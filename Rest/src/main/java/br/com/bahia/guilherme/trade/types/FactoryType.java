/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.types;

import br.com.bahia.guilherme.trade.annotations.product.AllProducts;
import br.com.bahia.guilherme.trade.annotations.product.SomeProducts;
import br.com.bahia.guilherme.trade.exceptions.UnexpectedException;
import br.com.bahia.guilherme.trade.to.TradeTO;
import java.lang.reflect.Field;
import org.apache.log4j.Logger;

/**
 * Simplify the work to load all data about a product from TradeTO.
 * @author Guilherme
 */
public final class FactoryType {

    private static final transient Logger LOG = Logger.getLogger(FactoryType.class);
    
    private FactoryType() {
    }

    /**
     * Use to get the product for this Trade.
     * @param <T> The product type.
     * @param tradeTO
     * @return 
     * @throws UnexpectedException 
     */
    public static <T extends Product> T extractProduct(TradeTO tradeTO) throws UnexpectedException {
        try {
            ProductType type = tradeTO.getType();
            T product = (T) type.getProduct().newInstance();
            reflectionTransform(tradeTO, type, product);
            return product;
        } catch (Exception e) {
            LOG.error("Unexpected error happened trying to extract tradeTO:[" + tradeTO + "]" , e);
            throw new UnexpectedException(e);
        }
    }

    /**
     * By Java reflection this will transfer the values from TradeTo to respective product instance.
     * @param <T>
     * @param tradeTO
     * @param type
     * @param product
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException 
     */
    private static <T extends Product> void reflectionTransform(TradeTO tradeTO, ProductType type, T product)
            throws SecurityException, IllegalAccessException, IllegalArgumentException {
        for (Field fieldTrade : tradeTO.getClass().getDeclaredFields()) {
            if (checkAnnotations(fieldTrade, type)) {
                for (Field fieldProduct : product.getClass().getDeclaredFields()) {
                    if (fieldTrade.getName().equals(fieldProduct.getName())) {
                        boolean accessProduct = fieldProduct.isAccessible();
                        boolean accessTrade = fieldTrade.isAccessible();
                        try {
                            fieldProduct.setAccessible(true);
                            fieldTrade.setAccessible(true);
                            fieldProduct.set(product, fieldTrade.get(tradeTO));
                            break;
                        } finally {
                            fieldProduct.setAccessible(accessProduct);
                            fieldTrade.setAccessible(accessTrade);
                        }
                    }
                }
            }
        }
    }

    private static boolean checkAnnotations(Field fieldTrade, ProductType type) {
        if (checkSomeAnnotation(fieldTrade, type)) {
            return true;
        }
        return fieldTrade.getAnnotation(AllProducts.class) != null
                || fieldTrade.getAnnotation(type.getAnnotation()) != null;
    }

     private static boolean checkSomeAnnotation(Field fieldTrade, ProductType type) {
         SomeProducts someProducts = fieldTrade.getAnnotation(SomeProducts.class);
         if (someProducts != null) {
             for (Class clazz : someProducts.products()) {
                 if (type.getAnnotation().equals(clazz)) {
                     return true;
                 }
             }
         }
         return false;
    }
}

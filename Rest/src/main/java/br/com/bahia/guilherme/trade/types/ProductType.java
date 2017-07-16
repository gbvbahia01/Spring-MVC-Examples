/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.types;

import br.com.bahia.guilherme.trade.annotations.product.Forward;
import br.com.bahia.guilherme.trade.annotations.product.FxSpot;
import br.com.bahia.guilherme.trade.annotations.product.Options;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 *
 * @author Guilherme
 */
public enum ProductType {
    FX_SPOT("spot", FxSpot.class, FxSpotProduct.class),
    FORWARD("forward", Forward.class, ForwardProduct.class),
    OPTIONS("Vanillaoption", Options.class, OptionsProduct.class);
    
    private String jsonCompare;
    private Class annotation;
    private Class product;
    
    private ProductType ( String jsonCompare, Class annotation, Class product) {
        this.jsonCompare = jsonCompare;
        this.annotation = annotation;
        this.product = product;
    }

    public Class getAnnotation() {
        return annotation;
    }

    public Class getProduct() {
        return product;
    }

    public String getJsonCompare() {
        return jsonCompare;
    }
    
    @JsonCreator
    public static ProductType fromString(String key) {
        for(ProductType type : ProductType.values()) {
            if(type.getJsonCompare().equalsIgnoreCase(key)) {
                return type;
            }
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.util;

import java.lang.reflect.Field;
import org.apache.log4j.Logger;

/**
 *
 * @author Guilherme
 */
public final class ReflectionHelper {
    
    private static final transient Logger LOG = Logger.getLogger(ReflectionHelper.class);
    
    private ReflectionHelper() { }
    
    public static <T> T getValueFrom(Object toGetValue, String fieldName) {
        try {
            Field  field = toGetValue.getClass().getDeclaredField(fieldName);
            boolean access = field.isAccessible();
            try{
                field.setAccessible(true);
                return (T) field.get(toGetValue);
            }finally {
                field.setAccessible(access);
            }
        } catch (NoSuchFieldException ex) {
            LOG.warn("No field with name:" + fieldName, ex);
        } catch (SecurityException ex) {
            LOG.error("Security problems for field: " + fieldName, ex);
        } catch (IllegalAccessException ex) {
            LOG.error("No access for field: " + fieldName, ex);
        }
        return null;
    }
}

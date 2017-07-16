/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.util;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author Guilherme
 */
public class SpringUtil  implements ApplicationContextAware {
    
    private final static transient Logger LOG = Logger.getLogger(SpringUtil.class);
    
    public static ApplicationContext context = null;
     
    public static <T> T getBean(Class beanClass) {
        return (T) context.getBean(beanClass);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LOG.debug("ApplicationContext setted");
        context = applicationContext;
    }
}

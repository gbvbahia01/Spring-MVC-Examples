/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.log4j.Logger;

/**
 *
 * @author Guilherme
 */
@WebListener
public class AppListener implements ServletContextListener {

    private final static transient Logger LOG = Logger.getLogger(AppListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.debug("Trade application started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.debug("Trade application finished");
    }
}

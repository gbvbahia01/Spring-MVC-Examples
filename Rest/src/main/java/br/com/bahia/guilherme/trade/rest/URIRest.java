/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.rest;

import org.apache.log4j.Logger;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * org.glassfish.jersey.server.spring.scope.RequestContextFilter, which is a Spring filter that
 * provides a bridge between JAX-RS and Spring request attributes<br>
 * br.com.gbvbahia.ecomerce.rest.unsecured.Searches, which is the service component that exposes the
 * REST API via annotations. <br>
 * org.glassfish.jersey.jackson.JacksonFeature, which is a feature that registers Jackson JSON
 * providers – you need it for the application to understand JSON data
 *
 * @author Guilherme
 */
public class URIRest extends ResourceConfig {

    private static final Logger LOG = Logger.getLogger(URIRest.class);

    public URIRest() {
        try {
            register(RequestContextFilter.class);
            register(TradeRest.class);
            register(JacksonFeature.class);
            LOG.info("Rest service loaded");
        } catch (Exception e) {
            LOG.error("Error trying loading rest service", e);
        }
    }
}

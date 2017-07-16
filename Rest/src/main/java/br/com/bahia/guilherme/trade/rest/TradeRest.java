/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.rest;

import br.com.bahia.guilherme.trade.to.TradeTO;
import br.com.bahia.guilherme.trade.to.ValidateResultTO;
import br.com.bahia.guilherme.trade.util.Metrics;
import br.com.bahia.guilherme.trade.validade.ValidateTrade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Guilherme
 */
@Controller
public class TradeRest {

    private final static transient Logger LOG = Logger.getLogger(TradeRest.class);
    
    private StopWatch watch;
    private Metrics metrics;
    
    @Autowired
    private ValidateTrade validateTrade;

    @PostConstruct
    private void init() {
        LOG.debug("Rest service is up");
        watch = new StopWatch();
        metrics = Metrics.getInstance();
    }

    @PreDestroy
    private void end() {
        LOG.debug("Rest service is down");
    }

    @RequestMapping(value = "/trade/validatebulk", method = RequestMethod.POST)
    public @ResponseBody
    List<ValidateResultTO> validateTrades(@RequestBody List<TradeTO> trades) {
        try {
            watch.start();
        return validateTrade.validate(trades);
        } finally {
            watch.stop();
            metrics.registry(watch.getTotalTimeSeconds(), watch.getLastTaskTimeMillis(),
                               trades.size());
            LOG.info(metrics);
        }
    }

    @RequestMapping(value = "/trade/validate", method = RequestMethod.GET)
    public @ResponseBody
    ValidateResultTO validateTrade(@RequestBody TradeTO trade) {
        return validateTrade.validate(trade);
    }
}

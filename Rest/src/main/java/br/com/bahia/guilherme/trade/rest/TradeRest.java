/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.rest;

import br.com.bahia.guilherme.trade.to.TradeTO;
import br.com.bahia.guilherme.trade.to.ValidateResultTO;
import br.com.bahia.guilherme.trade.validade.ValidateTrade;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    private ValidateTrade validateTrade;

    @PostConstruct
    private void init() {
        LOG.debug("Rest service is up");
    }

    @PreDestroy
    private void end() {
        LOG.debug("Rest service is down");
    }

    @RequestMapping(value = "/trade/validatecallable", method = RequestMethod.POST)
    public  @ResponseBody Callable<List<ValidateResultTO>> validateCallableTrade(@RequestBody List<TradeTO> trades) {
        Callable<List<ValidateResultTO>> result = () -> {
            return TradeRest.this.validateTrade.validate(trades);
        };
        return result;
    }

    @RequestMapping(value = "/trade/validatebulk", method = RequestMethod.POST)
    public @ResponseBody
    List<ValidateResultTO> validateTrades(@RequestBody List<TradeTO> trades) {
            return validateTrade.validate(trades);
    }

    @RequestMapping(value = "/trade/validate", method = RequestMethod.GET)
    public @ResponseBody
    ValidateResultTO validateTrade(@RequestBody TradeTO trade) {
        return validateTrade.validate(trade);
    }
}

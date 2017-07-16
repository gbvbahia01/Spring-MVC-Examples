/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.aop;

import br.com.bahia.guilherme.trade.rest.TradeRest;
import br.com.bahia.guilherme.trade.to.ValidateResultTO;
import br.com.bahia.guilherme.trade.util.Metrics;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 *
 * @author Guilherme
 */
@Component("metricsLoggerAspect")
@Aspect
public class AopMetrics {

    private final static transient Logger LOG = Logger.getLogger(AopMetrics.class);

    private StopWatch watch;
    private Metrics metrics;

    @PostConstruct
    private void init() {
        watch = new StopWatch();
        metrics = Metrics.getInstance();
    }

    @Around(value = "execution(* br.com.bahia.guilherme.trade.validade.ValidateTrade.validate(java.util.List))")
    public Object metricsAdvice(ProceedingJoinPoint jPoint) throws Throwable {
        List<ValidateResultTO> trades = null;
        try {
            watch.start();
            trades = (List<ValidateResultTO>) jPoint.proceed(jPoint.getArgs());
            watch.stop();
            return trades;
        } finally {
            if (trades != null) {
                metrics.registry(watch.getTotalTimeSeconds(), watch.getLastTaskTimeMillis(),
                        trades.size());
                LOG.info(metrics);
            }
        }
    }
}

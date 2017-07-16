/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.util;

import java.text.MessageFormat;

/**
 *
 * @author Guilherme
 */
public class Metrics {
    
    private Metrics() {}
    
    private static Metrics instance;
    
    public static synchronized Metrics getInstance() {
        if (instance == null) {
            instance = new Metrics();
        }
        return instance;
    }
    
    private double aveTime;
    private double minTime;
    private double maxTime;
    private double lastTime;
    private int totalRequest;

    public void registry(double totalTimeSeconds, long lastTaskTimeMillis, int linesProcessed) {
        totalRequest += linesProcessed;
        aveTime = totalTimeSeconds / totalRequest ;
        lastTime = lastTaskTimeMillis;
        if (minTime == 0 || minTime > lastTaskTimeMillis) {
            minTime = lastTaskTimeMillis;
        }
        if (maxTime == 0 || maxTime < lastTaskTimeMillis) {
            maxTime = lastTaskTimeMillis;
        }
    }

    @Override
    public String toString() {
        
        return MessageFormat.format("Metrics[Average: {0}, Min. task time: {1}, "
                + "Max. task time: {2}, Last task time: {3}, Total validations: {4}. "
                + "(all time in seconds, average per validation)]",
                aveTime, (minTime/1000.0), (maxTime/1000.0), (lastTime/1000.0), totalRequest);
    }
}

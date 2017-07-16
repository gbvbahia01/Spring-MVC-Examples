/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Guilherme
 */
public class DateTestProvider {
    
    private static String localeTimeZone = "Poland";
    
    public static SimpleDateFormat getDateFormater() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone(localeTimeZone));
        return sdf;
    }
    
    public static Date addTime(Date toAdd, int amount) {
        LocalDate localDate = toAdd.toInstant().atZone(ZoneId.of(localeTimeZone)).toLocalDate();
        localDate = localDate.plusDays(amount);
        Instant inst = Instant.from(localDate.atStartOfDay(ZoneId.of(localeTimeZone)));
        return Date.from(inst);
    }
}

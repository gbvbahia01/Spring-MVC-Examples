/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Guilherme
 */
public class DateUtil {
    
     private static String localeTimeZone = "Poland";
    
    public static LocalDate convertDateToLocalDate(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.of(localeTimeZone)).toLocalDate();
        return localDate;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.exceptions;

/**
 *
 * @author Guilherme
 */
public class TradeException extends Exception {

    public TradeException(String message) {
        super(message);
    }

    public TradeException(Throwable cause) {
        super(cause);
    }
    
    
}

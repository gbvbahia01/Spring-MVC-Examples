/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.types;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 *
 * @author Guilherme
 */
public enum StyleOption {
    AMERICAN, EUROPEAN;

    @JsonCreator
    public static StyleOption fromString(String key) {
        for (StyleOption type : StyleOption.values()) {
            if (type.name().equalsIgnoreCase(key)) {
                return type;
            }
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Guilherme
 */
public class ValidateResultTO implements Serializable {

    private String result = "No errors found.";
    private boolean errosFound;
    private int index = 1;
    private Set<String> errors = new TreeSet<>();
    private String tradeLineData = "";

    private void addErrors(Collection<String> erros) {
        errors.addAll(erros);
    }

    public void errorsWereFound(Collection<String> erros) {
        if (!erros.isEmpty()) {
            result = "Some errors were found.";
            addErrors(erros);
            errosFound = true;
        }
    }

    public void noDataReceived() {
        result = "A Empty JSON was sent. Nothing to respond.";
    }

    public String getResult() {
        return result;
    }

    public Set<String> getErrors() {
        return errors;
    }

    public String getTradeLineData() {
        return tradeLineData;
    }

    public void setTradeLineData(String tradeLineData) {
        this.tradeLineData = tradeLineData;
    }

    @JsonIgnore
    public boolean isErrosFound() {
        return errosFound;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "ValidadeResultTO{" + "result=" + result + ", tradeLineData=" + tradeLineData + ", errors=" + errors + '}';
    }

    public String toStringWeb() {
        StringBuilder builder = new StringBuilder();
        builder.append("Result: ").append(result);
        if (isErrosFound()) {
            builder.append("<br />");
            for (String error : errors) {
                builder.append(error);
                builder.append("<br />");
            }
        }

        return builder.toString();
    }

}

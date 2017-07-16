/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.types;

import br.com.bahia.guilherme.trade.annotations.validation.CounterpartySupported;
import br.com.bahia.guilherme.trade.annotations.validation.CurrenciesISO4217;
import br.com.bahia.guilherme.trade.annotations.validation.LegalEntity;
import br.com.bahia.guilherme.trade.annotations.validation.ValueDateNonWorkingDay;
import br.com.bahia.guilherme.trade.annotations.validation.ValueDateTradeDate;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Guilherme
 */
@ValueDateTradeDate()
public class FxSpotProduct implements Product {

    @NotNull
    @CounterpartySupported
    private String customer;

    @NotNull
    @CurrenciesISO4217
    private String ccyPair;

    @NotNull
    private ProductType type;

    @NotNull
    private String direction;

    @NotNull
    @LegalEntity
    private String legalEntity;

    @NotNull
    private String trader;

    @NotNull
    private BigDecimal amount1;

    @NotNull
    private BigDecimal amount2;

    @NotNull
    private BigDecimal rate;

    @NotNull
    private Date tradeDate;

    @NotNull
    @ValueDateNonWorkingDay
    private Date valueDate;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCcyPair() {
        return ccyPair;
    }

    public void setCcyPair(String ccyPair) {
        this.ccyPair = ccyPair;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public BigDecimal getAmount1() {
        return amount1;
    }

    public void setAmount1(BigDecimal amount1) {
        this.amount1 = amount1;
    }

    public BigDecimal getAmount2() {
        return amount2;
    }

    public void setAmount2(BigDecimal amount2) {
        this.amount2 = amount2;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    @Override
    public String toString() {
        return "FxSpotProduct{" + "customer=" + customer + ", ccyPair=" + ccyPair + ", "
                + "type=" + type + ", direction=" + direction + ", legalEntity=" + legalEntity + ","
                + " trader=" + trader + ", amount1=" + amount1 + ", amount2=" + amount2 + ","
                + " rate=" + rate + ", tradeDate=" + tradeDate + ", valueDate=" + valueDate + '}';
    }
    
    
}

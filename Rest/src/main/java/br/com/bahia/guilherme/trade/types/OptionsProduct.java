/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.types;

import br.com.bahia.guilherme.trade.annotations.validation.AmericanExerciseDate;
import br.com.bahia.guilherme.trade.annotations.validation.CounterpartySupported;
import br.com.bahia.guilherme.trade.annotations.validation.CurrenciesISO4217;
import br.com.bahia.guilherme.trade.annotations.validation.ExpiryPremiumBeforeDeliveryDate;
import br.com.bahia.guilherme.trade.annotations.validation.LegalEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Guilherme
 */
@AmericanExerciseDate(exerciseDateFieldName = "excerciseDate", styleFieldName = "style", 
        expiryDateFieldName = "expiryDate", tradeDateFieldName = "tradeDate")
@ExpiryPremiumBeforeDeliveryDate(deliveryDateFieldName = "deliveryDate",
        expiryDateFieldName = "expiryDate", premiumDateFieldName = "premiumDate")
public class OptionsProduct implements Product {

    @NotNull
    @CounterpartySupported
    private String customer;

    @NotNull
    @CurrenciesISO4217
    private String ccyPair;

    @NotNull
    private ProductType type;

    @NotNull
    private StyleOption style;

    @NotNull
    private String direction;

    @NotNull
    private String strategy;

    @NotNull
    private String payCcy;

    @NotNull
    private String premiumCcy;

    @NotNull
    private String premiumType;

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
    private BigDecimal premium;

    @NotNull
    private Date tradeDate;

    @NotNull
    private Date expiryDate;

    @NotNull
    private Date deliveryDate;

    @NotNull
    private Date premiumDate;
    
    private Date excerciseDate;

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

    public StyleOption getStyle() {
        return style;
    }

    public void setStyle(StyleOption style) {
        this.style = style;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getPayCcy() {
        return payCcy;
    }

    public void setPayCcy(String payCcy) {
        this.payCcy = payCcy;
    }

    public String getPremiumCcy() {
        return premiumCcy;
    }

    public void setPremiumCcy(String premiumCcy) {
        this.premiumCcy = premiumCcy;
    }

    public String getPremiumType() {
        return premiumType;
    }

    public void setPremiumType(String premiumType) {
        this.premiumType = premiumType;
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

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getPremiumDate() {
        return premiumDate;
    }

    public void setPremiumDate(Date premiumDate) {
        this.premiumDate = premiumDate;
    }

    public Date getExcerciseDate() {
        return excerciseDate;
    }

    public void setExcerciseDate(Date excerciseDate) {
        this.excerciseDate = excerciseDate;
    }

    @Override
    public String toString() {
        return "OptionsProduct{" + "customer=" + customer + ", ccyPair=" + ccyPair + ", "
                + "type=" + type + ", style=" + style + ", direction=" + direction + ", "
                + "strategy=" + strategy + ", payCcy=" + payCcy + ", premiumCcy=" + premiumCcy + ", "
                + "premiumType=" + premiumType + ", legalEntity=" + legalEntity + ", "
                + "trader=" + trader + ", amount1=" + amount1 + ", amount2=" + amount2 + ", "
                + "rate=" + rate + ", premium=" + premium + ", tradeDate=" + tradeDate + ", "
                + "expiryDate=" + expiryDate + ", deliveryDate=" + deliveryDate + ", "
                + "premiumDate=" + premiumDate + ", excerciseDate=" + excerciseDate + '}';
    }



}

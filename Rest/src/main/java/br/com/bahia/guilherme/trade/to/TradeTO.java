/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.to;

import br.com.bahia.guilherme.trade.annotations.product.AllProducts;
import br.com.bahia.guilherme.trade.annotations.product.Forward;
import br.com.bahia.guilherme.trade.annotations.product.FxSpot;
import br.com.bahia.guilherme.trade.annotations.product.Options;
import br.com.bahia.guilherme.trade.annotations.product.SomeProducts;
import br.com.bahia.guilherme.trade.types.ProductType;
import br.com.bahia.guilherme.trade.types.StyleOption;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
/**
 * This class represents a trade row in the trade json array.
 *
 * @author Guilherme
 */
public class TradeTO implements Serializable {

    @AllProducts
    private String customer;

    @AllProducts
    private String ccyPair;

    @AllProducts
    private ProductType type;

    @Options
    private StyleOption style;

    @AllProducts
    private String direction;

    @Options
    private String strategy;

    @Options
    private String payCcy;

    @Options
    private String premiumCcy;

    @Options
    private String premiumType;

    @AllProducts
    private String legalEntity;

    @AllProducts
    private String trader;

    @AllProducts
    private BigDecimal amount1;

    @AllProducts
    private BigDecimal amount2;

    @AllProducts
    private BigDecimal rate;

    @Options
    private BigDecimal premium;

    @AllProducts
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Poland")
    @JsonSerialize(using=DateSerializer.class)
    private Date tradeDate;

    @Options
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Poland")
    @JsonSerialize(using=DateSerializer.class)
    private Date expiryDate;

    @Options
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Poland")
    @JsonSerialize(using=DateSerializer.class)
    private Date deliveryDate;

    @Options
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Poland")
    @JsonSerialize(using=DateSerializer.class)
    private Date premiumDate;

    @SomeProducts(products = {Forward.class, FxSpot.class})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Poland")
    @JsonSerialize(using=DateSerializer.class)
    private Date valueDate;

    @Options
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Poland")
    @JsonSerialize(using=DateSerializer.class)
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

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
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

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPayCcy() {
        return payCcy;
    }

    public void setPayCcy(String payCcy) {
        this.payCcy = payCcy;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
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

    public Date getPremiumDate() {
        return premiumDate;
    }

    public void setPremiumDate(Date premiumDate) {
        this.premiumDate = premiumDate;
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

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public Date getExcerciseDate() {
        return excerciseDate;
    }

    public void setExcerciseDate(Date excerciseDate) {
        this.excerciseDate = excerciseDate;
    }

    @Override
    public String toString() {
        return "TradeTO{" + "customer=" + customer + ", ccyPair=" + ccyPair + ", "
                + "type=" + type + ", style=" + style + ", direction=" + direction + ", "
                + "strategy=" + strategy + ", payCcy=" + payCcy + ", premiumCcy=" + premiumCcy + ", "
                + "premiumType=" + premiumType + ", legalEntity=" + legalEntity + ", "
                + "trader=" + trader + ", amount1=" + amount1 + ", amount2=" + amount2 + ", "
                + "rate=" + rate + ", premium=" + premium + ", tradeDate=" + tradeDate + ", "
                + "expiryDate=" + expiryDate + ", deliveryDate=" + deliveryDate + ", "
                + "premiumDate=" + premiumDate + ", valueDate=" + valueDate + ", "
                + "excerciseDate=" + excerciseDate + '}';
    }



}

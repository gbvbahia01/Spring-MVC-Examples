/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.types;

import br.com.bahia.guilherme.trade.exceptions.TypeUndefinedException;
import br.com.bahia.guilherme.trade.exceptions.UnexpectedException;
import br.com.bahia.guilherme.trade.to.TradeTO;
import br.com.bahia.guilherme.trade.util.DataTestShared;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import static br.com.bahia.guilherme.trade.util.DateTestProvider.*;

/**
 *
 * @author Guilherme
 */
public class FactoryTypeTest {
    
        private ObjectMapper objectMapper = null;

    @Before
    public void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testeFactorySpot() throws Exception {
        TradeTO trade = objectMapper.readValue(DataTestShared.TYPE_SPOT, TradeTO.class);
        
        FxSpotProduct spot= FactoryType.extractProduct(trade);
        
        ProductType typeExpected = ProductType.FX_SPOT;
        Assert.assertEquals(typeExpected, spot.getType());

        String customerExpected = "JUPITER1";
        Assert.assertEquals(spot.getCustomer(), customerExpected);

        Calendar tradeDateExpected = Calendar.getInstance();
        tradeDateExpected.setTime(getDateFormater().parse("2016-08-11"));
        Assert.assertEquals(tradeDateExpected.getTime(), spot.getTradeDate());

        BigDecimal amount1Expected = new BigDecimal("1000000.00");
        Assert.assertEquals(amount1Expected, spot.getAmount1());

        BigDecimal amount2Expected = new BigDecimal("1120000.01");
        Assert.assertEquals(amount2Expected, spot.getAmount2());

        BigDecimal rateExpected = new BigDecimal("1.17");
        Assert.assertEquals(rateExpected, spot.getRate());

        Calendar valueDateExpected = Calendar.getInstance();
        valueDateExpected.setTime(getDateFormater().parse("2016-08-15"));
        Assert.assertEquals(valueDateExpected.getTime(), spot.getValueDate());
        
    }

    @Test
    public void testeFactoryOption() throws Exception {
        TradeTO trade = objectMapper.readValue(DataTestShared.TYPE_OPTION, TradeTO.class);
        
        OptionsProduct option = FactoryType.extractProduct(trade);
        
        String customerExpected = "JUPITER1";
        Assert.assertEquals(customerExpected, option.getCustomer());

        ProductType typeExpected = ProductType.OPTIONS;
        Assert.assertEquals(typeExpected, option.getType());

        String traderExpected = "Johann Baumfiddler";
        Assert.assertEquals(traderExpected, option.getTrader());

        Calendar tradeDateExpected = Calendar.getInstance();
        tradeDateExpected.setTime(getDateFormater().parse("2016-08-11"));
        Assert.assertEquals(tradeDateExpected.getTime(), option.getTradeDate());

        BigDecimal amount1Expected = new BigDecimal("1000000.00");
        Assert.assertEquals(amount1Expected, option.getAmount1());

        BigDecimal amount2Expected = new BigDecimal("1120000.01");
        Assert.assertEquals(amount2Expected, option.getAmount2());

        BigDecimal rateExpected = new BigDecimal("1.17");
        Assert.assertEquals(rateExpected, option.getRate());

        Calendar deliveryDateExpected = Calendar.getInstance();
        deliveryDateExpected.setTime(getDateFormater().parse("2016-08-22"));
        Assert.assertEquals(deliveryDateExpected.getTime(), option.getDeliveryDate());
        
        StyleOption styleExpected = StyleOption.EUROPEAN;
        Assert.assertEquals(styleExpected, option.getStyle());
    }
    
}

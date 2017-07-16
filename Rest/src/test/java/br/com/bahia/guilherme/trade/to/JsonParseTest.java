/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.to;

import br.com.bahia.guilherme.trade.types.ProductType;
import br.com.bahia.guilherme.trade.types.StyleOption;
import br.com.bahia.guilherme.trade.util.DataTestShared;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static br.com.bahia.guilherme.trade.util.DateTestProvider.*;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class JsonParseTest {

    private ObjectMapper objectMapper = null;

    @Before
    public void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testeParseSpot() throws Exception {
        TradeTO tSpot = objectMapper.readValue(DataTestShared.TYPE_SPOT, TradeTO.class);

        ProductType typeExpected = ProductType.FX_SPOT;
        Assert.assertEquals(typeExpected, tSpot.getType());

        String customerExpected = "JUPITER1";
        Assert.assertEquals(customerExpected, tSpot.getCustomer());

        Calendar tradeDateExpected = Calendar.getInstance();
        tradeDateExpected.setTime(getDateFormater().parse("2016-08-11"));
        Assert.assertEquals(tradeDateExpected.getTime(), tSpot.getTradeDate());

        BigDecimal amount1Expected = new BigDecimal("1000000.00");
        Assert.assertEquals(amount1Expected, tSpot.getAmount1());

        BigDecimal amount2Expected = new BigDecimal("1120000.01");
        Assert.assertEquals(amount2Expected, tSpot.getAmount2());

        BigDecimal rateExpected = new BigDecimal("1.17");
        Assert.assertEquals(rateExpected, tSpot.getRate());

        Calendar valueDateExpected = Calendar.getInstance();
        valueDateExpected.setTime(getDateFormater().parse("2016-08-15"));
        Assert.assertEquals(valueDateExpected.getTime(), tSpot.getValueDate());
    }

    @Test
    public void testeParseOption() throws Exception {
        TradeTO tOption = objectMapper.readValue(DataTestShared.TYPE_OPTION, TradeTO.class);

        String customerExpected = "JUPITER1";
        Assert.assertEquals(customerExpected, tOption.getCustomer());

        ProductType typeExpected = ProductType.OPTIONS;
        Assert.assertEquals(typeExpected, tOption.getType());

        String traderExpected = "Johann Baumfiddler";
        Assert.assertEquals(traderExpected, tOption.getTrader());

        Calendar tradeDateExpected = Calendar.getInstance();
        tradeDateExpected.setTime(getDateFormater().parse("2016-08-11"));
        Assert.assertEquals(tradeDateExpected.getTime(), tOption.getTradeDate());

        BigDecimal amount1Expected = new BigDecimal("1000000.00");
        Assert.assertEquals(amount1Expected, tOption.getAmount1());

        BigDecimal amount2Expected = new BigDecimal("1120000.01");
        Assert.assertEquals(amount2Expected, tOption.getAmount2());

        BigDecimal rateExpected = new BigDecimal("1.17");
        Assert.assertEquals(rateExpected, tOption.getRate());

        Calendar deliveryDateExpected = Calendar.getInstance();
        deliveryDateExpected.setTime(getDateFormater().parse("2016-08-22"));
        Assert.assertEquals(deliveryDateExpected.getTime(), tOption.getDeliveryDate());
    }

    @Test
    public void testeParseForward() throws Exception {
        TradeTO tForward = objectMapper.readValue(DataTestShared.TYPE_FORWARD, TradeTO.class);

        String customerExpected = "JUPITER2";
        Assert.assertEquals(customerExpected, tForward.getCustomer());

        ProductType typeExpected = ProductType.FORWARD;
        Assert.assertEquals(typeExpected, tForward.getType());

        String traderExpected = "Johann Baumfiddler";
        Assert.assertEquals(traderExpected, tForward.getTrader());

        Calendar tradeDateExpected = Calendar.getInstance();
        tradeDateExpected.setTime(getDateFormater().parse("2016-08-11"));
        Assert.assertEquals(tradeDateExpected.getTime(), tForward.getTradeDate());

        BigDecimal amount1Expected = new BigDecimal("1000000.00");
        Assert.assertEquals(amount1Expected, tForward.getAmount1());

        BigDecimal amount2Expected = new BigDecimal("1120909.99");
        Assert.assertEquals(amount2Expected, tForward.getAmount2());

        BigDecimal rateExpected = new BigDecimal("1.17");
        Assert.assertEquals(rateExpected, tForward.getRate());

        Calendar valueDateExpected = Calendar.getInstance();
        valueDateExpected.setTime(getDateFormater().parse("2016-08-22"));
        Assert.assertEquals(valueDateExpected.getTime(), tForward.getValueDate());
    }
    
    @Test
    public void testArrayTrade() throws Exception {
        List<TradeTO> trades = objectMapper.readValue(DataTestShared.TEST_DATA, List.class);
        Integer sizeExpected = 15;
        Assert.assertEquals(sizeExpected, Integer.valueOf(trades.size()));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.validade;

import br.com.bahia.guilherme.trade.to.TradeTO;
import br.com.bahia.guilherme.trade.to.ValidateResultTO;
import br.com.bahia.guilherme.trade.util.DataTestShared;
import br.com.bahia.guilherme.trade.util.DateTestProvider;
import br.com.bahia.guilherme.trade.util.SpringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collection;
import javax.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Guilherme
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml"})
@Transactional
public class ValidateTradeTest {

    @Autowired
    private ApplicationContext context;

    private ObjectMapper objectMapper = null;
    private ValidateTrade validator = null;

    public ValidateTradeTest() {
    }

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        validator = new ValidateTrade();
        SpringUtil.context = context;
    }

    /**
     * Test of validate method, of class ValidadeTrade.
     */
    @Test
    public void testValidate_List() {
    }

    /**
     * Test of validate method, of class ValidadeTrade.
     */
    @Test
    public void testValidate_TradeTO() throws Exception {
        String resultExpected = "No errors found.";
        TradeTO tSpot = objectMapper.readValue(DataTestShared.TYPE_SPOT, TradeTO.class);
        String tradeDataExpected = tSpot.toString();
        ValidateResultTO result = validator.validate(tSpot);
        assertTrue(result.getErrors().isEmpty());
        assertEquals(resultExpected, result.getResult());
        assertEquals(tradeDataExpected, result.getTradeLineData());
    }

    @Test
    public void testValidate_ValueDateTradeDate() throws Exception {
        String resultExpected = "Some errors were found.";
        String msgErrorExpectedIn = "value date cannot be before trade date";
        TradeTO tSpot = objectMapper.readValue(DataTestShared.TYPE_SPOT, TradeTO.class);
        tSpot.setTradeDate(DateTestProvider.addTime(tSpot.getTradeDate(), 10));
        String tradeDataExpected = tSpot.toString();

        check(tSpot, resultExpected, tradeDataExpected, msgErrorExpectedIn);
    }

    @Test
    public void testValidate_ValueDateNonWorkingDay() throws Exception {
        String resultExpected = "Some errors were found.";
        String msgErrorExpectedIn = "value date cannot be non working day";
        TradeTO tForward = objectMapper.readValue(DataTestShared.TYPE_FORWARD, TradeTO.class);
        tForward.setValueDate(DateTestProvider.addTime(tForward.getValueDate(), 6));
        String tradeDataExpected = tForward.toString();

        check(tForward, resultExpected, tradeDataExpected, msgErrorExpectedIn);
    }

    @Test
    public void testValidate_ExpiryPremiumBeforeDeliveryDate() throws Exception {
        String resultExpected = "Some errors were found.";
        String msgErrorExpectedIn = "expiry date and premium date must be before delivery date";
        TradeTO tOption = objectMapper.readValue(DataTestShared.TYPE_OPTION, TradeTO.class);
        tOption.setDeliveryDate(DateTestProvider.addTime(tOption.getDeliveryDate(), -30));
        String tradeDataExpected = tOption.toString();

        check(tOption, resultExpected, tradeDataExpected, msgErrorExpectedIn);
    }

    @Test
    public void testValidate_CurrenciesISO4217() throws Exception {
        String resultExpected = "Some errors were found.";
        String msgErrorExpectedIn = "Currency not supported";
        TradeTO tOption = objectMapper.readValue(DataTestShared.TYPE_OPTION, TradeTO.class);
        tOption.setCcyPair("ZZZUSD");
        String tradeDataExpected = tOption.toString();

        check(tOption, resultExpected, tradeDataExpected, msgErrorExpectedIn);
    }

    @Test
    public void testValidate_CounterpartySupported() throws Exception {
        String resultExpected = "Some errors were found.";
        String msgErrorExpectedIn = "Counterparty not supported";
        TradeTO tForward = objectMapper.readValue(DataTestShared.TYPE_FORWARD, TradeTO.class);
        tForward.setCustomer("UNKNOW");
        String tradeDataExpected = tForward.toString();

        check(tForward, resultExpected, tradeDataExpected, msgErrorExpectedIn);
    }

    @Test
    public void testValidate_AmericanExerciseDate() throws Exception {
        String resultExpected = "Some errors were found.";
        String msgErrorExpectedIn = "American exercise date is invalid";
        TradeTO tOption = objectMapper.readValue(DataTestShared.TYPE_OPTION_AMERICAN, TradeTO.class);
        String tradeDataExpected = tOption.toString();
        
        check(tOption, resultExpected, tradeDataExpected, msgErrorExpectedIn);
    }
    
    @Test
    public void testValidade_LegalEntity() throws Exception {
        String resultExpected = "Some errors were found.";
        String msgErrorExpectedIn = "Legal entity invalid";
        TradeTO tSpot = objectMapper.readValue(DataTestShared.TYPE_SPOT, TradeTO.class);
        tSpot.setLegalEntity("UNKNOW");
        String tradeDataExpected = tSpot.toString();

        check(tSpot, resultExpected, tradeDataExpected, msgErrorExpectedIn);
    }

    private void check(TradeTO tForward, String resultExpected, String tradeDataExpected, String msgErrorExpectedIn) {
        ValidateResultTO result = validator.validate(tForward);
        
        assertFalse(result.getErrors().isEmpty());
        assertEquals(resultExpected, result.getResult());
        assertEquals(tradeDataExpected, result.getTradeLineData());
        if (!searchError(msgErrorExpectedIn, result.getErrors())) {
            fail("Not found: " + msgErrorExpectedIn);
        }
    }

    private boolean searchError(String error, Collection<String> erros) {
        for (String er : erros) {
            if (er.contains(error)) {
                return true;
            }
        }
        return false;
    }
}

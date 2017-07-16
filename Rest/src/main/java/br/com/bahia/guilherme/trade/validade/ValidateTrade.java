/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.validade;

import br.com.bahia.guilherme.trade.exceptions.TypeUndefinedException;
import br.com.bahia.guilherme.trade.exceptions.UnexpectedException;
import br.com.bahia.guilherme.trade.to.TradeTO;
import br.com.bahia.guilherme.trade.to.ValidateResultTO;
import br.com.bahia.guilherme.trade.types.FactoryType;
import br.com.bahia.guilherme.trade.types.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guilherme
 */
@Service
public class ValidateTrade {

    private static final transient Logger LOG = Logger.getLogger(ValidateTrade.class);
    private ValidateJSR303 jsr303Validator = new ValidateJSR303();
    
    public List<ValidateResultTO> validate(List<TradeTO> tradesTO) {
        List<ValidateResultTO> results = new ArrayList<>();
        if (tradesTO == null) {
            TradeTO noResult = null;
            results.add(validate(noResult));
            return results;
        }
        
        int index = 1;
        for (TradeTO tradeTO : tradesTO) {
            ValidateResultTO result = validate(tradeTO);
            result.setIndex(index++);
            if (result.isErrosFound()) {
                results.add(result);
            }
        } 
        if (results.isEmpty()) {
            results.add(new ValidateResultTO());
        }
        return results;
    }
    
    public ValidateResultTO validate(TradeTO tradeTO) {
        ValidateResultTO result = new ValidateResultTO();
        if (tradeTO == null) {
            result.noDataReceived();
            return result;
        }
        result.setTradeLineData(tradeTO.toString());
        try {
            typeValidade(tradeTO);
            Product product = FactoryType.extractProduct(tradeTO);
            jsr303Validator.validate(product, result);
        }catch (TypeUndefinedException ex) {
            LOG.error("A invalid type was informed at:[" + tradeTO + "]");
            result.errorsWereFound(Collections.singletonList("Type of trade invalid"));
        } catch (UnexpectedException ex) {
            //Log about this was wrote in FactoryType
            result.errorsWereFound(Collections.singletonList("Unexpected Error occurred. See log to find more details about."));
        }
        return result;
    }

    private static void typeValidade(TradeTO tradeTO) throws TypeUndefinedException {
        if (tradeTO.getType() == null) {
            throw new TypeUndefinedException("Type o trade must be informed");
        }
    }
}

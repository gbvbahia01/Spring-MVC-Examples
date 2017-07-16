/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.validade.smalltask;

import br.com.bahia.guilherme.trade.annotations.validation.ValueDateTradeDate;
import br.com.bahia.guilherme.trade.util.ReflectionHelper;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The following basic validation rules shall be implemented:
 *
 * 1. value date cannot be before trade date
 *
 * @author Guilherme
 */
public class ValueDateTradeDateValidator implements ConstraintValidator<ValueDateTradeDate, Object> {

    private String valueDateField;
    private String tradeDateField;

    @Override
    public void initialize(ValueDateTradeDate constraintAnnotation) {
        valueDateField = constraintAnnotation.valueDate();
        tradeDateField = constraintAnnotation.tradeDate();
    }

    @Override
    public boolean isValid(Object product, ConstraintValidatorContext context) {
        Date valueDate = ReflectionHelper.getValueFrom(product, valueDateField);
        Date tradeDate = ReflectionHelper.getValueFrom(product, tradeDateField);
        if (valueDate == null || tradeDate == null) {
            //for null @NotNull is used.
            return true;
        }
        return !valueDate.before(tradeDate);
    }

}

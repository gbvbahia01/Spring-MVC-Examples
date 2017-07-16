/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.validade.smalltask;

import br.com.bahia.guilherme.trade.annotations.validation.CurrenciesISO4217;
import br.com.bahia.guilherme.trade.repositories.ISO4217Repository;
import br.com.bahia.guilherme.trade.util.SpringUtil;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Guilherme
 */
public class CurrenciesISO4217Validator implements ConstraintValidator<CurrenciesISO4217, String> {

    private CurrenciesISO4217 constraint;
    private ISO4217Repository repository;
    
    @Override
    public void initialize(CurrenciesISO4217 constraintAnnotation) {
        constraint = constraintAnnotation;
        repository = SpringUtil.getBean(ISO4217Repository.class);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        String from = StringUtils.substring(value, 0, 3);
        String to = StringUtils.substring(value, 3);
        if (StringUtils.isBlank(from) || StringUtils.isBlank(to)) {
            return false;
        }
        
        return repository.amountByCodes(to, from) == 2;
    }
    
}

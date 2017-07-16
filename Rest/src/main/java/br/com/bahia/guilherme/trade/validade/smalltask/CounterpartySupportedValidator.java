/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.validade.smalltask;

import br.com.bahia.guilherme.trade.annotations.validation.CounterpartySupported;
import br.com.bahia.guilherme.trade.model.Counterparty;
import br.com.bahia.guilherme.trade.repositories.CounterpartyRepository;
import br.com.bahia.guilherme.trade.util.SpringUtil;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Guilherme
 */
public class CounterpartySupportedValidator implements ConstraintValidator<CounterpartySupported, String> {

    private CounterpartySupported constraint;
    private CounterpartyRepository repository;
    
    @Override
    public void initialize(CounterpartySupported constraintAnnotation) {
        repository = SpringUtil.getBean(CounterpartyRepository.class);
        constraint = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        Counterparty counterparty = repository.findOne(value);
        return counterparty != null;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.annotations.validation;

import br.com.bahia.guilherme.trade.validade.smalltask.CurrenciesISO4217Validator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Guilherme
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CurrenciesISO4217Validator.class)
public @interface CurrenciesISO4217 {

    String message() default "{currency.not.supported}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

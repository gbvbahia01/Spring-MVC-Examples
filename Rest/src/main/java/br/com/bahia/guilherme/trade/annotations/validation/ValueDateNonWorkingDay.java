/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.annotations.validation;

import br.com.bahia.guilherme.trade.validade.smalltask.ValueDateNonWorkingDayValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * The following basic validation rules shall be implemented:
 * 
 * 2. value date cannot fall on weekend or non-working day for currency.
 * 
 * @author Guilherme
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValueDateNonWorkingDayValidator.class)
public @interface ValueDateNonWorkingDay {

    String message() default "{value.date.cannot.be.non.working.day}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

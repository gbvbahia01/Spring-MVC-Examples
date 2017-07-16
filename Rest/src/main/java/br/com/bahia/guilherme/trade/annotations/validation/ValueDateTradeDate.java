/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.annotations.validation;

import br.com.bahia.guilherme.trade.validade.smalltask.ValueDateTradeDateValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * The following basic validation rules shall be implemented:
 *
 * 1. value date cannot be before trade date
 *
 * @author Guilherme
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValueDateTradeDateValidator.class)
public @interface ValueDateTradeDate {

    String message() default "{value.date.cannot.be.before.trade.date}";

    String valueDate() default "valueDate";

    String tradeDate() default "tradeDate";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

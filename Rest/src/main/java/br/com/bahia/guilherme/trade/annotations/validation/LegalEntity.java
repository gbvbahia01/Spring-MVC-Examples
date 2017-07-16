/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.annotations.validation;

import br.com.bahia.guilherme.trade.validade.smalltask.LegalEntityValidator;
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
@Constraint(validatedBy = LegalEntityValidator.class)
public @interface LegalEntity {
        String message() default "{legal.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

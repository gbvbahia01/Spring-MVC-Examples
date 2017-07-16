/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.annotations.validation;

import br.com.bahia.guilherme.trade.validade.smalltask.AmericanExerciseDateValidator;
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
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AmericanExerciseDateValidator.class)
public @interface AmericanExerciseDate {

    String message() default "{american.exercise.date.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String styleFieldName();

    String exerciseDateFieldName();

    String tradeDateFieldName();

    String expiryDateFieldName();
}

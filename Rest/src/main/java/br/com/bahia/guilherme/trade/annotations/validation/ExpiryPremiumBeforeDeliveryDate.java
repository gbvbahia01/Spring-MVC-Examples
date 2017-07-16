/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.annotations.validation;

import br.com.bahia.guilherme.trade.validade.smalltask.ExpiryPremiumBeforeDeliveryDateValidator;
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
@Constraint(validatedBy = ExpiryPremiumBeforeDeliveryDateValidator.class)
public @interface ExpiryPremiumBeforeDeliveryDate {

    String message() default "{expiry.date.premium.date.before.delivery.date}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String premiumDateFieldName();

    String deliveryDateFieldName();

    String expiryDateFieldName();
}

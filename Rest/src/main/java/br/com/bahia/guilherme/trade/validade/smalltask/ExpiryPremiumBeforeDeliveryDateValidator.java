/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.validade.smalltask;

import br.com.bahia.guilherme.trade.annotations.validation.ExpiryPremiumBeforeDeliveryDate;
import br.com.bahia.guilherme.trade.util.ReflectionHelper;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Guilherme
 */
public class ExpiryPremiumBeforeDeliveryDateValidator implements ConstraintValidator<ExpiryPremiumBeforeDeliveryDate, Object> {

    private String expiryFieldName;
    private String premiumDateFieldName;
    private String deliveryDateFieldName;

    @Override
    public void initialize(ExpiryPremiumBeforeDeliveryDate constraintAnnotation) {
        expiryFieldName = constraintAnnotation.expiryDateFieldName();
        premiumDateFieldName = constraintAnnotation.premiumDateFieldName();
        deliveryDateFieldName = constraintAnnotation.deliveryDateFieldName();
    }

    @Override
    public boolean isValid(Object product, ConstraintValidatorContext context) {
        Date expiry = ReflectionHelper.getValueFrom(product, expiryFieldName);
        Date premium = ReflectionHelper.getValueFrom(product, premiumDateFieldName);
        Date delivery = ReflectionHelper.getValueFrom(product, deliveryDateFieldName);
        
        if (expiry == null || premium == null || delivery == null) {
            return true;
        }
        
        return expiry.before(delivery) && premium.before(delivery);
    }

}

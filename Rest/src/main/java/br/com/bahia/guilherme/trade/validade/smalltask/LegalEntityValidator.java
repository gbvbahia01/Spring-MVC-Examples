    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.validade.smalltask;

import br.com.bahia.guilherme.trade.annotations.validation.LegalEntity;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Guilherme
 */
public class LegalEntityValidator implements ConstraintValidator<LegalEntity, String> {

    private LegalEntity legalEntity;
    private String validLegalEntity = "CS London";
    
    @Override
    public void initialize(LegalEntity constraintAnnotation) {
        legalEntity = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return validLegalEntity.equalsIgnoreCase(value);
    }
    
}

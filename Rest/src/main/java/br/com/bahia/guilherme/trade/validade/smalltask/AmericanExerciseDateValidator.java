/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.validade.smalltask;

import br.com.bahia.guilherme.trade.annotations.validation.AmericanExerciseDate;
import br.com.bahia.guilherme.trade.types.StyleOption;
import br.com.bahia.guilherme.trade.util.ReflectionHelper;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Guilherme
 */
public class AmericanExerciseDateValidator implements ConstraintValidator<AmericanExerciseDate, Object> {

    private String styleFieldName;
    private String exerciseDateFieldName;
    private String expiryDateFieldName;
    private String tradeDateFieldName;

    @Override
    public void initialize(AmericanExerciseDate constraintAnnotation) {
        styleFieldName = constraintAnnotation.styleFieldName();
        exerciseDateFieldName = constraintAnnotation.exerciseDateFieldName();
        expiryDateFieldName = constraintAnnotation.expiryDateFieldName();
        tradeDateFieldName = constraintAnnotation.tradeDateFieldName();         
    }

    @Override
    public boolean isValid(Object product, ConstraintValidatorContext context) {
        StyleOption style = ReflectionHelper.getValueFrom(product, styleFieldName);
        if (style == null || !StyleOption.AMERICAN.equals(style)) {
            return true;
        }

        Date exerciseDate = ReflectionHelper.getValueFrom(product, exerciseDateFieldName);
        if (exerciseDate == null) {
            return false;
        }

        Date expiryDate = ReflectionHelper.getValueFrom(product, expiryDateFieldName);
        Date tradeDate = ReflectionHelper.getValueFrom(product, tradeDateFieldName);
        
        if (expiryDate == null || tradeDate == null) {
            return true;
        }

        return exerciseDate.after(tradeDate) && exerciseDate.before(expiryDate);
    }

}

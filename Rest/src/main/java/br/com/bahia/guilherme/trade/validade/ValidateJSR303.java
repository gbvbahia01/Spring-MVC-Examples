/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.validade;

import br.com.bahia.guilherme.trade.exceptions.TypeUndefinedException;
import br.com.bahia.guilherme.trade.to.ValidateResultTO;
import br.com.bahia.guilherme.trade.types.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Guilherme
 */
public class ValidateJSR303 {

    protected void validate(Product product, ValidateResultTO result) throws TypeUndefinedException {
        List<String> errorsFields = validate(product);
        if (!errorsFields.isEmpty()) {
            result.errorsWereFound(errorsFields);
        }
    }

    private List<String> validate(Product product) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> msgs
                = validator.validate(product);
        if (!msgs.isEmpty()) {
            return createMsg(msgs);
        }
        return new ArrayList<>();
    }

    private List<String> createMsg(final Set<ConstraintViolation<Object>> erros) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation cv : erros) {
            StringBuilder builder = new StringBuilder();
            builder.append(cv.getPropertyPath()).append(":").append(cv.getMessage());
            errors.add(builder.toString());
        }
        return errors;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.validade.smalltask;

import br.com.bahia.guilherme.trade.annotations.validation.ValueDateNonWorkingDay;
import br.com.bahia.guilherme.trade.model.HoliDay;
import br.com.bahia.guilherme.trade.repositories.HolidayRepository;
import br.com.bahia.guilherme.trade.util.DateUtil;
import br.com.bahia.guilherme.trade.util.SpringUtil;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Guilherme
 */
public class ValueDateNonWorkingDayValidator implements ConstraintValidator<ValueDateNonWorkingDay, Date> {

    private ValueDateNonWorkingDay constraint;
    private HolidayRepository repository;
    
    @Override
    public void initialize(ValueDateNonWorkingDay constraintAnnotation) {
        constraint = constraintAnnotation;
        repository = SpringUtil.getBean(HolidayRepository.class);
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (value == null) {
            //for null @NotNull is used.
            return true;
        }
        LocalDate localDate = DateUtil.convertDateToLocalDate(value);
        if (localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                || localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return false;
        }
        
        List<HoliDay> holidays = repository.findByDayAndMonth(localDate.getDayOfMonth(), localDate.getMonthValue());
        if (!holidays.isEmpty()) {
            return false;
        }
        
        return true;
    }


    
}

package br.com.gbvbahia.smvc.taskify.web.validators;

import br.com.gbvbahia.smvc.taskify.domain.Task;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class TaskValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	    return clazz.isAssignableFrom(Task.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Task task = (Task) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
		        "error.required", new Object[] { "Task name" });
	
		ValidationUtils.rejectIfEmpty(errors, "createdBy.id",
		        "error.required", new Object[] { "Created user" });
		
		ValidationUtils.rejectIfEmpty(errors, "assignee.id",
		        "error.required", new Object[] { "Assigned user" });
		
		ValidationUtils.rejectIfEmpty(errors, "priority",
		        "error.required", new Object[] { "Priority" });

	}

}

package in.dhanushselvam.kowmart.validation;

import java.time.LocalDate;

import in.dhanushselvam.kowmart.exception.ValidationException;
import in.dhanushselvam.kowmart.model.TaskEntity;
import in.dhanushselvam.kowmart.util.StringUtil;

public class TaskValidator {

	public static void validate(TaskEntity task) throws ValidationException {

		if (task == null) {
			throw new ValidationException("Invalid user input");
		}
		
		StringUtil.rejectIfInvalidString(task.getName(), "Task Name");
		isValidDueDate(task.getDueDate(),"Due Date");
	}
	
	public static void isValidDueDate(LocalDate dueDate ,String inputname) throws ValidationException {
		LocalDate today = LocalDate.now();
		if (dueDate.isBefore(today)) {
			throw new ValidationException(inputname.concat(" cannot be before than today"));
		}
	}

}

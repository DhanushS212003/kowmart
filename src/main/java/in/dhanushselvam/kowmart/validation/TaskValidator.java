package in.dhanushselvam.kowmart.validation;

import in.dhanushselvam.kowmart.exception.ValidationException;
import in.dhanushselvam.kowmart.model.Task;
import in.dhanushselvam.kowmart.util.StringUtil;

public class TaskValidator {

	public static void validate(Task task) throws ValidationException {

		if (task == null) {
			throw new ValidationException("Invalid user input");
		}
		
		StringUtil.rejectIfInvalidString(task.getName(), "name");

	}

}

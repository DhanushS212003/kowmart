package in.dhanushselvam.kowmart.validation;

import in.dhanushselvam.kowmart.util.StringUtil;
import in.dhanushselvam.kowmart.exception.ValidationException;
import in.dhanushselvam.kowmart.model.UserEntity;

public class UserValidator {

	public static void validate(UserEntity user) throws ValidationException {

		if (user == null) {
			throw new ValidationException("Invalid user input");
		}
//		if(user.getEmail() == null || "".equals(user.getEmail().trim())) {
//			throw new ValidationException("Email cannot be empty or null");
//		}
//		if(user.getPasswd() ==  null || "".equals(user.getEmail().trim())) {
//			throw new ValidationException("Password cannot be empty or null");
//		}
//		if(user.getfName()==null || "".equals(user.getEmail().trim())) {
//			throw new ValidationException("First name cannot be empty or null");
//		}
		StringUtil.rejectIfInvalidString(user.getEmail(), "Email");
		StringUtil.rejectIfInvalidString(user.getPassword(), "Password");
		StringUtil.rejectIfInvalidString(user.getFirstName(), "Firstname");

	}
}

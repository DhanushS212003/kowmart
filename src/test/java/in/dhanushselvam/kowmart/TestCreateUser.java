package in.dhanushselvam.kowmart;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow; 
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import in.dhanushselvam.kowmart.exception.ValidationException;
import in.dhanushselvam.kowmart.model.User;
import in.dhanushselvam.kowmart.service.UserService;

public class TestCreateUser {

	@Test
	public void testCreateUserWithValidData() {
		UserService userService = new UserService();
		User newUser = new User();
		newUser.setFirstName("Dhanush");
		newUser.setLastName("Selvam");
		newUser.setEmail("dhanush212@gmail.com");
		newUser.setPassword("Aa!12345");
		assertDoesNotThrow(() -> {
			userService.create(newUser);
		});
	}

	@Test
	public void testCreateUserWithInvalidData() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(null);
		});
		String expectedMessage = "Invalid user input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithEmailNull() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			newUser.setFirstName("Dhanush");
			newUser.setLastName("Selvam");
			newUser.setEmail(null);
			newUser.setPassword("Aa!12345");
			userService.create(newUser);
		});
		String expectedMessage = "Email cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithEmailEmpty() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			newUser.setFirstName("Dhanush");
			newUser.setLastName("Selvam");
			newUser.setEmail("");
			newUser.setPassword("Aa!12345");
			userService.create(newUser);
		});
		String expectedMessage = "Email cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithPasswordEmpty() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			newUser.setFirstName("Dhanush");
			newUser.setLastName("Selvam");
			newUser.setEmail("dhanush212@gmail.com");
			newUser.setPassword("");
			userService.create(newUser);
		});
		String expectedMessage = "Password cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithPasswordNull() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			newUser.setFirstName("Dhanush");
			newUser.setLastName("Selvma");
			newUser.setEmail("dhanush212@gmail.com");
			newUser.setPassword(null);
			userService.create(newUser);
		});
		String expectedMessage = "Password cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithFirstnameEmpty() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			newUser.setFirstName("");
			newUser.setLastName("Selvam");
			newUser.setEmail("dhanush212@gmail.com");
			newUser.setPassword("Aa!12345");
			userService.create(newUser);
		});
		String expectedMessage = "Firstname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithFirstnameNull() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			newUser.setFirstName(null);
			newUser.setLastName("Selvam");
			newUser.setEmail("dhanush212@gmail.com");
			newUser.setPassword("Aa!12345");
			userService.create(newUser);
		});
		String expectedMessage = "Firstname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
}
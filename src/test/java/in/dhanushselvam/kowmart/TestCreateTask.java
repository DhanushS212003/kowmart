package in.dhanushselvam.kowmart;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow ;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import in.dhanushselvam.kowmart.exception.ValidationException;
import in.dhanushselvam.kowmart.model.Task;
import in.dhanushselvam.kowmart.service.TaskService;

public class TestCreateTask {

	@Test
	public void testCreateTaskWithValidData() {
		TaskService taskService = new TaskService();

		Task newTask = new Task();
		newTask.setId(12345);
		newTask.setName("Say Hi");

		String date = "23/07/2023";
		LocalDate convertedDate = TaskService.convertToDate(date);
		newTask.setDueDate(convertedDate);
		newTask.setActive(true);
		assertDoesNotThrow(() -> {
			taskService.create(newTask);
		});
	}

	@Test
	public void testCreateTaskWithInvalidData() {
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(null);
		});
		String expectedMessage = "Invalid user input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithNameEmpty() {
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			Task newTask = new Task();
			newTask.setId(12345);
			newTask.setName("");

			String date = "23/07/2023";
			LocalDate convertedDate = TaskService.convertToDate(date);
			newTask.setDueDate(convertedDate);
			newTask.setActive(true);
			taskService.create(newTask);
		});
		String expectedMessage = "Task Name cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithNameNull() {
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			Task newTask = new Task();
			newTask.setId(12345);
			newTask.setName(null);

			String date = "23/07/2023";
			LocalDate convertedDate = TaskService.convertToDate(date);
			newTask.setDueDate(convertedDate);
			newTask.setActive(true);
			taskService.create(newTask);
		});
		String expectedMessage = "Task Name cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithInvalidDate() {
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			Task newTask = new Task();
			newTask.setId(12345);
			
			String date = "23/07/2022";
			newTask.setName("Say Hi");
			LocalDate convertedDate = TaskService.convertToDate(date);
			newTask.setDueDate(convertedDate);
			newTask.setActive(true);
			taskService.create(newTask);
		});
		String expectedMessage = "Due Date cannot be before than today";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

}

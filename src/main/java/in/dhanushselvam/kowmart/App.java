package in.dhanushselvam.kowmart;

import java.time.LocalDate; 

import in.dhanushselvam.kowmart.model.UserEntity;
import in.dhanushselvam.kowmart.model.Task;
import in.dhanushselvam.kowmart.model.User;
import in.dhanushselvam.kowmart.service.TaskService;
import in.dhanushselvam.kowmart.service.UserService;

public class App {

	public static void main(String[] args) {

		try {
			UserService userService = new UserService();
			
			User user = new User();
			user.setId(1);
			user.setFirstName("dhanush");
			user.setLastName("selvam");
			user.setEmail("dhanush.selvam@fssa.freshworks.com");
			user.setPassword("Aa!12345");
			user.setActive(true);

			userService.create(user);
			userService.getAll();
			
			String userInput = "23/07/2023";
			LocalDate convertedDate = TaskService.convertToDate(userInput);
			
			TaskService taskService = new TaskService();
			
			Task task = new Task();
			task.setId(1);
			task.setName("dhanush");
			task.setDueDate(convertedDate);
			user.setActive(true);

			taskService.create(task);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package in.dhanushselvam.kowmart;

import in.dhanushselvam.kowmart.model.User;
import in.dhanushselvam.kowmart.service.UserService;

public class App {

	public static void main(String[] args) {

//		UserService userService = new UserService();
//		userService.create();
//		userService.update();
//		userService.delete();
//		userService.getAll();
//		userService.getById();

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
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package in.dhanushselvam.kowmart;

import in.dhanushselvam.kowmart.service.UserService;

public class App {

	public static void main(String[] args) {
		
		UserService userService = new UserService();
		userService.create();
		userService.getAll();

	}

}

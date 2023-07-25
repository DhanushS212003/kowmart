package in.dhanushselvam.kowmart;

import org.junit.jupiter.api.Test;
import in.dhanushselvam.kowmart.model.User;
import in.dhanushselvam.kowmart.service.UserService;

public class TestGetAllUser {
	
	@Test
	public void testfindById() {
		UserService userService = new UserService();
		User user = userService.findById(1);
		System.out.println(user);
	}
	@Test
	public void getAllUsers() {
		UserService userService = new UserService();
		System.out.println(userService.getAll());
	}

}

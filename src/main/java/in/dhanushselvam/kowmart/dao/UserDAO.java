package in.dhanushselvam.kowmart.dao;

import in.dhanushselvam.kowmart.model.User;

public class UserDAO {
	
	public User[] findAll() {
		
		User[] userList = UserList.listOfUser;
		return userList;
		
	}
	
	public void create() {
		
		User user = new User();
		user.setId(001);
		user.setFirstName("dhanush");
		user.setLastName("selvam");
		user.setEmail("dhanush.selvam@fssa.freshworks.com");
		user.setPassword("Aa!12345");
		user.setActive(true);
		
		UserList.listOfUser[0] = user;
		
	}

}
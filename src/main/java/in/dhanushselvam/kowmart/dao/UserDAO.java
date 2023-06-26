package in.dhanushselvam.kowmart.dao;

import in.dhanushselvam.kowmart.model.User;

public class UserDAO {
	
	public User[] findAll() {
		
		User[] userList = UserList.listOfUser;
		return userList;
		
	}
	
	public void create(User user) {
		
		UserList.listOfUser[0] = user;
		
	}
 
}

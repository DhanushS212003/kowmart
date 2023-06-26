package in.dhanushselvam.kowmart.service;

import in.dhanushselvam.kowmart.dao.UserDAO;
import in.dhanushselvam.kowmart.model.User;

public class UserService {

	public User[] getAll() {

		UserDAO userDao = new UserDAO();
		User[] userList = userDao.findAll();

		for (int i = 0; i < userList.length; i++) {
			System.out.println(userList[i]);
		}

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

		UserDAO newUserDao = new UserDAO();
		newUserDao.create(user);

	}

}

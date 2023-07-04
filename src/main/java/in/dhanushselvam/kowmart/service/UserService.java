package in.dhanushselvam.kowmart.service;

import in.dhanushselvam.kowmart.dao.UserDAO;
import in.dhanushselvam.kowmart.exception.ValidationException;
import in.dhanushselvam.kowmart.model.User;
import in.dhanushselvam.kowmart.validation.UserValidator;

public class UserService {

	public User[] getAll() {

		UserDAO userDao = new UserDAO();
		User[] userList = userDao.findAll();

		for (int i = 0; i < userList.length; i++) {
			System.out.println(userList[i]);
		}

		return userList;

	}

	public void create(User user) throws ValidationException {

		UserValidator.validate(user);
		UserDAO userDao = new UserDAO();
		userDao.create(user);

	}
	
	public void update() {
		
		User updatedUser = new User();
		
		updatedUser.setFirstName("Dhanush");
		updatedUser.setLastName("S");
		
		UserDAO userDao = new UserDAO();
		userDao.update(2, updatedUser);
		
	}
	
	public void delete() {
		
		User deleteUser = new User();
		deleteUser.setActive(false);
		
		UserDAO userDao = new UserDAO();
		userDao.delete(2,deleteUser);
	}
	
	public User getById() {
		
		UserDAO userDao = new UserDAO();
		User user = userDao.getById(1);
		System.out.println(user);
		return user;
		
	}
 
}

package in.dhanushselvam.kowmart.service;

import java.util.List; 
import in.dhanushselvam.kowmart.dao.UserDAO; 
import in.dhanushselvam.kowmart.model.User;
import in.dhanushselvam.kowmart.validation.UserValidator;

public class UserService {
	
	private UserDAO userDao;
	
	public UserService() {
		this.userDao = new UserDAO();
	}

	public List<User> getAll() {

		List<User> userList = userDao.findAll();
		for (User user: userList) {
			System.out.print(user);
		}
		return userList;
	}

	public void create(User newUser) throws Exception {

		UserValidator.validate(newUser);
		UserDAO userDao = new UserDAO();
		userDao.create(newUser);

	}
	
	public void update(int id, User updatedUser) {
		
		UserDAO userDao = new UserDAO();
		userDao.update(id, updatedUser);
		
	}
	
	public void delete(int id) {
		
		UserDAO userDao = new UserDAO();
		userDao.delete(id);
	}
	
	public User findById(int id) {
		
		UserDAO userDao = new UserDAO();
		return userDao.findById(id);
		
	}
 
}

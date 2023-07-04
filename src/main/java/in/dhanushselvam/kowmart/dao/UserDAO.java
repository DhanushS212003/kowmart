package in.dhanushselvam.kowmart.dao;

import in.dhanushselvam.kowmart.model.User;

public class UserDAO {
	
	private User[] arr = UserList.listOfUser;
	
	public User[] findAll() {
		
		User[] userList = UserList.listOfUser;
		return userList;
		
	}
	
	public void create(User user) {
						
		for (int i = 0; i < arr.length; i++) {
			
			User currentUser = arr[i];
			
			if (currentUser == null) {
				arr[i] = user;
				break;
			}
			
		}
		
	}
	
	public void update(int id, User updatedUser) {
				
		for (int i = 0; i < arr.length; i++) {
			
			User currentUser = arr[i];
			
			if (currentUser == null) {
				continue;
			}
			if (currentUser.getId() == id) {
				
				currentUser.setFirstName(updatedUser.getFirstName());
				currentUser.setLastName(updatedUser.getLastName());
				break;
				
			}
		}
		
	}
	
	public void delete(int id, User updatedUser) {
				
		for (int i = 0; i < arr.length; i++) {
			
			User currentUser = arr[i];
			
			if (currentUser == null) {
				continue;
			}
			if (currentUser.getId() == id) {
				currentUser.setActive(false);
			}
		}
		
	}
	
	public User getById(int id) {
		
		User matchedUser = null;
		
		for (int i = 0; i < arr.length; i++) {
			
			User currentUser = arr[i];
			
			if (currentUser == null) {
				continue;
			}
			if (currentUser.getId() == id) {
				matchedUser = currentUser;
				System.out.print(currentUser);
				break;
			}
			
		}
		return matchedUser;
		
	}
 
}

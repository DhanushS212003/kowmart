package in.dhanushselvam.kowmart.Interface;

import in.dhanushselvam.kowmart.model.User;

public interface UserInterface extends Base<User> {
	
	public abstract User findByEmailId(String email);
	
	public abstract int count();

}

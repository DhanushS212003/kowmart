package in.dhanushselvam.kowmart.model;

public abstract class UserEntity implements Comparable<User> {

	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	private String lastName;

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", id=" + id + ", isActive=" + isActive + "]";
	}

	private String email;
	private String password;
	private int id;
	private boolean isActive = true;

	public String fullName() {
		return firstName.concat(" ").concat(lastName);
	}

	public int compareTo(User o) {

		if (this.getId() == o.getId())
			return 0;
		else {
			if (this.getId() > o.getId())
				return 1;
			else
				return -1;
		}

	}

}

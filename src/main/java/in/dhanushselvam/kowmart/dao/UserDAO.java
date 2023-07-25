package in.dhanushselvam.kowmart.dao;

import java.sql.Connection;    
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.dhanushselvam.kowmart.Interface.UserInterface;
import in.dhanushselvam.kowmart.model.User;
import in.dhanushselvam.kowmart.util.ConnectionUtil;

public class UserDAO implements UserInterface{
	
	public List<User> findAll() throws RuntimeException{
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<User> userList = new ArrayList<>();
		
		try {
			
			String query = "SELECT * FROM users WHERE is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("is_active"));
				
				userList.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return userList;
		
	}
	
	public void create(User newUser) {		
		
		Connection con = null;
		PreparedStatement ps = null;
	
		
		try {
			
			String query = "INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, newUser.getFirstName());
			ps.setString(2, newUser.getLastName());
			ps.setString(3, newUser.getEmail());
			ps.setString(4, newUser.getPassword());
			
			 ps.executeUpdate();
			 System.out.println("Done :)");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps);
		}
	
	}
	
	public void update(int id, User updatedUser) {
//		List<User> userList = UserList.listOfUser;
//		for (User ListOfUsers: userList) {
//			User user1 = ListOfUsers;
//			
//			if (user1 == null) continue;
//			if (user1.getId() == id) {
//				ListOfUsers.setFirstName(updatedUser.getFirstName());
//				ListOfUsers.setLastName(updatedUser.getLastName());
//				ListOfUsers.setPassword(updatedUser.getFirstName());
//			}
//		}
		
		Connection con = null;
		PreparedStatement ps = null;
		
//		try {
//			
//			String query = "UPDATE users SET "
//			
//		}
		
	}
	
	public void delete(int id) {
				
		List<User> userList = UserList.listOfUser;
		for (User ListOfUsers: userList) {
			User user1 = ListOfUsers;
			
			if (user1 == null) continue;
			if (user1.getId() == id) user1.setActive(false);
		}
		
	}
	
	public User findById(int id) throws RuntimeException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User user = null;
		
		try {
			
			String query = "SELECT * FROM users WHERE is_active = 1 and id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("is_active"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return user;
		
	}
	
	public User findByEmailId(String email) {
		
		List<User> userList = UserList.listOfUser;
		for (User user : userList) {
			if (user != null && user.getEmail() == null) return user;
		}
		return null;
		
	}
	
	public int count() {
		return 0;
	}
 
}

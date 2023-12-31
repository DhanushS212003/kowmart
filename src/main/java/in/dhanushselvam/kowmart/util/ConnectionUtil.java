package in.dhanushselvam.kowmart.util;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {

	public static Connection getConnection() {

		Connection connection = null;
		Dotenv env = Dotenv.load();
		String url = env.get("DATABASE_HOST");
		String userName = env.get("DATABASE_USERNAME");
		String password = env.get("DATABASE_PASSWORD");

		try {
			// Class.forName("com.mysql.cj.jdbc.Drivers");
			// connection = DriverManager.getConnection(url, userName, password);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, password);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return connection;

	}

	public static void close(Connection connection, PreparedStatement ps) {

		try {
			if (ps != null)ps.close();
			if (connection != null)connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(Connection connection, PreparedStatement ps, ResultSet rs) {

		try {
			if (ps != null)ps.close();
			if (connection != null)connection.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

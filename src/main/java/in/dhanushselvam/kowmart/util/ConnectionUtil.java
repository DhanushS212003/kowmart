package in.dhanushselvam.kowmart.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {

		Connection connection = null;
		String url = null;
		String userName = null;
		String password = null;

		try {
			// Class.forName("com.mysql.cj.jdbc.Drivers");
			// connection = DriverManager.getConnection(url, userName, password);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
			  "jdbc:mysql://aws.connect.psdb.cloud/kowmart?sslMode=VERIFY_IDENTITY",
			  "b6toc49kxyc79wu6w1hs",
			  "pscale_pw_m9OKDVnKaWMS8sqUzOVzI17NbnLTvifmTdQy54NhoXd");


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

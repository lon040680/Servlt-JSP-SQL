package net.javaguides.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.login.bean.LoginBean;

public class LoginDao {

	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		boolean status = false;

		// Step 1: Driver load & Set link
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dburl = "jdbc:mysql://151.106.116.31:3306/u586968401_test01";
		String dbuname = "u586968401_user01";
		String dbpassword = "Money780406";

		try {
			// Step 1.5: link SQL
			Connection connection = DriverManager.getConnection(dburl,dbuname, dbpassword);

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employees where username = ? and password = ? ");
			
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return status;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.registration.model.Employee;

public class EmployeeDao {

	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO employees"
				+ "  (id, frist_name, last_name, username, password, address, contact) VALUES "
				+ " (?, ?, ?, ?, ?, ?, ?);";

		int result = 0;

		// Step 1: Driver load & Set link
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dburl = "jdbc:mysql://151.106.116.31:3306/u586968401_test01";
		String dbuname = "u586968401_user01";
		String dbpassword = "Money780406";
		
		try {
			
			// Step 1.5: link SQL
			Connection connection = DriverManager.getConnection(dburl,dbuname, dbpassword);
					
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, employee.getFristname());
			preparedStatement.setString(3, employee.getLastname());
			preparedStatement.setString(4, employee.getUsername());
			preparedStatement.setString(5, employee.getPassword());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.setString(7, employee.getContact());

			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			e.printStackTrace();
		}
		return result;
	}

	//例外發生時可以發出錯誤提示
	@SuppressWarnings("unused")
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

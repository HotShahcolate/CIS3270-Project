package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import code.*;

public class Main {
	public static Connection conn;
	
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/sys";
			String username = "root";
			String password = "3270";
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}
	
	public static void login(Customer co) throws Exception{
		// Create a statement
		PreparedStatement statement = conn.prepareStatement(Queries.LOGIN);
		
		statement.setString(1, co.getUsername());
		statement.setString(2, co.getPassword());

		// Execute a statement
		ResultSet resultSet = statement.executeQuery();
		
		int count = 0;

		// Iterate through the result and print the student names
		while (resultSet.next()) {
			System.out.println("Number of Users:" + resultSet.getInt(1));
			count = resultSet.getInt(1);
		}
		
		if (count == 0)
			throw new code.Exceptions("Invalid Username or Password!");
	}
	
	public static void register(Customer co) throws Exception{
		// Create a statement
		PreparedStatement statement = conn.prepareStatement(Queries.REGISTER);
		
		statement.setString(1, co.getUsername());
		statement.setString(2, co.getPassword());
		statement.setString(3, co.getFirstname());
		statement.setString(4, co.getLastname());
		statement.setString(5, co.getAddress());
		statement.setString(6, co.getZip());
		statement.setString(7, co.getState());
		statement.setString(8, co.getEmail());
		statement.setString(9, co.getAnswer());
		statement.setString(10, co.getSsn());

		// Execute a statement
		try {
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new code.Exceptions("The specified username already exists.");
		}
	}
	
	public static ResultSet loadMainMenuFlights() throws Exception{
		// Create a statement
		PreparedStatement statement = conn.prepareStatement(Queries.LOAD_MAIN_MENU_FLIGHTS);
		
		// Execute a statement
		ResultSet resultSet = statement.executeQuery();
		
		return resultSet;
	}
	
	public static ResultSet loadMainMenuDates() throws Exception{
		// Create a statement
		PreparedStatement statement = conn.prepareStatement(Queries.LOAD_MAIN_MENU_DATES);
		
		// Execute a statement
		ResultSet resultSet = statement.executeQuery();
		
		return resultSet;
	}

	public static String retrievePassword(Customer co) throws Exception{
		// Create a statement
		PreparedStatement statement = conn.prepareStatement(Queries.RETRIEVE_PASSWORD);
		
		statement.setString(1, co.getUsername());
		statement.setString(2, co.getAnswer());
		
		try {
			// Execute a statement
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			
			return resultSet.getString("password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new code.Exceptions("Incorrect username/password");
		}
	}
}

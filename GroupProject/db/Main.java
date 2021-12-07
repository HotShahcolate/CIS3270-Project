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
	
	public static ResultSet loadYourFlights(Customer co) throws Exception{
		// Create a statement
		PreparedStatement statement = conn.prepareStatement(Queries.LOAD_YOUR_FLIGHTS,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		statement.setInt(1, co.getId());
		
		// Execute a statement
		ResultSet resultSet = statement.executeQuery();
		
		if (!resultSet.isBeforeFirst() )   
			throw new code.Exceptions("You have not booked any flights");
		
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
	
	public static int retrieveCustomerID(Customer co) throws Exception{
		// Create a statement
		PreparedStatement statement = conn.prepareStatement(Queries.RETRIEVE_CUSTOMER_ID);
		
		statement.setString(1, co.getUsername());
		
		try {
			// Execute a statement
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			
			return resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new code.Exceptions("Username not found");
		}
	}
	
	public static int retrieveFlightID(Flight fl) throws Exception{
		// Create a statement
		PreparedStatement statement = conn.prepareStatement(Queries.RETRIEVE_FLIGHT_ID);
		
		statement.setString(1, fl.getFrom());
		statement.setString(2, fl.getTo());
		statement.setString(3, fl.getDate());

		
		try {
			// Execute a statement
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			
			return resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
			throw new code.Exceptions("Error: no flight from selected location to selected destination for this date");
		}
	}
	
	public static void bookFlight(Customer co, Flight fl) throws Exception{
		// Create a statement
		PreparedStatement statement = conn.prepareStatement(Queries.BOOK_FLIGHT);
		
		//Integer.toString(co.getId())
		statement.setInt(1, co.getId());
		statement.setInt(2, fl.getId());

		// Execute a statement
		try {
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new code.Exceptions("You've already booked a ticket for this flight");
		}
	}
	
	public static void deleteYourFlight(int idCustomersIndex, int idFlightsIndex) throws Exception{
		// Create a statement
		PreparedStatement statement = conn.prepareStatement(Queries.DELETE_YOUR_FLIGHT);
		
		statement.setInt(1, idCustomersIndex);
		statement.setInt(2, idFlightsIndex);
		
		// Execute a statement
		try {
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

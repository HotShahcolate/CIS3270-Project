package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

}

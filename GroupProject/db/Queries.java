package db;

public class Queries {
	public static final String LOGIN = "SELECT count(*) FROM sys.customers WHERE username = ? AND password =?";
	
	public static final String LOAD_MAIN_MENU_FLIGHTS = "SELECT flights.from FROM sys.flights GROUP BY flights.from";
	
	public static final String LOAD_MAIN_MENU_DATES = "SELECT flights.date FROM sys.flights GROUP BY flights.date";

	public static final String REGISTER = "INSERT INTO `sys`.`customers` (`username`, `password`, `firstname`, `lastname`, `address`, `zip`, `state`, `email`, `answer`, `ssn`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String RETRIEVE_PASSWORD = "SELECT password FROM sys.customers WHERE username = ? AND answer =?";

}

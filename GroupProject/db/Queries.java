package db;

public class Queries {
	public static final String LOGIN = "SELECT count(*) FROM sys.customers WHERE username = ? AND password =?";
	
	public static final String LOAD_MAIN_MENU_FLIGHTS = "SELECT flights.from FROM sys.flights GROUP BY flights.from";
	
	public static final String LOAD_MAIN_MENU_DATES = "SELECT flights.date FROM sys.flights GROUP BY flights.date";

	public static final String REGISTER = "INSERT INTO `sys`.`customers` (`username`, `password`, `firstname`, `lastname`, `address`, `zip`, `state`, `email`, `answer`, `ssn`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String RETRIEVE_PASSWORD = "SELECT password FROM sys.customers WHERE username = ? AND answer =?";
	
	public static final String RETRIEVE_CUSTOMER_ID = "SELECT idcustomers FROM sys.customers WHERE username = ?";
	
	public static final String RETRIEVE_FLIGHT_ID = "SELECT idflights FROM sys.flights WHERE `from` = ? AND `to` = ? and date = ?";
	
	public static final String BOOK_FLIGHT = "INSERT INTO `sys`.`customerflights` (`idcustomers`, `idflights`) VALUES (?, ?)";

	public static final String LOAD_YOUR_FLIGHTS = "SELECT * FROM flights RIGHT JOIN customerflights ON flights.idflights = customerflights.idflights WHERE customerflights.idcustomers = ?";
	
	public static final String DELETE_YOUR_FLIGHT = "DELETE FROM `sys`.`customerflights` WHERE (`idcustomers` = ?) and (`idflights` = ?)";
}

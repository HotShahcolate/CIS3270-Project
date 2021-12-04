package db;

public class Queries {
	public static final String LOGIN = "SELECT count(*) FROM sys.customers WHERE username = ? AND password =?";
}

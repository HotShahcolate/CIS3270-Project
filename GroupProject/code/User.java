package code;

abstract public class User {
	// the use of private variables and their associated getters and setters is an example of ENCAPSULATION - 
	// Encapsulation in Java is a concept where data is wrapped (variables) with code acting on the data (methods) 
	// together as a single unit. In encapsulation, the variables of a class are hidden from other classes, and can be 
	// accessed only through the methods of their current class. Therefore, it is also known as data hiding.
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String address;
	private String zip;
	private String state;
	private String email;
	private String answer;
	private String ssn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	// the use of multiple constructors here is an example of POLYMORPHISM. This is also known as method overloading, or more specifically here,
	// constructor overloading. POLYMORPHISM is the ability of an object to take on many forms. Here, the "User" object can be constructed in two 
	// different ways. 
	public User(int id, String username, String password, String firstname, String lastname, String address, String zip,
			String state, String email, String answer, String ssn) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.zip = zip;
		this.state = state;
		this.email = email;
		this.answer = answer;
		this.ssn = ssn;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {
		
	}
	
}

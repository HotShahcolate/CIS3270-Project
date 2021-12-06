package code;

// The Customer class is an example of INHERITANCE. Here, it "inherits" from User by using the "extends" keyword.
// Inheritance can be defined as the process where one class acquires the properties (methods and fields) of another. The class which 
// inherits the properties of other is known as subclass (derived class, child class) and the class whose properties are inherited is 
// known as superclass (base class, parent class). Here, Customer is the subclass and User is the superclass.


public class Customer extends User {

	public Customer(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
	public Customer() {
		
	}

}

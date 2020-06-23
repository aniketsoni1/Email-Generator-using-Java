// import necessary packages
import java.util.Random;
import java.util.Scanner;

//definition of class: EmailApp - begin
public class EmailApp {
	// all the data fields are private
	private String firstname;
	private String lastname;
	private String password;
	private String department;
	final private int mailboxCapacity = 500;
	final private int passwordLength  = 10;
	
	// constructor with two parameters firstname and lastname
	public EmailApp(String inFirstname, String inLastname)
	{
		// update first and last name with passed arguments
		firstname = inFirstname;
		lastname  = inLastname;
		
		// call to setDepartment() from the constructor
		setDepartment();
		
		// call to setPassword() from the constructor
		setPassword();
	}
	
	// method to get department options from user and set the department code
	private void setDepartment()
	{
		// display the valid department numbers and codes to choose from
		System.out.println("Enter the department number: ");
		System.out.println("           0 for none");
		System.out.println("           1 for cs(computer scienc)");
		System.out.println("           2 for act(accounting)");
		System.out.println("           3 for ee(electrical engineering)");
		
		// create object to read the input from the user
		Scanner userInput = new Scanner(System.in);
		
		// read the department number
		byte departmentNumber = userInput.nextByte();	
		
		// initialize the department code to empty string
		String departmentCode = "";
		
		// set the department code accordingly
		switch(departmentNumber)
		{
			case 0: departmentCode = "";  break;
			case 1: departmentCode = "cs.";  break;
			case 2: departmentCode = "act."; break;
			case 3: departmentCode = "ee.";  break;
		}
		
		// set the department 
		department = departmentCode;
	}
	
	// method to generate random password with the default passwordLength of 10
	private void setPassword()
	{
		// string with all the valid characters allowed in the password 
		final String allChars = "ABDCEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$";
		
		// initialize the password with empty string
		String randomPassword = "";
		
		// generate random numbers
		Random randomNumber = new Random();
		
		// generate random password of length: passwordLength 
		for (int count = 1; count <= passwordLength; count++)
			randomPassword += allChars.charAt(randomNumber.nextInt(allChars.length())); 
		
		// set the generated password
		password = randomPassword;
	}
	
	// method to change the password
	public void changePassword()
	{
		// simply changing the password using the member
		Scanner passwordChange = new Scanner(System.in);
		System.out.println("Please enter your new password");
		password = passwordChange.next();
		this.password = password;
		System.out.println("Your password is updated. Your new password is: " + password);
	}
	
	// method to display the email, password and mailboxCapacity
	void display()
	{
		// syntax of email - firstname.lastname@department.saumag.edu
		// both firstname and lastname are in lowercase
		System.out.println("Email address:    " + firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "saumag.edu"); 
		System.out.println("Password:         " + password);
		System.out.println("Mailbox capacity: " + mailboxCapacity);
	}
	
} // definition of class: EmailApp - end 

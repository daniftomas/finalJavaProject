package finalJavaProject;

public class Employee extends Person {

	private int employeeNumber;
	private String extension;
	private String email;
	private String officeCode;
	private int reportsTo;
	private String jobTitle;
	
	public Employee(String firstName, String lastName) {
		super(firstName, lastName);
		extension = "";
		email = "";
		officeCode = "";
		reportsTo = -1;
		jobTitle = "";
	}
	
	public Employee(String firstName, String lastName, int employeeNumber, String extension, String email, String officeCode, int reportsTo, String jobTitle) {
		super(firstName, lastName);
		this.employeeNumber = employeeNumber; 
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.officeCode = "invalid";
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
	}
	
	public Employee(Person p, int employeeNumber, String extension, String email, String officeCode, int reportsTo, String jobTitle) {
		super(p);
		this.employeeNumber = employeeNumber; 
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
	}
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		if (Utilities.validateSize(10, extension))this.extension = extension;
		else this.extension = "invalid";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (Utilities.validateEmail(email)) this.email = email;
		else this.email = "invalid";
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		if (Utilities.validateSize(10, officeCode))this.officeCode = officeCode;
		else this.officeCode = "invalid";
	}

	public int getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String toString(){
		return this.getFirstName() + " " + this.getLastName() + "\n "
				+ "Number: " + this.getEmployeeNumber() + "\n"
				+ "Job title: " + this.jobTitle + "\n"
				+ "Office: " + this.getOfficeCode() + "\n"
				+ "Reports to: ";
	}
	
}
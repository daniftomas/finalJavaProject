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
		if (Utilities.validateSize(10, extension))this.extension = extension;
		else this.extension = "invalid";
		if (Utilities.validateEmail(email))this.email = email;
		else this.email = "invalid";
		if (Utilities.validateSize(10, officeCode))this.officeCode = officeCode;
		else this.officeCode = "invalid";
		this.reportsTo = reportsTo;
		if (Utilities.validateSize(50, jobTitle))this.jobTitle = jobTitle;
		else this.jobTitle = "invalid";
	}
	
	public Employee(Person p, int employeeNumber, String extension, String email, String officeCode, int reportsTo, String jobTitle) {
		super(p);
		this.employeeNumber = employeeNumber; 
		if (Utilities.validateSize(10, extension))this.extension = extension;
		else this.extension = "invalid";
		if (Utilities.validateEmail(email))this.email = email;
		else this.email = "invalid";
		if (Utilities.validateSize(10, officeCode))this.officeCode = officeCode;
		else this.officeCode = "invalid";
		this.reportsTo = reportsTo;
		if (Utilities.validateSize(50, jobTitle))this.jobTitle = jobTitle;
		else this.jobTitle = "invalid";
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
		if (Utilities.validateSize(50, jobTitle))this.jobTitle = jobTitle;
		else this.jobTitle = "invalid";
	}
}
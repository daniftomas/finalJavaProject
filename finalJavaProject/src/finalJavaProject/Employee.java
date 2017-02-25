package finalJavaProject;

public class Employee extends Person implements Comparable<Employee> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int employeeNumber;
	private String extension;
	private String email;
	private String officeCode;
	private int reportsTo;
	private String jobTitle;
	
	
	public Employee() {
		super("", "");
		employeeNumber = -1;
		extension = "";
		email = "";
		officeCode = "";
		reportsTo = -1;
		jobTitle = "";
	}
	
	public Employee(String firstName, String lastName) {
		super(firstName, lastName);
		employeeNumber = -1;
		extension = "";
		email = "";
		officeCode = "";
		reportsTo = -1;
		jobTitle = "";
	}
	
	public Employee(int employeeNumber, String firstName, String lastName, String extension, String email, String officeCode, int reportsTo, String jobTitle) {
		super(firstName, lastName);
		this.employeeNumber = employeeNumber; 
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.officeCode = "";
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
	}
	
	public Employee(String firstName, String lastName, String extension, String email, String officeCode, int reportsTo, String jobTitle) {
		super(firstName, lastName);
		this.employeeNumber = -1; 
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.officeCode = "";
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
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
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
		String of = this.officeCode;
		if (this.getOfficeCode().equals("")) of = "N/A";
		String ff = this.getFirstName() + " " + this.getLastName() + "\n"
				+ "Number: " + this.getEmployeeNumber() + "\n"
				+ "Job title: " + this.jobTitle + "\n"
				+ "Office: " + of + "\n";
		if (this.getReportsTo() > 0) {
			Employee report = DataBase.getEmployeeByNumber(this.getReportsTo());
			ff += "Reports to: " + report.getFirstName() + " " + report.getLastName();
		}
		return ff;
		
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
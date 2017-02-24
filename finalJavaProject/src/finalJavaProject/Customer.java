package finalJavaProject;

public class Customer extends Person {
	
	private int customerNumber;
	private String customerName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private int salesRepEmployeeNumber;
	private double creditLimit;
	
	public Customer(Person p, int customerNumber, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, int salesRepEmployeeNumber, double creditLimit) {
		super(p);
		this.customerNumber = customerNumber;
		this.customerName = p.getFirstName() + " " + p.getLastName();
		if (Utilities.validatePhone(phone)) this.phone = phone;
		else this.phone = "invalid";
		if (Utilities.validateSize(50, addressLine1)) this.addressLine1 = addressLine1;
		else this.addressLine1 = "invalid. Too long!!";
		if (Utilities.validateSize(50, addressLine2)) this.addressLine2 = addressLine2;
		else this.addressLine2 = "invalid. Too long!!";
		if (Utilities.validateSize(50, city)) this.city = city;
		else this.city = "invalid. Too long!!";
		if (Utilities.validateSize(50, state)) this.state = state;
		else this.state = "invalid. Too long!!";
		if (Utilities.validateSize(50, country)) this.country = country;
		else this.country = "invalid. Too long!!";
		if (Utilities.validateCodePostal(postalCode)) this.postalCode = postalCode;
		else this.postalCode = "invalid";
		if (salesRepEmployeeNumber > 0) this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		else this.salesRepEmployeeNumber = -1; 
		if (creditLimit > 0) this.creditLimit = creditLimit;
		else this.creditLimit = 0; 
	}
	
	public Customer(String firstName, String lastName, int customerNumber, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, int salesRepEmployeeNumber, double creditLimit) {
		super(firstName, lastName);
		this.customerName = firstName + " " + lastName;
		this.customerNumber = customerNumber;
		if (Utilities.validatePhone(phone)) this.phone = phone;
		else this.phone = "invalid";
		if (Utilities.validateSize(50, addressLine1)) this.addressLine1 = addressLine1;
		else this.addressLine1 = "invalid. Too long!!";
		if (Utilities.validateSize(50, addressLine2)) this.addressLine2 = addressLine2;
		else this.addressLine2 = "invalid. Too long!!";
		if (Utilities.validateSize(50, city)) this.city = city;
		else this.city = "invalid. Too long!!";
		if (Utilities.validateSize(50, state)) this.state = state;
		else this.state = "invalid. Too long!!";
		if (Utilities.validateSize(50, country)) this.country = country;
		else this.country = "invalid. Too long!!";
		if (Utilities.validateCodePostal(postalCode)) this.postalCode = postalCode;
		else this.postalCode = "invalid";
		if (salesRepEmployeeNumber > 0) this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		else this.salesRepEmployeeNumber = -1; 
		if (creditLimit > 0) this.creditLimit = creditLimit;
		else this.creditLimit = 0; 
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (Utilities.validatePhone(phone)) this.phone = phone;
		else this.phone = "invalid";
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		if (Utilities.validateSize(50, addressLine1)) this.addressLine1 = addressLine1;
		else this.addressLine1 = "invalid. Too long!!";
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		if (Utilities.validateSize(50, addressLine2)) this.addressLine2 = addressLine2;
		else this.addressLine2 = "invalid. Too long!!";
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		if (Utilities.validateSize(50, city)) this.city = city;
		else this.city = "invalid. Too long!!";
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		if (Utilities.validateSize(50, state)) this.state = state;
		else this.state = "invalid. Too long!!";
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		if (Utilities.validateCodePostal(postalCode)) this.postalCode = postalCode;
		else this.postalCode = "invalid";
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		if (Utilities.validateSize(50, country)) this.country = country;
		else this.country = "invalid. Too long!!";
	}

	public int getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}

	public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
		if (salesRepEmployeeNumber > 0) this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		else this.salesRepEmployeeNumber = -1; 
	}

	public double getCreditlimit() {
		return creditLimit;
	}

	public void setCreditlimit(double creditLimit) {
		if (creditLimit > 0) this.creditLimit = creditLimit;
		else this.creditLimit = 0; 
	}
}


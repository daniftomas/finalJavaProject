package finalJavaProject;

import java.io.Serializable;

public class Customer extends Person implements Serializable, Comparable<Customer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public Customer(){
		super("", "");
		customerNumber = -1;
		phone = "";
		addressLine1 = "";
		addressLine2 = "";
		city = "";
		state = "";
		postalCode = "";
		country = "";
		salesRepEmployeeNumber = -1;
		creditLimit = 0;
	}
	
	public Customer(String firstName, String lastName, int customerNumber, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, int salesRepEmployeeNumber, double creditLimit) {
		super(firstName, lastName);
		this.customerName = firstName + " " + lastName;
		this.customerNumber = customerNumber;
		if (phone != null) {
			this.phone = phone;
		} else {
			phone = "";
		}
		if (addressLine1 != null) {
			this.addressLine1 = addressLine1;
		} else {
			addressLine1 = "";
		}
		if (addressLine2 != null) {
			this.addressLine2 = addressLine2;
		} else {
			addressLine2 = "";
		}
		if (city != null) {
			this.city = city;
		} else {
			city = "";
		}
		if (state != null) {
			this.state = state;
		}
		else {
			state = "";
		}
		if (country != null) {
			this.country = country;
		} else {
			country = "";
		}
		if (postalCode != null) {
			this.postalCode = postalCode;
		} else {
			postalCode = "";
		}
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.creditLimit = creditLimit;
	}
	
	public Customer(String firstName, String lastName, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, int salesRepEmployeeNumber, double creditLimit) {
		super(firstName, lastName);
		this.customerName = firstName + " " + lastName;
		this.customerNumber = -1;
		if (phone != null) {
			this.phone = phone;
		} else {
			phone = "";
		}
		if (addressLine1 != null) {
			this.addressLine1 = addressLine1;
		} else {
			addressLine1 = "";
		}
		if (addressLine2 != null) {
			this.addressLine2 = addressLine2;
		} else {
			addressLine2 = "";
		}
		if (city != null) {
			this.city = city;
		} else {
			city = "";
		}
		if (state != null) {
			this.state = state;
		}
		else {
			state = "";
		}
		if (country != null) {
			this.country = country;
		} else {
			country = "";
		}
		if (postalCode != null) {
			this.postalCode = postalCode;
		} else {
			postalCode = "";
		}
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.creditLimit = creditLimit;
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
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}

	public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	}

	public double getCreditlimit() {
		return creditLimit;
	}

	public void setCreditlimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	public String toString(){
		if (this.getState().equals("")) state = "N/A";
		if (this.getCity().equals("")) city = "N/A";
		if (this.getCountry().equals("")) country = "N/A";
		if (this.getAddressLine1().equals("")) addressLine1 = "N/A";
		if (this.getAddressLine2().equals("")) addressLine2 = "N/A";
		return "Name: "+ this.getCustomerName() + "\n" +
				"Address: " + this.getAddressLine1() + "\n" +
				"Address2: " + this.getAddressLine2() + "\n" +
				"Postal Code: " + this.getPostalCode() + "\n" +
				"City: " + this.getCity() + "\n" + 
				"State: " + this.getState() + " " + "\n" +
				"Country: "+ this.getCountry() + "\n" +
				"Phone: " + this.getPhone();
	}

	@Override
	public int compareTo(Customer o) {
		int val = 0;
		if ((val = this.getCustomerName().compareTo(o.getCustomerName())) == 0) {
			if ((val = this.getCity().compareTo(o.getCity())) == 0) {
				if ((val = this.getState().compareTo(o.getState())) == 0) {
					if ((val = this.getCountry().compareTo(o.getCountry())) == 0) {
						if ((val = this.getAddressLine1().compareTo(o.getAddressLine1())) == 0) {
							if ((val = this.getAddressLine2().compareTo(o.getAddressLine2())) == 0) {
								val = this.getPhone().compareTo(o.getPhone());
							}
						}
					}
				}
			}
		}
		return val;
	}
}


package finalJavaProject;

public class Office {
	
	private String OfficeCode;
	private String city;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String country;
	private String postalCode;
	private String territory;
	
	public Office(){
		OfficeCode = "";
		city = "";
		phone = "";
		addressLine1 = "";
		addressLine2 = "";
		state = "";
		country = "";
		postalCode = "";
		territory = "";
	}
	
	public Office(String OfficeCode, String city, String phone, String addressLine1, String addressLine2, String state, String country, String postalCode, String territory){
		this.OfficeCode = OfficeCode;
		this.city = city;
		if (Utilities.validatePhone(phone)) this.phone = phone;
		else this.phone = "invalid";
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.country = country;
		if (Utilities.validateCodePostal(postalCode)) this.postalCode = postalCode;
		else this.postalCode = "invalid";
		this.territory = territory;
	}
	
	public Office(String OfficeCode, String city, String phone, String addressLine1, String state, String country, String postalCode, String territory){
		this.OfficeCode = OfficeCode;
		this.city = city;
		if (Utilities.validatePhone(phone)) this.phone = phone;
		else this.phone = "invalid";
		this.addressLine1 = addressLine1;
		this.addressLine2 = "";
		this.state = state;
		this.country = country;
		if (Utilities.validateCodePostal(postalCode)) this.postalCode = postalCode;
		else this.postalCode = "invalid";
		this.territory = territory;
	}
	
	public String getOfficeCode() {
		return OfficeCode;
	}
	
	public void setOfficeCode(String officeCode) {
		OfficeCode = officeCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
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
		this.addressLine1 = addressLine1;
	}
	
	public String getAddressLine2() {
		return addressLine2;
	}
	
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		if (Utilities.validateCodePostal(postalCode)) this.postalCode = postalCode;
		else this.postalCode = "Invalid";
	}
	
	public String getTerritory() {
		return territory;
	}
	
	public void setTerritory(String territory) {
		this.territory = territory;
	}
	
	public String toString(){
		String texto = OfficeCode +"\n" +
				"Phone: " + phone + "\n" +
				addressLine1 + "\n" +
				city + " - " + state + " - " + territory + "\n" + 
				postalCode + " " + country + "\n";
		if (addressLine2 != "") {
			texto = OfficeCode +"\n" +
					"Phone: " + phone + "\n" +
					addressLine1 + "\n" +
					addressLine2 + "\n" +
					state + " - " + territory + "\n" + 
					postalCode + " " + city + " - " + country + "\n";
		} 
		return texto;
	}
}
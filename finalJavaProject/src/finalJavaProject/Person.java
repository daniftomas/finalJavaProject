package finalJavaProject;

public abstract class Person {
	
	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName){
		if (Utilities.validateSize(50, firstName))this.firstName = firstName;
		else this.firstName = "invalid. Too long!";
		if (Utilities.validateSize(50, lastName))this.lastName = lastName;
		else this.lastName = "invalid. Too long!";
	}
	
	public Person(Person p){
		this.firstName = p.getFirstName();
		this.lastName = p.getLastName();
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setLastName(String lastName){
		if (Utilities.validateSize(50, lastName)) this.lastName = lastName;
		else this.lastName = "invalid. Too long!";
	}
	
	public void setFirstName(String firstName){
		if (Utilities.validateSize(50, firstName)) this.firstName = firstName;
		else this.firstName = "invalid. Too long!";
	}
}
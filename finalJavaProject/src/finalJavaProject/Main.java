package finalJavaProject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int choice;

		do {
			// Main menu
			System.out.println("   **BEAUTIFUL MAIN** \n" 
					+ "1-> Register new client \n" 
					+ "2-> Make new order \n"
					+ "3-> View customer list\n" 
					+ "4-> Export list of customer's orders \n"
					+ "5-> Import list of new employees \n" 
					+ "0-> Out!");

			// Read and choose
			do {
				System.out.println("Choose a number.");
				choice = Utilities.readNumber();
				mainOptions(choice);
			} while (choice < 0 || choice > 5);
		} while (choice != 0);

	}

	// choose case from main menu
	public static void mainOptions(int a) {

		switch (a) {

		case 1:
			System.out.println("NEW CLIENT");
			//insertDBCustomer();
			
			break;
		case 2:
			System.out.println("NEW ORDER");
			break;
		case 3:
			System.out.println("cenas3\n");
			//printCustomerList();
			break;
		case 4:
			System.out.println("cenas4\n");
			
			break;
		case 5:
			System.out.println("cenas5\n");
			break;
		case 0:
			System.out.println("You are OUT*\n\n");
			break;

		default:
			System.out.println("Choose a number between 0 and 5.");
			break;
		}

	}

	
	
	//OPTION 1
	
	 public static void insertDBCustomer(){
		 
		 int x;
		 Customer client = new Customer();
		 String fName;
		 String lName;
		 String phone;
		 String adress1;
		 String adress2;
		 String city;
		 String state;
		 String country;
		 String postalCode;
		 int salesRepEmployeeNumber;
		 double creditLimit;
		 
		 
		 // fisrt name
		 System.out.println("Insert Fist Name");
		 do{
		 fName = Utilities.readString();
		  
		 if(fName.length()==0){
			 System.out.println("you may not leave the name in blank.");
		 }
		 if(fName.length()>50){
			 System.out.println("you can olnly use 50char");
		 }
		 }while(fName.length()==0 || fName.length()>50);
		 client.setFirstName(fName);
		
		 
		 // last name
		 System.out.println("Insert Last Name");
		 do{
		 lName = Utilities.readString();
		  
		 if(lName.length()==0){
			 System.out.println("you may not leave the field in blank.");
		 }
		 if(lName.length()>50){
			 System.out.println("you can olnly use 50char");
		 }
		 
		 }while(lName.length()==0 || lName.length()>50);
		 
		 client.setLastName(lName);
		 
		 // phone
		 System.out.println("Insert phone \n");
		 phone = Utilities.insertPhone();
		 client.setPhone(phone);
		 
		 // adressline1
		 
		 System.out.println("Insert adressLine 1");
		 do{
		 adress1 = Utilities.readString();
		 if(adress1.length()==0){
			 System.out.println("you may not leave the field in blank.");
		 }
		 if(adress1.length()>50){
			 System.out.println("you can olnly use 50char");
		 }
		 
		 }while(adress1.length()==0 || adress1.length()>50);
		 client.setAddressLine1(adress1);

		 
		 // adressL2
		 System.out.println("Insert adressLine 2");
		 do{
		 adress2 = Utilities.readString();
		 if(adress2.length()==0){
			 System.out.println("you may not leave the field in blank.");
		 }
		 if(adress2.length()>50){
			 System.out.println("you can olnly use 50char");
		 }
		 
		 }while(adress2.length()==0 || adress2.length()>50);
		 client.setAddressLine2(adress2);
		 
		 // city
		 System.out.println("Insert city");
		 do{
		 city = Utilities.readString();
		 if(city.length()==0){
			 System.out.println("you may not leave the field in blank.");
		 }
		 if(city.length()>50){
			 System.out.println("you can olnly use 50char");
		 }
		 
		 }while(city.length()==0 || city.length()>50);
		 client.setCity(city);
		 
		 // state
		 System.out.println("Insert state");
         do{
		 state = Utilities.readString();
		 if(state.length()==0){
			 System.out.println("you may not leave the field in blank.");
		 }
		 if(state.length()>50){
			 System.out.println("you can olnly use 50char");
		 }
		 
		 }while(state.length()==0 || state.length()>50);
		 client.setState(state);
		 
		 
		 // postalC
		 System.out.println("Insert postal code");
		 postalCode = Utilities.readString();
		 client.setPostalCode(postalCode);
		 
		 // country
		 System.out.println("Insert country");
		 country = Utilities.readString();
		 client.setCountry(country);
		 
		 // sales repEmploeeNumber
		 List<Employee> lu = DataBase.getEmployeesList();
		   String employee;
		   System.out.println("Employees List:\n");
		   for (int i = 0; i < lu.size(); i++) {
		    employee = ""+(i+1);
		    System.out.println(employee+". "+lu.get(i).toString());
		   }
		 do{
		   salesRepEmployeeNumber = Utilities.readNumber();
		   if(salesRepEmployeeNumber> lu.size()){
			   System.out.println("There are only " + lu.size() + " employees.");
		   }
		   
		 }while(salesRepEmployeeNumber> lu.size());
	 
		 
		 // creditLim	 
		 System.out.println("Insert Credit limit");
		 creditLimit = Utilities.readDouble();
		 client.setCreditlimit(creditLimit);
		 
		 //insert on data base
		 x= DataBase.insertCustomer(client);
		 
		 if (x==0){
			 System.out.println("Client already exists \n");
		 }
		 if (x==-1){
			 System.out.println("There was a problem with the connection\n");
		 }
		 else{
			 System.out.println("Client created successfully\n");
		 }
		 
	 }
	 
	 //OPTION 2
	 public static void insertNewOrder(){
		 
		 boolean validInsert;
		 Customer cust = new Customer();
		 LocalDate date;
		 LocalDate requiredDate;
		 LocalDate shippedDate;
		 Order.Status status;
		 String comments;
		 Product produto;
		 int quantidade;
		 double preco;
		 int orderLineNumber;
		 
		 
		 
		 
		 
		 
		 
		 //validInsert = DataBase.insertOrder(cust, date, requiredDate,
		 //			shippedDate, status,comments,produto, quantidade,
	     //		preco,orderLineNumber);
		 
		 
		 
		 
		 
	 }
	 
	 
	 //OPTION 3
	 public static void printCustomerList(){
		 
		 List<Customer> l = DataBase.getCustomerList();
		   String cust;
		   System.out.println("Customer's List:\n");
		   for (int i = 0; i < l.size(); i++) {
		    cust = ""+(i+1);
		    System.out.println(cust+". "+l.get(i).toString());
		   }
		 
	 }
	 
	 
	 
	 
	 //OPTION 4
	 public static void exportCustomerOrderList(){
		 
		 Customer cliente = new Customer();
		 
		 
	 }
	 
	 public static void importListEmployees(){
		 
		 
	 }
	 

}

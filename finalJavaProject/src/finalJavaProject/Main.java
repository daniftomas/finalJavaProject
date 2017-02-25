package finalJavaProject;

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
					+ "4-> Print list of customer orders \n"
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
			System.out.println("Insert client\n");
			insertDBCustomer();
			
			break;
		case 2:
			System.out.println("cenas2\n");
			break;
		case 3:
			System.out.println("cenas3\n");
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
		 System.out.println("Insert Firt Name \n");
		 do{
		 fName = Utilities.readString();
		  
		 if(fName.length()==0){
			 System.out.println("you may not leave the name in blank.");
		 }
		 if(fName.length()>50){
			 System.out.println("you can olnly use 50char");
		 }
		 
		 }while(fName.length()==0 || fName.length()>50);
		 
		 		 
		 // last name
		 System.out.println("Insert Last Name Name \n");
		 do{
		 fName = Utilities.readString();
		  
		 if(fName.length()==0){
			 System.out.println("you may not leave the name in blank.");
		 }
		 if(fName.length()>50){
			 System.out.println("you can olnly use 50char");
		 }
		 
		 }while(fName.length()==0 || fName.length()>50);
		 
		 
		 // phone
		 System.out.println("Insert phone \n");
		 phone = Utilities.insertPhone();
		 
		 // adressline1
		 
		 System.out.println("Insert adressLine 1");
		 adress1 = Utilities.readString();
		 
		 // adressL2
		 System.out.println("Insert adressLine 2");
		 adress2 = Utilities.readString();
		 
		 // city
		 System.out.println("Insert city");
		 city = Utilities.readString();
		 // state
		 System.out.println("Insert state");
		 state = Utilities.readString();
		 // postalC
		 System.out.println("Insert postal code");
		 postalCode = Utilities.readString();
		 // country
		 System.out.println("Insert country");
		 country = Utilities.readString();
		 // sales repEmploeeNumber
		 
		 
		 // creditLim	 
		 System.out.println("Insert Credit limit");
		 creditLimit = Utilities.readDouble();
		 
		 
		 /*
		 
		 x= DataBase.insertCustomer(client);
		 
		 if (x==0){
			 System.out.println("Client already exists");
		 }
		 if (x==-1){
			 System.out.println("There was a problem with the connection");
		 }
		 else{
			 System.out.println("Client created successfully");
		 }
		 */
	 }
	 
	

}

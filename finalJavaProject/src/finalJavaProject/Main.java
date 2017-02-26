package finalJavaProject;


import java.awt.Desktop;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
			insertDBCustomer();
			
			break;
		case 2:
			insertNewOrder();
			break;
		case 3:
			printCustomerList();
			break;
		case 4:
			exportClientsListToTXT();
			break;
		case 5:
			importClientsFromBinaryDocument();
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
		 adress1 = Utilities.insertAdressLine();
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
		 adress2 = Utilities.insertAdressLine();
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
		 postalCode = Utilities.insertPostalCode();
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
	 
		 client.setSalesRepEmployeeNumber(lu.get(salesRepEmployeeNumber-1).getEmployeeNumber());
		 
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
		 
		 //choose client
		 do{
		 cust = pickCustomer();
		 if(cust==null){
			 System.out.println("customer not valid.");
		 }
		 }while(cust==null);
		 
		 System.out.println(cust);
		 
		 //today date
		 date = LocalDate.now();
		 
		 //required date
		 requiredDate = Utilities.insertLD();
		 
		 //shipped date
		 shippedDate = Utilities.insertLD();
		
		 //status
		 status = Order.Status.waiting;
		 
		 //
		 comments = Utilities.readString();
		 
		 //choose products
		 
		 
		 
		 //validInsert = DataBase.insertOrder(cust, date, requiredDate,
		 //			shippedDate, status,comments,produto, quantidade,
	     //		preco,orderLineNumber);
		 
		 
		 
		 
		 
	 }
	 
	 
	 public static Customer pickCustomer(){
			String vv = "";
			System.out.println();
			System.out.println("Choose one of this options:\n (s)-search\n (l)-list customers \n (x)-to exit.");
			vv = Utilities.readString();
			if (vv.equals("x")) {
				System.out.println();
				return null;
			} else if (vv.equals("l")) {
				List<Customer> l = DataBase.getCustomerList();
				String cust;
				System.out.println("******* Customer's List ******* \n");
				for (int i = 0; i < l.size(); i++) {
					cust = "" + (i + 1);
					System.out.println(cust + ". " + l.get(i).toString());
				}
				System.out.print("Choose a client (number): (x) to exit ");
				boolean passou = false;
				int b = 0;
				String g = "";
				do {
					if (passou) {
						System.out.print("Invalid number, choose another: (x) to exit ");
					}
					g = Utilities.readString();
					if (g.equals("x")) {
						System.out.println();
						return null;
					}
					try 
						{
						b = Integer.parseInt(g);
					} catch (NumberFormatException e) {}
				} while ((b <= 0)||(b > l.size()));
				return l.get(b-1);
			} else {
				System.out.print("Write is phone or is addressLine: (x) to exit ");
				boolean passou = false;
				String valor = "";
				do {
					if (passou) {
						System.out.print("Wrong phone or addressLine, write again: (x) to exit ");
					}
					valor = Utilities.readString();
					passou = true;
					if (Utilities.validateEmail(valor)) {
						System.out.println();
						return DataBase.getCustomer("", valor);
					} else if (Utilities.validatePhone(valor)){
						System.out.println();
						return DataBase.getCustomer(valor, "");
					}	 
				} while (!valor.equals("x"));
			}
			return null;
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
	 
	 
	 
	// OPTION 4

		public static void exportClientsListToTXT() {
			FileIO.exportToFile(DataBase.getCustomerList());
			try {
				Desktop.getDesktop().open(new java.io.File(FileIO.CUSTOMERSTXT));
			} catch (IOException e) {
				System.out.println(
						"Sorry, there was an error while openning the document! Please, check the success in the creation of it.");
				e.printStackTrace();
			}
		}

		
		
		
		//option 5
		public static void importClientsFromBinaryDocument() {
			String x = "y";
			System.out.print("Do you need to create customers first? (y/n/x to e(x)it)\n");
			x = Utilities.readString();
			if ((x.equals("x"))||(x.equals("X"))) return;
			List<Customer> customers = new ArrayList<>();
			if ((x.equals("y")) || (x.equals("Y"))) {
				do {
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
					System.out.println("************ Customer creation **************\n");
					// fisrt name
					System.out.print("Insert Fist Name: ");
					do {
						fName = Utilities.readString();
						if (fName.length() == 0) {
							System.out.println("you may not leave the name in blank.");
						}
						if (fName.length() > 50) {
							System.out.println("you can olnly use 50 char");
						}
					} while (fName.length() == 0 || fName.length() > 50);
					client.setFirstName(fName);
					// last name
					System.out.print("Insert Last Name: ");
					do {
						lName = Utilities.readString();
						if (lName.length() == 0) {
							System.out.print("you may not leave the field in blank. Insert last Name: ");
						}
						if (lName.length() > 50) {
							System.out.print("you can only use 50 char. Insert last Name:");
						}

					} while (lName.length() == 0 || lName.length() > 50);

					client.setLastName(lName);
					// phone
					System.out.print("Insert phone: ");
					phone = Utilities.insertPhone();
					client.setPhone(phone);

					// adressline1
					System.out.print("Insert adressLine 1: ");
					do {
						adress1 = Utilities.readString();
						if (adress1.length() == 0) {
							System.out.print("you may not leave the field in blank. Insert addressLine 1: ");
						}
						if (adress1.length() > 50) {
							System.out.print("you can olnly use 50 char. Insert addressLine 2: ");
						}

					} while (adress1.length() == 0 || adress1.length() > 50);
					client.setAddressLine1(adress1);
					// adressLine2
					System.out.print("Insert adressLine 2: ");
					do {
						adress2 = Utilities.readString();
						if (adress2.length() == 0) {
							System.out.print("you may not leave the field in blank. Insert addressLine 2: ");
						}
						if (adress2.length() > 50) {
							System.out.print("you can olnly use 50 char. Insert addressLine 2: ");
						}

					} while (adress2.length() == 0 || adress2.length() > 50);
					client.setAddressLine2(adress2);
					// city5
					System.out.print("Insert city: ");
					do {
						city = Utilities.readString();
						if (city.length() == 0) {
							System.out.print("you may not leave the field in blank. Insert city: ");
						}
						if (city.length() > 50) {
							System.out.print("you can olnly use 50 char. Insert city: ");
						}

					} while (city.length() == 0 || city.length() > 50);
					client.setCity(city);
					// state
					System.out.print("Insert state: ");
					do {
						state = Utilities.readString();
						if (state.length() == 0) {
							System.out.print("you may not leave the field in blank. Insert state: ");
						}
						if (state.length() > 50) {
							System.out.print("you can olnly use 50 char. Insert state: ");
						}

					} while (state.length() == 0 || state.length() > 50);
					client.setState(state);
					// postalCode
					System.out.print("Insert postal code: ");
					boolean passou = false;
					do {
						if (passou) {
							System.out.print("Bad postal code, insert again: ");
							passou = true;
						}
						postalCode = Utilities.readString();
					} while (!Utilities.validateCodePostal(postalCode));
					client.setPostalCode(postalCode);
					// country
					System.out.print("Insert country: ");
					country = Utilities.readString();
					client.setCountry(country);
					// salesrepEmploeeNumber
					List<Employee> lu = DataBase.getEmployeesList();
					String employee;
					System.out.println("\n******* Employees List *******\n");
					for (int i = 0; i < lu.size(); i++) {
						employee = "" + (i + 1);
						System.out.println(employee + ". " + lu.get(i).toString());
					}
					System.out.print("Select the responsible Employeer (number): ");
					do {
						salesRepEmployeeNumber = Utilities.readNumber();
						if (salesRepEmployeeNumber > lu.size()) {
							System.out.println("There are only " + lu.size() + " employees.");
						}

					} while (salesRepEmployeeNumber > lu.size());
					client.setSalesRepEmployeeNumber(salesRepEmployeeNumber - 1);
					// creditLimit
					System.out.print("Insert Credit limit: ");
					creditLimit = Utilities.readDouble();
					client.setCreditlimit(creditLimit);
					customers.add(client);
					System.out.print("Do you want to add another customer?? (Y/N)");
					x = Utilities.readString();
				} while ((x.equals("y")) || (x.equals('Y')));
				if (!customers.isEmpty()) {
					FileIO.exportCustomersBinary(customers);
					java.io.File fil = new java.io.File(FileIO.BINARYFILEFINAL);
					if (fil.isFile()) {
						List<Customer> ll = FileIO.importCustomersBinary();
						if (ll.isEmpty()) {
							System.out.println("Something went wrong!! The list of customers is empty. Try another file!! Press Enter");
							Utilities.readString();
						} else if (DataBase.insertCustomersList(ll)) {
							System.out.println("Action successfull! The Customer(s) was(were) created!! Press Enter");
							Utilities.readString();
						} else {
							System.out.println("An error happened! Try again. Press Enter");
							Utilities.readString();
						}
					} else {
						System.out.println("An error happened! Try again. Press Enter");
						Utilities.readString();
					}
				}
			} else {
				java.io.File fil;
				System.out.println("Please, give me the path of the binary file! (x to e(x)it)");
				boolean entrou = false;
				do {
					if (entrou) System.out.println("Please, give me the \"true\" path of the binary file! (x to e(x)it)");
					entrou = true;
					FileIO.BINARYFILE = Utilities.readString();
					fil = new java.io.File(FileIO.BINARYFILE);
					if (fil.isFile()) {
						List<Customer> ll = FileIO.importCustomersBinary();
						if (ll.isEmpty()) {
							System.out.println("Something went wrong!! The list of customers is empty. Try another file!! Press Enter");
							Utilities.readString();
						} else if (DataBase.insertCustomersList(ll)) {
							System.out.println("Action successfull! Press Enter." );
							Utilities.readString();
						} else {
							System.out.println("An error happened! Try again. Press Enter");
							Utilities.readString();
						}
					}
					if ((x.equals("x"))||(x.equals("X"))) break;
				} while (!fil.isFile());
			}
		}
	 

}

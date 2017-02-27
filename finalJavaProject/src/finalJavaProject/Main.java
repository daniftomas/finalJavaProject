package finalJavaProject;

import java.awt.Desktop;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int choice;
		do {
			// Main menu
			System.out.println("   *****BEAUTIFUL MAIN***** \n" + "1-> Register new client \n" + "2-> Make new order \n"
					+ "3-> View customer list\n" + "4-> Export list of customer's orders \n"
					+ "5-> Import list of new employees \n" + "0-> Out!");
			// Read and choose
			do {
				System.out.print("Choose a number: ");
				choice = Utilities.readNumber();
				System.out.println();
				mainOptions(choice);
				
			} while (choice < 0 || choice > 5);
		} while (choice != 0);

	}

	// choose case from main menu
	public static void mainOptions(int a) {

		switch (a) {
		case 1:
			System.out.print("******* NEW CLIENT ******* \n");
			insertDBCustomer();
			break;
		case 2:
			makeOrder();
			break;
		case 3:
			exportClientsListToTXT();
			break;
		case 4:
			System.out.println("******* Printing orders *******");
			Main.printCustomerList();
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

	// OPTION 1

	public static void insertDBCustomer() {
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

		// first name
		System.out.println("Insert Fist Name");
		do {
			fName = Utilities.readString();

			if (fName.length() == 0) {
				System.out.println("you may not leave the name in blank.");
			}
			if (fName.length() > 50) {
				System.out.println("you can olnly use 50char");
			}
		} while (fName.length() == 0 || fName.length() > 50);
		client.setFirstName(fName);

		// last name
		System.out.println("Insert Last Name");
		do {
			lName = Utilities.readString();

			if (lName.length() == 0) {
				System.out.println("you may not leave the field in blank.");
			}
			if (lName.length() > 50) {
				System.out.println("you can olnly use 50char");
			}

		} while (lName.length() == 0 || lName.length() > 50);

		client.setLastName(lName);

		// phone
		System.out.println("Insert phone \n");
	
		phone = Utilities.insertPhone();
	
		client.setPhone(phone);

		// adressline1

		System.out.println("Insert adressLine 1");
		do {
			adress1 = Utilities.insertAdressLine();
			
			if (adress1.length() > 50) {
				System.out.println("you can olnly use 50char");
			}

		} while (adress1.length() > 50);
		client.setAddressLine1(adress1);

		// adressL2
		System.out.println("Insert adressLine 2");
		do {
			adress2 = Utilities.insertAdressLine();
			
			if (adress2.length() > 50) {
				System.out.println("you can olnly use 50char");
			}
		} while ( adress2.length() > 50);
		client.setAddressLine2(adress2);

		// city
		System.out.println("Insert city");
		do {
			city = Utilities.readString();
			if (city.length() == 0) {
				System.out.println("you may not leave the field in blank.");
			}
			if (city.length() > 50) {
				System.out.println("you can olnly use 50char");
			}

		} while (city.length() == 0 || city.length() > 50);
		client.setCity(city);

		// state
		System.out.println("Insert state");
		do {
			state = Utilities.readString();
			if (state.length() == 0) {
				System.out.println("you may not leave the field in blank.");
			}
			if (state.length() > 50) {
				System.out.println("you can olnly use 50char");
			}

		} while (state.length() == 0 || state.length() > 50);
		client.setState(state);

		// postalCode
		System.out.println("Insert postal code: ");
		do {
			postalCode = Utilities.insertPostalCode();
			if (postalCode.length() == 0) {
				System.out.println("you may not leave the field in blank.");
			}
		} while (postalCode.length()>50 || postalCode.length()==0);
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
			employee = "" + (i + 1);
			System.out.println(employee + ". " + lu.get(i).toString());
		}
		do {
			salesRepEmployeeNumber = Utilities.readNumber();
			if (salesRepEmployeeNumber > lu.size()) {
				System.out.println("There are only " + lu.size() + " employees.");
			}
		} while (salesRepEmployeeNumber > lu.size());
		client.setSalesRepEmployeeNumber(lu.get(salesRepEmployeeNumber - 1).getEmployeeNumber());
		// creditLim
		System.out.println("Insert Credit limit");
		creditLimit = Utilities.readDouble();
		client.setCreditlimit(creditLimit);

		// insert on data base
		x = DataBase.insertCustomer(client);

		if (x == 0) {
			System.out.println("Client already exists \n");
		}
		if (x == -1) {
			System.out.println("There was a problem with the connection\n");
		} else {
			System.out.println("Client created successfully\n");
		}
	}
	
	//Option 2
	public static void makeOrder(){
		System.out.println("\n************ Customer creation **************");
		System.out.print("\nPlease, pick a customer.");
		Customer custom = pickCustomer();
		if (custom == null) {
			return;
		} else {
			System.out.print("Chosen client: "+custom.getCustomerName()+"\n\n");
		}
		System.out.print("Please, pick a product.");
		Product product = pickProduct();
		if (product == null) {
			return;
		} else {
			System.out.print("Chosen product: "+product.getProductDescription()+"\n\n");
		}
		System.out.print("Please, pick a date.\n");
		LocalDate date = Utilities.insertLD();
		System.out.print("Limit days to be deliver: ");
		int b = -1;
		do {
			b = Utilities.readNumber();
		} while (b < 0);
		LocalDate requiredDate = date.plusDays(b);
		System.out.print("Any comments: ");
		String comments = Utilities.readString();
		System.out.print("Quantity: ");
		int quantidade = 0;
		do {
			quantidade = Utilities.readNumber();
		} while (quantidade <= 0);
		double preco = -1.0;
		System.out.print("Price: ");
		do {
			preco = Utilities.readDouble();
		} while (preco < 0.0);
		int orderLineNumber = 0;
		System.out.print("Order Line Number: ");
		do {
			orderLineNumber = Utilities.readNumber();
		} while (orderLineNumber <= 0);
		Order.Status st = Order.Status.inProgress;
		if(DataBase.insertOrder(custom, date, requiredDate, requiredDate, st, comments, product, quantidade, preco, orderLineNumber)){
			System.out.println("\nThe order was created!! Press Enter");
			Utilities.readString();
		} else {
			System.out.println("\nSomething bad occurred!! Press Enter");
			Utilities.readString();
		}
	}
	
	

	private static Customer pickCustomer() {
		String vv = "";
		System.out.println();
		System.out.print("Choose one of this options: \n (s) search \n (l)ist customers. \n (x) to exit.");
		
		do{
		vv = Utilities.readString();
		if (vv.equals("x")) {
			System.out.println();
			return null;
		} else if (vv.equals("l")) {
			List<Customer> l = DataBase.getCustomerList();
			String cust;
			System.out.println("\n******* Customer's List ******* \n");
			for (int i = 0; i < l.size(); i++) {
				cust = "" + (i + 1);
				System.out.println(cust + ". " + l.get(i).toString());
			}
			String g = "";
			boolean passou = false;
			int b = 0;
			System.out.print("Choose a client (number): (x) to exit ");
			do {
				g = Utilities.readString();
				if (g.equals("x")) {
					System.out.println();
					return null;
				}
				try {
					b = Integer.parseInt(g);
					if (b > l.size())passou = true;
				} catch (NumberFormatException e) {
					passou = true;
				} finally {
					if (passou)System.out.print("Invalid number, choose another: (x) to exit ");
					passou = false;
				}
			} while ((b <= 0) || (b > l.size()));
			System.out.println();
			return l.get(b - 1);
		} else if (vv.equals("s")) {
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
				} else if (Utilities.validatePhone(valor)) {
					System.out.println();
					return DataBase.getCustomer(valor, "");
				}
			} while (!valor.equals("x"));
		
			System.out.print("");
		}
		else{
			System.out.println("Not valid option.");
		}
		}while(!vv.equals("x") ||!vv.equals("s") ||!vv.equals("l"));
		return null;
	}

	private static Product pickProduct() {
		String vv = "";
		System.out.println();
		System.out.print("Choose one of this options: \n (s) search \n (l)list products \n (x) to exit.");
		do{
		vv = Utilities.readString();
		if (vv.equals("x")) {
			System.out.println();
			return null;
		} else if (vv.equals("l")) {
			List<Product> l = DataBase.getProductsList();
			String prod;
			System.out.println("\n******* Product's List ******* \n");
			for (int i = 0; i < l.size(); i++) {
				prod = "" + (i + 1);
				System.out.println(prod + ". " + l.get(i).toString());
			}
			int b = 0;
			String g = "";
			boolean passou = false;
			System.out.println("Choose a product (number): (x) to exit ");
			do {
				g = Utilities.readString();
				if (g.equals("x")) {
					System.out.println();
					return null;
				}
				try {
					b = Integer.parseInt(g);
					if (b > l.size())passou = true;
				} catch (NumberFormatException e) {
					passou = true;
				} finally {
					if (passou)System.out.print("Invalid number, choose another: (x) to exit ");
					passou = false;
				}
			} while ((b <= 0) || (b > l.size()));
			System.out.println();
			return l.get(b - 1);
		} else if (vv.equals("s")){
			System.out.print("Write is Code value: (x) to exit ");
			String valor = "";
			valor = Utilities.readString();
			if (valor.equals("x")) {
				if (Utilities.validateEmail(valor)) {
					System.out.println();
					return DataBase.getProduct(valor);
				} else if (Utilities.validatePhone(valor)) {
					System.out.println();
					return DataBase.getProduct(valor);
				}
			}
			System.out.print("");
		}
		else{
			System.out.println("Not valid option");
		}
		}while(!vv.equals("x") ||!vv.equals("s") ||!vv.equals("l"));
		return null;
	}
	
	//option 3
		public static void exportClientsListToTXT() {
			FileIO.exportToFile(DataBase.getCustomerList());
			try {
				Desktop.getDesktop().open(new java.io.File(FileIO.CUSTOMERSTXT));
			} catch (IOException e) {
				System.out.println(
						"Sorry, there was an error while openning the document! Please, check the success in the creation of it.");
			}
		}
	
	// OPTION 4
	public static void printCustomerList() {
		Customer custom = pickCustomer();
		if (custom != null) {
			FileIO.exportOrdersCustomer(custom);
			try {
				Desktop.getDesktop().open(new java.io.File(FileIO.ORDERSTXT));
			} catch (IOException e) {
				System.out.println(
						"Sorry, there was an error while openning the document! Please, check the success in the creation of it. Press Enter.");
				Utilities.readString();
			}
		}
	}
	
	// OPTION 4
	public static void printOnScreenCustomersList() {
		List<Customer> l = DataBase.getCustomerList();
		String cust;
		System.out.println("\n******* Customer's List ******* \n");
		for (int i = 0; i < l.size(); i++) {
			cust = "" + (i + 1);
			System.out.println(cust + ". " + l.get(i).toString());
		}
	}

	
	//option 5

		public static void importClientsFromBinaryDocument() {
			String x = "y";
			System.out.print("Do you need to create customers first? \n (y)yes \n(n)no \n (x) to e(x)it) ");
			x = Utilities.readString();
			if ((x.equals("x")) || (x.equals("X"))) {
				System.out.println();
				return;
			}
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

					// first name
					System.out.println("Insert Fist Name");
					do {
						fName = Utilities.readString();

						if (fName.length() == 0) {
							System.out.println("you may not leave the name in blank.");
						}
						if (fName.length() > 50) {
							System.out.println("you can olnly use 50char");
						}
					} while (fName.length() == 0 || fName.length() > 50);
					client.setFirstName(fName);

					// last name
					System.out.println("Insert Last Name");
					do {
						lName = Utilities.readString();

						if (lName.length() == 0) {
							System.out.println("you may not leave the field in blank.");
						}
						if (lName.length() > 50) {
							System.out.println("you can olnly use 50char");
						}

					} while (lName.length() == 0 || lName.length() > 50);

					client.setLastName(lName);

					// phone
					System.out.println("Insert phone \n");
				
					phone = Utilities.insertPhone();
				
					client.setPhone(phone);

					// adressline1

					System.out.println("Insert adressLine 1");
					do {
						adress1 = Utilities.insertAdressLine();
						
						if (adress1.length() > 50) {
							System.out.println("you can olnly use 50char");
						}

					} while (adress1.length() > 50);
					client.setAddressLine1(adress1);

					// adressL2
					System.out.println("Insert adressLine 2");
					do {
						adress2 = Utilities.insertAdressLine();
						
						if (adress2.length() > 50) {
							System.out.println("you can olnly use 50char");
						}
					} while ( adress2.length() > 50);
					client.setAddressLine2(adress2);

					// city
					System.out.println("Insert city");
					do {
						city = Utilities.readString();
						if (city.length() == 0) {
							System.out.println("you may not leave the field in blank.");
						}
						if (city.length() > 50) {
							System.out.println("you can olnly use 50char");
						}

					} while (city.length() == 0 || city.length() > 50);
					client.setCity(city);

					// state
					System.out.println("Insert state");
					do {
						state = Utilities.readString();
						if (state.length() == 0) {
							System.out.println("you may not leave the field in blank.");
						}
						if (state.length() > 50) {
							System.out.println("you can olnly use 50char");
						}

					} while (state.length() == 0 || state.length() > 50);
					client.setState(state);

					// postalCode
					System.out.println("Insert postal code: ");
					do {
						postalCode = Utilities.insertPostalCode();
						if (postalCode.length() == 0) {
							System.out.println("you may not leave the field in blank.");
						}
					} while (postalCode.length()>50 || postalCode.length()==0);
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
						employee = "" + (i + 1);
						System.out.println(employee + ". " + lu.get(i).toString());
					}
					do {
						salesRepEmployeeNumber = Utilities.readNumber();
						if (salesRepEmployeeNumber > lu.size()) {
							System.out.println("There are only " + lu.size() + " employees.");
						}
					} while (salesRepEmployeeNumber > lu.size());
					client.setSalesRepEmployeeNumber(lu.get(salesRepEmployeeNumber - 1).getEmployeeNumber());
					// creditLim
					System.out.println("Insert Credit limit");
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
							System.out.println(
									"Something went wrong!! The list of customers is empty. Try another file!! Press Enter.");
							Utilities.readString();
						} else if (DataBase.insertCustomersList(ll)) {
							System.out.println("Action successfull! The Customer(s) was(were) created!! Press Enter.");
							Utilities.readString();
						} else {
							System.out.println("An error happened! Try again. Press Enter.");
							Utilities.readString();
						}
					} else {
						System.out.println("An error happened! Try again. Press Enter.");
						Utilities.readString();
					}
				}
			} else {
				java.io.File fil;
				System.out.print("Please, give me the path of the binary file! (x to e(x)it) ");
				boolean entrou = false;
				do {
					if (entrou)
						System.out.print("Please, give me the \"true\" path of the binary file! (x to e(x)it) ");
					entrou = true;
					FileIO.BINARYFILE = Utilities.readString();
					fil = new java.io.File(FileIO.BINARYFILE);
					if (fil.isFile()) {
						List<Customer> ll = FileIO.importCustomersBinary();
						if (ll.isEmpty()) {
							System.out.println(
									"Something went wrong!! The list of customers is empty. Try another file!! Press Enter. ");
							Utilities.readString();
						} else if (DataBase.insertCustomersList(ll)) {
							System.out.println("Action successfull! Press Enter. ");
							Utilities.readString();
						} else {
							System.out.println("An error happened! Try again. Press Enter. ");
							Utilities.readString();
						}
					}
					if ((FileIO.BINARYFILE.equals("x")) || (FileIO.BINARYFILE.equals("X"))) {
						System.out.println();
						FileIO.BINARYFILE = FileIO.BINARYFILEFINAL;
						return;
					}
				} while (!fil.isFile());
			}
		}

		
	
	public static void clearScreen() {
		String sistema = System.getProperty("os.name");
		if (sistema.indexOf("win") >= 0) {
			try {
				Runtime.getRuntime().exec("cls");
			} catch (IOException e) {
			}
		} else if (sistema.indexOf("mac") >= 0) {
			try {
				Runtime.getRuntime().exec("clear");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (sistema.indexOf("nix") >= 0 || sistema.indexOf("nux") >= 0 || sistema.indexOf("aix") > 0) {
			String ANSI_CLS = "\u001b[2J";
			String ANSI_HOME = "\u001b[H";
			System.out.print(ANSI_CLS + ANSI_HOME);
			System.out.flush();
		}
	}
	
	
}

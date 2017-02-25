package finalJavaProject;

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
			System.out.println("Insert client:\n");

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
			System.out.println("You are OUT*\n");
			break;

		default:
			System.out.println("Choose a number between 0 and 5.");
			break;
		}

	}

	
	/*
	 public Customer insertCustomer(){
		 
		 Customer client = new Customer();
		 
		 return 
	 }
	 
	 */

}

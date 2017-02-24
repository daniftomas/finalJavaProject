package finalJavaProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		//Main menu
		System.out.println("BEAUTIFUL MAIN \n"
				+ "1-> Register new client \n"
				+ "2-> Make new order \n"
				+ "3-> View customer list\n"
				+ "4-> Print list of customer orders \n"
				+ "5-> Import list of new employees \n");
		
		//Read and choose
		int choice;
		do{
			System.out.println("vamos ler um num");
		choice = Utilities.readNumber();
		mainMenu(choice);
	
		if (choice<1 || choice>5){
			System.out.println("Choose a number between 1 and 5.");
		}
		}while(choice<1 || choice>5);
		
		
	}
	

	//choose case from main menu
	public static void mainMenu(int a) {

		
		switch (a) {
		case 1:
			System.out.println("cenas1");
			break;
		case 2:
			System.out.println("cenas2");
			break;
		case 3:
			System.out.println("cenas3");
			break;
		case 4:
			System.out.println("cenas4");
			break;
		case 5:
			System.out.println("cenas5");
			break;
			
		default:
			System.out.println("escolhe outro pá");
			break;
		}

	}
	
	

}

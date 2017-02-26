package finalJavaProject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Utilities {
	
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	//validar tamanho dos varchar
	public static boolean validateSize(int limite, String texto){
		return (texto.length() <= limite);
	}
	
	//validar num telemovel
	public static boolean validatePhone(String phone){
		phone = phone.replace(" ", "");
		return (phone.matches("^(([+]?(\\d{3}))|(([+]?[(](\\d{3})[)])))?[- .]?((\\d\\d{2}[. -]?\\d{6})|(\\d\\d{2}[. -]?\\d{3}[. -]?\\d{3})|(9[1236]\\d{7})|(9[1236][. -]?\\d{3}[. -]?\\d{4})|(9[1236][. -]?\\d{4}[. -]?\\d{3})|(9[1236][. -]?\\d{3}[. -]?\\d{2}[. -]?\\d{2}))"));
	}
	
	//valid mail
	public static boolean validateEmail(String email){
		return (email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$"));
	}
	
	//valid cod postal
	public static boolean validateCodePostal(String codePostal){
		return (codePostal.matches("\\d*(([\\-])?\\d*)?"));
	}
	
	// read positive number from pad
	public static int readNumber() {

		Scanner a;
		int x = 0;
		boolean badN=true;
		
		do {
			a = new Scanner(System.in);
			if (!a.hasNextInt()) {
				System.out.println("Choose a positive number.");
				
			} else {
				x = Integer.parseInt(a.nextLine());
				if (x < 0) {
					System.out.println("Positive numbers only.");
				}
				else{
					badN=false;
				}
			}

		} while ( x < 0 || badN);

		return x;
	}
	
	public static String readString(){
		String st ="";
		Scanner a;
		
		a = new Scanner(System.in);
		st = a.nextLine();	
		return st;
		
	}
	
	public static int readDouble() {

		Scanner a;
		int x = 0;
		boolean badN=true;
		
		do {
			a = new Scanner(System.in);
			if (!a.hasNextDouble()) {
				System.out.println("Choose a positive number.");
				
			} else {
				x = Integer.parseInt(a.nextLine());
				if (x < 0) {
					System.out.println("Positive numbers only.");
				}
				else{
					badN=false;
				}
			}

		} while ( x < 0 || badN);

		return x;
	}
	
public static String insertPhone(){
		
		boolean x=false;
		String phone;
		
		do{
		phone = readString();
		x=validatePhone(phone);
		if(!x){
			System.out.println("phone number not valid");
		}
		
		}while(!x);
		
		return phone;
	}

	public static String insertPostalCode() {

		boolean x = false;
		String postalCode;

		do {
			postalCode = readString();
			x = validateCodePostal(postalCode);
			if (!x) {
				System.out.println("postal code number not valid");
			}

		} while (!x);

		return postalCode;
	}
	
	
public static LocalDate insertLD(){
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate time = LocalDate.now();

	System.out.println(time.format(format));

	Scanner year = new Scanner(System.in);
	Scanner month = new Scanner(System.in);
	Scanner day = new Scanner(System.in);
	String y = year.nextLine();
	String m = month.nextLine();
	if (m.length() == 1) {
		m = "0" + m;
	}
	String d = day.nextLine();
	if (d.length() == 1) {
		d = "0" + d;
	}
	String temp = y + "/" + m + "/" + d;
	System.out.println(temp);

		LocalDate tempo = LocalDate.parse(temp, format);
		System.out.println(tempo);
	
	return tempo;
}

public static String insertAdressLine(){
	
	boolean x = false;
	String adress;

	do {
		adress = readString();
		x = validateEmail(adress);
		if (!x) {
			System.out.println("adressline number not valid");
		}

	} while (!x);

	return adress;
	
}
	
	
}
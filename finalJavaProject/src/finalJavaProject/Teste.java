package finalJavaProject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import finalJavaProject.Order.Status;

public class Teste {

	public static void main(String[] args) {
		List<Office> lista = DataBase.getOfficeList();
		
		System.out.println(lista.size());
		for (Office office : lista) {
			System.out.println(office.toString());
		}
		Office of = DataBase.getOffice("o1");
		System.out.println(of.getTerritory());
		Scanner scan = new Scanner(System.in);
		int x = 0;
		do {
			x = scan.nextInt();
		} while(x < 0);
		List<Customer> cust = DataBase.getCustomerList();
		cust = new ArrayList<>(cust);
		System.out.println(FileIO.exportToFile(cust));
		List<Order> orders = DataBase.getOrders(cust.get(0));
		FileIO.exportOrdersCustomer(cust.get(0));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH");
		LocalDateTime dd = LocalDateTime.now();
		String sd = dtf.format(dd);
		System.out.println(sd);
		System.out.println(FileIO.exportCustomersBinary(cust));
		List<Customer> ll = FileIO.importCustomersBinary(FileIO.BINARYFILE);
		System.out.println(ll.get(1));
		Customer c = new Customer("Maria","Albertina","456789987","Rua Latino 45","Travessa Bernardino Machado", "Coimbra", "Beira Litoral", "3456-456","Portugal",-1,23.89);
		DataBase.insertCustomer(c);
		DataBase.insertCustomersByBinaryFile(FileIO.BINARYFILE);
		LocalDateTime tim = LocalDateTime.now();
		LocalDateTime tim2 = LocalDateTime.of(2017, 02, 27, 11, 30);
		LocalDateTime tim3 = LocalDateTime.of(2017, 02, 27, 11, 30);
		
		Product produto = new Product("prod123","Toshiba R700","line1","scal2", "vendor3", "qq coisa", 23,702.45,1.56);
		DataBase.insertProduct(produto);
		Order.Status st = Status.inProgress;
		DataBase.insertOrder(cust.get(0), tim, tim2, tim3, st, "qq coisa", produto, 23, 2.3, 2);
		
	}

}

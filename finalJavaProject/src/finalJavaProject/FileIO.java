package finalJavaProject;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
	public static final String BINARYFILEFINAL = "customersBin.bin";
	public static String BINARYFILE = "customersBin.bin";
	public static String CUSTOMERSTXT = "customersList.txt";
	public static String ORDERSTXT = "orders.txt";
 
	public static boolean exportToFile(List<Customer> clientes) {
		BufferedWriter outputStream = null;
		try {
			outputStream = new BufferedWriter(new FileWriter(CUSTOMERSTXT));
			outputStream.write("Customer's List:\n\n");
			for (Customer cliente : clientes) {
				outputStream.write(cliente.toString()+"\n");
				outputStream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	public static boolean exportOrdersCustomer(Customer customer) {
		BufferedWriter outputStream = null;
		List<Order> orders = DataBase.getOrders(customer);
		try {
			outputStream = new BufferedWriter(new FileWriter(ORDERSTXT));
			outputStream.write("List orders from customer: "+customer.getCustomerName()+" \n\n");
			if (!orders.isEmpty()) {
				for (Order order : orders) {
					outputStream.write("Order: \n");
					if (order instanceof OrderDetail) {
						OrderDetail det = (OrderDetail)order;
						outputStream.write(det.toString()+"\n\n");
					} else {
						outputStream.write(order.toString()+"\n");
					}
					outputStream.flush();
				}
			} else {
				outputStream.write("\nThere are no orders from this customer.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}
	
	// exporta  uma lista de clientes para documento binário
	public static boolean exportCustomersBinary(List<Customer> customers) {
		FileOutputStream fileout;
		ObjectOutputStream out = null;
		try {
			fileout = new FileOutputStream(BINARYFILE);
			out = new ObjectOutputStream(fileout);
			out.writeObject(customers);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (out != null) out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	// cria uma lista de clientes a partir de um ficheiro binário
	// útil para inserir na base de dados a partir de um ficheiro binário 
	@SuppressWarnings("unchecked")
	public static List<Customer> importCustomersBinary() {
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		List<Customer> customers = new ArrayList<>();
		try {
			fileIn = new FileInputStream(BINARYFILE);
			in = new ObjectInputStream(fileIn);
			customers = (List<Customer>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {} finally {
			try {
				if (in != null) in.close();
				if (fileIn != null) fileIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return customers;
	}
	
	
	

}

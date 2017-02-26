package finalJavaProject;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import finalJavaProject.Order.Status;

public class DataBase {

	private static Connection c = null;
	public static String baseDados = "dbfinalJavaProject.db";

	public static boolean isOn() {
		try {
			return ((c != null) || (!c.isClosed()));
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// permite obter o office a partir do código do objeto
	public static Office getOffice(String var) {
		Office office = new Office();
		String city;
		String phone;
		String addressLine1;
		String addressLine2;
		String state;
		String country;
		String postalCode;
		String territory;
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String sql = "SELECT city, phone, addressLine1, addressLine2, state, country, postalCode, territory from Offices WHERE officeCode = '"
					+ var + "';";
			ResultSet rs = smt.executeQuery(sql);
			if (rs.next()) {
				city = rs.getString("city");
				phone = rs.getString("phone");
				addressLine1 = rs.getString("addressLine1");
				addressLine2 = rs.getString("addressLine2");
				state = rs.getString("state");
				country = rs.getString("country");
				postalCode = rs.getString("postalCode");
				territory = rs.getString("territory");
				office = new Office(var, city, phone, addressLine1, addressLine2, state, country, postalCode,
						territory);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return office;
	}

	// permite obter uma lista de Offices
	public static List<Office> getOfficeList() {
		Office office = null;
		List<Office> offices = new ArrayList<>();
		String city;
		String phone;
		String addressLine1;
		String addressLine2;
		String state;
		String country;
		String postalCode;
		String territory;
		String officeCode;
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String sql = "SELECT officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory from Offices;";
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				officeCode = rs.getString("officeCode");
				city = rs.getString("city");
				phone = rs.getString("phone");
				addressLine1 = rs.getString("addressLine1");
				addressLine2 = rs.getString("addressLine2");
				state = rs.getString("state");
				country = rs.getString("country");
				postalCode = rs.getString("postalCode");
				territory = rs.getString("territory");
				office = new Office(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode,
						territory);
				offices.add(office);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return offices;
	}
	
	public static List<Employee> getEmployeesList() {
		Employee empregado = new Employee();
		List<Employee> emps = new ArrayList<>();
		String firstName;
		String lastName;
		int employeeNumber;
		String extension;
		String email;
		String officeCode;
		int reportsTo;
		String jobTitle;
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String sql = "SELECT firstName, lastName, employeeNumber, extension, email, officeCode, reportsTo, jobTitle from Employees;";
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				firstName = rs.getString("firstName");
				lastName = rs.getString("lastName");
				employeeNumber = rs.getInt("employeeNumber");
				email = rs.getString("email");
				extension = rs.getString("extension"); 
				officeCode = rs.getString("officeCode");
				reportsTo = rs.getInt("reportsTo");
				jobTitle = rs.getString("jobTitle");
				empregado = new Employee(employeeNumber, firstName, lastName, extension, email, officeCode, reportsTo, jobTitle);
				emps.add(empregado);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return emps;
	}

	//GET PRODUCTS LIST!
	public static List<Product> getProductList() {
		Product product = null;
		List<Product> products = new ArrayList<>();
		String productCode;
		String productName;
		String productLine;
		String productScale;
		String productVendor;
		String productDescription;
		int quantityInStock;
		double buyPrice;
		double msrp;
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String sql = "SELECT productCode, productName,productLine, productScale, productVendor, productDescription, quantityInStock,buyPrice, msrp from Products;";
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				productCode = rs.getString("productCode");
				productName = rs.getString("productName");
				productLine = rs.getString("productLine");
				productScale = rs.getString("productScale");
				productVendor = rs.getString("productVendor");
				productDescription = rs.getString("productDescription");
				quantityInStock = rs.getInt("quantityInStock");
				buyPrice = rs.getDouble("buyPrice");
				msrp = rs.getDouble("msrp");
				
				product = new Product(productCode, productName,productLine, productScale, productVendor, productDescription, quantityInStock,buyPrice, msrp);
				products.add(product);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return products;
	}
	
	
	//get product by code
	public static Product getProduct(String code) {
		Product product = null;
		List<Product> products = new ArrayList<>();
		String productCode;
		String productName;
		String productLine;
		String productScale;
		String productVendor;
		String productDescription;
		int quantityInStock;
		double buyPrice;
		double msrp;
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String sql;
			if (code == null) return null;
			else {
				sql = "SELECT productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, msrp from Customers where productCode = '"+code+"'";
			}
			ResultSet rs = smt.executeQuery(sql);
			if (rs.next()) {
				productCode = rs.getString("productCode");
				productName = rs.getString("productName");
				productLine = rs.getString("productLine");
				productScale = rs.getString("productScale");
				productVendor = rs.getString("productVendor");
				productDescription = rs.getString("productDescription");
				quantityInStock = rs.getInt("quantityInStock");
				buyPrice = rs.getDouble("buyPrice");
				msrp = rs.getDouble("msrp");
				
				product = new Product(productCode, productName,productLine, productScale, productVendor, productDescription, quantityInStock,buyPrice, msrp);
				products.add(product);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return product;
	}
	
	
	
	
	
	// permite obter uma lista de clientes
	public static List<Customer> getCustomerList() {
		Customer customer = null;
		List<Customer> customers = new ArrayList<>();
		int customerNumber;
		String lastName;
		String firstName;
		String phone;
		String addressLine1;
		String addressLine2;
		String city;
		String state;
		String country;
		String postalCode;
		int salesRepEmployeeNumber;
		double creditLimit;
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String sql = "SELECT customerNumber, contactLastName, contactFirstName, phone, addressLine1, addressLine2, postalCode, city, country, state, salesRepEmployeeNumber, creditLimit from Customers;";
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				customerNumber = rs.getInt("customerNumber");
				lastName = rs.getString("contactLastName");
				firstName = rs.getString("contactFirstName");
				phone = rs.getString("phone");
				addressLine1 = rs.getString("addressLine1");
				addressLine2 = rs.getString("addressLine2");
				state = rs.getString("state");
				country = rs.getString("country");
				postalCode = rs.getString("postalCode");
				city = rs.getString("city");
				salesRepEmployeeNumber = rs.getInt("salesRepEmployeeNumber");
				creditLimit = rs.getDouble("creditLimit");
				customer = new Customer(firstName, lastName, customerNumber, phone, addressLine1, addressLine2, city,
						state, postalCode, country, salesRepEmployeeNumber, creditLimit);
				customers.add(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return customers;
	}
	
	public static Customer getCustomer(String firstName, String lastName, String phone) {
		Customer customer = null;
		List<Customer> customers = new ArrayList<>();
		int customerNumber;
		String addressLine1;
		String addressLine2;
		String city;
		String state;
		String country;
		String postalCode;
		int salesRepEmployeeNumber;
		double creditLimit;
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String sql = "SELECT customerNumber, addressLine1, addressLine2, postalCode, city, country, state, salesRepEmployeeNumber, creditLimit from Customers where contactFirstName = '"+firstName+"' and "
					+ "contactLastName = '"+lastName+"' and phone = '"+phone+"';";
			ResultSet rs = smt.executeQuery(sql);
			if (rs.next()) {
				customerNumber = rs.getInt("customerNumber");
				addressLine1 = rs.getString("addressLine1");
				addressLine2 = rs.getString("addressLine2");
				state = rs.getString("state");
				country = rs.getString("country");
				postalCode = rs.getString("postalCode");
				city = rs.getString("city");
				salesRepEmployeeNumber = rs.getInt("salesRepEmployeeNumber");
				creditLimit = rs.getDouble("creditLimit");
				customer = new Customer(firstName, lastName, customerNumber, phone, addressLine1, addressLine2, city,
						state, postalCode, country, salesRepEmployeeNumber, creditLimit);
				customers.add(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return customer;
	}
	
	
	public static Customer getCustomer(String phone, String addressLine1) {
		Customer customer = null;
		List<Customer> customers = new ArrayList<>();
		int customerNumber;
		String firstName;
		String lastName;
		String addressLine2;
		String city;
		String state;
		String country;
		String postalCode;
		int salesRepEmployeeNumber;
		double creditLimit;
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String sql;
			if ((addressLine1 == null)&&(phone == null)) return null;
			if ((addressLine1.equals(""))&&(phone.equals(""))) return null;
			if ((phone == null)||(phone.equals(""))) {
				sql = "SELECT customerNumber, contactFirstName, contactLastName, addressLine1, addressLine2, postalCode, city, country, state, salesRepEmployeeNumber, creditLimit from Customers where addressLine1 = '"+addressLine1+"';";
			} else if ((addressLine1 == null)||(addressLine1.equals(""))) {
				sql = "SELECT customerNumber, contactFirstName, contactLastName, addressLine1, addressLine2, postalCode, city, country, state, salesRepEmployeeNumber, creditLimit from Customers where phone = '"+phone+"';";
			} else {
				sql = "SELECT customerNumber, contactFirstName, contactLastName, addressLine1, addressLine2, postalCode, city, country, state, salesRepEmployeeNumber, creditLimit from Customers where phone = '"+phone+"'"
						+ "and addressLine1 = '"+addressLine1+"';";
			}
			ResultSet rs = smt.executeQuery(sql);
			if (rs.next()) {
				firstName = rs.getString("contactFirstName");
				lastName = rs.getString("contactLastName");
				customerNumber = rs.getInt("customerNumber");
				addressLine1 = rs.getString("addressLine1");
				addressLine2 = rs.getString("addressLine2");
				state = rs.getString("state");
				country = rs.getString("country");
				postalCode = rs.getString("postalCode");
				city = rs.getString("city");
				salesRepEmployeeNumber = rs.getInt("salesRepEmployeeNumber");
				creditLimit = rs.getDouble("creditLimit");
				customer = new Customer(firstName, lastName, customerNumber, phone, addressLine1, addressLine2, city,
						state, postalCode, country, salesRepEmployeeNumber, creditLimit);
				customers.add(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return customer;
	}
	
	public static Customer getCustomer(int number) {
		Customer customer = null;
		List<Customer> customers = new ArrayList<>();
		int customerNumber;
		String firstName;
		String lastName;
		String addressLine2;
		String addressLine1;
		String phone;
		String city;
		String state;
		String country;
		String postalCode;
		int salesRepEmployeeNumber;
		double creditLimit;
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String sql = "SELECT customerNumber, contactFirstName, contactLastName, addressLine1, addressLine2, phone, postalCode, city, country, state, salesRepEmployeeNumber, creditLimit from Customers where customerNumber = "+number+";";
			ResultSet rs = smt.executeQuery(sql);
			if (rs.next()) {
				firstName = rs.getString("contactFirstName");
				lastName = rs.getString("contactLastName");
				customerNumber = rs.getInt("customerNumber");
				addressLine1 = rs.getString("addressLine1");
				addressLine2 = rs.getString("addressLine2");
				state = rs.getString("state");
				country = rs.getString("country");
				postalCode = rs.getString("postalCode");
				city = rs.getString("city");
				salesRepEmployeeNumber = rs.getInt("salesRepEmployeeNumber");
				creditLimit = rs.getDouble("creditLimit");
				phone = rs.getString("phone");
				customer = new Customer(firstName, lastName, customerNumber, phone, addressLine1, addressLine2, city,
						state, postalCode, country, salesRepEmployeeNumber, creditLimit);
				customers.add(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return customer;
	}

	// permite obter uma lista de offices a partir de um tipo de pesquisa e uma
	// String de pesquisa
	public static List<Office> getOfficeList(int tipoPesquisa, String variavel) {
		Office office = null;
		List<Office> offices = new ArrayList<>();
		String city;
		String phone;
		String addressLine1;
		String addressLine2;
		String state;
		String country;
		String postalCode;
		String territory;
		String officeCode;
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String compara = "";
			switch (tipoPesquisa) {
			case 0:
				compara = "city";
				break;
			case 1:
				compara = "state";
				break;
			case 2:
				compara = "territory";
				break;
			default:
				compara = "country";
			}
			String sql = "SELECT officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory from Offices where "
					+ compara + " = '" + variavel + "';";
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				officeCode = rs.getString("officeCode");
				city = rs.getString("city");
				phone = rs.getString("phone");
				addressLine1 = rs.getString("addressLine1");
				addressLine2 = rs.getString("addressLine2");
				state = rs.getString("state");
				country = rs.getString("country");
				postalCode = rs.getString("postalCode");
				territory = rs.getString("territory");
				office = new Office(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode,
						territory);
				offices.add(office);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return offices;
	}

	// permite obter as orders / encomendas do cliente
	public static List<Order> getOrders(Customer cliente) {
		Order order = null;
		OrderDetail orderdetail = null;
		List<Order> orders = new ArrayList<>();
		int orderNumber;
		String orderDate;
		String requireDate;
		String shippedDate;
		Order.Status status;
		String ss;
		String comments;
		int customerNumber;
		String productCode;
		int quantityOrder;
		double priceEach;
		int orderLineNumber;
		Statement smt = null;
		Statement smt2 = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			ResultSet rs2;
			int clienteID = -1;
			if (cliente.getCustomerNumber() <= 0) {
				clienteID = DataBase.getCustomerID(cliente);
			} else {
				clienteID = cliente.getCustomerNumber();
			}
			String sql = "SELECT orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber from Orders where customerNumber = "
					+ clienteID + ";";
			ResultSet rs = smt.executeQuery(sql);
			LocalDate ldate1;
			LocalDate ldate2;
			LocalDate ldate3; 
			String [] auxiliar;
			while (rs.next()) {
				orderNumber = rs.getInt("orderNumber");
				orderDate = rs.getString("orderDate");
				auxiliar = orderDate.split("/");
				ldate1 = LocalDate.of(Integer.parseInt(auxiliar[0]), Integer.parseInt(auxiliar[1]), Integer.parseInt(auxiliar[2]));
				requireDate = rs.getString("requiredDate");
				auxiliar = requireDate.split("/");
				ldate2 = LocalDate.of(Integer.parseInt(auxiliar[0]), Integer.parseInt(auxiliar[1]), Integer.parseInt(auxiliar[2]));
				shippedDate = rs.getString("shippedDate");
				auxiliar = shippedDate.split("/");
				ldate3 = LocalDate.of(Integer.parseInt(auxiliar[0]), Integer.parseInt(auxiliar[1]), Integer.parseInt(auxiliar[2]));
				ss = rs.getString("status");
				if (Order.Status.finished.toString().equals(ss)) {
					status = Status.finished;
				} else if (Order.Status.inProgress.toString().equals(ss)) {
					status = Status.inProgress;
				} else {
					status = Status.waiting;
				}
				comments = rs.getString("comments");
				customerNumber = rs.getInt("customerNumber");
				order = new Order(orderNumber, ldate1, ldate2, ldate3, status, comments, customerNumber);
				smt2 = c.createStatement();
				sql = "select productCode, quantityOrdered, priceEach, orderLineNumber from OrderDetails where orderNumber = "
						+ orderNumber + ";";
				rs2 = smt2.executeQuery(sql);
				if (rs2.next()) {
					productCode = rs2.getString("productCode");
					quantityOrder = rs2.getInt("quantityOrdered");
					priceEach = rs2.getDouble("priceEach");
					orderLineNumber = rs2.getInt("OrderLineNumber");
					orderdetail = new OrderDetail(order, productCode, quantityOrder, priceEach, orderLineNumber);
					orders.add(orderdetail);
				} else {
					orders.add(order);
				}
				smt2.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return orders;
	}

	// Insere um cliente na base de dados
	public static int insertCustomer(Customer customer) {
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			if (DataBase.getCustomerID(customer) <= 0) {
				String sql = "insert into Customers(customerName, contactFirstName, contactLastName,"
						+ "phone, country, state, addressLine1, addressLine2, city, postalCode, "
						+ "salesRepEmployeeNumber, creditLimit) values ('" + customer.getCustomerName() + "','"
						+ customer.getFirstName() + "', '" + customer.getLastName() + "'," + "'" + customer.getPhone()
						+ "','" + customer.getCountry() + "'," + "'" + customer.getState() + "','"
						+ customer.getAddressLine1() + "'" + ",'" + customer.getAddressLine2() + "', '"
						+ customer.getCity() + "'," + "'" + customer.getPostalCode() + "',"
						+ customer.getSalesRepEmployeeNumber() + "," + customer.getCreditlimit() + ")";
				smt.executeUpdate(sql);
			} else {
				return 0;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 1;
	}

	// insere Cliente na base de dados a partir de um ficheiro binário
	public static int insertCustomersByBinaryFile() {
		List<Customer> customers = FileIO.importCustomersBinary();
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			for (Customer customer : customers) {
				if (DataBase.getCustomerID(customer) <= 0) {
					String sql = "insert into Customers(customerName, contactFirstName, contactLastName,"
							+ "phone, country, state, addressLine1, addressLine2, city, postalCode, "
							+ "salesRepEmployeeNumber, creditLimit) values ('" + customer.getCustomerName() + "','"
							+ customer.getFirstName() + "', '" + customer.getLastName() + "'," + "'"
							+ customer.getPhone() + "','" + customer.getCountry() + "'," + "'" + customer.getState()
							+ "','" + customer.getAddressLine1() + "'" + ",'" + customer.getAddressLine2() + "', '"
							+ customer.getCity() + "'," + "'" + customer.getPostalCode() + "',"
							+ customer.getSalesRepEmployeeNumber() + "," + customer.getCreditlimit() + ")";
					smt.executeUpdate(sql);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 1;
	}

	// procura o id /customer Number, se retornar valores diferente de -1 e 0,
	// já existe na base de dados
	public static int getCustomerID(Customer customer) {
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String sql = "select customerNumber from Customers where customerName = '" + customer.getCustomerName()
					+ "' and " + "contactLastName = '" + customer.getLastName() + "' and contactFirstName = '"
					+ customer.getFirstName() + "' and " + "phone = '" + customer.getPhone() + "' and country = '"
					+ customer.getCountry() + "' and " + "state = '" + customer.getState() + "' and addressLine1 = '"
					+ customer.getAddressLine1() + "' and " + "addressLine2 = '" + customer.getAddressLine2()
					+ "' and city = '" + customer.getCity() + "' and " + "postalCode = '" + customer.getPostalCode()
					+ "';";
			ResultSet rs = smt.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	// falta getProduct(String codigo)
	
	public static List<Product> getProductsList() {
		Statement smt = null;
		String productName;
		String productLine;
		String productScale;
		String productVendor;
		String productDescription;
		String productCode;
		int quantityInStock;
		double buyPrice;
		double msrp;
		Product product = null;
		List<Product> products = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String sql = "select productCode, productName, productLine, productScale, ProductVendor, productDescription, quantityInStock, buyPrice, MSRP from products;";
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				productCode = rs.getString("productCode");
				productName = rs.getString("productName");
				productLine = rs.getString("productLine");
				productScale = rs.getString("productScale");
				productVendor = rs.getString("productVendor");
				productDescription = rs.getString("productDescription");
				quantityInStock = rs.getInt("quantityInStock");
				buyPrice = rs.getDouble("buyPrice");
				msrp = rs.getDouble("MSRP");
				product = new Product(productCode, productName,productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, msrp);
				products.add(product);
			} 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return products;
	}

	// Insere um produto,já com validação
	public static int insertProduct(Product prod) {
		Statement smt = null;
		Statement smt2 = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			smt2 = c.createStatement();
			ResultSet rs = smt2.executeQuery("select count(*) from products where productCode = '" + prod.getProductCode() + "';");
			if (!rs.next() || (rs.getInt(1) == 0)) {
				String sql = "insert into Products(productCode, productName, productline,"
						+ "productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP) values ('"
						+ prod.getProductCode() + "','" + prod.getProductName() + "', '" + prod.getProductLine() + "',"
						+ "'" + prod.getProductScale() + "','" + prod.getProductVendor() + "'," + "'"
						+ prod.getProductDescription() + "'," + prod.getQuantityInStock() + ","
						+ prod.getBuyPrice() + ", " + prod.getMsrp() + ")";
				smt.executeUpdate(sql);
			} else {
				return 0;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 1;
	}

	// Insere Lista de Clientes na base de dados
	public static boolean insertCustomersList(List<Customer> customers) {
		Customer customer;
		Statement smt = null;
		try {
			int i = 0;
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			while (i < customers.size()) {
				customer = customers.get(i);
				if (DataBase.getCustomerID(customer) <= 0) {
					String sql = "insert into Customers(customerName, contactFirstName, contactLastName,"
						+ "phone, country, state, addressLine1, addressLine2, city, postalCode, "
						+ "salesRepEmployeeNumber, creditLimit) values ('" + customer.getCustomerName() + "','"
						+ customer.getFirstName() + "', '" + customer.getLastName() + "'," + "'" + customer.getPhone()
						+ "','" + customer.getCountry() + "'," + "'" + customer.getState() + "','"
						+ customer.getAddressLine1() + "'" + ",'" + customer.getAddressLine2() + "', '"
						+ customer.getCity() + "'," + "'" + customer.getPostalCode() + "',"
						+ customer.getSalesRepEmployeeNumber() + "," + customer.getCreditlimit() + ")";
					smt.executeUpdate(sql);
				}
				i++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				if (c != null) {
					c.rollback();
				}
			} catch (SQLException e1) {
			}
			return false;
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	// Insere uma encomenda
	// Insere uma encomenda
		public static boolean insertOrder(Customer cust, LocalDate date, LocalDate requiredDate,
				LocalDate shippedDate, Order.Status status, String comments, Product produto, int quantidade,
				double preco, int orderLineNumber) {
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			Statement smt = null;
			Statement smt2 = null;
			String sql = "";
			int customerNumber = -1;
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
				c.setAutoCommit(false);
				smt = c.createStatement();
				smt2 = c.createStatement();
				if (cust.getCustomerNumber() == -1) {
					sql = "select customerNumber from Customers where customerName = '" + cust.getCustomerName()
							+ "' and phone = '" + cust.getPhone() + "' and " + "country = '" + cust.getCountry()
							+ "' and state = '" + cust.getState() + "' and city = '" + cust.getCity() + "' and "
							+ "postalCode = '" + cust.getPostalCode() + "' and salesRepEmployeeNumber = "
							+ cust.getSalesRepEmployeeNumber() + " and " + "addressLine1 = '" + cust.getAddressLine1()
							+ "';";
					ResultSet rs = smt.executeQuery(sql);
					if (rs.next()) {
						customerNumber = rs.getInt(1);
					}
				} else {
					customerNumber = cust.getCustomerNumber();
				}
				sql = "insert into Orders(orderDate, requiredDate, shippedDate, status, comments, customerNumber) values "
						+ "('" + fmt.format(date) + "','" + fmt.format(requiredDate) + "','" + fmt.format(shippedDate)
						+ "','" + status.toString() + "','" + comments + "'," + customerNumber + ")";
				smt.executeUpdate(sql);
				sql = "SELECT last_insert_rowid()";
				ResultSet rs = smt2.executeQuery(sql);
				if (rs.next()) {
					int val = rs.getInt(1);
					sql = "insert into OrderDetails(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber) values "
							+ "(" + val + ",'" + produto.getProductCode() + "', " + quantidade + ", " + preco + ","
							+ orderLineNumber + ")";
					smt.executeUpdate(sql);
				}
				c.commit();
				c.setAutoCommit(true);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				if (smt != null) {
					try {
						smt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (c != null) {
					try {
						c.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return true;
		}

	
	public static int getEmployeeNumber(Employee emp){
		Statement smt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String sql = "select employeeNumber from Employees where lastName = '" + emp.getLastName()
					+ "' and " + "firstName = '" + emp.getFirstName() + "' and extension = '"
					+ emp.getExtension() + "' and" + " email = '" + emp.getEmail() + "' and officeCode = "
					+ emp.getOfficeCode() + " and " + "reportsTo = " + emp.getReportsTo() + " and jobTitle = '"
					+ emp.getJobTitle() + "';";
			ResultSet rs = smt.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Employee getEmployeeByNumber(int num){
		Statement smt = null;
		Employee emp = new Employee();
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + baseDados);
			smt = c.createStatement();
			String sql = "select firstName, lastName, extension, email, officeCode, reportsTo, jobTitle from Employees where employeeNumber = "+num; 
			ResultSet rs = smt.executeQuery(sql);
			if (rs.next()) {
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String extension = rs.getString("extension");
				String email = rs.getString("firstName");
				String officeCode = rs.getString("officeCode");
				int reportsTo = rs.getInt("reportsTo");
				String jobTitle = rs.getString("jobTitle");
				emp = new Employee(firstName,lastName, extension, email, officeCode, reportsTo, jobTitle);
				smt.executeUpdate(sql);
			} 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return emp;
	}
	
}
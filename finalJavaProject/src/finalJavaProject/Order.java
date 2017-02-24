package finalJavaProject;

import java.time.LocalDate;

public class Order {

	//ATRIB
	
	private int orderNumber;
	private LocalDate orderDate;
	private LocalDate requireDate;
	private LocalDate shippedDate;
	private enum Status {waiting, inProgress, finished}	
	private Status status;
	private String coments;
	private int custumerNumber;
	
	//CONSTRUCTOR
	public Order(){
		orderNumber=0;
		orderDate=LocalDate.of(01, 01, 2017);
		requireDate=LocalDate.of(01, 01, 2017);
		shippedDate=LocalDate.of(01, 01, 2017);
		status= Status.waiting;
		coments ="";
		custumerNumber=-1;
	}
	
	public Order(Order order){
		this.orderNumber=order.getOrderNumber();
		this.orderDate=order.getOrderDate();
		this.requireDate=order.getRequireDate();
		this.shippedDate=order.getShippedDate();
		this.status=order.getStatus();
		this.coments=order.getComents();
		this.custumerNumber=order.getCustumerNumber();				
	}
	
	
	public Order(int ordN, LocalDate ordD, LocalDate reqD, LocalDate shipD, Status stat, String com, int custN){
		orderNumber=ordN;
		orderDate= ordD;
		requireDate=reqD;
		shippedDate=shipD;
		status= stat;
		coments =com;
		custumerNumber=custN;
		
	}
	
	

	//SET AND GET
	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getRequireDate() {
		return requireDate;
	}

	public void setRequireDate(LocalDate requireDate) {
		this.requireDate = requireDate;
	}

	public LocalDate getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(LocalDate shippedDate) {
		this.shippedDate = shippedDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getComents() {
		return coments;
	}

	public void setComents(String coments) {
		this.coments = coments;
	}

	public int getCustumerNumber() {
		return custumerNumber;
	}

	public void setCustumerNumber(int custumerNumber) {
		this.custumerNumber = custumerNumber;
	}

	
	
	//TO STRING
	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requireDate=" + requireDate
				+ ", shippedDate=" + shippedDate + ", status=" + status + ", coments=" + coments + ", custumerNumber="
				+ custumerNumber + "]";
	}
	
	
	
	
}
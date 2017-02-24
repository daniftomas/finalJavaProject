package finalJavaProject;

public class OrderDetail extends Order {
	

	private String productCode;
	private int quantityOrder;
	private double priceEach;
	private int orderLineNumber;
	
	//CONSTRUCTOR
	public OrderDetail(){
		super();
		productCode="";
		quantityOrder=-1;
		priceEach=-1.0;
		orderLineNumber=-1;	
	}
	
	

	public OrderDetail(Order order, String prodCod, int quantOrd, double pricE, int ordLN ){
		super(order);
		productCode = prodCod;
		quantityOrder = quantOrd;
		priceEach = pricE;
		orderLineNumber = ordLN;
		
		
	}
		
	
	
	//GETS AND SETS


	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getQuantityOrder() {
		return quantityOrder;
	}

	public void setQuantityOrder(int quantityOrder) {
		this.quantityOrder = quantityOrder;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public int getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}


	
	//TO STRING

	@Override
	public String toString() {
		return "OrderDetail [productCode=" + productCode + ", quantityOrder=" + quantityOrder + ", priceEach="
				+ priceEach + ", orderLineNumber=" + orderLineNumber + "]";
	}
	
	
}
package rooms;



public  class RoomType {
	
	String typeName;

	double customerCost;

	public RoomType(String typeName, double customerCost) {
		setTypeName(typeName);
		
		setCustomerCost(customerCost);

	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String type) {
		this.typeName = type;
	}


	public double getCustomerCost() {
		return customerCost;
	}

	public void setCustomerCost(double customerCost) {
		this.customerCost = customerCost;
	}
	
	@Override
	public String toString(){
		
		return String.format("%16s %7.2f",getTypeName(),getCustomerCost());
		
		
	}

}

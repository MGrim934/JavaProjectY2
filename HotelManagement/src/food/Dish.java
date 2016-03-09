package food;

public class Dish {

	String dishName;
	double dishPrice;
	public Dish() {
		// TODO Auto-generated constructor stub
	}
	
	public Dish(String dishName){
		setDishName(dishName);
	
	}
	
	public Dish(String dishName,double dishPrice){
		this(dishName);
		setDishPrice(dishPrice);
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public double getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(double dishPrice) {
		this.dishPrice = dishPrice;
	}

	@Override
	public String toString(){
		return String.format("%20s %9.2f", getDishName(),getDishPrice());
	}
	

}

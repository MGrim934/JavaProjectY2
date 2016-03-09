package food;

public class MainCourse extends Dish {

	public MainCourse() {
	}

	public MainCourse(String dishName) {
		super(dishName);
	}

	public MainCourse(String dishName, double dishPrice) {
		super(dishName, dishPrice);
	}
	
	@Override
	public String toString(){
		String output = super.toString();
		output+=String.format(" %12s","Main Course");
		return output;
		//return String.format("%28s %5.2f %10s", getDishName(),getDishPrice(),"Main Course");
	}

}

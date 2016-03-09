package food;

public class Dessert extends Dish {

	public Dessert() {
	}

	public Dessert(String dishName) {
		super(dishName);
	}

	public Dessert(String dishName, double dishPrice) {
		super(dishName, dishPrice);
	}
	
	@Override
	public String toString(){
		String output = super.toString();
		output+=String.format(" %12s","Dessert");
		return output;
	}

}

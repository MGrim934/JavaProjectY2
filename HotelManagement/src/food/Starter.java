package food;

public class Starter extends Dish {

	public Starter() {
		// TODO Auto-generated constructor stub
	}

	public Starter(String dishName) {
		super(dishName);
		// TODO Auto-generated constructor stub
	}

	public Starter(String dishName, double dishPrice) {
		super(dishName, dishPrice);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString(){
		String output = super.toString();
		output+=String.format(" %12s","Starter");
		return output;
	}

}



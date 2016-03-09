package personnel;

public class Chef extends Employee {
	public Chef(){
		super();
	}
	
	public Chef(String name, int empID, double wage){
		super(name, empID,wage);
	}
	
	//method
	public void cook(){
		System.out.println(getName()+ "cooks!");
	}

	@Override
	public String toString() {
		String output = super.toString();
		output+=String.format("%12s",getClass().toString().substring(getClass().toString().indexOf(".")+1));
		return output;
		
	}
	
	

}

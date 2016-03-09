package personnel;

public class Cleaner extends Employee {
	
	public Cleaner(){
		super();
	}
	public Cleaner(String name, int empID,double wage){
		super(name,empID,wage);
	}
	
	

	
	@Override
	public String toString() {
		String output = super.toString();
		output+=String.format("%12s",getClass().toString().substring(getClass().toString().indexOf(".")+1));
		return output;
		
	}
}

package personnel;


public class Employee extends Person {
	private int empID;
	private double wage;
	public Employee(){
		
	}
	
	public Employee(String name){
		setName(name);
		
	}
	
	//showing the this function to call another constructor within the class
	public Employee(String name, int empID){
		this(name);
		setEmpID(empID);
	}
	
	public Employee(String name, int empID, double wage){
		this(name,empID);
		setWage(wage);
	}

	//gets and sets
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		
	}
	
	public void setEmpID(int empID){
		this.empID=empID;
	}
	
	public int getEmpID(){
		return empID;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}
	
	
	//gets and sets
	
	@Override
	public String toString(){
		return String.format("%16s %5d %10.2f", getName(),getEmpID(),getWage());
	}
	
	public void printEmployee(){
		String output = toString();
		
		System.out.print(output);
	}
	
	//Allow a way for a user to enter in employee Details


}

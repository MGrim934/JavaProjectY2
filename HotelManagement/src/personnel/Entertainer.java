package personnel;

public class Entertainer extends Employee implements Profession {
private	String profession;

	public Entertainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Entertainer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public Entertainer(String name, int empID) {
		super(name, empID);
	}
	
	public Entertainer(String name, int empID, double wage) {
		super(name, empID, wage);
	}
	
	public Entertainer(String name, int empID, double wage, String profession) {
		this(name,empID,wage);
		setProfession(profession);
	}




	

	//interface implementation
	public String getProfession(){
		return this.profession;
	}
	public void setProfession(String profession){
		this.profession=profession;
	}

	//give a sample performance
	//interface implementation
	public void perform(){
		System.out.println("The"+getProfession()+" performs!");
	}


	@Override
	//use index of to stop it from displaying the super + sub class
	public String toString() {
		String output = super.toString();
		output+=String.format("%12s",getClass().toString().substring(getClass().toString().indexOf(".")+1));
		return output;
		
	}
	
	@Override
	public void printEmployee(){
		String output = toString();
		output+=String.format("%18s",getProfession());
		System.out.println(output);
	}
}

package personnel;

import hotel.Hotel;
import food.Dish;

public class HeadChef extends Chef implements Qualification {

	String qualification;
	String qualificationRewarder;
	//composition!
	Dish specialtyDish;
	public HeadChef() {
		// TODO Auto-generated constructor stub
	}

	public HeadChef(String name, int empID, double wage) {
		super(name, empID, wage);
	}
	
	public HeadChef(String name, int empID, double wage,String qualification, String qualificationRewarder) {
		this(name, empID, wage);
		setQualification(qualification);
		setQualificationRewarder(qualificationRewarder);
	}
	
	
	public HeadChef(String name, int empID, double wage,String qualification, String qualificationRewarder,Dish specialtyDish) {
		this(name, empID, wage,qualification,qualificationRewarder);
		setSpecialtyDish(specialtyDish);
	}
	
	public void setQualification(String qualification){
		this.qualification=qualification;
	}
	public String getQualification(){
		return qualification;
	}

	public void setQualificationRewarder(String rewarder){
		this.qualificationRewarder=rewarder;
	}
	public String getQualificationRewarder(){
		return qualificationRewarder;
	}
	
	public Dish getSpecialityDish(){
		return specialtyDish;
	}
	
	public void setSpecialtyDish(Dish specialtyDish){
		this.specialtyDish=specialtyDish;
	}
	
	//add to hotel statistics
	public void addSpecialty(Hotel hotel){
		hotel.addNewDish(specialtyDish);
	}
	
	

	
	@Override
	public void printEmployee(){
		String output = toString();
		output+=String.format("%14s %14s",getQualification(),getQualificationRewarder());
		System.out.println(output);
	}
	


}

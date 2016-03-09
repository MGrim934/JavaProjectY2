package personnel;



public class Guest extends Person {
	
private	int roomNumber;
private	String suiteType;
	
	public Guest(){
		
	}
	
	public Guest(String name){
		setName(name);
	}
	
	public Guest(String name, int roomNumber, String suiteType){
		this(name);
		setRoomNumber(roomNumber);
		setSuiteType(suiteType);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getSuiteType() {
		return suiteType;
	}

	public void setSuiteType(String suiteType) {
		this.suiteType = suiteType;
	}
	
	@Override
	public String toString(){
		return String.format("%16s %9d %16s",
				getName(),getRoomNumber(),getSuiteType());
	}
	
	//increase static count
	//called every time a guest is created
	/*public static void incrGuestCount(){
		Hotel.increaseGuestCount();
	}
	
	public static void decGuestCount(){
		Hotel.decreaseGuestCount();
	}*/
	
	

}

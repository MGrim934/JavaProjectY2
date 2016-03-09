package hotel;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import personnel.*;
import food.*;

//this is the hotel object
//stores the name, guests, employees, dishes, employees in the organisation

public class Hotel {
	static final int MAX_HEADCHEFS = 1;
	String hotelName;
	String hotelManagerName;
	int guestCount = 0;
	int employeeCount = 0;
	
	//dishes, guests and employees are stored in lists 
	//as they will be dynamically updated and added to by the user
	
	ArrayList<Dish> dishes;
	ArrayList<Guest> guestList;
	ArrayList<Employee> employeeList;

	public Hotel(String hotelName, String hotelManagerName) {

		setHotelName(hotelName);
		setHotelManagerName(hotelManagerName);
		setGuestCount(0);
		setEmployeeCount(0);

		dishes = new ArrayList<Dish>();
		guestList = new ArrayList<Guest>();
		employeeList = new ArrayList<Employee>();

	}

	public Hotel(String hotelName, String hotelManagerName, int guestCount,
			int employeeCount) {

		this(hotelName, hotelManagerName);
		setGuestCount(guestCount);
		setEmployeeCount(employeeCount);

	}

	// gets and sets

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelManagerName() {
		return hotelManagerName;
	}

	public void setHotelManagerName(String hotelManagerName) {
		this.hotelManagerName = hotelManagerName;
	}

	public int getGuestCount() {
		return guestCount;
	}

	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	// increment methods
	public void increaseGuestCount() {
		guestCount++;
	}

	public void decreaseGuestCount() {
		guestCount--;
	}

	public void increaseEmployeeCount() {
		employeeCount++;
	}

	public void decreaseEmployeeCount() {
		employeeCount--;
	}

	public void addNewDish(Dish dish) {
		dishes.add(dish);
	}

	public void addNewGuest(Guest guest) {
		guestList.add(guest);
	}

	public void addNewEmployee(Employee employee) {
		employeeList.add(employee);
	}

	//prints out the list of dishes in the arraylist
	public void printDishes() {

		System.out.printf("%44s\n", "Current Dishes List");
		System.out.println("==============================================");
		System.out.printf("%20s %12s\n", "Dish", "Price");

		for (int i = 0; i < dishes.size(); i++) {
			System.out.println(dishes.get(i).toString());
		}
	}

	// print guestList
	public void printGuestList() {

		System.out.printf("%44s\n", "Current Guest List");
		System.out.println("==============================================");
		System.out.printf("%16s  %5s %16s\n", "Guest", "Room Number",
				"Room Type");
		System.out.println("==============================================");
		for (int i = 0; i < guestList.size(); i++) {

			System.out.print(guestList.get(i).toString() + "\n");
		}
	}

	// print employees
	// methods that prints specific type of employee

	public void printEmployeeList() {
		System.out.printf("%44s\n", "Employees List");
		System.out.println("==============================================");
		System.out.printf("%16s  %5s %10s %10s\n", "Employee Name", "ID",
				"Wage", "Job");
		System.out.println("==============================================");
		for (int i = 0; i < employeeList.size(); i++) {

			System.out.print(employeeList.get(i).toString() + "\n");
		}

	}

	public void printCleaners() {
		System.out.printf("%44s\n", "Cleaners");
		System.out.println("==============================================");
		System.out.printf("%16s  %5s %10s %10s\n", "Employee Name", "ID",
				"Wage", "Job");
		System.out.println("==============================================");
		for (int i = 0; i < employeeList.size(); i++) {

			if (employeeList.get(i) instanceof Cleaner) {
				System.out.print(employeeList.get(i).toString() + "\n");
			}
		}

	}

	public void printChefs() {
		System.out.printf("%44s\n", "Chefs");
		System.out.println("==============================================");
		System.out.printf("%16s  %5s %10s %10s\n", "Employee Name", "ID",
				"Wage", "Job");
		System.out.println("==============================================");
		for (int i = 0; i < employeeList.size(); i++) {

			//only prints if the employee is an instance of the chosen class
			//want both chefs and headchefs
			if (employeeList.get(i) instanceof Chef
					|| employeeList.get(i) instanceof HeadChef) {
				System.out.print(employeeList.get(i).toString() + "\n");
			}
		}

	}

	public void printHeadChef() {
		System.out.printf("%44s\n", "Cleaners");
		System.out.println("==============================================");
		System.out.printf("%16s  %5s %10s %10s\n", "Employee Name", "ID",
				"Wage", "Job");
		System.out.println("==============================================");
		for (int i = 0; i < employeeList.size(); i++) {

			if (employeeList.get(i) instanceof HeadChef) {
				System.out.print(employeeList.get(i).toString() + "\n");
			}
		}

	}
	
	public void printEntertainers() {
		System.out.printf("%44s\n", "Entertainers");
		System.out.println("==============================================");
		System.out.printf("%16s  %5s %10s %10s\n", "Employee Name", "ID",
				"Wage", "Job");
		System.out.println("==============================================");
		for (int i = 0; i < employeeList.size(); i++) {

			if (employeeList.get(i) instanceof Entertainer) {
				System.out.print(employeeList.get(i).toString() + "\n");
			}
		}

	}

	// =================================================================

	public void printHotelInformation() {
		//first update guest count and employees
		updateGuestAndEmployeeCount();
		System.out.printf("%16s  %12s %6s %6s\n", "Hotel", "Manager", "Guests",
				"Employees");
		System.out.println("==============================================");
		System.out.println(toString());

	}

	@Override
	public String toString() {
		return String.format("%16s %12s %5d %5d", getHotelName(),
				getHotelManagerName(), getGuestCount(), getEmployeeCount());
	}

	// assign head chef
	// checks head chef. If there is already a head chef, it removes it from the
	// arrayList and adds the new one
	// you can only have one headchef because too many cooks spoil the broth!
	
	public void changeHeadChef() {
		// generate new head chef?
		int choice = HotelManagementSystem.changeHeadChefQuestion(); //prompts user if they really wanna switch
		int result;
		switch (choice) {
		case 1:
			HeadChef chef = new HeadChef(); //creates a new chef object
			HotelManagementSystem.enterEmployeeDetails(chef); //lets the user enter details on the employee
			// replace other chef
			result = removeHeadChef();
			if (result == 1) {
				//removeheadchef returns 1 if there is a headchef to be removed
				System.out.println("Old Head Chef Removed");
			} else if (result == 0) {
				System.out
						.println("No Head Chef Employed, Hiring new Head Chef!");
			}
			// add in new headchef
			employeeList.add(chef);
			break;
		default:
			System.out.println("Invalid");
		}
		// create new headchef
		// if theres a head chef
		// you will have to replace
		// if yes
		// replace

	}

	// find headchef position
	public int removeHeadChef() {
		int result = 0;
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i) instanceof HeadChef) {
				employeeList.remove(i);//removes a headchef
				result = 1; //returns 1 to confirm there was a headchef that needed to be removed

			}// if
		}// for
		return result;
	}

	
	//update guest and employeeCount
	//updates every time user wishes to view information on the hotel
	
	public void updateGuestAndEmployeeCount(){
		setGuestCount(guestList.size());
		setEmployeeCount(guestList.size());
	}
	
	//printing to files
	public void printHotelReport(PrintWriter writeOut){
		//general
		updateGuestAndEmployeeCount();
		writeOut.printf("%16s  %12s %6s %6s%n", "Hotel", "Manager", "Guests",
				"Employees");
		writeOut.println("===============================================");
		writeOut.println(toString());
		
		writeOut.printf("%n");
		
		//employees
		
		writeOut.printf("%44s%n", "Employees List");
		writeOut.println("===============================================");
		writeOut.printf("%16s  %5s %10s %10s%n", "Employee Name", "ID",
				"Wage", "Job");
		writeOut.println("===============================================");
		for (int i = 0; i < employeeList.size(); i++) {

			writeOut.printf(employeeList.get(i).toString() + "%n");
		}
		
		writeOut.printf("%n");
			
		//guests
			
			writeOut.printf("%44s%n", "Current Guest List");
			writeOut.println("===============================================");
			writeOut.printf("%16s  %6s %16s%n", "Guest", "Room Number",
					"Room Type");
			writeOut.println("===============================================");
			for ( int i = 0; i < guestList.size(); i++) {

				writeOut.printf(guestList.get(i).toString() + "%n");
			}
			
			writeOut.printf("%n");
			
			
			//dishes
			writeOut.printf("%44s%n", "Current Dishes List");
			writeOut.println("===============================================");
			writeOut.printf("%20s %12s %8s %n", "Dish", "Price","Course");

			for ( int i = 0; i < dishes.size(); i++) {
				writeOut.printf(dishes.get(i).toString()+"%n");
			}
			
			writeOut.printf("%44s","End of Report");
		
			
		}
	
	//create a guest list from an external file
	//use a string path, so that the user can import from multiple files
	void AddGuestsFromFile(String path) 
	{
		
		//take in guest details
		
		//pass in the users file path
		
		Scanner file;
		try {
			 file = new Scanner( new FileReader(path));			
			
		
			String name;
			int roomNum;
			String roomType;

			name=file.next();
			while(name.equalsIgnoreCase("EOF")==false){
				//keeps looping until a sentinel is reached
				
				name+=" "+file.next();
				roomNum=file.nextInt();
				roomType=file.next();
				
				Guest guest = new Guest(name,roomNum,roomType); //creates a new guest
				guestList.add(guest); //adds a guest to the hotels arraylist
				
				
				//subsequent read
				name=file.next();
				
			}//while
			file.close(); //closes the file
			System.out.println("Guests read in from file! Hurray!");
			
			
			
			} catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}//add guests from file
	
	
		
	
}

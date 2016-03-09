package hotel;

import java.io.FileNotFoundException;
import java.util.Scanner;

import food.*;
import personnel.*;


//this class includes  many systems designed to 
//give the user the ability to make choices and fill up a hotel object

public class HotelManagementSystem {
	
	public static Scanner console = new Scanner(System.in);
	static String userInputString; //if the user needs to give something a name
	static int userIntChoice;
	static DataGenerator dataGenerator = new DataGenerator();
	//this is where the information system gets its data from
	//menu items, employee names, guest names, room types
	//can randomly generate names from dataGenerator
	
	


	
	//Creates a Hotel
	static public Hotel showCreateMenu(){
		StringBuffer managerName= new StringBuffer(); //appendable, unlike strings
		String hotelName;
		
		System.out.println("======================================");
		System.out.print("Enter your First Name: ");
		managerName.append(console.next());
		managerName.append(" ");
		System.out.print("Enter your Last Name: ");
		managerName.append(console.next());
		console.nextLine();
		System.out.print("Enter Hotel Name:  ");
		hotelName=console.nextLine();
		String fullName= managerName.toString(); //convert to string to fit with hotel constructor
		Hotel hotel = new Hotel (hotelName,fullName);
		return hotel;
		
		
		
	}
	
	//shows the main menu
	
	//output header
	static public void showHeader(){
		System.out.println("==============================================");
		System.out.printf("%44s\n","Hotel Management System 3000!");
		System.out.println("==============================================");
	}
	static public int showMainMenu(){
		showHeader();
		System.out.printf("%-15s %28s\n","1)","Show Hotel Information.");
		System.out.printf("%-15s %28s\n","2)","View/Update Guest List.");
		System.out.printf("%-15s %28s\n","3)","View/Update Employee List.");
		System.out.printf("%-15s %28s\n","4)","View/Update Catering Menu");
		System.out.printf("%-15s %28s\n","0)","Write To File and Exit");
		userIntChoice=console.nextInt();
		return userIntChoice;
	}
	
	//Guest Menus
	static public int showGuestMenu(){
		System.out.printf("%44s\n","Guest List Control");
		System.out.println("==============================================");
		System.out.printf("%-15s %28s\n","1)","View Current Guests");
		System.out.printf("%-15s %28s\n","2)","Add To Guest List.");
		System.out.printf("%-15s %28s\n","3)","Remove Guest from List");
		System.out.printf("%-15s %28s\n","0)","Return To Main Menu");
		userIntChoice=console.nextInt();
		return userIntChoice;
	}
	//add menu
	static public int showAddGuestMenu(){
		System.out.printf("%44s\n","Add Guest");
		System.out.println("==============================================");
		System.out.printf("%-15s %28s\n","1)","Manually Input Guest Details");
		System.out.printf("%-15s %28s\n","2)","Auto Generate Guest");
		System.out.printf("%-15s %28s\n","3)","Generate Guests from File");
		System.out.printf("%-15s %28s\n","0)","Return");
		
		userIntChoice=console.nextInt();
		return userIntChoice;
	}
	//remove guest
	static public String showRemoveGuestMenu(){
		System.out.printf("%44s\n","Remove Guest");
		System.out.println("==============================================");
		System.out.print("Enter \"0\" to Cancel Guest Removal and Return\n");
		
		
		
		userInputString=console.nextLine().trim();
		return userInputString;
	}
	
	//==============================================
	//guest menus
	
	
	
	//guest controls
	
	static public void createGuest(Hotel hotel) throws FileNotFoundException{
		do{
		userIntChoice = showAddGuestMenu(); //returns a number based on user choice
		//goes into a switch statement to give guest details

		Guest guest = new Guest();
		switch(userIntChoice){
		case 1:
			enterGuestDetails(guest); //allows the user to enter information
			hotel.addNewGuest(guest);
			break;
		case 2:
			generateGuestDetails(guest);
			System.out.println("Guest Generated");
			System.out.print(guest.toString()+"\n");
			hotel.addNewGuest(guest); //adds it to the hotels list
			break;
		case 3:
			System.out.print("Enter the file name: ");
			String path = console.next();
		
				hotel.AddGuestsFromFile(path);
				
		break;
		case 0:
			System.out.println("Returning to previous Menu");
			default:
				System.out.println("Invalid Input");
		}//switch
		}while(userIntChoice!=0);
			
		}
		
		
	
	static public void enterGuestDetails(Guest guest){
		
		StringBuffer sbName= new StringBuffer();
		String fullName;
		int roomNumber;
		
		System.out.print("Enter First Name: ");
		
		//use a string buffer instead of a string as the user is entering two parts of a name 
		//but the data only has one field for info
		sbName.append(console.next());
		sbName.append(" ");
		System.out.print("Enter Last Name: ");
		sbName.append(console.next());
		fullName=sbName.toString();	
		//converts stringbuffer to...string!
		
		
		guest.setName(fullName);
		System.out.print("Enter Room Number: ");
		roomNumber = console.nextInt();
		guest.setRoomNumber(roomNumber);
		System.out.print("Choose Room Type\n");
		userIntChoice=roomTypeChoice();
		//runs another method which shows list of rooms available
		guest.setSuiteType(dataGenerator.roomTypes.get(userIntChoice).getTypeName());
		
		//pulls from a list of objects known as "roomtypes". 
		//However in guest, the data is simply stored as a string
		//could have also used composition and 
		//given the guest a room type object as one of its attributes
		
	} //set guest details
	
	//randomly set guest details
	static public void generateGuestDetails(Guest guest){
		
		String fullName;
		int roomNumber;
	
		
		//created a number of methods in the data generator class to use the random class
		//implemented here, allowing user to create a person with random attributes
		//probably not useful in a real world scenario!
		//decided to implement it to stress the random class a little
		
		fullName=dataGenerator.generateFullName();	
		
		
		guest.setName(fullName);
		roomNumber =(int)(Math.random()*300)+1; 
		//generates a room number between 1 and 300
		guest.setRoomNumber(roomNumber);
		guest.setSuiteType(dataGenerator.generateRoomType());
		
	}
	
	//print room Types
	static public int roomTypeChoice(){
		dataGenerator.printRoomTypes();
		userIntChoice=console.nextInt();
		//decrement for accuracy
		return --userIntChoice;
		//if i don't decrement for accuracy and the user says the final choice, it could be out of bounds
		
	}
	
	
	public static void removeGuest(Hotel hotel){
		do{
			
		userInputString=showRemoveGuestMenu();
		int pos;

		hotel.printGuestList();
		System.out.println();
		System.out.println("Enter Guest Name: ");
		userInputString=console.nextLine().trim();
		//engage search
		boolean found=false;
		pos=searchGuestMatch(hotel, userInputString); 
		//another method which searches for a guest in a hotel object and returns an integer
		if(pos>=0&&pos<hotel.guestList.size()){
			//the previous method returns -1 if its not found, 
			//so >=0 means "if its found" and < guest list size is a double check to ensure no funny business
			found=true;
			hotel.guestList.remove(pos);
			System.out.println("Guest Removed");//removes guest
		}//if
		if(found==false){
			System.out.println("No Guest Found!");
		}
	

		System.out.println("Remove another? (1) or Go Back? (0)");
		userIntChoice=console.nextInt();
		}while(userIntChoice!=0);
		
	}
	
	
	public static int searchGuestMatch(Hotel hotel, String userInputString){
		
		//this method searches guest names
		//the user inputs the name of a guest
		//if the name is found it returns their location
		//if not it returns minus 1
		int found = -1;
		for(int i=0;i<hotel.guestList.size();i++){
			if(hotel.guestList.get(i).getName().equalsIgnoreCase(userInputString)){
				
				found = i;
			}//if
		}//for
		//if it returns -1, then it doesn't try to remove
		return found;
	}
	
	//=====================================
	
	
	
	//employee menus
	static public int showEmployeeMenu(){
		System.out.printf("%44s\n","Employee List Control");
		System.out.println("==============================================");
		System.out.printf("%-15s %28s\n","1)","View Current Employees");
		System.out.printf("%-15s %28s\n","2)","Hire New Employee");
		System.out.printf("%-15s %28s\n","3)","Fire Employee");
		System.out.printf("%-15s %28s\n","0)","Return To Main Menu");
		userIntChoice=console.nextInt();
		return userIntChoice;
	}
	
	static public int showViewEmployeeMenu(){
		System.out.printf("%44s\n","View Employees");
		System.out.println("==============================================");
		System.out.printf("%-15s %28s\n","1)","View All Current Employees");
		System.out.printf("%-15s %28s\n","2)","View Cleaners");
		System.out.printf("%-15s %28s\n","3)","View Entertainers");
		System.out.printf("%-15s %28s\n","4)","View Chefs");
		System.out.printf("%-15s %28s\n","5)","View Head Chef");
		System.out.printf("%-15s %28s\n","0)","Return");
		userIntChoice=console.nextInt();
		return userIntChoice;
	}
	
	static public int showHireEmployeeMenu(){
		System.out.printf("%44s\n","Hire New Employee!");
		System.out.println("==============================================");
	
		System.out.printf("%-15s %28s\n","1)","Hire Cleaner");
		System.out.printf("%-15s %28s\n","2)","Hire Entertainers");
		System.out.printf("%-15s %28s\n","3)","Hire Chef");
		System.out.printf("%-15s %28s\n","4)","Hire Head Chef (only one allowed!)");
		System.out.printf("%-15s %28s\n","0)","Return");
		userIntChoice=console.nextInt();
		return userIntChoice;


	}
	
	static public int showFireEmployeeMenu(){
			System.out.printf("%44s\n","Fire Employee");
			System.out.println("==============================================");
			System.out.printf("%-15s %28s\n","1)","Consult List and Fire");
			System.out.print("Enter \"0\" to Cancel and Return\n");
			System.out.print("Enter Employee Name: ");
			
			
			userIntChoice=console.nextInt();
			return userIntChoice;
		}
		
		//employee menus
		//=========================================================
	
	
	//view employees
	static public void viewEmployees(Hotel hotel){
		//takes in hotel object
		do{
			//do while loop as it needs to run at least once
			
			userIntChoice=showViewEmployeeMenu();
			switch(userIntChoice){
			case 1:
				//all
				hotel.printEmployeeList();
				break;
			case 2:
				hotel.printCleaners();
				//cleaners
				break;
			case 3:
				hotel.printEntertainers();
				//entertainers
				break;
			case 4:
				hotel.printChefs();
				//chefs
				break;
			case 5:
				hotel.printHeadChef();
				//head chefs
				break;
			case 0:
				System.out.println("Returning to Previous Menu");
				break;
				default:
					System.out.println("Invalid Input");
				
			}
		}while(userIntChoice!=0);
		
		
		//
	}//viewEmployees
	
	static public void createAndAddEmployee(Hotel hotel){
		do{
		userIntChoice = showHireEmployeeMenu();
		
		
		//switch creates objects based on user choice
			switch(userIntChoice){
			case 1:
				 Cleaner cleaner = new Cleaner();
				 enterEmployeeDetails(cleaner);
				 //this method helps the user build an employee
				 hotel.employeeList.add(cleaner);
				 //adds the employee to the list of employees
				break;
			case 2:
				Entertainer entertainer = new Entertainer();
				enterEmployeeDetails(entertainer);
				hotel.employeeList.add(entertainer);
				break;
			case 3:
				Chef chef = new Chef();
				enterEmployeeDetails(chef);
				hotel.employeeList.add(chef);
				
				break;
			case 4:
				hotel.changeHeadChef();
				//this method checks to see if you already have a headchef among other things
				break;
			case 0: 
				System.out.println("Returning to previous Menu");
				break;
			default:
				System.out.println("Invalid Input");
			}//switch
		}while(userIntChoice!=0);
			
		
		
	}
		//=========================================================
		static public void enterEmployeeDetails(Employee employee){
			StringBuffer sbName= new StringBuffer();
			String fullName;
			int empID;
			double wage;
			System.out.print("Enter First Name: ");
			sbName.append(console.next());
			sbName.append(" ");
			System.out.print("Enter Last Name: ");
			sbName.append(console.next());
			fullName=sbName.toString();
			employee.setName(fullName);
			System.out.print("Enter Employee ID: ");
			empID = console.nextInt();
			System.out.print("Enter Hourly Wage: ");
			wage = console.nextDouble();
			employee.setEmpID(empID);
			employee.setWage(wage);
			
			//for headchefs and entertainers, we must use casting to enter all details
			
			if(employee instanceof HeadChef){
				//cast to chef
				HeadChef chef = (HeadChef) employee;
				String qualification;
				System.out.print("Enter Qualification: \n");
				console.nextLine();
				
				qualification=console.nextLine().trim();
				chef.setQualification(qualification);
				String qualificationRewarder;
				System.out.print("Enter Rewarding Organisiation: \n");
				
				qualificationRewarder=console.nextLine().trim();
				
				chef.setQualificationRewarder(qualificationRewarder);
				
				System.out.print("Does this Chef have a specialty? (Y)/(N)");
				char answer = console.next().charAt(0);
				switch(answer){
				case 'y':
				case 'Y':
					AddDishMenu(chef); 
					//triggers overloaded add a dish menu
					//through the magic of composition, we give the chef a dish
					System.out.print("The Chefs Specialty is: "+chef.getSpecialityDish().toString()+"\n"); 
					//prints the specialty dish
					
					break;
				case 'N':
				case 'n':
				System.out.println("Okay! Returning to Menu!");
				break;
				default:
					System.out.println("Error - Will not add specialty then..."); 
					//if they user gives an invalid input
				}
				
				
			}
			
			if(employee instanceof Entertainer){
				//cast down
				Entertainer entertainer = (Entertainer) employee;
				System.out.print("Set Profession\n");
				userIntChoice=professionsChoice();
				entertainer.setProfession(dataGenerator.professions.get(userIntChoice));
				//print profession menu
			}//if entertainer
			
		}
		
		

		
		//print professionList
		static public int professionsChoice(){
			dataGenerator.printProfessions(); //shows the various professions
			userIntChoice=console.nextInt();
			//decrement for accuracy
			return --userIntChoice;
		}
		
	
		
		//ask if you want to change head chef
		static public int changeHeadChefQuestion(){
			System.out.print("WARNING: Only one Head Chef Allowed at a Time\n");
			System.out.printf("%-15s %28s\n","1)","Proceed");
			System.out.printf("%-15s %28s\n","0)","Cancel");
			userIntChoice=console.nextInt();
			return userIntChoice;
			
		}
		
		
		//remove employee
		public static void fireEmployee(Hotel hotel){
			do{
			userIntChoice=showFireEmployeeMenu();
			int pos;
			switch(userIntChoice){
			case 1://print current list of employees
			hotel.printEmployeeList();
			console.nextLine();
			System.out.println("Enter Employee Name");
			userInputString=console.nextLine().trim();
			//engage search
			pos=searchEmployeeMatch(hotel, userInputString);
			if(pos>=0&&pos<hotel.employeeList.size()){
				hotel.employeeList.remove(pos);
				System.out.println("Employee Removed");//removes employee
			}//if
			break;
			default:
				System.out.println("Invalid Input");
			}//switch
			}while(userIntChoice!=0);
			
		}
		
		
		public static int searchEmployeeMatch(Hotel hotel, String userInputString){
			int found = -1;
			for(int i=0;i<hotel.employeeList.size();i++){
				if(hotel.employeeList.get(i).getName().equalsIgnoreCase(userInputString)){
					//compares the name property of each employee as the user only enters a string
					found = i;
				}//if
			}//for
			//if it returns -1, then it doesn't try to remove
			return found;
		}
		//============================================================
		//end employees

		
		//dishes
		
		static public int showDishesMenu(){
			System.out.printf("%44s\n","Catering Menu");
			System.out.println("==============================================");
			System.out.printf("%-15s %28s\n","1)","View Current Catering Menu");
			System.out.printf("%-15s %28s\n","2)","Add To Menu");
			System.out.printf("%-15s %28s\n","3)","Remove Item From Menu");
			System.out.printf("%-15s %28s\n","0)","Return To Main Menu");
			userIntChoice=console.nextInt();
			return userIntChoice;
		}
		
		//remove item from menu
		
		static public void removeDishFromMenu(Hotel hotel){
			System.out.printf("%44s\n","Remove a Dish 0 to cancel");
			System.out.println("==============================================");
			hotel.printDishes();
			System.out.print("Select a Dish to remove: (based on number)");
			userIntChoice=console.nextInt();
			--userIntChoice;
			//decrement as the array starts at 0, and is at odds with what is displayed
			//always show the first as 1 for the user. usability
			if(userIntChoice<0){
				//do nothing
			}else if(userIntChoice<hotel.dishes.size()){
				hotel.dishes.remove(userIntChoice);
			}
			
		}
		
		///sub menu
		
		static public int addToMenu(){
			//print options
			//lets user choice what type of dish
			System.out.printf("%44s\n","Add a Dish");
			System.out.println("==============================================");
			System.out.printf("%-15s %28s\n","1)","Add Starter");
			System.out.printf("%-15s %28s\n","2)","Add Main Course");
			System.out.printf("%-15s %28s\n","3)","Add Dessert");
			System.out.printf("%-15s %28s\n","0)","Return");
			//make choice
			userIntChoice=console.nextInt();
			return userIntChoice;
			
			
		}
		
		//==================================================================
		static public void AddDishMenu(Hotel hotel){
			do{
			userIntChoice=addToMenu();
			int choice;
			//different choices are different sub classes
			switch(userIntChoice){
			case 1:
				//create starter
				Starter starter = new Starter();
				choice=starterChoice(); 
				
				//show menu of the starters, user gives the system an integer
				
				starter.setDishName(dataGenerator.starterName.get(choice).toString()); 
				//the name of the starter is set based of the integer choice, pulled from the data generator
				//set name
				//now set price
				try {
					dishPriceMenu(starter);
					
					
					hotel.dishes.add(starter); 
					//add dish
					
				} catch (PriceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

				break;
			case 2:
				MainCourse mainCourse = new MainCourse();
				choice=mainCourseChoice();
				mainCourse.setDishName(dataGenerator.mainCourseName.get(choice).toString());
				try {
					dishPriceMenu(mainCourse);
					hotel.dishes.add(mainCourse);
				} catch (PriceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				
				break;
			case 3:
				Dessert dessert = new Dessert();
				choice=dessertChoice();
				dessert.setDishName(dataGenerator.dessertName.get(choice).toString());
				try {
					dishPriceMenu(dessert);
					hotel.dishes.add(dessert);
				} catch (PriceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			
				break;
			case 0:
				System.out.println("Returning");
				break;
				default:
					System.out.println("Invalid Input");
			}//switch
			}while(userIntChoice!=0);
			
			//choice
			
		}
		
		//========================================================
		//method overload
		static public void AddDishMenu(HeadChef chef){
			
			userIntChoice=addToMenu();
			int choice;
			//different choices are different sub classes
			switch(userIntChoice){
			case 1:
				//create starter
				Starter starter = new Starter();
				choice=starterChoice(); 
				//show menu
				starter.setDishName(dataGenerator.starterName.get(choice).toString()); 
				//set name
				//now set price
				try {
					dishPriceMenu(starter);
					
					
					chef.setSpecialtyDish(starter); 
					//add dish
					
				} catch (PriceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

				break;
			case 2:
				MainCourse mainCourse = new MainCourse();
				choice=mainCourseChoice();
				mainCourse.setDishName(dataGenerator.mainCourseName.get(choice).toString());
				try {
					dishPriceMenu(mainCourse);
					chef.setSpecialtyDish(mainCourse);
				} catch (PriceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				
				break;
			case 3:
				Dessert dessert = new Dessert();
				choice=dessertChoice();
				dessert.setDishName(dataGenerator.dessertName.get(choice).toString());
				try {
					dishPriceMenu(dessert);
					chef.setSpecialtyDish(dessert);
				} catch (PriceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			
				break;
			case 0:
				System.out.println("Returning");
				break;
				default:
					System.out.println("Invalid Input");
			}//switch
			
		}
		
		//starter choice
		public static int starterChoice(){
			System.out.printf("%44s\n","Add a Dish");
			System.out.println("==============================================");
			dataGenerator.printStarters();
			userIntChoice=console.nextInt();
			return --userIntChoice;
		}
		
		public static  int mainCourseChoice(){
			System.out.printf("%44s\n","Add a Dish");
			System.out.println("==============================================");
			dataGenerator.printMains();
			userIntChoice=console.nextInt();
			return --userIntChoice;
		}
		
		public static int dessertChoice(){
			System.out.printf("%44s\n","Add a Dish");
			System.out.println("==============================================");
			dataGenerator.printDesserts();
			userIntChoice=console.nextInt();
			return --userIntChoice;
		}
		
		public static void dishPriceMenu(Dish food) throws PriceException {
			double price;
			
			System.out.printf("%44s\n","Add a Dish");
			System.out.println("==============================================");
			System.out.print("Set Price: ");
			price=console.nextDouble();
			
			//error handling to ensure reasonable prices
			
			if(price<=0){
				throw new PriceException("Error: You can't charge a negative number!");
			}else if(price>49){
				throw new PriceException("Error: You can't charge THAT much!");
			} else
				{
			 food.setDishPrice(price);
			}
			 
			 
		}

}

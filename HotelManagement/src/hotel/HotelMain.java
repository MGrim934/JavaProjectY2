package hotel;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

//Hotel Management System
//Mark Grimes

//This program allows users to enter data on a hotel object, which contains guests, employees, dishes
//the user gives the hotel a name and a manager and then inputs the information.
//finally, the information is written out to a "HotelDetails" report file
//this is the main class of this project
//This is how the user creates and gives objects information

public class HotelMain {


	//how the user accesses, updates and outputs hotel information
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		PrintWriter outFileRep = new PrintWriter ("HotelDetails.dat");
		

		
		int outerChoice,innerChoice;
		Hotel hotel = HotelManagementSystem.showCreateMenu();

		do{
			outerChoice = HotelManagementSystem.showMainMenu();
			switch(outerChoice){
			case 1:
				//print
				hotel.printHotelInformation();
				break;
			case 2:
				//print employee name menu
				do{
				innerChoice=HotelManagementSystem.showGuestMenu();
				//statically accessed from HotelManagementSystem
				//guest menu includes, create guest, view guest etc.
				//falls into a switch
				
				switch(innerChoice){
				case 1:
					//view guest list
					hotel.printGuestList();
					break;
				case 2:
					//add guest method
					HotelManagementSystem.createGuest(hotel);
					break;
				case 3:
					//remove guest
					HotelManagementSystem.removeGuest(hotel);
					break;
				case 0:
					System.out.println("Returning to Main Menu");
					break;
					default:
						System.out.println("Invalid Input!");
				}//switch
				}while(innerChoice!=0); //if its 0 then it returns to the previous menu
				

				break;
			case 3:
				do{
				innerChoice = HotelManagementSystem.showEmployeeMenu();
				//showEmployeeMenu returns an int which can be used in a switch
				//these methods are statically accessed
				
				switch(innerChoice){
				case 1:
					//view employees
					HotelManagementSystem.viewEmployees(hotel);
					break;
				case 2:
					//hire employee
					HotelManagementSystem.createAndAddEmployee(hotel);
					break;
				case 3:
					//fire employee
					HotelManagementSystem.fireEmployee(hotel);
					break;
				case 0:
					System.out.println("Returning to Main Menu");
					break;
					default:
						System.out.println("Invalid Input!");
				}//switch
				}while(innerChoice!=0);
				
				

				break;
			case 4:
				do{
					
				innerChoice=HotelManagementSystem.showDishesMenu();
				switch(innerChoice){
				case 1:
					//view
					hotel.printDishes();
					break;
				case 2:
					//add
					HotelManagementSystem.AddDishMenu(hotel);
					break;
				case 3:
					//remove
					HotelManagementSystem.removeDishFromMenu(hotel);
					break;
				case 0:
					//return
					System.out.println("Returning to Main Menu");
					break;
					default:
						System.out.println("Invalid Input!");
				}
				}while(innerChoice!=0);
				
				break;
			case 0:
				System.out.println("Shutting Down, Thank You!");
				break;
			default:
				System.out.println("Error, Try again!");
			}//switch
			
			
		}while(outerChoice!=0);
		
		//close files
		hotel.printHotelReport(outFileRep); 
		//prints to file
	
		outFileRep.close();
	}//main

}

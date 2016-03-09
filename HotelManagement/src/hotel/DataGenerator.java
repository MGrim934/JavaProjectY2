package hotel;

import java.util.*;

import rooms.RoomType;

public class DataGenerator {

	// the purpose of this method is to store a list of random strings and
	// generate data on command
	// people names, food, guests etc.

	 ArrayList<String> firstNames;
	 ArrayList<String> lastNames;
	ArrayList<String> starterName;
	ArrayList<String> mainCourseName;
	 ArrayList<String> dessertName;
	ArrayList<Double> dishPrices;
	 ArrayList<RoomType> roomTypes;
	 ArrayList<String> professions;

	static Random roll = new Random();

	public DataGenerator() {
		firstNames = new ArrayList<String>();
		firstNames.add("John");
		firstNames.add("Mary");
		firstNames.add("Paul");
		firstNames.add("Joey");
		firstNames.add("Chandler");
		firstNames.add("Monica");
		firstNames.add("Ross");
		firstNames.add("Rachel");
		firstNames.add("Benedict");
		firstNames.add("David");
		firstNames.add("Eli");
		firstNames.add("Jane");
		firstNames.add("Laura");
		firstNames.add("Thomas");
		firstNames.add("Kurt");

		lastNames = new ArrayList<String>();
		lastNames.add("Miller");
		lastNames.add("Johnson");
		lastNames.add("Bowie");
		lastNames.add("Bing");
		lastNames.add("Dickinson");
		lastNames.add("Harris");
		lastNames.add("Frusciante");
		lastNames.add("Berninger");
		lastNames.add("Thompson");
		lastNames.add("Hunter");
		lastNames.add("Emmerich");
		lastNames.add("Vonnegut");
		lastNames.add("Reed");
		lastNames.add("Dorian");

		starterName = new ArrayList<String>();
		starterName.add("Chicken Soup");
		starterName.add("Garlic Mushrooms");
		starterName.add("Bruchetta");
		starterName.add("Smoked Salmon");
		starterName.add("Caeser Salad");

		mainCourseName = new ArrayList<String>();
		mainCourseName.add("Chicken Curry");
		mainCourseName.add("Lasagne");
		mainCourseName.add("Pizza");
		mainCourseName.add("Steak and Chips");
		mainCourseName.add("Fish 'n' Chips");
		mainCourseName.add("Turkey and Ham");
		mainCourseName.add("Grilled Salmon");
		mainCourseName.add("Pesto Pasta");
		mainCourseName.add("Fried Rice");
		mainCourseName.add("Vegetable Stir Fry");
		mainCourseName.add("Beef and Rice Burrito");
		mainCourseName.add("Chicken Quesadilla");
		mainCourseName.add("Bacon and Cabbage");

		dessertName = new ArrayList<String>();
		dessertName.add("Apple Pie");
		dessertName.add("Chocolate Brownie");
		dessertName.add("Cheesecake");
		dessertName.add("Ice Cream");
		dessertName.add("Chocolate Cake");

		dishPrices = new ArrayList<Double>();
		dishPrices.add(5.50);
		dishPrices.add(7.50);
		dishPrices.add(8.50);
		dishPrices.add(9.50);
		dishPrices.add(10.50);
		dishPrices.add(11.50);
		dishPrices.add(12.50);

		roomTypes = new ArrayList<RoomType>();
		createNewRoomType("Single",100);
		createNewRoomType("Double",120);
		createNewRoomType("King",180);
		createNewRoomType("Queen",150);
		createNewRoomType("Suite",200);
		createNewRoomType("Presidential",250);
		createNewRoomType("Twin",100);

		professions = new ArrayList<String>();
		professions.add("Singer");
		professions.add("Comedian");
		professions.add("Musician");
		professions.add("Fitness Expert");
		professions.add("Motivational Speaker");

	}// constructor

	// methods creating name
	// implements random roll
	public String generateFullName() {

		String fullName;
		fullName = firstNames.get(roll.nextInt(firstNames.size()));
		fullName += " " + lastNames.get(roll.nextInt(lastNames.size()));
		return fullName;
	}

	// sets the price randomly
	public double setRandomPrice() {
		double price = dishPrices.get(roll.nextInt(dishPrices.size()));
		return price;
	}

	// picks a random foodName
	public String generateStarterName() {
		return starterName.get(roll.nextInt(starterName.size()));
	}

	public String generateMainName() {
		return mainCourseName.get(roll.nextInt(mainCourseName.size()));
	}

	public String generateDessertName() {
		return dessertName.get(roll.nextInt(dessertName.size()));
	}

	// assigns random profession
	public String generateProfession() {
		return professions.get(roll.nextInt(professions.size()));
	}

	public String generateRoomType() {
		return roomTypes.get(roll.nextInt(roomTypes.size())).getTypeName();
		
		//returns the type name in String form
	}

	// method to fill roomTypes list
	public void createNewRoomType(String typeName,
			double customerCost) {
		RoomType room = new RoomType(typeName, customerCost);
		roomTypes.add(room);
	}

	public void printProfessions() {

		for (int i = 0; i < professions.size(); i++) {
			System.out.printf("%3d)%30s\n", (i + 1), professions.get(i));
		}
	}
	
	public void printRoomTypes() {

		for (int i = 0; i < roomTypes.size(); i++) {
			System.out.printf("%3d)%30s\n", (i + 1), roomTypes.get(i));
		}
	}
	
	//print starters
	public void printStarters() {

		for (int i = 0; i < starterName.size(); i++) {
			System.out.printf("%3d)%30s\n", (i + 1), starterName.get(i));
		}
	}
	
	public void printMains() {

		for (int i = 0; i < mainCourseName.size(); i++) {
			System.out.printf("%3d)%30s\n", (i + 1), mainCourseName.get(i));
		}
	}
	
	public void printDesserts() {

		for (int i = 0; i < dessertName.size(); i++) {
			System.out.printf("%3d)%30s\n", (i + 1), dessertName.get(i));
		}
	}

	public void printDishPrices() {

		for (int i = 0; i < dishPrices.size(); i++) {
			System.out.printf("%3d)%30s\n", (i + 1), dishPrices.get(i));
		}
	}
}


/*********************************************************************************************
 * 
 * Student Name: Exequiel Repetto
 * Assignment number: Assignment 2
 * Course:  18W CST8130 - Data Structures
 * Date: 09/03/2018
 * Purpose of class:This class will create the items which are going to be allocated in an array List of type item
 * 
 * Data members:
 * 
 * ArrayList<Item> inventory  : ArrayList of type Item that will store all the items created by the user
 * numItems: used as a counter to know the amount of items created
 * 
 * Methods:
 * addItem():This method will add items to the array list
 * toString(): returns a string will all the data members values
 * alreadyExists(): this method will return the index of an item that is already stored in the array inventory
 * updateQuantity(): reads an item code to change the quantity
 * 
 * sortItems() This method is going to use binary search to sort items into the array list
 * writeFile () This method is going to write a .txt file with the inventory into the source folder of the program
 * fileReader() This method is going to read a file with elements and add them to the inventory
 * fileOutput() This method is use going to return a string with all elements on the array list
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Inventory extends Item {

	ArrayList<LinkedList<Item>> inventory;
	private int numItems;

	public Inventory() {
		inventory = new ArrayList<LinkedList<Item>>(100);
		numItems = 0;

		for (int i = 0; i < 100; i++) {

			inventory.add(i, new LinkedList<Item>());
		}

	}

	public boolean addItem(Scanner scan) {

		Item newItem;
		String option;
		System.out.println("Do you wish to add a purchased item (enter P/p) or manufactured (enter anything else)?");
		option = scan.next();

		if (option.equals("p") || option.equals("P"))
			newItem = new PurchasedItem();

		else
			newItem = new ManufacturedItem();

		while (!newItem.inputCode(scan)) {

		}

		 alreadyExist(newItem);

		if (!searchItem(inventory, newItem, newItem.position())) {
			newItem.addItem(scan);
			inventory.get(newItem.position()).add(newItem);
			numItems++;
		}

		else {
			System.out.println("item code already exist");
		}
		return true;
	}

	public String toString() {

		String inven = "Inventory: ";

		for (int i = 0; i < 100; i++) {

			if ((inventory.get(i).peek() != null))
				inven += inventory.get(i);

		}

		return inven;
	}

	public int alreadyExist(Item item) {

		boolean exist = false;
		int index = item.position();

		if (inventory.get(index).peek()==null) {

			index =-1;

			System.out.println("it doesnt exist");

		}
		
		else
			System.out.println("it  exist");

		return index;

	}

	// return index;
	//
	// }

	// public boolean updateQuantity(Scanner scan, boolean t) {
	//
	// Item itemTwo = new Item();
	// int amount = 0;
	// int index = 0;
	//
	// if (!(inventory.isEmpty())) {
	//
	// if (itemTwo.inputCode(scan) == true) {
	//
	// index = alreadyExist(itemTwo);
	//
	// if (index >= 0) {
	//
	// System.out.println("Enter valid quantity:");
	//
	// do {
	// amount = inputValues(scan);
	//
	// if (amount == -1)
	// System.out.println("Invalid quantity...please enter integer greater than
	// 0");
	//
	// } while (amount == -1);
	//
	// if (t == true)
	// inventory.get(index).updateItem(amount);
	//
	// else if (t == false)
	// inventory.get(index).updateItem(-amount);
	//
	// return true;
	// }
	//
	// else if (index < 0) {
	// return false;
	// }
	// }
	// return false;
	// }
	//
	// else
	// System.out.println("Inventory is empty\n");
	//
	// return true;
	// }

	

	public void writeFile(Scanner scan) {

		String fileName = "";

		try {

			System.out.print("Please name your file:");

			if (scan.hasNextLine())
				fileName = scan.next();

			FileWriter fileWriter = new FileWriter(new File("src/" + fileName + ".txt"));
			fileWriter.write(fileOutput());
			fileWriter.close();
			System.out.println("Your file has been created");

		} catch (IOException e) {
			System.out.println("Error writing your file, please try again");
			// scan.next();
			return;
		}
	}

	// public void fileReader(Scanner scan) {
	//
	// Item temp;
	// String fileName = new String();
	// Scanner inFile = null;
	// System.out.print("Enter name of file to process: ");
	// fileName = "src/" + scan.next();
	// System.out.println();
	// File file = new File(fileName);
	// int numOfItemsAdded = numItems;
	//
	// try {
	//
	// boolean done = false;
	// int option = 0;
	//
	// if (file.exists()) {
	// inFile = new Scanner(file);
	//
	// do {
	//
	// if (inFile.next().equals("p") || inFile.equals("P"))
	// temp = new PurchasedItem();
	// else
	// temp = new ManufacturedItem();
	//
	// if (temp.readFile(inFile))
	// ;
	//
	// else {
	// System.out.print("File is corrupted, could not load all items\n");
	//
	// while (!done) {
	//
	// System.out.println("\nPlease choose one of the following options:");
	// System.out.println("1 to display added items\n2 to delete added items\n3
	// go to main menu");
	//
	// do {
	//
	// if (scan.hasNextInt())
	// option = scan.nextInt();
	//
	// else {
	//
	// option = 0;
	// scan.next();
	// }
	//
	// if ((option < 1 || option > 3))
	// System.out.println("invalid option, please try again ");
	//
	// } while (!(option >= 1 || option <= 3));
	//
	// if (option == 1) {
	//
	// for (int i = numOfItemsAdded; i < numItems; i++)
	// System.out.print(inventory.get(i));
	// }
	//
	// else if (option == 2) {
	//
	// for (int i = numItems - 1; i > numOfItemsAdded; i--)
	// inventory.remove(i);
	//
	// System.out.print("Items deleted, back to main menu\n");
	// numItems = numOfItemsAdded;
	// done = true;
	// }
	//
	// else if (option == 3)
	// done = true;
	// }
	// }
	// if (done)
	// break;
	//
	// if (alreadyExist(temp) == -1) {
	// inventory.add(sortItems(temp), temp);
	// numItems++;
	// }
	//
	// } while (inFile.hasNext());
	//
	// }
	//
	// else {
	// System.out.println("File does not exist\n");
	// }
	//
	// } catch (IOException e) {
	// System.out.println("Could not open file: " + fileName);
	// }
	// }

	// public String fileOutput() {
	//
	// String info = "";
	//
	// for (int i = 0; i < numItems; i++) {
	// info += inventory.get(i).fileOutput() + "\n";
	// }
	// return info;
	// }

	public boolean searchItem(ArrayList<LinkedList<Item>> inventory, Item item, int index) {

		if (inventory.get(index).contains(item)) {

			return true;
		}

		else

			return false;

	}

}

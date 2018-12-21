
/*********************************************************************************************
 * 
 * Student Name: Exequiel Repetto
 * Assignment number: Assignment 2
 * Course:  18W CST8130 - Data Structures
 * Date: 09/03/2018
 * Purpose of class: This class contains most of all the data members and methods that are going to be extended to the other classes
 * Data members:
 *  
 * itemCode: It will hold the item-code for the item
 * itemName: It will hold the name of the item
 * itemQuantityStock: it will hold the quantity of items in stock
 * itemPrice: It will hold the price of the item
 * 
 * Methods:
 * addItem(): This method will read from the scanner and fill up all the data members
 * toString(): It will return a string containing all the information of the item
 * updateItem(): It will update the amount of quantityInStock data member
 * isEqual(): Method returns true if the itemCode we want to update already exist in our inventory
 * inputCode(): This method reads from the scanner and add the itemCode to the item
 * inputValues(): This method is going to read from the scanner and return an integer greater than 0 or -1 if invalid
 * 
 * readFile(): This method is going to use Scanner to read from a .txt file in a specific order all the elements
 * fileOutput(): This method is use to return all information of the item (use to write file only)
 * itemGreater(): use to know if 1  itemCode is greater than another one.
 * 
 * 
 * 
 */

import java.util.Scanner;

public class Item {

	private int itemCode;
	private String itemName;
	private int itemQuantityStock;
	private float itemPrice;

	public Item() {

		this.itemCode = 0;
		this.itemName = "";
		this.itemQuantityStock = 0;
		this.itemPrice = 0;
	}

	public boolean addItem(Scanner scan) {

		System.out.println("Enter the name for the item:");
		itemName = scan.next();
		System.out.println("Enter the quantity for the item:");

		do {

			itemQuantityStock = inputValues(scan);
			if (itemQuantityStock == -1)
				System.out.println("Invalid quantity...please enter integer greater than 0");

		} while (itemQuantityStock == -1);

		while (itemPrice <= 0) {

			System.out.println("Enter the price of the item:");

			if (scan.hasNextFloat()) {
				itemPrice = scan.nextFloat();

				if (itemPrice <= 0) {
					System.out.println("Invalid Price...please enter Float greater than 0");
				}
			}

			else {
				System.out.println("Invalid price...please enter float greater than 0");
				scan.next();
			}
		}
		return true;
	}

	public String toString() {
		return "\nItem: " + itemCode + " " + itemName + " " + itemQuantityStock + " Price: $" + itemPrice;
	}

	public boolean updateItem(int amount) {

		itemQuantityStock += amount;

		if (itemQuantityStock >= 0) {
			return true;
		}

		else
			itemQuantityStock -= amount;

		System.out.println("Error... could not sell item");

		return false;

	}

	public boolean isEqual(Item item) {

		if (item.itemCode == itemCode) {
			return true;
		}

		else
			return false;
	}

	public boolean inputCode(Scanner scan) {

		System.out.println("Enter the code for the item:");

		if(scan.hasNextInt()) {
		
			itemCode = scan.nextInt();

			if (itemCode >= 1)

				return true;
		}

		else {

			scan.next();
		}

		itemCode = 0;

		System.out.println("Invalid code...please enter integer greater than 0");

		return false;

	}

	public int inputValues(Scanner scan) {

		int input;

		if (scan.hasNextInt()) {
			input = scan.nextInt();

			if (input >= 1)
				return input;
		} else
			scan.next();

		return -1;

	}

	public boolean readFile(Scanner scan) {

		if (scan.hasNextInt())
			itemCode = scan.nextInt();
		else
			return false;

		if (scan.hasNext())
			itemName = scan.next();
		else
			return false;

		if (scan.hasNextInt())
			itemQuantityStock = scan.nextInt();
		else
			return false;

		if (scan.hasNextFloat())
			itemPrice = scan.nextFloat();
		else
			return false;

		return true;

	}

	public String fileOutput() {

		return itemCode + " " + itemName + " " + itemQuantityStock + " " + itemPrice;
	}

	public boolean itemGreater(Item item) {

		if (itemCode > item.itemCode)
			return true;

		else
			return false;

	}
	
	
	
	public int position(){
		

		return itemCode%100;
		
	}
	
	
	public int getItemCode(){
		
		
		return itemCode;
	}

}
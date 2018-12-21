/*********************************************************************************************
 * 
 * Student Name: Exequiel Repetto
 * Assignment number: Assignment 2
 * Course:  18W CST8130 - Data Structures
 * Date: 09/03/2018
 * Purpose of class: This class extends the Item class, is going to be use to create a manufactured item
 * 
 * Data members:
 * 
 * itemsUsed[]: array will stored up to 10 items code for a single item
 * numItemUsed: it will hold the amount of items code per item
 * 
 * Methods:
 * 
 * addItem(): It fill up all data members to create a manufactured Item
 * toString(): it will return all data members values in a string
 * 
 * readFile(): This method is used to read a file to store a ManufacturedItem
 * fileOutput(): this method is going to return members of the class as a string to be store in a .txt file
 * 
 */

import java.util.Scanner;

public class ManufacturedItem extends Item {

	private int itemsUsed[];
	private int numItemsUsed;

	public ManufacturedItem() {

		itemsUsed = new int[10];
		numItemsUsed=0;
		
	}

	public boolean addItem(Scanner scan) {

		super.addItem(scan);
		System.out.println("Enter up to 10 codes used in this item (-1 to quit):");
		inputCodes(scan);
		return true;

	}

	public String toString() {

		String codes = "\nCodes used: ";
		for (int i = 0; i < numItemsUsed; i++) {
			codes += Integer.toString(itemsUsed[i]) + ",";
		}
		return super.toString() + codes;
	}	
	
	public boolean inputCodes(Scanner scan){
		
		for (int i = 0; i < itemsUsed.length; i++) {

			itemsUsed[i] = inputValues(scan);

			if (itemsUsed[i] == -1) {
				break;
			}
			numItemsUsed++;
		}		
		return true;
	}
	
	
	public boolean readFile(Scanner scan){
		
		if(!super.readFile(scan))	
			return false;
		
		inputCodes(scan);		
		return true;
	}

	
	public String fileOutput(){
		
		String codes="";
		
		for (int i = 0; i < numItemsUsed; i++) {
			codes += Integer.toString(itemsUsed[i]) + " ";
		}
		
		if(numItemsUsed<10)
			codes +=Integer.toString(-1);
		
		return "m " + super.fileOutput()+ " "+codes;
	}
	
}

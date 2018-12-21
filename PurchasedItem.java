/*********************************************************************************************
 * 
 * Student Name: Exequiel Repetto
 * Assignment number: Assignment 2
 * Course:  18W CST8130 - Data Structures
 * Date: 09/03/2018
 * Purpose of class: This class extends the Item class, is going to be use to create a purchased item
 * 
 * Data Members:
 * 
 * supplierName: it will hold the supplier name of the item created
 * 
 * Methods:
 * 
 * addItem(): It fill up all data members to create a purchased Item
 * toString(): it will return all data members values in a string
 * 
 * readFile(): This method is used to read a file to store a PurchasedItem
 * fileOutput(): this method is going to return members of the class as a string to be store in a .txt file
 * 
 */

import java.util.Scanner;

public class PurchasedItem extends Item {

	private String supplierName;

	public PurchasedItem() {

	}

	public boolean addItem(Scanner scan) {

		super.addItem(scan);
		System.out.println("Enter the name of the supplier:");
		supplierName = scan.next();
		return true;
	}

	public String toString() {
		return super.toString() + "\nSupplier:" + supplierName;
	}

	public boolean readFile(Scanner scan){
		
		if(!super.readFile(scan))		
			return false;
		
		if(scan.hasNext())
			supplierName = scan.next();	
		else 
			return false;
		
		return true;
		
	}

	
	public String fileOutput(){
	
		return "p " + super.fileOutput() +" "+ supplierName;
	}
	
}

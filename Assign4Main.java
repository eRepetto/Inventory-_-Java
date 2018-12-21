
/*********************************************************************************************
 * 
 * Student Name: Exequiel Repetto
 * Assignment number: Assignment 2
 * Course:  18W CST8130 - Data Structures
 * Date: 09/03/2018
 * Purpose of class: This class contain the main method, which is going to run the program
 * 
 * 
 */

import java.util.Scanner;

public class Assign4Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String menu = "";
		Inventory inventory = new Inventory();
		boolean done = false;

		do {

			System.out.println(
					"\nEnter 1 to add an item to inventory\n2 to display current inventory\n3 buy some of an item\n4 sell some of an item\n5 to Write a file\n6 To read a file\n7 To exit");

			menu = scan.next();

			if (menu.equals("1")) {

				if (!inventory.addItem(scan)) {

					System.out.println("Inventory is full\n");
				}
			}

			else if (menu.equals("2")) {

				System.out.println(inventory);
			}

			else if (menu.equals("3")) {

				//if (inventory.updateQuantity(scan, true) == false) 

					System.out.println("Code not found in inventory...Error...could not buy item");
				
			}

			else if (menu.equals("4")) {

			//	if (inventory.updateQuantity(scan, false) == false) 

					System.out.println("Code not found in inventory...Error...could not sell item");
				
			}

			else if (menu.equals("5")) {

				inventory.writeFile(scan);
			}

			else if (menu.equals("6")) {

				//inventory.fileReader(scan);
			}

			else if (menu.equals("7")) {

				done = true;
			}

			else
				System.out.println("Invalid input, please try again");

		} while (!done);

	}

}

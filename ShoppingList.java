package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Cameron Barnes
 * Grand Circus Lab Bonus-20
 * July 25th, 2018
 */

public class ShoppingList {

	public static void main(String[] args) {
		// Scanner
		Scanner scnr = new Scanner(System.in);

		// Class variables
		String prompt;
		String newItem;
		String yesOrNo = "yes";

		// Class ArrayList
		ArrayList<String> shoppingCart = new ArrayList<String>(); // shopping cart

		// Class Map
		HashMap<String, Double> inventory = new HashMap<>(); // inventory

		// Fill inventory using method
		inventory = ShoppingListMethods.fillInventory(inventory);

		do {
			// displays the inventory using method
			ShoppingListMethods.displayInventory(inventory);

			// Enter item name
			prompt = "What would you like to order?";
			newItem = ShoppingListMethods.enterItem(scnr, inventory, prompt);

			// Add item to shopping cart
			shoppingCart.add(newItem);

			// Line for spacing
			System.out.println();

			// Continue Adding items
			yesOrNo = Validator.YesOrNo(scnr, "Would you like to order anything else (yes or no)?");

		} while (yesOrNo.equals("yes"));

		// Ending statements
		System.out.println("Thanks for your order!");
		System.out.println("Here's what you got: ");

		// Display items added to shopping cart
		ShoppingListMethods.displayShoppingCart(shoppingCart, inventory);

		// Display average of all items in cart
		ShoppingListMethods.average(shoppingCart, inventory);

		System.out.println("Press any key to continue");

		// Continue method call
		ShoppingListMethods.pressAnyKey(scnr, shoppingCart, inventory);

	}

}

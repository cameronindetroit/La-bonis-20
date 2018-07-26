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
		ArrayList<String> shoppingCart = new ArrayList<String>(); // shopping cart
		HashMap<String, Double> inventory = new HashMap<>(); // inventory

		String yesOrNo = "yes";

		inventory = ShoppingListMethods.fillInventory(inventory);
		// displays the inventory
		ShoppingListMethods.displayInventory(inventory);

		do {
			// Enter item name
			prompt = "What would you like to order?";
			// fills the Inventory
			newItem = ShoppingListMethods.enterItem(scnr, inventory, prompt);

			// Conditional to make sure valid item is being added to shopping cart

			shoppingCart.add(newItem);

			System.out.println();

			// System.out.println(shoppingCart);

			yesOrNo = Validator.YesOrNo(scnr, "Would you like to order anything else (yes or no)?");

		} while (yesOrNo.equals("yes"));

		System.out.println("Thanks for your order!");
		System.out.println("Here's what you got: ");
		ShoppingListMethods.displayShoppingCart(shoppingCart, inventory);

		ShoppingListMethods.average(shoppingCart, inventory);

		ShoppingListMethods.highest(shoppingCart, inventory);
		ShoppingListMethods.lowest(shoppingCart, inventory);

	}
}

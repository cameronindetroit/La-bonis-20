package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ShoppingListMethods {

	// Display shopping list cart
	public static void displayShoppingCart(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		ArrayList<String> tempArray = shoppingCart;
		String format2 = "%-12s    %s%n";

		for (int i = 0; i < tempArray.size(); i++) {

			String item = tempArray.get(i);

			System.out.printf(format2, item, inventory.get(item));

		}

	}

	// Enter item method
	public static String enterItem(Scanner scnr, HashMap<String, Double> inventory, String prompt) {
		System.out.println(prompt);
		String userInput = scnr.nextLine().toLowerCase();

		do {
			if (inventory.containsKey(userInput)) {
				System.out.println("confirmation! " + userInput + " added to cart!");

			} else {
				System.out.println("item is not available. Please choose an item in our inventory");
				return enterItem(scnr, inventory, prompt);
			}
		} while (!inventory.containsKey(userInput));

		return userInput;
	}

	// Fill inventory Method
	public static HashMap<String, Double> fillInventory(HashMap<String, Double> inventory) {

		inventory.put("apple", 0.99);
		inventory.put("banana", 0.59);
		inventory.put("cauliflower", 1.59);
		inventory.put("dragonfruit", 2.19);
		inventory.put("Elderberry", 1.79);
		inventory.put("figs", 2.09);
		inventory.put("grapefruit", 1.99);
		inventory.put("honeydew", 3.49);
		return inventory;

	}

	// Display Inventory Method
	public static void displayInventory(HashMap<String, Double> inventory) {

		// String format = "%s\t\t%s";
		String format2 = "%-12s    %s%n";
		System.out.printf(format2, "item", "price");

		System.out.println("======================");
		// Loop through inventory by key
		for (String item : inventory.keySet()) {
			System.out.printf(format2, item, inventory.get(item));

		}

	}

	// Calculate average of all items in cart method
	public static void average(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double sum = 0;// the total price, added together
		int count = 0; // the number of individual items
		for (String fruit : shoppingCart) {

			// sum get from the inventory,
			// the "value" of the "key" in this case fruit!
			sum += inventory.get(fruit);
			count++;

		}

		System.out.println("Average price: " + sum / count);
	}

	// Calculate most expensive in cart item method
	public static void highest(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double highest = 0.0;

		for (String fruit : shoppingCart) {

			if (highest < inventory.get(fruit)) {
				highest = inventory.get(fruit);
			}

		}
		System.out.println("The highest price for your items is: " + highest);
	}

	// calculate least expensive item in the cart method
	public static void lowest(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double lowest = 0.0;

		for (String fruit : shoppingCart) {

			if (lowest + 1.0 > inventory.get(fruit)) {
				lowest = inventory.get(fruit);
			}

		}
		System.out.println("The lowest price for your items is: " + lowest);
	}

	// Continue when any key is pushed method
	public static void pressAnyKey(Scanner scnr, ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		String userInput = scnr.next();

		if (userInput.equals("\\s.*")) {

		} else {
			// Display price of most expensive item
			ShoppingListMethods.highest(shoppingCart, inventory);

			// Display price of least expensive item
			ShoppingListMethods.lowest(shoppingCart, inventory);

			System.out.println("Exit Program");
		}

	}

}

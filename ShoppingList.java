package collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Cameron Barnes
 * Grand Circus Lab Bonus-20
 * July 25th, 2018
 */

// Display Inventory();
//-------------------------
// ask questions
// "prompt"
// "scnr"
//---------------------------
// average();
// highest();
// lowest();
//---------------------------
//Questions to ask
//Enter item name:
//Add another item?
//---------------------------

public class ShoppingList {

	public static void main(String[] args) {
		// Scanner
		Scanner scnr = new Scanner(System.in);

		// Class variables
		String prompt;
		String newItem;
		ArrayList<String> shoppingCart = new ArrayList<String>(); // shopping cart
		HashMap<String, Double> inventory = new HashMap<>(); // inventory
		boolean isValid = false;
		String yesOrNo = "yes";

		do {
			// Enter item name
			prompt = "What would you like to order?";
			// fills the Inventory
			inventory = fillInventory(inventory);
			// displays the inventory
			displayInventory(inventory);
			System.out.println();

			// add that item, to the shoppingCart
			newItem = enterItem(scnr, inventory, prompt);
			shoppingCart.add(newItem);
			System.out.println("Would you like to order anything else (y/n)?");
			yesOrNo = scnr.nextLine().toLowerCase();

			if (yesOrNo.equals("yes")) {
				yesOrNo.equals("yes");
				System.out.println(shoppingCart);
			} else {
				yesOrNo.equals("no");
			}

		} while (yesOrNo.equals("yes"));
		System.out.println("Exiting Program");

		// average();
		// highest();
		// lowest();

	}

	private static String enterItem(Scanner scnr, HashMap<String, Double> inventory, String prompt) {
		System.out.println(prompt);
		String userInput = scnr.nextLine().toLowerCase();

		if (inventory.containsKey(userInput)) {
			System.out.println("confirmation! " + userInput + " added to cart!");

		} else {
			System.out.println("item is not available. Please choose an item in out inventory");
			enterItem(scnr, inventory, prompt);
		}

		return userInput;
	}

	private static HashMap<String, Double> fillInventory(HashMap<String, Double> inventory) {
		// TODO Auto-generated method stub
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

	private static void displayInventory(HashMap<String, Double> inventory) {

		String format = "%s\t\t%s";
		String format2 = "%-12s    %s%n";
		System.out.printf(format2, "item", "price");

		System.out.println("======================");
		// Loop through inventory by key
		for (String item : inventory.keySet()) {
			System.out.printf(format2, item, inventory.get(item));

		}

	}

}

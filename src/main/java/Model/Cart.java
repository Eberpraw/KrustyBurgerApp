package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a shopping cart.
 * It contains a list of items and provides methods to manipulate and retrieve information about the items.
 */
public class Cart {
    // Declare a variable of type List and call it items
    // This list can  contain objects of the Items class
    private List<Items> items;

    /**
     * Constructs a new Cart object.
     * Initializes the items list as an empty ArrayList.
     */
    // Constructure of the Cart class
    // It initializes the items list as an empty ArrayList
    public Cart() {
        items = new ArrayList<>();
    }

    /**
     * Adds an item to the cart.
     *
     * @param item the item to be added
     */
    // Method to add an item to the cart
    // It takes an object of the Items class as a parameter
    // Void as it does not return a value
    public void addItem(Items item) {
        items.add(item);
    }

    /**
     * Returns the list of items in the cart.
     *
     * @return the list of items in the cart
     */
    public List<Items> getItems() {
        return items;
    }

    /**
     * Calculates and returns the total price of all items in the cart.
     *
     * @return the total price of all items in the cart
     */
    // Here I use a for-each loop to iterate over the items in the cart
    // In the for-each loop I create a variable of type Items and call it item
    public double getTotalPrice() {

        double total = 0;
        for (Items item : items) {
            total += item.getPrice(); // The same as total = total + item.getPrice();
        }
        return total;
    }
}

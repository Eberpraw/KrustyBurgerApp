package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a shopping cart.
 * It contains a list of items and provides methods to manipulate and retrieve information about the items.
 */
public class Cart {
    private List<Items> items;

    /**
     * Constructs a new Cart object.
     * Initializes the items list as an empty ArrayList.
     */
    public Cart() {
        items = new ArrayList<>();
    }

    /**
     * Adds an item to the cart.
     *
     * @param item the item to be added
     */
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
    public double getTotalPrice() {

        double total = 0;
        for (Items item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

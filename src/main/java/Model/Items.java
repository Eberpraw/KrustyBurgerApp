package Model;

import javafx.scene.image.Image;

/**
 * This abstract class represents an item with a name, price, and image.
 * It provides the base for other specific item types in the application.
 */
public abstract class Items {
    private String name;
    private double price;
    private Image image;

    /**
     * Constructs a new item with the specified name, price, and image.
     *
     * @param name  the name of the item
     * @param price the price of the item
     * @param image the image of the item
     */
    public Items(String name, double price, Image image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    /**
     * Returns the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item.
     *
     * @param name the new name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of the item.
     *
     * @return the price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the item.
     *
     * @param price the new price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the image of the item.
     *
     * @return the image of the item
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the image of the item.
     *
     * @param image the new image of the item
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Returns a string representation of the item, including its name and price.
     *
     * @return a string representation of the item
     */
    @Override
    public String toString() {
        return name + " $" + price;
    }

    /**
     * This method is intended to be overridden by subclasses to add an item to a collection.
     *
     * @param items the item to be added
     */
    public void add(Items items) {
    }
}

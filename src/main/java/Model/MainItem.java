package Model;

import javafx.scene.image.Image;

/**
 * This class represents a main item in the menu.
 * It extends the Items class, inheriting its properties and methods.
 */
public class MainItem extends Items {

    /**
     * Constructs a new MainItem with the specified name, price, and image.
     *
     * @param name  the name of the main item
     * @param price the price of the main item
     * @param image the image of the main item
     */
    public MainItem(String name, double price, Image image) {
        super(name, price, image);
    }
}
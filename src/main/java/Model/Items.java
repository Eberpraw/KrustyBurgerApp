package Model;

import javafx.scene.image.Image;

public abstract class Items {
    private String name;
    private double price;
    private Image image;

    public Items(String name, double price, Image image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }

    public void add(Items items) {
    }
}

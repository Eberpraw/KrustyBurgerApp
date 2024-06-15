package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Model.Cart;
import Model.DrinkItem;
import Model.MainItem;
import Model.SideItem;

public class MainViewController {
    @FXML
    private Label stepLabel;
    @FXML
    private ImageView itemImageView;
    @FXML
    private Label itemNameLabel;
    @FXML
    private Label itemPriceLabel;

    private MainItem[] mainItems = {
            new MainItem("Krusty Burger w/Cheese", 5.99, new Image(getClass().getResource("/Images/KrustyBurgerWCheese.png").toString())),
            new MainItem("Double Krusty Burger w/Cheese", 8.99, new Image(getClass().getResource("/Images/DoubleKrustyBurgerWCheese.png").toString())),
            new MainItem("Ribwich", 4.99, new Image(getClass().getResource("/Images/Ribwich.png").toString())),
            new MainItem("Mother Nature Burger", 4.99, new Image(getClass().getResource("/Images/MotherNatureBurger.png").toString()))
    };

    private SideItem[] sideItems = {
            new SideItem("Fries", 2.99, new Image(getClass().getResource("/Images/KrustyBurgerWCheese.png").toString())),
            new SideItem("Onion Rings", 3.49, new Image(getClass().getResource("/Images/KrustyBurgerWCheese.png").toString())),
            new SideItem("Salad", 2.99, new Image(getClass().getResource("/Images/KrustyBurgerWCheese.png").toString()))
    };

    private DrinkItem[] drinkItems = {
            new DrinkItem("Soda", 1.99, new Image(getClass().getResource("/Images/KrustyBurgerWCheese.png").toString())),
            new DrinkItem("Juice", 2.49, new Image(getClass().getResource("/Images/KrustyBurgerWCheese.png").toString())),
            new DrinkItem("Water", 0.99, new Image(getClass().getResource("/Images/KrustyBurgerWCheese.png").toString()))
    };

    private int mainItemIndex;
    private int sideItemIndex;
    private int drinkItemIndex;

    private Cart cart;

    public void initialize() {
        mainItemIndex = 0;
        sideItemIndex = 0;
        drinkItemIndex = 0;
        cart = new Cart();

        showCurrentMainItem();
        stepLabel.setText("Select Main Item:");
    }

    private void showCurrentMainItem() {
        MainItem currentItem = mainItems[mainItemIndex];
        itemNameLabel.setText(currentItem.getName());
        itemPriceLabel.setText("$" + currentItem.getPrice());
        itemImageView.setImage(currentItem.getImage());
    }

    private void showCurrentSideItem() {
        SideItem currentItem = sideItems[sideItemIndex];
        itemNameLabel.setText(currentItem.getName());
        itemPriceLabel.setText("$" + currentItem.getPrice());
        itemImageView.setImage(currentItem.getImage());
    }

    private void showCurrentDrinkItem() {
        DrinkItem currentItem = drinkItems[drinkItemIndex];
        itemNameLabel.setText(currentItem.getName());
        itemPriceLabel.setText("$" + currentItem.getPrice());
        itemImageView.setImage(currentItem.getImage());
    }

    @FXML
    private void handleNextItem() {
        if (stepLabel.getText().equals("Select Main Item:")) {
            // Move to the next main item
            mainItemIndex = (mainItemIndex + 1) % mainItems.length;
            showCurrentMainItem();
        } else if (stepLabel.getText().equals("Select Side Item:")) {
            // Move to the next side item
            sideItemIndex = (sideItemIndex + 1) % sideItems.length;
            showCurrentSideItem();
        } else if (stepLabel.getText().equals("Select Drink Item:")) {
            // Move to the next drink item
            drinkItemIndex = (drinkItemIndex + 1) % drinkItems.length;
            showCurrentDrinkItem();
        }
    }

    @FXML
    private void handlePreviousItem() {
        if (stepLabel.getText().equals("Select Main Item:")) {
            // Move to the previous main item
            mainItemIndex = (mainItemIndex - 1 + mainItems.length) % mainItems.length;
            showCurrentMainItem();
        } else if (stepLabel.getText().equals("Select Side Item:")) {
            // Move to the previous side item
            sideItemIndex = (sideItemIndex - 1 + sideItems.length) % sideItems.length;
            showCurrentSideItem();
        } else if (stepLabel.getText().equals("Select Drink Item:")) {
            // Move to the previous drink item
            drinkItemIndex = (drinkItemIndex - 1 + drinkItems.length) % drinkItems.length;
            showCurrentDrinkItem();
        }
    }

    @FXML
    private void handleAddToCart() {
        if (stepLabel.getText().equals("Select Main Item:")) {
            // Add selected main item to cart
            MainItem selectedItem = mainItems[mainItemIndex];
            cart.addItem(selectedItem);
            stepLabel.setText("Select Side Item:");
            showCurrentSideItem(); // Show initial side item after main item selection
        } else if (stepLabel.getText().equals("Select Side Item:")) {
            // Add selected side item to cart
            SideItem selectedItem = sideItems[sideItemIndex];
            cart.addItem(selectedItem);
            stepLabel.setText("Select Drink Item:");
            showCurrentDrinkItem(); // Show initial drink item after side item selection
        } else if (stepLabel.getText().equals("Select Drink Item:")) {
            // Add selected drink item to cart
            DrinkItem selectedItem = drinkItems[drinkItemIndex];
            cart.addItem(selectedItem);
            stepLabel.setText("Review and Add to Cart:");
        }
    }
}


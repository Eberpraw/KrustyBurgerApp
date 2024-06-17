package Controllers;

import Model.*;
import javafx.collections.transformation.TransformationList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {
    @FXML
    private Label stepLabel;
    @FXML
    private ImageView itemImageView;
    @FXML
    private Label itemNameLabel;
    @FXML
    private Label itemPriceLabel;
    @FXML
    private Button addToCartButton;
    @FXML
    private Button goToCartButton;
    @FXML
    private Button nextItemButton;
    @FXML
    private Button previousItemButton;

    SFX sfx = new SFX();

    private MainItem[] mainItems = {
            new MainItem("Krusty Burger", 5.99, new Image(getClass().getResource("/Images/KrustyBurgerWCheese.png").toString())),
            new MainItem("Double Krusty Burger", 8.99, new Image(getClass().getResource("/Images/DoubleKrustyBurgerWCheese.png").toString())),
            new MainItem("Ribwich", 4.99, new Image(getClass().getResource("/Images/Ribwich.png").toString())),
            new MainItem("Mother Nature Burger", 4.99, new Image(getClass().getResource("/Images/MotherNatureBurger.png").toString()))
    };

    private SideItem[] sideItems = {
            new SideItem("Fries", 2.99, new Image(getClass().getResource("/Images/Fries.png").toString())),
            new SideItem("Onion Rings", 3.49, new Image(getClass().getResource("/Images/OnionRings.png").toString())),
            new SideItem("Krusty Loaded Fries", 2.99, new Image(getClass().getResource("/Images/LoadedFries.png").toString()))
    };

    private DrinkItem[] drinkItems = {
            new DrinkItem("Buzz Cola", 1.99, new Image(getClass().getResource("/Images/BuzzCola.png").toString())),
            new DrinkItem("Mystery Shake", 2.49, new Image(getClass().getResource("/Images/Shake.png").toString())),
            new DrinkItem("Generic Orange Drink", 0.99, new Image(getClass().getResource("/Images/GenericOrangeDrink.png").toString()))
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

        // Enable automatic line breaks in text
        itemNameLabel.setWrapText(true);
        itemPriceLabel.setWrapText(true);

        showCurrentMainItem();
        stepLabel.setText("Select Main Item");

        addToCartButton.setVisible(true);
        goToCartButton.setVisible(false);
        /**
         * Sets the action to be invoked when this button is pressed.
         * The `openCartView` method will be called when the `goToCartButton` is clicked.
         */
        goToCartButton.setOnAction(this::openCartView);

        Animations.buttonAnimation(addToCartButton);
        Animations.buttonAnimation(goToCartButton);
        Animations.buttonAnimation(nextItemButton);
        Animations.buttonAnimation(previousItemButton);
    }

    /**
     * This method is used to display the current main item in the selection process.
     * It sets the name, price, and image of the current main item to the respective labels and ImageView.
     */
    private void showCurrentMainItem() {
        MainItem currentItem = mainItems[mainItemIndex];
        itemNameLabel.setText(currentItem.getName());
        itemPriceLabel.setText("$" + currentItem.getPrice());
        itemImageView.setImage(currentItem.getImage());
    }

    /**
     * This method is used to display the current side item in the selection process.
     * It sets the name, price, and image of the current side item to the respective labels and ImageView.
     */
    private void showCurrentSideItem() {
        SideItem currentItem = sideItems[sideItemIndex];
        itemNameLabel.setText(currentItem.getName());
        itemPriceLabel.setText("$" + currentItem.getPrice());
        itemImageView.setImage(currentItem.getImage());
    }

    /**
     * This method is used to display the current drink item in the selection process.
     * It sets the name, price, and image of the current drink item to the respective labels and ImageView.
     */
    private void showCurrentDrinkItem() {
        DrinkItem currentItem = drinkItems[drinkItemIndex];
        itemNameLabel.setText(currentItem.getName());
        itemPriceLabel.setText("$" + currentItem.getPrice());
        itemImageView.setImage(currentItem.getImage());
    }

    /**
     * This method handles the action of moving to the next item in the selection process.
     * It plays a sound effect and checks the current selection step.
     * If the step is "Select Main Item", it moves to the next main item and displays it.
     * If the step is "Select Side Item", it moves to the next side item and displays it.
     * If the step is "Select Drink Item", it moves to the next drink item and displays it.
     */
    @FXML
    private void handleNextItem() {
        sfx.playSoundEffect("AudioFiles/ButtonClick.wav");
        if (stepLabel.getText().equals("Select Main Item")) {
            // Move to the next main item
            mainItemIndex = (mainItemIndex + 1) % mainItems.length;
            showCurrentMainItem();
        } else if (stepLabel.getText().equals("Select Side Item")) {
            // Move to the next side item
            sideItemIndex = (sideItemIndex + 1) % sideItems.length;
            showCurrentSideItem();
        } else if (stepLabel.getText().equals("Select Drink Item")) {
            // Move to the next drink item
            drinkItemIndex = (drinkItemIndex + 1) % drinkItems.length;
            showCurrentDrinkItem();
        }
    }

    /**
     * This method handles the action of moving to the previous item in the selection process.
     * It plays a sound effect and checks the current selection step.
     * If the step is "Select Main Item", it moves to the previous main item and displays it.
     * If the step is "Select Side Item", it moves to the previous side item and displays it.
     * If the step is "Select Drink Item", it moves to the previous drink item and displays it.
     */
    @FXML
    private void handlePreviousItem() {
        sfx.playSoundEffect("AudioFiles/ButtonClick.wav");
        if (stepLabel.getText().equals("Select Main Item")) {
            // Move to the previous main item
            mainItemIndex = (mainItemIndex - 1 + mainItems.length) % mainItems.length;
            showCurrentMainItem();
        } else if (stepLabel.getText().equals("Select Side Item")) {
            // Move to the previous side item
            sideItemIndex = (sideItemIndex - 1 + sideItems.length) % sideItems.length;
            showCurrentSideItem();
        } else if (stepLabel.getText().equals("Select Drink Item")) {
            // Move to the previous drink item
            drinkItemIndex = (drinkItemIndex - 1 + drinkItems.length) % drinkItems.length;
            showCurrentDrinkItem();
        }
    }

    /**
     * This method handles the action of adding items to the cart.
     * It plays a sound effect and checks the current selection step.
     * If the step is "Select Main Item", it adds the selected main item to the cart and updates the step to "Select Side Item".
     * If the step is "Select Side Item", it adds the selected side item to the cart and updates the step to "Select Drink Item".
     * If the step is "Select Drink Item", it adds the selected drink item to the cart and makes the "Go to Cart" button visible.
     */
    @FXML
    private void handleAddToCart() {
        sfx.playSoundEffect("AudioFiles/chaching.wav");
        if (stepLabel.getText().equals("Select Main Item")) {
            // Add selected main item to cart
            MainItem selectedItem = mainItems[mainItemIndex];
            cart.addItem(selectedItem);
            stepLabel.setText("Select Side Item");
            showCurrentSideItem(); // Show initial side item after main item selection
        } else if (stepLabel.getText().equals("Select Side Item")) {
            // Add selected side item to cart
            SideItem selectedItem = sideItems[sideItemIndex];
            cart.addItem(selectedItem);
            stepLabel.setText("Select Drink Item");
            showCurrentDrinkItem(); // Show initial drink item after side item selection
        } else if (stepLabel.getText().equals("Select Drink Item")) {
            // Add selected drink item to cart
            DrinkItem selectedItem = drinkItems[drinkItemIndex];
            cart.addItem(selectedItem);
            addToCartButton.setVisible(false);
            goToCartButton.setVisible(true);
        }
    }

    /**
     * This method handles the action of opening the cart view.
     * It plays a sound effect and loads the CartView.fxml file to display the cart contents.
     * @param event The ActionEvent object generated when the "Go to Cart" button is clicked.
     */
    public void openCartView(ActionEvent event) {
        try {
            sfx.playSoundEffect("AudioFiles/KrustyLaugh.wav");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Interfaces/CartView.fxml"));
            Parent newSceneParent = loader.load();
            Scene newScene = new Scene(newSceneParent);

            CartViewController controller = loader.getController();
            controller.setCart(cart);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();
        } catch (IOException e) {
            sfx.playSoundEffect("AudioFiles/Crap.wav");
            e.printStackTrace();
        }
    }
}


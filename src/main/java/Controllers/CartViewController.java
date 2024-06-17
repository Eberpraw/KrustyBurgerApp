package Controllers;

import Model.Animations;
import Model.SFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Model.Cart;
import Model.Items;

import java.io.IOException;

public class CartViewController {
    @FXML
    private Text cartTextArea;
    @FXML
    private Text cartPriceArea;
    @FXML
    private Text cartTotalPrice;
    @FXML
    HBox productImages;
    @FXML
    private Button backToMainViewButton;
    @FXML
    private Button completePurchase;

    private Cart cart;

    SFX sfx = new SFX();

    /**
     * This method is used to set the cart and display its contents.
     * It assigns the provided Cart object to the cart field and then calls the displayCartContents method.
     *
     * @param cart The Cart object to be set.
     */
    public void setCart(Cart cart) {
        this.cart = cart;
        displayCartContents();
    }

    /**
     * This method is used to display the contents of the cart.
     * It creates an HBox for item images, and StringBuilder objects for cart contents, prices, and total price.
     * It then iterates over the items in the cart, appending each item's name and price to the respective StringBuilder,
     * and adding an ImageView of each item to the imageBox.
     * Finally, it sets the text of the cartTextArea, cartPriceArea, and cartTotalPrice to the respective StringBuilder contents,
     * and adds the imageBox to the productImages HBox.
     */
    private void displayCartContents() {
        HBox imageBox = new HBox();
        imageBox.setSpacing(-10);
        StringBuilder cartContents = new StringBuilder();
        StringBuilder cartPrice = new StringBuilder();
        StringBuilder cartTotal = new StringBuilder();
        for (Items items : cart.getItems()) {
            // Append item name and price separately
            cartContents.append("1x ").append(items.getName()).append("\n");
            cartPrice.append("$").append(items.getPrice()).append("\n");

            ImageView itemImage = new ImageView(items.getImage());
            itemImage.setFitHeight(100);
            itemImage.setFitWidth(100);
            imageBox.getChildren().add(itemImage);
        }
        cartTotal.append("\nTotal: $").append(cart.getTotalPrice());
        cartTextArea.setText(cartContents.toString());
        cartPriceArea.setText(cartPrice.toString());
        cartTotalPrice.setText(cartTotal.toString());
        productImages.getChildren().add(imageBox);
    }

    public void initialize() {
        Animations.buttonAnimation(backToMainViewButton);
        Animations.buttonAnimation(completePurchase);
    }

    /**
     * This method is used to navigate back to the Main view.
     * It plays a sound effect, loads the MainView.fxml file, and sets the scene on the current window.
     *
     * @param event The action event that triggered this method.
     * @throws IOException If an input or output exception occurred.
     */
    @FXML
    private void handleBackToMainView(ActionEvent event) throws IOException {
        sfx.playSoundEffect("AudioFiles/GetLost.wav");
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("/Interfaces/MainView.fxml"));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }


    /**
     * This method is used to navigate to the Receipt view.
     * It plays a sound effect, loads the ReceiptView.fxml file, and sets the scene on the current window.
     *
     * @param event The action event that triggered this method.
     * @throws IOException If an input or output exception occurred.
     */
    @FXML
    public void goToReceipt(ActionEvent event) throws IOException {
        sfx.playSoundEffect("AudioFiles/KrustyLaugh.wav");
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("/Interfaces/ReceiptView.fxml"));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
}

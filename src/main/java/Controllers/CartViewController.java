package Controllers;

import Model.Animations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

    public void setCart(Cart cart) {
        this.cart = cart;
        displayCartContents();
    }

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

    @FXML
    private void handleBackToMainView(ActionEvent event) throws IOException {
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("/Interfaces/MainView.fxml"));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }


    @FXML
    public void goToReceipt(ActionEvent event) throws IOException {
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("/Interfaces/ReceiptView.fxml"));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
}

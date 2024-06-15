package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
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

    private Cart cart;

    public void setCart(Cart cart) {
        this.cart = cart;
        displayCartContents();
    }

    private void displayCartContents() {
        StringBuilder cartContents = new StringBuilder();
        StringBuilder cartPrice = new StringBuilder();
        StringBuilder cartTotal = new StringBuilder();
        for (Items items : cart.getItems()) {
            // Append item name and price separately
            cartContents.append("").append(items.getName()).append("\n");
            cartPrice.append("$").append(items.getPrice()).append("\n");
        }
        cartTotal.append("\nTotal: $").append(cart.getTotalPrice());
        cartTextArea.setText(cartContents.toString());
        cartPriceArea.setText(cartPrice.toString());
        cartTotalPrice.setText(cartTotal.toString());
    }

    @FXML
    private void handleBackToMainView() {
        try {
            Stage stage = (Stage) cartTextArea.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
            VBox mainView = loader.load();

            MainViewController controller = loader.getController();
            controller.initialize();

            stage.setScene(new Scene(mainView));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

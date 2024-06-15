package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.Cart;
import Model.Items;

import java.io.IOException;

public class CartViewController {
    @FXML
    private TextArea cartTextArea;

    private Cart cart;

    public void setCart(Cart cart) {
        this.cart = cart;
        displayCartContents();
    }

    private void displayCartContents() {
        cartTextArea.clear();
        for (Items items : cart.getItems()) {
            cartTextArea.appendText(items + "\n");
        }
        cartTextArea.appendText("Total: $" + cart.getTotalPrice());
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

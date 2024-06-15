package Controllers;

import Model.Cart;
import Model.DrinkItem;
import Model.MainItem;
import Model.SideItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemsController {
    @FXML
    private ComboBox<MainItem> mainItemComboBox;
    @FXML
    private ComboBox<SideItem> sideItemComboBox;
    @FXML
    private ComboBox<DrinkItem> drinkItemComboBox;
    @FXML
    private TextArea cartTextArea;
    @FXML
    private Label stepLabel;

    private Cart cart;
    private int step;

    @FXML
    public void initialize() {
        cart = new Cart();
        step = 1;

        ObservableList<MainItem> mainItems = FXCollections.observableArrayList(
                new MainItem("Burger", 5.99, new Image("file:images/burger.png")),
                new MainItem("Pizza", 8.99, new Image("file:images/pizza.png")),
                new MainItem("Salad", 4.99, new Image("file:images/salad.png"))
        );

        ObservableList<SideItem> sideItems = FXCollections.observableArrayList(
                new SideItem("Fries", 2.99, new Image("file:images/fries.png")),
                new SideItem("Onion Rings", 3.49, new Image("file:images/onion_rings.png")),
                new SideItem("Salad", 2.99, new Image("file:images/salad.png"))
        );

        ObservableList<DrinkItem> beverageItems = FXCollections.observableArrayList(
                new DrinkItem("Soda", 1.99, new Image("file:images/soda.png")),
                new DrinkItem("Juice", 2.49, new Image("file:images/juice.png")),
                new DrinkItem("Water", 0.99, new Image("file:images/water.png"))
        );

        mainItemComboBox.setItems(mainItems);
        sideItemComboBox.setItems(sideItems);
        drinkItemComboBox.setItems(beverageItems);

        sideItemComboBox.setVisible(false);
        drinkItemComboBox.setVisible(false);
    }
    @FXML
    private void handleNextStep() {
        switch (step) {
            case 1:
                if (mainItemComboBox.getValue() != null) {
                    cart.addItem(mainItemComboBox.getValue());
                    mainItemComboBox.setDisable(true);
                    sideItemComboBox.setVisible(true);
                    stepLabel.setText("Select a Side Item:");
                    step++;
                }
                break;
            case 2:
                if (sideItemComboBox.getValue() != null) {
                    cart.addItem(sideItemComboBox.getValue());
                    sideItemComboBox.setDisable(true);
                    drinkItemComboBox.setVisible(true);
                    stepLabel.setText("Select a Beverage Item:");
                    step++;
                }
                break;
            case 3:
                if (drinkItemComboBox.getValue() != null) {
                    cart.addItem(drinkItemComboBox.getValue());
                    showCartView();
                }
                break;
        }
    }

    private void showCartView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CartView.fxml"));
            VBox cartView = loader.load();

            CartViewController controller = loader.getController();
            controller.setCart(cart);

            Stage stage = (Stage) cartTextArea.getScene().getWindow();
            stage.setScene(new Scene(cartView));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

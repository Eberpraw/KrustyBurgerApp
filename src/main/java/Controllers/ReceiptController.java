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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ReceiptController {

    private String receipt;

    private static int orderNumber = 0;

    @FXML
    private Text orderNumberText;

    @FXML
    private Button exitButton;

    SFX sfx = new SFX();

    /**
     * This method is used to print the receipt for an order.
     * It increments the order number by one each time a receipt is printed, resetting to zero when it reaches 99.
     * The order number is then displayed on the orderNumberText Text object, prefixed with a '#'.
     */
    public void printReceipt() {
        if (orderNumber >= 99) {
            orderNumber = 0;
        } else {
            orderNumber++;
        }
        orderNumberText.setText("#" + orderNumber);
    }

    public void initialize() {
        sfx.playSoundEffect("AudioFiles/krusty-the-clown.wav");
        printReceipt();
        Animations.buttonAnimation(exitButton);
    }

    /**
     * This method is used to handle the action event of exiting an order.
     * It stops any sound effect that is currently playing, loads a new scene from the 'AppView.fxml' file,
     * and sets this new scene on the current stage.
     *
     * @param event An ActionEvent which indicates that a set action occurred on a node.
     * This event is used to get the source of the event, which is then used to get the current stage.
     * @throws IOException If an I/O error occurs during loading the FXML file.
     */
    @FXML
    public void exitOrder(ActionEvent event) throws IOException {
        sfx.stopSoundEffect();
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("/Interfaces/AppView.fxml"));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

}

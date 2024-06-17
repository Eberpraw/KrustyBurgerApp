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

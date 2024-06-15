package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label welcomeText2;

    Font titleFont;

    @FXML
    public void initialize() {
        titleFont = Font.loadFont(getClass().getResource("/Fonts/Alphakind.ttf").toExternalForm(), 65);
        welcomeText.setFont(titleFont);
        welcomeText.setText("Krusty\nBurger");
        welcomeText2.setText("HEY HEY! Welcome to");
    }

    @FXML
    public void changeScene(ActionEvent event) throws IOException {
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("/Interfaces/MainView.fxml"));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
}
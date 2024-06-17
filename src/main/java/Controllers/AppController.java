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
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {
    @FXML
    private Text welcomeText;
    @FXML
    private Text welcomeText2;
    @FXML
    Button startButton;

    Font titleFont;
    Font smallTitleFont;

    SFX sfx = new SFX();

    @FXML
    public void initialize() {
        titleFont = Font.loadFont(getClass().getResource("/Fonts/Alphakind.ttf").toExternalForm(), 75);
        smallTitleFont = Font.loadFont(getClass().getResource("/Fonts/Alphakind.ttf").toExternalForm(), 30);
        welcomeText.setFont(titleFont);
        welcomeText2.setFont(smallTitleFont);
        welcomeText.setText("Krusty\nBurger");
        welcomeText.setLineSpacing(-20);
        welcomeText.setFill(Color.web("#f93736"));
        welcomeText.setStroke(Color.web("#66310e"));
        welcomeText.setStrokeWidth(3.0);
        welcomeText2.setFill(Color.web("#f93736"));
        welcomeText2.setStroke(Color.web("#66310e"));
        welcomeText2.setStrokeWidth(2);
        welcomeText2.setText("Welcome to");

        // Load Animation Class
        Animations.buttonAnimation(startButton);

        // Start Sound Effect
        sfx.playSoundEffect("AudioFiles/KrustyLaugh.wav");
    }

    @FXML
    public void changeScene(ActionEvent event) throws IOException {
        sfx.playSoundEffect("AudioFiles/HeyHey.wav");
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("/Interfaces/MainView.fxml"));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
}
package Model;

import javafx.animation.ScaleTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Animations {

    /**
     * This method is used to animate a button with a scale transition.
     * The button scales up and down when pressed.
     *
     * @param button The button to animate.
     */
    public static void buttonAnimation(Button button) {
        // Create a scale transition
        ScaleTransition st = new ScaleTransition(Duration.millis(100), button);
        st.setByX(0.15);  // scale factor for x-axis
        st.setByY(0.15);  // scale factor for y-axis
        st.setCycleCount(2);  // number of cycles
        st.setAutoReverse(true);  // reverse the animation

        // Create a flag to indicate whether the animation has finished
        final boolean[] animationFinished = {true};

        // Set a handler that is called when the animation has finished
        st.setOnFinished(event -> animationFinished[0] = true);

        // Set the mouse pressed event
        button.setOnMousePressed(event -> {
            if (animationFinished[0]) {
                animationFinished[0] = false;
                st.playFromStart();
            }
        });
    }
}

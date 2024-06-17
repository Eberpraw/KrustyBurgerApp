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

        /**
         * Sets an event handler to be called when the animation has finished.
         * The event handler is represented by a lambda expression that sets the first element of the animationFinished array to true.
         * This indicates that the animation has completed.
         *
         * @param event An ActionEvent which indicates that a set action occurred on a node.
         * This event is passed to the lambda expression, which doesn't use it in this case.
         */
        st.setOnFinished(event -> animationFinished[0] = true);

        /**
         * Sets an event handler to be called when the button is pressed.
         * The event handler is represented by a lambda expression that checks if the animation has finished.
         * If it has, it sets animationFinished[0] to false and starts the animation from the beginning.
         *
         * @param event A MouseEvent which indicates that a mouse action occurred on a node.
         * This event is passed to the lambda expression, which doesn't use it in this case.
         */
        button.setOnMousePressed(event -> {
            if (animationFinished[0]) {
                animationFinished[0] = false;
                st.playFromStart();
            }
        });
    }
}

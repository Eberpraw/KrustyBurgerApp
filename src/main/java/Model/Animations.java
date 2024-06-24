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
    // Declared as static because it's a utility method that doesn't depend
    // on any instance variables of the Animations class.
    // It can be called without creating an instance of the Animations class.
    public static void buttonAnimation(Button button) {
        // Create a scale transition
        ScaleTransition st = new ScaleTransition(Duration.millis(100), button);
        st.setByX(0.15);  // scale factor for x-axis
        st.setByY(0.15);  // scale factor for y-axis
        st.setCycleCount(2);  // number of cycles
        st.setAutoReverse(true);  // reverse the animation

        // Create a flag to indicate whether the animation has finished
        // Variables used in Lambdas must be "final" so they can't be modified
        final boolean[] animationFinished = {true};

        /**
         * Sets an event handler to be called when the animation has finished.
         * The event handler is represented by a lambda expression that sets the first element of the animationFinished array to true.
         * This indicates that the animation has completed.
         *
         * @param event An ActionEvent which indicates that a set action occurred on a node.
         * This event is passed to the lambda expression, which doesn't use it in this case.
         */
        // Lambda expression is used as an event handler
        // It sets the first element in the animationFinished array to true
        // Indicating that the animation has finished
        // This is used to prevent multiple animations from running simultaneously

        // Use Lambdas as a reusable piece of code that can be
        // applied to any Button object to animate it.
        // Meaning I don't have to write multiple event handlers in the controllers
        // for each button that needs to be animated.
        // The compiler will figure out the rest.
        st.setOnFinished(event -> animationFinished[0] = true);

        /**
         * Sets an event handler to be called when the button is pressed.
         * The event handler is represented by a lambda expression that checks if the animation has finished.
         * If it has, it sets animationFinished[0] to false and starts the animation from the beginning.
         *
         * @param event A MouseEvent which indicates that a mouse action occurred on a node.
         * This event is passed to the lambda expression, which doesn't use it in this case.
         */
        // Lambda expression is used as an event handler
        // It checks if the animation has finished
        button.setOnMousePressed(event -> {
            if (animationFinished[0]) {
                animationFinished[0] = false;
                st.playFromStart();
            }
        });
    }
}

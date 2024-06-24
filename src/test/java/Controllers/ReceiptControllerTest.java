package Controllers;

import javafx.scene.text.Text;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptControllerTest {

    // Declare a variable called receiptController of type ReceiptController
    ReceiptController receiptController;

    // Test the printReceipt method
    @Test
    void printReceiptTest() {
        // Create a new instance of the ReceiptController class
        receiptController = new ReceiptController();
        // Create a new instance of Text class (JavaFX)
        // Set the orderNumberText to the Text object
        receiptController.orderNumberText = new Text();
        // Call the printReceipt method on the receiptController object
        receiptController.printReceipt();
        assertEquals("#1", receiptController.orderNumberText.getText());
    }
}
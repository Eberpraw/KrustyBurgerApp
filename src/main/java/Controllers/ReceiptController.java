package Controllers;

import javafx.fxml.FXML;

public class ReceiptController {
    private String receipt;
    private int orderNumber = 1;

    @FXML
    public void printReceipt() {
        orderNumber++;
        System.out.println(orderNumber);
    }

}

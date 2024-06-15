module com.example.krustyburgerapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.krustyburgerapp to javafx.fxml;
    exports com.krustyburgerapp;
    exports Controllers;
    opens Controllers to javafx.fxml;
    exports Model;
    opens Model to javafx.fxml;
}
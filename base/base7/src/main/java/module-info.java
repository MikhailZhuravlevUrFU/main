module com.example.base7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.base7 to javafx.fxml;
    exports com.example.base7;
}
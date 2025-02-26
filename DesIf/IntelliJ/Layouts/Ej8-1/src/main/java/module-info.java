module com.example.ej81 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ej81 to javafx.fxml;
    exports com.example.ej81;
}
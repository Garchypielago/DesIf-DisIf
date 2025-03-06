module com.example.ej85 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ej85 to javafx.fxml;
    exports com.example.ej85;
}
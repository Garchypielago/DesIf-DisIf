module com.example.t9_ej12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.t9_ej12 to javafx.fxml;
    exports com.example.t9_ej12;
}
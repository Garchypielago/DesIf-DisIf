module com.example.t92 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.t92 to javafx.fxml;
    exports com.example.t92;
}
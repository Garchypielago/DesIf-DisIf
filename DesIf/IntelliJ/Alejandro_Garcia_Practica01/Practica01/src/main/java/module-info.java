module com.example.practica01 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.practica01.controladores to javafx.fxml;
    opens com.example.practica01.modelos to javafx.base;

    opens com.example.practica01 to javafx.fxml;
    exports com.example.practica01;
}
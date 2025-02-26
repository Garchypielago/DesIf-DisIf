module com.example.alejandro_garcia_sanchez_practica1 {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.example.alejandro_garcia_sanchez_practica1.modelos to javafx.base;
    opens com.example.alejandro_garcia_sanchez_practica1.controladores to javafx.fxml;
    opens com.example.alejandro_garcia_sanchez_practica1 to javafx.fxml;
    exports com.example.alejandro_garcia_sanchez_practica1;
}
module com.example.t10ej {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.t10ej01.alert to javafx.fxml;
    exports com.example.t10ej01.alert;


    opens com.example.t10ej01.dialogoPersonalizado to javafx.fxml;
    exports com.example.t10ej01.dialogoPersonalizado;


    opens com.example.t10ej01.dialogoEntrada to javafx.fxml;
    exports com.example.t10ej01.dialogoEntrada;

}
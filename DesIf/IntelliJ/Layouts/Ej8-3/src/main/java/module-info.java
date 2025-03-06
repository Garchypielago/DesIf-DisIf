module com.example.ej83 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens com.example.ej83 to javafx.fxml;
    exports com.example.ej83;
    exports com.example.ej83.objects;
    opens com.example.ej83.objects to javafx.fxml;
}
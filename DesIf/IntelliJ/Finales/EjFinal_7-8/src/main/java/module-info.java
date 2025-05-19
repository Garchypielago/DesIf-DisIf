module com.example.ejfinal_78 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejfinal_78 to javafx.fxml;
    exports com.example.ejfinal_78;

    opens com.example.ejfinal_78.ej1_AGS to javafx.fxml;
    exports com.example.ejfinal_78.ej1_AGS;

    opens com.example.ejfinal_78.ej2_AGS to javafx.fxml;
    exports com.example.ejfinal_78.ej2_AGS;
}
module com.example.ejfinal_910 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejfinal_910 to javafx.fxml;
    exports com.example.ejfinal_910;


    opens com.example.ejfinal_910.ej9_AGS to javafx.fxml;
    exports com.example.ejfinal_910.ej9_AGS;


    opens com.example.ejfinal_910.ej10_AGS to javafx.fxml;
    exports com.example.ejfinal_910.ej10_AGS;
}
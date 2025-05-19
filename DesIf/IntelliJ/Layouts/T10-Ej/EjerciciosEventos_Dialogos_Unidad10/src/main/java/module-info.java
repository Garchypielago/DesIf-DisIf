module com.example.ejercicioseventos_dialogos_unidad10 {
    requires javafx.controls;
    requires javafx.fxml;

//    opens com.example.ejercicioseventos_dialogos_unidad10 to javafx.fxml;
//    exports com.example.ejercicioseventos_dialogos_unidad10;

    opens com.example.ejercicioseventos_dialogos_unidad10.eventosValidar to javafx.fxml;
    exports com.example.ejercicioseventos_dialogos_unidad10.eventosValidar;

    opens com.example.ejercicioseventos_dialogos_unidad10.draggableFiles to javafx.fxml;
    exports com.example.ejercicioseventos_dialogos_unidad10.draggableFiles;

    opens com.example.ejercicioseventos_dialogos_unidad10.choiceEjercicio to javafx.fxml;
    exports com.example.ejercicioseventos_dialogos_unidad10.choiceEjercicio;

    opens com.example.ejercicioseventos_dialogos_unidad10.pagination to javafx.fxml;
    exports com.example.ejercicioseventos_dialogos_unidad10.pagination;
}
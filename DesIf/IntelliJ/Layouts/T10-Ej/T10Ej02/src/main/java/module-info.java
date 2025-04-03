module com.example.t10ej {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.t10ej02 to javafx.fxml;
    exports com.example.t10ej02;

    opens com.example.t10ej02.draggablePanels to javafx.fxml;
    exports com.example.t10ej02.draggablePanels;

    opens com.example.t10ej02.eventosManejo to javafx.fxml;
    exports com.example.t10ej02.eventosManejo;

    opens com.example.t10ej02.eventosTipos to javafx.fxml;
    exports com.example.t10ej02.eventosTipos;

    opens com.example.t10ej02.handlerVsFilters to javafx.fxml;
    exports com.example.t10ej02.handlerVsFilters;

    opens com.example.t10ej02.listeners to javafx.fxml;
    exports com.example.t10ej02.listeners;

    opens com.example.t10ej02.listenersBasico to javafx.fxml;
    exports com.example.t10ej02.listenersBasico;
}
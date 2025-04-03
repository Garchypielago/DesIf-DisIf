package com.example.ej83;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class RootController {
    @FXML private BorderPane rootLayout;

    @FXML
    private void initialize() {
        System.out.println("MainController inicializado. rootLayout: " + rootLayout);

    }
}
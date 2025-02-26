package com.example.ej81;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainLayoutsController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
package com.example.ej81;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class ListController {


    @FXML
    private ChoiceBox<String> ChoiceBoxLocation;

    @FXML
    private void initialize() {
// Controles de JavaFX a los que se añaden directamente los items
        ChoiceBoxLocation.getItems().addAll("New York", "Orlando", "London",
                "Manchester");
    }
}

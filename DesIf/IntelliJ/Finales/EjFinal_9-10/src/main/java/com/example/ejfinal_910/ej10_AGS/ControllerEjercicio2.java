package com.example.ejfinal_910.ej10_AGS;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Optional;

public class ControllerEjercicio2 {
    @FXML private TextField inputField;
    @FXML private Button addButton;
    @FXML private Button closeButton;
    @FXML private ListView<String> listView;

    @FXML
    public void initialize() {
        // inicialmente deshabilitado
        addButton.setDisable(true);

        // solo dígitos y control de habilitación
        inputField.addEventFilter(KeyEvent.KEY_TYPED, evt -> {
            if (!evt.getCharacter().matches("\\d")) {
                evt.consume();
            }
        });
        inputField.textProperty().addListener((obs, oldText, newText) -> {
            addButton.setDisable(newText.isEmpty());
        });
    }

    @FXML
    private void onAdd(ActionEvent event) {
        // añadir nuevo número
        listView.getItems().add(inputField.getText());
        inputField.clear();
        addButton.setDisable(true);
    }

    @FXML
    private void onClose(ActionEvent event) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Cerrando ventana");
        confirm.setHeaderText("Va a cerrar la ventana actual");
        confirm.setContentText("¿Está seguro?");
        Optional<ButtonType> result = confirm.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ((Stage) closeButton.getScene().getWindow()).close();
        }
    }

    @FXML
    private void onListClick(MouseEvent event) {
        if (event.getClickCount() == 1) {
            double x = event.getX();
            double y = event.getY();
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setTitle("Información telefónica");
            info.setHeaderText("Este es un listado de teléfonos");
            info.setContentText(
                    String.format("Has hecho click en la posición %.2f, %.2f", x, y));
            info.showAndWait();
        }
    }
}


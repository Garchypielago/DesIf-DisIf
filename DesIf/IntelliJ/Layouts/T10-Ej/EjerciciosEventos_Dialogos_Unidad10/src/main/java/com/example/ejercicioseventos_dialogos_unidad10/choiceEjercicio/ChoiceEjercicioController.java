package com.example.ejercicioseventos_dialogos_unidad10.choiceEjercicio;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChoiceEjercicioController {
    @FXML private ListView<String> listView;
    @FXML private Button btnMostrar;

    public void initialize() {
        listView.setItems(FXCollections.observableArrayList(
                "Opción 1","Opción 2","Opción 3","Opción 4","Opción 5",
                "Opción 6","Opción 7","Opción 8","Opción 9","Opción 10"
        ));
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        btnMostrar.setDisable(true);

        listView.getSelectionModel()
                .getSelectedItems()
                .addListener((ListChangeListener<String>) c -> {
                    btnMostrar.setDisable(listView.getSelectionModel()
                            .getSelectedItems()
                            .isEmpty());
                });

        listView.setOnMouseExited((MouseEvent e) -> {
            if (listView.getSelectionModel().getSelectedItems().isEmpty()) {
                Alert myAlert = new Alert(Alert.AlertType.INFORMATION,
                        "No se puede mostrar el diálogo hasta que se seleccione un ítem como mínimo",
                        ButtonType.OK);
                myAlert.setHeaderText("Sin ítems seleccionados");
                myAlert.setTitle("Aviso sobre listado");
                myAlert.showAndWait();
            }
        });
    }

    @FXML
    private void onMostrarDialog() {
        List<String> sel = new ArrayList<>(listView.getSelectionModel().getSelectedItems());
        ChoiceDialog<String> dialog = new ChoiceDialog<>(sel.get(0), sel);
        dialog.setTitle("Elige uno");
        dialog.setHeaderText("Selecciona un valor...");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(chosen -> {
            listView.getSelectionModel().clearSelection();
            listView.getSelectionModel().select(chosen);
        });
    }
}
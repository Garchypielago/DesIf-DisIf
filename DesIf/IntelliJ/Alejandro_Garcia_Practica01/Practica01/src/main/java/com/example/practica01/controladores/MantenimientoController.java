package com.example.practica01.controladores;

import com.example.practica01.modelos.Empleado;
import com.example.practica01.modelos.EmpleadoData;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class MantenimientoController {

    @FXML private TextField campoNombre;
    @FXML private TextField campoApellido;
    @FXML private ComboBox<String> comboDepartamento;
    @FXML private DatePicker selectorFecha;
    @FXML private CheckBox checkActivo;

    @FXML
    private void initialize() {
        configurarCombobox();
        selectorFecha.setValue(LocalDate.now());
    }

    private void configurarCombobox() {
        comboDepartamento.getItems().addAll("Ventas", "TI", "Recursos Humanos");
    }

    @FXML
    private void guardarRegistro() {
        if (campoNombre.getText().isEmpty() || campoApellido.getText().isEmpty()) {
            mostrarAlerta("Error", "Debe completar todos los campos.");
            return;
        }

        Empleado nuevoEmpleado = new Empleado(
                campoNombre.getText(),
                campoApellido.getText(),
                comboDepartamento.getValue(),
                selectorFecha.getValue(),
                checkActivo.isSelected()
        );

        EmpleadoData.agregarEmpleado(nuevoEmpleado);
        mostrarAlerta("Éxito", "Empleado agregado correctamente.");
        limpiarCampos();
    }

    private void limpiarCampos() {
        campoNombre.clear();
        campoApellido.clear();
        comboDepartamento.getSelectionModel().clearSelection();
        selectorFecha.setValue(LocalDate.now());
        checkActivo.setSelected(false);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    public void cancelar() {
        // Lógica para cancelar la acción
    }
}


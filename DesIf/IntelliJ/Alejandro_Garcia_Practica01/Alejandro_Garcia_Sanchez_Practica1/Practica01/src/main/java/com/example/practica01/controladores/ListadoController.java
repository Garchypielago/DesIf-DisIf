package com.example.practica01.controladores;

import com.example.practica01.modelos.Empleado;
import com.example.practica01.modelos.EmpleadoData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListadoController {

    @FXML private TableView<Empleado> tablaEmpleados;
    @FXML private TableColumn<Empleado, String> columnaNombre;
    @FXML private TableColumn<Empleado, String> columnaApellido;
    @FXML private TableColumn<Empleado, String> columnaDepartamento;
    @FXML private TableColumn<Empleado, String> columnaFecha;
    @FXML private TableColumn<Empleado, Boolean> columnaActivo;
    @FXML private ComboBox<String> comboFiltroDepartamento;

    @FXML
    private void initialize() {
        configurarTabla();
        configurarCombobox();
        cargarDatos();
    }

    private void configurarTabla() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columnaDepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fechaContratacion"));
        columnaActivo.setCellValueFactory(new PropertyValueFactory<>("activo"));
    }

    private void configurarCombobox() {
        comboFiltroDepartamento.getItems().addAll("Todos", "Ventas", "TI", "Recursos Humanos");
        comboFiltroDepartamento.setValue("Todos");

        comboFiltroDepartamento.setOnAction(event -> filtrarEmpleados());
    }

    private void cargarDatos() {
        tablaEmpleados.setItems(EmpleadoData.getEmpleados());
    }

    private void filtrarEmpleados() {
        String filtro = comboFiltroDepartamento.getValue();
        if ("Todos".equals(filtro)) {
            tablaEmpleados.setItems(EmpleadoData.getEmpleados());
        } else {
            ObservableList<Empleado> filtrados = EmpleadoData.getEmpleados().filtered(e -> e.getDepartamento().equals(filtro));
            tablaEmpleados.setItems(filtrados);
        }
    }
}


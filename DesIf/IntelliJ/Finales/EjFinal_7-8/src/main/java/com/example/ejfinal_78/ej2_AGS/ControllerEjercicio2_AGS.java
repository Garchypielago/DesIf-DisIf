package com.example.ejfinal_78.ej2_AGS;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.control.TreeItem;

import java.util.List;

public class ControllerEjercicio2_AGS {

    @FXML private TreeView<String>    treeViewLeft;
    @FXML private ComboBox<String>    comboDescripcion;
    @FXML private TableView<Producto> tableProductos;

    private final List<Producto> productos = List.of(
            new Producto(1, "Monitor"),
            new Producto(2, "Tarjeta gráfica"),
            new Producto(3, "Disco duro SSD"),
            new Producto(4, "Refrigeración líquida"),
            new Producto(5, "Fuente de alimentación"),
            new Producto(6, "Memoria RAM")
    );

    @FXML
    public void initialize() {
        //tree
        treeViewLeft.setEditable(true);
        treeViewLeft.setCellFactory(TextFieldTreeCell.forTreeView());
        TreeItem<String> root = new TreeItem<>("ROOT");
        root.setExpanded(true);

        TreeItem<String> hardware = new TreeItem<>("Hardware");
        hardware.setExpanded(true);
        hardware.getChildren().addAll(
                new TreeItem<>("Monitor"),
                new TreeItem<>("Tarjeta gráfica"),
                new TreeItem<>("Refrigeración líquida"),
                new TreeItem<>("Fuente de alimentación")
        );

        TreeItem<String> almacenamiento = new TreeItem<>("Almacenamiento");
        almacenamiento.setExpanded(true);
        almacenamiento.getChildren().addAll(
                new TreeItem<>("Disco duro SSD"),
                new TreeItem<>("Memoria RAM")
        );

        root.getChildren().addAll(hardware, almacenamiento);
        treeViewLeft.setRoot(root);
        treeViewLeft.setShowRoot(false);

        //combobox
        comboDescripcion.setItems(
                FXCollections.observableArrayList(
                        productos.stream()
                                .map(Producto::getDescripcion)
                                .toList()
                )
        );

        //table
        TableColumn<Producto,Integer> colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Producto,String> colDesc = new TableColumn<>("Descripción");
        colDesc.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        tableProductos.getColumns().addAll(colId, colDesc);
        tableProductos.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );

        tableProductos.getItems().addAll(productos);

        tableProductos.setTableMenuButtonVisible(true);
    }
}

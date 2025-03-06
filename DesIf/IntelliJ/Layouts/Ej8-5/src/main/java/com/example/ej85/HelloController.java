package com.example.ej85;

import com.example.ej85.entities.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class HelloController {
    @FXML
    private TableView<Order> tableOrder;
    @FXML
    private TableColumn<Order, String> idColumn;
    @FXML
    private TableColumn<Order, Image> priorityColumn;
    @FXML
    private TableColumn<Order, String> courierColumn;
    @FXML
    private TableColumn<Order, String> costColumn;
    @FXML
    private TableColumn<Order, String> driverColumn;

    private HelloApplication application;

    @FXML
    private ComboBox comboShapes;

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty().asString());

        priorityColumn.setCellValueFactory(cellData -> {
            if (!cellData.getValue().priorityProperty().getValue()) {
                return new SimpleObjectProperty<>(null);
            } else {
                URL imageUrl = HelloApplication.class.getResource("static/vip.png");
                if (imageUrl == null)
                    return new SimpleObjectProperty<>(null);

                return new SimpleObjectProperty<>(new Image(imageUrl.toExternalForm()));
            }
        });

        priorityColumn.setCellFactory(column -> new TableCell<Order, Image>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(Image image, boolean empty) {
                super.updateItem(image, empty);
                if (empty || image == null) {
                    setGraphic(null);
                } else {
                    imageView.setImage(image);
                    imageView.setFitWidth(20);
                    imageView.setFitHeight(20);
                    setGraphic(imageView);
                }
            }
        });



        courierColumn.setCellValueFactory(cellData -> cellData.getValue().courierProperty().asString());

        costColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty("$" + cellData.getValue().getCost())
        );

        driverColumn.setCellValueFactory(cellData -> cellData.getValue().driverProperty());

        comboShapes.getItems().addAll("Line", "Rectangle", "Circle", "Text");
        comboShapes.setCellFactory(new ShapeCellFactory());
        comboShapes.setButtonCell(new ShapeCell());
    }

    public void setApplication(HelloApplication application) {
        this.application = application;
        tableOrder.setItems(this.application.getOrderData());
    }

}
package com.example.ej81;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainLayoutsController {

    @FXML
    private ComboBox<Object> ComboBoxLocation;

    @FXML
    private ComboBox<String> ComboBoxLanguage;


    @FXML
    private ListView<ComboBox> ListViewQualifications;
    public static final ObservableList indeterminateText =
            FXCollections.observableArrayList();
    public static final ObservableList devStuff =
            FXCollections.observableArrayList(
                    "Objects", "Classes", "Functions", "Variables", "Compiler",
                    "Debugger", "Projects", "Beans", "Libraries", "Modules");

    @FXML
    private TreeView<String> TreeViewLeft = new TreeView<>();


    @FXML
    private void initialize() {
// Controles de JavaFX a los que se añaden directamente los items
        ComboBoxLocation.getItems().addAll("New York", "Orlando", new Separator(), "London",
                "Manchester");
        ComboBoxLanguage.getItems().addAll("English", "Japanese", "Spanish");

        for (int i = 0; i < 10; i++) {
            indeterminateText.add("Indeterminate (pick a choice)");
        }
        ListViewQualifications.setEditable(true);
        ListViewQualifications.setItems(indeterminateText);
        ListViewQualifications.setCellFactory(ComboBoxListCell.forListView(devStuff));

        TreeItem<String> rootItem = new TreeItem<String>("Inbox");
        ImageView rootIcon = new ImageView(new Image(getClass().getResourceAsStream("/com/example/ej81/static/carpeta.png")));
        rootIcon.setFitWidth(12);
        rootIcon.setFitHeight(12);
        rootItem.setGraphic(rootIcon);
        rootItem.getChildren().add(new TreeItem<String>("Sales"));
        rootItem.getChildren().add(new TreeItem<String>("Marketing"));
        rootItem.getChildren().add(new TreeItem<String>("Distribution"));
        rootItem.getChildren().add(new TreeItem<String>("Costs"));


        TreeViewLeft.setCellFactory(TextFieldTreeCell.forTreeView());
        rootItem.setExpanded(true);
        TreeViewLeft.setRoot(rootItem);
    }
}
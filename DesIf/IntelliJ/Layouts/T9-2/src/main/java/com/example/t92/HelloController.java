package com.example.t92;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private RadioButton radioButton1, radioButton2, radioButton3;
    @FXML
    private ToggleGroup toggleGroup;
    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Label label1;
    @FXML
    private Button button1, button2;
    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3;
    @FXML
    private Separator separator;
    @FXML
    private Slider slider;
    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    public void initialize() {
        // Inicialización de ChoiceBox
        choiceBox.setItems(FXCollections.observableArrayList("English", "Español", "Français"));
        choiceBox.getSelectionModel().select(0);

        // Configuración de ProgressIndicator
        progressIndicator.progressProperty().bind(Bindings.divide(slider.valueProperty(), slider.maxProperty()));

        // Manejo de eventos de botones
        button1.setOnAction(event -> label1.setText("Accepted"));
        button2.setOnAction(event -> label1.setText("Declined"));
    }
}

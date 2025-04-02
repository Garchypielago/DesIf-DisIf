package com.example.t92;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        ScrollPane scrollPane = new ScrollPane();
        VBox vBox = new VBox();

        // Primer HBox con RadioButtons
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton radioButton1 = new RadioButton("High");
        radioButton1.setToggleGroup(toggleGroup);
        radioButton1.setSelected(true);
        RadioButton radioButton2 = new RadioButton("Medium");
        radioButton2.setToggleGroup(toggleGroup);
        RadioButton radioButton3 = new RadioButton("Low");
        radioButton3.setToggleGroup(toggleGroup);
        VBox vBox1 = new VBox(radioButton1, radioButton2, radioButton3);

        // Segundo VBox con TextFields
        TextField textField = new TextField();
        textField.setPromptText("Your name");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Your password");
        VBox vBox2 = new VBox(textField, passwordField);

        // ChoiceBox
        ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList("English", "Español", "Français"));
        choiceBox.getSelectionModel().select(0);

        HBox hBox1 = new HBox(vBox1, vBox2, choiceBox);

        // Segundo HBox con botones y etiqueta
        Label label1 = new Label("Not Available");
        Button button1 = new Button("Accept");
        Button button2 = new Button("Decline");
        HBox hBox2 = new HBox(button1, button2, label1);

        // Tercer HBox con CheckBoxes y Separator
        CheckBox checkBox1 = new CheckBox("Normal");
        Separator separator = new Separator();
        CheckBox checkBox2 = new CheckBox("Checked");
        checkBox2.setSelected(true);
        CheckBox checkBox3 = new CheckBox("Undefined");
        checkBox3.setIndeterminate(true);
        checkBox3.setAllowIndeterminate(true);
        HBox hBox3 = new HBox(checkBox1, separator, checkBox2, checkBox3);

        // Cuarto HBox con Slider y ProgressIndicator
        Label label2 = new Label("Progress:");
        Slider slider = new Slider();
        ProgressIndicator progressIndicator = new ProgressIndicator(0);
        progressIndicator.progressProperty().bind(Bindings.divide(slider.valueProperty(), slider.maxProperty()));
        HBox hBox4 = new HBox(label2, slider, progressIndicator);

        // Agregar todos los HBox al VBox principal
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);
        scrollPane.setContent(vBox);

        Scene scene = new Scene(scrollPane, 750, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ejemplo de UI en JavaFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
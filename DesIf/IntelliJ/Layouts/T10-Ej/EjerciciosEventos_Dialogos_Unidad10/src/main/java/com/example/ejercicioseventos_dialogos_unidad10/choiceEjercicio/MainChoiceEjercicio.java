package com.example.ejercicioseventos_dialogos_unidad10.choiceEjercicio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class MainChoiceEjercicio extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("choiceEjercicio.fxml"))
        ));
        stage.setTitle("ChoiceDialog Ejercicio");
        stage.show();
    }
    public static void main(String[] args) { launch(args); }
}

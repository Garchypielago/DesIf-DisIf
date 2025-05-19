package com.example.ejercicioseventos_dialogos_unidad10.eventosValidar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainEventosValidar extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("main.fxml"));
        primaryStage.setScene(new Scene(fxml.load()));
        primaryStage.setTitle("Ejercicio 1–2");
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}

package com.example.ejfinal_78.ej1_AGS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainEjercicio1_AGS extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Ejercicio1_AGS.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Ejercicio 1 – AGS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
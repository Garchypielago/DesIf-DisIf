package com.example.practica01;

import com.example.practica01.controladores.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("vistas/MainView.fxml"));
        fxmlLoader.setLocation(Main.class.getResource("vistas/MainView.fxml"));


        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Gestión Empresarial");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

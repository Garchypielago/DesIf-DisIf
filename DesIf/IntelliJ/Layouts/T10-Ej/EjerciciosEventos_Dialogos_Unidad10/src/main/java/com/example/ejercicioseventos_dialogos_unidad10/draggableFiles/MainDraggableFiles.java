package com.example.ejercicioseventos_dialogos_unidad10.draggableFiles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class MainDraggableFiles extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("draggableFiles.fxml"))
        ));
        primaryStage.setTitle("Draggable Text & Image");
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}

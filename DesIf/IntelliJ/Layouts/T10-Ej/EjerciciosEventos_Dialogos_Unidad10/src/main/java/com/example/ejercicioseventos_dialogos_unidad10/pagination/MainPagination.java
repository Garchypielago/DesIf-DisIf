package com.example.ejercicioseventos_dialogos_unidad10.pagination;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class MainPagination extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("pagination.fxml"))
        ));
        stage.setTitle("Pagination Ejercicio");
        stage.show();
    }
    public static void main(String[] args) { launch(args); }
}

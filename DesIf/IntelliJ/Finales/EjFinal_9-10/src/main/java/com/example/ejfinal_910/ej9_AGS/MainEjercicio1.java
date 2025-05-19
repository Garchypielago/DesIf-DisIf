package com.example.ejfinal_910.ej9_AGS;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainEjercicio1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el dise�o del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainEjercicio1.class.getResource("Ejercicio1.fxml"));
			BorderPane rootLayout = (BorderPane) loader.load();
			
			// Mostramos la escena del BorderPane de la variable rootLayot
			Scene scene = new Scene(rootLayout);
						
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejercicio 1 examen Unidades 9 y 10");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
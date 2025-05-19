package com.example.ejfinal_910.ej10_AGS;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainEjercicio2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox rootLayout = new VBox(10);
			rootLayout.setPadding(new Insets(10));
			rootLayout.setAlignment(Pos.CENTER);
			Button button = new Button("Mostrar listado");
			rootLayout.getChildren().add(button);

			// Aqu� debes mostrar el di�logo que se indica en el enunciado
			button.setOnAction((event) -> {
				try {
					FXMLLoader loader = new FXMLLoader(
							getClass().getResource("Ejercicio2.fxml"));
					Parent dialogRoot = loader.load();
					Stage dialog = new Stage();
					dialog.initOwner(primaryStage);
					dialog.initModality(Modality.APPLICATION_MODAL);
					dialog.setScene(new Scene(dialogRoot));
					dialog.setTitle("Listado teléfonos");
					dialog.showAndWait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

			Scene scene = new Scene(rootLayout, 370, 50);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejercicio 2 examen Unidades 9 y 10");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

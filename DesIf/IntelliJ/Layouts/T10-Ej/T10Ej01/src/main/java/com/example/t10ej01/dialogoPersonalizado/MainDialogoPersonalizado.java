package com.example.t10ej01.dialogoPersonalizado;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainDialogoPersonalizado extends Application {
	private VBox rootLayout;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Se crea HBox con bot�n para mostrar el di�logo
			rootLayout = new VBox(10);
			rootLayout.setAlignment(Pos.CENTER);
			Button btnMostrar = new Button("Haz click para mostrar di�logo");
			Label lblUsuario = new Label("Aqu� se mostrar� el usuario");
			lblUsuario.setPadding(new Insets(20, 0, 0, 0));
			rootLayout.getChildren().addAll(btnMostrar, lblUsuario);
			
			btnMostrar.setOnAction(ev -> {
				try {
			        // Cargamos el dise�o del di�logo desde un XML
			        FXMLLoader loader = new FXMLLoader();
			        loader.setLocation(MainDialogoPersonalizado.class.getResource("MiDialogo.fxml"));
			        AnchorPane page = (AnchorPane) loader.load();

			        // Se crea un nuevo Stage para mostrar el di�logo
			        Stage dialogStage = new Stage();
			        dialogStage.setTitle("Crear usuario");
			        dialogStage.initModality(Modality.WINDOW_MODAL);
			        dialogStage.initOwner(primaryStage);
			        dialogStage.setResizable(false);
			        Scene scene = new Scene(page);
			        dialogStage.setScene(scene);

			        // Carga el controlador con una referencia al Stage y carga al label de la ventana principal donde cargara el usuario
			        MiDialogoController controller = loader.getController();
			        controller.setDialogStage(dialogStage);
			        controller.setLabel(lblUsuario);
			       
			        // Muestra el di�logo y no contin�a el c�digo hasta que lo cierra el usuario
			        dialogStage.showAndWait(); 
			        
			    } catch (IOException e) {
			        e.printStackTrace();
			        
			    }
			});
						
			// Mostramos la escena del BorderPane de la variable rootLayot
			Scene scene = new Scene(rootLayout, 200, 200);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Mi di�logo");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

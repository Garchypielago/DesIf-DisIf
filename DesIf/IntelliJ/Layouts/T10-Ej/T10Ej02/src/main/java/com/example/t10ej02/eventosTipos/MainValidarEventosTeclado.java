package com.example.t10ej02.eventosTipos;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainValidarEventosTeclado extends Application {
	private VBox rootLayout;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Creamos VBox con TextField
			rootLayout = new VBox(10);
			rootLayout.setPadding(new Insets(10));
			TextField txtField = new TextField("Prueba de eventos");
			rootLayout.getChildren().add(txtField);
			
			/*Diferencia entre eventos de teclado para validar con KeyPressed y KeyTyped
			  En este caso da igual filtro o manejador. El filtro se emplea sobre todo 
			  cuando se definen varios eventos comunes a elementos en el objeto Scene o contenedores
			  Lo que s� que hay que tener cuidado es que si consumimos el evento KEY_PRESSED la tecla
			  que estamos impidiendo mostrar en realidad se visualiza porque KEY_TYPED se ejecuta despu�s */
			txtField.addEventFilter(KeyEvent.KEY_PRESSED, (e) -> {								
				System.out.print("Code: " + e.getCode().getChar() + "-> " +  e.getCode().getCode());
				System.out.println(" Text: " + e.getText());
				if (Character.isLowerCase(e.getCode().getChar().charAt(0))) {
					// En principio la validaci�n con KEY_PRESSED no funciona porque se lanza igualmente KEY_TYPED
					e.consume();
				}
			});
			
			txtField.addEventFilter(KeyEvent.KEY_TYPED, (e) -> {				
				System.out.println("Character: " + e.getCharacter());
				if (Character.isLowerCase(e.getCharacter().charAt(0))) {
					// Si descomenta esta l�nea entonces s� que se valida porque es el �ltimo evento que se genera
					//e.consume(); 
				}
			});	
					
			// Mostramos la escena del VBox de la variable rootLayot
			Scene scene = new Scene(rootLayout);						
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejemplo sobre eventos");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	public static void main(String[] args) {
		launch(args);
	}
}

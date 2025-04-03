package eventosTipos;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainEventosTipos extends Application {
	private VBox rootLayout;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Creamos VBox con TextField
			rootLayout = new VBox(10);
			rootLayout.setPadding(new Insets(10));
			TextField txtField = new TextField("Prueba de eventos");
			rootLayout.getChildren().add(txtField);
			
			// Eventos de ratón
			//txtField.setOnMouseEntered((event) -> mostrarCoordenadasRaton(event));
			//txtField.setOnMouseExited((event) -> mostrarCoordenadasRaton(event));
			txtField.setOnMousePressed((event) -> mostrarCoordenadasRaton(event));
			txtField.setOnMouseReleased((event) -> mostrarCoordenadasRaton(event));
			txtField.setOnMouseClicked((event) -> mostrarCoordenadasRaton(event));
			
			// Eventos de teclado
			txtField.setOnKeyPressed((event) -> mostrarTecla(event));
			txtField.setOnKeyReleased((event) -> mostrarTecla(event));
			txtField.setOnKeyTyped((event) -> mostrarTecla(event));
			
			// Mostramos la escena del VBox de la variable rootLayot
			Scene scene = new Scene(rootLayout);						
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejemplo sobre eventos");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void mostrarTecla(KeyEvent event) {
		System.out.println("Key code " + event.getEventType().getName() + ": " + event.getCode() + ","
				+ " Key text " + event.getEventType().getName() + ": " + event.getText() + ","
				+ " Key character " + event.getEventType().getName() + ": " +  (int) event.getCharacter().charAt(0));
	}
	
	private void mostrarCoordenadasRaton(MouseEvent event) {
		// Obtiene los objetos source y target del evento
	    String source = event.getSource().getClass().getSimpleName();
	    String target = event.getTarget().getClass().getSimpleName();
	         
	    // Localización del ratón relativa a source
	    double sourceX = event.getX();
	    double sourceY = event.getY();
	        
	    // Localización del raton relativa a la escena
	    double sceneX = event.getSceneX();
	    double sceneY = event.getSceneY();
	         
	    // Localización del raton relativa a la pantalla
	    double screenX = event.getScreenX();
	    double screenY = event.getScreenY();
	         
	    // Log the Informations
	    System.out.println(
	    		"Event type=" + event.getEventType().getName() + ", Source=" + source + ", Target=" + target +
	            ", Location:" + " source(" + sourceX + ", " + sourceY + ")" +
	            ", scene(" + sceneX + ", " + sceneY + ")" +
	            ", screen(" + screenX + ", " + screenY + ")"
	        );
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

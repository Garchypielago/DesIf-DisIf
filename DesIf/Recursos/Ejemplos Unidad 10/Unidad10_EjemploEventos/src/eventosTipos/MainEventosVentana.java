package eventosTipos;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainEventosVentana extends Application {
	private VBox rootLayout;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Creamos VBox con un botón
			rootLayout = new VBox(10);
			rootLayout.setPadding(new Insets(10));
			rootLayout.setAlignment(Pos.CENTER);
			Button btnDialog = new Button("Mostrar ventana");
			rootLayout.getChildren().add(btnDialog);
					
			// El botón se encarga de crear y mostrar un diálogo al hacer click
			TextInputDialog textDialog = new TextInputDialog("Texto de ejemplo...");
	    	textDialog.initModality(Modality.APPLICATION_MODAL); // En ese caso será "no modal"
	    	textDialog.setTitle("Ejemplo de diálogo");
	    	textDialog.setHeaderText("Diálogo de prueba.\nVer consola para observar eventos de ventana");
			btnDialog.setOnAction(e -> {	    		  	  		
	    		textDialog.showAndWait();
	    	});  
	    	
	    	// Prueba de eventos de ventana
			// Prueba a depurar para ver más claramente cuándo se genera cada evento
	    	textDialog.setOnHidden((event) -> {
	            System.out.println("Ya oculto");
	        });
	    	
	    	textDialog.setOnHiding((event) -> {
	            System.out.println("Ocultando");
	        });
	    	
	    	textDialog.setOnShowing((event) -> {
	            System.out.println("Mostrando");
	        });
	    	
	    	textDialog.setOnShown((event) -> {
	            System.out.println("Mostrado");
	        });
	    	
	    	textDialog.setOnCloseRequest((event) -> {
	    		// Más que capturar este evento, lo más común es cerrar 
	    		// manualmente con el método "close" cuando es necesario
	    		System.out.println("Click a cerrar"); 
	            
	        });
	    	  		    		    	
			// Mostramos la escena del VBox de la variable rootLayot
			Scene scene = new Scene(rootLayout, 200, 50);						
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

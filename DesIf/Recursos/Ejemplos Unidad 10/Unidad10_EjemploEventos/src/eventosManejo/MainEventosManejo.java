package eventosManejo;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainEventosManejo extends Application {
	private VBox rootLayout;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Creamos VBox con TextField
			rootLayout = new VBox(10);
			rootLayout.setPadding(new Insets(10));
			rootLayout.setAlignment(Pos.CENTER);
			TextField txtField = new TextField("Prueba de filtros");
			Button button = new Button("Filtros");
			rootLayout.getChildren().addAll(txtField, button);
			
			// Código común que sirve para filtros y manejadores
			EventHandler<MouseEvent> manejo = (MouseEvent event) -> {
				System.out.println("Manejador común para filtros y handlers del evento " + event.getEventType()); 
			};
			
			// Mostramos la escena del VBox de la variable rootLayot
			Scene scene = new Scene(rootLayout);
			
			// Filtro para cualquier evento MOUSE_PRESSED de la escena. Se detecta en cualquier elemento
			scene.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
				String type = e.getEventType().getName();
			    String source = e.getSource().getClass().getSimpleName();
			    String target = e.getTarget().getClass().getSimpleName();

			    System.out.println("Filtro específico de: " + type + ", " + source + ", " + target);
			    
			    // Se puede borrar el filtro asociado a una función
			    //button.removeEventFilter(MouseEvent.MOUSE_PRESSED, manejo);
			});
			
			// Los manejadores tienen que ser de nodos específicos. No sirve con declararlos en la escena
			txtField.addEventHandler(MouseEvent.DRAG_DETECTED, e -> {
				String type = e.getEventType().getName();
				String source = e.getSource().getClass().getSimpleName();
				String target = e.getTarget().getClass().getSimpleName();
								
				System.out.println("Manejador específico de: " + type + ", " + source + ", " + target);				
			});
						
			// Filtro y manejador con el código común declarado arriba. En los filtros se activará con MOUSSE_PRESSED	
			txtField.addEventFilter(MouseEvent.MOUSE_PRESSED, manejo);
			button.addEventFilter(MouseEvent.MOUSE_PRESSED, manejo);
			
			// En los manejadores se activará con DRAG_DETECTED y solo en TextField
			txtField.addEventHandler(MouseEvent.DRAG_DETECTED, manejo);
			
			// En el caso del evento DRAG_DETECTED, el botón no lo hacemos arrastrable y sirve para desactivar la función manejo del texto
			button.setOnAction((event) -> {				
				txtField.removeEventHandler(MouseEvent.DRAG_DETECTED, manejo);
			});
		
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

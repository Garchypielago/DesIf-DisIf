package handlerVsFilters;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainHandlerFilters extends Application {
	private VBox rootLayout;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainHandlerFilters.class.getResource("eventosBasico.fxml"));
			rootLayout = (VBox) loader.load();
			
			// Se accede al botón creado en la interfaz con lookup
			Button btnProbar = (Button) rootLayout.lookup("#btnProbar");
						
			// Se crea un manejador y filtro de eventos
			btnProbar.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> System.out.println("handler1..."));
			btnProbar.addEventFilter(MouseEvent.MOUSE_CLICKED, (event) -> {
				System.out.println("handler2...");
				// Si ejecutamos consume entonces el evento no se propaga de nuevo hacia arriba y no se ejecuta el manejador
				// TODO Probar a descomentar esta línea
				event.consume(); 
			});
			
			btnProbar.setOnMouseClicked(event -> System.out.println("click 1"));
			
			// Si cambiamos los eventos de ratón por eventos de acción
			// entonces transcurren antes los eventos de acción aunque sea 
			// un manejador y no un filtro
			btnProbar.setOnAction(event -> System.out.println("click 2"));

			// Mostramos la escena del VBox de la variable rootLayot
			Scene scene = new Scene(rootLayout);
			
			// Los eventos de teclado se crean directamente sobre el objeto Scene
			scene.addEventFilter(KeyEvent.KEY_TYPED, e -> {

			    String type = e.getEventType().getName();
			    String source = e.getSource().getClass().getSimpleName();
			    String target = e.getTarget().getClass().getSimpleName();

			    System.out.println("filter: " + type + ", " + source + ", " + target);
			    
			    if (Character.isDigit(e.getCharacter().charAt(0))) {
			        System.out.println("caracter: " + e.getCharacter() + ", no permitido.");
			        //e.consume();
			    }
			});
			
			// Probamos a crear eventos de teclado directamente sobre el TextField
			// También funciona si comentamos el código del filtro sobre el Scene
			// Tiene prioridad el filtro, ya que se ejecuta antes y detiene la propagación cuando se consume el evento
			TextField pruebaText = (TextField) rootLayout.lookup("#pruebaText");
			pruebaText.addEventHandler(KeyEvent.KEY_TYPED, e -> {

			    String type = e.getEventType().getName();
			    String source = e.getSource().getClass().getSimpleName();
			    String target = e.getTarget().getClass().getSimpleName();

			    System.out.println("handler: " + type + ", " + source + ", " + target);
			    
			    if (Character.isDigit(e.getCharacter().charAt(0))) {
			        System.out.println("caracter: " + e.getCharacter() + ", no permitido.");
			        e.consume();
			    }
			});
			
			// El manejador nunca llega a ejecutarse aunque se comente el código
			// anterior de e.consume()
			// Los manejadores solo funcionan en el nodo que se definen, no en los hijos
			scene.addEventHandler(KeyEvent.KEY_TYPED, e -> {
				System.out.println("Prueba KEY_TYPED");
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

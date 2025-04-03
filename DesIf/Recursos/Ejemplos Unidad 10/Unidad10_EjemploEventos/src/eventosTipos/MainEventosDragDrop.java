package eventosTipos;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainEventosDragDrop extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Group es un tipo de contenedor que no admite layouts 
			Group root = new Group();
	        Scene scene = new Scene(root, 400, 200);
	        scene.setFill(Color.LIGHTGREEN);
	 
	        final Text source = new Text(50, 100, "DRAG ME");
	        final Text target = new Text(250, 100, "DROP HERE");
		 
	        root.getChildren().add(source);
	        root.getChildren().add(target);
	                
	        // OnDragDetected: Cuando se detecta que el texto origen se va a arrastar
	        source.setOnDragDetected((event) -> {
                System.out.println("onDragDetected");
                
                // Se indica que el modo de transferencia será del tipo movimiento
                Dragboard db = source.startDragAndDrop(TransferMode.MOVE);
                
                // Se transfiere el String del texto inicial
                ClipboardContent content = new ClipboardContent();
                content.putString(source.getText());
                db.setContent(content);            
            });
	        	 
	        // OnDragOver: Cuando el texto destino detecta que nos hemos posicionado
	        target.setOnDragOver((event) -> {
                // El texto se mueve al destino 
	        	// No se muestra en consola porque se generan muchos DragOver
                //System.out.println("onDragOver");
                
                // Solo se acepta si el texto se mueve desde otro nodo y es un String
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasString()) {
                    // Se permite movimiento drag and drop
                    event.acceptTransferModes(TransferMode.MOVE);
                }          
	        });
	 
	        // OnDragEntered: Cuando se detecta que el texto origen ha alcanzado el destino
	        target.setOnDragEntered((event) -> {
                System.out.println("onDragEntered");
                // Se cambia el color para mostrar al usuario que se sitúa en el texto permitido para soltar el elemento origen
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasString()) {
                    target.setFill(Color.GREEN);
                }
	        });
	        
	        // OnDragDropped: Cuando se suelta el botón de ratón al arrastrar el elemento en el destino
	        target.setOnDragDropped((event) -> {
                System.out.println("onDragDropped");
                             
                // Si se ha almacenado texto se copia al destino
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    target.setText(db.getString());
                    success = true;
                }
                // Marcamos el evento como finalizado
                event.setDropCompleted(success);        
	        });
	 
	        // OnDragExited: Cuando el movimiento de ratón ha finalizado
	        target.setOnDragExited((event) -> {
            	System.out.println("onDragExited");
            	
                // Cuando se finaliza el color vuelve a ser negro
                target.setFill(Color.BLACK);
	        });
	            
	        // OnDragDone: Se notifica al elemento origen que ha finalizado la operación de arrastrar y soltar
	        source.setOnDragDone((event) -> {
                System.out.println("onDragDone");
                // Se elimina del origen
                if (event.getTransferMode() == TransferMode.MOVE) {
                    source.setText("");
                }
	        });
	 
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Hello Drag And Drop");
	        primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}

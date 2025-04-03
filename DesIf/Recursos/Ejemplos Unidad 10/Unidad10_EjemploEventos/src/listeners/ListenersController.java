package listeners;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.collections.ListChangeListener.Change;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class ListenersController {
	@FXML
    private GridPane container;
	
	@FXML
    private ToggleGroup genero;

    @FXML
    private RadioButton hombre;
	
    @FXML
    private RadioButton mujer;
    
	@FXML
	private TextField textField;
	
	@FXML
    private ComboBox<String> comboBox;
	
	@FXML
	private Text resultado;
	
	@FXML
	private ListView<Integer> listNumeros;

	// Listener para el campo de texto
	InvalidationListener textListener = new InvalidationListener() {
		@Override
		public void invalidated(Observable observable) {
			StringProperty sp = (StringProperty) observable;
			System.out.println(observable.toString() + ", " + sp.get());				
		}
	};
	
    @FXML
    private void initialize() {
    	// Ítems del ComboBox
    	comboBox.getItems().addAll("Combo1", "Combo2", "Combo3", "Combo4", "Combo5", "Combo6",
        		"Combo7", "Combo8", "Combo9");
    	comboBox.getSelectionModel().select("Combo3");
    	
    	// Se asocia el valor del TextField al combo
    	comboBox.valueProperty().bind(textField.textProperty());
        	
    	// Cada vez que se cambia el TextField se notifica por consola
    	textField.textProperty().addListener(textListener);    	       	
    	   	
    	// Cualquier nueva selección del usuario se registra en el texto de debajo
    	comboBox.getSelectionModel().selectedItemProperty().addListener(
    		(observable, oldValue, newValue) -> {
    			resultado.setText("Antiguo -> " + oldValue + "\n" + "Nuevo -> " + newValue);
    		});    	
       	
    	// Ítems del ListView (con la segunda línea se asigna un CellFactory para permitir que sean editables)
    	listNumeros.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9);
        
    	// Para seleccionar más de un ítem a la vez
    	listNumeros.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
    	// Cuando se detecta un nuevo índice se muestran todos aquellos ya seleccionados
    	// Para ObservableList, el listener de tipo change solo acepta un parámetro que incluye ímplitamente los valores modificados
    	listNumeros.getSelectionModel().getSelectedItems().addListener((Change<? extends Integer> change) -> {
    		// Hay que llamar a next para obtener el cambio actual 
    		while (change.next()) {
    			 if (change.wasAdded()) {
    				 System.out.println("Nuevos -> " + change.getAddedSubList());
    		     }
    			 if (change.wasRemoved()) {
    				 System.out.println("Eliminados -> " + change.getRemoved());
    			 }
    		 }   		
    	});
    	
    	// Esta sería la alternativa para InvalidationListener 
    	listNumeros.getSelectionModel().getSelectedItems().addListener((Observable observable) -> {
    		System.out.println("Invalidation -> " + observable);
    	});
    	
    	// Prueba de listener al añadir un nuevo elemento
    	listNumeros.getItems().addListener((Observable observable) -> {
    		System.out.println("Invalidation al añadir -> " + observable);
    	});
    	
    	listNumeros.getItems().add(10);
    	
    	// Aparte de los listeners y bind, vamos a probar a acceder dinámicamente a un control
    	// Desde cualquier contenedor, con lookup podemos recuperar controles de la página
    	// Además, vamos a probar a seleccionar directamente desde un ToggleGroup del RadioButton
    	genero.selectToggle((RadioButton) container.lookup("#mujer"));
    }
    
    @FXML
    private void eliminarTextListener(ActionEvent event) {
    	textField.textProperty().removeListener(textListener);
    	comboBox.valueProperty().unbind();
    }
   
}

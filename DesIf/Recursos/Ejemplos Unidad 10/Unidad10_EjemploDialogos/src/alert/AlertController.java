package alert;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class AlertController {

    @FXML
    private TextField textInput;

    @FXML
    private Button infoButton;

    @FXML
    private Button saveButton;
    
    @FXML
    private Button clearButton;
    
    // Función auxiliar para crear alert
    private Alert crearAlert(AlertType type, String title, String header, String contextText) {
    	Alert auxAlert = new Alert(type);
    	
    	auxAlert.setTitle(title);
    	auxAlert.setHeaderText(header);
    	auxAlert.setContentText(contextText);
    	
    	return auxAlert;
    }
      	
    @FXML
    private void initialize() { 
     	// Alert de tipo informativo
    	Alert info = crearAlert(AlertType.INFORMATION, "Ejemplo de diálogo",
    			"Alert informativo", "Esto es un ejemplo de diálogos en Java FX... ");
    	
    	// Se muestra el diálogo cuando se hace click en el botón
    	infoButton.setOnAction(e -> {
    		info.showAndWait();
        });
    	
    	// Alert de tipo error
    	Alert alert = crearAlert(AlertType.WARNING, "Ejemplo de diálogo",
    			"Alert de error", "Formato de texto incorrecto");
		
    	// Se muestra el diálogo cuando se hace click en el botón y no se cumple el formato del texto
    	saveButton.setOnAction(e -> {
    		String txt = textInput.getText().trim();
    		    		
    		if ((txt.isEmpty()) || (txt.length() < 5)) {
    			alert.showAndWait();
    			textInput.requestFocus(); // Permite llevar el foco al campo de texto
    		}    		
        });
    	
    	// Alert de tipo confirmación
    	Alert confirm = crearAlert(AlertType.CONFIRMATION, "Ejemplo de diálogo",
    			"Alert de confirmación", "¿Desea borrar el valor del campo de texto");
    	
    	// Botón de confirmación antes de borrar el texto
    	clearButton.setOnAction(e -> {
    		// 3 alternativas. Comentar el resto para probar alguna
    		
    		// Si el usuario acepta, entonces se lleva a cabo la acción correspondiente
    		/*Optional<ButtonType> result = confirm.showAndWait();
    		if (result.isPresent() && result.get() == ButtonType.OK) {
    			textInput.setText("");
				textInput.requestFocus();
    		}*/

    		// Si el usuario acepta, entonces se lleva a cabo la acción correspondiente
    		confirm.showAndWait().ifPresent(response -> {
    			if (response == ButtonType.OK) {
    				textInput.setText("");
    				textInput.requestFocus();
    		    }
    		});
    		
    		/*confirm.showAndWait()
    	       .filter(response -> response == ButtonType.OK)
    	       .ifPresent(response -> {
    	       		textInput.setText("");
    	       		textInput.requestFocus();
    	       });*/    		
    	});
    }
    
}

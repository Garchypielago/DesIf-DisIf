package com.example.t10ej01.alert;

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
    
    // Funci�n auxiliar para crear alert
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
    	Alert info = crearAlert(AlertType.INFORMATION, "Ejemplo de di�logo",
    			"Alert informativo", "Esto es un ejemplo de di�logos en Java FX... ");
    	
    	// Se muestra el di�logo cuando se hace click en el bot�n
    	infoButton.setOnAction(e -> {
    		info.showAndWait();
        });
    	
    	// Alert de tipo error
    	Alert alert = crearAlert(AlertType.WARNING, "Ejemplo de di�logo",
    			"Alert de error", "Formato de texto incorrecto");
		
    	// Se muestra el di�logo cuando se hace click en el bot�n y no se cumple el formato del texto
    	saveButton.setOnAction(e -> {
    		String txt = textInput.getText().trim();
    		    		
    		if ((txt.isEmpty()) || (txt.length() < 5)) {
    			alert.showAndWait();
    			textInput.requestFocus(); // Permite llevar el foco al campo de texto
    		}    		
        });
    	
    	// Alert de tipo confirmaci�n
    	Alert confirm = crearAlert(AlertType.CONFIRMATION, "Ejemplo de di�logo",
    			"Alert de confirmaci�n", "�Desea borrar el valor del campo de texto");
    	
    	// Bot�n de confirmaci�n antes de borrar el texto
    	clearButton.setOnAction(e -> {
    		// 3 alternativas. Comentar el resto para probar alguna
    		
    		// Si el usuario acepta, entonces se lleva a cabo la acci�n correspondiente
    		/*Optional<ButtonType> result = confirm.showAndWait();
    		if (result.isPresent() && result.get() == ButtonType.OK) {
    			textInput.setText("");
				textInput.requestFocus();
    		}*/

    		// Si el usuario acepta, entonces se lleva a cabo la acci�n correspondiente
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

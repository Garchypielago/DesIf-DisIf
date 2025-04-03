package com.example.t10ej01.dialogoEntrada;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;
import javafx.stage.Modality;

public class InputDialogController {

    @FXML
    private Button textButton;

    @FXML
    private Button choiceButton;
    
    @FXML
    private Text userInput;

      	
    @FXML
    private void initialize() {
    	// Di�logo con texto por defecto
    	TextInputDialog textDialog = new TextInputDialog("Texto de ejemplo...");
    	textDialog.initModality(Modality.APPLICATION_MODAL); // En ese caso ser� "no modal"
    	textDialog.setTitle("Ejemplo de di�logo");
    	textDialog.setHeaderText("Di�logo para introducir un texto");
    	    	 
    	textButton.setOnAction(e -> {
    		/*Optional<String> result = textDialog.showAndWait();
    		if (result.isPresent()) {
    			userInput.setText(result.get());
    		}*/    	  		
    		textDialog.showAndWait().ifPresent(response -> {
    			userInput.setText(response);
    		});
    	});    	
    	
    	// Lista para el ChoiceDialog
    	String [] arrayData = {"Primero", "Segundo", "Tercero", "Cuarto"};
    	ObservableList<String> ol = FXCollections.observableArrayList(arrayData);
    	    	
    	// Se crea el ChoiceDialog con el primer elemento seleccionado por defecto y el listado anterior
    	ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>(ol.get(0), ol);
    	choiceDialog.initModality(Modality.NONE); // En ese caso ser� "no modal"
    	choiceDialog.setTitle("Ejemplo de di�logo");
    	choiceDialog.setHeaderText("Seleccione un valor...");
    	
    	choiceButton.setOnAction(e -> {
    		// Se incluye la respuesta del usuario en el campo de tipo Text de la pantalla
    		choiceDialog.showAndWait().ifPresent(response -> {
    			userInput.setText(response);
    		});;
    	}); 
    }
    
}

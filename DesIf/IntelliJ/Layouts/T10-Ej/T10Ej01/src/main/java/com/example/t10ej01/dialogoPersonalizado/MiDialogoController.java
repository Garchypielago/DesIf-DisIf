package com.example.t10ej01.dialogoPersonalizado;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MiDialogoController {

	@FXML
    private PasswordField password;

    @FXML
    private TextField username;
    
    @FXML
    private Button btnAceptar;
    
    // Campos auxiliares para intercambiar datos con la clase Main
    private Stage dialogStage;
    private Label label;
      	
    @FXML
    private void initialize() {
    	
    }
    
    @FXML
    private void cargarUsuario(ActionEvent event) {
    	if ((username.getText() == null) || (username.getText().length() == 0) || 
    		(password.getText() == null) || (password.getText().length() == 0)) {
    		
    		// Se muestra un alert si alg�n campo est� vac�o
    		Alert errorAlert = new Alert(AlertType.ERROR);
        	
    		errorAlert.setTitle("Hay campos incorrectos");
    		errorAlert.setHeaderText("Por favor, rellena correctamente los campos");
    		errorAlert.setContentText("El usuario o la contrase�a est�n vac�os");
    		
    		errorAlert.showAndWait();
    	} else {
    		label.setText("Usuario: " + username.getText() + " Password: " + password.getText());
    		
    		dialogStage.close();
    	}        
    }

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
	    
}

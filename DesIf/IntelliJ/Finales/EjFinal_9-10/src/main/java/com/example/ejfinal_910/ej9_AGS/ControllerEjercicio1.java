package com.example.ejfinal_910.ej9_AGS;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class ControllerEjercicio1 {
	
	@FXML
	private ComboBox<String> combo;

	@FXML
	private TreeView<String> listado;

    @FXML
    private void initialize() {   
    	// �tems num�ricos del ComboBox
    	combo.getItems().addAll("Programaci�n multimedia y dispositivos m�viles", 
    			"Sistemas de gesti�n empresarial", "Desarrollo web en entorno cliente",
    			"Despliegue de aplicaciones web");	
        	    	     	
    	// �tem ra�z del TreeView que se expande por defecto
    	TreeItem<String> rootItem = new TreeItem<String>("Doble titulaci�n");
    	rootItem.setExpanded(true);

        // Resto de �tems del TreeView
    	rootItem.getChildren().add(new TreeItem<String>("Dise�o de interfaces web"));
    	rootItem.getChildren().add(new TreeItem<String>("Desarrollo de interfaces"));
    	rootItem.getChildren().add(new TreeItem<String>("Acceso a datos"));
    	rootItem.getChildren().add(new TreeItem<String>("Programaci�n de servicios y procesos"));
    
    	// Se asigna el �tem ra�z al TreeView
    	listado.setRoot(rootItem);
    }
    
}
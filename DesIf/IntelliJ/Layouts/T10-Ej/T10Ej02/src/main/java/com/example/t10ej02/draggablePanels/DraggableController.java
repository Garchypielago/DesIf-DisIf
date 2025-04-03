package com.example.t10ej02.draggablePanels;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class DraggableController {
	@FXML
    private HBox loginPanel;

    @FXML
    private HBox confirmationPanel;

    @FXML
    private HBox progressPanel;
    
    @FXML
    private CheckBox dragModeActiveProperty;


    @FXML
    private void initialize() {   
    	makeDraggable(loginPanel);
    	makeDraggable(confirmationPanel);
    	makeDraggable(progressPanel);
    }
    
    private void makeDraggable(final Node node) {
        final DragContext dragContext = new DragContext();
            
        node.addEventFilter(MouseEvent.ANY, (mouseEvent) -> {
        	if (dragModeActiveProperty.isSelected()) {
        		// Se desactivan eventos para los hijos
                mouseEvent.consume();
            }
        });
        
        node.addEventFilter(MouseEvent.MOUSE_PRESSED, (mouseEvent) -> {
        	if (dragModeActiveProperty.isSelected()) {
        		// Guardamos la posici�n del rat�n
                dragContext.mouseAnchorX = mouseEvent.getX();
                dragContext.mouseAnchorY = mouseEvent.getY();
                dragContext.initialTranslateX = node.getTranslateX();
                dragContext.initialTranslateY = node.getTranslateY();
            }
        });
          
        node.addEventFilter(MouseEvent.MOUSE_DRAGGED, (mouseEvent) -> {
			if (dragModeActiveProperty.isSelected()) {
			    // Se ajusta la posici�n final 
			    node.setTranslateX(dragContext.initialTranslateX + mouseEvent.getX() - dragContext.mouseAnchorX);
			    node.setTranslateY(dragContext.initialTranslateY + mouseEvent.getY() - dragContext.mouseAnchorY);
			}
        });           
    }
    
    private static final class DragContext {
        public double mouseAnchorX;
        public double mouseAnchorY;
        public double initialTranslateX;
        public double initialTranslateY;
    }
}

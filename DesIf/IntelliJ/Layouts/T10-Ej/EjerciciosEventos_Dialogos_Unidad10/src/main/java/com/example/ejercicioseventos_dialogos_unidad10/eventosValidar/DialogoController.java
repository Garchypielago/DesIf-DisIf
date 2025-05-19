package com.example.ejercicioseventos_dialogos_unidad10.eventosValidar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class DialogoController {

    @FXML private VBox root;
    @FXML private TextField tfDialog;
    @FXML private Button btnAceptar, btnCancelar;

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void initialize() {
        // sólo mayúsculas
        tfDialog.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            if (!e.getCharacter().matches("[A-Z]")) e.consume();
        });

        btnAceptar.setDefaultButton(false);
        btnCancelar.setCancelButton(false);
        root.sceneProperty().addListener((obs,o,s) -> {
            if (s!=null) {
                s.addEventFilter(KeyEvent.KEY_PRESSED, ev -> {
                    if (ev.getCode()==KeyCode.ENTER||ev.getCode()==KeyCode.ESCAPE) {
                        ev.consume();
                    }
                });
            }
        });
    }

    @FXML
    private void onAceptar() {
            mainController.setPrincipalText(tfDialog.getText());
        btnAceptar.getScene().getWindow().hide();
    }

    @FXML
    private void onCancelar() {
        btnCancelar.getScene().getWindow().hide();
    }
}
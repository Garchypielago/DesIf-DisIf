package com.example.ejercicioseventos_dialogos_unidad10.eventosValidar;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {

    @FXML private TextField tfPrincipal;
    @FXML private Button btnMostrarDialog;

    @FXML
    private void onMostrarDialog() throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/ejercicioseventos_dialogos_unidad10/eventosValidar/dialogo.fxml")
        );
        Parent root = loader.load();

        DialogoController dlgCtrl = loader.getController();
        dlgCtrl.setMainController(this);

        Stage dialog = new Stage();
        dialog.setScene(new Scene(root));
        dialog.initOwner(btnMostrarDialog.getScene().getWindow());
        dialog.showAndWait();

        tfPrincipal.requestFocus();
    }

    public void setPrincipalText(String texto) {
        tfPrincipal.setText(texto);
    }
}
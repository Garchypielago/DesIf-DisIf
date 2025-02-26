package com.example.alejandro_garcia_sanchez_practica1.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class MainController {
    @FXML private BorderPane rootLayout;

    @FXML
    private void initialize() {
        System.out.println("MainController inicializado. rootLayout: " + rootLayout);
    }

    public void mostrarListado() throws IOException {
        cargarVista("/com/example/alejandro_garcia_sanchez_practica1/vistas/ListadoView.fxml");
    }

    public void mostrarMantenimiento() throws IOException {
        cargarVista("/com/example/alejandro_garcia_sanchez_practica1/vistas/MantenimientoView.fxml");
    }

    public void mostrarTutorial() throws IOException {
        cargarVista("/com/example/alejandro_garcia_sanchez_practica1/vistas/TutorialView.fxml");
    }

    private void cargarVista(String ruta) throws IOException {
        System.out.println("Cargando vista: " + ruta);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
        Parent vista = loader.load();

        if (rootLayout == null) {
            System.err.println("Error: rootLayout es null. Verifica el fx:id en el FXML.");
            return;
        }

        rootLayout.setCenter(vista);
    }

    @FXML
    private void salir() {
        System.out.println("Saliendo de la aplicación...");
        System.exit(0);
    }
}

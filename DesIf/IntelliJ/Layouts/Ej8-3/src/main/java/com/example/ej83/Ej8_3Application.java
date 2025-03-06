package com.example.ej83;

import com.example.ej83.objects.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Ej8_3Application extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Person> peopleData = FXCollections.observableArrayList();

    public Ej8_3Application(){
        peopleData.add(new Person("David", "Doe"));
        peopleData.add(new Person("Samu", "Gil"));
        peopleData.add(new Person("Jack", "Jock"));
        peopleData.add(new Person("Will", "Doe"));
        peopleData.add(new Person("Bob", "Yeia"));
        peopleData.add(new Person("Kim", "Possible"));
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showPersonOverview();
    }

    /** Inicializa el diseño de la pantalla principal. */
    public void initRootLayout() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(com.example.ej83.Ej8_3Application.class.getResource("RootLayout.fxml"));
            rootLayout = fxmlLoader.load();

            // Se añade el diseño principal a la escena
            Scene scene = new Scene(rootLayout, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Muestra el diseño de PersonOverview dentro de la pantalla
     principal */
    public void showPersonOverview() {
        try {
            // Cargamos el archivo PersonOverview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(com.example.ej83.Ej8_3Application.class.getResource("PersonOverview-view.fxml"));
            AnchorPane personOverview = loader.load();
            rootLayout.setCenter(personOverview);

            PersonOverviewController controller = loader.getController();
            controller.setApplication(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Returns the main stage. */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Person> getPeopleData() {
        return peopleData;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

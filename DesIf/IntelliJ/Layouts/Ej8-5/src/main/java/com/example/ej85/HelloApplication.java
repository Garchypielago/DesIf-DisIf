package com.example.ej85;

import com.example.ej85.entities.Order;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private ObservableList<Order> orderData = FXCollections.observableArrayList();

    public HelloApplication() {
        orderData.add(new Order(1, false, 0, 0.07, "Ellen Jowels"));
        orderData.add(new Order(2, true, 1, 0.08, "Eric Northope"));
        orderData.add(new Order(3, false, 0, 0.15, "Stella Gerrad"));
        orderData.add(new Order(4, true, 0, 0.03, "Stanly Horbriend"));
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        HelloController controller = fxmlLoader.getController();
        controller.setApplication(this);
    }

    public ObservableList<Order> getOrderData() {
        return orderData;
    }

    public static void main(String[] args) {
        launch();
    }
}
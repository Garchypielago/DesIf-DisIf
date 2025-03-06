package com.example.ej85.entities;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Order {
    private SimpleIntegerProperty orderId;
    private SimpleBooleanProperty priority;
    private SimpleIntegerProperty courier;
    private SimpleDoubleProperty cost;
    private SimpleStringProperty driver;

    public Order(Integer orderId, Boolean priority, Integer courier, Double cost, String driver) {
        this.orderId = new SimpleIntegerProperty(orderId);
        this.priority = new SimpleBooleanProperty(priority);
        this.courier = new SimpleIntegerProperty(courier);
        this.cost = new SimpleDoubleProperty(cost);
        this.driver = new SimpleStringProperty(driver);
    }

    public int getOrderId() {
        return orderId.get();
    }

    public SimpleIntegerProperty orderIdProperty() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId.set(orderId);
    }

    public boolean isPriority() {
        return priority.get();
    }

    public SimpleBooleanProperty priorityProperty() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority.set(priority);
    }

    public int getCourier() {
        return courier.get();
    }

    public SimpleIntegerProperty courierProperty() {
        return courier;
    }

    public void setCourier(int courier) {
        this.courier.set(courier);
    }

    public double getCost() {
        return cost.get();
    }

    public SimpleDoubleProperty costProperty() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost.set(cost);
    }

    public String getDriver() {
        return driver.get();
    }

    public SimpleStringProperty driverProperty() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver.set(driver);
    }
}

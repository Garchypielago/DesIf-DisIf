package com.example.ejfinal_78.ej2_AGS;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Producto {

    private final IntegerProperty id;
    private final StringProperty descripcion;

    public Producto() {
        this(null, null);
    }

    public Producto(Integer id, String descripcion) {
        this.id = new SimpleIntegerProperty(id);
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }
}
package com.example.practica01.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class EmpleadoData {
    private static final ObservableList<Empleado> empleados = FXCollections.observableArrayList();

    static {
        // Datos iniciales para prueba
        empleados.add(new Empleado("Ana", "García", "Ventas", LocalDate.of(2020, 5, 10), true));
        empleados.add(new Empleado("Carlos", "Pérez", "TI", LocalDate.of(2022, 3, 15), true));
        empleados.add(new Empleado("Marta", "López", "Recursos Humanos", LocalDate.of(2019, 7, 22), false));
    }

    public static ObservableList<Empleado> getEmpleados() {
        return empleados;
    }

    public static void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
}


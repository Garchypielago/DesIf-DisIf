package com.example.alejandro_garcia_sanchez_practica1.modelos;

import java.time.LocalDate;

public class Empleado {
    private String nombre;
    private String apellido;
    private String departamento;
    private LocalDate fechaContratacion;
    private boolean activo;

    public Empleado(String nombre, String apellido, String departamento, LocalDate fechaContratacion, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
        this.fechaContratacion = fechaContratacion;
        this.activo = activo;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDate fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}


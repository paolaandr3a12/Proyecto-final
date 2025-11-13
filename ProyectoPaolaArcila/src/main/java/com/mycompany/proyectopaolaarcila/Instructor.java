package com.mycompany.proyectopaolaarcila;

public class Instructor extends Persona {
    private String especialidad;

    public Instructor(String id, String nombre, String correo, String especialidad) {
        super(id, nombre, correo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { return especialidad; }

    @Override
    public String descripcion() {
        return "Instructor: " + getNombre() + " - Especialidad: " + especialidad;
    }
}
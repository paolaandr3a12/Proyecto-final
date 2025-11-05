package com.mycompany.proyectopaolat;
//herencia
public class Instructor extends Persona {
    private String especialidad;

    public Instructor(String id, String nombre, String correo, String especialidad) {
        super(id, nombre, correo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    @Override
    public String descripcion() {
        return "Instructor: " + getNombre() + " - Especialidad: " + especialidad;
    }
}
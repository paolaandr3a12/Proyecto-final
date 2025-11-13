package com.mycompany.proyectopaolaarcila;

public abstract class Persona {
    private String id;
    private String nombre;
    private String correo;

    public Persona(String id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }

    public abstract String descripcion();
}
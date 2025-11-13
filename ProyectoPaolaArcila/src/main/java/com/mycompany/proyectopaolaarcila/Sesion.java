package com.mycompany.proyectopaolaarcila;

public class Sesion {
    private final String fecha;
    private final String tema;

    public Sesion(String fecha, String tema) {
        this.fecha = fecha;
        this.tema = tema;
    }

    public String getFecha() { return fecha; }
    public String getTema() { return tema; }
}
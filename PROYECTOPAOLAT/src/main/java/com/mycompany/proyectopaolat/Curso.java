package com.mycompany.proyectopaolat;

import java.util.ArrayList;

public abstract class Curso {
    protected String codigo;
    protected String titulo;
    protected Instructor instructor;
    protected ArrayList<Sesion> sesiones; //composicion
    protected ArrayList<Inscripcion> inscripciones; //agregacion

    public Curso(String codigo, String titulo, Instructor instructor, ArrayList<Inscripcion> inscripciones) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.instructor = instructor;
        this.sesiones = new ArrayList<>(); //composicion
        this.inscripciones = inscripciones; //agregacion
    }

    // Método abstracto
    public abstract double calcularNotaFinal(Estudiante e);

    // Agregar sesión
    public void agregarSesion(String fecha, String tema) {
        Sesion s = new Sesion(fecha, tema);
        sesiones.add(s);
    }

    // Agregar inscripción
    public void agregarInscripcion(Inscripcion inscripcion) {
        if (inscripcion != null) {
            inscripciones.add(inscripcion);
        }
    }

    // Método corregido para inscribir estudiante
    public void inscribir(Estudiante e) {
        Inscripcion ins = new Inscripcion(e, this);
        agregarInscripcion(ins);
    }

    // Getters
    public ArrayList<Inscripcion> getInscripciones() { return inscripciones; }
    public String getTitulo() { return titulo; }
    public String getCodigo() { return codigo; }
}
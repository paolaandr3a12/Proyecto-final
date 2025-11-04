package com.mycompany.proyectofinal_cursospao;

import java.util.ArrayList;

public abstract class Curso {
    // Atributos principales
    protected String codigo;
    protected String titulo;
    protected Instructor instructor;

    // Composición: el curso crea y controla sus sesiones
    protected ArrayList<Sesion> sesiones;

    // Agregación: las inscripciones existen fuera del curso
    protected ArrayList<Inscripcion> inscripciones;

    // Constructor: recibe las inscripciones externas (agregación)
    public Curso(String codigo, String titulo, Instructor instructor, ArrayList<Inscripcion> inscripciones) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.instructor = instructor;
        this.sesiones = new ArrayList<>();     // composición (creadas por el curso)
        this.inscripciones = inscripciones;    // agregación (referencia externa)
    }

    // Método abstracto para cálculo de nota final (cada curso lo define)
    public abstract double calcularNotaFinal(Estudiante e);

    // Método para agregar sesiones (composición)
    public void agregarSesion(String fecha, String tema) {
        Sesion s = new Sesion(fecha, tema);
        sesiones.add(s);
    }

    // Método para asociar una inscripción ya existente al curso (agregación)
    public void agregarInscripcion(Inscripcion inscripcion) {
        if (inscripcion != null) {
            inscripciones.add(inscripcion);
        }
    }

    // Getters
    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    void inscribir(Estudiante e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}


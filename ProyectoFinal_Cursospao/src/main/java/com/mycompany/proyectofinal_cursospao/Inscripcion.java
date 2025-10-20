/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal_cursospao;

// Inscripcion.java
public class Inscripcion {
    private final Estudiante estudiante; // asociación hacia Estudiante
    private final Curso curso; // asociación hacia Curso (interfaz/abstracto)
    private double notaFinal;
    private boolean asistio;

    public Inscripcion(Estudiante estudiante, Curso curso) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.notaFinal = 0;
        this.asistio = false;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public Curso getCurso() { return curso; }

    public double getNotaFinal() { return notaFinal; }
    public void setNotaFinal(double nota) { this.notaFinal = nota; }

    public boolean isAsistio() { return asistio; }
    public void marcarAsistencia(boolean v) { this.asistio = v; }
}
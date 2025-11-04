package com.mycompany.proyectofinal_cursospao;

import java.util.ArrayList;

public class CursoAutoconfianza extends Curso {

    // Constructor correcto, sin pasar inscripciones
    public CursoAutoconfianza(String codigo, String titulo, Instructor instructor) {
        super(codigo, titulo, instructor, new ArrayList<>());
    }

    @Override
    public double calcularNotaFinal(Estudiante e) {
        // Algoritmo de ejemplo: promedio penalizado por inasistencias
        double base = e.promedio();

        long asistencias = getInscripciones().stream()
                .filter(i -> i.getEstudiante().getId().equals(e.getId()) && i.isAsistio())
                .count();

        long totalSesiones = sesiones.isEmpty() ? 1 : sesiones.size();
        double proporcion = (double) asistencias / totalSesiones;

        // Cálculo personalizado
        return Math.max(0.0, base * 0.6 + proporcion * 2.0);
    }
}
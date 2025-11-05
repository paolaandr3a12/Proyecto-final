package com.mycompany.proyectopaolat;

import java.util.ArrayList;
//herencia
public class CursoAlimentacionSaludable extends Curso {

    public CursoAlimentacionSaludable(String codigo, String titulo, Instructor instructor) {
        super(codigo, titulo, instructor, new ArrayList<>());
    }

    @Override
    public double calcularNotaFinal(Estudiante e) {
        double base = e.promedio();

        long asistencias = getInscripciones().stream()
                .filter(i -> i.getEstudiante().getId().equals(e.getId()) && i.isAsistio())
                .count();

        double bono = Math.min(1.0, asistencias * 0.2);
        return Math.min(5.0, base + bono);
    }
}
package com.mycompany.proyectopaolat;

import java.util.ArrayList;
//implementacion 
public class TarjetaSpark implements AccesoRecursos {
    private final boolean activa;
    private final String tipoCurso;

    public TarjetaSpark(String tipoCurso, boolean activa) {
        this.tipoCurso = tipoCurso;
        this.activa = activa;
    }

    @Override
    public ArrayList<String> obtenerRecursosBasicos() {
        ArrayList<String> recursos = new ArrayList<>();
        recursos.add("Guía introductoria del curso " + tipoCurso);
        recursos.add("Podcast educativo básico");
        recursos.add("Artículo de lectura libre");
        return recursos;
    }

    @Override
    public ArrayList<String> obtenerRecursosPremium() {
        ArrayList<String> recursos = new ArrayList<>();
        recursos.add("Video avanzado del curso " + tipoCurso);
        recursos.add("Libro digital completo");
        recursos.add("Acceso a biblioteca virtual y simuladores");
        return recursos;
    }

    @Override
    public void mostrarRecursos(boolean accesoPremium) {
        try {
            System.out.println("\nRecursos disponibles para el curso " + tipoCurso + ":");
            ArrayList<String> recursos = accesoPremium ? obtenerRecursosPremium() : obtenerRecursosBasicos();
            for (String r : recursos) {
                System.out.println(" - " + r);
            }
            if (!accesoPremium) {
                throw new IllegalAccessException("⚠ Acceso limitado: actualiza a TarjetaSpark Premium para ver más recursos.");
            }
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isActiva() { return activa; }
}
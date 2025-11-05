package com.mycompany.proyectopaolat;

import java.util.ArrayList;
//es como un "contrato que la clase spark debe cumplir"
public interface AccesoRecursos {
    ArrayList<String> obtenerRecursosBasicos();
    ArrayList<String> obtenerRecursosPremium();
    void mostrarRecursos(boolean accesoPremium);
}
package com.mycompany.proyectopaolaarcila;

import java.util.ArrayList;

public interface AccesoRecursos {
    ArrayList<String> obtenerRecursosBasicos();
    ArrayList<String> obtenerRecursosPremium();
    void mostrarRecursos(boolean accesoPremium);
}
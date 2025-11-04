
package com.mycompany.proyectofinal_cursospao;

import java.util.ArrayList;

public interface AccesoRecursos {
    ArrayList<String> obtenerRecursosBasicos();
    ArrayList<String> obtenerRecursosPremium();
    void mostrarRecursos(boolean accesoPremium);
}
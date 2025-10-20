
package com.mycompany.proyectofinal_cursospao;
import java.util.HashMap;

public class RegistroNotas {
    private final HashMap<String, Double> notas; // idEstudiante -> nota final

    public RegistroNotas() {
        notas = new HashMap<>();
    }

    public void asignarNota(String idEstudiante, double nota) {
        notas.put(idEstudiante, nota);
    }

    public void mostrarNotas() {
        System.out.println("📊 Registro de notas:");
        notas.forEach((id, nota) -> {
            System.out.println("Estudiante " + id + ": " + nota);
        });
    }
}

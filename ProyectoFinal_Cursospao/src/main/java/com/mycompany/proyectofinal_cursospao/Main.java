package com.mycompany.proyectofinal_cursospao; 
import java.util.ArrayList; 
import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        // Uso un try con recursos para que el Scanner se cierre solo cuando termine el programa.
        try (Scanner sc = new Scanner(System.in)) {
            
            // --- Inicio del sistema ---
            System.out.println("=== SISTEMA DE CURSOS ===");
            
            // Pido los datos básicos del instructor
            System.out.print("Ingrese nombre del instructor: ");
            String nombreInstructor = sc.nextLine();
            System.out.print("Ingrese ID del instructor: ");
            String idInstructor = sc.nextLine();
            System.out.print("Ingrese correo del instructor: ");
            String correoInstructor = sc.nextLine();
            System.out.print("Ingrese especialidad del instructor: ");
            String especialidad = sc.nextLine();
            
            // Aquí creo el objeto "instructor" con los datos que el usuario escribió.
            // Esto es un ejemplo de cómo se crean objetos a partir de una clase.
            Instructor instructor = new Instructor(idInstructor, nombreInstructor, correoInstructor, especialidad);
            
            
            // --- Elección del curso ---
            System.out.println("\nSeleccione curso a crear:");
            System.out.println("1. Curso de Autoconfianza");
            System.out.println("2. Curso de Alimentación Saludable");
            System.out.print("Opción: ");
            int opcionCurso = sc.nextInt(); // Guardo la opción que el usuario elija.
            sc.nextLine(); // Limpio el buffer (evita errores al leer cadenas después de números)
            
            // Pido los datos del curso
            System.out.print("Ingrese código del curso: ");
            String codigoCurso = sc.nextLine();
            System.out.print("Ingrese título del curso: ");
            String tituloCurso = sc.nextLine();
            
            // Creo una variable tipo Curso, pero todavía no sé cuál curso específico será.
            Curso curso;
            
            // Dependiendo de lo que el usuario elija, creo un curso de Autoconfianza o de Alimentación Saludable.
            // Aquí se aplica el polimorfismo: la variable "curso" puede guardar distintos tipos de curso.
            if (opcionCurso == 1) {
                curso = new CursoAutoconfianza(codigoCurso, tituloCurso, instructor);
            } else {
                curso = new CursoAlimentacionSaludable(codigoCurso, tituloCurso, instructor);
            }
            
            
            // --- Creación de sesiones ---
            System.out.println("\n=== CREAR SESIONES ===");
            System.out.print("¿Cuántas sesiones desea agregar? ");
            int numSesiones = sc.nextInt();
            sc.nextLine();
            
            // Recorro con un ciclo para agregar todas las sesiones que el usuario indique.
            for (int i = 0; i < numSesiones; i++) {
                System.out.println("Sesión #" + (i + 1));
                System.out.print("Fecha: ");
                String fecha = sc.nextLine();
                System.out.print("Tema: ");
                String tema = sc.nextLine();
                
                // Uso el método "agregarSesion" para guardar cada sesión dentro del curso.
                curso.agregarSesion(fecha, tema);
            }
            
            
            // --- Inscripción de estudiantes ---
            System.out.println("\n=== INSCRIPCIÓN DE ESTUDIANTES ===");
            System.out.print("¿Cuántos estudiantes desea inscribir? ");
            int numEst = sc.nextInt();
            sc.nextLine();
            
            // Creo una lista donde voy a guardar los estudiantes inscritos.
            ArrayList<Estudiante> estudiantes = new ArrayList<>();
            
            // Con este ciclo voy pidiendo los datos de cada estudiante.
            for (int i = 0; i < numEst; i++) {
                System.out.println("\n--- Estudiante #" + (i + 1) + " ---");
                System.out.print("ID: ");
                String id = sc.nextLine();
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Correo: ");
                String correo = sc.nextLine();
                
                // Creo el objeto del estudiante con los datos que ingresó el usuario.
                Estudiante e = new Estudiante(id, nombre, correo);
                
                // Lo inscribo al curso y lo guardo en la lista de estudiantes.
                curso.inscribir(e);
                estudiantes.add(e);
            }
            
            
            // --- Registro de notas ---
            System.out.println("\n=== AGREGAR NOTAS ===");
            for (Estudiante e : estudiantes) { // Recorro uno por uno los estudiantes.
                System.out.println("Notas para " + e.getNombre());
                System.out.print("¿Cuántas notas desea agregar? ");
                int nNotas = sc.nextInt();
                
                // Pido todas las notas que el usuario quiera registrar para ese estudiante.
                for (int j = 0; j < nNotas; j++) {
                    System.out.print("Nota " + (j + 1) + ": ");
                    double nota = sc.nextDouble();
                    e.agregarNota(nota); // Guardo cada nota dentro del objeto del estudiante.
                }
            }
            
            
            // --- Registro de asistencias ---
            System.out.println("\n=== MARCAR ASISTENCIAS ===");
            for (Estudiante e : estudiantes) {
                System.out.println("Asistencias para " + e.getNombre());
                
                // Recorro las inscripciones del curso para encontrar la del estudiante actual.
                for (Inscripcion ins : curso.getInscripciones()) {
                    if (ins.getEstudiante().getId().equals(e.getId())) {
                        
                        // Por cada sesión, pregunto si asistió o no.
                        for (int s = 0; s < curso.sesiones.size(); s++) {
                            System.out.print("¿Asistió a la sesión " + (s + 1) + "? (true/false): ");
                            boolean asistio = sc.nextBoolean();
                            
                            // Si asistió, marco su asistencia.
                            if (asistio) ins.marcarAsistencia(true);
                        }
                    }
                }
            }
            
            
            // --- Resultados finales ---
            System.out.println("\n=== RESULTADOS ===");
            for (Estudiante e : estudiantes) {
                // Calculo la nota final del estudiante (probablemente hace un promedio de sus notas).
                double notaFinal = curso.calcularNotaFinal(e);
                
                // Muestro la información del estudiante con su nota final.
                System.out.println(e.descripcion() + " → Nota Final: " + notaFinal);
            }
            
            
            // --- Resumen del curso creado ---
            System.out.println("\nCurso: " + curso.getTitulo() + " (" + curso.getCodigo() + ")");
            System.out.println("Instructor: " + instructor.getNombre());
            System.out.println("Sesiones creadas: " + numSesiones);
            System.out.println("Estudiantes inscritos: " + estudiantes.size());
            System.out.println("\n Prueba completada correctamente.");
        }
    }
}

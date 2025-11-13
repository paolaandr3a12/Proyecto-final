package com.mycompany.proyectopaolaarcila;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {

    // ======== COMPONENTES ========
    private JTextField txtIdInstructor, txtNombreInstructor, txtCorreoInstructor, txtEspecialidad;
    private JTextField txtCodigoCurso, txtTituloCurso;
    private JComboBox<String> cbTipoCurso;

    private JTextField txtFechaSesion, txtTemaSesion;
    private JButton btnAgregarSesion;

    private JTextField txtIdEst, txtNombreEst, txtCorreoEst;
    private JButton btnInscribirEst;

    private JButton btnAgregarNotas, btnMarcarAsistencias, btnGenerarReportes;
    private JButton btnRegistrarAsistencia;

    private JTextField txtTotalEstudiantes, txtAsistieron;
    private JTextArea areaSalida;

    // ======== DATOS ========
    private Curso cursoActual;
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<String[]> listaEstudiantes = new ArrayList<>();
    private ArrayList<Boolean> listaPagos = new ArrayList<>();

    // ======== PALETA DE COLORES ========
    private final Color verdeFondo = new Color(200, 230, 200);
    private final Color verdeOscuro = new Color(100, 160, 100);
    private final Color grisClaro = new Color(240, 240, 240);

    // ======== CONSTRUCTOR ========
    public VentanaPrincipal() {
        setTitle("🎓 Learnix - Sistema de Gestión de Cursos");
        setSize(900, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        getContentPane().setBackground(verdeFondo); // fondo general

        // ===== PANEL INSTRUCTOR =====
        JPanel panelInstructor = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInstructor.setBorder(BorderFactory.createTitledBorder("Datos del Instructor"));
        panelInstructor.setBackground(grisClaro);

        txtIdInstructor = new JTextField();
        txtNombreInstructor = new JTextField();
        txtCorreoInstructor = new JTextField();
        txtEspecialidad = new JTextField();

        panelInstructor.add(new JLabel("ID:"));
        panelInstructor.add(txtIdInstructor);
        panelInstructor.add(new JLabel("Nombre:"));
        panelInstructor.add(txtNombreInstructor);
        panelInstructor.add(new JLabel("Correo:"));
        panelInstructor.add(txtCorreoInstructor);
        panelInstructor.add(new JLabel("Especialidad:"));
        panelInstructor.add(txtEspecialidad);

        // ===== PANEL CURSO =====
        JPanel panelCurso = new JPanel(new GridLayout(4, 2, 5, 5));
        panelCurso.setBorder(BorderFactory.createTitledBorder("Datos del Curso"));
        panelCurso.setBackground(grisClaro);

        cbTipoCurso = new JComboBox<>(new String[]{"Autoconfianza", "Alimentación Saludable"});
        txtCodigoCurso = new JTextField();
        txtTituloCurso = new JTextField();
        JButton btnCrearCurso = new JButton("Crear Curso");
        estilizarBoton(btnCrearCurso);

        panelCurso.add(new JLabel("Tipo de Curso:"));
        panelCurso.add(cbTipoCurso);
        panelCurso.add(new JLabel("Código:"));
        panelCurso.add(txtCodigoCurso);
        panelCurso.add(new JLabel("Título:"));
        panelCurso.add(txtTituloCurso);
        panelCurso.add(new JLabel(""));
        panelCurso.add(btnCrearCurso);

        btnCrearCurso.addActionListener(e -> crearCurso());

        // ===== PANEL SESIONES =====
        JPanel panelSesion = new JPanel(new GridLayout(3, 2, 5, 5));
        panelSesion.setBorder(BorderFactory.createTitledBorder("Sesiones del Curso"));
        panelSesion.setBackground(grisClaro);

        txtFechaSesion = new JTextField();
        txtTemaSesion = new JTextField();
        btnAgregarSesion = new JButton("Agregar Sesión");
        estilizarBoton(btnAgregarSesion);

        panelSesion.add(new JLabel("Fecha:"));
        panelSesion.add(txtFechaSesion);
        panelSesion.add(new JLabel("Tema:"));
        panelSesion.add(txtTemaSesion);
        panelSesion.add(new JLabel(""));
        panelSesion.add(btnAgregarSesion);
        btnAgregarSesion.addActionListener(e -> agregarSesion());

        // ===== PANEL ESTUDIANTES =====
        JPanel panelEstudiantes = new JPanel(new GridLayout(4, 2, 5, 5));
        panelEstudiantes.setBorder(BorderFactory.createTitledBorder("Registro de Estudiantes"));
        panelEstudiantes.setBackground(grisClaro);

        txtIdEst = new JTextField();
        txtNombreEst = new JTextField();
        txtCorreoEst = new JTextField();
        btnInscribirEst = new JButton("Inscribir Estudiante");
        estilizarBoton(btnInscribirEst);

        panelEstudiantes.add(new JLabel("ID:"));
        panelEstudiantes.add(txtIdEst);
        panelEstudiantes.add(new JLabel("Nombre:"));
        panelEstudiantes.add(txtNombreEst);
        panelEstudiantes.add(new JLabel("Correo:"));
        panelEstudiantes.add(txtCorreoEst);
        panelEstudiantes.add(new JLabel(""));
        panelEstudiantes.add(btnInscribirEst);
        btnInscribirEst.addActionListener(e -> inscribirEstudiante());

        // ===== PANEL FUNCIONES =====
        JPanel panelFunciones = new JPanel(new GridLayout(4, 2, 10, 10));
        panelFunciones.setBorder(BorderFactory.createTitledBorder("Gestión del Curso"));
        panelFunciones.setBackground(grisClaro);

        btnAgregarNotas = new JButton("Agregar Notas");
        btnMarcarAsistencias = new JButton("Marcar Asistencias");
        btnGenerarReportes = new JButton("Generar Reportes PDF");
        estilizarBoton(btnAgregarNotas);
        estilizarBoton(btnMarcarAsistencias);
        estilizarBoton(btnGenerarReportes);

        txtTotalEstudiantes = new JTextField();
        txtAsistieron = new JTextField();
        btnRegistrarAsistencia = new JButton("Calcular Faltantes");
        estilizarBoton(btnRegistrarAsistencia);

        panelFunciones.add(btnAgregarNotas);
        panelFunciones.add(btnMarcarAsistencias);
        panelFunciones.add(btnGenerarReportes);
        panelFunciones.add(new JLabel("Total Estudiantes:"));
        panelFunciones.add(txtTotalEstudiantes);
        panelFunciones.add(new JLabel("Asistieron:"));
        panelFunciones.add(txtAsistieron);
        panelFunciones.add(btnRegistrarAsistencia);

        // ===== PANEL SALIDA =====
        areaSalida = new JTextArea(15, 40);
        areaSalida.setEditable(false);
        areaSalida.setBackground(Color.WHITE);
        JScrollPane scroll = new JScrollPane(areaSalida);
        scroll.setBorder(BorderFactory.createTitledBorder("Resultados"));

        // ===== CONTENEDORES =====
        JPanel panelArriba = new JPanel(new GridLayout(2, 1));
        panelArriba.setBackground(verdeFondo);
        panelArriba.add(panelInstructor);
        panelArriba.add(panelCurso);

        JPanel panelCentro = new JPanel(new GridLayout(3, 1));
        panelCentro.setBackground(verdeFondo);
        panelCentro.add(panelSesion);
        panelCentro.add(panelEstudiantes);
        panelCentro.add(panelFunciones);

        add(panelArriba, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
        add(scroll, BorderLayout.EAST);

        // ===== ACCIONES =====
        btnAgregarNotas.addActionListener(e -> agregarNotas());
        btnMarcarAsistencias.addActionListener(e -> marcarAsistencias());
        btnGenerarReportes.addActionListener(e -> generarReportes());
        btnRegistrarAsistencia.addActionListener(e -> calcularFaltantes());
    }

    // ======== MÉTODO PARA ESTILIZAR BOTONES ========
    private void estilizarBoton(JButton boton) {
        boton.setBackground(verdeOscuro);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createLineBorder(new Color(70, 120, 70)));
    }

    // =====================================================
    // Métodos funcionales: crearCurso(), agregarSesion(), etc.
    // =====================================================

    private void crearCurso() {
        try {
            String id = txtIdInstructor.getText().trim();
            String nombre = txtNombreInstructor.getText().trim();
            String correo = txtCorreoInstructor.getText().trim();
            String especialidad = txtEspecialidad.getText().trim();

            if (id.isEmpty() || nombre.isEmpty() || correo.isEmpty() || especialidad.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los datos del instructor.");
                return;
            }

            Instructor instructor = new Instructor(id, nombre, correo, especialidad);
            String tipoCurso = (String) cbTipoCurso.getSelectedItem();
            String codigo = txtCodigoCurso.getText().trim();
            String titulo = txtTituloCurso.getText().trim();

            if (tipoCurso.equals("Autoconfianza")) {
                cursoActual = new CursoAutoconfianza(codigo, titulo, instructor);
            } else {
                cursoActual = new CursoAlimentacionSaludable(codigo, titulo, instructor);
            }

            areaSalida.append("✅ Curso creado: " + titulo + " (" + tipoCurso + ")\n");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al crear curso: " + ex.getMessage());
        }
    }

    private void agregarSesion() {
        if (cursoActual == null) {
            JOptionPane.showMessageDialog(this, "Cree un curso primero.");
            return;
        }
        String fecha = txtFechaSesion.getText().trim();
        String tema = txtTemaSesion.getText().trim();
        cursoActual.agregarSesion(fecha, tema);
        areaSalida.append("📅 Sesión agregada: " + tema + " (" + fecha + ")\n");
    }

    private void inscribirEstudiante() {
        if (cursoActual == null) {
            JOptionPane.showMessageDialog(this, "Primero debe crear un curso.");
            return;
        }
        String id = txtIdEst.getText().trim();
        String nombre = txtNombreEst.getText().trim();
        String correo = txtCorreoEst.getText().trim();

        Estudiante e = new Estudiante(id, nombre, correo);
        cursoActual.inscribir(e);
        estudiantes.add(e);
        listaEstudiantes.add(new String[]{id, nombre, correo});

        areaSalida.append("🧾 Estudiante inscrito: " + nombre + "\n");
    }

    private void agregarNotas() {
        for (Estudiante e : estudiantes) {
            String input = JOptionPane.showInputDialog("Ingrese nota final para " + e.getNombre());
            if (input != null) {
                try {
                    double nota = Double.parseDouble(input);
                    e.agregarNota(nota);
                    areaSalida.append("🧮 Nota registrada para " + e.getNombre() + ": " + nota + "\n");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Valor inválido.");
                }
            }
        }
    }

    private void marcarAsistencias() {
        for (Estudiante e : estudiantes) {
            int asistencias = JOptionPane.showConfirmDialog(this, "¿" + e.getNombre() + " asistió a todas las sesiones?", "Asistencia", JOptionPane.YES_NO_OPTION);
            if (asistencias == JOptionPane.YES_OPTION) {
                for (Inscripcion ins : cursoActual.getInscripciones()) {
                    if (ins.getEstudiante().equals(e)) ins.marcarAsistencia(true);
                }
                areaSalida.append("✅ Asistencia marcada para " + e.getNombre() + "\n");
            }
        }
    }

    private void generarReportes() {
        for (Estudiante e : estudiantes) {
            GeneradorPDF.generarFactura(e.getNombre(), e.getCorreo(), cursoActual.getTitulo(), true);
        }
        GeneradorPDF.generarConsolidadoEstudiantes(listaEstudiantes);
        GeneradorPDF.generarConsolidadoPagos(listaEstudiantes, listaPagos);
        areaSalida.append("📄 Reportes PDF generados correctamente.\n");
    }

    private void calcularFaltantes() {
        try {
            int total = Integer.parseInt(txtTotalEstudiantes.getText().trim());
            int asistieron = Integer.parseInt(txtAsistieron.getText().trim());
            if (asistieron > total) {
                JOptionPane.showMessageDialog(this, "Asistentes no puede ser mayor al total.");
                return;
            }
            int faltaron = total - asistieron;
            areaSalida.append("\n📋 Total: " + total + " | ✅ Asistieron: " + asistieron + " | ❌ Faltaron: " + faltaron + "\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}

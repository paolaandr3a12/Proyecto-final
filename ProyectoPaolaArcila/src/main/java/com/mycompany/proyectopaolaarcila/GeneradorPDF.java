package com.mycompany.proyectopaolaarcila;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GeneradorPDF {

    private static final String CARPETA = "Reportes";

    // Crea la carpeta si no existe
    private static void crearCarpeta() {
        File carpeta = new File(CARPETA);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }

    // 📄 Genera una factura PDF
    public static void generarFactura(String nombreEstudiante, String correo, String curso, boolean pago) {
        crearCarpeta();
        Document doc = new Document();
        try {
            String nombreArchivo = CARPETA + File.separator + "Factura_" + nombreEstudiante.replace(" ", "_") + ".pdf";
            PdfWriter.getInstance(doc, new FileOutputStream(nombreArchivo));
            doc.open();

            Font titulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font normal = FontFactory.getFont(FontFactory.HELVETICA, 12);

            doc.add(new Paragraph("FACTURA - TARJETA SPARK", titulo));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Estudiante: " + nombreEstudiante, normal));
            doc.add(new Paragraph("Correo: " + correo, normal));
            doc.add(new Paragraph("Curso: " + curso, normal));
            doc.add(new Paragraph("Estado del pago: " + (pago ? "✅ Pagado (Acceso Premium)" : "❌ No pagado (Acceso básico)"), normal));
            doc.add(new Paragraph("Valor: " + (pago ? "$50.000 COP" : "$0 COP"), normal));
            doc.add(new Paragraph("\nGracias por formar parte de Learnix 💡", normal));

            System.out.println("📄 Factura generada correctamente: " + nombreArchivo);
        } catch (DocumentException | IOException e) {
            System.out.println("⚠ Error generando factura: " + e.getMessage());
        } finally {
            doc.close();
        }
    }

    // 📘 Genera un consolidado de estudiantes
    public static void generarConsolidadoEstudiantes(ArrayList<String[]> estudiantes) {
        crearCarpeta();
        Document doc = new Document();
        try {
            String archivo = CARPETA + File.separator + "Consolidado_Estudiantes.pdf";
            PdfWriter.getInstance(doc, new FileOutputStream(archivo));
            doc.open();

            Font titulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font header = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            Font normal = FontFactory.getFont(FontFactory.HELVETICA, 11);

            doc.add(new Paragraph("CONSOLIDADO DE ESTUDIANTES", titulo));
            doc.add(new Paragraph(" "));

            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell(new PdfPCell(new Paragraph("ID", header)));
            tabla.addCell(new PdfPCell(new Paragraph("Nombre", header)));
            tabla.addCell(new PdfPCell(new Paragraph("Correo", header)));

            for (String[] datos : estudiantes) {
                tabla.addCell(new Paragraph(datos[0], normal));
                tabla.addCell(new Paragraph(datos[1], normal));
                tabla.addCell(new Paragraph(datos[2], normal));
            }

            doc.add(tabla);
            System.out.println("📘 Consolidado de estudiantes generado: " + archivo);
        } catch (DocumentException | IOException e) {
            System.out.println("⚠ Error generando consolidado: " + e.getMessage());
        } finally {
            doc.close();
        }
    }

    // 💰 Genera consolidado de pagos
    public static void generarConsolidadoPagos(ArrayList<String[]> estudiantes, ArrayList<Boolean> pagos) {
        crearCarpeta();
        Document doc = new Document();
        try {
            String archivo = CARPETA + File.separator + "Consolidado_Pagos.pdf";
            PdfWriter.getInstance(doc, new FileOutputStream(archivo));
            doc.open();

            Font titulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font header = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            Font normal = FontFactory.getFont(FontFactory.HELVETICA, 11);

            doc.add(new Paragraph("CONSOLIDADO DE PAGOS - TARJETA SPARK", titulo));
            doc.add(new Paragraph(" "));

            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell(new PdfPCell(new Paragraph("Nombre", header)));
            tabla.addCell(new PdfPCell(new Paragraph("Correo", header)));
            tabla.addCell(new PdfPCell(new Paragraph("Estado de Pago", header)));

            int totalPagados = 0;
            for (int i = 0; i < estudiantes.size(); i++) {
                String[] e = estudiantes.get(i);
                boolean pago = pagos.get(i);

                tabla.addCell(new Paragraph(e[1], normal));
                tabla.addCell(new Paragraph(e[2], normal));
                tabla.addCell(new Paragraph(pago ? "Pagado" : "No pagado", normal));

                if (pago) totalPagados++;
            }

            doc.add(tabla);
            doc.add(new Paragraph("\nTotal de estudiantes que pagaron: " + totalPagados, normal));
            doc.add(new Paragraph("Total sin pago: " + (estudiantes.size() - totalPagados), normal));

            System.out.println("💰 Consolidado de pagos generado: " + archivo);
        } catch (DocumentException | IOException e) {
            System.out.println("⚠ Error generando consolidado de pagos: " + e.getMessage());
        } finally {
            doc.close();
        }
        
    }

    static void generarResumenAsistencia(int total, int asistieron, int faltaron) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
package util;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;

public class ExportarPDF {

    String Separador = "________________________________________________________________";
    String ruta = System.getProperty("user.home");

    public void generarPDF(String clinica, String Hora, String Codigo, String Nombre, String DNI) {
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/Desktop/ReporteTicket" + Nombre + ".pdf"));
            doc.open();

            String b = "src/imagenes/ga.png";

            Image foto = Image.getInstance(b);
            foto.scaleToFit(200, 200);
            foto.setAlignment(Chunk.ALIGN_LEFT);
            doc.add(foto);

            doc.add(Chunk.NEWLINE);
            String titulo = "COVID";
            doc.add(new Paragraph(titulo));

            PdfPTable tabla = new PdfPTable(3);
            Chunk chkSeparator = new Chunk(Separador);
            doc.add(chkSeparator);
            doc.add(Chunk.NEWLINE);
            tabla.addCell("Clínica");
            tabla.addCell("Hora de registro");
            tabla.addCell("Código");

            PdfPTable tabla2 = new PdfPTable(2);

            try {
                tabla.addCell(clinica);
                tabla.addCell(Hora);
                tabla.addCell(Codigo);
                doc.add(tabla);

            } catch (Exception ex) {
                System.out.println(ex);
            }
            doc.add(Chunk.NEWLINE);
            String paciente = "PACIENTE";

            doc.add(new Paragraph(paciente));
            doc.add(Chunk.NEWLINE);
            tabla2.addCell("Nombre");
            tabla2.addCell("DNI");
            try {
                tabla2.addCell(Nombre);
                tabla2.addCell(DNI);
                doc.add(tabla2);
            } catch (Exception ex) {
                System.out.println(ex);
            }

            doc.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void generarInforme(String nombre, int edad, String sexo, String codigo, String correo, String Tipo,
            String Numero, String Direccion, String Celular, String fecha) {
        Document doc2 = new Document();
        try {
            PdfWriter.getInstance(doc2, new FileOutputStream(ruta + "/Desktop/ReporteTicket" + nombre + ".pdf"));
            doc2.open();

            String c = "src/imagenes/ga.png";

            Image foto = Image.getInstance(c);
            foto.scaleToFit(200, 200);
            foto.setAlignment(Chunk.ALIGN_LEFT);
            doc2.add(foto);

            doc2.add(Chunk.NEWLINE);
            String titulo = "REPORTE DEL PACIENTE";
            doc2.add(new Paragraph(titulo));

            PdfPTable tabla2 = new PdfPTable(4);
            Chunk chkSeparator = new Chunk(Separador);
            doc2.add(chkSeparator);
            doc2.add(Chunk.NEWLINE);
            tabla2.addCell("Código");
            tabla2.addCell("Paciente");
            tabla2.addCell("Tipo");
            tabla2.addCell("Número");

            try {
                tabla2.addCell(codigo);
                tabla2.addCell(nombre);
                tabla2.addCell(Tipo);
                tabla2.addCell(Numero);

                doc2.add(tabla2);
                doc2.add(Chunk.NEWLINE);

                PdfPTable tabla3 = new PdfPTable(5);
                tabla3.addCell("Sexo");
                tabla3.addCell("Correo");
                tabla3.addCell("Edad");
                tabla3.addCell("Dirección");
                tabla3.addCell("Celular");

                try {
                    tabla3.addCell(sexo);
                    tabla3.addCell(correo);
                    tabla3.addCell(String.valueOf(edad));
                    tabla3.addCell(Direccion);
                    tabla3.addCell(Celular);

                    doc2.add(tabla3);
                } catch (Exception ex) {

                }

                doc2.add(new Paragraph(fecha));
            } catch (Exception ex) {
                System.out.println(ex);
            }

            doc2.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

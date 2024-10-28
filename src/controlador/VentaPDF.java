package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import vista.InterFacturacion;

public class VentaPDF {

    private String nombreCliente;
    private String dniCliente;
    private String telefonoCliente;
    private String direccionCliente;
    private String fechaActual = "";
    private String nombreArchivoPDFVenta = "";

    //metodo para obtener datos del cliente
    public void DatosCliente(int idCliente) {
        Connection cn = Conexion.conectar();
        String sql = "SELECT * FROM tb_Cliente WHERE idCliente = ?";
        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, idCliente);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                nombreCliente = rs.getString("nombre") + " " + rs.getString("apellido");
                dniCliente = rs.getString("DNI");
                telefonoCliente = rs.getString("telefono");
                direccionCliente = rs.getString("direccion");
            }
            rs.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente: " + e);
        }
    }

    //metodo para generar la factura de venta
    public void generarFacturaPDF() {

        try {

            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);

            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }

            nombreArchivoPDFVenta = "Venta_" + nombreCliente + "_" + fechaNueva + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image img = Image.getInstance("src/img/logoNaranja.jpeg");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.ORANGE);
            fecha.add(Chunk.NEWLINE);
            fecha.add("Factura: 001" + "\nFecha: " + fechaActual + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);

            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

            Encabezado.addCell(img);

            String ruc = "0987654321001";
            String nombre = "Naranja Mecánica";
            String telefono = "987654321";
            String direccion = "Marcona";
            String razon = "¡Disfruta de nuestro gran ambiente!";

            Encabezado.addCell(""); // Celda vacía
            Encabezado.addCell("RUC: " + ruc + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razon);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            // CUERPO
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE); // Nueva línea
            cliente.add("Datos del cliente: " + "\n\n");
            doc.add(cliente);

            // DATOS DEL CLIENTE
            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0); // Quitar bordes

            // Tamaño de las celdas
            float[] ColumnaCliente = new float[]{25f, 45f, 30f, 40f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("DNI/RUC: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Telefono: ", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Direccion: ", negrita));

            // Quitar bordes
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);

            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);
            tablaCliente.addCell(dniCliente);
            tablaCliente.addCell(nombreCliente);
            tablaCliente.addCell(telefonoCliente);
            tablaCliente.addCell(direccionCliente);
            doc.add(tablaCliente);

            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            PdfPTable tablaProducto = new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);

//tamaño de celdas
            // Configuración de anchos de las columnas para la tabla de productos
            float[] ColumnaProducto = new float[]{2f, 6f, 3f, 3f}; // Ajusta los valores según tus necesidades
            tablaProducto.setWidths(ColumnaProducto);

// Encabezados de la tabla
            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Descripción: ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio Unitario: ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio Total: ", negrita));

// Configuración de celdas de encabezado
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            

// Alineación de encabezados
            producto1.setHorizontalAlignment(Element.ALIGN_CENTER);
            producto2.setHorizontalAlignment(Element.ALIGN_CENTER);
            producto3.setHorizontalAlignment(Element.ALIGN_CENTER);
            producto4.setHorizontalAlignment(Element.ALIGN_CENTER);

// Agregar encabezados a la tabla
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);

// Variables para calcular el total y el descuento general
            float totalGeneral = 0;
            float totalDescuento = 0;

// Iterar sobre los productos para agregarlos a la tabla
            for (int i = 0; i < InterFacturacion.jTable_productos.getRowCount(); i++) {
                String producto = InterFacturacion.jTable_productos.getValueAt(i, 1).toString();
                String cantidadStr = InterFacturacion.jTable_productos.getValueAt(i, 2).toString();
                String precioStr = InterFacturacion.jTable_productos.getValueAt(i, 3).toString();

                int cantidad = Integer.parseInt(cantidadStr);
                float precio = Float.parseFloat(precioStr);
                float total = cantidad * precio;

                // Calcular el descuento por producto
                float descuentoPorProducto = total * (InterFacturacion.porcentajeDescuento / 100.0f);

                // Acumular el total y el descuento
                totalGeneral += total;
                totalDescuento += descuentoPorProducto;

                // Crear celdas para cada dato
                PdfPCell cantidadCell = new PdfPCell(new Phrase(cantidadStr));
                PdfPCell descripcionCell = new PdfPCell(new Phrase(producto));
                PdfPCell precioUnitarioCell = new PdfPCell(new Phrase(precioStr));
                PdfPCell precioTotalCell = new PdfPCell(new Phrase(String.valueOf(total)));

                cantidadCell.setBorder(0);
                descripcionCell.setBorder(0);
                precioUnitarioCell.setBorder(0);
                precioTotalCell.setBorder(0);

                // Alineación de celdas de datos
                cantidadCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                descripcionCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                precioUnitarioCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                precioTotalCell.setHorizontalAlignment(Element.ALIGN_CENTER);

                // Agregar celdas de datos a la tabla
                tablaProducto.addCell(cantidadCell);
                tablaProducto.addCell(descripcionCell);
                tablaProducto.addCell(precioUnitarioCell);
                tablaProducto.addCell(precioTotalCell);
            }

// Agregar tabla de productos al documento
            doc.add(tablaProducto);

// Crear una nueva tabla para el resumen de descuentos y total final
            PdfPTable tablaResumen = new PdfPTable(2);
            tablaResumen.setWidthPercentage(50);
            tablaResumen.setHorizontalAlignment(Element.ALIGN_CENTER);

// Encabezados para la tabla de resumen
            PdfPCell resumen1 = new PdfPCell(new Phrase("Descuento Total: ", negrita));
            PdfPCell resumen2 = new PdfPCell(new Phrase("Total con Descuento: ", negrita));

// Alineación y configuración de celdas de resumen
            resumen1.setBorder(0);
            resumen2.setBorder(0);
           
            resumen1.setHorizontalAlignment(Element.ALIGN_LEFT);
            resumen2.setHorizontalAlignment(Element.ALIGN_LEFT);

// Agregar encabezados a la tabla de resumen
            tablaResumen.addCell(resumen1);
            tablaResumen.addCell(resumen2);

// Crear celdas para los valores del descuento y total con descuento
            PdfPCell descuentoTotalCell = new PdfPCell(new Phrase(String.valueOf(totalDescuento)));
            PdfPCell totalConDescuentoCell = new PdfPCell(new Phrase(String.valueOf(totalGeneral - totalDescuento)));

// Alineación de celdas de valores de resumen
            descuentoTotalCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            totalConDescuentoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            descuentoTotalCell.setBorder(0);
            totalConDescuentoCell.setBorder(0);

// Agregar celdas de valores a la tabla de resumen
            tablaResumen.addCell(descuentoTotalCell);
            tablaResumen.addCell(totalConDescuentoCell);

// Agregar tabla de resumen al documento
            doc.add(new Paragraph("\n")); // Salto de línea
            doc.add(tablaResumen);

// Total a pagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: " + InterFacturacion.txt_total_pagar.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

// Firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion y firma\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

// Mensaje
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡Gracias por su compra!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

// Cerrar el documento y el archivo
            doc.close();
            archivo.close();

// Abrir el documento al ser generado automáticamente
            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }

    }
}

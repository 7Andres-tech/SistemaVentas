package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Ventas;
import modelo.DetalleVenta;

public class Ctrl_RegistrarVenta {

    public static int idVentaRegistrada;
    java.math.BigDecimal iDColVar;

    public boolean guardar(Ventas objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_Ventas (idVentas, idCliente, valorPagar, fechaVenta, estado)  values(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, 0);//id
            consulta.setInt(2, objeto.getIdCliente());
            consulta.setDouble(3, objeto.getValorPagar());
            consulta.setString(4, objeto.getFechaVenta());
            consulta.setInt(5, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            ResultSet rs = consulta.getGeneratedKeys();
            while (rs.next()) {
                iDColVar = rs.getBigDecimal(1);
                idVentaRegistrada = iDColVar.intValue();
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar venta: " + e);
        }
        return respuesta;
    }

    public boolean guardarDetalle(DetalleVenta objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_detalleventa (idVenta, idProducto, cantidad, precioUnitario, subtotal, descuento, totalPagar, estado) values (?, ?, ?, ?, ?, ?, ?, ?)");
            consulta.setInt(1, idVentaRegistrada);
            consulta.setInt(2, objeto.getIdProducto());
            consulta.setInt(3, objeto.getCantidad());
            consulta.setDouble(4, objeto.getPrecioUnitario());
            consulta.setDouble(5, objeto.getSubTotal());
            consulta.setDouble(6, objeto.getDescuento());
            consulta.setDouble(7, objeto.getTotalPagar());
            consulta.setInt(8, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
                System.out.println("Inserción exitosa en tb_detalleventa.");
            } else {
                System.out.println("No se insertó ninguna fila en tb_detalleventa.");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar detalle de venta: " + e);
        }

        return respuesta;
    }

    public boolean actualizar(Ventas objeto, int idVentas) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "update tb_Ventas set idCliente = ?, estado = ? "
                    + "where idVentas ='" + idVentas + "'");
            consulta.setInt(1, objeto.getIdCliente());
            consulta.setInt(2, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar venta: " + e);
        }
        return respuesta;
    }
}

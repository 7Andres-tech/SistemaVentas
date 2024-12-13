package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;

public class Ctrl_Cliente {

    public boolean guardar(Cliente objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "INSERT INTO tb_cliente (nombre, apellido, dni, telefono, direccion, estado) VALUES (?, ?, ?, ?, ?, ?)"
            );
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setInt(3, objeto.getDni());
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setInt(6, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e);
        }
        return respuesta;
    }

    /**
     * ********************************************************************
     * metodo para consultar si el producto ya esta registrado en la BBDD
     * ********************************************************************
     */
    public boolean existeCliente(int dni) {
        boolean existe = false;
        Connection cn = Conexion.conectar();
        try {
            String sql = "SELECT COUNT(*) FROM tb_Cliente WHERE DNI = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setInt(1, dni); // Ajuste para pasar un int
            ResultSet rs = consulta.executeQuery();
            if (rs.next()) {
                existe = rs.getInt(1) > 0; // Si el conteo es mayor a 0, existe
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al verificar si el cliente existe: " + e);
        }
        return existe;
    }

    /**
     * **************************************************
     * metodo para actualizar un cliente
     * **************************************************
     */
    public boolean actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_cliente set nombre=?, apellido = ?, DNI = ?, telefono= ?, direccion = ?, estado = ? where idCliente ='" + idCliente + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setInt(3, objeto.getDni());
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setInt(6, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para eliminar un cliente
     * **************************************************
     */
    public boolean eliminar(int idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_cliente where idCliente ='" + idCliente + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e);
        }
        return respuesta;
    }

}

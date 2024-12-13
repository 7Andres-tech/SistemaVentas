package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Mozo;

public class Ctrl_Mozo {

    /**
     * **************************************************
     * metodo para guardar un nuevo mozo
     * **************************************************
     */
    public boolean guardar(Mozo objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            // Consulta ajustada (asumiendo que 'id' es AUTO_INCREMENT)
            PreparedStatement consulta = cn.prepareStatement(
                    "INSERT INTO tb_Mozo (nombre, direccion, correo, password, telefono, DNI) VALUES (?, ?, ?, ?, ?, ?)"
            );
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getDireccion());
            consulta.setString(3, objeto.getCorreo());
            consulta.setString(4, objeto.getPassword());
            consulta.setString(5, objeto.getTelefono());
            consulta.setInt(6, objeto.getDni());

            // Ejecutar consulta
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar mozo: " + e.getMessage());
            e.printStackTrace(); // Esto mostrará la traza completa del error en la consola
        }
        return respuesta;
    }

    /**
     * ********************************************************************
     * metodo para consultar si el producto ya esta registrado en la BBDD
     * ********************************************************************
     */
    public boolean existeMozo(String correo) {
        boolean respuesta = false;
        String sql = "SELECT correo FROM tb_Mozo WHERE correo = ?;"; // Cambia 'mozo' a 'correo'

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, correo); // Establece el valor del placeholder
            try (ResultSet rs = pst.executeQuery()) {
                respuesta = rs.next(); // Si hay un resultado, 'respuesta' será true
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para Iniciar Sesion
     * **************************************************
     */
    public boolean loginMozo(Mozo objeto) {
        boolean respuesta = false;
        String sql = "SELECT * FROM tb_Mozo WHERE correo = ? AND password = ?"; // Usamos placeholders

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) { // Usa PreparedStatement
            pst.setString(1, objeto.getCorreo()); // Establece el valor del placeholder para 'correo'
            pst.setString(2, objeto.getPassword()); // Establece el valor del placeholder para 'password'

            try (ResultSet rs = pst.executeQuery()) { // Cierra automáticamente el ResultSet
                respuesta = rs.next(); // Si hay un resultado, 'respuesta' será true
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para actualizar un usuario
     * **************************************************
     */
    public boolean actualizar(Mozo objeto, int idMozo) {
        boolean respuesta = false;
        String sql = "UPDATE tb_Mozo SET nombre = ?, direccion = ?, correo = ?, password = ?, telefono = ?, dni = ? WHERE idMozo = ?"; // Asegúrate de que el nombre de la columna y la tabla son correctos.

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) { // Usa PreparedStatement

            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getDireccion());
            consulta.setString(3, objeto.getCorreo());
            consulta.setString(4, objeto.getPassword());
            consulta.setString(5, objeto.getTelefono());
            consulta.setInt(6, objeto.getDni());
            consulta.setInt(7, idMozo); // Establece el valor para el id del mozo a actualizar

            if (consulta.executeUpdate() > 0) {
                respuesta = true; // Si se actualizó al menos un registro, la respuesta es true
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar mozo: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para eliminar un usuario
     * **************************************************
     */
    public boolean eliminar(int idMozo) {
        boolean respuesta = false;
        String sql = "DELETE FROM tb_Mozo WHERE idMozo = ?"; // Asegúrate de que el nombre de la columna y la tabla son correctos.

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) { // Usa PreparedStatement

            consulta.setInt(1, idMozo); // Establece el valor para el id del mozo a eliminar

            if (consulta.executeUpdate() > 0) {
                respuesta = true; // Si se eliminó al menos un registro, la respuesta es true
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar mozo: " + e);
        }
        return respuesta;
    }

}

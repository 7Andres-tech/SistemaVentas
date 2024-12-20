package vista;

import conexion.Conexion;
import controlador.Ctrl_Cliente;
import controlador.Ctrl_Mozo;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Mozo;


public class InterGestionarMozo extends javax.swing.JInternalFrame {

    private int idMozo = 0;

    public InterGestionarMozo() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Mozos");
        //Cargar tablaMozos();
        this.CargarTablaMozos();

        //insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("src/img/FONDONARANJA.jpeg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_mozos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_dni = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Administrar Mozos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_mozos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_mozos);
        if (jTable_mozos.getColumnModel().getColumnCount() > 0) {
            jTable_mozos.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            jTable_mozos.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            jTable_mozos.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            jTable_mozos.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(0, 153, 204));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton_eliminar.setBackground(new java.awt.Color(0, 153, 204));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 270));

        jPanel3.setBackground(new java.awt.Color(255, 153, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Password:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Direccion:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Telefono:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Correo:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, -1));

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        txt_direccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        txt_correo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 170, -1));
        jPanel3.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("DNI:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));

        jLabel_wallpaper.setBackground(new java.awt.Color(255, 153, 51));
        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FONDONARANJA.jpeg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        Mozo mozo = new Mozo();
        Ctrl_Mozo controlMozo = new Ctrl_Mozo();

        if (idMozo == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un Usuario!");
        } else {
            if (txt_nombre.getText().isEmpty() || txt_direccion.getText().isEmpty() || txt_correo.getText().isEmpty()
                    || txt_password.getText().isEmpty() || txt_telefono.getText().isEmpty() || txt_dni.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Completa todos los campos!");

            } else {
                mozo.setNombre(txt_nombre.getText().trim());
                mozo.setDireccion(txt_direccion.getText().trim());
                mozo.setCorreo(txt_correo.getText().trim());
                mozo.setPassword(txt_password.getText().trim());
                mozo.setTelefono(txt_telefono.getText().trim());
                // Convertir el DNI a entero, ya que es de tipo int
                try {
                    int dni = Integer.parseInt(txt_dni.getText().trim());
                    mozo.setDni(dni); // Establecer el DNI en el objeto mozo
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "DNI debe ser un número");
                    return; // Salir si el DNI no es un número válido
                }

                if (controlMozo.actualizar(mozo, idMozo)) { // Cambié usuario por mozo y idUsuario por idMozo
                    JOptionPane.showMessageDialog(null, "¡Actualización Exitosa!");
                    this.Limpiar();
                    this.CargarTablaMozos(); // Cambié la referencia a cargar la tabla de mozos
                    idMozo = 0;
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al Actualizar Mozo!");
                }

            }
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

        Ctrl_Mozo controlUsuario = new Ctrl_Mozo();
        if (idMozo == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un Mozo!");
        } else {
            if (!controlUsuario.eliminar(idMozo)) {
                JOptionPane.showMessageDialog(null, "¡Mozo Eliminado!");
                this.CargarTablaMozos();
                this.Limpiar();
                idMozo = 0;
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar mozo!");
                this.Limpiar();
            }
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_mozos;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

    /*
     * *****************************************************
     * metodo para limpiar
     * *****************************************************
     */
    private void Limpiar() {
        txt_nombre.setText("");
        txt_password.setText("");
        txt_direccion.setText("");
        txt_telefono.setText("");
        txt_correo.setText("");
        txt_dni.setText("");
    }


    /*
     * *****************************************************
     * metodo para mostrar todos los clientes registrados
     * *****************************************************
     */
    private void CargarTablaMozos() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select * from tb_Mozo";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarMozo.jTable_mozos = new JTable(model);
            InterGestionarMozo.jScrollPane1.setViewportView(InterGestionarMozo.jTable_mozos);

            model.addColumn("N°");//ID
            model.addColumn("nombre");
            model.addColumn("direccion");
            model.addColumn("correo");
            model.addColumn("password");
            model.addColumn("telefono");
            model.addColumn("dni");

            while (rs.next()) {
                Object fila[] = new Object[7];
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla Mozo: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        jTable_mozos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_mozos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idMozo = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosMozoSeleccionado(idMozo);//metodo
                }
            }
        });
    }


    /*
     * **************************************************
     * Metodo que envia datos seleccionados
     * **************************************************
     */
    private void EnviarDatosMozoSeleccionado(int idMozo) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_Mozo where idMozo = '" + idMozo + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_nombre.setText(rs.getString("nombre"));
                txt_direccion.setText(rs.getString("direccion"));
                txt_correo.setText(rs.getString("correo"));
                txt_password.setText(rs.getString("password"));
                txt_telefono.setText(rs.getString("telefono"));
                txt_dni.setText(rs.getString("DNI"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar Mozo: " + e);
        }
    }

}

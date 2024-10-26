/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Alumno;
import models.AlumnoDAO;
import models.Usuario;
import models.UsuarioDAO;

/**
 *
 * @author Asus
 */
public class ListU extends javax.swing.JFrame {

    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    private int idSeleccionado;

    public ListU() {
        initComponents();
        mostrarUsuariosEnTabla();

    }

    public void LimpiarTabla() {
//    modelo.setRowCount(0);
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void mostrarUsuariosEnTabla() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        DefaultTableModel model = (DefaultTableModel) tablaU.getModel();

        // Limpiar las filas existentes en la tabla
        model.setRowCount(0);

        try {
            // Obtener la lista de usuarios
            List<Usuario> usuarios = usuarioDAO.obtenerTodosLosUsuarios();

            // Recorrer la lista de usuarios y añadirlos a la tabla
            for (Usuario usuario : usuarios) {
                Object[] fila = {
                    usuario.getId(),
                    usuario.getNombreUsuario(),
                    usuario.getContrasenia(), // Si deseas mostrar la contraseña
                    usuario.getRol(),
                    usuario.getAlumnoId() != null ? usuario.getAlumnoId() : "N/A"
                };
                model.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaU = new javax.swing.JTable();
        ualum = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        uadmin = new javax.swing.JButton();
        regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuario", "Contraseña", "rol", "alumno_id"
            }
        ));
        jScrollPane1.setViewportView(tablaU);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 700, 190));

        ualum.setBackground(new java.awt.Color(0, 0, 0));
        ualum.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        ualum.setForeground(new java.awt.Color(255, 255, 255));
        ualum.setText("Nuevo Usuario Alumno");
        ualum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ualumActionPerformed(evt);
            }
        });
        jPanel1.add(ualum, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        eliminar.setBackground(new java.awt.Color(0, 0, 0));
        eliminar.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        editar.setBackground(new java.awt.Color(0, 0, 0));
        editar.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        editar.setForeground(new java.awt.Color(255, 255, 255));
        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        jPanel1.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista Usuarios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 180, -1));

        uadmin.setBackground(new java.awt.Color(0, 0, 0));
        uadmin.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        uadmin.setForeground(new java.awt.Color(255, 255, 255));
        uadmin.setText("Nuevo Usuario Admin");
        uadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uadminActionPerformed(evt);
            }
        });
        jPanel1.add(uadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 270, -1));

        regresar.setBackground(new java.awt.Color(0, 0, 0));
        regresar.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        regresar.setForeground(new java.awt.Color(255, 255, 255));
        regresar.setText("←");
        regresar.setBorder(null);
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        jPanel1.add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 6, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ualumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ualumActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        AsgUA listaCursos = new AsgUA();
        listaCursos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaCursos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ualumActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        Inicio inicio = new Inicio();
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
       // Obtener la fila seleccionada
    int filaSeleccionada = tablaU.getSelectedRow();

    if (filaSeleccionada == -1) {
        // Si no hay fila seleccionada, mostrar un mensaje de advertencia
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Obtener el ID del usuario seleccionado
    int idUsuario = (int) tablaU.getValueAt(filaSeleccionada, 0); // Asumiendo que el ID está en la primera columna

    // Verificar si el usuario a eliminar es un admin
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    try {
        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(idUsuario);
        
        if (usuario.getRol().equals("admin")) {
            // Contar el número de admins
            int conteoAdmins = usuarioDAO.contarAdmins();
            if (conteoAdmins <= 1) {
                // Si solo hay un admin, no permitir la eliminación
                JOptionPane.showMessageDialog(this, "No se puede eliminar al último usuario con rol de admin.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        // Confirmación antes de eliminar
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Llamar al método eliminarUsuario del DAO
            if (usuarioDAO.eliminarUsuario(idUsuario)) {
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
                mostrarUsuariosEnTabla(); // Actualizar la tabla después de eliminar
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_eliminarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:
  
        
        int selectedRow = tablaU.getSelectedRow();
    
    // Verifica que una fila esté seleccionada
    if (selectedRow != -1) {
        int userId = (int) tablaU.getValueAt(selectedRow, 0); // Asume que la columna 0 tiene el ID

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.obtenerUsuarioPorId(userId);

            if (usuario != null) {
                // Crea una instancia de EditarUser y pasa los datos del usuario
                EditarUser editarUserFrame = new EditarUser();
                editarUserFrame.setUsuario(usuario);  // Método para pasar el usuario a EditarUser
                editarUserFrame.setVisible(true);
                this.dispose(); // Cierra la ventana actual si es necesario
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener los datos del usuario: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario de la tabla.");
    }

        
    }//GEN-LAST:event_editarActionPerformed

    private void uadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uadminActionPerformed
        // TODO add your handling code here:
        
                // TODO add your handling code here:
        Adminuser listaCursos = new Adminuser();
        listaCursos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaCursos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_uadminActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresar;
    private javax.swing.JTable tablaU;
    private javax.swing.JButton uadmin;
    private javax.swing.JButton ualum;
    // End of variables declaration//GEN-END:variables
}

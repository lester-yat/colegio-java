/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.Seguridad;
import models.Usuario;
import models.UsuarioDAO;

/**
 *
 * @author Asus
 */
public class EditarUser extends javax.swing.JFrame {

private Usuario usuario; 

    public EditarUser() {
        initComponents();
    
    }

  public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        user.setText(usuario.getNombreUsuario());
  } 
        
   


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        cancelar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 139, 106, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 225, 121, -1));

        user.setBackground(new java.awt.Color(0, 0, 0));
        user.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setBorder(null);
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 139, 234, -1));

        pass.setBackground(new java.awt.Color(0, 0, 0));
        pass.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setBorder(null);
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 239, 234, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 174, 234, 10));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 274, 234, 10));

        cancelar.setBackground(new java.awt.Color(0, 0, 0));
        cancelar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 351, -1, -1));

        guardar.setBackground(new java.awt.Color(0, 0, 0));
        guardar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 351, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Editar Usuario");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 17, 270, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        
        dispose();
        ListU vistaLista = new ListU();
        vistaLista.setVisible(true);
      
    }//GEN-LAST:event_cancelarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        

               // Obtiene los datos de los campos de texto
    String nombreUsuario = user.getText().trim();
    String contrasenia = pass.getText().trim();
    
    // Verifica que los campos no estén vacíos
    if (nombreUsuario.isEmpty() || contrasenia.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
        return; // Salir del método si hay campos vacíos
    }

    // Asigna los datos al objeto Usuario
    usuario.setNombreUsuario(nombreUsuario);
    usuario.setContrasenia(Seguridad.encriptarSHA256(contrasenia)); // Encriptar la contraseña antes de guardarla

    // Crea una instancia de UsuarioDAO para actualizar el usuario
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    try {
        // Actualiza el usuario en la base de datos
        boolean actualizado = usuarioDAO.actualizarUsuario(usuario);
        if (actualizado) {
            JOptionPane.showMessageDialog(this, "Usuario actualizado con éxito.");

            // Aquí debes abrir la vista ListU y cerrar la ventana actual
            ListU listUFrame = new ListU(); // Asegúrate de que ListU tenga un constructor sin parámetros
            listUFrame.setVisible(true);
            this.dispose(); // Cierra la ventana de edición
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar el usuario. Por favor, inténtelo de nuevo.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar los datos del usuario: " + e.getMessage());
    }
    }//GEN-LAST:event_guardarActionPerformed

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
            java.util.logging.Logger.getLogger(EditarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}

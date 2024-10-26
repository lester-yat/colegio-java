package views;

import java.util.List;
import javax.swing.JOptionPane;
import models.Nota;
import models.NotaDAO;
import models.Usuario;
import models.UsuarioDAO;

public class Login extends javax.swing.JFrame {

    public Login() {    
        
        initComponents();
        this.setLocationRelativeTo(null);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        inicio = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 139, 45));

        txtusuario.setBackground(new java.awt.Color(0, 0, 0));
        txtusuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(255, 255, 255));
        txtusuario.setBorder(null);
        txtusuario.setMargin(new java.awt.Insets(0, 0, 2, 0));
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 171, 280, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 223, -1));

        pass.setBackground(new java.awt.Color(0, 0, 0));
        pass.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setBorder(null);
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 290, 40));

        inicio.setBackground(new java.awt.Color(0, 0, 0));
        inicio.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        inicio.setForeground(new java.awt.Color(255, 255, 255));
        inicio.setText("Iniciar");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        jPanel1.add(inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 275, 45));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 380, 450));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 270, 20));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 270, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        
        
        String usuario = txtusuario.getText();
String contraseña = new String(pass.getPassword());

UsuarioDAO usuarioDAO = new UsuarioDAO();

// Validar si el usuario y la contraseña son correctos
if (usuarioDAO.validarUsuario(usuario, contraseña)) {
    // Obtener el objeto Usuario después de la validación exitosa
    Usuario usuarioLogeado = usuarioDAO.obtenerUsuarioPorNombre(usuario);
    
    if (usuarioLogeado != null) {
        String rol = usuarioLogeado.getRol();
        
        // Abrir la vista correspondiente según el rol del usuario
        if ("admin".equals(rol)) {
            Inicio inicioAdmin = new Inicio();
            inicioAdmin.setVisible(true); // Mostrar la vista de admin
            this.dispose(); // Cerrar la ventana de login
        } else if ("alumno".equals(rol)) {
            Integer alumnoId = usuarioLogeado.getAlumnoId();
            if (alumnoId != null) {
                ViewStudents viewStudents = new ViewStudents(alumnoId); // Pasar el alumnoId
                viewStudents.setVisible(true); // Mostrar la ventana con las notas del alumno
                this.dispose(); // Cerrar la ventana de login
            } else {
                JOptionPane.showMessageDialog(this, "Este alumno fue eliminado y ya no tiene acceso.");
            }
        } else if ("profesor".equals(rol)) {
            // Implementación para el rol profesor
            this.dispose(); // Cerrar la ventana de login
        } else {
            JOptionPane.showMessageDialog(this, "Rol desconocido");
            this.dispose(); // Cerrar la ventana de login
        }
    } else {
        JOptionPane.showMessageDialog(this, "Error al obtener los datos del usuario");
    }
} else {    
    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
}

       
        
    }//GEN-LAST:event_inicioActionPerformed
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}

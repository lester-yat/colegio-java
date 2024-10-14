package views;

import javax.swing.JOptionPane;
import models.UsuarioDAO;

public class Login extends javax.swing.JFrame {

    public Login() {    
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        inicio = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 139, 45));

        txtusuario.setBackground(new java.awt.Color(255, 255, 255));
        txtusuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(0, 0, 0));
        txtusuario.setBorder(null);
        txtusuario.setMargin(new java.awt.Insets(0, 0, 2, 0));
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 171, 275, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 223, -1));

        pass.setBackground(new java.awt.Color(255, 255, 255));
        pass.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pass.setForeground(new java.awt.Color(0, 0, 0));
        pass.setBorder(null);
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 275, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 60, 30));

        inicio.setBackground(new java.awt.Color(255, 255, 255));
        inicio.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        inicio.setForeground(new java.awt.Color(0, 0, 0));
        inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        inicio.setText("Iniciar");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        getContentPane().add(inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 275, 45));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 380, 450));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/69.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        String usuario = txtusuario.getText();
        String contraseña = new String(pass.getPassword());

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if (usuarioDAO.validarUsuario(usuario, contraseña)) {
            Inicio inicio = new Inicio();
            inicio.setVisible(true);
            
            this.dispose();
        } else {    
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
    }//GEN-LAST:event_inicioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}

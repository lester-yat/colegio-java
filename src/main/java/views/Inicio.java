package views;

import javax.swing.JFrame;

public class Inicio extends javax.swing.JFrame {
    
    public Inicio() {
       
        initComponents();
            this.setLocationRelativeTo(null);
             

           

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGrados = new javax.swing.JButton();
        btnAlumnos = new javax.swing.JButton();
        btnProfesores = new javax.swing.JButton();
        btnSecciones = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnPagos = new javax.swing.JButton();
        btnPadres = new javax.swing.JButton();
        btnInscripcion = new javax.swing.JButton();
        btnNotas = new javax.swing.JButton();
        btnCursos = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGrados.setBackground(new java.awt.Color(0, 0, 0));
        btnGrados.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnGrados.setForeground(new java.awt.Color(255, 255, 255));
        btnGrados.setText("Grados");
        btnGrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGradosActionPerformed(evt);
            }
        });
        jPanel1.add(btnGrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 200, 50));

        btnAlumnos.setBackground(new java.awt.Color(0, 0, 0));
        btnAlumnos.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btnAlumnos.setText("Alumnos");
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 200, 50));

        btnProfesores.setBackground(new java.awt.Color(0, 0, 0));
        btnProfesores.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnProfesores.setForeground(new java.awt.Color(255, 255, 255));
        btnProfesores.setText("Profesores");
        btnProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfesoresActionPerformed(evt);
            }
        });
        jPanel1.add(btnProfesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 200, 50));

        btnSecciones.setBackground(new java.awt.Color(0, 0, 0));
        btnSecciones.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSecciones.setForeground(new java.awt.Color(255, 255, 255));
        btnSecciones.setText("Secciones");
        btnSecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeccionesActionPerformed(evt);
            }
        });
        jPanel1.add(btnSecciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 200, 50));

        jLabel3.setBackground(new java.awt.Color(153, 0, 153));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("INICIO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 140, 60));

        btnPagos.setBackground(new java.awt.Color(0, 0, 0));
        btnPagos.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnPagos.setForeground(new java.awt.Color(255, 255, 255));
        btnPagos.setText("Pagos");
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
            }
        });
        jPanel1.add(btnPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 200, 50));

        btnPadres.setBackground(new java.awt.Color(0, 0, 0));
        btnPadres.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnPadres.setForeground(new java.awt.Color(255, 255, 255));
        btnPadres.setText("Padres");
        btnPadres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPadresActionPerformed(evt);
            }
        });
        jPanel1.add(btnPadres, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 200, 50));

        btnInscripcion.setBackground(new java.awt.Color(0, 0, 0));
        btnInscripcion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnInscripcion.setForeground(new java.awt.Color(255, 255, 255));
        btnInscripcion.setText("Inscripciones");
        btnInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscripcionActionPerformed(evt);
            }
        });
        jPanel1.add(btnInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 200, 50));

        btnNotas.setBackground(new java.awt.Color(0, 0, 0));
        btnNotas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnNotas.setForeground(new java.awt.Color(255, 255, 255));
        btnNotas.setText("Notas");
        btnNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotasActionPerformed(evt);
            }
        });
        jPanel1.add(btnNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 200, 50));

        btnCursos.setBackground(new java.awt.Color(0, 0, 0));
        btnCursos.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCursos.setForeground(new java.awt.Color(255, 255, 255));
        btnCursos.setText("Cursos");
        btnCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursosActionPerformed(evt);
            }
        });
        jPanel1.add(btnCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, 200, 50));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 420, 20));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 420, 20));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 173, 420, 20));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 420, 40));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 420, 20));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Usuarios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 200, 50));

        btnSalir.setBackground(new java.awt.Color(0, 0, 0));
        btnSalir.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Cerrar Sesion");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 200, 50));

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 420, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfesoresActionPerformed
        ListaProfesores listaProfesores = new ListaProfesores();
        listaProfesores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaProfesores.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProfesoresActionPerformed

    private void btnGradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGradosActionPerformed
        ListaGrados listaGrados = new ListaGrados();
        listaGrados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaGrados.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGradosActionPerformed

    private void btnSeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeccionesActionPerformed
        ListaSecciones listaSecciones = new ListaSecciones();
        listaSecciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaSecciones.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSeccionesActionPerformed

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        
        ListaAlumnos listaAlumnos = new ListaAlumnos();
        listaAlumnos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaAlumnos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        ListarPagos listaPagos = new ListarPagos();
        listaPagos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaPagos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPagosActionPerformed

    private void btnPadresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPadresActionPerformed
        // TODO add your handling code here:
        ListadoPadre listaPadre = new ListadoPadre();
        listaPadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaPadre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPadresActionPerformed

    private void btnInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscripcionActionPerformed
        // TODO add your handling code here:
        ListaInscripciones listaInscripcion = new ListaInscripciones();
        listaInscripcion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaInscripcion.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnInscripcionActionPerformed

    private void btnNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotasActionPerformed
        ListaNotas listaNotas = new ListaNotas();
        listaNotas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaNotas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNotasActionPerformed

    private void btnCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursosActionPerformed
        ListaCursos listaCursos = new ListaCursos();
        listaCursos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaCursos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCursosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AsgUA listaCursos = new AsgUA();
        listaCursos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaCursos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Login inicio = new Login();
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnCursos;
    private javax.swing.JButton btnGrados;
    private javax.swing.JButton btnInscripcion;
    private javax.swing.JButton btnNotas;
    private javax.swing.JButton btnPadres;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnProfesores;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSecciones;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    // End of variables declaration//GEN-END:variables
}

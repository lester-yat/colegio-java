package views;

import javax.swing.JFrame;

public class Inicio extends javax.swing.JFrame {
    
    public Inicio() {
        
        this.setUndecorated(true);
        initComponents();
            this.setLocationRelativeTo(null);
            setResizable(false); 

           

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salir = new javax.swing.JButton();
        btnGrados = new javax.swing.JButton();
        btnAlumnos = new javax.swing.JButton();
        btnProfesores = new javax.swing.JButton();
        btnSecciones = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnPadres = new javax.swing.JButton();
        btnInscripcion = new javax.swing.JButton();
        btnNotas = new javax.swing.JButton();
        btnCursos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salir.setBackground(new java.awt.Color(255, 255, 255));
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x.png"))); // NOI18N
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 70, 40));

        btnGrados.setBackground(new java.awt.Color(255, 255, 255));
        btnGrados.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnGrados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/grados.png"))); // NOI18N
        btnGrados.setText("Grados");
        btnGrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGradosActionPerformed(evt);
            }
        });
        getContentPane().add(btnGrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 210, 60));

        btnAlumnos.setBackground(java.awt.Color.white);
        btnAlumnos.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clss.png"))); // NOI18N
        btnAlumnos.setText("Alumnos");
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 210, 60));

        btnProfesores.setBackground(new java.awt.Color(255, 255, 255));
        btnProfesores.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnProfesores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/teachers.png"))); // NOI18N
        btnProfesores.setText("Profesores");
        btnProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfesoresActionPerformed(evt);
            }
        });
        getContentPane().add(btnProfesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 240, 60));

        btnSecciones.setBackground(new java.awt.Color(255, 255, 255));
        btnSecciones.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnSecciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/secc.png"))); // NOI18N
        btnSecciones.setText("Secciones");
        btnSecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeccionesActionPerformed(evt);
            }
        });
        getContentPane().add(btnSecciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 230, 60));

        jLabel3.setBackground(new java.awt.Color(153, 0, 153));
        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("INICIO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 140, 60));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/removeuser.png"))); // NOI18N
        jButton1.setText("Cerrar Sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 210, 60));

        btnPadres.setText("Padres");
        btnPadres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPadresActionPerformed(evt);
            }
        });
        getContentPane().add(btnPadres, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, -1));

        btnInscripcion.setText("Inscripciones");
        btnInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscripcionActionPerformed(evt);
            }
        });
        getContentPane().add(btnInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, -1));

        btnNotas.setText("Notas");
        btnNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotasActionPerformed(evt);
            }
        });
        getContentPane().add(btnNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, -1, -1));

        btnCursos.setText("Cursos");
        btnCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursosActionPerformed(evt);
            }
        });
        getContentPane().add(btnCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/69.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 640));
        jLabel2.getAccessibleContext().setAccessibleName("");

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

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Login inicio = new Login();
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton btnProfesores;
    private javax.swing.JButton btnSecciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}

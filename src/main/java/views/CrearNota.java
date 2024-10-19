package views;

import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Alumno;
import models.Curso;
import models.Nota;
import models.NotaDAO;

public class CrearNota extends javax.swing.JFrame {

    Nota nota = new Nota();
    NotaDAO notaDAO = new NotaDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public CrearNota() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarAlumnos();
        cargarCursos();
    }
    
    public void cargarAlumnos(){
        List<Alumno> alumnos = notaDAO.listarAlumnos();
        for (int i = 0; i < alumnos.size(); i++) {
            String nombre = alumnos.get(i).getNombre()+" "+alumnos.get(i).getApellido();
            selectAlumno.addItem(nombre);
        }
    }
    
    public void cargarCursos(){
        List<Curso> cursos = notaDAO.listarCursos();
        for (int i = 0; i < cursos.size(); i++) {
            String nombre = cursos.get(i).getNombre();
            selectCurso.addItem(nombre);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCalificacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        selectAlumno = new javax.swing.JComboBox<>();
        selectCurso = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFechaRegistro = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creacion de Nota");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 63, 269, 36));

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 184, 290, 35));

        txtCalificacion.setBackground(new java.awt.Color(0, 0, 0));
        txtCalificacion.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtCalificacion.setForeground(new java.awt.Color(255, 255, 255));
        txtCalificacion.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        txtCalificacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCalificacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCalificacionFocusLost(evt);
            }
        });
        jPanel1.add(txtCalificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 276, 290, 35));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de Registro");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 171, -1, -1));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Alumno");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 237, -1, -1));

        jPanel1.add(selectAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 227, 290, 35));

        jPanel1.add(selectCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 313, 290, 35));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Curso");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 323, -1, -1));

        btnGuardar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 255, 204));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 204)));
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 497, 100, 40));

        btnCancelar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 255, 204));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 204)));
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(814, 497, 100, 40));

        txtFechaRegistro.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaRegistro.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 159, 290, 35));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 310, 180, 300));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\samuel\\Desktop\\COLEGIO-JAVA\\colegio-java\\Recursos\\MONSTER.png")); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 320, 620, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaNotas vistaLista = new ListaNotas();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!"".equals(txtNombre.getText()) && !"".equals(txtCalificacion.getText()) && 
            !"".equals(txtFechaRegistro.getDate()) && selectAlumno.getSelectedItem() != null && 
            selectCurso.getSelectedItem() != null) {
            try {
                nota.setNombre(txtNombre.getText());
                nota.setCalificacion(Float.parseFloat(txtCalificacion.getText()));
                nota.setFechaRegistro(txtFechaRegistro.getDate());
                
                List<Alumno> alumnos = notaDAO.listarAlumnos();
                for (Alumno alumno : alumnos) {
                    if ((alumno.getNombre()+" "+alumno.getApellido()).equals(selectAlumno.getSelectedItem())) {
                        nota.setAlumnoID(alumno.getId());
                        break;
                    }
                }

                List<Curso> cursos = notaDAO.listarCursos();
                for (Curso curso : cursos) {
                    if (curso.getNombre().equals(selectCurso.getSelectedItem())) {
                        nota.setCursoID(curso.getId());
                        break;
                    }
                }
                
                int idNota = notaDAO.guardarNota(nota);
                if (idNota == -1) {
                    JOptionPane.showMessageDialog(null, "Error al guardar la nota.");
                    return;
                }
                
                JOptionPane.showMessageDialog(null, "Nota guardado exitosamente.");
                ListaNotas vistaLista = new ListaNotas();
                vistaLista.setVisible(true);
                dispose();
            } catch (NumberFormatException e) {
                System.out.println("Error en el formato de los datos numéricos: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar la nota: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
        
        try {
            float calificacion = Float.parseFloat(txtCalificacion.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La calificacion debe ser un número entero o con decimales.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        // TODO add your handling code here:
          if(txtNombre.getText().equals(" Nombre"))
        {
            txtNombre.setText(" ");
            txtNombre.setForeground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        // TODO add your handling code here:
        
           if(txtNombre.getText().equals(" "))
        {
            txtNombre.setText(" Nombre");
            txtNombre.setForeground(Color.decode("#545353"));
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtCalificacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCalificacionFocusGained
        // TODO add your handling code here:
          if(txtCalificacion.getText().equals(" Calificacion"))
        {
            txtCalificacion.setText(" ");
            txtCalificacion.setForeground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_txtCalificacionFocusGained

    private void txtCalificacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCalificacionFocusLost
        // TODO add your handling code here:
          if(txtCalificacion.getText().equals(" "))
        {
            txtCalificacion.setText(" Calificacion");
            txtCalificacion.setForeground(Color.decode("#545353"));
        }
    }//GEN-LAST:event_txtCalificacionFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
           if (txtNombre.getText().isEmpty()) {
        txtNombre.setText(" Nombre");
        txtNombre.setForeground(new Color(153, 153, 153));
    }
           
              if (txtCalificacion.getText().isEmpty()) {
        txtCalificacion.setText(" Calificacion");
        txtCalificacion.setForeground(new Color(153, 153, 153));
    }
    }//GEN-LAST:event_formWindowOpened

    
    
    
    
    
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
            java.util.logging.Logger.getLogger(CrearNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearNota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> selectAlumno;
    private javax.swing.JComboBox<String> selectCurso;
    private javax.swing.JTextField txtCalificacion;
    private com.toedter.calendar.JDateChooser txtFechaRegistro;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

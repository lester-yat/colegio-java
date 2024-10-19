package views;

import java.awt.Color;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import models.Grado;
import models.Seccion;
import models.SeccionDAO;

public class CrearSeccion extends javax.swing.JFrame {

    Seccion seccion = new Seccion();
    SeccionDAO seccionDAO = new SeccionDAO();

    public CrearSeccion() {
        this.setUndecorated(true);
        initComponents();
        cargarGrados();
    }

    public void cargarGrados() {
        List<Grado> grados = seccionDAO.listarGrados();
        for (int i = 0; i < grados.size(); i++) {
            String nombre = grados.get(i).getNombre();
            selectGrado.addItem(nombre);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtHoraInicio = new javax.swing.JTextField();
        txtHoraFinal = new javax.swing.JTextField();
        selectGrado = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creacion de Seccion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 41, -1, -1));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Grado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 413, -1, -1));

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
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 149, 290, 35));

        txtHoraInicio.setBackground(new java.awt.Color(0, 0, 0));
        txtHoraInicio.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtHoraInicio.setForeground(new java.awt.Color(255, 255, 255));
        txtHoraInicio.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        txtHoraInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoraInicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoraInicioFocusLost(evt);
            }
        });
        jPanel1.add(txtHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 243, 290, 35));

        txtHoraFinal.setBackground(new java.awt.Color(0, 0, 0));
        txtHoraFinal.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtHoraFinal.setForeground(new java.awt.Color(255, 255, 255));
        txtHoraFinal.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        txtHoraFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoraFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoraFinalFocusLost(evt);
            }
        });
        jPanel1.add(txtHoraFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 334, 290, 35));

        selectGrado.setBackground(new java.awt.Color(255, 255, 255));
        selectGrado.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        selectGrado.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(selectGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 433, 290, 35));

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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 100, 40));

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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 460, 100, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\samuel\\Desktop\\COLEGIO-JAVA\\colegio-java\\Recursos\\MONSTER.png")); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 149, 406, 258));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaSecciones vistaLista = new ListaSecciones();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (!"".equals(txtNombre.getText()) && !"".equals(txtHoraInicio.getText())
            && !"".equals(txtHoraFinal.getText()) && !"".equals(selectGrado.getSelectedItem())) {

            // Validación para que el nombre tenga al menos 3 caracteres
            if (txtNombre.getText().length() < 3) {
                JOptionPane.showMessageDialog(null, "El nombre debe tener al menos 3 caracteres.");
                return;
            }

            try {
                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
                formatoHora.setLenient(false);

                // Validación para verificar el formato de las horas
                Date horaInicio = formatoHora.parse(txtHoraInicio.getText());
                Date horaFinal = formatoHora.parse(txtHoraFinal.getText());

                // Validación para que la hora de inicio no sea igual a la hora final
                if (horaInicio.equals(horaFinal)) {
                    JOptionPane.showMessageDialog(null, "La hora de inicio y la hora final no pueden ser iguales.");
                    return;
                }

                // Validación para que la hora de inicio sea menor que la hora final
                if (horaInicio.after(horaFinal)) {
                    JOptionPane.showMessageDialog(null, "La hora de inicio debe ser menor que la hora final.");
                    return;
                }

                seccion.setHorarioInicio(new Time(horaInicio.getTime()));
                seccion.setHorarioFinal(new Time(horaFinal.getTime()));
                seccion.setNombre(txtNombre.getText());

                List<Grado> grados = seccionDAO.listarGrados();
                boolean gradoEncontrado = false;
                for (Grado grado : grados) {
                    if (grado.getNombre().equals(selectGrado.getSelectedItem())) {
                        seccion.setGrado(grado.getId());
                        gradoEncontrado = true;
                        break;
                    }
                }

                // Validación para asegurar que el grado existe
                if (!gradoEncontrado) {
                    JOptionPane.showMessageDialog(null, "Grado no válido.");
                    return;
                }

                seccionDAO.guardarSeccion(seccion);
                JOptionPane.showMessageDialog(null, "Sección guardada exitosamente.");
                ListaSecciones vistaLista = new ListaSecciones();
                vistaLista.setVisible(true);
                dispose();

            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Error en el formato de la hora: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar la sección: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos están vacíos.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        // TODO add your handling code here:
           if (txtNombre.getText().equals(" Nombre")) {
        txtNombre.setText(""); // Limpia el campo
        txtNombre.setForeground(Color.decode("#FFFFFF")); // Color de texto normal
    }
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        // TODO add your handling code here:
         if (txtNombre.getText().trim().isEmpty()) {
        txtNombre.setText(" Nombre"); // Vuelve a poner el placeholder
        txtNombre.setForeground(Color.decode("#ECECEC")); // Color de placeholder (gris)
    }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtHoraInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraInicioFocusGained
        // TODO add your handling code here:
         if (txtHoraInicio.getText().equals(" Hora de inicio")) {
        txtHoraInicio.setText(""); // Limpia el campo
        txtHoraInicio.setForeground(Color.decode("#FFFFFF")); // Color de texto normal
    }
    }//GEN-LAST:event_txtHoraInicioFocusGained

    private void txtHoraInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraInicioFocusLost
        // TODO add your handling code here:
         if (txtHoraInicio.getText().trim().isEmpty()) {
        txtHoraInicio.setText(" Hora de inicio"); // Vuelve a poner el placeholder
        txtHoraInicio.setForeground(Color.decode("#ECECEC")); // Color de placeholder (gris)
    }
    }//GEN-LAST:event_txtHoraInicioFocusLost

    private void txtHoraFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraFinalFocusGained
        // TODO add your handling code here:
              if (txtHoraFinal.getText().equals(" Horario final")) {
        txtHoraFinal.setText(""); // Limpia el campo
        txtHoraFinal.setForeground(Color.decode("#FFFFFF")); // Color de texto normal
    }
    }//GEN-LAST:event_txtHoraFinalFocusGained

    private void txtHoraFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraFinalFocusLost
        // TODO add your handling code here:
                if (txtHoraFinal.getText().trim().isEmpty()) {
        txtHoraFinal.setText(" Horario final"); // Vuelve a poner el placeholder
        txtHoraFinal.setForeground(Color.decode("#ECECEC")); // Color de placeholder (gris)
    }
    }//GEN-LAST:event_txtHoraFinalFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
          if (txtNombre.getText().isEmpty()) {
        txtNombre.setText(" Nombre");
        txtNombre.setForeground(Color.decode("#B0B0B0")); // Color gris para el placeholder
    }  
        
      if (txtHoraInicio.getText().isEmpty()) {
        txtHoraInicio.setText(" Hora de inicio");
        txtHoraInicio.setForeground(Color.decode("#B0B0B0")); // Color gris para el placeholder
    }  
      if (txtHoraFinal.getText().isEmpty()) {
        txtHoraFinal.setText(" Horario final");
        txtHoraFinal.setForeground(Color.decode("#B0B0B0")); // Color gris para el placeholder
    }  
      
    this.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(CrearSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearSeccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> selectGrado;
    private javax.swing.JTextField txtHoraFinal;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

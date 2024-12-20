package views;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import models.Grado;
import models.Profesor;
import models.Seccion;
import models.SeccionDAO;

public class EditarSeccion extends javax.swing.JFrame {

    Seccion seccion = new Seccion();
    SeccionDAO seccionDAO = new SeccionDAO();
    
    public int seccionId;
    private Map<Integer, String> gradoMap = new HashMap<>();
    
    public EditarSeccion() {
        this.setUndecorated(true);
        initComponents();
            this.setLocationRelativeTo(null);
            setResizable(false); 
        
    }
    
    
    
    public void cargarGrados() {
        List<Grado> grados = seccionDAO.listarGrados();
        gradoMap.clear();

        for (Grado grado : grados) {
            gradoMap.put(grado.getId(), grado.getNombre());
            selectGrado.addItem(grado.getNombre());
        }
    }

    
    public EditarSeccion(int seccionId) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.seccionId = seccionId;
        
        cargarGrados();

        Seccion seccion = seccionDAO.consultarSeccion(seccionId);

        if (seccion != null) {
            txtNombre.setText(seccion.getNombre());
            txtHoraInicio.setText(String.format("%tT", seccion.getHorarioInicio()));
            txtHoraFinal.setText(String.format("%tT", seccion.getHorarioFinal()));
            
            Integer gradoId = seccion.getGrado();
            if (gradoId != null) {
                String gradoNombre = gradoMap.get(gradoId);
                if (gradoNombre != null) {
                    selectGrado.setSelectedItem(gradoNombre);
                }
            }
        } else {
            System.out.println("No se encontró ninguna sección con el ID: " + seccionId);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoraInicio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoraFinal = new javax.swing.JTextField();
        selectGrado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Editar  Seccion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(null);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 300, -1));

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Horario de Inicio");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        txtHoraInicio.setBackground(new java.awt.Color(0, 0, 0));
        txtHoraInicio.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtHoraInicio.setForeground(new java.awt.Color(255, 255, 255));
        txtHoraInicio.setBorder(null);
        txtHoraInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraInicioActionPerformed(evt);
            }
        });
        jPanel1.add(txtHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 300, -1));

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Horario de Fin");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        txtHoraFinal.setBackground(new java.awt.Color(0, 0, 0));
        txtHoraFinal.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtHoraFinal.setForeground(new java.awt.Color(255, 255, 255));
        txtHoraFinal.setBorder(null);
        txtHoraFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraFinalActionPerformed(evt);
            }
        });
        jPanel1.add(txtHoraFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 300, -1));

        selectGrado.setBackground(new java.awt.Color(255, 255, 255));
        selectGrado.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        selectGrado.setForeground(new java.awt.Color(0, 0, 0));
        selectGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectGradoActionPerformed(evt);
            }
        });
        jPanel1.add(selectGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 300, -1));

        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Grado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(0, 0, 0));
        btnActualizar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 300, 10));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 300, 10));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 300, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed


        if (!"".equals(txtNombre.getText()) && !"".equals(txtHoraInicio.getText()) &&
        !"".equals(txtHoraFinal.getText()) && selectGrado.getSelectedItem() != null) {

    // Validación para que el nombre tenga al menos 3 caracteres
    if (txtNombre.getText().length() < 1) {
        JOptionPane.showMessageDialog(null, "El nombre debe tener al menos 1 caracteres.");
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

        seccion.setHorarioInicio(new java.sql.Time(horaInicio.getTime()));
        seccion.setHorarioFinal(new java.sql.Time(horaFinal.getTime()));
        seccion.setNombre(txtNombre.getText());
        seccion.setId(seccionId);

        String selectedGradoNombre = (String) selectGrado.getSelectedItem();
        Integer gradoId = null;
        for (Map.Entry<Integer, String> entry : gradoMap.entrySet()) {
            if (entry.getValue().equals(selectedGradoNombre)) {
                gradoId = entry.getKey();
                break;
            }
        }

        // Validación para asegurar que el grado existe
        if (gradoId != null) {
            seccion.setGrado(gradoId);
            seccionDAO.editarSeccion(seccion);
            JOptionPane.showMessageDialog(null, "Sección actualizada exitosamente.");
            ListaSecciones vistaLista = new ListaSecciones();
            vistaLista.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Grado seleccionado no encontrado.");
        }
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(null, "Error en el formato de la hora: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar la sección: " + e.getMessage());
    }
} else {
    JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados.");
}


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaSecciones vistaLista = new ListaSecciones();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtHoraInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraInicioActionPerformed

    private void txtHoraFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraFinalActionPerformed

    private void selectGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectGradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectGradoActionPerformed

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
            java.util.logging.Logger.getLogger(EditarSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarSeccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> selectGrado;
    private javax.swing.JTextField txtHoraFinal;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

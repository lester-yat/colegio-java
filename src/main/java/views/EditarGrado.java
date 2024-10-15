package views;

import java.util.Date;
import javax.swing.JOptionPane;
import models.Grado;
import models.GradoDAO;

public class EditarGrado extends javax.swing.JFrame {
    
    Grado grado = new Grado();
    GradoDAO gradoDAO = new GradoDAO();
    
    public int gradoId;

    public EditarGrado() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false); 
    }
    
    public EditarGrado(int gradoId) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.gradoId = gradoId;
        
        Grado grado = gradoDAO.consultarDatos(gradoId);

        if (grado != null) {
            txtNombre3.setText(grado.getNombre());
            txtSalon3.setText(grado.getSalon());
            txtNivel3.setText(grado.getNivel());
            txtAnio.setDate(grado.getAnio());
            txtJornada3.setText(grado.getJornada());
            txtCantMaxEstu3.setText(String.valueOf(grado.getCantidadMaxEstudiantes()));
        } else {
            System.out.println("No se encontró ningún grado con el ID: " + gradoId);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtNombre3 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtSalon3 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtNivel3 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtJornada3 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtCantMaxEstu3 = new javax.swing.JTextField();
        btnActualizar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        txtAnio = new com.toedter.calendar.JDateChooser();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Edicion Grado");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 310, 33));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Nombre");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        txtNombre3.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtNombre3.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre3.setBorder(null);
        jPanel1.add(txtNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 330, -1));

        jLabel24.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Salon");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        txtSalon3.setBackground(new java.awt.Color(0, 0, 0));
        txtSalon3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtSalon3.setForeground(new java.awt.Color(255, 255, 255));
        txtSalon3.setBorder(null);
        jPanel1.add(txtSalon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 330, -1));

        jLabel25.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Nivel");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        txtNivel3.setBackground(new java.awt.Color(0, 0, 0));
        txtNivel3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtNivel3.setForeground(new java.awt.Color(255, 255, 255));
        txtNivel3.setBorder(null);
        txtNivel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNivel3ActionPerformed(evt);
            }
        });
        jPanel1.add(txtNivel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 330, -1));

        jLabel26.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Año");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, -1));

        jLabel27.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Jornada");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        txtJornada3.setBackground(new java.awt.Color(0, 0, 0));
        txtJornada3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtJornada3.setForeground(new java.awt.Color(255, 255, 255));
        txtJornada3.setBorder(null);
        jPanel1.add(txtJornada3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 330, -1));

        jLabel28.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Cantidad Max Estudiantes");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        txtCantMaxEstu3.setBackground(new java.awt.Color(0, 0, 0));
        txtCantMaxEstu3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtCantMaxEstu3.setForeground(new java.awt.Color(255, 255, 255));
        txtCantMaxEstu3.setBorder(null);
        txtCantMaxEstu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantMaxEstu3ActionPerformed(evt);
            }
        });
        jPanel1.add(txtCantMaxEstu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 330, -1));

        btnActualizar1.setBackground(new java.awt.Color(0, 0, 0));
        btnActualizar1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnActualizar1.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar1.setText("Actualizar");
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, -1, -1));

        btnCancelar1.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelar1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnCancelar1.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, -1, -1));
        jPanel1.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 330, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 320, 10));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 320, 10));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 320, 20));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 320, 10));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 320, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaGrados vistaLista = new ListaGrados();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (!"".equals(txtNombre3.getText()) && !"".equals(txtSalon3.getText()) && !"".equals(txtNivel3.getText()) &&
            !"".equals(txtAnio.getDate()) && !"".equals(txtJornada3.getText()) && !"".equals(txtCantMaxEstu3.getText())) {
            try {
                grado.setId(gradoId);
                grado.setNombre(txtNombre3.getText());
                grado.setSalon(txtSalon3.getText());
                grado.setNivel(txtNivel3.getText());
                grado.setJornada(txtJornada3.getText());
                grado.setCantidadMaxEstudiantes(Integer.parseInt(txtCantMaxEstu3.getText()));
                grado.setAnio( (Date) txtAnio.getDate());

                gradoDAO.editarGrado(grado);
                JOptionPane.showMessageDialog(null, "Grado actualizado exitosamente.");
                ListaGrados vistaLista = new ListaGrados();
                vistaLista.setVisible(true);
                dispose();
            } catch (NumberFormatException e) {
                System.out.println("Error en el formato de los datos numéricos: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el grado: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
        
        try {
            int edad = Integer.parseInt(txtSalon3.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El salon debe ser un número entero.");
        }

        try {
            int inscripcion = Integer.parseInt(txtCantMaxEstu3.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La cantidad maxima de estudiantes debe ser un número entero.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtNivel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNivel3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNivel3ActionPerformed

    private void txtCantMaxEstu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantMaxEstu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantMaxEstu3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarGrado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private com.toedter.calendar.JDateChooser txtAnio;
    private javax.swing.JTextField txtCantMaxEstu3;
    private javax.swing.JTextField txtJornada3;
    private javax.swing.JTextField txtNivel3;
    private javax.swing.JTextField txtNombre3;
    private javax.swing.JTextField txtSalon3;
    // End of variables declaration//GEN-END:variables
}

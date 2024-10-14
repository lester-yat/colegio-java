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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Edicion Grado");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 310, 33));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Nombre");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        txtNombre3.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtNombre3.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 330, -1));

        jLabel24.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Salon");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        txtSalon3.setBackground(new java.awt.Color(255, 255, 255));
        txtSalon3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtSalon3.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtSalon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 330, -1));

        jLabel25.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Nivel");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        txtNivel3.setBackground(new java.awt.Color(255, 255, 255));
        txtNivel3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtNivel3.setForeground(new java.awt.Color(0, 0, 0));
        txtNivel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNivel3ActionPerformed(evt);
            }
        });
        getContentPane().add(txtNivel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 330, -1));

        jLabel26.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Año");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        jLabel27.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Jornada");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        txtJornada3.setBackground(new java.awt.Color(255, 255, 255));
        txtJornada3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtJornada3.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtJornada3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 330, -1));

        jLabel28.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Cantidad Max Estudiantes");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        txtCantMaxEstu3.setBackground(new java.awt.Color(255, 255, 255));
        txtCantMaxEstu3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtCantMaxEstu3.setForeground(new java.awt.Color(0, 0, 0));
        txtCantMaxEstu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantMaxEstu3ActionPerformed(evt);
            }
        });
        getContentPane().add(txtCantMaxEstu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 330, -1));

        btnActualizar1.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnActualizar1.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnActualizar1.setText("Actualizar");
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, -1));

        btnCancelar1.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnCancelar1.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calcelar.png"))); // NOI18N
        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, -1));
        getContentPane().add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 330, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/69.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 550));

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private com.toedter.calendar.JDateChooser txtAnio;
    private javax.swing.JTextField txtCantMaxEstu3;
    private javax.swing.JTextField txtJornada3;
    private javax.swing.JTextField txtNivel3;
    private javax.swing.JTextField txtNombre3;
    private javax.swing.JTextField txtSalon3;
    // End of variables declaration//GEN-END:variables
}

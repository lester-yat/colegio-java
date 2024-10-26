package views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Alumno;
import models.Conexion;
import models.Padre;
import models.PadreDAO;

public class CrearPadre extends javax.swing.JFrame {

    private List<Alumno> listaAlumnosSeleccionados = new ArrayList<>();
    private List<Alumno> listaAlumnosRelacionados = new ArrayList<>();

    // Modelo para la tabla de alumnos
    private DefaultTableModel modeloTablaAlumnos;

    public CrearPadre() {
        initComponents();
        cbParentesco.addItem("Padre");
        cbParentesco.addItem("Madre");
        cbParentesco.addItem("Encargado");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        cbParentesco = new javax.swing.JComboBox<>();
        txtTelefono = new javax.swing.JTextField();
        txtIdentificacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombres");

        txtApellido.setBackground(new java.awt.Color(0, 0, 0));
        txtApellido.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Edad");

        txtEdad.setBackground(new java.awt.Color(0, 0, 0));
        txtEdad.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(255, 255, 255));
        txtEdad.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creación de Padre");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                            .addComponent(txtApellido)
                            .addComponent(txtEdad))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(23, 23, 23))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 650, 100, 40));

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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 100, 40));

        cbParentesco.setBackground(new java.awt.Color(255, 255, 255));
        cbParentesco.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        cbParentesco.setForeground(new java.awt.Color(0, 0, 0));
        cbParentesco.setBorder(null);
        cbParentesco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbParentescoActionPerformed(evt);
            }
        });
        jPanel1.add(cbParentesco, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 530, 274, 35));

        txtTelefono.setBackground(new java.awt.Color(0, 0, 0));
        txtTelefono.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, 274, 33));

        txtIdentificacion.setBackground(new java.awt.Color(0, 0, 0));
        txtIdentificacion.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtIdentificacion.setForeground(new java.awt.Color(255, 255, 255));
        txtIdentificacion.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        jPanel1.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 274, 35));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Parentesco");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, -1, -1));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Teléfono");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, -1, -1));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Identificación");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaAlumnos vistaLista = new ListaAlumnos();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // guardarPadre(); // Llamar al método para guardar el padre
        // Crear un nuevo objeto Padre con los datos del formulario

        Padre nuevoPadre = new Padre();

// Validación de nombre y apellido
        if (txtNombre.getText().length() < 2) {
            JOptionPane.showMessageDialog(this, "El nombre debe tener al menos 2 caracteres.");
            return;
        }
        if (txtApellido.getText().length() < 2) {
            JOptionPane.showMessageDialog(this, "El apellido debe tener al menos 2 caracteres.");
            return;
        }

// Validación de edad
        try {
            int edad = Integer.parseInt(txtEdad.getText());
            if (edad <= 0 || edad > 100) {
                JOptionPane.showMessageDialog(this, "La edad debe ser un número entre 1 y 100.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número entero válido.");
            return;
        }

// Validación de teléfono (8 dígitos)
        if (!txtTelefono.getText().matches("\\d{8}")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe ser un número de 8 dígitos.");
            return;
        }

// Validación de parentesco
        if (cbParentesco.getSelectedItem() == null || "".equals(cbParentesco.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un parentesco.");
            return;
        }
        
        String identificacion = txtIdentificacion.getText();
        if (identificacion.length() > 50) {
            JOptionPane.showMessageDialog(null, "La identificación no puede exceder los 50 caracteres.");
            return;
        }

// Si todas las validaciones pasan, procedemos a guardar los datos
        nuevoPadre.setNombre(txtNombre.getText());
        nuevoPadre.setApellido(txtApellido.getText());
        nuevoPadre.setEdad(Integer.parseInt(txtEdad.getText()));
        nuevoPadre.setIdentificacion(txtIdentificacion.getText());
        nuevoPadre.setTelefono(txtTelefono.getText());
        nuevoPadre.setParentesco(cbParentesco.getSelectedItem().toString());

        PadreDAO padreDAO = new PadreDAO();
        boolean guardado = padreDAO.guardarPadre(nuevoPadre);

        if (guardado) {
            JOptionPane.showMessageDialog(this, "Padre guardado correctamente.");
            this.dispose(); // Cerrar el formulario de creación
            ListadoPadre vistaLista = new ListadoPadre();
            vistaLista.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar el padre.");
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbParentescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbParentescoActionPerformed

    }//GEN-LAST:event_cbParentescoActionPerformed

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
            java.util.logging.Logger.getLogger(CrearPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearPadre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbParentesco;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}

package views;

import com.toedter.calendar.JDateChooser;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import models.Alumno;
import models.AlumnoDAO;
import models.Grado;
import models.GradoDAO;
import models.Inscripcion;
import models.InscripcionDAO;
import models.Seccion;
import models.SeccionDAO;

public class CrearInscripcion extends javax.swing.JFrame {

    InscripcionDAO inscripcionDAO = new InscripcionDAO();
    public int alumnoId, gradoId;

    public CrearInscripcion() {
        this.setUndecorated(true);
        initComponents();
        cargarGrados();
        cargarAlumnos();
    }

    public void cargarAlumnos() {
        List<Alumno> alumnos = inscripcionDAO.listarAlumnos();
        for (Alumno alumno : alumnos) {
            // Crear un objeto de tipo ComboBoxItem que almacene el ID y el nombre
            String item = alumno.getId() + " - " + alumno.getNombre() + " " + alumno.getApellido();
            selectAlumno.addItem(item); // Añadir el string con el ID y el nombre
        }
    }

    public void cargarGrados() {
        List<Grado> grados = inscripcionDAO.listarGrados();
        for (Grado grado : grados) {
            // Crear un objeto de tipo ComboBoxItem que almacene el ID y el nombre
            String item = grado.getId() + " - " + grado.getNombre();
            selectGrado.addItem(item); // Añadir el string con el ID y el nombre
        }

    }
    
    
    // Método para validar el número de cuenta
private boolean validarNumeroCuenta(String numeroCuenta) {
    String regex = "^(\\d{4}-?\\d{4}-?\\d{2}-?\\d{8})$|^(\\d{4}-?\\d{4}-?\\d{8})$|^(\\d{4}-?\\d{8})$";
    if (!numeroCuenta.matches(regex)) {
        JOptionPane.showMessageDialog(this, "Número de cuenta inválido. Formatos válidos:\n" +
                "- ####-####-##-########\n" +
                "- ####-####-########\n" +
                "- ####-########", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}

// Método para validar el monto
private boolean validarMonto(double monto) {
    double limiteMaximo = 100000; // Define el límite máximo aquí
    if (monto <= 0 || monto > limiteMaximo) {
        JOptionPane.showMessageDialog(this, "Monto inválido. Debe ser un número positivo y no exceder " + limiteMaximo,
                "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}

// Método para validar la fecha
private boolean validarFecha(Date fecha) {
    if (fecha == null) {
        JOptionPane.showMessageDialog(this, "Fecha inválida. No puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    Date fechaActual = new Date();
    if (fecha.after(fechaActual)) {
        JOptionPane.showMessageDialog(this, "Fecha inválida. No puede ser una fecha futura.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}

// En tu diseño puedes agregar el JDateChooser donde lo necesites
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        selectGrado = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        selectAlumno = new javax.swing.JComboBox<>();
        ChooserInscripcion = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creación de Inscripcion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Alumno");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID Grado");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de Inscripción");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        selectGrado.setBackground(new java.awt.Color(255, 255, 255));
        selectGrado.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        selectGrado.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(selectGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 225, 290, 30));

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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, 100, 40));

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0));
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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 560, 100, 40));

        selectAlumno.setBackground(new java.awt.Color(255, 255, 255));
        selectAlumno.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        selectAlumno.setForeground(new java.awt.Color(0, 0, 0));
        selectAlumno.setBorder(null);
        jPanel1.add(selectAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 165, 290, 30));

        ChooserInscripcion.setBackground(new java.awt.Color(255, 255, 255));
        ChooserInscripcion.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(ChooserInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 290, -1));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No. Cuenta");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Monto");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, -1));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estado");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, -1, -1));

        txtCuenta.setBackground(new java.awt.Color(0, 0, 0));
        txtCuenta.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtCuenta.setForeground(new java.awt.Color(255, 255, 255));
        txtCuenta.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        jPanel1.add(txtCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 290, 30));

        txtEstado.setBackground(new java.awt.Color(0, 0, 0));
        txtEstado.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtEstado.setForeground(new java.awt.Color(255, 255, 255));
        txtEstado.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 290, 30));

        txtMonto.setBackground(new java.awt.Color(0, 0, 0));
        txtMonto.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtMonto.setForeground(new java.awt.Color(255, 255, 255));
        txtMonto.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        jPanel1.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 290, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       if (selectAlumno.getSelectedItem() != null && selectGrado.getSelectedItem() != null && ChooserInscripcion.getDate() != null) {
        // Validaciones de los nuevos campos
        if (txtCuenta.getText().isEmpty() || txtMonto.getText().isEmpty() || txtEstado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.");
            return;
        }

        try {
            // Validar el número de cuenta
            String numeroCuenta = txtCuenta.getText();
            if (!validarNumeroCuenta(numeroCuenta)) {
                return; // Detener si la validación falla
            }

            // Validar que el monto sea un número válido y positivo
            double monto = Double.parseDouble(txtMonto.getText());
            if (!validarMonto(monto)) {
                return; // Detener si la validación falla
            }

            // Validar que la fecha no sea futura
            Date fechaInscripcion = ChooserInscripcion.getDate();
            if (!validarFecha(fechaInscripcion)) {
                return; // Detener si la validación falla
            }

            // Crear una nueva inscripción
            Inscripcion inscripcion = new Inscripcion();

            // Obtener el ID del Alumno a partir de la selección
            String alumnoSeleccionado = (String) selectAlumno.getSelectedItem();
            int idAlumno = Integer.parseInt(alumnoSeleccionado.split(" - ")[0]); // Extraer ID
            inscripcion.setAlumnoId(idAlumno);

            // Obtener el ID del Grado a partir de la selección
            String gradoSeleccionado = (String) selectGrado.getSelectedItem();
            int idGrado = Integer.parseInt(gradoSeleccionado.split(" - ")[0]); // Extraer ID
            inscripcion.setGradoId(idGrado);

            // Asignar la fecha de inscripción
            inscripcion.setFechaInscripcion(fechaInscripcion);

            // Asignar los nuevos campos
            inscripcion.setNumeroCuenta(numeroCuenta);
            inscripcion.setMonto(monto);
            inscripcion.setEstado(txtEstado.getText());

            // Guardar la inscripción en la base de datos
            int idInscripcion = inscripcionDAO.guardarInscripcion(inscripcion);
            if (idInscripcion == -1) {
                JOptionPane.showMessageDialog(null, "Error al guardar la inscripción.");
                return;
            }

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "Inscripción guardada exitosamente.");
            ListaInscripciones vistaLista = new ListaInscripciones();
            vistaLista.setVisible(true);
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El monto debe ser un número válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar la inscripción: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos.");
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaInscripciones vistaLista = new ListaInscripciones();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(CrearInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearInscripcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser ChooserInscripcion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> selectAlumno;
    private javax.swing.JComboBox<String> selectGrado;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}

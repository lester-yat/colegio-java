package views;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import models.Alumno;
import models.AlumnoDAO;
import models.Grado;
import models.GradoDAO;
import models.Inscripcion;
import models.InscripcionDAO;

public class EditarInscripcion extends javax.swing.JFrame {

    InscripcionDAO inscripcionDAO = new InscripcionDAO();
    AlumnoDAO alumnoDAO = new AlumnoDAO();
    GradoDAO gradoDAO = new GradoDAO();

    private int idInscripcion; // ID de la inscripción que estás editando

    public EditarInscripcion() {
        this.setUndecorated(true);
        initComponents();
        this.idInscripcion = idInscripcion;

    }

    public EditarInscripcion(int idInscripcionSeleccionado) {
        this.idInscripcion = idInscripcionSeleccionado;
        initComponents();  // Asegúrate de inicializar los componentes
        cargarInscripcion(idInscripcion); // Cargar datos existentes

    }

// Método para cargar los datos de la inscripción a editar
    public void cargarInscripcion(int idInscripcion) {
        Inscripcion inscripcion = inscripcionDAO.obtenerInscripcionPorId(idInscripcion);

        // Cargar los alumnos en el JComboBox
        cargarAlumnos();
        cargarGrados();

        // Seleccionar el alumno correspondiente
        for (int i = 0; i < selectAlumno.getItemCount(); i++) {
            String item = selectAlumno.getItemAt(i);
            if (item.startsWith(inscripcion.getAlumnoId() + " -")) {
                selectAlumno.setSelectedIndex(i);
                break;
            }
        }

        // Seleccionar el grado correspondiente
        for (int i = 0; i < selectGrado.getItemCount(); i++) {
            String item = selectGrado.getItemAt(i);
            if (item.startsWith(inscripcion.getGradoId() + " -")) {
                selectGrado.setSelectedIndex(i);
                break;
            }
        }

        // Establecer la fecha de inscripción
        ChooserInscripcion.setDate(inscripcion.getFechaInscripcion());

        // Asignar los valores a los nuevos campos (número de cuenta, monto y estado)
        txtCuenta.setText(inscripcion.getNumeroCuenta()); // Para número de cuenta
        txtMonto.setText(String.valueOf(inscripcion.getMonto())); // Convertir monto a String para mostrarlo
        txtEstado.setText(inscripcion.getEstado()); // Para el estado de la inscripción
    }

    public void cargarAlumnos() {
        List<Alumno> alumnos = alumnoDAO.listarAlumnos();
        for (Alumno alumno : alumnos) {
            String item = alumno.getId() + " - " + alumno.getNombre() + " " + alumno.getApellido();
            selectAlumno.addItem(item);
        }
    }

    public void cargarGrados() {
        List<Grado> grados = gradoDAO.listarGrados();
        for (Grado grado : grados) {
            String item = grado.getId() + " - " + grado.getNombre();
            selectGrado.addItem(item);
        }
    }
    
    // Primero agregamos los métodos de validación
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

private boolean validarMonto(double monto) {
    double limiteMaximo = 100000; // Define el límite máximo aquí
    if (monto <= 0 || monto > limiteMaximo) {
        JOptionPane.showMessageDialog(this, "Monto inválido. Debe ser un número positivo y no exceder " + limiteMaximo,
                "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        selectAlumno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        selectGrado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ChooserInscripcion = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txtMonto = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Edicion Inscripcion");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 440, 33));

        btnActualizar.setBackground(new java.awt.Color(0, 0, 0));
        btnActualizar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Alumno");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        selectAlumno.setBackground(new java.awt.Color(0, 0, 0));
        selectAlumno.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(selectAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 170, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID Grado");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        selectGrado.setBackground(new java.awt.Color(0, 0, 0));
        selectGrado.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(selectGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 170, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        ChooserInscripcion.setBackground(new java.awt.Color(0, 0, 0));
        ChooserInscripcion.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ChooserInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de Inscripcion");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("No.Cuenta");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Monto");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));

        txtCuenta.setBackground(new java.awt.Color(0, 0, 0));
        txtCuenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCuenta.setForeground(new java.awt.Color(255, 255, 255));
        txtCuenta.setBorder(null);
        jPanel1.add(txtCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 190, -1));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 200, 10));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 200, 10));

        txtMonto.setBackground(new java.awt.Color(0, 0, 0));
        txtMonto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtMonto.setForeground(new java.awt.Color(255, 255, 255));
        txtMonto.setBorder(null);
        jPanel1.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 190, -1));

        txtEstado.setBackground(new java.awt.Color(0, 0, 0));
        txtEstado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtEstado.setForeground(new java.awt.Color(255, 255, 255));
        txtEstado.setBorder(null);
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 190, -1));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 200, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaInscripciones vistaLista = new ListaInscripciones();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       if (selectAlumno.getSelectedItem() != null && selectGrado.getSelectedItem() != null && ChooserInscripcion.getDate() != null) {
        // Validaciones de los campos
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

            // Crear una nueva inscripción con los datos modificados
            Inscripcion inscripcion = new Inscripcion();

            // Obtener el ID del Alumno seleccionado
            String alumnoSeleccionado = (String) selectAlumno.getSelectedItem();
            int idAlumno = Integer.parseInt(alumnoSeleccionado.split(" - ")[0]); // Extraer ID
            inscripcion.setAlumnoId(idAlumno);

            // Obtener el ID del Grado seleccionado
            String gradoSeleccionado = (String) selectGrado.getSelectedItem();
            int idGrado = Integer.parseInt(gradoSeleccionado.split(" - ")[0]); // Extraer ID
            inscripcion.setGradoId(idGrado);

            // Asignar fecha de inscripción
            inscripcion.setFechaInscripcion(fechaInscripcion);

            // Asignar los valores de los campos
            inscripcion.setNumeroCuenta(numeroCuenta);
            inscripcion.setMonto(monto);
            inscripcion.setEstado(txtEstado.getText());

            // Actualizar la inscripción en la base de datos
            boolean actualizacionExitosa = inscripcionDAO.actualizarInscripcion(idInscripcion, inscripcion);
            if (!actualizacionExitosa) {
                JOptionPane.showMessageDialog(null, "Error al actualizar la inscripción.");
                return;
            }

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "Inscripción actualizada exitosamente.");
            ListaInscripciones vistaLista = new ListaInscripciones();
            vistaLista.setVisible(true);
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El monto debe ser un número válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar la inscripción: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos.");
    }
    }//GEN-LAST:event_btnActualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarInscripcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser ChooserInscripcion;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JComboBox<String> selectAlumno;
    private javax.swing.JComboBox<String> selectGrado;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}

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
    }

    public void cargarAlumnos() {
        List<Alumno> alumnos = alumnoDAO.listarAlumnos();
        for (Alumno alumno : alumnos) {
            String item = alumno.getId()+ " - " + alumno.getNombre() + " " + alumno.getApellido();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel22 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        selectAlumno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        selectGrado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ChooserInscripcion = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Edicion Inscripcion");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 500, 33));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calcelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, -1));

        jLabel2.setText("ID Alumno");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        getContentPane().add(selectAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 160, -1));

        jLabel3.setText("ID Grado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        getContentPane().add(selectGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 160, -1));

        jLabel4.setText("Fecha de Inscripcion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));
        getContentPane().add(ChooserInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 170, -1));

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

        if (selectAlumno.getSelectedItem() != null && selectGrado.getSelectedItem() != null && ChooserInscripcion.getDate() != null) {
            try {
                Inscripcion inscripcion = new Inscripcion();

                // Obtener el ID del Alumno seleccionado
                String alumnoSeleccionado = (String) selectAlumno.getSelectedItem();
                int idAlumno = Integer.parseInt(alumnoSeleccionado.split(" - ")[0]);
                inscripcion.setAlumnoId(idAlumno);

                // Obtener el ID del Grado seleccionado
                String gradoSeleccionado = (String) selectGrado.getSelectedItem();
                int idGrado = Integer.parseInt(gradoSeleccionado.split(" - ")[0]);
                inscripcion.setGradoId(idGrado);

                // Obtener la fecha del JDateChooser
                Date fechaInscripcion = ChooserInscripcion.getDate();
                inscripcion.setFechaInscripcion(fechaInscripcion);

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> selectAlumno;
    private javax.swing.JComboBox<String> selectGrado;
    // End of variables declaration//GEN-END:variables
}
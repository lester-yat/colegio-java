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
            String item = alumno.getId()+ " - " + alumno.getNombre() + " " + alumno.getApellido();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Creacion de Inscipcion");

        jLabel2.setText("ID Alumno");

        jLabel3.setText("ID Grado");

        jLabel4.setText("Fecha de Inscripcion");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(btnGuardar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(selectGrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ChooserInscripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(selectAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(btnCancelar)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selectAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(selectGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(ChooserInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(164, 164, 164)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (selectAlumno.getSelectedItem() != null && selectGrado.getSelectedItem() != null && ChooserInscripcion.getDate() != null) {
            try {
                Inscripcion inscripcion = new Inscripcion();

                // Obtener el ID del Alumno a partir de la selección
                String alumnoSeleccionado = (String) selectAlumno.getSelectedItem();
                int idAlumno = Integer.parseInt(alumnoSeleccionado.split(" - ")[0]); // Extraer ID
                inscripcion.setAlumnoId(idAlumno);

                // Obtener el ID del Grado a partir de la selección
                String gradoSeleccionado = (String) selectGrado.getSelectedItem();
                int idGrado = Integer.parseInt(gradoSeleccionado.split(" - ")[0]); // Extraer ID
                inscripcion.setGradoId(idGrado);

                // Obtener y asignar la fecha del JDateChooser
                Date fechaInscripcion = ChooserInscripcion.getDate();
                inscripcion.setFechaInscripcion(fechaInscripcion);

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> selectAlumno;
    private javax.swing.JComboBox<String> selectGrado;
    // End of variables declaration//GEN-END:variables
}

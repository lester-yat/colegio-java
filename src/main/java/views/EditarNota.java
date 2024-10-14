package views;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Alumno;
import models.Curso;
import models.Nota;
import models.NotaDAO;

public class EditarNota extends javax.swing.JFrame {

    Nota nota = new Nota();
    NotaDAO notaDAO = new NotaDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    private int notaId;
    private int alumnoId;
    private int cursoId;
    private Map<Integer, String> alumnoMap = new HashMap<>();
    private Map<Integer, String> cursoMap = new HashMap<>();
    
    public EditarNota() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public EditarNota(int notaId) {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarAlumnos();
        cargarCursos();
        this.notaId = notaId;
        
        Nota nota = notaDAO.consultarDatos(notaId);

        if (nota != null) {
            txtNombre.setText(nota.getNombre());
            txtCalificacion.setText(String.format(Locale.US, "%.2f", nota.getCalificacion()));
            txtFechaRegistro.setDate(nota.getFechaRegistro());
            
            Integer alumnoID = nota.getAlumnoID();
            if (alumnoID != null) {
                String alumnoNombre = alumnoMap.get(alumnoID);
                if (alumnoNombre != null) {
                    selectAlumno.setSelectedItem(alumnoNombre);
                }
            }
            
            Integer cursoID = nota.getCursoID();
            if (cursoID != null) {
                String cursoNombre = cursoMap.get(cursoID);
                if (cursoNombre != null) {
                    selectCurso.setSelectedItem(cursoNombre);
                }
            }
        } else {
            System.out.println("No se encontró ningún nota con el ID: " + notaId);
        }
    }

    public void cargarAlumnos(){
        List<Alumno> alumnos = notaDAO.listarAlumnos();
        selectAlumno.removeAllItems();
        for (Alumno alumno : alumnos) {
            alumnoMap.put(alumno.getId(), alumno.getNombre()+" "+alumno.getApellido());
            selectAlumno.addItem(alumno.getNombre()+" "+alumno.getApellido());
        }
    }
    
    public void cargarCursos(){
        List<Curso> cursos = notaDAO.listarCursos();
        selectCurso.removeAllItems();
        for (Curso curso : cursos) {
            cursoMap.put(curso.getId(), curso.getNombre());
            selectCurso.addItem(curso.getNombre());
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
        txtCalificacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        selectAlumno = new javax.swing.JComboBox<>();
        selectCurso = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFechaRegistro = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setText("Edicion de Nota");

        jLabel2.setText("Nombre");

        jLabel3.setText("Calificacion");

        jLabel4.setText("Fecha de Registro");

        jLabel6.setText("Alumno");

        jLabel7.setText("Curso");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(selectCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(selectAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(selectAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(selectCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnCancelar))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaNotas vistaLista = new ListaNotas();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (!"".equals(txtNombre.getText()) && !"".equals(txtCalificacion.getText()) && 
            !"".equals(txtFechaRegistro.getDate()) && selectAlumno.getSelectedItem() != null && 
            selectCurso.getSelectedItem() != null) {
            try {
                nota.setNombre(txtNombre.getText());
                nota.setCalificacion(Float.parseFloat(txtCalificacion.getText()));
                nota.setFechaRegistro(txtFechaRegistro.getDate());
                nota.setId(notaId);
                
                String selectedAlumnoNombre = (String) selectAlumno.getSelectedItem();
                Integer alumnoId = null;
                for (Map.Entry<Integer, String> entry : alumnoMap.entrySet()) {
                    if (entry.getValue().equals(selectedAlumnoNombre)) {
                        alumnoId = entry.getKey();
                        break;
                    }
                }
                
                String selectedCursoNombre = (String) selectCurso.getSelectedItem();
                Integer cursoId = null;
                for (Map.Entry<Integer, String> entry : cursoMap.entrySet()) {
                    if (entry.getValue().equals(selectedCursoNombre)) {
                        cursoId = entry.getKey();
                        break;
                    }
                }

                if (alumnoId != null && cursoId != null) {
                    nota.setAlumnoID(alumnoId);
                    nota.setCursoID(cursoId);
                    notaDAO.editarNota(nota);
                    JOptionPane.showMessageDialog(null, "Nota actualizada exitosamente.");
                    ListaNotas vistaLista = new ListaNotas();
                    vistaLista.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Grado seleccionado no encontrado.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error en el formato de los datos numéricos: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar la sección: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos están vacíos.");
        }
        
        try {
            float calificacion = Float.parseFloat(txtCalificacion.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La calificacion debe ser un número entero o con decimales.");
        } 
    }//GEN-LAST:event_btnActualizarActionPerformed
    
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
            java.util.logging.Logger.getLogger(EditarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarNota().setVisible(true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> selectAlumno;
    private javax.swing.JComboBox<String> selectCurso;
    private javax.swing.JTextField txtCalificacion;
    private com.toedter.calendar.JDateChooser txtFechaRegistro;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

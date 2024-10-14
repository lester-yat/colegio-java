package views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Curso;
import models.CursoDAO;
import models.Grado;
import models.Profesor;
import models.Seccion;

public class EditarCurso extends javax.swing.JFrame {
    
    Curso curso = new Curso();
    CursoDAO cursoDAO = new CursoDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    private int profesorId;
    private int cursoId;
    private int gradoId;
    private int seccionId;
    private Map<Integer, String> profesorMap = new HashMap<>();
    private Map<Integer, String> gradoMap = new HashMap<>();
    private Map<Integer, String> seccionMap = new HashMap<>();
    
    public EditarCurso() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void cargarProfesores() {
        List<Profesor> profesores = cursoDAO.listarProfesores();
        profesorMap.clear();

        for (Profesor profesor : profesores) {
            profesorMap.put(profesor.getId(), profesor.getNombre());
            selectProfesor.addItem(profesor.getNombre());
        }
    }
    
    public void cargarGrados(int profesorId) {
        List<Grado> grados = cursoDAO.listarGrados(profesorId);
        selectGrado.removeAllItems();
        for (Grado grado : grados) {
            gradoMap.put(grado.getId(), grado.getNombre());
            selectGrado.addItem(grado.getNombre());
        }
    }
    
    public void cargarSecciones(int gradoId, int profesorId){
        List<Seccion> secciones = cursoDAO.listarSecciones(gradoId, profesorId);
        selectSeccion.removeAllItems();
        for (Seccion seccion : secciones) {
            seccionMap.put(seccion.getId(), seccion.getNombre());
            selectSeccion.addItem(seccion.getNombre());
        }
    }
    
    public EditarCurso(int cursoId) {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarProfesores();
        this.cursoId = cursoId;
        
        Curso curso = cursoDAO.consultarDatos(cursoId);

        if (curso != null) {
            txtNombre.setText(curso.getNombre());
            txtDescripcion.setText(curso.getDescripcion());
            txtNivel.setText(curso.getNivel());
            
            Integer profesorID = curso.getProfesorId();
            if (profesorID != null) {
                String profesorNombre = profesorMap.get(profesorID);
                if (profesorNombre != null) {
                    selectProfesor.setSelectedItem(profesorNombre);
                }
            }
            
            Integer gradoID = curso.getGradoId();
            if (gradoID != null) {
                String gradoNombre = gradoMap.get(gradoID);
                if (gradoNombre != null) {
                    selectGrado.setSelectedItem(gradoNombre);
                }
            }
            
            Integer seccionID = curso.getSeccionId();
            if (seccionID != null) {
                String seccionNombre = seccionMap.get(seccionID);
                if (seccionNombre != null) {
                    selectSeccion.setSelectedItem(seccionNombre);
                }
            }
            
        } else {
            System.out.println("No se encontró ningún curso con el ID: " + cursoId);
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
        txtDescripcion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNivel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        selectProfesor = new javax.swing.JComboBox<>();
        selectGrado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        selectSeccion = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setText("Edicion de Curso");

        jLabel2.setText("Nombre");

        jLabel3.setText("Descripcion");

        jLabel4.setText("Nivel");

        jLabel6.setText("Profesor");

        selectProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectProfesorActionPerformed(evt);
            }
        });

        selectGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectGradoActionPerformed(evt);
            }
        });

        jLabel7.setText("Grado");

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

        jLabel8.setText("Seccion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(selectSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(selectGrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(selectProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(195, 195, 195)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(209, 209, 209)
                            .addComponent(btnActualizar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar))))
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
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(selectProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(selectGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(selectSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaCursos vistaLista = new ListaCursos();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (!"".equals(txtNombre.getText()) && !"".equals(txtDescripcion.getText()) && 
            !"".equals(txtNivel.getText()) && selectProfesor.getSelectedItem() != null && 
            selectGrado.getSelectedItem() != null && selectSeccion.getSelectedItem() != null) {
            try {
                curso.setNombre(txtNombre.getText());
                curso.setDescripcion(txtDescripcion.getText());
                curso.setNivel(txtNivel.getText());
                curso.setId(cursoId);
                
                String selectedProfesorNombre = (String) selectProfesor.getSelectedItem();
                Integer profesorId = null;
                for (Map.Entry<Integer, String> entry : profesorMap.entrySet()) {
                    if (entry.getValue().equals(selectedProfesorNombre)) {
                        profesorId = entry.getKey();
                        break;
                    }
                }
                
                String selectedGradoNombre = (String) selectGrado.getSelectedItem();
                Integer gradoId = null;
                for (Map.Entry<Integer, String> entry : gradoMap.entrySet()) {
                    if (entry.getValue().equals(selectedGradoNombre)) {
                        gradoId = entry.getKey();
                        break;
                    }
                }
                
                String selectedSeccionNombre = (String) selectSeccion.getSelectedItem();
                Integer seccionId = null;
                for (Map.Entry<Integer, String> entry : seccionMap.entrySet()) {
                    if (entry.getValue().equals(selectedSeccionNombre)) {
                        seccionId = entry.getKey();
                        break;
                    }
                }

                if (profesorId != null && gradoId != null && seccionId != null) {
                    curso.setProfesorId(profesorId);
                    curso.setGradoId(gradoId);
                    curso.setSeccionId(seccionId);
                    cursoDAO.editarCurso(curso);
                    JOptionPane.showMessageDialog(null, "Curso actualizada exitosamente.");
                    ListaCursos vistaLista = new ListaCursos();
                    vistaLista.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Grado seleccionado no encontrado.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error en el formato de los datos numéricos: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar el curso: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos están vacíos.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void selectProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectProfesorActionPerformed
        List<Profesor> profesores = cursoDAO.listarProfesores();
        for (Profesor profesor : profesores) {
            if (profesor.getNombre().equals(selectProfesor.getSelectedItem())) {
                profesorId = profesor.getId();
                cargarGrados(profesorId);
                break;
            }
        }
    }//GEN-LAST:event_selectProfesorActionPerformed

    private void selectGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectGradoActionPerformed
        List<Grado> grados = cursoDAO.listarGrados();
        for (Grado grado : grados) {
            if (grado.getNombre().equals(selectGrado.getSelectedItem())) {
                gradoId = grado.getId();
                cargarSecciones(gradoId, profesorId);
                break;
            }
        }
    }//GEN-LAST:event_selectGradoActionPerformed

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
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarCurso().setVisible(true);
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> selectGrado;
    private javax.swing.JComboBox<String> selectProfesor;
    private javax.swing.JComboBox<String> selectSeccion;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

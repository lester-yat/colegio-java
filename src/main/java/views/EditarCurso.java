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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edicion de Curso");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 202, 36));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 240, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripcion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        txtDescripcion.setBackground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setBorder(null);
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 240, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nivel");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        txtNivel.setBackground(new java.awt.Color(0, 0, 0));
        txtNivel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNivel.setForeground(new java.awt.Color(255, 255, 255));
        txtNivel.setBorder(null);
        jPanel1.add(txtNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 240, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Profesor");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        selectProfesor.setBackground(new java.awt.Color(0, 0, 0));
        selectProfesor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        selectProfesor.setForeground(new java.awt.Color(255, 255, 255));
        selectProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectProfesorActionPerformed(evt);
            }
        });
        jPanel1.add(selectProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 240, -1));

        selectGrado.setBackground(new java.awt.Color(0, 0, 0));
        selectGrado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        selectGrado.setForeground(new java.awt.Color(255, 255, 255));
        selectGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectGradoActionPerformed(evt);
            }
        });
        jPanel1.add(selectGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 240, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Grado");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(0, 0, 0));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, -1, -1));

        selectSeccion.setBackground(new java.awt.Color(0, 0, 0));
        selectSeccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        selectSeccion.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(selectSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 240, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Seccion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 250, 10));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 250, 10));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 250, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 630, 510));

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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> selectGrado;
    private javax.swing.JComboBox<String> selectProfesor;
    private javax.swing.JComboBox<String> selectSeccion;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

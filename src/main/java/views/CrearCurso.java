package views;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Curso;
import models.CursoDAO;
import models.Grado;
import models.Profesor;
import models.Seccion;

public class CrearCurso extends javax.swing.JFrame {
    
    Curso curso = new Curso();
    CursoDAO cursoDAO = new CursoDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    public int profesorId, gradoId;
    
    public CrearCurso() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarProfesor();
    }
    
    public void cargarProfesor(){
        List<Profesor> profesores = cursoDAO.listarProfesores();
        for (int i = 0; i < profesores.size(); i++) {
            String nombre = profesores.get(i).getNombre()+" "+profesores.get(i).getApellido();
            selectProfesor.addItem(nombre);
        }
    }
    
    public void cargarGrados(int profesorId){
        List<Grado> grados = cursoDAO.listarGrados(profesorId);
        selectGrado.removeAllItems();
        for (int i = 0; i < grados.size(); i++) {
            String nombre = grados.get(i).getNombre();
            selectGrado.addItem(nombre);
        }
    }
    
    public void cargarSecciones(int gradoId, int profesorId){
        List<Seccion> secciones = cursoDAO.listarSecciones(gradoId, profesorId);
        selectSeccion.removeAllItems();
        for (int i = 0; i < secciones.size(); i++) {
            String nombre = secciones.get(i).getNombre();
            selectSeccion.addItem(nombre);
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
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        selectSeccion = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setText("Creacion de Curso");

        jLabel2.setText("Nombre");

        jLabel3.setText("Descripcion");

        jLabel4.setText("Nivel");

        jLabel6.setText("Profesor");

        selectProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectProfesorMouseClicked(evt);
            }
        });
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
                            .addComponent(btnGuardar)
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
                    .addComponent(btnGuardar)
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

    private void selectProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectProfesorActionPerformed
        List<Profesor> profesores = cursoDAO.listarProfesores();
        for (Profesor profesor : profesores) {
            if ((profesor.getNombre()+" "+profesor.getApellido()).equals(selectProfesor.getSelectedItem())) {
                profesorId = profesor.getId();
                cargarGrados(profesorId);
                break;
            }
        }
    }//GEN-LAST:event_selectProfesorActionPerformed

    private void selectProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectProfesorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_selectProfesorMouseClicked

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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!"".equals(txtNombre.getText()) && !"".equals(txtDescripcion.getText()) && 
            !"".equals(txtNivel.getText()) && !"".equals(selectProfesor.getSelectedItem()) && 
            !"".equals(selectGrado.getSelectedItem()) && !"".equals(selectSeccion.getSelectedItem())) {
            try {
                curso.setNombre(txtNombre.getText());
                curso.setDescripcion(txtDescripcion.getText());
                curso.setNivel(txtNivel.getText());
                
                List<Profesor> profesores = cursoDAO.listarProfesores();
                for (Profesor profesor : profesores) {
                    if ((profesor.getNombre()+" "+profesor.getApellido()).equals(selectProfesor.getSelectedItem())) {
                        curso.setProfesorId(profesor.getId());
                        break;
                    }
                }
                
                List<Grado> grados = cursoDAO.listarGrados();
                for (Grado grado : grados) {
                    if (grado.getNombre().equals(selectGrado.getSelectedItem())) {
                        curso.setGradoId(grado.getId());
                        break;
                    }
                }
                
                List<Seccion> secciones = cursoDAO.listarSecciones();
                for (Seccion seccion : secciones) {
                    if (seccion.getNombre().equals(selectSeccion.getSelectedItem())) {
                        curso.setSeccionId(seccion.getId());
                        break;
                    }
                }
                
                int idCurso = cursoDAO.guardarCurso(curso);
                if (idCurso == -1) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el curso.");
                    return;
                }
                
                JOptionPane.showMessageDialog(null, "Curso guardado exitosamente.");
                ListaCursos vistaLista = new ListaCursos();
                vistaLista.setVisible(true);
                dispose();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error en el formato de los datos numéricos: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el curso: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    
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
            java.util.logging.Logger.getLogger(CrearCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
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

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
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creacion de Curso");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 300, 36));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 191, -1, -1));

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 179, 250, 30));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripcion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 256, -1, -1));

        txtDescripcion.setBackground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 244, 250, 30));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nivel");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 324, -1, -1));

        txtNivel.setBackground(new java.awt.Color(0, 0, 0));
        txtNivel.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtNivel.setForeground(new java.awt.Color(255, 255, 255));
        txtNivel.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        jPanel1.add(txtNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 312, 250, 30));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Profesor");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 388, -1, -1));

        selectProfesor.setBackground(new java.awt.Color(255, 255, 255));
        selectProfesor.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        selectProfesor.setForeground(new java.awt.Color(0, 0, 0));
        selectProfesor.setBorder(null);
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
        jPanel1.add(selectProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 378, 250, 30));

        selectGrado.setBackground(new java.awt.Color(255, 255, 255));
        selectGrado.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        selectGrado.setForeground(new java.awt.Color(0, 0, 0));
        selectGrado.setBorder(null);
        selectGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectGradoActionPerformed(evt);
            }
        });
        jPanel1.add(selectGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 437, 250, 30));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Grado");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 447, -1, -1));

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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 540, 100, 40));

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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 530, 100, 40));

        selectSeccion.setBackground(new java.awt.Color(255, 255, 255));
        selectSeccion.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        selectSeccion.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(selectSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 496, 250, 30));

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Seccion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\samuel\\Desktop\\FRONT-CREATE\\colegio-java\\RECURSOS1\\MONSTER-GRADUATION.png")); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 320, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1112, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel5;
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

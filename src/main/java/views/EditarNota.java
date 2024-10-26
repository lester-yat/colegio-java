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
    
    public void cargarCursos(int idAlumno){
        List<Curso> cursos = notaDAO.cargarCursos(idAlumno);
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edicion de Nota");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 202, 36));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 230, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Calificacion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        txtCalificacion.setBackground(new java.awt.Color(0, 0, 0));
        txtCalificacion.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtCalificacion.setForeground(new java.awt.Color(255, 255, 255));
        txtCalificacion.setBorder(null);
        jPanel1.add(txtCalificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 230, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de Registro");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Alumno");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        selectAlumno.setBackground(new java.awt.Color(0, 0, 0));
        selectAlumno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        selectAlumno.setForeground(new java.awt.Color(255, 255, 255));
        selectAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAlumnoActionPerformed(evt);
            }
        });
        jPanel1.add(selectAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 250, -1));

        selectCurso.setBackground(new java.awt.Color(0, 0, 0));
        selectCurso.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        selectCurso.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(selectCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 250, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Curso");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(0, 0, 0));
        btnActualizar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, -1, -1));

        txtFechaRegistro.setBackground(new java.awt.Color(0, 0, 0));
        txtFechaRegistro.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 250, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 240, 10));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 240, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 494));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaNotas vistaLista = new ListaNotas();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       
       if (!"".equals(txtNombre.getText()) && !"".equals(txtCalificacion.getText()) && 
    txtFechaRegistro.getDate() != null && selectAlumno.getSelectedItem() != null && 
    selectCurso.getSelectedItem() != null) {
    try {
        nota.setNombre(txtNombre.getText());
        float calificacion = Float.parseFloat(txtCalificacion.getText());
        
        // Validar que la calificación esté entre 0 y 100
        if (calificacion < 0 || calificacion > 100) {
            JOptionPane.showMessageDialog(null, "La calificación debe estar entre 0 y 100.");
            return; // Salir del método si la calificación no es válida
        }

        nota.setCalificacion(calificacion);
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
            JOptionPane.showMessageDialog(null, "Alumno o curso seleccionado no encontrado.");
        }
    } catch (NumberFormatException e) {
        System.out.println("Error en el formato de los datos numéricos: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar la sección: " + e.getMessage());
    }
} else {
    JOptionPane.showMessageDialog(null, "Los campos están vacíos.");
}

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void selectAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAlumnoActionPerformed
        int idAlumno = 0;
        List<Alumno> alumnos = notaDAO.listarAlumnos();
            for (Alumno alumno : alumnos) {
                    if ((alumno.getNombre() + " " + alumno.getApellido()).equals(selectAlumno.getSelectedItem())) {
                        idAlumno = alumno.getId();
                        break;
                    }
                }
        cargarCursos(idAlumno);
    }//GEN-LAST:event_selectAlumnoActionPerformed
    
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> selectAlumno;
    private javax.swing.JComboBox<String> selectCurso;
    private javax.swing.JTextField txtCalificacion;
    private com.toedter.calendar.JDateChooser txtFechaRegistro;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

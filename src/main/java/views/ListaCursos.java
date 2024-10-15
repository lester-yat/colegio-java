package views;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Curso;
import models.CursoDAO;

public class ListaCursos extends javax.swing.JFrame {

    Curso cr = new Curso();
    CursoDAO cursoDAO = new CursoDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    private int idSeleccionado;
    
    public ListaCursos() {
        initComponents();
        this.setLocationRelativeTo(null);
        ListarCursos();
    }
    
    public void LimpiarTabla() {
//    modelo.setRowCount(0);
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }
    
    public void ListarCursos(){
        List<Curso> ListarCur = cursoDAO.listarCursos();
        modelo = (DefaultTableModel) tablaCursos.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < ListarCur.size(); i++) {
            ob[0] = ListarCur.get(i).getId();
            ob[1] = ListarCur.get(i).getNombre();
            ob[2] = ListarCur.get(i).getNivel();
            ob[3] = cursoDAO.columnaProfesores(ListarCur.get(i).getId());
            ob[4] = cursoDAO.columnaGrados(ListarCur.get(i).getId());
            ob[5] = cursoDAO.columnaSecciones(ListarCur.get(i).getId());
            modelo.addRow(ob);
        }
        tablaCursos.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        campoBuscar2 = new javax.swing.JTextField();
        btnBuscar2 = new javax.swing.JButton();
        btnCrear2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCursos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoBuscar2.setBackground(new java.awt.Color(0, 0, 0));
        campoBuscar2.setForeground(new java.awt.Color(255, 255, 255));
        campoBuscar2.setBorder(null);
        jPanel3.add(campoBuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 600, 30));

        btnBuscar2.setBackground(new java.awt.Color(0, 0, 0));
        btnBuscar2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar2.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar2.setText("Buscar");
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 200, 40));

        btnCrear2.setBackground(new java.awt.Color(0, 0, 0));
        btnCrear2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrear2.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear2.setText("Nuevo Curso");
        btnCrear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrear2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnCrear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 200, 40));

        tablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Nivel", "Profesor", "Grado", "Seccion"
            }
        ));
        tablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCursosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCursos);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 250, 830, 260));

        btnEditar.setBackground(new java.awt.Color(0, 0, 0));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 200, 40));

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 200, 40));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listado de Cursos");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(0, 0, 0));
        btnRegresar.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("←");
        btnRegresar.setBorder(null);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 600, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 899, 584));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrear2ActionPerformed
        CrearCurso vistaCrear = new CrearCurso();
        vistaCrear.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCrear2ActionPerformed

    private void tablaCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCursosMouseClicked
        int fila = tablaCursos.rowAtPoint(evt.getPoint());
        idSeleccionado = (int) tablaCursos.getValueAt(fila, 0);
    }//GEN-LAST:event_tablaCursosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (idSeleccionado > 0) {
            EditarCurso vistaEditar = new EditarCurso(idSeleccionado);
            vistaEditar.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un curso.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (idSeleccionado > 0) {
                CursoDAO cursoDAO = new CursoDAO();
//                if (cursoDAO.tieneDependencias(idSeleccionado)) {
//                    JOptionPane.showMessageDialog(this, "No se puede eliminar. El curso tiene notas o alumnos relacionados.");
//                } else {
                    int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
                    if (pregunta == 0) {
                        cursoDAO.eliminarCurso(idSeleccionado);
                        LimpiarTabla();
                        ListarCursos();
                    }
//                }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un curso para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Inicio inicio = new Inicio();
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar2ActionPerformed
    
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
            java.util.logging.Logger.getLogger(ListaCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaCursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnCrear2;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JTextField campoBuscar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tablaCursos;
    // End of variables declaration//GEN-END:variables
}

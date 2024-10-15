package views;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Conexion;
import models.Padre;
import models.PadreDAO;

public class ListadoPadre extends javax.swing.JFrame {
    
    Conexion con = new Conexion();
  
    
    public ListadoPadre() {
        initComponents();
        cargarTablaPadres();  // Cargar los padres al iniciar el formulario
    }

public void cargarTablaPadres() {
    PadreDAO padreDAO = new PadreDAO();
    List<Padre> listaPadres = padreDAO.listarPadres();
    
    DefaultTableModel modeloTabla = (DefaultTableModel) tablaPadre.getModel();
    modeloTabla.setRowCount(0);  // Limpiar la tabla antes de cargar nuevos datos
    
    for (Padre padre : listaPadres) {
        Object[] fila = {
            padre.getId(),
            padre.getNombre(),
            padre.getApellido(),
            padre.getEdad(),
            padre.getIdentificacion(),
            padre.getTelefono(),
            padre.getParentesco()
        };
        modeloTabla.addRow(fila);
    }
}


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        campoBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPadre = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrear.setBackground(new java.awt.Color(0, 0, 0));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setText("Nuevo Padre");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 200, 40));

        btnEditar.setBackground(new java.awt.Color(0, 0, 0));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 200, 40));

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 200, 40));

        btnBuscar.setBackground(new java.awt.Color(0, 0, 0));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 200, 40));

        campoBuscar.setBackground(new java.awt.Color(0, 0, 0));
        campoBuscar.setForeground(new java.awt.Color(255, 255, 255));
        campoBuscar.setBorder(null);
        jPanel2.add(campoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 670, 30));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listado Padres");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

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
        jPanel2.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 40));

        tablaPadre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombres", "Apellidos", "Edad", "Identificacion(DPI)", "Telefono", "Parentesco"
            }
        ));
        tablaPadre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPadreMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPadre);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 892, 190));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 670, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 980, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaPadreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPadreMouseClicked

    }//GEN-LAST:event_tablaPadreMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Inicio inicio = new Inicio();
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tablaPadre.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un padre de la lista para eliminar.");
        } else {
            int idPadre = (int) tablaPadre.getValueAt(filaSeleccionada, 0);

            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este registro?",
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                PadreDAO padreDAO = new PadreDAO();
                boolean eliminado = padreDAO.eliminarPadre(idPadre);

                if (eliminado) {
                    JOptionPane.showMessageDialog(this, "Padre eliminado correctamente.");
                    cargarTablaPadres();  // Refrescar la tabla después de eliminar
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el padre.");
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int filaSeleccionada = tablaPadre.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un padre de la lista para editar.");
        } else {
            int idPadreSeleccionado = (int) tablaPadre.getValueAt(filaSeleccionada, 0);  // Tomar el ID de la primera columna

            // Abrir el formulario de edición con el ID seleccionado
            dispose();
            EditarPadre vistaCrear = new EditarPadre( idPadreSeleccionado);
            vistaCrear.setVisible(true);

            // Refrescar la tabla después de cerrar el formulario EditarPadre
            cargarTablaPadres();
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        CrearPadre vistaCrear = new CrearPadre();
        vistaCrear.setVisible(true);

        dispose();
    }//GEN-LAST:event_btnCrearActionPerformed

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
            java.util.logging.Logger.getLogger(ListadoPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoPadre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaPadre;
    // End of variables declaration//GEN-END:variables
}

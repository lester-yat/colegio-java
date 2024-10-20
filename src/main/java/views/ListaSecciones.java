package views;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Grado;
import models.Seccion;
import models.SeccionDAO;

public class ListaSecciones extends javax.swing.JFrame {

    Seccion seccion = new Seccion();
    SeccionDAO seccionDAO = new SeccionDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    private int idSeleccionado;
    
      private TableRowSorter<DefaultTableModel> sorter;
    private boolean isFilterActive = false;
    
    public ListaSecciones() {
        this.setUndecorated(true);
        initComponents();
        ListarSecciones();
        this.setLocationRelativeTo(null);
        setResizable(false); 
        sorter = new TableRowSorter<>(modelo);
        tablaSecciones.setRowSorter(sorter);
        
        // Agregar listener al campoBuscar para filtrar mientras se escribe
        campoBuscar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (isFilterActive) {
                    filtrarTabla();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (isFilterActive) {
                    filtrarTabla();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (isFilterActive) {
                    filtrarTabla();
                }
            }
        });
    }
    
    public void LimpiarTabla() {
//    modelo.setRowCount(0);
    for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }
    
    public void ListarSecciones() {
        List<Seccion> secciones = seccionDAO.listarSecciones();
        List<Grado> grados = seccionDAO.listarGrados();
        
        Map<Integer, String> gradoMap = new HashMap<>();
        for (Grado grado : grados) {
            gradoMap.put(grado.getId(), grado.getNombre());
        }
        
        modelo = (DefaultTableModel) tablaSecciones.getModel();
        modelo.setRowCount(0);
        
        for (Seccion seccion : secciones) {
            Object[] ob = new Object[5];
            ob[0] = seccion.getId();
            ob[1] = seccion.getNombre();
            ob[2] = seccion.getHorarioInicio();
            ob[3] = seccion.getHorarioFinal();
            ob[4] = gradoMap.get(seccion.getGrado());

            modelo.addRow(ob);
        }
        
        tablaSecciones.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        campoBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSecciones = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        btnCrear.setBackground(new java.awt.Color(0, 0, 0));
        btnCrear.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setText("Nueva Seccion");
        btnCrear.setToolTipText("");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 240, -1));

        btnEditar.setBackground(new java.awt.Color(0, 0, 0));
        btnEditar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 200, 40));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listado de Secciones");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 200, -1));

        campoBuscar.setBackground(new java.awt.Color(0, 0, 0));
        campoBuscar.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        campoBuscar.setForeground(new java.awt.Color(255, 255, 255));
        campoBuscar.setBorder(null);
        jPanel1.add(campoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 670, 40));

        btnBuscar.setBackground(new java.awt.Color(0, 0, 0));
        btnBuscar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 240, 40));

        tablaSecciones.setBackground(new java.awt.Color(255, 255, 255));
        tablaSecciones.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        tablaSecciones.setForeground(new java.awt.Color(0, 0, 0));
        tablaSecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Hora de Inicio", "Hora Final", "Grado"
            }
        ));
        tablaSecciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSeccionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaSecciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 970, 360));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 670, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        CrearSeccion vistaCrear = new CrearSeccion();
        vistaCrear.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void tablaSeccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSeccionesMouseClicked
        int fila = tablaSecciones.rowAtPoint(evt.getPoint());
        idSeleccionado = (int) tablaSecciones.getValueAt(fila, 0);
    }//GEN-LAST:event_tablaSeccionesMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (idSeleccionado > 0) {
            EditarSeccion vistaEditar = new EditarSeccion(idSeleccionado);
            vistaEditar.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una seccion.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (idSeleccionado > 0) {
            SeccionDAO seccionDAO = new SeccionDAO();
//            if (seccionDAO.tieneDependencias(idSeleccionado)) {
//                JOptionPane.showMessageDialog(this, "No se puede eliminar. La sección está asignada a uno o más alumnos.");
//            } else {
                int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
                if (pregunta == 0) {
                    seccionDAO.eliminarSeccion(idSeleccionado);
                    LimpiarTabla();
                    ListarSecciones();
                }
//            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una sección para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Inicio inicio = new Inicio();
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
         isFilterActive = true; // Activar el filtro tras hacer clic en el botón Buscar
        filtrarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void filtrarTabla() {
        String query = campoBuscar.getText();
        if (query.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
        }
    }
    
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
            java.util.logging.Logger.getLogger(ListaSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaSecciones().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaSecciones;
    // End of variables declaration//GEN-END:variables
}

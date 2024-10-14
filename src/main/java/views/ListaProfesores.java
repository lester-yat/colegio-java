package views;

import java.awt.Event;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Profesor;
import models.ProfesoresDAO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;




public class ListaProfesores extends javax.swing.JFrame {
    
    Profesor pr = new Profesor();
    ProfesoresDAO profesor = new ProfesoresDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    private int idSeleccionado;
    
    // busqueda 
    
     private TableRowSorter<DefaultTableModel> sorter;
    private boolean isFilterActive = false;
    
    public ListaProfesores() {
        this.setUndecorated(true);
        initComponents();
        ListarProfesor();
        this.setLocationRelativeTo(null);
                    
            setResizable(false); 
            
        sorter = new TableRowSorter<>(modelo);
        tablaProfesores.setRowSorter(sorter);
        
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
    
    public void ListarProfesor(){
        List<Profesor> ListarProf = profesor.listarProfesores();
        modelo = (DefaultTableModel) tablaProfesores.getModel();
        Object[] ob = new Object[9];
        for (int i = 0; i < ListarProf.size(); i++) {
            ob[0] = ListarProf.get(i).getId();
            ob[1] = ListarProf.get(i).getIdentificacion();
            ob[2] = ListarProf.get(i).getNombre() + " " + ListarProf.get(i).getApellido();
            ob[3] = profesor.columnaGrados(ListarProf.get(i).getId());
            ob[4] = profesor.columnaSecciones(ListarProf.get(i).getId());
            ob[5] = ListarProf.get(i).getEspecialidad();
            ob[6] = ListarProf.get(i).getEstado_contrato();
            ob[7] = ListarProf.get(i).getFecha_contratacion();
            ob[8] = ListarProf.get(i).getFecha_terminacion_contrato();
            modelo.addRow(ob);
        }
        tablaProfesores.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        campoBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProfesores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return2.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listado de Profesores");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, 50));

        btnCrear.setBackground(new java.awt.Color(255, 255, 255));
        btnCrear.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(0, 0, 0));
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/teachers.png"))); // NOI18N
        btnCrear.setText("Nuevo Profesor");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 60));

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 220, 60));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, 220, 60));

        campoBuscar.setBackground(new java.awt.Color(255, 255, 255));
        campoBuscar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        campoBuscar.setForeground(new java.awt.Color(0, 0, 0));
        campoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscarActionPerformed(evt);
            }
        });
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBuscarKeyTyped(evt);
            }
        });
        getContentPane().add(campoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 770, 50));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seracher.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 220, 60));

        tablaProfesores.setBackground(new java.awt.Color(204, 204, 204));
        tablaProfesores.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monospaced", 1, 14)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monospaced", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        tablaProfesores.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        tablaProfesores.setForeground(new java.awt.Color(0, 0, 0));
        tablaProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Identificacion", "Nombre", "Grado", "Seccion", "Especialidad", "Estado Contrato", "Fecha Contratacion", "Fecha Terminacion"
            }
        ));
        tablaProfesores.setSelectionForeground(new java.awt.Color(153, 0, 153));
        tablaProfesores.getTableHeader().setReorderingAllowed(false);
        tablaProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProfesoresMouseClicked(evt);
            }
        });
        tablaProfesores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tablaProfesoresKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProfesores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 1030, 290));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/69.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        CrearProfesores vistaCrear = new CrearProfesores();
        vistaCrear.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (idSeleccionado > 0) {
            ProfesoresDAO profesorDAO = new ProfesoresDAO();
//            if (profesorDAO.tieneDependencias(idSeleccionado)) {
//                JOptionPane.showMessageDialog(this, "No se puede eliminar. El profesor está asignado a uno o más cursos.");
//            } else {
                int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
                if (pregunta == 0) {
                    profesorDAO.eliminarProfesor(idSeleccionado);
                    LimpiarTabla();
                    ListarProfesor();
                }
//            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un profesor para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaProfesoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProfesoresMouseClicked
        int fila = tablaProfesores.rowAtPoint(evt.getPoint());
        idSeleccionado = (int) tablaProfesores.getValueAt(fila, 0);
    }//GEN-LAST:event_tablaProfesoresMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (idSeleccionado > 0) {
            EditarProfesor vistaEditar = new EditarProfesor(idSeleccionado);
            vistaEditar.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un profesor.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

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
            sorter.setRowFilter(null); // Resetea el filtro si no hay texto
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
        }
    }

    private void campoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscarActionPerformed

    private void campoBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyTyped
        // TODO add your handling code here:
        
     
    }//GEN-LAST:event_campoBuscarKeyTyped

    private void tablaProfesoresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaProfesoresKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaProfesoresKeyTyped
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaProfesores().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProfesores;
    // End of variables declaration//GEN-END:variables
}

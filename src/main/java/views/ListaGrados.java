package views;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Grado;
import models.GradoDAO;

public class ListaGrados extends javax.swing.JFrame {
    
    Grado gr = new Grado();
    GradoDAO grado = new GradoDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    private int idSeleccionado;

    public ListaGrados() {
        this.setUndecorated(true);
        initComponents();
        ListarGrados();
        this.setLocationRelativeTo(null);
    }

    public void LimpiarTabla() {
//    modelo.setRowCount(0);
    for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }
    
    public void ListarGrados(){
        List<Grado> ListarGrad = grado.listarGrados();
        modelo = (DefaultTableModel) tablaGrados.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < ListarGrad.size(); i++) {
            ob[0] = ListarGrad.get(i).getId();
            ob[1] = ListarGrad.get(i).getNombre();
            ob[2] = ListarGrad.get(i).getSalon();
            ob[3] = ListarGrad.get(i).getNivel();
            ob[4] = ListarGrad.get(i).getAnio();
            ob[5] = ListarGrad.get(i).getJornada();
            ob[6] = ListarGrad.get(i).getCantidadMaxEstudiantes();
            ob[7] = grado.consultarSeccion(ListarGrad.get(i).getId());
            modelo.addRow(ob);
        }
        tablaGrados.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        campoBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGrados = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscar.setText("Buscar");

        btnCrear.setText("Nuevo Grado");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        tablaGrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Salon", "Nivel", "Año", "Jornada", "Cantidad Estudiantes", "Seccion"
            }
        ));
        tablaGrados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGradosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGrados);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setText("Listado de Grados");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(256, 256, 256))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addComponent(jLabel1))
                        .addGap(481, 481, 481))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        CrearGrado vistaCrear = new CrearGrado();
        vistaCrear.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void tablaGradosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGradosMouseClicked
        int fila = tablaGrados.rowAtPoint(evt.getPoint());
        idSeleccionado = (int) tablaGrados.getValueAt(fila, 0);
    }//GEN-LAST:event_tablaGradosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (idSeleccionado > 0) {
            EditarGrado vistaEditar = new EditarGrado(idSeleccionado);
            vistaEditar.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un profesor.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (idSeleccionado > 0) {
            GradoDAO gradoDAO = new GradoDAO();
//            if (gradoDAO.tieneDependencias(idSeleccionado)) {
//                JOptionPane.showMessageDialog(this, "No se puede eliminar. El grado tiene secciones relacionadas.");
//            } else {
                int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
                if (pregunta == 0) {
                    gradoDAO.eliminarGrado(idSeleccionado);
                    LimpiarTabla();
                    ListarGrados();
                }
//            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un grado para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Inicio inicio = new Inicio();
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaGrados().setVisible(true);
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
    private javax.swing.JTable tablaGrados;
    // End of variables declaration//GEN-END:variables
}

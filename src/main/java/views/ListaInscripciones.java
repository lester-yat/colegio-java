package views;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Grado;
import models.GradoDAO;
import models.Inscripcion;
import models.InscripcionDAO;

public class ListaInscripciones extends javax.swing.JFrame {

    public ListaInscripciones() {
        this.setUndecorated(true);
        initComponents();
        cargarInscripciones(); // Cargar inscripciones al abrir el formulario
        this.setLocationRelativeTo(null);
    }

    private void cargarInscripciones() {
        InscripcionDAO inscripcionDAO = new InscripcionDAO();
        List<Inscripcion> listaInscripciones = inscripcionDAO.listarInscripciones();

        // Obtener el modelo actual de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tablaInscripcion.getModel();
        modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

        // Agregar cada inscripción al modelo de la tabla
        for (Inscripcion inscripcion : listaInscripciones) {
            Object[] fila = {
                inscripcion.getId(),
                inscripcion.getAlumnoId(),
                inscripcion.getNombreAlumno(), // Nombre del alumno
                inscripcion.getGradoId(),
                inscripcion.getFechaInscripcion(),
                inscripcion.getNumeroCuenta(), // Mostrar nuevo campo
                inscripcion.getMonto(), // Mostrar nuevo campo
                inscripcion.getEstado() // Mostrar nuevo campo    
            };

            // Imprimir los datos en consola para confirmar que están bien
            System.out.println("Datos a agregar en la tabla: " + inscripcion.getNombreAlumno());

            modelo.addRow(fila); // Agregar la fila al modelo de la tabla
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        campoBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInscripcion = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoBuscar.setBackground(new java.awt.Color(0, 0, 0));
        campoBuscar.setForeground(new java.awt.Color(255, 255, 255));
        campoBuscar.setBorder(null);
        jPanel1.add(campoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 640, 40));

        btnBuscar.setBackground(new java.awt.Color(0, 0, 0));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 200, 50));

        btnCrear.setBackground(new java.awt.Color(0, 0, 0));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setText("Nueva Inscripcion");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 200, 50));

        tablaInscripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID alumno", "Nombre Alumno", "ID Grado", "Fecha", "No.Cuenta", "Monto", "Estado"
            }
        ));
        tablaInscripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInscripcionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaInscripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 860, 200));

        btnEditar.setBackground(new java.awt.Color(0, 0, 0));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 200, 50));

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 200, 50));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listado de Inscripciones");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

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
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 40));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 640, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        CrearInscripcion vistaCrear = new CrearInscripcion();
        vistaCrear.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void tablaInscripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInscripcionMouseClicked

    }//GEN-LAST:event_tablaInscripcionMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int filaSeleccionada = tablaInscripcion.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtener el ID de la inscripción seleccionada desde la tabla
            int idInscripcionSeleccionado = (int) tablaInscripcion.getValueAt(filaSeleccionada, 0); // Asegúrate de que el ID esté en la primera columna

            // Abrir el formulario de edición con el ID de la inscripción seleccionada
            EditarInscripcion editar = new EditarInscripcion(idInscripcionSeleccionado);
            editar.setVisible(true);

            // Agregar un listener para detectar cuando se cierre el formulario de edición
            editar.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    // Refrescar la tabla después de cerrar el formulario EditarInscripcion
                    cargarInscripciones(); // Este método debería recargar los datos de la tabla desde la base de datos
                }
            });

            // Cerrar la ventana actual de listar inscripciones
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una inscripción para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         // Verificar que haya una fila seleccionada
    int filaSeleccionada = tablaInscripcion.getSelectedRow();
    
    if (filaSeleccionada != -1) { // Si se seleccionó una fila
        // Obtener el ID de la inscripción desde la columna correspondiente (suponiendo que está en la primera columna)
        int idInscripcion = Integer.parseInt(tablaInscripcion.getValueAt(filaSeleccionada, 0).toString());

        // Confirmar si el usuario realmente quiere eliminar la inscripción
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar esta inscripción?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            // Llamar al método eliminarInscripcion
            InscripcionDAO inscripcionDAO = new InscripcionDAO();
            boolean eliminado = inscripcionDAO.eliminarInscripcion(idInscripcion);

            if (eliminado) {
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(null, "Inscripción eliminada exitosamente.");
                
                // Actualizar la tabla para reflejar los cambios
                cargarInscripciones();
            } else {
                // Mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "Error al eliminar la inscripción.");
            }
        }
    } else {
        // Mostrar un mensaje si no se seleccionó ninguna inscripción
        JOptionPane.showMessageDialog(null, "Selecciona una inscripción para eliminar.");
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
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaInscripciones().setVisible(true);
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
    private javax.swing.JTable tablaInscripcion;
    // End of variables declaration//GEN-END:variables
}

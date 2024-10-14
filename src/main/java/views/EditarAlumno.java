package views;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Alumno;
import models.AlumnoDAO;
import models.Grado;
import models.Padre;
import models.Seccion;

public class EditarAlumno extends javax.swing.JFrame {
    Alumno alumno = new Alumno();
    AlumnoDAO alumnoDAO = new AlumnoDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    private int alumnoId;
    private Map<Integer, String> padreMap = new HashMap<>();
    private Map<Integer, String> gradoMap = new HashMap<>();

    public EditarAlumno() {
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        initComponents();
        setResizable(false); 
    }
    
    public void cargarGrados(){
        List<Grado> grados = alumnoDAO.listarGrados();
        for (Grado grado : grados) {
            String nombre = grado.getNombre();
            int id = grado.getId(); 
            gradoMap.put(id, nombre);
            selectGrado.addItem(nombre);
        }
    }
    
    public void cargarPadres() {
        List<Padre> padres = alumnoDAO.listarPadres();
        padreMap.clear();

        for (Padre padre : padres) {
            padreMap.put(padre.getId(), padre.getNombre()+" "+padre.getApellido());
            selectPadre.addItem(padre.getNombre()+" "+padre.getApellido());
        }
    }
    
    public void ListarSecciones(int idGrado) {
        List<Seccion> secciones = alumnoDAO.listarSecciones(idGrado);
        
        modelo = (DefaultTableModel) tablaSecciones.getModel();
        modelo.setRowCount(0);
        
        for (Seccion seccion : secciones) {
            Object[] ob = new Object[4];
            ob[0] = seccion.getId();
            ob[1] = seccion.getNombre();
            ob[2] = seccion.getHorarioInicio();
            ob[3] = seccion.getHorarioFinal();
            modelo.addRow(ob);
        }
        tablaSecciones.setModel(modelo);
    }
    
    public List<Integer> obtenerIdsSeleccionadosSecciones() {
        int[] filasSeleccionadas = tablaSecciones.getSelectedRows();
        List<Integer> idsSeleccionados = new ArrayList<>();
        for (int fila : filasSeleccionadas) {
            int id = (int) tablaSecciones.getValueAt(fila, 0);
            idsSeleccionados.add(id);
        }
        return idsSeleccionados;
    }
    
    public EditarAlumno(int alumnoId) {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarGrados();
        cargarPadres();
        this.alumnoId = alumnoId;
        Alumno alumno = alumnoDAO.consultarDatos(alumnoId);

        if (alumno != null) {
            txtNombre.setText(alumno.getNombre());
            txtApellido.setText(alumno.getApellido());
            txtEdad.setText(String.valueOf(alumno.getEdad()));
            txtFechaResgistro.setDate(alumno.getFechaResgistro());
            
            Integer padreID = alumno.getPadre();
            if (padreID != null) {
                String padreNombre = padreMap.get(padreID);
                if (padreNombre != null) {
                    selectPadre.setSelectedItem(padreNombre);
                }
            }
            
            Integer gradoID = alumno.getGrado();
            if (gradoID != null) {
                String gradoNombre = gradoMap.get(gradoID);
                if (gradoNombre != null) {
                    selectGrado.setSelectedItem(gradoNombre);
                }
            }
        } else {
            System.out.println("No se encontró ningún alumno con el ID: " + alumnoId);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        selectPadre = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        selectGrado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSecciones = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtFechaResgistro = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Editar de Alumno");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombres");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 270, -1));

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txtApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 270, -1));

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Edad");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        txtEdad.setBackground(new java.awt.Color(255, 255, 255));
        txtEdad.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(0, 0, 0));
        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        getContentPane().add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 270, -1));

        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Padreo/Encargado");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        selectPadre.setBackground(new java.awt.Color(255, 255, 255));
        selectPadre.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        selectPadre.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(selectPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 280, -1));

        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Grado");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 150, -1));

        selectGrado.setBackground(new java.awt.Color(255, 255, 255));
        selectGrado.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        selectGrado.setForeground(new java.awt.Color(0, 0, 0));
        selectGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectGradoActionPerformed(evt);
            }
        });
        getContentPane().add(selectGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 270, -1));

        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fecha Registro");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calcelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, -1, -1));

        tablaSecciones.setBackground(new java.awt.Color(204, 204, 204));
        tablaSecciones.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        tablaSecciones.setForeground(new java.awt.Color(0, 0, 0));
        tablaSecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Hora Inicio", "Hora Final"
            }
        ));
        tablaSecciones.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(tablaSecciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 610, 190));

        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Secciones");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, -1, -1));
        getContentPane().add(txtFechaResgistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 270, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/70.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (!"".equals(txtNombre.getText()) && !"".equals(txtApellido.getText()) &&
            !"".equals(txtEdad.getText()) && !"".equals(selectPadre.getSelectedItem()) && !"".equals(selectGrado.getSelectedItem()) &&
            !"".equals(txtFechaResgistro.getDate())) {
            try {
                alumno.setId(alumnoId);
                alumno.setNombre(txtNombre.getText());
                alumno.setApellido(txtApellido.getText());
                alumno.setEdad(Integer.parseInt(txtEdad.getText()));
                alumno.setFechaResgistro( (Date) txtFechaResgistro.getCalendar().getTime());
                alumno.setPadre(1);
                
                List<Padre> padres = alumnoDAO.listarPadres();
                for (Padre padre : padres) {
                    if ((padre.getNombre()+" "+padre.getApellido()).equals(selectPadre.getSelectedItem())) {
                        alumno.setPadre(padre.getId());
                        break;
                    }
                }
                                
                List<Grado> grados = alumnoDAO.listarGrados();
                for (Grado grado : grados) {
                    if (grado.getNombre().equals(selectGrado.getSelectedItem())) {
                        alumno.setGrado(grado.getId());
                        break;
                    }
                }
                
                alumnoDAO.editarAlumno(alumno);

                List<Integer> listaIDSecciones = obtenerIdsSeleccionadosSecciones();

                if (!alumnoDAO.editarAlumSecc(alumnoId, listaIDSecciones)) {
                    JOptionPane.showMessageDialog(null, "Error al guardar las relaciones.");
                    return;
                }
                
                JOptionPane.showMessageDialog(null, "Alumno guardado exitosamente.");
                ListaAlumnos vistaLista = new ListaAlumnos();
                vistaLista.setVisible(true);
                dispose();
            } catch (NumberFormatException e) {
                System.out.println("Error en el formato de los datos numéricos: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar la seccion: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
        
        try {
            int edad = Integer.parseInt(txtEdad.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La edad debe ser un número entero.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaAlumnos vistaLista = new ListaAlumnos();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void selectGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectGradoActionPerformed
        int idGrado = 0;
        List<Grado> grados = alumnoDAO.listarGrados();
            for (Grado grado : grados) {
                    if (grado.getNombre().equals(selectGrado.getSelectedItem())) {
                        idGrado = grado.getId();
                        break;
                    }
                }
        ListarSecciones(idGrado);
    }//GEN-LAST:event_selectGradoActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

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
            java.util.logging.Logger.getLogger(EditarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> selectGrado;
    private javax.swing.JComboBox<String> selectPadre;
    private javax.swing.JTable tablaSecciones;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEdad;
    private com.toedter.calendar.JDateChooser txtFechaResgistro;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

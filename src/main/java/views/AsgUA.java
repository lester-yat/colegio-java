/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Alumno;
import models.AlumnoDAO;
import models.Conexion;
import models.Seguridad;
import models.Usuario;
import models.UsuarioDAO;

/**
 *
 * @author Asus
 */
public class AsgUA extends javax.swing.JFrame {

Conexion con = new Conexion();


    public AsgUA() {
        initComponents();
        cargarTablaAlumnos();
    }
    
    
      public void cargarTablaAlumnos() {
    AlumnoDAO alumnoDAO = new AlumnoDAO();
    List<Alumno> listarAlumnos = alumnoDAO.listarAlumnos();
    
    DefaultTableModel modeloTabla = (DefaultTableModel) Alumnos.getModel();
    modeloTabla.setRowCount(0);  // Limpiar la tabla antes de cargar nuevos datos
    
    for (Alumno alumno : listarAlumnos) {
        // Verificar si el padre ya tiene un usuario asignado
        if (!alumnoDAO.tieneUsuario(alumno.getId())) {
            Object[] fila = {
                    alumno.getId(),
                    alumno.getNombre(),
                    alumno.getApellido(),
                    alumno.getGrado()
            };
            modeloTabla.addRow(fila);
        }
    }
}

   
   
       public List<Integer> obtenerIdsSeleccionadosPadre() {
        int[] filasSeleccionadas = Alumnos.getSelectedRows();
        List<Integer> idsSeleccionados = new ArrayList<>();
        for (int fila : filasSeleccionadas) {
            int id = (int) Alumnos.getValueAt(fila, 0);
            idsSeleccionados.add(id);
        }
        System.out.println("IDs seleccionados en Padres: " + idsSeleccionados);
        return idsSeleccionados;
    }
    
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        asig = new javax.swing.JButton();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Alumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        regresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asig.setBackground(new java.awt.Color(0, 0, 0));
        asig.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        asig.setForeground(new java.awt.Color(255, 255, 255));
        asig.setText("Asignar");
        asig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asigActionPerformed(evt);
            }
        });
        jPanel1.add(asig, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, -1));

        user.setBackground(new java.awt.Color(0, 0, 0));
        user.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setBorder(null);
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 105, 240, -1));

        pass.setBackground(new java.awt.Color(0, 0, 0));
        pass.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setBorder(null);
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 240, -1));

        Alumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Grado"
            }
        ));
        jScrollPane1.setViewportView(Alumnos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 678, 261));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 143, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contarseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 157, -1));

        regresar.setBackground(new java.awt.Color(0, 0, 0));
        regresar.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        regresar.setForeground(new java.awt.Color(255, 255, 255));
        regresar.setText("←");
        regresar.setBorder(null);
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        jPanel1.add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 86, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Asignar Usuario al Alumno");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 230, 20));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 230, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void asigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asigActionPerformed
        // TODO add your handling code here:
        
            String usuario = user.getText();
    String contrasenia = pass.getText();

    // Validar que los campos no estén vacíos
    if (usuario.isEmpty() || contrasenia.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El usuario y la contraseña no deben estar vacíos");
        return;
    }

    // Obtener el ID del alumno seleccionado en la tabla de alumnos
    int filaSeleccionada = Alumnos.getSelectedRow();
    if (filaSeleccionada < 0) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un alumno en la tabla de alumnos");
        return;
    }

    // Obtener el ID del alumno seleccionado
    int alumnoId = (int) Alumnos.getValueAt(filaSeleccionada, 0);

    // Encriptar la contraseña usando el método de la clase Seguridad
    String contraseniaEncriptada = Seguridad.encriptarSHA256(contrasenia);

    // Asignar rol por defecto "alumno"
    String rol = "alumno";

    // Crear el objeto Usuario con los datos obtenidos
    Usuario nuevoUsuario = new Usuario();
    nuevoUsuario.setNombreUsuario(usuario);
    nuevoUsuario.setContrasenia(contraseniaEncriptada);
    nuevoUsuario.setRol(rol);
    nuevoUsuario.setAlumnoId(alumnoId);

    // Insertar el nuevo usuario en la base de datos
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    try {
        usuarioDAO.insertarUsuario(nuevoUsuario);

        // Confirmación de la asignación
        JOptionPane.showMessageDialog(this, 
            "Usuario asignado correctamente.\nUsuario: " + usuario + "\nContraseña: " + contrasenia,
            "Asignación exitosa", 
            JOptionPane.INFORMATION_MESSAGE);
        
        // Limpiar campos de texto
        user.setText("");
        pass.setText("");

        // Recargar la tabla para reflejar los cambios (si aplicable)
        cargarTablaAlumnos();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al asignar usuario: " + e.getMessage());
    }
        
    }//GEN-LAST:event_asigActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        // TODO add your handling code here:
        ListU inicio = new ListU();
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarActionPerformed

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
            java.util.logging.Logger.getLogger(AsgUA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsgUA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsgUA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsgUA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsgUA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Alumnos;
    private javax.swing.JButton asig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField pass;
    private javax.swing.JButton regresar;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Nota;
import models.NotaDAO;
import models.Session;

/**
 *
 * @author Asus
 */
public class ViewStudents extends javax.swing.JFrame {
    
        

private int alumnoId;


    
    public ViewStudents(int alumnoId) {
        this.alumnoId = alumnoId;
    initComponents();
    listarNotasPorAlumnoId(alumnoId); 
    }
    
   public void listarNotasPorAlumnoId(int alumnoId) {
    NotaDAO notaDAO = new NotaDAO();
    List<Nota> listaNotas = notaDAO.obtenerNotasPorAlumnoId(alumnoId);
    
    DefaultTableModel modelo = (DefaultTableModel) notas.getModel(); // Obtener el modelo de la tabla
    modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevas filas
    
    Object[] fila = new Object[6]; // El tamaño de la fila debe coincidir con el número de columnas
    for (Nota nota : listaNotas) {
        fila[0] = nota.getNombre(); // Asegúrate de tener este campo en el objeto Nota
        fila[2] = nota.getCursoID();  // Si tienes un método para obtener el nombre del curso, puedes usarlo aquí
        fila[3] = nota.getNombre();  // O un campo para la tarea o actividad
        fila[4] = nota.getCalificacion();
        fila[5] = nota.getFechaRegistro();
        modelo.addRow(fila);
    }
    
    notas.setModel(modelo); // Asignar el modelo actualizado a la tabla
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NOTAS");

        notas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Curso", "Tarea", "Nota ", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(notas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    public static void main(String args[]) {
    Session.setAlumnoId(1); // Suponiendo que este es el ID del alumno logueado.
    
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new ViewStudents(Session.getAlumnoId()).setVisible(true);
        }
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable notas;
    // End of variables declaration//GEN-END:variables
}
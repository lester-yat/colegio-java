package views;

import java.util.Date;
import javax.swing.JOptionPane;
import models.Grado;
import models.GradoDAO;


public class CrearGrado extends javax.swing.JFrame {
    
    Grado grado = new Grado();
    GradoDAO gradoDAO = new GradoDAO();

    public CrearGrado() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    
    
// Validación para campos de texto que no deben estar vacíos
public boolean esTextoValido(String texto) {
    return texto != null && !texto.trim().isEmpty();
}


// Método para validar si el texto es un número válido entre 10 y 70
public boolean esNumeroValido(String texto) {
    try {
        int numero = Integer.parseInt(texto);
        return numero >= 10 && numero <= 50; // Verifica que el número esté dentro del rango
    } catch (NumberFormatException e) {
        return false; // No es un número válido
    }
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSalon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNivel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtJornada = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCantMaxEstu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtAnio = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creación Grado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 230, 33));

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 280, 40));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        txtSalon.setBackground(new java.awt.Color(0, 0, 0));
        txtSalon.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtSalon.setForeground(new java.awt.Color(255, 255, 255));
        txtSalon.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        jPanel1.add(txtSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 280, 40));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Salón");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nivel");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, -1, -1));

        txtNivel.setBackground(new java.awt.Color(0, 0, 0));
        txtNivel.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtNivel.setForeground(new java.awt.Color(255, 255, 255));
        txtNivel.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        jPanel1.add(txtNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 280, 40));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Año");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, -1, -1));

        txtJornada.setBackground(new java.awt.Color(0, 0, 0));
        txtJornada.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtJornada.setForeground(new java.awt.Color(255, 255, 255));
        txtJornada.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        jPanel1.add(txtJornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 280, 40));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jornada");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, -1, -1));

        txtCantMaxEstu.setBackground(new java.awt.Color(0, 0, 0));
        txtCantMaxEstu.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtCantMaxEstu.setForeground(new java.awt.Color(255, 255, 255));
        txtCantMaxEstu.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        jPanel1.add(txtCantMaxEstu, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 280, 30));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cantidad Max Estudiantes");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, -1, -1));

        btnGuardar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 255, 204));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 204)));
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 610, 100, 40));

        btnCancelar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 255, 204));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 204)));
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, 100, 40));
        jPanel1.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 280, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
      // Validar que los campos de texto no estén vacíos
if (esTextoValido(txtNombre.getText()) && esTextoValido(txtSalon.getText()) 
    && esTextoValido(txtNivel.getText()) && txtAnio.getDate() != null 
    && esTextoValido(txtJornada.getText())) {

    // Validar los campos numéricos individualmente
    if (!esNumeroValido(txtCantMaxEstu.getText())) {
        JOptionPane.showMessageDialog(null, "La cantidad máxima de estudiantes debe ser un número entero válido y ser mayora 10 y menor que 50.");
        return; // Detener la ejecución si el campo es inválido
    }

    try {
        // Convertir cantidad máxima de estudiantes a número entero
        int cantMaxEstudiantes = Integer.parseInt(txtCantMaxEstu.getText());
        
        // Asignación de valores al objeto grado
        grado.setNombre(txtNombre.getText());
        grado.setSalon(txtSalon.getText());
        grado.setNivel(txtNivel.getText());
        grado.setJornada(txtJornada.getText());
        grado.setCantidadMaxEstudiantes(cantMaxEstudiantes);
        grado.setAnio((Date) txtAnio.getDate());

        // Guardar el grado en la base de datos
        gradoDAO.guardarGrado(grado);
        
        // Mensaje de éxito
        JOptionPane.showMessageDialog(null, "Grado guardado exitosamente.");
        ListaGrados vistaLista = new ListaGrados();
        vistaLista.setVisible(true);
        dispose();
        
    } catch (NumberFormatException e) {
        // Este catch solo se activará si ocurre un error con los datos numéricos
        JOptionPane.showMessageDialog(null, "Error en el formato numérico.");
        
    } catch (Exception e) {
        // Control de errores generales
        JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el grado: " + e.getMessage());
    }

} else {
    // Mostrar mensaje si faltan campos obligatorios
    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios.");
}

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaGrados vistaLista = new ListaGrados();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearGrado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser txtAnio;
    private javax.swing.JTextField txtCantMaxEstu;
    private javax.swing.JTextField txtJornada;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalon;
    // End of variables declaration//GEN-END:variables
}

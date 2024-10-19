package views;

import java.awt.Color;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtSalon = new javax.swing.JTextField();
        txtNivel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtJornada = new javax.swing.JTextField();
        txtCantMaxEstu = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtAnio = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creacion Grado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 55, 279, 33));

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 157, 290, 35));

        txtSalon.setBackground(new java.awt.Color(0, 0, 0));
        txtSalon.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtSalon.setForeground(new java.awt.Color(255, 255, 255));
        txtSalon.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        txtSalon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSalonFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSalonFocusLost(evt);
            }
        });
        jPanel1.add(txtSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 235, 290, 35));

        txtNivel.setBackground(new java.awt.Color(0, 0, 0));
        txtNivel.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtNivel.setForeground(new java.awt.Color(255, 255, 255));
        txtNivel.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        txtNivel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNivelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNivelFocusLost(evt);
            }
        });
        jPanel1.add(txtNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 311, 290, 35));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Año");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, -1, -1));

        txtJornada.setBackground(new java.awt.Color(0, 0, 0));
        txtJornada.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtJornada.setForeground(new java.awt.Color(255, 255, 255));
        txtJornada.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        txtJornada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJornadaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJornadaFocusLost(evt);
            }
        });
        jPanel1.add(txtJornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 235, 290, 35));

        txtCantMaxEstu.setBackground(new java.awt.Color(0, 0, 0));
        txtCantMaxEstu.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtCantMaxEstu.setForeground(new java.awt.Color(255, 255, 255));
        txtCantMaxEstu.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        txtCantMaxEstu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantMaxEstuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantMaxEstuFocusLost(evt);
            }
        });
        jPanel1.add(txtCantMaxEstu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 311, 290, 35));

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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 506, 100, 40));

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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 506, 100, 40));

        txtAnio.setBackground(new java.awt.Color(255, 255, 255));
        txtAnio.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 157, 290, 35));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 363, 350, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\samuel\\Desktop\\COLEGIO-JAVA\\colegio-java\\Recursos\\MONSTER.png")); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 393, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!"".equals(txtNombre.getText()) && !"".equals(txtSalon.getText()) && !"".equals(txtNivel.getText()) && 
            !"".equals(txtAnio.getDate()) && !"".equals(txtJornada.getText()) && !"".equals(txtCantMaxEstu.getText())) {
            try {
                grado.setNombre(txtNombre.getText());
                grado.setSalon(txtSalon.getText());
                grado.setNivel(txtNivel.getText());
                grado.setJornada(txtJornada.getText());
                grado.setCantidadMaxEstudiantes(Integer.parseInt(txtCantMaxEstu.getText()));
                grado.setAnio( (Date) txtAnio.getDate());
                
                gradoDAO.guardarGrado(grado);
                JOptionPane.showMessageDialog(null, "Grado guardado exitosamente.");
                ListaGrados vistaLista = new ListaGrados();
                vistaLista.setVisible(true);
                dispose();
            } catch (NumberFormatException e) {
                System.out.println("Error en el formato de los datos numéricos: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el grado: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos están vacíos");
        }
        
        try {
            int edad = Integer.parseInt(txtSalon.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El salon debe ser un número entero.");
        }

        try {
            int inscripcion = Integer.parseInt(txtCantMaxEstu.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La cantidad maxima de estudiantes debe ser un número entero.");
        } 
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaGrados vistaLista = new ListaGrados();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        // TODO add your handling code here:
         if(txtNombre.getText().equals(" Nombre"))
        {
            txtNombre.setText(" ");
            txtNombre.setForeground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        // TODO add your handling code here:
           if(txtNombre.getText().equals(" "))
        {
            txtNombre.setText(" Nombre");
            txtNombre.setForeground(Color.decode("#545353"));
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtSalonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSalonFocusGained
        // TODO add your handling code here:
         if(txtSalon.getText().equals(" Salon"))
        {
            txtSalon.setText(" ");
            txtSalon.setForeground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_txtSalonFocusGained

    private void txtSalonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSalonFocusLost
        // TODO add your handling code here:
            if(txtSalon.getText().equals(" "))
        {
            txtSalon.setText(" Salon");
            txtSalon.setForeground(Color.decode("#545353"));
        }
    }//GEN-LAST:event_txtSalonFocusLost

    private void txtNivelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNivelFocusGained
        // TODO add your handling code here:
         if(txtNivel.getText().equals(" Nivel"))
        {
            txtNivel.setText(" ");
            txtNivel.setForeground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_txtNivelFocusGained

    private void txtNivelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNivelFocusLost
        // TODO add your handling code here:
         if(txtNivel.getText().equals(" "))
        {
            txtNivel.setText(" Nivel");
            txtNivel.setForeground(Color.decode("#545353"));
        }
    }//GEN-LAST:event_txtNivelFocusLost

    private void txtJornadaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJornadaFocusGained
        // TODO add your handling code here:
           if(txtJornada.getText().equals(" Jornada"))
        {
            txtJornada.setText(" ");
            txtJornada.setForeground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_txtJornadaFocusGained

    private void txtJornadaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJornadaFocusLost
        // TODO add your handling code here:
                 if(txtJornada.getText().equals(" "))
        {
            txtJornada.setText(" Jornada");
            txtJornada.setForeground(Color.decode("#545353"));
        }
    }//GEN-LAST:event_txtJornadaFocusLost

    private void txtCantMaxEstuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantMaxEstuFocusGained
        // TODO add your handling code here:
                 if(txtCantMaxEstu.getText().equals(" Cantidad maxima de estudiantes"))
        {
            txtCantMaxEstu.setText(" ");
            txtCantMaxEstu.setForeground(Color.decode("#FFFFFF"));
        }
    }//GEN-LAST:event_txtCantMaxEstuFocusGained

    private void txtCantMaxEstuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantMaxEstuFocusLost
        // TODO add your handling code here:
                 if(txtCantMaxEstu.getText().equals(" "))
        {
            txtCantMaxEstu.setText(" Cantidad maxima de estudiantes");
            txtCantMaxEstu.setForeground(Color.decode("#545353"));
        }
    }//GEN-LAST:event_txtCantMaxEstuFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if (txtNombre.getText().isEmpty()) {
        txtNombre.setText(" Nombre");
        txtNombre.setForeground(new Color(153, 153, 153));
    }
            if (txtSalon.getText().isEmpty()) {
        txtSalon.setText(" Salon");
        txtSalon.setForeground(new Color(153, 153, 153));
    }  
            
    if (txtNivel.getText().isEmpty()) {
        txtNivel.setText(" Nivel");
        txtNivel.setForeground(new Color(153, 153, 153));
    }
        if (txtJornada.getText().isEmpty()) {
        txtJornada.setText(" Jornada");
        txtJornada.setForeground(new Color(153, 153, 153));
    }
      
          if (txtCantMaxEstu.getText().isEmpty()) {
        txtCantMaxEstu.setText(" Cantidad maxima de estudiantes");
        txtCantMaxEstu.setForeground(new Color(153, 153, 153));
    }
          
    this.requestFocus();
    
    }//GEN-LAST:event_formWindowOpened
    
    
    
    
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser txtAnio;
    private javax.swing.JTextField txtCantMaxEstu;
    private javax.swing.JTextField txtJornada;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalon;
    // End of variables declaration//GEN-END:variables
}

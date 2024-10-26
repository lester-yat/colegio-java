package views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Grado;
import models.Profesor;
import models.ProfesoresDAO;
import models.Seccion;

public class CrearProfesores extends javax.swing.JFrame {

    Profesor profesor = new Profesor();
    ProfesoresDAO profesorDAO = new ProfesoresDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modeloGrados = new DefaultTableModel();
    DefaultTableModel modeloSecciones = new DefaultTableModel();
    DefaultTableModel modeloGradoSeccion = new DefaultTableModel();
    int idGrado = 0;
    String nombreGrado = "";

    public CrearProfesores() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        ListaGrados();
        initTablaGradoSeccion();
    }

    public void initTablaGradoSeccion() {
        modeloGradoSeccion = (DefaultTableModel) tablaGradoSeccion.getModel();
        modeloGradoSeccion.setColumnIdentifiers(new String[]{"ID Grado", "Nombre Grado", "ID Seccion", "Nombre Seccion"});
    }

    public void LimpiarTabla(DefaultTableModel modelo) {
        modelo.setRowCount(0);
//        for (int i = 0; i < modelo.getRowCount(); i++) {
//            modelo.removeRow(i);
//            i = i-1;
//        }
    }

    public void ListaGrados() {
        List<Grado> ListarGrad = profesorDAO.listarGrados();
        modelo = (DefaultTableModel) tablaGrados.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < ListarGrad.size(); i++) {
            ob[0] = ListarGrad.get(i).getId();
            ob[1] = ListarGrad.get(i).getNombre();
            ob[2] = ListarGrad.get(i).getSalon();
            ob[3] = ListarGrad.get(i).getCantidadMaxEstudiantes();
            modelo.addRow(ob);
        }
        tablaGrados.setModel(modelo);
    }

    public void ListaSecciones(int id) {
        modeloSecciones = (DefaultTableModel) tablaSecciones.getModel();
        LimpiarTabla(modeloSecciones);
        List<Seccion> ListarSecc = profesorDAO.listarSecciones(id);

        if (ListarSecc.isEmpty()) {
            System.out.println("No hay secciones para este grado.");
            return;
        }

        Object[] ob = new Object[4];
        for (int i = 0; i < ListarSecc.size(); i++) {
            ob[0] = ListarSecc.get(i).getId();
            ob[1] = ListarSecc.get(i).getNombre();
            ob[2] = ListarSecc.get(i).getHorarioInicio();
            ob[3] = ListarSecc.get(i).getHorarioFinal();
            modeloSecciones.addRow(ob);
        }
        tablaSecciones.setModel(modeloSecciones);
    }

    public Integer obtenerIdsSeleccionadoGrado() {
        int filaSeleccionada = tablaGrados.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un grado de la tabla.");
            return null;
        }
        int id = (int) tablaGrados.getValueAt(filaSeleccionada, 0);
        nombreGrado = (String) tablaGrados.getValueAt(filaSeleccionada, 1);
        System.out.println("ID del grado: " + id);
        return id;
    }

    public List<Integer> obtenerIdsSeleccionadosSecciones() {
        int[] filasSeleccionadas = tablaSecciones.getSelectedRows();
        List<Integer> idsSeleccionados = new ArrayList<>();
        for (int fila : filasSeleccionadas) {
            int id = (int) tablaSecciones.getValueAt(fila, 0);
            idsSeleccionados.add(id);
        }
        System.out.println("IDs seleccionados en Secciones: " + idsSeleccionados);
        return idsSeleccionados;
    }

    public List<String> obtenerNombresSeleccionadosSecciones() {
        int[] filasSeleccionadas = tablaSecciones.getSelectedRows();
        List<String> nombresSeleccionados = new ArrayList<>();
        for (int fila : filasSeleccionadas) {
            String nombre = (String) tablaSecciones.getValueAt(fila, 1);
            nombresSeleccionados.add(nombre);
        }
        System.out.println("Nombres seleccionados en Secciones: " + nombresSeleccionados);
        return nombresSeleccionados;
    }

    public List<int[]> obtenerRelacionesGradoSeccion() {
        List<int[]> listaRelaciones = new ArrayList<>();
        Set<String> relacionesUnicas = new HashSet<>();  // Para evitar duplicados

        for (int i = 0; i < modeloGradoSeccion.getRowCount(); i++) {
            int idGrado = (int) modeloGradoSeccion.getValueAt(i, 0);
            Integer idSeccion = (Integer) modeloGradoSeccion.getValueAt(i, 2);

            if (idSeccion != null) {
                String claveUnica = idGrado + "-" + idSeccion;  // Combina grado y sección

                if (!relacionesUnicas.add(claveUnica)) {
                    JOptionPane.showMessageDialog(null,
                            "La sección ya ha sido agregada.");
                    return Collections.emptyList();
                }
                listaRelaciones.add(new int[]{idGrado, idSeccion});
            } else {
                JOptionPane.showMessageDialog(null,
                        "Todos los registros deben tener una sección asignada.");
                return Collections.emptyList();
            }
        }
        return listaRelaciones;
    }

  
    public boolean esNumeroValido(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean esTelefonoValido(String telefono) {
        return telefono.matches("\\d{8}");
    }

    // validaciones hechas por angel 
    
    
      public boolean esEdadValida(String edad) {
    // Verifica que sea un número y esté entre 0 y 100
    if (edad.matches("\\d+")) {
        int edadNumerica = Integer.parseInt(edad);
        return edadNumerica >= 0 && edadNumerica <= 100;
    }
    return false;
}

    
    // Método para validar un correo electrónico de Gmail
public boolean esEmailValido(String email) {
    // Expresión regular para validar el formato de un correo electrónico de Gmail
    return email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$");
}

// Método para validar identificación
public boolean esIdentificacionValida(String identificacion) {
    return identificacion.matches("[\\d-]+"); // Permite dígitos y guiones
}



// Validación para campos de texto que no deben estar vacíos
public boolean esTextoValido(String texto) {
    return texto != null && !texto.trim().isEmpty();
}


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApeliido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtoDireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTipoContrato = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGrados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSecciones = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaGradoSeccion = new javax.swing.JTable();
        btnConsultarGrado = new javax.swing.JButton();
        btnAsignarSeccion = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtFechaContratacion = new com.toedter.calendar.JDateChooser();
        txtFechaTerminacion = new com.toedter.calendar.JDateChooser();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        txtGenero = new javax.swing.JComboBox<>();
        txtTipoIdentificacion = new javax.swing.JComboBox<>();
        txtEstadoCivil = new javax.swing.JComboBox<>();
        txtEstadoContrato = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Creación de Profesor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 330, 60));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 114, -1, -1));

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 103, 212, 30));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 152, -1, -1));

        txtApeliido.setBackground(new java.awt.Color(0, 0, 0));
        txtApeliido.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtApeliido.setForeground(new java.awt.Color(255, 255, 255));
        txtApeliido.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)

        );
        jPanel1.add(txtApeliido, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 143, 212, 30));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Edad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 194, -1, -1));

        txtEdad.setBackground(new java.awt.Color(0, 0, 0));
        txtEdad.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(255, 255, 255));
        txtEdad.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)

        );
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 183, 212, 30));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No. Identificacion");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        txtIdentificacion.setBackground(new java.awt.Color(0, 0, 0));
        txtIdentificacion.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtIdentificacion.setForeground(new java.awt.Color(255, 255, 255));
        txtIdentificacion.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)

        );
        txtIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificacionActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 223, 212, 30));

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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 690, 85, 35));

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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 600, 85, 35));

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Especialidad");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 333, -1, 21));

        txtEspecialidad.setBackground(new java.awt.Color(0, 0, 0));
        txtEspecialidad.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtEspecialidad.setForeground(new java.awt.Color(255, 255, 255));
        txtEspecialidad.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)

        );
        jPanel1.add(txtEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 323, 212, 30));

        txtTelefono.setBackground(new java.awt.Color(0, 0, 0));
        txtTelefono.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)

        );
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 103, 197, 30));

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Teléfono");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(743, 110, -1, -1));

        txtEmail.setBackground(new java.awt.Color(0, 0, 0));
        txtEmail.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)

        );
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 143, 197, 30));

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("E-mail");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(743, 152, -1, -1));

        txtoDireccion.setBackground(new java.awt.Color(0, 0, 0));
        txtoDireccion.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtoDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtoDireccion.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)

        );
        jPanel1.add(txtoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 183, 197, 30));

        jLabel11.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Dirección");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(743, 194, -1, -1));

        jLabel12.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha de Nacimiento");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, -1, -1));

        jLabel13.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tipo Identificacion");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Salario");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, -1, -1));

        txtSalario.setBackground(new java.awt.Color(0, 0, 0));
        txtSalario.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtSalario.setForeground(new java.awt.Color(255, 255, 255));
        txtSalario.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)

        );
        jPanel1.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 273, 197, 30));

        jLabel15.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Fecha Contratación");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, -1, -1));

        jLabel16.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha Terminacion Contrato");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, -1, -1));

        jLabel17.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Estado Contrato");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        txtTipoContrato.setBackground(new java.awt.Color(0, 0, 0));
        txtTipoContrato.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtTipoContrato.setForeground(new java.awt.Color(255, 255, 255));
        txtTipoContrato.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)

        );
        jPanel1.add(txtTipoContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 453, 197, 30));

        jLabel18.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("No. Contrato");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 460, -1, -1));

        jLabel19.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Género");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, 21));

        jLabel20.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Estado Civil");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, -1, 21));

        tablaGrados.setBackground(new java.awt.Color(255, 255, 255));
        tablaGrados.setForeground(new java.awt.Color(0, 0, 0));
        tablaGrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Salon", "Capacitdad de Estudiantes"
            }
        ));
        tablaGrados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablaGrados);
        if (tablaGrados.getColumnModel().getColumnCount() > 0) {
            tablaGrados.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 527, 539, 111));

        tablaSecciones.setBackground(new java.awt.Color(255, 255, 255));
        tablaSecciones.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tablaSecciones.setForeground(new java.awt.Color(0, 0, 0));
        tablaSecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Horario Inicio", "Horario Final"
            }
        ));
        tablaSecciones.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(tablaSecciones);
        if (tablaSecciones.getColumnModel().getColumnCount() > 0) {
            tablaSecciones.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 527, 539, 111));

        tablaGradoSeccion.setBackground(new java.awt.Color(255, 255, 255));
        tablaGradoSeccion.setForeground(new java.awt.Color(0, 0, 0));
        tablaGradoSeccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Grado", "Grado", "ID Seccion", "Seccion"
            }
        ));
        tablaGradoSeccion.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane3.setViewportView(tablaGradoSeccion);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 684, 547, 101));

        btnConsultarGrado.setBackground(new java.awt.Color(0, 255, 204));
        btnConsultarGrado.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btnConsultarGrado.setForeground(new java.awt.Color(0, 255, 204));
        btnConsultarGrado.setText("Consultar");
        btnConsultarGrado.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 204)));
        btnConsultarGrado.setContentAreaFilled(false);
        btnConsultarGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarGradoActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 538, 85, 35));

        btnAsignarSeccion.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btnAsignarSeccion.setForeground(new java.awt.Color(0, 255, 204));
        btnAsignarSeccion.setText("Asignar");
        btnAsignarSeccion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 204)));
        btnAsignarSeccion.setContentAreaFilled(false);
        btnAsignarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarSeccionActionPerformed(evt);
            }
        });
        jPanel1.add(btnAsignarSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 540, 85, 35));

        btnEliminar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 255, 204));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 204)));
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 750, 85, 35));

        txtFechaContratacion.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaContratacion.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtFechaContratacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 314, 197, 30));

        txtFechaTerminacion.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaTerminacion.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtFechaTerminacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 370, 197, 30));

        txtFechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaNacimiento.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 230, 197, 30));

        txtGenero.setBackground(new java.awt.Color(255, 255, 255));
        txtGenero.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtGenero.setForeground(new java.awt.Color(0, 0, 0));
        txtGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        jPanel1.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 375, 212, 30));

        txtTipoIdentificacion.setBackground(new java.awt.Color(255, 255, 255));
        txtTipoIdentificacion.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtTipoIdentificacion.setForeground(new java.awt.Color(0, 0, 0));
        txtTipoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DPI", "Pasaporte" }));
        jPanel1.add(txtTipoIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 285, 212, 30));

        txtEstadoCivil.setBackground(new java.awt.Color(255, 255, 255));
        txtEstadoCivil.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtEstadoCivil.setForeground(new java.awt.Color(0, 0, 0));
        txtEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero/a", "Casado/a", "Viudo/a" }));
        jPanel1.add(txtEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 425, 212, 30));

        txtEstadoContrato.setBackground(new java.awt.Color(255, 255, 255));
        txtEstadoContrato.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtEstadoContrato.setForeground(new java.awt.Color(0, 0, 0));
        txtEstadoContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel1.add(txtEstadoContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 415, 197, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

              // Validaciones por campo clave
if (txtNombre.getText() == null || !esTextoValido(txtNombre.getText())) {
    JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
    return;
}
if (txtApeliido.getText() == null || !esTextoValido(txtApeliido.getText())) {
    JOptionPane.showMessageDialog(null, "El apellido no puede estar vacío.");
    return;
}
if (txtoDireccion.getText() == null || !esTextoValido(txtoDireccion.getText())) {
    JOptionPane.showMessageDialog(null, "La dirección no puede estar vacía.");
    return;
}
if (txtTipoContrato.getText() == null || !esTextoValido(txtTipoContrato.getText())) {
    JOptionPane.showMessageDialog(null, "El tipo de contrato no puede estar vacío.");
    return;
}

// Validación de otros campos
if (txtEdad.getText() == null || !esEdadValida(txtEdad.getText())) {
    JOptionPane.showMessageDialog(null, "La edad debe ser un número entero válido.");
    return;
}
if (txtEmail.getText() == null || !esEmailValido(txtEmail.getText())) {
    JOptionPane.showMessageDialog(null, "El correo electrónico es inválido.");
    return;
}
if (txtIdentificacion.getText() == null || !esIdentificacionValida(txtIdentificacion.getText())) {
    JOptionPane.showMessageDialog(null, "El número de identificación debe ser un número entero con guiones en vez de espacios.");
    return;
}
if (!esTelefonoValido(txtTelefono.getText())) {
    JOptionPane.showMessageDialog(null, "El teléfono debe ser un número de 8 dígitos.");
    return;
}
if (txtSalario.getText() == null || !esNumeroValido(txtSalario.getText())) {
    JOptionPane.showMessageDialog(null, "El salario debe ser un número válido.");
    return;
}

// Validación de campos de selección y fechas
if (txtEstadoCivil.getSelectedItem() == null) {
    JOptionPane.showMessageDialog(null, "Debe seleccionar un estado civil.");
    return;
}
if (txtEstadoContrato.getSelectedItem() == null) {
    JOptionPane.showMessageDialog(null, "Debe seleccionar un estado de contrato.");
    return;
}
if (txtGenero.getSelectedItem() == null) {
    JOptionPane.showMessageDialog(null, "Debe seleccionar un género.");
    return;
}
if (txtFechaContratacion.getDate() == null) {
    JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha de contratación.");
    return;
}
if (txtFechaNacimiento.getDate() == null) {
    JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha de nacimiento.");
    return;
}
if (txtFechaTerminacion.getDate() == null) {
    JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha de terminación del contrato.");
    return;
}

// Validación de relaciones de grado y sección
List<int[]> listaRelaciones = obtenerRelacionesGradoSeccion();
if (listaRelaciones == null || listaRelaciones.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Debe asignar al menos una relación de grado y sección.");
    return;
}

// Si todas las validaciones pasan, procedemos a guardar el profesor
try {
    profesor.setFecha_nacimiento((Date) txtFechaNacimiento.getDate());
    profesor.setFecha_contratacion((Date) txtFechaContratacion.getDate());
    profesor.setFecha_terminacion_contrato((Date) txtFechaTerminacion.getDate());

    profesor.setNombre(txtNombre.getText());
    profesor.setApellido(txtApeliido.getText());
    profesor.setEdad(Integer.parseInt(txtEdad.getText()));  // Validado que es numérico
    profesor.setIdentificacion(txtIdentificacion.getText());
    profesor.setTipo_identificacion(txtTipoIdentificacion.getSelectedItem().toString());
    profesor.setTelefono(txtTelefono.getText());
    profesor.setEmail(txtEmail.getText());
    profesor.setGenero(txtGenero.getSelectedItem().toString());
    profesor.setDireccion(txtoDireccion.getText());
    profesor.setEstado_civil(txtEstadoCivil.getSelectedItem().toString());
    profesor.setEspecialidad(txtEspecialidad.getText());
    profesor.setSalario(Integer.parseInt(txtSalario.getText()));  // Validado que es numérico
    profesor.setEstado_contrato(txtEstadoContrato.getSelectedItem().toString());
    profesor.setTipo_contrato(txtTipoContrato.getText());

    int idProfesor = profesorDAO.guardarProfesor(profesor);
    if (idProfesor == -1) {
        JOptionPane.showMessageDialog(null, "Error al guardar el profesor.");
        return;
    }

    if (!profesorDAO.guardarProfGradSecc(idProfesor, listaRelaciones)) {
        JOptionPane.showMessageDialog(null, "Error al guardar las relaciones.");
        return;
    }

    JOptionPane.showMessageDialog(null, "Profesor guardado exitosamente.");
    ListaProfesores vistaLista = new ListaProfesores();
    vistaLista.setVisible(true);
    dispose();
} catch (NumberFormatException e) {
    System.out.println("Error en el formato de los datos numéricos: " + e.getMessage());
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el profesor: " + e.getMessage());
}

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaProfesores vistaLista = new ListaProfesores();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConsultarGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarGradoActionPerformed
        idGrado = obtenerIdsSeleccionadoGrado();
        if (idGrado != 0) {
            ListaSecciones(idGrado);
        }
    }//GEN-LAST:event_btnConsultarGradoActionPerformed

    private void btnAsignarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarSeccionActionPerformed
        if (idGrado == 0) {
            JOptionPane.showMessageDialog(null, "Primero seleccione un grado y haga clic en 'Consultar'.");
            return;
        }

        List<Integer> seccionesSeleccionadas = obtenerIdsSeleccionadosSecciones();
        List<String> nombresSeccionesSeleccionadas = obtenerNombresSeleccionadosSecciones();

        if (seccionesSeleccionadas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una sección.");
            return;
        }

        for (int i = 0; i < seccionesSeleccionadas.size(); i++) {
            Object[] fila = new Object[4];
            fila[0] = idGrado;
            fila[1] = nombreGrado;
            fila[2] = seccionesSeleccionadas.get(i);
            fila[3] = nombresSeccionesSeleccionadas.get(i);
            modeloGradoSeccion.addRow(fila);
        }
    }//GEN-LAST:event_btnAsignarSeccionActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int[] filasSeleccionadas = tablaGradoSeccion.getSelectedRows();

        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un registro para eliminar.");
            return;
        }

        for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
            modeloGradoSeccion.removeRow(filasSeleccionadas[i]);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificacionActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(CrearProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearProfesores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarSeccion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultarGrado;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaGradoSeccion;
    private javax.swing.JTable tablaGrados;
    private javax.swing.JTable tablaSecciones;
    private javax.swing.JTextField txtApeliido;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JComboBox<String> txtEstadoCivil;
    private javax.swing.JComboBox<String> txtEstadoContrato;
    private com.toedter.calendar.JDateChooser txtFechaContratacion;
    private com.toedter.calendar.JDateChooser txtFechaNacimiento;
    private com.toedter.calendar.JDateChooser txtFechaTerminacion;
    private javax.swing.JComboBox<String> txtGenero;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipoContrato;
    private javax.swing.JComboBox<String> txtTipoIdentificacion;
    private javax.swing.JTextField txtoDireccion;
    // End of variables declaration//GEN-END:variables
}

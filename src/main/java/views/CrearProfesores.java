package views;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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
        for (int i = 0; i < modeloGradoSeccion.getRowCount(); i++) {
            int idGrado = (int) modeloGradoSeccion.getValueAt(i, 0);
            Integer idSeccion = (Integer) modeloGradoSeccion.getValueAt(i, 2);

            if (idSeccion != null) {
                listaRelaciones.add(new int[]{idGrado, idSeccion});
            } else {
                JOptionPane.showMessageDialog(null, "Todos los registros deben tener una sección asignada.");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApeliido = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtIdentificacion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtEspecialidad = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtoDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTipoContrato = new javax.swing.JTextField();
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Creacion de Profesor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 28, 363, 60));

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        txtNombre.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                txtNombreHierarchyChanged(evt);
            }
        });
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 137, 290, 35));

        txtApeliido.setBackground(new java.awt.Color(0, 0, 0));
        txtApeliido.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtApeliido.setForeground(new java.awt.Color(255, 255, 255));
        txtApeliido.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        txtApeliido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApeliidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApeliidoFocusLost(evt);
            }
        });
        jPanel1.add(txtApeliido, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 184, 290, 35));

        txtEdad.setBackground(new java.awt.Color(0, 0, 0));
        txtEdad.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(255, 255, 255));
        txtEdad.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        txtEdad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEdadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEdadFocusLost(evt);
            }
        });
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 237, 290, 35));

        txtIdentificacion.setBackground(new java.awt.Color(0, 0, 0));
        txtIdentificacion.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtIdentificacion.setForeground(new java.awt.Color(255, 255, 255));
        txtIdentificacion.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        txtIdentificacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdentificacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdentificacionFocusLost(evt);
            }
        });
        jPanel1.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 295, 290, 35));

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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 730, 100, 40));

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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 730, 100, 40));

        txtEspecialidad.setBackground(new java.awt.Color(0, 0, 0));
        txtEspecialidad.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtEspecialidad.setForeground(new java.awt.Color(255, 255, 255));
        txtEspecialidad.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        txtEspecialidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEspecialidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEspecialidadFocusLost(evt);
            }
        });
        txtEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEspecialidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 411, 290, 35));

        txtTelefono.setBackground(new java.awt.Color(0, 0, 0));
        txtTelefono.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 290, 35));

        txtEmail.setBackground(new java.awt.Color(0, 0, 0));
        txtEmail.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE)
        );
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 290, 35));

        txtoDireccion.setBackground(new java.awt.Color(0, 0, 0));
        txtoDireccion.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtoDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtoDireccion.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        txtoDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtoDireccionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtoDireccionFocusLost(evt);
            }
        });
        jPanel1.add(txtoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 290, 35));

        jLabel12.setFont(new java.awt.Font("Montserrat", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha de Nacimiento");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, -1, -1));

        jLabel13.setFont(new java.awt.Font("Montserrat", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tipo de Identificacion");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        txtSalario.setBackground(new java.awt.Color(0, 0, 0));
        txtSalario.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtSalario.setForeground(new java.awt.Color(255, 255, 255));
        txtSalario.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        txtSalario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSalarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSalarioFocusLost(evt);
            }
        });
        jPanel1.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 136, 290, 35));

        jLabel15.setFont(new java.awt.Font("Montserrat", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Fecha Contratacion");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 190, -1, -1));

        jLabel16.setFont(new java.awt.Font("Montserrat", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha Terminacion Contrato");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 264, -1, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Estado Contrato");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 333, -1, -1));

        txtTipoContrato.setBackground(new java.awt.Color(0, 0, 0));
        txtTipoContrato.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtTipoContrato.setForeground(new java.awt.Color(255, 255, 255));
        txtTipoContrato.setBorder(new javax.swing.border.MatteBorder(0, 0, 1, 0, java.awt.Color.WHITE));
        txtTipoContrato.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTipoContratoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTipoContratoFocusLost(evt);
            }
        });
        jPanel1.add(txtTipoContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 408, 290, 35));

        jLabel19.setFont(new java.awt.Font("Montserrat", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Género");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, 21));

        jLabel20.setFont(new java.awt.Font("Montserrat", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Estado Civil");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, -1, 21));

        tablaGrados.setBackground(new java.awt.Color(153, 255, 255));
        tablaGrados.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 500, 120));

        tablaSecciones.setBackground(new java.awt.Color(0, 0, 0));
        tablaSecciones.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tablaSecciones.setForeground(new java.awt.Color(255, 255, 255));
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 500, 500, 120));

        tablaGradoSeccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Grado", "Grado", "ID Seccion", "Seccion"
            }
        ));
        tablaGradoSeccion.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane3.setViewportView(tablaGradoSeccion);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, 500, 110));

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
        jPanel1.add(btnConsultarGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 510, 100, 40));

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
        jPanel1.add(btnAsignarSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 510, 100, 40));

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
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 670, 100, 40));

        txtFechaContratacion.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaContratacion.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtFechaContratacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 211, 290, 35));

        txtFechaTerminacion.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaTerminacion.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtFechaTerminacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 286, 290, 35));

        txtFechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaNacimiento.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 290, 35));

        txtGenero.setBackground(new java.awt.Color(255, 255, 255));
        txtGenero.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtGenero.setForeground(new java.awt.Color(255, 255, 255));
        txtGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        txtGenero.setBorder(null);
        jPanel1.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 290, 35));

        txtTipoIdentificacion.setBackground(new java.awt.Color(255, 255, 255));
        txtTipoIdentificacion.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtTipoIdentificacion.setForeground(new java.awt.Color(0, 0, 0));
        txtTipoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DPI", "Pasaporte" }));
        txtTipoIdentificacion.setBorder(null);
        jPanel1.add(txtTipoIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 364, 290, 35));

        txtEstadoCivil.setBackground(new java.awt.Color(255, 255, 255));
        txtEstadoCivil.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtEstadoCivil.setForeground(new java.awt.Color(0, 0, 0));
        txtEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero/a", "Casado/a", "Viudo/a" }));
        txtEstadoCivil.setBorder(null);
        jPanel1.add(txtEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 290, 35));

        txtEstadoContrato.setBackground(new java.awt.Color(255, 255, 255));
        txtEstadoContrato.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtEstadoContrato.setForeground(new java.awt.Color(0, 0, 0));
        txtEstadoContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel1.add(txtEstadoContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 355, 290, 35));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
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

    private void btnConsultarGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarGradoActionPerformed
        idGrado = obtenerIdsSeleccionadoGrado();
        if (idGrado != 0) {
            ListaSecciones(idGrado);
        }
    }//GEN-LAST:event_btnConsultarGradoActionPerformed

    private void txtTipoContratoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTipoContratoFocusLost
        // TODO add your handling code here:
        if (txtTipoContrato.getText().trim().isEmpty()) {
            txtTipoContrato.setText(" Tipo de Contrato"); // Vuelve a poner el placeholder
            txtTipoContrato.setForeground(Color.decode("#ECECEC")); // Color de placeholder (gris)
        }
    }//GEN-LAST:event_txtTipoContratoFocusLost

    private void txtTipoContratoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTipoContratoFocusGained
        // TODO add your handling code here:
        if (txtTipoContrato.getText().equals(" Tipo de Contrato")) {
            txtTipoContrato.setText(""); // Limpia el campo
            txtTipoContrato.setForeground(Color.decode("#FFFFFF")); // Color de texto normal
        }
    }//GEN-LAST:event_txtTipoContratoFocusGained

    private void txtSalarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSalarioFocusLost
        // TODO add your handling code here:
        if (txtSalario.getText().trim().isEmpty()) {
            txtSalario.setText(" Salario"); // Vuelve a poner el placeholder
            txtSalario.setForeground(Color.decode("#ECECEC")); // Color de placeholder (gris)
        }
    }//GEN-LAST:event_txtSalarioFocusLost

    private void txtSalarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSalarioFocusGained
        // TODO add your handling code here:
        if (txtSalario.getText().equals(" Salario")) {
            txtSalario.setText(""); // Limpia el campo
            txtSalario.setForeground(Color.decode("#FFFFFF")); // Color de texto normal
        }

    }//GEN-LAST:event_txtSalarioFocusGained

    private void txtoDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtoDireccionFocusLost
        // TODO add your handling code here:

        if (txtoDireccion.getText().trim().isEmpty()) {
            txtoDireccion.setText(" Direccion"); // Vuelve a poner el placeholder
            txtoDireccion.setForeground(Color.decode("#ECECEC")); // Color de placeholder (gris)
        }
    }//GEN-LAST:event_txtoDireccionFocusLost

    private void txtoDireccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtoDireccionFocusGained
        // TODO add your handling code here:
        if (txtoDireccion.getText().equals(" Direccion")) {
            txtoDireccion.setText(""); // Limpia el campo
            txtoDireccion.setForeground(Color.decode("#FFFFFF")); // Color de texto normal
        }
    }//GEN-LAST:event_txtoDireccionFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:
        if (txtEmail.getText().trim().isEmpty()) {
            txtEmail.setText(" Email"); // Vuelve a poner el placeholder
            txtEmail.setForeground(Color.decode("#ECECEC")); // Color de placeholder (gris)
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        // TODO add your handling code here:
        if (txtEmail.getText().equals(" Email")) {
            txtEmail.setText(""); // Limpia el campo
            txtEmail.setForeground(Color.decode("#FFFFFF")); // Color de texto normal
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        // TODO add your handling code here:
        if (txtTelefono.getText().trim().isEmpty()) {
            txtTelefono.setText(" Telefono"); // Vuelve a poner el placeholder
            txtTelefono.setForeground(Color.decode("#ECECEC")); // Color de placeholder (gris)
        }
    }//GEN-LAST:event_txtTelefonoFocusLost

    private void txtTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusGained
        // TODO add your handling code here:
        if (txtTelefono.getText().equals(" Telefono")) {
            txtTelefono.setText(""); // Limpia el campo
            txtTelefono.setForeground(Color.decode("#FFFFFF")); // Color de texto normal
        }
    }//GEN-LAST:event_txtTelefonoFocusGained

    private void txtEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEspecialidadActionPerformed

    private void txtEspecialidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEspecialidadFocusLost
        // TODO add your handling code here:
        if (txtEspecialidad.getText().trim().isEmpty()) {
            txtEspecialidad.setText(" Especialidad"); // Vuelve a poner el placeholder
            txtEspecialidad.setForeground(Color.decode("#ECECEC")); // Color de placeholder (gris)
        }
    }//GEN-LAST:event_txtEspecialidadFocusLost

    private void txtEspecialidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEspecialidadFocusGained
        // TODO add your handling code here:
        if (txtEspecialidad.getText().equals(" Especialidad")) {
            txtEspecialidad.setText(""); // Limpia el campo
            txtEspecialidad.setForeground(Color.decode("#FFFFFF")); // Color de texto normal
        }
    }//GEN-LAST:event_txtEspecialidadFocusGained

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaProfesores vistaLista = new ListaProfesores();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (!"".equals(txtNombre.getText()) && !"".equals(txtApeliido.getText()) && !"".equals(txtEdad.getText())
            && !"".equals(txtEmail.getText()) && !"".equals(txtEspecialidad.getText()) && !"".equals(txtEstadoCivil.getSelectedItem())
            && !"".equals(txtEstadoContrato.getSelectedItem()) && !"".equals(txtFechaContratacion.getDate())
            && !"".equals(txtFechaNacimiento.getDate()) && !"".equals(txtFechaTerminacion.getDate())
            && !"".equals(txtGenero.getSelectedItem()) && !"".equals(txtIdentificacion.getText())
            && !"".equals(txtSalario.getText()) && !"".equals(txtTelefono.getText())
            && !"".equals(txtTipoContrato.getText()) && !"".equals(txtTipoIdentificacion.getSelectedItem())
            && !"".equals(txtoDireccion.getText())) {
            try {
                profesor.setFecha_nacimiento((Date) txtFechaNacimiento.getDate());
                profesor.setFecha_contratacion((Date) txtFechaContratacion.getDate());
                profesor.setFecha_terminacion_contrato((Date) txtFechaTerminacion.getDate());

                profesor.setNombre(txtNombre.getText());
                profesor.setApellido(txtApeliido.getText());
                profesor.setEdad(Integer.parseInt(txtEdad.getText()));
                profesor.setIdentificacion(txtIdentificacion.getText());
                profesor.setTipo_identificacion(txtTipoIdentificacion.getSelectedItem().toString());
                profesor.setTelefono(txtTelefono.getText());
                profesor.setEmail(txtEmail.getText());
                profesor.setGenero(txtGenero.getSelectedItem().toString());
                profesor.setDireccion(txtoDireccion.getText());
                profesor.setEstado_civil(txtEstadoCivil.getSelectedItem().toString());
                profesor.setEspecialidad(txtEspecialidad.getText());
                profesor.setSalario(Integer.parseInt(txtSalario.getText()));
                profesor.setEstado_contrato(txtEstadoContrato.getSelectedItem().toString());
                profesor.setTipo_contrato(txtTipoContrato.getText());

                int idProfesor = profesorDAO.guardarProfesor(profesor);
                if (idProfesor == -1) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el profesor.");
                    return;
                }

                List<int[]> listaRelaciones = obtenerRelacionesGradoSeccion();

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
        } else {
            JOptionPane.showMessageDialog(null, "Los campos están vacíos");
        }

        if (!esTelefonoValido(txtTelefono.getText())) {
            JOptionPane.showMessageDialog(null, "El teléfono debe ser un número de 8 dígitos.");
        } else if (!esNumeroValido(txtEdad.getText())) {
            JOptionPane.showMessageDialog(null, "La edad debe ser un número entero.");
        } else if (!esNumeroValido(txtIdentificacion.getText())) {
            JOptionPane.showMessageDialog(null, "El número de identificación debe ser un número entero.");
        } else if (!esNumeroValido(txtSalario.getText())) {
            JOptionPane.showMessageDialog(null, "El salario debe ser un número entero.");
        } else if (!esNumeroValido(txtTipoContrato.getText())) {
            JOptionPane.showMessageDialog(null, "El tipo de contrato debe ser un número entero.");
        } else {
            System.out.println("Datos correctos.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtIdentificacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdentificacionFocusLost
        // TODO add your handling code here:
        if (txtIdentificacion.getText().trim().isEmpty()) {
            txtIdentificacion.setText(" Identificacion"); // Vuelve a poner el placeholder
            txtIdentificacion.setForeground(Color.decode("#ECECEC")); // Color de placeholder (gris)
        }
    }//GEN-LAST:event_txtIdentificacionFocusLost

    private void txtIdentificacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdentificacionFocusGained
        // TODO add your handling code here:
        if (txtIdentificacion.getText().equals(" Identificacion")) {
            txtIdentificacion.setText(""); // Limpia el campo
            txtIdentificacion.setForeground(Color.decode("#FFFFFF")); // Color de texto normal
        }
    }//GEN-LAST:event_txtIdentificacionFocusGained

    private void txtEdadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdadFocusLost
        // TODO add your handling code here:
        if (txtEdad.getText().trim().isEmpty()) {
            txtEdad.setText(" Edad"); // Vuelve a poner el placeholder
            txtEdad.setForeground(Color.decode("#ECECEC")); // Color de placeholder (gris)
        }
    }//GEN-LAST:event_txtEdadFocusLost

    private void txtEdadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdadFocusGained
        // TODO add your handling code here:
        if (txtEdad.getText().equals(" Edad")) {
            txtEdad.setText(""); // Limpia el campo
            txtEdad.setForeground(Color.decode("#FFFFFF")); // Color de texto normal
        }
    }//GEN-LAST:event_txtEdadFocusGained

    private void txtApeliidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApeliidoFocusLost
        // TODO add your handling code here:
        if (txtApeliido.getText().trim().isEmpty()) {
            txtApeliido.setText(" Apellido"); // Vuelve a poner el placeholder
            txtApeliido.setForeground(Color.decode("#ECECEC")); // Color de placeholder (gris)
        }
    }//GEN-LAST:event_txtApeliidoFocusLost

    private void txtApeliidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApeliidoFocusGained
        // TODO add your handling code here:
        if (txtApeliido.getText().equals(" Apellido")) {
            txtApeliido.setText(""); // Limpia el campo
            txtApeliido.setForeground(Color.decode("#FFFFFF")); // Color de texto normal
        }
    }//GEN-LAST:event_txtApeliidoFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        // TODO add your handling code here:
        if (txtNombre.getText().trim().isEmpty()) {
            txtNombre.setText(" Nombre"); // Vuelve a poner el placeholder
            txtNombre.setForeground(Color.decode("#ECECEC")); // Color de placeholder (gris)
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        // TODO add your handling code here:
        if (txtNombre.getText().equals(" Nombre")) {
            txtNombre.setText(""); // Limpia el campo
            txtNombre.setForeground(Color.decode("#FFFFFF")); // Color de texto normal
        }
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_txtNombreHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreHierarchyChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
           if (txtNombre.getText().isEmpty()) {
        txtNombre.setText(" Nombre");
        txtNombre.setForeground(Color.decode("#B0B0B0")); // Color gris para el placeholder
    }  
       
       if (txtApeliido.getText().isEmpty()) {
        txtApeliido.setText(" Apellido");
        txtApeliido.setForeground(Color.decode("#B0B0B0")); // Color gris para el placeholder
    }
        
        
     if (txtEdad.getText().isEmpty()) {
        txtEdad.setText(" Edad");
        txtEdad.setForeground(Color.decode("#B0B0B0")); // Color gris para el placeholder
    }
     
      if (txtIdentificacion.getText().isEmpty()) {
        txtIdentificacion.setText(" Identificacion");
        txtIdentificacion.setForeground(Color.decode("#B0B0B0")); // Color gris para el placeholder
    }
      
       if (txtEspecialidad.getText().isEmpty()) {
        txtEspecialidad.setText(" Especialidad");
        txtEspecialidad.setForeground(Color.decode("#B0B0B0")); // Color gris para el placeholder
    }  
      
        
    if (txtTelefono.getText().isEmpty()) {
        txtTelefono.setText(" Telefono");
        txtTelefono.setForeground(Color.decode("#B0B0B0")); // Color gris para el placeholder
    }  
    
     if (txtEmail.getText().isEmpty()) {
        txtEmail.setText(" Email");
        txtEmail.setForeground(Color.decode("#B0B0B0")); // Color gris para el placeholder
    }  
     
      if (txtoDireccion.getText().isEmpty()) {
        txtoDireccion.setText(" Direccion");
        txtoDireccion.setForeground(Color.decode("#B0B0B0")); // Color gris para el placeholder
    } 
      if (txtSalario.getText().isEmpty()) {
        txtSalario.setText(" Salario");
        txtSalario.setForeground(Color.decode("#B0B0B0")); // Color gris para el placeholder
    } 
      
        if (txtTipoContrato.getText().isEmpty()) {
        txtTipoContrato.setText(" Tipo de Contrato");
        txtTipoContrato.setForeground(Color.decode("#B0B0B0")); // Color gris para el placeholder
    } 
        
        
    this.requestFocus();
    }//GEN-LAST:event_formWindowOpened
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
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

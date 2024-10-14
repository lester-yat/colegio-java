package views;

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
    
    public void ListaGrados(){
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

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Creacion de Profesor");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Edad");

        jLabel5.setText("No. Identificacion");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel8.setText("Especialidad");

        jLabel9.setText("Telefono");

        jLabel10.setText("E-mail");

        jLabel11.setText("Direccion");

        jLabel12.setText("Fecha de Nacimiento");

        jLabel13.setText("Tipo Identificacion");

        jLabel14.setText("Salario");

        jLabel15.setText("Fecha Contratacion");

        jLabel16.setText("Fecha Terminacion Contrato");

        jLabel17.setText("Estado Contrato");

        jLabel18.setText("No. Contrato");

        jLabel19.setText("Genero");

        jLabel20.setText("Estado Civil");

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

        tablaGradoSeccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Grado", "Grado", "ID Seccion", "Seccion"
            }
        ));
        tablaGradoSeccion.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane3.setViewportView(tablaGradoSeccion);

        btnConsultarGrado.setText("Conultar");
        btnConsultarGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarGradoActionPerformed(evt);
            }
        });

        btnAsignarSeccion.setText("Asignar");
        btnAsignarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarSeccionActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        txtTipoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DPI", "Pasaporte" }));

        txtEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero/a", "Casado/a", "Viudo/a" }));

        txtEstadoContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(369, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApeliido, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 235, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEspecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(txtTipoIdentificacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFechaTerminacion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEstadoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel14))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                            .addComponent(txtFechaContratacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(192, 192, 192))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(btnConsultarGrado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addGap(104, 104, 104))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(527, Short.MAX_VALUE)
                                .addComponent(btnGuardar)
                                .addGap(113, 113, 113)
                                .addComponent(btnCancelar)
                                .addGap(216, 216, 216)
                                .addComponent(btnAsignarSeccion)))
                        .addGap(45, 45, 45)))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(380, 380, 380))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApeliido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addComponent(txtFechaContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFechaTerminacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtEstadoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnConsultarGrado)
                                        .addGap(115, 115, 115))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAsignarSeccion)
                        .addGap(103, 103, 103)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!"".equals(txtNombre.getText()) && !"".equals(txtApeliido.getText()) && !"".equals(txtEdad.getText()) &&
            !"".equals(txtEmail.getText()) && !"".equals(txtEspecialidad.getText()) && !"".equals(txtEstadoCivil.getSelectedItem()) &&
            !"".equals(txtEstadoContrato.getSelectedItem()) && !"".equals(txtFechaContratacion.getDate()) &&
            !"".equals(txtFechaNacimiento.getDate()) && !"".equals(txtFechaTerminacion.getDate()) &&
            !"".equals(txtGenero.getSelectedItem()) && !"".equals(txtIdentificacion.getText()) &&
            !"".equals(txtSalario.getText()) && !"".equals(txtTelefono.getText()) &&
            !"".equals(txtTipoContrato.getText()) && !"".equals(txtTipoIdentificacion.getSelectedItem()) &&
            !"".equals(txtoDireccion.getText())) {
            try {
                profesor.setFecha_nacimiento( (Date) txtFechaNacimiento.getDate());
                profesor.setFecha_contratacion( (Date) txtFechaContratacion.getDate());
                profesor.setFecha_terminacion_contrato( (Date) txtFechaTerminacion.getDate());

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

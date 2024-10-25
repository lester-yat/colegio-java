package views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Grado;
import models.Profesor;
import models.ProfesoresDAO;
import models.Seccion;

public class EditarProfesor extends javax.swing.JFrame {

    Profesor profesor = new Profesor();
    ProfesoresDAO profesorDAO = new ProfesoresDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modeloGrados = new DefaultTableModel();
    DefaultTableModel modeloSecciones = new DefaultTableModel();
    DefaultTableModel modeloGradoSeccion = new DefaultTableModel();
    int idGrado = 0;
    String nombreGrado = "";

    public int profesorId;
    private Map<Integer, String> gradoMap = new HashMap<>();

    public EditarProfesor() {

        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
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

    private void cargarRelacionesGradoSeccion(int profesorId) {
        List<int[]> relaciones = profesorDAO.obtenerRelacionesGradoSeccion(profesorId);

        LimpiarTabla(modeloGradoSeccion);

        for (int[] relacion : relaciones) {
            Object[] fila = new Object[4];
            fila[0] = relacion[0];
            fila[1] = obtenerNombreGrado(relacion[0]);
            fila[2] = relacion[1];
            fila[3] = obtenerNombreSeccion(relacion[1]);
            modeloGradoSeccion.addRow(fila);
        }
    }

    private String obtenerNombreGrado(int gradoId) {
        return profesorDAO.obtenerNombreGrado(gradoId);
    }

    private String obtenerNombreSeccion(int seccionId) {
        return profesorDAO.obtenerNombreSeccion(seccionId);
    }

    public EditarProfesor(int profesorId) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.profesorId = profesorId;

        ListaGrados();
        initTablaGradoSeccion();

        Profesor profesor = profesorDAO.consultarDatos(profesorId);

        if (profesor != null) {
            txtNombre.setText(profesor.getNombre());
            txtApeliido.setText(profesor.getApellido());
            txtTelefono.setText(profesor.getTelefono());
            txtEmail.setText(profesor.getEmail());
            txtoDireccion.setText(profesor.getDireccion());
            txtEdad.setText(String.valueOf(profesor.getEdad()));
            txtIdentificacion.setText(profesor.getIdentificacion());
            txtFechaNacimiento.setDate(profesor.getFecha_nacimiento());
            txtTipoIdentificacion.setSelectedItem(profesor.getTipo_identificacion());
            txtSalario.setText(String.valueOf(profesor.getSalario()));
            txtEspecialidad.setText(profesor.getEspecialidad());
            txtFechaContratacion.setDate(profesor.getFecha_contratacion());
            txtFechaTerminacion.setDate(profesor.getFecha_terminacion_contrato());
            txtEstadoContrato.setSelectedItem(profesor.getEstado_contrato());
            txtGenero.setSelectedItem(profesor.getGenero());
            txtTipoContrato.setText(profesor.getTipo_contrato());
            txtEstadoCivil.setSelectedItem(profesor.getEstado_civil());
        } else {
            System.out.println("No se encontró ningún profesor con el ID: " + profesorId);
        }

        cargarRelacionesGradoSeccion(profesorId);
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

    // Método para validar un correo electrónico de Gmail
    public boolean esEmailValido(String email) {
        // Expresión regular para validar el formato de un correo electrónico de Gmail
        return email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$");
    }

// Método para validar identificación
    public boolean esIdentificacionValida(String identificacion) {
        return identificacion.matches("\\d+"); // Comprueba si solo contiene dígitos
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaGradoSeccion = new javax.swing.JTable();
        btnAsignarSeccion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSecciones = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGrados = new javax.swing.JTable();
        btnConsultarGrado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApeliido = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtoDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTipoContrato = new javax.swing.JTextField();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        txtFechaContratacion = new com.toedter.calendar.JDateChooser();
        txtFechaTerminacion = new com.toedter.calendar.JDateChooser();
        txtGenero = new javax.swing.JComboBox<>();
        txtEstadoCivil = new javax.swing.JComboBox<>();
        txtEstadoContrato = new javax.swing.JComboBox<>();
        txtTipoIdentificacion = new javax.swing.JComboBox<>();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizar.setBackground(new java.awt.Color(0, 0, 0));
        btnActualizar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 700, 180, 50));

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 700, 180, 50));

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 700, 180, 50));

        tablaGradoSeccion.setBackground(new java.awt.Color(204, 204, 204));
        tablaGradoSeccion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 550, 620, 140));

        btnAsignarSeccion.setBackground(new java.awt.Color(0, 0, 0));
        btnAsignarSeccion.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnAsignarSeccion.setForeground(new java.awt.Color(255, 255, 255));
        btnAsignarSeccion.setText("Asignar");
        btnAsignarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarSeccionActionPerformed(evt);
            }
        });
        jPanel1.add(btnAsignarSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 470, 180, 50));

        tablaSecciones.setBackground(new java.awt.Color(204, 204, 204));
        tablaSecciones.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 350, 620, 111));

        tablaGrados.setBackground(new java.awt.Color(204, 204, 204));
        tablaGrados.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tablaGrados.setForeground(new java.awt.Color(0, 0, 0));
        tablaGrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Salon", "Cantidad Estudiantes"
            }
        ));
        tablaGrados.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tablaGrados.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(tablaGrados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 620, 180));

        btnConsultarGrado.setBackground(new java.awt.Color(0, 0, 0));
        btnConsultarGrado.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnConsultarGrado.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarGrado.setText("Consultar");
        btnConsultarGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarGradoActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 180, 50));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edicion de Profesor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 450, 60));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 290, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txtApeliido.setBackground(new java.awt.Color(0, 0, 0));
        txtApeliido.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtApeliido.setForeground(new java.awt.Color(255, 255, 255));
        txtApeliido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeliidoActionPerformed(evt);
            }
        });
        jPanel1.add(txtApeliido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 290, -1));

        txtEdad.setBackground(new java.awt.Color(0, 0, 0));
        txtEdad.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(255, 255, 255));
        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 290, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Edad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No. Identificacion");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        txtIdentificacion.setBackground(new java.awt.Color(0, 0, 0));
        txtIdentificacion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtIdentificacion.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 290, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tipo Identificacion");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Especialidad");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, 21));

        txtEspecialidad.setBackground(new java.awt.Color(0, 0, 0));
        txtEspecialidad.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtEspecialidad.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 290, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Genero");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, 20));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Estado Civil");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, -1, 21));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Telefono");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        txtTelefono.setBackground(new java.awt.Color(0, 0, 0));
        txtTelefono.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 370, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("E-mail");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Direccion");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, -1));

        txtoDireccion.setBackground(new java.awt.Color(0, 0, 0));
        txtoDireccion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtoDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtoDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(txtoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 370, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha de Nacimiento");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Salario");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, -1));

        txtSalario.setBackground(new java.awt.Color(0, 0, 0));
        txtSalario.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtSalario.setForeground(new java.awt.Color(255, 255, 255));
        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 370, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Fecha Contratacion");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, -1, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha Terminacion Contrato");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Estado Contrato");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 610, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Tipo Contrato");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 690, -1, -1));

        txtTipoContrato.setBackground(new java.awt.Color(0, 0, 0));
        txtTipoContrato.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtTipoContrato.setForeground(new java.awt.Color(255, 255, 255));
        txtTipoContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoContratoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipoContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 730, 370, -1));

        txtFechaNacimiento.setBackground(new java.awt.Color(0, 0, 0));
        txtFechaNacimiento.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 370, -1));

        txtFechaContratacion.setBackground(new java.awt.Color(0, 0, 0));
        txtFechaContratacion.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtFechaContratacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, 370, -1));

        txtFechaTerminacion.setBackground(new java.awt.Color(0, 0, 0));
        txtFechaTerminacion.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtFechaTerminacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 570, 370, -1));

        txtGenero.setBackground(new java.awt.Color(0, 0, 0));
        txtGenero.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtGenero.setForeground(new java.awt.Color(255, 255, 255));
        txtGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        jPanel1.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 290, -1));

        txtEstadoCivil.setBackground(new java.awt.Color(0, 0, 0));
        txtEstadoCivil.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtEstadoCivil.setForeground(new java.awt.Color(255, 255, 255));
        txtEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero/a", "Casado/a", "Viudo/a" }));
        jPanel1.add(txtEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 290, -1));

        txtEstadoContrato.setBackground(new java.awt.Color(0, 0, 0));
        txtEstadoContrato.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtEstadoContrato.setForeground(new java.awt.Color(255, 255, 255));
        txtEstadoContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel1.add(txtEstadoContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, 370, -1));

        txtTipoIdentificacion.setBackground(new java.awt.Color(0, 0, 0));
        txtTipoIdentificacion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTipoIdentificacion.setForeground(new java.awt.Color(255, 255, 255));
        txtTipoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DPI", "Pasaporte" }));
        jPanel1.add(txtTipoIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 290, -1));

        txtEmail.setBackground(new java.awt.Color(0, 0, 0));
        txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 360, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        if (txtNombre.getText().isEmpty() || txtApeliido.getText().isEmpty()
                || txtEdad.getText().isEmpty() || txtEmail.getText().isEmpty()
                || txtEspecialidad.getText().isEmpty() || txtEstadoCivil.getSelectedItem() == null
                || txtEstadoContrato.getSelectedItem() == null || txtFechaContratacion.getDate() == null
                || txtFechaNacimiento.getDate() == null || txtFechaTerminacion.getDate() == null
                || txtGenero.getSelectedItem() == null || txtIdentificacion.getText().isEmpty()
                || txtSalario.getText().isEmpty() || txtTelefono.getText().isEmpty()
                || txtTipoContrato.getText().isEmpty() || txtTipoIdentificacion.getSelectedItem() == null
                || txtoDireccion.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados.");
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(txtEdad.getText());
            // Validar que la edad esté entre 1 y 100
            if (edad <= 0 || edad > 100) {
                JOptionPane.showMessageDialog(null, "La edad debe ser mayor a 0 y menor o igual a 100.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La edad debe ser un número entero.");
            return;
        }

        String identificacion = txtIdentificacion.getText();
        if (identificacion.length() > 50) {
            JOptionPane.showMessageDialog(null, "La identificación no puede exceder los 50 caracteres.");
            return;
        }
        if (!esIdentificacionValida(identificacion)) {
            JOptionPane.showMessageDialog(null, "El número de identificación debe ser un número entero.");
            return;
        }

        String telefono = txtTelefono.getText();
        if (!esTelefonoValido(telefono)) {
            JOptionPane.showMessageDialog(null, "El teléfono debe ser un número de 8 dígitos.");
            return;
        }

        String email = txtEmail.getText();
        if (!esEmailValido(email)) {
            JOptionPane.showMessageDialog(null, "El correo debe ser de tipo gmail.com.");
            return;
        }

        int salario;
        try {
            salario = Integer.parseInt(txtSalario.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El salario debe ser un número entero.");
            return;
        }

// Al final del bloque, si todo es correcto, procede a guardar el profesor.
        profesor.setId(profesorId);
        profesor.setNombre(txtNombre.getText());
        profesor.setApellido(txtApeliido.getText());
        profesor.setEdad(edad);
        profesor.setIdentificacion(identificacion);
        profesor.setTipo_identificacion(txtTipoIdentificacion.getSelectedItem().toString());
        profesor.setTelefono(telefono);
        profesor.setEmail(email);
        profesor.setGenero(txtGenero.getSelectedItem().toString());
        profesor.setDireccion(txtoDireccion.getText());
        profesor.setEstado_civil(txtEstadoCivil.getSelectedItem().toString());
        profesor.setEspecialidad(txtEspecialidad.getText());
        profesor.setSalario(salario);
        profesor.setEstado_contrato(txtEstadoContrato.getSelectedItem().toString());
        profesor.setTipo_contrato(txtTipoContrato.getText());
        profesor.setFecha_nacimiento(txtFechaNacimiento.getDate());
        profesor.setFecha_contratacion(txtFechaContratacion.getDate());
        profesor.setFecha_terminacion_contrato(txtFechaTerminacion.getDate());

        try {
            profesorDAO.editarProfesor(profesor);

            List<int[]> listaRelaciones = obtenerRelacionesGradoSeccion();
            if (!profesorDAO.editarProfGradSecc(profesorId, listaRelaciones)) {
                JOptionPane.showMessageDialog(null, "Error al actualizar las relaciones.");
                return;
            }

            JOptionPane.showMessageDialog(null, "Profesor actualizado exitosamente.");
            ListaProfesores vistaLista = new ListaProfesores();
            vistaLista.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el profesor: " + e.getMessage());
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ListaProfesores vistaLista = new ListaProfesores();
        vistaLista.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

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

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void txtTipoContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoContratoActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void txtApeliidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeliidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeliidoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarProfesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAsignarSeccion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultarGrado;
    private javax.swing.JButton btnEliminar;
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

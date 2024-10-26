package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlumnoDAO {
    Conexion conexion = new Conexion();
    Connection con = conexion.establecerConexion();
    
    public List listarAlumnos() {
        List<Alumno> listAlum = new ArrayList();
        String sql = "SELECT * FROM alumno";

        try (PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Alumno al = new Alumno();
                
                al.setId(rs.getInt("id"));
                al.setNombre(rs.getString("nombre"));
                al.setApellido(rs.getString("apellido"));
                al.setEdad(rs.getInt("edad"));
                al.setGrado(rs.getInt("grado_id"));
                listAlum.add(al);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los alumnos: " + e.toString());
        }
        return listAlum;
    }
    
    public List<Grado> listarGrados() {
        List<Grado> listGrad = new ArrayList<>();
        String sql = "SELECT * FROM grado";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Grado gr = new Grado();
                gr.setId(rs.getInt("id"));
                gr.setNombre(rs.getString("nombre"));
                gr.setSalon(rs.getString("salon"));
                gr.setNivel(rs.getString("nivel"));
                gr.setAnio(rs.getDate("anio"));
                gr.setJornada(rs.getString("jornada"));
                gr.setCantidadMaxEstudiantes(rs.getInt("cantidad_max_estudiantes"));
                listGrad.add(gr);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los grados: " + e.toString());
        }
        return listGrad;
    }
    
    public List listarSecciones(int idGrado) {
        List<Seccion> listSec = new ArrayList();
        String sql = "SELECT * FROM seccion WHERE grado_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idGrado);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Seccion sc = new Seccion();
                
                sc.setId(rs.getInt("id"));
                sc.setNombre(rs.getString("nombre"));
                sc.setHorarioInicio(rs.getTime("horario_inicio"));
                sc.setHorarioFinal(rs.getTime("horario_final"));
                sc.setGrado(rs.getInt("grado_id"));
                listSec.add(sc);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar las secciones: " + e.toString());
        }
        return listSec;
    }
    
    public String columnaGrados(int idAlumno) {
        StringBuilder nombresGrados = new StringBuilder();
        String sql = "SELECT g.nombre " +
                     "FROM grado g " +
                     "INNER JOIN alumno al ON g.id = al.grado_id " +
                     "WHERE al.id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            Set<String> gradosSet = new HashSet<>();
            while (rs.next()) {
                gradosSet.add(rs.getString("nombre"));
            }
            
            nombresGrados.append(String.join(", ", gradosSet));

        } catch (SQLException e) {
            System.out.println("Error al consultar los nombres de los grados: " + e.getMessage());
        }

        return nombresGrados.toString();
    }
    
    public List<Padre> listarPadres() {
        List<Padre> padres = new ArrayList<>();
        String sql = "SELECT id, nombre, apellido FROM padre";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Padre padre = new Padre();
                padre.setId(rs.getInt("id"));
                padre.setNombre(rs.getString("nombre"));
                padre.setApellido(rs.getString("apellido"));
                padres.add(padre);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar padres: " + e.getMessage());
        }
        return padres;
    }

    public Alumno consultarDatos(int id) {
        String sql = "SELECT * FROM alumno WHERE id = ?";
        String sql2 = "SELECT padre_id FROM alumno_padre WHERE alumno_id = ?";
        Alumno alumno = new Alumno();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    alumno.setId(rs.getInt("id"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setEdad(rs.getInt("edad"));
                    alumno.setGrado(rs.getInt("grado_id"));
                    alumno.setFechaResgistro(rs.getDate("fecha_registro"));
                }
            }

            // Ejecutar la segunda consulta para obtener el padre_id
            try (PreparedStatement ps2 = con.prepareStatement(sql2)) {
                ps2.setInt(1, id);
                try (ResultSet rs2 = ps2.executeQuery()) {
                    if (rs2.next()) {
                        alumno.setPadre(rs2.getInt("padre_id"));
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar los datos del alumno: " + e.getMessage());
        }

        return alumno;
    }
    
    public int guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (nombre, apellido, edad, grado_id, fecha_registro) VALUES (?, ?, ?, ?, ?)";
        int idGenerado = -1;
        
        try (
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getGrado());
            ps.setDate(5, new java.sql.Date(alumno.getFechaResgistro().getTime()));
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar el alumno: " + e.toString());
        }
        
        guardarAlumPad(idGenerado, alumno.getPadre());
        
        return idGenerado;
    }
    
    public boolean guardarAlumPad(int idAlumno, int idPadre) {
        String sql = "INSERT INTO alumno_padre (alumno_id, padre_id) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAlumno);
            ps.setInt(2, idPadre);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: La relación ya existe o hay un problema de integridad referencial. " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println("Error al guardar la relación: " + e.getMessage());
            return false;
        }
    }
    
    public boolean guardarAlumSecc(int idAlumno, List<Integer> listaRelaciones) {
        String sql = "INSERT INTO alumno_seccion (alumno_id, seccion_id) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            for (Integer idSeccion : listaRelaciones) {
                ps.setInt(1, idAlumno);

                if (idSeccion != null && idSeccion != -1) {
                    ps.setInt(2, idSeccion);
                } else {
                    ps.setNull(2, java.sql.Types.INTEGER);
                }

                ps.addBatch();  // Agregar la instrucción a un batch
            }

            ps.executeBatch();  // Ejecutar todas las instrucciones juntas
            return true;
        } catch (SQLException e) {
            System.out.println("Error al guardar las relaciones: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarAlumno(int id) {
        String sql = "DELETE FROM alumno WHERE id = ?";
        try (
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el alumno: " + e.toString());
            return false;
        }
    }
    
    public boolean editarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET nombre = ?, apellido = ?, edad = ?, grado_id = ?, fecha_registro = ? WHERE id = ?";

        try (
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getGrado());
            ps.setDate(5, new java.sql.Date(alumno.getFechaResgistro().getTime()));
            ps.setInt(6, alumno.getId());

            int rows = ps.executeUpdate();
            editarAlumPad(alumno.getId(), alumno.getPadre());
            return rows > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar el alumno: " + e.toString());
            return false;
        }
    }
    
    public boolean editarAlumPad(int idAlumno, int idPadre) {
        String sqlDelete = "DELETE FROM alumno_padre WHERE alumno_id = ?";
        String sqlInsert = "INSERT INTO alumno_padre (alumno_id, padre_id) VALUES (?, ?)";

        PreparedStatement psDelete = null;
        PreparedStatement psInsert = null;

        try {
            con.setAutoCommit(false);

            // Eliminar la relación existente (si la hay)
            psDelete = con.prepareStatement(sqlDelete);
            psDelete.setInt(1, idAlumno);
            psDelete.executeUpdate();

            // Insertar la nueva relación
            psInsert = con.prepareStatement(sqlInsert);
            psInsert.setInt(1, idAlumno);
            psInsert.setInt(2, idPadre);
            psInsert.executeUpdate();

            con.commit();  // Confirmar la transacción
            return true;

        } catch (SQLException e) {
            // Revertir cambios si ocurre un error
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error al deshacer cambios: " + ex.getMessage());
                }
            }
            System.out.println("Error al editar la relación del alumno: " + e.getMessage());
            return false;

        } finally {
            // Cerrar recursos y restablecer autocommit
            try {
                if (psDelete != null) psDelete.close();
                if (psInsert != null) psInsert.close();
                con.setAutoCommit(true);  // Restablecer autocommit
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
    
    public boolean editarAlumSecc(int idAlumno, List<Integer> listaIDSecciones) {
        String sqlDelete = "DELETE FROM alumno_seccion WHERE alumno_id = ?";
        String sqlInsert = "INSERT INTO alumno_seccion (alumno_id, seccion_id) VALUES (?, ?)";

        PreparedStatement psDelete = null;
        PreparedStatement psInsert = null;

        try {
            con.setAutoCommit(false);
            
            psDelete = con.prepareStatement(sqlDelete);
            psDelete.setInt(1, idAlumno);
            psDelete.executeUpdate();
            
            psInsert = con.prepareStatement(sqlInsert);
            for (Integer idSeccion : listaIDSecciones) {
                psInsert.setInt(1, idAlumno);
                psInsert.setInt(2, idSeccion);
                psInsert.addBatch();
            }

            psInsert.executeBatch();
            con.commit();
            return true;

        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error al deshacer cambios: " + ex.getMessage());
                }
            }
            System.out.println("Error al guardar relaciones del alumno: " + e.getMessage());
            return false;
        } finally {
            try {
                if (psDelete != null) psDelete.close();
                if (psInsert != null) psInsert.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
    
    public List<Integer> obtenerSeccionesActuales(int idAlumno) {
        List<Integer> seccionesActuales = new ArrayList<>();
        String sql = "SELECT seccionid FROM alumno_seccion WHERE alumno_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                seccionesActuales.add(rs.getInt("seccion_id"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las secciones actuales del alumno: " + e.toString());
        }
        return seccionesActuales;
    }
    
    public void eliminarSeccionesPorAlumno(int idAlumno) {
        String sql = "DELETE FROM alumno_seccion WHERE alumno_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAlumno);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar las secciones del alumno: " + e.toString());
        }
    }

    public void insertarSeccionPorAlumno(int idAlumno, int idSeccion) {
        String sql = "INSERT INTO alumno_seccion (alumno_id, seccion_id) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAlumno);
            ps.setInt(2, idSeccion);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar la sección del alumno: " + e.toString());
        }
    }
    
    
     public boolean tieneUsuario(int padreId) {
    boolean tieneUsuario = false;
    String sql = "SELECT COUNT(*) FROM usuario WHERE alumno_id = ?"; // Ajusta la consulta según tu estructura de base de datos

    try (Connection con = conexion.establecerConexion();
         PreparedStatement pst = con.prepareStatement(sql)) {
        
        pst.setInt(1, padreId);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            tieneUsuario = rs.getInt(1) > 0; // Si el conteo es mayor que 0, el padre tiene un usuario asignado
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Manejo de errores
    }
    return tieneUsuario;
}
    
    
}
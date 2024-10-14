package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProfesoresDAO {
    
    Conexion conexion = new Conexion();
    Connection con = conexion.establecerConexion();

    public int guardarProfesor(Profesor profesor) {
        String sql = "INSERT INTO profesor (nombre, apellido, edad, identificacion, tipo_identificacion, telefono, email, genero, direccion, fecha_nacimiento, estado_civil, especialidad, salario, fecha_contratacion, fecha_terminacion_contrato, estado_contrato, tipo_contrato) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int idGenerado = -1;

        try (
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getApellido());
            ps.setInt(3, profesor.getEdad());
            ps.setString(4, profesor.getIdentificacion());
            ps.setString(5, profesor.getTipo_identificacion());
            ps.setString(6, profesor.getTelefono());
            ps.setString(7, profesor.getEmail());
            ps.setString(8, profesor.getGenero());
            ps.setString(9, profesor.getDireccion());
            ps.setDate(10, new java.sql.Date(profesor.getFecha_nacimiento().getTime()));
            ps.setString(11, profesor.getEstado_civil());
            ps.setString(12, profesor.getEspecialidad());
            ps.setInt(13, profesor.getSalario());
            ps.setDate(14, new java.sql.Date(profesor.getFecha_contratacion().getTime()));
            ps.setDate(15, new java.sql.Date(profesor.getFecha_terminacion_contrato().getTime()));
            ps.setString(16, profesor.getEstado_contrato());
            ps.setString(17, profesor.getTipo_contrato());

            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar el profesor: " + e.toString());
        }

        return idGenerado;
    }

    public boolean guardarProfGradSecc(int idProfesor, List<int[]> listaRelaciones) {
       String sql = "INSERT INTO profesor_grado (profesor_id, grado_id, seccion_id) VALUES (?, ?, ?)";

       try (PreparedStatement ps = con.prepareStatement(sql)) {
           for (int[] relacion : listaRelaciones) {
               int idGrado = relacion[0];
               Integer idSeccion = (relacion[1] != -1) ? relacion[1] : null;

               ps.setInt(1, idProfesor);
               ps.setInt(2, idGrado);

               if (idSeccion != null) {
                   ps.setInt(3, idSeccion);
               } else {
                   ps.setNull(3, java.sql.Types.INTEGER);
               }

               ps.addBatch();
           }

           ps.executeBatch();
           return true;
       } catch (SQLException e) {
           System.out.println("Error al guardar las relaciones: " + e.toString());
           return false;
       } finally {
           try {
               con.close();
           } catch (Exception e) {
               System.out.println("Error al cerrar la conexión: " + e.toString());
           }
       }
   }

    public List listarProfesores() {
        List<Profesor> listProf = new ArrayList();
        String sql = "SELECT * FROM profesor";

        try (
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Profesor pr = new Profesor();
                
                pr.setId(rs.getInt("id"));
                pr.setIdentificacion(rs.getString("identificacion"));
                pr.setNombre(rs.getString("nombre"));
                pr.setApellido(rs.getString("apellido"));
                pr.setEspecialidad(rs.getString("especialidad"));
                pr.setEstado_contrato(rs.getString("estado_contrato"));
                pr.setFecha_contratacion(rs.getDate("fecha_contratacion"));
                pr.setFecha_terminacion_contrato(rs.getDate("fecha_terminacion_contrato"));
                listProf.add(pr);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los profesores: " + e.toString());
        }
        return listProf;
    }
    
    public String columnaGrados(int idProfesor) {
        StringBuilder nombresGrados = new StringBuilder();
        String sql = "SELECT g.nombre " +
                     "FROM grado g " +
                     "INNER JOIN profesor_grado pg ON g.id = pg.grado_id " +
                     "WHERE pg.profesor_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProfesor);
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
    
    public String columnaSecciones(int idProfesor) {
        StringBuilder nombresSecciones = new StringBuilder();
        String sql = "SELECT s.nombre " +
                     "FROM seccion s " +
                     "INNER JOIN profesor_grado pg ON s.id = pg.seccion_id " +
                     "WHERE pg.profesor_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProfesor);
            ResultSet rs = ps.executeQuery();
            
            Set<String> seccionesSet = new HashSet<>();
            while (rs.next()) {
                seccionesSet.add(rs.getString("nombre"));
            }
            
            nombresSecciones.append(String.join(", ", seccionesSet));

        } catch (SQLException e) {
            System.out.println("Error al consultar los nombres de las secciones: " + e.getMessage());
        }

        return nombresSecciones.toString();
    }
    
    public boolean eliminarProfesor(int id) {
        String eliminarReferenciasSQL = "DELETE FROM profesor_grado WHERE profesor_id = ?";
        String eliminarProfesorSQL = "DELETE FROM profesor WHERE id = ?";

        try {
            try (PreparedStatement ps = con.prepareStatement(eliminarReferenciasSQL)) {
                ps.setInt(1, id);
                ps.execute();
            }

            try (PreparedStatement ps = con.prepareStatement(eliminarProfesorSQL)) {
                ps.setInt(1, id);
                ps.execute();
            }

            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el profesor: " + e.toString());
            return false;
        }
    }
    
    public Profesor consultarDatos(int id) {
        String sql = "SELECT * FROM profesor WHERE id = ?";
        Profesor profesor = new Profesor();

        try (Connection con = new Conexion().establecerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    profesor.setId(rs.getInt("id"));
                    profesor.setNombre(rs.getString("nombre"));
                    profesor.setApellido(rs.getString("apellido"));
                    profesor.setEdad(rs.getInt("edad"));
                    profesor.setIdentificacion(rs.getString("identificacion"));
                    profesor.setTipo_identificacion(rs.getString("tipo_identificacion"));
                    profesor.setTelefono(rs.getString("telefono"));
                    profesor.setEmail(rs.getString("email"));
                    profesor.setGenero(rs.getString("genero"));
                    profesor.setDireccion(rs.getString("direccion"));
                    profesor.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                    profesor.setEstado_civil(rs.getString("estado_civil"));
                    profesor.setEspecialidad(rs.getString("especialidad"));
                    profesor.setSalario(rs.getInt("salario"));
                    profesor.setFecha_contratacion(rs.getDate("fecha_contratacion"));
                    profesor.setFecha_terminacion_contrato(rs.getDate("fecha_terminacion_contrato"));
                    profesor.setEstado_contrato(rs.getString("estado_contrato"));
                    profesor.setTipo_contrato(rs.getString("tipo_contrato"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos del profesor: " + e.toString());
        }

        return profesor;
    }
    
    public List<Integer> consultarGrados(int idProfesor) {
        List<Integer> grados = new ArrayList<>();
        String sql = "SELECT grado_id FROM profesor_grado WHERE profesor_id = ?";

        try (
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idProfesor);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    grados.add(rs.getInt("grado_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los grados: " + e.toString());
        } 
        return grados;
    }
    
    public List<Integer> consultarSecciones(int idProfesor) {
        List<Integer> secciones = new ArrayList<>();
        String sql = "SELECT seccion_id FROM profesor_grado WHERE profesor_id = ?";

        try (
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idProfesor);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    secciones.add(rs.getInt("seccion_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar las secciones: " + e.toString());
        } 
        return secciones;
    }
    
    public boolean editarProfesor(Profesor profesor) {
        String sql = "UPDATE profesor SET nombre = ?, apellido = ?, edad = ?, identificacion = ?, tipo_identificacion = ?, telefono = ?, email = ?, genero = ?, direccion = ?, fecha_nacimiento = ?, estado_civil = ?, especialidad = ?, salario = ?, fecha_contratacion = ?, fecha_terminacion_contrato = ?, estado_contrato = ?, tipo_contrato = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getApellido());
            ps.setInt(3, profesor.getEdad());
            ps.setString(4, profesor.getIdentificacion());
            ps.setString(5, profesor.getTipo_identificacion());
            ps.setString(6, profesor.getTelefono());
            ps.setString(7, profesor.getEmail());
            ps.setString(8, profesor.getGenero());
            ps.setString(9, profesor.getDireccion());
            ps.setDate(10, new java.sql.Date(profesor.getFecha_nacimiento().getTime()));
            ps.setString(11, profesor.getEstado_civil());
            ps.setString(12, profesor.getEspecialidad());
            ps.setInt(13, profesor.getSalario());
            ps.setDate(14, new java.sql.Date(profesor.getFecha_contratacion().getTime()));
            ps.setDate(15, new java.sql.Date(profesor.getFecha_terminacion_contrato().getTime()));
            ps.setString(16, profesor.getEstado_contrato());
            ps.setString(17, profesor.getTipo_contrato());
            ps.setInt(18, profesor.getId());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el profesor: " + e.getMessage());
            return false;
        }
    }
    
    public boolean editarProfGradSecc(int idProfesor, List<int[]> listaRelaciones) {
        PreparedStatement psDelete = null;
        PreparedStatement psInsert = null;

        try {
            con.setAutoCommit(false);
            
            String sqlDelete = "DELETE FROM profesor_grado WHERE profesor_id = ?";
            psDelete = con.prepareStatement(sqlDelete);
            psDelete.setInt(1, idProfesor);
            psDelete.executeUpdate();
            
            String sqlInsert = "INSERT INTO profesor_grado (profesor_id, grado_id, seccion_id) VALUES (?, ?, ?)";
            psInsert = con.prepareStatement(sqlInsert);

            for (int[] relacion : listaRelaciones) {
                int idGrado = relacion[0];
                Integer idSeccion = (relacion[1] != -1) ? relacion[1] : null;

                psInsert.setInt(1, idProfesor);
                psInsert.setInt(2, idGrado);
                if (idSeccion != null) {
                    psInsert.setInt(3, idSeccion);
                } else {
                    psInsert.setNull(3, java.sql.Types.INTEGER);
                }

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
            System.out.println("Error al actualizar las relaciones: " + e.getMessage());
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
    
    public List listarGrados() {
        List<Grado> listGrad = new ArrayList();
        String sql = "SELECT * FROM grado";

        try (
            PreparedStatement ps = con.prepareStatement(sql);
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
    
    public List<Seccion> listarSecciones(int id) {
        List<Seccion> listSecc = new ArrayList<>();
        String sql = "SELECT * FROM seccion WHERE grado_id = ?";

        try (
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Seccion sc = new Seccion();
                    sc.setId(rs.getInt("id"));
                    sc.setNombre(rs.getString("nombre"));
                    sc.setHorarioInicio(rs.getTime("horario_inicio"));
                    sc.setHorarioFinal(rs.getTime("horario_final"));
                    sc.setGrado(rs.getInt("grado_id"));
                    listSecc.add(sc);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar las secciones: " + e.toString());
        }
        return listSecc;
    }
    
        public List<int[]> obtenerRelacionesGradoSeccion(int profesorId) {
        List<int[]> relaciones = new ArrayList<>();
        String sql = "SELECT grado_id, seccion_id FROM profesor_grado WHERE profesor_id = ?";

        try (
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, profesorId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int gradoId = rs.getInt("grado_id");
                    int seccionId = rs.getInt("seccion_id");
                    relaciones.add(new int[]{gradoId, seccionId});
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las relaciones: " + e.toString());
        }
        return relaciones;
    }

    public String obtenerNombreGrado(int gradoId) {
        String nombre = null;
        String sql = "SELECT nombre FROM grado WHERE id = ?";

        try (
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, gradoId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nombre = rs.getString("nombre");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre del grado: " + e.toString());
        }
        return nombre;
    }

    public String obtenerNombreSeccion(int seccionId) {
        String nombre = null;
        String sql = "SELECT nombre FROM seccion WHERE id = ?";

        try (
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, seccionId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nombre = rs.getString("nombre");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre de la sección: " + e.toString());
        }
        return nombre;
    }
}

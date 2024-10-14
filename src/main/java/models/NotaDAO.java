package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotaDAO {
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
    
    public List listarNotas() {
        List<Nota> listNotas = new ArrayList();
        String sql = "SELECT * FROM nota";

        try (PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Nota nt = new Nota();
                
                nt.setId(rs.getInt("id"));
                nt.setNombre(rs.getString("nombre"));
                nt.setCalificacion(rs.getFloat("calificacion"));
                nt.setFechaRegistro(rs.getDate("fecha_registro"));
                nt.setAlumnoID(rs.getInt("alumno_id"));
                nt.setCursoID(rs.getInt("curso_id"));
                listNotas.add(nt);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar las notas: " + e.toString());
        }
        return listNotas;
    }
    
    public List<Curso> listarCursos() {
        List<Curso> listCurs = new ArrayList<>();
        String sql = "SELECT * FROM curso";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Curso cs= new Curso();
                cs.setId(rs.getInt("id"));
                cs.setNombre(rs.getString("nombre"));
                cs.setDescripcion(rs.getString("descripcion"));
                cs.setNivel(rs.getString("nivel"));
                cs.setProfesorId(rs.getInt("profesor_id"));
                cs.setGradoId(rs.getInt("grado_id"));
                cs.setSeccionId(rs.getInt("seccion_id"));
                listCurs.add(cs);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los alumnos: " + e.toString());
        }
        return listCurs;
    }
    
    public String columnaAlumno(int notaID) {
        String nombreAlumno = null;
        String sql = "SELECT alm.nombre, alm.apellido " +
                     "FROM alumno alm " +
                     "INNER JOIN nota nt ON alm.id = nt.alumno_id " +
                     "WHERE nt.id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, notaID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nombreAlumno = rs.getString("nombre") + " " + rs.getString("apellido");
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar el nombre del Alumno: " + e.getMessage());
        }

        return nombreAlumno;
    }
    
    public String columnaCurso(int notaID) {
        String nombreCurso = null;
        String sql = "SELECT cr.nombre " +
                     "FROM curso cr " +
                     "INNER JOIN nota nt ON cr.id = nt.curso_id " +
                     "WHERE nt.id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, notaID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nombreCurso = rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar el nombre del Curso: " + e.getMessage());
        }

        return nombreCurso;
    }
    
    public Nota consultarDatos(int id) {
        String sql = "SELECT * FROM nota WHERE id = ?";
        Nota nota = new Nota();

        try (
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nota.setId(rs.getInt("id"));
                    nota.setNombre(rs.getString("nombre"));
                    nota.setCalificacion(rs.getFloat("calificacion"));
                    nota.setFechaRegistro(rs.getDate("fecha_registro"));
                    nota.setAlumnoID(rs.getInt("alumno_id"));
                    nota.setCursoID(rs.getInt("curso_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos de la Nota: " + e.toString());
        }

        return nota;
    }
    
    public int guardarNota(Nota nota) {
        String sql = "INSERT INTO nota (nombre, calificacion, fecha_registro, alumno_id, curso_id) VALUES (?, ?, ?, ?, ?)";
        int idGenerado = -1;
        
        try (
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, nota.getNombre());
            ps.setFloat(2, nota.getCalificacion());
            ps.setDate(3, new java.sql.Date(nota.getFechaRegistro().getTime()));
            ps.setInt(4, nota.getAlumnoID());
            ps.setInt(5, nota.getCursoID());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar la nota: " + e.toString());
        }
        
        return idGenerado;
    }
    
    public boolean eliminarNota(int id) {
        String sql = "DELETE FROM nota WHERE id = ?";
        try (
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la nota: " + e.toString());
            return false;
        }
    }
    
    public boolean editarNota(Nota nota) {
        String sql = "UPDATE nota SET nombre = ?, calificacion = ?, fecha_registro = ?, alumno_id = ?, curso_id = ? WHERE id = ?";

        try (
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nota.getNombre());
            ps.setFloat(2, nota.getCalificacion());
            ps.setDate(3, new java.sql.Date(nota.getFechaRegistro().getTime()));
            ps.setInt(4, nota.getAlumnoID());
            ps.setInt(5, nota.getCursoID());
            ps.setInt(6, nota.getId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar la nota: " + e.toString());
            return false;
        }
    }
}
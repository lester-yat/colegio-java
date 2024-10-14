package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionDAO {
    Conexion conexion = new Conexion();
    Connection con = conexion.establecerConexion();

    public boolean agregarInscripcion(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripcion (alumno_id, grado_id, fecha_inscripcion) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, inscripcion.getAlumnoId());
            ps.setInt(2, inscripcion.getGradoId());
            ps.setDate(3, new java.sql.Date(inscripcion.getFechaInscripcion().getTime()));
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public int guardarInscripcion(Inscripcion inscripcion) {
    String sql = "INSERT INTO inscripcion (alumno_id, grado_id, fecha_inscripcion) VALUES (?, ?, ?)";
    
    try {
        Connection con = conexion.establecerConexion();
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, inscripcion.getAlumnoId());
        ps.setInt(2, inscripcion.getGradoId());
        ps.setDate(3, new java.sql.Date(inscripcion.getFechaInscripcion().getTime()));
        
        int rows = ps.executeUpdate();
        if (rows > 0) {
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al guardar la inscripción: " + e.getMessage());
    }
    
    return -1;
}

public boolean editarInscripcion(Inscripcion inscripcion) {
    String sql = "UPDATE inscripcion SET alumno_id = ?, grado_id = ?, fecha_inscripcion = ? WHERE id = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, inscripcion.getAlumnoId());
        ps.setInt(2, inscripcion.getGradoId());
        ps.setDate(3, new java.sql.Date(inscripcion.getFechaInscripcion().getTime()));
        ps.setInt(4, inscripcion.getId());

        int rowsUpdated = ps.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public boolean eliminarInscripcion(int id) {
        String sql = "DELETE FROM inscripcion WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

 public List<Inscripcion> listarInscripciones() {
    List<Inscripcion> lista = new ArrayList<>();
    String sql = "SELECT i.id, i.alumno_id, a.nombre, i.grado_id, i.fecha_inscripcion " +
                 "FROM inscripcion i " +
                 "JOIN alumno a ON i.alumno_id = a.id";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setId(rs.getInt("id"));
            inscripcion.setAlumnoId(rs.getInt("alumno_id"));
            inscripcion.setNombreAlumno(rs.getString("nombre"));
            inscripcion.setGradoId(rs.getInt("grado_id"));
            inscripcion.setFechaInscripcion(rs.getDate("fecha_inscripcion"));
            lista.add(inscripcion);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}

public List<Alumno> listarAlumnos() {
    List<Alumno> alumnos = new ArrayList<>();
    String sql = "SELECT * FROM alumno";
    
    try {
        Connection con = conexion.establecerConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Alumno alumno = new Alumno();
            alumno.setId(rs.getInt("id"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setApellido(rs.getString("apellido"));
            alumnos.add(alumno);
        }
    } catch (SQLException e) {
        System.out.println("Error al listar alumnos: " + e.getMessage());
    }
    
    return alumnos;
}

public List<Grado> listarGrados() {
    List<Grado> grados = new ArrayList<>();
    String sql = "SELECT * FROM grado";
    
    try {
        Connection con = conexion.establecerConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Grado grado = new Grado();
            grado.setId(rs.getInt("id"));
            grado.setNombre(rs.getString("nombre"));
            grados.add(grado);
        }
    } catch (SQLException e) {
        System.out.println("Error al listar grados: " + e.getMessage());
    }
    
    return grados;
}
/*
public Inscripcion consultarInscripcion(int id) {
    String sql = "SELECT i.id, i.alumnoid, i.gradoid, i.fecha_inscripcion, a.nombre " +
                 "FROM inscripcion i " +
                 "JOIN alumno a ON i.alumnoid = a.id " +
                 "WHERE i.id=?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setId(rs.getInt("id"));
            inscripcion.setAlumnoId(rs.getInt("alumnoid"));
            inscripcion.setGradoId(rs.getInt("gradoid"));
            inscripcion.setFechaInscripcion(rs.getDate("fecha_inscripcion"));
            // Asigna el nombre del alumno, si es necesario
            inscripcion.setNombreAlumno(rs.getString("nombre"));
            return inscripcion;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null; // Retorna null si no se encuentra la inscripción
}

*/



// Método para obtener una inscripción por ID
    public Inscripcion obtenerInscripcionPorId(int id) {
        Inscripcion inscripcion = null;
        String sql = "SELECT * FROM inscripcion WHERE id = ?";
        
        try (Connection con = conexion.establecerConexion(); 
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                inscripcion = new Inscripcion();
                inscripcion.setId(rs.getInt("id"));
                inscripcion.setAlumnoId(rs.getInt("alumno_id"));
                inscripcion.setGradoId(rs.getInt("grado_id"));
                inscripcion.setFechaInscripcion(rs.getDate("fecha_inscripcion"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la inscripción: " + e.getMessage());
        }
        
        return inscripcion;
    }

    // Método para actualizar una inscripción
    public boolean actualizarInscripcion(int id, Inscripcion inscripcion) {
        String sql = "UPDATE inscripcion SET alumno_id = ?, grado_id = ?, fecha_inscripcion = ? WHERE id = ?";

        try (Connection con = conexion.establecerConexion(); 
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, inscripcion.getAlumnoId());
            pstmt.setInt(2, inscripcion.getGradoId());
            pstmt.setDate(3, new java.sql.Date(inscripcion.getFechaInscripcion().getTime()));
            pstmt.setInt(4, id);

            int filasActualizadas = pstmt.executeUpdate();
            return filasActualizadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar la inscripción: " + e.getMessage());
            return false;
        }
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
}
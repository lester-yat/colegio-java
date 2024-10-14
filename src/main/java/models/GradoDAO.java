package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradoDAO {
    
    Conexion conexion = new Conexion();
    Connection con = conexion.establecerConexion();

    public boolean guardarGrado(Grado grado) {
        String sql = "INSERT INTO grado (nombre, salon, nivel, anio, jornada, cantidad_max_estudiantes) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, grado.getNombre());
            ps.setString(2, grado.getSalon());
            ps.setString(3, grado.getNivel());
            ps.setDate(4, new java.sql.Date(grado.getAnio().getTime()));
            ps.setString(5, grado.getJornada());
            ps.setInt(6, grado.getCantidadMaxEstudiantes());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al guardar el grado: " + e.toString());
            return false;
        } finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
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
    
    public String consultarSeccion(int id) {
        StringBuilder nombresSecciones = new StringBuilder();
        String sql = "SELECT nombre FROM seccion WHERE grado_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            List<String> secciones = new ArrayList<>();
            while (rs.next()) {
                secciones.add(rs.getString("nombre"));
            }
            
            for (int i = 0; i < secciones.size(); i++) {
                nombresSecciones.append(secciones.get(i));
                if (i < secciones.size() - 1) {
                    nombresSecciones.append(", ");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar las secciones: " + e.getMessage());
        }

        return nombresSecciones.toString();
    }
    
    public String consultarProfesor(int id) {
        String nombreProfesor = null;
        
        String sql1 = "SELECT profesor_id FROM profesor_grado WHERE grado_id = ?";
        try (
            PreparedStatement ps1 = con.prepareStatement(sql1)) {

            ps1.setInt(1, id);
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                int idProfesor = rs1.getInt("profesor_id");
                
                String sql2 = "SELECT nombre, apellido FROM profesor WHERE id = ?";
                try (
                    PreparedStatement ps2 = con.prepareStatement(sql2)) {

                    ps2.setInt(1, idProfesor);
                    ResultSet rs2 = ps2.executeQuery();

                    if (rs2.next()) {
                        String nombre = rs2.getString("nombre");
                        String apellido = rs2.getString("apellido");
                        nombreProfesor = nombre + " " + apellido;
                    }
                } catch (SQLException e) {
                    System.out.println("Error al consultar al profesor: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el profesor_grado: " + e.getMessage());
        }

        return nombreProfesor;
    }
    
    public boolean eliminarGrado(int id) {
        String sql = "DELETE FROM grado WHERE id = ?";
        try (
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el grado: " + e.toString());
            return false;
        }
    }
    
    public Grado consultarDatos(int id) {
        String sql = "SELECT * FROM grado WHERE id = ?";
        Grado grado = new Grado();

        try (
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    grado.setId(rs.getInt("id"));
                    grado.setNombre(rs.getString("nombre"));
                    grado.setSalon(rs.getString("salon"));
                    grado.setNivel(rs.getString("nivel"));
                    grado.setAnio(rs.getDate("anio"));
                    grado.setJornada(rs.getString("jornada"));
                    grado.setCantidadMaxEstudiantes(rs.getInt("cantidad_max_estudiantes"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos del grado: " + e.toString());
        }

        return grado;
    }
    
    public boolean editarGrado(Grado grado) {
        String sql = "UPDATE grado SET nombre = ?, salon = ?, nivel = ?, anio = ?, jornada = ?, cantidad_max_estudiantes = ? WHERE id = ?";

        try (
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, grado.getNombre());
            ps.setString(2, grado.getSalon());
            ps.setString(3, grado.getNivel());
            ps.setDate(4, new java.sql.Date(grado.getAnio().getTime()));
            ps.setString(5, grado.getJornada());
            ps.setInt(6, grado.getCantidadMaxEstudiantes());
            ps.setInt(7, grado.getId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar el grado: " + e.toString());
            return false;
        }
    }
}
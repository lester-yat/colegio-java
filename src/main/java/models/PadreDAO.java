package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PadreDAO {

    Conexion conexion = new Conexion();
    Connection con = conexion.establecerConexion();

    // Guardar un nuevo padre
    public boolean guardarPadre(Padre padre) {
        String sql = "INSERT INTO padre (nombre, apellido, edad, identificacion, telefono, parentesco) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, padre.getNombre());
            ps.setString(2, padre.getApellido());
            ps.setInt(3, padre.getEdad());
            ps.setString(4, padre.getIdentificacion());
            ps.setString(5, padre.getTelefono());
            ps.setString(6, padre.getParentesco());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al guardar el padre: " + e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.toString());
            }
        }
    }

    // Listar todos los padres
    public List<Padre> listarPadres() {
        List<Padre> listaPadres = new ArrayList<>();
        String sql = "SELECT * FROM padre";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Padre padre = new Padre();
                padre.setId(rs.getInt("id"));
                padre.setNombre(rs.getString("nombre"));
                padre.setApellido(rs.getString("apellido"));
                padre.setEdad(rs.getInt("edad"));
                padre.setIdentificacion(rs.getString("identificacion"));
                padre.setTelefono(rs.getString("telefono"));
                padre.setParentesco(rs.getString("parentesco"));
                listaPadres.add(padre);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los padres: " + e.toString());
        }
        return listaPadres;
    }

    // Consultar un padre por su ID
    public Padre consultarDatos(int id) {
        String sql = "SELECT * FROM padre WHERE id = ?";
        Padre padre = new Padre();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    padre.setId(rs.getInt("id"));
                    padre.setNombre(rs.getString("nombre"));
                    padre.setApellido(rs.getString("apellido"));
                    padre.setEdad(rs.getInt("edad"));
                    padre.setIdentificacion(rs.getString("identificacion"));
                    padre.setTelefono(rs.getString("telefono"));
                    padre.setParentesco(rs.getString("parentesco"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos del padre: " + e.toString());
        }

        return padre;
    }

    // Actualizar los datos de un padre
    public boolean editarPadre(Padre padre) {
        String sql = "UPDATE padre SET nombre = ?, apellido = ?, edad = ?, identificacion = ?, telefono = ?, parentesco = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, padre.getNombre());
            ps.setString(2, padre.getApellido());
            ps.setInt(3, padre.getEdad());
            ps.setString(4, padre.getIdentificacion());
            ps.setString(5, padre.getTelefono());
            ps.setString(6, padre.getParentesco());
            ps.setInt(7, padre.getId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar el padre: " + e.toString());
            return false;
        }
    }

    // Eliminar un padre por su ID
    public boolean eliminarPadre(int id) {
        String sql = "DELETE FROM padre WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el padre: " + e.toString());
            return false;
        }
    }
}

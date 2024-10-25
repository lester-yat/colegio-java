
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import views.AsgUA;

public class UsuarioDAO {

    private Connection con;

    // Constructor que establece la conexión utilizando la clase Conexion
    public UsuarioDAO() {
        Conexion conexion = new Conexion();
        this.con = conexion.establecerConexion();
    }

    // Método para autenticar un usuario (Login)
    public Usuario autenticarUsuario(String nombreUsuario, String contrasenia) throws SQLException {
        String query = "SELECT * FROM usuario WHERE nombre_usuario = ? AND contrasenia = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, nombreUsuario);
        statement.setString(2, contrasenia);  // Se debe pasar el hash de la contraseña para comparar

        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            // Crear y retornar el objeto Usuario
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNombreUsuario(rs.getString("nombre_usuario"));
            usuario.setContrasenia(rs.getString("contrasenia"));
            usuario.setRol(rs.getString("rol"));
            usuario.setProfesorId(rs.getObject("profesor_id", Integer.class)); // Permitir NULL
            usuario.setAlumnoId(rs.getObject("alumno_id", Integer.class));     // Permitir NULL
            return usuario;
        }
        return null; // Usuario no encontrado
    }

    // Método para insertar un nuevo usuario
    public boolean insertarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nombre_usuario, contrasenia, rol, profesor_id, alumno_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, usuario.getNombreUsuario());
        statement.setString(2, usuario.getContrasenia());
        statement.setString(3, usuario.getRol());
        statement.setObject(4, usuario.getProfesorId()); // Puede ser NULL
        statement.setObject(5, usuario.getAlumnoId());   // Puede ser NULL

        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
    }

    // Método para actualizar un usuario existente
    public boolean actualizarUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE usuario SET nombre_usuario = ?, contrasenia = ?, rol = ?, profesor_id = ?, alumno_id = ? WHERE id = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, usuario.getNombreUsuario());
        statement.setString(2, usuario.getContrasenia());
        statement.setString(3, usuario.getRol());
        statement.setObject(4, usuario.getProfesorId());
        statement.setObject(5, usuario.getAlumnoId());
        statement.setInt(6, usuario.getId());

        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    }

    // Método para eliminar un usuario por ID
    public boolean eliminarUsuario(int id) throws SQLException {
        String query = "DELETE FROM usuario WHERE id = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, id);

        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
    }

    // Método para obtener un usuario por ID
    public Usuario obtenerUsuarioPorId(int id) throws SQLException {
        String query = "SELECT * FROM usuario WHERE id = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNombreUsuario(rs.getString("nombre_usuario"));
            usuario.setContrasenia(rs.getString("contrasenia"));
            usuario.setRol(rs.getString("rol"));
            usuario.setProfesorId(rs.getObject("profesor_id", Integer.class)); // Permitir NULL
            usuario.setAlumnoId(rs.getObject("alumno_id", Integer.class));     // Permitir NULL
            return usuario;
        }
        return null; // Usuario no encontrado
    }

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() throws SQLException {
        String query = "SELECT * FROM usuario";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        List<Usuario> usuarios = new ArrayList<>();
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNombreUsuario(rs.getString("nombre_usuario"));
            usuario.setContrasenia(rs.getString("contrasenia"));
            usuario.setRol(rs.getString("rol"));
            usuario.setProfesorId(rs.getObject("profesor_id", Integer.class)); // Permitir NULL
            usuario.setAlumnoId(rs.getObject("alumno_id", Integer.class));     // Permitir NULL
            usuarios.add(usuario);
        }
        return usuarios;
    }
    
    
    //validar contraseña
    
    
    public boolean validarUsuario(String usuario, String contrasenia) {
    Conexion conexion = new Conexion();
    Connection con = conexion.establecerConexion();
    
    // Cambiamos la consulta para que apunte a la tabla "usuario"
    String sql = "SELECT * FROM usuario WHERE nombre_usuario = ? AND contrasenia = ?";
    
    String contraseñaEncriptada = Seguridad.encriptarSHA256(contrasenia); // Encriptar la contraseña ingresada

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario);
        ps.setString(2, contraseñaEncriptada); // Comparar con la contraseña encriptada
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            return true; // Usuario válido
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return false; // Usuario o contraseña incorrectos
}

    
    public Usuario obtenerUsuarioPorNombre(String nombreUsuario) {
    Conexion conexion = new Conexion();
    Connection con = conexion.establecerConexion();
    
    String sql = "SELECT * FROM usuario WHERE nombre_usuario = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreUsuario);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNombreUsuario(rs.getString("nombre_usuario"));
            usuario.setContrasenia(rs.getString("contrasenia"));
            usuario.setRol(rs.getString("rol"));
            usuario.setProfesorId(rs.getObject("profesor_id", Integer.class));
            usuario.setAlumnoId(rs.getObject("alumno_id", Integer.class));
            return usuario;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return null;
}

    
    
     
}

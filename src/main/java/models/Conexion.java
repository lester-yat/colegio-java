package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    Connection conectar = null;

    String usuario = "SA";
    String contrasena = "<Strong@Pass1>";
    String bd = "dbcolegio";
    String ip = "localhost";
    String puerto = "1433";

    String cadena = "jdbc:sqlserver://" + ip + ":" + puerto + ";databaseName=" + bd + ";encrypt=false;";

    public Connection establecerConexion() {
        try {
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
//            System.out.println("Conectado a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos, error: " + e.getMessage());
            e.printStackTrace();
        }
        return conectar;
    }

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();
    }
}
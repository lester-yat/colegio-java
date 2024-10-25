package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagoDAO {
    Conexion conexion = new Conexion();
    Connection con = conexion.establecerConexion();
    
    public List listarPagos() {
        List<Pago> listPagos = new ArrayList();
        String sql = "SELECT * FROM Pago";

        try (PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pago pago = new Pago();
                
                pago.setId(rs.getInt("id"));
                pago.setCodigoTransaccion(rs.getInt("codigo_transaccion"));
                pago.setTipoTransaccion(rs.getString("tipo_transaccion"));
                pago.setNoCuentaCliente(rs.getString("no_cuenta_cliente"));
                pago.setNoCuentaDestino(rs.getString("no_cuenta_destino"));
                pago.setFechaHora(rs.getDate("fecha_hora"));
                pago.setMonto(rs.getFloat("monto"));
                pago.setEstado(rs.getInt("estado_id"));
                listPagos.add(pago);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los Pagos: " + e.toString());
        }
        return listPagos;
    }
    
    public String obtenerEstadoInicial(int idEstado) {
        String nombreEstado = "";
        String sql = "SELECT descripcion FROM estado_pago WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idEstado);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nombreEstado = rs.getString("descripcion");
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el estado inicial del pago: " + e.getMessage());
        }

        return nombreEstado;
    }
    
    public String obtenerEstadoPago(int idEstadoPago) {
        StringBuilder descripcionEstado = new StringBuilder();
        String sql = "SELECT ep.descripcion " +
                     "FROM estado_pago ep " +
                     "INNER JOIN pago p ON ep.id = p.estado_id " +
                     "WHERE p.estado_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idEstadoPago);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                descripcionEstado.append(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el estado del pago: " + e.getMessage());
        }
        
        return descripcionEstado.toString();
    }

    public Pago consultarDatos(int id) {
        String sql = "SELECT * FROM pago WHERE codigo_transaccion = ?";
        Pago pago = new Pago();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pago.setId(rs.getInt("id"));
                    pago.setCodigoTransaccion(rs.getInt("codigo_transaccion"));
                    pago.setTipoTransaccion(rs.getString("tipo_transaccion"));
                    pago.setNoCuentaCliente(rs.getString("no_cuenta_cliente"));
                    pago.setNoCuentaDestino(rs.getString("no_cuenta_destino"));
                    pago.setFechaHora(rs.getDate("fecha_hora"));
                    pago.setMonto(rs.getDouble("monto"));
                    pago.setEstado(rs.getInt("estado_id"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar los datos del pago: " + e.getMessage());
        }

        return pago;
    }
    
    public int guardarPago(Pago pago) {
        String sql = "INSERT INTO pago (codigo_transaccion, tipo_transaccion, no_cuenta_cliente, no_cuenta_destino, fecha_hora, monto, estado_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int idGenerado = -1;

        try (PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            int codigoTransaccion = getNextCodigoTransaccion();
            ps.setInt(1, codigoTransaccion);
            ps.setString(2, pago.getTipoTransaccion());
            ps.setString(3, pago.getNoCuentaCliente());
            ps.setString(4, pago.getNoCuentaDestino());
            ps.setDate(5, new java.sql.Date(pago.getFechaHora().getTime()));
            ps.setDouble(6, pago.getMonto());
            ps.setInt(7, pago.getEstado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar el pago: " + e.toString());
        }

        return idGenerado;
    }

    private int getNextCodigoTransaccion() {
        int nextValue = -1;
        String sql = "SELECT NEXT VALUE FOR seq_codigo_transaccion";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                nextValue = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el siguiente valor de la secuencia: " + e.getMessage());
        }

        return nextValue;
    }
    
    public boolean eliminarPago(int id) {
        String sql = "DELETE FROM pago WHERE codigo_transaccion = ?";
        try (
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el pago: " + e.toString());
            return false;
        }
    }
    
    public boolean editarPago(Pago pago) {
        String sql = "UPDATE pago SET codigo_transaccion = ?, tipo_transaccion = ?, no_cuenta_cliente = ?, no_cuenta_destino = ?, fecha_hora = ?, monto = ?, estado_id = ? WHERE id = ?";

        try (
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, pago.getCodigoTransaccion());
            ps.setString(2, pago.getTipoTransaccion());
            ps.setString(3, pago.getNoCuentaCliente());
            ps.setString(4, pago.getNoCuentaDestino());
            ps.setDate(5, new java.sql.Date(pago.getFechaHora().getTime()));
            ps.setDouble(6, pago.getMonto());
            ps.setInt(7, pago.getEstado());
            ps.setInt(8, pago.getId());

            int rows = ps.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar el alumno: " + e.toString());
            return false;
        }
    }
    
    public List<String> listarEstadosPago() {
        List<String> estados = new ArrayList<>();
        String sql = "SELECT descripcion FROM estado_pago";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                estados.add(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los estados de pago: " + e.getMessage());
        }

        return estados;
    }
    
    public Integer obtenerIdPorDescripcion(String descripcion) {
        String sql = "SELECT id FROM estado_pago WHERE descripcion = ?";
        Integer id = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, descripcion);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del estado de pago: " + e.getMessage());
        }

        return id;
    }
}
package models;

import java.util.Date;

public class Pago {
    private int id;
    private int codigoTransaccion;
    private String tipoTransaccion;
    private String noCuentaCliente;
    private String noCuentaDestino;
    private Date fechaHora;
    private double monto;
    private int estado;

    public Pago() {
    }

    public Pago(int id, int codigoTransaccion, String tipoTransaccion, String noCuentaCliente, String noCuentaDestino, Date fechaHora, double monto, int estado) {
        this.id = id;
        this.codigoTransaccion = codigoTransaccion;
        this.tipoTransaccion = tipoTransaccion;
        this.noCuentaCliente = noCuentaCliente;
        this.noCuentaDestino = noCuentaDestino;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(int codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getNoCuentaCliente() {
        return noCuentaCliente;
    }

    public void setNoCuentaCliente(String noCuentaCliente) {
        this.noCuentaCliente = noCuentaCliente;
    }

    public String getNoCuentaDestino() {
        return noCuentaDestino;
    }

    public void setNoCuentaDestino(String noCuentaDestino) {
        this.noCuentaDestino = noCuentaDestino;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
}

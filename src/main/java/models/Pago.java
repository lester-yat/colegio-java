package models;

import java.util.Date;

public class Pago {
    private int codigoTransaccion;
    private int tipoTransaccion;
    private int noCuentaCliente;
    private int noCuentaDestino;
    private Date fechaHora;
    private double monto;
    private String estado;

    public Pago() {
    }

    public Pago(int codigoTransaccion, int tipoTransaccion, int noCuentaCliente, int noCuentaDestino, Date fechaHora, double monto, String estado) {
        this.codigoTransaccion = codigoTransaccion;
        this.tipoTransaccion = tipoTransaccion;
        this.noCuentaCliente = noCuentaCliente;
        this.noCuentaDestino = noCuentaDestino;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.estado = estado;
    }

    public int getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(int codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public int getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(int tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public int getNoCuentaCliente() {
        return noCuentaCliente;
    }

    public void setNoCuentaCliente(int noCuentaCliente) {
        this.noCuentaCliente = noCuentaCliente;
    }

    public int getNoCuentaDestino() {
        return noCuentaDestino;
    }

    public void setNoCuentaDestino(int noCuentaDestino) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

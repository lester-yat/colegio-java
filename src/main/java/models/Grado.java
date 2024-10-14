package models;

import java.util.Date;

public class Grado {
    private int id;
    private String nombre;
    private String salon;
    private String nivel;
    private Date anio;
    private String jornada;
    private int cantidadMaxEstudiantes;

    public Grado() {
    }

    public Grado(int id, String nombre, String salon, String nivel, Date anio, String jornada, int cantidadMaxEstudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.salon = salon;
        this.nivel = nivel;
        this.anio = anio;
        this.jornada = jornada;
        this.cantidadMaxEstudiantes = cantidadMaxEstudiantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public int getCantidadMaxEstudiantes() {
        return cantidadMaxEstudiantes;
    }

    public void setCantidadMaxEstudiantes(int cantidadMaxEstudiantes) {
        this.cantidadMaxEstudiantes = cantidadMaxEstudiantes;
    }
}

package models;

import java.sql.Time;
import java.util.Date;

public class Seccion {
    private int id;
    private String nombre;
    private Time horarioInicio;
    private Time horarioFinal;
    private int grado;

    public Seccion() {
    }

    public Seccion(int id, String nombre, Time horarioInicio, Time horarioFinal, int grado) {
        this.id = id;
        this.nombre = nombre;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.grado = grado;
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

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Time getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Time horarioFinal) {
        this.horarioFinal = horarioFinal;
    }
    
    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }
}

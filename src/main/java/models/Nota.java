package models;

import java.util.Date;

public class Nota {
   private int id;
   private String nombre;
   private float calificacion;
   private Date fechaRegistro;
   private int alumnoID;
   private int cursoID;

    public Nota() {
    }

    public Nota(int id, String nombre, float calificacion, Date fechaRegistro, int alumnoID, int cursoID) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.fechaRegistro = fechaRegistro;
        this.alumnoID = alumnoID;
        this.cursoID = cursoID;
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

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getAlumnoID() {
        return alumnoID;
    }

    public void setAlumnoID(int alumnoID) {
        this.alumnoID = alumnoID;
    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }   
    
    
}
package models;

import java.util.Date;

public class Alumno {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private int padre;
    private int grado;
    private Date fechaResgistro;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String apellido, int edad, int padre, int grado, Date fechaResgistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.padre = padre;
        this.grado = grado;
        this.fechaResgistro = fechaResgistro;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public Date getFechaResgistro() {
        return fechaResgistro;
    }

    public void setFechaResgistro(Date fechaResgistro) {
        this.fechaResgistro = fechaResgistro;
    }

    
}
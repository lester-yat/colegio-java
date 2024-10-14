package models;

public class Curso {
    private int id;
    private String nombre;
    private String descripcion;
    private String nivel;
    private int profesorId;
    private int gradoId;
    private int seccionId;

    public Curso() {
    }

    public Curso(int id, String nombre, String descripcion, String nivel, int profesorId, int gradoId, int seccionId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.profesorId = profesorId;
        this.gradoId = gradoId;
        this.seccionId = seccionId;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public int getGradoId() {
        return gradoId;
    }

    public void setGradoId(int gradoId) {
        this.gradoId = gradoId;
    }

    public int getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(int seccionId) {
        this.seccionId = seccionId;
    }
}

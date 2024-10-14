package models;



public class Padre {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String identificacion;
    private String telefono;
    private String parentesco;

    // Constructor vacío
    public Padre() {
    }

    // Constructor con todos los campos
    public Padre(int id, String nombre, String apellido, int edad, String identificacion, String telefono, String parentesco) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.parentesco = parentesco;
    }

    // Getters y Setters para cada campo
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}

package models;

import java.util.Date;

public class Profesor {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String identificacion;
    private String tipo_identificacion;
    private String telefono;
    private String email;
    private String genero;
    private String direccion;
    private Date fecha_nacimiento;
    private String estado_civil;
    private String especialidad;
    private int salario;
    private Date fecha_contratacion;
    private Date fecha_terminacion_contrato;
    private String estado_contrato;
    private String tipo_contrato;

    public Profesor() {
    }

    public Profesor(String nombre, String apellido, int edad, String identificacion, String tipo_identificacion, String telefono, String email, String genero, String direccion, Date fecha_nacimiento, String estado_civil, String especialidad, int salario, Date fecha_contratacion, Date fecha_terminacion_contrato, String estado_contrato, String tipo_contrato) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.identificacion = identificacion;
        this.tipo_identificacion = tipo_identificacion;
        this.telefono = telefono;
        this.email = email;
        this.genero = genero;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado_civil = estado_civil;
        this.especialidad = especialidad;
        this.salario = salario;
        this.fecha_contratacion = fecha_contratacion;
        this.fecha_terminacion_contrato = fecha_terminacion_contrato;
        this.estado_contrato = estado_contrato;
        this.tipo_contrato = tipo_contrato;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public Date getFecha_terminacion_contrato() {
        return fecha_terminacion_contrato;
    }

    public void setFecha_terminacion_contrato(Date fecha_terminacion_contrato) {
        this.fecha_terminacion_contrato = fecha_terminacion_contrato;
    }

    public String getEstado_contrato() {
        return estado_contrato;
    }

    public void setEstado_contrato(String estado_contrato) {
        this.estado_contrato = estado_contrato;
    }

    public String getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(String tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }
}
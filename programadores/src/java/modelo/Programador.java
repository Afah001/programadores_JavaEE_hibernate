/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Set;

/**
 *
 * @author FRAGATA
 */
public class Programador {
    private int id_Programador;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private int salarioBase;
    private Set<Tarea> tareas;

    public Programador() {
        
    }

    

    public Programador(String nombre, String apellido, String direccion, String telefono, int salarioBase) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.salarioBase = salarioBase;
    }

    public int getId_Programador() {
        return id_Programador;
    }

    public void setId_Programador(int id_Programador) {
        this.id_Programador = id_Programador;
    }

    
    
    public int getId_proyecto() {
        return id_Programador;
    }

    public void setId_proyecto(int id_Programador) {
        this.id_Programador = id_Programador;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Set<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(Set<Tarea> tareas) {
        this.tareas = tareas;
    }
    
    
    
}

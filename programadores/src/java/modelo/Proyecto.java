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
public class Proyecto {
    
    private int id_Proyecto;
    private String nombre;
    private int duracion;
    private String cliente;
    private  int costoTotal;
    private  Set <Tarea> tareas;

    public Proyecto() {
        
    }

    public  void setCostoTotal(Set <Tarea> tareas){
        
         this.costoTotal=0;
      
        for(Tarea t: tareas){
            
             costoTotal+=t.getCosto(); //costoTotal=costoTotal+t.getCosto();
            
        }
        
    }

    public  int getCostoTotal() {
        return costoTotal;
    }
    
    
    
    public int getId_Proyecto() {
        return id_Proyecto;
    }

    public void setId_Proyecto(int id_Proyecto) {
        this.id_Proyecto = id_Proyecto;
    }

    
    public Proyecto(String nombre, int duracion, String cliente) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Set<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(Set<Tarea> tareas) {
        this.tareas = tareas;
    }
    
    
    
    
    
    
}

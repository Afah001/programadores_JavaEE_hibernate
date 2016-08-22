/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;


/**
 *
 * @author ANDERSON
 */
public class Tarea {
    
    private int id_Tarea; 
    private Programador programador;  //responsable uno a muchos
    private Proyecto proyecto;  //uno a uno
    private int costo;
    private int duracion;
    private String estado;
    private Date fecha;

    public Tarea() {
        
    }

    public Tarea(Programador programador,Proyecto proyecto,int duracion, Date fecha) {
        this.programador=programador;
        this.proyecto=proyecto;
        this.estado="proceso";
        this.duracion = duracion;
        this.fecha = fecha;
    }

    

    public int getId_Tarea() {
        return id_Tarea;
    }

    public void setId_Tarea(int id_Tarea) {
        this.id_Tarea = id_Tarea;
    }

    public Programador getProgramador() {
        return programador;
    }

    public void setProgramador(Programador programador) {
        this.programador = programador;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
    
    

    

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
    
    public void calcularCosto(int duracion,int salarioBase) {
        //costo tarea= cantidad de horas(duracion)* valorHora
        //valor de hora
        int valorHora=salarioBase/23;
        this.costo=duracion*valorHora;
      
    }
    
    
}

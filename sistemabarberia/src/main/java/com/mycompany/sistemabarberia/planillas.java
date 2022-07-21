/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Jonathan Laux
 */
@Entity
public class planillas implements Serializable{
    @Id 
    private int idplanilla;
    @Column
    private int IDEmpleado;
    @Column
    private String Periodo;
    @Column
    private double TotalPagar;
    @Column
    private boolean Activo;

    public planillas(int idplanilla, int IDEmpleado, String Periodo, double TotalPagar, boolean Activo) {
        this.idplanilla = idplanilla;
        this.IDEmpleado = IDEmpleado;
        this.Periodo = Periodo;
        this.TotalPagar = TotalPagar;
        this.Activo = Activo;
    }

    public planillas() {
    }

    
    
    public int getIdplanilla() {
        return idplanilla;
    }

    public void setIdplanilla(int idplanilla) {
        this.idplanilla = idplanilla;
    }

    public int getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(int IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    public double getTotalPagar() {
        return TotalPagar;
    }

    public void setTotalPagar(double TotalPagar) {
        this.TotalPagar = TotalPagar;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    } 
}

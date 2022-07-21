/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Jonathan Laux
 */
@Entity
public class puestohistoricoempleado implements Serializable{
    @Id
    private int numpuesto;
    @Column
    private int IDEmpleado;
    @Column
    private int IDPuesto;
    @Column(nullable=true)
    private Date FechaInicial;
    @Column
    private Date FechaFinal;
    @Column 
    private boolean Activo;

    public puestohistoricoempleado(int numpuesto, int IDEmpleado, int IDPuesto, Date FechaInicial, Date FechaFinal, boolean Activo) {
        this.numpuesto = numpuesto;
        this.IDEmpleado = IDEmpleado;
        this.IDPuesto = IDPuesto;
        this.FechaInicial = FechaInicial;
        this.FechaFinal = FechaFinal;
        this.Activo = Activo;
    }

    public puestohistoricoempleado() {
    }
    
    public int getNumpuesto() {
        return numpuesto;
    }

    public void setNumpuesto(int numpuesto) {
        this.numpuesto = numpuesto;
    }

    public int getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(int IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public int getIDPuesto() {
        return IDPuesto;
    }

    public void setIDPuesto(int IDPuesto) {
        this.IDPuesto = IDPuesto;
    }

    public Date getFechaInicial() {
        return FechaInicial;
    }

    public void setFechaInicial(Date FechaInicial) {
        this.FechaInicial = FechaInicial;
    }

    public Date getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(Date FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }
    
    
    
    
}

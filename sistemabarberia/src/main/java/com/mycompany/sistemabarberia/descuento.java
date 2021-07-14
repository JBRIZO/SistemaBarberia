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
 * @author flore
 */
@Entity
public class descuento implements Serializable{
    @Id 
    private int iddescuento;
    
    @Column
    private int IDTipoDescuento;
    
    @Column
    private Date FechaInicio;
    
    @Column
    private Date FechaFinal;
    
    @Column
    private double Valor;
    
    @Column
    private boolean Activo;

    public int getIddescuento() {
        return iddescuento;
    }

    public void setIddescuento(int iddescuento) {
        this.iddescuento = iddescuento;
    }

    public int getIDTipoDescuento() {
        return IDTipoDescuento;
    }

    public void setIDTipoDescuento(int IDTipoDescuento) {
        this.IDTipoDescuento = IDTipoDescuento;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(Date FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }
    
    
    
    
}

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
 * @author flore
 */
@Entity
public class deduccionesempleadomensual implements Serializable {
    @Id
    private int numdeduccion;
    
    @Column
    private int IDEmpleado;
    
    @Column
    private int IDTipoDeduccion;
    
    @Column
    private double Valor;
    
    @Column
    private String Periodo;
    
    @Column 
    private boolean Activo;

    public int getNumdeduccion() {
        return numdeduccion;
    }

    public void setNumdeduccion(int numdeduccion) {
        this.numdeduccion = numdeduccion;
    }

    public int getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(int IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public int getIDTipoDeduccion() {
        return IDTipoDeduccion;
    }

    public void setIDTipoDeduccion(int IDTipoDeduccion) {
        this.IDTipoDeduccion = IDTipoDeduccion;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author Kesil
 */
public class bonosempleadomensual implements Serializable {

    @Id
    private int numbono;

    @Column
    private int IDEmpleado;
    @Column
    private int TipoBono;
    @Column
    private double Valor;
    @Column
    private String Periodo;
    @Column
    private boolean Activo;

    public int getNumbono() {
    return numbono;
  
    
}

    public int getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(int IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public int getTipoBono() {
        return TipoBono;
    }

    public void setTipoBono(int TipoBono) {
        this.TipoBono = TipoBono;
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
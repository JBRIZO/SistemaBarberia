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
 * @author Kesil
 */
@Entity
public class bonosempleadomensual implements Serializable {
    
    @Id
    private int numbono;
    @Column
    private int IDEmpleado;
    @Column
    private int IDTipoBono;
    @Column
    private double Valor;
    @Column
    private String Periodo;
    @Column
    private boolean Activo;

    public int getNumbono() {
        return numbono;
    }

    public void setNumbono(int numbono) {
        this.numbono = numbono;
    }

    public int getIdEmpleado() {
        return IDEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IDEmpleado = IdEmpleado;
    }

    public int getIDTipoBono() {
        return IDTipoBono;
    }

    public void setIDTipoBono(int IDTipoBono) {
        this.IDTipoBono = IDTipoBono;
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

    public boolean getActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }
    
}

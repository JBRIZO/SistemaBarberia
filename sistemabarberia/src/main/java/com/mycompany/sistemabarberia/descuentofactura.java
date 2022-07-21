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
public class descuentofactura implements Serializable{
    @Id
    private int numdescuento;
    @Column
    private int IDFactura;
    @Column
    private int IDDescuento;
    @Column
    private double Valor;
    @Column
    private boolean Activo;

    public descuentofactura(int numdescuento, int IDFactura, int IDDescuento, double Valor, boolean Activo) {
        this.numdescuento = numdescuento;
        this.IDFactura = IDFactura;
        this.IDDescuento = IDDescuento;
        this.Valor = Valor;
        this.Activo = Activo;
    }

    public descuentofactura(){}
    
    public int getNumdescuento() {
        return numdescuento;
    }

    public void setNumdescuento(int numdescuento) {
        this.numdescuento = numdescuento;
    }

    public int getIDFactura() {
        return IDFactura;
    }

    public void setIDFactura(int IDFactura) {
        this.IDFactura = IDFactura;
    }

    public int getIDDescuento() {
        return IDDescuento;
    }

    public void setIDDescuento(int IDDescuento) {
        this.IDDescuento = IDDescuento;
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

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
public class facturasanuladas implements Serializable{
    @Id
    private int idfacturaanulada;
    @Column
    private int IDFacturaEncabezado;
    @Column
    private int IDEmpleado;
    @Column
    private String Motivo;

    public int getIdfacturaanulada() {
        return idfacturaanulada;
    }

    public void setIdfacturaanulada(int idfacturaanulada) {
        this.idfacturaanulada = idfacturaanulada;
    }

    public int getIDFacturaEncabezado() {
        return IDFacturaEncabezado;
    }

    public void setIDFacturaEncabezado(int IDFacturaEncabezado) {
        this.IDFacturaEncabezado = IDFacturaEncabezado;
    }

    public int getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(int IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }
    
    
}

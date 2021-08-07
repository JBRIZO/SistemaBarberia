/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;

/**
 *
 * @author Jonathan Laux
 */
@Entity
public class facturaencabezado implements Serializable{
    @Id
    private int idfacturaencabezado;
    @Column
    private int IDCliente;
    @Column
    private int IDEmpleado;
    @Column
    private int IDTipoPago;
    @Column
    private int IDParametro;
    @Column
    private int IDEstado;
    @Column
    private Date FechaFactura;

    public int getIdfacturaencabezado() {
        return idfacturaencabezado;
    }

    public void setIdfacturaencabezado(int idfacturaencabezado) {
        this.idfacturaencabezado = idfacturaencabezado;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public int getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(int IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public int getIDTipoPago() {
        return IDTipoPago;
    }

    public void setIDTipoPago(int IDTipoPago) {
        this.IDTipoPago = IDTipoPago;
    }

    public int getIDParametro() {
        return IDParametro;
    }

    public void setIDParametro(int IDParametro) {
        this.IDParametro = IDParametro;
    }

    public int getIDEstado() {
        return IDEstado;
    }

    public void setIDEstado(int IDEstado) {
        this.IDEstado = IDEstado;
    }

    public Date getFechaFactura() {
        return FechaFactura;
    }

    public void setFechaFactura(Date FechaFactura) {
        this.FechaFactura = FechaFactura;
    }
    
    
}

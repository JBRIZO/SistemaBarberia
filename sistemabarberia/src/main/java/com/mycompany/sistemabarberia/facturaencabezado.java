/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

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
    private int IDVendedor;
    
    @Column(nullable=true)
    private Integer IDBarbero;
    
    @Column
    private int IDTipoPago;
    @Column
    private int IDParametro;
    @Column
    private int IDEstado;
    @Column
    private String FechaFactura;
    
    @Column(nullable=true)
    private String NumTarjeta;

    public String getNumTarjeta() {
        return NumTarjeta;
    }

    public void setNumTarjeta(String NumTarjeta) {
        this.NumTarjeta = NumTarjeta;
    }

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

    public int getIDVendedor() {
        return IDVendedor;
    }

    public void setIDVendedor(int IDVendedor) {
        this.IDVendedor = IDVendedor;
    }

    public Integer getIDBarbero() {
        return IDBarbero;
    }

    public void setIDBarbero(Integer IDBarbero) {
        this.IDBarbero = IDBarbero;
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

    public String getFechaFactura() {
        return FechaFactura;
    }

    public void setFechaFactura(String FechaFactura) {
        this.FechaFactura = FechaFactura;
    }
    
    
}

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
    @Column(nullable=true)
    private String NumFactura;
    
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
    private double MontoTarjeta;
    @Column
    private double TotalFactura;
    
    @Column(nullable=true)
    private String NumTarjeta;

    public facturaencabezado(int idfacturaencabezado, int IDCliente, String NumFactura, int IDVendedor, Integer IDBarbero, int IDTipoPago, int IDParametro, int IDEstado, String FechaFactura, double MontoTarjeta, double TotalFactura, String NumTarjeta) {
        this.idfacturaencabezado = idfacturaencabezado;
        this.IDCliente = IDCliente;
        this.NumFactura = NumFactura;
        this.IDVendedor = IDVendedor;
        this.IDBarbero = IDBarbero;
        this.IDTipoPago = IDTipoPago;
        this.IDParametro = IDParametro;
        this.IDEstado = IDEstado;
        this.FechaFactura = FechaFactura;
        this.MontoTarjeta = MontoTarjeta;
        this.TotalFactura = TotalFactura;
        this.NumTarjeta = NumTarjeta;
    }

    public facturaencabezado(){}
    
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

    public double getMontoTarjeta() {
        return MontoTarjeta;
    }

    public void setMontoTarjeta(double MontoTarjeta) {
        this.MontoTarjeta = MontoTarjeta;
    }

    public double getTotalFactura() {
        return TotalFactura;
    }

    public void setTotalFactura(double TotalFactura) {
        this.TotalFactura = TotalFactura;
    }

    public String getNumFactura() {
        return NumFactura;
    }

    public void setNumFactura(String NumFactura) {
        this.NumFactura = NumFactura;
    }
    
    
    
}

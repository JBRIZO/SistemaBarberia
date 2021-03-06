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
public class precioshistoricosproductos implements Serializable {
    @Id
    private int numprecio;
    @Column
    private int IDProducto;
    @Column
    private Date FechaInicial;
    @Column(nullable=true)
    private Date FechaFinal;
    @Column
    private double Precio;
    @Column
    private boolean Activo;

    public precioshistoricosproductos(int numprecio, int IDProducto, Date FechaInicial, Date FechaFinal, double Precio, boolean Activo) {
        this.numprecio = numprecio;
        this.IDProducto = IDProducto;
        this.FechaInicial = FechaInicial;
        this.FechaFinal = FechaFinal;
        this.Precio = Precio;
        this.Activo = Activo;
    }

    public precioshistoricosproductos() {
    }

    
    
    public int getNumprecio() {
        return numprecio;
    }

    public void setNumprecio(int numprecio) {
        this.numprecio = numprecio;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
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

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }
    
    
    
}

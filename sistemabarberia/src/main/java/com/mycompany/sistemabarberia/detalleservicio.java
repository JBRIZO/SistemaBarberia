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
public class detalleservicio implements Serializable {
    @Id
    private int numdetalleservicio;
    @Column
    private int IDFacturaEncabezado;
    @Column
    private int IDServicio;
    @Column
    private int Cantidad;
    @Column
    private double Precio;

    public int getNumdetalleservicio() {
        return numdetalleservicio;
    }

    public void setNumdetalleservicio(int numdetalleservicio) {
        this.numdetalleservicio = numdetalleservicio;
    }

    public int getIDFacturaEncabezado() {
        return IDFacturaEncabezado;
    }

    public void setIDFacturaEncabezado(int IDFacturaEncabezado) {
        this.IDFacturaEncabezado = IDFacturaEncabezado;
    }

    public int getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(int IDServicio) {
        this.IDServicio = IDServicio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    
    
}

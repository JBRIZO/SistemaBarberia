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
public class detalleproducto implements Serializable{
    @Id 
    private int numdetalle;
    @Column
    private int IDFacturaEncabezado;
    @Column
    private int IDProducto;
    @Column
    private int Cantidad;
    @Column
    private double Precio;

    public int getNumdetalle() {
        return numdetalle;
    }

    public void setNumdetalle(int numdetalle) {
        this.numdetalle = numdetalle;
    }

    public int getIDFacturaEncabezado() {
        return IDFacturaEncabezado;
    }

    public void setIDFacturaEncabezado(int IDFacturaEncabezado) {
        this.IDFacturaEncabezado = IDFacturaEncabezado;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
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

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
public class productos implements Serializable{
    @Id
    private int idproducto;
    @Column
    private String NomProducto;
    @Column
    private int StockActual;
    @Column
    private int StockMinimo;
    @Column
    private int StockMaximo;
    @Column
    private boolean Activo;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNomProducto() {
        return NomProducto;
    }

    public void setNomProducto(String NomProducto) {
        this.NomProducto = NomProducto;
    }

    public int getStockActual() {
        return StockActual;
    }

    public void setStockActual(int StockActual) {
        this.StockActual = StockActual;
    }

    public int getStockMinimo() {
        return StockMinimo;
    }

    public void setStockMinimo(int StockMinimo) {
        this.StockMinimo = StockMinimo;
    }

    public int getStockMaximo() {
        return StockMaximo;
    }

    public void setStockMaximo(int StockMaximo) {
        this.StockMaximo = StockMaximo;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }
    
    @Override
    public String toString()
    {
        return idproducto + ". " + NomProducto;
    }
    
    
    
}

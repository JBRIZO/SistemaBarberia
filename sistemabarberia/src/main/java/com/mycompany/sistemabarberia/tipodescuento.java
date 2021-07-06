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
public class tipodescuento implements Serializable{
    
    @Id
    private int idtipodescuento;
    
    @Column
    private String NomDescuento;
    
    @Column
    private boolean Activo;

    public int getIdtipodescuento() {
        return idtipodescuento;
    }

    public void setIdtipodescuento(int idtipodescuento) {
        this.idtipodescuento = idtipodescuento;
    }

    public String getNomDescuento() {
        return NomDescuento;
    }

    public void setNomDescuento(String NomDescuento) {
        this.NomDescuento = NomDescuento;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }     
}

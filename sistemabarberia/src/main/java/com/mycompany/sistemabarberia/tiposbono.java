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
public class tiposbono implements Serializable{
    @Id
    private int idtipobono;
    @Column
    private String NomBono;
    @Column
    private boolean Activo;

    public tiposbono(int idtipobono, String NomBono, boolean Activo) {
        this.idtipobono = idtipobono;
        this.NomBono = NomBono;
        this.Activo = Activo;
    }

    public tiposbono() {
    }

    
    
    public int getIdtipobono() {
        return idtipobono;
    }

    public void setIdtipobono(int idtipobono) {
        this.idtipobono = idtipobono;
    }

    public String getNomBono() {
        return NomBono;
    }

    public void setNomBono(String NomBono) {
        this.NomBono = NomBono;
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
        return idtipobono + ". " + NomBono;
    }
    
    
    
}

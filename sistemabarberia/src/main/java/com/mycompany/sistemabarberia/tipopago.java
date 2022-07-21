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
 * @author flore
 */
@Entity
public class tipopago implements Serializable {
    @Id
    private int idtipopago;
    
    @Column
    private String TipoPago;
    
    @Column
    private Boolean Activo;

    public tipopago() {
    }

    public tipopago(int idtipopago, String TipoPago, Boolean Activo) {
        this.idtipopago = idtipopago;
        this.TipoPago = TipoPago;
        this.Activo = Activo;
    }

    
    
    public int getIdtipopago() {
        return idtipopago;
    }

    public void setIdtipopago(int idtipopago) {
        this.idtipopago = idtipopago;
    }

    public String getTipoPago() {
        return TipoPago;
    }

    public void setTipoPago(String TipoPago) {
        this.TipoPago = TipoPago;
    }

    public Boolean getActivo() {
        return Activo;
    }

    public void setActivo(Boolean Activo) {
        this.Activo = Activo;
    }
    
    @Override 
    public String toString()
    {
        return idtipopago + ". " + TipoPago;
    }
    
}

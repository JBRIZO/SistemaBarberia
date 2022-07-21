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
 * @author Kesil 
 */
@Entity
public class puesto implements Serializable{
    
    @Id
    private int idpuesto;
    
    @Column
    private String NomPuesto;
    
    @Column
    private boolean Activo;

    public puesto(int idpuesto, String NomPuesto, boolean Activo) {
        this.idpuesto = idpuesto;
        this.NomPuesto = NomPuesto;
        this.Activo = Activo;
    }

    public puesto() {
    }

    public int getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(int idpuesto) {
        this.idpuesto = idpuesto;
    }

    public String getNomPuesto() {
        return NomPuesto;
    }

    public void setNomPuesto(String NomPuesto) {
        this.NomPuesto = NomPuesto;
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
        return idpuesto + ". " +NomPuesto;
    }
    
   
}

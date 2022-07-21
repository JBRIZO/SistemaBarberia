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
public class servicios implements Serializable {
    
    @Id
    private int idservicio;
    
    @Column
    private String NomServicio;
    
    @Column
    private boolean Activo;

    public servicios(int idservicio, String NomServicio, boolean Activo) {
        this.idservicio = idservicio;
        this.NomServicio = NomServicio;
        this.Activo = Activo;
    }

    public servicios() {
    }

    
    
    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public String getNomServicio() {
        return NomServicio;
    }

    public void setNomServicio(String NomServicio) {
        this.NomServicio = NomServicio;
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
        return idservicio + ". " + NomServicio;
    }
    
}

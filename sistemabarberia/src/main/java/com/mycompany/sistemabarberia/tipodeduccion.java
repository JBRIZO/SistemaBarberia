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
public class tipodeduccion implements Serializable{
    
    @Id
    private int idtipodeduccion;
    
    @Column
    private String Nombre;
    
    @Column
    private boolean Activo;

    public int getIdtipodeduccion() {
        return idtipodeduccion;
    }

    public void setIdtipodeduccion(int idtipodeduccion) {
        this.idtipodeduccion = idtipodeduccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }   
}

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
public class usuarios implements Serializable {
   @Id  
   private int idusuario;
   
   @Column 
    private int IDEmpleado;
   
   @Column
   private String NomCuenta;
   
   @Column
   private String Contraseña;
   
   @Column
   private Boolean Activo;
   
   

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(int IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public String getNomCuenta() {
        return NomCuenta;
    }

    public void setNomCuenta(String NomCuenta) {
        this.NomCuenta = NomCuenta;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public Boolean getActivo() {
        return Activo;
    }

    public void setActivo(Boolean Activo) {
        this.Activo = Activo;
    }
   
   
    
}

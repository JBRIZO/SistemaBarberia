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
   
   @Column(unique=true) 
    private int IDEmpleado;
   
   @Column
   private String NomCuenta;
   
   @Column
   private String Contrasena;
   
   @Column
   private Boolean Activo;
   
   @Column
   private int Intentos;
   
   public usuarios(){}
   
   public usuarios(int idUsuario, int idEmpleado, String nomCuenta, String password, Boolean activo, int intentos){
       this.idusuario = idUsuario;
       this.IDEmpleado = idEmpleado;
       this.NomCuenta = nomCuenta;
       this.Contrasena = password;
       this.Activo = activo;
       this.Intentos = intentos;
   }
   
   
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

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public Boolean getActivo() {
        return Activo;
    }

    public void setActivo(Boolean Activo) {
        this.Activo = Activo;
    }

    public int getIntentos() {
        return Intentos;
    }

    public void setIntentos(int Intentos) {
        this.Intentos = Intentos;
    }
   
   
    
}

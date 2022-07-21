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
public class permisosusuario implements Serializable{
    @Id
    private int idpermisousuario;
    @Column
    private int IDUsuario;
    @Column
    private int IDPermiso;
    @Column
    private boolean Activo;
    @Column
    private boolean Nuevo;
    @Column
    private boolean Imprimir;
    @Column
    private boolean Modificar;
    @Column
    private boolean Lista;
    @Column
    private boolean Desactivar;
    @Column
    private boolean Puesto;
    @Column
    private boolean NuevoPrecio;
    @Column
    private boolean NuevoPuesto;

    public int getIdpermisousuario() {
        return idpermisousuario;
    }

    public void setIdpermisousuario(int idpermisousuario) {
        this.idpermisousuario = idpermisousuario;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public int getIDPermiso() {
        return IDPermiso;
    }

    public void setIDPermiso(int IDPermiso) {
        this.IDPermiso = IDPermiso;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    public boolean isNuevo() {
        return Nuevo;
    }

    public void setNuevo(boolean Nuevo) {
        this.Nuevo = Nuevo;
    }

    public boolean isImprimir() {
        return Imprimir;
    }

    public void setImprimir(boolean Imprimir) {
        this.Imprimir = Imprimir;
    }

    public boolean isModificar() {
        return Modificar;
    }

    public void setModificar(boolean Modificar) {
        this.Modificar = Modificar;
    }

    public boolean isLista() {
        return Lista;
    }

    public void setLista(boolean Lista) {
        this.Lista = Lista;
    }

    public boolean isDesactivar() {
        return Desactivar;
    }

    public void setDesactivar(boolean Desactivar) {
        this.Desactivar = Desactivar;
    }

    public boolean isPuesto() {
        return Puesto;
    }

    public void setPuesto(boolean Puesto) {
        this.Puesto = Puesto;
    }

    public boolean isNuevoPrecio() {
        return NuevoPrecio;
    }

    public void setNuevoPrecio(boolean NuevoPrecio) {
        this.NuevoPrecio = NuevoPrecio;
    }

    public boolean isNuevoPuesto() {
        return NuevoPuesto;
    }

    public void setNuevoPuesto(boolean NuevoPuesto) {
        this.NuevoPuesto = NuevoPuesto;
    }
    
    
    
}

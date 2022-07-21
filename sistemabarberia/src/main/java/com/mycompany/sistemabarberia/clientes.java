/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Jonathan Laux
 */
@Entity
public class clientes implements Serializable {
    @Id
    private int idcliente;
    @Column
    private String NomCliente;
    @Column
    private String ApeCliente;
    @Column
    private int IDTipoDocumento;
    @Column
    private String NumDocumento;
    @Column 
    private int IDServicio;
    @Column
    private Date FechaNacimiento;
    @Column
    private String NumTelefono;
    @Column
    private boolean Activo;
    
    public clientes(){}

    public clientes(int idcliente, String NomCliente, String ApeCliente, int IDTipoDocumento, String NumDocumento, int IDServicio, Date FechaNacimiento, String NumTelefono, boolean Activo) {
        this.idcliente = idcliente;
        this.NomCliente = NomCliente;
        this.ApeCliente = ApeCliente;
        this.IDTipoDocumento = IDTipoDocumento;
        this.NumDocumento = NumDocumento;
        this.IDServicio = IDServicio;
        this.FechaNacimiento = FechaNacimiento;
        this.NumTelefono = NumTelefono;
        this.Activo = Activo;
    }
    
    

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNomCliente() {
        return NomCliente;
    }

    public void setNomCliente(String NomCliente) {
        this.NomCliente = NomCliente;
    }

    public String getApeCliente() {
        return ApeCliente;
    }

    public void setApeCliente(String ApeCliente) {
        this.ApeCliente = ApeCliente;
    }

    public int getIDTipoDocumento() {
        return IDTipoDocumento;
    }

    public void setIDTipoDocumento(int IDTipoDocumento) {
        this.IDTipoDocumento = IDTipoDocumento;
    }

    public String getNumDocumento() {
        return NumDocumento;
    }

    public void setNumDocumento(String NumDocumento) {
        this.NumDocumento = NumDocumento;
    }

    public int getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(int IDServicio) {
        this.IDServicio = IDServicio;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getNumTelefono() {
        return NumTelefono;
    }

    public void setNumTelefono(String NumTelefono) {
        this.NumTelefono = NumTelefono;
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
        return idcliente + ". " +  NomCliente + " " + ApeCliente;
    }
    
}

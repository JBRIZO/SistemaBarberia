/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author flore
 */
@Entity
public class clientes implements Serializable {
    @Id
    private int idcliente;
    
    @Column 
    private int IDTipoDocumento;
    
    @Column
    private int NumDocumento;
    
    @Column 
    private int IDServicio;
    
    @Column 
    private String NomCliente;
    
    @Column
    private String ApeCliente;
    
    @Column 
    private String NumTelefono;
    
    @Column
    private Date FechaNacimiento;
    
    @Column
    private Boolean Activo;
    
    

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIDTipoDocumento() {
        return IDTipoDocumento;
    }

    public void setIDTipoDocumento(int IDTipoDocumento) {
        this.IDTipoDocumento = IDTipoDocumento;
    }

    public int getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(int IDServicio) {
        this.IDServicio = IDServicio;
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

    public String getNumTelefono() {
        return NumTelefono;
    }

    public void setNumTelefono(String NumTelefono) {
        this.NumTelefono = NumTelefono;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public Boolean getActivo() {
        return Activo;
    }

    public void setActivo(Boolean Activo) {
        this.Activo = Activo;
    }

    public int getNumDocumento() {
        return NumDocumento;
    }

    public void setNumDocumento(int NumDocumento) {
        this.NumDocumento = NumDocumento;
    }
    
    
    
    
    

    
}

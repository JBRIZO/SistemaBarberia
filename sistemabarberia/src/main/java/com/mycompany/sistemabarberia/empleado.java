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
 * @author Jonathan Laux
 */
@Entity
public class empleado implements Serializable {
    @Id
    private int idempleado;
    @Column
    private int IDTipoDocumento;
    @Column
    private String NumDoc;
    @Column
    private String NomEmpleado;
    @Column
    private String ApeEmpleado;
    @Column
    private Date FechaNacimiento;
    @Column
    private char GenEmpleado;
    @Column
    private String Direccion;
    @Column
    private String NumCelular;
    @Column
    private Date FechaInicio;
    @Column(nullable=true)
    private Date FechaFinal;
    @Column
    private boolean Activo;

    public empleado() {
    }

    public empleado(int idempleado, int IDTipoDocumento, String NumDoc, String NomEmpleado, String ApeEmpleado, 
            Date FechaNacimiento, char GenEmpleado, String Direccion, String NumCelular, Date FechaInicio, Date FechaFinal, boolean Activo) {
        this.idempleado = idempleado;
        this.IDTipoDocumento = IDTipoDocumento;
        this.NumDoc = NumDoc;
        this.NomEmpleado = NomEmpleado;
        this.ApeEmpleado = ApeEmpleado;
        this.FechaNacimiento = FechaNacimiento;
        this.GenEmpleado = GenEmpleado;
        this.Direccion = Direccion;
        this.NumCelular = NumCelular;
        this.FechaInicio = FechaInicio;
        this.FechaFinal = FechaFinal;
        this.Activo = Activo;
    }

    
    
    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public int getIDTipoDocumento() {
        return IDTipoDocumento;
    }

    public void setIDTipoDocumento(int IDTipoDocumento) {
        this.IDTipoDocumento = IDTipoDocumento;
    }

    public String getNomEmpleado() {
        return NomEmpleado;
    }

    public void setNomEmpleado(String NomEmpleado) {
        this.NomEmpleado = NomEmpleado;
    }

    public char getGenEmpleado() {
        return GenEmpleado;
    }

    public void setGenEmpleado(char GenEmpleado) {
        this.GenEmpleado = GenEmpleado;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getNumCelular() {
        return NumCelular;
    }

    public void setNumCelular(String NumCelular) {
        this.NumCelular = NumCelular;
    }

    public Date getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(Date FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    public String getApeEmpleado() {
        return ApeEmpleado;
    }

    public void setApeEmpleado(String ApeEmpleado) {
        this.ApeEmpleado = ApeEmpleado;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getNumDoc() {
        return NumDoc;
    }

    public void setNumDoc(String NumDoc) {
        this.NumDoc = NumDoc;
    }


    @Override
    public String toString() {
        return idempleado + "." + NomEmpleado + " " + ApeEmpleado;
    }

    

    
   
}

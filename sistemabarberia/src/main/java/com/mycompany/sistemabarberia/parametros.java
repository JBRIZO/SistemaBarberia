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
public class parametros implements Serializable {
        @Id
        private int idparametro;
        
        @Column
        private String Llave;
        
        @Column
        private String FechaInicio;
        
        @Column
        private String FechaFinal;
        
        @Column
        private String Valor;
        
        @Column
        private boolean Activo;
        
       

    public int getIdparametro() {
        return idparametro;
    }

    public void setIdparametro(int idparametro) {
        this.idparametro = idparametro;
    }

    public String getLlave() {
        return Llave;
    }

    public void setLlave(String Llave) {
        this.Llave = Llave;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(String FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }


        
        
}


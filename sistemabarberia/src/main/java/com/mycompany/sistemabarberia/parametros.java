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
import java.util.Date;

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
        private Date FechaInicio;
        
        @Column
        private Date FechaFinal;
        
        @Column
        private int RangoInicial;
        
        @Column
        private int RangoFinal;
        
        @Column
        private boolean Activo;

    public parametros(int idparametro, String Llave, Date FechaInicio, Date FechaFinal, int RangoInicial, int RangoFinal, boolean Activo) {
        this.idparametro = idparametro;
        this.Llave = Llave;
        this.FechaInicio = FechaInicio;
        this.FechaFinal = FechaFinal;
        this.RangoInicial = RangoInicial;
        this.RangoFinal = RangoFinal;
        this.Activo = Activo;
    }

    public parametros() {
    }

        
        
    public int getRangoInicial() {
        return RangoInicial;
    }

    public void setRangoInicial(int RangoInicial) {
        this.RangoInicial = RangoInicial;
    }

    public int getRangoFinal() {
        return RangoFinal;
    }

    public void setRangoFinal(int RangoFinal) {
        this.RangoFinal = RangoFinal;
    }
    
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

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
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


        
        
}


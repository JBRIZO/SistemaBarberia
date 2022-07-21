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
public class datosempresa implements Serializable {
    @Id
    private int iddato;
    @Column
    private String Nombre;
    @Column
    private String Valor;


    public datosempresa(){}
    
    public datosempresa(int iddato, String Nombre, String Valor) {
        this.iddato = iddato;
        this.Nombre = Nombre;
        this.Valor = Valor;
    }
    
    public int getIddato() {
        return iddato;
    }

    public void setIddato(int iddato) {
        this.iddato = iddato;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }
    
    
}

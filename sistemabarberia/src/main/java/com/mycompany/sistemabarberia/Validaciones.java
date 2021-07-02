/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jonathan Laux
 */
//Clase que contiene las diferentes validaciones para campos con Regex
public class Validaciones {
    
    public boolean validacionLetrasRepetidas(String cadena)
    {
         String patron = "^\\b(\\w*)(\\w)\\2{2,}(\\w*)\\b";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
        if(comparador.matches()){
            return false;
        }else
        {
            return true;
        }
    }
    
    
    public boolean validacionMayusculaInicial(String cadena)
    {
      String patron = "^[A-Z]\\w+";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }  
        
    }
    
    public boolean validacionCampoNumerico(String cadena)
    {
        String patron = "^\\d+";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }  
    }
    
    
}

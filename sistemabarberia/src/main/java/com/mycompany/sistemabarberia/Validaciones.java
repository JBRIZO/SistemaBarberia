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
    
    //Valida el periodo, que debe tener el formato mm-AAAA 
    public boolean validacionPeriodo(String cadena)
    {
        String mes = "";
        String patron = "^[0-1][1-9]-[2][0-2][2-9][1-9]";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
        //Verificacion de mes valido
        for (int i=0 ; i<=1;i++)
        {
         mes = mes + cadena.charAt(i);  
        }
        int numMes = Integer.parseInt(mes);
        
        if(numMes>12)
        {
            return false;
        }
        
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }
        
        
    }
    
   
    //Valida el formato de la fecha (dd/mm/aaaa)
    public boolean validacionFecha(String cadena)
    {
        String patron = "^((0[1-9])|(1[0-9])|(2[0-9])|(3[0-1]))[\\/-]((0[1-9])|(1[0-2]))[\\/-](\\d{4})";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
         if(comparador.matches()){
            return true;
        }else
        {
            return false;
        } 
    }
    
    
    //Devuelve TRUE si una cadena de texto tiene letras repetidas, sino false.
    public boolean validacionLetrasRepetidas(String cadena)
    {
         String patron = "^\\b(\\w*)(\\w)\\2{2,}(\\w*)\\b";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }
    }
    
    //Devuelve TRUE si una cadena de texto empieza con mayuscula, sino devuelve FALSE.
    public boolean validacionMayusculaInicial(String cadena)
    {
      String patron = "^[A-Z]{1}[a-z]+$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }  
        
    }
    
    //Si un campo es solo de numeros devuelve TRUE, sino FALSE.
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
    
    
    
    //Compara el resultado de dos validaciones, y devuelve TRUE si ambas son ciertas, sino FALSE.
    public boolean validar(boolean validacion1, boolean validacion2)
    {
        if(validacion1 && validacion2)
        {
            return true;
        }else
        {
            return false;
        }
        
    }
    
    //Valida si una oracion tiene mayuscula inicial y las palabras son validas.
    public boolean validacionCadenaPalabras(String cadena)
    {
          String[] palabras  = cadena.split("\\s+");
          boolean mayusculaInicial = false;
          boolean palabraValida = false;
          
          if(validacionMayusculaInicial(palabras[0]))
          {
              mayusculaInicial = true;
          }
          for (int i = 0; i < palabras.length; i++)
          {
              System.out.println(palabras[i]);
              if(!validacionLetrasRepetidas(palabras[i]))
              {
                  palabraValida = true;
              }else
              {
                  return false;
              }
          }
          if(mayusculaInicial && palabraValida)
          {
              return true;
          }else
          {
              return false;
          }
    }
    
}

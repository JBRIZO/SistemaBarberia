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
    
   //valida que el formato de una cadena sea un numero de identidad valido
    public boolean validacionIdentidad(String Identidad)
    {
        String patron = "^[01][1-9][0-2][0-9][1-3][0-9][0-9][0-9][\\d]{5}$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(Identidad);
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }
    }
    //valida un nombre o un apellido, cada nombre y apellido debe iniciar en mayusculas
    public boolean validacionNombres(String Nombre)
    {   
        String[] dosNombres = Nombre.split("\\s");
        if(dosNombres.length == 2)
        {
               for(int i = 0; i < dosNombres.length ; i++)
               {
                    String patron ="^[A-Z]\\w+";
                    Pattern patt = Pattern.compile(patron);
                    Matcher comparador = patt.matcher(dosNombres[i].trim());
                    if(!comparador.matches()){
                        return false;
                    }
               }
               return true;
        }
        String patron ="^[A-Z]\\w+";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(Nombre.trim());
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }
        
    }
    
    //Valida el periodo, que debe tener el formato mm-AAAA 
     public boolean validacionEntero(String numero) 
    {
        String patron = "^[1-9][0-9]+$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(numero);
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }
    }
    
     // valida que se introdruzca un numero decimal valido
    public boolean validacionDecimal(String numero)
    {
        String patron = "^[0-9]{1,6}.[0-9]{2}$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(numero);
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }
    }
    
    //valida un periodo valido con formato MM-aaaa
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
    
   
    //Valida una fecha valida, que el usuario ingrese el numero apropiado de dias y de meses.
    public boolean validacionFechaValida(String cadena)
    {
        String patron = "^((0[1-9])|(1[0-9])|(2[0-9])|(3[0-1]))[\\/]((0[1-9])|(1[0-2]))[\\/](\\d{4})";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
         if(comparador.matches()){
            return true;
        }else
        {
            return false;
        } 
    }
    
    
    //Valida que el formato de fecha sea el correcto
    public boolean validacionFormatoFecha(String cadena)
    {
        String patron = "^[\\d]{2}/[\\d]{2}/[\\d]{4}$";
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
        String[] palabras  = cadena.split("\\s+");
        String patron = "^[A-Z]{1}[a-z]+$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(palabras[0]);
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
        String patron = "^[\\d./-]+$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }  
    }
    
    public boolean validacionNumEntero(String cadena)
    {
        String patron = "^[\\d]+$";
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
              if(!validacionLetrasRepetidas(palabras[i]) && 
                      !validacionAbcd(palabras[i]) && 
                      !validacionConsonantesSeguidas(palabras[i]) && 
                      !validacionVocalesSeguidas(palabras[i]))
              {
                  palabraValida = true;
              }else
              {
                  return false;
              }
          }
          if(mayusculaInicial && palabraValida )
          {
              return true;
          }else
          {
              return false;
          }
    }
    
    //valida que una cadena tenga la cantidad minima de caracteres necesarios
    public boolean validacionCantidadMinima(String palabra, int cantidadMinima)
    {
        String patron = String.format("^[\\w|\\s]{%d,}$",cantidadMinima);
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(palabra);
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }  
        
    }
    
    //valida si el usuario ingresa un numero de celular o telefono valido en Honduras
    public boolean validarNumCelular(String cadena)
    {
        String patron = "^[23789]\\d{7}$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }  
    }
    
    public boolean validarNomCuenta(String cadena)
    {
        String patron = "^[a-z0-9_-]{3,16}$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }  
    }
    //validacion de contrasena, permite mayusculas, numeros y @
    public boolean validarContrasena(String cadena)
    {
        String patron = "^[@A-Za-z0-9_-]{6,18}$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }        
    }
    
    //validar pasaporte
    public boolean validarPasaporte(String cadena)
    {
        String patron = "^(?!^0+$)[a-zA-Z0-9]{3,20}$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
        if(comparador.matches()){
            return true;
        }else
        {
            return false;
        }             
    }
    
    //abcd
    public static boolean validacionAbcd(String palabra)
          {
            String patron = String.format("^(|\\w+)[AabBcCdD]{4,}(|\\w+)$");
            Pattern patt = Pattern.compile(patron);
            Matcher comparador = patt.matcher(palabra);
            if(comparador.matches()){
                return true;
            }else
            {
                return false;
            }  
          }
    
    public static boolean validacionConsonantesSeguidas(String palabra)
            { 
            String patron = String.format("^(|\\w+)[b-df-hj-np-tv-z]{4,}(|\\w+)$");
            Pattern patt = Pattern.compile(patron);
            Matcher comparador = patt.matcher(palabra);
            if(comparador.matches()){
                return true;
            }else
            {
                return false;
            }          
            }
    
    public static boolean validacionVocalesSeguidas(String palabra)
    {
            String patron = String.format("^(|\\w+)[AaEeIiOoUu]{3,}(|\\w+)$");
            Pattern patt = Pattern.compile(patron);
            Matcher comparador = patt.matcher(palabra);
            if(comparador.matches()){
                return true;
            }else
            {
                return false;
            }       
    }
}

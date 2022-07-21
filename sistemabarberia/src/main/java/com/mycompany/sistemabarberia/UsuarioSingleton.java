/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

/**
 *
 * @author Jonathan Laux
 */
public class UsuarioSingleton {
 
private usuarios Usuario;
private static UsuarioSingleton usuario;
 
 public static UsuarioSingleton getUsuario(usuarios nombreUsuario) {
 
 if (usuario==null) {
 usuario = new UsuarioSingleton(nombreUsuario);
 }
 return usuario;
 }
 
 private UsuarioSingleton(usuarios usuario){
 
 this.Usuario=usuario;
 
 }
 
 public usuarios getCuenta()
 {
     return Usuario;
 }
 
public String getNombreUsuario() {
 return Usuario.getNomCuenta();
 }
 
public void setUsuario(usuarios usuario) {
 this.Usuario = usuario;
 }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import javax.swing.ImageIcon;

/**
 *
 * @author Jonathan Laux
 */
public class NewClass {
    
    PantallaCargando screen;
    
     public NewClass()
    {
       inicioPantalla();
        screen.velocidadDeCarga(); 
    }
     private  void inicioPantalla() {
    ImageIcon myImage = new ImageIcon("src/main/resources/Imagenes/logoBarberia.jpeg");
    screen = new PantallaCargando(myImage);
    screen.setLocationRelativeTo(null);
    screen.setProgresoMax(100);
    screen.setVisible(true);
  }
    
}

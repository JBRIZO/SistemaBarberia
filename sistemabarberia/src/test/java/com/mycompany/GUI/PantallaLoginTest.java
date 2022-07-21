/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.usuarios;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan Laux
 */
public class PantallaLoginTest {
    
    public PantallaLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class PantallaLogin.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PantallaLogin.main(args);
    }
    /**
     * Test of encontrarUsuario method, of class PantallaLogin.
     */
    @Test
    public void testEncontrarUsuario() {
        System.out.println();
        System.out.println("encontrarUsuario");
        PantallaLogin instance = new PantallaLogin();
        String nomUsuario = "jbrizo123";
        try{instance.encontrarUsuario(nomUsuario);}catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        };
    }
    
    @Test
    public void testValidarCamposEnBlanco(){
        System.out.println("validarCamposEnBlanco");
        PantallaLogin instance = new PantallaLogin();
        instance.nombreUsuario.setText("jbrizo123");
        instance.password.setText("Hola");
        boolean expResult = true;
        boolean result = instance.validarCamposEnBlanco();
        assertEquals(expResult,result);
        
        
    }
    
}

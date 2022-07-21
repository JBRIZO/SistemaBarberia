/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import java.time.LocalDate;
import java.util.Date;
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
public class nuevoPrecioProductoTest {
    
    public nuevoPrecioProductoTest() {
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
     * Test of Reiniciar method, of class nuevoPrecioProducto.
     */
    @org.junit.Test
    public void testReiniciar() {
        System.out.println("Reiniciar");
        nuevoPrecioProducto instance = new nuevoPrecioProducto();
        instance.Reiniciar();
    }

    /**
     * Test of main method, of class nuevoPrecioProducto.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        nuevoPrecioProducto.main(args);
    }

    @Test
    public void testValidarCamposEnBlanco(){
        System.out.println("validarCamposEnBlanco");
        nuevoPrecioProducto instance = new nuevoPrecioProducto();
        instance.fechaInicio.setText("Fecha");
        instance.precio.setText("precio");
        boolean expResult = true;
        boolean result = instance.validarCamposEnBlanco();
        assertEquals(expResult,result);
        
    }
  
    
}

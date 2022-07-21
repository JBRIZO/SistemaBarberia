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
public class descuentoTest {
    
    public descuentoTest() {
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
     * Test of Reiniciar method, of class descuento.
     */
    @org.junit.Test
    public void testReiniciar() {
        System.out.println("Reiniciar");
        descuento instance = new descuento();
        instance.Reiniciar();
    }

    /**
     * Test of main method, of class descuento.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        descuento.main(args);
    }

    /**
     * Test of validarPorcentaje method, of class descuento.
     */
    @Test
    public void testValidarPorcentaje() {
        System.out.println("validarPorcentaje");
        String porcentaje = "50";
        descuento instance = new descuento();
        boolean expResult = true;
        boolean result = instance.validarPorcentaje(porcentaje);
        assertEquals(expResult, result);
    }
    
}

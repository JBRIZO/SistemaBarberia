/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

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
public class NuevoBonoTest {
    
    public NuevoBonoTest() {
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
     * Test of obtenerEmpleados method, of class NuevoBono.
     */
    @org.junit.Test
    public void testObtenerEmpleados() {
        System.out.println("obtenerEmpleados");
        NuevoBono instance = new NuevoBono();
        
        try{instance.obtenerEmpleados();}catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of obtenerTipoBono method, of class NuevoBono.
     */
    @org.junit.Test
    public void testObtenerTipoBono() {
        System.out.println("obtenerTipoBono");
        NuevoBono instance = new NuevoBono();
        
        try{instance.obtenerTipoBono();}catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of main method, of class NuevoBono.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        NuevoBono.main(args);
    }

    /**
     * Test of validarCamposEnBlanco method, of class NuevoBono.
     */
    @Test
    public void testValidarCamposEnBlanco() {
        System.out.println("validarCamposEnBlanco");
        NuevoBono instance = new NuevoBono();
        instance.cantidad.setText("12000.00");
        instance.periodo.setText("202110");
        boolean expResult = true;
        boolean result = instance.validarCamposEnBlanco();
        assertEquals(expResult, result);
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jonathan Laux
 */
public class BusquedaFacturaTest {
    
    public BusquedaFacturaTest() {
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
     * Test of main method, of class BusquedaFactura.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BusquedaFactura.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of convertirDates method, of class BusquedaFactura.
//     */
//    @Test
//    public void testConvertirDates() {
//        System.out.println("convertirDates");
//        BusquedaFactura instance = new BusquedaFactura();
//        String Fecha = "2021-10-10 00:00:00";
//        String expResult = "10/10/2021 00:00:00";
//        System.out.println(instance.convertirDates(Fecha));
//        String result = instance.convertirDates(Fecha);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of validarMotivo method, of class BusquedaFactura.
     */
    @Test
    public void testValidarMotivo() {
        System.out.println("validarMotivo");
        String motivo = "Cera en mal estado";
        BusquedaFactura instance = new BusquedaFactura();
        boolean expResult = true;
        boolean result = instance.validarMotivo(motivo);
        assertEquals(expResult, result);
    }

    
    
}

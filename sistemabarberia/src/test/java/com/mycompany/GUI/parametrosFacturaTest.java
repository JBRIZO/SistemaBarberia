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
public class parametrosFacturaTest {
    
    public parametrosFacturaTest() {
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
     * Test of Reiniciar method, of class parametrosFactura.
     */
    @org.junit.Test
    public void testReiniciar() {
        System.out.println("Reiniciar");
        parametrosFactura instance = new parametrosFactura();
        instance.Reiniciar();
    }

    /**
     * Test of convertirFecha method, of class parametrosFactura.
     */
    @org.junit.Test
    public void testConvertirFechaSql() {
        System.out.println("convertirFecha");
        System.out.println();
        String Fecha = "10/10/2021";
        parametrosFactura instance = new parametrosFactura();
        String expResult = "2021-10-10";
        String result = instance.convertirFechaSql(Fecha);
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class parametrosFactura.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        parametrosFactura.main(args);
    }

    

    
}

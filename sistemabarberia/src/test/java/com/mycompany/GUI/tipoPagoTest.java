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
public class tipoPagoTest {
    
    public tipoPagoTest() {
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
     * Test of Reiniciar method, of class tipoPago.
     */
    @org.junit.Test
    public void testReiniciar() {
        System.out.println("Reiniciar");
        tipoPago instance = new tipoPago();
        instance.Reiniciar();
    }

    /**
     * Test of main method, of class tipoPago.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        tipoPago.main(args);
    }
    
}

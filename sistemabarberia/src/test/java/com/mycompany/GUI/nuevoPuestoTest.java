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
public class nuevoPuestoTest {
    
    public nuevoPuestoTest() {
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
     * Test of Reiniciar method, of class nuevoPuesto.
     */
    @org.junit.Test
    public void testReiniciar() {
        System.out.println("Reiniciar");
        nuevoPuesto instance = new nuevoPuesto();
        instance.Reiniciar();
    }

    /**
     * Test of main method, of class nuevoPuesto.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        nuevoPuesto.main(args);
    }
    
}

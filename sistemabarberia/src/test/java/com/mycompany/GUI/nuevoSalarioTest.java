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
public class nuevoSalarioTest {
    
    public nuevoSalarioTest() {
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
     * Test of Reiniciar method, of class nuevoSalario.
     */
    @org.junit.Test
    public void testReiniciar() {
        System.out.println("Reiniciar");
        nuevoSalario instance = new nuevoSalario();
        instance.Reiniciar();
    }

    /**
     * Test of main method, of class nuevoSalario.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        nuevoSalario.main(args);
    }
    
    @Test
    public void testValidarCamposVacios(){
        System.out.println("validarCamposVacios");
        nuevoSalario instance = new nuevoSalario();
        instance.fechaInicio.setText("fecha");
        instance.salario.setText("salario");
        boolean expResult = true;
        boolean result = instance.validarCamposVacios();
        assertEquals(expResult,result);
    }
    
}

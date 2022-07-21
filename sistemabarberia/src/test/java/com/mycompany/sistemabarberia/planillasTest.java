/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

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
public class planillasTest {
     
    public planillasTest() {
    }
    
    private planillas plani = new planillas(1,2,"periodo",100.00,true);
    
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
     * Test of getIdplanilla method, of class planillas.
     */
    @org.junit.Test
    public void testGetIdplanilla() {
        System.out.println("getIdplanilla");
        planillas instance = plani;
        int expResult = 1;
        int result = instance.getIdplanilla();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdplanilla method, of class planillas.
     */
    @org.junit.Test
    public void testSetIdplanilla() {
        System.out.println("setIdplanilla");
        int idplanilla = 1;
        planillas instance =  plani;
        try{
            instance.setIdplanilla(idplanilla);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDEmpleado method, of class planillas.
     */
    @org.junit.Test
    public void testGetIDEmpleado() {
        System.out.println("getIDEmpleado");
        planillas instance = plani;
        int expResult = 2;
        int result = instance.getIDEmpleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDEmpleado method, of class planillas.
     */
    @org.junit.Test
    public void testSetIDEmpleado() {
        System.out.println("setIDEmpleado");
        int IDEmpleado = 2;
        planillas instance = plani;
        try{
           instance.setIDEmpleado(IDEmpleado); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPeriodo method, of class planillas.
     */
    @org.junit.Test
    public void testGetPeriodo() {
        System.out.println("getPeriodo");
        planillas instance = plani;
        String expResult = "periodo";
        String result = instance.getPeriodo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPeriodo method, of class planillas.
     */
    @org.junit.Test
    public void testSetPeriodo() {
        System.out.println("setPeriodo");
        String Periodo = "periodo";
        planillas instance = plani;
        try{
            instance.setPeriodo(Periodo);
        }catch(Exception Ex){
        fail("The test case is a prototype.");
    }
        // TODO review the generated test code and remove the default call to fail.   
    }

    /**
     * Test of getTotalPagar method, of class planillas.
     */
    @org.junit.Test
    public void testGetTotalPagar() {
        System.out.println("getTotalPagar");
        planillas instance = plani;
        double expResult = 100.00;
        double result = instance.getTotalPagar();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalPagar method, of class planillas.
     */
    @org.junit.Test
    public void testSetTotalPagar() {
        System.out.println("setTotalPagar");
        double TotalPagar = 100.00;
        planillas instance = plani;
        try{
            instance.setTotalPagar(TotalPagar);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isActivo method, of class planillas.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        planillas instance = plani;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class planillas.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        planillas instance = plani;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

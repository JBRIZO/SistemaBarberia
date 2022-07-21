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
public class puestoTest {
    
   public puestoTest() {
    }
    
    private puesto puesto = new puesto(1,"puesto",true);
    
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
     * Test of getIdpuesto method, of class puesto.
     */
    @org.junit.Test
    public void testGetIdpuesto() {
        System.out.println("getIdpuesto");
        puesto instance = puesto;
        int expResult = 1;
        int result = instance.getIdpuesto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdpuesto method, of class puesto.
     */
    @org.junit.Test
    public void testSetIdpuesto() {
        System.out.println("setIdpuesto");
        int idpuesto = 1;
        puesto instance = puesto;
        try{
            instance.setIdpuesto(idpuesto);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNomPuesto method, of class puesto.
     */
    @org.junit.Test
    public void testGetNomPuesto() {
        System.out.println("getNomPuesto");
        puesto instance = puesto;
        String expResult = "puesto";
        String result = instance.getNomPuesto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNomPuesto method, of class puesto.
     */
    @org.junit.Test
    public void testSetNomPuesto() {
        System.out.println("setNomPuesto");
        String NomPuesto = "puesto";
        puesto instance = puesto;
        try{
            instance.setNomPuesto(NomPuesto);
        }catch(Exception Ex){
            fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isActivo method, of class puesto.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        puesto instance = puesto;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class puesto.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        puesto instance =  puesto;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

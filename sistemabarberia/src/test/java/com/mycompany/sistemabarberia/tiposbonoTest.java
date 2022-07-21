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
public class tiposbonoTest {
   public tiposbonoTest() {
    }
    
    private tiposbono tiposbo = new tiposbono(1,"nombre",true);
    
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
     * Test of getIdtipobono method, of class tiposbono.
     */
    @org.junit.Test
    public void testGetIdtipobono() {
        System.out.println("getIdtipobono");
        tiposbono instance = tiposbo;
        int expResult = 1;
        int result = instance.getIdtipobono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdtipobono method, of class tiposbono.
     */
    @org.junit.Test
    public void testSetIdtipobono() {
        System.out.println("setIdtipobono");
        int idtipobono = 1;
        tiposbono instance = tiposbo;
        try{
          instance.setIdtipobono(idtipobono);  
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNomBono method, of class tiposbono.
     */
    @org.junit.Test
    public void testGetNomBono() {
        System.out.println("getNomBono");
        tiposbono instance = tiposbo;
        String expResult = "nombre";
        String result = instance.getNomBono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNomBono method, of class tiposbono.
     */
    @org.junit.Test
    public void testSetNomBono() {
        System.out.println("setNomBono");
        String NomBono = "nombre";
        tiposbono instance = tiposbo;
        try{
            instance.setNomBono(NomBono);
        }catch(Exception Ex){
          fail("The test case is a prototype.");  
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isActivo method, of class tiposbono.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        tiposbono instance = tiposbo;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class tiposbono.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        tiposbono instance = tiposbo;
        try{
          instance.setActivo(Activo);  
        }catch(Exception Ex){
           fail("The test case is a prototype.");  
        }
        // TODO review the generated test code and remove the default call to fail.
    }

}

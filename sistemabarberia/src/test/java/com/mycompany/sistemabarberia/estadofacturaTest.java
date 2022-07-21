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
public class estadofacturaTest {
    
   public estadofacturaTest() {
    }
    
    private estadofactura estadofactu = new estadofactura(1,"Estado",true);
    
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
     * Test of getIdestado method, of class estadofactura.
     */
    @org.junit.Test
    public void testGetIdestado() {
        System.out.println("getIdestado");
        estadofactura instance = estadofactu;
        int expResult = 1;
        int result = instance.getIdestado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdestado method, of class estadofactura.
     */
    @org.junit.Test
    public void testSetIdestado() {
        System.out.println("setIdestado");
        int idestado = 1;
        estadofactura instance = estadofactu;
        try{
            instance.setIdestado(idestado);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail. 
    }

    /**
     * Test of getNombreEstado method, of class estadofactura.
     */
    @org.junit.Test
    public void testGetNombreEstado() {
        System.out.println("getNombreEstado");
        estadofactura instance = estadofactu;
        String expResult = "Estado";
        String result = instance.getNombreEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreEstado method, of class estadofactura.
     */
    @org.junit.Test
    public void testSetNombreEstado() {
        System.out.println("setNombreEstado");
        String NombreEstado = "Estado";
        estadofactura instance = estadofactu;
        try{
           instance.setNombreEstado(NombreEstado); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isActivo method, of class estadofactura.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        estadofactura instance = estadofactu;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class estadofactura.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        estadofactura instance = estadofactu;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

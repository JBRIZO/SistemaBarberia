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
public class tipodescuentoTest {
    
    public tipodescuentoTest() {
    }
    
    private tipodescuento tipodescu = new tipodescuento(1,"nombre",true);
    
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
     * Test of getIdtipodescuento method, of class tipodescuento.
     */
    @org.junit.Test
    public void testGetIdtipodescuento() {
        System.out.println("getIdtipodescuento");
        tipodescuento instance = tipodescu;
        int expResult = 1;
        int result = instance.getIdtipodescuento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdtipodescuento method, of class tipodescuento.
     */
    @org.junit.Test
    public void testSetIdtipodescuento() {
        System.out.println("setIdtipodescuento");
        int idtipodescuento = 1;
        tipodescuento instance = tipodescu;
        try{
            instance.setIdtipodescuento(idtipodescuento);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNomDescuento method, of class tipodescuento.
     */
    @org.junit.Test
    public void testGetNomDescuento() {
        System.out.println("getNomDescuento");
        tipodescuento instance = tipodescu;
        String expResult = "nombre";
        String result = instance.getNomDescuento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNomDescuento method, of class tipodescuento.
     */
    @org.junit.Test
    public void testSetNomDescuento() {
        System.out.println("setNomDescuento");
        String NomDescuento = "nombre";
        tipodescuento instance = tipodescu;
        try{
            instance.setNomDescuento(NomDescuento);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isActivo method, of class tipodescuento.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        tipodescuento instance = tipodescu;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class tipodescuento.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        tipodescuento instance = tipodescu;
        try{
            instance.setActivo(Activo); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    
    
}

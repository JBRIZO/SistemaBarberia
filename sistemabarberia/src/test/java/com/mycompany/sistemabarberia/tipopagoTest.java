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
public class tipopagoTest {
    
    public tipopagoTest() {
    }
    
    private tipopago tipopa = new tipopago(1,"pago",true);
    
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
     * Test of getIdtipopago method, of class tipopago.
     */
    @org.junit.Test
    public void testGetIdtipopago() {
        System.out.println("getIdtipopago");
        tipopago instance = tipopa;
        int expResult = 1;
        int result = instance.getIdtipopago();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdtipopago method, of class tipopago.
     */
    @org.junit.Test
    public void testSetIdtipopago() {
        System.out.println("setIdtipopago");
        int idtipopago = 1;
        tipopago instance = tipopa;
        try{
            instance.setIdtipopago(idtipopago);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTipoPago method, of class tipopago.
     */
    @org.junit.Test
    public void testGetTipoPago() {
        System.out.println("getTipoPago");
        tipopago instance = tipopa;
        String expResult = "pago";
        String result = instance.getTipoPago();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoPago method, of class tipopago.
     */
    @org.junit.Test
    public void testSetTipoPago() {
        System.out.println("setTipoPago");
        String TipoPago = "pago";
        tipopago instance = tipopa;
        try{
           instance.setTipoPago(TipoPago); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getActivo method, of class tipopago.
     */
    @org.junit.Test
    public void testGetActivo() {
        System.out.println("getActivo");
        tipopago instance = tipopa;
        Boolean expResult = true;
        Boolean result = instance.getActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class tipopago.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        Boolean Activo = true;
        tipopago instance = tipopa;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class tipopago.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        tipopago instance = tipopa;
        String expResult = "1. pago";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}

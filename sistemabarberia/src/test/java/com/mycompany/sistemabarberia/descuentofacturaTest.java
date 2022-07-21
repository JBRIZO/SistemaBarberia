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
public class descuentofacturaTest {
    
     public descuentofacturaTest() {
    }
    
    private descuentofactura descuentofac = new descuentofactura(1,5,3,450.00,true);
    
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
     * Test of getNumdescuento method, of class descuentofactura.
     */
    @org.junit.Test
    public void testGetNumdescuento() {
        System.out.println("getNumdescuento");
        descuentofactura instance = descuentofac;
        int expResult = 1;
        int result = instance.getNumdescuento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumdescuento method, of class descuentofactura.
     */
    @org.junit.Test
    public void testSetNumdescuento() {
        System.out.println("setNumdescuento");
        int numdescuento = 1;
        descuentofactura instance = descuentofac;
        try{
            instance.setNumdescuento(numdescuento);
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDFactura method, of class descuentofactura.
     */
    @org.junit.Test
    public void testGetIDFactura() {
        System.out.println("getIDFactura");
        descuentofactura instance = descuentofac;
        int expResult = 5;
        int result = instance.getIDFactura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDFactura method, of class descuentofactura.
     */
    @org.junit.Test
    public void testSetIDFactura() {
        System.out.println("setIDFactura");
        int IDFactura = 5;
        descuentofactura instance = descuentofac;
        try{
          instance.setIDFactura(IDFactura);  
        }catch(Exception Ex){
             fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDDescuento method, of class descuentofactura.
     */
    @org.junit.Test
    public void testGetIDDescuento() {
        System.out.println("getIDDescuento");
        descuentofactura instance = descuentofac;
        int expResult = 3;
        int result = instance.getIDDescuento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDDescuento method, of class descuentofactura.
     */
    @org.junit.Test
    public void testSetIDDescuento() {
        System.out.println("setIDDescuento");
        int IDDescuento = 3;
        descuentofactura instance = descuentofac;
        try{
            instance.setIDDescuento(IDDescuento);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getValor method, of class descuentofactura.
     */
    @org.junit.Test
    public void testGetValor() {
        System.out.println("getValor");
        descuentofactura instance = descuentofac;
        double expResult = 450.00;
        double result = instance.getValor();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setValor method, of class descuentofactura.
     */
    @org.junit.Test
    public void testSetValor() {
        System.out.println("setValor");
        double Valor = 450.00;
        descuentofactura instance = descuentofac;
        try{
            instance.setValor(Valor);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isActivo method, of class descuentofactura.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        descuentofactura instance = descuentofac;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class descuentofactura.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        descuentofactura instance = descuentofac;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    } 
}

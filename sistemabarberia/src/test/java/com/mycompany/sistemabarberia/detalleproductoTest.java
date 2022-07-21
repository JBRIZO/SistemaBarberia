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
public class detalleproductoTest {
    public detalleproductoTest() {
    }
    
    private detalleproducto detallepro = new detalleproducto(1,6,8,30,700.00);
    
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
     * Test of getNumdetalle method, of class detalleproducto.
     */
    @org.junit.Test
    public void testGetNumdetalle() {
        System.out.println("getNumdetalle");
        detalleproducto instance = detallepro;
        int expResult = 1;
        int result = instance.getNumdetalle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumdetalle method, of class detalleproducto.
     */
    @org.junit.Test
    public void testSetNumdetalle() {
        System.out.println("setNumdetalle");
        int numdetalle = 1;
        detalleproducto instance = detallepro;
        try{
            instance.setNumdetalle(numdetalle);
        }catch(Exception Ex){
              fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDFacturaEncabezado method, of class detalleproducto.
     */
    @org.junit.Test
    public void testGetIDFacturaEncabezado() {
        System.out.println("getIDFacturaEncabezado");
        detalleproducto instance = detallepro;
        int expResult = 6;
        int result = instance.getIDFacturaEncabezado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDFacturaEncabezado method, of class detalleproducto.
     */
    @org.junit.Test
    public void testSetIDFacturaEncabezado() {
        System.out.println("setIDFacturaEncabezado");
        int IDFacturaEncabezado = 6;
        detalleproducto instance = detallepro;
        try{
            instance.setIDFacturaEncabezado(IDFacturaEncabezado);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDProducto method, of class detalleproducto.
     */
    @org.junit.Test
    public void testGetIDProducto() {
        System.out.println("getIDProducto");
        detalleproducto instance = detallepro;
        int expResult = 8;
        int result = instance.getIDProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDProducto method, of class detalleproducto.
     */
    @org.junit.Test
    public void testSetIDProducto() {
        System.out.println("setIDProducto");
        int IDProducto = 8;
        detalleproducto instance = detallepro;
        try{
            instance.setIDProducto(IDProducto);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }  
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCantidad method, of class detalleproducto.
     */
    @org.junit.Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        detalleproducto instance = detallepro;
        int expResult = 30;
        int result = instance.getCantidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class detalleproducto.
     */
    @org.junit.Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int Cantidad = 30;
        detalleproducto instance = detallepro;
        try{
             instance.setCantidad(Cantidad);
        }catch(Exception Ex){
         fail("The test case is a prototype.");
    }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPrecio method, of class detalleproducto.
     */
    @org.junit.Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        detalleproducto instance = detallepro;
        double expResult = 700.00;
        double result = instance.getPrecio();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecio method, of class detalleproducto.
     */
    @org.junit.Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        double Precio = 700.00;
        detalleproducto instance = detallepro;
        try{
            instance.setPrecio(Precio);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
}

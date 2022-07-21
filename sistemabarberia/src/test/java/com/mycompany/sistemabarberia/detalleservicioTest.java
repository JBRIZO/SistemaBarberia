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
public class detalleservicioTest {
    
    public detalleservicioTest() {
    }
    
    private detalleservicio detalleservi = new detalleservicio(1,8,3,10,100.00);
    
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
     * Test of getNumdetalleservicio method, of class detalleservicio.
     */
    @org.junit.Test
    public void testGetNumdetalleservicio() {
        System.out.println("getNumdetalleservicio");
        detalleservicio instance = detalleservi;
        int expResult = 1;
        int result = instance.getNumdetalleservicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumdetalleservicio method, of class detalleservicio.
     */
    @org.junit.Test
    public void testSetNumdetalleservicio() {
        System.out.println("setNumdetalleservicio");
        int numdetalleservicio = 1;
        detalleservicio instance = detalleservi;
        try{
            instance.setNumdetalleservicio(numdetalleservicio);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDFacturaEncabezado method, of class detalleservicio.
     */
    @org.junit.Test
    public void testGetIDFacturaEncabezado() {
        System.out.println("getIDFacturaEncabezado");
        detalleservicio instance = detalleservi;
        int expResult = 8;
        int result = instance.getIDFacturaEncabezado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDFacturaEncabezado method, of class detalleservicio.
     */
    @org.junit.Test
    public void testSetIDFacturaEncabezado() {
        System.out.println("setIDFacturaEncabezado");
        int IDFacturaEncabezado = 8;
        detalleservicio instance = detalleservi;
        try{
             instance.setIDFacturaEncabezado(IDFacturaEncabezado);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDServicio method, of class detalleservicio.
     */
    @org.junit.Test
    public void testGetIDServicio() {
        System.out.println("getIDServicio");
        detalleservicio instance = detalleservi;
        int expResult = 3;
        int result = instance.getIDServicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDServicio method, of class detalleservicio.
     */
    @org.junit.Test
    public void testSetIDServicio() {
        System.out.println("setIDServicio");
        int IDServicio = 3;
        detalleservicio instance = detalleservi;
        try{
            instance.setIDServicio(IDServicio);
        }catch(Exception Ex){
             fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCantidad method, of class detalleservicio.
     */
    @org.junit.Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        detalleservicio instance = detalleservi;
        int expResult = 10;
        int result = instance.getCantidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class detalleservicio.
     */
    @org.junit.Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int Cantidad = 10;
        detalleservicio instance = detalleservi;
        try{
             instance.setCantidad(Cantidad);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPrecio method, of class detalleservicio.
     */
    @org.junit.Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        detalleservicio instance = detalleservi;
        double expResult = 100.00;
        double result = instance.getPrecio();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecio method, of class detalleservicio.
     */
    @org.junit.Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        double Precio = 100.00;
        detalleservicio instance = detalleservi;
        try{
            instance.setPrecio(Precio);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

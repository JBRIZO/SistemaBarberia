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
public class tipodeduccionTest {
    
    public tipodeduccionTest() {
    }
    
    private tipodeduccion tipodedu = new tipodeduccion(1,"nombre",true);
    
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
     * Test of getIdtipodeduccion method, of class tipodeduccion.
     */
    @org.junit.Test
    public void testGetIdtipodeduccion() {
        System.out.println("getIdtipodeduccion");
        tipodeduccion instance = tipodedu;
        int expResult = 1;
        int result = instance.getIdtipodeduccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdtipodeduccion method, of class tipodeduccion.
     */
    @org.junit.Test
    public void testSetIdtipodeduccion() {
        System.out.println("setIdtipodeduccion");
        int idtipodeduccion = 1;
        tipodeduccion instance = tipodedu;
        try{
           instance.setIdtipodeduccion(idtipodeduccion); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNombre method, of class tipodeduccion.
     */
    @org.junit.Test
    public void testGetNombre() {
        System.out.println("getNombre");
        tipodeduccion instance = tipodedu;
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class tipodeduccion.
     */
    @org.junit.Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String Nombre = "nombre";
        tipodeduccion instance = tipodedu;
        try{
          instance.setNombre(Nombre);  
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isActivo method, of class tipodeduccion.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        tipodeduccion instance = tipodedu;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class tipodeduccion.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        tipodeduccion instance = tipodedu;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
          fail("The test case is a prototype.");  
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

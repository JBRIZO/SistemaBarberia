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
public class serviciosTest {
    
     
    public serviciosTest() {
    }
    
    private servicios servi = new servicios(1,"servicio",true);
    
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
     * Test of getIdservicio method, of class servicios.
     */
    @org.junit.Test
    public void testGetIdservicio() {
        System.out.println("getIdservicio");
        servicios instance = servi;
        int expResult = 1;
        int result = instance.getIdservicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdservicio method, of class servicios.
     */
    @org.junit.Test
    public void testSetIdservicio() {
        System.out.println("setIdservicio");
        int idservicio = 1;
        servicios instance = servi;
        try{
           instance.setIdservicio(idservicio); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNomServicio method, of class servicios.
     */
    @org.junit.Test
    public void testGetNomServicio() {
        System.out.println("getNomServicio");
        servicios instance = servi;
        String expResult = "servicio";
        String result = instance.getNomServicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNomServicio method, of class servicios.
     */
    @org.junit.Test
    public void testSetNomServicio() {
        System.out.println("setNomServicio");
        String NomServicio = "servicio";
        servicios instance = servi;
        try{
            instance.setNomServicio(NomServicio);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isActivo method, of class servicios.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        servicios instance = servi;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class servicios.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        servicios instance = servi;
        try{
           instance.setActivo(Activo); 
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

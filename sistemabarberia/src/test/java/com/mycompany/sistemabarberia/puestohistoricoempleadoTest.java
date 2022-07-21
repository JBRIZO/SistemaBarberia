/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class puestohistoricoempleadoTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date fecha; 
    puestohistoricoempleado puestohistoemple;
    
    public puestohistoricoempleadoTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
             puestohistoemple = new puestohistoricoempleado(1,2,3,new java.sql.Date(fecha.getTime()),new java.sql.Date(fecha.getTime()),true);
        } catch (Exception ex) {
            Logger.getLogger(clientesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
     * Test of getNumpuesto method, of class puestohistoricoempleado.
     */
    @org.junit.Test
    public void testGetNumpuesto() {
        System.out.println("getNumpuesto");
        puestohistoricoempleado instance = puestohistoemple;
        int expResult = 1;
        int result = instance.getNumpuesto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumpuesto method, of class puestohistoricoempleado.
     */
    @org.junit.Test
    public void testSetNumpuesto() {
        System.out.println("setNumpuesto");
        int numpuesto = 1;
        puestohistoricoempleado instance = puestohistoemple;
        try{
            instance.setNumpuesto(numpuesto);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getIDEmpleado method, of class puestohistoricoempleado.
     */
    @org.junit.Test
    public void testGetIDEmpleado() {
        System.out.println("getIDEmpleado");
        puestohistoricoempleado instance = puestohistoemple;
        int expResult = 2;
        int result = instance.getIDEmpleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDEmpleado method, of class puestohistoricoempleado.
     */
    @org.junit.Test
    public void testSetIDEmpleado() {
        System.out.println("setIDEmpleado");
        int IDEmpleado = 2;
        puestohistoricoempleado instance = puestohistoemple;
        try{
           instance.setIDEmpleado(IDEmpleado); 
        }catch(Exception Ex){
         fail("The test case is a prototype.");   
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getIDPuesto method, of class puestohistoricoempleado.
     */
    @org.junit.Test
    public void testGetIDPuesto() {
        System.out.println("getIDPuesto");
        puestohistoricoempleado instance = puestohistoemple;
        int expResult = 3;
        int result = instance.getIDPuesto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDPuesto method, of class puestohistoricoempleado.
     */
    @org.junit.Test
    public void testSetIDPuesto() {
        System.out.println("setIDPuesto");
        int IDPuesto = 3;
        puestohistoricoempleado instance = puestohistoemple;
        try{
          instance.setIDPuesto(IDPuesto);  
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getFechaInicial method, of class puestohistoricoempleado.
     */
    @org.junit.Test
    public void testGetFechaInicial() {
        System.out.println("getFechaInicial");
        puestohistoricoempleado instance = puestohistoemple;
        Date expResult = new java.sql.Date(fecha.getTime());
        Date result = instance.getFechaInicial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaInicial method, of class puestohistoricoempleado.
     */
    @org.junit.Test
    public void testSetFechaInicial() {
        System.out.println("setFechaInicial");
        Date FechaInicial = new java.sql.Date(fecha.getTime());
        puestohistoricoempleado instance = puestohistoemple;
        try{
            instance.setFechaInicial(FechaInicial);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getFechaFinal method, of class puestohistoricoempleado.
     */
    @org.junit.Test
    public void testGetFechaFinal() {
        System.out.println("getFechaFinal");
        puestohistoricoempleado instance = puestohistoemple;
        Date expResult = new java.sql.Date(fecha.getTime());
        Date result = instance.getFechaFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaFinal method, of class puestohistoricoempleado.
     */
    @org.junit.Test
    public void testSetFechaFinal() {
        System.out.println("setFechaFinal");
        Date FechaFinal = new java.sql.Date(fecha.getTime());
        puestohistoricoempleado instance =  puestohistoemple;
        try{
            instance.setFechaFinal(FechaFinal);
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isActivo method, of class puestohistoricoempleado.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        puestohistoricoempleado instance = puestohistoemple;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class puestohistoricoempleado.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        puestohistoricoempleado instance = puestohistoemple;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
             fail("The test case is a prototype.");
        }
        
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class facturasanuladasTest {
    
   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date fecha; 
    facturasanuladas facturasanu;
    
    public facturasanuladasTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
             facturasanu = new facturasanuladas(1,2,3,"motivo",fecha);
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
     * Test of getIdfacturaanulada method, of class facturasanuladas.
     */
    @org.junit.Test
    public void testGetIdfacturaanulada() {
        System.out.println("getIdfacturaanulada");
        facturasanuladas instance = facturasanu;
        int expResult = 1;
        int result = instance.getIdfacturaanulada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdfacturaanulada method, of class facturasanuladas.
     */
    @org.junit.Test
    public void testSetIdfacturaanulada() {
        System.out.println("setIdfacturaanulada");
        int idfacturaanulada = 1;
        facturasanuladas instance = facturasanu;
        try{
           instance.setIdfacturaanulada(idfacturaanulada); 
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDFacturaEncabezado method, of class facturasanuladas.
     */
    @org.junit.Test
    public void testGetIDFacturaEncabezado() {
        System.out.println("getIDFacturaEncabezado");
        facturasanuladas instance = facturasanu;
        int expResult = 2;
        int result = instance.getIDFacturaEncabezado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDFacturaEncabezado method, of class facturasanuladas.
     */
    @org.junit.Test
    public void testSetIDFacturaEncabezado() {
        System.out.println("setIDFacturaEncabezado");
        int IDFacturaEncabezado = 2;
        facturasanuladas instance = facturasanu;
        try{
            instance.setIDFacturaEncabezado(IDFacturaEncabezado);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDEmpleado method, of class facturasanuladas.
     */
    @org.junit.Test
    public void testGetIDEmpleado() {
        System.out.println("getIDEmpleado");
        facturasanuladas instance = facturasanu;
        int expResult = 3;
        int result = instance.getIDEmpleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDEmpleado method, of class facturasanuladas.
     */
    @org.junit.Test
    public void testSetIDEmpleado() {
        System.out.println("setIDEmpleado");
        int IDEmpleado = 3;
        facturasanuladas instance = facturasanu;
        try{
            instance.setIDEmpleado(IDEmpleado);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMotivo method, of class facturasanuladas.
     */
    @org.junit.Test
    public void testGetMotivo() {
        System.out.println("getMotivo");
        facturasanuladas instance = facturasanu;
        String expResult = "motivo";
        String result = instance.getMotivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMotivo method, of class facturasanuladas.
     */
    @org.junit.Test
    public void testSetMotivo() {
        System.out.println("setMotivo");
        String Motivo = "motivo";
        facturasanuladas instance = facturasanu;
        try{
            instance.setMotivo(Motivo); 
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFechaAnulacion method, of class facturasanuladas.
     */
    @org.junit.Test
    public void testGetFechaAnulacion() {
        System.out.println("getFechaAnulacion");
        facturasanuladas instance = facturasanu;
        Date expResult = fecha;
        Date result = instance.getFechaAnulacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaAnulacion method, of class facturasanuladas.
     */
    @org.junit.Test
    public void testSetFechaAnulacion() {
        System.out.println("setFechaAnulacion");
        Date FechaAnulacion = fecha;
        facturasanuladas instance = facturasanu;
        try{
            instance.setFechaAnulacion(FechaAnulacion);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

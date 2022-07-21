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
public class descuentosTest {
    
   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date fecha; 
    descuentos descuentos;
    
    public descuentosTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
             descuentos = new descuentos(1,2,new java.sql.Date(fecha.getTime()),new java.sql.Date(fecha.getTime()),10.00,true);
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
     * Test of getIddescuento method, of class descuentos.
     */
    @org.junit.Test
    public void testGetIddescuento() {
        System.out.println("getIddescuento");
        descuentos instance = descuentos;
        int expResult = 1;
        int result = instance.getIddescuento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIddescuento method, of class descuentos.
     */
    @org.junit.Test
    public void testSetIddescuento() {
        System.out.println("setIddescuento");
        int iddescuento = 1;
        descuentos instance = descuentos;
        try{
            instance.setIddescuento(iddescuento);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getIDTipoDescuento method, of class descuentos.
     */
    @org.junit.Test
    public void testGetIDTipoDescuento() {
        System.out.println("getIDTipoDescuento");
        descuentos instance = descuentos;
        int expResult = 2;
        int result = instance.getIDTipoDescuento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDTipoDescuento method, of class descuentos.
     */
    @org.junit.Test
    public void testSetIDTipoDescuento() {
        System.out.println("setIDTipoDescuento");
        int IDTipoDescuento = 2;
        descuentos instance = descuentos;
        try{
            instance.setIDTipoDescuento(IDTipoDescuento);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFechaInicio method, of class descuentos.
     */
    @org.junit.Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        descuentos instance = descuentos;
        Date expResult = new java.sql.Date(fecha.getTime());
        java.sql.Date result = instance.getFechaInicio();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFechaInicio method, of class descuentos.
     */
    @org.junit.Test
    public void testSetFechaInicio() {
        System.out.println("setFechaInicio");
        Date FechaInicio = new java.sql.Date(fecha.getTime());
        descuentos instance = descuentos;
        try{
            instance.setFechaInicio(FechaInicio);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFechaFinal method, of class descuentos.
     */
    @org.junit.Test
    public void testGetFechaFinal() {
        System.out.println("getFechaFinal");
        descuentos instance = descuentos;
        Date expResult = new java.sql.Date(fecha.getTime());
        Date result = instance.getFechaFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaFinal method, of class descuentos.
     */
    @org.junit.Test
    public void testSetFechaFinal() {
        System.out.println("setFechaFinal");
        Date FechaFinal = new java.sql.Date(fecha.getTime());
        descuentos instance = descuentos;
        try{
            instance.setFechaFinal(FechaFinal);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getValor method, of class descuentos.
     */
    @org.junit.Test
    public void testGetValor() {
        System.out.println("getValor");
        descuentos instance = descuentos;
        double expResult = 10.00;
        double result = instance.getValor();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setValor method, of class descuentos.
     */
    @org.junit.Test
    public void testSetValor() {
        System.out.println("setValor");
        double Valor = 10.00;
        descuentos instance = descuentos;
        try{
            instance.setValor(Valor);
        }catch(Exception Ex){
            fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isActivo method, of class descuentos.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        descuentos instance = descuentos;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class descuentos.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        descuentos instance = descuentos;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
}

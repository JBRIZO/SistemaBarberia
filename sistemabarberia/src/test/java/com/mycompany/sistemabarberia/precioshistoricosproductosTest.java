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
public class precioshistoricosproductosTest {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date fecha; 
    precioshistoricosproductos precioshistopro;
    
    public precioshistoricosproductosTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
             precioshistopro = new precioshistoricosproductos(1,2,new java.sql.Date(fecha.getTime()),new java.sql.Date(fecha.getTime()),30.00,true);
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
     * Test of getNumprecio method, of class precioshistoricosproductos.
     */
    @org.junit.Test
    public void testGetNumprecio() {
        System.out.println("getNumprecio");
        precioshistoricosproductos instance = precioshistopro;
        int expResult = 1;
        int result = instance.getNumprecio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumprecio method, of class precioshistoricosproductos.
     */
    @org.junit.Test
    public void testSetNumprecio() {
        System.out.println("setNumprecio");
        int numprecio = 1;
        precioshistoricosproductos instance = precioshistopro;
        try{
            instance.setNumprecio(numprecio);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getIDProducto method, of class precioshistoricosproductos.
     */
    @org.junit.Test
    public void testGetIDProducto() {
        System.out.println("getIDProducto");
        precioshistoricosproductos instance = precioshistopro;
        int expResult = 2;
        int result = instance.getIDProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDProducto method, of class precioshistoricosproductos.
     */
    @org.junit.Test
    public void testSetIDProducto() {
        System.out.println("setIDProducto");
        int IDProducto = 2;
        precioshistoricosproductos instance = precioshistopro;
        try{
            instance.setIDProducto(IDProducto);
        }catch(Exception Ex){
             fail("The test case is a prototype.");
        }
        
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getFechaInicial method, of class precioshistoricosproductos.
     */
    @org.junit.Test
    public void testGetFechaInicial() {
        System.out.println("getFechaInicial");
        precioshistoricosproductos instance = precioshistopro;
        Date expResult = new java.sql.Date(fecha.getTime());
        Date result = instance.getFechaInicial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaInicial method, of class precioshistoricosproductos.
     */
    @org.junit.Test
    public void testSetFechaInicial() {
        System.out.println("setFechaInicial");
        Date FechaInicial = new java.sql.Date(fecha.getTime());
        precioshistoricosproductos instance = precioshistopro;
        try{
            instance.setFechaInicial(FechaInicial);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getFechaFinal method, of class precioshistoricosproductos.
     */
    @org.junit.Test
    public void testGetFechaFinal() {
        System.out.println("getFechaFinal");
        precioshistoricosproductos instance = precioshistopro;
        Date expResult = new java.sql.Date(fecha.getTime());
        Date result = instance.getFechaFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaFinal method, of class precioshistoricosproductos.
     */
    @org.junit.Test
    public void testSetFechaFinal() {
        System.out.println("setFechaFinal");
        Date FechaFinal = new java.sql.Date(fecha.getTime());
        precioshistoricosproductos instance = precioshistopro;
        try{
          instance.setFechaFinal(FechaFinal);  
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPrecio method, of class precioshistoricosproductos.
     */
    @org.junit.Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        precioshistoricosproductos instance = precioshistopro;
        double expResult = 30.00;
        double result = instance.getPrecio();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecio method, of class precioshistoricosproductos.
     */
    @org.junit.Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        double Precio = 30.00;
        precioshistoricosproductos instance = precioshistopro;
        try{
         instance.setPrecio(Precio);   
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isActivo method, of class precioshistoricosproductos.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        precioshistoricosproductos instance = precioshistopro;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class precioshistoricosproductos.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        precioshistoricosproductos instance = precioshistopro;
        try{
           instance.setActivo(Activo); 
        }catch(Exception Ex){
          fail("The test case is a prototype.");  
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }
}

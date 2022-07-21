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
public class precioshistoricoserviciosTest {
   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date fecha; 
    precioshistoricoservicios precioshisto;
    
    public precioshistoricoserviciosTest() {
         try { 
            fecha = sdf.parse("12/10/2021");
             precioshisto = new precioshistoricoservicios(1,2,new java.sql.Date(fecha.getTime()),new java.sql.Date(fecha.getTime()),200.00,true);
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
     * Test of getNumprecioservicio method, of class precioshistoricoservicios.
     */
    @org.junit.Test
    public void testGetNumprecioservicio() {
        System.out.println("getNumprecioservicio");
        precioshistoricoservicios instance = precioshisto;
        int expResult = 1;
        int result = instance.getNumprecioservicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumprecioservicio method, of class precioshistoricoservicios.
     */
    @org.junit.Test
    public void testSetNumprecioservicio() {
        System.out.println("setNumprecioservicio");
        int numprecioservicio = 1;
        precioshistoricoservicios instance = precioshisto;
        try{
            instance.setNumprecioservicio(numprecioservicio);
        }catch(Exception Ex){
             fail("The test case is a prototype.");
        }
        
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getIDServicio method, of class precioshistoricoservicios.
     */
    @org.junit.Test
    public void testGetIDServicio() {
        System.out.println("getIDServicio");
        precioshistoricoservicios instance = precioshisto;
        int expResult = 2;
        int result = instance.getIDServicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDServicio method, of class precioshistoricoservicios.
     */
    @org.junit.Test
    public void testSetIDServicio() {
        System.out.println("setIDServicio");
        int IDServicio = 2;
        precioshistoricoservicios instance = precioshisto;
        try{
           instance.setIDServicio(IDServicio); 
        }catch(Exception Ex){
          fail("The test case is a prototype.");  
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getFechaInicial method, of class precioshistoricoservicios.
     */
    @org.junit.Test
    public void testGetFechaInicial() {
        System.out.println("getFechaInicial");
        precioshistoricoservicios instance = precioshisto;
        Date expResult = new java.sql.Date(fecha.getTime()) ;
        Date result = instance.getFechaInicial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaInicial method, of class precioshistoricoservicios.
     */
    @org.junit.Test
    public void testSetFechaInicial() {
        System.out.println("setFechaInicial");
        Date FechaInicial = new java.sql.Date(fecha.getTime());
        precioshistoricoservicios instance = precioshisto;
        try{
           instance.setFechaInicial(FechaInicial); 
        }catch(Exception Ex){
             fail("The test case is a prototype.");
        }
        
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getFechaFinal method, of class precioshistoricoservicios.
     */
    @org.junit.Test
    public void testGetFechaFinal() {
        System.out.println("getFechaFinal");
        precioshistoricoservicios instance = precioshisto;
        Date expResult = new java.sql.Date(fecha.getTime());
        Date result = instance.getFechaFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaFinal method, of class precioshistoricoservicios.
     */
    @org.junit.Test
    public void testSetFechaFinal() {
        System.out.println("setFechaFinal");
        Date FechaFinal = new java.sql.Date(fecha.getTime());
        precioshistoricoservicios instance = precioshisto;
        try{
          instance.setFechaFinal(FechaFinal);  
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPrecio method, of class precioshistoricoservicios.
     */
    @org.junit.Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        precioshistoricoservicios instance = precioshisto;
        double expResult = 200.00;
        double result = instance.getPrecio();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecio method, of class precioshistoricoservicios.
     */
    @org.junit.Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        double Precio = 200.00;
        precioshistoricoservicios instance = precioshisto;
        try{
         instance.setPrecio(Precio);   
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isActivo method, of class precioshistoricoservicios.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        precioshistoricoservicios instance = precioshisto;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class precioshistoricoservicios.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        precioshistoricoservicios instance = precioshisto;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}

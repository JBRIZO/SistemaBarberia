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
public class parametrosTest {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date fecha; 
    parametros parametros;
    
    public parametrosTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
             parametros = new parametros(1,"llave",fecha,fecha,2,3,true);
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
     * Test of getRangoInicial method, of class parametros.
     */
    @org.junit.Test
    public void testGetRangoInicial() {
        System.out.println("getRangoInicial");
        parametros instance =  parametros;
        int expResult = 2;
        int result = instance.getRangoInicial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setRangoInicial method, of class parametros.
     */
    @org.junit.Test
    public void testSetRangoInicial() {
        System.out.println("setRangoInicial");
        int RangoInicial = 2;
        parametros instance = parametros;
        try{
          instance.setRangoInicial(RangoInicial);  
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRangoFinal method, of class parametros.
     */
    @org.junit.Test
    public void testGetRangoFinal() {
        System.out.println("getRangoFinal");
        parametros instance = parametros;
        int expResult = 3;
        int result = instance.getRangoFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setRangoFinal method, of class parametros.
     */
    @org.junit.Test
    public void testSetRangoFinal() {
        System.out.println("setRangoFinal");
        int RangoFinal = 3;
        parametros instance = parametros;
        try{
           instance.setRangoFinal(RangoFinal); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIdparametro method, of class parametros.
     */
    @org.junit.Test
    public void testGetIdparametro() {
        System.out.println("getIdparametro");
        parametros instance = parametros;
        int expResult = 1;
        int result = instance.getIdparametro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdparametro method, of class parametros.
     */
    @org.junit.Test
    public void testSetIdparametro() {
        System.out.println("setIdparametro");
        int idparametro = 1;
        parametros instance = parametros;
        try{
           instance.setIdparametro(idparametro); 
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail. 
    }

    /**
     * Test of getLlave method, of class parametros.
     */
    @org.junit.Test
    public void testGetLlave() {
        System.out.println("getLlave");
        parametros instance = parametros;
        String expResult = "llave";
        String result = instance.getLlave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setLlave method, of class parametros.
     */
    @org.junit.Test
    public void testSetLlave() {
        System.out.println("setLlave");
        String Llave = "llave";
        parametros instance = parametros;
        try{
            instance.setLlave(Llave);
        }catch(Exception Ex){
          fail("The test case is a prototype.");  
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFechaInicio method, of class parametros.
     */
    @org.junit.Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        parametros instance = parametros;
        Date expResult = fecha;
        Date result = instance.getFechaInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaInicio method, of class parametros.
     */
    @org.junit.Test
    public void testSetFechaInicio() {
        System.out.println("setFechaInicio");
        Date FechaInicio = fecha;
        parametros instance = parametros;
        try{
           instance.setFechaInicio(FechaInicio); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFechaFinal method, of class parametros.
     */
    @org.junit.Test
    public void testGetFechaFinal() {
        System.out.println("getFechaFinal");
        parametros instance = parametros;
        Date expResult = fecha;
        Date result = instance.getFechaFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaFinal method, of class parametros.
     */
    @org.junit.Test
    public void testSetFechaFinal() {
        System.out.println("setFechaFinal");
        Date FechaFinal = fecha;
        parametros instance = parametros;
        try{
           instance.setFechaFinal(FechaFinal); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isActivo method, of class parametros.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        parametros instance = parametros;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class parametros.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        parametros instance = parametros;
        try{
           instance.setActivo(Activo); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}

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
public class datosempresaTest {
    
   public datosempresaTest() {
    }
    
    private datosempresa datos = new datosempresa(1,"nombre","valor");
    
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
     * Test of getIddato method, of class datosempresa.
     */
    @org.junit.Test
    public void testGetIddato() {
        System.out.println("getIddato");
        datosempresa instance = datos;
        int expResult = 1;
        int result = instance.getIddato();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIddato method, of class datosempresa.
     */
    @org.junit.Test
    public void testSetIddato() {
        System.out.println("setIddato");
        int iddato = 1;
        datosempresa instance = datos;
        try{
            instance.setIddato(iddato);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getNombre method, of class datosempresa.
     */
    @org.junit.Test
    public void testGetNombre() {
        System.out.println("getNombre");
        datosempresa instance = datos;
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class datosempresa.
     */
    @org.junit.Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String Nombre = "nombre";
        datosempresa instance = datos;
        try{
           instance.setNombre(Nombre); 
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getValor method, of class datosempresa.
     */
    @org.junit.Test
    public void testGetValor() {
        System.out.println("getValor");
        datosempresa instance = datos;
        String expResult = "valor";
        String result = instance.getValor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setValor method, of class datosempresa.
     */
    @org.junit.Test
    public void testSetValor() {
        System.out.println("setValor");
        String Valor = "valor";
        datosempresa instance = datos;
        try{
        instance.setValor(Valor);
      }catch(Exception Ex){
           fail("The test case is a prototype.");
      }  
        // TODO review the generated test code and remove the default call to fail.
}
}

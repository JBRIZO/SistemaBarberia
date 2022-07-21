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
public class tipodocumentoTest {
    
   public tipodocumentoTest() {
    }
    
    private tipodocumento tipodocu = new tipodocumento(1,"documento",true);
    
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
     * Test of getIdtipodocumento method, of class tipodocumento.
     */
    @org.junit.Test
    public void testGetIdtipodocumento() {
        System.out.println("getIdtipodocumento");
        tipodocumento instance = tipodocu;
        int expResult = 1;
        int result = instance.getIdtipodocumento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdtipodocumento method, of class tipodocumento.
     */
    @org.junit.Test
    public void testSetIdtipodocumento() {
        System.out.println("setIdtipodocumento");
        int idtipodocumento = 1;
        tipodocumento instance = tipodocu;
        try{
            instance.setIdtipodocumento(idtipodocumento);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTipoDocumento method, of class tipodocumento.
     */
    @org.junit.Test
    public void testGetTipoDocumento() {
        System.out.println("getTipoDocumento");
        tipodocumento instance = tipodocu;
        String expResult = "documento";
        String result = instance.getTipoDocumento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoDocumento method, of class tipodocumento.
     */
    @org.junit.Test
    public void testSetTipoDocumento() {
        System.out.println("setTipoDocumento");
        String TipoDocumento = "documento";
        tipodocumento instance = tipodocu;
        try{
           instance.setTipoDocumento(TipoDocumento); 
        }catch(Exception Ex){
          fail("The test case is a prototype.");  
        }
        // TODO review the generated test code and remove the default call to fail. 
    }

    /**
     * Test of isActivo method, of class tipodocumento.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        tipodocumento instance = tipodocu;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class tipodocumento.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        tipodocumento instance = tipodocu;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

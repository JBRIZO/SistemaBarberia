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
public class UsuarioSingletonTest {
    
    public UsuarioSingletonTest() {
    }
    
    private usuarios usuario = new usuarios(1,0,"jbrizo123","jonathan1234",true,0);
    
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
     * Test of getUsuario method, of class UsuarioSingleton.
     */
    @org.junit.Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        try{
            UsuarioSingleton result = UsuarioSingleton.getUsuario(usuario);
        }catch(Exception ex){
            fail("Prueba fallida.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCuenta method, of class UsuarioSingleton.
     */
    @org.junit.Test
    public void testGetCuenta() {
        System.out.println("getCuenta");
        
        UsuarioSingleton instance = UsuarioSingleton.getUsuario(usuario);
        instance.setUsuario(usuario);
        assertEquals(usuario, instance.getCuenta());
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreUsuario method, of class UsuarioSingleton.
     */
    @org.junit.Test
    public void testGetNombreUsuario() {
        System.out.println("getNombreUsuario");
        UsuarioSingleton instance = UsuarioSingleton.getUsuario(usuario);
        String expResult = "jbrizo123";
        String result = instance.getNombreUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario method, of class UsuarioSingleton.
     */
    @org.junit.Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        
        usuarios usuario = new usuarios();
        usuarios usuario2 = new usuarios();
        
        
        UsuarioSingleton instance = UsuarioSingleton.getUsuario(usuario);
        instance.setUsuario(usuario2);
        assertEquals(usuario2,instance.getCuenta());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}

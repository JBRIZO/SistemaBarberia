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
public class usuariosTest {
    
   public usuariosTest() {
    }
    
    private usuarios usu = new usuarios(1,2,"cuenta","contra",true,3);
    
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
     * Test of getIdusuario method, of class usuarios.
     */
    @org.junit.Test
    public void testGetIdusuario() {
        System.out.println("getIdusuario");
        usuarios instance = usu;
        int expResult = 1;
        int result = instance.getIdusuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdusuario method, of class usuarios.
     */
    @org.junit.Test
    public void testSetIdusuario() {
        System.out.println("setIdusuario");
        int idusuario = 1;
        usuarios instance = usu;
        try{
            instance.setIdusuario(idusuario);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDEmpleado method, of class usuarios.
     */
    @org.junit.Test
    public void testGetIDEmpleado() {
        System.out.println("getIDEmpleado");
        usuarios instance = usu;
        int expResult = 2;
        int result = instance.getIDEmpleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDEmpleado method, of class usuarios.
     */
    @org.junit.Test
    public void testSetIDEmpleado() {
        System.out.println("setIDEmpleado");
        int IDEmpleado = 2;
        usuarios instance = usu;
        try{
            instance.setIDEmpleado(IDEmpleado);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.       
    }

    /**
     * Test of getNomCuenta method, of class usuarios.
     */
    @org.junit.Test
    public void testGetNomCuenta() {
        System.out.println("getNomCuenta");
        usuarios instance = usu;
        String expResult = "cuenta";
        String result = instance.getNomCuenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNomCuenta method, of class usuarios.
     */
    @org.junit.Test
    public void testSetNomCuenta() {
        System.out.println("setNomCuenta");
        String NomCuenta = "cuenta";
        usuarios instance = usu;
        try{
            instance.setNomCuenta(NomCuenta);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getContrasena method, of class usuarios.
     */
    @org.junit.Test
    public void testGetContrasena() {
        System.out.println("getContrasena");
        usuarios instance = usu;
        String expResult = "contra";
        String result = instance.getContrasena();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setContrasena method, of class usuarios.
     */
    @org.junit.Test
    public void testSetContrasena() {
        System.out.println("setContrasena");
        String Contrasena = "contra";
        usuarios instance = usu;
        try{
            instance.setContrasena(Contrasena);
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.   
    }

    /**
     * Test of getActivo method, of class usuarios.
     */
    @org.junit.Test
    public void testGetActivo() {
        System.out.println("getActivo");
        usuarios instance = usu;
        Boolean expResult = true;
        Boolean result = instance.getActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class usuarios.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        Boolean Activo = true;
        usuarios instance = usu;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIntentos method, of class usuarios.
     */
    @org.junit.Test
    public void testGetIntentos() {
        System.out.println("getIntentos");
        usuarios instance = usu;
        int expResult = 3;
        int result = instance.getIntentos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIntentos method, of class usuarios.
     */
    @org.junit.Test
    public void testSetIntentos() {
        System.out.println("setIntentos");
        int Intentos = 3;
        usuarios instance = usu;
        try{
          instance.setIntentos(Intentos);  
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

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
public class empleadoTest {
   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date fecha; 
    empleado emple;
    
    public empleadoTest() {
        
                try { 
            fecha = sdf.parse("12/10/2021");
             emple = new empleado(1,3,"0801199712340","Alejandro","Castro",new java.sql.Date(fecha.getTime()),'M',"el pedregal",
                "2234056",new java.sql.Date(fecha.getTime()),new java.sql.Date(fecha.getTime()),true);
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
     * Test of getIdempleado method, of class empleado.
     */
    @org.junit.Test
    public void testGetIdempleado() {
        System.out.println("getIdempleado");
        empleado instance = emple;
        int expResult = 1;
        int result = instance.getIdempleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdempleado method, of class empleado.
     */
    @org.junit.Test
    public void testSetIdempleado() {
        System.out.println("setIdempleado");
        int idempleado = 1;
        empleado instance =  emple;
        try{
           instance.setIdempleado(idempleado); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDTipoDocumento method, of class empleado.
     */
    @org.junit.Test
    public void testGetIDTipoDocumento() {
        System.out.println("getIDTipoDocumento");
        empleado instance = emple;
        int expResult = 3;
        int result = instance.getIDTipoDocumento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDTipoDocumento method, of class empleado.
     */
    @org.junit.Test
    public void testSetIDTipoDocumento() {
        System.out.println("setIDTipoDocumento");
        int IDTipoDocumento = 3;
        empleado instance = emple;
        try{
            instance.setIDTipoDocumento(IDTipoDocumento);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNomEmpleado method, of class empleado.
     */
    @org.junit.Test
    public void testGetNomEmpleado() {
        System.out.println("getNomEmpleado");
        empleado instance =  emple;
        String expResult = "Alejandro";
        String result = instance.getNomEmpleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNomEmpleado method, of class empleado.
     */
    @org.junit.Test
    public void testSetNomEmpleado() {
        System.out.println("setNomEmpleado");
        String NomEmpleado = "Alejandro";
        empleado instance =  emple;
        try{
            instance.setNomEmpleado(NomEmpleado);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        } 
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getGenEmpleado method, of class empleado.
     */
    @org.junit.Test
    public void testGetGenEmpleado() {
        System.out.println("getGenEmpleado");
        empleado instance = emple;
        char expResult = 'M';
        char result = instance.getGenEmpleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setGenEmpleado method, of class empleado.
     */
    @org.junit.Test
    public void testSetGenEmpleado() {
        System.out.println("setGenEmpleado");
        char GenEmpleado = 'M';
        empleado instance = emple;
        try{
            instance.setGenEmpleado(GenEmpleado);
        }catch(Exception Ex){
            fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDireccion method, of class empleado.
     */
    @org.junit.Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        empleado instance =  emple;
        String expResult = "el pedregal";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class empleado.
     */
    @org.junit.Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String Direccion = "el pedregal";
        empleado instance = emple;
        try{
           instance.setDireccion(Direccion); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNumCelular method, of class empleado.
     */
    @org.junit.Test
    public void testGetNumCelular() {
        System.out.println("getNumCelular");
        empleado instance = emple;
        String expResult = "2234056";
        String result = instance.getNumCelular();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumCelular method, of class empleado.
     */
    @org.junit.Test
    public void testSetNumCelular() {
        System.out.println("setNumCelular");
        String NumCelular = "2234056";
        empleado instance = emple;
        try{
           instance.setNumCelular(NumCelular); 
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFechaFinal method, of class empleado.
     */
    @org.junit.Test
    public void testGetFechaFinal() {
        System.out.println("getFechaFinal");
        empleado instance =  emple;
        Date expResult = new java.sql.Date(fecha.getTime());
        Date result = instance.getFechaFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaFinal method, of class empleado.
     */
    @org.junit.Test
    public void testSetFechaFinal() {
        System.out.println("setFechaFinal");
        Date FechaFinal = new java.sql.Date(fecha.getTime());
        empleado instance =  emple;
        try{
            instance.setFechaFinal(FechaFinal);
        }catch(Exception Ex){
             fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isActivo method, of class empleado.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        empleado instance = emple;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class empleado.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        empleado instance = emple;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getApeEmpleado method, of class empleado.
     */
    @org.junit.Test
    public void testGetApeEmpleado() {
        System.out.println("getApeEmpleado");
        empleado instance = emple;
        String expResult = "Castro";
        String result = instance.getApeEmpleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setApeEmpleado method, of class empleado.
     */
    @org.junit.Test
    public void testSetApeEmpleado() {
        System.out.println("setApeEmpleado");
        String ApeEmpleado = "Castro";
        empleado instance = emple;
        try{
            instance.setApeEmpleado(ApeEmpleado);
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFechaInicio method, of class empleado.
     */
    @org.junit.Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        empleado instance = emple;
        Date expResult = new java.sql.Date(fecha.getTime());
        Date result = instance.getFechaInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaInicio method, of class empleado.
     */
    @org.junit.Test
    public void testSetFechaInicio() {
        System.out.println("setFechaInicio");
        Date FechaInicio = new java.sql.Date(fecha.getTime());
        empleado instance =  emple;
        try{
           instance.setFechaInicio(FechaInicio); 
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFechaNacimiento method, of class empleado.
     */
    @org.junit.Test
    public void testGetFechaNacimiento() {
        System.out.println("getFechaNacimiento");
        empleado instance = emple;
        Date expResult = new java.sql.Date(fecha.getTime());
        Date result = instance.getFechaNacimiento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaNacimiento method, of class empleado.
     */
    @org.junit.Test
    public void testSetFechaNacimiento() {
        System.out.println("setFechaNacimiento");
        Date FechaNacimiento = new java.sql.Date(fecha.getTime());
        empleado instance = emple;
        try{
           instance.setFechaNacimiento(FechaNacimiento); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }   
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNumDoc method, of class empleado.
     */
    @org.junit.Test
    public void testGetNumDoc() {
        System.out.println("getNumDoc");
        empleado instance =  emple;
        String expResult = "0801199712340";
        String result = instance.getNumDoc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumDoc method, of class empleado.
     */
    @org.junit.Test
    public void testSetNumDoc() {
        System.out.println("setNumDoc");
        String NumDoc = "0801199712340";
        empleado instance = emple;
        try{
            instance.setNumDoc(NumDoc);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import java.text.ParseException;
import java.util.Date;
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
public class clientesTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha; 
    clientes cliente;
    
    public clientesTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
             cliente = new clientes(1,"lionel","hernandez",1,"0801200020654",1,fecha,"32045678",true);
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
     * Test of getIdcliente method, of class clientes.
     */
    @org.junit.Test
    public void testGetIdcliente() {
        System.out.println("getIdcliente");
        clientes instance = cliente;
        int expResult = 1;
        int result = instance.getIdcliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdcliente method, of class clientes.
     */
    @org.junit.Test
    public void testSetIdcliente() {
        System.out.println("setIdcliente");
        int idcliente = 0;
        clientes instance = new clientes();
        try{
            instance.setIdcliente(idcliente);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to //fail.
        
    }

    /**
     * Test of getNomCliente method, of class clientes.
     */
    @org.junit.Test
    public void testGetNomCliente() {
        System.out.println("getNomCliente");
        clientes instance = cliente;
        String expResult = "lionel";
        String result = instance.getNomCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNomCliente method, of class clientes.
     */
    @org.junit.Test
    public void testSetNomCliente() {
        System.out.println("setNomCliente");
        String NomCliente = "";
        clientes instance = new clientes();
        try{
            instance.setNomCliente(NomCliente);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to //fail.
        //
    }

    /**
     * Test of getApeCliente method, of class clientes.
     */
    @org.junit.Test
    public void testGetApeCliente() {
        System.out.println("getApeCliente");
        clientes instance = cliente;
        String expResult = "hernandez";
        String result = instance.getApeCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setApeCliente method, of class clientes.
     */
    @org.junit.Test
    public void testSetApeCliente() {
        System.out.println("setApeCliente");
        String ApeCliente = "";
        clientes instance = new clientes();
        try{
            instance.setApeCliente(ApeCliente);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to //fail.
        //
    }

    /**
     * Test of getIDTipoDocumento method, of class clientes.
     */
    @org.junit.Test
    public void testGetIDTipoDocumento() {
        System.out.println("getIDTipoDocumento");
        clientes instance = cliente;
        int expResult = 1;
        int result = instance.getIDTipoDocumento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDTipoDocumento method, of class clientes.
     */
    @org.junit.Test
    public void testSetIDTipoDocumento() {
        System.out.println("setIDTipoDocumento");
        int IDTipoDocumento = 0;
        clientes instance = new clientes();
        try{
            instance.setIDTipoDocumento(IDTipoDocumento);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to //fail.
    }

    /**
     * Test of getNumDocumento method, of class clientes.
     */
    @org.junit.Test
    public void testGetNumDocumento() {
        System.out.println("getNumDocumento");
        clientes instance = cliente;
        String expResult = "0801200020654";
        String result = instance.getNumDocumento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumDocumento method, of class clientes.
     */
    @org.junit.Test
    public void testSetNumDocumento() {
        System.out.println("setNumDocumento");
        String NumDocumento = "";
        clientes instance = new clientes();
        try{
            instance.setNumDocumento(NumDocumento);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to //fail.
    }

    /**
     * Test of getIDServicio method, of class clientes.
     */
    @org.junit.Test
    public void testGetIDServicio() {
        System.out.println("getIDServicio");
        clientes instance = cliente;
        int expResult = 1;
        int result = instance.getIDServicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDServicio method, of class clientes.
     */
    @org.junit.Test
    public void testSetIDServicio() {
        System.out.println("setIDServicio");
        int IDServicio = 0;
        clientes instance = new clientes();
        try{
            instance.setIDServicio(IDServicio);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to //fail.
    }

    /**
     * Test of getFechaNacimiento method, of class clientes.
     */
    @org.junit.Test
    public void testGetFechaNacimiento() {
        System.out.println("getFechaNacimiento");
        System.out.println(cliente.getFechaNacimiento());
        clientes instance = cliente;
        Date expResult = fecha;
        Date result = instance.getFechaNacimiento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaNacimiento method, of class clientes.
     */
    @org.junit.Test
    public void testSetFechaNacimiento() {
        System.out.println("setFechaNacimiento");
        Date FechaNacimiento = fecha;
        clientes instance = new clientes();
        try{
            instance.setFechaNacimiento(FechaNacimiento);
        }catch(Exception Ex){
        fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to //fail.
    }

    /**
     * Test of getNumTelefono method, of class clientes.
     */
    @org.junit.Test
    public void testGetNumTelefono() {
        System.out.println("getNumTelefono");
        clientes instance = cliente;
        String expResult = "32045678";
        String result = instance.getNumTelefono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumTelefono method, of class clientes.
     */
    @org.junit.Test
    public void testSetNumTelefono() {
        System.out.println("setNumTelefono");
        String NumTelefono = "12345678";
        clientes instance = new clientes();
        try{
            instance.setNumTelefono(NumTelefono);
        }catch(Exception Ex){
        fail("The test case is a prototype.");}
        // TODO review the generated test code and remove the default call to //fail.
    }

    /**
     * Test of isActivo method, of class clientes.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        clientes instance = cliente;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class clientes.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = false;
        clientes instance = new clientes();
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
        fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to //fail.
        //
    } 
}

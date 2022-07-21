/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

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
public class facturaencabezadoTest {
    
   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date fecha; 
    facturaencabezado facturaenca;
    
    public facturaencabezadoTest() {
         try { 
            fecha = sdf.parse("12/10/2021");
             facturaenca = new facturaencabezado(1,2,"1234",3,4,5,6,7,"12/03/2021",100.00,115.00,"12345678");
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
     * Test of getNumTarjeta method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testGetNumTarjeta() {
        System.out.println("getNumTarjeta");
        facturaencabezado instance = facturaenca;
        String expResult = "12345678";
        String result = instance.getNumTarjeta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumTarjeta method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testSetNumTarjeta() {
        System.out.println("setNumTarjeta");
        String NumTarjeta = "12345678";
        facturaencabezado instance = facturaenca;
        try{
            instance.setNumTarjeta(NumTarjeta);
        }catch(Exception Ex){
             fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIdfacturaencabezado method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testGetIdfacturaencabezado() {
        System.out.println("getIdfacturaencabezado");
        facturaencabezado instance = facturaenca;
        int expResult = 1;
        int result = instance.getIdfacturaencabezado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdfacturaencabezado method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testSetIdfacturaencabezado() {
        System.out.println("setIdfacturaencabezado");
        int idfacturaencabezado = 1;
        facturaencabezado instance = facturaenca;
        try{
           instance.setIdfacturaencabezado(idfacturaencabezado); 
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail. 
    }

    /**
     * Test of getIDCliente method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testGetIDCliente() {
        System.out.println("getIDCliente");
        facturaencabezado instance = facturaenca;
        int expResult = 2;
        int result = instance.getIDCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDCliente method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testSetIDCliente() {
        System.out.println("setIDCliente");
        int IDCliente = 2;
        facturaencabezado instance = facturaenca;
        try{
            instance.setIDCliente(IDCliente);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDVendedor method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testGetIDVendedor() {
        System.out.println("getIDVendedor");
        facturaencabezado instance = facturaenca;
        int expResult = 3;
        int result = instance.getIDVendedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDVendedor method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testSetIDVendedor() {
        System.out.println("setIDVendedor");
        int IDVendedor = 3;
        facturaencabezado instance = facturaenca;
        try{
            instance.setIDVendedor(IDVendedor);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDBarbero method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testGetIDBarbero() {
        System.out.println("getIDBarbero");
        facturaencabezado instance = facturaenca;
        Integer expResult = 4;
        Integer result = instance.getIDBarbero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDBarbero method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testSetIDBarbero() {
        System.out.println("setIDBarbero");
        Integer IDBarbero = 4;
        facturaencabezado instance = facturaenca;
        try{
            instance.setIDBarbero(IDBarbero);
        }catch(Exception Ex){
             fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDTipoPago method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testGetIDTipoPago() {
        System.out.println("getIDTipoPago");
        facturaencabezado instance = facturaenca;
        int expResult = 5;
        int result = instance.getIDTipoPago();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDTipoPago method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testSetIDTipoPago() {
        System.out.println("setIDTipoPago");
        int IDTipoPago = 5;
        facturaencabezado instance = facturaenca;
        try{
           instance.setIDTipoPago(IDTipoPago); 
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDParametro method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testGetIDParametro() {
        System.out.println("getIDParametro");
        facturaencabezado instance = facturaenca;
        int expResult = 6;
        int result = instance.getIDParametro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDParametro method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testSetIDParametro() {
        System.out.println("setIDParametro");
        int IDParametro = 6;
        facturaencabezado instance = facturaenca;
        try{
          instance.setIDParametro(IDParametro);  
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIDEstado method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testGetIDEstado() {
        System.out.println("getIDEstado");
        facturaencabezado instance = facturaenca;
        int expResult = 7;
        int result = instance.getIDEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDEstado method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testSetIDEstado() {
        System.out.println("setIDEstado");
        int IDEstado = 7;
        facturaencabezado instance = facturaenca;
        try{
             instance.setIDEstado(IDEstado);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFechaFactura method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testGetFechaFactura() {
        System.out.println("getFechaFactura");
        facturaencabezado instance = facturaenca;
        String expResult = "12/03/2021";
        String result = instance.getFechaFactura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaFactura method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testSetFechaFactura() {
        System.out.println("setFechaFactura");
        String FechaFactura = "12/03/2021";
        facturaencabezado instance =  facturaenca;
        try{
            instance.setFechaFactura(FechaFactura);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMontoTarjeta method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testGetMontoTarjeta() {
        System.out.println("getMontoTarjeta");
        facturaencabezado instance = facturaenca;
        double expResult = 100.00;
        double result = instance.getMontoTarjeta();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMontoTarjeta method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testSetMontoTarjeta() {
        System.out.println("setMontoTarjeta");
        double MontoTarjeta = 100.00;
        facturaencabezado instance = facturaenca;
        try{
            instance.setMontoTarjeta(MontoTarjeta);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTotalFactura method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testGetTotalFactura() {
        System.out.println("getTotalFactura");
        facturaencabezado instance = facturaenca;
        double expResult = 115.00;
        double result = instance.getTotalFactura();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalFactura method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testSetTotalFactura() {
        System.out.println("setTotalFactura");
        double TotalFactura = 115.00;
        facturaencabezado instance = facturaenca;
        try{
         instance.setTotalFactura(TotalFactura);   
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNumFactura method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testGetNumFactura() {
        System.out.println("getNumFactura");
        facturaencabezado instance = facturaenca;
        String expResult = "1234";
        String result = instance.getNumFactura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumFactura method, of class facturaencabezado.
     */
    @org.junit.Test
    public void testSetNumFactura() {
        System.out.println("setNumFactura");
        String NumFactura = "1234";
        facturaencabezado instance = facturaenca;
        try{
          instance.setNumFactura(NumFactura);  
        }catch(Exception Ex){
          fail("The test case is a prototype.");  
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

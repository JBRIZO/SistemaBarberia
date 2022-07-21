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
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan Laux
 */
public class salariohistoricoempleadosTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date fecha; 
    salariohistoricoempleados salario;
    public salariohistoricoempleadosTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
            salario = new salariohistoricoempleados(1,1,new java.sql.Date(fecha.getTime()),new java.sql.Date(fecha.getTime()),12000.00,true);
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
     * Test of getIdsalario method, of class salariohistoricoempleados.
     */
    @org.junit.Test
    public void testGetIdsalario() {
        System.out.println("getIdsalario");
        salariohistoricoempleados instance = salario;
        int expResult = 1;
        int result = instance.getIdsalario();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdsalario method, of class salariohistoricoempleados.
     */
    @org.junit.Test
    public void testSetIdsalario() {
        System.out.println("setIdsalario");
        int Idsalario = 1;
        salariohistoricoempleados instance = salario;
        
        try{instance.setIdsalario(Idsalario);}catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getIDEmpleado method, of class salariohistoricoempleados.
     */
    @org.junit.Test
    public void testGetIDEmpleado() {
        System.out.println("getIDEmpleado");
        salariohistoricoempleados instance = salario;
        int expResult = 1;
        int result = instance.getIDEmpleado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIDEmpleado method, of class salariohistoricoempleados.
     */
    @org.junit.Test
    public void testSetIDEmpleado() {
        System.out.println("setIDEmpleado");
        int IDEmpleado = 0;
        salariohistoricoempleados instance = salario;
        try{instance.setIDEmpleado(IDEmpleado);}catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getFechaInicial method, of class salariohistoricoempleados.
     */
    @org.junit.Test
    public void testGetFechaInicial() {
        System.out.println("getFechaInicial");
        salariohistoricoempleados instance = salario;
        Date expResult = new java.sql.Date(fecha.getTime());
        Date result = instance.getFechaInicial();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFechaInicial method, of class salariohistoricoempleados.
     */
    @org.junit.Test
    public void testSetFechaInicial() {
        System.out.println("setFechaInicial");
        Date FechaInicial = new java.sql.Date(fecha.getTime());
        salariohistoricoempleados instance = salario;
        try{instance.setFechaInicial(FechaInicial);}catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getFechaFinal method, of class salariohistoricoempleados.
     */
    @org.junit.Test
    public void testGetFechaFinal() {
        System.out.println("getFechaFinal");
        salariohistoricoempleados instance = salario;
        Date expResult = new java.sql.Date(fecha.getTime());
        Date result = instance.getFechaFinal();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFechaFinal method, of class salariohistoricoempleados.
     */
    @org.junit.Test
    public void testSetFechaFinal() {
        System.out.println("setFechaFinal");
        Date FechaFinal = null;
        salariohistoricoempleados instance = salario;
        try{instance.setFechaFinal(FechaFinal);}catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getSalario method, of class salariohistoricoempleados.
     */
    @org.junit.Test
    public void testGetSalario() {
        System.out.println("getSalario");
        salariohistoricoempleados instance = salario;
        double expResult = 12000.00;
        double result = instance.getSalario();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setSalario method, of class salariohistoricoempleados.
     */
    @org.junit.Test
    public void testSetSalario() {
        System.out.println("setSalario");
        double Salario = 0.0;
        salariohistoricoempleados instance = salario;
        try{instance.setSalario(Salario);}catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of isActivo method, of class salariohistoricoempleados.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        salariohistoricoempleados instance = salario;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActivo method, of class salariohistoricoempleados.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = false;
        salariohistoricoempleados instance = salario;
        try{instance.setActivo(Activo);}catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }
    
}

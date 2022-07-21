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
public class bonosempleadomensualTest {
    
    public bonosempleadomensualTest() {
    }
    
    private bonosempleadomensual bono = new bonosempleadomensual(1,1,1,100.00,"202110",true);
    
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
     * Test of getNumbono method, of class bonosempleadomensual.
     */
    @org.junit.Test
    public void testGetNumbono() {
        System.out.println("getNumbono");
        bonosempleadomensual instance = bono;
        int expResult = 1;
        int result = instance.getNumbono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumbono method, of class bonosempleadomensual.
     */
    @org.junit.Test
    public void testSetNumbono() {
        System.out.println("setNumbono");
        int numbono = 0;
        bonosempleadomensual instance = bono;
        instance.setNumbono(numbono);
        assertEquals(0,instance.getNumbono());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIdEmpleado method, of class bonosempleadomensual.
     */
    @org.junit.Test
    public void testGetIdEmpleado() {
        System.out.println("getIdEmpleado");
        bonosempleadomensual instance = bono;
        int expResult = 1;
        int result = instance.getIdEmpleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdEmpleado method, of class bonosempleadomensual.
     */
    @org.junit.Test
    public void testSetIdEmpleado() {
        System.out.println("setIdEmpleado");
        int IdEmpleado = 0;
        bonosempleadomensual instance = bono;
        instance.setIdEmpleado(IdEmpleado);
        assertEquals(0,instance.getIdEmpleado());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIDTipoBono method, of class bonosempleadomensual.
     */
    @org.junit.Test
    public void testGetIDTipoBono() {
        System.out.println("getIDTipoBono");
        bonosempleadomensual instance = bono;
        int expResult = 1;
        int result = instance.getIDTipoBono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDTipoBono method, of class bonosempleadomensual.
     */
    @org.junit.Test
    public void testSetIDTipoBono() {
        System.out.println("setIDTipoBono");
        int IDTipoBono = 0;
        bonosempleadomensual instance = bono;
        instance.setIDTipoBono(IDTipoBono);
        assertEquals(0,instance.getIDTipoBono());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getValor method, of class bonosempleadomensual.
     */
    @org.junit.Test
    public void testGetValor() {
        System.out.println("getValor");
        bonosempleadomensual instance = bono;
        double expResult = 100.00;
        double result = instance.getValor();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setValor method, of class bonosempleadomensual.
     */
    @org.junit.Test
    public void testSetValor() {
        System.out.println("setValor");
        double Valor = 0.0;
        bonosempleadomensual instance = bono;
        instance.setValor(Valor);
        assertEquals(0.0,instance.getValor(),0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPeriodo method, of class bonosempleadomensual.
     */
    @org.junit.Test
    public void testGetPeriodo() {
        System.out.println("getPeriodo");
        bonosempleadomensual instance = bono;
        String expResult = "202110";
        String result = instance.getPeriodo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPeriodo method, of class bonosempleadomensual.
     */
    @org.junit.Test
    public void testSetPeriodo() {
        System.out.println("setPeriodo");
        String Periodo = "202111";
        bonosempleadomensual instance = bono;
        instance.setPeriodo(Periodo);
        assertEquals(Periodo,instance.getPeriodo());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getActivo method, of class bonosempleadomensual.
     */
    @org.junit.Test
    public void testGetActivo() {
        System.out.println("getActivo");
        bonosempleadomensual instance = bono;
        boolean expResult = true;
        boolean result = instance.getActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class bonosempleadomensual.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = false;
        bonosempleadomensual instance = bono;
        instance.setActivo(Activo);
        assertEquals(Activo,instance.getActivo());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

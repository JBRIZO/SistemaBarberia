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
public class deduccionesempleadomensualTest {
    
  public deduccionesempleadomensualTest() {
    }
    
    private deduccionesempleadomensual deducciones = new deduccionesempleadomensual(2,1,3,100.00, "periodo",true);
    
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
     * Test of getNumdeduccion method, of class deduccionesempleadomensual.
     */
    @org.junit.Test
    public void testGetNumdeduccion() {
        System.out.println("getNumdeduccion");
        deduccionesempleadomensual instance = deducciones;
        int expResult = 2;
        int result = instance.getNumdeduccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumdeduccion method, of class deduccionesempleadomensual.
     */
    @org.junit.Test
    public void testSetNumdeduccion() {
        System.out.println("setNumdeduccion");
        int numdeduccion = 2;
        deduccionesempleadomensual instance = deducciones;
        try{
            instance.setNumdeduccion(numdeduccion);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
           // TODO review the generated test code and remove the default call to fail.
        }

    /**
     * Test of getIDEmpleado method, of class deduccionesempleadomensual.
     */
    @org.junit.Test
    public void testGetIDEmpleado() {
        System.out.println("getIDEmpleado");
        deduccionesempleadomensual instance = deducciones;
        int expResult = 1;
        int result = instance.getIDEmpleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDEmpleado method, of class deduccionesempleadomensual.
     */
    @org.junit.Test
    public void testSetIDEmpleado() {
        System.out.println("setIDEmpleado");
        int IDEmpleado = 1;
        deduccionesempleadomensual instance = deducciones;
        try{
            instance.setIDEmpleado(IDEmpleado);
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
        }

    /**
     * Test of getIDTipoDeduccion method, of class deduccionesempleadomensual.
     */
    @org.junit.Test
    public void testGetIDTipoDeduccion() {
        System.out.println("getIDTipoDeduccion");
        deduccionesempleadomensual instance = deducciones;
        int expResult = 3;
        int result = instance.getIDTipoDeduccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIDTipoDeduccion method, of class deduccionesempleadomensual.
     */
    @org.junit.Test
    public void testSetIDTipoDeduccion() {
        System.out.println("setIDTipoDeduccion");
        int IDTipoDeduccion = 3;
        deduccionesempleadomensual instance = deducciones;
        try{
            instance.setIDTipoDeduccion(IDTipoDeduccion);
        }catch(Exception Ex){
             fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getValor method, of class deduccionesempleadomensual.
     */
    @org.junit.Test
    public void testGetValor() {
        System.out.println("getValor");
        deduccionesempleadomensual instance = deducciones;
        double expResult = 100.00;
        double result = instance.getValor();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setValor method, of class deduccionesempleadomensual.
     */
    @org.junit.Test
    public void testSetValor() {
        System.out.println("setValor");
        double Valor = 100.00;
        deduccionesempleadomensual instance = deducciones;
        try{
            instance.setValor(Valor);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPeriodo method, of class deduccionesempleadomensual.
     */
    @org.junit.Test
    public void testGetPeriodo() {
        System.out.println("getPeriodo");
        deduccionesempleadomensual instance = deducciones;
        String expResult = "periodo";
        String result = instance.getPeriodo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPeriodo method, of class deduccionesempleadomensual.
     */
    @org.junit.Test
    public void testSetPeriodo() {
        System.out.println("setPeriodo");
        String Periodo = "periodo";
        deduccionesempleadomensual instance = deducciones;
        try{
             instance.setPeriodo(Periodo);
        }catch(Exception Ex){
           fail("The test case is a prototype."); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isActivo method, of class deduccionesempleadomensual.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        deduccionesempleadomensual instance = deducciones;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class deduccionesempleadomensual.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        deduccionesempleadomensual instance = deducciones;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
}

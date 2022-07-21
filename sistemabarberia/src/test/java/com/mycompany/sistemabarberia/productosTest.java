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
public class productosTest {
    public productosTest() {
    }
    
    private productos produ = new productos(1,"shampoo",5,3,10,true);
    
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
     * Test of getIdproducto method, of class productos.
     */
    @org.junit.Test
    public void testGetIdproducto() {
        System.out.println("getIdproducto");
        productos instance = produ;
        int expResult = 1;
        int result = instance.getIdproducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdproducto method, of class productos.
     */
    @org.junit.Test
    public void testSetIdproducto() {
        System.out.println("setIdproducto");
        int idproducto = 1;
        productos instance =  produ;
        try{
            instance.setIdproducto(idproducto);
        }catch(Exception Ex){
             fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.  
    }

    /**
     * Test of getNomProducto method, of class productos.
     */
    @org.junit.Test
    public void testGetNomProducto() {
        System.out.println("getNomProducto");
        productos instance = produ;
        String expResult = "shampoo";
        String result = instance.getNomProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNomProducto method, of class productos.
     */
    @org.junit.Test
    public void testSetNomProducto() {
        System.out.println("setNomProducto");
        String NomProducto = "shampoo";
        productos instance = produ;
        try{
          instance.setNomProducto(NomProducto);  
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStockActual method, of class productos.
     */
    @org.junit.Test
    public void testGetStockActual() {
        System.out.println("getStockActual");
        productos instance = produ;
        int expResult = 5;
        int result = instance.getStockActual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setStockActual method, of class productos.
     */
    @org.junit.Test
    public void testSetStockActual() {
        System.out.println("setStockActual");
        int StockActual = 5;
        productos instance = produ;
        try{
            instance.setStockActual(StockActual);
        }catch(Exception Ex){
             fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStockMinimo method, of class productos.
     */
    @org.junit.Test
    public void testGetStockMinimo() {
        System.out.println("getStockMinimo");
        productos instance = produ;
        int expResult = 3;
        int result = instance.getStockMinimo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setStockMinimo method, of class productos.
     */
    @org.junit.Test
    public void testSetStockMinimo() {
        System.out.println("setStockMinimo");
        int StockMinimo = 3;
        productos instance = produ;
        try{
           instance.setStockMinimo(StockMinimo); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStockMaximo method, of class productos.
     */
    @org.junit.Test
    public void testGetStockMaximo() {
        System.out.println("getStockMaximo");
        productos instance = produ;
        int expResult = 10;
        int result = instance.getStockMaximo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setStockMaximo method, of class productos.
     */
    @org.junit.Test
    public void testSetStockMaximo() {
        System.out.println("setStockMaximo");
        int StockMaximo = 10;
        productos instance = produ;
        try{
           instance.setStockMaximo(StockMaximo); 
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isActivo method, of class productos.
     */
    @org.junit.Test
    public void testIsActivo() {
        System.out.println("isActivo");
        productos instance = produ;
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class productos.
     */
    @org.junit.Test
    public void testSetActivo() {
        System.out.println("setActivo");
        boolean Activo = true;
        productos instance = produ;
        try{
            instance.setActivo(Activo);
        }catch(Exception Ex){
            fail("The test case is a prototype.");
        } 
        // TODO review the generated test code and remove the default call to fail.
    }

    
    
}

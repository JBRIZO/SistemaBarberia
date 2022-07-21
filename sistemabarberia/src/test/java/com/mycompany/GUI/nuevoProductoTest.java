/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.productos;
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
public class nuevoProductoTest {
    
    public nuevoProductoTest() {
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
     * Test of Reiniciar method, of class nuevoProducto.
     */
    @org.junit.Test
    public void testReiniciar() {
        System.out.println("Reiniciar");
        nuevoProducto instance = new nuevoProducto();
        instance.Reiniciar();
    }

    /**
     * Test of cargarDatosProducto method, of class nuevoProducto.
     */
    @org.junit.Test
    public void testCargarDatosProducto() {
        System.out.println("cargarDatosProducto");
        productos prod = new productos();
        prod.setActivo(true);
        prod.setIdproducto(0);
        prod.setNomProducto("Nombre");
        prod.setStockActual(0);
        prod.setStockMaximo(5);
        prod.setStockMinimo(2);
        nuevoProducto instance = new nuevoProducto(prod);
        try{
            instance.cargarDatosProducto();
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of main method, of class nuevoProducto.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        nuevoProducto.main(args);
    }
    
    @Test
    public void testValidarCamposEnBlanco(){
        System.out.println("validarCamposEnBlanco");
        nuevoProducto instance = new nuevoProducto();
        instance.nombreProducto.setText("Nombre");
        instance.precioInicial.setText("100.00");
        instance.stockInicial.setText("1");
        instance.stockMaximo.setText("1");
        instance.stockMinimo.setText("1");
        boolean expResult = true;
        boolean result = instance.validarCamposEnBlanco();
        assertEquals(expResult,result);
   
    }
    
    @Test 
    public void testValidacionStock(){
        System.out.println("validacionStock");
        nuevoProducto instance = new nuevoProducto();
        instance.stockInicial.setText("1");
        instance.stockMinimo.setText("2");
        instance.stockMaximo.setText("3");
        boolean expResult = true;
        boolean result = instance.validacionStock();
        assertEquals(expResult,result);
    }
}

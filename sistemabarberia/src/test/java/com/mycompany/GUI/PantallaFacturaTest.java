/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.usuarios;
import java.time.LocalDate;
import java.util.Date;
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
public class PantallaFacturaTest {
    
    usuarios usuario = new usuarios(1,1,"jbrizo123","pass",Boolean.TRUE,2);
    UsuarioSingleton single = UsuarioSingleton.getUsuario(usuario);
    
    public PantallaFacturaTest() {
        single.setUsuario(usuario);
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

    
   @org.junit.Test
   public void testPuestoEmpleadoActual(){
       System.out.println("puestoEmpleadoActual");
         usuarios usuario = new usuarios();
        usuario.setActivo(Boolean.TRUE);
        usuario.setContrasena("pass");
        usuario.setIDEmpleado(1);
        usuario.setIdusuario(8);
        usuario.setIntentos(0);
        usuario.setNomCuenta("Cuenta");
        UsuarioSingleton usr = UsuarioSingleton.getUsuario(usuario);
        usr.setUsuario(usuario);
       PantallaFactura instance = new PantallaFactura();
       int expResult = 1;
       int result = instance.puestoEmpleadoActual(1);
       assertEquals(expResult,result);
   }

   
    /**
     * Test of round method, of class PantallaFactura.
     */
    @org.junit.Test
    public void testRound() {
        System.out.println("round");
        double value = 0.0;
        int places = 2;
        double expResult = 0.00;
        double result = PantallaFactura.round(value, places);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of cargarClientes method, of class PantallaFactura.
     */
    @Test
    public void testCargarClientes() {
        System.out.println("cargarClientes");
        PantallaFactura instance = new PantallaFactura();
        try{
            instance.cargarClientes();
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
        
    }

    /**
     * Test of cargarBarberos method, of class PantallaFactura.
     */
    @Test
    public void testCargarBarberos() {
        System.out.println("cargarBarberos");
        PantallaFactura instance = new PantallaFactura();
        instance.cargarBarberos();
    }

    /**
     * Test of cargarProductos method, of class PantallaFactura.
     */
    @Test
    public void testCargarProductos() {
        System.out.println("cargarProductos");
        PantallaFactura instance = new PantallaFactura();        
        try{
            instance.cargarProductos();
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of cargarProductosBusqueda method, of class PantallaFactura.
     */
    @Test
    public void testCargarProductosBusqueda() {
        System.out.println("cargarProductosBusqueda");
        String buscar = "cera";
        PantallaFactura instance = new PantallaFactura();
        try{
        instance.cargarProductosBusqueda(buscar);
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of cargarServicios method, of class PantallaFactura.
     */
    @Test
    public void testCargarServicios() {
        System.out.println("cargarServicios");
        PantallaFactura instance = new PantallaFactura();
        instance.cargarServicios();
        
        try{instance.cargarServicios();}catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of cargarServiciosBusqueda method, of class PantallaFactura.
     */
    @Test
    public void testCargarServiciosBusqueda() {
        System.out.println("cargarServiciosBusqueda");
        String buscar = "Fade";
        PantallaFactura instance = new PantallaFactura();
        instance.cargarServiciosBusqueda(buscar);
        
        try{instance.cargarServiciosBusqueda(buscar);
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of main method, of class PantallaFactura.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PantallaFactura.main(args);
    }

    /**
     * Test of validarTarjetaCredito method, of class PantallaFactura.
     */
    @Test
    public void testValidarTarjetaCredito() {
        System.out.println("validarTarjetaCredito");
        String jText = "1234567891234567";
        PantallaFactura instance = new PantallaFactura();
        boolean expResult = false;
        boolean result = instance.validarTarjetaCredito(jText);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarMontoTarjeta method, of class PantallaFactura.
     */
    @Test
    public void testValidarMontoTarjeta() {
        System.out.println("validarMontoTarjeta");
        String jText = "-12";
        PantallaFactura instance = new PantallaFactura();
        boolean expResult = false;
        boolean result = instance.validarMontoTarjeta(jText);
        assertEquals(expResult, result);
    }

    
    
}

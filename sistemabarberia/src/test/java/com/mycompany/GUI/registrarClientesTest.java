/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.clientes;
import com.mycompany.sistemabarberia.clientesTest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
public class registrarClientesTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha;
    
    public registrarClientesTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
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
     * Test of Reiniciar method, of class registrarClientes.
     */
    @org.junit.Test
    public void testReiniciar() {
        System.out.println("Reiniciar");
        registrarClientes instance = new registrarClientes();
        instance.Reiniciar();
    }

    /**
     * Test of cargarDatosModificarCliente method, of class registrarClientes.
     */
    @org.junit.Test
    public void testCargarDatosModificarCliente() {
        System.out.println("cargarDatosModificarCliente");
        clientes cliente = new clientes();
        cliente.setActivo(true);
        cliente.setApeCliente("apellido");
        cliente.setFechaNacimiento(new java.sql.Date(fecha.getTime()));
        cliente.setIDServicio(1);
        cliente.setIDTipoDocumento(0);
        cliente.setIdcliente(1);
        cliente.setNomCliente("Nombre");
        cliente.setNumDocumento("123345");
        cliente.setNumTelefono("334567");
        registrarClientes instance = new registrarClientes(cliente);
        
        try{instance.cargarDatosModificarCliente();}catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of main method, of class registrarClientes.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        registrarClientes.main(args);
    }
    
    @Test
    public void testValidarCamposEnBlanco(){
        System.out.println("validarCamposEnBlanco");
        registrarClientes instance = new registrarClientes();
        instance.apellidosCliente.setText("Apellido");
        instance.fechaNacimiento.setText("fecha");
        instance.nombreCliente.setText("Nombre");
        instance.numDoc.setText("081203812");
        instance.telefonoCliente.setText("3234455");
        boolean expResult = true;
        boolean result = instance.validarCamposEnBlanco();
        assertEquals(expResult,result);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.clientesTest;
import com.mycompany.sistemabarberia.empleado;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Jonathan Laux
 */
public class AgregarEmpleadoTest {
    
    Date fecha;  
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
    
    public AgregarEmpleadoTest() {
        try { 
            fecha = sdf.parse("2021-10-12");
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
     * Test of Reiniciar method, of class AgregarEmpleado.
     */
    @org.junit.Test
    public void testReiniciar() {
        System.out.println("Reiniciar");
        AgregarEmpleado instance = new AgregarEmpleado();
        instance.Reiniciar();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cargarDatosModificarEmpleado method, of class AgregarEmpleado.
     */
    @org.junit.Test
    public void testCargarDatosModificarEmpleado() {
        System.out.println("cargarDatosModificarEmpleado");
        empleado empleado = new empleado();
        System.out.println(fecha);
        empleado.setIdempleado(0);
        empleado.setNomEmpleado("nombre");
        empleado.setApeEmpleado("apellido");
        empleado.setActivo(true);
        empleado.setDireccion("direccion");
        empleado.setFechaInicio(new java.sql.Date(fecha.getTime()));
        empleado.setFechaNacimiento(new java.sql.Date(fecha.getTime()));
        empleado.setGenEmpleado('M');
        empleado.setFechaFinal(new java.sql.Date(fecha.getTime()));
        empleado.setIDTipoDocumento(1);
        empleado.setNumCelular("32042675");
        
        AgregarEmpleado instance = new AgregarEmpleado(empleado);
        try{
        instance.cargarDatosModificarEmpleado();
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }
     /**
     * Test of validarCamposNumero method, of class AgregarEmpleado.
//     */
//    @Test
//    public void testValidarCamposNumero() {
//        System.out.println("validarCamposNumero");
//        AgregarEmpleado instance = new AgregarEmpleado();
//        instance.telefonoEmpleado.setText("32041675");
//        boolean expResult = true;
//        boolean result = instance.validarCamposNumero(instance.telefonoEmpleado);
//        assertEquals(expResult, result);
//    }
    

    /**
     * Test of main method, of class AgregarEmpleado.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AgregarEmpleado.main(args);
        // TODO review the generated test cod
    }

    /**
     * Test of validarNombre method, of class AgregarEmpleado.
     */
    @Test
    public void testValidarNombre() {
        System.out.println("validarNombre");
        AgregarEmpleado instance = new AgregarEmpleado();
        instance.nombreEmpleado.setText("Jooooonathan");
        boolean expResult = false;
        boolean result = instance.validarNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of validarApellido method, of class AgregarEmpleado.
     */
    @Test
    public void testValidarApellido() {
        System.out.println("validarApellido");
        AgregarEmpleado instance = new AgregarEmpleado();
        instance.apellidosEmpleado.setText("Laaaaaux");
        boolean expResult = false;
        boolean result = instance.validarApellido();
        assertEquals(expResult, result);
    }

   
    /**
     * Test of validarDecimal method, of class AgregarEmpleado.
     */
    @Test
    public void testValidarDecimal() {
        System.out.println("validarDecimal");
        AgregarEmpleado instance = new AgregarEmpleado();
        instance.salarioInicial.setText("12000.00");
        boolean expResult = true;
        boolean result = instance.validarDecimal();
        assertEquals(expResult, result);
    }

   
    
    @Test
    public void testValidarCamposEnBlanco(){
        System.out.println("camposEnBlanco");
        AgregarEmpleado instance = new AgregarEmpleado();
        instance.apellidosEmpleado.setText("Apellido");
        instance.direccion.setText("Direccion de la casa");
        instance.fechaInicio.setText("12/12/2021");
        instance.fechaNacimiento.setText("12/12/2021");
        instance.nombreEmpleado.setText("Nombre");
        instance.numDoc.setText("080120012075");
        instance.salarioInicial.setText("12000.00");
        instance.telefonoEmpleado.setText("23456745");
        boolean expResult = true;
        boolean result = instance.validarCamposEnBlanco();
        assertEquals(expResult,result);
    }

    
    
}

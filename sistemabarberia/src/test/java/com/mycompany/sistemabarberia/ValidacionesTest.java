/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import com.mycompany.GUI.AgregarEmpleadoTest;
import java.text.ParseException;
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
public class ValidacionesTest {
    
    public ValidacionesTest() {
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
     * Test of validacionIdentidad method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionIdentidad() {
        System.out.println("validacionIdentidad");
        String Identidad = "0801200020798";
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validacionIdentidad(Identidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validacionNombres method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionNombres() {
        System.out.println("validacionNombres");
        String Nombre = "Jonathan Joel";
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validacionNombres(Nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validacionEntero method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionEntero() {
        System.out.println("validacionEntero");
        String numero = "5";
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validacionEntero(numero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validacionDecimal method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionDecimal() {
        System.out.println("validacionDecimal");
        String numero = "12.00";
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validacionDecimal(numero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validacionPeriodo method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionPeriodo() {
        System.out.println("validacionPeriodo");
        String cadena = "202110";
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validacionPeriodo(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validacionFechaValida method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionFechaValida() {
        System.out.println("validacionFechaValida");
        String cadena = "40/10/2021";
        Validaciones instance = new Validaciones();
        boolean expResult = false;
        boolean result = instance.validacionFechaValida(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validacionFormatoFecha method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionFormatoFecha() {
        System.out.println("validacionFormatoFecha");
        String cadena = "00/00/0000";
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validacionFormatoFecha(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validacionLetrasRepetidas method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionLetrasRepetidas() {
        System.out.println("validacionLetrasRepetidas");
        String cadena = "aaaaaaa";
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validacionLetrasRepetidas(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validacionMayusculaInicial method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionMayusculaInicial() {
        System.out.println("validacionMayusculaInicial");
        String cadena = "Test";
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validacionMayusculaInicial(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validacionCampoNumerico method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionCampoNumerico() {
        System.out.println("validacionCampoNumerico");
        String cadena = "1234";
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validacionCampoNumerico(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validacionNumEntero method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionNumEntero() {
        System.out.println("validacionNumEntero");
        String cadena = "12.34";
        Validaciones instance = new Validaciones();
        boolean expResult = false;
        boolean result = instance.validacionNumEntero(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

  

    /**
     * Test of validacionCadenaPalabras method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionCadenaPalabras() {
        System.out.println("validacionCadenaPalabras");
        String cadena = "Holaaaaaa que tal";
        Validaciones instance = new Validaciones();
        boolean expResult = false;
        boolean result = instance.validacionCadenaPalabras(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validacionCantidadMinima method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionCantidadMinima() {
        System.out.println("validacionCantidadMinima");
        String palabra = "we";
        int cantidadMinima = 3;
        Validaciones instance = new Validaciones();
        boolean expResult = false;
        boolean result = instance.validacionCantidadMinima(palabra, cantidadMinima);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validarNumCelular method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidarNumCelular() {
        System.out.println("validarNumCelular");
        String cadena = "12345678";
        Validaciones instance = new Validaciones();
        boolean expResult = false;
        boolean result = instance.validarNumCelular(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validarNomCuenta method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidarNomCuenta() {
        System.out.println("validarNomCuenta");
        String cadena = "jbrizo123";
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarNomCuenta(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validarContrasena method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidarContrasena() {
        System.out.println("validarContrasena");
        String cadena = "VarY@n26";
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarContrasena(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validarNoTarjeta method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidarNoTarjeta() {
        System.out.println("validarNoTarjeta");
        String tarjeta = "99999999999999999";
        Validaciones instance = new Validaciones();
        boolean expResult = false;
        boolean result = instance.validarNoTarjeta(tarjeta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of validarPasaporte method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidarPasaporte() {
        System.out.println("validarPasaporte");
        String cadena = "ZAB000254";
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarPasaporte(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of validacionAbcd method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionAbcd() {
        System.out.println("validacionAbcd");
        String palabra = "Abcde";
        boolean expResult = true;
        boolean result = Validaciones.validacionAbcd(palabra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of validacionConsonantesSeguidas method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionConsonantesSeguidas() {
        System.out.println("validacionConsonantesSeguidas");
        String palabra = "fgdhbc";
        boolean expResult = true;
        boolean result = Validaciones.validacionConsonantesSeguidas(palabra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of validacionVocalesSeguidas method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidacionVocalesSeguidas() {
        System.out.println("validacionVocalesSeguidas");
        String palabra = "eoaui";
        boolean expResult = true;
        boolean result = Validaciones.validacionVocalesSeguidas(palabra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of validarRepeticionCadena method, of class Validaciones.
     */
    @org.junit.Test
    public void testValidarRepeticionCadena() {
        System.out.println("validarRepeticionCadena");
        String cadena = "Andreeees Lopez";
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarRepeticionCadena(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call t//o fail.
      //  fail("The test case is a prototype.");
    }
    
    /**
     * Test of convertToLocalDateViaInstant method, of class AgregarEmpleado.
     */
    @org.junit.Test
    public void testConvertToLocalDateViaInstant() {
        System.out.println("convertToLocalDateViaInstant");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dateToConvert;
        Validaciones instance = new Validaciones();
        try {
            dateToConvert = sdf.parse("10/10/2021");
            LocalDate result = instance.convertToLocalDateViaInstant(dateToConvert);
            LocalDate expResult = LocalDate.of(2021, 10, 10);
            assertEquals(expResult.toString(), result.toString());
        } catch (ParseException ex) {
            Logger.getLogger(AgregarEmpleadoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO review the generated test code and remove the default call t//o fail.
        ////fail("The test case is a prototype.");
    }
    
}

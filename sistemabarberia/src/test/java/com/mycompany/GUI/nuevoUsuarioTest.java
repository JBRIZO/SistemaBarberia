/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.usuarios;
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
public class nuevoUsuarioTest {
    
    public nuevoUsuarioTest() {
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
     * Test of cargarDatosUsuarioModif method, of class nuevoUsuario.
     */
    @org.junit.Test
    public void testCargarDatosUsuarioModif() {
        System.out.println("cargarDatosUsuarioModif");
        usuarios usuario = new usuarios();
        usuario.setActivo(Boolean.TRUE);
        usuario.setContrasena("pass");
        usuario.setIDEmpleado(1);
        usuario.setIntentos(0);
        usuario.setNomCuenta("cuenta");
        nuevoUsuario instance = new nuevoUsuario(usuario);
        try{
        instance.cargarDatosUsuarioModif();
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of Reiniciar method, of class nuevoUsuario.
     */
    @org.junit.Test
    public void testReiniciar() {
        System.out.println("Reiniciar");
        nuevoUsuario instance = new nuevoUsuario();
        instance.Reiniciar();
    }

    /**
     * Test of main method, of class nuevoUsuario.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        nuevoUsuario.main(args);
    }
    
}

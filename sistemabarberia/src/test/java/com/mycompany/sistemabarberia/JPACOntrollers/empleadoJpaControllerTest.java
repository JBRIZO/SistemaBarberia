/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.clientesTest;
import com.mycompany.sistemabarberia.empleado;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class empleadoJpaControllerTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha;
    
    public empleadoJpaControllerTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
        } catch (Exception ex) {
            Logger.getLogger(clientesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private empleadoJpaController empleadoDAO =  new empleadoJpaController(emf);
    
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
        empleadoDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class empleadoJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        empleadoJpaController instance = new empleadoJpaController(emf);
        try{
            instance.getEntityManager();
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

   

    /**
     * Test of create method, of class empleadoJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        empleado empleado = new empleado();
        empleado.setActivo(true);
        empleado.setApeEmpleado("apellido");
        empleado.setDireccion("Direccion");
        empleado.setFechaFinal(null);
        empleado.setFechaInicio(new java.sql.Date(fecha.getTime()));
        empleado.setFechaNacimiento(new java.sql.Date(fecha.getTime()));
        empleado.setGenEmpleado('M');
        empleado.setIDTipoDocumento(1);
        empleado.setNomEmpleado("Nombre");
        empleado.setNumCelular("12345678");
        empleado.setNumDoc("123456789012");
        empleadoJpaController instance = new empleadoJpaController(emf);
        try{instance.create(empleado);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
             fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class empleadoJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        empleado empleado = empleadoDAO.findempleado(empleadoDAO.findempleadoEntities().get(empleadoDAO.getempleadoCount()-1).getIdempleado());
        empleadoJpaController instance = new empleadoJpaController(emf);
        
        try{instance.edit(empleado);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findempleadoEntities method, of class empleadoJpaController.
     */
    @org.junit.Test
    public void testFindempleadoEntities_0args() {
        System.out.println("findempleadoEntities");
        empleadoJpaController instance = new empleadoJpaController(emf);
        try{instance.findempleadoEntities();
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findempleadoEntities method, of class empleadoJpaController.
     */
    @org.junit.Test
    public void testFindempleadoEntities_int_int() {
        System.out.println("findempleadoEntities");
        int maxResults = 2;
        int firstResult = 1;
        empleadoJpaController instance = new empleadoJpaController(emf);
        try{instance.findempleadoEntities(maxResults, firstResult);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findempleado method, of class empleadoJpaController.
     */
    @org.junit.Test
    public void testFindempleado() {
        System.out.println("findempleado");
        int id = empleadoDAO.findempleado(empleadoDAO.findempleadoEntities().get(empleadoDAO.getempleadoCount()-1).getIdempleado()).getIdempleado();
        empleadoJpaController instance = new empleadoJpaController(emf);
       try{instance.findempleado(id);
       instance.getEntityManager().close();
       }catch(Exception Ex){
           instance.getEntityManager().close();
           fail("Prueba fallida: " + Ex.getMessage());
       }
    }

    /**
     * Test of getempleadoCount method, of class empleadoJpaController.
     */
    @org.junit.Test
    public void testGetempleadoCount() {
        System.out.println("getempleadoCount");
        empleadoJpaController instance = new empleadoJpaController(emf);
        int expResult = empleadoDAO.getempleadoCount();
        int result = instance.getempleadoCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

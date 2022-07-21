/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.clientesTest;
import com.mycompany.sistemabarberia.puestohistoricoempleado;
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
public class puestohistoricoempleadoJpaControllerTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha;
    
    public puestohistoricoempleadoJpaControllerTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
        } catch (Exception ex) {
            Logger.getLogger(clientesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private puestohistoricoempleadoJpaController puestoDAO = new puestohistoricoempleadoJpaController(emf);
    
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
        puestoDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class puestohistoricoempleadoJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        puestohistoricoempleadoJpaController instance = new puestohistoricoempleadoJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

   

    /**
     * Test of create method, of class puestohistoricoempleadoJpaController.
     */
    @org.junit.Test
    public void testCreate() {
        System.out.println("create");
        puestohistoricoempleado puesto = new puestohistoricoempleado();
        puesto.setActivo(true);
        puesto.setFechaFinal(new java.sql.Date(fecha.getTime()));
        puesto.setFechaInicial(new java.sql.Date(fecha.getTime()));
        puesto.setIDEmpleado(1);
        puesto.setIDPuesto(1);
        puestohistoricoempleadoJpaController instance = new puestohistoricoempleadoJpaController(emf);
        try{instance.create(puesto);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class puestohistoricoempleadoJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        puestohistoricoempleado puestohistoricoempleado = puestoDAO.findpuestohistoricoempleadoEntities().get(puestoDAO.getpuestohistoricoempleadoCount()-1);
        puestohistoricoempleadoJpaController instance = new puestohistoricoempleadoJpaController(emf);
       try{
           instance.edit(puestohistoricoempleado);
           instance.getEntityManager().close();
       }catch(Exception Ex){
           instance.getEntityManager().close();
           fail("Prueba Fallida: " + Ex.getMessage());
       }
    }

  
    /**
     * Test of findpuestohistoricoempleadoEntities method, of class puestohistoricoempleadoJpaController.
     */
    @org.junit.Test
    public void testFindpuestohistoricoempleadoEntities_0args() {
        System.out.println("findpuestohistoricoempleadoEntities");
        puestohistoricoempleadoJpaController instance = new puestohistoricoempleadoJpaController(emf);
        try{
            instance.findpuestohistoricoempleadoEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findpuestohistoricoempleadoEntities method, of class puestohistoricoempleadoJpaController.
     */
    @org.junit.Test
    public void testFindpuestohistoricoempleadoEntities_int_int() {
        System.out.println("findpuestohistoricoempleadoEntities");
        int maxResults = 2;
        int firstResult = 1;
        puestohistoricoempleadoJpaController instance = new puestohistoricoempleadoJpaController(emf);
        try{
            instance.findpuestohistoricoempleadoEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findpuestohistoricoempleado method, of class puestohistoricoempleadoJpaController.
     */
    @org.junit.Test
    public void testFindpuestohistoricoempleado() {
        System.out.println("findpuestohistoricoempleado");
        int id = puestoDAO.findpuestohistoricoempleadoEntities().get(puestoDAO.getpuestohistoricoempleadoCount()-1).getNumpuesto();
        puestohistoricoempleadoJpaController instance = new puestohistoricoempleadoJpaController(emf);
        try{
            instance.findpuestohistoricoempleado(id);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getpuestohistoricoempleadoCount method, of class puestohistoricoempleadoJpaController.
     */
    @org.junit.Test
    public void testGetpuestohistoricoempleadoCount() {
        System.out.println("getpuestohistoricoempleadoCount");
        puestohistoricoempleadoJpaController instance = new puestohistoricoempleadoJpaController(emf);
        int expResult = puestoDAO.getpuestohistoricoempleadoCount();
        int result = instance.getpuestohistoricoempleadoCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

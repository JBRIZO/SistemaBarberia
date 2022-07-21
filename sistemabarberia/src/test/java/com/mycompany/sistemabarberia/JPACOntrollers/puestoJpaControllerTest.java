/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.puesto;
import java.util.List;
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
public class puestoJpaControllerTest {
    
    public puestoJpaControllerTest() {
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private puestoJpaController puestoDAO = new puestoJpaController(emf);
    
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
     * Test of getEntityManager method, of class puestoJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        puestoJpaController instance = new puestoJpaController(emf);
        try{instance.getEntityManager();
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of create method, of class puestoJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        puesto puesto = new puesto();
        puesto.setActivo(true);
        puesto.setNomPuesto("puesto");
        puestoJpaController instance = new puestoJpaController(emf);
        try{
            instance.create(puesto);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class puestoJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        puesto puesto = puestoDAO.findpuestoEntities().get(puestoDAO.getpuestoCount() - 1);
        puestoJpaController instance = new puestoJpaController(emf);
        try{
            instance.edit(puesto);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

   
    /**
     * Test of findpuestoEntities method, of class puestoJpaController.
     */
    @org.junit.Test
    public void testFindpuestoEntities_0args() {
        System.out.println("findpuestoEntities");
        puestoJpaController instance = new puestoJpaController(emf);
        try{
            instance.findpuestoEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findpuestoEntities method, of class puestoJpaController.
     */
    @org.junit.Test
    public void testFindpuestoEntities_int_int() {
        System.out.println("findpuestoEntities");
        int maxResults = 2;
        int firstResult = 1;
        puestoJpaController instance = new puestoJpaController(emf);
        try{
            instance.findpuestoEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findpuesto method, of class puestoJpaController.
     */
    @org.junit.Test
    public void testFindpuesto() {
        System.out.println("findpuesto");
        int id = puestoDAO.findpuestoEntities().get(puestoDAO.getpuestoCount()-1).getIdpuesto();
        puestoJpaController instance = new puestoJpaController(emf);
        try{
            instance.findpuesto(id);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getpuestoCount method, of class puestoJpaController.
     */
    @org.junit.Test
    public void testGetpuestoCount() {
        System.out.println("getpuestoCount");
        puestoJpaController instance = new puestoJpaController(emf);
        int expResult = puestoDAO.getpuestoCount();
        int result = instance.getpuestoCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

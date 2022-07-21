/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.tiposbono;
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
public class tiposbonoJpaControllerTest {
    
    public tiposbonoJpaControllerTest() {
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private tiposbonoJpaController bonoDAO = new tiposbonoJpaController(emf);
    
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
        bonoDAO.getEntityManager().close();
        emf.close();
    }

    

    /**
     * Test of getEntityManager method, of class tiposbonoJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        tiposbonoJpaController instance = new tiposbonoJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of create method, of class tiposbonoJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        tiposbono tiposbono = new tiposbono();
        tiposbono.setActivo(true);
        tiposbono.setNomBono("Nombre");
        tiposbonoJpaController instance = new tiposbonoJpaController(emf);
        try{
            instance.create(tiposbono);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class tiposbonoJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        tiposbono tiposbono = bonoDAO.findtiposbonoEntities().get(bonoDAO.gettiposbonoCount()-1);
        tiposbonoJpaController instance = new tiposbonoJpaController(emf);
        try{
            instance.edit(tiposbono);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

  
    /**
     * Test of findtiposbonoEntities method, of class tiposbonoJpaController.
     */
    @org.junit.Test
    public void testFindtiposbonoEntities_0args() {
        System.out.println("findtiposbonoEntities");
        tiposbonoJpaController instance = new tiposbonoJpaController(emf);
        try{
            instance.findtiposbonoEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findtiposbonoEntities method, of class tiposbonoJpaController.
     */
    @org.junit.Test
    public void testFindtiposbonoEntities_int_int() {
        System.out.println("findtiposbonoEntities");
        int maxResults = 2;
        int firstResult = 1;
        tiposbonoJpaController instance = new tiposbonoJpaController(emf);
        try{
            instance.findtiposbonoEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findtiposbono method, of class tiposbonoJpaController.
     */
    @org.junit.Test
    public void testFindtiposbono() {
        System.out.println("findtiposbono");
        int id = bonoDAO.findtiposbonoEntities().get(bonoDAO.gettiposbonoCount()-1).getIdtipobono();
        tiposbonoJpaController instance = new tiposbonoJpaController(emf);
        try{
            instance.findtiposbono(id);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of gettiposbonoCount method, of class tiposbonoJpaController.
     */
    @org.junit.Test
    public void testGettiposbonoCount() {
        System.out.println("gettiposbonoCount");
        tiposbonoJpaController instance = new tiposbonoJpaController(emf);
        int expResult = bonoDAO.gettiposbonoCount();
        int result = instance.gettiposbonoCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

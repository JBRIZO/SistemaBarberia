/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.bonosempleadomensual;
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
public class bonosempleadomensualJpaControllerTest {
    
    public bonosempleadomensualJpaControllerTest() {
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private bonosempleadomensualJpaController bonosDAO = new bonosempleadomensualJpaController(emf);
    
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
        bonosDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class bonosempleadomensualJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        bonosempleadomensualJpaController instance = new bonosempleadomensualJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            fail("Prueba fallida" + Ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of create method, of class bonosempleadomensualJpaController.
     */
    @org.junit.Test
    public void testCreate() {
        System.out.println("create");
        bonosempleadomensual bonosempleadomensual = new bonosempleadomensual();
        bonosempleadomensual.setActivo(true);
        bonosempleadomensual.setIDTipoBono(1);
        bonosempleadomensual.setIdEmpleado(1);
        bonosempleadomensual.setPeriodo("202110");
        bonosempleadomensual.setValor(1200.00);
        bonosempleadomensualJpaController instance = new bonosempleadomensualJpaController(emf);  
        try{
            instance.create(bonosempleadomensual);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of edit method, of class bonosempleadomensualJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        bonosempleadomensual bonosempleadomensual = bonosDAO.findbonosempleadomensual(bonosDAO.findbonosempleadomensualEntities().get(bonosDAO.findbonosempleadomensualEntities().size()-1).getNumbono());
        bonosempleadomensualJpaController instance = new bonosempleadomensualJpaController(emf);
        try{
            instance.edit(bonosempleadomensual);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            fail("Prueba fallida" + Ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of findbonosempleadomensualEntities method, of class bonosempleadomensualJpaController.
     */
    @org.junit.Test
    public void testFindbonosempleadomensualEntities_0args() {
        System.out.println("findbonosempleadomensualEntities");
        bonosempleadomensualJpaController instance = new bonosempleadomensualJpaController(emf); 
        try{
            instance.findbonosempleadomensualEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex)
        {
            fail("Prueba fallida " + Ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of findbonosempleadomensualEntities method, of class bonosempleadomensualJpaController.
     */
    @org.junit.Test
    public void testFindbonosempleadomensualEntities_int_int() {
        System.out.println("findbonosempleadomensualEntities");
        int maxResults = 2;
        int firstResult = 1;
        bonosempleadomensualJpaController instance = new bonosempleadomensualJpaController(emf);
        try{
            instance.findbonosempleadomensualEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            fail("Prueba fallida " + Ex.getMessage());
        }
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findbonosempleadomensual method, of class bonosempleadomensualJpaController.
     */
    @org.junit.Test
    public void testFindbonosempleadomensual() {
        System.out.println("findbonosempleadomensual");
        int id = bonosDAO.findbonosempleadomensual(bonosDAO.findbonosempleadomensualEntities().get(bonosDAO.findbonosempleadomensualEntities().size()-1).getNumbono()).getNumbono();
        bonosempleadomensualJpaController instance = new bonosempleadomensualJpaController(emf);
        try{
            instance.findbonosempleadomensual(id);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            fail("Prueba fallida "  + Ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getbonosempleadomensualCount method, of class bonosempleadomensualJpaController.
     */
    @org.junit.Test
    public void testGetbonosempleadomensualCount() {
        System.out.println("getbonosempleadomensualCount");
        bonosempleadomensualJpaController instance = new bonosempleadomensualJpaController(emf);
        int expResult = bonosDAO.getbonosempleadomensualCount();
        int result = instance.getbonosempleadomensualCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

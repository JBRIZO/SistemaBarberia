/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.planillas;
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
public class planillasJpaControllerTest {
    
    public planillasJpaControllerTest() {
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private planillasJpaController planillaDAO = new planillasJpaController(emf);
    
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
        planillaDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class planillasJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        planillasJpaController instance = new planillasJpaController(emf);
        
       try{instance.getEntityManager();
       instance.getEntityManager().close();
       }catch(Exception Ex){
           instance.getEntityManager().close();
           fail("Prueba Fallida: " + Ex.getMessage());
       }
    }

    /**
     * Test of create method, of class planillasJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        planillas planillas = new planillas();
        planillas.setActivo(true);
        planillas.setIDEmpleado(1);
        planillas.setPeriodo("202110");
        planillas.setTotalPagar(10000.00);
        planillasJpaController instance = new planillasJpaController(emf);
        
        try{
            instance.create(planillas);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
        fail("Prueba Fallida: " + Ex.getMessage());}
    }

    /**
     * Test of destroy method, of class planillasJpaController.
     */
    @org.junit.Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        int id = planillaDAO.findplanillas(planillaDAO.findplanillasEntities().get(planillaDAO.getplanillasCount()-1).getIdplanilla()).getIdplanilla();
        planillasJpaController instance = new planillasJpaController(emf);
        try{
            instance.destroy(id);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findplanillasEntities method, of class planillasJpaController.
     */
    @org.junit.Test
    public void testFindplanillasEntities_0args() {
        System.out.println("findplanillasEntities");
        planillasJpaController instance = new planillasJpaController(emf);
        try{instance.findplanillasEntities();
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findplanillasEntities method, of class planillasJpaController.
     */
    @org.junit.Test
    public void testFindplanillasEntities_int_int() {
        System.out.println("findplanillasEntities");
        int maxResults = 2;
        int firstResult = 1;
        planillasJpaController instance = new planillasJpaController(emf);
        try{
            instance.findplanillasEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findplanillas method, of class planillasJpaController.
     */
    @org.junit.Test
    public void testFindplanillas() {
        System.out.println("findplanillas");
        int id = planillaDAO.findplanillasEntities().get(planillaDAO.getplanillasCount()-1).getIdplanilla();
        planillasJpaController instance = new planillasJpaController(emf);
        try{instance.findplanillas(id);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getplanillasCount method, of class planillasJpaController.
     */
    @org.junit.Test
    public void testGetplanillasCount() {
        System.out.println("getplanillasCount");
        planillasJpaController instance = new planillasJpaController(emf);
        int expResult = planillaDAO.getplanillasCount();
        int result = instance.getplanillasCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

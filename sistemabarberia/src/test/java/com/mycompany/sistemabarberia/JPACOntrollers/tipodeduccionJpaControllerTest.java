/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.tipodeduccion;
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
public class tipodeduccionJpaControllerTest {
    
    public tipodeduccionJpaControllerTest() {
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private tipodeduccionJpaController tipoDAO = new tipodeduccionJpaController(emf);
    
    
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
        tipoDAO.getEntityManager().close();
        emf.close();
    }

  

    /**
     * Test of getEntityManager method, of class tipodeduccionJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        tipodeduccionJpaController instance = new tipodeduccionJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of create method, of class tipodeduccionJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        tipodeduccion tipodeduccion = new tipodeduccion();
        tipodeduccion.setActivo(true);
        tipodeduccion.setNombre("Nombre");
        tipodeduccionJpaController instance = new tipodeduccionJpaController(emf);
        
        try{
            instance.create(tipodeduccion);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class tipodeduccionJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        tipodeduccion tipodeduccion = tipoDAO.findtipodeduccionEntities().get(tipoDAO.gettipodeduccionCount()-1);
        tipodeduccionJpaController instance = new tipodeduccionJpaController(emf);
        try{
            instance.edit(tipodeduccion);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    
    /**
     * Test of findtipodeduccionEntities method, of class tipodeduccionJpaController.
     */
    @org.junit.Test
    public void testFindtipodeduccionEntities_0args() {
        System.out.println("findtipodeduccionEntities");
        tipodeduccionJpaController instance = new tipodeduccionJpaController(emf);
        try{
            instance.findtipodeduccionEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findtipodeduccionEntities method, of class tipodeduccionJpaController.
     */
    @org.junit.Test
    public void testFindtipodeduccionEntities_int_int() {
        System.out.println("findtipodeduccionEntities");
        int maxResults = 2;
        int firstResult = 1;
        tipodeduccionJpaController instance = new tipodeduccionJpaController(emf);
        try{
            instance.findtipodeduccionEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findtipodeduccion method, of class tipodeduccionJpaController.
     */
    @org.junit.Test
    public void testFindtipodeduccion() {
        System.out.println("findtipodeduccion");
        int id = tipoDAO.findtipodeduccionEntities().get(tipoDAO.gettipodeduccionCount()-1).getIdtipodeduccion();
        tipodeduccionJpaController instance = new tipodeduccionJpaController(emf);
        try{instance.findtipodeduccion(id);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of gettipodeduccionCount method, of class tipodeduccionJpaController.
     */
    @org.junit.Test
    public void testGettipodeduccionCount() {
        System.out.println("gettipodeduccionCount");
        tipodeduccionJpaController instance = new tipodeduccionJpaController(emf);
        int expResult = tipoDAO.gettipodeduccionCount();
        int result = instance.gettipodeduccionCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

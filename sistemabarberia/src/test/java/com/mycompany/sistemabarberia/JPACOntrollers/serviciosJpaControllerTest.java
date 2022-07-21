/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.servicios;
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
public class serviciosJpaControllerTest {
    
    
    
    public serviciosJpaControllerTest() {
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private serviciosJpaController serviciosDAO = new serviciosJpaController(emf);
    
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
        serviciosDAO.getEntityManager().close();
        emf.close();
    }

   
    

    /**
     * Test of getEntityManager method, of class serviciosJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        serviciosJpaController instance = new serviciosJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of create method, of class serviciosJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        servicios servicios = new servicios();
        servicios.setActivo(true);
        servicios.setNomServicio("Nombre");
        serviciosJpaController instance = new serviciosJpaController(emf);
        
        try{
            instance.create(servicios);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class serviciosJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        servicios servicios = serviciosDAO.findserviciosEntities().get(serviciosDAO.getserviciosCount()-1);
        serviciosJpaController instance = new serviciosJpaController(emf);
        
        try{
            instance.edit(servicios);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    

    /**
     * Test of findserviciosEntities method, of class serviciosJpaController.
     */
    @org.junit.Test
    public void testFindserviciosEntities_0args() {
        System.out.println("findserviciosEntities");
        serviciosJpaController instance = new serviciosJpaController(emf);
        try{
            instance.findserviciosEntities();
            instance.getEntityManager().close();instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findserviciosEntities method, of class serviciosJpaController.
     */
    @org.junit.Test
    public void testFindserviciosEntities_int_int() {
        System.out.println("findserviciosEntities");
        int maxResults = 2;
        int firstResult = 1;
        serviciosJpaController instance = new serviciosJpaController(emf);
        
        try{
            instance.findserviciosEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findservicios method, of class serviciosJpaController.
     */
    @org.junit.Test
    public void testFindservicios() {
        System.out.println("findservicios");
        int id = serviciosDAO.findserviciosEntities().get(serviciosDAO.getserviciosCount()-1).getIdservicio();
        serviciosJpaController instance = new serviciosJpaController(emf);
        try{
            instance.findservicios(id);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getserviciosCount method, of class serviciosJpaController.
     */
    @org.junit.Test
    public void testGetserviciosCount() {
        System.out.println("getserviciosCount");
        serviciosJpaController instance = new serviciosJpaController(emf);
        int expResult = serviciosDAO.getserviciosCount();
        int result = instance.getserviciosCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

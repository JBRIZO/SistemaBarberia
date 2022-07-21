/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.estadofactura;
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
public class estadofacturaJpaControllerTest {
    
    public estadofacturaJpaControllerTest() {
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private estadofacturaJpaController estadoDAO = new estadofacturaJpaController(emf);
    
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
        estadoDAO.getEntityManager().close();
        emf.close();
    }

   

    /**
     * Test of getEntityManager method, of class estadofacturaJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        estadofacturaJpaController instance = new estadofacturaJpaController(emf);
        
        try{instance.getEntityManager();
                    instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of create method, of class estadofacturaJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        estadofactura estadofactura = new estadofactura();
        estadofactura.setActivo(true);
        estadofactura.setNombreEstado("prueba");
        
        estadofacturaJpaController instance = new estadofacturaJpaController(emf);
        try{instance.create(estadofactura);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class estadofacturaJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        estadofactura estadofactura = estadoDAO.findestadofactura(estadoDAO.findestadofacturaEntities().get(estadoDAO.getestadofacturaCount()-1).getIdestado());
        estadofacturaJpaController instance = new estadofacturaJpaController(emf);
        try{instance.edit(estadofactura);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

   

    /**
     * Test of findestadofacturaEntities method, of class estadofacturaJpaController.
     */
    @org.junit.Test
    public void testFindestadofacturaEntities_0args() {
        System.out.println("findestadofacturaEntities");
        estadofacturaJpaController instance = new estadofacturaJpaController(emf);
        
        try{instance.findestadofacturaEntities();
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
        fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findestadofacturaEntities method, of class estadofacturaJpaController.
     */
    @org.junit.Test
    public void testFindestadofacturaEntities_int_int() {
        System.out.println("findestadofacturaEntities");
        int maxResults = 2;
        int firstResult = 1;
        estadofacturaJpaController instance = new estadofacturaJpaController(emf);
        try{instance.findestadofacturaEntities(maxResults, firstResult);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findestadofactura method, of class estadofacturaJpaController.
     */
    @org.junit.Test
    public void testFindestadofactura() {
        System.out.println("findestadofactura");
        int id = estadoDAO.findestadofactura(estadoDAO.findestadofacturaEntities().get(estadoDAO.getestadofacturaCount()-1).getIdestado()).getIdestado();
        estadofacturaJpaController instance = new estadofacturaJpaController(emf);
        try{instance.findestadofactura(id);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getestadofacturaCount method, of class estadofacturaJpaController.
     */
    @org.junit.Test
    public void testGetestadofacturaCount() {
        System.out.println("getestadofacturaCount");
        estadofacturaJpaController instance = new estadofacturaJpaController(emf);
        int expResult = estadoDAO.getestadofacturaCount();
        int result = instance.getestadofacturaCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

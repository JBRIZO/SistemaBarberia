/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.tipopago;
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
public class tipopagoJpaControllerTest {
    
    public tipopagoJpaControllerTest() {
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private tipopagoJpaController tipoDAO = new tipopagoJpaController(emf);
    
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
     * Test of getEntityManager method, of class tipopagoJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        tipopagoJpaController instance = new tipopagoJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of create method, of class tipopagoJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        tipopago tipopago = new tipopago();
        tipopago.setActivo(Boolean.TRUE);
        tipopago.setTipoPago("Tipo");
        tipopagoJpaController instance = new tipopagoJpaController(emf);
        
        try{instance.create(tipopago);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class tipopagoJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        tipopago tipopago = tipoDAO.findtipopagoEntities().get(tipoDAO.gettipopagoCount()-1);
        tipopagoJpaController instance = new tipopagoJpaController(emf);
        try{instance.edit(tipopago);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findtipopagoEntities method, of class tipopagoJpaController.
     */
    @org.junit.Test
    public void testFindtipopagoEntities_0args() {
        System.out.println("findtipopagoEntities");
        tipopagoJpaController instance = new tipopagoJpaController(emf);
        try{
            instance.findtipopagoEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
        fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findtipopagoEntities method, of class tipopagoJpaController.
     */
    @org.junit.Test
    public void testFindtipopagoEntities_int_int() {
        System.out.println("findtipopagoEntities");
        int maxResults = 2;
        int firstResult = 1;
        tipopagoJpaController instance = new tipopagoJpaController(emf);
        try{
            instance.findtipopagoEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findtipopago method, of class tipopagoJpaController.
     */
    @org.junit.Test
    public void testFindtipopago() {
        System.out.println("findtipopago");
        int id = tipoDAO.findtipopagoEntities().get(tipoDAO.gettipopagoCount()-1).getIdtipopago();
        tipopagoJpaController instance = new tipopagoJpaController(emf);
        try{
            instance.findtipopago(id);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of gettipopagoCount method, of class tipopagoJpaController.
     */
    @org.junit.Test
    public void testGettipopagoCount() {
        System.out.println("gettipopagoCount");
        tipopagoJpaController instance = new tipopagoJpaController(emf);
        int expResult = tipoDAO.gettipopagoCount();
        int result = instance.gettipopagoCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

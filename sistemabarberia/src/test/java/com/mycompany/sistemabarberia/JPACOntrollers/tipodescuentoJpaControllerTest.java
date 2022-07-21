/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.tipodescuento;
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
public class tipodescuentoJpaControllerTest {
    
    public tipodescuentoJpaControllerTest() {
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private tipodescuentoJpaController tipoDAO = new tipodescuentoJpaController(emf);
    
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
     * Test of getEntityManager method, of class tipodescuentoJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        tipodescuentoJpaController instance = new tipodescuentoJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of create method, of class tipodescuentoJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        tipodescuento tipodescuento = new tipodescuento();
        tipodescuento.setActivo(true);
        tipodescuento.setNomDescuento("Nombre");
        tipodescuentoJpaController instance = new tipodescuentoJpaController(emf);
        
        try{
            instance.create(tipodescuento);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class tipodescuentoJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        tipodescuento tipodescuento = tipoDAO.findtipodescuentoEntities().get(tipoDAO.gettipodescuentoCount()-1);
        tipodescuentoJpaController instance = new tipodescuentoJpaController(emf);
        try{
            instance.edit(tipodescuento);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findtipodescuentoEntities method, of class tipodescuentoJpaController.
     */
    @org.junit.Test
    public void testFindtipodescuentoEntities_0args() {
        System.out.println("findtipodescuentoEntities");
        tipodescuentoJpaController instance = new tipodescuentoJpaController(emf);
        try{
            instance.findtipodescuentoEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findtipodescuentoEntities method, of class tipodescuentoJpaController.
     */
    @org.junit.Test
    public void testFindtipodescuentoEntities_int_int() {
        System.out.println("findtipodescuentoEntities");
        int maxResults = 2;
        int firstResult = 1;
        tipodescuentoJpaController instance = new tipodescuentoJpaController(emf);
        try{instance.findtipodescuentoEntities(maxResults, firstResult);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findtipodescuento method, of class tipodescuentoJpaController.
     */
    @org.junit.Test
    public void testFindtipodescuento() {
        System.out.println("findtipodescuento");
        int id = tipoDAO.findtipodescuentoEntities().get(tipoDAO.gettipodescuentoCount()-1).getIdtipodescuento();
        tipodescuentoJpaController instance = new tipodescuentoJpaController(emf);
        try{
            instance.findtipodescuento(id);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of gettipodescuentoCount method, of class tipodescuentoJpaController.
     */
    @org.junit.Test
    public void testGettipodescuentoCount() {
        System.out.println("gettipodescuentoCount");
        tipodescuentoJpaController instance = new tipodescuentoJpaController(emf);
        int expResult = tipoDAO.gettipodescuentoCount();
        int result = instance.gettipodescuentoCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

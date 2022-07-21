/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.deduccionesempleadomensual;
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
public class deduccionesempleadomensualJpaControllerTest {
    
    public deduccionesempleadomensualJpaControllerTest() {
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private deduccionesempleadomensualJpaController deduccionesDAO = new deduccionesempleadomensualJpaController(emf);
    
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
        deduccionesDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class deduccionesempleadomensualJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        deduccionesempleadomensualJpaController instance = new deduccionesempleadomensualJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    

    /**
     * Test of create method, of class deduccionesempleadomensualJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        deduccionesempleadomensual deduccionesempleadomensual = new deduccionesempleadomensual();
        deduccionesempleadomensual.setActivo(true);
        deduccionesempleadomensual.setIDEmpleado(1);
        deduccionesempleadomensual.setIDTipoDeduccion(1);
        deduccionesempleadomensual.setPeriodo("202110");
        deduccionesempleadomensual.setValor(1200.00);
        deduccionesempleadomensualJpaController instance = new deduccionesempleadomensualJpaController(emf);
        try{
            instance.create(deduccionesempleadomensual);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class deduccionesempleadomensualJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        deduccionesempleadomensual deduccionesempleadomensual = deduccionesDAO.finddeduccionesempleadomensual(deduccionesDAO.finddeduccionesempleadomensualEntities().get(deduccionesDAO.finddeduccionesempleadomensualEntities().size()-1).getNumdeduccion());
        deduccionesempleadomensualJpaController instance = new deduccionesempleadomensualJpaController(emf);
        try{
            instance.edit(deduccionesempleadomensual);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }
    

    /**
     * Test of finddeduccionesempleadomensualEntities method, of class deduccionesempleadomensualJpaController.
     */
    @org.junit.Test
    public void testFinddeduccionesempleadomensualEntities_0args() {
        System.out.println("finddeduccionesempleadomensualEntities");
        deduccionesempleadomensualJpaController instance = new deduccionesempleadomensualJpaController(emf);
        try{
            instance.finddeduccionesempleadomensualEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of finddeduccionesempleadomensualEntities method, of class deduccionesempleadomensualJpaController.
     */
    @org.junit.Test
    public void testFinddeduccionesempleadomensualEntities_int_int() {
        System.out.println("finddeduccionesempleadomensualEntities");
        int maxResults = 2;
        int firstResult = 1;
        deduccionesempleadomensualJpaController instance = new deduccionesempleadomensualJpaController(emf);
        try{
            instance.finddeduccionesempleadomensualEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of finddeduccionesempleadomensual method, of class deduccionesempleadomensualJpaController.
     */
    @org.junit.Test
    public void testFinddeduccionesempleadomensual() {
        System.out.println("finddeduccionesempleadomensual");
        int id = deduccionesDAO.finddeduccionesempleadomensual(deduccionesDAO.finddeduccionesempleadomensualEntities().get(deduccionesDAO.finddeduccionesempleadomensualEntities().size()-1).getNumdeduccion()).getNumdeduccion();
        deduccionesempleadomensualJpaController instance = new deduccionesempleadomensualJpaController(emf);
        try{
            instance.finddeduccionesempleadomensual(id);
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getdeduccionesempleadomensualCount method, of class deduccionesempleadomensualJpaController.
     */
    @org.junit.Test
    public void testGetdeduccionesempleadomensualCount() {
        System.out.println("getdeduccionesempleadomensualCount");
        deduccionesempleadomensualJpaController instance = new deduccionesempleadomensualJpaController(emf);
        int expResult = deduccionesDAO.getdeduccionesempleadomensualCount();
        int result = instance.getdeduccionesempleadomensualCount();
        assertEquals(expResult, result);
    }
    
}

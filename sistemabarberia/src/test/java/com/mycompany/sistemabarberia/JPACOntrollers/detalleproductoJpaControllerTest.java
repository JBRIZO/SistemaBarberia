/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.detalleproducto;
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
public class detalleproductoJpaControllerTest {
    
    public detalleproductoJpaControllerTest() {
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private detalleproductoJpaController detalleDAO = new detalleproductoJpaController(emf);
    
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
        detalleDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class detalleproductoJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        detalleproductoJpaController instance = new detalleproductoJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + instance.getEntityManager());
        }
    }

    /**
     * Test of create method, of class detalleproductoJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        detalleproducto detalleproducto = new detalleproducto();
        detalleproducto.setCantidad(1);
        detalleproducto.setIDFacturaEncabezado(1);
        detalleproducto.setIDProducto(1);
        detalleproducto.setPrecio(120.00);
        
        detalleproductoJpaController instance = new detalleproductoJpaController(emf);
        try{
            instance.create(detalleproducto);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class detalleproductoJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        detalleproducto detalleproducto = detalleDAO.finddetalleproducto(detalleDAO.finddetalleproductoEntities().get(detalleDAO.getdetalleproductoCount()-1).getNumdetalle());
        detalleproductoJpaController instance = new detalleproductoJpaController(emf);
        try{instance.edit(detalleproducto);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }
    

    /**
     * Test of finddetalleproductoEntities method, of class detalleproductoJpaController.
     */
    @org.junit.Test
    public void testFinddetalleproductoEntities_0args() {
        System.out.println("finddetalleproductoEntities");
        detalleproductoJpaController instance = new detalleproductoJpaController(emf);
        try{instance.finddetalleproductoEntities();
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of finddetalleproductoEntities method, of class detalleproductoJpaController.
     */
    @org.junit.Test
    public void testFinddetalleproductoEntities_int_int() {
        System.out.println("finddetalleproductoEntities");
        int maxResults = 2;
        int firstResult = 1;
        detalleproductoJpaController instance = new detalleproductoJpaController(emf);
        try{
            instance.finddetalleproductoEntities(maxResults, firstResult);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of finddetalleproducto method, of class detalleproductoJpaController.
     */
    @org.junit.Test
    public void testFinddetalleproducto() {
        System.out.println("finddetalleproducto");
        int id = detalleDAO.finddetalleproducto(detalleDAO.finddetalleproductoEntities().get(detalleDAO.getdetalleproductoCount()-1).getNumdetalle()).getNumdetalle();
        detalleproductoJpaController instance = new detalleproductoJpaController(emf);
        try{
            instance.finddetalleproducto(id);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getdetalleproductoCount method, of class detalleproductoJpaController.
     */
    @org.junit.Test
    public void testGetdetalleproductoCount() {
        System.out.println("getdetalleproductoCount");
        detalleproductoJpaController instance = new detalleproductoJpaController(emf);
        int expResult = detalleDAO.getdetalleproductoCount();
        int result = instance.getdetalleproductoCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

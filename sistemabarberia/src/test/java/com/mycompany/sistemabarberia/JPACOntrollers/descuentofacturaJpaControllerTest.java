/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.descuentofactura;
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
public class descuentofacturaJpaControllerTest {
    
    public descuentofacturaJpaControllerTest() {
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private  descuentofacturaJpaController descuentoDAO = new descuentofacturaJpaController(emf);
    
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
        descuentoDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class descuentofacturaJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        descuentofacturaJpaController instance = new descuentofacturaJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of create method, of class descuentofacturaJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        descuentofactura descuentofactura = new descuentofactura();
        descuentofactura.setActivo(true);
        descuentofactura.setIDDescuento(1);
        descuentofactura.setIDFactura(1);
        descuentofactura.setValor(0.15);
        descuentofacturaJpaController instance = new descuentofacturaJpaController(emf);
        
        try{
            instance.create(descuentofactura);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class descuentofacturaJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        descuentofactura descuentofactura = descuentoDAO.finddescuentofactura(descuentoDAO.finddescuentofacturaEntities().get(descuentoDAO.getdescuentofacturaCount()-1).getNumdescuento());
        descuentofacturaJpaController instance = new descuentofacturaJpaController(emf);
        
        try{
            instance.edit(descuentofactura);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    

    /**
     * Test of finddescuentofacturaEntities method, of class descuentofacturaJpaController.
     */
    @org.junit.Test
    public void testFinddescuentofacturaEntities_0args() {
        System.out.println("finddescuentofacturaEntities");
        descuentofacturaJpaController instance = new descuentofacturaJpaController(emf);
        try{
            instance.finddescuentofacturaEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of finddescuentofacturaEntities method, of class descuentofacturaJpaController.
     */
    @org.junit.Test
    public void testFinddescuentofacturaEntities_int_int() {
        System.out.println("finddescuentofacturaEntities");
        int maxResults = 2;
        int firstResult = 1;
        descuentofacturaJpaController instance = new descuentofacturaJpaController(emf);
        try{
            instance.finddescuentofacturaEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of finddescuentofactura method, of class descuentofacturaJpaController.
     */
    @org.junit.Test
    public void testFinddescuentofactura() {
        System.out.println("finddescuentofactura");
        int id = descuentoDAO.finddescuentofactura(descuentoDAO.finddescuentofacturaEntities().get(descuentoDAO.getdescuentofacturaCount()-1).getNumdescuento()).getNumdescuento();
        descuentofacturaJpaController instance = new descuentofacturaJpaController(emf);
        try{
            instance.finddescuentofactura(id);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getdescuentofacturaCount method, of class descuentofacturaJpaController.
     */
    @org.junit.Test
    public void testGetdescuentofacturaCount() {
        System.out.println("getdescuentofacturaCount");
        descuentofacturaJpaController instance = new descuentofacturaJpaController(emf);
        int expResult = descuentoDAO.getdescuentofacturaCount();
        int result = instance.getdescuentofacturaCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.productos;
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
public class productosJpaControllerTest {
    
    public productosJpaControllerTest() {
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private productosJpaController productoDAO = new productosJpaController(emf);
    
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
        productoDAO.getEntityManager().close();
        emf.close();
    }

    

    /**
     * Test of getEntityManager method, of class productosJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        productosJpaController instance = new productosJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
        fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of create method, of class productosJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        productos productos = new productos();
        productos.setActivo(true);
        productos.setNomProducto("Nombre");
        productos.setStockActual(10);
        productos.setStockMaximo(10);
        productos.setStockMinimo(10);
        productosJpaController instance = new productosJpaController(emf);
        
        try{instance.create(productos);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class productosJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        productos productos = productoDAO.findproductosEntities().get(productoDAO.getproductosCount()-1);
        productosJpaController instance = new productosJpaController(emf);
        try{instance.edit(productos);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    

    /**
     * Test of findproductosEntities method, of class productosJpaController.
     */
    @org.junit.Test
    public void testFindproductosEntities_0args() {
        System.out.println("findproductosEntities");
        productosJpaController instance = new productosJpaController(emf);
        try{instance.findproductosEntities();
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findproductosEntities method, of class productosJpaController.
     */
    @org.junit.Test
    public void testFindproductosEntities_int_int() {
        System.out.println("findproductosEntities");
        int maxResults = 2;
        int firstResult = 1;
        productosJpaController instance = new productosJpaController(emf);
        try{instance.findproductosEntities(maxResults, firstResult);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findproductos method, of class productosJpaController.
     */
    @org.junit.Test
    public void testFindproductos() {
        System.out.println("findproductos");
        int id = productoDAO.findproductosEntities().get(productoDAO.getproductosCount()-1).getIdproducto();
        productosJpaController instance = new productosJpaController(emf);
        try{instance.findproductos(id);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getproductosCount method, of class productosJpaController.
     */
    @org.junit.Test
    public void testGetproductosCount() {
        System.out.println("getproductosCount");
        productosJpaController instance = new productosJpaController(emf);
        int expResult = productoDAO.getproductosCount();
        int result = instance.getproductosCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

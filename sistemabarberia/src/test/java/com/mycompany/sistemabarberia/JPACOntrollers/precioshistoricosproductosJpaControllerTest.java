/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.clientesTest;
import com.mycompany.sistemabarberia.precioshistoricosproductos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class precioshistoricosproductosJpaControllerTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha;
    
    public precioshistoricosproductosJpaControllerTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
        } catch (Exception ex) {
            Logger.getLogger(clientesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private precioshistoricosproductosJpaController preciosDAO = new precioshistoricosproductosJpaController(emf);
    
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
        preciosDAO.getEntityManager().close();
        emf.close();emf.close();
    }

    /**
     * Test of getEntityManager method, of class precioshistoricosproductosJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        precioshistoricosproductosJpaController instance = new precioshistoricosproductosJpaController(emf);
        try{instance.getEntityManager();
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    

    /**
     * Test of create method, of class precioshistoricosproductosJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        precioshistoricosproductos precios = new precioshistoricosproductos();
        precios.setActivo(true);
        precios.setFechaFinal(new java.sql.Date(fecha.getTime()));
        precios.setFechaInicial(new java.sql.Date(fecha.getTime()));
        precios.setIDProducto(1);
        precios.setPrecio(12.00);
        precioshistoricosproductosJpaController instance = new precioshistoricosproductosJpaController(emf);
        try{instance.create(precios);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class precioshistoricosproductosJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        precioshistoricosproductos precioshistoricosproductos = preciosDAO.findprecioshistoricosproductosEntities().get(preciosDAO.getprecioshistoricosproductosCount()-1);
        precioshistoricosproductosJpaController instance = new precioshistoricosproductosJpaController(emf);
        try{instance.edit(precioshistoricosproductos);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findprecioshistoricosproductosEntities method, of class precioshistoricosproductosJpaController.
     */
    @org.junit.Test
    public void testFindprecioshistoricosproductosEntities_0args() {
        System.out.println("findprecioshistoricosproductosEntities");
        precioshistoricosproductosJpaController instance = new precioshistoricosproductosJpaController(emf);
        try{instance.findprecioshistoricosproductosEntities();
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findprecioshistoricosproductosEntities method, of class precioshistoricosproductosJpaController.
     */
    @org.junit.Test
    public void testFindprecioshistoricosproductosEntities_int_int() {
        System.out.println("findprecioshistoricosproductosEntities");
        int maxResults = 2;
        int firstResult = 1;
        precioshistoricosproductosJpaController instance = new precioshistoricosproductosJpaController(emf);
        try{instance.findprecioshistoricosproductosEntities(maxResults, firstResult);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findprecioshistoricosproductos method, of class precioshistoricosproductosJpaController.
     */
    @org.junit.Test
    public void testFindprecioshistoricosproductos() {
        System.out.println("findprecioshistoricosproductos");
        int id = preciosDAO.findprecioshistoricosproductosEntities().get(preciosDAO.getprecioshistoricosproductosCount()-1).getNumprecio();
        precioshistoricosproductosJpaController instance = new precioshistoricosproductosJpaController(emf);
        try{instance.findprecioshistoricosproductos(id);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getprecioshistoricosproductosCount method, of class precioshistoricosproductosJpaController.
     */
    @org.junit.Test
    public void testGetprecioshistoricosproductosCount() {
        System.out.println("getprecioshistoricosproductosCount");
        precioshistoricosproductosJpaController instance = new precioshistoricosproductosJpaController(emf);
        int expResult = preciosDAO.getprecioshistoricosproductosCount();
        int result = instance.getprecioshistoricosproductosCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

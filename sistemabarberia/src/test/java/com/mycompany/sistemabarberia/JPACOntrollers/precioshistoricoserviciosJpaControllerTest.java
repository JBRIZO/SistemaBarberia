/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.clientesTest;
import com.mycompany.sistemabarberia.precioshistoricoservicios;
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
public class precioshistoricoserviciosJpaControllerTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha;
    
    public precioshistoricoserviciosJpaControllerTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
        } catch (Exception ex) {
            Logger.getLogger(clientesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private precioshistoricoserviciosJpaController preciosDAO = new precioshistoricoserviciosJpaController(emf);
    
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
        emf.close();
    }

    

    /**
     * Test of getEntityManager method, of class precioshistoricoserviciosJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        precioshistoricoserviciosJpaController instance = new precioshistoricoserviciosJpaController(emf);
        
       try{instance.getEntityManager();
       instance.getEntityManager().close();}catch(Exception Ex){
           instance.getEntityManager().close();
           fail("Prueba Fallida: " + Ex.getMessage());
       }
    }

    /**
     * Test of create method, of class precioshistoricoserviciosJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        precioshistoricoservicios preciosH = new precioshistoricoservicios();
        preciosH.setActivo(true);
        preciosH.setFechaFinal(new java.sql.Date(fecha.getTime()));
        preciosH.setFechaInicial(new java.sql.Date(fecha.getTime()));
        preciosH.setIDServicio(1);
        preciosH.setPrecio(120.00);
        precioshistoricoserviciosJpaController instance = new precioshistoricoserviciosJpaController(emf);
        try{instance.create(preciosH);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class precioshistoricoserviciosJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        precioshistoricoservicios precioshistoricoservicios = preciosDAO.findprecioshistoricoserviciosEntities().get(preciosDAO.getprecioshistoricoserviciosCount()-1);
        precioshistoricoserviciosJpaController instance = new precioshistoricoserviciosJpaController(emf);
        try{instance.edit(precioshistoricoservicios);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findprecioshistoricoserviciosEntities method, of class precioshistoricoserviciosJpaController.
     */
    @org.junit.Test
    public void testFindprecioshistoricoserviciosEntities_0args() {
        System.out.println("findprecioshistoricoserviciosEntities");
        precioshistoricoserviciosJpaController instance = new precioshistoricoserviciosJpaController(emf);
        try{instance.findprecioshistoricoserviciosEntities();
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findprecioshistoricoserviciosEntities method, of class precioshistoricoserviciosJpaController.
     */
    @org.junit.Test
    public void testFindprecioshistoricoserviciosEntities_int_int() {
        System.out.println("findprecioshistoricoserviciosEntities");
        int maxResults = 2;
        int firstResult = 1;
        precioshistoricoserviciosJpaController instance = new precioshistoricoserviciosJpaController(emf);
        try{
            instance.findprecioshistoricoserviciosEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
        fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findprecioshistoricoservicios method, of class precioshistoricoserviciosJpaController.
     */
    @org.junit.Test
    public void testFindprecioshistoricoservicios() {
        System.out.println("findprecioshistoricoservicios");
        int id = preciosDAO.findprecioshistoricoserviciosEntities().get(preciosDAO.getprecioshistoricoserviciosCount()-1).getNumprecioservicio();
        precioshistoricoserviciosJpaController instance = new precioshistoricoserviciosJpaController(emf);
        try{instance.findprecioshistoricoservicios(id);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getprecioshistoricoserviciosCount method, of class precioshistoricoserviciosJpaController.
     */
    @org.junit.Test
    public void testGetprecioshistoricoserviciosCount() {
        System.out.println("getprecioshistoricoserviciosCount");
        precioshistoricoserviciosJpaController instance = new precioshistoricoserviciosJpaController(emf);
        int expResult = preciosDAO.getprecioshistoricoserviciosCount();
        int result = instance.getprecioshistoricoserviciosCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

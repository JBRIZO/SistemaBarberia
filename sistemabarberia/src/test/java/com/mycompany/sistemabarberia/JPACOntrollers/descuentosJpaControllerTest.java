/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.clientesTest;
import com.mycompany.sistemabarberia.descuentos;
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
public class descuentosJpaControllerTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha;
    
    public descuentosJpaControllerTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
        } catch (Exception ex) {
            Logger.getLogger(clientesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private  descuentosJpaController descuentosDAO = new descuentosJpaController(emf);
    
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
        descuentosDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class descuentosJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        descuentosJpaController instance = new descuentosJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

   

    /**
     * Test of create method, of class descuentosJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        descuentos descuentos = new descuentos();
        descuentos.setActivo(true);
        descuentos.setFechaFinal(new java.sql.Date(fecha.getTime()));
        descuentos.setFechaInicio(new java.sql.Date(fecha.getTime()));
        descuentos.setIDTipoDescuento(1);
        descuentos.setValor(0.15);
        
        descuentosJpaController instance = new descuentosJpaController(emf);
        
        try{
            instance.create(descuentos);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class descuentosJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        descuentos descuentos = descuentosDAO.finddescuentos(descuentosDAO.finddescuentosEntities().get(descuentosDAO.getdescuentosCount()-1).getIddescuento());
        descuentosJpaController instance = new descuentosJpaController(emf);
        try{
            instance.edit(descuentos);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + instance.getEntityManager());
        }
    }

   

    /**
     * Test of finddescuentosEntities method, of class descuentosJpaController.
     */
    @org.junit.Test
    public void testFinddescuentosEntities_0args() {
        System.out.println("finddescuentosEntities");
        descuentosJpaController instance = new descuentosJpaController(emf);
        try{
            instance.finddescuentosEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + instance.getEntityManager());
        }
    }

    /**
     * Test of finddescuentosEntities method, of class descuentosJpaController.
     */
    @org.junit.Test
    public void testFinddescuentosEntities_int_int() {
        System.out.println("finddescuentosEntities");
        int maxResults = 2;
        int firstResult = 1;
        descuentosJpaController instance = new descuentosJpaController(emf);
        try{
            
            instance.finddescuentosEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + instance.getEntityManager());
        }
    }

    /**
     * Test of finddescuentos method, of class descuentosJpaController.
     */
    @org.junit.Test
    public void testFinddescuentos() {
        System.out.println("finddescuentos");
        int id = descuentosDAO.finddescuentos(descuentosDAO.finddescuentosEntities().get(descuentosDAO.getdescuentosCount()-1).getIddescuento()).getIddescuento();
        descuentosJpaController instance = new descuentosJpaController(emf);
        try{
            instance.finddescuentos(id);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + instance.getEntityManager());
        }
    }

    /**
     * Test of getdescuentosCount method, of class descuentosJpaController.
     */
    @org.junit.Test
    public void testGetdescuentosCount() {
        System.out.println("getdescuentosCount");
        descuentosJpaController instance = new descuentosJpaController(emf);
        int expResult = descuentosDAO.getdescuentosCount();
        int result = instance.getdescuentosCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

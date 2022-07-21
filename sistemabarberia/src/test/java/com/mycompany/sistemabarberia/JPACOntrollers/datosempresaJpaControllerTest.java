/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.datosempresa;
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
public class datosempresaJpaControllerTest {
    
    public datosempresaJpaControllerTest() {
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
     datosempresaJpaController datosDAO = new datosempresaJpaController(emf);
    
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
        datosDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class datosempresaJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        datosempresaJpaController instance = new datosempresaJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of create method, of class datosempresaJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        datosempresa datosempresa = new datosempresa();
        datosempresa.setIddato(6);
        datosempresa.setNombre("Nombre");
        datosempresa.setValor("Valor");
        datosempresaJpaController instance = new datosempresaJpaController(emf);
        try{
            instance.create(datosempresa);
            instance.getEntityManager().close();
        }catch(Exception Ex){fail("Prueba fallida: " + Ex.getMessage());}
    }

    /**
     * Test of edit method, of class datosempresaJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        datosempresa datosempresa = datosDAO.finddatosempresaEntities(datosDAO.getdatosempresaCount(), datosDAO.getdatosempresaCount()-1).get(0);
        datosempresaJpaController instance = new datosempresaJpaController(emf);
        try{
            instance.edit(datosempresa);
            instance.getEntityManager().close();
        }catch(Exception Ex){
        fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of finddatosempresaEntities method, of class datosempresaJpaController.
     */
    @org.junit.Test
    public void testFinddatosempresaEntities_0args() {
        System.out.println("finddatosempresaEntities");
        datosempresaJpaController instance = new datosempresaJpaController(emf);
        try{
            instance.finddatosempresaEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){
        fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of finddatosempresaEntities method, of class datosempresaJpaController.
     */
    @org.junit.Test
    public void testFinddatosempresaEntities_int_int() {
        System.out.println("finddatosempresaEntities");
        int maxResults = 2;
        int firstResult = 1;
        datosempresaJpaController instance = new datosempresaJpaController(emf);
        try{
            instance.finddatosempresaEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of finddatosempresa method, of class datosempresaJpaController.
     */
    @org.junit.Test
    public void testFinddatosempresa() {
        System.out.println("finddatosempresa");
        int id = datosDAO.finddatosempresa(datosDAO.finddatosempresaEntities().get(datosDAO.finddatosempresaEntities().size()-1).getIddato()).getIddato();
        datosempresaJpaController instance = new datosempresaJpaController(emf);
        try{
            instance.finddatosempresa(id);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getdatosempresaCount method, of class datosempresaJpaController.
     */
    @org.junit.Test
    public void testGetdatosempresaCount() {
        System.out.println("getdatosempresaCount");
        datosempresaJpaController instance = new datosempresaJpaController(emf);
        int expResult = datosDAO.getdatosempresaCount();
        int result = instance.getdatosempresaCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

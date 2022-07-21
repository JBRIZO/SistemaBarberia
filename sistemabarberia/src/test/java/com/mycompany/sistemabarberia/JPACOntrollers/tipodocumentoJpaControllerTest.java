/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.tipodocumento;
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
public class tipodocumentoJpaControllerTest {
    
    public tipodocumentoJpaControllerTest() {
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private tipodocumentoJpaController tipoDAO = new tipodocumentoJpaController(emf);
    
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
     * Test of getEntityManager method, of class tipodocumentoJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        tipodocumentoJpaController instance = new tipodocumentoJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of create method, of class tipodocumentoJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        tipodocumento tipodocumento = new tipodocumento();
        tipodocumento.setActivo(true);
        tipodocumento.setTipoDocumento("Nombre");
        tipodocumentoJpaController instance = new tipodocumentoJpaController(emf);
        try{
            instance.create(tipodocumento);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class tipodocumentoJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        tipodocumento tipodocumento = tipoDAO.findtipodocumentoEntities().get(tipoDAO.gettipodocumentoCount()-1);
        tipodocumentoJpaController instance = new tipodocumentoJpaController(emf);
        try{
            instance.edit(tipodocumento);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

   

    /**
     * Test of findtipodocumentoEntities method, of class tipodocumentoJpaController.
     */
    @org.junit.Test
    public void testFindtipodocumentoEntities_0args() {
        System.out.println("findtipodocumentoEntities");
        tipodocumentoJpaController instance = new tipodocumentoJpaController(emf);
        try{
            instance.findtipodocumentoEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findtipodocumentoEntities method, of class tipodocumentoJpaController.
     */
    @org.junit.Test
    public void testFindtipodocumentoEntities_int_int() {
        System.out.println("findtipodocumentoEntities");
        int maxResults = 2;
        int firstResult = 1;
        tipodocumentoJpaController instance = new tipodocumentoJpaController(emf);
        try{instance.findtipodocumentoEntities(maxResults, firstResult);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findtipodocumento method, of class tipodocumentoJpaController.
     */
    @org.junit.Test
    public void testFindtipodocumento() {
        System.out.println("findtipodocumento");
        int id = tipoDAO.findtipodocumentoEntities().get(tipoDAO.gettipodocumentoCount()-1).getIdtipodocumento();
        tipodocumentoJpaController instance = new tipodocumentoJpaController(emf);
        try{
            instance.findtipodocumento(id);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of gettipodocumentoCount method, of class tipodocumentoJpaController.
     */
    @org.junit.Test
    public void testGettipodocumentoCount() {
        System.out.println("gettipodocumentoCount");
        tipodocumentoJpaController instance = new tipodocumentoJpaController(emf);
        int expResult = tipoDAO.gettipodocumentoCount();
        int result = instance.gettipodocumentoCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

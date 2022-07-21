/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.clientesTest;
import com.mycompany.sistemabarberia.parametros;
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
public class parametrosJpaControllerTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha;
    
    public parametrosJpaControllerTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
        } catch (Exception ex) {
            Logger.getLogger(clientesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private parametrosJpaController parametrosDAO = new parametrosJpaController(emf);
    
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
        parametrosDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class parametrosJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        parametrosJpaController instance = new parametrosJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    

    /**
     * Test of create method, of class parametrosJpaController.
     */
    @org.junit.Test
    public void testCreate() {
        System.out.println("create");
        parametros parametros = new parametros();
        parametros.setActivo(true);
        parametros.setFechaFinal(fecha);
        parametros.setFechaInicio(fecha);
        parametros.setLlave("Llave");
        parametros.setRangoFinal(5);
        parametros.setRangoInicial(1);
        
        parametrosJpaController instance = new parametrosJpaController(emf);
        try{instance.create(parametros);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class parametrosJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        parametros parametros = parametrosDAO.findparametros(parametrosDAO.findparametrosEntities().get(parametrosDAO.getparametrosCount()-1).getIdparametro());
        parametrosJpaController instance = new parametrosJpaController(emf);
        try{
            instance.edit(parametros);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

   

    /**
     * Test of findparametrosEntities method, of class parametrosJpaController.
     */
    @org.junit.Test
    public void testFindparametrosEntities_0args() {
        System.out.println("findparametrosEntities");
        parametrosJpaController instance = new parametrosJpaController(emf);
        try{instance.findparametrosEntities();
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findparametrosEntities method, of class parametrosJpaController.
     */
    @org.junit.Test
    public void testFindparametrosEntities_int_int() {
        System.out.println("findparametrosEntities");
        int maxResults = 2;
        int firstResult = 1;
        parametrosJpaController instance = new parametrosJpaController(emf);
        try{instance.findparametrosEntities(maxResults, firstResult);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findparametros method, of class parametrosJpaController.
     */
    @org.junit.Test
    public void testFindparametros() {
        System.out.println("findparametros");
        int id = parametrosDAO.findparametros(parametrosDAO.findparametrosEntities().get(parametrosDAO.getparametrosCount()-1).getIdparametro()).getIdparametro();
        parametrosJpaController instance = new parametrosJpaController(emf);
        try{instance.findparametros(id);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getparametrosCount method, of class parametrosJpaController.
     */
    @org.junit.Test
    public void testGetparametrosCount() {
        System.out.println("getparametrosCount");
        parametrosJpaController instance = new parametrosJpaController(emf);
        int expResult = parametrosDAO.getparametrosCount();
        int result = instance.getparametrosCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

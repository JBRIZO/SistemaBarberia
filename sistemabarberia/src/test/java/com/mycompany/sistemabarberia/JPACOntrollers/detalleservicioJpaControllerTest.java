/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.detalleservicio;
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
public class detalleservicioJpaControllerTest {
    
    public detalleservicioJpaControllerTest() {
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private detalleservicioJpaController detalleDAO = new detalleservicioJpaController(emf);
    
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
     * Test of getEntityManager method, of class detalleservicioJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        detalleservicioJpaController instance = new detalleservicioJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of create method, of class detalleservicioJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        detalleservicio detalleservicio = new detalleservicio();
        detalleservicio.setIDServicio(1);
        detalleservicio.setCantidad(1);
        detalleservicio.setIDFacturaEncabezado(1);
        detalleservicio.setPrecio(120.00);
        detalleservicioJpaController instance = new detalleservicioJpaController(emf);
        try{
            instance.create(detalleservicio);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class detalleservicioJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception{
        System.out.println("edit");
        detalleservicio detalleservicio = detalleDAO.finddetalleservicio(detalleDAO.finddetalleservicioEntities().get(detalleDAO.getdetalleservicioCount()-1).getNumdetalleservicio());
        detalleservicioJpaController instance = new detalleservicioJpaController(emf);
        
        try{
            instance.edit(detalleservicio);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

  
    /**
     * Test of finddetalleservicioEntities method, of class detalleservicioJpaController.
     */
    @org.junit.Test
    public void testFinddetalleservicioEntities_0args() {
        System.out.println("finddetalleservicioEntities");
        detalleservicioJpaController instance = new detalleservicioJpaController(emf);
        try{
            instance.finddetalleservicioEntities();
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of finddetalleservicioEntities method, of class detalleservicioJpaController.
     */
    @org.junit.Test
    public void testFinddetalleservicioEntities_int_int() {
        System.out.println("finddetalleservicioEntities");
        int maxResults = 2;
        int firstResult = 1;
        detalleservicioJpaController instance = new detalleservicioJpaController(emf);
        try{
            instance.finddetalleservicioEntities(maxResults, firstResult);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of finddetalleservicio method, of class detalleservicioJpaController.
     */
    @org.junit.Test
    public void testFinddetalleservicio() {
        System.out.println("finddetalleservicio");
        int id = detalleDAO.finddetalleservicio(detalleDAO.finddetalleservicioEntities().get(detalleDAO.getdetalleservicioCount()-1).getNumdetalleservicio()).getNumdetalleservicio();
        detalleservicioJpaController instance = new detalleservicioJpaController(emf);
        try{
            instance.finddetalleservicio(id);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getdetalleservicioCount method, of class detalleservicioJpaController.
     */
    @org.junit.Test
    public void testGetdetalleservicioCount() {
        System.out.println("getdetalleservicioCount");
        detalleservicioJpaController instance = new detalleservicioJpaController(emf);
        int expResult = detalleDAO.getdetalleservicioCount();
        int result = instance.getdetalleservicioCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

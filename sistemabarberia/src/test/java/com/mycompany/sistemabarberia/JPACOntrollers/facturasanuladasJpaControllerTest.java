/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.clientesTest;
import com.mycompany.sistemabarberia.facturasanuladas;
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
public class facturasanuladasJpaControllerTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha;
    
    public facturasanuladasJpaControllerTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
        } catch (Exception ex) {
            Logger.getLogger(clientesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private facturasanuladasJpaController facturaDAO = new facturasanuladasJpaController(emf);
    
    
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
        facturaDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class facturasanuladasJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        facturasanuladasJpaController instance = new facturasanuladasJpaController(emf);
        try{instance.getEntityManager();
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of create method, of class facturasanuladasJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        facturasanuladas facturasanuladas = new facturasanuladas();
        facturasanuladas.setFechaAnulacion(fecha);
        facturasanuladas.setIDEmpleado(1);
        facturasanuladas.setIDFacturaEncabezado(1);
        facturasanuladas.setMotivo("anulada");
        
        facturasanuladasJpaController instance = new facturasanuladasJpaController(emf);
        try{instance.create(facturasanuladas);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class facturasanuladasJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        facturasanuladas facturasanuladas = facturaDAO.findfacturasanuladas(facturaDAO.findfacturasanuladasEntities().get(facturaDAO.getfacturasanuladasCount()-1).getIdfacturaanulada());
        facturasanuladasJpaController instance = new facturasanuladasJpaController(emf);
        
        try{instance.edit(facturasanuladas);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
        fail("Prueba fallida: " + Ex.getMessage());
        }
    }

   

    /**
     * Test of findfacturasanuladasEntities method, of class facturasanuladasJpaController.
     */
    @org.junit.Test
    public void testFindfacturasanuladasEntities_0args() {
        System.out.println("findfacturasanuladasEntities");
        facturasanuladasJpaController instance = new facturasanuladasJpaController(emf);
       try{
           instance.findfacturasanuladasEntities();
           instance.getEntityManager().close();
       }catch(Exception Ex){
           instance.getEntityManager().close();
           fail("Prueba fallida: " + Ex.getMessage());
       }
    }

    /**
     * Test of findfacturasanuladasEntities method, of class facturasanuladasJpaController.
     */
    @org.junit.Test
    public void testFindfacturasanuladasEntities_int_int() {
        System.out.println("findfacturasanuladasEntities");
        int maxResults = 2;
        int firstResult = 1;
        facturasanuladasJpaController instance = new facturasanuladasJpaController(emf);
        try{
            instance.findfacturasanuladasEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findfacturasanuladas method, of class facturasanuladasJpaController.
     */
    @org.junit.Test
    public void testFindfacturasanuladas() {
        System.out.println("findfacturasanuladas");
        int id = facturaDAO.findfacturasanuladas(facturaDAO.findfacturasanuladasEntities().get(facturaDAO.getfacturasanuladasCount()-1).getIdfacturaanulada()).getIdfacturaanulada();
        facturasanuladasJpaController instance = new facturasanuladasJpaController(emf);
        try{instance.findfacturasanuladas(id);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getfacturasanuladasCount method, of class facturasanuladasJpaController.
     */
    @org.junit.Test
    public void testGetfacturasanuladasCount() {
        System.out.println("getfacturasanuladasCount");
        facturasanuladasJpaController instance = new facturasanuladasJpaController(emf);
        int expResult = facturaDAO.getfacturasanuladasCount();
        int result = instance.getfacturasanuladasCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

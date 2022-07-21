/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.clientesTest;
import com.mycompany.sistemabarberia.facturaencabezado;
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
public class facturaencabezadoJpaControllerTest {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfSql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date fecha;
    private java.util.Date dt = new java.util.Date();
    
    public facturaencabezadoJpaControllerTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
        } catch (Exception ex) {
            Logger.getLogger(clientesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private facturaencabezadoJpaController facturaDAO = new facturaencabezadoJpaController(emf);
    
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
     * Test of getEntityManager method, of class facturaencabezadoJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        facturaencabezadoJpaController instance = new facturaencabezadoJpaController(emf);
        try{
            instance.getEntityManager();
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of create method, of class facturaencabezadoJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        facturaencabezado facturaencabezado = new facturaencabezado();
        String currentTimeSql = sdfSql.format(dt);
        System.out.println(currentTimeSql);
        facturaencabezado.setFechaFactura(currentTimeSql);
        facturaencabezado.setIDBarbero(1);
        facturaencabezado.setIDCliente(0);
        facturaencabezado.setIDEstado(1);
        facturaencabezado.setIDParametro(5);
        facturaencabezado.setIDTipoPago(1);
        facturaencabezado.setIDVendedor(1);
        facturaencabezado.setMontoTarjeta(12.00);
        facturaencabezado.setNumFactura("numero");
        facturaencabezado.setNumTarjeta("1234567891234567");
        facturaencabezado.setTotalFactura(100.00);
        facturaencabezadoJpaController instance = new facturaencabezadoJpaController(emf);
        try{instance.create(facturaencabezado);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage() + Ex.getClass());
        }
    }

    /**
     * Test of edit method, of class facturaencabezadoJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        facturaencabezado facturaencabezado = facturaDAO.findfacturaencabezado(facturaDAO.findfacturaencabezadoEntities().get(facturaDAO.getfacturaencabezadoCount()-1).getIdfacturaencabezado());
        facturaencabezadoJpaController instance = new facturaencabezadoJpaController(emf);
        try{instance.edit(facturaencabezado);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

   
    /**
     * Test of findfacturaencabezadoEntities method, of class facturaencabezadoJpaController.
     */
    @org.junit.Test
    public void testFindfacturaencabezadoEntities_0args() {
        System.out.println("findfacturaencabezadoEntities");
        facturaencabezadoJpaController instance = new facturaencabezadoJpaController(emf);
        try{instance.findfacturaencabezadoEntities();
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findfacturaencabezadoEntities method, of class facturaencabezadoJpaController.
     */
    @org.junit.Test
    public void testFindfacturaencabezadoEntities_int_int() {
        System.out.println("findfacturaencabezadoEntities");
        int maxResults = 2;
        int firstResult = 1;
        facturaencabezadoJpaController instance = new facturaencabezadoJpaController(emf);
        try{instance.findfacturaencabezadoEntities(maxResults, firstResult);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
        fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findfacturaencabezado method, of class facturaencabezadoJpaController.
     */
    @org.junit.Test
    public void testFindfacturaencabezado() {
        System.out.println("findfacturaencabezado");
        int id = facturaDAO.findfacturaencabezado(facturaDAO.findfacturaencabezadoEntities().get(facturaDAO.getfacturaencabezadoCount()-1).getIdfacturaencabezado()).getIdfacturaencabezado();
        facturaencabezadoJpaController instance = new facturaencabezadoJpaController(emf);
        try{instance.findfacturaencabezado(id);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
        fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getfacturaencabezadoCount method, of class facturaencabezadoJpaController.
     */
    @org.junit.Test
    public void testGetfacturaencabezadoCount() {
        System.out.println("getfacturaencabezadoCount");
        facturaencabezadoJpaController instance = new facturaencabezadoJpaController(emf);
        int expResult = facturaDAO.getfacturaencabezadoCount();
        int result = instance.getfacturaencabezadoCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

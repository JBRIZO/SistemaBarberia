/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.clientesTest;
import com.mycompany.sistemabarberia.salariohistoricoempleados;
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
public class salariohistoricoempleadosJpaControllerTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha;
    
    public salariohistoricoempleadosJpaControllerTest() {
        try { 
            fecha = sdf.parse("12/10/2021");
        } catch (Exception ex) {
            Logger.getLogger(clientesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private salariohistoricoempleadosJpaController salariosDAO = new salariohistoricoempleadosJpaController(emf);
    
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
        salariosDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class salariohistoricoempleadosJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        salariohistoricoempleadosJpaController instance = new salariohistoricoempleadosJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

   
    /**
     * Test of create method, of class salariohistoricoempleadosJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        salariohistoricoempleados salario = new salariohistoricoempleados();
        salario.setActivo(true);
        salario.setFechaFinal(new java.sql.Date(fecha.getTime()));
        salario.setFechaInicial(new java.sql.Date(fecha.getTime()));
        salario.setIDEmpleado(1);
        salario.setSalario(10000.00);
        salariohistoricoempleadosJpaController instance = new salariohistoricoempleadosJpaController(emf);
        try{
            instance.create(salario);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class salariohistoricoempleadosJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        salariohistoricoempleados salariohistoricoempleados = salariosDAO.findsalariohistoricoempleadosEntities().get(salariosDAO.getsalariohistoricoempleadosCount()-1);
        salariohistoricoempleadosJpaController instance = new salariohistoricoempleadosJpaController(emf);
        try{
            instance.edit(salariohistoricoempleados);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

   

    /**
     * Test of findsalariohistoricoempleadosEntities method, of class salariohistoricoempleadosJpaController.
     */
    @org.junit.Test
    public void testFindsalariohistoricoempleadosEntities_0args() {
        System.out.println("findsalariohistoricoempleadosEntities");
        salariohistoricoempleadosJpaController instance = new salariohistoricoempleadosJpaController(emf);
        try{
            instance.findsalariohistoricoempleadosEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findsalariohistoricoempleadosEntities method, of class salariohistoricoempleadosJpaController.
     */
    @org.junit.Test
    public void testFindsalariohistoricoempleadosEntities_int_int() {
        System.out.println("findsalariohistoricoempleadosEntities");
        int maxResults = 2;
        int firstResult = 1;
        salariohistoricoempleadosJpaController instance = new salariohistoricoempleadosJpaController(emf);
        try{
            instance.findsalariohistoricoempleadosEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findsalariohistoricoempleados method, of class salariohistoricoempleadosJpaController.
     */
    @org.junit.Test
    public void testFindsalariohistoricoempleados() {
        System.out.println("findsalariohistoricoempleados");
        int id = salariosDAO.findsalariohistoricoempleadosEntities().get(salariosDAO.getsalariohistoricoempleadosCount()-1).getIdsalario();
        salariohistoricoempleadosJpaController instance = new salariohistoricoempleadosJpaController(emf);
        try{instance.findsalariohistoricoempleados(id);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getsalariohistoricoempleadosCount method, of class salariohistoricoempleadosJpaController.
     */
    @org.junit.Test
    public void testGetsalariohistoricoempleadosCount() {
        System.out.println("getsalariohistoricoempleadosCount");
        salariohistoricoempleadosJpaController instance = new salariohistoricoempleadosJpaController(emf);
        int expResult = salariosDAO.getsalariohistoricoempleadosCount();
        int result = instance.getsalariohistoricoempleadosCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

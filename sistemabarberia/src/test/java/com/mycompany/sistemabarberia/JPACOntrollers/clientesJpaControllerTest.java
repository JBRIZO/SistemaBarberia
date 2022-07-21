/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.clientes;
import com.mycompany.sistemabarberia.clientesTest;
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
public class clientesJpaControllerTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    clientesJpaController clientesDAO = new clientesJpaController(emf);
    
    public clientesJpaControllerTest() {
         try { 
            fecha = sdf.parse("12/10/2021");
        } catch (Exception ex) {
            Logger.getLogger(clientesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     
    
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
        clientesDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class clientesJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        clientesJpaController instance = new clientesJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            fail("Prueba Fallida: " + Ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

  

    /**
     * Test of create method, of class clientesJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        clientes clientes = new clientes();
        clientes.setActivo(true);
        clientes.setApeCliente("Apellido");
        clientes.setNomCliente("Nombre");
        clientes.setFechaNacimiento(fecha);
        clientes.setIDServicio(1);
        clientes.setIDTipoDocumento(1);
        clientes.setNumDocumento("0808200023456");
        clientes.setNumTelefono("12345678");
        
        clientesJpaController instance = new clientesJpaController(emf);
        
        try{
            instance.create(clientes);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            fail("Prueba fallida: " + Ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class clientesJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        clientes clientes = clientesDAO.findclientes(clientesDAO.findclientesEntities().get(clientesDAO.findclientesEntities().size()-1).getIdcliente());
        clientesJpaController instance = new clientesJpaController(emf);
        try{
            instance.edit(clientes);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

   

    /**
     * Test of findclientesEntities method, of class clientesJpaController.
     */
    @org.junit.Test
    public void testFindclientesEntities_0args() {
        System.out.println("findclientesEntities");
        clientesJpaController instance = new clientesJpaController(emf);
        try{
            instance.findclientesEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){fail("Prueba Fallida: " + Ex.getMessage());}
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of findclientesEntities method, of class clientesJpaController.
     */
    @org.junit.Test
    public void testFindclientesEntities_int_int() {
        System.out.println("findclientesEntities");
        int maxResults = 2;
        int firstResult = 1;
        clientesJpaController instance = new clientesJpaController(emf);
        try{
            instance.findclientesEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
        fail("Prueba Fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findclientes method, of class clientesJpaController.
     */
    @org.junit.Test
    public void testFindclientes() {
        System.out.println("findclientes");
        int id = clientesDAO.findclientes(clientesDAO.findclientesEntities().get(clientesDAO.findclientesEntities().size()-1).getIdcliente()).getIdcliente();
        clientesJpaController instance = new clientesJpaController(emf);
        try{
            instance.findclientes(id);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba Fallida: " + Ex.getMessage());}
    }

    /**
     * Test of getclientesCount method, of class clientesJpaController.
     */
    @org.junit.Test
    public void testGetclientesCount() {
        System.out.println("getclientesCount");
        clientesJpaController instance = new clientesJpaController(emf);
        int expResult = clientesDAO.getclientesCount();
        int result = instance.getclientesCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

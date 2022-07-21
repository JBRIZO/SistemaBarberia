/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.usuarios;
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
public class usuariosJpaControllerTest {
    
    public usuariosJpaControllerTest() {
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private usuariosJpaController usuariosDAO = new usuariosJpaController(emf);
    
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
        usuariosDAO.getEntityManager().close();
        emf.close();
    }

    /**
     * Test of getEntityManager method, of class usuariosJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        usuariosJpaController instance = new usuariosJpaController(emf);
        try{
            instance.getEntityManager();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

   
    /**
     * Test of create method, of class usuariosJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        usuarios usuarios = new usuarios();
        usuarios.setActivo(Boolean.TRUE);
        usuarios.setContrasena("password");
        usuarios.setIDEmpleado(7);
        usuarios.setIntentos(0);
        usuarios.setNomCuenta("Cuenta");
        usuariosJpaController instance = new usuariosJpaController(emf);
        try{instance.create(usuarios);
        instance.getEntityManager().close();}catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of edit method, of class usuariosJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        usuarios usuarios = usuariosDAO.findusuariosEntities().get(usuariosDAO.getusuariosCount()-1);
        usuariosJpaController instance = new usuariosJpaController(emf);
        try{
            instance.edit(usuarios);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

   

    /**
     * Test of findusuariosEntities method, of class usuariosJpaController.
     */
    @org.junit.Test
    public void testFindusuariosEntities_0args() {
        System.out.println("findusuariosEntities");
        usuariosJpaController instance = new usuariosJpaController(emf);
        try{
            instance.findusuariosEntities();
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findusuariosEntities method, of class usuariosJpaController.
     */
    @org.junit.Test
    public void testFindusuariosEntities_int_int() {
        System.out.println("findusuariosEntities");
        int maxResults = 2;
        int firstResult = 1;
        usuariosJpaController instance = new usuariosJpaController(emf);
        try{
            instance.findusuariosEntities(maxResults, firstResult);
            instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findusuarios method, of class usuariosJpaController.
     */
    @org.junit.Test
    public void testFindusuarios() {
        System.out.println("findusuarios");
        int id = usuariosDAO.findusuariosEntities().get(usuariosDAO.getusuariosCount()-1).getIdusuario();
        usuariosJpaController instance = new usuariosJpaController(emf);
        try{instance.findusuarios(id);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of findusuariosPorEmpleado method, of class usuariosJpaController.
     */
    @org.junit.Test
    public void testFindusuariosPorEmpleado() {
        System.out.println("findusuariosPorEmpleado");
        int IDEmpleado = 1;
        usuariosJpaController instance = new usuariosJpaController(emf);
        try{instance.findusuariosPorEmpleado(IDEmpleado);
        instance.getEntityManager().close();
        }catch(Exception Ex){
            instance.getEntityManager().close();
            fail("Prueba fallida: " + Ex.getMessage());
        }
    }

    /**
     * Test of getusuariosCount method, of class usuariosJpaController.
     */
    @org.junit.Test
    public void testGetusuariosCount() {
        System.out.println("getusuariosCount");
        usuariosJpaController instance = new usuariosJpaController(emf);
        int expResult = usuariosDAO.getusuariosCount();
        int result = instance.getusuariosCount();
        assertEquals(expResult, result);
        instance.getEntityManager().close();
    }
    
}

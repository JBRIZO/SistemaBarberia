/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
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
public class PlanillaDataSourceTest {
    
    public PlanillaDataSourceTest() {
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
    }

    /**
     * Test of next method, of class PlanillaDataSource.
     */
    @org.junit.Test
    public void testNext() throws Exception {
        System.out.println("next");
        Object[][] object = new Object[4][3];
        PlanillaDataSource instance = new PlanillaDataSource(object);
        instance.index = 5;
        boolean expResult = false;
        boolean result = instance.next();
        assertEquals(expResult, result);
    }

   

    /**
     * Test of getDataSource method, of class PlanillaDataSource.
     */
    @org.junit.Test
    public void testGetDataSource() {
        System.out.println("getDataSource");
        Object[][] planilla = new Object[4][3];
        PlanillaDataSource instance = new PlanillaDataSource(planilla);
        Object[][] expResult = planilla;
        Object[][] result = instance.planilla;
        assertEquals(expResult, result);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import com.mycompany.GUI.PantallaLogin;
import com.mycompany.GUI.pantallaProductos;
import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.facturaencabezadoJpaController;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.Path;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jonathan Laux
 */
public class main 
{
    public static void main(String args[]) throws FileNotFoundException{
     Connection conn = null;
     
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mqw9x0qo2x?zeroDateTimeBehavior=convertToNull","root","");
            conn.setAutoCommit(false);
        }
        catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }
        HashMap logo = new HashMap();
        //logo.put("logo",is);
        logo.put("usuario","hola");

        try {
            JasperReport reporte = JasperCompileManager.compileReport("src/main/resources/Reportes/reporteInventario.jrxml");
            //JasperReport reporte = JasperCompileManager.compileReport("src/main/resources/Reportes/reporteInventario.jrxml");
            JasperPrint print = JasperFillManager.fillReport(
                reporte,
                logo,
                conn);
            
            MyJasperViewer view = new MyJasperViewer(print,false);
            view.setVisible(true);
            

              //JasperViewer view = new JasperViewer(print,false);
//            view.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
//            view.setTitle("Reporte de Usuarios");
//            view.setVisible(true);
//            JRViewer jViewer = new JRViewer(print);
//            jViewer.setVisible(true);
            
//            for(int i = 0 ; i < jViewer.getSaveContributors().length-1 ; i++){
//                System.out.println(jViewer.getSaveContributors()[i].toString());
//                //jViewer.removeSaveContributor(jViewer.getSaveContributors()[i]);
//            }  
//            
//            for(int i = 0 ; i < jViewer.getSaveContributors().length-1 ; i++){
//                jViewer.removeSaveContributor(jViewer.getSaveContributors()[i]);
//            }
//            System.out.println("hola");
//
//             for(int i = 0 ; i < jViewer.getSaveContributors().length-1 ; i++){
//                System.out.println(jViewer.getSaveContributors()[i].toString());
//                //jViewer.removeSaveContributor(jViewer.getSaveContributors()[i]);
//            }  
            
        } catch (JRException ex) {
            Logger.getLogger(pantallaProductos.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}
  
    


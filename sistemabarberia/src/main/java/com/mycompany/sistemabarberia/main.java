/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jonathan Laux
 */
public class main 
{
static Connection conn = null;
    public static void main(String[] args)
    {
        // Cargamos el driver JDBC
         
    try {
      Class.forName("com.mysql.jdbc.Driver");
    }
    catch (ClassNotFoundException e) {
      System.out.println("MySQL JDBC Driver not found.");
      System.exit(1);
    }
    //Para iniciar el Logger.
    //inicializaLogger();
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mqw9x0qo2x?zeroDateTimeBehavior=convertToNull","root","");
      conn.setAutoCommit(false);
    }
    catch (SQLException e) {
      System.out.println("Error de conexión: " + e.getMessage());
      System.exit(4);
    }

    try {
//     JasperDesign design = JRXmlLoader.load("C:\\Users\\Jonathan Laux\\Documents\\NetBeansProjects\\SistemaBarberia\\sistemabarberia\\src\\main\\java\\Reportes\\reporteInventario.jrxml");
//     String query = "SELECT * from productos";
//     
//     JRDesignQuery updateQuery = new JRDesignQuery();
//     updateQuery.setText(query);
//     
//     design.setQuery(updateQuery);
//     
//     JasperReport jReport = JasperCompileManager.compileReport(design);
//     JasperPrint print = JasperFillManager.fillReport(jReport,null,conn);
//System.out.println(main.class.getResourceAsStream("C:\\Users\\Jonathan Laux\\Documents\\NetBeansProjects\\SistemaBarberia\\sistemabarberia\\src\\main\\java\\Reportes\\reporteInventario.jrxml"));
//     JasperPrint print = JasperFillManager.fillReport(
//             main.class.getResourceAsStream("/Reportes/reporteInventario.jrxml") , 
//              new HashMap<>(), conn);
     
     JasperReport reporte = JasperCompileManager.compileReport("src/main/resources/Reportes/reporteInventario.jrxml");
            JasperPrint print = JasperFillManager.fillReport(
                    reporte,
                    null, 
                    conn);

      
      JasperViewer view = new JasperViewer(print,false);
      view.setVisible(true);
      //JasperViewer.viewReport(print, false);
    }
    catch (Exception e) {
        System.out.println("fuck");
        System.out.println(e.toString());
      //e.printStackTrace();
    }
    finally {
      /*
       * Cleanup antes de salir
       */
      try {
        if (conn != null) {
          conn.rollback();
          System.out.println("ROLLBACK EJECUTADO");
          conn.close();
        }
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }

  }
}
  /**
   *  Puedes descomentar esto si quieres instanciar  el loger. Necesitas la libreia log4j y el siguiente import
   *  import org.apache.log4j.*;
   *  Debes llamarlo desde el main.
   */
  /*
  static void inicializaLogger()
   {
                 PatternLayout pat = new PatternLayout(
                                 "[%-5p][%t] (%F:%L) : %m%n");
                 Logger.getRootLogger().addAppender(new ConsoleAppender(pat));
     Logger.getRootLogger().setLevel(Level.DEBUG);

   }
   */
      
    


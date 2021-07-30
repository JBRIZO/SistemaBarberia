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
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
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
      conn = DriverManager.getConnection("jdbc:mysql:3306//localhost:3306/mqw9x0qo2x?zeroDateTimeBehavior=convertToNull","root","");
      conn.setAutoCommit(false);
    }
    catch (SQLException e) {
      System.out.println("Error de conexión: " + e.getMessage());
      System.exit(4);
    }

    try {
      Map parameters = new HashMap();
      parameters.put("TITULO", "PAISES");
      parameters.put("FECHA", new java.util.Date());
      JasperReport report = JasperCompileManager.compileReport(
          "G:\\Documentos\\prueba.jrxml");
      JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
      // Exporta el informe a PDF
      JasperExportManager.exportReportToPdfFile(print,
          "G:\\Documentos\\Ing Software I\\Informe.pdf");
      //Para visualizar el pdf directamente desde java
      JasperViewer.viewReport(print, false);
    }
    catch (Exception e) {
      e.printStackTrace();
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
      
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jonathan Laux
 */
public class MyJasperViewer extends JasperViewer{
    
    public MyJasperViewer(JasperPrint print, boolean exitOnClose){
        super(print,exitOnClose);
        for(int i = super.viewer.getSaveContributors().length-1 ; i > -1 ; i--){
            if(super.viewer.getSaveContributors()[i].getDescription().equals("Single sheet XLS (*.xls)") || 
               super.viewer.getSaveContributors()[i].getDescription().equals("Multiple sheets XLS (*.xls)") ||
               super.viewer.getSaveContributors()[i].getDescription().equals("PDF (*.pdf)")){
                continue;
            }else{
               super.viewer.removeSaveContributor(super.viewer.getSaveContributors()[i]); 
            }
        }
    }  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Jonathan Laux
 */
public class PlanillaDataSource implements JRDataSource{

    public final Object[][] planilla;
    public int index;
    
     public PlanillaDataSource(Object[][] planilla)
    {
        this.planilla = planilla;
        index = -1;
    }
     
    @Override
    public boolean next() throws JRException {
         index++;
        return (index < planilla.length);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        String nombreCampo = jrf.getName();
        
        switch(nombreCampo)
        {
            case "IDEmpleado":
                valor = planilla[index][0];
                break;
            case "NomEmpleado":
                valor = planilla[index][1];
                break;
            case "ApeEmpleado":
                valor = planilla[index][2];
                break;
            case "SumaBonos":
                valor = planilla[index][3];
                break;
            case "Suma Deducciones":
                valor = planilla[index][4];
                break;
            case "SalarioActualEmpleado":
                valor = planilla[index][5];
                break;
            case "TotalPagar":
                valor = planilla[index][6];
                break;
        }
        return valor;
    }
    
    public static JRDataSource getDataSource(Object[][] planilla)
    {
        return new PlanillaDataSource(planilla);
    }
    
    
}

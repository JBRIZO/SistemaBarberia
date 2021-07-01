/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import com.mycompany.sistemabarberia.JPACOntrollers.tipopagoJpaController;
import java.util.List;

/**
 *
 * @author Jonathan Laux
 */
public class main 
{
    static tipopagoJpaController tipopagodao =new tipopagoJpaController();

    public static void main(String[] args)
    {
        System.out.println("hola");

        
         List<tipopago> vendedores = tipopagodao.findtipopagoEntities();
         
         for(tipopago vendedor : vendedores)
         {
             System.out.println(vendedor.getIdtipopago());
             System.out.println(vendedor.getTipoPago());
             System.out.println(vendedor.isActivo());
         }
                   
         
        
        
    }
}
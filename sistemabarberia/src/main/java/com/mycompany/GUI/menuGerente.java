/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.usuarios;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jonathan Laux
 */
public class menuGerente extends javax.swing.JFrame {
    private empleadoJpaController empleadoDAO = new empleadoJpaController();
    private usuarios usuarios = new usuarios(); 
    private UsuarioSingleton singleton = UsuarioSingleton.getUsuario(usuarios);
    private ImageIcon imagen;
    private Icon icono;

    /**
     * Creates new form nuevoTipoDescuento
     */
    public menuGerente() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        List<empleado> empleadosBD = empleadoDAO.findempleadoEntities();
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        for(int i =0 ; i<empleadosBD.size();i++)
        {
            if(singleton.getCuenta().getIDEmpleado() == empleadosBD.get(i).getIdempleado())
            {
                if(empleadosBD.get(i).getGenEmpleado() == 'M')
                {
                    bienvenido.setText("Bienvenido, " + empleadosBD.get(i).getNomEmpleado() + " " + empleadosBD.get(i).getApeEmpleado());
                }else
                {
                    bienvenido.setText("Bienvenida, " + empleadosBD.get(i).getNomEmpleado() + " " + empleadosBD.get(i).getApeEmpleado());
                }
            }
        }        
    }
    
    public void Reiniciar()
    {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tituloPantalla = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        botonPuesto = new javax.swing.JButton();
        botonProductos = new javax.swing.JButton();
        botonAtributosFactura = new javax.swing.JButton();
        botonServicios = new javax.swing.JButton();
        botonDeducciones = new javax.swing.JButton();
        botonEmpleados = new javax.swing.JButton();
        botonBonos = new javax.swing.JButton();
        botonDescuentos = new javax.swing.JButton();
        botonUsuarios = new javax.swing.JButton();
        botonClientes = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        bienvenido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("MENÚ GERENTE");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        botonPuesto.setBackground(new java.awt.Color(189, 158, 76));
        botonPuesto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonPuesto.setText("PUESTO");
        botonPuesto.setRequestFocusEnabled(false);
        botonPuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonPuestoMouseClicked(evt);
            }
        });
        botonPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPuestoActionPerformed(evt);
            }
        });

        botonProductos.setBackground(new java.awt.Color(189, 158, 76));
        botonProductos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonProductos.setText("PRODUCTOS");
        botonProductos.setRequestFocusEnabled(false);
        botonProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonProductosMouseClicked(evt);
            }
        });
        botonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProductosActionPerformed(evt);
            }
        });

        botonAtributosFactura.setBackground(new java.awt.Color(189, 158, 76));
        botonAtributosFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonAtributosFactura.setText("ATRIBUTOS FACTURA");
        botonAtributosFactura.setRequestFocusEnabled(false);
        botonAtributosFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAtributosFacturaMouseClicked(evt);
            }
        });
        botonAtributosFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtributosFacturaActionPerformed(evt);
            }
        });

        botonServicios.setBackground(new java.awt.Color(189, 158, 76));
        botonServicios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonServicios.setText("SERVICIOS");
        botonServicios.setRequestFocusEnabled(false);
        botonServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonServiciosMouseClicked(evt);
            }
        });
        botonServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonServiciosActionPerformed(evt);
            }
        });

        botonDeducciones.setBackground(new java.awt.Color(189, 158, 76));
        botonDeducciones.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonDeducciones.setText("DEDUCCIONES");
        botonDeducciones.setRequestFocusEnabled(false);
        botonDeducciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonDeduccionesMouseClicked(evt);
            }
        });
        botonDeducciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDeduccionesActionPerformed(evt);
            }
        });

        botonEmpleados.setBackground(new java.awt.Color(189, 158, 76));
        botonEmpleados.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonEmpleados.setText("EMPLEADOS");
        botonEmpleados.setRequestFocusEnabled(false);
        botonEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEmpleadosMouseClicked(evt);
            }
        });
        botonEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEmpleadosActionPerformed(evt);
            }
        });

        botonBonos.setBackground(new java.awt.Color(189, 158, 76));
        botonBonos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonBonos.setText("BONOS");
        botonBonos.setRequestFocusEnabled(false);
        botonBonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBonosMouseClicked(evt);
            }
        });
        botonBonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBonosActionPerformed(evt);
            }
        });

        botonDescuentos.setBackground(new java.awt.Color(189, 158, 76));
        botonDescuentos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonDescuentos.setText("DESCUENTOS");
        botonDescuentos.setRequestFocusEnabled(false);
        botonDescuentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonDescuentosMouseClicked(evt);
            }
        });
        botonDescuentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDescuentosActionPerformed(evt);
            }
        });

        botonUsuarios.setBackground(new java.awt.Color(189, 158, 76));
        botonUsuarios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonUsuarios.setText("USUARIOS");
        botonUsuarios.setRequestFocusEnabled(false);
        botonUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonUsuariosMouseClicked(evt);
            }
        });
        botonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUsuariosActionPerformed(evt);
            }
        });

        botonClientes.setBackground(new java.awt.Color(189, 158, 76));
        botonClientes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonClientes.setText("CLIENTES");
        botonClientes.setRequestFocusEnabled(false);
        botonClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonClientesMouseClicked(evt);
            }
        });
        botonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAtributosFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBonos, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonDeducciones, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(134, 134, 134)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(botonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(botonServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(botonEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAtributosFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(botonDeducciones, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonBonos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        botonRegresar.setBackground(new java.awt.Color(189, 158, 76));
        botonRegresar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonRegresar.setText("CERRAR SESIÓN");
        botonRegresar.setRequestFocusEnabled(false);
        botonRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRegresarMouseClicked(evt);
            }
        });
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        bienvenido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bienvenido.setForeground(new java.awt.Color(255, 255, 255));
        bienvenido.setText("Bienvenido, ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(365, 365, 365)
                            .addComponent(tituloPantalla)))
                    .addComponent(bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bienvenido))
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tituloPantalla)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonPuestoActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProductosActionPerformed
        // TODO add your handling code here:
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaProductos().setVisible(true);
            }
        });
        this.dispose(); 
        this.setVisible(false);
    }//GEN-LAST:event_botonProductosActionPerformed

    private void botonAtributosFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtributosFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAtributosFacturaActionPerformed

    private void botonServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonServiciosActionPerformed
        // TODO add your handling code here:
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaServicios().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_botonServiciosActionPerformed

    private void botonDeduccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDeduccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonDeduccionesActionPerformed

    private void botonEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEmpleadosActionPerformed
        // TODO add your handling code here:\
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaEmpleados().setVisible(true);
            }
        });
        this.dispose(); 
        this.setVisible(false);
        
        
    }//GEN-LAST:event_botonEmpleadosActionPerformed

    private void botonBonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBonosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonBonosActionPerformed

    private void botonDescuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDescuentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonDescuentosActionPerformed

    private void botonPuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPuestoMouseClicked
        // TODO add your handling code here:
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoTipoPuesto().setVisible(true);
            }
        });
    this.setVisible(false);
    this.dispose(); 
    }//GEN-LAST:event_botonPuestoMouseClicked

    private void botonServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonServiciosMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_botonServiciosMouseClicked

    private void botonDescuentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonDescuentosMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaDescuentos().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_botonDescuentosMouseClicked

    private void botonDeduccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonDeduccionesMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tipoDeduccion().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_botonDeduccionesMouseClicked

    private void botonAtributosFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAtributosFacturaMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new atributosFactura().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        
    }//GEN-LAST:event_botonAtributosFacturaMouseClicked

    private void botonEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEmpleadosMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botonEmpleadosMouseClicked

    private void botonProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonProductosMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaProductos().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_botonProductosMouseClicked

    private void botonBonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBonosMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoTipoBono().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_botonBonosMouseClicked

    private void botonUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUsuariosMouseClicked
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaUsuarios().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_botonUsuariosMouseClicked

    private void botonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonUsuariosActionPerformed

    private void botonClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonClientesMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarClientes().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_botonClientesMouseClicked

    private void botonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClientesActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaClientes().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_botonClientesActionPerformed

    private void botonRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegresarMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaLogin().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        
    }//GEN-LAST:event_botonRegresarMouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        
        
    }
    
    private void insertarImagen(JLabel lbl,String ruta)
    {
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        lbl.getWidth(), 
                        lbl.getHeight(),
                        Image.SCALE_DEFAULT)
        );
        lbl.setIcon(this.icono);
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bienvenido;
    private javax.swing.JButton botonAtributosFactura;
    private javax.swing.JButton botonBonos;
    private javax.swing.JButton botonClientes;
    private javax.swing.JButton botonDeducciones;
    private javax.swing.JButton botonDescuentos;
    private javax.swing.JButton botonEmpleados;
    private javax.swing.JButton botonProductos;
    private javax.swing.JButton botonPuesto;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton botonServicios;
    private javax.swing.JButton botonUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

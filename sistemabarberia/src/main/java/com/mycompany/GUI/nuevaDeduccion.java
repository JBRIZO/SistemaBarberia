/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.deduccionesempleadomensualJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipodeduccionJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.deduccionesempleadomensual;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.tipodeduccion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;


/**
 *
 * @author flore
 */
public class nuevaDeduccion extends javax.swing.JFrame {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    
    private deduccionesempleadomensualJpaController deduccionesDAO = new deduccionesempleadomensualJpaController(emf);
    private List<deduccionesempleadomensual> deduccionesempleadomensualBD = deduccionesDAO.finddeduccionesempleadomensualEntities();
    private tipodeduccionJpaController tipodeduccionDAO = new tipodeduccionJpaController(emf);
    private List<tipodeduccion> tipodeduccionBD = tipodeduccionDAO.findtipodeduccionEntities();
    private empleadoJpaController empleadosDAO = new empleadoJpaController(emf);
    private List<empleado> empleadosBD = empleadosDAO.findempleadoEntities();
    private Validaciones validar = new Validaciones();
    private ImageIcon imagen;
    private Icon icono;
     private java.util.Date dt = new java.util.Date();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
    String currentTime = sdf.format(dt);
    Border redBorder = BorderFactory.createLineBorder(Color.RED,1);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN,1);
    Border defaultBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true);
    /**
     * Creates new form nuevaDeduccion
     */
    public nuevaDeduccion() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
        setIconImage(icon);
        this.insertarImagen(this.logo,"/Imagenes/logoBarberia.png");
        Reiniciar(); 
        cantidadLbl.setText(" ");
        for(int i = 0; i < empleadosBD.size(); i++)
        {
            if(empleadosBD.get(i).isActivo())
            {
                idEmpleado.addItem(empleadosBD.get(i).toString());
            }
        }
        for(int i = 0; i < tipodeduccionBD.size(); i++)
        {
            if(tipodeduccionBD.get(i).isActivo())
            {
                tipoDeduccion.addItem(tipodeduccionBD.get(i).toString());
            }
        } 
    }
    
    public void Reiniciar()
    {
        cantidad.setText("Cantidad");
        cantidad.setBorder(defaultBorder);
        formatoInvalidoCantidad.setText(" ");
        formatoInvalidoPeriodo.setText(" ");
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();
        idEmpleado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tipoDeduccion = new javax.swing.JComboBox<>();
        cantidad = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        periodo = new javax.swing.JTextField();
        formatoInvalidoPeriodo = new javax.swing.JLabel();
        formatoInvalidoCantidad = new javax.swing.JLabel();
        cantidadLbl = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("NUEVA DEDUCCION");

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(53, 53, 53));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));

        jLabel.setForeground(new java.awt.Color(255, 255, 255));
        jLabel.setText("ID Empleado:");

        idEmpleado.setBackground(new java.awt.Color(30, 33, 34));
        idEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        idEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Todos los empleados" }));
        idEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        idEmpleado.setMinimumSize(new java.awt.Dimension(32, 23));
        idEmpleado.setPreferredSize(new java.awt.Dimension(32, 23));
        idEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idEmpleadoActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Periodo:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo Deduccion");

        tipoDeduccion.setBackground(new java.awt.Color(30, 33, 34));
        tipoDeduccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        tipoDeduccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tipoDeduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDeduccionActionPerformed(evt);
            }
        });

        cantidad.setEditable(true);
        cantidad.setBackground(new java.awt.Color(30, 33, 34));
        cantidad.setDocument(new JTextFieldLimit(10));
        cantidad.setForeground(new java.awt.Color(255, 255, 255));
        cantidad.setText("Cantidad");
        cantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cantidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cantidadFocusLost(evt);
            }
        });
        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });

        botonAceptar.setBackground(new java.awt.Color(189, 158, 76));
        botonAceptar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonAceptar.setText("ACEPTAR");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCancelar.setBackground(new java.awt.Color(189, 158, 76));
        botonCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonCancelar.setText("CANCELAR");
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCancelarMouseClicked(evt);
            }
        });
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        periodo.setBackground(new java.awt.Color(30, 33, 34));
        periodo.setDocument(new JTextFieldLimit(6));
        periodo.setForeground(new java.awt.Color(255, 255, 255));
        periodo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        periodo.setPreferredSize(new java.awt.Dimension(305, 42));
        periodo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                periodoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                periodoFocusLost(evt);
            }
        });

        formatoInvalidoPeriodo.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoPeriodo.setText("Formato Invalido.");

        formatoInvalidoCantidad.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoCantidad.setText("Formato invalido.");

        cantidadLbl.setForeground(new java.awt.Color(255, 255, 255));
        cantidadLbl.setText("Cantidad:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(formatoInvalidoPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(periodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(botonAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tipoDeduccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cantidadLbl)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(botonCancelar)
                                        .addGap(6, 6, 6))
                                    .addComponent(cantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(formatoInvalidoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel)
                    .addComponent(idEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formatoInvalidoPeriodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cantidadLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tipoDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formatoInvalidoCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        logo.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(tituloPantalla))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tituloPantalla)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idEmpleadoActionPerformed

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed

    private void cantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantidadFocusGained
        // TODO add your handling code here:
        if(cantidad.getText().equals("Cantidad"))
        {
            cantidad.setText("");
        }
        
    }//GEN-LAST:event_cantidadFocusGained

    private void cantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantidadFocusLost
        // TODO add your handling code here:
        try{
        if(cantidad.getText().equals(""))
        {
            cantidad.setText("Cantidad");
            cantidadLbl.setText(" ");
        }else
        {
         validarDecimal();   
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_cantidadFocusLost

    private void botonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botonCancelarMouseClicked

    private void periodoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_periodoFocusGained
        // TODO add your handling code here:
        periodo.selectAll();
    }//GEN-LAST:event_periodoFocusGained

    private void periodoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_periodoFocusLost
        // TODO add your handling code here:
        try{
        validacionPeriodo(periodo,formatoInvalidoPeriodo);
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_periodoFocusLost

    private void tipoDeduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDeduccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoDeduccionActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        try{
        //Filtrar empleados activos
        List<empleado> empleadosActivos = new ArrayList();
        
        for(int i=0 ; i < empleadosBD.size();i++)
        {
            if(empleadosBD.get(i).isActivo())
            {
                empleadosActivos.add(empleadosBD.get(i));
            }
        }
        
        if(idEmpleado.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(null,"Debes seleccionar un empleado.",
                    "Selecciona un empleado.",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(tipoDeduccion.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(null,"Debes seleccionar un tipo de deduccion.",
                    "Selecciona un tipo de deduccion.",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(periodo.getText().equals("") || cantidad.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos.",
                    "Campos Incompletos",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
         if(!validarDecimal() || !validacionPeriodo(periodo,formatoInvalidoPeriodo))
        {
           JOptionPane.showMessageDialog(this,"Por favor corrige los campos en rojo.","Datos inválidos",JOptionPane.ERROR_MESSAGE);
            return; 
        }
         
        //evitar deducciones duplicadas
         EntityManager em = deduccionesDAO.getEntityManager();
        Query query = em.createQuery("FROM deduccionesempleadomensual E where E.Periodo =:periodo AND E.IDEmpleado = :idEmpleado AND E.IDTipoDeduccion = :tipoBono");
        query.setParameter("periodo",periodo.getText());
        query.setParameter("tipoBono",Character.getNumericValue(tipoDeduccion.getSelectedItem().toString().charAt(0)));
        //para todos los empleados
       if(idEmpleado.getSelectedIndex() == 1)
       {
           deduccionesempleadomensual deduccionEmpleado = new deduccionesempleadomensual();
           deduccionesempleadomensual deduccionEditar = new deduccionesempleadomensual();
           boolean edit = false;
           int contador = 0;
           for(empleado empleado:empleadosBD)
           {
               query.setParameter("idEmpleado",empleado.getIdempleado());
               try{
                   deduccionesempleadomensual deduccionesEmp = (deduccionesempleadomensual)query.getSingleResult();
                   deduccionEditar = deduccionesEmp;
                   deduccionEditar.setValor(Double.parseDouble(cantidad.getText()));
                   deduccionEditar.setIDEmpleado(empleado.getIdempleado());
                   deduccionEditar.setIDTipoDeduccion(Character.getNumericValue(tipoDeduccion.getSelectedItem().toString().charAt(0)));
                   deduccionEditar.setPeriodo(periodo.getText());
                   deduccionEditar.setValor(Double.parseDouble(cantidad.getText()));
                   deduccionEditar.setActivo(true);
                   edit = true;
               }catch(javax.persistence.NoResultException Ex)
               {
                   edit = false;
               }
               if(edit)
               {
                   try {
                       deduccionesDAO.edit(deduccionEditar);
                   } catch (Exception ex) {
                       Logger.getLogger(NuevoBono.class.getName()).log(Level.SEVERE, null, ex);
                   }
                 contador++;
               }else
               {
               deduccionEmpleado.setIDEmpleado(empleado.getIdempleado());
               deduccionEmpleado.setIDTipoDeduccion(Character.getNumericValue(tipoDeduccion.getSelectedItem().toString().charAt(0)));
               deduccionEmpleado.setPeriodo(periodo.getText());
               deduccionEmpleado.setValor(Double.parseDouble(cantidad.getText()));
               deduccionEmpleado.setActivo(true);
               if(validarDecimal() && validacionPeriodo(periodo,formatoInvalidoPeriodo))
                {
                    try {
                        deduccionesDAO.create(deduccionEmpleado);
                        contador++;
                    } catch (Exception ex) {
                        //empleado con error
                        contador = empleado.getIdempleado();
                        Logger.getLogger(nuevaDeduccion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               }
               
           }
           if(contador == empleadosActivos.size())
           {
             JOptionPane.showMessageDialog(null,"Operacion Exitosa.");  
           }else
           {
              JOptionPane.showMessageDialog(null,"Error al aplicar deducción al empleado con Id número " + contador); 
           }
           return;   
       }
        deduccionesempleadomensual nuevaDeduccion = new deduccionesempleadomensual();
        Query query2 = em.createQuery("FROM deduccionesempleadomensual E where E.Periodo =:periodo AND E.IDEmpleado = :idEmpleado AND E.IDTipoDeduccion = :tipoBono");
        query2.setParameter("periodo",periodo.getText());
        query2.setParameter("tipoBono",Character.getNumericValue(tipoDeduccion.getSelectedItem().toString().charAt(0)));
        query2.setParameter("idEmpleado",Character.getNumericValue(idEmpleado.getSelectedItem().toString().charAt(0)));
        try{
            deduccionesempleadomensual bonoBd = (deduccionesempleadomensual) query2.getSingleResult();
                JOptionPane.showMessageDialog(this,"Ese tipo de deducción ya ha sido aplicado a este empleado en este periodo","Deducción ya aplicada",JOptionPane.ERROR_MESSAGE);
                return;
        }catch(javax.persistence.NoResultException Ex)
        {
        nuevaDeduccion.setIDEmpleado(Character.getNumericValue(idEmpleado.getSelectedItem().toString().charAt(0)));
        nuevaDeduccion.setIDTipoDeduccion(Character.getNumericValue(tipoDeduccion.getSelectedItem().toString().charAt(0)));
        nuevaDeduccion.setPeriodo(periodo.getText());
        nuevaDeduccion.setValor(Double.parseDouble(cantidad.getText()));
        nuevaDeduccion.setActivo(true);
         try {
                deduccionesDAO.create(nuevaDeduccion);
                JOptionPane.showMessageDialog(null,"Operacion Exitosa.");
            } catch (Exception ex) {
                log(ex);
                Logger.getLogger(nuevaDeduccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaDeducciones().setVisible(true);
            }
        });
        emf.close();
        this.setVisible(false);
        this.dispose(); 
        deduccionesDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_botonCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(nuevaDeduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevaDeduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevaDeduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevaDeduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevaDeduccion().setVisible(true);
            }
        });
    }
    
     private void insertarImagen(JLabel lbl,String ruta)
    {
        this.imagen = new ImageIcon(getClass().getResource(ruta));
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        lbl.getWidth(), 
                        lbl.getHeight(),
                        Image.SCALE_DEFAULT)
        );
        lbl.setIcon(this.icono);
        this.repaint();
    }
     
     private boolean validarDecimal()
     {
         double precio1 = 0 ;
        try{
            precio1 = Double.parseDouble(cantidad.getText());
        }catch(NumberFormatException ex)
        {
            formatoInvalidoCantidad.setVisible(true);
            formatoInvalidoCantidad.setText("Solo puedes ingresar números en este campo.");
            cantidad.setBorder(redBorder);
            return false;
        }
       
        if(precio1 <= 0)
        {
            cantidad.setBorder(redBorder);
            formatoInvalidoCantidad.setVisible(true);
            formatoInvalidoCantidad.setText("La cantidad debe ser mayor a 0.");
            return false;
        }
        
         cantidad.setBorder(greenBorder);
         formatoInvalidoCantidad.setVisible(false);
         return true;
     }
     
     public boolean validacionPeriodo(javax.swing.JTextField jText, JLabel label)
     {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dt);
        int mes = calendar.get(Calendar.MONTH) + 1;
        String mesCampo = "";
        try
        {
            mesCampo = Character.toString(jText.getText().charAt(4)) + jText.getText().charAt(5);
        }catch(StringIndexOutOfBoundsException Ex)
                {
                periodo.setBorder(redBorder);
                label.setText("Un periodo debe tener 6 caracteres.");
                return false;
                }
         
         try{
             if(Integer.parseInt(mesCampo) > mes || Integer.parseInt(mesCampo) < mes)
         {
             jText.setBorder(redBorder);
             label.setText("El mes del periodo debe concordar con el mes actual.");
           return false; 
         } 
         }catch(NumberFormatException Ex)
         {
            jText.setBorder(redBorder); 
            formatoInvalidoPeriodo.setText("Un periodo se compone solo de números.");
         }
        
         if(!validar.validacionCampoNumerico(jText.getText()))
         {
             jText.setBorder(redBorder);
             label.setVisible(true);
             JOptionPane.showMessageDialog(null,"Solo puedes ingresar periodos en este campo.\nEl formato de un periodo es aaaaMM.",
                     "Periodo Inválido",
                     JOptionPane.ERROR_MESSAGE);
             return false;
         }
       if(validar.validacionPeriodo(jText.getText()))
       {
           jText.setBorder(greenBorder);
           return true;
       }else
       {
           jText.setBorder(redBorder);
           JOptionPane.showMessageDialog(null,"Por favor verifica que el año y el mes del periodo "
                   + "otorgado sean válidos","Periodo Inválido",JOptionPane.ERROR_MESSAGE);
           return false; 
       }  
     }
     
     public boolean validarCamposEnBlanco(){
         if(periodo.getText().equals("") || cantidad.getText().equals(""))
        {
            return false;
        }else{return true;}
     }
     
     private void log(Exception ex){
        FileHandler fh;                              
            java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Log");  
            try {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                String ts = new SimpleDateFormat("dd MMMM yyyy HH.mm.ss").format(timestamp);
                fh = new FileHandler("../logs/"+ ts + " " + this.getClass().getName()+".txt" );
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
                logger.info(ex.getClass().toString() + " : " +ex.getMessage());
            } catch (SecurityException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            } 
    }
         
     

     
     
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    public javax.swing.JTextField cantidad;
    private javax.swing.JLabel cantidadLbl;
    private javax.swing.JLabel formatoInvalidoCantidad;
    private javax.swing.JLabel formatoInvalidoPeriodo;
    private javax.swing.JComboBox<String> idEmpleado;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    public javax.swing.JTextField periodo;
    private javax.swing.JComboBox<String> tipoDeduccion;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables


}

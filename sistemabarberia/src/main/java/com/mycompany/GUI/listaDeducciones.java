/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.deduccionesempleadomensualJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.tipodeduccionJpaController;
import com.mycompany.sistemabarberia.MyJasperViewer;
import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.bonosempleadomensual;
import com.mycompany.sistemabarberia.deduccionesempleadomensual;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.permisosusuario;
import com.mycompany.sistemabarberia.tipodeduccion;
import com.mycompany.sistemabarberia.usuarios;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author flore
 */
public class listaDeducciones extends javax.swing.JFrame {
    
    private permisosusuario permisosUsuario;
    private String periodoActual;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    
    private empleadoJpaController empleadosDAO = new empleadoJpaController(emf);
    private deduccionesempleadomensualJpaController deduccionesDAO = new deduccionesempleadomensualJpaController(emf);
    private List<deduccionesempleadomensual> deduccionesBD = deduccionesDAO.finddeduccionesempleadomensualEntities();
    private tipodeduccionJpaController tipodeduccionDAO = new tipodeduccionJpaController(emf);
    private List<tipodeduccion> tipodeduccionBD = tipodeduccionDAO.findtipodeduccionEntities();
    private ImageIcon imagen;
    private Icon icono;
    private java.util.Date dt = new java.util.Date();
    private usuarios usuarios = new usuarios(); 
    private UsuarioSingleton singleton = UsuarioSingleton.getUsuario(usuarios);

    /**
     * Creates new form listaDeducciones
     */
    public listaDeducciones() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
        setIconImage(icon);
        this.insertarImagen(this.logo,"/Imagenes/logoBarberia.png");
        
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dt);
        int anio = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH) + 1;
        periodoActual = mes<10? anio+"0"+mes: Integer.toString(anio)+mes;
         TableColumnModel model = tablaDeducciones.getColumnModel();
        model.removeColumn(model.getColumn(0));
        
        cargarTabla();
        cargarPeriodosCb();
         if(deduccionesDAO.getdeduccionesempleadomensualCount()>0)
        {
           if(!periodoActual.equals(ultimoPeriodo()))
        {
            JOptionPane.showMessageDialog(this,"No has otorgado deducciones este periodo.");
        }  
        }   
         permisosUsuario = verificarPermisos();
         desactivarBotonesPermisos();
    }
    
    private void desactivarBotonesPermisos(){
        if(permisosUsuario.isNuevo()){
            nuevaDeduccion.setEnabled(true);
        }else{
            nuevaDeduccion.setEnabled(false);
        }
        if(permisosUsuario.isModificar()){
            nuevoTipo.setEnabled(true);
        }else{
            nuevoTipo.setEnabled(false);
        }
        if(permisosUsuario.isImprimir()){
            imprimirReporteBonos.setEnabled(true);
        }else{
            imprimirReporteBonos.setEnabled(false);
        }
        if(permisosUsuario.isLista()){
            limpiar.setEnabled(true);
            eliminar.setEnabled(true);
        }else{
            limpiar.setEnabled(false);
            limpiar.setEnabled(false);
        }
    }
    
    private permisosusuario verificarPermisos(){
        EntityManager em = empleadosDAO.getEntityManager();
        String hqlDetalleProd = "FROM permisosusuario E WHERE E.IDUsuario = :IDUsuario AND E.IDPermiso = :IDPermiso";
        Query queryPermisos = em.createQuery(hqlDetalleProd);
        queryPermisos.setParameter("IDUsuario",singleton.getCuenta().getIdusuario());
        queryPermisos.setParameter("IDPermiso",3);
        permisosusuario permisos = (permisosusuario)queryPermisos.getSingleResult();
        return permisos;
    }
    
     private String ultimoPeriodo()
    {
        EntityManager em = deduccionesDAO.getEntityManager();
        Query query = em.createQuery("FROM deduccionesempleadomensual E where E.numdeduccion = (select max(numdeduccion) from deduccionesempleadomensual)");
        deduccionesempleadomensual deduccion = (deduccionesempleadomensual)query.getSingleResult();
        em.close();

        
        return deduccion.getPeriodo();
    }
    
     private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaDeducciones.getModel();
        modelo.setRowCount(0);
        tablaDeducciones.setModel(modelo);
        List<deduccionesempleadomensual> deduccionesempleadomes = deduccionesDAO.finddeduccionesempleadomensualEntities();
        deduccionesempleadomes.forEach((deduccionActual) -> {
            modelo.addRow(
                    new Object[]{
                        deduccionActual.getNumdeduccion(),
                        deduccionActual.getIDEmpleado(),
                        empleadosDAO.findempleado(deduccionActual.getIDEmpleado()).getNomEmpleado(),
                        tipodeduccionDAO.findtipodeduccion(deduccionActual.getIDTipoDeduccion()).getNombre(),
                        deduccionActual.getValor(),
                        deduccionActual.getPeriodo()
                    }
            );
        });
    }

    private void cargarPeriodosCb()
    {
        if(deduccionesBD.size() > 0)
        {
          List<String> periodosEnBD = new ArrayList<>();
         periodosEnBD.add(deduccionesBD.get(deduccionesBD.size()-1).getPeriodo());
        for(int i = deduccionesBD.size()-1 ; i > 0; i--)
        {
            if(!deduccionesBD.get(i).getPeriodo().equals(deduccionesBD.get(i-1).getPeriodo()))
            {
                periodosEnBD.add(deduccionesBD.get(i-1).getPeriodo());
            }
        }
           for(int i = 0; i < periodosEnBD.size() ; i++)
        {
            cbPeriodos.addItem(periodosEnBD.get(i));
        } 
        }
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        botonCancelar = new javax.swing.JButton();
        jScrollpane = new javax.swing.JScrollPane();
        tablaDeducciones = new javax.swing.JTable();
        nuevaDeduccion = new javax.swing.JButton();
        nuevoTipo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbPeriodos = new javax.swing.JComboBox<>();
        limpiar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        imprimirReporteBonos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        botonCancelar.setBackground(new java.awt.Color(189, 158, 76));
        botonCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonCancelar.setText("CANCELAR");
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCancelarMouseClicked(evt);
            }
        });

        jScrollpane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollpaneMouseClicked(evt);
            }
        });

        tablaDeducciones.setBackground(new java.awt.Color(30, 33, 34));
        tablaDeducciones.setForeground(new java.awt.Color(255, 255, 255));
        tablaDeducciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID deduccion", "ID Empleado", "Nombre Empleado", "Tipo ", "Valor", "Periodo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDeducciones.getTableHeader().setReorderingAllowed(false);
        tablaDeducciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDeduccionesMouseClicked(evt);
            }
        });
        jScrollpane.setViewportView(tablaDeducciones);
        if (tablaDeducciones.getColumnModel().getColumnCount() > 0) {
            tablaDeducciones.getColumnModel().getColumn(0).setResizable(false);
            tablaDeducciones.getColumnModel().getColumn(1).setResizable(false);
            tablaDeducciones.getColumnModel().getColumn(2).setResizable(false);
            tablaDeducciones.getColumnModel().getColumn(3).setResizable(false);
            tablaDeducciones.getColumnModel().getColumn(4).setResizable(false);
            tablaDeducciones.getColumnModel().getColumn(5).setResizable(false);
        }
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaDeducciones.getColumnCount();i++)
        {
            tablaDeducciones.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaDeducciones.setShowGrid(true);
        tablaDeducciones.setGridColor(Color.BLACK);

        nuevaDeduccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevaDeduccion.png"))); // NOI18N
        nuevaDeduccion.setContentAreaFilled(false);
        nuevaDeduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaDeduccionActionPerformed(evt);
            }
        });

        nuevoTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevoTipo.png"))); // NOI18N
        nuevoTipo.setContentAreaFilled(false);
        nuevoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTipoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Deducciones por periodo:");

        cbPeriodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPeriodosActionPerformed(evt);
            }
        });

        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        limpiar.setContentAreaFilled(false);
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        eliminar.setContentAreaFilled(false);
        eliminar.setEnabled(false);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        imprimirReporteBonos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/printIcon.png"))); // NOI18N
        imprimirReporteBonos.setBorderPainted(false);
        imprimirReporteBonos.setContentAreaFilled(false);
        imprimirReporteBonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirReporteBonosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imprimirReporteBonos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevaDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nuevoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCancelar)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbPeriodos))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imprimirReporteBonos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)))
                .addComponent(jScrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nuevoTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nuevaDeduccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTA DE DEDUCCIONES");
        jLabel1.setMaximumSize(new java.awt.Dimension(269, 32));
        jLabel1.setMinimumSize(new java.awt.Dimension(269, 32));
        jLabel1.setPreferredSize(new java.awt.Dimension(269, 32));

        logo.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    private void cargarTablaPeriodo(String periodo)
    {
        empleadoJpaController empleadoDAO = new empleadoJpaController(emf);
        DefaultTableModel modelo = (DefaultTableModel)tablaDeducciones.getModel();
        modelo.setRowCount(0);
        tablaDeducciones.setModel(modelo);
        
        EntityManager em = deduccionesDAO.getEntityManager();
        String hql = "FROM deduccionesempleadomensual E WHERE E.Periodo = :Periodo";
        Query query = em.createQuery(hql);
        query.setParameter("Periodo",periodo);
        List<deduccionesempleadomensual> results = (List<deduccionesempleadomensual>)query.getResultList();
        em.close();
        
        results.forEach((deduccionActual) -> {
            modelo.addRow(
                    new Object[]{
                        deduccionActual.getNumdeduccion(),
                        deduccionActual.getIDEmpleado(),
                        empleadoDAO.findempleado(deduccionActual.getIDEmpleado()).getNomEmpleado(),
                        tipodeduccionDAO.findtipodeduccion(deduccionActual.getIDTipoDeduccion()).getNombre(),
                        deduccionActual.getValor(),
                        deduccionActual.getPeriodo()
                    }
            );
        });
        eliminar.setEnabled(false);
        //empleadoDAO.close();
    }
    
    private void botonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseClicked
        // TODO add your handling code here:
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        emf.close();
        this.setVisible(false);
        this.dispose(); 
        deduccionesDAO.close();
        tipodeduccionDAO.close();
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_botonCancelarMouseClicked

    private void nuevaDeduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaDeduccionActionPerformed
        // TODO add your handling code here:
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevaDeduccion().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        deduccionesDAO.close();
        tipodeduccionDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_nuevaDeduccionActionPerformed

    private void nuevoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTipoActionPerformed
        // TODO add your handling code here:
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tipoDeduccion().setVisible(true);
            }
        });
        deduccionesDAO.close();
        tipodeduccionDAO.close();
        this.dispose();
        }catch(Exception ex){
        log(ex);
        }
        
    }//GEN-LAST:event_nuevoTipoActionPerformed

    private void cbPeriodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPeriodosActionPerformed
        // TODO add your handling code here:
        try{
        cargarTablaPeriodo(cbPeriodos.getSelectedItem().toString());
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_cbPeriodosActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        // TODO add your handling code here:
        try{
        DefaultTableModel modelo = (DefaultTableModel) tablaDeducciones.getModel();
        if(!cbPeriodos.getSelectedItem().toString().equals(periodoActual))
        {
           JOptionPane.showMessageDialog(null,"Esas deducciones pertenecen a otro periodo, solo puedes borrar las deducciones del periodo actual ("+periodoActual+").","Deducciones ya aplicadas.",JOptionPane.ERROR_MESSAGE);
           return;
        }
        int confirmar = JOptionPane.showConfirmDialog(null,"¿Estás seguro que deseas eliminar la deducciones del periodo "+periodoActual+"?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        
        if(confirmar == 0)
        {
        EntityManager em = deduccionesDAO.getEntityManager();
        String hql = "FROM deduccionesempleadomensual E WHERE E.Periodo = :Periodo";
        Query query = em.createQuery(hql);
        query.setParameter("Periodo",cbPeriodos.getSelectedItem().toString());
        List<deduccionesempleadomensual> results = (List<deduccionesempleadomensual>)query.getResultList();
        em.close();
        results.forEach((deduccion) -> {
            try {
                deduccionesDAO.destroy(deduccion.getNumdeduccion());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(listaDeducciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        modelo.setRowCount(0);
        }
        
         if(tablaDeducciones.getRowCount() == 0){
            cbPeriodos.setSelectedIndex(cbPeriodos.getSelectedIndex()+1);
            cbPeriodos.removeItemAt(cbPeriodos.getSelectedIndex()-1);            
        }
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_limpiarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        try{
        DefaultTableModel modelo = (DefaultTableModel) tablaDeducciones.getModel();        
        int confirmacion = JOptionPane.showConfirmDialog(null,"¿Seguro que deseas eliminar esta deducción?","Confirmación",JOptionPane.YES_NO_OPTION);
        if(confirmacion == 0)
            {
                try {
                deduccionesDAO.destroy(Integer.parseInt(modelo.getValueAt(tablaDeducciones.getSelectedRow(),0).toString()));
                JOptionPane.showMessageDialog(null,"Deduccion Eliminada");
                cargarTablaPeriodo(periodoActual);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(listaDeducciones.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_eliminarActionPerformed

    private void tablaDeduccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDeduccionesMouseClicked
        // TODO add your handling code here:
        try{
        if(tablaDeducciones.getSelectedRow() != -1 && cbPeriodos.getSelectedItem().equals(periodoActual))
        {
            if(permisosUsuario.isLista()){
            eliminar.setEnabled(true);
            }
        }else
        {
            eliminar.setEnabled(false);
        }
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_tablaDeduccionesMouseClicked

    private void imprimirReporteBonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirReporteBonosActionPerformed
        // TODO add your handling code here:
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
            log(e);
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        empleado empleadoActual = empleadosDAO.findempleado(singleton.getCuenta().getIDEmpleado());
        HashMap logo = new HashMap();
        logo.put("logo",getClass().getResourceAsStream("/Imagenes/logoBarberia.jpeg"));
        logo.put("usuario",empleadoActual.getNomEmpleado() + " " + empleadoActual.getApeEmpleado());
        logo.put("periodo",cbPeriodos.getSelectedItem().toString());

        try {
            JasperReport reporte = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reportes/reporteDeducciones.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(
                reporte,
                logo,
                conn);

            MyJasperViewer view = new MyJasperViewer(print,false);
            view.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
            view.setTitle("Reporte de Tipos de Pago");
            view.setVisible(true);
        } catch (JRException ex) {
            log(ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_imprimirReporteBonosActionPerformed

    private void jScrollpaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollpaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollpaneMouseClicked

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
            java.util.logging.Logger.getLogger(listaDeducciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listaDeducciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listaDeducciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listaDeducciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaDeducciones().setVisible(true);
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
    private javax.swing.JButton botonCancelar;
    private javax.swing.JComboBox<String> cbPeriodos;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton imprimirReporteBonos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollpane;
    private javax.swing.JButton limpiar;
    private javax.swing.JLabel logo;
    private javax.swing.JButton nuevaDeduccion;
    private javax.swing.JButton nuevoTipo;
    private javax.swing.JTable tablaDeducciones;
    // End of variables declaration//GEN-END:variables
}

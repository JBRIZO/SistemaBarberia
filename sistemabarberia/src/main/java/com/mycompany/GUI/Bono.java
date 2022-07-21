/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.bonosempleadomensualJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.tiposbonoJpaController;
import com.mycompany.sistemabarberia.MyJasperViewer;
import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.bonosempleadomensual;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.permisosusuario;
import com.mycompany.sistemabarberia.tiposbono;
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
 * @author Kesil
 */
public class Bono extends javax.swing.JFrame {

    private permisosusuario permisosUsuario;
    private String periodoActual;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    
    private bonosempleadomensualJpaController bonosDAO = new bonosempleadomensualJpaController(emf);
    private empleadoJpaController empleado = new empleadoJpaController(emf);
    private tiposbonoJpaController tipoBono = new tiposbonoJpaController(emf);
    private ImageIcon imagen;
    private Icon icono;
    private usuarios usuarios = new usuarios(); 
    private UsuarioSingleton singleton = UsuarioSingleton.getUsuario(usuarios);
    private empleadoJpaController empleadosDAO = new empleadoJpaController(emf);
    
     private java.util.Date dt = new java.util.Date();

    /**
     * Creates new form nuevoTipoDescuento
     */
    public Bono() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.insertarImagen(this.logo, "/Imagenes/logoLogin.png");
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
        setIconImage(icon);
       //periodo actual
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dt);
        int anio = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH) + 1;
        periodoActual = mes<10? anio+"0"+mes: Integer.toString(anio)+mes;
         //ocultar column con numero del bono
        TableColumnModel model = tablaBonos.getColumnModel();
        model.removeColumn(model.getColumn(0));
        cargarTabla();
        cargarPeriodosCb();
        
        if(bonosDAO.getbonosempleadomensualCount() >0)
        {
           if(!periodoActual.equals(ultimoPeriodo()))
        {
            JOptionPane.showMessageDialog(this,"No has otorgado bonos este periodo.");
        }  
        }   
        permisosUsuario = verificarPermisos();
        btnNuevoBono.setEnabled(permisosUsuario.isNuevo());
        btnNuevoTipo.setEnabled(permisosUsuario.isModificar());
        limpiar.setEnabled(permisosUsuario.isLista());
        imprimirReporteBonos.setEnabled(permisosUsuario.isImprimir());
    }
    
    private permisosusuario verificarPermisos(){
        EntityManager em = bonosDAO.getEntityManager();
        String hqlDetalleProd = "FROM permisosusuario E WHERE E.IDUsuario = :IDUsuario AND E.IDPermiso = :IDPermiso";
        Query queryPermisos = em.createQuery(hqlDetalleProd);
        queryPermisos.setParameter("IDUsuario",singleton.getCuenta().getIdusuario());
        queryPermisos.setParameter("IDPermiso",2);
        permisosusuario permisos = (permisosusuario)queryPermisos.getSingleResult();
        return permisos;
    }
    
    public String ultimoPeriodo()
    {
        EntityManager em = bonosDAO.getEntityManager();
        Query query = em.createQuery("FROM bonosempleadomensual E where E.numbono = (select max(numbono) from bonosempleadomensual)");
        bonosempleadomensual bono = (bonosempleadomensual)query.getSingleResult();
        em.close();
        return bono.getPeriodo();
    }
    private void cargarPeriodosCb()
    {
        List<bonosempleadomensual> bonosBD = bonosDAO.findbonosempleadomensualEntities();
        
        if(bonosBD.size() > 0)
        {
          List<String> periodosEnBD = new ArrayList<>();
         periodosEnBD.add(bonosBD.get(bonosBD.size()-1).getPeriodo());
        for(int i = bonosBD.size()-1 ; i > 0; i--)
        {
            if(!bonosBD.get(i).getPeriodo().equals(bonosBD.get(i-1).getPeriodo()))
            {
                periodosEnBD.add(bonosBD.get(i-1).getPeriodo());
            }
        }
           for(int i = 0; i < periodosEnBD.size() ; i++)
        {
            cbPeriodos.addItem(periodosEnBD.get(i));
        } 
        }
    }

    List<empleado> empleadoBono = empleado.findempleadoEntities();
    List<tiposbono> bonoTipo = tipoBono.findtiposbonoEntities();
    
      private void cargarTablaPeriodo(String periodo)
    {
        DefaultTableModel modelo = (DefaultTableModel)tablaBonos.getModel();
        modelo.setRowCount(0);
        tablaBonos.setModel(modelo);
        
        EntityManager em = bonosDAO.getEntityManager();
        String hql = "FROM bonosempleadomensual E WHERE E.Periodo = :Periodo";
        Query query = em.createQuery(hql);
        query.setParameter("Periodo",periodo);
        List<bonosempleadomensual> results = (List<bonosempleadomensual>)query.getResultList();
        em.close();
        

        results.forEach((bonoActual) -> {
            modelo.addRow(
                    new Object[]{
                        bonoActual.getNumbono(),
                        bonoActual.getIdEmpleado(),
                        empleado.findempleado(bonoActual.getIdEmpleado()).getNomEmpleado(),
                        tipoBono.findtiposbono(bonoActual.getIDTipoBono()).getNomBono(),
                        bonoActual.getValor(),
                        bonoActual.getPeriodo()
                    }
            );
                });
         eliminar.setEnabled(false);
    }
      
      private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaBonos.getModel();
        modelo.setRowCount(0);
        tablaBonos.setModel(modelo);
        List<bonosempleadomensual> bonosempleadomensual = bonosDAO.findbonosempleadomensualEntities();
        bonosempleadomensual.forEach((bonoActual) -> {
            modelo.addRow(
                    new Object[]{
                        bonoActual.getNumbono(),
                        bonoActual.getIdEmpleado(),
                        empleado.findempleado(bonoActual.getIdEmpleado()).getNomEmpleado(),
                        tipoBono.findtiposbono(bonoActual.getIDTipoBono()).getNomBono(),
                        bonoActual.getValor(),
                        bonoActual.getPeriodo()
                        
                    }
            );
        });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBonos = new javax.swing.JTable();
        btnNuevoTipo = new javax.swing.JButton();
        btnNuevoBono = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbPeriodos = new javax.swing.JComboBox<>();
        limpiar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        imprimirReporteBonos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("BONOS");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaBonos.setAutoCreateRowSorter(true);
        tablaBonos.setBackground(new java.awt.Color(30, 33, 34));
        tablaBonos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaBonos.setForeground(new java.awt.Color(255, 255, 255));
        tablaBonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num Bono", "ID Empleado", "Niombre Empleado", "Tipo Bono", "Valor", "Periodo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBonos.setGridColor(new java.awt.Color(255, 255, 255));
        tablaBonos.setRowHeight(32);
        tablaBonos.getTableHeader().setReorderingAllowed(false);
        tablaBonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBonosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBonos);
        if (tablaBonos.getColumnModel().getColumnCount() > 0) {
            tablaBonos.getColumnModel().getColumn(0).setResizable(false);
            tablaBonos.getColumnModel().getColumn(1).setResizable(false);
            tablaBonos.getColumnModel().getColumn(2).setResizable(false);
            tablaBonos.getColumnModel().getColumn(3).setResizable(false);
            tablaBonos.getColumnModel().getColumn(4).setResizable(false);
            tablaBonos.getColumnModel().getColumn(5).setResizable(false);
        }
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaBonos.getColumnCount();i++)
        {
            tablaBonos.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaBonos.setShowGrid(true);
        tablaBonos.setGridColor(Color.BLACK);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 287));

        btnNuevoTipo.setBackground(new java.awt.Color(30, 33, 34));
        btnNuevoTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevoTipo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NuevoTipo.png"))); // NOI18N
        btnNuevoTipo.setBorder(null);
        btnNuevoTipo.setContentAreaFilled(false);
        btnNuevoTipo.setRequestFocusEnabled(false);
        btnNuevoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoTipoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, -1, -1));

        btnNuevoBono.setBackground(new java.awt.Color(30, 33, 34));
        btnNuevoBono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevoBono.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoBono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NuevoBono.png"))); // NOI18N
        btnNuevoBono.setBorder(null);
        btnNuevoBono.setContentAreaFilled(false);
        btnNuevoBono.setRequestFocusEnabled(false);
        btnNuevoBono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoBonoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevoBono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        Aceptar.setBackground(new java.awt.Color(189, 158, 76));
        Aceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Aceptar.setText("CANCELAR");
        Aceptar.setRequestFocusEnabled(false);
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        jPanel3.add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 110, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bonos por periodo:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        cbPeriodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPeriodosActionPerformed(evt);
            }
        });
        jPanel3.add(cbPeriodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 130, 35));

        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        limpiar.setContentAreaFilled(false);
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        jPanel3.add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 160, 40));

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        eliminar.setContentAreaFilled(false);
        eliminar.setEnabled(false);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel3.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 30, 40));

        imprimirReporteBonos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/printIcon.png"))); // NOI18N
        imprimirReporteBonos.setBorderPainted(false);
        imprimirReporteBonos.setContentAreaFilled(false);
        imprimirReporteBonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirReporteBonosActionPerformed(evt);
            }
        });
        jPanel3.add(imprimirReporteBonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280)
                        .addComponent(tituloPantalla))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloPantalla))
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaBonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBonosMouseClicked
        // TODO add your handling code here:
        try{
        if(tablaBonos.getSelectedRow() != -1 && cbPeriodos.getSelectedItem().equals(periodoActual))
        {
            if(limpiar.isEnabled()){
            eliminar.setEnabled(true);
            }
        }else
        {
            eliminar.setEnabled(false);
        }
        }catch(Exception ex){
            log(ex);
            
        }
         
    }//GEN-LAST:event_tablaBonosMouseClicked

    private void btnNuevoBonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoBonoActionPerformed
        try{
            NuevoBono nv = new NuevoBono();
            nv.setVisible(true);
            this.dispose();
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_btnNuevoBonoActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
       try{
           menuGerente menu = new menuGerente();
        menu.setVisible(true);
        emf.close();
        this.dispose();
       }catch(Exception ex){
           log(ex);
       }
        
    }//GEN-LAST:event_AceptarActionPerformed

    private void btnNuevoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoTipoActionPerformed
        try{
            nuevoTipoBono ntb = new nuevoTipoBono();
            ntb.setVisible(true);
            this.dispose();
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_btnNuevoTipoActionPerformed

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
            DefaultTableModel modelo = (DefaultTableModel) tablaBonos.getModel();
        if(!cbPeriodos.getSelectedItem().toString().equals(periodoActual))
        {
            JOptionPane.showMessageDialog(null,"Esos bonos pertenecen a otro periodo, solo puedes borrar los bonos del periodo actual ("+periodoActual+").","Bonos ya aplicados.",JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirmar = JOptionPane.showConfirmDialog(null,"¿Estás seguro que deseas eliminar todos los bonos del periodo "+periodoActual+"?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION);

        if(confirmar == 0)
        {
            EntityManager em = bonosDAO.getEntityManager();
            String hql = "FROM bonosempleadomensual E WHERE E.Periodo = :Periodo";
            Query query = em.createQuery(hql);
            query.setParameter("Periodo",cbPeriodos.getSelectedItem().toString());
            List<bonosempleadomensual> results = (List<bonosempleadomensual>)query.getResultList();
            em.close();
            results.forEach((bonos) -> {
                try {
                    bonosDAO.destroy(bonos.getNumbono());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(listaDeducciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            modelo.setRowCount(0);
        }
        
        if(tablaBonos.getRowCount() == 0){
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
        DefaultTableModel modelo = (DefaultTableModel) tablaBonos.getModel();
        int confirmacion = JOptionPane.showConfirmDialog(null,"¿Seguro que deseas eliminar este bono?","Confirmación",JOptionPane.YES_NO_OPTION);
        if(confirmacion == 0)
        {
            try {
                bonosDAO.destroy(Integer.parseInt(modelo.getValueAt(tablaBonos.getSelectedRow(),0).toString()));
                JOptionPane.showMessageDialog(null,"Bono Eliminado.");
                cargarTablaPeriodo(periodoActual);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(listaDeducciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_eliminarActionPerformed

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
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        empleado empleadoActual = empleadosDAO.findempleado(singleton.getCuenta().getIDEmpleado());
        HashMap logo = new HashMap();
        logo.put("logo",getClass().getResourceAsStream("/Imagenes/logoBarberia.jpeg"));
        logo.put("usuario",empleadoActual.getNomEmpleado() + " " + empleadoActual.getApeEmpleado());
        logo.put("periodo",cbPeriodos.getSelectedItem().toString());

        try {
            JasperReport reporte = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reportes/reporteBonos.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(
                reporte,
                logo,
                conn);

            MyJasperViewer view = new MyJasperViewer(print,false);
            view.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
            view.setTitle("Reporte de Tipos de Pago");
            view.setVisible(true);
        } catch (Exception ex) {
            log(ex);
        }
    }//GEN-LAST:event_imprimirReporteBonosActionPerformed

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
            java.util.logging.Logger.getLogger(Bono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bono().setVisible(true);
            }
        });

    }

    private void insertarImagen(JLabel lbl, String ruta) {
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
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton btnNuevoBono;
    private javax.swing.JButton btnNuevoTipo;
    private javax.swing.JComboBox<String> cbPeriodos;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton imprimirReporteBonos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tablaBonos;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

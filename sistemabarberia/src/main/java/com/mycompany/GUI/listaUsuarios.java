/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.usuariosJpaController;
import com.mycompany.sistemabarberia.MyJasperViewer;
import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.permisosusuario;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRSaveContributor;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kesil
 */
public class listaUsuarios extends javax.swing.JFrame {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    
    private permisosusuario permisosUsuario;
    
    private empleadoJpaController empleadoDAO = new empleadoJpaController(emf);
    private usuariosJpaController usuarioDAO =  new usuariosJpaController(emf);
    private empleadoJpaController empleadosDAO = new empleadoJpaController(emf);
    private ImageIcon imagen;
    private Icon icono;
    private usuarios usuarios = new usuarios(); 
    private UsuarioSingleton singleton = UsuarioSingleton.getUsuario(usuarios);

    /**
     * Creates new form nuevoTipoDescuento
     */
    public listaUsuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
        setIconImage(icon);
        this.insertarImagen(this.logo,"/Imagenes/logoBarberia.png");
        this.insertarImagen(this.activar,"/Imagenes/desactivar.png");
        cargarTabla();
        for(int i = 0; i < tablaUsuarios.getColumnCount()-2;i++)
        {
            cbParametros.addItem(tablaUsuarios.getColumnName(i));
        }
        modificarUsuario.setEnabled(false);
        permisosUsuario = verificarPermisos();
        desactivarBotonesPermisos();
    }
    
    private void desactivarBotonesPermisos(){
        if(permisosUsuario.isDesactivar()){
            activar.setEnabled(true);
        }else{
            activar.setEnabled(false);
        }
        if(permisosUsuario.isImprimir()){
            imprimirReporte.setEnabled(true);
        }else{
            imprimirReporte.setEnabled(false);
        }
        if(permisosUsuario.isModificar()){
            modificarUsuario.setEnabled(true);
        }else{
            modificarUsuario.setEnabled(false);
        }
        if(permisosUsuario.isNuevo()){
            nuevoUsuario.setEnabled(true);
        }else{
            nuevoUsuario.setEnabled(false);
        }
    }
    
    private permisosusuario verificarPermisos(){
        EntityManager em = empleadosDAO.getEntityManager();
        String hqlDetalleProd = "FROM permisosusuario E WHERE E.IDUsuario = :IDUsuario AND E.IDPermiso = :IDPermiso";
        Query queryPermisos = em.createQuery(hqlDetalleProd);
        queryPermisos.setParameter("IDUsuario",singleton.getCuenta().getIdusuario());
        queryPermisos.setParameter("IDPermiso",9);
        permisosusuario permisos = (permisosusuario)queryPermisos.getSingleResult();
        return permisos;
    }
    
    private void cargarTabla()
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaUsuarios.getModel();
        modelo.setRowCount(0);
        tablaUsuarios.setModel(modelo);
        List<usuarios> usuarios = usuarioDAO.findusuariosEntities();
            for(usuarios usuario : usuarios){
                if(usuario.getActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        usuario.getIdusuario(),
                        empleadoDAO.findempleado(usuario.getIDEmpleado()).getNomEmpleado(),
                        usuario.getNomCuenta(),
                        usuario.getContrasena(),
                        activo
                    }
                );
            } 
    }
    
     private void cargarTablaIdUsuario(int IdUsuario)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaUsuarios.getModel();
        modelo.setRowCount(0);
        tablaUsuarios.setModel(modelo);
        List<usuarios> usuarios = usuarioDAO.findusuariosEntities();
        List<usuarios> usuariosFiltrados = new ArrayList();
        
        for(int i = 0; i < usuarios.size();i++)
        {
            if(usuarios.get(i).getIdusuario() == IdUsuario)
            {
                usuariosFiltrados.add(usuarios.get(i));
            }
        }
        
        if(usuariosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"No se encontraron usuarios con ese Id.","ID inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(usuarios usuario : usuariosFiltrados){
                if(usuario.getActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        usuario.getIdusuario(),
                        empleadoDAO.findempleado(usuario.getIDEmpleado()).getNomEmpleado(),
                        usuario.getNomCuenta(),
                        usuario.getContrasena(),
                        activo
                    }
                );
            } 
    }
     
     private void cargarTablaIDEmpleado(String IdEmpleado)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaUsuarios.getModel();
        modelo.setRowCount(0);
        tablaUsuarios.setModel(modelo);
        List<usuarios> usuarios = usuarioDAO.findusuariosEntities();
        List<usuarios> usuariosFiltrados = new ArrayList();
        
        for(int i = 0; i < usuarios.size();i++)
        {
            if(empleadoDAO.findempleado(usuarios.get(i).getIDEmpleado()).getNomEmpleado().equalsIgnoreCase(IdEmpleado))
            {
                usuariosFiltrados.add(usuarios.get(i));
            }
        }
         if(usuariosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"No se encontraron usarios con ese nombre de empleado.","Empleado inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(usuarios usuario : usuariosFiltrados){
                if(usuario.getActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        usuario.getIdusuario(),
                        empleadoDAO.findempleado(usuario.getIDEmpleado()).getNomEmpleado(),
                        usuario.getNomCuenta(),
                        usuario.getContrasena(),
                        activo
                    }
                );
            } 
    }
     
     private void cargarTablaUsuario(String nomUsuario)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaUsuarios.getModel();
        modelo.setRowCount(0);
        tablaUsuarios.setModel(modelo);
        List<usuarios> usuarios = usuarioDAO.findusuariosEntities();
        List<usuarios> usuariosFiltrados = new ArrayList();
        
        for(int i = 0; i < usuarios.size();i++)
        {
            if(usuarios.get(i).getNomCuenta().equals(nomUsuario))
            {
                usuariosFiltrados.add(usuarios.get(i));
            }
        }
        
        if(usuariosFiltrados.isEmpty())
        {
        JOptionPane.showMessageDialog(this,"No se un usuario con ese nombre de usuario.","Nombre de usuario inexistente",JOptionPane.ERROR_MESSAGE);
        return;
        }
            for(usuarios usuario : usuariosFiltrados){
                if(usuario.getActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        usuario.getIdusuario(),
                        empleadoDAO.findempleado(usuario.getIDEmpleado()).getNomEmpleado(),
                        usuario.getNomCuenta(),
                        usuario.getContrasena(),
                        activo
                    }
                );
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
        tituloPantalla = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        activar = new javax.swing.JButton();
        nuevoUsuario = new javax.swing.JButton();
        modificarUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbParametros = new javax.swing.JComboBox<>();
        buscarTxt = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        recargar = new javax.swing.JButton();
        imprimirReporte = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 48)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("USUARIOS");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        tablaUsuarios.setAutoCreateRowSorter(true);
        tablaUsuarios.setBackground(new java.awt.Color(30, 33, 34));
        tablaUsuarios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Usuario", "Empleado", "Usuario", "Contraseña", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuarios.setGridColor(new java.awt.Color(255, 255, 255));
        tablaUsuarios.setRowHeight(32);
        tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaUsuarios.getColumnCount();i++)
        {
            tablaUsuarios.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaUsuarios.setShowGrid(true);
        tablaUsuarios.setGridColor(Color.BLACK);

        activar.setBorderPainted(false);
        activar.setContentAreaFilled(false);
        activar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activarMouseClicked(evt);
            }
        });
        activar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activarActionPerformed(evt);
            }
        });

        nuevoUsuario.setBackground(new java.awt.Color(30, 33, 34));
        nuevoUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nuevoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevoUsuario.png"))); // NOI18N
        nuevoUsuario.setBorder(null);
        nuevoUsuario.setContentAreaFilled(false);
        nuevoUsuario.setRequestFocusEnabled(false);
        nuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoUsuarioActionPerformed(evt);
            }
        });

        modificarUsuario.setBackground(new java.awt.Color(30, 33, 34));
        modificarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modificarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        modificarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificarUsuario.png"))); // NOI18N
        modificarUsuario.setBorder(null);
        modificarUsuario.setContentAreaFilled(false);
        modificarUsuario.setRequestFocusEnabled(false);
        modificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Por:");

        buscarTxt.setBackground(new java.awt.Color(30, 33, 34));
        buscarTxt.setForeground(new java.awt.Color(255, 255, 255));
        buscarTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        buscarTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscarTxtFocusGained(evt);
            }
        });

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        botonBuscar.setBorderPainted(false);
        botonBuscar.setContentAreaFilled(false);
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        recargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recargar.png"))); // NOI18N
        recargar.setContentAreaFilled(false);
        recargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargarActionPerformed(evt);
            }
        });

        imprimirReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimirReporte.png"))); // NOI18N
        imprimirReporte.setBorderPainted(false);
        imprimirReporte.setContentAreaFilled(false);
        imprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recargar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscarTxt)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(recargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nuevoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imprimirReporte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        botonRegresar.setBackground(new java.awt.Color(189, 158, 76));
        botonRegresar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonRegresar.setText("REGRESAR");
        botonRegresar.setRequestFocusEnabled(false);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(349, 349, 349)
                        .addComponent(tituloPantalla)
                        .addGap(250, 250, 250)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tituloPantalla)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(79, 79, 79))
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
    }// </editor-fold>//GEN-END:initComponents

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        // TODO add your handling code here:
        try{
        if(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),4).equals("Sí"))
        {
            this.insertarImagen(this.activar,"/Imagenes/desactivar.png");
            if(permisosUsuario.isModificar()){
                modificarUsuario.setEnabled(true);
            }
        }else
        {
            this.insertarImagen(this.activar,"/Imagenes/activar.png");
            if(permisosUsuario.isModificar()){
                modificarUsuario.setEnabled(false);
            }
        }
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void activarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_activarMouseClicked

    private void nuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoUsuarioActionPerformed
        // TODO add your handling code here:
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoUsuario().setVisible(true);
            }
        });
        emf.close();
        this.setVisible(false);
        this.dispose(); 
        usuarioDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_nuevoUsuarioActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        emf.close();
        this.dispose();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void modificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarUsuarioActionPerformed
        // TODO add your handling code here:
        try{
            if(tablaUsuarios.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(this,"Debes seleccionar un usuario para poder modificarlo.","Selecciona un empleado",JOptionPane.ERROR_MESSAGE);
            return;
        }
        usuarios usuario = usuarioDAO.findusuarios(Integer.parseInt(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),0).toString()));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoUsuario(usuario).setVisible(true);
            }
        });
        emf.close();
        this.setVisible(false);
        this.dispose(); 
        usuarioDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_modificarUsuarioActionPerformed

    private void buscarTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarTxtFocusGained
        // TODO add your handling code here:
        buscarTxt.selectAll();
    }//GEN-LAST:event_buscarTxtFocusGained

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        try{
        if(buscarTxt.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Debes ingresar un " + cbParametros.getSelectedItem().toString() + ".","Campo vacío",JOptionPane.ERROR_MESSAGE);
            return;
        }
        switch(cbParametros.getSelectedItem().toString())
        {
            case "ID Usuario":
                try{
                    cargarTablaIdUsuario(Integer.parseInt(buscarTxt.getText()));
                }catch(NumberFormatException Ex)
                {
                    JOptionPane.showMessageDialog(this,"El id debe ser un número entero.","ID inválido",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            return;
            case "Empleado":
            cargarTablaIDEmpleado(buscarTxt.getText()); 
            return;
            case "Usuario":
            cargarTablaUsuario(buscarTxt.getText());
        }
        }catch(Exception ex){
            log(ex);
        }
         
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void recargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarActionPerformed
        // TODO add your handling code here:
        try{
        cargarTabla();
        buscarTxt.setText("");
        modificarUsuario.setEnabled(false);
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_recargarActionPerformed

    private void activarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarActionPerformed
        // TODO add your handling code here:
        try{
        //Si el empleado esta desactivado no puede activarse su usuario.
        if(tablaUsuarios.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(this,"Debes seleccionar un usuario para desactivarlo","Selecciona un usuario",JOptionPane.ERROR_MESSAGE);
            return;
        }
        empleadoJpaController empleadoDAO = new empleadoJpaController(emf);
        
        usuarios modificar = new usuarios();
        List<usuarios> usuarios = usuarioDAO.findusuariosEntities();
        for(int i=0 ; i<usuarios.size();i++)
        {
            if(Integer.parseInt(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),0).toString()) == usuarios.get(i).getIdusuario())
            {
                modificar = usuarios.get(i);
            }
        }
        
        empleado empleado = empleadoDAO.findempleado(modificar.getIDEmpleado());
        
        if(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),4).equals("Sí"))
        {
           modificar.setActivo(false);
           this.insertarImagen(this.activar,"/Imagenes/activar.png");
           try
           {
               usuarioDAO.edit(modificar);
           }catch(Exception Ex)
           {log(Ex);}  
        }else
         {
             if(!empleado.isActivo())
             {
                 JOptionPane.showMessageDialog(null,"El empleado propietario de este usuario ha sido desactivado, \n"
                         + "debes activarlo para poder activar este usuario.","Empleado Desactivado",JOptionPane.ERROR_MESSAGE);
                 return;
             }
            modificar.setIntentos(0);
            modificar.setActivo(true);
            this.insertarImagen(this.activar,"/Imagenes/desactivar.png");  
            try
           {
               usuarioDAO.edit(modificar);
           }catch(Exception Ex)
           {log(Ex);}  
        }
        cargarTabla();
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_activarActionPerformed

    private void imprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirReporteActionPerformed
        // TODO add your handling code here:
        try{
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            log(e);
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

        try {
            JasperReport reporte = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reportes/reporteUsuarios.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(
                reporte,
                logo,
                conn);

            MyJasperViewer view = new MyJasperViewer(print,false);
            view.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
            view.setTitle("Reporte de Usuarios");
            view.setVisible(true);
            
        } catch (JRException ex) {
            log(ex);
            ex.printStackTrace();
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_imprimirReporteActionPerformed

    
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
            java.util.logging.Logger.getLogger(listaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaUsuarios().setVisible(true);
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
    private void insertarImagen(JButton checkBox,String ruta)
    {
        this.imagen = new ImageIcon(getClass().getResource(ruta));
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        checkBox.getWidth(), 
                        checkBox.getHeight(),
                        Image.SCALE_DEFAULT)
        );
        checkBox.setIcon(this.icono);
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
    private javax.swing.JButton activar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JComboBox<String> cbParametros;
    private javax.swing.JButton imprimirReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton modificarUsuario;
    private javax.swing.JButton nuevoUsuario;
    private javax.swing.JButton recargar;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

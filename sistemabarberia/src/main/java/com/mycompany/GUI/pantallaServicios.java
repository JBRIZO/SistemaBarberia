/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.precioshistoricoserviciosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.serviciosJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.permisosusuario;
import com.mycompany.sistemabarberia.precioshistoricoservicios;
import com.mycompany.sistemabarberia.servicios;
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
import java.util.Arrays;
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
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Kesil
 */
public class pantallaServicios extends javax.swing.JFrame {
    
    private permisosusuario permisosUsuario;
    private servicios servicioSeleccionado;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private usuarios usuarios = new usuarios(); 
    private UsuarioSingleton singleton = UsuarioSingleton.getUsuario(usuarios);
    
    private Validaciones validar = new Validaciones();
    private serviciosJpaController serviciosDAO =  new serviciosJpaController(emf);
    private empleadoJpaController empleadoDAO = new empleadoJpaController(emf);
    private List<servicios> serviciosBD = serviciosDAO.findserviciosEntities();
    private precioshistoricoserviciosJpaController preciosDAO= new precioshistoricoserviciosJpaController(emf);
    List<precioshistoricoservicios> preciosBD = preciosDAO.findprecioshistoricoserviciosEntities();
    private ImageIcon imagen;
    private Icon icono;
    private java.util.Date dt = new java.util.Date();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
    String currentTime = sdf.format(dt);

    /**
     * Creates new form nuevoTipoDescuento
     */
    public pantallaServicios() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
        setIconImage(icon);
        this.insertarImagen(this.logo,"/Imagenes/logoBarberia.png");
        this.insertarImagen(this.activar,"/Imagenes/desactivar.png");
        fechaLabel.setText("Fecha: " + currentTime);
        cargarTabla();
        for(int i = 0; i < tablaServicios.getColumnCount()-1 ; i++)
        {
            cbParametros.addItem(tablaServicios.getColumnName(i));
        }  
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
        
        if(permisosUsuario.isLista()){
            listaPreciosServicios.setEnabled(true);
        }else{
            listaPreciosServicios.setEnabled(false);
        }
        
        if(permisosUsuario.isModificar()){
            modificarServicio.setEnabled(true);
        }else{
            modificarServicio.setEnabled(false);
        }
        
        if(permisosUsuario.isNuevo()){
            nuevoServicio.setEnabled(true);
        }else{
            nuevoServicio.setEnabled(false);
        }
    }
    
    private permisosusuario verificarPermisos(){
        EntityManager em = empleadoDAO.getEntityManager();
        String hqlDetalleProd = "FROM permisosusuario E WHERE E.IDUsuario = :IDUsuario AND E.IDPermiso = :IDPermiso";
        Query queryPermisos = em.createQuery(hqlDetalleProd);
        queryPermisos.setParameter("IDUsuario",singleton.getCuenta().getIdusuario());
        queryPermisos.setParameter("IDPermiso",6);
        permisosusuario permisos = (permisosusuario)queryPermisos.getSingleResult();
        return permisos;
    }
    
    private void cargarTabla()
    {
        double precioActual = 0;
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaServicios.getModel();
        modelo.setRowCount(0);
        tablaServicios.setModel(modelo);
        List<servicios> serviciosEnBd = serviciosDAO.findserviciosEntities();
            for(servicios servicio : serviciosEnBd){
                for(int i = 0; i < preciosBD.size() ; i++)
                    {
                        //precio actual del servicio
                        if(preciosBD.get(i).getIDServicio() == servicio.getIdservicio() && preciosBD.get(i).isActivo())
                        {
                            precioActual = preciosBD.get(i).getPrecio();
                        }
                    }
                if(servicio.isActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        servicio.getIdservicio(),
                        servicio.getNomServicio(),
                        precioActual,
                        activo
                    }
                );
            } 
    }
    
    private void cargarTablaBusquedaId(int IDProducto)
    {
        double precioActual = 0;
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaServicios.getModel();
        modelo.setRowCount(0);
        tablaServicios.setModel(modelo);
        List<servicios> serviciosEnBd = serviciosDAO.findserviciosEntities();
        List<servicios> serviciosFiltrados = new ArrayList();
        
        for(int i = 0; i < serviciosEnBd.size();i++)
        {
            if(serviciosEnBd.get(i).getIdservicio() == IDProducto)
            {
                serviciosFiltrados.add(serviciosEnBd.get(i));
            }
        }
        if(serviciosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"No se encontraron servicios con Id de Servicio '" + buscarTxt.getText() + "'","Error de búsqueda",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(servicios servicio : serviciosFiltrados){
                for(int i = 0; i < preciosBD.size() ; i++)
                    {
                        //precio actual del producto
                        if(preciosBD.get(i).getIDServicio() == servicio.getIdservicio() && preciosBD.get(i).isActivo())
                        {
                            precioActual = preciosBD.get(i).getPrecio();
                        }
                    }
                if(servicio.isActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        servicio.getIdservicio(),
                        servicio.getNomServicio(),
                        precioActual,
                        activo
                    }
                );
            }    
    }
    
    private void cargarTablaBusquedaNombre(String Nombre)
    {
        double precioActual = 0;
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaServicios.getModel();
        modelo.setRowCount(0);
        tablaServicios.setModel(modelo);
        List<servicios> serviciosEnBd = serviciosDAO.findserviciosEntities();
        List<servicios> serviciosFiltrados = new ArrayList();
        
        
        
        for(int i = 0; i < serviciosEnBd.size();i++)
        {
            if(serviciosEnBd.get(i).getNomServicio().equalsIgnoreCase(Nombre))
            {
                serviciosFiltrados.add(serviciosEnBd.get(i));
            }
        }
         if(serviciosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"No se encontraron servicios con el Nombre '" + buscarTxt.getText() + "'","Error de búsqueda",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(servicios servicio : serviciosFiltrados){
                for(int i = 0; i < preciosBD.size() ; i++)
                    {
                        //precio actual del servicio
                        if(preciosBD.get(i).getIDServicio() == servicio.getIdservicio() && preciosBD.get(i).isActivo())
                        {
                            precioActual = preciosBD.get(i).getPrecio();
                        }
                    }
                if(servicio.isActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        servicio.getIdservicio(),
                        servicio.getNomServicio(),
                        precioActual,
                        activo
                    }
                );
            }    
    }
    
    private void cargarTablaBusquedaPrecio(double Precio)
    {
        double precioActual = 0;
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaServicios.getModel();
        modelo.setRowCount(0);
        tablaServicios.setModel(modelo);
        List<servicios> serviciosEnBd = serviciosDAO.findserviciosEntities();
        List<servicios> serviciosFiltrados = new ArrayList();
        List<precioshistoricoservicios> preciosFiltrados = new ArrayList();
        
        for(int i = 0 ; i < preciosBD.size() ; i++)
        {
            if(preciosBD.get(i).isActivo())
            {
                preciosFiltrados.add(preciosBD.get(i));
            }
        }     
        
        for(int i = 0; i < serviciosEnBd.size() ; i++)
        {
            for(int j = 0 ; j < preciosFiltrados.size(); j++)
            {
                if(serviciosEnBd.get(i).getIdservicio() == preciosFiltrados.get(j).getIDServicio() && preciosFiltrados.get(j).getPrecio() == Precio)
                {
                    serviciosFiltrados.add(serviciosEnBd.get(i));
                }
            }
        }
        
         if(serviciosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"No se encontraron servicios con un precio de '" + buscarTxt.getText() + "'","Error de búsqueda",JOptionPane.ERROR_MESSAGE);
            return;
        }
         
        
            for(servicios servicio : serviciosFiltrados){
                for(int i = 0; i < preciosBD.size() ; i++)
                    {
                        //precio actual del servicio
                        if(preciosBD.get(i).getIDServicio() == servicio.getIdservicio() && preciosBD.get(i).isActivo())
                        {
                            precioActual = preciosBD.get(i).getPrecio();
                        }
                    }
                if(servicio.isActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        servicio.getIdservicio(),
                        servicio.getNomServicio(),
                        precioActual,
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
        tablaServicios = new javax.swing.JTable();
        activar = new javax.swing.JButton();
        nuevoServicio = new javax.swing.JButton();
        modificarServicio = new javax.swing.JButton();
        listaPreciosServicios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbParametros = new javax.swing.JComboBox<>();
        buscarTxt = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        imprimirReporte = new javax.swing.JButton();
        recargar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        fechaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 48)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("SERVICIOS");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        tablaServicios.setAutoCreateRowSorter(true);
        tablaServicios.setBackground(new java.awt.Color(30, 33, 34));
        tablaServicios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaServicios.setForeground(new java.awt.Color(255, 255, 255));
        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Servicio", "Nombre", "Precio Actual", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaServicios.setGridColor(new java.awt.Color(255, 255, 255));
        tablaServicios.setRowHeight(32);
        tablaServicios.getTableHeader().setReorderingAllowed(false);
        tablaServicios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaServiciosFocusGained(evt);
            }
        });
        tablaServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaServiciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaServicios);
        if (tablaServicios.getColumnModel().getColumnCount() > 0) {
            tablaServicios.getColumnModel().getColumn(0).setResizable(false);
            tablaServicios.getColumnModel().getColumn(1).setResizable(false);
            tablaServicios.getColumnModel().getColumn(2).setResizable(false);
            tablaServicios.getColumnModel().getColumn(3).setResizable(false);
        }
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaServicios.getColumnCount();i++)
        {
            tablaServicios.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaServicios.setShowGrid(true);
        tablaServicios.setGridColor(Color.BLACK);

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

        nuevoServicio.setBackground(new java.awt.Color(30, 33, 34));
        nuevoServicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nuevoServicio.setForeground(new java.awt.Color(255, 255, 255));
        nuevoServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevoServicio.png"))); // NOI18N
        nuevoServicio.setBorder(null);
        nuevoServicio.setContentAreaFilled(false);
        nuevoServicio.setRequestFocusEnabled(false);
        nuevoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoServicioActionPerformed(evt);
            }
        });

        modificarServicio.setBackground(new java.awt.Color(30, 33, 34));
        modificarServicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modificarServicio.setForeground(new java.awt.Color(255, 255, 255));
        modificarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificarServicio.png"))); // NOI18N
        modificarServicio.setBorder(null);
        modificarServicio.setContentAreaFilled(false);
        modificarServicio.setRequestFocusEnabled(false);
        modificarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarServicioActionPerformed(evt);
            }
        });

        listaPreciosServicios.setBackground(new java.awt.Color(30, 33, 34));
        listaPreciosServicios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listaPreciosServicios.setForeground(new java.awt.Color(255, 255, 255));
        listaPreciosServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/preciosProducto.png"))); // NOI18N
        listaPreciosServicios.setBorder(null);
        listaPreciosServicios.setContentAreaFilled(false);
        listaPreciosServicios.setRequestFocusEnabled(false);
        listaPreciosServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaPreciosServiciosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar por:");

        buscarTxt.setBackground(new java.awt.Color(30, 33, 34));
        buscarTxt.setDocument(new JTextFieldLimit(25));
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

        imprimirReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimirReporte.png"))); // NOI18N
        imprimirReporte.setBorderPainted(false);
        imprimirReporte.setContentAreaFilled(false);
        imprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirReporteActionPerformed(evt);
            }
        });

        recargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recargar.png"))); // NOI18N
        recargar.setContentAreaFilled(false);
        recargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevoServicio)
                        .addGap(70, 70, 70)
                        .addComponent(modificarServicio)
                        .addGap(75, 75, 75)
                        .addComponent(listaPreciosServicios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(recargar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botonBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buscarTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(recargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevoServicio)
                    .addComponent(modificarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listaPreciosServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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
                .addContainerGap(22, Short.MAX_VALUE))
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

        fechaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaLabel.setForeground(new java.awt.Color(255, 255, 255));
        fechaLabel.setText("Fecha:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(344, 344, 344)
                .addComponent(tituloPantalla)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fechaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloPantalla))
                        .addGap(18, 18, 18)
                        .addComponent(fechaLabel))
                    .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(60, 60, 60))
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

    private void tablaServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaServiciosMouseClicked
        if(!permisosUsuario.isModificar()){
        return;
        }
        try{
         for(int i = 0 ; i < serviciosBD.size() ; i++ )
        {
            if(tablaServicios.getSelectedRow() == -1)
                {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar un servicio para poder desactivarlo o activarlo.",
                            "Selecciona un servicio.", 
                            JOptionPane.OK_OPTION);
                    return;
                } 
            //target servicio seleccionado
            if(Integer.parseInt(tablaServicios.getValueAt(tablaServicios.getSelectedRow(),0).toString()) == serviciosBD.get(i).getIdservicio())
            {
              servicioSeleccionado = serviciosBD.get(i); 
            }
        }
        if(tablaServicios.getValueAt(tablaServicios.getSelectedRow(),3).equals("Sí"))
        {
            this.insertarImagen(this.activar,"/Imagenes/desactivar.png");
            modificarServicio.setEnabled(true);
        }else
        {
            this.insertarImagen(this.activar,"/Imagenes/activar.png");
            modificarServicio.setEnabled(false);
        }
         }catch(Exception ex){
             log(ex);
         }
    }//GEN-LAST:event_tablaServiciosMouseClicked

    private void activarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activarMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_activarMouseClicked

    private void tablaServiciosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaServiciosFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tablaServiciosFocusGained

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

    private void nuevoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoServicioActionPerformed
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoServicio().setVisible(true);
            }
        });
        emf.close();
        this.setVisible(false);
        this.dispose(); 
        serviciosDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_nuevoServicioActionPerformed

    private void modificarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarServicioActionPerformed
        try{
        List<servicios> serviciosBD = serviciosDAO.findserviciosEntities();
        for(int i = 0 ; i < serviciosBD.size() ; i++ )
        {
            if(tablaServicios.getSelectedRow() == -1)
                {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar un servicio para poder modificarlo.","Selecciona un servicio.", JOptionPane.OK_OPTION);
                    return;
                } 
            //target producto seleccionado
            if(Integer.parseInt(tablaServicios.getValueAt(tablaServicios.getSelectedRow(),0).toString()) == serviciosBD.get(i).getIdservicio())
            {
              servicioSeleccionado = serviciosBD.get(i); 
            }
        }
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoServicio(servicioSeleccionado).setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        serviciosDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_modificarServicioActionPerformed

    private void listaPreciosServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPreciosServiciosActionPerformed
        // TODO add your handling code here:
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaPreciosServicio().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        serviciosDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_listaPreciosServiciosActionPerformed

    private void activarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarActionPerformed
        // TODO add your handling code here:
        try{
        servicios modificar = new servicios();
        List<servicios> servicios = serviciosDAO.findserviciosEntities();
        //verificar que el usuario haya seleccionado un servicio
        if(tablaServicios.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un servicio para poder desactivarlo.", "Selecciona un servicio", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //target producto a modificar
        for(int i=0 ; i<servicios.size();i++)
        {
            if(Integer.parseInt(tablaServicios.getValueAt(tablaServicios.getSelectedRow(),0).toString()) == servicios.get(i).getIdservicio())
            {
                modificar = servicios.get(i);
            }
        }
        if(tablaServicios.getValueAt(tablaServicios.getSelectedRow(),3).equals("Sí"))
        {
           modificar.setActivo(false);
           this.insertarImagen(this.activar,"/Imagenes/activar.png");
           modificarServicio.setEnabled(false);
           try
           {
               serviciosDAO.edit(modificar);
           }catch(Exception Ex)
           {}  
        }else
         {
            modificar.setActivo(true);
            this.insertarImagen(this.activar,"/Imagenes/desactivar.png"); 
            modificarServicio.setEnabled(true);
            try
           {
               serviciosDAO.edit(modificar);
           }catch(Exception Ex)
           {}  
        }
        cargarTabla();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_activarActionPerformed

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
            case "ID Servicio":
                try{
                    cargarTablaBusquedaId(Integer.parseInt(buscarTxt.getText()));
                }catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(this,"Un Id es un numero entero.","ID Inválido",JOptionPane.ERROR_MESSAGE);
                    return;
                } 
                 return;
            case "Nombre":
                 if(!buscarTxt.getText().matches("^[\\w]+[^\\d]$"))
                {
                    JOptionPane.showMessageDialog(this,"Un nombre no lleva números.","Nombre inválido",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                    cargarTablaBusquedaNombre(buscarTxt.getText());
                return;
            case "Precio Actual":
                try{
                    cargarTablaBusquedaPrecio(Double.parseDouble(buscarTxt.getText()));
                }catch(NumberFormatException Ex)
                {
                    JOptionPane.showMessageDialog(this, "Ese no es um precio válido","Precio Inválido",JOptionPane.ERROR_MESSAGE);
                }
        }
        }catch(Exception ex){
            log(ex);
        } 
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void buscarTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarTxtFocusGained
        // TODO add your handling code here:
        buscarTxt.selectAll();
    }//GEN-LAST:event_buscarTxtFocusGained

    private void imprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirReporteActionPerformed
        // TODO add your handling code here:
        try{
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
        HashMap logo = new HashMap();
        empleado empleadoActual = empleadoDAO.findempleado(singleton.getCuenta().getIDEmpleado());
        logo.put("logo",getClass().getResourceAsStream("/Imagenes/logoBarberia.jpeg"));
        logo.put("usuario", empleadoActual.getNomEmpleado() + " " + empleadoActual.getApeEmpleado());
        try {
             JasperReport reporte = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reportes/reporteServicios.jrxml"));
            //JasperReport reporte = JasperCompileManager.compileReport("src/main/resources/Reportes/reporteServicios.jrxml");
            JasperPrint print = JasperFillManager.fillReport(
                    reporte,
                    logo, 
                    conn);
      
      JasperViewer view = new JasperViewer(print,false);
      Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
      view.setIconImage(icon);
      view.setTitle("Reporte de Inventario");
      view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(pantallaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(pantallaServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        }catch(Exception ex){
            log(ex);
        }  
    }//GEN-LAST:event_imprimirReporteActionPerformed

    private void recargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarActionPerformed
        // TODO add your handling code here:
        try{
        cargarTabla();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_recargarActionPerformed

    
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
            java.util.logging.Logger.getLogger(pantallaServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaServicios().setVisible(true);
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
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JButton imprimirReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listaPreciosServicios;
    private javax.swing.JLabel logo;
    private javax.swing.JButton modificarServicio;
    private javax.swing.JButton nuevoServicio;
    private javax.swing.JButton recargar;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

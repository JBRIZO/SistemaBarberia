/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.estadofacturaJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipodocumentoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipopagoJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.estadofactura;
import com.mycompany.sistemabarberia.permisosusuario;
import com.mycompany.sistemabarberia.tipodocumento;
import com.mycompany.sistemabarberia.tipopago;
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
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jonathan Laux
 */
public class atributosFactura extends javax.swing.JFrame {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private permisosusuario permisosUsuario;
            
    private Validaciones validar = new Validaciones();
    private tipopagoJpaController tipopagoDAO = new tipopagoJpaController(emf);
    private tipodocumentoJpaController tipoDocumentoDAO = new tipodocumentoJpaController(emf);
    private estadofacturaJpaController estadoDAO = new estadofacturaJpaController(emf);
    private empleadoJpaController empleadoDAO = new empleadoJpaController(emf);
    private ImageIcon imagen;
    private Icon icono;
    private usuarios usuarios = new usuarios(); 
    private UsuarioSingleton singleton = UsuarioSingleton.getUsuario(usuarios);
    private int tabla = 0; //identificar la tabla seleccionada
    Border redBorder = BorderFactory.createLineBorder(Color.RED, 1);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 1);
    Border defaultBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true);

    /**
     * Creates new form nuevoTipoDescuento
     */
    public atributosFactura() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
        setIconImage(icon);
        this.insertarImagen(this.logo,"/Imagenes/logoBarberia.png");
        formatoInvalido.setText("");
        Reiniciar();
        permisosUsuario = verificarPermisos();
        desactivarBotonesPermisos();
        if(!verificarPermisoParametro().isActivo()){
            botonParametros.setEnabled(false);
        }
    }
    
    private void desactivarBotonesPermisos(){
        if(permisosUsuario.isNuevo()){
            estadoFactura.setEnabled(true);
        }else{
            estadoFactura.setEnabled(false);
        }
        if(permisosUsuario.isModificar()){
            modificar.setEnabled(true);
        }else{
            modificar.setEnabled(false);
        }
        if(permisosUsuario.isImprimir()){
            imprimirReporteEstados.setEnabled(true);
            imprimirReporteDocumentos.setEnabled(true);
            imprimirReportePagos.setEnabled(true);
        }else{
            imprimirReporteEstados.setEnabled(false);
            imprimirReporteDocumentos.setEnabled(false);
            imprimirReportePagos.setEnabled(false);
        }
        if(permisosUsuario.isLista()){
            tipoPago.setEnabled(true);
        }else{
            tipoPago.setEnabled(false);
        }
        if(permisosUsuario.isDesactivar()){
            botonParametros.setEnabled(true);
        }else{
            botonParametros.setEnabled(false);
        }
        
        if(permisosUsuario.isPuesto()){
            botonTipoDocumento.setEnabled(true);
        }else{
            botonTipoDocumento.setEnabled(false);
        }
    }
    
    private permisosusuario verificarPermisos(){
        EntityManager em = tipopagoDAO.getEntityManager();
        String hqlDetalleProd = "FROM permisosusuario E WHERE E.IDUsuario = :IDUsuario AND E.IDPermiso = :IDPermiso";
        Query queryPermisos = em.createQuery(hqlDetalleProd);
        queryPermisos.setParameter("IDUsuario",singleton.getCuenta().getIdusuario());
        queryPermisos.setParameter("IDPermiso",4);
        permisosusuario permisos = (permisosusuario)queryPermisos.getSingleResult();
        return permisos;
    }
    
    private permisosusuario verificarPermisoParametro(){
        try{
        EntityManager em = tipopagoDAO.getEntityManager();
        String hqlDetalleProd = "FROM permisosusuario E WHERE E.IDUsuario = :IDUsuario AND E.IDPermiso = :IDPermiso";
        Query queryPermisos = em.createQuery(hqlDetalleProd);
        queryPermisos.setParameter("IDUsuario",singleton.getCuenta().getIdusuario());
        queryPermisos.setParameter("IDPermiso",13);
        permisosusuario permisos = (permisosusuario)queryPermisos.getSingleResult();
        return permisos;
        }catch(javax.persistence.NoResultException Ex){
            permisosusuario permiso = new permisosusuario();
            permiso.setActivo(false); 
        return permiso;
        } 
    }
    
    private void Reiniciar()
    {
        cargarTablaTipoPago();
        cargarTablaEstado();
        cargarTablaTipoDoc();
    }
    
    private void cargarTablaTipoPago()
    {
        DefaultTableModel modelo = (DefaultTableModel)tablaTiposPago.getModel();
        modelo.setRowCount(0);
        tablaTiposPago.setModel(modelo);
        String activo = "";
        List<tipopago> tipopagoBD = tipopagoDAO.findtipopagoEntities();
            for(tipopago tipopago : tipopagoBD){
                if(tipopago.getActivo()){
                    activo = "Sí";
                }else{
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        tipopago.getIdtipopago(),
                        tipopago.getTipoPago(),
                        activo
                    }
                );
            }
    }
    
  
    private void cargarTablaTipoDoc()
    {
        DefaultTableModel modelo = (DefaultTableModel)tablaDocumentos.getModel();
        modelo.setRowCount(0);
        String activo = "";
        tablaDocumentos.setModel(modelo);
        List<tipodocumento> tipoDocBD = tipoDocumentoDAO.findtipodocumentoEntities();
            for(tipodocumento tipodocumento : tipoDocBD){
                if(tipodocumento.isActivo()){
                    activo = "Sí";
                }else{
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        tipodocumento.getIdtipodocumento(),
                        tipodocumento.getTipoDocumento(),
                        activo
                    }
                );
            }
    }
    
     private void cargarTablaEstado()
    {
        DefaultTableModel modelo = (DefaultTableModel)tablaEstados.getModel();
        modelo.setRowCount(0);
        String activo = "";
        tablaEstados.setModel(modelo);
        List<estadofactura> estadosFacturaBD = estadoDAO.findestadofacturaEntities();
            for(estadofactura estadoFactura : estadosFacturaBD){
                if(estadoFactura.isActivo()){
                    activo = "Sí";
                }else{
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        estadoFactura.getIdestado(),
                        estadoFactura.getNombreEstado(),
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        estadoFactura = new javax.swing.JButton();
        tipoPago = new javax.swing.JButton();
        botonParametros = new javax.swing.JButton();
        botonTipoDocumento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEstados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDocumentos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaTiposPago = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();
        desactivar = new javax.swing.JButton();
        nuevoNombre = new javax.swing.JTextField();
        formatoInvalido = new javax.swing.JLabel();
        imprimirReporteEstados = new javax.swing.JButton();
        imprimirReporteDocumentos = new javax.swing.JButton();
        imprimirReportePagos = new javax.swing.JButton();
        tituloPantalla = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        estadoFactura.setBackground(new java.awt.Color(189, 158, 76));
        estadoFactura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        estadoFactura.setText("NUEVO ESTADO");
        estadoFactura.setRequestFocusEnabled(false);
        estadoFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estadoFacturaMouseClicked(evt);
            }
        });
        estadoFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoFacturaActionPerformed(evt);
            }
        });

        tipoPago.setBackground(new java.awt.Color(189, 158, 76));
        tipoPago.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tipoPago.setText("NUEVO TIPO PAGO");
        tipoPago.setRequestFocusEnabled(false);
        tipoPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tipoPagoMouseClicked(evt);
            }
        });
        tipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoPagoActionPerformed(evt);
            }
        });

        botonParametros.setBackground(new java.awt.Color(189, 158, 76));
        botonParametros.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonParametros.setText("NUEVO PARAMETRO");
        botonParametros.setRequestFocusEnabled(false);
        botonParametros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonParametrosMouseClicked(evt);
            }
        });
        botonParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonParametrosActionPerformed(evt);
            }
        });

        botonTipoDocumento.setBackground(new java.awt.Color(189, 158, 76));
        botonTipoDocumento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonTipoDocumento.setText("NUEVO TIPO DOC.");
        botonTipoDocumento.setRequestFocusEnabled(false);
        botonTipoDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonTipoDocumentoMouseClicked(evt);
            }
        });
        botonTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTipoDocumentoActionPerformed(evt);
            }
        });

        tablaEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Estado", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEstados.getTableHeader().setReorderingAllowed(false);
        tablaEstados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEstadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEstados);
        if (tablaEstados.getColumnModel().getColumnCount() > 0) {
            tablaEstados.getColumnModel().getColumn(0).setResizable(false);
            tablaEstados.getColumnModel().getColumn(0).setPreferredWidth(15);
            tablaEstados.getColumnModel().getColumn(1).setResizable(false);
            tablaEstados.getColumnModel().getColumn(2).setResizable(false);
            tablaEstados.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ESTADO DE FACTURA:");

        tablaDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Documento", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDocumentos.getTableHeader().setReorderingAllowed(false);
        tablaDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDocumentosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaDocumentos);
        if (tablaDocumentos.getColumnModel().getColumnCount() > 0) {
            tablaDocumentos.getColumnModel().getColumn(0).setResizable(false);
            tablaDocumentos.getColumnModel().getColumn(0).setPreferredWidth(15);
            tablaDocumentos.getColumnModel().getColumn(1).setResizable(false);
            tablaDocumentos.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        tablaTiposPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tipo de Pago", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTiposPago.getTableHeader().setReorderingAllowed(false);
        tablaTiposPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTiposPagoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaTiposPago);
        if (tablaTiposPago.getColumnModel().getColumnCount() > 0) {
            tablaTiposPago.getColumnModel().getColumn(0).setResizable(false);
            tablaTiposPago.getColumnModel().getColumn(0).setPreferredWidth(15);
            tablaTiposPago.getColumnModel().getColumn(1).setResizable(false);
            tablaTiposPago.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TIPOS DE DOCUMENTO:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TIPOS DE PAGO:");

        modificar.setBackground(new java.awt.Color(189, 158, 76));
        modificar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        modificar.setText("MODIFICAR");
        modificar.setEnabled(false);
        modificar.setRequestFocusEnabled(false);
        modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarMouseClicked(evt);
            }
        });
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        desactivar.setBackground(new java.awt.Color(189, 158, 76));
        desactivar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/desactivar.png"))); // NOI18N
        desactivar.setText("DESACTIVAR");
        desactivar.setEnabled(false);
        desactivar.setRequestFocusEnabled(false);
        desactivar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                desactivarMouseClicked(evt);
            }
        });
        desactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desactivarActionPerformed(evt);
            }
        });

        nuevoNombre.setBackground(new java.awt.Color(30, 33, 34));
        nuevoNombre.setDocument(new JTextFieldLimit(20));
        nuevoNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nuevoNombre.setForeground(new java.awt.Color(255, 255, 255));
        nuevoNombre.setText("Nombre Documento");
        nuevoNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nuevoNombre.setEnabled(false);
        nuevoNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nuevoNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nuevoNombreFocusLost(evt);
            }
        });

        formatoInvalido.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido.setText("Formato no valido.");

        imprimirReporteEstados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N
        imprimirReporteEstados.setBorderPainted(false);
        imprimirReporteEstados.setContentAreaFilled(false);
        imprimirReporteEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirReporteEstadosActionPerformed(evt);
            }
        });

        imprimirReporteDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N
        imprimirReporteDocumentos.setBorderPainted(false);
        imprimirReporteDocumentos.setContentAreaFilled(false);
        imprimirReporteDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirReporteDocumentosActionPerformed(evt);
            }
        });

        imprimirReportePagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N
        imprimirReportePagos.setBorderPainted(false);
        imprimirReportePagos.setContentAreaFilled(false);
        imprimirReportePagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirReportePagosActionPerformed(evt);
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(estadoFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(imprimirReporteEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imprimirReporteDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(tipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonParametros, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nuevoNombre)
                                .addComponent(desactivar, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(formatoInvalido))))
                    .addComponent(imprimirReportePagos, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estadoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(botonParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(desactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formatoInvalido))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imprimirReporteEstados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imprimirReporteDocumentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imprimirReportePagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 48)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("ATRIBUTOS DE FACTURA");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        botonRegresar.setBackground(new java.awt.Color(189, 158, 76));
        botonRegresar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonRegresar.setText("REGRESAR");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156)
                        .addComponent(tituloPantalla))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloPantalla, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
        emf.close();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void estadoFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoFacturaActionPerformed
        // TODO add your handling code here:
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new estadoFactura(tablaEstados).setVisible(true);
            }
        });
    }//GEN-LAST:event_estadoFacturaActionPerformed

    private void tipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoPagoActionPerformed

    private void tipoPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoPagoMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tipoPago().setVisible(true);
            }
        });
        this.setVisible(false);
    }//GEN-LAST:event_tipoPagoMouseClicked

    private void estadoFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estadoFacturaMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_estadoFacturaMouseClicked

    private void botonRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegresarMouseClicked
        // TODO add your handling code here:
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        this.setVisible(false);
    }//GEN-LAST:event_botonRegresarMouseClicked

    private void botonParametrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonParametrosMouseClicked
        // TODO add your handling code here:                               
    }//GEN-LAST:event_botonParametrosMouseClicked

    private void botonParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonParametrosActionPerformed
      try{
      parametrosFactura pf = new parametrosFactura();
       pf.setVisible(true);
       this.dispose();
      }catch(Exception ex){
          log(ex);
      }
    }//GEN-LAST:event_botonParametrosActionPerformed

    private void botonTipoDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonTipoDocumentoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonTipoDocumentoMouseClicked

    private void botonTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTipoDocumentoActionPerformed
        // TODO add your handling code here:
        tipoDocumento td = new tipoDocumento(tablaDocumentos);
        td.setVisible(true);
    }//GEN-LAST:event_botonTipoDocumentoActionPerformed

    private void modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarMouseClicked

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
        if(!validarCampos()){
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void desactivarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_desactivarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_desactivarMouseClicked

    private void desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desactivarActionPerformed
        // TODO add your handling code here:
        try{
        switch(tabla){
            case 1://estados
                
                //desactivar
                estadofactura estadoDesactivar = new estadofactura();
                if(tablaEstados.getValueAt(tablaEstados.getSelectedRow(),2).equals("Sí"))
                {
                    estadoDesactivar.setIdestado(Integer.parseInt(tablaEstados.getValueAt(tablaEstados.getSelectedRow(),0).toString()));
                    estadoDesactivar.setNombreEstado(tablaEstados.getValueAt(tablaEstados.getSelectedRow(),1).toString());
                    estadoDesactivar.setActivo(false);
                }else{
                    estadoDesactivar.setIdestado(Integer.parseInt(tablaEstados.getValueAt(tablaEstados.getSelectedRow(),0).toString()));
                    estadoDesactivar.setNombreEstado(tablaEstados.getValueAt(tablaEstados.getSelectedRow(),1).toString());
                    estadoDesactivar.setActivo(true);
                }
                try{
                    estadoDAO.edit(estadoDesactivar);
                    JOptionPane.showMessageDialog(this,"Estado modificado con éxito.");
                    cargarTablaEstado();
                }catch(Exception Ex)
                {}
                break;
            case 2://tipo documento
                
                tipodocumento tipoDoc = new tipodocumento();
                if(tablaDocumentos.getValueAt(tablaDocumentos.getSelectedRow(),2).equals("Sí"))
                {
                    tipoDoc.setIdtipodocumento(Integer.parseInt(tablaDocumentos.getValueAt(tablaDocumentos.getSelectedRow(),0).toString()));
                    tipoDoc.setTipoDocumento(tablaDocumentos.getValueAt(tablaDocumentos.getSelectedRow(),1).toString());
                    tipoDoc.setActivo(false);
                }else{
                    tipoDoc.setIdtipodocumento(Integer.parseInt(tablaDocumentos.getValueAt(tablaDocumentos.getSelectedRow(),0).toString()));
                    tipoDoc.setTipoDocumento(tablaDocumentos.getValueAt(tablaDocumentos.getSelectedRow(),1).toString());
                    tipoDoc.setActivo(true);
                }
                try{
                    tipoDocumentoDAO.edit(tipoDoc);
                    JOptionPane.showMessageDialog(this,"Estado modificado con éxito.");
                    cargarTablaTipoDoc();
                }catch(Exception Ex)
                {}
                break;
            case 3://tipo pago

                tipopago tipoPagoDesactivar = new tipopago();
                if(tablaTiposPago.getValueAt(tablaTiposPago.getSelectedRow(),2).equals("Sí"))
                {
                    tipoPagoDesactivar.setIdtipopago(Integer.parseInt(tablaTiposPago.getValueAt(tablaTiposPago.getSelectedRow(),0).toString()));
                    tipoPagoDesactivar.setTipoPago(tablaTiposPago.getValueAt(tablaTiposPago.getSelectedRow(),1).toString());
                    tipoPagoDesactivar.setActivo(false);
                }else{
                    tipoPagoDesactivar.setIdtipopago(Integer.parseInt(tablaTiposPago.getValueAt(tablaTiposPago.getSelectedRow(),0).toString()));
                    tipoPagoDesactivar.setTipoPago(tablaTiposPago.getValueAt(tablaTiposPago.getSelectedRow(),1).toString());
                    tipoPagoDesactivar.setActivo(true);
                }
                try{
                    tipopagoDAO.edit(tipoPagoDesactivar);
                    JOptionPane.showMessageDialog(this,"Estado modificado con éxito.");
                    cargarTablaTipoDoc();
                }catch(Exception Ex)
                {}
                break;
            default:
                break;
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_desactivarActionPerformed

    private void tablaEstadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEstadosMouseClicked
        try{
        if(tablaEstados.getSelectedRow() > -1){
             //validar que el usuario no modifique ni desactiva los estados del sistema
             if(Integer.parseInt(tablaEstados.getValueAt(tablaEstados.getSelectedRow(),0).toString()) <= 3)
                {
                    JOptionPane.showMessageDialog(this,"Este estado de factura no se puede modificar.","Advertencia",JOptionPane.WARNING_MESSAGE);
                    return;
                }
            tabla = 1;
            if(permisosUsuario.isDesactivar()){
                desactivar.setEnabled(true);
            }
            if(permisosUsuario.isModificar()){
                modificar.setEnabled(true);
            }
            nuevoNombre.setEnabled(true);
            nuevoNombre.setText(tablaEstados.getValueAt(tablaEstados.getSelectedRow(),1).toString());
            if(tablaEstados.getValueAt(tablaEstados.getSelectedRow(),0).toString().equalsIgnoreCase("Sí")){
                desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/activar.png")));
            }else{
                desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/desactivar.png")));
            } 
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_tablaEstadosMouseClicked

    private void tablaDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDocumentosMouseClicked
          try{
          if(tablaDocumentos.getSelectedRow() > -1){
            //validar que el usuario no modifique los tipos de  documentos del sistema
             if(Integer.parseInt(tablaDocumentos.getValueAt(tablaDocumentos.getSelectedRow(),0).toString()) <= 3)
                {
                    JOptionPane.showMessageDialog(this,"Este tipo de documento no se puede modificar.","Advertencia",JOptionPane.WARNING_MESSAGE);
                    return;
                }
            tabla = 2;
            if(permisosUsuario.isDesactivar()){
                desactivar.setEnabled(true);
            }
            if(permisosUsuario.isModificar()){
                modificar.setEnabled(true);
            }
            nuevoNombre.setEnabled(true);
            nuevoNombre.setText(tablaDocumentos.getValueAt(tablaDocumentos.getSelectedRow(),1).toString());
            
            if(tablaTiposPago.getValueAt(tablaTiposPago.getSelectedRow(),0).toString().equalsIgnoreCase("Sí")){
                desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/activar.png")));
            }else{
                desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/desactivar.png")));
            } 
        }
          }catch(Exception ex){
          log(ex);
          }
    }//GEN-LAST:event_tablaDocumentosMouseClicked

    private void tablaTiposPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTiposPagoMouseClicked
        // TODO add your handling code here:
        try{
            if(tablaTiposPago.getSelectedRow() > -1){
               //validar que el usuario no modifique los tipos de  documentos del sistema
             if(Integer.parseInt(tablaTiposPago.getValueAt(tablaTiposPago.getSelectedRow(),0).toString()) <= 3)
                {
                    JOptionPane.showMessageDialog(this,"Este tipo de pago no se puede modificar.","Advertencia",JOptionPane.WARNING_MESSAGE);
                    return;
                }
            tabla = 3;
            if(permisosUsuario.isDesactivar()){
                desactivar.setEnabled(true);
            }
            if(permisosUsuario.isModificar()){
                modificar.setEnabled(true);
            }
            nuevoNombre.setEnabled(true);
            nuevoNombre.setText(tablaTiposPago.getValueAt(tablaTiposPago.getSelectedRow(),1).toString());
            if(tablaTiposPago.getValueAt(tablaTiposPago.getSelectedRow(),0).toString().equalsIgnoreCase("Sí")){
                desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/activar.png")));
            }else{
                desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/desactivar.png")));
            }   
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_tablaTiposPagoMouseClicked

    private void nuevoNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nuevoNombreFocusGained
        // TODO add your handling code here:
        nuevoNombre.selectAll();
    }//GEN-LAST:event_nuevoNombreFocusGained

    private void nuevoNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nuevoNombreFocusLost
        // TODO add your handling code here:
        try{
        validarCampos();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_nuevoNombreFocusLost

    private void imprimirReporteEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirReporteEstadosActionPerformed
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
        HashMap logo = new HashMap();
        empleado empleadoActual = empleadoDAO.findempleado(singleton.getCuenta().getIDEmpleado());
        logo.put("logo",getClass().getResourceAsStream("/Imagenes/logoBarberia.jpeg"));
        logo.put("usuario", empleadoActual.getNomEmpleado() + " " + empleadoActual.getApeEmpleado());
        try {
             JasperReport reporte = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reportes/reporteEstadosFactura.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(
                    reporte,
                    logo, 
                    conn);
      
      JasperViewer view = new JasperViewer(print,false);
      Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
      view.setIconImage(icon);
      view.setTitle("Reporte de Estados de Factura");
      view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(pantallaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn.close();
        } catch (Exception ex) {
            log(ex);
        }
    }//GEN-LAST:event_imprimirReporteEstadosActionPerformed

    private void imprimirReporteDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirReporteDocumentosActionPerformed
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
        HashMap logo = new HashMap();
        empleado empleadoActual = empleadoDAO.findempleado(singleton.getCuenta().getIDEmpleado());
        logo.put("logo",getClass().getResourceAsStream("/Imagenes/logoBarberia.jpeg"));
        logo.put("usuario", empleadoActual.getNomEmpleado() + " " + empleadoActual.getApeEmpleado());
        try {
             JasperReport reporte = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reportes/reporteTiposDocumento.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(
                    reporte,
                    logo, 
                    conn);
      JasperViewer view = new JasperViewer(print,false);
      Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
      view.setIconImage(icon);
      view.setTitle("Reporte de Tipos de Documento");
      view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(pantallaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (Exception ex) {
            log(ex);
        }
        
    }//GEN-LAST:event_imprimirReporteDocumentosActionPerformed

    private void imprimirReportePagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirReportePagosActionPerformed
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
        HashMap logo = new HashMap();
        empleado empleadoActual = empleadoDAO.findempleado(singleton.getCuenta().getIDEmpleado());
        logo.put("logo",getClass().getResourceAsStream("/Imagenes/logoBarberia.jpeg"));
        logo.put("usuario", empleadoActual.getNomEmpleado() + " " + empleadoActual.getApeEmpleado());
        try {
             JasperReport reporte = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reportes/reporteTiposPago.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(
                    reporte,
                    logo, 
                    conn);
      JasperViewer view = new JasperViewer(print,false);
      Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
      view.setIconImage(icon);
      view.setTitle("Reporte de Metodos de Pago");
      view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(pantallaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(pantallaServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_imprimirReportePagosActionPerformed

    
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
            java.util.logging.Logger.getLogger(atributosFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(atributosFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(atributosFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(atributosFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new atributosFactura().setVisible(true);
            }
        });
        
        
    }
    private boolean validarCampos()
    {
        if(nuevoNombre.getText().equals(""))
        {
            nuevoNombre.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Debes ingresar un dato.");
            return false;
        }
        if(nuevoNombre.getText().matches("^.*\\d+.*$"))
        {
            nuevoNombre.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Solo se permite texto en este campo.");
            return false;
        }
        if(!nuevoNombre.getText().matches("^[A-Z]{1}[\\w\\s]+$"))
        {
            nuevoNombre.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("El nombre debe iniciar con mayuscula.");
            return false;
        }
        
        if(validar.validacionLetrasRepetidas(nuevoNombre.getText()))
        {
            nuevoNombre.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("No puedes repetir tantas letras.");
            return false;
        }
        if(!validar.validacionCadenaPalabras(nuevoNombre.getText()))
        {    
             nuevoNombre.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Esa no es una palabra válida.");
            return false;
            
        }
        if(!validar.validacionCantidadMinima(nuevoNombre.getText(), 3))
            {
            nuevoNombre.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("El nombre debe ser de minimo 3 letras.");
            return false;
            }
        formatoInvalido.setText("");
        nuevoNombre.setBorder(greenBorder);
        return true;
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
    private javax.swing.JButton botonParametros;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton botonTipoDocumento;
    private javax.swing.JButton desactivar;
    private javax.swing.JButton estadoFactura;
    private javax.swing.JLabel formatoInvalido;
    private javax.swing.JButton imprimirReporteDocumentos;
    private javax.swing.JButton imprimirReporteEstados;
    private javax.swing.JButton imprimirReportePagos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel logo;
    private javax.swing.JButton modificar;
    public javax.swing.JTextField nuevoNombre;
    private javax.swing.JTable tablaDocumentos;
    private javax.swing.JTable tablaEstados;
    private javax.swing.JTable tablaTiposPago;
    private javax.swing.JButton tipoPago;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

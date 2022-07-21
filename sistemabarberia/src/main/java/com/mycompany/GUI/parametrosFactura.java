/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.parametrosJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.MyJasperViewer;
import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.parametros;
import com.mycompany.sistemabarberia.permisosusuario;
import com.mycompany.sistemabarberia.usuarios;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Kesil
 */
public class parametrosFactura extends javax.swing.JFrame {

    private permisosusuario permisosUsuario;
    private Validaciones validar = new Validaciones();
    private ImageIcon imagen;
    private Icon icono;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private parametrosJpaController parametros = new parametrosJpaController(emf);
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    private java.text.SimpleDateFormat formatoEspanol = new java.text.SimpleDateFormat("dd/MM/yyyy");
    private empleadoJpaController empleadosDAO = new empleadoJpaController(emf);
    private usuarios usuarios = new usuarios(); 
    private UsuarioSingleton singleton = UsuarioSingleton.getUsuario(usuarios);
    

    /**
     * Creates new form nuevoTipoDescuento
     */
    public parametrosFactura() {
        initComponents();
       Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
        setIconImage(icon);
        this.insertarImagen(this.logo,"/Imagenes/logoBarberia.png");
        Reiniciar();
        establecerRangoInicial();
        cargarTablaParametros();
        Reiniciar();
        permisosUsuario = verificarPermisos();
        botonGuardar.setEnabled(permisosUsuario.isNuevo());
        imprimirReporte.setEnabled(permisosUsuario.isImprimir());   
    }
    
    private permisosusuario verificarPermisos(){
        EntityManager em = parametros.getEntityManager();
        String hqlDetalleProd = "FROM permisosusuario E WHERE E.IDUsuario = :IDUsuario AND E.IDPermiso = :IDPermiso";
        Query queryPermisos = em.createQuery(hqlDetalleProd);
        queryPermisos.setParameter("IDUsuario",singleton.getCuenta().getIdusuario());
        queryPermisos.setParameter("IDPermiso",13);
        permisosusuario permisos = (permisosusuario)queryPermisos.getSingleResult();
        return permisos;
    }

    private void cargarTablaParametros()
    {
         String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaParametros.getModel();
        modelo.setRowCount(0);
        tablaParametros.setModel(modelo);
        List<parametros> parametrosBD = parametros.findparametrosEntities();
            for(parametros parametro : parametrosBD){
                if(parametro.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        parametro.getLlave(),
                        formatoEspanol.format(parametro.getFechaInicio()),
                        formatoEspanol.format(parametro.getFechaFinal()),
                        parametro.getRangoInicial(),
                        parametro.getRangoFinal(),
                        activo
                    }
                );
            }
    }
    private void establecerRangoInicial()
    {
        //encontrar el ultimo parametro utilizado 
        Query queryParametros = parametros.getEntityManager().createQuery("FROM parametros ORDER BY idparametro DESC");
        queryParametros.setMaxResults(1);
        parametros parametroFinal = (parametros) queryParametros.getSingleResult();
        
            rangoInicial.setText(Integer.toString(parametroFinal.getRangoFinal() + 1));
            rangoInicial.setEditable(false);
        
//             //ultima factura
//        Query query = parametros.getEntityManager().createQuery("FROM facturaencabezado ORDER BY idfacturaencabezado DESC");
//        query.setMaxResults(1);
//        int numeroFactura = 0;
//        try{
//            facturaencabezado lastFactura = (facturaencabezado) query.getSingleResult();
//            numeroFactura = lastFactura.getIdfacturaencabezado()+1;
//        }catch(javax.persistence.NoResultException Ex)
//        {
//            numeroFactura = 1;
//        }
//        rangoInicial.setText(Integer.toString(numeroFactura));
//        rangoInicial.setEditable(false);
        
    }
    
    
    public void Reiniciar() 
    {
        List<parametros> parametrosBD = parametros.findparametrosEntities();
        lbFechaInicio.setText("");
        lbFechaFinal.setText("");
        lbLlave.setText("");
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
        txtFechaFinal = new javax.swing.JTextField();
        txtLlave = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JTextField();
        rangoInicial = new javax.swing.JTextField();
        rangoFinal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaParametros = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lbFechaInicio = new javax.swing.JLabel();
        lbFechaFinal = new javax.swing.JLabel();
        lbLlave = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        salir1 = new javax.swing.JLabel();
        imprimirReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("PARAMETROS");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        txtFechaFinal.setBackground(new java.awt.Color(30, 33, 34));
        txtFechaFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFechaFinal.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaFinal.setText("Fecha Final");
        txtFechaFinal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtFechaFinal.setSelectionColor(new java.awt.Color(55, 53, 53));
        txtFechaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaFinalFocusLost(evt);
            }
        });
        txtFechaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaFinalActionPerformed(evt);
            }
        });

        txtLlave.setBackground(new java.awt.Color(30, 33, 34));
        txtLlave.setDocument(new JTextFieldLimit(37));
        txtLlave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLlave.setForeground(new java.awt.Color(255, 255, 255));
        txtLlave.setText("Llave");
        txtLlave.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtLlave.setSelectionColor(new java.awt.Color(55, 53, 53));
        txtLlave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLlaveFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLlaveFocusLost(evt);
            }
        });
        txtLlave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLlaveActionPerformed(evt);
            }
        });

        txtFechaInicio.setBackground(new java.awt.Color(30, 33, 34));
        txtFechaInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaInicio.setText("Fecha de Inicio");
        txtFechaInicio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtFechaInicio.setSelectionColor(new java.awt.Color(55, 53, 53));
        txtFechaInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaInicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaInicioFocusLost(evt);
            }
        });
        txtFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInicioActionPerformed(evt);
            }
        });

        rangoInicial.setBackground(new java.awt.Color(30, 33, 34));
        rangoInicial.setDocument(new JTextFieldLimit(9));
        rangoInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rangoInicial.setForeground(new java.awt.Color(255, 255, 255));
        rangoInicial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        rangoInicial.setSelectionColor(new java.awt.Color(55, 53, 53));
        rangoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rangoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rangoInicialFocusLost(evt);
            }
        });
        rangoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangoInicialActionPerformed(evt);
            }
        });

        rangoFinal.setBackground(new java.awt.Color(30, 33, 34));
        rangoFinal.setDocument(new JTextFieldLimit(9));
        rangoFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rangoFinal.setForeground(new java.awt.Color(255, 255, 255));
        rangoFinal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        rangoFinal.setSelectionColor(new java.awt.Color(55, 53, 53));
        rangoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rangoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rangoFinalFocusLost(evt);
            }
        });
        rangoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangoFinalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inicio:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Final:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Rango Factura:");

        tablaParametros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Llave ", "Fecha Inicio", "Fecha Final", "Rango Iniicial", "Rango Final", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
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
        tablaParametros.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaParametros);
        if (tablaParametros.getColumnModel().getColumnCount() > 0) {
            tablaParametros.getColumnModel().getColumn(0).setResizable(false);
            tablaParametros.getColumnModel().getColumn(1).setResizable(false);
            tablaParametros.getColumnModel().getColumn(2).setResizable(false);
            tablaParametros.getColumnModel().getColumn(3).setResizable(false);
            tablaParametros.getColumnModel().getColumn(3).setPreferredWidth(20);
            tablaParametros.getColumnModel().getColumn(4).setResizable(false);
            tablaParametros.getColumnModel().getColumn(4).setPreferredWidth(20);
            tablaParametros.getColumnModel().getColumn(5).setResizable(false);
            tablaParametros.getColumnModel().getColumn(5).setPreferredWidth(15);
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NUEVO PARAMETRO:");

        lbFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        lbFechaInicio.setText("jLabel5");

        lbFechaFinal.setForeground(new java.awt.Color(255, 255, 255));
        lbFechaFinal.setText("jLabel5");

        lbLlave.setForeground(new java.awt.Color(255, 255, 255));
        lbLlave.setText("jLabel5");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtLlave, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(lbLlave))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rangoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rangoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbFechaInicio)
                            .addComponent(lbFechaFinal))
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(lbFechaInicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFechaFinal)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(rangoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rangoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addComponent(txtLlave, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLlave))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        botonGuardar.setBackground(new java.awt.Color(189, 158, 76));
        botonGuardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonGuardar.setText("GUARDAR");
        botonGuardar.setRequestFocusEnabled(false);
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarMouseClicked(evt);
            }
        });
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        salir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x.png"))); // NOI18N
        salir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salir1MouseClicked(evt);
            }
        });

        imprimirReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/printIcon.png"))); // NOI18N
        imprimirReporte.setBorderPainted(false);
        imprimirReporte.setContentAreaFilled(false);
        imprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salir1)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(tituloPantalla)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imprimirReporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(salir1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tituloPantalla, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(imprimirReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public String convertirFechaSql(String Fecha){
        String[] palabras  = Fecha.split("/");
        return palabras[2] + "-" + palabras[1] + "-" + palabras[0];
    }
    
    private void limpiar(){
        txtFechaInicio.setText("Fecha de Inicio");
        txtFechaInicio.setForeground(new Color(153, 153, 153));
        txtFechaFinal.setText("Fecha Final");
        txtFechaFinal.setForeground(new Color(153, 153, 153));
        txtLlave.setText("Llave");
        txtLlave.setForeground(new Color(153, 153, 153));
        lbFechaInicio.setText("");
        lbFechaFinal.setText("");
        lbLlave.setText("");
        txtFechaInicio.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        txtFechaFinal.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        txtLlave.setBorder(BorderFactory.createLineBorder(Color.black, 1));   
    }
    
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        try{
        java.util.Date startDate = new Date(0000000000);
        java.util.Date fechaFinal = new Date(0000000000);
        String fechaIni = "00-00-0000";
        String fechaFin = "00-00-0000";
       
        if (txtFechaInicio.getText().isEmpty() || txtFechaFinal.getText().isEmpty() ||  txtLlave.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
         if(!validar.isDateValid(txtFechaInicio.getText()) || !validar.isDateValid(txtFechaFinal.getText()))
        {
            JOptionPane.showMessageDialog(null,"Por favor corrige las fechas con los campos en rojo.",
                    "Fecha Inválida",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
          try {
                startDate = sdf.parse(convertirFechaSql(txtFechaInicio.getText()));  
                fechaIni = sdf.format(startDate);
                fechaFinal = sdf.parse(convertirFechaSql(txtFechaFinal.getText()));
                fechaFin = sdf.format(fechaFinal);
                } catch (ParseException ex) {
                   ex.printStackTrace();
                }
                //validar fecha de inicio del empleado
                    LocalDate fecha = validar.convertToLocalDateViaInstant(startDate);
                    LocalDate fecha2 = validar.convertToLocalDateViaInstant(fechaFinal);
                    if(fecha.isAfter(fecha2))
                    {
                       JOptionPane.showMessageDialog(null,"La fecha final no puede ser menor a la fecha inicial.", 
                               "Fecha Inválida",
                               JOptionPane.ERROR_MESSAGE); 
                       txtFechaFinal.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                       return;
                    }
            if (!txtFechaInicio.getText().matches("^\\d{2}[/]{1}\\d{2}[/]{1}\\d{4}$")) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inicio inválido\nFormato correcto: dd/mm/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!txtFechaFinal.getText().matches("^\\d{2}[/]{1}\\d{2}[/]{1}\\d{4}$")) {
            JOptionPane.showMessageDialog(null, "Formato de fecha final inválido\nFormato correcto: dd/mm/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!txtLlave.getText().matches("^[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}-[A-Z,0-9]{2}$")) {
            JOptionPane.showMessageDialog(null, "El CAI debe contener 32 caracteres\nDeben ser numeros y letras\nFormato correcto: XXXXXX-XXXXXX-XXXXXX-XXXXXX-XX ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            if(!validarRangos(rangoInicial,rangoFinal))
            {
                return;
            }
            parametros pm = new parametros();

            pm.setFechaInicio(Date.valueOf(convertirFechaSql(txtFechaInicio.getText())));
            pm.setFechaFinal(Date.valueOf(convertirFechaSql(txtFechaFinal.getText())));
            pm.setLlave(txtLlave.getText());
            pm.setRangoInicial(Integer.parseInt(rangoInicial.getText()));
            pm.setRangoFinal(Integer.parseInt(rangoFinal.getText()));
            pm.setActivo(true);
            try {
                parametros.create(pm);
                limpiar();
                JOptionPane.showMessageDialog(null, "El registro se ha almacenado correctamente");
                cargarTablaParametros();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Esa llave ya existe.","Error",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                //JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
        // TODO add your handling code here:
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
        this.setVisible(false);
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void txtFechaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFinalActionPerformed

    private void txtLlaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLlaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLlaveActionPerformed

    private void txtFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioActionPerformed

    private void txtFechaInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaInicioFocusGained
        try{
        if (txtFechaInicio.getText().equals("Fecha de Inicio")) {
            txtFechaInicio.setDocument(new JTextFieldLimit(10));
            txtFechaInicio.setText("");
            txtFechaInicio.setForeground(new Color(255, 255, 255));
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_txtFechaInicioFocusGained

    private void txtFechaInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaInicioFocusLost
        try{
        if (txtFechaInicio.getText().equals("")) {
            txtFechaInicio.setDocument(new JTextFieldLimit(25));
            txtFechaInicio.setText("Fecha de Inicio");
            txtFechaInicio.setForeground(new Color(153, 153, 153));
            txtFechaInicio.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            lbFechaInicio.setText("");
        } else if (!txtFechaInicio.getText().matches("^\\d{2}[/]{1}\\d{2}[/]{1}\\d{4}$")) {
            txtFechaInicio.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            lbFechaInicio.setText("Formato incorrecto: dd/mm/aaaa");
        } else {
             if(!validar.isDateValid(txtFechaInicio.getText()))
        {
            txtFechaInicio.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            lbFechaInicio.setVisible(true);
            JOptionPane.showMessageDialog(null,"Esa fecha es inválida, por favor revisa que la cantidad de dias concuerde con el mes.\nEjemplo de fecha inválida: 30/02/2021",
                    "Fecha Inválida",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
            txtFechaInicio.setBorder(BorderFactory.createLineBorder(Color.green, 1));
            lbFechaInicio.setText("");
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_txtFechaInicioFocusLost

    private void txtFechaFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaFinalFocusGained
        try{
        if (txtFechaFinal.getText().equals("Fecha Final")) {
            txtFechaFinal.setDocument(new JTextFieldLimit(10));
            txtFechaFinal.setText("");
            txtFechaFinal.setForeground(new Color(255, 255, 255));
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_txtFechaFinalFocusGained

    private void txtFechaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaFinalFocusLost
        try{
        if (txtFechaFinal.getText().equals("")) {
            txtFechaFinal.setDocument(new JTextFieldLimit(25));
            txtFechaFinal.setText("Fecha Final");
            txtFechaFinal.setForeground(new Color(153, 153, 153));
            txtFechaFinal.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            lbFechaFinal.setText("");
        } else if (!txtFechaFinal.getText().matches("^\\d{2}[/]{1}\\d{2}[/]{1}\\d{4}$")) {
            txtFechaFinal.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            lbFechaFinal.setText("Formato incorrecto: dd/mm/aaaa");
        } else {
            if(!validar.isDateValid(txtFechaFinal.getText()))
        {
            txtFechaFinal.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            lbFechaFinal.setVisible(true);
            JOptionPane.showMessageDialog(null,"Esa fecha es inválida, por favor revisa que la cantidad de dias concuerde con el mes.\nEjemplo de fecha inválida: 30/02/2021",
                    "Fecha Inválida",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
            txtFechaFinal.setBorder(BorderFactory.createLineBorder(Color.green, 1));
            lbFechaFinal.setText("");
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_txtFechaFinalFocusLost

    private void txtLlaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLlaveFocusGained
        try{
        if (txtLlave.getText().equals("Llave")) {
            txtLlave.setText("");
            txtLlave.setForeground(new Color(255, 255, 255));
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_txtLlaveFocusGained

    private void txtLlaveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLlaveFocusLost
        try{
        if (txtLlave.getText().equals("")) {
            txtLlave.setText("Llave");
            txtLlave.setForeground(new Color(153, 153, 153));
            txtLlave.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            lbLlave.setText("");
        } else if (!txtLlave.getText().matches("^[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{2}$")) {
            //txtLlave.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            //lbLlave.setText("Formato incorrecto: XXXXXX-XXXXXX-XXXXXX-XXXXXX-XX \"");
        } else {
            txtLlave.setBorder(BorderFactory.createLineBorder(Color.green, 1));
            //lbLlave.setText("Formato correcto");
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_txtLlaveFocusLost

    private void salir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salir1MouseClicked
        // TODO add your handling code here:
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new atributosFactura().setVisible(true);
            }
        });
        emf.close();
        this.setVisible(false);
        this.dispose();
        parametros.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_salir1MouseClicked

    private void rangoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rangoInicialFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_rangoInicialFocusGained

    private void rangoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rangoInicialFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_rangoInicialFocusLost

    private void rangoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rangoInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rangoInicialActionPerformed

    private void rangoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rangoFinalFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_rangoFinalFocusGained

    private void rangoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rangoFinalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_rangoFinalFocusLost

    private void rangoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rangoFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rangoFinalActionPerformed

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
            JasperReport reporte = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reportes/reporteParametros.jrxml"));
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
            java.util.logging.Logger.getLogger(parametrosFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(parametrosFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(parametrosFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(parametrosFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new parametrosFactura().setVisible(true);
            }
        });

    }
    
    private boolean validarRangos(javax.swing.JTextField rangoInicial, javax.swing.JTextField rangoFinal)
    {
        if(!validar.validacionEntero(rangoFinal.getText()))
        {
           rangoFinal.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            JOptionPane.showMessageDialog(null,"El formato del rango final está equivocado, recuerda que en este campo solo puedes ingresar números enteros.","Error de formato",JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        int rangoInicio = 0;
        int rangoFin = 0;
        try
        {
        rangoInicio = Integer.parseInt(rangoInicial.getText());
        rangoFin = Integer.parseInt(rangoFinal.getText());   
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null,"Solo puedes ingresar números enteros en este campo.","Rango Inválido",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(rangoInicio >= rangoFin)
        {
            JOptionPane.showMessageDialog(this,"El rango final debe ser mayor al rango inicial.","",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(validar.validacionEntero(rangoFinal.getText()))
        {
            return true;
        }else{return false;}
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
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton imprimirReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFechaFinal;
    private javax.swing.JLabel lbFechaInicio;
    private javax.swing.JLabel lbLlave;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField rangoFinal;
    private javax.swing.JTextField rangoInicial;
    private javax.swing.JLabel salir1;
    private javax.swing.JTable tablaParametros;
    private javax.swing.JLabel tituloPantalla;
    private javax.swing.JTextField txtFechaFinal;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtLlave;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.clientesJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.MyJasperViewer;
import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.clientes;
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
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kesil
 */
public class pantallaClientes extends javax.swing.JFrame {


    private permisosusuario permisosUsuario;
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private clientes clienteSeleccionado;
    private empleadoJpaController empleadosDAO = new empleadoJpaController(emf);
    private clientesJpaController clienteDAO =  new clientesJpaController(emf);
    private ImageIcon imagen;
    private Icon icono;
    private usuarios usuarios = new usuarios(); 
    private UsuarioSingleton singleton = UsuarioSingleton.getUsuario(usuarios);

    /**
     * Creates new form nuevoTipoDescuento
     */
    public pantallaClientes() {
        try{
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
        setIconImage(icon);
        this.insertarImagen(this.logo,"/Imagenes/logoBarberia.png");
        this.insertarImagen(this.activar,"/Imagenes/desactivar.png");
        cargarTabla();
        for(int i = 0 ; i < tablaClientes.getColumnCount()-1 ; i++)
        {
            cbParametros.addItem(tablaClientes.getColumnName(i));
        }
        modificarCliente.setEnabled(false);
        }catch(Exception ex){
            ex.printStackTrace();
            log(ex);
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
        if(permisosUsuario.isModificar()){
            modificarCliente.setEnabled(true);
        }else{
            modificarCliente.setEnabled(false);
        }
        if(permisosUsuario.isNuevo()){
            nuevoEmpleado.setEnabled(true);
        }else{
            nuevoEmpleado.setEnabled(false);
        }
    }
    
    private permisosusuario verificarPermisos(){
        EntityManager em = empleadosDAO.getEntityManager();
        String hqlDetalleProd = "FROM permisosusuario E WHERE E.IDUsuario = :IDUsuario AND E.IDPermiso = :IDPermiso";
        Query queryPermisos = em.createQuery(hqlDetalleProd);
        queryPermisos.setParameter("IDUsuario",singleton.getCuenta().getIdusuario());
        queryPermisos.setParameter("IDPermiso",10);
        permisosusuario permisos = (permisosusuario)queryPermisos.getSingleResult();
        return permisos;
    }

    private void cargarTabla()
    {

        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaClientes.getModel();
        modelo.setRowCount(0);
        tablaClientes.setModel(modelo);
        List<clientes> clientes = clienteDAO.findclientesEntities();
            for(clientes cliente : clientes){
                //consumidor final no se agrega a la tabla
                if(cliente.getIdcliente() == 0)
                {
                    continue;
                }
                if(cliente.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        cliente.getIdcliente(),
                        cliente.getNomCliente(),
                        cliente.getApeCliente(),
                        cliente.getNumDocumento(),
                        convertirDates(cliente.getFechaNacimiento().toString()),
                        cliente.getNumTelefono(),
                        activo
                    }
                );
            }
    }

    private void cargarTablaIdCliente(int IdCliente)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaClientes.getModel();
        modelo.setRowCount(0);
        tablaClientes.setModel(modelo);
        List<clientes> clientes = clienteDAO.findclientesEntities();
        List<clientes> clientesFiltrados = new ArrayList();

        for(int i = 0; i < clientes.size();i++)
        {
            if(clientes.get(i).getIdcliente() == IdCliente)
            {
                clientesFiltrados.add(clientes.get(i));
            }
        }
         if(clientesFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "No se encontró ningun cliente con ese ID.",
                    "ID inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(clientes cliente : clientesFiltrados){
                if(cliente.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        cliente.getIdcliente(),
                        cliente.getNomCliente(),
                        cliente.getApeCliente(),
                        cliente.getNumDocumento(),
                        convertirDates(cliente.getFechaNacimiento().toString()),
                        cliente.getNumTelefono(),
                        activo
                    }
                );
            }
    }

    private void cargarTablaNomCliente(String NomCliente)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaClientes.getModel();
        modelo.setRowCount(0);
        tablaClientes.setModel(modelo);
        List<clientes> clientes = clienteDAO.findclientesEntities();
        List<clientes> clientesFiltrados = new ArrayList();

        for(int i = 0; i < clientes.size();i++)
        {
            if(clientes.get(i).getNomCliente().equalsIgnoreCase(NomCliente))
            {
                clientesFiltrados.add(clientes.get(i));
            }
        }
        if(clientesFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "No se encontró ningun cliente con ese nombre.",
                    "Nombre inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(clientes cliente : clientesFiltrados){
                if(cliente.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        cliente.getIdcliente(),
                        cliente.getNomCliente(),
                        cliente.getApeCliente(),
                        cliente.getNumDocumento(),
                        convertirDates(cliente.getFechaNacimiento().toString()),
                        cliente.getNumTelefono(),
                        activo
                    }
                );
            }
    }

    private void cargarTablaApeCliente(String apeCliente)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaClientes.getModel();
        modelo.setRowCount(0);
        tablaClientes.setModel(modelo);
        List<clientes> clientes = clienteDAO.findclientesEntities();
        List<clientes> clientesFiltrados = new ArrayList();

        for(int i = 0; i < clientes.size();i++)
        {
            if(clientes.get(i).getApeCliente().equalsIgnoreCase(apeCliente))
            {
                clientesFiltrados.add(clientes.get(i));
            }
        }
        if(clientesFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "No se encontró ningun cliente con ese apellido.",
                    "Apellido inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(clientes cliente : clientesFiltrados){
                if(cliente.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        cliente.getIdcliente(),
                        cliente.getNomCliente(),
                        cliente.getApeCliente(),
                        cliente.getNumDocumento(),
                        convertirDates(cliente.getFechaNacimiento().toString()),
                        cliente.getNumTelefono(),
                        activo
                    }
                );
            }
    }

    private void cargarTablaNumDoc(String numDocumento)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaClientes.getModel();
        modelo.setRowCount(0);
        tablaClientes.setModel(modelo);
        List<clientes> clientes = clienteDAO.findclientesEntities();
        List<clientes> clientesFiltrados = new ArrayList();

        for(int i = 0; i < clientes.size();i++)
        {
            if(clientes.get(i).getNumDocumento().equalsIgnoreCase(numDocumento))
            {
                clientesFiltrados.add(clientes.get(i));
            }
        }
        if(clientesFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "No se encontró ningun cliente con ese número de documento.",
                    "Documento inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(clientes cliente : clientesFiltrados){
                if(cliente.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        cliente.getIdcliente(),
                        cliente.getNomCliente(),
                        cliente.getApeCliente(),
                        cliente.getNumDocumento(),
                        convertirDates(cliente.getFechaNacimiento().toString()),
                        cliente.getNumTelefono(),
                        activo
                    }
                );
            }
    }

    private void cargarTablaFechaNacimiento(String fechaNac)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaClientes.getModel();
        modelo.setRowCount(0);
        tablaClientes.setModel(modelo);
        List<clientes> clientes = clienteDAO.findclientesEntities();
        List<clientes> clientesFiltrados = new ArrayList();

        for(int i = 1; i < clientes.size();i++)
        {
            if(convertirDates(clientes.get(i).getFechaNacimiento().toString()).equals(fechaNac))
            {
                clientesFiltrados.add(clientes.get(i));
            }
        }
        if(clientesFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "No se encontró ningun cliente que haya nacido ese día.",
                    "Fecha de nacimiento inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(clientes cliente : clientesFiltrados){
                if(cliente.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        cliente.getIdcliente(),
                        cliente.getNomCliente(),
                        cliente.getApeCliente(),
                        cliente.getNumDocumento(),
                        convertirDates(cliente.getFechaNacimiento().toString()),
                        cliente.getNumTelefono(),
                        activo
                    }
                );
            }
    }

    private void cargarTablaNumTelefono(String numTelefono)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaClientes.getModel();
        modelo.setRowCount(0);
        tablaClientes.setModel(modelo);
        List<clientes> clientes = clienteDAO.findclientesEntities();
        List<clientes> clientesFiltrados = new ArrayList();

        for(int i = 0; i < clientes.size();i++)
        {
            if(clientes.get(i).getNumTelefono().equals(numTelefono))
            {
                clientesFiltrados.add(clientes.get(i));
            }
        }
        if(clientesFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "No se encontró ningun cliente con ese número de teléfono.",
                    "Número de telefono inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(clientes cliente : clientesFiltrados){
                if(cliente.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        cliente.getIdcliente(),
                        cliente.getNomCliente(),
                        cliente.getApeCliente(),
                        cliente.getNumDocumento(),
                        convertirDates(cliente.getFechaNacimiento().toString()),
                        cliente.getNumTelefono(),
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
        tablaClientes = new javax.swing.JTable();
        activar = new javax.swing.JButton();
        nuevoEmpleado = new javax.swing.JButton();
        modificarCliente = new javax.swing.JButton();
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
        tituloPantalla.setText("CLIENTES");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        tablaClientes.setAutoCreateRowSorter(true);
        tablaClientes.setBackground(new java.awt.Color(30, 33, 34));
        tablaClientes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaClientes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaClientes.setForeground(new java.awt.Color(255, 255, 255));
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Cliente", "Nombres", "Apellidos", "Numero Doc.", "Fecha Nacimiento", "Num. Teléfono", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaClientes.setGridColor(new java.awt.Color(0, 0, 0));
        tablaClientes.setRowHeight(32);
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        tablaClientes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaClientesFocusGained(evt);
            }
        });
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaClientes.getColumnCount();i++)
        {
            tablaClientes.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaClientes.setShowGrid(true);
        tablaClientes.setGridColor(Color.BLACK);

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

        nuevoEmpleado.setBackground(new java.awt.Color(30, 33, 34));
        nuevoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nuevoEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        nuevoEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevoCliente.png"))); // NOI18N
        nuevoEmpleado.setBorder(null);
        nuevoEmpleado.setContentAreaFilled(false);
        nuevoEmpleado.setRequestFocusEnabled(false);
        nuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoEmpleadoActionPerformed(evt);
            }
        });

        modificarCliente.setBackground(new java.awt.Color(30, 33, 34));
        modificarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modificarCliente.setForeground(new java.awt.Color(255, 255, 255));
        modificarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modficarCliente.png"))); // NOI18N
        modificarCliente.setBorder(null);
        modificarCliente.setContentAreaFilled(false);
        modificarCliente.setRequestFocusEnabled(false);
        modificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarClienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Por:");

        buscarTxt.setBackground(new java.awt.Color(30, 33, 34));
        buscarTxt.setDocument(new JTextFieldLimit(25));
        buscarTxt.setForeground(new java.awt.Color(255, 255, 255));
        buscarTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarTxt)
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recargar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevoEmpleado)
                        .addGap(18, 18, 18)
                        .addComponent(modificarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(imprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(recargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbParametros, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addComponent(buscarTxt)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(nuevoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modificarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(353, 353, 353)
                        .addComponent(tituloPantalla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(31, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tituloPantalla)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        try{
        if(tablaClientes.getValueAt(tablaClientes.getSelectedRow(),6).equals("Sí"))
        {
            if(permisosUsuario.isModificar()){
            modificarCliente.setEnabled(true);
            }
            this.insertarImagen(this.activar,"/Imagenes/desactivar.png");
        }else
        {
            if(permisosUsuario.isModificar()){
                modificarCliente.setEnabled(false);
            }
            this.insertarImagen(this.activar,"/Imagenes/activar.png");
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void activarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activarMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_activarMouseClicked

    private void tablaClientesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaClientesFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_tablaClientesFocusGained

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

    private void nuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoEmpleadoActionPerformed
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarClientes().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose();
        clienteDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_nuevoEmpleadoActionPerformed

    private void modificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarClienteActionPerformed
        
        try{
        List<clientes> clientesBD = clienteDAO.findclientesEntities();
        for(int i = 0 ; i < clientesBD.size() ; i++ )
        {
            //target cliente seleccionado
            if(Integer.parseInt(tablaClientes.getValueAt(tablaClientes.getSelectedRow(),0).toString()) == clientesBD.get(i).getIdcliente())
            {
              clienteSeleccionado = clientesBD.get(i);
            }
        }
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarClientes(clienteSeleccionado).setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose();
        clienteDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_modificarClienteActionPerformed

    private void activarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarActionPerformed
        // TODO add your handling code here:
        try{
        if(tablaClientes.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(this,"Debes seleccionar un cliente para poder desactivarlo","Selecciona un cliente",JOptionPane.ERROR_MESSAGE);
            return;
        }
        clientes modificar = new clientes();
        List<clientes> empleados = clienteDAO.findclientesEntities();
        for(int i=0 ; i<empleados.size();i++)
        {
            if(Integer.parseInt(tablaClientes.getValueAt(tablaClientes.getSelectedRow(),0).toString()) == empleados.get(i).getIdcliente())
            {
                modificar = empleados.get(i);
            }
        }
        if(tablaClientes.getValueAt(tablaClientes.getSelectedRow(),6).equals("Sí"))
        {
           modificar.setActivo(false);
           this.insertarImagen(this.activar,"/Imagenes/activar.png");
           if(permisosUsuario.isModificar()){
           modificarCliente.setEnabled(false);
           }
           try
           {
               clienteDAO.edit(modificar);
           }catch(Exception Ex)
           {}
        }else
         {
            modificar.setActivo(true);
            this.insertarImagen(this.activar,"/Imagenes/desactivar.png");
            if(permisosUsuario.isModificar()){
           modificarCliente.setEnabled(true);
           }
            try
           {
               clienteDAO.edit(modificar);
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
        modificarCliente.setEnabled(false);
        if(buscarTxt.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Debes ingresar un " + cbParametros.getSelectedItem().toString() + ".","Campo vacío",JOptionPane.ERROR_MESSAGE);
            return;
        }
        switch(cbParametros.getSelectedItem().toString())
        {
            case "ID Cliente":
                try{
                    cargarTablaIdCliente(Integer.parseInt(buscarTxt.getText()));
                }catch(NumberFormatException ex)
                {
                   JOptionPane.showMessageDialog(this,"El Id debe de ser un número entero","ID Inválido",JOptionPane.ERROR_MESSAGE);
                   return;
                }
            return;
            case "Nombres":
                 if(!buscarTxt.getText().matches("^[\\w\\s]+[^\\d]$"))
                {
                    JOptionPane.showMessageDialog(this,"Un nombre no lleva números.","Nombre inválido",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                    cargarTablaNomCliente(buscarTxt.getText());
                return;
            case "Apellidos":
                 if(!buscarTxt.getText().matches("^[\\w\\s]+[^\\d]$"))
                {
                    JOptionPane.showMessageDialog(this,"Un apellido no lleva números.","Apellido inválido",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                    cargarTablaApeCliente(buscarTxt.getText());
                    return;
            case "Numero Doc.":
            cargarTablaNumDoc(buscarTxt.getText());
            return;
            case "Fecha Nacimiento":
            cargarTablaFechaNacimiento(buscarTxt.getText());
            return;
            case "Num. Teléfono":
            cargarTablaNumTelefono(buscarTxt.getText());
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void recargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarActionPerformed
        // TODO add your handling code here:
        try{
        modificarCliente.setEnabled(false);
        cargarTabla();
        buscarTxt.setText("");
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_recargarActionPerformed

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
            JasperReport reporte = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reportes/reporteClientes.jrxml"));
            //JasperReport reporte = JasperCompileManager.compileReport("src/main/resources/Reportes/reporteInventario.jrxml");
            JasperPrint print = JasperFillManager.fillReport(
                reporte,
                logo,
                conn);

            MyJasperViewer view = new MyJasperViewer(print,false);
            view.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
            view.setTitle("Reporte de Clientes");
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
            java.util.logging.Logger.getLogger(pantallaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaClientes().setVisible(true);
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

    private String convertirDates(String Fecha)
    {
        String[] palabras  = Fecha.split("-");

        return palabras[2] + "/" + palabras[1] + "/" + palabras[0];
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
    private javax.swing.JButton modificarCliente;
    private javax.swing.JButton nuevoEmpleado;
    private javax.swing.JButton recargar;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.usuariosJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
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
import static java.util.Collections.singleton;
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
public class pantallaEmpleados extends javax.swing.JFrame {

    private permisosusuario permisosUsuario;
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    private empleado empleadoSeleccionado;
    private empleadoJpaController empleadoDAO =  new empleadoJpaController(emf);
    private ImageIcon imagen;
    private Icon icono;
    private usuarios usuarios = new usuarios(); 
    private UsuarioSingleton singleton = UsuarioSingleton.getUsuario(usuarios);

    /**
     * Creates new form nuevoTipoDescuento
     */
    public pantallaEmpleados() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
        setIconImage(icon);
        this.insertarImagen(this.logo,"/Imagenes/logoBarberia.png");
        this.insertarImagen(this.activar,"/Imagenes/desactivar.png");
        cargarTabla();
        for (int i = 0; i < tablaEmpleados.getColumnCount()-1 ;i++)
        {
            cbParametros.addItem(tablaEmpleados.getColumnName(i));
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
            listaSalarios.setEnabled(true);
        }else{
            listaSalarios.setEnabled(false);
        }
        
        if(permisosUsuario.isModificar()){
            modificarEmpleado.setEnabled(true);
        }else{
            modificarEmpleado.setEnabled(false);
        }
        
        if(permisosUsuario.isNuevo()){
            nuevoEmpleado.setEnabled(true);
        }else{
            nuevoEmpleado.setEnabled(false);
        }
        
        if(permisosUsuario.isPuesto()){
            verPuestos.setEnabled(true);
        }else{
            verPuestos.setEnabled(false);
        }
    }
    
    
    private permisosusuario verificarPermisos(){
        EntityManager em = empleadoDAO.getEntityManager();
        String hqlDetalleProd = "FROM permisosusuario E WHERE E.IDUsuario = :IDUsuario AND E.IDPermiso = :IDPermiso";
        Query queryPermisos = em.createQuery(hqlDetalleProd);
        queryPermisos.setParameter("IDUsuario",singleton.getCuenta().getIdusuario());
        queryPermisos.setParameter("IDPermiso",7);
        permisosusuario permisos = (permisosusuario)queryPermisos.getSingleResult();
        return permisos;
    }

    private void cargarTabla()
    {

        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaEmpleados.getModel();
        modelo.setRowCount(0);
        tablaEmpleados.setModel(modelo);
        List<empleado> empleados = empleadoDAO.findempleadoEntities();
            for(empleado empleado : empleados){
                if(empleado.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        empleado.getIdempleado(),
                        empleado.getNomEmpleado(),
                        empleado.getApeEmpleado(),
                        empleado.getGenEmpleado(),
                        convertirDates(empleado.getFechaInicio().toString()),
                        empleado.getNumCelular(),
                        activo
                    }
                );
            }
    }

    private void cargarTablaBusquedaId(int IdEmpleado)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaEmpleados.getModel();
        modelo.setRowCount(0);
        tablaEmpleados.setModel(modelo);
        List<empleado> empleadosEnBd = empleadoDAO.findempleadoEntities();
        List<empleado> empleadosFiltrados = new ArrayList();

        for(int i = 0; i < empleadosEnBd.size();i++)
        {
            if(empleadosEnBd.get(i).getIdempleado() == IdEmpleado)
            {
                empleadosFiltrados.add(empleadosEnBd.get(i));
            }
        }
        
         if(empleadosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "No se encontró ningun empleado con ese ID.",
                    "ID inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(empleado empleado : empleadosFiltrados){
                if(empleado.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        empleado.getIdempleado(),
                        empleado.getNomEmpleado(),
                        empleado.getApeEmpleado(),
                        empleado.getGenEmpleado(),
                        convertirDates(empleado.getFechaInicio().toString()),
                        empleado.getNumCelular(),
                        activo
                    }
                );
            }
    }

     private void cargarTablaBusquedaNombres(String nombreEmpleado)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaEmpleados.getModel();
        modelo.setRowCount(0);
        tablaEmpleados.setModel(modelo);
        List<empleado> empleadosEnBd = empleadoDAO.findempleadoEntities();
        List<empleado> empleadosFiltrados = new ArrayList();

        for(int i = 0; i < empleadosEnBd.size();i++)
        {
            if(empleadosEnBd.get(i).getNomEmpleado().equalsIgnoreCase(nombreEmpleado))
            {
                empleadosFiltrados.add(empleadosEnBd.get(i));
            }
        }
        if(empleadosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "No se encontró ningun empleado con esos nombres.",
                    "Empleado inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(empleado empleado : empleadosFiltrados){
                if(empleado.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        empleado.getIdempleado(),
                        empleado.getNomEmpleado(),
                        empleado.getApeEmpleado(),
                        empleado.getGenEmpleado(),
                        convertirDates(empleado.getFechaInicio().toString()),
                        empleado.getNumCelular(),
                        activo
                    }
                );
            }
    }

     private void cargarTablaBusquedaApellidos(String apellidosEmpleado)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaEmpleados.getModel();
        modelo.setRowCount(0);
        tablaEmpleados.setModel(modelo);
        List<empleado> empleadosEnBd = empleadoDAO.findempleadoEntities();
        List<empleado> empleadosFiltrados = new ArrayList();

        for(int i = 0; i < empleadosEnBd.size();i++)
        {
            if(empleadosEnBd.get(i).getApeEmpleado().equalsIgnoreCase(apellidosEmpleado))
            {
                empleadosFiltrados.add(empleadosEnBd.get(i));
            }
        }
        
        if(empleadosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "No se encontró ningun empleado con esos apellidos.",
                    "Empleado inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(empleado empleado : empleadosFiltrados){
                if(empleado.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        empleado.getIdempleado(),
                        empleado.getNomEmpleado(),
                        empleado.getApeEmpleado(),
                        empleado.getGenEmpleado(),
                        convertirDates(empleado.getFechaInicio().toString()),
                        empleado.getNumCelular(),
                        activo
                    }
                );
            }
    }

    private void cargarTablaBusquedaGenero(char genero)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaEmpleados.getModel();
        modelo.setRowCount(0);
        tablaEmpleados.setModel(modelo);
        List<empleado> empleadosEnBd = empleadoDAO.findempleadoEntities();
        List<empleado> empleadosFiltrados = new ArrayList();

        for(int i = 0; i < empleadosEnBd.size();i++)
        {
            if(empleadosEnBd.get(i).getGenEmpleado() == genero)
            {
                empleadosFiltrados.add(empleadosEnBd.get(i));
            }
        }
            for(empleado empleado : empleadosFiltrados){
                if(empleado.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        empleado.getIdempleado(),
                        empleado.getNomEmpleado(),
                        empleado.getApeEmpleado(),
                        empleado.getGenEmpleado(),
                        convertirDates(empleado.getFechaInicio().toString()),
                        empleado.getNumCelular(),
                        activo
                    }
                );
            }
    }

    private void cargarTablaFechaInicio(String fechaInicio)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaEmpleados.getModel();
        modelo.setRowCount(0);
        tablaEmpleados.setModel(modelo);
        List<empleado> empleadosEnBd = empleadoDAO.findempleadoEntities();
        List<empleado> empleadosFiltrados = new ArrayList();

        for(int i = 0; i < empleadosEnBd.size();i++)
        {
            if(convertirDates(empleadosEnBd.get(i).getFechaInicio().toString()).equals(fechaInicio))
            {
                empleadosFiltrados.add(empleadosEnBd.get(i));
            }
        }
        if(empleadosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "No se encontró ningun empleado que haya iniciado ese día.",
                    "Empleado inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(empleado empleado : empleadosFiltrados){
                if(empleado.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        empleado.getIdempleado(),
                        empleado.getNomEmpleado(),
                        empleado.getApeEmpleado(),
                        empleado.getGenEmpleado(),
                        convertirDates(empleado.getFechaInicio().toString()),
                        empleado.getNumCelular(),
                        activo
                    }
                );
            }
    }

    private void cargarTablaNumeroTelefono(String numTelefono)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaEmpleados.getModel();
        modelo.setRowCount(0);
        tablaEmpleados.setModel(modelo);
        List<empleado> empleadosEnBd = empleadoDAO.findempleadoEntities();
        List<empleado> empleadosFiltrados = new ArrayList();

        for(int i = 0; i < empleadosEnBd.size();i++)
        {
            if(empleadosEnBd.get(i).getNumCelular().equals(numTelefono))
            {
                empleadosFiltrados.add(empleadosEnBd.get(i));
            }
        }
        
        if(empleadosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "No se encontró ningun empleado con ese numero de teléfono.",
                    "Empleado inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(empleado empleado : empleadosFiltrados){
                if(empleado.isActivo())
                {
                activo = "Sí";
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        empleado.getIdempleado(),
                        empleado.getNomEmpleado(),
                        empleado.getApeEmpleado(),
                        empleado.getGenEmpleado(),
                        convertirDates(empleado.getFechaInicio().toString()),
                        empleado.getNumCelular(),
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
        tablaEmpleados = new javax.swing.JTable();
        activar = new javax.swing.JButton();
        nuevoEmpleado = new javax.swing.JButton();
        modificarEmpleado = new javax.swing.JButton();
        verPuestos = new javax.swing.JButton();
        listaSalarios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbParametros = new javax.swing.JComboBox<>();
        buscarTxt = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        recargar = new javax.swing.JButton();
        imprimirReporte = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 48)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("EMPLEADOS");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        tablaEmpleados.setAutoCreateRowSorter(true);
        tablaEmpleados.setBackground(new java.awt.Color(30, 33, 34));
        tablaEmpleados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Empleado", "Nombres", "Apellidos", "Género", "Fecha Inicio", "Num. Teléfono", "Activo"
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
        tablaEmpleados.setGridColor(new java.awt.Color(255, 255, 255));
        tablaEmpleados.setRowHeight(32);
        tablaEmpleados.getTableHeader().setReorderingAllowed(false);
        tablaEmpleados.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaEmpleadosFocusGained(evt);
            }
        });
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);
        if (tablaEmpleados.getColumnModel().getColumnCount() > 0) {
            tablaEmpleados.getColumnModel().getColumn(3).setPreferredWidth(5);
        }
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaEmpleados.getColumnCount();i++)
        {
            tablaEmpleados.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaEmpleados.setShowGrid(true);
        tablaEmpleados.setGridColor(Color.BLACK);

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
        nuevoEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button.png"))); // NOI18N
        nuevoEmpleado.setBorder(null);
        nuevoEmpleado.setContentAreaFilled(false);
        nuevoEmpleado.setRequestFocusEnabled(false);
        nuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoEmpleadoActionPerformed(evt);
            }
        });

        modificarEmpleado.setBackground(new java.awt.Color(30, 33, 34));
        modificarEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modificarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        modificarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modify.png"))); // NOI18N
        modificarEmpleado.setBorder(null);
        modificarEmpleado.setContentAreaFilled(false);
        modificarEmpleado.setRequestFocusEnabled(false);
        modificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarEmpleadoActionPerformed(evt);
            }
        });

        verPuestos.setBackground(new java.awt.Color(30, 33, 34));
        verPuestos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        verPuestos.setForeground(new java.awt.Color(255, 255, 255));
        verPuestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/puestos.png"))); // NOI18N
        verPuestos.setBorder(null);
        verPuestos.setContentAreaFilled(false);
        verPuestos.setRequestFocusEnabled(false);
        verPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPuestosActionPerformed(evt);
            }
        });

        listaSalarios.setBackground(new java.awt.Color(30, 33, 34));
        listaSalarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listaSalarios.setForeground(new java.awt.Color(255, 255, 255));
        listaSalarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salarios.png"))); // NOI18N
        listaSalarios.setBorder(null);
        listaSalarios.setContentAreaFilled(false);
        listaSalarios.setRequestFocusEnabled(false);
        listaSalarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaSalariosActionPerformed(evt);
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
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscarTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recargar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevoEmpleado)
                        .addGap(18, 18, 18)
                        .addComponent(modificarEmpleado)
                        .addGap(26, 26, 26)
                        .addComponent(verPuestos)
                        .addGap(18, 18, 18)
                        .addComponent(listaSalarios)
                        .addGap(18, 18, 18)
                        .addComponent(imprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE))
                .addGap(90, 90, 90))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recargar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nuevoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modificarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(verPuestos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(listaSalarios, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(imprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304)
                        .addComponent(tituloPantalla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(tituloPantalla))
                    .addComponent(botonRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        try{
        if(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(),6).equals("Sí"))
        {
            this.insertarImagen(this.activar,"/Imagenes/desactivar.png");
            if(permisosUsuario.isModificar()){
                modificarEmpleado.setEnabled(true);
            }
        }else
        {
            this.insertarImagen(this.activar,"/Imagenes/activar.png");
            modificarEmpleado.setEnabled(false);
        }
        }catch(Exception ex){
        log(ex);
        }
    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void activarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activarMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_activarMouseClicked

    private void tablaEmpleadosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaEmpleadosFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_tablaEmpleadosFocusGained

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
                new AgregarEmpleado().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose();
        empleadoDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_nuevoEmpleadoActionPerformed

    private void modificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarEmpleadoActionPerformed
        try{
        List<empleado> empleadosBD = empleadoDAO.findempleadoEntities();
        for(int i = 0 ; i < empleadosBD.size() ; i++ )
        {
            if(tablaEmpleados.getSelectedRow() == -1)
                {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado para poder modificarlo.","Selecciona un empleado.", JOptionPane.OK_OPTION);
                    return;
                }
            //target empleado seleccionado
            if(Integer.parseInt(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(),0).toString()) == empleadosBD.get(i).getIdempleado())
            {
              empleadoSeleccionado = empleadosBD.get(i);
            }
        }
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarEmpleado(empleadoSeleccionado).setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose();
        empleadoDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_modificarEmpleadoActionPerformed

    private void verPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPuestosActionPerformed
        // TODO add your handling code here:
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaPuestos().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose();
        empleadoDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_verPuestosActionPerformed

    private void listaSalariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaSalariosActionPerformed
        // TODO add your handling code here:
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaSalarios().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose();
        empleadoDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_listaSalariosActionPerformed

    private void activarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarActionPerformed
        // TODO add your handling code here:
        try{
        empleado modificar = new empleado();
        List<empleado> empleados = empleadoDAO.findempleadoEntities();
        
        if(tablaEmpleados.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(this,"Debes seleccionar un empleado para poder desactivarlo.","Selecciona un empleado",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        for(int i=0 ; i<empleados.size();i++)
        {
            if(Integer.parseInt(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(),0).toString()) == empleados.get(i).getIdempleado())
            {
                modificar = empleados.get(i);
            }
        }
        //para desactivar usuario
        usuariosJpaController usuarioDAO = new usuariosJpaController(emf);
        List<usuarios> usuariosBD = usuarioDAO.findusuariosEntities();
        usuarios usuario = new usuarios();
        for(int i = 0 ; i < usuariosBD.size() ; i++)
        {
            if(usuariosBD.get(i).getIDEmpleado() == Integer.parseInt(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(),0).toString()))
            {
                usuario = usuariosBD.get(i);
            }
        }
        
        if(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(),6).equals("Sí"))
        {
           usuario.setActivo(false);
           modificar.setActivo(false);
           this.insertarImagen(this.activar,"/Imagenes/activar.png");
           if(!permisosUsuario.isModificar()){
                modificarEmpleado.setEnabled(false);
           }
           try
           {
               usuarioDAO.edit(usuario);
               empleadoDAO.edit(modificar);
           }catch(Exception Ex)
           {}
        }else
         {
            usuario.setActivo(true);
            modificar.setActivo(true);
            this.insertarImagen(this.activar,"/Imagenes/desactivar.png");
            if(permisosUsuario.isModificar()){
                modificarEmpleado.setEnabled(true);
           }
            try
           {
               usuarioDAO.edit(usuario);
               empleadoDAO.edit(modificar);
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
            case "ID Empleado":
                try{
                   cargarTablaBusquedaId(Integer.parseInt(buscarTxt.getText())); 
                }
                catch(NumberFormatException Ex)
                {
                    JOptionPane.showMessageDialog(this,"El Id debe de ser un número entero.","ID inválido",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            return;
            case "Nombres":
                 if(!buscarTxt.getText().matches("^[\\w\\s]+[^\\d]$"))
                {
                    JOptionPane.showMessageDialog(this,"Un nombre no lleva números.","Nombre inválido",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                    cargarTablaBusquedaNombres(buscarTxt.getText());
                return;
            case "Apellidos":
                if(!buscarTxt.getText().matches("^[\\w\\s]+[^\\d]$"))
                {
                    JOptionPane.showMessageDialog(this,"Un apellido no lleva números.","Apellido inválido",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                    cargarTablaBusquedaApellidos(buscarTxt.getText());
                return;
            case "Género":
            cargarTablaBusquedaGenero(buscarTxt.getText().charAt(0));
                return;
            case "Fecha Inicio":
            cargarTablaFechaInicio(buscarTxt.getText());
            return;
            case "Num. Teléfono":
            cargarTablaNumeroTelefono(buscarTxt.getText());
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

        empleado empleadoActual = empleadoDAO.findempleado(singleton.getCuenta().getIDEmpleado());
        HashMap logo = new HashMap();
        logo.put("logo",getClass().getResourceAsStream("/Imagenes/logoBarberia.jpeg"));
        logo.put("usuario",empleadoActual.getNomEmpleado() + " " + empleadoActual.getApeEmpleado());

        try {
            JasperReport reporte = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reportes/reporteEmpleados.jrxml"));
            //JasperReport reporte = JasperCompileManager.compileReport("src/main/resources/Reportes/reporteInventario.jrxml");
            JasperPrint print = JasperFillManager.fillReport(
                reporte,
                logo,
                conn);

            MyJasperViewer view = new MyJasperViewer(print,false);
            view.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
            view.setTitle("Reporte de Empleados");
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
            java.util.logging.Logger.getLogger(pantallaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaEmpleados().setVisible(true);
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
    private javax.swing.JButton listaSalarios;
    private javax.swing.JLabel logo;
    private javax.swing.JButton modificarEmpleado;
    private javax.swing.JButton nuevoEmpleado;
    private javax.swing.JButton recargar;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JLabel tituloPantalla;
    private javax.swing.JButton verPuestos;
    // End of variables declaration//GEN-END:variables
}

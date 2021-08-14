/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.clientesJpaController;
import com.mycompany.sistemabarberia.clientes;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kesil
 */
public class pantallaClientes extends javax.swing.JFrame {
    

    private clientes clienteSeleccionado;
    private clientesJpaController clienteDAO =  new clientesJpaController();
    private ImageIcon imagen;
    private Icon icono;

    /**
     * Creates new form nuevoTipoDescuento
     */
    public pantallaClientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        this.insertarImagen(this.activar,"src/main/resources/Imagenes/desactivar.png");
        cargarTabla();
        for(int i = 0 ; i < tablaClientes.getColumnCount()-1 ; i++)
        {
            cbParametros.addItem(tablaClientes.getColumnName(i));
        }
           
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
                        cliente.getFechaNacimiento(),
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
                        cliente.getFechaNacimiento(),
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
            if(clientes.get(i).getNomCliente().equalsIgnoreCase(apeCliente))
            {
                clientesFiltrados.add(clientes.get(i));
            }
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
                        cliente.getFechaNacimiento(),
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
                        cliente.getFechaNacimiento(),
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
        
        for(int i = 0; i < clientes.size();i++)
        {
            if(convertirDates(clientes.get(i).getFechaNacimiento().toString()).equals(fechaNac))
            {
                clientesFiltrados.add(clientes.get(i));
            }
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
                        cliente.getFechaNacimiento(),
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
                        cliente.getFechaNacimiento(),
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
        modificarEmpleado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbParametros = new javax.swing.JComboBox<>();
        buscarTxt = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        recargar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("CLIENTES");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        tablaClientes.setAutoCreateRowSorter(true);
        tablaClientes.setBackground(new java.awt.Color(30, 33, 34));
        tablaClientes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaClientes.setForeground(new java.awt.Color(255, 255, 255));
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Cliente", "Nombres", "Apellidos", "Numero Id.", "Fecha Nacimiento", "Num. Teléfono", "Activo"
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

        modificarEmpleado.setBackground(new java.awt.Color(30, 33, 34));
        modificarEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modificarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        modificarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modficarCliente.png"))); // NOI18N
        modificarEmpleado.setBorder(null);
        modificarEmpleado.setContentAreaFilled(false);
        modificarEmpleado.setRequestFocusEnabled(false);
        modificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarEmpleadoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Por:");

        buscarTxt.setBackground(new java.awt.Color(30, 33, 34));
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevoEmpleado)
                        .addGap(18, 18, 18)
                        .addComponent(modificarEmpleado))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscarTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recargar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbParametros)
                                    .addComponent(buscarTxt)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(recargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nuevoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(353, 353, 353)
                .addComponent(tituloPantalla)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tituloPantalla)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
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

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
         if(tablaClientes.getValueAt(tablaClientes.getSelectedRow(),6).equals("Sí"))
        {
            this.insertarImagen(this.activar,"src/main/resources/Imagenes/desactivar.png");
            modificarEmpleado.setEnabled(true);
        }else
        {
            this.insertarImagen(this.activar,"src/main/resources/Imagenes/activar.png");
            modificarEmpleado.setEnabled(false);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void nuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoEmpleadoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarClientes().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        clienteDAO.close();
    }//GEN-LAST:event_nuevoEmpleadoActionPerformed

    private void modificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarEmpleadoActionPerformed
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
    }//GEN-LAST:event_modificarEmpleadoActionPerformed

    private void activarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarActionPerformed
        // TODO add your handling code here:
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
           this.insertarImagen(this.activar,"src/main/resources/Imagenes/activar.png");
           modificarEmpleado.setEnabled(false);
           try
           {
               clienteDAO.edit(modificar);
           }catch(Exception Ex)
           {}  
        }else
         {
            modificar.setActivo(true);
            this.insertarImagen(this.activar,"src/main/resources/Imagenes/desactivar.png"); 
            modificarEmpleado.setEnabled(true);
            try
           {
               clienteDAO.edit(modificar);
           }catch(Exception Ex)
           {}  
        }
        cargarTabla();
    }//GEN-LAST:event_activarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:

        switch(cbParametros.getSelectedItem().toString())
        {
            case "ID Cliente":
            cargarTablaIdCliente(Integer.parseInt(buscarTxt.getText()));
            return;
            case "Nombres":
            cargarTablaNomCliente(buscarTxt.getText());
            return;
            case "Apellidos":
            cargarTablaApeCliente(buscarTxt.getText());
            case "Numero Id.":
            cargarTablaNumDoc(buscarTxt.getText());
            return;
            case "Fecha Nacimiento":
            cargarTablaFechaNacimiento(buscarTxt.getText());
            return;
            case "Num. Télefono":
            cargarTablaNumTelefono(buscarTxt.getText());    
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void recargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarActionPerformed
        // TODO add your handling code here:
        cargarTabla();
        buscarTxt.setText("");
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
    private void insertarImagen(JButton checkBox,String ruta)
    {
        this.imagen = new ImageIcon(ruta);
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
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JComboBox<String> cbParametros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton modificarEmpleado;
    private javax.swing.JButton nuevoEmpleado;
    private javax.swing.JButton recargar;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

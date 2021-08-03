/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.productos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kesil
 */
public class pantallaEmpleados extends javax.swing.JFrame {


    private empleado empleadoSeleccionado;
    private empleadoJpaController empleadoDAO =  new empleadoJpaController();
    private ImageIcon imagen;
    private Icon icono;

    /**
     * Creates new form nuevoTipoDescuento
     */
    public pantallaEmpleados() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        this.insertarImagen(this.activar,"src/main/resources/Imagenes/desactivar.png");
        cargarTabla();
        for (int i = 0; i < tablaEmpleados.getColumnCount()-1 ;i++)
        {
            cbParametros.addItem(tablaEmpleados.getColumnName(i));
        }

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
        botonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(listaSalarios))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(2, 2, 2)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recargar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(recargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nuevoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modificarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(verPuestos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(listaSalarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
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
                .addGap(280, 280, 280)
                .addComponent(tituloPantalla)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
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

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
         if(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(),6).equals("Sí"))
        {
            this.insertarImagen(this.activar,"src/main/resources/Imagenes/desactivar.png");
            modificarEmpleado.setEnabled(true);
        }else
        {
            this.insertarImagen(this.activar,"src/main/resources/Imagenes/activar.png");
            modificarEmpleado.setEnabled(false);
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
                new agregarEmpleado().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose();
        empleadoDAO.close();
    }//GEN-LAST:event_nuevoEmpleadoActionPerformed

    private void modificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarEmpleadoActionPerformed
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
                new agregarEmpleado(empleadoSeleccionado).setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose();
        empleadoDAO.close();
    }//GEN-LAST:event_modificarEmpleadoActionPerformed

    private void verPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPuestosActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaPuestos().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose();
        empleadoDAO.close();
    }//GEN-LAST:event_verPuestosActionPerformed

    private void listaSalariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaSalariosActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaSalarios().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose();
        empleadoDAO.close();
    }//GEN-LAST:event_listaSalariosActionPerformed

    private void activarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarActionPerformed
        // TODO add your handling code here:
        empleado modificar = new empleado();
        List<empleado> empleados = empleadoDAO.findempleadoEntities();
        for(int i=0 ; i<empleados.size();i++)
        {
            if(Integer.parseInt(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(),0).toString()) == empleados.get(i).getIdempleado())
            {
                modificar = empleados.get(i);
            }
        }
        if(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(),6).equals("Sí"))
        {
           modificar.setActivo(false);
           this.insertarImagen(this.activar,"src/main/resources/Imagenes/activar.png");
           modificarEmpleado.setEnabled(false);
           try
           {
               empleadoDAO.edit(modificar);
           }catch(Exception Ex)
           {}
        }else
         {
            modificar.setActivo(true);
            this.insertarImagen(this.activar,"src/main/resources/Imagenes/desactivar.png");
            modificarEmpleado.setEnabled(true);
            try
           {
               empleadoDAO.edit(modificar);
           }catch(Exception Ex)
           {}
        }
        cargarTabla();
    }//GEN-LAST:event_activarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:

        switch(cbParametros.getSelectedItem().toString())
        {
            case "ID Empleado":
            cargarTablaBusquedaId(Integer.parseInt(buscarTxt.getText()));
            return;

            case "Nombres":
            cargarTablaBusquedaNombres(buscarTxt.getText());
            return;

            case "Apellidos":
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

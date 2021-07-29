/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.precioshistoricosproductosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.productosJpaController;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.precioshistoricosproductos;
import com.mycompany.sistemabarberia.productos;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kesil
 */
public class pantallaProductos extends javax.swing.JFrame {
    
    private productos productoSeleccionado;
    
    private Validaciones validar = new Validaciones();
    private productosJpaController productosDAO =  new productosJpaController();
    private List<productos> productosBD = productosDAO.findproductosEntities();
    private precioshistoricosproductosJpaController preciosDAO= new precioshistoricosproductosJpaController();
    List<precioshistoricosproductos> preciosBD = preciosDAO.findprecioshistoricosproductosEntities();
    private ImageIcon imagen;
    private Icon icono;
    private java.util.Date dt = new java.util.Date();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
    String currentTime = sdf.format(dt);

    /**
     * Creates new form nuevoTipoDescuento
     */
    public pantallaProductos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        this.insertarImagen(this.activar,"src/main/resources/Imagenes/desactivar.png");
        this.insertarImagen(this.anadirProductos,"src/main/resources/Imagenes/agregar.png");
        fechaLabel.setText("Fecha: " + currentTime);
        cargarTabla();
        for(int i = 0; i < tablaProductos.getColumnCount()-1 ; i++)
        {
            cbParametros.addItem(tablaProductos.getColumnName(i));
        }  
    }
    
    private void cargarTabla()
    {
        double precioActual = 0;
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaProductos.getModel();
        modelo.setRowCount(0);
        tablaProductos.setModel(modelo);
        List<productos> productosEnBD = productosDAO.findproductosEntities();
            for(productos producto : productosEnBD){
                for(int i = 0; i < preciosBD.size() ; i++)
                    {
                        //precio actual del producto
                        if(preciosBD.get(i).getIDProducto() == producto.getIdproducto() && preciosBD.get(i).isActivo())
                        {
                            precioActual = preciosBD.get(i).getPrecio();
                        }
                    }
                if(producto.isActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        producto.getIdproducto(),
                        producto.getNomProducto(),
                        producto.getStockActual(),
                        producto.getStockMaximo(),
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
        DefaultTableModel modelo = (DefaultTableModel)tablaProductos.getModel();
        modelo.setRowCount(0);
        tablaProductos.setModel(modelo);
        List<productos> productosEnBD = productosDAO.findproductosEntities();
        List<productos> productosFiltrados = new ArrayList();
        
        for(int i = 0; i < productosEnBD.size();i++)
        {
            if(productosEnBD.get(i).getIdproducto() == IDProducto)
            {
                productosFiltrados.add(productosEnBD.get(i));
            }
        }
            for(productos producto : productosFiltrados){
                for(int i = 0; i < preciosBD.size() ; i++)
                    {
                        //precio actual del producto
                        if(preciosBD.get(i).getIDProducto() == producto.getIdproducto() && preciosBD.get(i).isActivo())
                        {
                            precioActual = preciosBD.get(i).getPrecio();
                        }
                    }
                if(producto.isActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        producto.getIdproducto(),
                        producto.getNomProducto(),
                        producto.getStockActual(),
                        producto.getStockMaximo(),
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
        DefaultTableModel modelo = (DefaultTableModel)tablaProductos.getModel();
        modelo.setRowCount(0);
        tablaProductos.setModel(modelo);
        List<productos> productosEnBD = productosDAO.findproductosEntities();
        List<productos> productosFiltrados = new ArrayList();
        
        for(int i = 0; i < productosEnBD.size();i++)
        {
            if(productosEnBD.get(i).getNomProducto().equalsIgnoreCase(Nombre))
            {
                productosFiltrados.add(productosEnBD.get(i));
            }
        }
            for(productos producto : productosFiltrados){
                for(int i = 0; i < preciosBD.size() ; i++)
                    {
                        //precio actual del producto
                        if(preciosBD.get(i).getIDProducto() == producto.getIdproducto() && preciosBD.get(i).isActivo())
                        {
                            precioActual = preciosBD.get(i).getPrecio();
                        }
                    }
                if(producto.isActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        producto.getIdproducto(),
                        producto.getNomProducto(),
                        producto.getStockActual(),
                        producto.getStockMaximo(),
                        precioActual,
                        activo
                    }
                );
            }    
    }
    
    private void cargarTablaBusquedaStock(int Stock)
    {
        double precioActual = 0;
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaProductos.getModel();
        modelo.setRowCount(0);
        tablaProductos.setModel(modelo);
        List<productos> productosEnBD = productosDAO.findproductosEntities();
        List<productos> productosFiltrados = new ArrayList();
        
        for(int i = 0; i < productosEnBD.size();i++)
        {
            if(productosEnBD.get(i).getStockActual() == Stock)
            {
                productosFiltrados.add(productosEnBD.get(i));
            }
        }
            for(productos producto : productosFiltrados){
                for(int i = 0; i < preciosBD.size() ; i++)
                    {
                        //precio actual del producto
                        if(preciosBD.get(i).getIDProducto() == producto.getIdproducto() && preciosBD.get(i).isActivo())
                        {
                            precioActual = preciosBD.get(i).getPrecio();
                        }
                    }
                if(producto.isActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        producto.getIdproducto(),
                        producto.getNomProducto(),
                        producto.getStockActual(),
                        producto.getStockMaximo(),
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
        DefaultTableModel modelo = (DefaultTableModel)tablaProductos.getModel();
        modelo.setRowCount(0);
        tablaProductos.setModel(modelo);
        List<productos> productosEnBD = productosDAO.findproductosEntities();
        List<productos> productosFiltrados = new ArrayList();
        List<precioshistoricosproductos> preciosFiltrados = new ArrayList();
        
        for(int i = 0 ; i < preciosBD.size() ; i++)
        {
            if(preciosBD.get(i).isActivo())
            {
                preciosFiltrados.add(preciosBD.get(i));
            }
        }     
        
        for(int i = 0; i < productosEnBD.size() ; i++)
        {
            for(int j = 0 ; j < preciosFiltrados.size(); j++)
            {
                if(productosEnBD.get(i).getIdproducto() == preciosFiltrados.get(j).getIDProducto() && preciosFiltrados.get(j).getPrecio() == Precio)
                {
                    productosFiltrados.add(productosEnBD.get(i));
                }
            }
        }
            for(productos producto : productosFiltrados){
                for(int i = 0; i < preciosBD.size() ; i++)
                    {
                        //precio actual del producto
                        if(preciosBD.get(i).getIDProducto() == producto.getIdproducto() && preciosBD.get(i).isActivo())
                        {
                            precioActual = preciosBD.get(i).getPrecio();
                        }
                    }
                if(producto.isActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        producto.getIdproducto(),
                        producto.getNomProducto(),
                        producto.getStockActual(),
                        producto.getStockMaximo(),
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
        tablaProductos = new javax.swing.JTable();
        activar = new javax.swing.JButton();
        nuevoProducto = new javax.swing.JButton();
        modificarProducto = new javax.swing.JButton();
        listaPrecios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbParametros = new javax.swing.JComboBox<>();
        buscarTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        anadirProductos = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        fechaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("PRODUCTOS");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        tablaProductos.setAutoCreateRowSorter(true);
        tablaProductos.setBackground(new java.awt.Color(30, 33, 34));
        tablaProductos.setForeground(new java.awt.Color(255, 255, 255));
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre", "Stock Actual", "Stock Maximo", "Precio Actual", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
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
        tablaProductos.setGridColor(new java.awt.Color(255, 255, 255));
        tablaProductos.setRowHeight(32);
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        tablaProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaProductosFocusGained(evt);
            }
        });
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaProductos.getColumnCount();i++)
        {
            tablaProductos.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaProductos.setShowGrid(true);
        tablaProductos.setGridColor(Color.BLACK);

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

        nuevoProducto.setBackground(new java.awt.Color(30, 33, 34));
        nuevoProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nuevoProducto.setForeground(new java.awt.Color(255, 255, 255));
        nuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevoProducto.png"))); // NOI18N
        nuevoProducto.setBorder(null);
        nuevoProducto.setContentAreaFilled(false);
        nuevoProducto.setRequestFocusEnabled(false);
        nuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProductoActionPerformed(evt);
            }
        });

        modificarProducto.setBackground(new java.awt.Color(30, 33, 34));
        modificarProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modificarProducto.setForeground(new java.awt.Color(255, 255, 255));
        modificarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificarProducto.png"))); // NOI18N
        modificarProducto.setBorder(null);
        modificarProducto.setContentAreaFilled(false);
        modificarProducto.setRequestFocusEnabled(false);
        modificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarProductoActionPerformed(evt);
            }
        });

        listaPrecios.setBackground(new java.awt.Color(30, 33, 34));
        listaPrecios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listaPrecios.setForeground(new java.awt.Color(255, 255, 255));
        listaPrecios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/preciosProducto.png"))); // NOI18N
        listaPrecios.setBorder(null);
        listaPrecios.setContentAreaFilled(false);
        listaPrecios.setRequestFocusEnabled(false);
        listaPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaPreciosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar por:");

        buscarTxt.setBackground(new java.awt.Color(30, 33, 34));
        buscarTxt.setForeground(new java.awt.Color(255, 255, 255));
        buscarTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        buscarTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscarTxtFocusGained(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        anadirProductos.setBorderPainted(false);
        anadirProductos.setContentAreaFilled(false);
        anadirProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anadirProductosMouseClicked(evt);
            }
        });
        anadirProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirProductosActionPerformed(evt);
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anadirProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevoProducto)
                        .addGap(18, 18, 18)
                        .addComponent(modificarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(listaPrecios)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarTxt)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(anadirProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nuevoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaPrecios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
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
                .addGap(278, 278, 278)
                .addComponent(tituloPantalla)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fechaLabel)
                .addGap(895, 895, 895))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloPantalla))
                .addGap(18, 18, 18)
                .addComponent(fechaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
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

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
         
        for(int i = 0 ; i < productosBD.size() ; i++ )
        {
            if(tablaProductos.getSelectedRow() == -1)
                {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar un producto para poder desactivarlo o activarlo.","Selecciona un producto.", JOptionPane.OK_OPTION);
                    return;
                } 
            //target producto seleccionado
            if(Integer.parseInt(tablaProductos.getValueAt(tablaProductos.getSelectedRow(),0).toString()) == productosBD.get(i).getIdproducto())
            {
              productoSeleccionado = productosBD.get(i); 
            }
        }
        if(tablaProductos.getValueAt(tablaProductos.getSelectedRow(),5).equals("Sí"))
        {
            anadirProductos.setVisible(true);
            this.insertarImagen(this.activar,"src/main/resources/Imagenes/desactivar.png");
            modificarProducto.setEnabled(true);
        }else
        {
            anadirProductos.setVisible(false);
            this.insertarImagen(this.activar,"src/main/resources/Imagenes/activar.png");
            modificarProducto.setEnabled(false);
        }
        
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void activarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activarMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_activarMouseClicked

    private void tablaProductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaProductosFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tablaProductosFocusGained

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void nuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoProductoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoProducto().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        productosDAO.close();
    }//GEN-LAST:event_nuevoProductoActionPerformed

    private void modificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarProductoActionPerformed
        List<productos> productosBD = productosDAO.findproductosEntities();
        for(int i = 0 ; i < productosBD.size() ; i++ )
        {
            if(tablaProductos.getSelectedRow() == -1)
                {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar un producto para poder modificarlo.","Selecciona un producto.", JOptionPane.OK_OPTION);
                    return;
                } 
            //target producto seleccionado
            if(Integer.parseInt(tablaProductos.getValueAt(tablaProductos.getSelectedRow(),0).toString()) == productosBD.get(i).getIdproducto())
            {
              productoSeleccionado = productosBD.get(i); 
            }
        }
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoProducto(productoSeleccionado).setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        productosDAO.close();
    }//GEN-LAST:event_modificarProductoActionPerformed

    private void listaPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPreciosActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaPrecios().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        productosDAO.close();
    }//GEN-LAST:event_listaPreciosActionPerformed

    private void activarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarActionPerformed
        // TODO add your handling code here:
        productos modificar = new productos();
        List<productos> productos = productosDAO.findproductosEntities();
        //verificar que el usuario haya seleccionado un producto
        if(tablaProductos.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un producto para poder desactivarlo.", "Selecciona un producto", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //target producto a modificar
        for(int i=0 ; i<productos.size();i++)
        {
            if(Integer.parseInt(tablaProductos.getValueAt(tablaProductos.getSelectedRow(),0).toString()) == productos.get(i).getIdproducto())
            {
                modificar = productos.get(i);
            }
        }
        if(tablaProductos.getValueAt(tablaProductos.getSelectedRow(),5).equals("Sí"))
        {
           modificar.setActivo(false);
           this.insertarImagen(this.activar,"src/main/resources/Imagenes/activar.png");
           modificarProducto.setEnabled(false);
           anadirProductos.setVisible(false);
           try
           {
               productosDAO.edit(modificar);
           }catch(Exception Ex)
           {}  
        }else
         {
            modificar.setActivo(true);
            this.insertarImagen(this.activar,"src/main/resources/Imagenes/desactivar.png"); 
            modificarProducto.setEnabled(true);
            anadirProductos.setVisible(true);
            try
           {
               productosDAO.edit(modificar);
           }catch(Exception Ex)
           {}  
        }
        cargarTabla();
    }//GEN-LAST:event_activarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        switch(cbParametros.getSelectedItem().toString())
        {
            case "ID Producto":
                    cargarTablaBusquedaId(Integer.parseInt(buscarTxt.getText()));
                 return;
            case "Nombre":
                    cargarTablaBusquedaNombre(buscarTxt.getText());
                return;
            case "Stock Actual":
                    cargarTablaBusquedaStock(Integer.parseInt(buscarTxt.getText()));
                return;
            case "Precio Actual":
                    cargarTablaBusquedaPrecio(Double.parseDouble(buscarTxt.getText()));
                return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscarTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarTxtFocusGained
        // TODO add your handling code here:
        buscarTxt.selectAll();
    }//GEN-LAST:event_buscarTxtFocusGained

    private void anadirProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anadirProductosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_anadirProductosMouseClicked

    private void anadirProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirProductosActionPerformed
        // TODO add your handling code here:
        int numeroIngresado = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Ingresa el numero de unidades a ser agregadas.",
                "Ingresar Unidades",
                JOptionPane.PLAIN_MESSAGE));
        productos modificar = new productos();
        List<productos> productos = productosDAO.findproductosEntities(); 
        
        //verificar si el usuario selecciono un producto
        if(tablaProductos.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un producto para poder añadir unidades.", "Selecciona un producto", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        if(!validar.validacionNumEntero(Integer.toString(numeroIngresado)))
        {
            JOptionPane.showMessageDialog(null,"Solo puedes introducir números enteros en este campo.","Numero inválido",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //target producto a modificar
        for(int i=0 ; i< productos.size();i++)
        {
            if(Integer.parseInt(tablaProductos.getValueAt(tablaProductos.getSelectedRow(),0).toString()) == productos.get(i).getIdproducto())
            {
                modificar = productos.get(i);
            }
        }
        
        if(modificar.getStockActual() +  numeroIngresado > modificar.getStockMaximo())
        {
           JOptionPane.showMessageDialog(null,"La cantidad de unidades no puede exceder el stock máximo para este producto.","Unidades inválidas",JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        if(tablaProductos.getValueAt(tablaProductos.getSelectedRow(),5).equals("Sí"))
        {
           modificar.setStockActual(modificar.getStockActual() + numeroIngresado);
           try
           {
               productosDAO.edit(modificar);
           }catch(Exception Ex)
           {}  
        }else
         {
            anadirProductos.setEnabled(false);  
        }
        cargarTabla();
        
    }//GEN-LAST:event_anadirProductosActionPerformed

    
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
            java.util.logging.Logger.getLogger(pantallaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaProductos().setVisible(true);
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
    private javax.swing.JButton anadirProductos;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JComboBox<String> cbParametros;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listaPrecios;
    private javax.swing.JLabel logo;
    private javax.swing.JButton modificarProducto;
    private javax.swing.JButton nuevoProducto;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

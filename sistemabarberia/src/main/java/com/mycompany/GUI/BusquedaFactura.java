/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.FacturaDataSource;
import com.mycompany.sistemabarberia.JPACOntrollers.clientesJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.descuentosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.detalleproductoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.estadofacturaJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.facturaencabezadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.parametrosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.precioshistoricosproductosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.productosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.serviciosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipodescuentoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipopagoJpaController;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.clientes;
import com.mycompany.sistemabarberia.descuentofactura;
import com.mycompany.sistemabarberia.descuentos;
import com.mycompany.sistemabarberia.detalleproducto;
import com.mycompany.sistemabarberia.detalleservicio;
import com.mycompany.sistemabarberia.estadofactura;
import com.mycompany.sistemabarberia.facturaencabezado;
import com.mycompany.sistemabarberia.precioshistoricosproductos;
import com.mycompany.sistemabarberia.productos;
import com.mycompany.sistemabarberia.tipodescuento;
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
import com.mycompany.sistemabarberia.tipopago;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
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
public class BusquedaFactura extends javax.swing.JFrame {
    

    private facturaencabezado facturaSeleccionada;
    private Validaciones validar = new Validaciones();
    
    private facturaencabezadoJpaController facturaDAO = new facturaencabezadoJpaController();
    private productosJpaController productosDAO =  new productosJpaController();
    private serviciosJpaController serviciosDAO = new serviciosJpaController();
    private precioshistoricosproductosJpaController preciosDAO= new precioshistoricosproductosJpaController();
    private List<precioshistoricosproductos> preciosBD = preciosDAO.findprecioshistoricosproductosEntities();
    private clientesJpaController clientesDAO = new clientesJpaController();
    private tipopagoJpaController tipopagoDAO = new tipopagoJpaController();
    private tipodescuentoJpaController tipoDescuentosDAO = new tipodescuentoJpaController();
    private estadofacturaJpaController estadoFacturaDAO = new estadofacturaJpaController();
    private List<estadofactura> estadosFacturaBD = estadoFacturaDAO.findestadofacturaEntities();
    private empleadoJpaController empleadoDAO = new empleadoJpaController();
    private parametrosJpaController parametrosDAO = new parametrosJpaController();
    private descuentosJpaController descuentosDAO = new descuentosJpaController();
    private detalleproductoJpaController detallesProdDao = new detalleproductoJpaController();
        
    private FacturaDataSource dataSource;
    private ImageIcon imagen;
    private Icon icono;
    private java.util.Date dt = new java.util.Date();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String currentTime = sdf.format(dt);

    /**
     * Creates new form nuevoTipoDescuento
     */
    public BusquedaFactura() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        for(int i = 0 ; i <estadosFacturaBD.size() ; i++)
        {
            cbEstados.addItem(estadosFacturaBD.get(i).toString());
        }
        for(int i = 0; i < tablaFactura.getColumnCount(); i++)
        {
            cbParametros.addItem(tablaFactura.getColumnName(i));
        }
        fechaLabel.setText("Fecha: " + currentTime);
        TableColumnModel columnModel = tablaFactura.getColumnModel();
        columnModel.removeColumn(columnModel.getColumn(0));
        cargarTabla();

    }
    
    public void imprimirFactura()
    {
        DefaultTableModel modelo = (DefaultTableModel) tablaFactura.getModel();
        facturaencabezado factura = facturaDAO.findfacturaencabezado(Integer.parseInt(modelo.getValueAt(tablaFactura.getSelectedRow(),0).toString()));
        //detalles producto
        EntityManager em = descuentosDAO.getEntityManager();
        
        String hqlDetalleProd = "FROM detalleproducto E WHERE E.IDFacturaEncabezado = :idFactura";
        Query queryDetalleProd = em.createQuery(hqlDetalleProd);
        queryDetalleProd.setParameter("idFactura",factura.getIdfacturaencabezado());
        List<detalleproducto> detallesProd = queryDetalleProd.getResultList();
        //detalles servicios
        
        String hqlDetalleServ = "FROM detalleservicio E WHERE E.IDFacturaEncabezado = :idFactura";
        Query queryDetalleServ = em.createQuery(hqlDetalleServ);
        queryDetalleServ.setParameter("idFactura",factura.getIdfacturaencabezado());
        List<detalleservicio> detallesServ = queryDetalleServ.getResultList();
        
        
        Object[][] arrayDetallesFactura;
        arrayDetallesFactura = new Object[detallesProd.size() + detallesServ.size()][3];
      
    for(int i = 0; i < detallesProd.size();i++)
    {
        for(int j = 0; j < 3 ; j++)
        {
            switch(j)
            {
                case 0:
                arrayDetallesFactura[i][0] = detallesProd.get(i).getCantidad();
                break;
                case 1:
                arrayDetallesFactura[i][1] = productosDAO.findproductos(detallesProd.get(i).getIDProducto()).getNomProducto();
                break;
                case 2:
                arrayDetallesFactura[i][2] = detallesProd.get(i).getPrecio();
                break;
            }
            
        }
    }
    for(int i = detallesProd.size() ; i < detallesProd.size() + detallesServ.size() ;i++)
    {
        for(int j = 0; j < 3 ; j++)
        {
            switch(j)
            {
                case 0:
                arrayDetallesFactura[i][0] = detallesServ.get(i-detallesProd.size()).getCantidad();
                break;
                case 1:
                arrayDetallesFactura[i][1] = serviciosDAO.findservicios(detallesServ.get(i-detallesProd.size()).getIDServicio()).getNomServicio();
                break;
                case 2:
                arrayDetallesFactura[i][2] = detallesServ.get(i-detallesProd.size()).getPrecio();
                break;
            }
            
        }
    }
    
    //descuento factura
        String hql = "FROM descuentofactura E WHERE E.IDFactura = :idFactura AND E.Activo = 1";
        Query query = em.createQuery(hql);
        query.setParameter("idFactura",factura.getIdfacturaencabezado());
        List<descuentofactura> descuento = query.getResultList();
    
        HashMap param = new HashMap();
        param.put("IDFactura", parametrosDAO.findparametros(2).getLlave() + String.format("%0" + 8 + "d",factura.getIdfacturaencabezado()));
        param.put("NombreCliente", clientesDAO.findclientes(factura.getIDCliente()).getNomCliente());
        param.put("ApellidoCliente", clientesDAO.findclientes(factura.getIDCliente()).getApeCliente());
        param.put("NumDocumento", clientesDAO.findclientes(factura.getIDCliente()).getNumDocumento());
        param.put("FechaFactura", factura.getFechaFactura());
        param.put("NomVendedor",empleadoDAO.findempleado(factura.getIDVendedor()).getNomEmpleado());
        param.put("NomBarbero",empleadoDAO.findempleado(factura.getIDBarbero()).getNomEmpleado());
        param.put("Cai", parametrosDAO.findparametros(factura.getIDParametro()).getLlave());
        param.put("Impuesto",0.15);
        param.put("Descuento",descuento.isEmpty() ? 0.00 : descuento.get(descuento.size()-1).getValor());
        
        try {
            JasperReport reporteFactura = JasperCompileManager.compileReport("src/main/resources/Reportes/report1.jrxml");
            JasperPrint print = JasperFillManager.fillReport(
                    reporteFactura,
                    param, 
                    dataSource.getDataSource(arrayDetallesFactura));
            JasperViewer view = new JasperViewer(print,false);
            view.setVisible(true);
            view.setTitle("Factura " + factura.getIdfacturaencabezado());
            view.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        } catch (JRException ex) {
            Logger.getLogger(PantallaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarTabla()
    {
        DefaultTableModel modelo = (DefaultTableModel)tablaFactura.getModel();
        modelo.setRowCount(0);
        tablaFactura.setModel(modelo);
        List<facturaencabezado> facturasEnBd = facturaDAO.findfacturaencabezadoEntities();
            for(facturaencabezado factura : facturasEnBd){
                    modelo.addRow(
                    new Object[]{
                        factura.getIdfacturaencabezado(),
                        parametrosDAO.findparametros(2).getLlave() + String.format("%0" + 8 + "d",factura.getIdfacturaencabezado()),
                        empleadoDAO.findempleado(factura.getIDVendedor()).getNomEmpleado(),
                       empleadoDAO.findempleado(factura.getIDBarbero()).getNomEmpleado(),
                        clientesDAO.findclientes(factura.getIDCliente()).getNomCliente(),
                        factura.getFechaFactura(),
                       tipopagoDAO.findtipopago(factura.getIDTipoPago()).getTipoPago(),
                       estadoFacturaDAO.findestadofactura(factura.getIDEstado()).getNombreEstado(),
                    }
                );
            } 
    }
    
    private void cargarTablaBusquedaId(int IDProducto)
    {
        double precioActual = 0;
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaFactura.getModel();
        modelo.setRowCount(0);
        tablaFactura.setModel(modelo);
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
        jLabel2 = new javax.swing.JLabel();
        cbParametros = new javax.swing.JComboBox<>();
        buscarTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFactura = new javax.swing.JTable();
        botonBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        imprimirReporte = new javax.swing.JButton();
        cbEstados = new javax.swing.JComboBox<>();
        modificarEstado = new javax.swing.JButton();
        fechaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("BUSQUEDA DE FACTURAS");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar por:");

        cbParametros.setBackground(new java.awt.Color(30, 33, 34));
        cbParametros.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        buscarTxt.setBackground(new java.awt.Color(30, 33, 34));
        buscarTxt.setForeground(new java.awt.Color(255, 255, 255));
        buscarTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        buscarTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscarTxtFocusGained(evt);
            }
        });
        buscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarTxtKeyTyped(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tablaFactura.setBackground(new java.awt.Color(30, 33, 34));
        tablaFactura.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaFactura.setForeground(new java.awt.Color(255, 255, 255));
        tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDFactura", "Número", "Vendedor", "Barbero", "Cliente", "Fecha", "Tipo de Pago", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaFactura.getTableHeader().setReorderingAllowed(false);
        tablaFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFacturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaFactura);
        if (tablaFactura.getColumnModel().getColumnCount() > 0) {
            tablaFactura.getColumnModel().getColumn(0).setResizable(false);
            tablaFactura.getColumnModel().getColumn(1).setResizable(false);
            tablaFactura.getColumnModel().getColumn(2).setResizable(false);
            tablaFactura.getColumnModel().getColumn(3).setResizable(false);
            tablaFactura.getColumnModel().getColumn(4).setResizable(false);
            tablaFactura.getColumnModel().getColumn(5).setResizable(false);
            tablaFactura.getColumnModel().getColumn(6).setResizable(false);
            tablaFactura.getColumnModel().getColumn(7).setResizable(false);
        }
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaFactura.getColumnCount();i++)
        {
            tablaFactura.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaFactura.setShowGrid(true);
        tablaFactura.setGridColor(Color.BLACK);

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        botonBuscar.setBorderPainted(false);
        botonBuscar.setContentAreaFilled(false);
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listar.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);

        botonRegresar.setBackground(new java.awt.Color(189, 158, 76));
        botonRegresar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonRegresar.setText("CANCELAR");
        botonRegresar.setRequestFocusEnabled(false);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        imprimirReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimirReporte.png"))); // NOI18N
        imprimirReporte.setContentAreaFilled(false);
        imprimirReporte.setEnabled(false);
        imprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirReporteActionPerformed(evt);
            }
        });

        cbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        modificarEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificarEstadoFactura.png"))); // NOI18N
        modificarEstado.setContentAreaFilled(false);
        modificarEstado.setEnabled(false);
        modificarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbEstados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscarTxt)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(imprimirReporte))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        fechaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaLabel.setForeground(new java.awt.Color(255, 255, 255));
        fechaLabel.setText("Fecha:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237)
                .addComponent(tituloPantalla)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaLabel)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
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
                .addContainerGap(17, Short.MAX_VALUE))
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

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaFactura().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void buscarTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarTxtFocusGained
        // TODO add your handling code here:
        buscarTxt.selectAll();
    }//GEN-LAST:event_buscarTxtFocusGained

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:

        switch(cbParametros.getSelectedItem().toString())
        {
            case "ID Servicio":
            cargarTablaBusquedaId(Integer.parseInt(buscarTxt.getText()));
            return;
//            case "Nombre":
//            cargarTablaBusquedaNombre(buscarTxt.getText());
//            return;
//            case "Precio Actual":
//            cargarTablaBusquedaPrecio(Double.parseDouble(buscarTxt.getText()));
//            return;
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void buscarTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTxtKeyTyped
        
    }//GEN-LAST:event_buscarTxtKeyTyped

    private void modificarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarEstadoActionPerformed
        // TODO add your handling code here:
        if(tablaFactura.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(null,
                    "Debes seleccionar una factura para cambiar su estado",
                    "Selecciona una factura",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //target factura seleccionada
        facturaSeleccionada = facturaDAO.findfacturaencabezado(Integer.parseInt(tablaFactura.getValueAt(tablaFactura.getSelectedRow(),0).toString()));
        
        if(cbEstados.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(null,
                    "Debes seleccionar un estado.",
                    "Selecciona un estado",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        facturaSeleccionada.setIDEstado(Character.getNumericValue(cbEstados.getSelectedItem().toString().charAt(0)));
        try {
            facturaDAO.edit(facturaSeleccionada);
            cargarTabla();
            cbEstados.setSelectedIndex(0);
        } catch (Exception ex) {
            Logger.getLogger(BusquedaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_modificarEstadoActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tablaFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFacturaMouseClicked
        // TODO add your handling code here:
        if(tablaFactura.getSelectedRow() != -1)
        {
           imprimirReporte.setEnabled(true);
           modificarEstado.setEnabled(true);
        }
    }//GEN-LAST:event_tablaFacturaMouseClicked

    private void imprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirReporteActionPerformed
        // TODO add your handling code here:
        imprimirFactura();
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
            java.util.logging.Logger.getLogger(BusquedaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedaFactura().setVisible(true);
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
    
    private void busquedaTabla()
    {
        DefaultTableModel modelo = (DefaultTableModel) tablaFactura.getModel();
        TableRowSorter sorter = new TableRowSorter<>(modelo);
        tablaFactura.setRowSorter(sorter);
        
      buscarTxt.getDocument().addDocumentListener(new DocumentListener() {
         @Override
         public void insertUpdate(DocumentEvent e) {
            search(buscarTxt.getText());
         }
         @Override
         public void removeUpdate(DocumentEvent e) {
            search(buscarTxt.getText());
         }
         @Override
         public void changedUpdate(DocumentEvent e) {
            search(buscarTxt.getText());
         }
         public void search(String str) {
            if (str.length() == 0) {
               sorter.setRowFilter(null);
            } else {
               sorter.setRowFilter(RowFilter.regexFilter(str));
            }
         }
      });
   }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JComboBox<String> cbEstados;
    private javax.swing.JComboBox<String> cbParametros;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JButton imprimirReporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton modificarEstado;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

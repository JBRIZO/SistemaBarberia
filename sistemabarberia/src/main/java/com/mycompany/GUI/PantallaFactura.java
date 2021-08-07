/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.clientesJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.parametrosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.precioshistoricoserviciosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.precioshistoricosproductosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.productosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.puestohistoricoempleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.serviciosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipodescuentoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipopagoJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.clientes;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.parametros;
import com.mycompany.sistemabarberia.precioshistoricoservicios;
import com.mycompany.sistemabarberia.precioshistoricosproductos;
import com.mycompany.sistemabarberia.productos;
import com.mycompany.sistemabarberia.puestohistoricoempleado;
import com.mycompany.sistemabarberia.servicios;
import com.mycompany.sistemabarberia.tipodescuento;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import com.mycompany.sistemabarberia.tipopago;
import com.mycompany.sistemabarberia.usuarios;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Kesil
 */
public class PantallaFactura extends javax.swing.JFrame {
    

    
    private Validaciones validar = new Validaciones();
    
    private usuarios usuarios = new usuarios(); 
    private UsuarioSingleton singleton = UsuarioSingleton.getUsuario(usuarios);
    
    private productosJpaController productosDAO =  new productosJpaController();
    private serviciosJpaController serviciosDAO = new serviciosJpaController();
   
    private precioshistoricosproductosJpaController preciosProductosDAO= new precioshistoricosproductosJpaController();
    private precioshistoricoserviciosJpaController preciosServiciosDAO = new precioshistoricoserviciosJpaController();
    
    private empleadoJpaController empleadosDAO = new empleadoJpaController();
    private clientesJpaController clientesDAO = new clientesJpaController();
    private List<clientes> clientesBD = clientesDAO.findclientesEntities();
    private tipopagoJpaController tipopagoDAO = new tipopagoJpaController();
    private List<tipopago> tipospagoBD = tipopagoDAO.findtipopagoEntities();
    private tipodescuentoJpaController descuentosDAO = new tipodescuentoJpaController();
    private List<tipodescuento>  descuentosBD = descuentosDAO.findtipodescuentoEntities();
    private parametrosJpaController parametrosDAO = new parametrosJpaController();
    private parametros CAI = parametrosDAO.findparametros(parametrosDAO.getparametrosCount());
    
    
    
    private ImageIcon imagen;
    private Icon icono;
    private java.util.Date dt = new java.util.Date();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String currentTime = sdf.format(dt);

    /**
     * Creates new form nuevoTipoDescuento
     */
    public PantallaFactura() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        this.setTitle("Facturación");
        empleado empleadoActual = empleadosDAO.findempleado(singleton.getCuenta().getIDEmpleado());
        //cbCajero.setText(empleadoActual.getNomEmpleado() + " " + empleadoActual.getApeEmpleado());
        cargarBarberos();
        cbOpciones.setSelectedIndex(0);
         cargarProductoATabla();
        for(int i = 0; i < clientesBD.size() ; i++)
        {
            cbCliente.addItem(clientesBD.get(i).toString());
        }  
        for(int i = 0; i < tipospagoBD.size() ; i++)
        {
            cbTipoPago.addItem(tipospagoBD.get(i).toString());
        }  
        for(int i = 0; i < descuentosBD.size() ; i++)
        {
            cbDescuento.addItem(descuentosBD.get(i).toString());
        }
        caiLabel.setText("CAI: " + CAI.getLlave());
        fecha.setText(currentTime);
    }
    
    public void cargarProductoATabla()
    {
        TableColumnModel columnModel = tablaFactura.getColumnModel();
        columnModel.removeColumn(columnModel.getColumn(1));
        
    }
    
    public void cargarBarberos()
    {
        EntityManager em = empleadosDAO.getEntityManager();
        String hql = "FROM puestohistoricoempleado E WHERE E.IDPuesto = 2 AND E.Activo = 1";
        Query query = em.createQuery(hql);
        List<puestohistoricoempleado> results = query.getResultList();
        for(int i = 0; i < results.size();i++)
        {
            cbBarbero.addItem(empleadosDAO.findempleado(results.get(i).getIDEmpleado()).toString());
        }
    }
    
    private void calcularSubtotal()
    {
      double subtotal = 0.00;
      if(tablaFactura.getRowCount() > 0)
      {
          for(int i  = 0 ; i < tablaFactura.getRowCount(); i++)
      {
           subtotal = subtotal + Double.parseDouble(tablaFactura.getValueAt(i,4).toString());
      }
      subTotal.setText(Double.toString(subtotal));
      }else
      {
          subTotal.setText("0.00");
      }
      
    }
    
    public void cargarProductos()
    {
        List<precioshistoricosproductos> preciosProductosBD = preciosProductosDAO.findprecioshistoricosproductosEntities();
        double precioActual = 0;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setRowCount(0);
        modelo.addColumn("Id Producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock Actual");
        tablaProductosServicios.setModel(modelo);
        List<productos> productosEnBD = productosDAO.findproductosEntities();
        
            for(productos producto : productosEnBD){
                if(producto.isActivo())
                {
                    for(int i = 0; i < preciosProductosBD.size() ; i++)
                    {
                        //precio actual del producto
                        if(preciosProductosBD.get(i).getIDProducto() == producto.getIdproducto() && preciosProductosBD.get(i).isActivo())
                        {
                            precioActual = preciosProductosBD.get(i).getPrecio();
                        }
                    }
                
                    modelo.addRow(
                    new Object[]{
                        producto.getIdproducto(),
                        producto.getNomProducto(),
                        precioActual,
                        producto.getStockActual(),
                    }
                );
                }
            }
    }
    
    public void cargarServicios()
    {
        List<precioshistoricoservicios> preciosServicioBD = preciosServiciosDAO.findprecioshistoricoserviciosEntities();
        double precioActual = 0;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setRowCount(0);
        modelo.addColumn("Id Servicio");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        tablaProductosServicios.setModel(modelo);
        List<servicios> serviciosEnBd = serviciosDAO.findserviciosEntities();
        
            for(servicios servicio : serviciosEnBd){
                if(servicio.isActivo())
                {
                    for(int i = 0; i < preciosServicioBD.size() ; i++)
                    {
                        //precio actual del producto
                        if(preciosServicioBD.get(i).getIDServicio() == servicio.getIdservicio() && preciosServicioBD.get(i).isActivo())
                        {
                            precioActual = preciosServicioBD.get(i).getPrecio();
                        }
                    }
                
                    modelo.addRow(
                    new Object[]{
                        servicio.getIdservicio(),
                        servicio.getNomServicio(),
                        precioActual
                    }
                );
                }  
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        numFactura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        registrarCliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbTipoPago = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbDescuento = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cajeroTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFactura = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        fecha1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        subTotal = new javax.swing.JTextField();
        botonFacturar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        botonBuscar1 = new javax.swing.JButton();
        caiLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductosServicios = new javax.swing.JTable();
        buscarTxt = new javax.swing.JTextField();
        botonQuitar = new javax.swing.JButton();
        botonAnadir = new javax.swing.JButton();
        cbOpciones = new javax.swing.JComboBox<>();
        cbBarbero = new javax.swing.JComboBox<>();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Num. Factura:");

        numFactura.setEditable(false);
        numFactura.setBackground(new java.awt.Color(30, 33, 34));
        numFactura.setDocument(new JTextFieldLimit(25));
        numFactura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numFactura.setForeground(new java.awt.Color(255, 255, 255));
        numFactura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        numFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numFacturaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                numFacturaFocusLost(evt);
            }
        });
        numFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numFacturaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cliente:");

        cbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONSUMIDOR FINAL" }));

        registrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadirCliente.png"))); // NOI18N
        registrarCliente.setContentAreaFilled(false);
        registrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarClienteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo de Pago:");

        cbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descuento:");

        cbDescuento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha:");

        fecha.setEditable(false);
        fecha.setBackground(new java.awt.Color(30, 33, 34));
        fecha.setDocument(new JTextFieldLimit(25));
        fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        fecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fechaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fechaFocusLost(evt);
            }
        });
        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cajero:");

        cajeroTxt.setEditable(false);
        cajeroTxt.setBackground(new java.awt.Color(30, 33, 34));
        cajeroTxt.setDocument(new JTextFieldLimit(25));
        cajeroTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cajeroTxt.setForeground(new java.awt.Color(255, 255, 255));
        cajeroTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cajeroTxt.setEnabled(false);
        cajeroTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cajeroTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cajeroTxtFocusLost(evt);
            }
        });
        cajeroTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajeroTxtActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Barbero:");

        jScrollPane1.setBackground(new java.awt.Color(30, 33, 34));

        tablaFactura.setBackground(new java.awt.Color(30, 33, 34));
        tablaFactura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaFactura.setForeground(new java.awt.Color(255, 255, 255));
        tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Servicio/Producto", "Descripción", "Precio Unitario", "Descuento", "Total "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaFactura.setSelectionBackground(new java.awt.Color(30, 33, 34));
        tablaFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFacturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaFactura);
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaFactura.getColumnCount();i++)
        {
            tablaFactura.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaFactura.setShowGrid(true);
        tablaFactura.setGridColor(Color.BLACK);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sub Total:");

        fecha1.setEditable(false);
        fecha1.setBackground(new java.awt.Color(30, 33, 34));
        fecha1.setDocument(new JTextFieldLimit(25));
        fecha1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fecha1.setForeground(new java.awt.Color(255, 255, 255));
        fecha1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        fecha1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fecha1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fecha1FocusLost(evt);
            }
        });
        fecha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecha1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TOTAL:");

        subTotal.setEditable(false);
        subTotal.setBackground(new java.awt.Color(30, 33, 34));
        subTotal.setDocument(new JTextFieldLimit(25));
        subTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subTotal.setForeground(new java.awt.Color(255, 255, 255));
        subTotal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        subTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                subTotalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                subTotalFocusLost(evt);
            }
        });
        subTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subTotalActionPerformed(evt);
            }
        });

        botonFacturar.setBackground(new java.awt.Color(189, 158, 76));
        botonFacturar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonFacturar.setText("FACTURAR");
        botonFacturar.setRequestFocusEnabled(false);
        botonFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFacturarActionPerformed(evt);
            }
        });

        botonBuscar.setBackground(new java.awt.Color(189, 158, 76));
        botonBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        botonBuscar.setText("BUSCAR");
        botonBuscar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botonBuscar.setRequestFocusEnabled(false);
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonBuscar1.setBackground(new java.awt.Color(189, 158, 76));
        botonBuscar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recargar.png"))); // NOI18N
        botonBuscar1.setText("REINICIAR");
        botonBuscar1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botonBuscar1.setRequestFocusEnabled(false);
        botonBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscar1ActionPerformed(evt);
            }
        });

        caiLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        caiLabel.setForeground(new java.awt.Color(255, 255, 255));
        caiLabel.setText("CAI:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar:");

        tablaProductosServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductosServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosServiciosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProductosServicios);

        buscarTxt.setBackground(new java.awt.Color(30, 33, 34));
        buscarTxt.setDocument(new JTextFieldLimit(25));
        buscarTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscarTxt.setForeground(new java.awt.Color(255, 255, 255));
        buscarTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        buscarTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscarTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buscarTxtFocusLost(evt);
            }
        });
        buscarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTxtActionPerformed(evt);
            }
        });

        botonQuitar.setBackground(new java.awt.Color(189, 158, 76));
        botonQuitar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        botonQuitar.setText("QUITAR");
        botonQuitar.setEnabled(false);
        botonQuitar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botonQuitar.setRequestFocusEnabled(false);
        botonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarActionPerformed(evt);
            }
        });

        botonAnadir.setBackground(new java.awt.Color(189, 158, 76));
        botonAnadir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        botonAnadir.setText("AÑADIR");
        botonAnadir.setEnabled(false);
        botonAnadir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botonAnadir.setRequestFocusEnabled(false);
        botonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirActionPerformed(evt);
            }
        });

        cbOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productos", "Servicios" }));
        cbOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOpcionesActionPerformed(evt);
            }
        });

        cbBarbero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel10))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(botonQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(caiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbBarbero, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cajeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbCliente, 0, 170, Short.MAX_VALUE)
                                            .addComponent(cbTipoPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(numFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(registrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(cajeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel8))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cbBarbero, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("FACTURACION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(458, 458, 458)
                        .addComponent(titulo)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFacturarActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_botonFacturarActionPerformed

    private void numFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numFacturaFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_numFacturaFocusGained

    private void numFacturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numFacturaFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_numFacturaFocusLost

    private void numFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numFacturaActionPerformed

    private void fechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaFocusGained

    private void fechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaFocusLost

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaActionPerformed

    private void cajeroTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cajeroTxtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_cajeroTxtFocusGained

    private void cajeroTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cajeroTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cajeroTxtFocusLost

    private void cajeroTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajeroTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajeroTxtActionPerformed

    private void registrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarClienteActionPerformed
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarClientes().setVisible(true);
            }
        });
    }//GEN-LAST:event_registrarClienteActionPerformed

    private void fecha1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fecha1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha1FocusGained

    private void fecha1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fecha1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha1FocusLost

    private void fecha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecha1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha1ActionPerformed

    private void subTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_subTotalFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_subTotalFocusGained

    private void subTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_subTotalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_subTotalFocusLost

    private void subTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subTotalActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedaFactura().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscar1ActionPerformed
        // TODO add your handling code here:
        List<clientes> clientesBD = clientesDAO.findclientesEntities();
        for(int i = 0; i < clientesBD.size() ; i++)
        {
            cbCliente.addItem(clientesBD.get(i).toString());
        }  
        cbBarbero.setSelectedIndex(0);
        cbCliente.setSelectedIndex(0);
        cbTipoPago.setSelectedIndex(0);
        cbDescuento.setSelectedIndex(0);
        cbOpciones.setSelectedIndex(0);
        DefaultTableModel modelo = (DefaultTableModel)tablaFactura.getModel();
        modelo.setRowCount(0);
        calcularSubtotal();
        botonAnadir.setEnabled(false);
        botonQuitar.setEnabled(false);
    }//GEN-LAST:event_botonBuscar1ActionPerformed

    private void buscarTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarTxtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarTxtFocusGained

    private void buscarTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarTxtFocusLost

    private void buscarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarTxtActionPerformed

    private void botonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel)tablaFactura.getModel();
        tablaFactura.setModel(modelo);
        modelo.removeRow(tablaFactura.getSelectedRow());
        calcularSubtotal();
    }//GEN-LAST:event_botonQuitarActionPerformed

    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed
        // TODO add your handling code here:
       if(cbOpciones.getSelectedIndex() == 0)
       {
        DefaultTableModel modelo = (DefaultTableModel)tablaFactura.getModel();
        tablaFactura.setModel(modelo);
         modelo.addRow(
                    new Object[]{
                        1,
                        true,
                        tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 1),
                        tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 2),
                        1,
                        1 * Double.parseDouble(tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 2).toString())
                    });
         calcularSubtotal();
       }else
       {
           DefaultTableModel modelo = (DefaultTableModel)tablaFactura.getModel();
        tablaFactura.setModel(modelo);
         modelo.addRow(
                    new Object[]{
                        1,
                        true,
                        tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 1),
                        tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 2),
                        1,
                        1 * Double.parseDouble(tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 2).toString())
                    });
         calcularSubtotal();
       }
        
    }//GEN-LAST:event_botonAnadirActionPerformed

    private void cbOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOpcionesActionPerformed
        // TODO add your handling code here:
        if(cbOpciones.getSelectedIndex() == 0)
        {
            cargarProductos();
        }else
        {
            cargarServicios();
        }
    }//GEN-LAST:event_cbOpcionesActionPerformed

    private void tablaProductosServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosServiciosMouseClicked
        // TODO add your handling code here:
        if(tablaProductosServicios.getSelectedRow() != -1)
        {
            botonAnadir.setEnabled(true);
        }
    }//GEN-LAST:event_tablaProductosServiciosMouseClicked

    private void tablaFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFacturaMouseClicked
        // TODO add your handling code here:
        if(tablaFactura.getSelectedRow()!= -1)
        {
          botonQuitar.setEnabled(true);  
        }
    }//GEN-LAST:event_tablaFacturaMouseClicked

    
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
            java.util.logging.Logger.getLogger(PantallaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaFactura().setVisible(true);
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
    
    
    private String convertirDates(String Fecha)
    {
        String[] palabras  = Fecha.split("-");
       
        return palabras[2] + "/" + palabras[1] + "/" + palabras[0];
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnadir;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonBuscar1;
    private javax.swing.JButton botonFacturar;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JLabel caiLabel;
    private javax.swing.JTextField cajeroTxt;
    private javax.swing.JComboBox<String> cbBarbero;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbDescuento;
    private javax.swing.JComboBox<String> cbOpciones;
    private javax.swing.JComboBox<String> cbTipoPago;
    private javax.swing.JTextField fecha;
    private javax.swing.JTextField fecha1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField numFactura;
    private javax.swing.JButton registrarCliente;
    private javax.swing.JTextField subTotal;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JTable tablaProductosServicios;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

   
}

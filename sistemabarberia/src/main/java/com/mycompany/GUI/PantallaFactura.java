/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.FacturaDataSource;
import com.mycompany.sistemabarberia.JPACOntrollers.clientesJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.datosempresaJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.descuentofacturaJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.detalleproductoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.detalleservicioJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.facturaencabezadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.facturasanuladasJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.parametrosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.precioshistoricoserviciosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.precioshistoricosproductosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.productosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.serviciosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipodescuentoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipopagoJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.clientes;
import com.mycompany.sistemabarberia.datosempresa;
import com.mycompany.sistemabarberia.descuentofactura;
import com.mycompany.sistemabarberia.descuentos;
import com.mycompany.sistemabarberia.detalleproducto;
import com.mycompany.sistemabarberia.detalleservicio;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.facturaencabezado;
import com.mycompany.sistemabarberia.facturasanuladas;
import com.mycompany.sistemabarberia.parametros;
import com.mycompany.sistemabarberia.permisosusuario;
import com.mycompany.sistemabarberia.precioshistoricoservicios;
import com.mycompany.sistemabarberia.precioshistoricosproductos;
import com.mycompany.sistemabarberia.productos;
import com.mycompany.sistemabarberia.puestohistoricoempleado;
import com.mycompany.sistemabarberia.servicios;
import com.mycompany.sistemabarberia.tipodescuento;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import com.mycompany.sistemabarberia.tipopago;
import com.mycompany.sistemabarberia.usuarios;
import java.awt.Image;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
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
public class PantallaFactura extends javax.swing.JFrame {
    
    private permisosusuario permisosUsuario;
    private FacturaDataSource dataSource;
    private Validaciones validar = new Validaciones();
    
    private usuarios usuarios = new usuarios(); 
    private UsuarioSingleton singleton = UsuarioSingleton.getUsuario(usuarios);
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    
    private productosJpaController productosDAO =  new productosJpaController(emf);
    private serviciosJpaController serviciosDAO = new serviciosJpaController(emf);
    private descuentofacturaJpaController descuentosDAO = new descuentofacturaJpaController(emf);
    private datosempresaJpaController datosempresaDAO = new datosempresaJpaController(emf);
   
    private precioshistoricosproductosJpaController preciosProductosDAO= new precioshistoricosproductosJpaController(emf);
    private List<precioshistoricosproductos> preciosProductosBD = preciosProductosDAO.findprecioshistoricosproductosEntities();
    private precioshistoricoserviciosJpaController preciosServiciosDAO = new precioshistoricoserviciosJpaController(emf);
    
    private empleadoJpaController empleadosDAO = new empleadoJpaController(emf);
    private clientesJpaController clientesDAO = new clientesJpaController(emf);
    private tipopagoJpaController tipopagoDAO = new tipopagoJpaController(emf);
    private List<tipopago> tipospagoBD = tipopagoDAO.findtipopagoEntities();
    private tipodescuentoJpaController tipoDescuentosDAO = new tipodescuentoJpaController(emf);
    private List<tipodescuento>  descuentosBD = tipoDescuentosDAO.findtipodescuentoEntities();
    private parametrosJpaController parametrosDAO = new parametrosJpaController(emf);
    private parametros CAI = null;
    private facturaencabezadoJpaController encabezadoDAO = new facturaencabezadoJpaController(emf);
    private facturasanuladasJpaController anuladasDAO = new facturasanuladasJpaController(emf);

    
    
    private descuentos descuentoFactura;
    

    private java.util.Date dt = new java.util.Date();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private java.text.SimpleDateFormat formatoEspanol = new java.text.SimpleDateFormat("dd/MM/yyyy");
    private java.text.SimpleDateFormat sdfSql = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String currentTime = sdf.format(dt);
    String currentTimeSql = sdfSql.format(dt);
     Border redBorder = BorderFactory.createLineBorder(Color.RED, 1);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 1);
    Border defaultBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true);

    /**
     * Creates new form nuevoTipoDescuento
     */
    public PantallaFactura() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
        setIconImage(icon);
        this.setTitle("Facturación");
        advertenciaCAI.setVisible(false);
        validarCAI();
        cargarClientes();
        empleado empleadoActual = empleadosDAO.findempleado(singleton.getCuenta().getIDEmpleado());
        cajeroTxt.setText(empleadoActual.getNomEmpleado() + " " + empleadoActual.getApeEmpleado());
        cargarBarberos();
        cbOpciones.setSelectedIndex(0);
        //ocultar columnas de servicio/producto
         TableColumnModel columnModel = tablaFactura.getColumnModel();
        columnModel.removeColumn(columnModel.getColumn(1));
        for(int i = 0; i < tipospagoBD.size() ; i++)
        {
            cbTipoPago.addItem(tipospagoBD.get(i).toString());
        }  
        for(int i = 0; i < descuentosBD.size() ; i++)
        {
            cbDescuento.addItem(descuentosBD.get(i).toString());
        }
        caiLabel.setText(CAI == null? "CAI INVÁLIDO": "CAI: " + CAI.getLlave());
        fecha.setText(currentTime);
        numFactura();
        isvTxt.setText("0.15");
        
        
        permisosUsuario = verificarPermisos();
        botonBuscar.setEnabled(permisosUsuario.isActivo());
    }
    
    private permisosusuario verificarPermisos(){
        try{
            EntityManager em = tipopagoDAO.getEntityManager();
            String hqlDetalleProd = "FROM permisosusuario E WHERE E.IDUsuario = :IDUsuario AND E.IDPermiso = :IDPermiso";
            Query queryPermisos = em.createQuery(hqlDetalleProd);
            queryPermisos.setParameter("IDUsuario",singleton.getCuenta().getIdusuario());
            queryPermisos.setParameter("IDPermiso",11);
            permisosusuario permisos = (permisosusuario)queryPermisos.getSingleResult();
            return permisos;
        }catch(javax.persistence.NoResultException ex){
            permisosusuario permisos = new permisosusuario();
            permisos.setActivo(false);
            return permisos;
        }
    }
    
    private void validarCAI()
    {
        List<parametros> parametrosBD = parametrosDAO.findparametrosEntities();
        
        //ultima factura
        Query query = parametrosDAO.getEntityManager().createQuery("FROM facturaencabezado ORDER BY idfacturaencabezado DESC");
        query.setMaxResults(1);
        int numeroFactura = 0;
        try{
            facturaencabezado lastFactura = (facturaencabezado) query.getSingleResult();
            numeroFactura = lastFactura.getIdfacturaencabezado()+1;
        }catch(javax.persistence.NoResultException Ex)
        {
            numeroFactura = 1;
        }
        
        Date fechaHoy = new Date(000000000);
        try {
            fechaHoy = formatoEspanol.parse(currentTime);
        } catch (ParseException ex) {
            Logger.getLogger(PantallaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        //desactivar CAI que no cumplen con los requisitos
        for(int i = 0 ; i < parametrosBD.size() ; i++)
        {
            if(parametrosBD.get(i).getFechaFinal().before(fechaHoy) || parametrosBD.get(i).getRangoFinal() < numeroFactura)
            {
             parametros parametro = parametrosDAO.findparametros(parametrosBD.get(i).getIdparametro());
             parametro.setActivo(false);
                try {
                    parametrosDAO.edit(parametro);
                } catch (Exception ex) {
                    Logger.getLogger(PantallaFactura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            //encontrar los paramertros que pueden ser validos
        Query queryParametrosActivos = parametrosDAO.getEntityManager().createQuery("FROM parametros E WHERE E.Activo = :idEstado");
        queryParametrosActivos.setParameter("idEstado",true);
        List<parametros> parametrosActivos = (List<parametros>) queryParametrosActivos.getResultList();
        
        if(parametrosActivos.isEmpty())
        {
            advertenciaCAI.setVisible(true);
            CAI = null;
            botonFacturar.setEnabled(false);
            caiLabel.setText(CAI == null? "CAI INVÁLIDO": "CAI: " + CAI.getLlave());
            return;
        }
        
        for(parametros parametro : parametrosActivos)
        {
            if(fechaHoy.compareTo(parametro.getFechaInicio()) >= 0 && fechaHoy.compareTo(parametro.getFechaFinal()) <= 0  &&
                    numeroFactura <= parametro.getRangoFinal())
            {
                CAI = parametro;
                botonFacturar.setEnabled(true);
            }else
            {
                CAI = null;
                botonFacturar.setEnabled(false);
            }
        }
            
        //advertir al usuario que no hay ningun CAI valido o que esta
        //a punto de vencer
        if(CAI == null)
        {
            JOptionPane.showMessageDialog(this,"No has añadido un CAI válido con el que puedas facturar.\n"
                    + "Agrega uno en parametros en el menú de configuracion de factura.",
                    "CAI vencido",JOptionPane.ERROR_MESSAGE);
            botonFacturar.setEnabled(false);
            advertenciaCAI.setVisible(true);
            return;
        }else
        {
        LocalDate fechaFinal = validar.convertToLocalDateViaInstant(CAI.getFechaFinal());
        Period periodo = Period.between(LocalDate.now(),fechaFinal);
        if(periodo.getDays() < 3 )
        {
//           JOptionPane.showMessageDialog(null,"El CAI actual esta a punto de vencer, por favor ingresa uno nuevo.", 
//                   "CAI Próximo a Vencer",
//                   JOptionPane.WARNING_MESSAGE); 
//           advertenciaCAI.setVisible(true);
           return;
        }   
        if(CAI.getRangoFinal() - numeroFactura <= 5)
        {
            JOptionPane.showMessageDialog(null,"Estas a punto de llegar al rango final para este CAI, por favor ingresa uno nuevo.", 
                   "CAI Próximo a Vencer",
                   JOptionPane.WARNING_MESSAGE); 
           advertenciaCAI.setVisible(true);
        }
        }
        //
        if(CAI.getRangoInicial() > numeroFactura + 1){
            for(int i = numeroFactura ; i < CAI.getRangoInicial() ; i++){
                //crear factura para anular
                facturaencabezado facturaAnular = new facturaencabezado();
                 facturaAnular.setFechaFactura(currentTimeSql);
                facturaAnular.setIDVendedor(singleton.getCuenta().getIDEmpleado());
                facturaAnular.setIDBarbero(null);
                facturaAnular.setIDCliente(0);
                facturaAnular.setIDTipoPago(1);
                facturaAnular.setIDParametro(CAI.getIdparametro());
                facturaAnular.setIDEstado(3);
                facturaAnular.setNumTarjeta(null);
                facturaAnular.setTotalFactura(0);
                try{
                    encabezadoDAO.create(facturaAnular);
                }catch(Exception Ex){
                System.out.println("error en encabezado");
                Ex.printStackTrace();}
                //agregar a la tabla de facturas anuladas
                facturasanuladas anuladas = new facturasanuladas();
                anuladas.setMotivo("Anuladas por vencimiento de CAI");
                anuladas.setFechaAnulacion(fechaHoy);
                anuladas.setIDFacturaEncabezado(i);
                anuladas.setIDEmpleado(singleton.getCuenta().getIDEmpleado());
                try{
                    anuladasDAO.create(anuladas);
                }catch(Exception Ex){System.out.println("error en anuladas");
                Ex.printStackTrace();
                }  
            }
            JOptionPane.showMessageDialog(null,"Se han anulado las facturas del N°" + numeroFactura + " al " + (CAI.getRangoInicial()-1) + " por vencimiento del CAI anterior.");
        }
}
    
    
    public int puestoEmpleadoActual(int idEmpleados)
    {
        EntityManager em = empleadosDAO.getEntityManager();
        String hql = "SELECT IDPuesto FROM puestohistoricoempleado E WHERE E.IDEmpleado = :idEmpleado AND E.Activo = 1";
        Query query = em.createQuery(hql);
        query.setParameter("idEmpleado", idEmpleados);
        int idPuesto = (int)query.getSingleResult();
        
        return idPuesto;
    }
    
    private void numFactura()
    {
        List<facturaencabezado> listaFacturasBD = encabezadoDAO.findfacturaencabezadoEntities();
        datosempresa numFacturaBD = datosempresaDAO.finddatosempresa(5);
        
        numFactura.setText(encabezadoDAO.getfacturaencabezadoCount() == 0 
            ?numFacturaBD.getValor()+ String.format("%0" + 8 + "d",1 )
            :numFacturaBD.getValor() + String.format("%0" + 8 + "d", listaFacturasBD.get(listaFacturasBD.size()-1).getIdfacturaencabezado() + 1));
    }
    
    public void cargarClientes()
    {
        List<clientes> clientesBD = clientesDAO.findclientesEntities();
        
         for(int i = cbCliente.getItemCount() - 1; i > 0 ; i--)
        {
           cbCliente.removeItemAt(i);
        }
        
        for(int i = 0; i < clientesBD.size() ; i++)
        {
            if(clientesBD.get(i).isActivo())
            {
                cbCliente.addItem(clientesBD.get(i).toString());
            } 
        }  
    }
   
    private void calcularTotal()
    {
        double total = 0.00;
        total = Double.parseDouble(subTotal.getText()) + (Double.parseDouble(subTotal.getText()) * Double.parseDouble(isvTxt.getText()));
        totalTxt.setText(Double.toString(round(total,2)));
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
    

    
    private void imprimirFactura()
    {
        List<facturaencabezado> listaFacturasBD = encabezadoDAO.findfacturaencabezadoEntities();
        java.text.SimpleDateFormat formatoFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
        facturaencabezado factura = listaFacturasBD.get(listaFacturasBD.size()-1);
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
        param.put("logo",getClass().getResourceAsStream("/Imagenes/logoBarberia.jpeg"));
        param.put("LimiteEmision",formatoFecha.format(parametrosDAO.findparametros(CAI.getIdparametro()).getFechaFinal()));
        param.put("NoTarjeta",factura.getNumTarjeta() == null ? "No Aplica" : factura.getNumTarjeta());
        param.put("MotivoDescuento", descuento.isEmpty() ? "No Aplica" : tipoDescuentosDAO.findtipodescuento(descuento.get(descuento.size()-1).getIDDescuento()).getNomDescuento());
        param.put("IDFactura", datosempresaDAO.finddatosempresa(5).getValor() + String.format("%0" + 8 + "d",factura.getIdfacturaencabezado()));
        param.put("NombreCliente", clientesDAO.findclientes(factura.getIDCliente()).getNomCliente() + " " + clientesDAO.findclientes(factura.getIDCliente()).getApeCliente());
        param.put("NumDocumento", clientesDAO.findclientes(factura.getIDCliente()).getNumDocumento());
        param.put("FechaFactura", factura.getFechaFactura());
        param.put("NomVendedor",empleadosDAO.findempleado(factura.getIDVendedor()).getNomEmpleado());
        param.put("NomBarbero",cbBarbero.getSelectedIndex() == 0?
                "No Aplica":
                empleadosDAO.findempleado(factura.getIDBarbero()).getNomEmpleado());
        param.put("Cai", parametrosDAO.findparametros(factura.getIDParametro()).getLlave());
        param.put("Impuesto",0.15);
        param.put("Descuento",descuento.isEmpty() ? 0.00 : descuento.get(descuento.size()-1).getValor());
        param.put("MontoTarjeta",factura.getMontoTarjeta());
        
        try {
            JasperReport reporteFactura = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reportes/report1.jrxml"));
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
    
    //calcular el total por filas
    private void calcularTotalFila()
    {
        double totalFila = 0.00;
        for(int i = 0 ; i < tablaFactura.getRowCount(); i++)
        {
            if(Double.parseDouble(tablaFactura.getValueAt(i,4).toString()) > 0.00)
            {
                totalFila = Double.parseDouble(tablaFactura.getValueAt(i,0).toString()) * Double.parseDouble(tablaFactura.getValueAt(i,3).toString()) * 
                        (1-Double.parseDouble(tablaFactura.getValueAt(i,4).toString()));
                tablaFactura.setValueAt(totalFila,i,5);
            }else
            {
               totalFila = Double.parseDouble(tablaFactura.getValueAt(i,0).toString()) * Double.parseDouble(tablaFactura.getValueAt(i,3).toString());
               tablaFactura.setValueAt(totalFila,i,5);  
            }
        }
        
    }
    
    private void calcularSubtotal()
    {
      double subtotal = 0.00;
      if(tablaFactura.getRowCount() > 0)
      {
          for(int i  = 0 ; i < tablaFactura.getRowCount(); i++)
      {
           subtotal = subtotal + Double.parseDouble(tablaFactura.getValueAt(i,5).toString());
      }
      subTotal.setText(Double.toString(round(subtotal,2)));
      }else
      {
          subTotal.setText("0.00");
      }
      calcularTotal();
    }
    
    public void cargarProductos()
    {       
        double precioActual = 0;
        tablaProductosServicios.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "ID Producto", "Nombre", "Precio", "Stock Actual"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        DefaultTableModel modelo = (DefaultTableModel) tablaProductosServicios.getModel();
        
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
            //busquedaTabla();
    }
    
    public void cargarProductosBusqueda(String buscar)
    {       
        double precioActual = 0;
        tablaProductosServicios.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "ID Producto", "Nombre", "Precio", "Stock Actual"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        DefaultTableModel modelo = (DefaultTableModel) tablaProductosServicios.getModel();
        List<productos> productosEnBD = productosDAO.findproductosEntities();
        List<productos> productosFiltrados = new ArrayList();
        
        for(int i = 0 ; i < productosEnBD.size() ; i++)
        {
            try{
                if(productosEnBD.get(i).getIdproducto() == Integer.parseInt(buscar))
            {
                productosFiltrados.add(productosEnBD.get(i));
            }
            }catch(NumberFormatException ex)
            {
                if(productosEnBD.get(i).getNomProducto().equalsIgnoreCase(buscar))
                {
                   productosFiltrados.add(productosEnBD.get(i)); 
                }
            }
            
        }
        if(productosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(tablaProductosServicios,"No se encontro un producto.","Producto no encontrado",JOptionPane.ERROR_MESSAGE);
            cargarProductos();
            return;
        }
            for(productos producto : productosFiltrados){
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
            //busquedaTabla();
    }
    
    public void cargarServicios()
    {
        
        List<precioshistoricoservicios> preciosServicioBD = preciosServiciosDAO.findprecioshistoricoserviciosEntities();
        double precioActual = 0;
        tablaProductosServicios.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "ID Servicio", "Nombre", "Precio"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        
        DefaultTableModel modelo = (DefaultTableModel) tablaProductosServicios.getModel();
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
         //busquedaTabla();    
    }
    
    public void cargarServiciosBusqueda(String buscar)
    {
        
        List<precioshistoricoservicios> preciosServicioBD = preciosServiciosDAO.findprecioshistoricoserviciosEntities();
        double precioActual = 0;
        tablaProductosServicios.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "ID Servicio", "Nombre", "Precio"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        
        DefaultTableModel modelo = (DefaultTableModel) tablaProductosServicios.getModel();
        tablaProductosServicios.setModel(modelo);
        List<servicios> serviciosEnBd = serviciosDAO.findserviciosEntities();
         List<servicios> serviciosFiltrados = new ArrayList();
        
        for(int i = 0 ; i < serviciosEnBd.size() ; i++)
        {
            try{
                if(serviciosEnBd.get(i).getIdservicio() == Integer.parseInt(buscar))
            {
                serviciosFiltrados.add(serviciosEnBd.get(i));
            }
            }catch(NumberFormatException ex)
            {
                if(serviciosEnBd.get(i).getNomServicio().equalsIgnoreCase(buscar))
                {
                   serviciosFiltrados.add(serviciosEnBd.get(i)); 
                }
            }
            
        }
        if(serviciosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(tablaProductosServicios,"No se encontro un servicio.","Servicio no encontrado",JOptionPane.ERROR_MESSAGE);
            cargarServicios();
            return;
        }
        
            for(servicios servicio : serviciosFiltrados){
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
         //busquedaTabla();    
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
        totalTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        subTotal = new javax.swing.JTextField();
        botonFacturar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        botonReiniciar = new javax.swing.JButton();
        caiLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductosServicios = new javax.swing.JTable();
        buscarTxt = new javax.swing.JTextField();
        botonQuitar = new javax.swing.JButton();
        botonAnadir = new javax.swing.JButton();
        cbOpciones = new javax.swing.JComboBox<>();
        cbBarbero = new javax.swing.JComboBox<>();
        botonCantidad = new javax.swing.JButton();
        ISV = new javax.swing.JLabel();
        isvTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        noTarjeta = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        montoTarjeta = new javax.swing.JTextField();
        advertenciaCAI = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        menuGerente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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
        cbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClienteActionPerformed(evt);
            }
        });

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
        cbTipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoPagoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descuento:");

        cbDescuento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cbDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDescuentoActionPerformed(evt);
            }
        });

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
        jScrollPane1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jScrollPane1PropertyChange(evt);
            }
        });
        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyTyped(evt);
            }
        });

        tablaFactura.setBackground(new java.awt.Color(30, 33, 34));
        tablaFactura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaFactura.setForeground(new java.awt.Color(255, 255, 255));
        tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Servicio/Producto", "ID", "Descripción", "Precio Unitario", "Descuento", "Total "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
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
        tablaFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaFactura.setSelectionBackground(new java.awt.Color(30, 33, 34));
        tablaFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFacturaMouseClicked(evt);
            }
        });
        tablaFactura.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablaFacturaPropertyChange(evt);
            }
        });
        tablaFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaFacturaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tablaFacturaKeyTyped(evt);
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

        totalTxt.setEditable(false);
        totalTxt.setBackground(new java.awt.Color(30, 33, 34));
        totalTxt.setDocument(new JTextFieldLimit(25));
        totalTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalTxt.setForeground(new java.awt.Color(255, 255, 255));
        totalTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        totalTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                totalTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                totalTxtFocusLost(evt);
            }
        });
        totalTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTxtActionPerformed(evt);
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

        botonReiniciar.setBackground(new java.awt.Color(189, 158, 76));
        botonReiniciar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recargar.png"))); // NOI18N
        botonReiniciar.setText("REINICIAR");
        botonReiniciar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botonReiniciar.setRequestFocusEnabled(false);
        botonReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReiniciarActionPerformed(evt);
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
        tablaProductosServicios.getTableHeader().setReorderingAllowed(false);
        tablaProductosServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosServiciosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProductosServicios);
        if (tablaProductosServicios.getColumnModel().getColumnCount() > 0) {
            tablaProductosServicios.getColumnModel().getColumn(0).setResizable(false);
            tablaProductosServicios.getColumnModel().getColumn(1).setResizable(false);
            tablaProductosServicios.getColumnModel().getColumn(2).setResizable(false);
            tablaProductosServicios.getColumnModel().getColumn(3).setResizable(false);
        }

        buscarTxt.setBackground(new java.awt.Color(30, 33, 34));
        buscarTxt.setDocument(new JTextFieldLimit(25));
        buscarTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscarTxt.setForeground(new java.awt.Color(255, 255, 255));
        buscarTxt.setToolTipText("Busca por Id o por Nombre.");
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

        botonCantidad.setBackground(new java.awt.Color(189, 158, 76));
        botonCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        botonCantidad.setText("MODIFICAR CANTIDAD");
        botonCantidad.setEnabled(false);
        botonCantidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botonCantidad.setRequestFocusEnabled(false);
        botonCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCantidadActionPerformed(evt);
            }
        });

        ISV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ISV.setForeground(new java.awt.Color(255, 255, 255));
        ISV.setText("ISV");

        isvTxt.setEditable(false);
        isvTxt.setBackground(new java.awt.Color(30, 33, 34));
        isvTxt.setDocument(new JTextFieldLimit(25));
        isvTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        isvTxt.setForeground(new java.awt.Color(255, 255, 255));
        isvTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        isvTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                isvTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                isvTxtFocusLost(evt);
            }
        });
        isvTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isvTxtActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("No. Tarjeta:");

        noTarjeta.setBackground(new java.awt.Color(30, 33, 34));
        noTarjeta.setDocument(new JTextFieldLimit(16));
        noTarjeta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        noTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        noTarjeta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        noTarjeta.setEnabled(false);
        noTarjeta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                noTarjetaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                noTarjetaFocusLost(evt);
            }
        });
        noTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noTarjetaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Monto Tarjeta:");

        montoTarjeta.setBackground(new java.awt.Color(30, 33, 34));
        montoTarjeta.setDocument(new JTextFieldLimit(8));
        montoTarjeta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        montoTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        montoTarjeta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        montoTarjeta.setEnabled(false);
        montoTarjeta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                montoTarjetaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                montoTarjetaFocusLost(evt);
            }
        });
        montoTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montoTarjetaActionPerformed(evt);
            }
        });

        advertenciaCAI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        advertenciaCAI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/advertencia.png"))); // NOI18N
        advertenciaCAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                advertenciaCAIMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
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
                                                    .addComponent(cbTipoPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(registrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(noTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(291, 291, 291)
                                .addComponent(jLabel3))
                            .addComponent(caiLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(montoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))
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
                                .addComponent(botonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonReiniciar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(botonQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonCantidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(advertenciaCAI, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(ISV)
                                .addGap(18, 18, 18)
                                .addComponent(isvTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbBarbero, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(noTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(montoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(caiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ISV)
                                .addComponent(isvTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advertenciaCAI, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );

        titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("FACTURACION");

        menuGerente.setBackground(new java.awt.Color(189, 158, 76));
        menuGerente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        menuGerente.setText("MENU GERENTE");
        menuGerente.setRequestFocusEnabled(false);
        menuGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGerenteActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.jpg"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(341, 341, 341)
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuGerente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titulo)
                        .addComponent(menuGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
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

    private void botonFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFacturarActionPerformed
        List<facturaencabezado> listaFacturasBD = encabezadoDAO.findfacturaencabezadoEntities();
        EntityManager em = productosDAO.getEntityManager();
        //modelo para obtener valores del campo oculto
        DefaultTableModel modelo = (DefaultTableModel) tablaFactura.getModel();
        //validar que se haya ingresado productos y servicios para facturar
        if(tablaFactura.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null,"No hay nada para facturar.","",JOptionPane.ERROR_MESSAGE);
            return;
        }
        //validar que se haya seleccionado un metodo de pago.
        if(cbTipoPago.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(null,"Debes seleccionar un método de pago.","Selecciona un método de pago",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //validar tipos de pago y valores
         if(Character.getNumericValue(cbTipoPago.getSelectedItem().toString().charAt(0)) == 2 && noTarjeta.getText().equals(""))
        {
           JOptionPane.showMessageDialog(null,"Debes introducir un número de tarjeta o cambiar el tipo de pago.","Numero de tarjeta vacío",JOptionPane.ERROR_MESSAGE);
            return;
        }else if(Character.getNumericValue(cbTipoPago.getSelectedItem().toString().charAt(0)) == 3 && noTarjeta.getText().equals("") && montoTarjeta.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Debes introducir un número de tarjeta y el monto que se pagara con la tarjeta.","Pago mixto incompleto",JOptionPane.ERROR_MESSAGE);
            return;
        }
         
         if(Character.getNumericValue(cbTipoPago.getSelectedItem().toString().charAt(0)) == 2)
        {
        //validar que el numero de tarjeta ingresado sae valido
        if(!validarTarjetaCredito(noTarjeta.getText()))
        {
            JOptionPane.showMessageDialog(null,"Ese es un número de tarjeta inválido, por favor ingresa un número de tarjeta válido. \n"
                    + "Ejemplo: 5390700823285988. Tarjetas Admitidas: Visa, Master Card, American Express.",
                    "Tarjeta Inválida",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        }
         
        if(Character.getNumericValue(cbTipoPago.getSelectedItem().toString().charAt(0)) == 3)
        {
            if(!validarMontoTarjeta(montoTarjeta.getText()))
        {
            JOptionPane.showMessageDialog(null,"El formato del monto es inválido, recuerda que el monto es la cantidad de dinero que se pagará con la tarjeta. \n "
                    + "Debe ser mayor a 0, con el formato 0000.00. No puedes pagar la totalidad de la factura con tarjeta en el tipo de pago mixto, \n para eso elige el tipo de pago con tarjeta.","Monto Inválido",JOptionPane.ERROR_MESSAGE);
            return;
        }
        //validar que el numero de tarjeta ingresado sae valido
        if(!validarTarjetaCredito(noTarjeta.getText()))
        {
            JOptionPane.showMessageDialog(null,"Ese es un número de tarjeta inválido, por favor ingresa un número de tarjeta válido. \n"
                    + "Ejemplo: 5390700823285988",
                    "Tarjeta Inválida",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        }
        
        //validar que no se pueda facrturar servicios cuando no hay barberos,
        //tampoco se debe dejar facturar cuando no hay servicios pero si barbero
        int contadorServicios = 0;
        for(int i = 0 ; i < tablaFactura.getRowCount() ; i++)
        {
            if(Integer.parseInt(modelo.getValueAt(i,1).toString()) == 1){contadorServicios++;}
            if(Integer.parseInt(modelo.getValueAt(i,1).toString()) == 1 && cbBarbero.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(null,"Seleccione un barbero para llevar a cabo los servicios.","Selecciona un barbero",JOptionPane.ERROR_MESSAGE);
            return;
            }
        }
        if(contadorServicios == 0 && cbBarbero.getSelectedIndex() != 0)
            {
                JOptionPane.showMessageDialog(null,"No puedes seleccionar un barbero cuando no hay servicios por facturar.","Barbero inválido",JOptionPane.ERROR_MESSAGE);
            return;
            }
        
        
   detalleproductoJpaController detalleProdDAO = new detalleproductoJpaController(emf);
   detalleservicioJpaController detalleServicioDAO = new detalleservicioJpaController(emf);
   boolean procesoConExito = true;
   
    //encabezado de la factura
    facturaencabezado encabezado = new facturaencabezado();
    encabezado.setFechaFactura(currentTimeSql);
    encabezado.setIDVendedor(singleton.getCuenta().getIDEmpleado());
    encabezado.setIDBarbero(cbBarbero.getSelectedIndex() == 0 ? null : Character.getNumericValue(cbBarbero.getSelectedItem().toString().charAt(0)));
    encabezado.setIDCliente(cbCliente.getSelectedIndex() == 0 ? 0 : Character.getNumericValue((cbCliente.getSelectedItem().toString().charAt(0))));
    encabezado.setIDTipoPago(Character.getNumericValue(cbTipoPago.getSelectedItem().toString().charAt(0)));
    encabezado.setIDParametro(CAI.getIdparametro());
    encabezado.setIDEstado(1);
    encabezado.setNumTarjeta(noTarjeta.getText().equals("") ? null : noTarjeta.getText());
    encabezado.setTotalFactura(Double.parseDouble(totalTxt.getText()));
    if(cbTipoPago.getSelectedIndex() == 2)
    {
        encabezado.setMontoTarjeta(Double.parseDouble(totalTxt.getText()));
    }else
    {
        if(cbTipoPago.getSelectedIndex() == 3)
        {
            encabezado.setMontoTarjeta(Double.parseDouble(montoTarjeta.getText()));  
        }
    }
        try {
            encabezadoDAO.create(encabezado);
        } catch (Exception ex) {
            procesoConExito = false;
            Logger.getLogger(PantallaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    //detalle de productos
    for(int i = 0 ; i < tablaFactura.getRowCount() ; i++)
    {
        
        //0 significa que el articulo en detalle es un producto
        if(Integer.parseInt(modelo.getValueAt(i,1).toString()) == 0)
        {
            //encontrar el precio actual del producto
            
            String hql = "FROM precioshistoricosproductos E WHERE E.IDProducto = :idProducto AND E.Activo = 1";
            Query query = em.createQuery(hql);
            query.setParameter("idProducto",Integer.parseInt(tablaFactura.getValueAt(i,1).toString()));
            precioshistoricosproductos precio = (precioshistoricosproductos)query.getSingleResult();
            
            //creacion de objeto para JPA Hibernate y seteando los atributos
            detalleproducto detalleProductos = new detalleproducto();
            detalleProductos.setCantidad(Integer.parseInt(tablaFactura.getValueAt(i,0).toString()));
            detalleProductos.setIDFacturaEncabezado(listaFacturasBD.isEmpty()
                    ?1 
                    :listaFacturasBD.get(listaFacturasBD.size() - 1).getIdfacturaencabezado() + 1);
            detalleProductos.setIDProducto(Integer.parseInt(tablaFactura.getValueAt(i,1).toString()));
            detalleProductos.setPrecio(precio.getPrecio());
              //disminuir inventario
            productos disminuirProducto = productosDAO.findproductos(Integer.parseInt(tablaFactura.getValueAt(i,1).toString()));
            disminuirProducto.setStockActual(disminuirProducto.getStockActual() - Integer.parseInt(tablaFactura.getValueAt(i,0).toString()));
            try
            {
              detalleProdDAO.create(detalleProductos);  
              productosDAO.edit(disminuirProducto);
              procesoConExito = true;
            }catch(Exception ex)
            {
                procesoConExito = false;
                Logger.getLogger(PantallaFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //detalle de servicios
    for(int i = 0 ; i < tablaFactura.getRowCount() ; i++)
    {
        //1 significa que el detalle de esa fila es un servicio
        if(Integer.parseInt(modelo.getValueAt(i,1).toString()) == 1)
        {
            //encontrar el precio actual del producto
            String hql = "FROM precioshistoricoservicios E WHERE E.IDServicio = :idServicio AND E.Activo = 1";
            Query query = em.createQuery(hql);
            query.setParameter("idServicio",Integer.parseInt(tablaFactura.getValueAt(i,1).toString()));
            precioshistoricoservicios precio = (precioshistoricoservicios)query.getSingleResult();
            
            //creacion de objeto JPA
            detalleservicio detalleServicios = new detalleservicio();
            detalleServicios.setCantidad(Integer.parseInt(tablaFactura.getValueAt(i,0).toString()));
            detalleServicios.setIDFacturaEncabezado(listaFacturasBD.isEmpty() 
                    ? 1 
                    :listaFacturasBD.get(listaFacturasBD.size() - 1).getIdfacturaencabezado() + 1);
            detalleServicios.setIDServicio(Integer.parseInt(tablaFactura.getValueAt(i,1).toString()));
            detalleServicios.setPrecio(precio.getPrecio());
            try {
                detalleServicioDAO.create(detalleServicios);
                procesoConExito = true;
            } catch (Exception ex) {
                procesoConExito = false;
                Logger.getLogger(PantallaFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //descuento de factura
    if(cbDescuento.getSelectedIndex() != 0)
    {
        //valor del descuento en la bd
       String hql = "FROM descuentos E WHERE E.IDTipoDescuento = :idTipoDescuento AND E.Activo = 1";
        Query query = em.createQuery(hql);
        query.setParameter("idTipoDescuento",Character.getNumericValue(cbDescuento.getSelectedItem().toString().charAt(0)));
        descuentos descuentoValor = (descuentos)query.getSingleResult();
    descuentofactura descuento = new descuentofactura();
    descuento.setIDFactura(listaFacturasBD.isEmpty() 
                    ? 1 
                    :listaFacturasBD.get(listaFacturasBD.size() - 1).getIdfacturaencabezado() + 1);
    descuento.setIDDescuento(Character.getNumericValue(cbDescuento.getSelectedItem().toString().charAt(0)));
    descuento.setValor(descuentoValor.getValor());
    descuento.setActivo(true);
    
        try {
            descuentosDAO.create(descuento);
            procesoConExito = true;
        } catch (Exception ex) {
            Logger.getLogger(PantallaFactura.class.getName()).log(Level.SEVERE, null, ex);
            procesoConExito = false;
        } 
    }
    
     if(procesoConExito)
    {
        JOptionPane.showMessageDialog(null,"Proceso realizado con Exito");
    }
        imprimirFactura();
        validarCAI();
        botonReiniciarActionPerformed(evt);
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
                new registrarClientes(true).setVisible(true);
            }
        });
        cargarClientes();
    }//GEN-LAST:event_registrarClienteActionPerformed

    private void totalTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalTxtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_totalTxtFocusGained

    private void totalTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_totalTxtFocusLost

    private void totalTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalTxtActionPerformed

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

    private void botonReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReiniciarActionPerformed
        // TODO add your handling code here:
      
        cargarClientes();
        cbBarbero.setSelectedIndex(0);
        cbCliente.setSelectedIndex(0);
        cbDescuento.setSelectedIndex(0);
        cbTipoPago.setSelectedIndex(0);
        cbOpciones.setSelectedIndex(0);
        DefaultTableModel modelo = (DefaultTableModel)tablaFactura.getModel();
        modelo.setRowCount(0);
        calcularSubtotal();
        calcularTotal();
        botonAnadir.setEnabled(false);
        botonQuitar.setEnabled(false);
        noTarjeta.setText("");
        montoTarjeta.setText("");
        noTarjeta.setEnabled(false);
        montoTarjeta.setEnabled(false);
        numFactura();
        noTarjeta.setBorder(defaultBorder);
        montoTarjeta.setBorder(defaultBorder);
        
    }//GEN-LAST:event_botonReiniciarActionPerformed

    private void buscarTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarTxtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarTxtFocusGained

    private void buscarTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarTxtFocusLost

    private void buscarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarTxtActionPerformed
        // TODO add your handling code here:
        switch(cbOpciones.getSelectedIndex())
        {
            case 0:
                cargarProductosBusqueda(buscarTxt.getText());
                break;
            case 1:
                cargarServiciosBusqueda(buscarTxt.getText());
                break;
        }
    }//GEN-LAST:event_buscarTxtActionPerformed

    private void botonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel)tablaFactura.getModel();
        tablaFactura.setModel(modelo);
        modelo.removeRow(tablaFactura.getSelectedRow());
        calcularSubtotal();
    }//GEN-LAST:event_botonQuitarActionPerformed

    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed

        DefaultTableModel modelo = (DefaultTableModel)tablaFactura.getModel();
        // Descuentos en BD
        EntityManager em = descuentosDAO.getEntityManager();
        String hql = "FROM descuentos E WHERE E.IDTipoDescuento = :idTipoDescuento AND E.Activo = 1";
        Query query = em.createQuery(hql);
        query.setParameter("idTipoDescuento",Character.getNumericValue(cbDescuento.getSelectedItem().toString().charAt(0)));
        List<descuentos> results = query.getResultList();
        
        //valida que el usuario no agregue el mismo producto 2 veces
       if(cbOpciones.getSelectedIndex() == 0)
       {
           for(int i = 0 ; i < tablaFactura.getRowCount(); i++)
           {
             if(tablaFactura.getValueAt(i,2).toString().equals(tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(),1).toString()))
                {
               JOptionPane.showMessageDialog(null,"Ese producto ya ha sido agregado a la factura. \n"
                       + "Modifica la cantidad con el boton Modificar Cantidad.",
                       "Producto ya agregado",
                       JOptionPane.ERROR_MESSAGE);
               return;
                }  
           }
           
           //valida que el usuario no pueda facturar productos que no se encuentran en el inventario
           if(productosDAO.findproductos(Integer.parseInt(tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(),0).toString())).getStockActual() == 0)
           {
              JOptionPane.showMessageDialog(null,"Actualmente no hay unidades de ese producto en existencia. \n"
                       + "Agrega unidades en la pantalla de productos",
                       "Producto agotado.",
                       JOptionPane.ERROR_MESSAGE);
               return; 
           }
           
           //despliega mensaje de verificacion indicando al cajero que muy pronto se acabara el producto seleccionado para facturarse
           if(productosDAO.findproductos(Integer.parseInt(tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(),0).toString())).getStockActual() < productosDAO.findproductos(Integer.parseInt(tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(),0).toString())).getStockMinimo())
           {
              JOptionPane.showMessageDialog(null,"Las unidades en existencia de este producto son menores a las unidades mínimas preestablecidas.\n"
                       + "Se recomienda comprar mas unidades de este producto.",
                       "Producto por agotarse.",
                       JOptionPane.WARNING_MESSAGE); 
           }
         int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Ingresa la cantidad de unidades de producto a facturar.",
                "Cantidad",
                JOptionPane.PLAIN_MESSAGE));
        if(cantidad == 0)
        {
            cantidad = 1;
        }
        if(cantidad > Integer.parseInt(tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(),3).toString()))
        {
            JOptionPane.showMessageDialog(null,"No existen tantas unidades de ese producto","Cantidad Inválida",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        tablaFactura.setModel(modelo);
         modelo.addRow(
                    new Object[]{
                        cantidad,
                        0,
                        tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 0),
                        tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 1),
                        tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 2),
                        cbDescuento.getSelectedIndex() == 0 ? 0.00 : results.get(results.size()-1).getValor(),
                        1 * Double.parseDouble(tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 2).toString())
                    });
         calcularTotalFila();
         calcularSubtotal();
       }else
       {
           //validar que este seleccionado un barbero para poder realizar los servicios
               if(cbBarbero.getSelectedIndex() == 0)
               {
                  JOptionPane.showMessageDialog(null,"Debes seleccionar un barbero para poder realizar esos servicios. ",
                       "Barbero no seleccionado",
                       JOptionPane.ERROR_MESSAGE); 
                  return;
               }
           //llenar servicios
           for(int i = 0 ; i < tablaFactura.getRowCount(); i++)
           {
               
               //valida que el usuario no agregue el mismo servicio 2 veces
             if(tablaFactura.getValueAt(i,2).toString().equals(tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(),1).toString()))
                {
               JOptionPane.showMessageDialog(null,"Ese servicio ya ha sido agregado a la factura. \n"
                       + "Modifica la cantidad con el boton Modificar Cantidad.",
                       "Producto ya agregado",
                       JOptionPane.ERROR_MESSAGE);
               return;
                }  
           } 
           
        tablaFactura.setModel(modelo);
        modelo.addRow(
                    new Object[]{
                        1,
                        1,
                        tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 0),
                        tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 1),
                        tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 2),
                        cbDescuento.getSelectedIndex() == 0 ? 0.00 : results.get(results.size()-1).getValor(),
                        1 * Double.parseDouble(tablaProductosServicios.getValueAt(tablaProductosServicios.getSelectedRow(), 2).toString())
                    });
        calcularTotalFila();
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
          botonCantidad.setEnabled(true);
        }
    }//GEN-LAST:event_tablaFacturaMouseClicked

    private void jScrollPane1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1KeyTyped

    private void tablaFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaFacturaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaFacturaKeyTyped

    private void jScrollPane1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jScrollPane1PropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jScrollPane1PropertyChange

    private void tablaFacturaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablaFacturaPropertyChange
        // TODO add your handling code here:
      
    }//GEN-LAST:event_tablaFacturaPropertyChange

    private void tablaFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaFacturaKeyPressed
        // TODO add your handling code here:
        calcularTotalFila();
        calcularSubtotal();
    }//GEN-LAST:event_tablaFacturaKeyPressed

    private void botonCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCantidadActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel)tablaFactura.getModel();
        tablaFactura.setModel(modelo);
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Ingresa la cantidad específica de este producto o servicio.",
                "Cantidad",
                JOptionPane.PLAIN_MESSAGE));
        if(cantidad == 0)
        {
            cantidad = 1;
        }
        if(cantidad > productosDAO.findproductos(Integer.parseInt(modelo.getValueAt(tablaFactura.getSelectedRow(),2).toString())).getStockActual())
        {
            JOptionPane.showMessageDialog(null,"No existen tantas unidades de ese producto","Cantidad Inválida",JOptionPane.ERROR_MESSAGE);
            return;
        }
        modelo.setValueAt(cantidad,tablaFactura.getSelectedRow(),0);
        calcularTotalFila();
        calcularSubtotal();
    }//GEN-LAST:event_botonCantidadActionPerformed

    private void cbDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDescuentoActionPerformed
        // TODO add your handling code here:
        if(cbCliente.getSelectedIndex() == 0 && cbDescuento.getSelectedIndex() != 0)
        {
            JOptionPane.showMessageDialog(null,"Solo los clientes registrados pueden recibir descuentos, selecciona un cliente o registra uno nuevo.","Selecciona un cliente",JOptionPane.ERROR_MESSAGE);
            cbDescuento.setSelectedIndex(0);
        }else{
        if(cbDescuento.getSelectedIndex() != 0)
        {
        EntityManager em = descuentosDAO.getEntityManager();
        String hql = "FROM descuentos E WHERE E.IDTipoDescuento = :idTipoDescuento AND E.Activo = 1";
        Query query = em.createQuery(hql);
        query.setParameter("idTipoDescuento",Character.getNumericValue(cbDescuento.getSelectedItem().toString().charAt(0)));
        descuentos results = (descuentos)query.getSingleResult();
        em.close();
        descuentoFactura = results;
        
        for(int i = 0; i < tablaFactura.getRowCount() ; i++)
        {
           tablaFactura.setValueAt(results.getValor(),i,4); 
        }
        calcularTotalFila();
        calcularSubtotal(); 
        } }
       
    }//GEN-LAST:event_cbDescuentoActionPerformed

    private void isvTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_isvTxtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_isvTxtFocusGained

    private void isvTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_isvTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_isvTxtFocusLost

    private void isvTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isvTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isvTxtActionPerformed

    private void menuGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGerenteActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        emf.close();
        this.dispose();
    }//GEN-LAST:event_menuGerenteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaLogin().setVisible(true);
            }
        });
         emf.close();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void noTarjetaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noTarjetaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_noTarjetaFocusGained

    private void noTarjetaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noTarjetaFocusLost
        // TODO add your handling code here:
        try{
        validarTarjetaCredito(noTarjeta.getText());
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_noTarjetaFocusLost

    private void noTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noTarjetaActionPerformed

    private void cbTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoPagoActionPerformed
        // TODO add your handling code here:
        try{
        if(Character.getNumericValue(cbTipoPago.getSelectedItem().toString().charAt(0)) == 2)
        {
            noTarjeta.setEnabled(true);
        }
        if(Character.getNumericValue(cbTipoPago.getSelectedItem().toString().charAt(0)) == 3)
        {
           noTarjeta.setEnabled(true);
           montoTarjeta.setEnabled(true);
        }
        if(Character.getNumericValue(cbTipoPago.getSelectedItem().toString().charAt(0)) == 1 || cbTipoPago.getSelectedIndex() == 0)
        {
            montoTarjeta.setText("");
            noTarjeta.setText("");
            noTarjeta.setEnabled(false);
            montoTarjeta.setEnabled(false);
        }
        }catch(Exception ex){
        log(ex);
        }
        
    }//GEN-LAST:event_cbTipoPagoActionPerformed

    private void montoTarjetaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_montoTarjetaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_montoTarjetaFocusGained

    private void montoTarjetaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_montoTarjetaFocusLost
        // TODO add your handling code here:
        try{
        validarMontoTarjeta(montoTarjeta.getText());
        }catch(Exception ex){
            log(ex);
        } 
    }//GEN-LAST:event_montoTarjetaFocusLost

    private void montoTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montoTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montoTarjetaActionPerformed

    private void cbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClienteActionPerformed
        // TODO add your handling code here:
        try{
        if(cbCliente.getSelectedIndex() != 0)
        {
           List<precioshistoricoservicios> preciosServicioBD = preciosServiciosDAO.findprecioshistoricoserviciosEntities();
        servicios servicio = serviciosDAO.findservicios(clientesDAO.findclientes(Character.getNumericValue(cbCliente.getSelectedItem().toString().charAt(0))).getIDServicio());
        DefaultTableModel modelo = (DefaultTableModel)tablaFactura.getModel();
        double precioActual = 0;
        //descuentos en base de datos
        EntityManager em = descuentosDAO.getEntityManager();
        String hql = "FROM descuentos E WHERE E.IDTipoDescuento = :idTipoDescuento AND E.Activo = 1";
        Query query = em.createQuery(hql);
        query.setParameter("idTipoDescuento",Character.getNumericValue(cbDescuento.getSelectedItem().toString().charAt(0)));
        List<descuentos> results = query.getResultList();
        
        //quitar el servicio favorito de otro cliente 
        for(int i = 0 ; i < tablaFactura.getRowCount() ; i++)
        {
            if(Integer.parseInt(modelo.getValueAt(i,1).toString()) == 1)
            {
                modelo.removeRow(i);
            }
        }
        if(servicio.isActivo())
        {
             for(int i = 0; i < preciosServicioBD.size() ; i++)
        {
            if(preciosServicioBD.get(i).getIDServicio() == servicio.getIdservicio() && preciosServicioBD.get(i).isActivo())
                {
                    precioActual = preciosServicioBD.get(i).getPrecio();
                }
        }
        
       modelo.addRow(
                    new Object[]{
                        1,
                        1,
                        servicio.getIdservicio(),
                        servicio.getNomServicio(),
                        precioActual,
                        cbDescuento.getSelectedIndex() == 0 ? 0.00 : results.get(results.size()-1).getValor(),
                        1 * precioActual
                    });
       calcularTotalFila();
       calcularSubtotal();
        }else
        {
              JOptionPane.showMessageDialog(null,"El servicio favorito del cliente ha sido desactivado","Sevicio favorito desactivado",JOptionPane.WARNING_MESSAGE);
        } 
        } 
        }catch(Exception ex){
            log(ex);
        }
        
        
    }//GEN-LAST:event_cbClienteActionPerformed

    private void advertenciaCAIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_advertenciaCAIMouseClicked
        // TODO add your handling code here:
        try{
        if(botonFacturar.isEnabled())
        {
            JOptionPane.showMessageDialog(null,"El CAI vence el " + formatoEspanol.format(CAI.getFechaFinal()) + ",se recomienda ingresar otro, al pasar de la fecha no se le dejará facturar.",
            "CAI a punto de vencer",
            JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"EL CAI ha vencido, si quieres seguir facturando, deberas ingresar otro desde el menú de gerente.",
                    "El CAI ha vencido",JOptionPane.ERROR_MESSAGE);
        }
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_advertenciaCAIMouseClicked

    
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
    
    //metodo para redondear doubles
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = BigDecimal.valueOf(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
    
//metodo para claidar el campo de numero de tarjeta
    public boolean validarTarjetaCredito(String jText)
    {        
        if(validar.validarNoTarjeta(jText))
        {
            noTarjeta.setBorder(greenBorder);
            return true;
        }else
        {
            noTarjeta.setBorder(redBorder);
            return false;
        }
    }
    
    public boolean validarMontoTarjeta(String jText)
    {
       double monto = 0 ;
        try{
            monto = Double.parseDouble(jText);
        }catch(NumberFormatException ex)
        {
            montoTarjeta.setBorder(redBorder);
            return false;
        }
        if(monto <= 0)
        {
            montoTarjeta.setBorder(redBorder);
            return false;
        }
        
        if(monto >= Double.parseDouble(totalTxt.getText()))
        {
            montoTarjeta.setBorder(redBorder);
            return false;
        }
         montoTarjeta.setBorder(greenBorder);
         return true;
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
    private javax.swing.JLabel ISV;
    private javax.swing.JLabel advertenciaCAI;
    private javax.swing.JButton botonAnadir;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCantidad;
    private javax.swing.JButton botonFacturar;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JButton botonReiniciar;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JLabel caiLabel;
    private javax.swing.JTextField cajeroTxt;
    private javax.swing.JComboBox<String> cbBarbero;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbDescuento;
    private javax.swing.JComboBox<String> cbOpciones;
    private javax.swing.JComboBox<String> cbTipoPago;
    private javax.swing.JTextField fecha;
    private javax.swing.JTextField isvTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JButton menuGerente;
    private javax.swing.JTextField montoTarjeta;
    private javax.swing.JTextField noTarjeta;
    private javax.swing.JTextField numFactura;
    private javax.swing.JButton registrarCliente;
    private javax.swing.JTextField subTotal;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JTable tablaProductosServicios;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField totalTxt;
    // End of variables declaration//GEN-END:variables

   
}

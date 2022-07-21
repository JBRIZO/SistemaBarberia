/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.clientesJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.serviciosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipodocumentoJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.clientes;
import com.mycompany.sistemabarberia.servicios;
import com.mycompany.sistemabarberia.tipodocumento;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author flore
 */
public class registrarClientes extends javax.swing.JFrame {
    
    private clientes clienteModificar;
    private boolean modificar = false;
    private boolean agregadoDesdeFactura = false;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    
    private clientesJpaController clientesDAO = new clientesJpaController(emf);
    private tipodocumentoJpaController tipodocumentoDAO = new tipodocumentoJpaController(emf);
    private List<tipodocumento> documentosBD = tipodocumentoDAO.findtipodocumentoEntities();
    private serviciosJpaController serviciosDAO = new serviciosJpaController(emf);
    private List<servicios> serviciosBD = serviciosDAO.findserviciosEntities();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    private java.text.SimpleDateFormat formatoFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
    private Validaciones validar = new Validaciones();
    private ImageIcon imagen;
    private Icon icono;
    Border redBorder = BorderFactory.createLineBorder(Color.RED,1);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN,1);
    Border defaultBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true);

    /**
     * Creates new form registrarClientes
     */
    public registrarClientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
        setIconImage(icon);
        this.insertarImagen(this.logo,"/Imagenes/logoBarberia.png");
       
       Reiniciar();
        for(int i = 0; i < documentosBD.size(); i++)
        {
            cbTipoDoc.addItem(documentosBD.get(i).toString());
        }
        for(int i = 0; i < serviciosBD.size(); i++)
        {
            servicioProducto.addItem(serviciosBD.get(i).toString());
        }
        
    }
    
    public registrarClientes(clientes clienteModificar)
    {
       initComponents();
        modificar = true;
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoLogin.png")).getImage();
        setIconImage(icon);
        this.insertarImagen(this.logo,"/Imagenes/logoBarberia.png");
        this.clienteModificar = clienteModificar;
        Reiniciar();
        cargarDatosModificarCliente();
        for(int i = 0; i < documentosBD.size(); i++)
        {
            cbTipoDoc.addItem(documentosBD.get(i).toString());
        }
        for(int i = 0; i < serviciosBD.size(); i++)
        {
            servicioProducto.addItem(serviciosBD.get(i).toString());
        }
        cbTipoDoc.setSelectedIndex(clienteModificar.getIDTipoDocumento()-1); 
        servicioProducto.setSelectedIndex(clienteModificar.getIDServicio()-1);
    }
    
    //agregarlo desde pantalla de facturacion 
    public registrarClientes(boolean agregar)
    {
         initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
       this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoLogin.png");
       
       Reiniciar();
        for(int i = 0; i < documentosBD.size(); i++)
        {
            cbTipoDoc.addItem(documentosBD.get(i).toString());
        }
        for(int i = 0; i < serviciosBD.size(); i++)
        {
            servicioProducto.addItem(serviciosBD.get(i).toString());
        }
        this.agregadoDesdeFactura = true;
    }
    public void Reiniciar()
    {
        formatoInvalidoNombre.setText(" ");
        formatoInvalidoApellido.setText(" ");
        formatoInvalidoTelefono.setText(" ");
        formatoInvalidoFechaNac.setText(" ");
        formatoInvalidoIdDocumento.setText(" ");
        nombresLabel.setText(" ");
        apellidosLabel.setText(" ");
        telefonoLabel.setText(" ");
        nacimientoLabel.setText(" ");
    }
    
    public void cargarDatosModificarCliente()
    {
       nombreCliente.setText(clienteModificar.getNomCliente());
       apellidosCliente.setText(clienteModificar.getApeCliente());
       telefonoCliente.setText(clienteModificar.getNumTelefono());
       fechaNacimiento.setText(convertirDates(clienteModificar.getFechaNacimiento().toString()));
       numDoc.setText(clienteModificar.getNumDocumento());
       tituloPantalla.setText("MODIFICAR CLIENTE");
       crearPerfil.setText("MODIFICAR");
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
        logo = new javax.swing.JLabel();
        crearPerfil = new javax.swing.JButton();
        datosPersonales = new javax.swing.JLabel();
        tituloPantalla = new javax.swing.JLabel();
        Cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        nombreCliente = new javax.swing.JTextField();
        telefonoCliente = new javax.swing.JTextField();
        fechaNacimiento = new javax.swing.JTextField();
        apellidosCliente = new javax.swing.JTextField();
        numDoc = new javax.swing.JTextField();
        servicioProducto = new javax.swing.JComboBox<>();
        cbTipoDoc = new javax.swing.JComboBox<>();
        formatoInvalidoNombre = new javax.swing.JLabel();
        formatoInvalidoApellido = new javax.swing.JLabel();
        formatoInvalidoTelefono = new javax.swing.JLabel();
        formatoInvalidoFechaNac = new javax.swing.JLabel();
        formatoInvalidoIdDocumento = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nombresLabel = new javax.swing.JLabel();
        apellidosLabel = new javax.swing.JLabel();
        telefonoLabel = new javax.swing.JLabel();
        nacimientoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));

        logo.setForeground(new java.awt.Color(255, 255, 255));

        crearPerfil.setBackground(new java.awt.Color(189, 158, 76));
        crearPerfil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        crearPerfil.setText("Crear Perfil");
        crearPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearPerfilActionPerformed(evt);
            }
        });

        datosPersonales.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        datosPersonales.setForeground(new java.awt.Color(255, 255, 255));
        datosPersonales.setText("DATOS PERSONALES DEL CLIENTE:");

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("REGISTRAR PERFIL DEL CLIENTE");

        Cancelar.setBackground(new java.awt.Color(189, 158, 76));
        Cancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.setPreferredSize(new java.awt.Dimension(135, 31));
        Cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelarMouseClicked(evt);
            }
        });
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(820, 329));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(794, 301));

        nombreCliente.setBackground(new java.awt.Color(30, 33, 34));
        nombreCliente.setDocument(new JTextFieldLimit(25));
        nombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        nombreCliente.setText("Nombres");
        nombreCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nombreCliente.setPreferredSize(new java.awt.Dimension(263, 42));
        nombreCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreClienteFocusLost(evt);
            }
        });
        nombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreClienteActionPerformed(evt);
            }
        });

        telefonoCliente.setBackground(new java.awt.Color(30, 33, 34));
        telefonoCliente.setDocument(new JTextFieldLimit(8));
        telefonoCliente.setForeground(new java.awt.Color(255, 255, 255));
        telefonoCliente.setText("Teléfono");
        telefonoCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        telefonoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telefonoClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                telefonoClienteFocusLost(evt);
            }
        });
        telefonoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telefonoClienteMouseClicked(evt);
            }
        });
        telefonoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoClienteActionPerformed(evt);
            }
        });

        fechaNacimiento.setBackground(new java.awt.Color(30, 33, 34));
        fechaNacimiento.setDocument(new JTextFieldLimit(25));
        fechaNacimiento.setForeground(new java.awt.Color(255, 255, 255));
        fechaNacimiento.setText("Fecha de Nacimiento");
        fechaNacimiento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        fechaNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fechaNacimientoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fechaNacimientoFocusLost(evt);
            }
        });
        fechaNacimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaNacimientoMouseClicked(evt);
            }
        });
        fechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaNacimientoActionPerformed(evt);
            }
        });

        apellidosCliente.setBackground(new java.awt.Color(30, 33, 34));
        apellidosCliente.setDocument(new JTextFieldLimit(25));
        apellidosCliente.setForeground(new java.awt.Color(255, 255, 255));
        apellidosCliente.setText("Apellidos");
        apellidosCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        apellidosCliente.setPreferredSize(new java.awt.Dimension(296, 42));
        apellidosCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                apellidosClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                apellidosClienteFocusLost(evt);
            }
        });
        apellidosCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidosClienteActionPerformed(evt);
            }
        });

        numDoc.setBackground(new java.awt.Color(30, 33, 34));
        numDoc.setForeground(new java.awt.Color(255, 255, 255));
        numDoc.setText("Número de Documento");
        numDoc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        numDoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numDocFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                numDocFocusLost(evt);
            }
        });
        numDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numDocActionPerformed(evt);
            }
        });

        servicioProducto.setBackground(new java.awt.Color(30, 33, 34));
        servicioProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        servicioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicioProductoActionPerformed(evt);
            }
        });

        cbTipoDoc.setBackground(new java.awt.Color(30, 33, 34));
        cbTipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cbTipoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoidDocumentoActionPerformed(evt);
            }
        });

        formatoInvalidoNombre.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoNombre.setText("Formato invalido.");

        formatoInvalidoApellido.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoApellido.setText("Formato invalido.");

        formatoInvalidoTelefono.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoTelefono.setText("Formato invalido.");

        formatoInvalidoFechaNac.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoFechaNac.setText("Formato invalido.");

        formatoInvalidoIdDocumento.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoIdDocumento.setText("Formato invalido.");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Servicio:");

        nombresLabel.setForeground(new java.awt.Color(255, 255, 255));
        nombresLabel.setText("Nombres:");

        apellidosLabel.setForeground(new java.awt.Color(255, 255, 255));
        apellidosLabel.setText("Apellidos:");

        telefonoLabel.setForeground(new java.awt.Color(255, 255, 255));
        telefonoLabel.setText("Teléfono:");

        nacimientoLabel.setForeground(new java.awt.Color(255, 255, 255));
        nacimientoLabel.setText("Fecha de Nacimiento:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(437, 437, 437)
                                .addComponent(jLabel1))
                            .addComponent(fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(servicioProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(formatoInvalidoTelefono))
                        .addGap(174, 174, 174)
                        .addComponent(cbTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(formatoInvalidoIdDocumento)
                            .addComponent(numDoc)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombresLabel)
                                    .addComponent(formatoInvalidoNombre)
                                    .addComponent(nombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(174, 174, 174)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(apellidosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(formatoInvalidoApellido)
                                    .addComponent(apellidosLabel)))
                            .addComponent(telefonoLabel)
                            .addComponent(nacimientoLabel)
                            .addComponent(formatoInvalidoFechaNac))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombresLabel)
                    .addComponent(apellidosLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formatoInvalidoNombre)
                    .addComponent(formatoInvalidoApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telefonoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formatoInvalidoTelefono)
                    .addComponent(formatoInvalidoIdDocumento))
                .addGap(18, 18, 18)
                .addComponent(nacimientoLabel)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(servicioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(formatoInvalidoFechaNac)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(tituloPantalla)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(crearPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205)
                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(datosPersonales))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tituloPantalla)
                        .addGap(18, 18, 18)))
                .addComponent(datosPersonales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crearPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
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

    private void telefonoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoClienteActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_telefonoClienteActionPerformed

    private void fechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaNacimientoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_fechaNacimientoActionPerformed

    private void nombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreClienteActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_nombreClienteActionPerformed

    private void apellidosClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidosClienteActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_apellidosClienteActionPerformed

    private void fechaNacimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaNacimientoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_fechaNacimientoMouseClicked

    private void crearPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPerfilActionPerformed
        // TODO add your handling code here:
        try{
        if(nombreCliente.getText().equals("Nombres") || apellidosCliente.getText().equals("Apellidos") || telefonoCliente.getText().equals("Teléfono") ||
                fechaNacimiento.getText().equals("Fecha de Nacimiento") || numDoc.getText().equals("Número de Documento"))
        {
            JOptionPane.showMessageDialog(null,"Debes rellenar todos los campos","Datos Faltantes",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(cbTipoDoc.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(null,"Debes seleccionar un tipo de documento","Tipo de Documento Inválido",JOptionPane.ERROR_MESSAGE);
            return;
        }else
        {
            if(servicioProducto.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(null,"Debes seleccionar un servicio","Servicio Inválido",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        java.util.Date birthDate = new Date(0000000000);
        String fechaNac = "00-00-0000";
        try {
        birthDate = sdf.parse(convertirFecha(fechaNacimiento.getText()));
        fechaNac = sdf.format(birthDate);
    } catch (ParseException ex) {
       JOptionPane.showMessageDialog(this, "Ingresa una fecha con formato válido.","Fecha inválida",JOptionPane.ERROR_MESSAGE);
               return;
    }
        clientes registrarClientes = new clientes();
        
        if(modificar)
        {
        registrarClientes.setIdcliente(clienteModificar.getIdcliente());
        }
        
        registrarClientes.setNomCliente(nombreCliente.getText());
        registrarClientes.setApeCliente(apellidosCliente.getText());
        registrarClientes.setNumTelefono(telefonoCliente.getText());
        registrarClientes.setNumDocumento(numDoc.getText());
        registrarClientes.setIDTipoDocumento(Character.getNumericValue(cbTipoDoc.getSelectedItem().toString().charAt(0)));
        registrarClientes.setIDServicio(Character.getNumericValue(servicioProducto.getSelectedItem().toString().charAt(0)));
        registrarClientes.setFechaNacimiento(Date.valueOf(fechaNac));
        registrarClientes.setActivo(true);
        
        LocalDate date = validar.convertToLocalDateViaInstant(birthDate);
        Period periodo = Period.between(date,LocalDate.now());
        if(periodo.getYears() < 18)
        {
           JOptionPane.showMessageDialog(null,"El cliente debe tener 18 años para registrarse.", "Fecha Inválida",JOptionPane.ERROR_MESSAGE); 
           return;
        }
        if(validarDocumento() && validarNombre() && validarApellido() &&  validarCamposNumero(telefonoCliente,formatoInvalidoTelefono) &&
           validarFecha(fechaNacimiento,formatoInvalidoFechaNac))
        {   
            if(modificar)
            {
                try {
            clientesDAO.edit(registrarClientes); 
            JOptionPane.showMessageDialog(null,"Operación Exitosa.");
                    Reiniciar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"No se pudo modificar el cliente, excepción: " + ex.getMessage());
            }
            }else
            {
                try {
            clientesDAO.create(registrarClientes); 
            JOptionPane.showMessageDialog(null,"Operación Exitosa.");
                    Reiniciar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"No se pudo guardar el cliente, excepción: " + ex.getMessage());
        }
            }
            
        }else{ JOptionPane.showMessageDialog(null,"Por favor, introduzca datos válidos.","Datos Inválidos",JOptionPane.ERROR_MESSAGE);}
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_crearPerfilActionPerformed

    private void numDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numDocActionPerformed

    private void nombreClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreClienteFocusLost
        try{
        if(nombreCliente.getText().equals(""))
        {
            nombreCliente.setText("Nombres");
            nombresLabel.setText(" ");
        }else
        {
        validarNombre();   
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_nombreClienteFocusLost

    private void apellidosClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidosClienteFocusLost
        // TODO add your handling code here:
        try{
        if(apellidosCliente.getText().equals(""))
        {
            apellidosCliente.setText("Apellidos");
            apellidosLabel.setText(" ");
        }else
        {
        validarApellido();    
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_apellidosClienteFocusLost

    private void nombreClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreClienteFocusGained
        // TODO add your handling code here:
        try{
        if(nombreCliente.getText().equals("Nombres"))
        {
            nombreCliente.setText("");
            nombresLabel.setText("Nombres: ");
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_nombreClienteFocusGained

    private void apellidosClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidosClienteFocusGained
        // TODO add your handling code here:
        try{
        if(apellidosCliente.getText().equals("Apellidos"))
        {
            apellidosCliente.setText("");
            apellidosLabel.setText("Apellidos: ");
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_apellidosClienteFocusGained

    private void telefonoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoClienteFocusLost
        // TODO add your handling code here:
        try{
        if(telefonoCliente.getText().equals(""))
        {
            telefonoCliente.setText("Teléfono");
            telefonoLabel.setText(" ");
        }else
        {
            validarCamposNumero(telefonoCliente,formatoInvalidoTelefono);
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_telefonoClienteFocusLost

    private void fechaNacimientoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaNacimientoFocusLost
        // TODO add your handling code here:
        try{
        if(fechaNacimiento.getText().equals(""))
        {
            fechaNacimiento.setDocument(new JTextFieldLimit(25));
            fechaNacimiento.setText("Fecha de Nacimiento");
            nacimientoLabel.setText(" ");
        }else
        {
         validarFecha(fechaNacimiento,formatoInvalidoFechaNac);   
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_fechaNacimientoFocusLost

    private void fechaNacimientoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaNacimientoFocusGained
        // TODO add your handling code here:
        try{
        if(fechaNacimiento.getText().equals("Fecha de Nacimiento"))
        {
            fechaNacimiento.setText("");
            fechaNacimiento.setDocument(new JTextFieldLimit(10));
            nacimientoLabel.setText("Fecha de Nacimiento: ");
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_fechaNacimientoFocusGained

    private void numDocFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numDocFocusGained
        // TODO add your handling code here:
        try{
        if(numDoc.getText().equals("Número de Documento"))
        {
            numDoc.setDocument(new JTextFieldLimit(13));
            numDoc.setText("");
        }
        }catch(Exception ex){
            log(ex);
        } 
    }//GEN-LAST:event_numDocFocusGained

    private void numDocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numDocFocusLost
        // TODO add your handling code here:
        try{
        if(numDoc.getText().equals(""))
        {
            numDoc.setDocument(new JTextFieldLimit(20));
            numDoc.setText("Número de Documento");
        }else
        {
            validarDocumento();
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_numDocFocusLost

    private void telefonoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telefonoClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoClienteMouseClicked

    private void telefonoClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoClienteFocusGained
        // TODO add your handling code here:
        try{
        if(telefonoCliente.getText().equals("Teléfono"))
        {
            telefonoCliente.setDocument(new JTextFieldLimit(8));
            telefonoCliente.setText("");
            telefonoLabel.setText("Teléfono: ");
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_telefonoClienteFocusGained

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        try{
        if(agregadoDesdeFactura)
        {
            this.dispose();
        }else
        {
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaClientes().setVisible(true);
            }
        });
           emf.close();
        this.dispose();
        clientesDAO.close();
        serviciosDAO.close();  
        } 
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_CancelarActionPerformed

    private void CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarMouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_CancelarMouseClicked

    private void servicioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicioProductoActionPerformed

    private void tipoidDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoidDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoidDocumentoActionPerformed

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
            java.util.logging.Logger.getLogger(registrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarClientes().setVisible(true);
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
    private boolean validarDocumento()
    {
         //validar pasaporte o identidad
        if(Character.getNumericValue(cbTipoDoc.getSelectedItem().toString().charAt(0)) == 1)
        {
            if(!validar.validarPasaporte(numDoc.getText()))
            {
                numDoc.setBorder(redBorder);
                formatoInvalidoIdDocumento.setText("Número inválido.");
                return false;
            }
        }else
        {
            if(Character.getNumericValue(cbTipoDoc.getSelectedItem().toString().charAt(0)) == 2)
            {
                if(!validar.validacionIdentidad(numDoc.getText()))
                {
                    numDoc.setBorder(redBorder);
                    formatoInvalidoIdDocumento.setText("Número inválido.");
                    return false; 
                }
            }
        }
        numDoc.setBorder(greenBorder);
        return true;
    }
    private boolean validarFecha(javax.swing.JTextField fecha, JLabel label)
    {
       if(!validar.validacionFormatoFecha(fecha.getText()) )
        {
            fecha.setBorder(redBorder);
            label.setVisible(true);
            label.setText("El formato de fecha es: dd/mm/aaaa");
            return false;
        }
        if(!validar.validacionFechaValida(fecha.getText()))
            {
            fecha.setBorder(redBorder);
            label.setVisible(true);
            label.setText("La fecha introducida es inválida.");
            return false;
            }
        
        if(!validar.isDateValid(fecha.getText()))
        {
            fecha.setBorder(redBorder);
            label.setVisible(true);
            JOptionPane.showMessageDialog(null,"Esa fecha es inválida, por favor revisa que la cantidad de dias concuerde con el mes.\nEjemplo de fecha inválida: 30/02/2021",
                    "Fecha Inválida",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else
        {
            fecha.setBorder(greenBorder);
            label.setText(" ");
            return true;
        }
    }
        
    
     private boolean validarApellido()
    {
        if(apellidosCliente.getText().matches("^.*\\d+.*$"))
        {
            apellidosCliente.setBorder(redBorder);
            formatoInvalidoApellido.setVisible(true);
            formatoInvalidoApellido.setText("Solo se permite texto en este campo.");
            return false;
        }
        if(!validar.validacionCantidadMinima(apellidosCliente.getText(),2))
            {
            apellidosCliente.setBorder(redBorder);
            formatoInvalidoApellido.setVisible(true);
            formatoInvalidoApellido.setText("El apellido debe ser de minimo 2 letras.");
            return false;
            }
        if (!validar.validacionNombres(apellidosCliente.getText()))
        {
            apellidosCliente.setBorder(redBorder);
            formatoInvalidoApellido.setVisible(true);
            formatoInvalidoApellido.setText("Cada apellido debe empezar en mayúscula.");
            return false;
        }
        if(validar.validarRepeticionCadena(apellidosCliente.getText()))
        {
            apellidosCliente.setBorder(redBorder);
            formatoInvalidoApellido.setVisible(true);
            formatoInvalidoApellido.setText("No puedes repetir tantas letras.");
            return false; 
        }
        if(validar.validacionCadenaPalabras(apellidosCliente.getText()))
        {    
            apellidosCliente.setBorder(greenBorder);
            formatoInvalidoApellido.setVisible(true);
            formatoInvalidoApellido.setText("Formato válido");
            return true;
            
        }else
        {
            apellidosCliente.setBorder(redBorder);
            formatoInvalidoApellido.setVisible(true);
            formatoInvalidoApellido.setText("Ese es un apellido inválido.");
            return false;
        }
     
    }
     
     private boolean validarNombre()
    {
        if(nombreCliente.getText().matches("^.*\\d+.*$"))
        {
            nombreCliente.setBorder(redBorder);
            formatoInvalidoNombre.setVisible(true);
            formatoInvalidoNombre.setText("Solo se permite texto en este campo.");
            return false;
        }
        if(!validar.validacionCantidadMinima(nombreCliente.getText(),3))
            {
            nombreCliente.setBorder(redBorder);
            formatoInvalidoNombre.setVisible(true);
            formatoInvalidoNombre.setText("El nombre debe ser de minimo 3 letras.");
            return false;
            }
        if (!validar.validacionNombres(nombreCliente.getText()))
        {
            nombreCliente.setBorder(redBorder);
            formatoInvalidoNombre.setVisible(true);
            formatoInvalidoNombre.setText("Cada nombre debe empezar en mayuscula.");
            return false;
        }
        if(validar.validarRepeticionCadena(nombreCliente.getText()))
        {
           nombreCliente.setBorder(redBorder);
            formatoInvalidoNombre.setVisible(true);
            formatoInvalidoNombre.setText("No puedes repetir tantas letras.");
            return false; 
        }
        if(validar.validacionCadenaPalabras(nombreCliente.getText()))
        {    
            nombreCliente.setBorder(greenBorder);
            formatoInvalidoNombre.setVisible(true);
            formatoInvalidoNombre.setText("Formato válido");
            return true;
            
        }else
        {
            nombreCliente.setBorder(redBorder);
            formatoInvalidoNombre.setVisible(true);
            formatoInvalidoNombre.setText("Ese es un nombre inválido.");
            return false;
        }
    }
     
   private boolean validarCamposNumero(javax.swing.JTextField telefonoEmpleado,JLabel formatoInvalidoTelefono)
    {
        if(!validar.validacionCampoNumerico(telefonoEmpleado.getText()))
        {
            telefonoEmpleado.setBorder(redBorder);
            formatoInvalidoTelefono.setVisible(true);
            formatoInvalidoTelefono.setText("Solo puedes ingresar numeros en este campo.");
            return false;
        }
        if(!validar.validarNumCelular(telefonoEmpleado.getText()))
            {
            telefonoEmpleado.setBorder(redBorder);
            formatoInvalidoTelefono.setVisible(true);
            formatoInvalidoTelefono.setText("El numero de teléfono es inválido.");
            return false;
            }else
        {
            telefonoEmpleado.setBorder(greenBorder);
            formatoInvalidoTelefono.setText(" ");
            return true;
        }
    }
   
     private String convertirFecha(String Fecha)
    {
        String[] palabras  = Fecha.split("/");
       
        return palabras[2] + "-" + palabras[1] + "-" + palabras[0];
    }
     
     private String convertirDates(String Fecha)
    {
        String[] palabras  = Fecha.split("-");
       
        return palabras[2] + "/" + palabras[1] + "/" + palabras[0];
    }
     
     public boolean validarCamposEnBlanco(){
         if(nombreCliente.getText().equals("") || apellidosCliente.getText().equals("") || telefonoCliente.getText().equals("") ||
                fechaNacimiento.getText().equals("") || numDoc.getText().equals(""))
        {
            return false;
        }else{return true;}
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
    private javax.swing.JButton Cancelar;
    public javax.swing.JTextField apellidosCliente;
    private javax.swing.JLabel apellidosLabel;
    private javax.swing.JComboBox<String> cbTipoDoc;
    private javax.swing.JButton crearPerfil;
    private javax.swing.JLabel datosPersonales;
    public javax.swing.JTextField fechaNacimiento;
    private javax.swing.JLabel formatoInvalidoApellido;
    private javax.swing.JLabel formatoInvalidoFechaNac;
    private javax.swing.JLabel formatoInvalidoIdDocumento;
    private javax.swing.JLabel formatoInvalidoNombre;
    private javax.swing.JLabel formatoInvalidoTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nacimientoLabel;
    public javax.swing.JTextField nombreCliente;
    private javax.swing.JLabel nombresLabel;
    public javax.swing.JTextField numDoc;
    private javax.swing.JComboBox<String> servicioProducto;
    public javax.swing.JTextField telefonoCliente;
    private javax.swing.JLabel telefonoLabel;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

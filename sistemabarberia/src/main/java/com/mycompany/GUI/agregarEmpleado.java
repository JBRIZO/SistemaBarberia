/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.puestoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.puestohistoricoempleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.salariohistoricoempleadosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipodocumentoJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.puesto;
import com.mycompany.sistemabarberia.puestohistoricoempleado;
import com.mycompany.sistemabarberia.salariohistoricoempleados;
import com.mycompany.sistemabarberia.tipodocumento;
import java.awt.Color;
import java.awt.Image;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Jonathan Laux
 */
public class agregarEmpleado extends javax.swing.JFrame {

    private empleado modificarEmpleado;
    private boolean modificar = false;
    
    private puestohistoricoempleadoJpaController puestoHistoricoDAO = new puestohistoricoempleadoJpaController();
    private puestoJpaController puestoDAO = new puestoJpaController();
    private List<puesto> puestosBD = puestoDAO.findpuestoEntities();
    private tipodocumentoJpaController tipodocumentoDAO = new tipodocumentoJpaController();
    private List<tipodocumento> documentosBD = tipodocumentoDAO.findtipodocumentoEntities();
    private empleadoJpaController empleadoDAO = new empleadoJpaController();
    private salariohistoricoempleadosJpaController salarioDAO = new salariohistoricoempleadosJpaController();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    private Validaciones validar = new Validaciones();
    Border redBorder = BorderFactory.createLineBorder(Color.RED,1);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN,1);
    Border defaultBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true);
    
    
    
    private ImageIcon imagen;
    private Icon icono;
    /**
     * Creates new form agregarEmpleado
     */
    public agregarEmpleado() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoLogin.png");
        Reiniciar();
        cbTipoDoc.addItem("Seleccione");
        cbPuestos.addItem("Seleccione");
            for(int i = 0; i < documentosBD.size(); i++)
        {
            cbTipoDoc.addItem(documentosBD.get(i).toString());
        }
        for(int i = 0; i < puestosBD.size(); i++)
        {
            cbPuestos.addItem(puestosBD.get(i).toString());
        }
          
    }
    
    //constructor para modificar un empleado 
    public agregarEmpleado(empleado empleadoModificar)
    {
        initComponents();
        modificar = true;
        this.setLocationRelativeTo(null);
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoLogin.png");
        this.modificarEmpleado = empleadoModificar;
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoLogin.png");
        Reiniciar();
        cargarDatosModificarEmpleado();
        cbPuestos.setEnabled(false);
        cbGenero.setEnabled(false);
        salarioInicial.setEnabled(false);
        cbTipoDoc.addItem("Seleccione");
        for(int i = 0; i < documentosBD.size(); i++)
        {
            cbTipoDoc.addItem(documentosBD.get(i).toString());
        }
        cbTipoDoc.setSelectedIndex(modificarEmpleado.getIDTipoDocumento()-1);
    }
    
    
    public void Reiniciar()
    {
        idEmpleado.setText(" ");
        formatoInvalidoNombre.setText(" ");
        formatoInvalidoApellido.setText(" ");
        formatoInvalidoTelefono.setText(" ");
        formatoInvalidoFechaIni.setText(" ");
        formatoInvalidoFechaNac.setText(" ");
        formatoInvalidoNumDoc.setText(" ");
        formatoInvalidoSalario.setText(" ");
        nombreLabel.setText(" ");
        apellidosLabel.setText(" ");
        telefonoLabel.setText(" ");
        inicioLabel.setText(" ");
        nacimientoLabel.setText(" ");
        direccionLabel.setText(" ");
    }
    
    public void cargarDatosModificarEmpleado()
    {
        idEmpleado.setText("ID Empleado: " + modificarEmpleado.getIdempleado());
        tituloPantalla.setText("MODIFICAR EMPLEADO");
        nombreEmpleado.setText(modificarEmpleado.getNomEmpleado());
        apellidosEmpleado.setText(modificarEmpleado.getApeEmpleado());
        telefonoEmpleado.setText(modificarEmpleado.getNumCelular());
        fechaInicio.setText(convertirDates(modificarEmpleado.getFechaInicio().toString()));
        fechaNacimiento.setText(convertirDates(modificarEmpleado.getFechaNacimiento().toString()));
        numDoc.setDocument(new JTextFieldLimit(25));
        numDoc.setText(modificarEmpleado.getNumDoc());
        direccion.setText(modificarEmpleado.getDireccion());
        salarioInicial.setText("10.00");
        botonAgregar.setText("MODIFICAR");
        
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        nombreEmpleado = new javax.swing.JTextField();
        telefonoEmpleado = new javax.swing.JTextField();
        fechaNacimiento = new javax.swing.JTextField();
        cbTipoDoc = new javax.swing.JComboBox<>();
        numDoc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        salarioInicial = new javax.swing.JTextField();
        apellidosEmpleado = new javax.swing.JTextField();
        fechaInicio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        direccion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cbPuestos = new javax.swing.JComboBox<>();
        cbGenero = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        formatoInvalidoNombre = new javax.swing.JLabel();
        formatoInvalidoApellido = new javax.swing.JLabel();
        formatoInvalidoTelefono = new javax.swing.JLabel();
        formatoInvalidoFechaIni = new javax.swing.JLabel();
        formatoInvalidoFechaNac = new javax.swing.JLabel();
        formatoInvalidoNumDoc = new javax.swing.JLabel();
        formatoInvalidoSalario = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        apellidosLabel = new javax.swing.JLabel();
        telefonoLabel = new javax.swing.JLabel();
        inicioLabel = new javax.swing.JLabel();
        nacimientoLabel = new javax.swing.JLabel();
        direccionLabel = new javax.swing.JLabel();
        tituloPantalla = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        idEmpleado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 500));
        setMinimumSize(new java.awt.Dimension(911, 716));

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(911, 716));
        jPanel1.setMinimumSize(new java.awt.Dimension(911, 716));

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        nombreEmpleado.setBackground(new java.awt.Color(30, 33, 34));
        nombreEmpleado.setDocument(new JTextFieldLimit(25));
        nombreEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        nombreEmpleado.setText("Nombre");
        nombreEmpleado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nombreEmpleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreEmpleadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreEmpleadoFocusLost(evt);
            }
        });
        nombreEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreEmpleadoActionPerformed(evt);
            }
        });

        telefonoEmpleado.setBackground(new java.awt.Color(30, 33, 34));
        telefonoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        telefonoEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        telefonoEmpleado.setText("Teléfono");
        telefonoEmpleado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        telefonoEmpleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telefonoEmpleadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                telefonoEmpleadoFocusLost(evt);
            }
        });
        telefonoEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telefonoEmpleadoMouseClicked(evt);
            }
        });
        telefonoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoEmpleadoActionPerformed(evt);
            }
        });

        fechaNacimiento.setBackground(new java.awt.Color(30, 33, 34));
        fechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        fechaNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaNacimientoKeyTyped(evt);
            }
        });

        cbTipoDoc.setBackground(new java.awt.Color(30, 33, 34));
        cbTipoDoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbTipoDoc.setForeground(new java.awt.Color(255, 255, 255));
        cbTipoDoc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cbTipoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDocActionPerformed(evt);
            }
        });

        numDoc.setBackground(new java.awt.Color(30, 33, 34));
        numDoc.setDocument(new JTextFieldLimit(20));
        numDoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numDoc.setForeground(new java.awt.Color(255, 255, 255));
        numDoc.setText("Número");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Salario Inicial:");

        salarioInicial.setBackground(new java.awt.Color(30, 33, 34));
        salarioInicial.setDocument(new JTextFieldLimit(10));
        salarioInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salarioInicial.setForeground(new java.awt.Color(255, 255, 255));
        salarioInicial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        salarioInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                salarioInicialFocusLost(evt);
            }
        });
        salarioInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salarioInicialActionPerformed(evt);
            }
        });

        apellidosEmpleado.setBackground(new java.awt.Color(30, 33, 34));
        apellidosEmpleado.setDocument(new JTextFieldLimit(25));
        apellidosEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        apellidosEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        apellidosEmpleado.setText("Apellidos");
        apellidosEmpleado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        apellidosEmpleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                apellidosEmpleadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                apellidosEmpleadoFocusLost(evt);
            }
        });
        apellidosEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidosEmpleadoActionPerformed(evt);
            }
        });

        fechaInicio.setBackground(new java.awt.Color(30, 33, 34));
        fechaInicio.setDocument(new JTextFieldLimit(25));
        fechaInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        fechaInicio.setText("Fecha de Inicio");
        fechaInicio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        fechaInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fechaInicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fechaInicioFocusLost(evt);
            }
        });
        fechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaInicioActionPerformed(evt);
            }
        });

        direccion.setBackground(new java.awt.Color(30, 33, 34));
        direccion.setColumns(20);
        direccion.setDocument(new JTextFieldLimit(200));
        direccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        direccion.setForeground(new java.awt.Color(255, 255, 255));
        direccion.setRows(5);
        direccion.setText("Dirección de Domicilio");
        direccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        direccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                direccionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                direccionFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(direccion);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Puesto Inicial:");

        cbPuestos.setBackground(new java.awt.Color(30, 33, 34));
        cbPuestos.setForeground(new java.awt.Color(255, 255, 255));
        cbPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPuestosActionPerformed(evt);
            }
        });

        cbGenero.setBackground(new java.awt.Color(30, 33, 34));
        cbGenero.setForeground(new java.awt.Color(255, 255, 255));
        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "M", "F" }));
        cbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGeneroActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Genero:");

        formatoInvalidoNombre.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoNombre.setText("Formato Invalido.");

        formatoInvalidoApellido.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoApellido.setText("Formato Invalido.");

        formatoInvalidoTelefono.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoTelefono.setText("Formato Invalido.");

        formatoInvalidoFechaIni.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoFechaIni.setText("Formato Invalido.");

        formatoInvalidoFechaNac.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoFechaNac.setText("Formato Invalido.");

        formatoInvalidoNumDoc.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoNumDoc.setText("Formato Invalido.");

        formatoInvalidoSalario.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoSalario.setText("Formato Invalido.");

        nombreLabel.setForeground(new java.awt.Color(255, 255, 255));
        nombreLabel.setText("Nombres:");

        apellidosLabel.setForeground(new java.awt.Color(255, 255, 255));
        apellidosLabel.setText("Apellidos:");

        telefonoLabel.setForeground(new java.awt.Color(255, 255, 255));
        telefonoLabel.setText("Teléfono:");

        inicioLabel.setForeground(new java.awt.Color(255, 255, 255));
        inicioLabel.setText("Fecha de Inicio:");

        nacimientoLabel.setForeground(new java.awt.Color(255, 255, 255));
        nacimientoLabel.setText("Fecha de Nacimiento:");

        direccionLabel.setForeground(new java.awt.Color(255, 255, 255));
        direccionLabel.setText("Dirección de Domicilio:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(formatoInvalidoSalario)
                        .addGap(620, 692, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(telefonoEmpleado)
                                .addComponent(fechaNacimiento)
                                .addComponent(nombreEmpleado)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(formatoInvalidoNumDoc)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(salarioInicial)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(numDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addComponent(formatoInvalidoNombre)
                            .addComponent(formatoInvalidoTelefono)
                            .addComponent(formatoInvalidoFechaNac)
                            .addComponent(nombreLabel)
                            .addComponent(telefonoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(apellidosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(apellidosLabel))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(formatoInvalidoApellido)
                            .addComponent(formatoInvalidoFechaIni)
                            .addComponent(inicioLabel)
                            .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nacimientoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(direccionLabel)
                        .addGap(195, 195, 195))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(apellidosLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formatoInvalidoNombre)
                    .addComponent(formatoInvalidoApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoLabel)
                    .addComponent(inicioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formatoInvalidoTelefono)
                    .addComponent(formatoInvalidoFechaIni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nacimientoLabel)
                    .addComponent(direccionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(formatoInvalidoFechaNac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(formatoInvalidoNumDoc)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(salarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formatoInvalidoSalario)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        tituloPantalla.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("REGISTRO DE EMPLEADO");

        botonAgregar.setBackground(new java.awt.Color(189, 158, 76));
        botonAgregar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonAgregar.setText("AGREGAR");
        botonAgregar.setRequestFocusEnabled(false);
        botonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAgregarMouseClicked(evt);
            }
        });
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonCancelar.setBackground(new java.awt.Color(189, 158, 76));
        botonCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonCancelar.setText("CANCELAR");
        botonCancelar.setRequestFocusEnabled(false);
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCancelarMouseClicked(evt);
            }
        });

        idEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        idEmpleado.setText("ID Empleado: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(tituloPantalla)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idEmpleado)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(tituloPantalla)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void telefonoEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telefonoEmpleadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoEmpleadoMouseClicked

    private void fechaNacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaNacimientoKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_fechaNacimientoKeyTyped

    private void botonAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgregarMouseClicked
        // TODO add your handling code here:
        
       
        
    }//GEN-LAST:event_botonAgregarMouseClicked

    private void fechaNacimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaNacimientoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_fechaNacimientoMouseClicked

    private void nombreEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreEmpleadoFocusLost
        // TODO add your handling code here:
        if(nombreEmpleado.getText().equals(""))
        {
            nombreEmpleado.setBorder(defaultBorder);
            nombreEmpleado.setText("Nombre");
            nombreLabel.setText(" ");
            formatoInvalidoNombre.setText(" ");
        }else
        {
           validarNombre(); 
        }  
    }//GEN-LAST:event_nombreEmpleadoFocusLost

    private void apellidosEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidosEmpleadoFocusLost
        // TODO add your handling code here:
        if(apellidosEmpleado.getText().equals(""))
        {
            apellidosEmpleado.setText("Apellidos");
            apellidosLabel.setText("");
        }else
        {
           validarApellido(); 
        } 
    }//GEN-LAST:event_apellidosEmpleadoFocusLost

    private void nombreEmpleadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreEmpleadoFocusGained
        // TODO add your handling code here:
        if(nombreEmpleado.getText().equals("Nombre"))
        {
            
            nombreEmpleado.setText("");
            nombreLabel.setText("Nombre:");
        }
        
    }//GEN-LAST:event_nombreEmpleadoFocusGained

    private void fechaInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaInicioFocusLost
        // TODO add your handling code here:
         if(fechaInicio.getText().equals(""))
        {
            fechaInicio.setDocument(new JTextFieldLimit(20));
            fechaInicio.setText("Fecha de Inicio");
            inicioLabel.setText(" ");
        }else
        {
            validarFecha(fechaInicio,formatoInvalidoFechaIni);
        }  
    }//GEN-LAST:event_fechaInicioFocusLost

    private void telefonoEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoEmpleadoFocusLost
        // TODO add your handling code here:
        if(telefonoEmpleado.getText().equals(""))
        {
            telefonoEmpleado.setDocument(new JTextFieldLimit(10));
            telefonoEmpleado.setText("Teléfono");
            telefonoLabel.setText("");
        }else
        {
            validarCamposNumero(telefonoEmpleado,formatoInvalidoTelefono);
        }
       
    }//GEN-LAST:event_telefonoEmpleadoFocusLost

    private void fechaNacimientoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaNacimientoFocusGained
        // TODO add your handling code here:
         if(fechaNacimiento.getText().equals("Fecha de Nacimiento"))
        {
            fechaNacimiento.setDocument(new JTextFieldLimit(10));  
            nacimientoLabel.setText("Fecha de Nacimiento:");
        }
    }//GEN-LAST:event_fechaNacimientoFocusGained

    private void fechaInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaInicioFocusGained
        // TODO add your handling code here:
        if(fechaInicio.getText().equals("Fecha de Inicio"))
        {
            fechaInicio.setDocument(new JTextFieldLimit(10));
            inicioLabel.setText("Fecha de Inicio:");
        }
    }//GEN-LAST:event_fechaInicioFocusGained

    private void fechaNacimientoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaNacimientoFocusLost
        // TODO add your handling code here:
        if(fechaNacimiento.getText().equals(""))
        {
            fechaNacimiento.setDocument(new JTextFieldLimit(20));
            fechaNacimiento.setText("Fecha de Nacimiento");
            nacimientoLabel.setText(" ");
        }else
        {
           validarFecha(fechaNacimiento,formatoInvalidoFechaNac);  
           
        }
       
    }//GEN-LAST:event_fechaNacimientoFocusLost

    private void numDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numDocActionPerformed

    private void apellidosEmpleadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidosEmpleadoFocusGained
        // TODO add your handling code here:
        if(apellidosEmpleado.getText().equals("Apellidos"))
        {
            apellidosEmpleado.setText("");
            apellidosLabel.setText("Apellidos: ");
        }
    }//GEN-LAST:event_apellidosEmpleadoFocusGained

    private void botonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaEmpleados().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        puestoDAO.close();    
    }//GEN-LAST:event_botonCancelarMouseClicked

    private void nombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreEmpleadoActionPerformed

    private void fechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaNacimientoActionPerformed

    private void telefonoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoEmpleadoActionPerformed

    private void salarioInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salarioInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salarioInicialActionPerformed

    private void apellidosEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidosEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidosEmpleadoActionPerformed

    private void fechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioActionPerformed

    private void cbPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPuestosActionPerformed

  
    private void cbTipoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDocActionPerformed
        // TODO add your handling code here:
          if(Character.getNumericValue(cbTipoDoc.getSelectedItem().toString().charAt(0)) == 2)
            {
                numDoc.setDocument(new JTextFieldLimit(13));
                if(modificar)
                {
                    numDoc.setText(modificarEmpleado.getNumDoc());
                }
            }else
            {
                numDoc.setDocument(new JTextFieldLimit(12));
                if(modificar)
                {
                    numDoc.setText(modificarEmpleado.getNumDoc());
                }
            }  
    }//GEN-LAST:event_cbTipoDocActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:
         //validar que todos los campos esten llenos
        if(nombreEmpleado.getText().equals("Nombre") || apellidosEmpleado.getText().equals("Apellidos") || telefonoEmpleado.getText().equals("Teléfono") ||
                fechaInicio.getText().equals("Fecha de Inicio") || fechaNacimiento.getText().equals("Fecha de Nacimiento") || numDoc.getText().equals("Número") ||
                salarioInicial.getText().equals("") || direccion.getText().equals("Dirección de Domicilio"))
        {
            JOptionPane.showMessageDialog(null,"Debes rellenar todos los campos","Datos Faltantes",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(cbTipoDoc.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(null,"Debes seleccionar un tipo de documento.", "Tipo de Documento Inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }else
        {
            if(cbPuestos.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(null,"Debes seleccionar un puesto inicial.","Puesto Inválido",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(cbGenero.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(null,"Debes seleccionar un género para el empleado.","Género Inválido",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        java.util.Date startDate = new Date(0000000000);
        java.util.Date birthDate = new Date(0000000000);
        String fechaIni = "00-00-0000";
        String fechaNac = "00-00-0000";
        try {
        startDate = sdf.parse(convertirFecha(fechaInicio.getText()));  
        fechaIni = sdf.format(startDate);
        birthDate = sdf.parse(convertirFecha(fechaNacimiento.getText()));
        fechaNac = sdf.format(birthDate);
    } catch (ParseException ex) {
       ex.printStackTrace();
    }
        
        //validar edad de empleado, debes ser mayor a 18 años para ser admitido
        LocalDate date = convertToLocalDateViaInstant(birthDate);
        Period periodo = Period.between(date,LocalDate.now());
        if(periodo.getYears() < 18)
        {
           JOptionPane.showMessageDialog(null,"El empleado no puede ser menor a 18 años.", "Fecha Inválida",JOptionPane.ERROR_MESSAGE); 
           return;
        }
        
        //nuevo empleado o modificar uno existente
        empleado nuevoEmpleado = new empleado();
        salariohistoricoempleados primerSalario = new salariohistoricoempleados();
        puestohistoricoempleado primerPuesto = new puestohistoricoempleado();
        //primer puesto
        if(modificar)
        {
            nuevoEmpleado.setIdempleado(modificarEmpleado.getIdempleado());
            nuevoEmpleado.setNomEmpleado(nombreEmpleado.getText());
            nuevoEmpleado.setApeEmpleado(apellidosEmpleado.getText());
            nuevoEmpleado.setNumCelular(telefonoEmpleado.getText());
            nuevoEmpleado.setFechaInicio(Date.valueOf(fechaIni));
            nuevoEmpleado.setFechaNacimiento(Date.valueOf(fechaNac));
            nuevoEmpleado.setIDTipoDocumento(Character.getNumericValue(cbTipoDoc.getSelectedItem().toString().charAt(0)));
            nuevoEmpleado.setGenEmpleado(cbGenero.getSelectedItem().toString().charAt(0));
            nuevoEmpleado.setActivo(true);
            nuevoEmpleado.setDireccion(direccion.getText());
            nuevoEmpleado.setNumDoc(numDoc.getText());
        }else
        {
        nuevoEmpleado.setNomEmpleado(nombreEmpleado.getText());
        nuevoEmpleado.setApeEmpleado(apellidosEmpleado.getText());
        nuevoEmpleado.setNumCelular(telefonoEmpleado.getText());
        nuevoEmpleado.setFechaInicio(Date.valueOf(fechaIni));
        nuevoEmpleado.setFechaFinal(null);
        nuevoEmpleado.setFechaNacimiento(Date.valueOf(fechaNac));
        nuevoEmpleado.setIDTipoDocumento(Character.getNumericValue(cbTipoDoc.getSelectedItem().toString().charAt(0)));
        nuevoEmpleado.setGenEmpleado(cbGenero.getSelectedItem().toString().charAt(0));
        nuevoEmpleado.setActivo(true);
        nuevoEmpleado.setDireccion(direccion.getText());
        nuevoEmpleado.setNumDoc(numDoc.getText());
         //primer salario
        primerSalario.setFechaInicial(Date.valueOf(fechaIni));
        primerSalario.setFechaFinal(null);
        primerSalario.setSalario(Double.parseDouble(salarioInicial.getText()));
        primerSalario.setActivo(true);
        //primer puesto
        primerPuesto.setIDPuesto(Character.getNumericValue(cbPuestos.getSelectedItem().toString().charAt(0)));
        primerPuesto.setFechaInicial(Date.valueOf(fechaIni));
        primerPuesto.setFechaFinal(null);
        primerPuesto.setActivo(true);
        }
        //validar pasaporte o identidad
        if(nuevoEmpleado.getIDTipoDocumento() == 1)
        {
            if(!validar.validarPasaporte(nuevoEmpleado.getNumDoc()))
            {
                numDoc.setBorder(redBorder);
                formatoInvalidoNumDoc.setText("Número inválido.");
                return;
            }
        }else
        {
            if(nuevoEmpleado.getIDTipoDocumento() == 2)
            {
                if(!validar.validacionIdentidad(nuevoEmpleado.getNumDoc()))
                {
                    numDoc.setBorder(redBorder);
                    formatoInvalidoNumDoc.setText("Número inválido.");
                    return; 
                }
            }
        }
        if(validarNombre() && validarApellido() && validarFecha(fechaInicio,formatoInvalidoFechaIni) && 
           validarFecha(fechaNacimiento,formatoInvalidoFechaNac) && validarCamposNumero(telefonoEmpleado,formatoInvalidoTelefono) &&
           validarDecimal())
        {   
            if(modificar)
            {
                try {
            empleadoDAO.edit(nuevoEmpleado);
            JOptionPane.showMessageDialog(null,"Empleado modificado exitosamente.");
                    Reiniciar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se pudo modificar el empleado, excepción: " + ex.getMessage());
        }
        }else{
                try {
            empleadoDAO.create(nuevoEmpleado);
            List<empleado> empleados = empleadoDAO.findempleadoEntities();
             primerSalario.setIDEmpleado(empleados.get(empleados.size()-1).getIdempleado());
             primerPuesto.setIDEmpleado(empleados.get(empleados.size()-1).getIdempleado());
             salarioDAO.create(primerSalario);
             puestoHistoricoDAO.create(primerPuesto);
            JOptionPane.showMessageDialog(null,"Operación Exitosa.");
                    Reiniciar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se pudo guardar el empleado, excepción: " + ex.getMessage());
        }
        }    
            
        }else{ JOptionPane.showMessageDialog(null,"Por favor, introduzca datos válidos.", "Datos inválidos",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void salarioInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salarioInicialFocusLost
        // TODO add your handling code here:
        if(!salarioInicial.getText().equals(""))
        {
            validarDecimal();
        } 
    }//GEN-LAST:event_salarioInicialFocusLost

    private void direccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direccionFocusGained
        // TODO add your handling code here:
        if(direccion.getText().equals("Dirección de Domicilio"))
        {
            direccion.setText("");
            direccionLabel.setText("Dirección de Domicilio");
        }
    }//GEN-LAST:event_direccionFocusGained

    private void direccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direccionFocusLost
        // TODO add your handling code here:
        if(direccion.getText().equals(""))
        {
            direccion.setText("Dirección de Domicilio");
            direccionLabel.setText(" ");
        }
    }//GEN-LAST:event_direccionFocusLost

    private void numDocFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numDocFocusGained
        // TODO add your handling code here:
        if(numDoc.getText().equals("Número"))
        {
            numDoc.setText("");
        }
    }//GEN-LAST:event_numDocFocusGained

    private void telefonoEmpleadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoEmpleadoFocusGained
        // TODO add your handling code here:
        if(telefonoEmpleado.getText().equals("Teléfono"))
        {
            telefonoEmpleado.setDocument(new JTextFieldLimit(8));
            telefonoEmpleado.setText("");
            telefonoLabel.setText("Teléfono:");
        }
    }//GEN-LAST:event_telefonoEmpleadoFocusGained

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void numDocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numDocFocusLost
        // TODO add your handling code here:

        if(numDoc.getText().equals(""))
        {
            numDoc.setText("Número");
        }
    }//GEN-LAST:event_numDocFocusLost

    private void cbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGeneroActionPerformed

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
            java.util.logging.Logger.getLogger(agregarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agregarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agregarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agregarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agregarEmpleado().setVisible(true);
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
    
    //convertir fecha a formato valido para almacenar en bd mysql
    private String convertirFecha(String Fecha)
    {
        String[] palabras  = Fecha.split("/");
       
        return palabras[2] + "-" + palabras[1] + "-" + palabras[0];
    }
    
    private boolean validarNombre()
    {
        if(!validar.validacionCantidadMinima(nombreEmpleado.getText(),4))
            {
            nombreEmpleado.setBorder(redBorder);
            formatoInvalidoNombre.setVisible(true);
            formatoInvalidoNombre.setText("El nombre debe ser de minimo 4 letras.");
            return false;
            }
        if (!validar.validacionNombres(nombreEmpleado.getText()))
        {
            nombreEmpleado.setBorder(redBorder);
            formatoInvalidoNombre.setVisible(true);
            formatoInvalidoNombre.setText("Cada nombre debe empezar en mayuscula.");
            return false;
        }
        if(validar.validacionCadenaPalabras(nombreEmpleado.getText()))
        {    
            nombreEmpleado.setBorder(greenBorder);
            formatoInvalidoNombre.setVisible(true);
            formatoInvalidoNombre.setText(" ");
            return true;
            
        }else
        {
            nombreEmpleado.setBorder(redBorder);
            formatoInvalidoNombre.setVisible(true);
            formatoInvalidoNombre.setText("Ese es un nombre invalido.");
            return false;
        }
    }
    
    private boolean validarApellido()
    {
        if(!validar.validacionCantidadMinima(apellidosEmpleado.getText(),2))
            {
            apellidosEmpleado.setBorder(redBorder);
            formatoInvalidoApellido.setVisible(true);
            formatoInvalidoApellido.setText("El apellido debe ser de minimo 2 letras.");
            return false;
            }
        if (!validar.validacionNombres(apellidosEmpleado.getText()))
        {
            apellidosEmpleado.setBorder(redBorder);
            formatoInvalidoApellido.setVisible(true);
            formatoInvalidoApellido.setText("Cada apellido debe empezar en mayuscula.");
            return false;
        }
        if(validar.validacionCadenaPalabras(apellidosEmpleado.getText()))
        {    
            apellidosEmpleado.setBorder(greenBorder);
            formatoInvalidoApellido.setVisible(true);
            formatoInvalidoApellido.setText(" ");
            return true;
            
        }else
        {
            apellidosEmpleado.setBorder(redBorder);
            formatoInvalidoApellido.setVisible(true);
            formatoInvalidoApellido.setText("Ese apellido es invalido.");
            return false;
        }
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
            }else
        {
            fecha.setBorder(greenBorder);
            label.setText(" ");
            return true;
        }
        
    }
    

    
    private boolean validarDecimal()
    {
        if(!validar.validacionCampoNumerico(salarioInicial.getText()))
        {
            salarioInicial.setBorder(redBorder);
            formatoInvalidoSalario.setVisible(true);
            formatoInvalidoSalario.setText("Solo puedes ingresar numeros en este campo.");
            return false;
        }
        
        if(Double.parseDouble(salarioInicial.getText()) <= 0)
        {
            salarioInicial.setBorder(redBorder);
            formatoInvalidoSalario.setText("El salario debe ser mayor a 0.");
            return false;
        }
        
        if(validar.validacionDecimal(salarioInicial.getText()))
        {
            salarioInicial.setBorder(greenBorder);
            formatoInvalidoSalario.setText(" ");
            return true;
        }else
        {
            salarioInicial.setBorder(redBorder);
            formatoInvalidoSalario.setText("El formato debe ser 000000.00");
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
       
    public LocalDate convertToLocalDateViaInstant(java.util.Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
    }
    
    private String convertirDates(String Fecha)
    {
        String[] palabras  = Fecha.split("-");
       
        return palabras[2] + "/" + palabras[1] + "/" + palabras[0];
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidosEmpleado;
    private javax.swing.JLabel apellidosLabel;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JComboBox<String> cbPuestos;
    private javax.swing.JComboBox<String> cbTipoDoc;
    private javax.swing.JTextArea direccion;
    private javax.swing.JLabel direccionLabel;
    private javax.swing.JTextField fechaInicio;
    private javax.swing.JTextField fechaNacimiento;
    private javax.swing.JLabel formatoInvalidoApellido;
    private javax.swing.JLabel formatoInvalidoFechaIni;
    private javax.swing.JLabel formatoInvalidoFechaNac;
    private javax.swing.JLabel formatoInvalidoNombre;
    private javax.swing.JLabel formatoInvalidoNumDoc;
    private javax.swing.JLabel formatoInvalidoSalario;
    private javax.swing.JLabel formatoInvalidoTelefono;
    private javax.swing.JLabel idEmpleado;
    private javax.swing.JLabel inicioLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nacimientoLabel;
    private javax.swing.JTextField nombreEmpleado;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField numDoc;
    private javax.swing.JTextField salarioInicial;
    private javax.swing.JTextField telefonoEmpleado;
    private javax.swing.JLabel telefonoLabel;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

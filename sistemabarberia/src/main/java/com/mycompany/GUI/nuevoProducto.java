/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.precioshistoricosproductosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.productosJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.precioshistoricosproductos;
import com.mycompany.sistemabarberia.productos;
import java.awt.Color;
import java.awt.Image;
import java.sql.Date;
import java.time.LocalDate;
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
public class nuevoProducto extends javax.swing.JFrame {
    
    private precioshistoricosproductosJpaController preciosDAO = new precioshistoricosproductosJpaController();
    private productosJpaController productoDAO = new productosJpaController();
    private Validaciones validar = new Validaciones();
    private List<productos> productosEnBd = productoDAO.findproductosEntities();
    private ImageIcon imagen;
    private Icon icono;
    private java.util.Date dt = new java.util.Date();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    String currentTime = sdf.format(dt);
    private LocalDate fecha ;
    Border redBorder = BorderFactory.createLineBorder(Color.RED,1);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN,1);
    Border defaultBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true);


    /**
     * Creates new form nuevoTipoDescuento
     */
    public nuevoProducto() {
        initComponents();
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        this.insertarImagen(this.salir,"src/main/resources/Imagenes/x.png");
                nombreProducto.setText("  Nombre del Nuevo Producto");

        Reiniciar();    
    }
    
    public void Reiniciar()
    {
        List<productos> productosEnBd = productoDAO.findproductosEntities();
        if (productosEnBd.isEmpty())
        {
            idProducto.setText("  ID de Producto: 1");
        }else
        {
            idProducto.setText("  ID de Producto: " + Integer.toString(productosEnBd.get(productosEnBd.size()-1).getIdproducto()+1));
        } 
        
        nombreProducto.setText("  Nuevo Producto");
        precioInicial.setText(" Precio");
        Border border = BorderFactory.createLineBorder(Color.RED, 0);
        nombreProducto.setBorder(defaultBorder);
        precioInicial.setBorder(defaultBorder);
        stockInicial.setBorder(defaultBorder);
        stockMinimo.setBorder(defaultBorder);
        stockMaximo.setBorder(defaultBorder);
        formatoInvalido1.setVisible(false);
        formatoInvalido2.setVisible(false);
        formatoInvalido3.setVisible(false);
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
        botonAceptar = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        idProducto = new javax.swing.JTextField();
        formatoInvalido1 = new javax.swing.JLabel();
        precioInicial = new javax.swing.JTextField();
        nombreProducto = new javax.swing.JTextField();
        formatoInvalido2 = new javax.swing.JLabel();
        Stock = new javax.swing.JLabel();
        stockInicial = new javax.swing.JTextField();
        stockMinimo = new javax.swing.JTextField();
        stockMaximo = new javax.swing.JTextField();
        actualLabel = new javax.swing.JLabel();
        minimoLabel = new javax.swing.JLabel();
        maximoLabel = new javax.swing.JLabel();
        formatoInvalido3 = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(486, 696));
        setMinimumSize(new java.awt.Dimension(486, 696));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(486, 680));
        jPanel1.setMinimumSize(new java.awt.Dimension(486, 680));
        jPanel1.setPreferredSize(new java.awt.Dimension(486, 680));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("NUEVO PRODUCTO");

        botonAceptar.setBackground(new java.awt.Color(189, 158, 76));
        botonAceptar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        botonAceptar.setText("ACEPTAR");
        botonAceptar.setRequestFocusEnabled(false);
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("jLabel1");

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(429, 510));
        jPanel2.setMinimumSize(new java.awt.Dimension(429, 510));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 444));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 444));

        idProducto.setEditable(false);
        idProducto.setBackground(new java.awt.Color(30, 33, 34));
        idProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idProducto.setForeground(new java.awt.Color(255, 255, 255));
        idProducto.setText(" Id de Producto");
        idProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        idProducto.setSelectionColor(new java.awt.Color(55, 53, 53));
        idProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idProductoActionPerformed(evt);
            }
        });

        formatoInvalido1.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido1.setText("Formato no valido.");

        precioInicial.setBackground(new java.awt.Color(30, 33, 34));
        precioInicial.setDocument(new JTextFieldLimit(7));
        precioInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        precioInicial.setForeground(new java.awt.Color(255, 255, 255));
        precioInicial.setText("  Precio Inicial");
        precioInicial.setToolTipText("Ingrese un precio de producto válido.");
        precioInicial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        precioInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                precioInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                precioInicialFocusLost(evt);
            }
        });
        precioInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioInicialActionPerformed(evt);
            }
        });
        precioInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioInicialKeyTyped(evt);
            }
        });

        nombreProducto.setBackground(new java.awt.Color(30, 33, 34));
        nombreProducto.setDocument(new JTextFieldLimit(25));
        nombreProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreProducto.setForeground(new java.awt.Color(255, 255, 255));
        nombreProducto.setText("   Nombre del Nuevo Producto");
        nombreProducto.setToolTipText("Ingrese un nombre de producto valido.");
        nombreProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nombreProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreProductoFocusLost(evt);
            }
        });
        nombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreProductoActionPerformed(evt);
            }
        });
        nombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreProductoKeyTyped(evt);
            }
        });

        formatoInvalido2.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido2.setText("Formato no valido.");

        Stock.setForeground(new java.awt.Color(255, 255, 255));
        Stock.setText("Stock");

        stockInicial.setBackground(new java.awt.Color(30, 33, 34));
        stockInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stockInicial.setForeground(new java.awt.Color(255, 255, 255));
        stockInicial.setToolTipText("Stock inicial.");
        stockInicial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        stockInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stockInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stockInicialFocusLost(evt);
            }
        });
        stockInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockInicialActionPerformed(evt);
            }
        });
        stockInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockInicialKeyTyped(evt);
            }
        });

        stockMinimo.setBackground(new java.awt.Color(30, 33, 34));
        stockMinimo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stockMinimo.setForeground(new java.awt.Color(255, 255, 255));
        stockMinimo.setToolTipText("Stock mínimo.");
        stockMinimo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        stockMinimo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stockMinimoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stockMinimoFocusLost(evt);
            }
        });
        stockMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockMinimoActionPerformed(evt);
            }
        });
        stockMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockMinimoKeyTyped(evt);
            }
        });

        stockMaximo.setBackground(new java.awt.Color(30, 33, 34));
        stockMaximo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stockMaximo.setForeground(new java.awt.Color(255, 255, 255));
        stockMaximo.setToolTipText("Stock máximo.");
        stockMaximo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        stockMaximo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stockMaximoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stockMaximoFocusLost(evt);
            }
        });
        stockMaximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockMaximoActionPerformed(evt);
            }
        });
        stockMaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockMaximoKeyTyped(evt);
            }
        });

        actualLabel.setForeground(new java.awt.Color(255, 255, 255));
        actualLabel.setText("Inicial");

        minimoLabel.setForeground(new java.awt.Color(255, 255, 255));
        minimoLabel.setText("Minimo");

        maximoLabel.setForeground(new java.awt.Color(255, 255, 255));
        maximoLabel.setText("Maximo");

        formatoInvalido3.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido3.setText("Formato Invalido");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formatoInvalido3)
                    .addComponent(formatoInvalido2)
                    .addComponent(precioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatoInvalido1)
                    .addComponent(idProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(actualLabel)
                                .addComponent(stockInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(56, 56, 56)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(minimoLabel)
                                .addComponent(stockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(maximoLabel)
                                .addComponent(stockMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(Stock, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(idProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(formatoInvalido1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(Stock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualLabel)
                    .addComponent(minimoLabel)
                    .addComponent(maximoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(formatoInvalido3)
                .addGap(18, 18, 18)
                .addComponent(formatoInvalido2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        salir.setText("jLabel2");
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(396, 396, 396)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(salir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(tituloPantalla))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tituloPantalla)
                        .addGap(11, 11, 11)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        //anadir producto
        List<productos> productosEnBd = productoDAO.findproductosEntities();
        productos productoNuevo = new productos();
        productoNuevo.setNomProducto(nombreProducto.getText());
        productoNuevo.setActivo(true);
        productoNuevo.setStockActual(Integer.parseInt(stockInicial.getText()));
        productoNuevo.setStockMinimo(Integer.parseInt(stockMinimo.getText()));
        productoNuevo.setStockMaximo(Integer.parseInt(stockMaximo.getText()));


        //anadir precio 1
        precioshistoricosproductos precioUno = new precioshistoricosproductos();
        precioUno.setFechaInicial(Date.valueOf(currentTime));
        precioUno.setFechaFinal(Date.valueOf(currentTime));
        precioUno.setPrecio(Double.parseDouble(precioInicial.getText()));
        precioUno.setActivo(true);  
        
       
       validacionCamposStock();
       validacionCampos();
       validarCampoNumerico();
        for(int i=0; i < productosEnBd.size();i++)
        {
            if(productoNuevo.getNomProducto().equalsIgnoreCase(productosEnBd.get(i).getNomProducto()))
            {
            nombreProducto.setBorder(redBorder);
            formatoInvalido1.setVisible(true);
            formatoInvalido1.setText("Ese producto ya existe.");
            return;
            }
        } 
        if(validar.validacionCadenaPalabras(nombreProducto.getText()) && validar.validacionDecimal(precioInicial.getText()) && validacionStock())
        {   
            try {
            productoDAO.create(productoNuevo); 
            List<productos> productos = productoDAO.findproductosEntities();
            precioUno.setIDProducto((productos.get(productos.size()-1)).getIdproducto());  
            preciosDAO.create(precioUno);    
            JOptionPane.showMessageDialog(null,"Operación Exitosa.");
                    Reiniciar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se pudo guardar el producto, excepción: " + ex.getMessage());
        }
        }else{ JOptionPane.showMessageDialog(null,"Por favor, introduzca datos válidos.");}
    }//GEN-LAST:event_botonAceptarActionPerformed

    
    
    private void idProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProductoActionPerformed
//a;adir validaciones botonaceptar
    private void precioInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precioInicialFocusLost
        validarCampoNumerico();
    }//GEN-LAST:event_precioInicialFocusLost
    
    private void precioInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioInicialActionPerformed

    private void precioInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioInicialKeyTyped
        // TODO add your handling code here:
        if ((precioInicial.getText() + evt.getKeyChar()).length() > 7) {
        evt.consume();
    }
    }//GEN-LAST:event_precioInicialKeyTyped

    private void precioInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precioInicialFocusGained
        // TODO add your handling code here:
        precioInicial.selectAll();
    }//GEN-LAST:event_precioInicialFocusGained

    private void nombreProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreProductoFocusGained
        // TODO add your handling code here:
        nombreProducto.selectAll();
    }//GEN-LAST:event_nombreProductoFocusGained

    private void nombreProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreProductoFocusLost
        // TODO add your handling code here:
      validacionCampos();   
    }//GEN-LAST:event_nombreProductoFocusLost

    private void nombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreProductoActionPerformed

    private void nombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProductoKeyTyped
        // TODO add your handling code here:
        if ((nombreProducto.getText() + evt.getKeyChar()).length() > 15) {
        evt.consume();}
    }//GEN-LAST:event_nombreProductoKeyTyped

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        preciosDAO.close();
        productoDAO.close();
    }//GEN-LAST:event_salirMouseClicked

    private void stockInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockInicialFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_stockInicialFocusGained

    private void stockInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockInicialFocusLost
        // TODO add your handling code here:
     validacionCamposStock();
    }//GEN-LAST:event_stockInicialFocusLost

    private void stockInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockInicialActionPerformed

    private void stockInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockInicialKeyTyped
        // TODO add your handling code here:
        if ((stockInicial.getText() + evt.getKeyChar()).length() > 4) {
        evt.consume();
        }
    }//GEN-LAST:event_stockInicialKeyTyped

    private void stockMinimoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockMinimoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_stockMinimoFocusGained

    private void stockMinimoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockMinimoFocusLost
        // TODO add your handling code here:
      validacionCamposStock();  
    }//GEN-LAST:event_stockMinimoFocusLost

    private void stockMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockMinimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockMinimoActionPerformed

    private void stockMinimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockMinimoKeyTyped
        // TODO add your handling code here:
        if ((stockMinimo.getText() + evt.getKeyChar()).length() > 4) {
        evt.consume();
        }
        
    }//GEN-LAST:event_stockMinimoKeyTyped

    private void stockMaximoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockMaximoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_stockMaximoFocusGained

    private void stockMaximoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockMaximoFocusLost
        // TODO add your handling code here:
        validacionCamposStock(); 
    }//GEN-LAST:event_stockMaximoFocusLost

    private void stockMaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockMaximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockMaximoActionPerformed

    private void stockMaximoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockMaximoKeyTyped
        // TODO add your handling code here:
         if ((stockMaximo.getText() + evt.getKeyChar()).length() > 4) {
        evt.consume();
        }
        
    }//GEN-LAST:event_stockMaximoKeyTyped

    public void validacionCampos()
    {
       
        if(validar.validacionCadenaPalabras(nombreProducto.getText()))
        {    
            nombreProducto.setBorder(greenBorder);
            formatoInvalido1.setVisible(true);
            formatoInvalido1.setText("Formato válido");
            
        }else
        {
            nombreProducto.setBorder(redBorder);
            formatoInvalido1.setVisible(true);
            formatoInvalido1.setText("Formato inválido");
            return;
        }
        if(!validar.validacionCantidadMinima(nombreProducto.getText(),4))
            {
            nombreProducto.setBorder(redBorder);
            formatoInvalido1.setVisible(true);
            formatoInvalido1.setText("El nombre del producto debe ser de minimo 4 letras.");
            }
    }
    public void validacionCamposStock()
    {
        if(Integer.parseInt(stockInicial.getText()) == 0)
        {
            stockInicial.setBorder(greenBorder);
        }
        if(validar.validacionEntero(stockInicial.getText()))
            {    
              stockInicial.setBorder(greenBorder);
            }else
            {
                stockInicial.setBorder(redBorder);
            }  

          
           if(validar.validacionEntero(stockMaximo.getText()))
        {    
            stockMaximo.setBorder(greenBorder);
            
        }else
        {
            stockMaximo.setBorder(redBorder);
        }
       
          if(validar.validacionEntero(stockMinimo.getText()))
        {    
            stockMinimo.setBorder(greenBorder);   
        }else
        {
            stockMinimo.setBorder(redBorder);
        }
          if(!validacionStock())
            {
                stockInicial.setBorder(redBorder);
                stockMinimo.setBorder(redBorder);
                stockMaximo.setBorder(redBorder);
                
            }else
            {
                stockInicial.setBorder(greenBorder);
                stockMinimo.setBorder(greenBorder);
                stockMaximo.setBorder(greenBorder);
                formatoInvalido3.setVisible(false);

            }
       
        
    }
    
    public void validarCampoNumerico()
    {
        if(validar.validacionDecimal(precioInicial.getText()))
        {
            precioInicial.setBorder(greenBorder);
            formatoInvalido2.setVisible(true);
            formatoInvalido2.setText("Formato válido");
        }else
        {
            precioInicial.setBorder(redBorder);
            formatoInvalido2.setVisible(true);
            formatoInvalido2.setText("Formato inválido");
        }
    }
    
    public boolean validacionStock()
    {
        int inicial = Integer.parseInt(stockInicial.getText());
        int minimo = Integer.parseInt(stockMinimo.getText());
        int maximo = Integer.parseInt(stockMaximo.getText());
        
        if(inicial > maximo)
        {
            formatoInvalido3.setVisible(true);
            formatoInvalido3.setText("Stock Inicial no puede ser mayor al máximo.");
        }
        if(minimo < 0)
        {
           formatoInvalido3.setVisible(true);
           formatoInvalido3.setText("Stock minimo debe ser mayor a 0."); 
        }
        if(maximo < 0)
        {
            formatoInvalido3.setVisible(true);
            formatoInvalido3.setText("Stock máximo debe ser mayor a 0.");
        }
        if(minimo > maximo)
        {
            formatoInvalido3.setVisible(true);
            formatoInvalido3.setText("Stock mínimo no puede ser mayor al máximo.");
        }
        
        if( minimo < maximo && inicial <= maximo && minimo>0 && inicial>=0 && maximo>0)
        {
            return true;   
        }else{return false;}
    }
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
            java.util.logging.Logger.getLogger(nuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoProducto().setVisible(true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Stock;
    private javax.swing.JLabel actualLabel;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JLabel formatoInvalido1;
    private javax.swing.JLabel formatoInvalido2;
    private javax.swing.JLabel formatoInvalido3;
    private javax.swing.JTextField idProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel maximoLabel;
    private javax.swing.JLabel minimoLabel;
    private javax.swing.JTextField nombreProducto;
    private javax.swing.JTextField precioInicial;
    private javax.swing.JLabel salir;
    private javax.swing.JTextField stockInicial;
    private javax.swing.JTextField stockMaximo;
    private javax.swing.JTextField stockMinimo;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

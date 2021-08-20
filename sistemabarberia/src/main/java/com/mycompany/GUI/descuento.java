/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import static com.mycompany.GUI.registrarClientes.isDateValid;
import com.mycompany.sistemabarberia.JPACOntrollers.descuentosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipodescuentoJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;

import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.descuentos;
import com.mycompany.sistemabarberia.tipodescuento;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
 * @author flore
 */
public class descuento extends javax.swing.JFrame {
    private descuentosJpaController descuentosDAO = new descuentosJpaController();
    private List<descuentos> descuentosBD = descuentosDAO.finddescuentosEntities();
    private tipodescuentoJpaController tipodescuentoDAO = new tipodescuentoJpaController();
    private List<tipodescuento> tipodescuentoBD = tipodescuentoDAO.findtipodescuentoEntities();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    private Validaciones validar = new Validaciones();
    private ImageIcon imagen;
    private Icon icono;
    Border redBorder = BorderFactory.createLineBorder(Color.RED,1);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN,1);
    Border defaultBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true);


    /**
     * Creates new form descuento
     */
    public descuento() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        Reiniciar();
        for(int i = 0; i < tipodescuentoBD.size(); i++)
        {
            cbTiposDescuentos.addItem(tipodescuentoBD.get(i).toString());
        }
    }
    
    public void Reiniciar()
    {
        formatoInvalidoFechaIni.setText("");
        formatoInvalidoFechaFin.setText("");
        formatoInvalidoValor.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbTiposDescuentos = new javax.swing.JComboBox<>();
        fechaInicio = new javax.swing.JTextField();
        formatoInvalidoFechaIni = new javax.swing.JLabel();
        fechaFinal = new javax.swing.JTextField();
        formatoInvalidoFechaFin = new javax.swing.JLabel();
        Valor = new javax.swing.JTextField();
        formatoInvalidoValor = new javax.swing.JLabel();
        porcentaje = new javax.swing.JCheckBox();
        Aceptar = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(894, 648));

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DESCUENTO");
        jLabel1.setMaximumSize(new java.awt.Dimension(197, 32));
        jLabel1.setMinimumSize(new java.awt.Dimension(197, 32));
        jLabel1.setPreferredSize(new java.awt.Dimension(197, 32));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));
        jPanel2.setPreferredSize(new java.awt.Dimension(421, 389));

        jPanel4.setBackground(new java.awt.Color(55, 53, 53));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo de descuento:");

        cbTiposDescuentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cbTiposDescuentos.setOpaque(false);
        cbTiposDescuentos.setPreferredSize(new java.awt.Dimension(299, 42));

        fechaInicio.setBackground(new java.awt.Color(30, 33, 34));
        fechaInicio.setDocument(new JTextFieldLimit(25));
        fechaInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        fechaInicio.setText("Fecha Inicial");
        fechaInicio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        fechaInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fechaInicio.setPreferredSize(new java.awt.Dimension(73, 19));
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

        formatoInvalidoFechaIni.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoFechaIni.setText("Formato Invalido.");

        fechaFinal.setBackground(new java.awt.Color(30, 33, 34));
        fechaFinal.setDocument(new JTextFieldLimit(25));
        fechaFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaFinal.setForeground(new java.awt.Color(255, 255, 255));
        fechaFinal.setText("Fecha Final");
        fechaFinal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        fechaFinal.setSelectionColor(new java.awt.Color(55, 53, 53));
        fechaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fechaFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fechaFinalFocusLost(evt);
            }
        });
        fechaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaFinalActionPerformed(evt);
            }
        });

        formatoInvalidoFechaFin.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoFechaFin.setText("Formato Invalido.");

        Valor.setBackground(new java.awt.Color(30, 33, 34));
        Valor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Valor.setForeground(new java.awt.Color(255, 255, 255));
        Valor.setText("Valor");
        Valor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Valor.setSelectionColor(new java.awt.Color(55, 53, 53));
        Valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ValorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ValorFocusLost(evt);
            }
        });
        Valor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ValorMouseClicked(evt);
            }
        });
        Valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorActionPerformed(evt);
            }
        });

        formatoInvalidoValor.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalidoValor.setText("Formato Invalido.");

        porcentaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        porcentaje.setText("%");
        porcentaje.setContentAreaFilled(false);
        porcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porcentajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbTiposDescuentos, 0, 313, Short.MAX_VALUE)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formatoInvalidoFechaIni, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formatoInvalidoFechaFin, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formatoInvalidoValor, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(porcentaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(fechaFinal, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTiposDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formatoInvalidoFechaIni)
                .addGap(18, 18, 18)
                .addComponent(fechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formatoInvalidoFechaFin)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(porcentaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Valor, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formatoInvalidoValor)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        Aceptar.setBackground(new java.awt.Color(189, 158, 76));
        Aceptar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Aceptar.setText("ACEPTAR");
        Aceptar.setRequestFocusEnabled(false);
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        logo.setForeground(new java.awt.Color(255, 255, 255));

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x.png"))); // NOI18N
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaDescuentos().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose();
        descuentosDAO.close();
        tipodescuentoDAO.close();
    }//GEN-LAST:event_salirMouseClicked

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        // TODO add your handling code here:
        if(fechaInicio.getText().equals("Fecha Inicial") || fechaInicio.getText().equals("") || fechaFinal.getText().equals("Fecha Final") || fechaFinal.getText().equals("") || Valor.getText().equals("Valor") || Valor.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null," Debes rellenar todos los campos.", "Datos inválidos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        java.util.Date startDate = new Date(0000000000);
        java.util.Date endDate = new Date(0000000000);
        String fechaIni = "00-00-0000";
        String fechaFin = "00-00-0000";
        try {
            startDate = sdf.parse(convertirFecha(fechaInicio.getText()));
            fechaIni = sdf.format(startDate);
            endDate = sdf.parse(convertirFecha(fechaFinal.getText()));
            fechaFin = sdf.format(endDate);
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Debes ingresar una fecha válida","Fecha inválida",JOptionPane.ERROR_MESSAGE);
            return;
        }
        //creacion de objeto
        descuentos descuentoNuevo = new descuentos();
        descuentoNuevo.setIDTipoDescuento(Character.getNumericValue(cbTiposDescuentos.getSelectedItem().toString().charAt(0)));
        descuentoNuevo.setFechaInicio(Date.valueOf(fechaIni));
        descuentoNuevo.setFechaFinal(Date.valueOf(fechaFin));
        

        //coherencia de fechas
        LocalDate date1 = convertToLocalDateViaInstant(startDate);
        LocalDate date2 = convertToLocalDateViaInstant(endDate);
        if(date1.isAfter(date2))
        {
            JOptionPane.showMessageDialog(null, "La fecha final no puede ser menor a la fecha inicial.", "Fecha inválida",JOptionPane.ERROR_MESSAGE);
            fechaFinal.setBorder(redBorder);
            return;
        }

        if(validarFecha(fechaInicio,formatoInvalidoFechaIni) && validacionCampoValor() &&
            validarFecha(fechaFinal,formatoInvalidoFechaFin))
        {
            try {
                //porcentaje o valor
                if(porcentaje.isSelected())
                {
                    descuentoNuevo.setValor(Double.parseDouble(Valor.getText())/100);
                }else
                {
                    descuentoNuevo.setValor(Double.parseDouble(Valor.getText()));
                }
                descuentoNuevo.setActivo(true);
                descuentosDAO.create(descuentoNuevo);
                JOptionPane.showMessageDialog(null,"Operación Exitosa.");
                Reiniciar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"No se pudo guardar el descuento, excepción: " + ex.getMessage());
            }
        }else{ JOptionPane.showMessageDialog(null,"Por favor, introduzca datos válidos.","Datos Inválidos",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AceptarActionPerformed

    private void ValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorActionPerformed

    }//GEN-LAST:event_ValorActionPerformed

    private void ValorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ValorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorMouseClicked

    private void ValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ValorFocusLost
        // TODO add your handling code here:
        if(Valor.getText().equals(""))
        {
            Valor.setDocument(new JTextFieldLimit(10));
            Valor.setText("Valor");
        }else
        {
            validacionCampoValor();
        }
    }//GEN-LAST:event_ValorFocusLost

    private void ValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ValorFocusGained
        // TODO add your handling code here:
        if(Valor.getText().equals("Valor"))
        {
            Valor.setText("");
            if(porcentaje.isSelected())
            {
             Valor.setDocument(new JTextFieldLimit(3));   
            }else
            {
                Valor.setDocument(new JTextFieldLimit(8));
            }
        }
    }//GEN-LAST:event_ValorFocusGained

    private void fechaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaFinalActionPerformed

    private void fechaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaFinalFocusLost
        // TODO add your handling code here:
        if(fechaFinal.getText().equals(""))
        {
            fechaFinal.setDocument(new JTextFieldLimit(20));
            fechaFinal.setText("Fecha Final");
        }else
        {
            validarFecha(fechaFinal, formatoInvalidoFechaFin);
        }
    }//GEN-LAST:event_fechaFinalFocusLost

    private void fechaFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaFinalFocusGained
        // TODO add your handling code here:
        if(fechaFinal.getText().equals("Fecha Final"))
        {
            fechaFinal.setDocument(new JTextFieldLimit(10));
            fechaFinal.setText("");
        }
    }//GEN-LAST:event_fechaFinalFocusGained

    private void fechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioActionPerformed

    private void fechaInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaInicioFocusLost
        // TODO add your handling code here:
        if(fechaInicio.getText().equals(""))
        {
            fechaInicio.setDocument(new JTextFieldLimit(20));
            fechaInicio.setText("Fecha Inicial");
        }else
        {
            validarFecha(fechaInicio,formatoInvalidoFechaIni);
        }
    }//GEN-LAST:event_fechaInicioFocusLost

    private void fechaInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaInicioFocusGained
        // TODO add your handling code here:
        if(fechaInicio.getText().equals("Fecha Inicial"))
        {
            fechaInicio.setDocument(new JTextFieldLimit(10));
            fechaInicio.setText("");
        }

    }//GEN-LAST:event_fechaInicioFocusGained

    private void porcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porcentajeActionPerformed
        // TODO add your handling code here:
        if(porcentaje.isSelected())
        {
            Valor.setDocument(new JTextFieldLimit(3));
        }else
                {
                    Valor.setDocument(new JTextFieldLimit(8));
                }
        
    }//GEN-LAST:event_porcentajeActionPerformed

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
            java.util.logging.Logger.getLogger(descuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(descuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(descuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(descuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new descuento().setVisible(true);
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
    
    private String convertirFecha(String Fecha)
    {
        String[] palabras  = Fecha.split("/");
       
        return palabras[2] + "-" + palabras[1] + "-" + palabras[0];
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
        
        if(!isDateValid(fecha.getText()))
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
    
    private boolean validarPorcentaje()
    {
        if(!validar.validacionEntero(Valor.getText()))
    {
      Valor.setBorder(redBorder);
      formatoInvalidoValor.setVisible(true);
      formatoInvalidoValor.setText("Solo se permiten numeros enteros en este campo. ");
      return false;
     }
        
       if(Integer.parseInt(Valor.getText())>100)
       {
           Valor.setBorder(redBorder);
           formatoInvalidoValor.setVisible(true);
           formatoInvalidoValor.setText("El porcentaje no debe de ser mayor a 100.");
           return false;
       }else
           
           if(Integer.parseInt(Valor.getText())<=0)
       {
           Valor.setBorder(redBorder);
           formatoInvalidoValor.setVisible(true);
           formatoInvalidoValor.setText("El porcentaje debe de ser mayor a 0.");
           return false;
       }else
           {
           return true;
           }
    }
    
    private boolean validacionCampoValor()
    {
        if(porcentaje.isSelected())
        {
            if(validarPorcentaje())
            {
                return true;
            }else
            {
                return false;
            }
        }
        
        if(!validar.validacionCampoNumerico(Valor.getText()))
        {
            Valor.setBorder(redBorder);
            formatoInvalidoValor.setText("Solo se permiten números en este campo.");
            return false;
        }
        if(Double.parseDouble(Valor.getText()) <= 0)
        {
            Valor.setBorder(redBorder);
            formatoInvalidoValor.setText("El precio debe ser mayor a 0.");
            return true;
        }
         if(validar.validacionDecimal(Valor.getText()))
        {
            Valor.setBorder(greenBorder);
            formatoInvalidoValor.setText("Formato válido");
            return true;
        }else
        {
            Valor.setBorder(redBorder);
            formatoInvalidoValor.setText("El formato debe de ser 0000.00");
            return false;
        }
    }
    
    public LocalDate convertToLocalDateViaInstant(java.util.Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
}
    
     public static boolean isDateValid(String date) 
{
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
}
 
     
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JTextField Valor;
    private javax.swing.JComboBox<String> cbTiposDescuentos;
    private javax.swing.JTextField fechaFinal;
    private javax.swing.JTextField fechaInicio;
    private javax.swing.JLabel formatoInvalidoFechaFin;
    private javax.swing.JLabel formatoInvalidoFechaIni;
    private javax.swing.JLabel formatoInvalidoValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel logo;
    private javax.swing.JCheckBox porcentaje;
    private javax.swing.JLabel salir;
    // End of variables declaration//GEN-END:variables

    

   
}

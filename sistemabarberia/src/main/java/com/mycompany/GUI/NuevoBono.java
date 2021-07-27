/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.estadofacturaJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.estadofactura;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Kesil
 */

public class NuevoBono extends javax.swing.JFrame {
    
    private estadofacturaJpaController estadofacturaDAO = new estadofacturaJpaController();
    private Validaciones validar = new Validaciones();
    private ImageIcon imagen;
    private Icon icono;
    Border redBorder = BorderFactory.createLineBorder(Color.RED, 1);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 1);
    Border defaultBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true);

    


    /**
     * Creates new form nuevoestadofactura
     */
    public NuevoBono() {
        initComponents();
        formatoInvalido.setVisible(false);
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        this.insertarImagen(this.salir,"src/main/resources/Imagenes/x.png"); 
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tituloPantalla = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        formatoInvalido = new javax.swing.JLabel();
        txtPeriodo = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        cbTipoBono = new javax.swing.JComboBox<>();
        formatoInvalido1 = new javax.swing.JLabel();
        Aceptar = new javax.swing.JButton();
        Aceptar1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        salir = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("NUEVO BONO");
        jPanel1.add(tituloPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(853, 513, -1, -1));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        formatoInvalido.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido.setText("Formato no valido.");
        jPanel3.add(formatoInvalido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 270, 10));

        txtPeriodo.setBackground(new java.awt.Color(30, 33, 34));
        txtPeriodo.setDocument(new JTextFieldLimit(25));
        txtPeriodo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPeriodo.setForeground(new java.awt.Color(255, 255, 255));
        txtPeriodo.setText("Periodo");
        txtPeriodo.setToolTipText("Ingrese un nuevo Estado de Factura.");
        txtPeriodo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtPeriodo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPeriodoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPeriodoFocusLost(evt);
            }
        });
        txtPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeriodoActionPerformed(evt);
            }
        });
        txtPeriodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPeriodoKeyTyped(evt);
            }
        });
        jPanel3.add(txtPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 270, 42));

        jComboBox1.setBackground(new java.awt.Color(30, 33, 34));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Empleado" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 270, 44));

        txtCantidad.setBackground(new java.awt.Color(30, 33, 34));
        txtCantidad.setDocument(new JTextFieldLimit(25));
        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(255, 255, 255));
        txtCantidad.setText("Cantidad");
        txtCantidad.setToolTipText("Ingrese un nuevo Estado de Factura.");
        txtCantidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel3.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 150, 42));

        cbTipoBono.setBackground(new java.awt.Color(30, 33, 34));
        cbTipoBono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbTipoBono.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo Bono" }));
        cbTipoBono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoBonoActionPerformed(evt);
            }
        });
        jPanel3.add(cbTipoBono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 100, 40));

        formatoInvalido1.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido1.setText("Formato no valido.");
        jPanel3.add(formatoInvalido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 150, 20));

        Aceptar.setBackground(new java.awt.Color(189, 158, 76));
        Aceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Aceptar.setText("CANCELAR");
        Aceptar.setRequestFocusEnabled(false);
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        jPanel3.add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 110, 30));

        Aceptar1.setBackground(new java.awt.Color(189, 158, 76));
        Aceptar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Aceptar1.setText("ACEPTAR");
        Aceptar1.setRequestFocusEnabled(false);
        Aceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar1ActionPerformed(evt);
            }
        });
        jPanel3.add(Aceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 110, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 28, 450, 340));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 104, 520, 400));

        jPanel5.setBackground(new java.awt.Color(20, 17, 17));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, -1));

        salir.setText("jLabel2");
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 33, 28));

        logo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 92, 98));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //a;adir validaciones botonaceptar
    private void txtPeriodoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPeriodoFocusLost
           validacionCampos();
    }//GEN-LAST:event_txtPeriodoFocusLost

    private void txtPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPeriodoActionPerformed

    private void txtPeriodoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPeriodoKeyTyped
        // TODO add your handling code here:
        if ((txtPeriodo.getText() + evt.getKeyChar()).length() > 15) {
        evt.consume();
    }
    }//GEN-LAST:event_txtPeriodoKeyTyped

    private void txtPeriodoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPeriodoFocusGained
        // TODO add your handling code here:
        txtPeriodo.selectAll();
    }//GEN-LAST:event_txtPeriodoFocusGained

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        menuGerente menu = new menuGerente();
        menu.setVisible(true);
        this.dispose(); 
     
    }//GEN-LAST:event_salirMouseClicked

    private void txtCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadFocusGained

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadFocusLost

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AceptarActionPerformed

    private void Aceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Aceptar1ActionPerformed

    private void cbTipoBonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoBonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoBonoActionPerformed

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
            java.util.logging.Logger.getLogger(NuevoBono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoBono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoBono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoBono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoBono().setVisible(true);
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
    
    public void validacionCampos()
    {
        if(validar.validacionCampoNumerico(txtPeriodo.getText()))
        {
            txtPeriodo.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Solo se permite texto en este campo.");
            return;
            
        }
        
        if(!validar.validacionMayusculaInicial(txtPeriodo.getText()))
        {
             txtPeriodo.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("El nombre debe empezar con mayúscula.");
            return;
        }
        if(validar.validacionCadenaPalabras(txtPeriodo.getText()))
        {    
            txtPeriodo.setBorder(greenBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Formato válido");
            
        }else
        {
            txtPeriodo.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Esa no es una palabra válida.");
            return;
        }

         if(!validar.validacionCantidadMinima(txtPeriodo.getText(), 4))
            {
            txtPeriodo.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("El tipo de pago debe ser de minimo 4 letras.");
            }      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Aceptar1;
    private javax.swing.JComboBox<String> cbTipoBono;
    private javax.swing.JLabel formatoInvalido;
    private javax.swing.JLabel formatoInvalido1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel salir;
    private javax.swing.JLabel tituloPantalla;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPeriodo;
    // End of variables declaration//GEN-END:variables
}

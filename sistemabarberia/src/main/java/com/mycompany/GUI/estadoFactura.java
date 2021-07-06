/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.estadofacturaJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipodescuentoJpaController;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.estadofactura;import static com.mycompany.sistemabarberia.estadofactura_.idestado;
import com.mycompany.sistemabarberia.tipodescuento;
import java.awt.Color;
import java.awt.Image;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
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
public class estadoFactura extends javax.swing.JFrame {
    
    private estadofacturaJpaController estadofacturaDAO = new estadofacturaJpaController();
    private Validaciones validar = new Validaciones();
    private List<estadofactura> estadofacturaEnBd = estadofacturaDAO.findestadofacturaEntities();
    private ImageIcon imagen;
    private Icon icono;

    /**
     * Creates new form nuevoestadofactura
     */
    public estadoFactura() {
        initComponents();
        formatoInvalido.setVisible(false);
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");

        List<estadofactura> estadofacturaEnBd = estadofacturaDAO.findestadofacturaEntities();
        if (estadofacturaEnBd.size() > 0)
        {
            idestado.setText("  ID Estado: " + Integer.toString(estadofacturaEnBd.get(estadofacturaEnBd.size()-1).getIdestado()+1));
        }else
        {
           idestado.setText("  ID Estado de Factura: 1");
        }
       
        
    }
    
    public void Reiniciar()
    {
        List<estadofactura> estadofacturaEnBd = estadofacturaDAO.findestadofacturaEntities();
        if (estadofacturaEnBd.isEmpty())
        {
            idestado.setText("  ID Estado de Factura: 1");
        }else
        {
            idestado.setText("  ID Estado de Factura: " + Integer.toString(estadofacturaEnBd.get(estadofacturaEnBd.size()-1).getIdestado()+1));
        } 
        
        NombreEstado.setText("  Nombre de Estado Factura  ");
        Border border = BorderFactory.createLineBorder(Color.RED, 0);
            NombreEstado.setBorder(border);
            formatoInvalido.setVisible(false);

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
        idestado = new javax.swing.JTextField();
        formatoInvalido = new javax.swing.JLabel();
        NombreEstado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("NUEVO ESTADO DE FACTURA");

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
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        idestado.setEditable(false);
        idestado.setBackground(new java.awt.Color(30, 33, 34));
        idestado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idestado.setForeground(new java.awt.Color(255, 255, 255));
        idestado.setText("  ID Estado");
        idestado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        idestado.setSelectionColor(new java.awt.Color(55, 53, 53));
        idestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idestadoActionPerformed(evt);
            }
        });

        formatoInvalido.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido.setText("Formato no valido.");

        NombreEstado.setBackground(new java.awt.Color(30, 33, 34));
        NombreEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NombreEstado.setForeground(new java.awt.Color(255, 255, 255));
        NombreEstado.setText(" Estado");
        NombreEstado.setToolTipText("Ingrese un tipo de descuento válido.");
        NombreEstado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        NombreEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NombreEstadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NombreEstadoFocusLost(evt);
            }
        });
        NombreEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreEstadoActionPerformed(evt);
            }
        });
        NombreEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombreEstadoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formatoInvalido)
                    .addComponent(NombreEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idestado, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(idestado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(formatoInvalido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NombreEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tituloPantalla))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(405, 405, 405)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(tituloPantalla))
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        List<estadofactura> estadofacturaEnBd = estadofacturaDAO.findestadofacturaEntities();
        String txt = NombreEstado.getText();
        estadofactura estadoFacturaNuevo = new estadofactura();
        estadoFacturaNuevo.setNombreEstado(NombreEstado.getText());
        estadoFacturaNuevo.setActivo(true);
        
       
        for(int i=0; i < estadofacturaEnBd.size();i++)
        {
            if(estadoFacturaNuevo.getNombreEstado().equalsIgnoreCase(estadofacturaEnBd.get(i).getNombreEstado()))
            {
                Border border = BorderFactory.createLineBorder(Color.RED, 1);
                NombreEstado.setBorder(border);
                formatoInvalido.setVisible(true);
                formatoInvalido.setText("Este estado de factura ya existe.");
                return;
            }
        }
        
        if(validar.validacionCadenaPalabras(txt)){
            try {
            estadofacturaDAO.create(estadoFacturaNuevo);
            JOptionPane.showMessageDialog(null,"Operación Exitosa");
                    Reiniciar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se pudo guardar, excepción: " + ex.getMessage());
        }
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    
    
    private void idestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idestadoActionPerformed
//a;adir validaciones botonaceptar
    private void NombreEstadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreEstadoFocusLost

         for(int i=0; i < estadofacturaEnBd.size();i++)
        {
            if(NombreEstado.getText().equalsIgnoreCase(estadofacturaEnBd.get(i).getNombreEstado()))
            {
            Border border = BorderFactory.createLineBorder(Color.RED, 1);
            NombreEstado.setBorder(border);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Este estado de factura ya existe.");
            }
        }
        if(!validar.validacionCadenaPalabras(NombreEstado.getText()))
        {    
            Border border = BorderFactory.createLineBorder(Color.RED, 1);
            NombreEstado.setBorder(border);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Formato inválido");
        }
        
       
        
    }//GEN-LAST:event_NombreEstadoFocusLost

    private void NombreEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreEstadoActionPerformed

    private void NombreEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreEstadoKeyTyped
        // TODO add your handling code here:
        if ((NombreEstado.getText() + evt.getKeyChar()).length() > 20) {
        evt.consume();
    }
    }//GEN-LAST:event_NombreEstadoKeyTyped

    private void NombreEstadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreEstadoFocusGained
        // TODO add your handling code here:
        NombreEstado.setText("");
    }//GEN-LAST:event_NombreEstadoFocusGained

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
            java.util.logging.Logger.getLogger(estadoFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(estadoFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(estadoFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(estadoFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new estadoFactura().setVisible(true);
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
    private javax.swing.JTextField NombreEstado;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JLabel formatoInvalido;
    private javax.swing.JTextField idestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

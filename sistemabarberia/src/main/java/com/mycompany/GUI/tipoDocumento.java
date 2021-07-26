/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.tipodocumentoJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.tipodocumento;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Kesil
 */
public class tipoDocumento extends javax.swing.JFrame {
    
    private tipodocumentoJpaController tipodocumentoDAO = new tipodocumentoJpaController();
    private Validaciones validar = new Validaciones();
    private List<tipodocumento> tipodocumentoEnBd = tipodocumentoDAO.findtipodocumentoEntities();
    private ImageIcon imagen;
    private Icon icono;
    Border redBorder = BorderFactory.createLineBorder(Color.RED, 1);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 1);
    Border defaultBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true);


    /**
     * Creates new form nuevoTipoDocumento
     */
    public tipoDocumento() {
        initComponents();
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        this.insertarImagen(this.salir,"src/main/resources/Imagenes/x.png");
        
        Reiniciar();
    }
    
    public void Reiniciar()
    {
        List<tipodocumento> tipodocumentoEnBd = tipodocumentoDAO.findtipodocumentoEntities();
        if (tipodocumentoEnBd.isEmpty())
        {
            idtipodocumento.setText("  ID Tipo de Documento: 1");
        }else
        {
            idtipodocumento.setText("  ID Tipo de Documento: " + Integer.toString(tipodocumentoEnBd.get(tipodocumentoEnBd.size()-1).getIdtipodocumento()+1));
        } 
        TipoDocumento.setBorder(defaultBorder);
        TipoDocumento.setText("  Nombre de Documento");
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
        idtipodocumento = new javax.swing.JTextField();
        formatoInvalido = new javax.swing.JLabel();
        TipoDocumento = new javax.swing.JTextField();
        salir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(498, 533));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("TIPO DE DOCUMENTO");

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

        idtipodocumento.setEditable(false);
        idtipodocumento.setBackground(new java.awt.Color(30, 33, 34));
        idtipodocumento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idtipodocumento.setForeground(new java.awt.Color(255, 255, 255));
        idtipodocumento.setText("   ID Tipo de Documento");
        idtipodocumento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        idtipodocumento.setSelectionColor(new java.awt.Color(55, 53, 53));
        idtipodocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idtipodocumentoActionPerformed(evt);
            }
        });

        formatoInvalido.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido.setText("Formato no valido.");

        TipoDocumento.setBackground(new java.awt.Color(30, 33, 34));
        TipoDocumento.setDocument(new JTextFieldLimit(25));
        TipoDocumento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TipoDocumento.setForeground(new java.awt.Color(255, 255, 255));
        TipoDocumento.setText("  Nombre de Documento");
        TipoDocumento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        TipoDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TipoDocumentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TipoDocumentoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TipoDocumento)
                    .addComponent(idtipodocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(formatoInvalido))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(idtipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(formatoInvalido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
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
                .addContainerGap(31, Short.MAX_VALUE))
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
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tituloPantalla))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(363, 363, 363)
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
                        .addContainerGap()
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(tituloPantalla))
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        List<tipodocumento> tipodocumentosEnBd = tipodocumentoDAO.findtipodocumentoEntities();
        tipodocumento tipoDocumentoNuevo = new tipodocumento();
        tipoDocumentoNuevo.setTipoDocumento(TipoDocumento.getText());
        tipoDocumentoNuevo.setActivo(true);
        
        validarCampos();
       
        for(int i=0; i < tipodocumentosEnBd.size();i++)
        {
            if(tipoDocumentoNuevo.getTipoDocumento().equalsIgnoreCase(tipodocumentosEnBd.get(i).getTipoDocumento()))
            {
                Border border = BorderFactory.createLineBorder(Color.RED, 1);
                TipoDocumento.setBorder(border);
                formatoInvalido.setVisible(true);
                formatoInvalido.setText("Ese tipo de documento ya existe.");
                return;
            }
        }
        
        if(validar.validacionCadenaPalabras(TipoDocumento.getText()) && validar.validacionCantidadMinima(TipoDocumento.getText(),4)){
            try {
            tipodocumentoDAO.create(tipoDocumentoNuevo);
            JOptionPane.showMessageDialog(null,"Operación Exitosa");
                    Reiniciar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se pudo guardar, excepción: " + ex.getMessage());
        }
        }else{JOptionPane.showMessageDialog(null, "Por favor, corrige los campos en rojo.","Datos inválidos",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_botonAceptarActionPerformed

    
    
    private void idtipodocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idtipodocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idtipodocumentoActionPerformed

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        tipodocumentoDAO.close();
    }//GEN-LAST:event_salirMouseClicked

    private void TipoDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TipoDocumentoFocusLost
        // TODO add your handling code here:
        validarCampos();
    }//GEN-LAST:event_TipoDocumentoFocusLost

    private void TipoDocumentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TipoDocumentoFocusGained
        // TODO add your handling code here:
        TipoDocumento.selectAll();
    }//GEN-LAST:event_TipoDocumentoFocusGained

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
            java.util.logging.Logger.getLogger(tipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tipoDocumento().setVisible(true);
            }
        });
        
        
    }
    private void validarCampos()
    {
        if(validar.validacionCampoNumerico(TipoDocumento.getText()))
        {
            TipoDocumento.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Solo se permite texto en este campo.");
            return;
        }
        if(!validar.validacionMayusculaInicial(TipoDocumento.getText()))
        {
            TipoDocumento.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("El tipo de documento debe iniciar con mayuscula.");
            return;
        }
        if(validar.validacionCadenaPalabras(TipoDocumento.getText()))
        {    
            TipoDocumento.setBorder(greenBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Formato válido");
            
        }else
        {
            TipoDocumento.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Esa no es una palabra válida.");
            return;
        }
        if(!validar.validacionCantidadMinima(TipoDocumento.getText(), 4))
            {
            TipoDocumento.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("El tipo de pago debe ser de minimo 4 letras.");
            }
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
    private javax.swing.JTextField TipoDocumento;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JLabel formatoInvalido;
    private javax.swing.JTextField idtipodocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel salir;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

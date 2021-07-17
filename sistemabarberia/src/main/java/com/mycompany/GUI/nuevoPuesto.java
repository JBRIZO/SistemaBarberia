/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.puestoJpaController;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.puesto;
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
 * @author Jonathan Laux
 */
public class nuevoPuesto extends javax.swing.JFrame {
    
    private puestoJpaController puestoDAO = new puestoJpaController();
    private Validaciones validar = new Validaciones();
    private List<puesto> puestosEnBd = puestoDAO.findpuestoEntities();
    private ImageIcon imagen;
    private Icon icono;
    Border redBorder = BorderFactory.createLineBorder(Color.RED, 1);            
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 1);
    Border defaultBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true);


    /**
     * Creates new form nuevoTipoDescuento
     */
    public nuevoPuesto() {
        initComponents();
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        this.insertarImagen(this.salir,"src/main/resources/Imagenes/x.png");
        Reiniciar();  
    }
    
    public void Reiniciar()
    {
        List<puesto> puestosEnBd = puestoDAO.findpuestoEntities();
        if (puestosEnBd.isEmpty())
        {
            idPuesto.setText("  ID de Puesto: 1");
        }else
        {
            idPuesto.setText("  ID de Puesto: " + Integer.toString(puestosEnBd.get(puestosEnBd.size()-1).getIdpuesto()+1));
        } 
        
        nombrePuesto.setText("  Nombre del Nuevo Puesto");
        nombrePuesto.setBorder(defaultBorder);
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        idPuesto = new javax.swing.JTextField();
        formatoInvalido = new javax.swing.JLabel();
        nombrePuesto = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        salir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(496, 547));
        setMinimumSize(new java.awt.Dimension(496, 547));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(496, 547));
        jPanel1.setMinimumSize(new java.awt.Dimension(496, 547));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("NUEVO PUESTO");

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

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        idPuesto.setEditable(false);
        idPuesto.setBackground(new java.awt.Color(30, 33, 34));
        idPuesto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idPuesto.setForeground(new java.awt.Color(255, 255, 255));
        idPuesto.setText("ID de Puesto");
        idPuesto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        idPuesto.setSelectionColor(new java.awt.Color(55, 53, 53));
        idPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPuestoActionPerformed(evt);
            }
        });

        formatoInvalido.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido.setText("Formato no valido.");

        nombrePuesto.setBackground(new java.awt.Color(30, 33, 34));
        nombrePuesto.setDocument(new JTextFieldLimit(25));
        nombrePuesto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombrePuesto.setForeground(new java.awt.Color(255, 255, 255));
        nombrePuesto.setText("  Nombre del nuevo puesto.");
        nombrePuesto.setToolTipText("Ingrese un puesto válido.");
        nombrePuesto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nombrePuesto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombrePuestoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombrePuestoFocusLost(evt);
            }
        });
        nombrePuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombrePuestoActionPerformed(evt);
            }
        });
        nombrePuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombrePuestoKeyTyped(evt);
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
                    .addComponent(nombrePuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(idPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(formatoInvalido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombrePuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel9.setBackground(new java.awt.Color(20, 17, 17));

        salir.setText("jLabel2");
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(347, 347, 347)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(tituloPantalla))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloPantalla, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 30, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed

        List<puesto> puestosEnBd = puestoDAO.findpuestoEntities();
        String txt = nombrePuesto.getText();
        puesto puestoNuevo = new puesto();
        puestoNuevo.setNomPuesto(nombrePuesto.getText());
        puestoNuevo.setActivo(true);
        
        validacionCampos();
        for(int i=0; i < puestosEnBd.size();i++)
        {
            if(nombrePuesto.getText().equalsIgnoreCase(puestosEnBd.get(i).getNomPuesto()))
            {
            nombrePuesto.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Ese puesto ya existe.");
            return;
            }
        }
        
        if(validar.validacionCadenaPalabras(txt) && validar.validacionCantidadMinima(txt,4)){
            try {
            puestoDAO.create(puestoNuevo);
            JOptionPane.showMessageDialog(null,"Operacion Exitosa");
                    Reiniciar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se pudo guardar, excepcion: " + ex.getMessage());
        }
    }else{JOptionPane.showMessageDialog(null, "Por favor, corrige los campos en rojo.","Datos inválidos",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_botonAceptarActionPerformed

    
    
    private void idPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPuestoActionPerformed
//a;adir validaciones botonaceptar
    private void nombrePuestoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombrePuestoFocusLost
        validacionCampos();     
    }//GEN-LAST:event_nombrePuestoFocusLost

    private void nombrePuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombrePuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombrePuestoActionPerformed

    private void nombrePuestoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombrePuestoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nombrePuestoKeyTyped

    private void nombrePuestoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombrePuestoFocusGained
        // TODO add your handling code here:
        nombrePuesto.selectAll();
    }//GEN-LAST:event_nombrePuestoFocusGained

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        puestoDAO.close();
    }//GEN-LAST:event_salirMouseClicked

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
            java.util.logging.Logger.getLogger(nuevoPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevoPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevoPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevoPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoPuesto().setVisible(true);
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
    
    private void validacionCampos()
    {
        if(validar.validacionCampoNumerico(nombrePuesto.getText()))
        {
            nombrePuesto.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Solo se permite texto en este campo.");
            return;
        }
        
        if(!validar.validacionMayusculaInicial(nombrePuesto.getText()))
        {
            nombrePuesto.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("El puesto debe iniciar con mayuscula.");
            return;
        }
        if(!validar.validacionCantidadMinima(nombrePuesto.getText(),4))
            {
            nombrePuesto.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("El nuevo puesto debe ser de minimo 4 letras.");
            return;
            }
        
         
        if(validar.validacionCadenaPalabras(nombrePuesto.getText()))
        {    
            nombrePuesto.setBorder(greenBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Formato válido");
            
        }else
        {
            nombrePuesto.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("No puedes repetir tantas letras.");
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JLabel formatoInvalido;
    private javax.swing.JTextField idPuesto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField nombrePuesto;
    private javax.swing.JLabel salir;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

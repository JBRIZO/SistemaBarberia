/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.precioshistoricoserviciosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.serviciosJpaController;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.precioshistoricoservicios;
import com.mycompany.sistemabarberia.servicios;
import com.mycompany.sistemabarberia.usuarios;
import com.mycompany.sistemabarberia.JPACOntrollers.usuariosJpaController;
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
public class nuevoUsuario extends javax.swing.JFrame {
    
    private usuariosJpaController usuariosDAO = new usuariosJpaController();
    private Validaciones validar = new Validaciones();
    private List<usuarios> usuariosEnBd = usuariosDAO.findusuariosEntities();
    private ImageIcon imagen;
    private Icon icono;
    //private empleadoJpaController empleadoDAO = new empleadoJpaController();
   // private List<empleado> empleadoEnBd = empleadoDAO.findempleadoEntities();
    

    /**
     * Creates new form nuevoTipoDescuento
     */
    public nuevoUsuario() {
        initComponents();
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        Reiniciar();    
    }
    
    public void Reiniciar()
    {
 
    
        
        nombreUsuario.setText("  Nombre de Usuario ");
        Contraseña.setText("   Contraseña ");
        Border border = BorderFactory.createLineBorder(Color.RED, 0);
        nombreUsuario.setBorder(border);
        Contraseña.setBorder(border);
        formatoInvalido1.setVisible(false);
        formatoInvalido2.setVisible(false);

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
        formatoInvalido1 = new javax.swing.JLabel();
        Contraseña = new javax.swing.JTextField();
        nombreUsuario = new javax.swing.JTextField();
        formatoInvalido2 = new javax.swing.JLabel();
        empleado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("NUEVO USUARIO");

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

        formatoInvalido1.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido1.setText("Formato no valido.");

        Contraseña.setBackground(new java.awt.Color(30, 33, 34));
        Contraseña.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Contraseña.setForeground(new java.awt.Color(255, 255, 255));
        Contraseña.setText("Contraseña");
        Contraseña.setToolTipText("Ingrese un precio de servicio válido.");
        Contraseña.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Contraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ContraseñaFocusLost(evt);
            }
        });
        Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActionPerformed(evt);
            }
        });
        Contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ContraseñaKeyTyped(evt);
            }
        });

        nombreUsuario.setBackground(new java.awt.Color(30, 33, 34));
        nombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setText("Nombre de Usuario");
        nombreUsuario.setToolTipText("Ingrese un nombre de servicio valido.");
        nombreUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nombreUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreUsuarioFocusLost(evt);
            }
        });
        nombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUsuarioActionPerformed(evt);
            }
        });
        nombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreUsuarioKeyTyped(evt);
            }
        });

        formatoInvalido2.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido2.setText("Formato no valido.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formatoInvalido2)
                    .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatoInvalido1)
                    .addComponent(empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(formatoInvalido1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(formatoInvalido2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(tituloPantalla))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(919, 919, 919)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloPantalla))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        
        //anadir servicio
        List<usuarios> usuariosEnBd = usuariosDAO.findusuariosEntities();
        String txt = nombreUsuario.getText();
        usuarios usuarioNuevo = new usuarios();
        usuarioNuevo.setNomCuenta(nombreUsuario.getText());
        usuarioNuevo.setContrasena(Contraseña.getText());
        //usuarioNuevo.setIDEmpleado();
        usuarioNuevo.setActivo(true);
        
        //anadir precio 1
      
        for(int i=0; i < usuariosEnBd.size();i++)
        {
            if(usuarioNuevo.getNomCuenta().equalsIgnoreCase(usuariosEnBd.get(i).getNomCuenta()))
            {
            Border redBorder = BorderFactory.createLineBorder(Color.RED,1);
            nombreUsuario.setBorder(redBorder);
            formatoInvalido1.setVisible(true);
            formatoInvalido1.setText("Ese usuario ya existe.");
            return;
            }
        }
           
        if(validar.validacionCadenaPalabras(txt) && validar.validacionDecimal(Contraseña.getText())){
            
            try {
            usuariosDAO.create(usuarioNuevo); 
      
              
            usuariosDAO.create(usuarioNuevo);    
            JOptionPane.showMessageDialog(null,"Operacion Exitosa");
                    Reiniciar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se pudo guardar el usuario, excepcion: " + ex.getMessage());
        }
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    
    
    
    
    private void nombreUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreUsuarioFocusGained
        // TODO add your handling code here:
        nombreUsuario.setText("");
    }//GEN-LAST:event_nombreUsuarioFocusGained

    private void nombreUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreUsuarioFocusLost
        // TODO add your handling code here:
        Border redBorder = BorderFactory.createLineBorder(Color.RED,1);
        Border greenBorder = BorderFactory.createLineBorder(Color.GREEN,1);
        for(int i=0; i < usuariosEnBd.size();i++)
        {
            if(nombreUsuario.getText().equalsIgnoreCase(usuariosEnBd.get(i).getNomCuenta()))
            {
            nombreUsuario.setBorder(redBorder);
            formatoInvalido1.setVisible(true);
            formatoInvalido1.setText("Ese usuario ya existe.");
            }
        }
        if(validar.validacionCadenaPalabras(nombreUsuario.getText()))
        {    
            nombreUsuario.setBorder(greenBorder);
            formatoInvalido1.setVisible(true);
            formatoInvalido1.setText("Formato válido");
            
        }else
        {
            nombreUsuario.setBorder(redBorder);
            formatoInvalido1.setVisible(true);
            formatoInvalido1.setText("Formato inválido");
        }
        
    }//GEN-LAST:event_nombreUsuarioFocusLost

    private void nombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreUsuarioActionPerformed

    private void nombreUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreUsuarioKeyTyped
        // TODO add your handling code here:
        if ((nombreUsuario.getText() + evt.getKeyChar()).length() > 15) {
        evt.consume();}
    }//GEN-LAST:event_nombreUsuarioKeyTyped

    private void ContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContraseñaKeyTyped
        // TODO add your handling code here:
        if ((Contraseña.getText() + evt.getKeyChar()).length() > 6) {
            evt.consume();
        }
    }//GEN-LAST:event_ContraseñaKeyTyped

    private void ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaActionPerformed

//a;adir validaciones botonaceptar
    private void ContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ContraseñaFocusLost

        Border redBorder = BorderFactory.createLineBorder(Color.RED,1);
        Border greenBorder = BorderFactory.createLineBorder(Color.GREEN,1);
        if(validar.validacionDecimal(Contraseña.getText()))
        {
            Contraseña.setBorder(greenBorder);
            formatoInvalido2.setVisible(true);
            formatoInvalido2.setText("Formato válido");
        }else
        {
            Contraseña.setBorder(redBorder);
            formatoInvalido2.setVisible(true);
            formatoInvalido2.setText("Formato inválido");
        }

    }//GEN-LAST:event_ContraseñaFocusLost

    private void ContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ContraseñaFocusGained
        // TODO add your handling code here:
        Contraseña.setText("");
    }//GEN-LAST:event_ContraseñaFocusGained

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
            java.util.logging.Logger.getLogger(nuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new nuevoUsuario().setVisible(true);
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
    private javax.swing.JTextField Contraseña;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JComboBox<String> empleado;
    private javax.swing.JLabel formatoInvalido1;
    private javax.swing.JLabel formatoInvalido2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField nombreUsuario;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

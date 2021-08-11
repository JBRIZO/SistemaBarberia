/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.usuarios;
import com.mycompany.sistemabarberia.JPACOntrollers.usuariosJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.empleado;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import org.apache.commons.codec.digest.DigestUtils;

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
    private empleadoJpaController empleadoDAO = new empleadoJpaController();
    private List<empleado> empleadoEnBd = empleadoDAO.findempleadoEntities();
    Border redBorder = BorderFactory.createLineBorder(Color.RED,1);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN,1);
    Border defaultBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true);

    

    /**
     * Creates new form nuevoTipoDescuento
     */
    public nuevoUsuario() {
       this.setVisible(false);
        this.setUndecorated(true);
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        this.insertarImagen(this.salir1,"src/main/resources/Imagenes/x.png");
        Reiniciar();   
        for(int i = 0; i < empleadoEnBd.size();i++)
        {
            if(empleadoEnBd.get(i).isActivo())
            cbEmpleados.addItem(empleadoEnBd.get(i).toString());
        }
    }
    
    public void Reiniciar()
    {
        nombreUsuario.setText("Nombre Usuario");
        nombreUsuario.setBorder(defaultBorder);
        contrasena.setBorder(defaultBorder);
        confirmarContrasena.setBorder(defaultBorder);
        formatoInvalido1.setText(" ");
        formatoInvalido2.setText(" ");
        formatoInvalido3.setText(" ");
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
        nombreUsuario = new javax.swing.JTextField();
        formatoInvalido2 = new javax.swing.JLabel();
        cbEmpleados = new javax.swing.JComboBox<>();
        contrasena = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        formatoInvalido3 = new javax.swing.JLabel();
        confirmarContrasena = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mostrar = new javax.swing.JToggleButton();
        salir1 = new javax.swing.JLabel();

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

        nombreUsuario.setBackground(new java.awt.Color(30, 33, 34));
        nombreUsuario.setDocument(new JTextFieldLimit(16));
        nombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setText("Nombre Usuario");
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

        cbEmpleados.setBackground(new java.awt.Color(30, 33, 34));
        cbEmpleados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cbEmpleados.setPreferredSize(new java.awt.Dimension(270, 42));

        contrasena.setBackground(new java.awt.Color(30, 33, 34));
        contrasena.setForeground(new java.awt.Color(255, 255, 255));
        contrasena.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        contrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                contrasenaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                contrasenaFocusLost(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Empleado:");

        formatoInvalido3.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido3.setText("Formato no valido.");

        confirmarContrasena.setBackground(new java.awt.Color(30, 33, 34));
        confirmarContrasena.setForeground(new java.awt.Color(255, 255, 255));
        confirmarContrasena.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Confirmar Contraseña:");

        mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/show.png"))); // NOI18N
        mostrar.setContentAreaFilled(false);
        mostrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hide.png"))); // NOI18N
        mostrar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mostrarStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(confirmarContrasena)
                            .addComponent(formatoInvalido3)
                            .addComponent(jLabel2)
                            .addComponent(formatoInvalido2)
                            .addComponent(nombreUsuario)
                            .addComponent(formatoInvalido1)
                            .addComponent(cbEmpleados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(contrasena))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formatoInvalido1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(formatoInvalido2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formatoInvalido3)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        salir1.setText("jLabel2");
        salir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salir1MouseClicked(evt);
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
                        .addGap(39, 39, 39)
                        .addComponent(tituloPantalla))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(salir1))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(salir1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

         if(nombreUsuario.getText().equals("Nombre Usuario") || contrasena.getPassword().equals("") || contrasena .getPassword().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Debes rellenar con datos todos los campos.","Datos Inválidos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for(int i = 0; i< usuariosEnBd.size();i++)
        {
            if(usuariosEnBd.get(i).getNomCuenta().equals(nombreUsuario.getText()))
            {
            JOptionPane.showMessageDialog(null,"Ese usuario ya existe, intenta con otro nombre de usuario.","Usuario ya existente", JOptionPane.ERROR_MESSAGE);
            nombreUsuario.setBorder(redBorder);
            return;
            }
        }
        if(cbEmpleados.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(null,"Debes de seleccionar un empleado.","Datos Inválidos",JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<usuarios> usuariosEnBd = usuariosDAO.findusuariosEntities();
        String pass = new String(contrasena.getPassword());
        String confirmPass = new String(confirmarContrasena.getPassword());
        
        if(!pass.equals(confirmPass))
        {
            contrasena.setBorder(redBorder);
            confirmarContrasena.setBorder(redBorder);
            formatoInvalido3.setText("Ambas contraseñas deben coincidir.");
            return;
        }
        
        
        //encriptacion de contrasena
        String contraEncriptada = DigestUtils.md5Hex(pass);
        
        //crear nuevo objeto de usuario
        usuarios usuarioNuevo = new usuarios();
        usuarioNuevo.setNomCuenta(nombreUsuario.getText());
        usuarioNuevo.setContrasena(contraEncriptada);
        usuarioNuevo.setIDEmpleado(Character.getNumericValue(cbEmpleados.getSelectedItem().toString().charAt(0)));
        usuarioNuevo.setActivo(true);
        
        //anadir precio 1
        for(int i=0; i < usuariosEnBd.size();i++)
        {
            if(usuarioNuevo.getIDEmpleado() == usuariosEnBd.get(i).getIDEmpleado())
            {
            nombreUsuario.setBorder(redBorder);
            formatoInvalido1.setVisible(true);
            formatoInvalido1.setText("Ese empleado ya tiene un usuario.");
            return;
            }
        }
        
        if(validarContrasena(contrasena,formatoInvalido2) && validarContrasena(confirmarContrasena,formatoInvalido3) && validarUsuario(nombreUsuario,formatoInvalido1)){
            
            try {
            usuariosDAO.create(usuarioNuevo);
            JOptionPane.showMessageDialog(null,"Operacion Exitosa");
                    Reiniciar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se pudo guardar el usuario, excepcion: " + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    
    
    
    
    private void nombreUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreUsuarioFocusGained
        // TODO add your handling code here:
        nombreUsuario.setText("");
    }//GEN-LAST:event_nombreUsuarioFocusGained

    private void nombreUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreUsuarioFocusLost
    if(nombreUsuario.getText().equals(""))
    {
        nombreUsuario.setText("Nombre Usuario");
    }else
    {
        validarUsuario(nombreUsuario,formatoInvalido1);
    }
    }//GEN-LAST:event_nombreUsuarioFocusLost

    private void nombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreUsuarioActionPerformed

    private void nombreUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreUsuarioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreUsuarioKeyTyped

    private void contrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contrasenaFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_contrasenaFocusLost

    private void salir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salir1MouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaUsuarios().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose();
        empleadoDAO.close();
    }//GEN-LAST:event_salir1MouseClicked

    private void contrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contrasenaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_contrasenaFocusGained

    private void mostrarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mostrarStateChanged
        // TODO add your handling code here:
        if(mostrar.isSelected())
        {
            contrasena.setEchoChar((char)0);
        }else
        {
            contrasena.setEchoChar('*');
        }
    }//GEN-LAST:event_mostrarStateChanged

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
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoUsuario().setVisible(true);
            }
        });
        
        
    }
    
    private boolean validarUsuario(javax.swing.JTextField textField, JLabel label)
    {
        
        if(validar.validacionLetrasRepetidas(textField.getText()))
        {
            textField.setBorder(redBorder);
            label.setVisible(true);
            label.setText("No puedes repetir tantas letras.");
            return false;
        }
        
        if(validar.validacionCampoNumerico(textField.getText()))
        {
            textField.setBorder(redBorder);
            label.setVisible(true);
            label.setText("El nombre de usuario debe contener letras.");
            return false;
        }
        if(!validar.validacionCantidadMinima(textField.getText(),3))
        {
            textField.setBorder(redBorder);
            label.setVisible(true);
            label.setText("El nombre de usuario debe ser de 5 caracteres mínimo.");
            return false;
        }
        if(validar.validarNomCuenta(textField.getText()))
        {
            textField.setBorder(greenBorder);
            label.setText("Usuario válido.");
            return true;
        }else
        {
            textField.setBorder(redBorder);
            label.setVisible(true);
            label.setText("El nombre de usuario es inválido.");
            JOptionPane.showMessageDialog(null, "Un nombre de usuario válido no lleva mayúsculas, solo se permiten lo signos '-' y '_', letras y números.\n"
                    + " Debe contener al menos 5 caracteres.", 
                    "Nombre de Usuario Inválido", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    
    private boolean validarContrasena(javax.swing.JPasswordField contra, JLabel label)
    {
        String pass = new String(contra.getPassword());
        if(validar.validarContrasena(pass))
        {
            contra.setBorder(greenBorder);
            label.setText("Contraseña válida.");
            return true;
        }else
        {
            contra.setBorder(redBorder);
            JOptionPane.showMessageDialog(null, "Para que la contraseña sea válida necesita ser de mínimo 8 caracteres, debe incluir al menos una letra mayúscula,\n"
                    + " un cáracter especial(@$!%*?&) y un número.", 
                    "Contraseña inválida", JOptionPane.ERROR_MESSAGE);
            return false;
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
    private javax.swing.JButton botonAceptar;
    private javax.swing.JComboBox<String> cbEmpleados;
    private javax.swing.JPasswordField confirmarContrasena;
    private javax.swing.JPasswordField contrasena;
    private javax.swing.JLabel formatoInvalido1;
    private javax.swing.JLabel formatoInvalido2;
    private javax.swing.JLabel formatoInvalido3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JToggleButton mostrar;
    private javax.swing.JTextField nombreUsuario;
    private javax.swing.JLabel salir1;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.usuariosJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.usuarios;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Jonathan Laux
 */
public class PantallaLogin extends javax.swing.JFrame {

    /**
     * Creates new form PantallaLogin
     */
    private usuariosJpaController usuariosDAO = new usuariosJpaController();
    private ImageIcon imagen;
    private Icon icono;
    
    public PantallaLogin() {
        this.setVisible(false);
        this.setUndecorated(true);
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoLogin.png");
        this.insertarImagen(this.imgLogin,"src/main/resources/Imagenes/loginImage.png");
        mostrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hide.png")));
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
        imgLogin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JTextField();
        iniciarSesion = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        mostrar = new javax.swing.JToggleButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));

        logo.setForeground(new java.awt.Color(255, 255, 255));

        imgLogin.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BIENVENIDO");

        nombreUsuario.setBackground(new java.awt.Color(30, 33, 34));
        nombreUsuario.setDocument(new JTextFieldLimit(17));
        nombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setText("Nombre de Usuario");
        nombreUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nombreUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreUsuarioFocusLost(evt);
            }
        });

        iniciarSesion.setBackground(new java.awt.Color(189, 158, 76));
        iniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        iniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/login.png"))); // NOI18N
        iniciarSesion.setText("Iniciar Sesion");
        iniciarSesion.setRequestFocusEnabled(false);
        iniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciarSesionMouseClicked(evt);
            }
        });
        iniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSesionActionPerformed(evt);
            }
        });

        password.setBackground(new java.awt.Color(30, 33, 34));
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");

        mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/show.png"))); // NOI18N
        mostrar.setContentAreaFilled(false);
        mostrar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mostrarStateChanged(evt);
            }
        });

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/exit.png"))); // NOI18N
        exit.setContentAreaFilled(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(imgLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nombreUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(iniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(2, 2, 2)
                                        .addComponent(mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(111, 111, 111)))
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exit)
                .addGap(19, 19, 19)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(iniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
            .addComponent(imgLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void iniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarSesionMouseClicked
        // TODO add your handling code here:
        List<usuarios> usuariosBD = usuariosDAO.findusuariosEntities();
        String contrasena = new String(password.getPassword());
        String contraEncriptada = DigestUtils.md5Hex(contrasena);
        usuarios usuarioActual = new usuarios();

        //encontrar usuario en la base de datos
        for(int i = 0; i < usuariosBD.size(); i++)
        {
            if(nombreUsuario.getText().equals(usuariosBD.get(i).getNomCuenta()))
            {
                usuarioActual = usuariosBD.get(i);
            }
        }
        if(usuarioActual.getIntentos() == 3)
                {
                    JOptionPane.showMessageDialog(null,"Alguien intento acceder a tu cuenta sin éxito 3 veces, "
                            + "tu usuario ha sido bloqueado.","Usuario Bloqueado",JOptionPane.ERROR_MESSAGE);
                    return;
                }else
                {
                    if(!usuarioActual.getActivo())
                    {
                         JOptionPane.showMessageDialog(null,"Este usuario ha sido desactivado, "
                            + "comunicate con el gerente.","Usuario Desactivado",JOptionPane.ERROR_MESSAGE);
                    return;
                    }
                    if(contraEncriptada.equals(usuarioActual.getContrasena()))
                {
                    usuarioActual.setIdusuario(usuarioActual.getIdusuario());
                    usuarioActual.setIntentos(0);
                    usuarioActual.setIDEmpleado(usuarioActual.getIDEmpleado());
                    usuarioActual.setNomCuenta(usuarioActual.getNomCuenta());
                    usuarioActual.setContrasena(usuarioActual.getContrasena());
                    usuarioActual.setActivo(true);
                    UsuarioSingleton usuario= UsuarioSingleton.getUsuario(usuarioActual);
                    usuario.setUsuario(usuarioActual);
                    try{usuariosDAO.edit(usuarioActual);
                    }catch(Exception ex)
                    {}
                   java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                    new PantallaFactura().setVisible(true);
                        }
                    });
                    this.setVisible(false);
                    this.dispose();
                }else
                {
                    JOptionPane.showMessageDialog(null,"Contraseña o usuario incorrectos.", "Credenciales incorrectas", JOptionPane.ERROR_MESSAGE);
                    password.selectAll();
                    usuarioActual.setIdusuario(usuarioActual.getIdusuario());
                    usuarioActual.setIDEmpleado(usuarioActual.getIDEmpleado());
                    usuarioActual.setIntentos(usuarioActual.getIntentos()+1);
                    usuarioActual.setNomCuenta(usuarioActual.getNomCuenta());
                    usuarioActual.setContrasena(usuarioActual.getContrasena());
                    if(usuarioActual.getIntentos() == 3)
                    {
                        usuarioActual.setActivo(false);
                    }else
                    {
                      usuarioActual.setActivo(true);
                    }
                    try{
                        usuariosDAO.edit(usuarioActual);
                        return;
                    }catch(Exception ex)
                    {System.out.println(ex);}
                }
        }
        contrasena = "";
    }//GEN-LAST:event_iniciarSesionMouseClicked

    private void iniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iniciarSesionActionPerformed

    private void nombreUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreUsuarioFocusGained
        // TODO add your handling code here:
        if(nombreUsuario.getText().equals("Nombre de Usuario"))
        {
            nombreUsuario.setText("");
        }
    }//GEN-LAST:event_nombreUsuarioFocusGained

    private void nombreUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreUsuarioFocusLost
        // TODO add your handling code here:
        if(nombreUsuario.getText().equals(""))
        {
            nombreUsuario.setText("Nombre de Usuario");
        }
    }//GEN-LAST:event_nombreUsuarioFocusLost

    private void mostrarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mostrarStateChanged
        // TODO add your handling code here:
        if(mostrar.isSelected())
        {
            password.setEchoChar((char)0);
        }else
        {
            password.setEchoChar('*');
        }

    }//GEN-LAST:event_mostrarStateChanged

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaLogin().setVisible(true);
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
    private javax.swing.JButton exit;
    private javax.swing.JLabel imgLogin;
    private javax.swing.JButton iniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JToggleButton mostrar;
    private javax.swing.JTextField nombreUsuario;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}

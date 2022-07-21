/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.tipodeduccionJpaController;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.MyJasperViewer;
import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.tipodeduccion;
import com.mycompany.sistemabarberia.usuarios;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Jonathan Laux
 */
public class tipoDeduccion extends javax.swing.JFrame {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");
    
    private tipodeduccionJpaController tipodeduccionDAO = new tipodeduccionJpaController(emf);
    private empleadoJpaController empleadosDAO = new empleadoJpaController(emf);
    private Validaciones validar = new Validaciones();
    private ImageIcon imagen;
    private Icon icono;
    private usuarios usuarios = new usuarios(); 
    private UsuarioSingleton singleton = UsuarioSingleton.getUsuario(usuarios);
    Border redBorder = BorderFactory.createLineBorder(Color.RED, 1);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 1);
    Border defaultBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true);


    /**
     * Creates new form nuevoTipoDescuento
     */
    public tipoDeduccion() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
        setIconImage(icon);
        this.insertarImagen(this.logo,"/Imagenes/logoBarberia.png");    
        Reiniciar();  
    }
    
    public void Reiniciar()
    {
        List<tipodeduccion> tipodeduccionEnBd = tipodeduccionDAO.findtipodeduccionEntities();
        if (tipodeduccionEnBd.isEmpty())
        {
            idDeduccion.setText("  ID de tipo deducción: 1");
        }else
        {
            idDeduccion.setText("  ID de tipo deducción: " + Integer.toString(tipodeduccionEnBd.get(tipodeduccionEnBd.size()-1).getIdtipodeduccion()+1));
        } 
        
        nombreDeduccion.setBorder(defaultBorder);
        nombreDeduccion.setText("Nuevo Tipo Deduccion");
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
        idDeduccion = new javax.swing.JTextField();
        formatoInvalido = new javax.swing.JLabel();
        nombreDeduccion = new javax.swing.JTextField();
        salir = new javax.swing.JLabel();
        imprimirReporteTipoDeduccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setPreferredSize(new java.awt.Dimension(487, 538));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("TIPO DE DEDUCCION");

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

        idDeduccion.setEditable(false);
        idDeduccion.setBackground(new java.awt.Color(30, 33, 34));
        idDeduccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idDeduccion.setForeground(new java.awt.Color(255, 255, 255));
        idDeduccion.setText("ID de tipo de deduccion");
        idDeduccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        idDeduccion.setSelectionColor(new java.awt.Color(55, 53, 53));
        idDeduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idDeduccionActionPerformed(evt);
            }
        });

        formatoInvalido.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido.setText("Formato no valido.");

        nombreDeduccion.setBackground(new java.awt.Color(30, 33, 34));
        nombreDeduccion.setDocument(new JTextFieldLimit(25));
        nombreDeduccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreDeduccion.setForeground(new java.awt.Color(255, 255, 255));
        nombreDeduccion.setText("  Nombre del Nuevo Tipo de Deduccion");
        nombreDeduccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nombreDeduccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreDeduccionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreDeduccionFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombreDeduccion, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(formatoInvalido)
                    .addComponent(idDeduccion))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(idDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(formatoInvalido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
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

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x.png"))); // NOI18N
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });

        imprimirReporteTipoDeduccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/printIcon.png"))); // NOI18N
        imprimirReporteTipoDeduccion.setBorderPainted(false);
        imprimirReporteTipoDeduccion.setContentAreaFilled(false);
        imprimirReporteTipoDeduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirReporteTipoDeduccionActionPerformed(evt);
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
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tituloPantalla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(salir))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imprimirReporteTipoDeduccion)
                .addGap(21, 21, 21)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tituloPantalla)))
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(imprimirReporteTipoDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
       try{
       List<tipodeduccion> tipodeduccionEnBd = tipodeduccionDAO.findtipodeduccionEntities();
        tipodeduccion tipoDeduccion = new tipodeduccion();
        tipoDeduccion.setNombre(nombreDeduccion.getText());
        tipoDeduccion.setActivo(true);
        
         if(nombreDeduccion.getText().equals("")||nombreDeduccion.getText().equals("Nuevo Tipo Deduccion"))
        {
            JOptionPane.showMessageDialog(this,"Debes de ingresar un nombre para el tipo de deducción.","Campo sin datos",JOptionPane.ERROR_MESSAGE);
            nombreDeduccion.setBorder(redBorder);
            return;
        }
       
        for(int i=0; i < tipodeduccionEnBd.size();i++)
        {
            if(tipoDeduccion.getNombre().equalsIgnoreCase(tipodeduccionEnBd.get(i).getNombre()))
            {
                Border border = BorderFactory.createLineBorder(Color.RED, 1);
                nombreDeduccion.setBorder(border);
                formatoInvalido.setVisible(true);
                formatoInvalido.setText("Ese tipo de deducción ya existe.");
                return;
            }
        }
        if(validarCampos()){
            try {
            tipodeduccionDAO.create(tipoDeduccion);
            JOptionPane.showMessageDialog(null,"Operación Exitosa");
                    Reiniciar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se pudo guardar, excepción: " + ex.getMessage());
        }
        }else{JOptionPane.showMessageDialog(null, "Por favor, corrige los campos en rojo.","Datos inválidos",JOptionPane.ERROR_MESSAGE);}
       }catch(Exception ex){
           log(ex);
       }
    }//GEN-LAST:event_botonAceptarActionPerformed

    
    
    private void idDeduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idDeduccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idDeduccionActionPerformed

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        // TODO add your handling code here:
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaDeducciones().setVisible(true);
            }
        });
        emf.close();
        this.setVisible(false);
        this.dispose(); 
        tipodeduccionDAO.close();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_salirMouseClicked

    private void nombreDeduccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreDeduccionFocusGained
        // TODO add your handling code here:
        nombreDeduccion.selectAll();
    }//GEN-LAST:event_nombreDeduccionFocusGained

    private void nombreDeduccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreDeduccionFocusLost
        // TODO add your handling code here:
        try{
        validarCampos();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_nombreDeduccionFocusLost

    private void imprimirReporteTipoDeduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirReporteTipoDeduccionActionPerformed
        // TODO add your handling code here:
        try{
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            log(e);
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mqw9x0qo2x?zeroDateTimeBehavior=convertToNull","root","");
            conn.setAutoCommit(false);
        }
        catch (SQLException e) {
            log(e);
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        empleado empleadoActual = empleadosDAO.findempleado(singleton.getCuenta().getIDEmpleado());
        HashMap logo = new HashMap();
        logo.put("logo",getClass().getResourceAsStream("/Imagenes/logoBarberia.jpeg"));
        logo.put("usuario",empleadoActual.getNomEmpleado() + " " + empleadoActual.getApeEmpleado());

        try {
            JasperReport reporte = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reportes/reporteTipoDeduccion.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(
                reporte,
                logo,
                conn);

            MyJasperViewer view = new MyJasperViewer(print,false);
            view.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
            view.setTitle("Reporte de Tipos de Pago");
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(pantallaProductos.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_imprimirReporteTipoDeduccionActionPerformed

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
            java.util.logging.Logger.getLogger(tipoDeduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tipoDeduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tipoDeduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tipoDeduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tipoDeduccion().setVisible(true);
            }
        });
        
        
    }
    private boolean validarCampos()
    {
        if(nombreDeduccion.getText().equals(""))
        {
            nombreDeduccion.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Debes ingresar un dato.");
            return false;
        }
        if(nombreDeduccion.getText().matches("^.*\\d+.*$"))
        {
            nombreDeduccion.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Solo se permite texto en este campo.");
            return false;
        }
        if(!nombreDeduccion.getText().matches("^[A-Z]{1}[\\w\\s]+$"))
        {
            nombreDeduccion.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("El tipo de documento debe iniciar con mayuscula.");
            return false;
        }
         if(validar.validacionLetrasRepetidas(nombreDeduccion.getText()))
        {
            nombreDeduccion.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("No puedes repetir tantas letras.");
            return false;
        }
        if(!validar.validacionCadenaPalabras(nombreDeduccion.getText()))
        {
            nombreDeduccion.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("Esa no es una palabra válida.");
            return false;
        }
        if(!validar.validacionCantidadMinima(nombreDeduccion.getText(), 3))
        {
            nombreDeduccion.setBorder(redBorder);
            formatoInvalido.setVisible(true);
            formatoInvalido.setText("El tipo de deducción debe ser de mínimo 3 letras.");
            return false;
        }
        nombreDeduccion.setBorder(greenBorder);
        formatoInvalido.setText("");
        return true;
        
    }
    
    private void insertarImagen(JLabel lbl,String ruta)
    {
        this.imagen = new ImageIcon(getClass().getResource(ruta));
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        lbl.getWidth(), 
                        lbl.getHeight(),
                        Image.SCALE_DEFAULT)
        );
        lbl.setIcon(this.icono);
        this.repaint();
    }
    
    private void log(Exception ex){
        FileHandler fh;                              
            java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Log");  
            try {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                String ts = new SimpleDateFormat("dd MMMM yyyy HH.mm.ss").format(timestamp);
                fh = new FileHandler("../logs/"+ ts + " " + this.getClass().getName()+".txt" );
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
                logger.info(ex.getClass().toString() + " : " +ex.getMessage());
            } catch (SecurityException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JLabel formatoInvalido;
    private javax.swing.JTextField idDeduccion;
    private javax.swing.JButton imprimirReporteTipoDeduccion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField nombreDeduccion;
    private javax.swing.JLabel salir;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

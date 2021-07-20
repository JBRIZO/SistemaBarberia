/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.salariohistoricoempleadosJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.salariohistoricoempleados;
import java.awt.Color;
import java.awt.Image;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
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
public class nuevoSalario extends javax.swing.JFrame {
    
    private Validaciones validar = new Validaciones();
    private empleadoJpaController empleadoDAO = new empleadoJpaController();
    private List<empleado> empleadosBD = empleadoDAO.findempleadoEntities();
    private salariohistoricoempleadosJpaController salarioDAO = new salariohistoricoempleadosJpaController();
    private List<salariohistoricoempleados> salariosBD = salarioDAO.findsalariohistoricoempleadosEntities();
    private ImageIcon imagen;
    private Icon icono;
    private java.util.Date dt = new java.util.Date();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    String currentTime = sdf.format(dt);
    Border redBorder = BorderFactory.createLineBorder(Color.RED,1);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN,1);
    Border defaultBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true);

    /**
     * Creates new form nuevoTipoDescuento
     */
    public nuevoSalario() {
        initComponents();
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
         this.insertarImagen(this.salir,"src/main/resources/Imagenes/x.png");
        Reiniciar();   
        for(int i = 0; i < empleadosBD.size(); i++)
        {
            if(empleadosBD.get(i).isActivo())
            {
                cbEmpleados.addItem(empleadosBD.get(i).toString());
            }
        }
    }
    
    public void Reiniciar()
    {
        fechaInicio.setText("Fecha Inicial");
        salario.setText("Salario");
        fechaInicio.setBorder(defaultBorder);
        salario.setBorder(defaultBorder);
        formatoInvalido1.setText(" ");
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
        salario = new javax.swing.JTextField();
        fechaInicio = new javax.swing.JTextField();
        cbEmpleados = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        formatoInvalido3 = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("NUEVO SALARIO");

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

        formatoInvalido1.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido1.setText("Formato no valido.");

        salario.setBackground(new java.awt.Color(30, 33, 34));
        salario.setDocument(new JTextFieldLimit(8));
        salario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salario.setForeground(new java.awt.Color(255, 255, 255));
        salario.setText(" Salario");
        salario.setToolTipText("Ingrese un precio de servicio válido.");
        salario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        salario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                salarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                salarioFocusLost(evt);
            }
        });
        salario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salarioActionPerformed(evt);
            }
        });
        salario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salarioKeyTyped(evt);
            }
        });

        fechaInicio.setBackground(new java.awt.Color(30, 33, 34));
        fechaInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        fechaInicio.setText(" Fecha Inicio");
        fechaInicio.setToolTipText("Ingrese un nombre de servicio valido.");
        fechaInicio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        fechaInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fechaInicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fechaInicioFocusLost(evt);
            }
        });
        fechaInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaInicioMouseClicked(evt);
            }
        });
        fechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaInicioActionPerformed(evt);
            }
        });
        fechaInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaInicioKeyTyped(evt);
            }
        });

        cbEmpleados.setBackground(new java.awt.Color(30, 33, 34));
        cbEmpleados.setPreferredSize(new java.awt.Dimension(270, 42));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Salario Num: ");

        formatoInvalido3.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido3.setText("Formato no valido.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formatoInvalido3)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fechaInicio)
                        .addComponent(salario)
                        .addComponent(formatoInvalido1)
                        .addComponent(cbEmpleados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formatoInvalido1)
                .addGap(18, 18, 18)
                .addComponent(salario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formatoInvalido3)
                .addGap(121, 121, 121))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
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
                .addGap(853, 853, 853)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(salir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(tituloPantalla))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(tituloPantalla))
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(175, 175, 175))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, Short.MAX_VALUE)
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
        
        List<salariohistoricoempleados> salariosBD = salarioDAO.findsalariohistoricoempleadosEntities();
        List<salariohistoricoempleados> salariosAnteriores = new ArrayList<salariohistoricoempleados>();
        for(int i = 0; i < salariosBD.size();i++)
        {
            if(salariosBD.get(i).getIDEmpleado() == Character.getNumericValue(cbEmpleados.getSelectedItem().toString().charAt(0)))
            {
                salariosAnteriores.add(salariosBD.get(i));
            }
        }
        java.util.Date startDate;
        String fechaIni = "00-00-0000";
        try {
        startDate = sdf.parse(convertirFecha(fechaInicio.getText()));  
        fechaIni = sdf.format(startDate);
    } catch (ParseException ex) {
       ex.printStackTrace();
    }
        //anadir salario
        salariohistoricoempleados nuevoSalario = new salariohistoricoempleados();
        nuevoSalario.setFechaInicial(Date.valueOf(fechaIni));
        nuevoSalario.setFechaFinal(Date.valueOf(fechaIni));
        nuevoSalario.setIDEmpleado(Character.getNumericValue(cbEmpleados.getSelectedItem().toString().charAt(0)));
        nuevoSalario.setSalario(Double.parseDouble(salario.getText()));
        nuevoSalario.setActivo(true);
        
        salariohistoricoempleados salarioAnterior = new salariohistoricoempleados();
        salarioAnterior.setIdsalario(salariosAnteriores.get(salariosAnteriores.size()-1).getIdsalario());
        salarioAnterior.setFechaInicial(salariosAnteriores.get(salariosAnteriores.size()-1).getFechaInicial());
        salarioAnterior.setFechaFinal(Date.valueOf(fechaIni));
        salarioAnterior.setIDEmpleado(salariosAnteriores.get(salariosAnteriores.size()-1).getIDEmpleado());
        salarioAnterior.setSalario(salariosAnteriores.get(salariosAnteriores.size()-1).getSalario());
        salarioAnterior.setActivo(false);
        
        if(validacionNumerica() && validarFecha(fechaInicio,formatoInvalido1) ){
            try {
            salarioDAO.create(nuevoSalario); 
            salarioDAO.edit(salarioAnterior);
            JOptionPane.showMessageDialog(null,"Operación Exitosa.");
                    Reiniciar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se pudo guardar el servicio, excepción: " + ex.getMessage());
        }
        }else{JOptionPane.showMessageDialog(null, "Por favor, corrige los campos en rojo.","Datos inválidos",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_botonAceptarActionPerformed

    
    //a;adir validaciones botonaceptar
    private void salarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salarioFocusLost
       
        if(salario.getText().equals(""))
        {
            salario.setText("Salario");
        }else
        {
            validacionNumerica(); 
        }
    }//GEN-LAST:event_salarioFocusLost

    
    
    private void salarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salarioActionPerformed

    private void salarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salarioKeyTyped
        // TODO add your handling code here
    }//GEN-LAST:event_salarioKeyTyped

    private void salarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salarioFocusGained
        // TODO add your handling code here:
        salario.setText("");
    }//GEN-LAST:event_salarioFocusGained

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaSalarios().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        empleadoDAO.close();
        salarioDAO.close();        
    }//GEN-LAST:event_salirMouseClicked

    private void fechaInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaInicioFocusGained
        // TODO add your handling code here:
        fechaInicio.setText("");
    }//GEN-LAST:event_fechaInicioFocusGained

    private void fechaInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaInicioFocusLost
        // TODO add your handling code here:
        if(fechaInicio.getText().equals(""))
        {
            fechaInicio.setDocument(new JTextFieldLimit(12));
            fechaInicio.setText("Fecha Inicio");
        }else{validarFecha(fechaInicio,formatoInvalido1);}
        
    }//GEN-LAST:event_fechaInicioFocusLost

    private void fechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioActionPerformed

    private void fechaInicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaInicioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioKeyTyped

    private void fechaInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaInicioMouseClicked
        // TODO add your handling code here:
        fechaInicio.setDocument(new JTextFieldLimit (10));
        
    }//GEN-LAST:event_fechaInicioMouseClicked

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
            java.util.logging.Logger.getLogger(nuevoSalario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevoSalario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevoSalario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevoSalario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoSalario().setVisible(true);
            }
        });
        
        
    }
    
    
    private boolean validacionNumerica()
    {
        if (!validar.validacionCampoNumerico(salario.getText()) )
        {
            salario.setBorder(redBorder);
            formatoInvalido3.setVisible(true);
            formatoInvalido3.setText("Solo se permiten números.");
            return false;
        }
        if(Double.parseDouble(salario.getText()) <= 0  )
        {
            salario.setBorder(redBorder);
            formatoInvalido3.setVisible(true);
            formatoInvalido3.setText("El salario debe ser mayor a 0");
            return false;
        }
         if(validar.validacionDecimal(salario.getText()))
        {
            salario.setBorder(greenBorder);
            formatoInvalido3.setVisible(true);
            formatoInvalido3.setText("Formato válido");
            return true;
        }else
        {
            salario.setBorder(redBorder);
            formatoInvalido3.setVisible(true);
            formatoInvalido3.setText("El formato debe de ser 0000.00");
            return false;
        }
        
    }
    
    private boolean validarFecha(javax.swing.JTextField fecha, JLabel label)
    {
        if(!validar.validacionCampoNumerico(fecha.getText()))
        {
            fecha.setBorder(redBorder);
            label.setVisible(true);
            label.setText("Solo puedes ingresar fechas en este campo.");
            return false;
        }
        if(!validar.validacionFormatoFecha(fecha.getText()) )
        {
            fecha.setBorder(redBorder);
            label.setVisible(true);
            label.setText("El formato de fecha es: dd-mm-aaaa");
            return false;
        }
        if(!validar.validacionFecha(fecha.getText()))
            {
            fecha.setBorder(redBorder);
            label.setVisible(true);
            label.setText("La fecha introducida es invalida.");
            return false;
            }else
        {
            fecha.setBorder(greenBorder);
            label.setText("");
            return true;
        }
        
    }
    
    private String convertirFecha(String Fecha)
    {
        String[] palabras  = Fecha.split("/");
       
        return palabras[2] + "-" + palabras[1] + "-" + palabras[0];
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
    private javax.swing.JTextField fechaInicio;
    private javax.swing.JLabel formatoInvalido1;
    private javax.swing.JLabel formatoInvalido3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField salario;
    private javax.swing.JLabel salir;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

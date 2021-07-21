/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.puestoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.puestohistoricoempleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.salariohistoricoempleadosJpaController;
import com.mycompany.sistemabarberia.JTextFieldLimit;
import com.mycompany.sistemabarberia.Validaciones;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.puesto;
import com.mycompany.sistemabarberia.puestohistoricoempleado;
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
public class nuevoPuesto extends javax.swing.JFrame {
    
    private Validaciones validar = new Validaciones();
    private empleadoJpaController empleadoDAO = new empleadoJpaController();
    private List<empleado> empleadosBD = empleadoDAO.findempleadoEntities();
    private puestoJpaController tiposPuestoDAO = new puestoJpaController();
    private List<puesto> tiposPuestoBD = tiposPuestoDAO.findpuestoEntities();
    private puestohistoricoempleadoJpaController puestoDao = new puestohistoricoempleadoJpaController();
    private List<puestohistoricoempleado> puestosBD = puestoDao.findpuestohistoricoempleadoEntities();
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
    public nuevoPuesto() {
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
        for(int i = 0; i < tiposPuestoBD.size(); i++)
        {
            if(tiposPuestoBD.get(i).isActivo())
            {
                cbTipoPuesto.addItem(tiposPuestoBD.get(i).toString());
            }
        }
    }
    
    public void Reiniciar()
    {
        fechaInicio.setText("Fecha Inicial");
        fechaInicio.setBorder(defaultBorder);
        formatoInvalido1.setText(" ");
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
        fechaInicio = new javax.swing.JTextField();
        cbEmpleados = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbTipoPuesto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

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

        jLabel1.setText("jLabel1");

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        formatoInvalido1.setForeground(new java.awt.Color(255, 255, 255));
        formatoInvalido1.setText("Formato no valido.");

        fechaInicio.setBackground(new java.awt.Color(30, 33, 34));
        fechaInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        fechaInicio.setText("Fecha Inicio");
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
        jLabel3.setText("Empleado:");

        cbTipoPuesto.setBackground(new java.awt.Color(30, 33, 34));
        cbTipoPuesto.setPreferredSize(new java.awt.Dimension(270, 42));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo de Puesto:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cbTipoPuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fechaInicio)
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
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipoPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formatoInvalido1)
                .addGap(143, 143, 143))
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
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
                .addGap(103, 103, 103)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))))
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
        
        List<puestohistoricoempleado> puestosBD = puestoDao.findpuestohistoricoempleadoEntities();
        List<puestohistoricoempleado> puestosAnteriores = new ArrayList<puestohistoricoempleado>();
        for(int i = 0; i < puestosBD.size();i++)
        {
            if(puestosBD.get(i).getIDEmpleado() == Character.getNumericValue(cbEmpleados.getSelectedItem().toString().charAt(0)))
            {
                puestosAnteriores.add(puestosBD.get(i));
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
        //anadir puesto
        puestohistoricoempleado nuevoPuesto = new puestohistoricoempleado();
        nuevoPuesto.setFechaInicial(Date.valueOf(fechaIni));
        nuevoPuesto.setFechaFinal(Date.valueOf(fechaIni));
        nuevoPuesto.setIDEmpleado(Character.getNumericValue(cbEmpleados.getSelectedItem().toString().charAt(0)));
        nuevoPuesto.setIDPuesto(Character.getNumericValue(cbTipoPuesto.getSelectedItem().toString().charAt(0)));
        nuevoPuesto.setActivo(true);
        
        puestohistoricoempleado puestoAnterior = new puestohistoricoempleado();
        puestoAnterior.setNumpuesto(puestosAnteriores.get(puestosAnteriores.size()-1).getNumpuesto());
        puestoAnterior.setFechaInicial(puestosAnteriores.get(puestosAnteriores.size()-1).getFechaInicial());
        puestoAnterior.setFechaFinal(Date.valueOf(fechaIni));
        puestoAnterior.setIDEmpleado(puestosAnteriores.get(puestosAnteriores.size()-1).getIDEmpleado());
        puestoAnterior.setIDPuesto(puestosAnteriores.get(puestosAnteriores.size()-1).getIDPuesto());
        puestoAnterior.setActivo(false);
        
        if(nuevoPuesto.getIDPuesto() == puestoAnterior.getIDPuesto())
        {
            JOptionPane.showMessageDialog(null, "El nuevo puesto para este empleado no puede ser igual que el anterior.","Puesto Inválido",JOptionPane.ERROR_MESSAGE);
        }
        
        if(validarFecha(fechaInicio,formatoInvalido1) ){
            try {
            puestoDao.create(nuevoPuesto); 
            puestoDao.edit(puestoAnterior);
            JOptionPane.showMessageDialog(null,"Operación Exitosa.");
                    Reiniciar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se pudo guardar el servicio, excepción: " + ex.getMessage());
        }
        }else{JOptionPane.showMessageDialog(null, "Por favor, corrige los campos en rojo.","Datos inválidos",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_botonAceptarActionPerformed

    
    
    
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
        puestoDao.close();        
    }//GEN-LAST:event_salirMouseClicked

    private void fechaInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaInicioFocusGained
        // TODO add your handling code here:
        if(fechaInicio.getText().equals("Fecha Inicio"))
        {
            fechaInicio.setDocument(new JTextFieldLimit(10));
            fechaInicio.setText("");
        }
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
    private javax.swing.JComboBox<String> cbTipoPuesto;
    private javax.swing.JTextField fechaInicio;
    private javax.swing.JLabel formatoInvalido1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel salir;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

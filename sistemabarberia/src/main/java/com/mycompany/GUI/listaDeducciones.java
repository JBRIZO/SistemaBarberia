/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.deduccionesempleadomensualJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.tipodeduccionJpaController;
import com.mycompany.sistemabarberia.bonosempleadomensual;
import com.mycompany.sistemabarberia.deduccionesempleadomensual;
import com.mycompany.sistemabarberia.tipodeduccion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author flore
 */
public class listaDeducciones extends javax.swing.JFrame {
    
    private String periodoActual;
    
    private deduccionesempleadomensualJpaController deduccionesDAO = new deduccionesempleadomensualJpaController();
    private List<deduccionesempleadomensual> deduccionesBD = deduccionesDAO.finddeduccionesempleadomensualEntities();
    private tipodeduccionJpaController tipodeduccionDAO = new tipodeduccionJpaController();
    private List<tipodeduccion> tipodeduccionBD = tipodeduccionDAO.findtipodeduccionEntities();
    private ImageIcon imagen;
    private Icon icono;
    private java.util.Date dt = new java.util.Date();

    /**
     * Creates new form listaDeducciones
     */
    public listaDeducciones() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        cargarPeriodosCb();
        
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dt);
        int anio = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH) + 1;
        periodoActual = mes<10? anio+"0"+mes: Integer.toString(anio)+mes;
         TableColumnModel model = tablaDeducciones.getColumnModel();
        model.removeColumn(model.getColumn(0));
        cargarTablaPeriodo(cbPeriodos.getSelectedItem().toString());

        
    }

    private void cargarPeriodosCb()
    {
        if(deduccionesBD.size() > 0)
        {
          List<String> periodosEnBD = new ArrayList<>();
         periodosEnBD.add(deduccionesBD.get(deduccionesBD.size()-1).getPeriodo());
        for(int i = deduccionesBD.size()-1 ; i > 0; i--)
        {
            if(!deduccionesBD.get(i).getPeriodo().equals(deduccionesBD.get(i-1).getPeriodo()))
            {
                periodosEnBD.add(deduccionesBD.get(i-1).getPeriodo());
            }
        }
           for(int i = 0; i < periodosEnBD.size() ; i++)
        {
            cbPeriodos.addItem(periodosEnBD.get(i));
        } 
        }
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        botonCancelar = new javax.swing.JButton();
        jScrollpane = new javax.swing.JScrollPane();
        tablaDeducciones = new javax.swing.JTable();
        nuevaDeduccion = new javax.swing.JButton();
        nuevoTipo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbPeriodos = new javax.swing.JComboBox<>();
        limpiar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        botonCancelar.setBackground(new java.awt.Color(189, 158, 76));
        botonCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonCancelar.setText("CANCELAR");
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCancelarMouseClicked(evt);
            }
        });

        tablaDeducciones.setBackground(new java.awt.Color(30, 33, 34));
        tablaDeducciones.setForeground(new java.awt.Color(255, 255, 255));
        tablaDeducciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID deduccion", "ID Empleado", "Nombre Empleado", "Tipo ", "Periodo", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDeducciones.getTableHeader().setReorderingAllowed(false);
        tablaDeducciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDeduccionesMouseClicked(evt);
            }
        });
        jScrollpane.setViewportView(tablaDeducciones);
        if (tablaDeducciones.getColumnModel().getColumnCount() > 0) {
            tablaDeducciones.getColumnModel().getColumn(0).setResizable(false);
            tablaDeducciones.getColumnModel().getColumn(1).setResizable(false);
            tablaDeducciones.getColumnModel().getColumn(2).setResizable(false);
            tablaDeducciones.getColumnModel().getColumn(3).setResizable(false);
            tablaDeducciones.getColumnModel().getColumn(4).setResizable(false);
            tablaDeducciones.getColumnModel().getColumn(5).setResizable(false);
        }
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaDeducciones.getColumnCount();i++)
        {
            tablaDeducciones.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaDeducciones.setShowGrid(true);
        tablaDeducciones.setGridColor(Color.BLACK);

        nuevaDeduccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevaDeduccion.png"))); // NOI18N
        nuevaDeduccion.setContentAreaFilled(false);
        nuevaDeduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaDeduccionActionPerformed(evt);
            }
        });

        nuevoTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevoTipo.png"))); // NOI18N
        nuevoTipo.setContentAreaFilled(false);
        nuevoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoTipoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Deducciones por periodo:");

        cbPeriodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPeriodosActionPerformed(evt);
            }
        });

        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        limpiar.setContentAreaFilled(false);
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        eliminar.setContentAreaFilled(false);
        eliminar.setEnabled(false);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevaDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nuevoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCancelar)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbPeriodos))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(eliminar)
                        .addGap(24, 24, 24)))
                .addComponent(jScrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nuevoTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nuevaDeduccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTA DE DEDUCCIONES");
        jLabel1.setMaximumSize(new java.awt.Dimension(269, 32));
        jLabel1.setMinimumSize(new java.awt.Dimension(269, 32));
        jLabel1.setPreferredSize(new java.awt.Dimension(269, 32));

        logo.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    private void cargarTablaPeriodo(String periodo)
    {
        empleadoJpaController empleadoDAO = new empleadoJpaController();
        DefaultTableModel modelo = (DefaultTableModel)tablaDeducciones.getModel();
        modelo.setRowCount(0);
        tablaDeducciones.setModel(modelo);
        
        EntityManager em = deduccionesDAO.getEntityManager();
        String hql = "FROM deduccionesempleadomensual E WHERE E.Periodo = :Periodo";
        Query query = em.createQuery(hql);
        query.setParameter("Periodo",periodo);
        List<deduccionesempleadomensual> results = (List<deduccionesempleadomensual>)query.getResultList();
        em.close();
        
        results.forEach((deduccionActual) -> {
            modelo.addRow(
                    new Object[]{
                        deduccionActual.getNumdeduccion(),
                        deduccionActual.getIDEmpleado(),
                        empleadoDAO.findempleado(deduccionActual.getIDEmpleado()).getNomEmpleado(),
                        tipodeduccionDAO.findtipodeduccion(deduccionActual.getIDTipoDeduccion()).getNombre(),
                        deduccionActual.getPeriodo(),
                        deduccionActual.getValor()
                    }
            );
        });
        eliminar.setEnabled(false);
        empleadoDAO.close();
    }
    
    private void botonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        deduccionesDAO.close();
        tipodeduccionDAO.close();
    }//GEN-LAST:event_botonCancelarMouseClicked

    private void nuevaDeduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaDeduccionActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevaDeduccion().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        deduccionesDAO.close();
        tipodeduccionDAO.close();
    }//GEN-LAST:event_nuevaDeduccionActionPerformed

    private void nuevoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoTipoActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tipoDeduccion().setVisible(true);
            }
        });
        deduccionesDAO.close();
        tipodeduccionDAO.close();
        this.dispose();
    }//GEN-LAST:event_nuevoTipoActionPerformed

    private void cbPeriodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPeriodosActionPerformed
        // TODO add your handling code here:
        cargarTablaPeriodo(cbPeriodos.getSelectedItem().toString());
    }//GEN-LAST:event_cbPeriodosActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel modelo = (DefaultTableModel) tablaDeducciones.getModel();
        if(!cbPeriodos.getSelectedItem().toString().equals(periodoActual))
        {
           JOptionPane.showMessageDialog(null,"Esas deducciones pertenecen a otro periodo, solo puedes borrar las deducciones del periodo actual ("+periodoActual+").","Deducciones ya aplicadas.",JOptionPane.ERROR_MESSAGE);
           return;
        }
        int confirmar = JOptionPane.showConfirmDialog(null,"¿Estás seguro que deseas eliminar la deducciones del periodo "+periodoActual+"?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        
        if(confirmar == 0)
        {
        EntityManager em = deduccionesDAO.getEntityManager();
        String hql = "FROM deduccionesempleadomensual E WHERE E.Periodo = :Periodo";
        Query query = em.createQuery(hql);
        query.setParameter("Periodo",cbPeriodos.getSelectedItem().toString());
        List<deduccionesempleadomensual> results = (List<deduccionesempleadomensual>)query.getResultList();
        em.close();
        results.forEach((deduccion) -> {
            try {
                deduccionesDAO.destroy(deduccion.getNumdeduccion());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(listaDeducciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        modelo.setRowCount(0);
        }
    }//GEN-LAST:event_limpiarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) tablaDeducciones.getModel();        
        int confirmacion = JOptionPane.showConfirmDialog(null,"¿Seguro que deseas eliminar esta deducción?","Confirmación",JOptionPane.YES_NO_OPTION);
        if(confirmacion == 0)
            {
                try {
                deduccionesDAO.destroy(Integer.parseInt(modelo.getValueAt(tablaDeducciones.getSelectedRow(),0).toString()));
                JOptionPane.showMessageDialog(null,"Deduccion Eliminada");
                cargarTablaPeriodo(periodoActual);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(listaDeducciones.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void tablaDeduccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDeduccionesMouseClicked
        // TODO add your handling code here:
        if(tablaDeducciones.getSelectedRow() != -1 && cbPeriodos.getSelectedItem().equals(periodoActual))
        {
            eliminar.setEnabled(true);
        }else
        {
            eliminar.setEnabled(false);
        }
    }//GEN-LAST:event_tablaDeduccionesMouseClicked

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
            java.util.logging.Logger.getLogger(listaDeducciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listaDeducciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listaDeducciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listaDeducciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaDeducciones().setVisible(true);
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
    private javax.swing.JButton botonCancelar;
    private javax.swing.JComboBox<String> cbPeriodos;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollpane;
    private javax.swing.JButton limpiar;
    private javax.swing.JLabel logo;
    private javax.swing.JButton nuevaDeduccion;
    private javax.swing.JButton nuevoTipo;
    private javax.swing.JTable tablaDeducciones;
    // End of variables declaration//GEN-END:variables
}

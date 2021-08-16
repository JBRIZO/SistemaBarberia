/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.bonosempleadomensualJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.tiposbonoJpaController;
import com.mycompany.sistemabarberia.bonosempleadomensual;
import com.mycompany.sistemabarberia.deduccionesempleadomensual;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.tiposbono;
import java.awt.Color;
import java.awt.Image;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Kesil
 */
public class Bono extends javax.swing.JFrame {

    private String periodoActual;
    
    private bonosempleadomensualJpaController bonosDAO = new bonosempleadomensualJpaController();
    private empleadoJpaController empleado = new empleadoJpaController();
    private tiposbonoJpaController tipoBono = new tiposbonoJpaController();
    private ImageIcon imagen;
    private Icon icono;
    
     private java.util.Date dt = new java.util.Date();

    /**
     * Creates new form nuevoTipoDescuento
     */
    public Bono() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.insertarImagen(this.logo, "src/main/resources/Imagenes/logoBarberia.png");
       //periodo actual
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dt);
        int anio = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH) + 1;
        periodoActual = mes<10? anio+"0"+mes: Integer.toString(anio)+mes;
         //ocultar column con numero del bono
        TableColumnModel model = tablaBonos.getColumnModel();
        model.removeColumn(model.getColumn(0));
        
        cargarPeriodosCb();
        cargarTablaPeriodo(cbPeriodos.getSelectedItem().toString());
          if(!periodoActual.equals(ultimoPeriodo()))
        {
            JOptionPane.showMessageDialog(this,"No has otorgado bonos este periodo.");
        }
    }
    
    private String ultimoPeriodo()
    {
        EntityManager em = bonosDAO.getEntityManager();
        Query query = em.createQuery("FROM bonosempleadomensual E where E.numbono = (select max(numbono) from bonosempleadomensual)");
        bonosempleadomensual bono = (bonosempleadomensual)query.getSingleResult();
        em.close();

        return bono.getPeriodo();
    }
    private void cargarPeriodosCb()
    {
        List<bonosempleadomensual> bonosBD = bonosDAO.findbonosempleadomensualEntities();
        
        if(bonosBD.size() > 0)
        {
          List<String> periodosEnBD = new ArrayList<>();
         periodosEnBD.add(bonosBD.get(bonosBD.size()-1).getPeriodo());
        for(int i = bonosBD.size()-1 ; i > 0; i--)
        {
            if(!bonosBD.get(i).getPeriodo().equals(bonosBD.get(i-1).getPeriodo()))
            {
                periodosEnBD.add(bonosBD.get(i-1).getPeriodo());
            }
        }
           for(int i = 0; i < periodosEnBD.size() ; i++)
        {
            cbPeriodos.addItem(periodosEnBD.get(i));
        } 
        }
    }

    List<empleado> empleadoBono = empleado.findempleadoEntities();
    List<tiposbono> bonoTipo = tipoBono.findtiposbonoEntities();
    
      private void cargarTablaPeriodo(String periodo)
    {
        DefaultTableModel modelo = (DefaultTableModel)tablaBonos.getModel();
        modelo.setRowCount(0);
        tablaBonos.setModel(modelo);
        
        EntityManager em = bonosDAO.getEntityManager();
        String hql = "FROM bonosempleadomensual E WHERE E.Periodo = :Periodo";
        Query query = em.createQuery(hql);
        query.setParameter("Periodo",periodo);
        List<bonosempleadomensual> results = (List<bonosempleadomensual>)query.getResultList();
        em.close();
        

        results.forEach((bonoActual) -> {
            modelo.addRow(
                    new Object[]{
                        bonoActual.getNumbono(),
                        bonoActual.getIdEmpleado(),
                        empleado.findempleado(bonoActual.getIdEmpleado()).getNomEmpleado(),
                        tipoBono.findtiposbono(bonoActual.getIDTipoBono()).getNomBono(),
                        bonoActual.getValor(),
                        bonoActual.getPeriodo()
                    }
            );
                });
         eliminar.setEnabled(false);
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
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBonos = new javax.swing.JTable();
        btnNuevoTipo = new javax.swing.JButton();
        btnNuevoBono = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbPeriodos = new javax.swing.JComboBox<>();
        limpiar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("BONOS");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaBonos.setAutoCreateRowSorter(true);
        tablaBonos.setBackground(new java.awt.Color(30, 33, 34));
        tablaBonos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaBonos.setForeground(new java.awt.Color(255, 255, 255));
        tablaBonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num Bono", "ID Empleado", "Niombre Empleado", "Tipo Bono", "Valor", "Periodo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBonos.setGridColor(new java.awt.Color(255, 255, 255));
        tablaBonos.setRowHeight(32);
        tablaBonos.getTableHeader().setReorderingAllowed(false);
        tablaBonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBonosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBonos);
        if (tablaBonos.getColumnModel().getColumnCount() > 0) {
            tablaBonos.getColumnModel().getColumn(0).setResizable(false);
            tablaBonos.getColumnModel().getColumn(1).setResizable(false);
            tablaBonos.getColumnModel().getColumn(2).setResizable(false);
            tablaBonos.getColumnModel().getColumn(3).setResizable(false);
            tablaBonos.getColumnModel().getColumn(4).setResizable(false);
            tablaBonos.getColumnModel().getColumn(5).setResizable(false);
        }
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaBonos.getColumnCount();i++)
        {
            tablaBonos.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaBonos.setShowGrid(true);
        tablaBonos.setGridColor(Color.BLACK);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 287));

        btnNuevoTipo.setBackground(new java.awt.Color(30, 33, 34));
        btnNuevoTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevoTipo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NuevoTipo.png"))); // NOI18N
        btnNuevoTipo.setBorder(null);
        btnNuevoTipo.setContentAreaFilled(false);
        btnNuevoTipo.setRequestFocusEnabled(false);
        btnNuevoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoTipoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));

        btnNuevoBono.setBackground(new java.awt.Color(30, 33, 34));
        btnNuevoBono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevoBono.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoBono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NuevoBono.png"))); // NOI18N
        btnNuevoBono.setBorder(null);
        btnNuevoBono.setContentAreaFilled(false);
        btnNuevoBono.setRequestFocusEnabled(false);
        btnNuevoBono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoBonoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevoBono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        Aceptar.setBackground(new java.awt.Color(189, 158, 76));
        Aceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Aceptar.setText("CANCELAR");
        Aceptar.setRequestFocusEnabled(false);
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        jPanel3.add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 110, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bonos por periodo:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        cbPeriodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPeriodosActionPerformed(evt);
            }
        });
        jPanel3.add(cbPeriodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 130, 35));

        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        limpiar.setContentAreaFilled(false);
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        jPanel3.add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 160, 40));

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        eliminar.setContentAreaFilled(false);
        eliminar.setEnabled(false);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel3.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 30, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280)
                        .addComponent(tituloPantalla))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloPantalla))
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void tablaBonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBonosMouseClicked
        // TODO add your handling code here:
         if(tablaBonos.getSelectedRow() != -1 && cbPeriodos.getSelectedItem().equals(periodoActual))
        {
            eliminar.setEnabled(true);
        }else
        {
            eliminar.setEnabled(false);
        }
    }//GEN-LAST:event_tablaBonosMouseClicked

    private void btnNuevoBonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoBonoActionPerformed
        NuevoBono nv = new NuevoBono();
        nv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNuevoBonoActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        menuGerente menu = new menuGerente();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AceptarActionPerformed

    private void btnNuevoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoTipoActionPerformed
        nuevoTipoBono ntb = new nuevoTipoBono();
        ntb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNuevoTipoActionPerformed

    private void cbPeriodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPeriodosActionPerformed
        // TODO add your handling code here:
        cargarTablaPeriodo(cbPeriodos.getSelectedItem().toString());
    }//GEN-LAST:event_cbPeriodosActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        // TODO add your handling code here:

        DefaultTableModel modelo = (DefaultTableModel) tablaBonos.getModel();
        if(!cbPeriodos.getSelectedItem().toString().equals(periodoActual))
        {
            JOptionPane.showMessageDialog(null,"Esos bonos pertenecen a otro periodo, solo puedes borrar los bonos del periodo actual ("+periodoActual+").","Bonos ya aplicados.",JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirmar = JOptionPane.showConfirmDialog(null,"¿Estás seguro que deseas eliminar todos los bonos del periodo "+periodoActual+"?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION);

        if(confirmar == 0)
        {
            EntityManager em = bonosDAO.getEntityManager();
            String hql = "FROM bonosempleadomensual E WHERE E.Periodo = :Periodo";
            Query query = em.createQuery(hql);
            query.setParameter("Periodo",cbPeriodos.getSelectedItem().toString());
            List<bonosempleadomensual> results = (List<bonosempleadomensual>)query.getResultList();
            em.close();
            results.forEach((bonos) -> {
                try {
                    bonosDAO.destroy(bonos.getNumbono());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(listaDeducciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            modelo.setRowCount(0);
        }
    }//GEN-LAST:event_limpiarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) tablaBonos.getModel();
        int confirmacion = JOptionPane.showConfirmDialog(null,"¿Seguro que deseas eliminar este bono?","Confirmación",JOptionPane.YES_NO_OPTION);
        if(confirmacion == 0)
        {
            try {
                bonosDAO.destroy(Integer.parseInt(modelo.getValueAt(tablaBonos.getSelectedRow(),0).toString()));
                JOptionPane.showMessageDialog(null,"Bono Eliminado.");
                cargarTablaPeriodo(periodoActual);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(listaDeducciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Bono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bono().setVisible(true);
            }
        });

    }

    private void insertarImagen(JLabel lbl, String ruta) {
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

    private void insertarImagen(JButton checkBox, String ruta) {
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        checkBox.getWidth(),
                        checkBox.getHeight(),
                        Image.SCALE_DEFAULT)
        );
        checkBox.setIcon(this.icono);
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton btnNuevoBono;
    private javax.swing.JButton btnNuevoTipo;
    private javax.swing.JComboBox<String> cbPeriodos;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tablaBonos;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

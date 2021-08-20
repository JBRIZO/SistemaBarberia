/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.usuariosJpaController;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.usuarios;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kesil
 */
public class listaUsuarios extends javax.swing.JFrame {
    

    private empleadoJpaController empleadoDAO = new empleadoJpaController();
    private usuariosJpaController usuarioDAO =  new usuariosJpaController();
    private ImageIcon imagen;
    private Icon icono;

    /**
     * Creates new form nuevoTipoDescuento
     */
    public listaUsuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        this.insertarImagen(this.activar,"src/main/resources/Imagenes/desactivar.png");
        cargarTabla();
        for(int i = 0; i < tablaUsuarios.getColumnCount()-2;i++)
        {
            cbParametros.addItem(tablaUsuarios.getColumnName(i));
        }
        modificarUsuario.setEnabled(false);
    }
    
    private void cargarTabla()
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaUsuarios.getModel();
        modelo.setRowCount(0);
        tablaUsuarios.setModel(modelo);
        List<usuarios> usuarios = usuarioDAO.findusuariosEntities();
            for(usuarios usuario : usuarios){
                if(usuario.getActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        usuario.getIdusuario(),
                        empleadoDAO.findempleado(usuario.getIDEmpleado()).getNomEmpleado(),
                        usuario.getNomCuenta(),
                        usuario.getContrasena(),
                        activo
                    }
                );
            } 
    }
    
     private void cargarTablaIdUsuario(int IdUsuario)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaUsuarios.getModel();
        modelo.setRowCount(0);
        tablaUsuarios.setModel(modelo);
        List<usuarios> usuarios = usuarioDAO.findusuariosEntities();
        List<usuarios> usuariosFiltrados = new ArrayList();
        
        for(int i = 0; i < usuarios.size();i++)
        {
            if(usuarios.get(i).getIdusuario() == IdUsuario)
            {
                usuariosFiltrados.add(usuarios.get(i));
            }
        }
        
        if(usuariosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"No se encontraron usuarios con ese Id.","ID inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(usuarios usuario : usuariosFiltrados){
                if(usuario.getActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        usuario.getIdusuario(),
                        empleadoDAO.findempleado(usuario.getIDEmpleado()).getNomEmpleado(),
                        usuario.getNomCuenta(),
                        usuario.getContrasena(),
                        activo
                    }
                );
            } 
    }
     
     private void cargarTablaIDEmpleado(String IdEmpleado)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaUsuarios.getModel();
        modelo.setRowCount(0);
        tablaUsuarios.setModel(modelo);
        List<usuarios> usuarios = usuarioDAO.findusuariosEntities();
        List<usuarios> usuariosFiltrados = new ArrayList();
        
        for(int i = 0; i < usuarios.size();i++)
        {
            if(empleadoDAO.findempleado(usuarios.get(i).getIDEmpleado()).getNomEmpleado().equalsIgnoreCase(IdEmpleado))
            {
                usuariosFiltrados.add(usuarios.get(i));
            }
        }
         if(usuariosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"No se encontraron usarios con ese nombre de empleado.","Empleado inexistente",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(usuarios usuario : usuariosFiltrados){
                if(usuario.getActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        usuario.getIdusuario(),
                        empleadoDAO.findempleado(usuario.getIDEmpleado()).getNomEmpleado(),
                        usuario.getNomCuenta(),
                        usuario.getContrasena(),
                        activo
                    }
                );
            } 
    }
     
     private void cargarTablaUsuario(String nomUsuario)
    {
        String activo = "";
        DefaultTableModel modelo = (DefaultTableModel)tablaUsuarios.getModel();
        modelo.setRowCount(0);
        tablaUsuarios.setModel(modelo);
        List<usuarios> usuarios = usuarioDAO.findusuariosEntities();
        List<usuarios> usuariosFiltrados = new ArrayList();
        
        for(int i = 0; i < usuarios.size();i++)
        {
            if(usuarios.get(i).getNomCuenta().equals(nomUsuario))
            {
                usuariosFiltrados.add(usuarios.get(i));
            }
        }
        
        if(usuariosFiltrados.isEmpty())
        {
        JOptionPane.showMessageDialog(this,"No se un usuario con ese nombre de usuario.","Nombre de usuario inexistente",JOptionPane.ERROR_MESSAGE);
        return;
        }
            for(usuarios usuario : usuariosFiltrados){
                if(usuario.getActivo())
                {
                activo = "Sí";   
                }else
                {
                    activo = "No";
                }
                    modelo.addRow(
                    new Object[]{
                        usuario.getIdusuario(),
                        empleadoDAO.findempleado(usuario.getIDEmpleado()).getNomEmpleado(),
                        usuario.getNomCuenta(),
                        usuario.getContrasena(),
                        activo
                    }
                );
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
        tituloPantalla = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        activar = new javax.swing.JButton();
        nuevoUsuario = new javax.swing.JButton();
        modificarUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbParametros = new javax.swing.JComboBox<>();
        buscarTxt = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        recargar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("USUARIOS");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        tablaUsuarios.setAutoCreateRowSorter(true);
        tablaUsuarios.setBackground(new java.awt.Color(30, 33, 34));
        tablaUsuarios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Usuario", "Empleado", "Usuario", "Contraseña", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuarios.setGridColor(new java.awt.Color(255, 255, 255));
        tablaUsuarios.setRowHeight(32);
        tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaUsuarios.getColumnCount();i++)
        {
            tablaUsuarios.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaUsuarios.setShowGrid(true);
        tablaUsuarios.setGridColor(Color.BLACK);

        activar.setBorderPainted(false);
        activar.setContentAreaFilled(false);
        activar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activarMouseClicked(evt);
            }
        });
        activar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activarActionPerformed(evt);
            }
        });

        nuevoUsuario.setBackground(new java.awt.Color(30, 33, 34));
        nuevoUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nuevoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevoUsuario.png"))); // NOI18N
        nuevoUsuario.setBorder(null);
        nuevoUsuario.setContentAreaFilled(false);
        nuevoUsuario.setRequestFocusEnabled(false);
        nuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoUsuarioActionPerformed(evt);
            }
        });

        modificarUsuario.setBackground(new java.awt.Color(30, 33, 34));
        modificarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modificarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        modificarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificarUsuario.png"))); // NOI18N
        modificarUsuario.setBorder(null);
        modificarUsuario.setContentAreaFilled(false);
        modificarUsuario.setRequestFocusEnabled(false);
        modificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Por:");

        buscarTxt.setBackground(new java.awt.Color(30, 33, 34));
        buscarTxt.setForeground(new java.awt.Color(255, 255, 255));
        buscarTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        buscarTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscarTxtFocusGained(evt);
            }
        });

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        botonBuscar.setBorderPainted(false);
        botonBuscar.setContentAreaFilled(false);
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        recargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recargar.png"))); // NOI18N
        recargar.setContentAreaFilled(false);
        recargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recargar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificarUsuario))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscarTxt)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(recargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nuevoUsuario)
                    .addComponent(modificarUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        botonRegresar.setBackground(new java.awt.Color(189, 158, 76));
        botonRegresar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonRegresar.setText("REGRESAR");
        botonRegresar.setRequestFocusEnabled(false);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(335, 335, 335)
                .addComponent(tituloPantalla)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tituloPantalla)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
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

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        // TODO add your handling code here:
        if(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),4).equals("Sí"))
        {
            this.insertarImagen(this.activar,"src/main/resources/Imagenes/desactivar.png");
            modificarUsuario.setEnabled(true);
        }else
        {
            this.insertarImagen(this.activar,"src/main/resources/Imagenes/activar.png");
            modificarUsuario.setEnabled(false);
        }
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void activarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_activarMouseClicked

    private void nuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoUsuarioActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoUsuario().setVisible(true);
            }
        });
        this.setVisible(false);
        this.dispose(); 
        usuarioDAO.close();
    }//GEN-LAST:event_nuevoUsuarioActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void modificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarUsuarioActionPerformed
        // TODO add your handling code here:
        if(tablaUsuarios.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(this,"Debes seleccionar un usuario para poder modificarlo.","Selecciona un empleado",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
    }//GEN-LAST:event_modificarUsuarioActionPerformed

    private void buscarTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarTxtFocusGained
        // TODO add your handling code here:
        buscarTxt.selectAll();
    }//GEN-LAST:event_buscarTxtFocusGained

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
         if(buscarTxt.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Debes ingresar un " + cbParametros.getSelectedItem().toString() + ".","Campo vacío",JOptionPane.ERROR_MESSAGE);
            return;
        }
        switch(cbParametros.getSelectedItem().toString())
        {
            case "ID Usuario":
                try{
                    cargarTablaIdUsuario(Integer.parseInt(buscarTxt.getText()));
                }catch(NumberFormatException Ex)
                {
                    JOptionPane.showMessageDialog(this,"El id debe ser un número entero.","ID inválido",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            return;
            case "Empleado":
            cargarTablaIDEmpleado(buscarTxt.getText()); 
            return;
            case "Usuario":
            cargarTablaUsuario(buscarTxt.getText());
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void recargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarActionPerformed
        // TODO add your handling code here:
        cargarTabla();
        buscarTxt.setText("");
        modificarUsuario.setEnabled(false);
    }//GEN-LAST:event_recargarActionPerformed

    private void activarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarActionPerformed
        // TODO add your handling code here:
        //Si el empleado esta desactivado no puede activarse su usuario.
        if(tablaUsuarios.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(this,"Debes seleccionar un usuario para desactivarlo","Selecciona un usuario",JOptionPane.ERROR_MESSAGE);
            return;
        }
        empleadoJpaController empleadoDAO = new empleadoJpaController();
        
        usuarios modificar = new usuarios();
        List<usuarios> usuarios = usuarioDAO.findusuariosEntities();
        for(int i=0 ; i<usuarios.size();i++)
        {
            if(Integer.parseInt(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),0).toString()) == usuarios.get(i).getIdusuario())
            {
                modificar = usuarios.get(i);
            }
        }
        
        empleado empleado = empleadoDAO.findempleado(modificar.getIDEmpleado());
        
        if(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),4).equals("Sí"))
        {
           modificar.setActivo(false);
           this.insertarImagen(this.activar,"src/main/resources/Imagenes/activar.png");
           try
           {
               usuarioDAO.edit(modificar);
           }catch(Exception Ex)
           {}  
        }else
         {
             if(!empleado.isActivo())
             {
                 JOptionPane.showMessageDialog(null,"El empleado propietario de este usuario ha sido desactivado, \n"
                         + "debes activarlo para poder activar este usuario.","Empleado Desactivado",JOptionPane.ERROR_MESSAGE);
                 return;
             }
            modificar.setIntentos(0);
            modificar.setActivo(true);
            this.insertarImagen(this.activar,"src/main/resources/Imagenes/desactivar.png");  
            try
           {
               usuarioDAO.edit(modificar);
           }catch(Exception Ex)
           {}  
        }
        cargarTabla();
    }//GEN-LAST:event_activarActionPerformed

    
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
            java.util.logging.Logger.getLogger(listaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaUsuarios().setVisible(true);
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
    private void insertarImagen(JButton checkBox,String ruta)
    {
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
    private javax.swing.JButton activar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JComboBox<String> cbParametros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton modificarUsuario;
    private javax.swing.JButton nuevoUsuario;
    private javax.swing.JButton recargar;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.permisosJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.permisosusuarioJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.usuariosJpaController;
import com.mycompany.sistemabarberia.UsuarioSingleton;
import com.mycompany.sistemabarberia.permisos;
import com.mycompany.sistemabarberia.permisosusuario;
import com.mycompany.sistemabarberia.usuarios;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
public class PermisosUsuario extends javax.swing.JFrame {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("servidorbd");

    private usuariosJpaController usuarioDAO =  new usuariosJpaController(emf);
    private permisosJpaController permisosDAO = new permisosJpaController(emf);
    private permisosusuarioJpaController permisosUsDAO = new permisosusuarioJpaController(emf);
    private ImageIcon imagen;
    private Icon icono;
    private usuarios usuarios = new usuarios(); 
    private UsuarioSingleton singleton = UsuarioSingleton.getUsuario(usuarios);

    /**
     * Creates new form nuevoTipoDescuento
     */
    public PermisosUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logoBarberia.jpeg")).getImage();
        setIconImage(icon);
        this.insertarImagen(this.logo,"/Imagenes/logoBarberia.png");
        cargarTabla();
        cargarCBPantallas();
        cbPantallas.setEnabled(false);
        desactivarActivarBotones();
    }
    
    private void cargarCBPantallas(){
        List<permisos> permisosList = permisosDAO.findpermisosEntities();
        for(int i = 0 ; i < permisosList.size(); i++)
        {
            cbPantallas.addItem(permisosList.get(i).toString());
        }
    }
    
    private void cargarTabla()
    {
        DefaultTableModel modelo = (DefaultTableModel)tablaUsuarios.getModel();
        modelo.setRowCount(0);
        tablaUsuarios.setModel(modelo);
        List<usuarios> usuarios = usuarioDAO.findusuariosEntities();
            for(usuarios usuario : usuarios){
                if(!usuario.getActivo())
                {
                    continue; 
                }
                    modelo.addRow(
                    new Object[]{
                        usuario.getIdusuario(),
                        usuario.getNomCuenta(),
                    }
                );
            } 
    }
    
     private void cargarTablaBusquedaUsuario(String user)
    {
        if(user.equalsIgnoreCase("")){
            cargarTabla();
            return;
        }
        
        DefaultTableModel modelo = (DefaultTableModel)tablaUsuarios.getModel();
        modelo.setRowCount(0);
        tablaUsuarios.setModel(modelo);
        List<usuarios> usuarios = usuarioDAO.findusuariosEntities();
        List<usuarios> usuariosFiltrados = new ArrayList();
        
        for(int i = 0; i < usuarios.size();i++)
        {
            try{
                if(usuarios.get(i).getIdusuario() == Integer.parseInt(user))
            {
                if(usuarios.get(i).getActivo()){
                usuariosFiltrados.add(usuarios.get(i));
                }
            }
            }catch(NumberFormatException ex){
                if(usuarios.get(i).getNomCuenta().equalsIgnoreCase(user)){
                if(usuarios.get(i).getActivo()){
                usuariosFiltrados.add(usuarios.get(i));
                }
                }
            }
        }
        
        if(usuariosFiltrados.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"No se encontraron usuarios con ese Id o cuenta o el usuario esta desactivado.","Usuario inexistente o desactivado",JOptionPane.ERROR_MESSAGE);
            return;
        }
            for(usuarios usuario : usuariosFiltrados){
                    modelo.addRow(
                    new Object[]{
                        usuario.getIdusuario(),
                        usuario.getNomCuenta(),
                    }
                );
            } 
    }
     
     //activa el permiso a la pantalla del combobox
    public void activarPermisoPantalla(){
         try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setActivo(true);
            permisosUsDAO.edit(permisos);
         }catch(javax.persistence.NoResultException ex){
             permisosusuario permisos = new permisosusuario();
             permisos.setActivo(true);
             permisos.setIDUsuario(Integer.parseInt(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),0).toString()));
             permisos.setIDPermiso(devolverIdCBPantallas(cbPantallas.getSelectedItem().toString()));
             try {
                 permisosUsDAO.create(permisos);
             }catch (Exception ex1) {
                 log(ex1);
             }
         }catch(Exception ex){
             log(ex);
         }
     }
    //desactiva el permiso a la pantalla seleccionada en el combobox
    public void desactivarPermisoPantalla(){
         try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setActivo(false);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al desactivar permiso.");
         }
     }
    
    
    public void activarPermisoNuevo(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setNuevo(true);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al otorgar permiso.");
         }
    }
    
    public void desactivarPermisoNuevo(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setNuevo(false);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al desactivar permiso.");
         }
    }
    
    public void activarPermisoModificar(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setModificar(true);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al otorgar permiso.");
         }
    
    }
    
    public void desactivarPermisoModificar(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setModificar(false);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al desactivar permiso.");
         }
    }
    
    public void activarPermisoImprimir(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setImprimir(true);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al otorgar permiso.");
         }
    }
    
    public void desactivarPermisoImprimir(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setImprimir(false);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al desactivar permiso.");
         }
    }
    
    public void activarPermisoLista(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setLista(true);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al otorgar permiso.");
         }
    }
    
    public void desactivarPermisoLista(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setLista(false);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al desactivar permiso.");
         }
    }
    
    public void activarPermisoDesactivar(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setDesactivar(true);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al otorgar permiso.");
         }
    }
    
    public void desactivarPermisoDesactivar(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setDesactivar(false);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al desactivar permiso.");
         }
    }
    
    public void activarPermisoPuestos(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setPuesto(true);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al otorgar permiso.");
         }
    }
    
    public void desactivarPermisoPuestos(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setPuesto(false);
            permisosUsDAO.edit(permisos);
        }catch(Exception ex){
            log(ex);
             JOptionPane.showMessageDialog(this, "Error al desactivar permiso.");
         } 
    }
    
    
    public void activarPermisoNuevoPrecio(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setNuevoPrecio(true);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al otorgar permiso.");
         }
    }
    
    public void desactivarPermisoNuevoPrecio(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setNuevoPrecio(false);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al desactivar permiso.");
         }
    }
    
    
    public void activarPermisoNuevoPuesto(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setNuevoPuesto(true);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al otorgar permiso.");
         }
    }
    
    public void desactivarPermisoNuevoPuesto(){
        try{
            permisosusuario permisos = encontrarPermisos();
            permisos.setNuevoPrecio(false);
            permisosUsDAO.edit(permisos);
         }catch(Exception ex){
             log(ex);
             JOptionPane.showMessageDialog(this, "Error al desactivar permiso.");
         }
    }
    
     //desactiva los botones de los permisos si la pantalla esta desactivada
     public void desactivarActivarBotones(){
         if(!cbPantallas.isEnabled()){
             permisoPantalla.setEnabled(false);
         }
        if(!permisoPantalla.isSelected()){
               nuevo.setEnabled(false);
               modificar.setEnabled(false);
               imprimir.setEnabled(false);
               lista.setEnabled(false);
               desactivar.setEnabled(false);
               puestos.setEnabled(false);
               nuevoPrecio.setEnabled(false);
               nuevoPuesto.setEnabled(false);
           }else{
               nuevo.setEnabled(true);
               modificar.setEnabled(true);
               imprimir.setEnabled(true);
               lista.setEnabled(true);
               desactivar.setEnabled(true);
               puestos.setEnabled(true);
               nuevoPrecio.setEnabled(true);
               nuevoPuesto.setEnabled(true);
           }
     }
     
     public permisosusuario encontrarPermisos(){
        EntityManager em = usuarioDAO.getEntityManager();
        String hqlDetalleProd = "FROM permisosusuario E WHERE E.IDUsuario = :IDUsuario AND E.IDPermiso = :IDPermiso";
        Query queryPermisos = em.createQuery(hqlDetalleProd);
        queryPermisos.setParameter("IDUsuario",Integer.parseInt(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(),0).toString()));
        queryPermisos.setParameter("IDPermiso",devolverIdCBPantallas(cbPantallas.getSelectedItem().toString()));
        permisosusuario permisos = (permisosusuario)queryPermisos.getSingleResult();
        return permisos;
     }
     
      public void cargarPermisosPantalla(){
         
         try{
            permisosusuario permisos = encontrarPermisos();
            
            if(permisos.isActivo()){
                permisoPantalla.setSelected(true);
            }else{
                permisoPantalla.setSelected(false);
                desactivarActivarBotones();
                return;
            }
            
            if(permisos.isLista()){
                lista.setSelected(true);
                if(devolverIdCBPantallas(cbPantallas.getSelectedItem().toString()) > 4 && devolverIdCBPantallas(cbPantallas.getSelectedItem().toString()) < 8){
                if(permisos.isNuevoPrecio()){
                    nuevoPrecio.setVisible(true);
                    lblNuevoPrecio.setVisible(true);
                    lblNuevoPrecio.setText("Nuevo Precio:");
                    nuevoPrecio.setSelected(true);
                }else{
                    nuevoPrecio.setVisible(true);
                    lblNuevoPrecio.setVisible(true);
                    lblNuevoPrecio.setText("Nuevo Precio:");
                    nuevoPrecio.setSelected(false);
                }
                }
            }else{
                lista.setSelected(false);
            }
            
            if(permisos.isImprimir()){
                imprimir.setSelected(true);
            }else{
                imprimir.setSelected(false);
            }
            
            if(permisos.isModificar()){
                modificar.setSelected(true);
            }else{
                modificar.setSelected(false);
            }
            
            if(permisos.isNuevo()){
                nuevo.setSelected(true);
            }else{
                nuevo.setSelected(false);
            }
            
            if(permisos.isDesactivar()){
                desactivar.setSelected(true);
            }else{
                desactivar.setSelected(false);
            }
            
            if(permisos.isPuesto()){
                puestos.setSelected(true);
                nuevoPuesto.setVisible(true);
                lblNuevoPuesto.setVisible(true);
                nuevoPuesto.setSelected(permisos.isPuesto());
            }else{
                puestos.setSelected(false);
                nuevoPuesto.setVisible(false);
                lblNuevoPuesto.setVisible(false);
            }
            
         }catch(javax.persistence.NoResultException Ex){
             permisoPantalla.setSelected(false);
             desactivarActivarBotones();
             imprimir.setSelected(false);
             nuevo.setSelected(false);
             modificar.setSelected(false);
             desactivar.setSelected(false);
             puestos.setSelected(false);
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
        jLabel1 = new javax.swing.JLabel();
        buscarTxt = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        tituloPantalla1 = new javax.swing.JLabel();
        permisoPantalla = new javax.swing.JToggleButton();
        cbPantallas = new javax.swing.JComboBox<>();
        tituloPantalla2 = new javax.swing.JLabel();
        lblNuevo = new javax.swing.JLabel();
        nuevo = new javax.swing.JToggleButton();
        lblModif = new javax.swing.JLabel();
        modificar = new javax.swing.JToggleButton();
        lblImprimir = new javax.swing.JLabel();
        imprimir = new javax.swing.JToggleButton();
        lblLista = new javax.swing.JLabel();
        lista = new javax.swing.JToggleButton();
        lblDesactivar = new javax.swing.JLabel();
        desactivar = new javax.swing.JToggleButton();
        lblPuestos = new javax.swing.JLabel();
        puestos = new javax.swing.JToggleButton();
        lblNuevoPrecio = new javax.swing.JLabel();
        nuevoPrecio = new javax.swing.JToggleButton();
        lblNuevoPuesto = new javax.swing.JLabel();
        nuevoPuesto = new javax.swing.JToggleButton();
        botonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 48)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("PERMISOS");

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

        tablaUsuarios.setAutoCreateRowSorter(true);
        tablaUsuarios.setBackground(new java.awt.Color(30, 33, 34));
        tablaUsuarios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Usuario", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
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
        if (tablaUsuarios.getColumnModel().getColumnCount() > 0) {
            tablaUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(15);
            tablaUsuarios.getColumnModel().getColumn(1).setResizable(false);
        }
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaUsuarios.getColumnCount();i++)
        {
            tablaUsuarios.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaUsuarios.setShowGrid(true);
        tablaUsuarios.setGridColor(Color.BLACK);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 58, 324, 435));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 24, -1, -1));

        buscarTxt.setBackground(new java.awt.Color(30, 33, 34));
        buscarTxt.setForeground(new java.awt.Color(255, 255, 255));
        buscarTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        buscarTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscarTxtFocusGained(evt);
            }
        });
        jPanel3.add(buscarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 13, 223, 39));

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        botonBuscar.setBorderPainted(false);
        botonBuscar.setContentAreaFilled(false);
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 13, 40, 39));

        tituloPantalla1.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla1.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla1.setText("ACCESO A PANTALLAS");
        jPanel3.add(tituloPantalla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 13, -1, -1));

        permisoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleoff.png"))); // NOI18N
        permisoPantalla.setBorderPainted(false);
        permisoPantalla.setContentAreaFilled(false);
        permisoPantalla.setRolloverEnabled(false);
        permisoPantalla.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleon.png"))); // NOI18N
        permisoPantalla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                permisoPantallaMouseClicked(evt);
            }
        });
        permisoPantalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permisoPantallaActionPerformed(evt);
            }
        });
        permisoPantalla.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                permisoPantallaPropertyChange(evt);
            }
        });
        jPanel3.add(permisoPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 68, 57, 42));

        cbPantallas.setBackground(new java.awt.Color(30, 33, 34));
        cbPantallas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbPantallas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbPantallasMouseClicked(evt);
            }
        });
        cbPantallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPantallasActionPerformed(evt);
            }
        });
        jPanel3.add(cbPantallas, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 68, 326, 42));

        tituloPantalla2.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla2.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla2.setText("Pantalla:");
        jPanel3.add(tituloPantalla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 68, -1, -1));

        lblNuevo.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblNuevo.setForeground(new java.awt.Color(255, 255, 255));
        lblNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNuevo.setText("Nuevo:");
        jPanel3.add(lblNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 128, 210, -1));

        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleoff.png"))); // NOI18N
        nuevo.setBorderPainted(false);
        nuevo.setContentAreaFilled(false);
        nuevo.setRolloverEnabled(false);
        nuevo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleon.png"))); // NOI18N
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel3.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 57, 42));

        lblModif.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblModif.setForeground(new java.awt.Color(255, 255, 255));
        lblModif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModif.setText("Modificar:");
        jPanel3.add(lblModif, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 214, 210, -1));

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleoff.png"))); // NOI18N
        modificar.setBorderPainted(false);
        modificar.setContentAreaFilled(false);
        modificar.setRolloverEnabled(false);
        modificar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleon.png"))); // NOI18N
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPanel3.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 252, 57, 42));

        lblImprimir.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblImprimir.setForeground(new java.awt.Color(255, 255, 255));
        lblImprimir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImprimir.setText("Imprimir:");
        jPanel3.add(lblImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 300, 210, -1));

        imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleoff.png"))); // NOI18N
        imprimir.setBorderPainted(false);
        imprimir.setContentAreaFilled(false);
        imprimir.setRolloverEnabled(false);
        imprimir.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleon.png"))); // NOI18N
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });
        jPanel3.add(imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 343, 57, 42));

        lblLista.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblLista.setForeground(new java.awt.Color(255, 255, 255));
        lblLista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLista.setText("Lista Precios:");
        jPanel3.add(lblLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 390, 210, -1));

        lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleoff.png"))); // NOI18N
        lista.setBorderPainted(false);
        lista.setContentAreaFilled(false);
        lista.setRolloverEnabled(false);
        lista.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleon.png"))); // NOI18N
        lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaActionPerformed(evt);
            }
        });
        jPanel3.add(lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 57, 42));

        lblDesactivar.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblDesactivar.setForeground(new java.awt.Color(255, 255, 255));
        lblDesactivar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesactivar.setText("Desactivar:");
        jPanel3.add(lblDesactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 128, 210, -1));

        desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleoff.png"))); // NOI18N
        desactivar.setBorderPainted(false);
        desactivar.setContentAreaFilled(false);
        desactivar.setRolloverEnabled(false);
        desactivar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleon.png"))); // NOI18N
        desactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desactivarActionPerformed(evt);
            }
        });
        jPanel3.add(desactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 57, 42));

        lblPuestos.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblPuestos.setForeground(new java.awt.Color(255, 255, 255));
        lblPuestos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPuestos.setText("Puestos:");
        jPanel3.add(lblPuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 214, 210, -1));

        puestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleoff.png"))); // NOI18N
        puestos.setBorderPainted(false);
        puestos.setContentAreaFilled(false);
        puestos.setRolloverEnabled(false);
        puestos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleon.png"))); // NOI18N
        puestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puestosActionPerformed(evt);
            }
        });
        jPanel3.add(puestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 252, 57, 42));

        lblNuevoPrecio.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblNuevoPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lblNuevoPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNuevoPrecio.setText("Nuevo Precio:");
        jPanel3.add(lblNuevoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 210, -1));

        nuevoPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleoff.png"))); // NOI18N
        nuevoPrecio.setBorderPainted(false);
        nuevoPrecio.setContentAreaFilled(false);
        nuevoPrecio.setRolloverEnabled(false);
        nuevoPrecio.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleon.png"))); // NOI18N
        nuevoPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoPrecioActionPerformed(evt);
            }
        });
        jPanel3.add(nuevoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 343, 57, 42));

        lblNuevoPuesto.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblNuevoPuesto.setForeground(new java.awt.Color(255, 255, 255));
        lblNuevoPuesto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNuevoPuesto.setText("Nuevo Puesto:");
        jPanel3.add(lblNuevoPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 210, -1));

        nuevoPuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleoff.png"))); // NOI18N
        nuevoPuesto.setBorderPainted(false);
        nuevoPuesto.setContentAreaFilled(false);
        nuevoPuesto.setRolloverEnabled(false);
        nuevoPuesto.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toggleon.png"))); // NOI18N
        nuevoPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoPuestoActionPerformed(evt);
            }
        });
        jPanel3.add(nuevoPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 57, 42));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tituloPantalla)
                        .addGap(213, 213, 213)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tituloPantalla)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        // TODO add your handling code here:
        try{
            if(tablaUsuarios.getSelectedRow() != -1){
            cbPantallas.setEnabled(true);
            permisoPantalla.setEnabled(true);
            cargarPermisosPantalla();
            desactivarActivarBotones();
            cbPantallas.setSelectedIndex(0);
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
        try{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        emf.close();
        this.dispose();
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        try{
            cargarTablaBusquedaUsuario(buscarTxt.getText());
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void buscarTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarTxtFocusGained
        // TODO add your handling code here:
        buscarTxt.selectAll();
    }//GEN-LAST:event_buscarTxtFocusGained

    private void permisoPantallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permisoPantallaActionPerformed
        // TODO add your handling code here:
        try{
            if(Integer.parseInt(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString()) == 1 &&
                    devolverIdCBPantallas(cbPantallas.getSelectedItem().toString()) == 12){
                JOptionPane.showMessageDialog(this, "El usuario administrador no puede desactivar su acceso al modulo de seguridad." , "Error de acceso",JOptionPane.ERROR_MESSAGE);
                permisoPantalla.setSelected(false);
                return;
            }
            desactivarActivarBotones();
            if(permisoPantalla.isSelected()){
                activarPermisoPantalla();
                cargarPermisosPantalla();
            }else{
                desactivarPermisoPantalla();
            }
        }catch(Exception ex){
            log(ex);
        }  
    }//GEN-LAST:event_permisoPantallaActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        try{
            if(nuevo.isSelected()){
            activarPermisoNuevo();
            }else{
                desactivarPermisoNuevo();
            }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_nuevoActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
        try{
            if(modificar.isSelected()){
            activarPermisoModificar();
            }else{
                desactivarPermisoModificar();
            }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
        // TODO add your handling code here:
        try{
            if(imprimir.isSelected()){
                activarPermisoImprimir();
            }else{
                desactivarPermisoImprimir();
            }
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_imprimirActionPerformed

    private void listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaActionPerformed
        // TODO add your handling code here:
        try{
            if(lista.isSelected()){
            activarPermisoLista();
            if(devolverIdCBPantallas(cbPantallas.getSelectedItem().toString()) > 4 && devolverIdCBPantallas(cbPantallas.getSelectedItem().toString()) < 8){
                lblNuevoPrecio.setVisible(true);
            lblNuevoPrecio.setText("Nuevo Salario");
            nuevoPrecio.setVisible(true);
            }
            }else{
                lblNuevoPrecio.setVisible(false);
                nuevoPrecio.setVisible(false);
                desactivarPermisoLista();
            }
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_listaActionPerformed

    private void permisoPantallaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_permisoPantallaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_permisoPantallaPropertyChange

    private void permisoPantallaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_permisoPantallaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_permisoPantallaMouseClicked

    private void cbPantallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPantallasActionPerformed
        // TODO add your handling code here:
        try{
        if(tablaUsuarios.getSelectedRow() > -1){
            cargarPermisosPantalla();
            desactivarActivarBotones();
            switch(devolverIdCBPantallas(cbPantallas.getSelectedItem().toString())){
                case 1:
                    lblNuevoPuesto.setVisible(false);
                    nuevoPuesto.setVisible(false);
                    lblNuevoPrecio.setVisible(false);
                    nuevoPrecio.setVisible(false);
                    desactivar.setVisible(false);
                    lblDesactivar.setVisible(false);
                    lblPuestos.setVisible(false);
                    puestos.setVisible(false);
                    lblNuevo.setVisible(true);
                    nuevo.setVisible(true);
                    modificar.setVisible(true);
                    imprimir.setVisible(true);
                    lblModif.setVisible(true);
                    lblImprimir.setVisible(true);
                    lista.setVisible(true);
                    lblLista.setVisible(true);
                    lblNuevo.setText("Guardar");
                    lblModif.setText("Generar");
                    lblImprimir.setText("Imprimir");
                    lblLista.setText("Limpiar");
                    if(!cbPantallas.isEnabled()){
                        cargarPermisosPantalla();
                    }
                    break;
                case 2:
                    lblNuevoPuesto.setVisible(false);
                    nuevoPuesto.setVisible(false);
                    lblNuevoPrecio.setVisible(false);
                    nuevoPrecio.setVisible(false);
                    puestos.setVisible(false);
                    lblPuestos.setVisible(false);
                    lblDesactivar.setVisible(false);
                    lblNuevo.setVisible(true);
                    nuevo.setVisible(true);
                    modificar.setVisible(true);
                    imprimir.setVisible(true);
                    lblModif.setVisible(true);
                    lblImprimir.setVisible(true);
                    lista.setVisible(true);
                    lblLista.setVisible(true);
                    lblNuevo.setText("Nuevo Bono");
                    lblModif.setText("Nuevo Tipo");
                    lblImprimir.setText("Imprimir");
                    lblLista.setText("Limpiar");
                    desactivar.setVisible(false);
                    if(!permisoPantalla.isSelected()){
                        cargarPermisosPantalla();
                    }
                    break;
                case 3:
                    lblNuevoPuesto.setVisible(false);
                    nuevoPuesto.setVisible(false);
                    lblNuevoPrecio.setVisible(false);
                    nuevoPrecio.setVisible(false);
                    lblNuevo.setText("Nueva Deduccion");
                    lblModif.setText("Nuevo Tipo");
                    lblImprimir.setText("Imprimir");
                    lblLista.setText("Limpiar");
                    lblNuevo.setVisible(true);
                    nuevo.setVisible(true);
                    modificar.setVisible(true);
                    imprimir.setVisible(true);
                    lblModif.setVisible(true);
                    lblImprimir.setVisible(true);
                    lista.setVisible(true);
                    lblLista.setVisible(true);
                    desactivar.setVisible(false);
                    lblDesactivar.setVisible(false);
                    puestos.setVisible(false);
                    lblPuestos.setVisible(false);
                    if(!permisoPantalla.isSelected()){
                        cargarPermisosPantalla();
                    }
                    break;
                case 4:
                    lblNuevoPuesto.setVisible(false);
                    nuevoPuesto.setVisible(false);
                    lblNuevoPrecio.setVisible(false);
                    nuevoPrecio.setVisible(false);
                    lblPuestos.setVisible(true);
                    puestos.setVisible(true);
                    desactivar.setVisible(true);
                    lblDesactivar.setVisible(true);
                    lblNuevo.setVisible(true);
                    nuevo.setVisible(true);
                    modificar.setVisible(true);
                    imprimir.setVisible(true);
                    lblModif.setVisible(true);
                    lblImprimir.setVisible(true);
                    lblPuestos.setText("Nuevo Tipo Doc.");
                    lblNuevo.setText("Nuevo Estado");
                    lblModif.setText("Modificar");
                    lblImprimir.setText("Imprimir");
                    lblLista.setText("Nuevo Tipo Pago");
                    lblDesactivar.setText("Desactivar");
                    if(!permisoPantalla.isSelected()){
                        cargarPermisosPantalla();
                    }
                    break;
                case 5:
                    lblNuevoPuesto.setVisible(false);
                    nuevoPuesto.setVisible(false);
                    lblNuevoPrecio.setVisible(false);
                    nuevoPrecio.setVisible(false);
                    lblPuestos.setVisible(true);
                    puestos.setVisible(true);
                    lblNuevo.setVisible(true);
                    nuevo.setVisible(true);
                    modificar.setVisible(true);
                    imprimir.setVisible(true);
                    lblModif.setVisible(true);
                    lblImprimir.setVisible(true);
                    desactivar.setVisible(true);
                    lista.setVisible(true);
                    lblLista.setVisible(true);
                    desactivar.setVisible(true);
                    lblDesactivar.setVisible(true);
                    lblPuestos.setText("Agregar Productos");
                    lblNuevo.setText("Nuevo");
                    lblModif.setText("Modificar");
                    lblImprimir.setText("Imprimir");
                    lblLista.setText("Lista Precios");
                    lblDesactivar.setText("Desactivar");
                    lblNuevoPrecio.setText("Precio Nuevo");
                    lblNuevoPrecio.setVisible(true);
                    nuevoPrecio.setVisible(true);
                    if(!permisoPantalla.isSelected()){
                        cargarPermisosPantalla();
                    }
                    break;
                case 6:
                    lblNuevoPuesto.setVisible(false);
                    nuevoPuesto.setVisible(false);
                    lblNuevoPrecio.setVisible(false);
                    nuevoPrecio.setVisible(false);
                    puestos.setVisible(false);
                    lblPuestos.setVisible(false);
                    lblNuevo.setText("Nuevo");
                    lblModif.setText("Modificar");
                    lblImprimir.setText("Imprimir");
                    lblLista.setText("Lista Precios");
                    lblNuevoPrecio.setText("Precio Nuevo");
                    lblNuevoPrecio.setVisible(true);
                    nuevoPrecio.setVisible(true);
                    lblNuevo.setVisible(true);
                    nuevo.setVisible(true);
                    modificar.setVisible(true);
                    imprimir.setVisible(true);
                    lblModif.setVisible(true);
                    lblImprimir.setVisible(true);
                    desactivar.setVisible(true);
                    lista.setVisible(true);
                    lblLista.setVisible(true);
                    desactivar.setVisible(true);
                    lblDesactivar.setVisible(true);
                    lblDesactivar.setText("Desactivar");
                    if(!permisoPantalla.isSelected()){
                        cargarPermisosPantalla();
                    }
                    break;
                case 7:
                    lblNuevoPuesto.setVisible(true);
                    nuevoPuesto.setVisible(true);
                    lblNuevoPrecio.setVisible(true);
                    nuevoPrecio.setVisible(true);
                    lblNuevo.setVisible(true);
                    nuevo.setVisible(true);
                    modificar.setVisible(true);
                    imprimir.setVisible(true);
                    lblModif.setVisible(true);
                    lblImprimir.setVisible(true);
                    desactivar.setVisible(true);
                    lblNuevoPrecio.setText("Nuevo Salario:");
                    lblNuevo.setText("Nuevo");
                    lblModif.setText("Modificar");
                    lblImprimir.setText("Imprimir");
                    lblLista.setText("Lista Salarios");
                    lblPuestos.setText("Lista de Puestos");
                    lblPuestos.setVisible(true);
                    puestos.setVisible(true);
                    lista.setVisible(true);
                    lblLista.setVisible(true);
                    desactivar.setVisible(true);
                    lblDesactivar.setVisible(true);
                    lblDesactivar.setText("Desactivar");
                    if(!permisoPantalla.isSelected()){
                        cargarPermisosPantalla();
                    }
                    break;
                case 8:
                    lblNuevoPuesto.setVisible(false);
                    nuevoPuesto.setVisible(false);
                    lblNuevoPrecio.setVisible(false);
                    nuevoPrecio.setVisible(false);
                    puestos.setVisible(false);
                    lblPuestos.setVisible(false);
                    lblNuevo.setVisible(true);
                    nuevo.setVisible(true);
                    modificar.setVisible(true);
                    imprimir.setVisible(true);
                    lblModif.setVisible(true);
                    lblImprimir.setVisible(true);
                    desactivar.setVisible(true);
                    lblNuevo.setText("Nuevo");
                    lblModif.setText("Modificar");
                    lblImprimir.setText("Imprimir");
                    lblLista.setText("Nuevo Tipo");
                    lista.setVisible(true);
                    lblLista.setVisible(true);
                    desactivar.setVisible(false);
                    lblDesactivar.setVisible(false);
                    lblDesactivar.setText("Desactivar");
                    if(!permisoPantalla.isSelected()){
                        cargarPermisosPantalla();
                    }
                    break;
                case 9:
                    lblNuevoPuesto.setVisible(false);
                    nuevoPuesto.setVisible(false);
                    lblNuevoPrecio.setVisible(false);
                    nuevoPrecio.setVisible(false);
                    puestos.setVisible(false);
                    lblPuestos.setVisible(false);
                    lblNuevo.setText("Nuevo");
                    lblNuevo.setVisible(true);
                    nuevo.setVisible(true);
                    modificar.setVisible(true);
                    imprimir.setVisible(true);
                    lblModif.setVisible(true);
                    lblImprimir.setVisible(true);
                    desactivar.setVisible(true);
                    lblDesactivar.setVisible(true);
                    lblDesactivar.setText("Desactivar");
                    lblModif.setText("Modificar");
                    lblImprimir.setText("Imprimir");
                    lblLista.setVisible(false);
                    lista.setVisible(false);
                    
                    if(!permisoPantalla.isSelected()){
                        cargarPermisosPantalla();
                    }
                    break;
                case 10:
                    lblNuevoPuesto.setVisible(false);
                    nuevoPuesto.setVisible(false);
                    lblNuevoPrecio.setVisible(false);
                    nuevoPrecio.setVisible(false);
                    lista.setVisible(false);
                    lblLista.setVisible(false);
                    puestos.setVisible(false);
                    lblPuestos.setVisible(false);
                    lblNuevo.setText("Nuevo");
                    nuevo.setVisible(true);
                    lblNuevo.setVisible(true);
                    lblModif.setText("Modificar");
                    modificar.setVisible(true);
                    lblModif.setVisible(true);
                    lblImprimir.setText("Imprimir");
                    lblDesactivar.setVisible(true);
                    desactivar.setVisible(true);
                    lblDesactivar.setVisible(true);
                    lblDesactivar.setText("Desactivar");
                    if(!permisoPantalla.isSelected()){
                        cargarPermisosPantalla();
                    }
                    break;
                case 11:
                    lblNuevoPuesto.setVisible(false);
                    nuevoPuesto.setVisible(false);
                    lblNuevoPrecio.setVisible(false);
                    nuevoPrecio.setVisible(false);
                    puestos.setVisible(false);
                    lblPuestos.setVisible(false);
                    nuevo.setVisible(false);
                    lblNuevo.setVisible(false);
                    lblModif.setText("Modificar Estado");
                    modificar.setVisible(true);
                    lblModif.setVisible(true);
                    lblImprimir.setText("Imprimir");
                    lblImprimir.setVisible(true);
                    imprimir.setVisible(true);
                    lista.setVisible(false);
                    lblLista.setVisible(false);
                    lblLista.setVisible(false);
                    lblDesactivar.setVisible(false);
                    desactivar.setVisible(false);
                    if(!permisoPantalla.isSelected()){
                        cargarPermisosPantalla();
                    }
                    break;
                case 12:
                    lblDesactivar.setVisible(false);
                    lblLista.setVisible(false);
                    lblNuevoPuesto.setVisible(false);
                    nuevoPuesto.setVisible(false);
                    lblNuevoPrecio.setVisible(false);
                    nuevoPrecio.setVisible(false);
                    puestos.setVisible(false);
                    lblPuestos.setVisible(false);
                    lblNuevo.setVisible(false);
                    nuevo.setVisible(false);
                    lblModif.setVisible(false);
                    modificar.setVisible(false);
                    lblImprimir.setVisible(false);
                    imprimir.setVisible(false);
                    lista.setVisible(false);
                    desactivar.setVisible(false);
                    if(!permisoPantalla.isSelected()){
                        cargarPermisosPantalla();
                    }
                    break;
                case 13:
                    lblNuevoPuesto.setVisible(false);
                    nuevoPuesto.setVisible(false);
                    lblNuevoPrecio.setVisible(false);
                    nuevoPrecio.setVisible(false);
                    puestos.setVisible(false);
                    lblPuestos.setVisible(false);
                    lblNuevo.setText("Guardar");
                    lblNuevo.setVisible(true);
                    nuevo.setVisible(true);
                    lblModif.setVisible(false);
                    lblModif.setText("Modificar Estado");
                    modificar.setVisible(false);
                    lblImprimir.setText("Imprimir");
                    lblImprimir.setVisible(true);
                    imprimir.setVisible(true);
                    lista.setVisible(false);
                    desactivar.setVisible(false);
                    lblDesactivar.setVisible(false);
                    lblLista.setVisible(false);
                    if(!permisoPantalla.isSelected()){
                        cargarPermisosPantalla();
                    }
                    break;
                case 14:
                    lblNuevoPuesto.setVisible(false);
                    nuevoPuesto.setVisible(false);
                    lblNuevoPrecio.setVisible(false);
                    nuevoPrecio.setVisible(false);
                    puestos.setVisible(false);
                    lblPuestos.setVisible(false);
                    lblNuevo.setVisible(true);
                    lblDesactivar.setVisible(false);
                    lblLista.setVisible(false);
                    nuevo.setVisible(true);
                    lblNuevo.setText("Menu gerente");
                    lblModif.setVisible(true);
                    lblModif.setText("Facturar");
                    modificar.setVisible(true);
                    lblImprimir.setVisible(false);
                    imprimir.setVisible(false);
                    lista.setVisible(false);
                    desactivar.setVisible(false);
                    break;
            }
        }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_cbPantallasActionPerformed

    private void cbPantallasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbPantallasMouseClicked
        // TODO add your handling code here:
        try{
            if(!cbPantallas.isEnabled()){
                JOptionPane.showMessageDialog(this, "Debes seleccionar un usuario.");
            }
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_cbPantallasMouseClicked

    private void desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desactivarActionPerformed
        // TODO add your handling code here:
        try{
            if(desactivar.isSelected()){
                activarPermisoDesactivar();
            }else{
                desactivarPermisoDesactivar();
            }
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_desactivarActionPerformed

    private void puestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puestosActionPerformed
        // TODO add your handling code here:
        try{
            if(puestos.isSelected()){
                activarPermisoPuestos();
                if(devolverIdCBPantallas(cbPantallas.getSelectedItem().toString()) == 7){
                    lblNuevoPuesto.setText("Nuevo Puesto:");
                    lblNuevoPuesto.setVisible(true);
                    nuevoPuesto.setVisible(true);
                }               
            }else{
                desactivarPermisoPuestos();
                lblNuevoPuesto.setVisible(false);
                nuevoPuesto.setVisible(false);
            }
        }catch(Exception ex){
               log(ex); 
        }
        
    }//GEN-LAST:event_puestosActionPerformed

    private void nuevoPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoPrecioActionPerformed
        // TODO add your handling code here:
        try{
            if(nuevoPrecio.isSelected()){
                activarPermisoNuevoPrecio();
            }else{
                desactivarPermisoNuevoPrecio();
            }
        }catch(Exception ex){
            log(ex);
        }
        
    }//GEN-LAST:event_nuevoPrecioActionPerformed

    private void nuevoPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoPuestoActionPerformed
        // TODO add your handling code here:
        try{
            if(nuevoPuesto.isSelected()){
                activarPermisoNuevoPuesto();
            }else{
                desactivarPermisoNuevoPuesto();
            }
        }catch(Exception ex){
            log(ex);
        }
    }//GEN-LAST:event_nuevoPuestoActionPerformed

    
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
            java.util.logging.Logger.getLogger(PermisosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PermisosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PermisosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PermisosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PermisosUsuario().setVisible(true);
            }
        });
        
        
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
   
   private int devolverIdCBPantallas(String item){
        String[] numero = item.split("\\.");
        return Integer.parseInt(numero[0]);
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
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JComboBox<String> cbPantallas;
    private javax.swing.JToggleButton desactivar;
    private javax.swing.JToggleButton imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDesactivar;
    private javax.swing.JLabel lblImprimir;
    private javax.swing.JLabel lblLista;
    private javax.swing.JLabel lblModif;
    private javax.swing.JLabel lblNuevo;
    private javax.swing.JLabel lblNuevoPrecio;
    private javax.swing.JLabel lblNuevoPuesto;
    private javax.swing.JLabel lblPuestos;
    private javax.swing.JToggleButton lista;
    private javax.swing.JLabel logo;
    private javax.swing.JToggleButton modificar;
    private javax.swing.JToggleButton nuevo;
    private javax.swing.JToggleButton nuevoPrecio;
    private javax.swing.JToggleButton nuevoPuesto;
    private javax.swing.JToggleButton permisoPantalla;
    private javax.swing.JToggleButton puestos;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JLabel tituloPantalla;
    private javax.swing.JLabel tituloPantalla1;
    private javax.swing.JLabel tituloPantalla2;
    // End of variables declaration//GEN-END:variables
}

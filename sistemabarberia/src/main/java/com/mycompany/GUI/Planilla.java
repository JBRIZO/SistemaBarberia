/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.sistemabarberia.JPACOntrollers.bonosempleadomensualJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.deduccionesempleadomensualJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.empleadoJpaController;
import com.mycompany.sistemabarberia.JPACOntrollers.planillasJpaController;
import com.mycompany.sistemabarberia.deduccionesempleadomensual;
import com.mycompany.sistemabarberia.empleado;
import com.mycompany.sistemabarberia.salariohistoricoempleados;
import com.mycompany.sistemabarberia.JPACOntrollers.salariohistoricoempleadosJpaController;
import com.mycompany.sistemabarberia.PlanillaDataSource;
import com.mycompany.sistemabarberia.bonosempleadomensual;
import com.mycompany.sistemabarberia.planillas;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kesil
 */
public class Planilla extends javax.swing.JFrame {
    
    private String periodoActual;
    
    private empleadoJpaController empleadoDAO =  new empleadoJpaController();
    private List<empleado> empleadosBD =  empleadoDAO.findempleadoEntities();
    private deduccionesempleadomensualJpaController deduccionesDAO = new deduccionesempleadomensualJpaController();
    private salariohistoricoempleadosJpaController salarioDAO = new salariohistoricoempleadosJpaController();
    private bonosempleadomensualJpaController bonosDAO = new bonosempleadomensualJpaController();
    private planillasJpaController planillaDAO = new planillasJpaController();
    private EntityManager em = empleadoDAO.getEntityManager();
    
    private PlanillaDataSource dataSource;
    private java.util.Date dt = new java.util.Date();
    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
    String currentTime = sdf.format(dt);
    private ImageIcon imagen;
    private Icon icono;

    /**
     * Creates new form nuevoTipoDescuento
     */
    public Planilla() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        this.insertarImagen(this.logo,"src/main/resources/Imagenes/logoBarberia.png");
        
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dt);
        int anio = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH) + 1;
        
        periodoActual = mes<10? anio+"0"+mes: Integer.toString(anio)+mes;
        fechaLabel.setText("Fecha: " + currentTime);
        periodo.setText("Periodo: " + periodoActual);
    }
    
    public void verificarUltimaPlanillaGenerada()
    {
        String hql = "FROM planillas E WHERE E.Periodo = :periodo";
        Query query = em.createQuery(hql);
        query.setParameter("periodo",periodoActual);
        List<planillas> planillasPeriodo = (List<planillas>)query.getResultList();
        
        if(planillasPeriodo.isEmpty())
        {
            return;
        }else
        {
            cargarTablaPlanilla();
        }
    }
     public void imprimirPlanilla()
    {
        //filtrar la planilla por periodo
        String hql = "FROM planillas E WHERE E.Periodo = :periodo";
        Query query = em.createQuery(hql);
        query.setParameter("periodo",periodoActual);
        List<planillas> planillasPeriodo = (List<planillas>)query.getResultList();
        
        //llenar los detalles en la factura
      Object[][] arrayPlanilla;
      arrayPlanilla = new Object[planillasPeriodo.size()][7];
      
    for(int i = 0; i < planillasPeriodo.size();i++)
    {
        //llamar procedimiento almacenado para obtener la suma de los bonos por empleado
        Query queryBonos =  em.createNativeQuery("CALL sumaBonos(:idEmpleado,:periodo)");
        queryBonos.setParameter("idEmpleado",planillasPeriodo.get(i).getIDEmpleado());
        queryBonos.setParameter("periodo", periodoActual);
        double sumabonos = (double)queryBonos.getSingleResult();
        //llamar procedimiento almacendao para obtenre la suma delas deducciones para un empleado
         Query queryDeducciones =  em.createNativeQuery("CALL sumaDeducciones(:idEmpleado,:periodo)");
        queryDeducciones.setParameter("idEmpleado",planillasPeriodo.get(i).getIDEmpleado());
        queryDeducciones.setParameter("periodo", periodoActual);
        double sumadeducciones = (double)queryDeducciones.getSingleResult();
        
        for(int j = 0; j < 7 ; j++)
        {
            switch(j)
            {
                case 0:
                arrayPlanilla[i][0] = planillasPeriodo.get(i).getIDEmpleado();
                break;
                case 1:
                arrayPlanilla[i][1] = empleadoDAO.findempleado(planillasPeriodo.get(i).getIDEmpleado()).getNomEmpleado();
                break;
                case 2:
                arrayPlanilla[i][2] = empleadoDAO.findempleado(planillasPeriodo.get(i).getIDEmpleado()).getApeEmpleado();
                break;
                case 3:
                arrayPlanilla[i][3] = sumabonos;
                break;
                case 4:
                arrayPlanilla[i][4] = sumadeducciones;
                break;
                case 5:
                arrayPlanilla[i][5] = Double.parseDouble(tablaPlanilla.getValueAt(i,6).toString());
                break;
                case 6:
                arrayPlanilla[i][6] = Double.parseDouble(tablaPlanilla.getValueAt(i,7).toString());    
            }
            
        }
    }     
        //para ponerles valor a los parametros
        HashMap param = new HashMap();
        
        param.put("periodo",  periodoActual);
       
        try {
            //compilar reporte
            JasperReport reporteFactura = JasperCompileManager.compileReport("src/main/resources/Reportes/reportePlanilla.jrxml");
            JasperPrint print = JasperFillManager.fillReport(
                    reporteFactura,
                    param, 
                    dataSource.getDataSource(arrayPlanilla));
            //view es un jframe dondes e muestra la factura
            JasperViewer view = new JasperViewer(print,false);
            view.setVisible(true);
            view.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Imagenes/logoBarberia.jpeg"));
        } catch (JRException ex) {
            Logger.getLogger(PantallaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarTablaPlanilla()
    {
        //Deducciones para el perido actual
        String hqlDeducciones = "FROM deduccionesempleadomensual E WHERE E.Periodo =:periodo AND E.IDEmpleado = :idEmpleado";
        Query queryDeducciones = em.createQuery(hqlDeducciones);
        queryDeducciones.setParameter("periodo",periodoActual);
        //verificar si hay deducciones para este periodo
        if(!verificarDeduccionesPeriodo())
        {
            return;
        }
        //Bonos para el periodo actual
        String hqlBonos = "FROM bonosempleadomensual E WHERE E.Periodo =:periodo AND E.IDEmpleado = :idEmpleado";
        Query queryBonos = em.createQuery(hqlBonos);
        queryBonos.setParameter("periodo",periodoActual);
        
        //verificar si hay bonos para este periodo
        if(!verificarBonosPeriodo())
        {
            return;
        }
        
        //Salario de empleados
        String hqlSalarios = "FROM salariohistoricoempleados E WHERE E.Activo = 1 AND E.IDEmpleado = :idEmpleado";
        Query querySalarios = em.createQuery(hqlSalarios);
        
        DefaultTableModel modelo = (DefaultTableModel)tablaPlanilla.getModel();
        modelo.setRowCount(0);
        tablaPlanilla.setModel(modelo);
        
        List<empleado> empleados = empleadoDAO.findempleadoEntities();
            for(empleado empleado : empleados){
                //no incluir empleados desactivados
                if(!empleado.isActivo())
                { 
                    continue;
                }
                Double totalDeducciones = 0.00;
                Double totalBonos = 0.00;
                //total de deducciones
                queryDeducciones.setParameter("idEmpleado",empleado.getIdempleado());
                List<deduccionesempleadomensual> deduccionesPorEmpleado = queryDeducciones.getResultList();
                for(deduccionesempleadomensual deducciones : deduccionesPorEmpleado)
                {
                    totalDeducciones = totalDeducciones + deducciones.getValor();
                }
                //total de bonos
                queryBonos.setParameter("idEmpleado",empleado.getIdempleado());
                List<bonosempleadomensual> bonosPorEmpleado = queryBonos.getResultList();
                for(bonosempleadomensual bonos : bonosPorEmpleado)
                {
                    totalBonos = totalBonos + bonos.getValor();
                }
                //Salario actual
                querySalarios.setParameter("idEmpleado",empleado.getIdempleado());
                salariohistoricoempleados salario = (salariohistoricoempleados)querySalarios.getSingleResult();
                Double salarioActual =  salario.getSalario();
                
                    modelo.addRow(
                    new Object[]{
                        empleado.getIdempleado(),
                        empleado.getNomEmpleado(),
                        empleado.getApeEmpleado(),
                        periodoActual,
                        totalBonos,
                        totalDeducciones,
                        salarioActual,
                        salarioActual-totalDeducciones+totalBonos
                    }
                );
                    totalDeducciones = 0.00;
                    totalBonos = 0.00;
            }
            guardar.setEnabled(true);
    }
    
    private boolean verificarDeduccionesPeriodo()
    {
        //Deducciones para el perido actual
        String hqlDeducciones = "FROM deduccionesempleadomensual E WHERE E.Periodo =:periodo";
        Query queryDeducciones = em.createQuery(hqlDeducciones);
        queryDeducciones.setParameter("periodo",periodoActual);
         List<deduccionesempleadomensual> deduccionesPorEmpleado = queryDeducciones.getResultList();
                if(deduccionesPorEmpleado.isEmpty())
                {
                    int confirmacion = JOptionPane.showConfirmDialog(this,"Parece que no hay deducciones para este periodo \n¿Seguro que deseas continuar?",
                            "Periodo sin deducciones",JOptionPane.YES_NO_OPTION);
                    if(confirmacion != 0)
                    {
                        return false;
                    }
                }
                return true;
    }
    
    private boolean verificarBonosPeriodo()
    {
         //Bonos para el periodo actual
        String hqlBonos = "FROM bonosempleadomensual E WHERE E.Periodo =:periodo";
        Query queryBonos = em.createQuery(hqlBonos);
        queryBonos.setParameter("periodo",periodoActual);
        List<bonosempleadomensual> bonosPorEmpleado = queryBonos.getResultList();
        if(bonosPorEmpleado.isEmpty())
        {
            int confirmacion = JOptionPane.showConfirmDialog(this,"Parece que no hay bonos para este periodo \n¿Seguro que deseas continuar?",
                    "Periodo sin bonos",JOptionPane.YES_NO_OPTION);
            if(confirmacion != 0)
            {
                return false;
            }
        }
        return true;
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
        tablaPlanilla = new javax.swing.JTable();
        limpiar = new javax.swing.JButton();
        generar = new javax.swing.JButton();
        imprimirReporte = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        fechaLabel = new javax.swing.JLabel();
        periodo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 17, 17));
        jPanel1.setMaximumSize(new java.awt.Dimension(334, 279));

        tituloPantalla.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        tituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        tituloPantalla.setText("PLANILLA");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 53, 53));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(421, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(421, 280));

        jPanel3.setBackground(new java.awt.Color(55, 53, 53));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setMaximumSize(new java.awt.Dimension(358, 219));
        jPanel3.setMinimumSize(new java.awt.Dimension(358, 219));

        tablaPlanilla.setAutoCreateRowSorter(true);
        tablaPlanilla.setBackground(new java.awt.Color(30, 33, 34));
        tablaPlanilla.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaPlanilla.setForeground(new java.awt.Color(255, 255, 255));
        tablaPlanilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Empleado", "Nombres", "Apellidos", "Periodo", "Bonos", "Deducciones", "Salario", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPlanilla.setGridColor(new java.awt.Color(255, 255, 255));
        tablaPlanilla.setRowHeight(32);
        tablaPlanilla.getTableHeader().setReorderingAllowed(false);
        tablaPlanilla.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaPlanillaFocusGained(evt);
            }
        });
        tablaPlanilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPlanillaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPlanilla);
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(Color.decode("#BD9E4C"));
        MyHeaderRender.setForeground(Color.BLACK);
        for(int i = 0; i < tablaPlanilla.getColumnCount();i++)
        {
            tablaPlanilla.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
        }
        tablaPlanilla.setShowGrid(true);
        tablaPlanilla.setGridColor(Color.BLACK);

        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        limpiar.setContentAreaFilled(false);
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        generar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/generar.png"))); // NOI18N
        generar.setContentAreaFilled(false);
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });

        imprimirReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimirReporte.png"))); // NOI18N
        imprimirReporte.setContentAreaFilled(false);
        imprimirReporte.setEnabled(false);
        imprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirReporteActionPerformed(evt);
            }
        });

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        guardar.setContentAreaFilled(false);
        guardar.setEnabled(false);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(generar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(generar)
                    .addComponent(imprimirReporte)
                    .addComponent(limpiar)
                    .addComponent(guardar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
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

        fechaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaLabel.setForeground(new java.awt.Color(255, 255, 255));
        fechaLabel.setText("Fecha:");

        periodo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        periodo.setForeground(new java.awt.Color(255, 255, 255));
        periodo.setText("Periodo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(306, 306, 306)
                .addComponent(tituloPantalla)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fechaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(periodo)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tituloPantalla)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaLabel)
                    .addComponent(periodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
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

    private void tablaPlanillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPlanillaMouseClicked

    }//GEN-LAST:event_tablaPlanillaMouseClicked

    private void tablaPlanillaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaPlanillaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaPlanillaFocusGained

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGerente().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
        // TODO add your handling code here:
        int confirmacion = JOptionPane.showConfirmDialog(null,"¿Seguro que deseas generar la planilla para el periodo "+periodoActual+ "?",
                "Generación de planilla",
                JOptionPane.YES_NO_OPTION);
        if(confirmacion == 0)
        {
            cargarTablaPlanilla();
            if(tablaPlanilla.getRowCount() > 0 )
            {
                imprimirReporte.setEnabled(true);
            }
        }
    }//GEN-LAST:event_generarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        // TODO add your handling code here:
         DefaultTableModel modelo = (DefaultTableModel)tablaPlanilla.getModel();
        modelo.setRowCount(0);
        tablaPlanilla.setModel(modelo);
    }//GEN-LAST:event_limpiarActionPerformed

    private void imprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirReporteActionPerformed
        // TODO add your handling code here:
        int confirmacion = JOptionPane.showConfirmDialog(this,"¿Seguro que deseas imprimir la planilla? \nAl imprimirla se guardara automaticamente y no podras generar mas planillas para este periodo.",
               "Confirmacion",JOptionPane.YES_NO_OPTION);
       if(confirmacion == 0)
       {
          imprimirPlanilla(); 
       }
    }//GEN-LAST:event_imprimirReporteActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
       
         for(int i = 0 ; i < tablaPlanilla.getRowCount() ; i++)
            {
                planillas planilla = new planillas();
                planilla.setIDEmpleado(Integer.parseInt(tablaPlanilla.getValueAt(i,0).toString()));
                planilla.setPeriodo(periodoActual);
                planilla.setTotalPagar(Double.parseDouble(tablaPlanilla.getValueAt(i,7).toString()));
                planilla.setActivo(true);
                try {
                    planillaDAO.create(planilla);
                } catch (Exception ex) {
                    Logger.getLogger(Planilla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_guardarActionPerformed

    
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
            java.util.logging.Logger.getLogger(Planilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Planilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Planilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Planilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Planilla().setVisible(true);
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
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JButton generar;
    private javax.swing.JButton guardar;
    private javax.swing.JButton imprimirReporte;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel periodo;
    private javax.swing.JTable tablaPlanilla;
    private javax.swing.JLabel tituloPantalla;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia;

import javax.swing.*;
import java.awt.*;

public class PantallaCargando extends JWindow {
  BorderLayout borderLayout1 = new BorderLayout();
  JLabel imageLabel = new JLabel();
  JPanel southPanel = new JPanel();
  FlowLayout southPanelFlowLayout = new FlowLayout();
  JProgressBar progressBar = new JProgressBar();
  ImageIcon imageIcon;
  
  public PantallaCargando(ImageIcon imageIcon) {
    this.imageIcon = imageIcon;
    dibujaVentana();
  }
  
  public void setProgressBar(JProgressBar progressBar)
  {
      this.progressBar = progressBar;
  }

  public void dibujaVentana() {
    imageLabel.setIcon(imageIcon);
    this.getContentPane().setLayout(borderLayout1);
    southPanel.setLayout(southPanelFlowLayout);
    southPanel.setBackground(Color.BLACK);
    this.getContentPane().add(imageLabel, BorderLayout.CENTER);
    this.getContentPane().add(southPanel, BorderLayout.SOUTH);
    southPanel.add(progressBar, null);
    progressBar.setVisible(false);
    this.pack();
  }

  public void setProgresoMax(int maxProgress)
  {
    progressBar.setMaximum(maxProgress);}

  public void setProgreso(int progress)
  {
    final int progreso = progress;
        progressBar.setValue(progreso);}

  public void setProgreso(String message, int progress)
  {
    final int progreso = progress;
    final String theMessage = message;
    setProgreso(progress);
    progressBar.setValue(progreso);
    setMessage(theMessage);  }

  private void setMessage(String message)
 {
    if (message==null){
      message = "";
      progressBar.setStringPainted(false);}
    else{
      progressBar.setStringPainted(true);}

    progressBar.setString(message); }

public void velocidadDeCarga(){
    for (int i = 0; i <= 100; i++)
    {
      for (long j=0; j<1000000; ++j)
      {
        String poop = " " + (j + i);
      }
     //setProgreso("" + i, i);
     setProgreso(i);        
   }
    dispose();}

}
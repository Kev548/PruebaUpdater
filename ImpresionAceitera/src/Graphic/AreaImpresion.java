/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic;

import Data.Objects;
import Data.Parameters;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Date;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Kev
 */
public class AreaImpresion extends javax.swing.JFrame implements Printable {

    public AreaImpresion() {
        initComponents();

        this.setTitle(Parameters.ProgramName + Parameters.VersionProgram);
        setIconImage(new ImageIcon(getClass().getResource("/Resources/Printer.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        F4C1 = new javax.swing.JLabel();
        mes = new javax.swing.JLabel();
        año = new javax.swing.JLabel();
        Bt_Imprimir = new javax.swing.JButton();
        Direccion = new javax.swing.JLabel();
        Nombre_1 = new javax.swing.JLabel();
        Nombre_2 = new javax.swing.JLabel();
        Nit = new javax.swing.JLabel();
        dia = new javax.swing.JLabel();
        F1C4 = new javax.swing.JLabel();
        F2C1 = new javax.swing.JLabel();
        F1C1 = new javax.swing.JLabel();
        F1C2 = new javax.swing.JLabel();
        F1C3 = new javax.swing.JLabel();
        F2C2 = new javax.swing.JLabel();
        F2C3 = new javax.swing.JLabel();
        F2C4 = new javax.swing.JLabel();
        F3C2 = new javax.swing.JLabel();
        F3C3 = new javax.swing.JLabel();
        F3C4 = new javax.swing.JLabel();
        F3C1 = new javax.swing.JLabel();
        F4C2 = new javax.swing.JLabel();
        F4C3 = new javax.swing.JLabel();
        F4C4 = new javax.swing.JLabel();
        F5C1 = new javax.swing.JLabel();
        F5C2 = new javax.swing.JLabel();
        F5C3 = new javax.swing.JLabel();
        F5C4 = new javax.swing.JLabel();
        F6C1 = new javax.swing.JLabel();
        F6C2 = new javax.swing.JLabel();
        F6C3 = new javax.swing.JLabel();
        F6C4 = new javax.swing.JLabel();
        F7C1 = new javax.swing.JLabel();
        F7C2 = new javax.swing.JLabel();
        F7C3 = new javax.swing.JLabel();
        F7C4 = new javax.swing.JLabel();
        F9C1 = new javax.swing.JLabel();
        F9C2 = new javax.swing.JLabel();
        F9C3 = new javax.swing.JLabel();
        F9C4 = new javax.swing.JLabel();
        F10C1 = new javax.swing.JLabel();
        F10C2 = new javax.swing.JLabel();
        F10C3 = new javax.swing.JLabel();
        F10C4 = new javax.swing.JLabel();
        F11C1 = new javax.swing.JLabel();
        F11C2 = new javax.swing.JLabel();
        F11C3 = new javax.swing.JLabel();
        F11C4 = new javax.swing.JLabel();
        F12C1 = new javax.swing.JLabel();
        F12C2 = new javax.swing.JLabel();
        F12C3 = new javax.swing.JLabel();
        F12C4 = new javax.swing.JLabel();
        F8C1 = new javax.swing.JLabel();
        F8C2 = new javax.swing.JLabel();
        F8C3 = new javax.swing.JLabel();
        F8C4 = new javax.swing.JLabel();
        F13C1 = new javax.swing.JLabel();
        F13C2 = new javax.swing.JLabel();
        F13C3 = new javax.swing.JLabel();
        F13C4 = new javax.swing.JLabel();
        F14C1 = new javax.swing.JLabel();
        TOTALLETRAS = new javax.swing.JLabel();
        F14C3 = new javax.swing.JLabel();
        TOTAL = new javax.swing.JLabel();
        F14C2 = new javax.swing.JLabel();
        F14C4 = new javax.swing.JLabel();

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("999");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel50.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("9999.99");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel52.setText("9999.99");

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("999");

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel70.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel71.setText("9999.99");

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel72.setText("9999.99");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(591, 106, 100, 100);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        F4C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F4C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F4C1.setText("999");
        jPanel2.add(F4C1);
        F4C1.setBounds(20, 310, 40, 20);

        mes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mes.setText("12");
        jPanel2.add(mes);
        mes.setBounds(240, 140, 58, 29);

        año.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        año.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        año.setText("2021");
        jPanel2.add(año);
        año.setBounds(320, 140, 40, 29);

        Bt_Imprimir.setText("IMPRIMIR");
        Bt_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_ImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(Bt_Imprimir);
        Bt_Imprimir.setBounds(0, 0, 560, 23);

        Direccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Direccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Direccion.setText("KM 15.5 RUTA AL ATLAN. COL ST, LUCIA SECTOR");
        jPanel2.add(Direccion);
        Direccion.setBounds(80, 220, 370, 10);

        Nombre_1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Nombre_1.setText("KEVIN ALEXANDER ROSALES VÁSQUEZ");
        jPanel2.add(Nombre_1);
        Nombre_1.setBounds(80, 173, 327, 20);

        Nombre_2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Nombre_2.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_2.setText("KEVIN ALEXANDER ROSALES ");
        jPanel2.add(Nombre_2);
        Nombre_2.setBounds(20, 190, 163, 30);

        Nit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Nit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nit.setText("0000000000-0");
        jPanel2.add(Nit);
        Nit.setBounds(260, 190, 100, 30);

        dia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dia.setText("31");
        jPanel2.add(dia);
        dia.setBounds(190, 140, 40, 29);

        F1C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F1C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F1C4.setText("9999.99");
        jPanel2.add(F1C4);
        F1C4.setBounds(310, 260, 50, 20);

        F2C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F2C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F2C1.setText("999");
        jPanel2.add(F2C1);
        F2C1.setBounds(20, 270, 40, 29);

        F1C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F1C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F1C1.setText("999");
        jPanel2.add(F1C1);
        F1C1.setBounds(20, 250, 40, 29);

        F1C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F1C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F1C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F1C2);
        F1C2.setBounds(70, 259, 190, 20);

        F1C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F1C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F1C3.setText("9999.99");
        jPanel2.add(F1C3);
        F1C3.setBounds(260, 260, 40, 20);

        F2C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F2C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F2C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F2C2);
        F2C2.setBounds(70, 280, 190, 13);

        F2C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F2C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F2C3.setText("9999.99");
        jPanel2.add(F2C3);
        F2C3.setBounds(260, 280, 40, 13);

        F2C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F2C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F2C4.setText("9999.99");
        jPanel2.add(F2C4);
        F2C4.setBounds(310, 280, 50, 13);

        F3C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F3C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F3C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F3C2);
        F3C2.setBounds(70, 293, 190, 20);

        F3C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F3C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F3C3.setText("9999.99");
        jPanel2.add(F3C3);
        F3C3.setBounds(260, 293, 40, 20);

        F3C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F3C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F3C4.setText("9999.99");
        jPanel2.add(F3C4);
        F3C4.setBounds(310, 293, 50, 20);

        F3C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F3C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F3C1.setText("999");
        jPanel2.add(F3C1);
        F3C1.setBounds(20, 295, 40, 15);

        F4C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F4C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F4C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F4C2);
        F4C2.setBounds(70, 310, 190, 20);

        F4C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F4C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F4C3.setText("9999.99");
        jPanel2.add(F4C3);
        F4C3.setBounds(260, 310, 40, 20);

        F4C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F4C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F4C4.setText("9999.99");
        jPanel2.add(F4C4);
        F4C4.setBounds(310, 310, 50, 20);

        F5C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F5C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F5C1.setText("999");
        jPanel2.add(F5C1);
        F5C1.setBounds(20, 330, 40, 20);

        F5C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F5C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F5C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F5C2);
        F5C2.setBounds(70, 330, 190, 20);

        F5C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F5C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F5C3.setText("9999.99");
        jPanel2.add(F5C3);
        F5C3.setBounds(260, 330, 40, 20);

        F5C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F5C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F5C4.setText("9999.99");
        jPanel2.add(F5C4);
        F5C4.setBounds(310, 330, 50, 20);

        F6C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F6C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F6C1.setText("999");
        jPanel2.add(F6C1);
        F6C1.setBounds(20, 350, 40, 15);

        F6C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F6C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F6C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F6C2);
        F6C2.setBounds(70, 350, 190, 20);

        F6C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F6C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F6C3.setText("9999.99");
        jPanel2.add(F6C3);
        F6C3.setBounds(260, 350, 40, 20);

        F6C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F6C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F6C4.setText("9999.99");
        jPanel2.add(F6C4);
        F6C4.setBounds(310, 350, 50, 20);

        F7C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F7C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F7C1.setText("999");
        jPanel2.add(F7C1);
        F7C1.setBounds(20, 370, 40, 15);

        F7C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F7C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F7C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F7C2);
        F7C2.setBounds(70, 370, 190, 13);

        F7C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F7C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F7C3.setText("9999.99");
        jPanel2.add(F7C3);
        F7C3.setBounds(260, 370, 40, 20);

        F7C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F7C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F7C4.setText("9999.99");
        jPanel2.add(F7C4);
        F7C4.setBounds(310, 370, 50, 20);

        F9C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F9C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F9C1.setText("999");
        jPanel2.add(F9C1);
        F9C1.setBounds(20, 395, 40, 30);

        F9C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F9C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F9C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F9C2);
        F9C2.setBounds(70, 400, 190, 30);

        F9C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F9C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F9C3.setText("9999.99");
        jPanel2.add(F9C3);
        F9C3.setBounds(260, 400, 40, 30);

        F9C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F9C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F9C4.setText("9999.99");
        jPanel2.add(F9C4);
        F9C4.setBounds(310, 400, 50, 30);

        F10C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F10C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F10C1.setText("999");
        jPanel2.add(F10C1);
        F10C1.setBounds(20, 420, 40, 15);

        F10C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F10C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F10C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F10C2);
        F10C2.setBounds(70, 420, 190, 20);

        F10C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F10C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F10C3.setText("9999.99");
        jPanel2.add(F10C3);
        F10C3.setBounds(260, 420, 40, 20);

        F10C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F10C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F10C4.setText("9999.99");
        jPanel2.add(F10C4);
        F10C4.setBounds(310, 420, 50, 20);

        F11C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F11C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F11C1.setText("999");
        jPanel2.add(F11C1);
        F11C1.setBounds(20, 440, 40, 15);

        F11C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F11C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F11C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F11C2);
        F11C2.setBounds(70, 440, 190, 20);

        F11C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F11C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F11C3.setText("9999.99");
        jPanel2.add(F11C3);
        F11C3.setBounds(260, 440, 40, 20);

        F11C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F11C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F11C4.setText("9999.99");
        jPanel2.add(F11C4);
        F11C4.setBounds(310, 440, 50, 20);

        F12C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F12C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F12C1.setText("999");
        jPanel2.add(F12C1);
        F12C1.setBounds(20, 460, 40, 15);

        F12C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F12C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F12C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F12C2);
        F12C2.setBounds(70, 460, 190, 20);

        F12C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F12C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F12C3.setText("9999.99");
        jPanel2.add(F12C3);
        F12C3.setBounds(260, 460, 40, 20);

        F12C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F12C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F12C4.setText("9999.99");
        jPanel2.add(F12C4);
        F12C4.setBounds(310, 460, 50, 20);

        F8C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F8C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F8C1.setText("999");
        jPanel2.add(F8C1);
        F8C1.setBounds(20, 380, 40, 30);

        F8C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F8C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F8C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F8C2);
        F8C2.setBounds(70, 380, 190, 30);

        F8C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F8C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F8C3.setText("9999.99");
        jPanel2.add(F8C3);
        F8C3.setBounds(260, 390, 40, 13);

        F8C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F8C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F8C4.setText("9999.99");
        jPanel2.add(F8C4);
        F8C4.setBounds(310, 390, 50, 13);

        F13C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F13C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F13C1.setText("999");
        jPanel2.add(F13C1);
        F13C1.setBounds(20, 480, 40, 10);

        F13C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F13C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F13C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F13C2);
        F13C2.setBounds(70, 480, 190, 10);

        F13C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F13C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F13C3.setText("9999.99");
        jPanel2.add(F13C3);
        F13C3.setBounds(260, 480, 40, 10);

        F13C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F13C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F13C4.setText("9999.99");
        jPanel2.add(F13C4);
        F13C4.setBounds(310, 480, 50, 10);

        F14C1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        F14C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F14C1.setText("999");
        jPanel2.add(F14C1);
        F14C1.setBounds(20, 500, 40, 10);

        TOTALLETRAS.setBackground(new java.awt.Color(204, 204, 204));
        TOTALLETRAS.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        TOTALLETRAS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TOTALLETRAS.setText("MMMMMMMMMMMMMMMMMMMMMMMMMMM");
        jPanel2.add(TOTALLETRAS);
        TOTALLETRAS.setBounds(30, 530, 220, 20);

        F14C3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F14C3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F14C3.setText("9999.99");
        jPanel2.add(F14C3);
        F14C3.setBounds(260, 500, 40, 10);

        TOTAL.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        TOTAL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TOTAL.setText("9999.99");
        jPanel2.add(TOTAL);
        TOTAL.setBounds(310, 530, 50, 20);

        F14C2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F14C2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F14C2.setText("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        jPanel2.add(F14C2);
        F14C2.setBounds(70, 500, 190, 10);

        F14C4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        F14C4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F14C4.setText("9999.99");
        jPanel2.add(F14C4);
        F14C4.setBounds(310, 500, 50, 10);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 560, 650);

        setSize(new java.awt.Dimension(559, 645));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void Imprimir() {

        Bt_Imprimir.setVisible(false);
        PrinterJob print = PrinterJob.getPrinterJob();
        print.setPrintable(this);
        if (print.printDialog()==true) {
            try {
                
                if(IMPRESORA.Re_Impresion==false){
                print.print();
                Objects.Methods.Historial();
                Objects.Methods.GuardarDocumento(IMPRESORA.TablaImpresion);
                Objects.Parameters.setCorrelativo();
                }if(IMPRESORA.Re_Impresion==true){
                print.print();
                Objects.Parameters.ClenForm();
                IMPRESORA.Re_Impresion=false;
                }
                
            } catch (PrinterException e) {
            }
        } else {
            Objects.Methods.MessageDialog("SE CANCELO IMPRESION", "Printer");
        }

    }


    private void Bt_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_ImprimirActionPerformed


    }//GEN-LAST:event_Bt_ImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(AreaImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AreaImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AreaImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AreaImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AreaImpresion().setVisible(true);
            }
        });
    }

    @Override
    public int print(Graphics grphcs, PageFormat pf, int i) throws PrinterException {
        if (i == 0) {
            Graphics2D graphics2d = (Graphics2D) grphcs;
            graphics2d.translate(pf.getImageableX(), pf.getImageableY());
            printAll(graphics2d);
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Bt_Imprimir;
    public static javax.swing.JLabel Direccion;
    public static javax.swing.JLabel F10C1;
    public static javax.swing.JLabel F10C2;
    public static javax.swing.JLabel F10C3;
    public static javax.swing.JLabel F10C4;
    public static javax.swing.JLabel F11C1;
    public static javax.swing.JLabel F11C2;
    public static javax.swing.JLabel F11C3;
    public static javax.swing.JLabel F11C4;
    public static javax.swing.JLabel F12C1;
    public static javax.swing.JLabel F12C2;
    public static javax.swing.JLabel F12C3;
    public static javax.swing.JLabel F12C4;
    public static javax.swing.JLabel F13C1;
    public static javax.swing.JLabel F13C2;
    public static javax.swing.JLabel F13C3;
    public static javax.swing.JLabel F13C4;
    public static javax.swing.JLabel F14C1;
    public static javax.swing.JLabel F14C2;
    public static javax.swing.JLabel F14C3;
    public static javax.swing.JLabel F14C4;
    public static javax.swing.JLabel F1C1;
    public static javax.swing.JLabel F1C2;
    public static javax.swing.JLabel F1C3;
    public static javax.swing.JLabel F1C4;
    public static javax.swing.JLabel F2C1;
    public static javax.swing.JLabel F2C2;
    public static javax.swing.JLabel F2C3;
    public static javax.swing.JLabel F2C4;
    public static javax.swing.JLabel F3C1;
    public static javax.swing.JLabel F3C2;
    public static javax.swing.JLabel F3C3;
    public static javax.swing.JLabel F3C4;
    public static javax.swing.JLabel F4C1;
    public static javax.swing.JLabel F4C2;
    public static javax.swing.JLabel F4C3;
    public static javax.swing.JLabel F4C4;
    public static javax.swing.JLabel F5C1;
    public static javax.swing.JLabel F5C2;
    public static javax.swing.JLabel F5C3;
    public static javax.swing.JLabel F5C4;
    public static javax.swing.JLabel F6C1;
    public static javax.swing.JLabel F6C2;
    public static javax.swing.JLabel F6C3;
    public static javax.swing.JLabel F6C4;
    public static javax.swing.JLabel F7C1;
    public static javax.swing.JLabel F7C2;
    public static javax.swing.JLabel F7C3;
    public static javax.swing.JLabel F7C4;
    public static javax.swing.JLabel F8C1;
    public static javax.swing.JLabel F8C2;
    public static javax.swing.JLabel F8C3;
    public static javax.swing.JLabel F8C4;
    public static javax.swing.JLabel F9C1;
    public static javax.swing.JLabel F9C2;
    public static javax.swing.JLabel F9C3;
    public static javax.swing.JLabel F9C4;
    public static javax.swing.JLabel Nit;
    public static javax.swing.JLabel Nombre_1;
    public static javax.swing.JLabel Nombre_2;
    public static javax.swing.JLabel TOTAL;
    public static javax.swing.JLabel TOTALLETRAS;
    public static javax.swing.JLabel año;
    public static javax.swing.JLabel dia;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel mes;
    // End of variables declaration//GEN-END:variables
}
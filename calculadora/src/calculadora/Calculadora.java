/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package calculadora;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author aaron
 */
public class Calculadora extends javax.swing.JFrame {

    /**
     * Creates new form Calculadora
     */
    ScriptEngineManager sem = new ScriptEngineManager();
    ScriptEngine se = sem.getEngineByName("JavaScript");
    public Calculadora() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtOperacion = new javax.swing.JLabel();
        txtResultado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnEqual = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnPow = new javax.swing.JButton();
        btnResiduo = new javax.swing.JButton();
        btnDiv = new javax.swing.JButton();
        btnX = new javax.swing.JButton();
        btnMas = new javax.swing.JButton();
        btnMenos = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btnDot = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(244, 253, 251));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtOperacion.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        txtOperacion.setForeground(new java.awt.Color(0, 0, 0));
        txtOperacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(txtOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 340, 70));

        txtResultado.setFont(new java.awt.Font("Purisa", 1, 36)); // NOI18N
        txtResultado.setForeground(new java.awt.Color(0, 0, 0));
        txtResultado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(txtResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 88, 340, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 166));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEqual.setBackground(new java.awt.Color(255, 255, 255));
        btnEqual.setFont(new java.awt.Font("Purisa", 1, 36)); // NOI18N
        btnEqual.setForeground(new java.awt.Color(255, 255, 255));
        btnEqual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnEqual.setText("=");
        btnEqual.setFocusPainted(false);
        btnEqual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEqual.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btnEqual.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEqualActionPerformed(evt);
            }
        });
        jPanel2.add(btnEqual, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 50, 50));

        btn9.setBackground(new java.awt.Color(255, 255, 255));
        btn9.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btn9.setForeground(new java.awt.Color(0, 51, 51));
        btn9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn9.setText("9");
        btn9.setFocusPainted(false);
        btn9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn9.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel2.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 50, 50));

        btnPow.setBackground(new java.awt.Color(255, 255, 255));
        btnPow.setFont(new java.awt.Font("Purisa", 1, 16)); // NOI18N
        btnPow.setForeground(new java.awt.Color(0, 0, 0));
        btnPow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnPow.setText("CE");
        btnPow.setFocusPainted(false);
        btnPow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPow.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btnPow.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnPow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPowActionPerformed(evt);
            }
        });
        jPanel2.add(btnPow, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 50, 50));

        btnResiduo.setBackground(new java.awt.Color(255, 255, 255));
        btnResiduo.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btnResiduo.setForeground(new java.awt.Color(0, 51, 51));
        btnResiduo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnResiduo.setText("%");
        btnResiduo.setFocusPainted(false);
        btnResiduo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnResiduo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btnResiduo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnResiduo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResiduoActionPerformed(evt);
            }
        });
        jPanel2.add(btnResiduo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 50, 50));

        btnDiv.setBackground(new java.awt.Color(255, 255, 255));
        btnDiv.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btnDiv.setForeground(new java.awt.Color(0, 51, 51));
        btnDiv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnDiv.setText("/");
        btnDiv.setFocusPainted(false);
        btnDiv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDiv.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btnDiv.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivActionPerformed(evt);
            }
        });
        jPanel2.add(btnDiv, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 50, 50));

        btnX.setBackground(new java.awt.Color(255, 255, 255));
        btnX.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btnX.setForeground(new java.awt.Color(0, 51, 51));
        btnX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnX.setText("x");
        btnX.setFocusPainted(false);
        btnX.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnX.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btnX.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXActionPerformed(evt);
            }
        });
        jPanel2.add(btnX, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 50, 50));

        btnMas.setBackground(new java.awt.Color(255, 255, 255));
        btnMas.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btnMas.setForeground(new java.awt.Color(0, 51, 51));
        btnMas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnMas.setText("+");
        btnMas.setFocusPainted(false);
        btnMas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btnMas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasActionPerformed(evt);
            }
        });
        jPanel2.add(btnMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 50, 50));

        btnMenos.setBackground(new java.awt.Color(255, 255, 255));
        btnMenos.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btnMenos.setForeground(new java.awt.Color(0, 51, 51));
        btnMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnMenos.setText("-");
        btnMenos.setFocusPainted(false);
        btnMenos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMenos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btnMenos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });
        jPanel2.add(btnMenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 50, 50));

        btnC.setBackground(new java.awt.Color(255, 255, 255));
        btnC.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btnC.setForeground(new java.awt.Color(0, 51, 51));
        btnC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnC.setText("C");
        btnC.setFocusPainted(false);
        btnC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnC.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btnC.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });
        jPanel2.add(btnC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, 50));

        btn7.setBackground(new java.awt.Color(255, 255, 255));
        btn7.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btn7.setForeground(new java.awt.Color(0, 51, 51));
        btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn7.setText("7");
        btn7.setFocusPainted(false);
        btn7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn7.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel2.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 50, 50));

        btn8.setBackground(new java.awt.Color(255, 255, 255));
        btn8.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btn8.setForeground(new java.awt.Color(0, 51, 51));
        btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn8.setText("8");
        btn8.setFocusPainted(false);
        btn8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel2.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 50, 50));

        btn6.setBackground(new java.awt.Color(255, 255, 255));
        btn6.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btn6.setForeground(new java.awt.Color(0, 51, 51));
        btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn6.setText("6");
        btn6.setFocusPainted(false);
        btn6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn6.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel2.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 50, 50));

        btn5.setBackground(new java.awt.Color(255, 255, 255));
        btn5.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btn5.setForeground(new java.awt.Color(0, 51, 51));
        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn5.setText("5");
        btn5.setFocusPainted(false);
        btn5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel2.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 50, 50));

        btn4.setBackground(new java.awt.Color(255, 255, 255));
        btn4.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btn4.setForeground(new java.awt.Color(0, 51, 51));
        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn4.setText("4");
        btn4.setFocusPainted(false);
        btn4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel2.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 50, 50));

        btn3.setBackground(new java.awt.Color(255, 255, 255));
        btn3.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btn3.setForeground(new java.awt.Color(0, 51, 51));
        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn3.setText("3");
        btn3.setFocusPainted(false);
        btn3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 50, 50));

        btn2.setBackground(new java.awt.Color(255, 255, 255));
        btn2.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btn2.setForeground(new java.awt.Color(0, 51, 51));
        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn2.setText("2");
        btn2.setFocusPainted(false);
        btn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 50, 50));

        btn1.setBackground(new java.awt.Color(255, 255, 255));
        btn1.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btn1.setForeground(new java.awt.Color(0, 51, 51));
        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn1.setText("1");
        btn1.setFocusPainted(false);
        btn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 50, 50));

        btnDot.setBackground(new java.awt.Color(255, 255, 255));
        btnDot.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btnDot.setForeground(new java.awt.Color(0, 51, 51));
        btnDot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btnDot.setText(".");
        btnDot.setFocusPainted(false);
        btnDot.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDot.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btnDot.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btnDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDotActionPerformed(evt);
            }
        });
        jPanel2.add(btnDot, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 50, 50));

        btn0.setBackground(new java.awt.Color(255, 255, 255));
        btn0.setFont(new java.awt.Font("Purisa", 1, 24)); // NOI18N
        btn0.setForeground(new java.awt.Color(0, 51, 51));
        btn0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn0.setText("0");
        btn0.setFocusPainted(false);
        btn0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn0.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1.png"))); // NOI18N
        btn0.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btn1_pressed (1).png"))); // NOI18N
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        jPanel2.add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 130, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 340, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
        txtOperacion.setText("");
        txtResultado.setText("");
    }//GEN-LAST:event_btnCActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        addNumber("1");
                btnEqual.doClick();

    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        addNumber("2");
                btnEqual.doClick();

    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        addNumber("3");
                btnEqual.doClick();

    }//GEN-LAST:event_btn3ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        // TODO add your handling code here:
        addNumber("9");
                btnEqual.doClick();

    }//GEN-LAST:event_btn9ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
        addNumber("6");
                btnEqual.doClick();

    }//GEN-LAST:event_btn6ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
        addNumber("5");
                btnEqual.doClick();

    }//GEN-LAST:event_btn5ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        addNumber("4");
                btnEqual.doClick();

    }//GEN-LAST:event_btn4ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
        addNumber("8");
                btnEqual.doClick();

    }//GEN-LAST:event_btn8ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
        addNumber("7");
                btnEqual.doClick();

    }//GEN-LAST:event_btn7ActionPerformed

    private void btnPowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPowActionPerformed
        // TODO add your handling code here:
        String texto = txtOperacion.getText().substring(0, txtOperacion.getText().length()-1);
       txtOperacion.setText(texto);
        btnEqual.doClick();
                

    }//GEN-LAST:event_btnPowActionPerformed

    private void btnResiduoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResiduoActionPerformed
        // TODO add your handling code here:
        addNumber("%");
             

    }//GEN-LAST:event_btnResiduoActionPerformed

    private void btnDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivActionPerformed
        // TODO add your handling code here:
        addNumber("/");
              

    }//GEN-LAST:event_btnDivActionPerformed

    private void btnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXActionPerformed
        // TODO add your handling code here:
        addNumber("*");
          

    }//GEN-LAST:event_btnXActionPerformed

    private void btnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasActionPerformed
        // TODO add your handling code here:
        addNumber("+");
              

    }//GEN-LAST:event_btnMasActionPerformed

    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
        // TODO add your handling code here:
        addNumber("-");
              

    }//GEN-LAST:event_btnMenosActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        // TODO add your handling code here:
        addNumber("0");
                btnEqual.doClick();

    }//GEN-LAST:event_btn0ActionPerformed

    private void btnDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDotActionPerformed
        // TODO add your handling code here:
        addNumber(".");
       
    }//GEN-LAST:event_btnDotActionPerformed

    private void btnEqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEqualActionPerformed
        // TODO add your handling code here:
        try{
            String Resultado= se.eval(txtOperacion.getText()).toString();
            txtResultado.setText(Resultado);
        }catch(Exception e){
                        txtResultado.setText("ERROR");

        }
        
    }//GEN-LAST:event_btnEqualActionPerformed

       public void addNumber(String digito){
           txtOperacion.setText(txtOperacion.getText()+digito);
       }
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
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnDiv;
    private javax.swing.JButton btnDot;
    private javax.swing.JButton btnEqual;
    private javax.swing.JButton btnMas;
    private javax.swing.JButton btnMenos;
    private javax.swing.JButton btnPow;
    private javax.swing.JButton btnResiduo;
    private javax.swing.JButton btnX;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtOperacion;
    private javax.swing.JLabel txtResultado;
    // End of variables declaration//GEN-END:variables
}

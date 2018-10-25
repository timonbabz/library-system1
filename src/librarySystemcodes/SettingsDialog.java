/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarySystemcodes;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class SettingsDialog extends javax.swing.JDialog {

    /**
     * Creates new form SettingsDialog
     */
    Connection con = null;
    Connection cons = null;
    Statement statement = null;
    
    public static String schoolNameid;
    public SettingsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSet = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnCancelSet = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSetNumbers = new javax.swing.JButton();
        spinStudents = new javax.swing.JTextField();
        spinStaff = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textStudentDays = new javax.swing.JTextField();
        textStaffDays = new javax.swing.JTextField();
        jbtnClearDays = new javax.swing.JButton();
        btnSetDays = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        txtSetName = new javax.swing.JTextField();
        btnSet = new javax.swing.JButton();
        jbtnExitSettings = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Library Management System");

        panelSet.setBackground(new java.awt.Color(129, 186, 243));

        jPanel3.setBackground(new java.awt.Color(129, 186, 243));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Maximum books allowed per borrower", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        btnCancelSet.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnCancelSet.setText("Clear");
        btnCancelSet.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnCancelSet.setContentAreaFilled(false);
        btnCancelSet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelSetActionPerformed(evt);
            }
        });

        jLabel4.setText("Maximum number of books borrowed by staff :");

        jLabel3.setText("Maximum number of books borrowed by student :");

        btnSetNumbers.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSetNumbers.setText("Set");
        btnSetNumbers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnSetNumbers.setContentAreaFilled(false);
        btnSetNumbers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSetNumbers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetNumbersActionPerformed(evt);
            }
        });

        spinStudents.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spinStudentsKeyTyped(evt);
            }
        });

        spinStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spinStaffKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spinStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(spinStudents))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSetNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelSet, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spinStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSetNumbers, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(btnCancelSet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(129, 186, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Maximum number of days allowable (needs system restart)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel5.setText("Maximum number of days allowable for  a student:");

        jLabel6.setText("Maximum number of days allowed for staff :");

        textStudentDays.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textStudentDaysKeyTyped(evt);
            }
        });

        textStaffDays.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textStaffDaysKeyTyped(evt);
            }
        });

        jbtnClearDays.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbtnClearDays.setText("Clear");
        jbtnClearDays.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jbtnClearDays.setContentAreaFilled(false);
        jbtnClearDays.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnClearDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClearDaysActionPerformed(evt);
            }
        });

        btnSetDays.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSetDays.setText("Set");
        btnSetDays.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnSetDays.setContentAreaFilled(false);
        btnSetDays.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSetDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetDaysActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSetDays, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnClearDays, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textStaffDays)
                            .addComponent(textStudentDays, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textStudentDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textStaffDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSetDays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnClearDays, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(129, 186, 243));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Set school name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        btnCancel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnCancel.setText("Clear");
        btnCancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnCancel.setContentAreaFilled(false);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtSetName.setBackground(new java.awt.Color(204, 204, 204));
        txtSetName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSetNameMouseClicked(evt);
            }
        });

        btnSet.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSet.setText("Set");
        btnSet.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnSet.setContentAreaFilled(false);
        btnSet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSetName)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 227, Short.MAX_VALUE)
                        .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jbtnExitSettings.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbtnExitSettings.setText("Exit");
        jbtnExitSettings.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jbtnExitSettings.setContentAreaFilled(false);
        jbtnExitSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnExitSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitSettingsActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(129, 186, 243));
        jButton2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton2.setText("Reset all fields");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton2.setContentAreaFilled(false);

        javax.swing.GroupLayout panelSetLayout = new javax.swing.GroupLayout(panelSet);
        panelSet.setLayout(panelSetLayout);
        panelSetLayout.setHorizontalGroup(
            panelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSetLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnExitSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelSetLayout.setVerticalGroup(
            panelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnExitSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
        jLabel1.setText("Settings Box");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetActionPerformed
        settingsMethod();
    }//GEN-LAST:event_btnSetActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        txtSetName.setText("");
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSetNumbersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetNumbersActionPerformed
        if(spinStudents.getText().isEmpty())
        {JOptionPane.showMessageDialog(null, "Please enter the maximum for students first");
        spinStudents.requestFocus();}
        else if (spinStaff.getText().isEmpty())
        {JOptionPane.showMessageDialog(null, "Please enter the maximum for staff first");
        spinStaff.requestFocus();}
        else{bookCountStaff();
        bookCountStudent();}
    }//GEN-LAST:event_btnSetNumbersActionPerformed

    private void btnCancelSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelSetActionPerformed
        spinStudents.setText("");
        spinStaff.setText("");
    }//GEN-LAST:event_btnCancelSetActionPerformed

    private void spinStudentsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spinStudentsKeyTyped
        spinStudents.setForeground(Color.black);
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();}
    }//GEN-LAST:event_spinStudentsKeyTyped

    private void spinStaffKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spinStaffKeyTyped
        spinStaff.setForeground(Color.black);
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();}
    }//GEN-LAST:event_spinStaffKeyTyped

    private void jbtnExitSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitSettingsActionPerformed
       dispose();
    }//GEN-LAST:event_jbtnExitSettingsActionPerformed

    private void textStudentDaysKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textStudentDaysKeyTyped
        textStudentDays.setForeground(Color.black);
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();}
    }//GEN-LAST:event_textStudentDaysKeyTyped

    private void textStaffDaysKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textStaffDaysKeyTyped
        textStaffDays.setForeground(Color.black);
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();}
    }//GEN-LAST:event_textStaffDaysKeyTyped

    private void btnSetDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetDaysActionPerformed
        if(textStudentDays.getText().isEmpty())
        {JOptionPane.showMessageDialog(null, "Please enter the number of days for students first");
        textStudentDays.requestFocus();}
        else if(textStaffDays.getText().isEmpty())
        {JOptionPane.showMessageDialog(null, "Please enter the number of days for staff first");
        textStaffDays.requestFocus();}
        else{daysCountStudent();
            daysCountStaff();}
    }//GEN-LAST:event_btnSetDaysActionPerformed

    private void jbtnClearDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClearDaysActionPerformed
        textStudentDays.setText("");
        textStaffDays.setText("");
    }//GEN-LAST:event_jbtnClearDaysActionPerformed

    private void txtSetNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSetNameMouseClicked
        if(!LibrarySignIn.usernameLabel.equalsIgnoreCase("Support Team")){
            txtSetName.setEditable(false);
            JOptionPane.showMessageDialog(null, "Operation not allowed for current user, contact support team");
        }else{
        txtSetName.setEditable(true);}
    }//GEN-LAST:event_txtSetNameMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            SettingsDialog dialog = new SettingsDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    
    //-----------------method to set name of school to the labels---------------
    public void settingsMethod(){
        
            String strSchoolId = txtSetName.getText();
            
            if(strSchoolId.isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter School name to set");
            }
            //end of if statement
            else{
                            try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
                statement = con.createStatement();

                // SQL Insert
                String sql = "UPDATE school_name_db SET school_name ='" + strSchoolId + "' WHERE school_id = 1";
                
                statement.execute(sql);
      
                JOptionPane.showMessageDialog(null, "School name set successfuly");

                // Reset Text Fields
                txtSetName.setText("");

                //status  = true;
            } catch (ClassNotFoundException | SQLException | HeadlessException es) {
                // TODO Auto-generated catch block
                JOptionPane.showMessageDialog(null, "Unable to add");
                JOptionPane.showMessageDialog(null, es.getMessage());
            }
            
            try {
                if (statement != null) {
                    statement.close();
                    con.close();
                }
            } catch (SQLException es) {
                JOptionPane.showMessageDialog(null, es.getMessage());
            }
            
        //end of else statement
            }
    }
    
    public void bookCountStaff(){
        
            String bookCount = spinStaff.getText();
            int noCount = Integer.parseInt(bookCount);
            
            if(noCount > 100){
            JOptionPane.showMessageDialog(null, "Maximum cannot be greater than 100 for staff");
            spinStaff.setForeground(Color.red);}
            else if(noCount <= 1){
            JOptionPane.showMessageDialog(null, "Minimum cannot be set to 1 or less for staff");
            spinStaff.setForeground(Color.red);}
            else{
                            try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
                statement = con.createStatement();

                // SQL Insert
                String sql = "UPDATE maxstaff SET number_set ='" + bookCount + "' WHERE id = 1";
                
                statement.execute(sql);
      
                JOptionPane.showMessageDialog(null, "Maximum allowable for staff set successfuly as "+bookCount);

                // Reset Text Fields
                spinStaff.setText("1");

                //status  = true;
            } catch (ClassNotFoundException | SQLException | HeadlessException es) {
                // TODO Auto-generated catch block
                JOptionPane.showMessageDialog(null, "Unable to set");
                JOptionPane.showMessageDialog(null, es.getMessage());
            }
            
            try {
                if (statement != null) {
                    statement.close();
                    con.close();
                }
            } catch (SQLException es) {
                JOptionPane.showMessageDialog(null, es.getMessage());
            }
            
        //end of else statement
            }
    }
        
    public void bookCountStudent(){
        
            String bookCount = spinStudents.getText();
            int noCount = Integer.parseInt(bookCount);
            
            if(noCount <= 1){
            JOptionPane.showMessageDialog(null, "Minimum cannot be set to 1 or less for students");
            spinStudents.setForeground(Color.red);
            }
            else if(noCount > 100){
            JOptionPane.showMessageDialog(null, "Maximum cannot be more than 100 for students");
            spinStudents.setForeground(Color.red);}
            else{
                try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
                statement = con.createStatement();

                // SQL Insert
                String sql = "UPDATE maxstudent SET number_set ='" + bookCount + "' WHERE id = 1";
                
                statement.execute(sql);
      
                JOptionPane.showMessageDialog(null, "Maximum allowable for students set successfuly as "+bookCount);

                // Reset Text Fields
                spinStudents.setText("1");

                //status  = true;
            } catch (ClassNotFoundException | SQLException | HeadlessException es) {
                JOptionPane.showMessageDialog(null, "Unable to set");
                JOptionPane.showMessageDialog(null, es.getMessage());
            }
            
            try {
                if (statement != null) {
                    statement.close();
                    con.close();
                }
            } catch (SQLException es) {
                JOptionPane.showMessageDialog(null, es.getMessage());
            }
            
        //end of else statement
            }
    }
    
    public void daysCountStudent(){
        
            String bookdays = textStudentDays.getText();
            int noCount = Integer.parseInt(bookdays);
            
            if(noCount <= 1){
            JOptionPane.showMessageDialog(null, "Minimum days cannot be set to 1 or less for students");
            textStudentDays.setForeground(Color.red);
            }
            else if(noCount > 90){
            JOptionPane.showMessageDialog(null, "Maximum days cannot be more than 90 for students");
            textStudentDays.setForeground(Color.red);}
            else{
                try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
                statement = con.createStatement();

                // SQL Insert
                String sql = "UPDATE daystudents SET days_set ='" + bookdays + "' WHERE day_id = 1";
                
                statement.execute(sql);
      
                JOptionPane.showMessageDialog(null, "Maximum allowable days for students set successfuly as "+bookdays);

                // Reset Text Fields
                textStudentDays.setText("1");

                //status  = true;
            } catch (ClassNotFoundException | SQLException | HeadlessException es) {
                JOptionPane.showMessageDialog(null, "Unable to set");
                JOptionPane.showMessageDialog(null, es.getMessage());
            }
            
            try {
                if (statement != null) {
                    statement.close();
                    con.close();
                }
            } catch (SQLException es) {
                JOptionPane.showMessageDialog(null, es.getMessage());
            }
            
        //end of else statement
            }
    }
    
    public void daysCountStaff(){
        
            String bookCount = textStaffDays.getText();
            int noCount = Integer.parseInt(bookCount);
            
            if(noCount <= 1){
            JOptionPane.showMessageDialog(null, "Minimum cannot be set to 1 or less for staff");
            textStaffDays.setForeground(Color.red);
            }
            else if(noCount > 100){
            JOptionPane.showMessageDialog(null, "Maximum cannot be more than 100 for staff");
            textStaffDays.setForeground(Color.red);}
            else{
                try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
                statement = con.createStatement();

                // SQL Insert
                String sql = "UPDATE daysstaff SET days_set ='" + bookCount + "' WHERE day_id = 1";
                
                statement.execute(sql);
      
                JOptionPane.showMessageDialog(null, "Maximum allowable for staff set successfuly as "+bookCount);

                // Reset Text Fields
                textStaffDays.setText("1");

                //status  = true;
            } catch (ClassNotFoundException | SQLException | HeadlessException es) {
                JOptionPane.showMessageDialog(null, "Unable to set");
                JOptionPane.showMessageDialog(null, es.getMessage());
            }
            
            try {
                if (statement != null) {
                    statement.close();
                    con.close();
                }
            } catch (SQLException es) {
                JOptionPane.showMessageDialog(null, es.getMessage());
            }
            
        //end of else statement
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelSet;
    private javax.swing.JButton btnSet;
    private javax.swing.JButton btnSetDays;
    private javax.swing.JButton btnSetNumbers;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jbtnClearDays;
    private javax.swing.JButton jbtnExitSettings;
    private javax.swing.JPanel panelSet;
    private javax.swing.JTextField spinStaff;
    private javax.swing.JTextField spinStudents;
    private javax.swing.JTextField textStaffDays;
    private javax.swing.JTextField textStudentDays;
    private javax.swing.JTextField txtSetName;
    // End of variables declaration//GEN-END:variables
}
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author TimonBabz
 */
public final class DialogEditStudentList extends javax.swing.JDialog {

    /**
     * Creates new form DialogEditStudentList
     * @param parent
     * @param modal
     */
    public DialogEditStudentList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadcomboStream();
        loadcomboForm();
        
        txtAdmnNo.setText(LibraryHome.admissionNo1);
        txtFname.setText(LibraryHome.stdFnameList1);
        txtLname.setText(LibraryHome.stdLnameList1);
        lblForm.setText(LibraryHome.stdFormList1);
        txtStatus.setText(LibraryHome.stdStatus1);
        
        if(txtStatus.getText().equals("Active")){
            txtStatus.setBackground(Color.CYAN);
        }else{
        txtStatus.setForeground(Color.WHITE);
        txtStatus.setBackground(Color.red);}
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelListUpdate = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelAdm = new javax.swing.JLabel();
        txtAdmnNo = new javax.swing.JTextField();
        labelFname = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        labelLname = new javax.swing.JLabel();
        txtLname = new javax.swing.JTextField();
        labelForm = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        labelCombobox = new javax.swing.JLabel();
        comboUpdate = new javax.swing.JComboBox();
        labelStatus = new javax.swing.JLabel();
        btnUpdateList = new javax.swing.JButton();
        btnCancelUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblForm = new javax.swing.JLabel();
        boxForm = new javax.swing.JComboBox();
        boxStream = new javax.swing.JComboBox();
        txtFormSelect = new javax.swing.JTextField();
        txtStreamSelect = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Library Management System");
        setResizable(false);

        panelListUpdate.setBackground(new java.awt.Color(129, 186, 243));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
        jLabel1.setText("Edit Student Details");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelAdm.setText("Admission number:");

        txtAdmnNo.setEditable(false);

        labelFname.setText("First name:");

        labelLname.setText("Second name:");

        labelForm.setText("Form:");

        txtStatus.setEditable(false);

        labelCombobox.setText("Update Student status:");

        comboUpdate.setBackground(new java.awt.Color(255, 255, 255));
        comboUpdate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Closed" }));
        comboUpdate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboUpdateItemStateChanged(evt);
            }
        });

        labelStatus.setText("Student status:");

        btnUpdateList.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnUpdateList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save_16.png"))); // NOI18N
        btnUpdateList.setText("Update");
        btnUpdateList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnUpdateList.setContentAreaFilled(false);
        btnUpdateList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateList.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Savewhite_16.png"))); // NOI18N
        btnUpdateList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateListActionPerformed(evt);
            }
        });

        btnCancelUpdate.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnCancelUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelblack_16.png"))); // NOI18N
        btnCancelUpdate.setText("Cancel");
        btnCancelUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnCancelUpdate.setContentAreaFilled(false);
        btnCancelUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelUpdate.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelred_16.png"))); // NOI18N
        btnCancelUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelUpdateActionPerformed(evt);
            }
        });

        jLabel2.setText("Stream :");

        jLabel3.setText("Current form and stream :");

        lblForm.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblForm.setText("form");

        boxForm.setBackground(new java.awt.Color(255, 255, 255));
        boxForm.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxFormItemStateChanged(evt);
            }
        });

        boxStream.setBackground(new java.awt.Color(255, 255, 255));
        boxStream.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxStreamItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelListUpdateLayout = new javax.swing.GroupLayout(panelListUpdate);
        panelListUpdate.setLayout(panelListUpdateLayout);
        panelListUpdateLayout.setHorizontalGroup(
            panelListUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelListUpdateLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelListUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelListUpdateLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtFormSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelListUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelListUpdateLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(labelAdm)
                        .addComponent(labelFname)
                        .addComponent(txtAdmnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelLname)
                        .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelListUpdateLayout.createSequentialGroup()
                            .addGroup(panelListUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelForm)
                                .addComponent(boxForm, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panelListUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(boxStream, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelListUpdateLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(txtStreamSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelListUpdateLayout.createSequentialGroup()
                        .addGroup(panelListUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelListUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelCombobox)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelStatus))
                            .addComponent(btnUpdateList, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(btnCancelUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelListUpdateLayout.setVerticalGroup(
            panelListUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAdm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAdmnNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelLname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(panelListUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblForm))
                .addGap(9, 9, 9)
                .addGroup(panelListUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForm)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelListUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxStream, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelListUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFormSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStreamSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStatus)
                .addGap(3, 3, 3)
                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(labelCombobox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelListUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateList, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelListUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelListUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateListActionPerformed
        if(txtAdmnNo.getText().equals(""))
        {JOptionPane.showMessageDialog(null, "please enter the admission number");
        txtAdmnNo.requestFocus();}
        else if(txtFname.getText().equals(""))
        {JOptionPane.showMessageDialog(null, "please enter first name");
        txtFname.requestFocus();}
        else if(txtLname.getText().equals(""))
        {JOptionPane.showMessageDialog(null, "please enter last name");
        txtLname.requestFocus();}
        else if(txtFormSelect.getText().equals("") || txtFormSelect.getText().equalsIgnoreCase("default"))
        {JOptionPane.showMessageDialog(null, "please select form");}
        else if(txtStreamSelect.getText().equals("") || txtStreamSelect.getText().equalsIgnoreCase("default"))
        {JOptionPane.showMessageDialog(null, "please select stream");}
        else{updatestudentDetails();
             updateSubIdStudent();}
    }//GEN-LAST:event_btnUpdateListActionPerformed

    private void comboUpdateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboUpdateItemStateChanged
        String studentStatus = (String) comboUpdate.getSelectedItem();
        if(txtStatus.getText().equals("Active")){
            txtStatus.setForeground(Color.BLACK);
            txtStatus.setBackground(Color.CYAN);
            txtStatus.setText(studentStatus);
        }else{
        txtStatus.setForeground(Color.WHITE);
        txtStatus.setBackground(Color.red);
        txtStatus.setText(studentStatus);}
    }//GEN-LAST:event_comboUpdateItemStateChanged

    private void btnCancelUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelUpdateActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelUpdateActionPerformed

    private void boxFormItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxFormItemStateChanged
        String formNo = (String) boxForm.getSelectedItem();
        txtFormSelect.setText(formNo);
    }//GEN-LAST:event_boxFormItemStateChanged

    private void boxStreamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxStreamItemStateChanged
        String streamNo = (String) boxStream.getSelectedItem();
        txtStreamSelect.setText(streamNo);
    }//GEN-LAST:event_boxStreamItemStateChanged

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
            java.util.logging.Logger.getLogger(DialogEditStudentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogEditStudentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogEditStudentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogEditStudentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DialogEditStudentList dialog = new DialogEditStudentList(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    
    public void updatestudentDetails() { 
        
            String studentStatus = (String) comboUpdate.getSelectedItem();
            String student = "STUDENT";
            try {
                String url = "jdbc:mysql://localhost/libdb?useSSL = false";
                Connection conn;
                conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
               
                //--------update student db-----------
                String sql = "UPDATE student_list SET adm_no='" + txtAdmnNo.getText() + "',"
                        + "std_fname='" + txtFname.getText().toUpperCase() + "' ,std_lname='" + txtLname.getText().toUpperCase() + "',"
                        + " form='"+ txtFormSelect.getText().toUpperCase() +"', stream_name='"+ txtStreamSelect.getText().toUpperCase() +"',status='"+ studentStatus +"' WHERE (adm_no='"+ txtAdmnNo.getText() +"')";
                
                PreparedStatement pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                String sql2 = "UPDATE student_db SET std_fname='" + txtFname.getText().toUpperCase() + "' ,std_lname='" + txtLname.getText().toUpperCase() + "',"
                        + " form='"+ txtFormSelect.getText().toUpperCase() +"', stream_name='"+ txtStreamSelect.getText().toUpperCase() +"'  WHERE (adm_no='"+ txtAdmnNo.getText() +"')";
                
                PreparedStatement pst2 = null;
                pst2 = conn.prepareStatement(sql2);
                pst2.execute();
                
                String sql3 = "UPDATE books_db SET name1_of_borrower='" + txtFname.getText().toUpperCase() + "' ,name2_of_borrower='" + txtLname.getText().toUpperCase() + "' WHERE (borrowed_by_id='"+ txtAdmnNo.getText() +"')";
                
                PreparedStatement pst3 = null;
                pst3 = conn.prepareStatement(sql3);
                pst3.execute();
                
                String sql4 = "UPDATE borrowers_db SET borrower_name1='" + txtFname.getText().toUpperCase() + "' ,borrower_name2='" + txtLname.getText().toUpperCase() + "' WHERE (borrower_id='"+ txtAdmnNo.getText() +"' AND student_staff='"+student+"')";
                
                PreparedStatement pst4 = null;
                pst4 = conn.prepareStatement(sql4);
                pst4.execute();
                //-----clear text fields after above------------
                
                JOptionPane.showMessageDialog(null, "Student record updated");
                txtAdmnNo.setText("");
                txtFname.setText("");
                txtLname.setText("");
                txtFormSelect.setText("");
                txtStreamSelect.setText("");
                dispose();

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }
    
    public void loadcomboForm() {
    try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/libdb", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT form FROM form");
            ResultSet rs = st.executeQuery();
            while(rs.next()){                            
                boxForm.addItem(rs.getString("form"));
                }
            con.close();
            }
        catch(Exception e)
        {
            //System.out.println("Error"+e);
        }    
}
    
    public void loadcomboStream() {
    try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/libdb", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT stream_n FROM stream");
            ResultSet rs = st.executeQuery();
            while(rs.next()){                            
                boxStream.addItem(rs.getString("stream_n"));
                }
            con.close();
            }
        catch(Exception e)
        {
            //System.out.println("Error"+e);
        }    
}
    
            public void updateSubIdStudent(){
        
            try {
            String url = "jdbc:mysql://localhost/libdb?useSSL = false";
            Connection conn;
            conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
            //UPDATE users_db SET dep_id = (SELECT dept_id FROM depart WHERE users_db.department = depart.dept_name)
            //--------update users db-----------
            String sql1 = "UPDATE student_list SET stream_id = (SELECT str_id FROM stream WHERE student_list.stream_name = stream.stream_n)";
            
            PreparedStatement pst1 = null;
            pst1 = conn.prepareStatement(sql1);
            pst1.execute();
            
            String sql2 = "UPDATE student_db SET stream_id = (SELECT str_id FROM stream WHERE student_db.stream_name = stream.stream_n)";
            
            PreparedStatement pst2 = null;
            pst2 = conn.prepareStatement(sql2);
            pst2.execute();
            
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxForm;
    private javax.swing.JComboBox boxStream;
    private javax.swing.JButton btnCancelUpdate;
    private javax.swing.JButton btnUpdateList;
    private javax.swing.JComboBox comboUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelAdm;
    private javax.swing.JLabel labelCombobox;
    private javax.swing.JLabel labelFname;
    private javax.swing.JLabel labelForm;
    private javax.swing.JLabel labelLname;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel lblForm;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelListUpdate;
    private javax.swing.JTextField txtAdmnNo;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtFormSelect;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtStreamSelect;
    // End of variables declaration//GEN-END:variables
}

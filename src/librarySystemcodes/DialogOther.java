/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarySystemcodes;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TimonBabz
 */
public final class DialogOther extends javax.swing.JDialog {

    /**
     * Creates new form DialogOther
     */
    
    Statement statement = null;
    Connection con = null;
    
    public static String catNo1, catname1;
    
    public static String catNo = "", catname = "";
    String[] columnNames = {"Category ID", "Category name"};
    DefaultTableModel catModel = new DefaultTableModel();
    
    public DialogOther(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        displayCategories();
        txtUpCatName.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtCatName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCat = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtUpCatName = new javax.swing.JTextField();
        txtCatId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Library Management System");

        jPanel1.setBackground(new java.awt.Color(129, 186, 243));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
        jLabel1.setText("Set book category names");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(129, 186, 243));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2), "Enter new category name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        btnSave.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save_16.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnSave.setContentAreaFilled(false);
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tableCat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCat);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(txtCatName, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCatName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Editwhite_16.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelblack_16.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        txtUpCatName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUpCatNameFocusGained(evt);
            }
        });

        txtCatId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCatIdKeyTyped(evt);
            }
        });

        jLabel7.setText("Enter category ID to edit :");

        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
        btnFind.setText("Find");
        btnFind.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnFind.setContentAreaFilled(false);
        btnFind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jLabel2.setText("Edit :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCatId, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUpCatName, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCatId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUpCatName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(txtCatName.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Type in new category first");
        txtCatName.requestFocus();}
        else{
        addCategory();
        refreshListOnTitle();}
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tableCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCatMouseClicked
        int row = tableCat.getSelectedRow();
        catNo1 = (String) tableCat.getModel().getValueAt(row, 0);
        catname1 = (String) tableCat.getModel().getValueAt(row, 1);
    }//GEN-LAST:event_tableCatMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int identered = Integer.parseInt(txtCatId.getText().trim());
        if(txtCatId.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Please enter the category ID");}
        else if(identered == 1){
        JOptionPane.showMessageDialog(null, "Default cannot be edited");
        txtCatId.setText("");
        txtUpCatName.setText("");}
        else{
        CheckCompExistsUpdate();}
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if(txtCatId.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Please enter the category ID");}
        else{
        retrievecatDetails();}
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtCatIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCatIdKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }else{txtUpCatName.setEnabled(true);}
    }//GEN-LAST:event_txtCatIdKeyTyped

    private void txtUpCatNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUpCatNameFocusGained
        if(txtCatId.getText().isEmpty()){
            txtCatId.requestFocus();
            JOptionPane.showMessageDialog(null, "Enter the category id, see from table");
        }
    }//GEN-LAST:event_txtUpCatNameFocusGained

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
            java.util.logging.Logger.getLogger(DialogOther.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogOther.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogOther.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogOther.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DialogOther dialog = new DialogOther(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    
    public void refreshListOnTitle(){
    while(catModel.getRowCount() != 0){
        catModel.removeRow(0);}
    displayCategories();
}

    public void addCategory(){
    
        String catText = txtCatName.getText().trim();
        
                try {
                    Class.forName("com.mysql.jdbc.Driver");

                    con = DriverManager.getConnection("jdbc:mysql://localhost/libdb", "root", "libsystem@dmin");
                    statement = con.createStatement();

                    // SQL Insert
                    String sql = "INSERT INTO bookcat_table " + "(cat_name)"
                            + "VALUES ('" + catText+ "') ";
                    
                    statement.execute(sql);

                    JOptionPane.showMessageDialog(null, "Book category | "+catText+" |, added successfully");

                    // Reset Text Fields
                    txtCatName.setText("");
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
        //end of if statement that validate the form
}
    
    public void displayCategories() {

        catModel.setColumnIdentifiers(columnNames);

        tableCat.setModel(catModel);

        tableCat.setFillsViewportHeight(true);
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libdb", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  cat_id,cat_name FROM bookcat_table");
            ResultSet rsIssue = st.executeQuery();

            int i = 0;
            while (rsIssue.next()) {
                catNo = rsIssue.getString("cat_id");
                catname = rsIssue.getString("cat_name");

                catModel.addRow(new Object[]{catNo, catname});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}
    
    public void retrievecatDetails() {
    
            String catIdSe = txtCatId.getText().trim();
            try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT cat_name FROM bookcat_table WHERE (cat_id='"+ catIdSe +"')");
            ResultSet rs = st.executeQuery();
            boolean emptyRs = true;
            if (rs.next()) {
                emptyRs = false;
                String bookretSysid = rs.getString("cat_name");
                txtUpCatName.setText(bookretSysid);
                
            }
            if (emptyRs) {
                JOptionPane.showMessageDialog(null, "No Record");
                txtUpCatName.setText("");
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            //JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        
    }
    
    public void updateCategory(){
        
        String newCatname = txtUpCatName.getText();
        String catIdS = txtCatId.getText().trim();
        
        if(txtUpCatName.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter the category name");}
        else if(txtCatId.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter the category id, see from table");}
        else{
                try {
            String url = "jdbc:mysql://localhost/libdb?useSSL = false";
            Connection conn;
            conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
            
            //--------update users db-----------
            String sql = "UPDATE bookcat_table SET cat_name='" + newCatname + "' WHERE cat_id=" + catIdS;
            
            PreparedStatement pst;
            pst = null;
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated successfully");
            refreshListOnTitle();
            
        txtUpCatName.setText("");
        txtCatId.setText("");
            
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Duplicate entry");
            }
        }
    }
    
     public void CheckCompExistsUpdate(){
 
        String enteredUser = txtCatId.getText().trim();

        try
        {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");

            PreparedStatement st = connection.prepareStatement("SELECT* FROM bookcat_table WHERE cat_id='" + enteredUser + "'");
            ResultSet r1=st.executeQuery();

             if(r1.next()) 
             {
               updateCategory();
             }else{
                 JOptionPane.showMessageDialog(null, "Entered category ID does not exist");
             txtCatId.requestFocus();}
         }

         catch (SQLException | ClassNotFoundException e) 
         {
            JOptionPane.showMessageDialog(null, e.getMessage());
         }

 }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCat;
    private javax.swing.JTextField txtCatId;
    private javax.swing.JTextField txtCatName;
    private javax.swing.JTextField txtUpCatName;
    // End of variables declaration//GEN-END:variables
}

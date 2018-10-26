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
public final class ReceiveMainDialog extends javax.swing.JDialog {

    Connection con = null;
    Statement statement = null;
    String select = null;
    
    public static String  bookId2, bookIsbn2,author2,title2,publisher2, shelf2, edition2, category2, compname2, date2;
    
    public static String bookId1 = "", bookIsbn1 = "",author1 = "",title1 = "",publisher1 = "", shelf1 = "", edition1 = "", category1 = "", compname1= "", date1= "";
    String[] columnNames = {"Book ID", "Book ISBN", "Author", "Title", "Publisher", "Shelf", "Edition", "Category", "Company", "Date of Issue"};
    DefaultTableModel compModel = new DefaultTableModel();
    /**
     * Creates new form ReceiveMainDialog
     * @param parent
     * @param modal
     */
    public ReceiveMainDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadcombo();
        refreshListOnT();
        numberOf();
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReceiveDam = new javax.swing.JTable();
        comboName = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBookId = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtBookSelect = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        txtCount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Library Management System");

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        tableReceiveDam.setModel(new javax.swing.table.DefaultTableModel(
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
        tableReceiveDam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableReceiveDamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableReceiveDam);

        comboName.setBackground(new java.awt.Color(255, 255, 255));
        comboName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        comboName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboNameItemStateChanged(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Addblack_16.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add_16.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Receive back selected (1) :");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select company issued to :");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
        jLabel4.setText("View Books issued for maintenance");

        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchwhite_16.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book ID :");

        txtBookSelect.setEditable(false);
        txtBookSelect.setBackground(new java.awt.Color(204, 204, 204));

        jButton4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ok_16.png"))); // NOI18N
        jButton4.setText("Confirm");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Okwhite_16.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtCount.setEditable(false);
        txtCount.setBackground(new java.awt.Color(102, 102, 102));
        txtCount.setForeground(new java.awt.Color(255, 255, 255));
        txtCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Records found");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBookId, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboName, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCount, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBookSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtBookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(txtBookSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void comboNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboNameItemStateChanged
        String textItem = (String) comboName.getSelectedItem();
        if(textItem.equalsIgnoreCase("default")){
        refreshListOnT();}
        else{
        refreshListOnTitle();
        numberOfcompName();}
    }//GEN-LAST:event_comboNameItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(txtBookId.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Please enter the book ID to search");}
        else{refreshListOnId();}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tableReceiveDamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReceiveDamMouseClicked
        int row = tableReceiveDam.getSelectedRow();
        bookId2 = (String) tableReceiveDam.getModel().getValueAt(row, 0);
        bookIsbn2 = (String) tableReceiveDam.getModel().getValueAt(row, 1);
        author2 = (String) tableReceiveDam.getModel().getValueAt(row, 2);
        title2 = (String) tableReceiveDam.getModel().getValueAt(row, 3);
        publisher2 = (String) tableReceiveDam.getModel().getValueAt(row, 4);
        shelf2 = (String) tableReceiveDam.getModel().getValueAt(row, 5);
        edition2 = (String) tableReceiveDam.getModel().getValueAt(row, 6);
        category2 = (String) tableReceiveDam.getModel().getValueAt(row, 7);
        compname2 = (String) tableReceiveDam.getModel().getValueAt(row, 8);
        date2  = (String) tableReceiveDam.getModel().getValueAt(row, 9);
    }//GEN-LAST:event_tableReceiveDamMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        select = bookId2;
        if (select == null) {
            JOptionPane.showMessageDialog(null, "Select a book from the table");
        } else {
                txtBookSelect.setText(bookId2);}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       if(txtBookSelect.getText().isEmpty()){
       JOptionPane.showMessageDialog(null, "Select a book from the table");}else{
        refreshListOnDelete();}
    }//GEN-LAST:event_jButton4ActionPerformed
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
            java.util.logging.Logger.getLogger(ReceiveMainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceiveMainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceiveMainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceiveMainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            ReceiveMainDialog dialog = new ReceiveMainDialog(new javax.swing.JFrame(), true);
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
    while(compModel.getRowCount() != 0){
        compModel.removeRow(0);}
    displayOnFilter();
    }
    
    public void refreshListOnT(){
    while(compModel.getRowCount() != 0){
        compModel.removeRow(0);}
    displaybooks();
    }

    public void refreshListOnDelete(){
    while(compModel.getRowCount() != 0){
        compModel.removeRow(0);}
    deleteBook();
    displaybooks();
    }
    
    public void refreshListOnId(){
    while(compModel.getRowCount() != 0){
        compModel.removeRow(0);}
     displayOnFilterID();}
    
    public void loadcombo() {
    try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/libdb", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT compName FROM company_table");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               
                comboName.addItem(rs.getString("compName"));
                }
            con.close();
            }
        catch(Exception e)
        {
            System.out.println("Error"+e);
        }    
}
    
    
    
        public void displaybooks() {

        compModel.setColumnIdentifiers(columnNames);

        tableReceiveDam.setModel(compModel);

        tableReceiveDam.setFillsViewportHeight(true);
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libdb", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT bookId,bkIsbn,author,title,publisher,shelf,edition,category,compName,timeIn FROM table_main");
            ResultSet rsIssue = st.executeQuery();
            
            int i = 0;
            while (rsIssue.next()) {
                bookId1 = rsIssue.getString("bookId");
                bookIsbn1 = rsIssue.getString("bkIsbn");
                author1 = rsIssue.getString("author");
                title1 = rsIssue.getString("title");
                publisher1 = rsIssue.getString("publisher");
                shelf1 = rsIssue.getString("shelf");
                edition1 = rsIssue.getString("edition");
                category1 = rsIssue.getString("category");
                compname1 = rsIssue.getString("compName");
                date1 = rsIssue.getString("timeIn");

                compModel.addRow(new Object[]{bookId1, bookIsbn1,author1,title1,publisher1,shelf1,edition1,category1,compname1,date1});
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
        
public void displayOnFilter() {

            
        String companyName = (String) comboName.getSelectedItem();
        compModel.setColumnIdentifiers(columnNames);

        tableReceiveDam.setModel(compModel);

        tableReceiveDam.setFillsViewportHeight(true);
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libdb", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT bookId,bkIsbn,author,title,publisher,shelf,edition,category,compName,timeIn FROM table_main WHERE compName = '"+companyName+"'");
            ResultSet rsIssue = st.executeQuery();
            
            int i = 0;
            while (rsIssue.next()) {
                bookId1 = rsIssue.getString("bookId");
                bookIsbn1 = rsIssue.getString("bkIsbn");
                author1 = rsIssue.getString("author");
                title1 = rsIssue.getString("title");
                publisher1 = rsIssue.getString("publisher");
                shelf1 = rsIssue.getString("shelf");
                edition1 = rsIssue.getString("edition");
                category1 = rsIssue.getString("category");
                compname1 = rsIssue.getString("compName");
                date1 = rsIssue.getString("timeIn");

                compModel.addRow(new Object[]{bookId1, bookIsbn1,author1,title1,publisher1,shelf1,edition1,category1,compname1,date1});
                i++;
            }

            if (i < 1) {
                //JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
}
        
public void displayOnFilterID() {

            
        String companyName =  txtBookId.getText();
        compModel.setColumnIdentifiers(columnNames);

        tableReceiveDam.setModel(compModel);

        tableReceiveDam.setFillsViewportHeight(true);
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libdb", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT bookId,bkIsbn,author,title,publisher,shelf,edition,category,compName,timeIn FROM table_main WHERE bookId = '"+companyName+"'");
            ResultSet rsIssue = st.executeQuery();
            
            int i = 0;
            while (rsIssue.next()) {
                bookId1 = rsIssue.getString("bookId");
                bookIsbn1 = rsIssue.getString("bkIsbn");
                author1 = rsIssue.getString("author");
                title1 = rsIssue.getString("title");
                publisher1 = rsIssue.getString("publisher");
                shelf1 = rsIssue.getString("shelf");
                edition1 = rsIssue.getString("edition");
                category1 = rsIssue.getString("category");
                compname1 = rsIssue.getString("compName");
                date1 = rsIssue.getString("timeIn");

                compModel.addRow(new Object[]{bookId1, bookIsbn1,author1,title1,publisher1,shelf1,edition1,category1,compname1,date1});
                i++;
            }

            if (i < 1) {
                //JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
}
public void deleteBook(){
    
    String systemBkId = txtBookSelect.getText().trim();
    String borrowedStatus = "NO";
    String nulText = "NULL";
    try {
                String url = "jdbc:mysql://localhost/libdb?useSSL = false";
                Connection conn;
                conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
               
                //--------update books db-----------
                String sql = "DELETE FROM table_main WHERE bookId= '"+systemBkId+"'";
                
                PreparedStatement pst;
                pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                statement = con.createStatement();
                String sql2 = "UPDATE books_db SET borrowed='" + borrowedStatus + "',borrowed_by_id =NULL,name1_of_borrower = '"+nulText+"',name2_of_borrower = '"+nulText+"',staff_std = '"+nulText+"' WHERE bklib_id='"+systemBkId+"'";
                    
                statement.execute(sql2);
                txtBookSelect.setText("");
                JOptionPane.showMessageDialog(null, "Book Received");
                
    }
    catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
}

public void numberOfcompName(){
    String compName = (String) comboName.getSelectedItem();
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
        PreparedStatement os = con.prepareStatement("SELECT COUNT(bookId) AS compcount FROM table_main WHERE compName='"+ compName +"'");
        ResultSet rsCs = os.executeQuery();
        
        int i = 0;
            if(rsCs.next()){    
                String repoCount = rsCs.getString("compcount");
                txtCount.setText(repoCount);}
            
            else{}//DO NOT delete this line
                
    }catch(ClassNotFoundException | SQLException | HeadlessException es){
    JOptionPane.showMessageDialog(null, es.getMessage());}
    }

public void numberOf(){
   
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
        PreparedStatement os = con.prepareStatement("SELECT COUNT(bookId) AS compcount FROM table_main");
        ResultSet rsCs = os.executeQuery();
        
        int i = 0;
            if(rsCs.next()){    
                String repoCount = rsCs.getString("compcount");
                txtCount.setText(repoCount);}
            
            else{}//DO NOT delete this line
                
    }catch(ClassNotFoundException | SQLException | HeadlessException es){
    JOptionPane.showMessageDialog(null, es.getMessage());}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableReceiveDam;
    private javax.swing.JTextField txtBookId;
    private javax.swing.JTextField txtBookSelect;
    private javax.swing.JTextField txtCount;
    // End of variables declaration//GEN-END:variables
}

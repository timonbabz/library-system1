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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public final class EditBookListDialog extends javax.swing.JDialog {

    /**
     * Creates new form EditBookListDialog
     * @param parent
     * @param modal
     */
  //  bookID1, bookISBNList1, authorNameList1, titleNameList1, publisherList1,editionList1,categoryList1,loanList1,borrowedList1;

    public EditBookListDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadcombo();
        
        bookId.setText(LibraryHome.bookID1);
        editIsbn.setText(LibraryHome.bookISBNList1);
        editAuthor.setText(LibraryHome.authorNameList1);
        editCategory.setSelectedItem(LibraryHome.categoryList1);
        comboEditLoanType.setSelectedItem(LibraryHome.loanList1);
        editTitle.setText(LibraryHome.titleNameList1);
        editPublisher.setText(LibraryHome.publisherList1);
        editEdition.setText(LibraryHome.editionList1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEditBookTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        mainPanelEditBook = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        editIsbn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        editAuthor = new javax.swing.JTextField();
        editTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        editPublisher = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        editEdition = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        comboEditLoanType = new javax.swing.JComboBox<String>();
        bookId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        editCategory = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        comboCondition = new javax.swing.JComboBox<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Library Management System");
        setResizable(false);

        panelEditBookTitle.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
        jLabel1.setText("Edit book details");

        javax.swing.GroupLayout panelEditBookTitleLayout = new javax.swing.GroupLayout(panelEditBookTitle);
        panelEditBookTitle.setLayout(panelEditBookTitleLayout);
        panelEditBookTitleLayout.setHorizontalGroup(
            panelEditBookTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditBookTitleLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelEditBookTitleLayout.setVerticalGroup(
            panelEditBookTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        mainPanelEditBook.setBackground(new java.awt.Color(129, 186, 243));

        jLabel2.setText("Book ISBN :");

        jLabel3.setText("Author :");

        jLabel4.setText("Title :");

        jLabel5.setText("Publisher :");

        jLabel6.setText("Edition :");

        jLabel7.setText("Subject category :");

        jLabel8.setText("For loan type :");

        btnSave.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save_16.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnSave.setContentAreaFilled(false);
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Savewhite_16.png"))); // NOI18N
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMouseExited(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Eraseblack_16.png"))); // NOI18N
        btnCancel.setText("Clear fields");
        btnCancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnCancel.setContentAreaFilled(false);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Erasered_16.png"))); // NOI18N
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelMouseExited(evt);
            }
        });
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exitblack_16.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exitred_16.png"))); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        comboEditLoanType.setBackground(new java.awt.Color(129, 186, 243));
        comboEditLoanType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select loan type", "Short", "Long" }));

        bookId.setEditable(false);
        bookId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookIdMouseClicked(evt);
            }
        });

        jLabel9.setText("Book ID :");

        editCategory.setBackground(new java.awt.Color(129, 186, 243));

        jLabel10.setText("Force borrowed condition (Optional):");

        comboCondition.setBackground(new java.awt.Color(129, 186, 243));
        comboCondition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "set", "YES", "NO", "LOST" }));

        javax.swing.GroupLayout mainPanelEditBookLayout = new javax.swing.GroupLayout(mainPanelEditBook);
        mainPanelEditBook.setLayout(mainPanelEditBookLayout);
        mainPanelEditBookLayout.setHorizontalGroup(
            mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelEditBookLayout.createSequentialGroup()
                .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelEditBookLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelEditBookLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelEditBookLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(mainPanelEditBookLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelEditBookLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelEditBookLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelEditBookLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelEditBookLayout.createSequentialGroup()
                                .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bookId, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(mainPanelEditBookLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboEditLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(108, 108, 108))
                            .addGroup(mainPanelEditBookLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(108, 108, 108)))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        mainPanelEditBookLayout.setVerticalGroup(
            mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelEditBookLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(editIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(editAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(editTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(editPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(editEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(editCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboEditLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(mainPanelEditBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelEditBookTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(mainPanelEditBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelEditBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanelEditBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bookIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookIdMouseClicked
        JOptionPane.showMessageDialog(null, "You are not allowed to edit the book's ID");
    }//GEN-LAST:event_bookIdMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String conditionText = (String) comboCondition.getSelectedItem();
        if (conditionText.equals("set")){
        updateBookDetails();
        updateSubId();
        }else{
        updateForceCondition();
        updateSubId();}
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
                editAuthor.setText("");
                editTitle.setText("");
                editPublisher.setText("");
                editEdition.setText("");
                editCategory.setSelectedIndex(0);
                comboEditLoanType.setSelectedIndex(0);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        btnSave.setForeground(Color.white);
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        btnSave.setForeground(Color.black);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseEntered
        btnCancel.setForeground(Color.red);
    }//GEN-LAST:event_btnCancelMouseEntered

    private void btnCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseExited
        btnCancel.setForeground(Color.black);
    }//GEN-LAST:event_btnCancelMouseExited

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setForeground(Color.red);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setForeground(Color.black);
    }//GEN-LAST:event_btnExitMouseExited

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
            java.util.logging.Logger.getLogger(EditBookListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditBookListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditBookListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditBookListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            EditBookListDialog dialog = new EditBookListDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    
    public void updateBookDetails(){
        String catValue = (String) comboEditLoanType.getSelectedItem();
        String value1 = editIsbn.getText().toUpperCase().trim();
        String value2 = editAuthor.getText().toUpperCase().trim();
        String value3 = editTitle.getText().toUpperCase().trim();
        String value4 = editPublisher.getText().toUpperCase().trim();
        String value5 = editEdition.getText().toUpperCase().trim();
        String value6 = (String) editCategory.getSelectedItem();
        
        if(value1.isEmpty()){
            JOptionPane.showMessageDialog(null, "Book ISBN cannot be empty");
            editIsbn.requestFocus();
        }else if(value2.isEmpty()){
            JOptionPane.showMessageDialog(null, "Book author must be entered");
            editAuthor.requestFocus();
        }else if(value3.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter book title");
            editTitle.requestFocus();
        }else if(value4.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter the book publisher");
            editPublisher.requestFocus();
        }else if(value5.isEmpty()){
            JOptionPane.showMessageDialog(null, "Book edition is missing");
            editEdition.requestFocus();
        }else if(value6.equals("select book category")){
            JOptionPane.showMessageDialog(null, "A category must be selected");}
        else if(catValue.equals("Select loan type")){
            JOptionPane.showMessageDialog(null, "Please select loan type");
        }
        else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/libdb", "root", "libsystem@dmin");

                String value7 = (String) comboEditLoanType.getSelectedItem();
                String value10 = bookId.getText();

                String sql = "UPDATE books_db SET book_isbn='" + value1 + "',author='" + value2 + "',title='" + value3 + "',publisher_name='" + value4 + "',edition='" + value5 + "',subject_category='" + value6 + "'"
                        + ",loan_type='" + value7 + "' WHERE bklib_id='" + value10 + "'";
                PreparedStatement pst;
                pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Edited successfully");

                editAuthor.setText("");
                editTitle.setText("");
                editPublisher.setText("");
                editEdition.setText("");
                editCategory.setSelectedIndex(0);
                bookId.setText("");
                comboEditLoanType.setSelectedIndex(0);
                
                dispose();

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditBookListDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void updateForceCondition(){
    
        {
        String catValue = (String) comboEditLoanType.getSelectedItem();
        String value1 = editIsbn.getText().toUpperCase().trim();
        String value2 = editAuthor.getText().toUpperCase().trim();
        String value3 = editTitle.getText().toUpperCase().trim();
        String value4 = editPublisher.getText().toUpperCase().trim();
        String value5 = editEdition.getText().toUpperCase().trim();
        String value6 = (String) editCategory.getSelectedItem();
        String valueCon = (String) comboCondition.getSelectedItem();
        
        if(value1.isEmpty()){
            JOptionPane.showMessageDialog(null, "Book ISBN cannot be empty");
            editIsbn.requestFocus();
        }else if(value2.isEmpty()){
            JOptionPane.showMessageDialog(null, "Book author must be entered");
            editAuthor.requestFocus();
        }else if(value3.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter book title");
            editTitle.requestFocus();
        }else if(value4.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter the book publisher");
            editPublisher.requestFocus();
        }else if(value5.isEmpty()){
            JOptionPane.showMessageDialog(null, "Book edition is missing");
            editEdition.requestFocus();
        }else if(value6.equals("select book category")){
            JOptionPane.showMessageDialog(null, "A category must be selected");}
        else if(catValue.equals("Select loan type")){
            JOptionPane.showMessageDialog(null, "Please select loan type");
        }
        else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/libdb", "root", "libsystem@dmin");

                String value7 = (String) comboEditLoanType.getSelectedItem();
                String value10 = bookId.getText();

                String sql = "UPDATE books_db SET book_isbn='" + value1 + "',author='" + value2 + "',title='" + value3 + "',publisher_name='" + value4 + "',edition='" + value5 + "',subject_category='" + value6 + "'"
                        + ",loan_type='" + value7 + "',borrowed='" + valueCon + "' WHERE bklib_id='" + value10 + "'";
                PreparedStatement pst;
                pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Edited successfully with forced borrowed condition");

                editAuthor.setText("");
                editTitle.setText("");
                editPublisher.setText("");
                editEdition.setText("");
                editCategory.setSelectedIndex(0);
                bookId.setText("");
                comboEditLoanType.setSelectedIndex(0);
                dispose();

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditBookListDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    }
    
   public void loadcombo() {
    try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/libdb", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT cat_name FROM bookcat_table");
            ResultSet rs = st.executeQuery();
            while(rs.next()){                            
                editCategory.addItem(rs.getString("cat_name"));
                }
            con.close();
            }
        catch(Exception e)
        {
            //System.out.println("Error"+e);
        }    
}
   
         public void updateSubId(){
        
            try {
            String url = "jdbc:mysql://localhost/libdb?useSSL = false";
            Connection conn;
            conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
            //UPDATE users_db SET dep_id = (SELECT dept_id FROM depart WHERE users_db.department = depart.dept_name)
            //--------update users db-----------
            String sql2 = "UPDATE books_db SET sub_id = (SELECT cat_id FROM bookcat_table WHERE books_db.subject_category = bookcat_table.cat_name)";
            
            PreparedStatement pst2 = null;
            pst2 = conn.prepareStatement(sql2);
            pst2.execute();
            
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookId;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboCondition;
    private javax.swing.JComboBox<String> comboEditLoanType;
    private javax.swing.JTextField editAuthor;
    private javax.swing.JComboBox<String> editCategory;
    private javax.swing.JTextField editEdition;
    private javax.swing.JTextField editIsbn;
    private javax.swing.JTextField editPublisher;
    private javax.swing.JTextField editTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel mainPanelEditBook;
    private javax.swing.JPanel panelEditBookTitle;
    // End of variables declaration//GEN-END:variables
}

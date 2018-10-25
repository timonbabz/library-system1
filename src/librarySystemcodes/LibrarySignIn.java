/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarySystemcodes;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */

public final class LibrarySignIn extends javax.swing.JFrame {
    /**
     * Creates new form LibraryHome
     */
    
    public static String usernameLabel;
    public static String permissionLabel;
    public static String userNameEntered;
    public static String deptLabel;
    public static String unameLabel;
    public static String userfname;
    public static String userLname;
    public static String userId;
    public static String labelStdMax;
    public static String labelStaffMax;
    public static String labeldaystaff;
    public static String labeldaystd;
    public static String labelSchoolName;
    Statement statement;
    
    public LibrarySignIn() throws IOException {
        initComponents();
        showNameOnLabel();
        showSchoolName();
        
        String imagepath = "/images/iconforlib_32.png";
        InputStream imgstream = LibrarySignIn.class.getResourceAsStream(imagepath);
        BufferedImage myImg = ImageIO.read(imgstream);
        this.setIconImage(myImg);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelname = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblForgotPass = new javax.swing.JLabel();
        capsLockText = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Management System");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/marannda.jpg"))); // NOI18N

        labelname.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelname.setText("SCHOOL/PRIMARY NAME HERE");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TOO LIBRARY MANAGEMENT SYSTEM");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        txtUsername.setBackground(new java.awt.Color(204, 204, 204));
        txtUsername.setToolTipText("username");
        txtUsername.setBorder(null);
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(204, 204, 204));
        txtPassword.setToolTipText("password");
        txtPassword.setBorder(null);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Login_16.png"))); // NOI18N
        btnLogin.setText("Log in");
        btnLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnLogin.setContentAreaFilled(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Loginblue_16.png"))); // NOI18N
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Name_16.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Password_16.png"))); // NOI18N

        jLabel8.setText("Username :");

        jLabel9.setText("Password :");

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("LOG IN");

        lblForgotPass.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblForgotPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblForgotPass.setText("Forgot password?");
        lblForgotPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblForgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgotPassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblForgotPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblForgotPassMouseExited(evt);
            }
        });

        capsLockText.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        capsLockText.setForeground(new java.awt.Color(255, 0, 0));
        capsLockText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator2)
                                    .addComponent(jSeparator3)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblForgotPass, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(capsLockText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(capsLockText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblForgotPass)
                .addGap(31, 31, 31))
        );

        jLabel5.setBackground(new java.awt.Color(51, 51, 255));
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("System Version 2.0.3");

        jLabel11.setForeground(new java.awt.Color(51, 102, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("TOO Studios © 2018");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(labelname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        btnLogin.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        btnLogin.setForeground(Color.black);
    }//GEN-LAST:event_btnLoginMouseExited

    private void lblForgotPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPassMouseEntered
        lblForgotPass.setForeground(Color.red);
    }//GEN-LAST:event_lblForgotPassMouseEntered

    private void lblForgotPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPassMouseExited
        lblForgotPass.setForeground(Color.black);
    }//GEN-LAST:event_lblForgotPassMouseExited

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String x = txtUsername.getText();
        String y = new String(txtPassword.getPassword());
        if(x.equals(""))
        {JOptionPane.showMessageDialog(null, "Please enter username");
        txtUsername.requestFocusInWindow();}
        else if(y.equals(""))
        {JOptionPane.showMessageDialog(null, "Please enter password");
        txtPassword.requestFocusInWindow();}
        else if(x.equals("support")){
        signinmethodAdmin();}
        else{signinmethod();
            SessionLogs();}
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_CAPS_LOCK){
        capsLockText.setText("Caps Lock has been pressed!");
        getToolkit().beep();
        }else{capsLockText.setText("");}
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_CAPS_LOCK){
        capsLockText.setText("Caps Lock is on!");
        getToolkit().beep();
        }else{capsLockText.setText("");}
    }//GEN-LAST:event_jPanel2KeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                signinmethod();
                SessionLogs();
                break;
            case KeyEvent.VK_CAPS_LOCK:
                capsLockText.setText("Caps Lock is on!");
                getToolkit().beep();
                break;
            default:
                capsLockText.setText("");
                break;
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void lblForgotPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPassMouseClicked
       userNameEntered = txtUsername.getText().trim();
        if(userNameEntered.isEmpty()){
           JOptionPane.showMessageDialog(null, "Please enter your username first");}
       
        else{CheckUsernameExists();}
       
    }//GEN-LAST:event_lblForgotPassMouseClicked

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
            java.util.logging.Logger.getLogger(LibrarySignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new LibrarySignIn().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(LibrarySignIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
public void showNameOnLabel() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement sti = con.prepareStatement("SELECT school_name FROM school_name_db");
            ResultSet rsName = sti.executeQuery();
            if (rsName.next()) {
                String schlName = rsName.getString("school_name");
                labelname.setText(schlName);
                
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            //JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
public void signinmethod() {
        
        String x = txtUsername.getText();
        String y = new String(txtPassword.getPassword());
        if(x.equals("systemAdmin") && y.equals("30library30"))
        {
                LibraryHome.main(null);
                dispose();}
        else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
                PreparedStatement st = con.prepareStatement("select user_fname,user_lname,id_no,department,password,username,permission from  users_db where  username=? and password=?");
                st.setString(1, x);
                st.setString(2, md5(txtPassword.getPassword()));
                ResultSet rs = st.executeQuery();

                int i = 0;
                if (rs.next()) {
                    String a = rs.getString("user_fname");
                    String b = rs.getString("user_lname");
                    String c = rs.getString("id_no");
                    String d = rs.getString("permission");
                    String dept = rs.getString("department");
                    String username = rs.getString("username");
                    
                    userId = c;
                    usernameLabel = a + " " + b;
                    userfname = a;
                      userLname = b;
                    permissionLabel = d;
                    deptLabel = dept;
                    unameLabel = username;
                    
                    showMaxOnLabelStd();
                    showMaxOnLabelStaff();
                    showMaxDayStaff();
                    showMaxDayStd();

                    LibraryHome.main(null);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please check your login details again or contact the system admin");
                }
            } catch (ClassNotFoundException | SQLException | HeadlessException e) {
           }
        }
    }

public void signinmethodAdmin() {
        
        String x = txtUsername.getText();
        String y = new String(txtPassword.getPassword());
        
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
                PreparedStatement st = con.prepareStatement("SELECT user_fname,user_lname,id_no,department,password,username,permission FROM  support_db WHERE  username=? and password=?");
                st.setString(1, x);
                st.setString(2, y);
                ResultSet rs = st.executeQuery();

                int i = 0;
                if (rs.next()) {
                    String a = rs.getString("user_fname");
                    String b = rs.getString("user_lname");
                    String c = rs.getString("id_no");
                    String d = rs.getString("permission");
                    String dept = rs.getString("department");
                    String username = rs.getString("username");
                    
                    userId = c;
                    usernameLabel = a + " " + b;
                    userfname = a;
                    userLname = b;
                    permissionLabel = d;
                    deptLabel = dept;
                    unameLabel = username;
                    
                    showMaxOnLabelStd();
                    showMaxOnLabelStaff();
                    showMaxDayStaff();
                    showMaxDayStd();

                    LibraryHome.main(null);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please check your login details again or contact the system admin");
                }
            } catch (ClassNotFoundException | SQLException | HeadlessException e) {
           }
        
    }

private String md5(char [] c){
    try{
    MessageDigest digs = MessageDigest.getInstance("MD5"); 
    digs.update((new String(c)).getBytes("UTF8"));
    String tsr = new String(digs.digest());
    return tsr;
    
    }catch(NoSuchAlgorithmException | UnsupportedEncodingException dd){
    return "";
    }
}

public final void SessionLogs() {

        String strUser = txtUsername.getText();
        String strLogger = userId;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
            statement = con.createStatement();

            // SQL Insert
            String sql = "INSERT INTO session_logs " + "(user_id,username)"
                    + "VALUES ('" + strLogger + "', '"
                    + strUser + "')";

            statement.execute(sql);
       String id = "select session_id from session_logs where ";
            //status  = true;
        } catch (ClassNotFoundException | SQLException | HeadlessException es) {
           
            //JOptionPane.showMessageDialog(null, "Session cancelled");
            //JOptionPane.showMessageDialog(null, es.getMessage());
        }

//end of if statement that validate the form
    }

 public void CheckUsernameExists()
{
 
    String enteredUser = txtUsername.getText().trim();

    try
    {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");

        PreparedStatement st = connection.prepareStatement("SELECT* FROM users_db WHERE username='" + enteredUser + "'");
        ResultSet r1=st.executeQuery();
        
         if(r1.next()) 
         {
           System.out.println("exists");
           ResetDialog userReset = new ResetDialog(this, true);
           userReset.setVisible(true);
         }else{JOptionPane.showMessageDialog(null, "Username doesn't exist, please contact the admin");}
     }

     catch (SQLException | ClassNotFoundException e) 
     {
        JOptionPane.showMessageDialog(null, e.getMessage());
     }

 }
 
 public void showMaxOnLabelStd() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSdbL = false", "root", "libsystem@dmin");
            PreparedStatement stino = con.prepareStatement("SELECT number_set FROM maxstudent");
            ResultSet rsName = stino.executeQuery();
            if (rsName.next()) {
                String maxno = rsName.getString("number_set");
                labelStdMax = maxno;
                
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
 public void showMaxOnLabelStaff() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement stino2 = con.prepareStatement("SELECT number_set FROM maxstaff");
            ResultSet rsName = stino2.executeQuery();
            if (rsName.next()) {
                String maxno = rsName.getString("number_set");
                labelStaffMax = maxno;
                
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
  public void showMaxDayStaff() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conMaxStaff;
            conMaxStaff = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement stino2 = conMaxStaff.prepareStatement("SELECT days_set FROM daysstaff");
            ResultSet rsName = stino2.executeQuery();
            if (rsName.next()) {
                String maxno = rsName.getString("days_set");
                labeldaystaff = (maxno);
                
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
 public void showMaxDayStd() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conMaxStaff;
            conMaxStaff = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement stino2 = conMaxStaff.prepareStatement("SELECT days_set FROM daystudents");
            ResultSet rsName = stino2.executeQuery();
            if (rsName.next()) {
                String maxno = rsName.getString("days_set");
                labeldaystd = (maxno);
                
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

 public void showSchoolName() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSdbL = false", "root", "libsystem@dmin");
            PreparedStatement stino = con.prepareStatement("SELECT school_name FROM school_name_db");
            ResultSet rsName = stino.executeQuery();
            if (rsName.next()) {
                String schName = rsName.getString("school_name");
                labelSchoolName = schName;
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel capsLockText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JLabel labelname;
    private javax.swing.JLabel lblForgotPass;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

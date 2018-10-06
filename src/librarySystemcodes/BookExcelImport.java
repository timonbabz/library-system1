/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarySystemcodes;

/**
 *
 * @author TimonBabz
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class BookExcelImport extends JFrame {

 public static JTable table;
 static JScrollPane scroll;
 // header is Vector contains table Column
 static Vector headers = new Vector();
 // Model is used to construct JTable
 static DefaultTableModel model = null;
 // data is Vector contains Data from Excel File
 static Vector data = new 
   Vector();
 static JButton jbClick;
 static JButton jbexport;
 static JButton jbInfo;
 static JFileChooser jChooser;
 static int tableWidth = 0; // set the tableWidth
 static int tableHeight = 0; // set the tableHeight

 public BookExcelImport() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
  super("Import Excel To JTable");
  String imagepath = "/images/iconforlib_32.png";
  InputStream imgstream = LibrarySignIn.class.getResourceAsStream(imagepath);
  BufferedImage myImg = ImageIO.read(imgstream);
  this.setIconImage(myImg);
  
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  JPanel buttonPanel = new JPanel();
  buttonPanel.setBackground(new java.awt.Color(129, 186, 243));
  
  jChooser = new JFileChooser();
  
  jbClick = new JButton("Select Excel File");
  jbClick.setContentAreaFilled(false);
  jbClick.setForeground(Color.white);
  jbClick.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
  jbClick.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
  jbClick.setPreferredSize(new Dimension(120, 30));
  jbClick.setFont(new java.awt.Font("sansserif", 1, 12));
  jbClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Addblack_16.png")));
  
  jbexport = new JButton("Save to Database");
  jbexport.setContentAreaFilled(false);
  jbexport.setForeground(Color.white);
  jbexport.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
  jbexport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
  jbexport.setPreferredSize(new Dimension(135, 30));
  jbexport.setFont(new java.awt.Font("sansserif", 1, 12));
  jbexport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save_16.png")));
  
  jbInfo = new JButton("Excel structure help");
  jbInfo.setContentAreaFilled(false);
  jbInfo.setForeground(Color.white);
  jbInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
  jbInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
  jbInfo.setPreferredSize(new Dimension(145, 30));
  jbInfo.setFont(new java.awt.Font("sansserif", 1, 12));
  jbInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help_16.png")));
  
  buttonPanel.add(jbInfo, BorderLayout.CENTER);
  buttonPanel.add(jbClick, BorderLayout.CENTER);
  buttonPanel.add(jbexport, BorderLayout.CENTER);
  // Show Button Click Event
  jbClick.addActionListener(new ActionListener()
  {

   @Override
   public void actionPerformed(ActionEvent arg0) {
    jChooser.showOpenDialog(null);
    
    File file = jChooser.getSelectedFile();
    if(!file.getName().endsWith("xls")){
     JOptionPane.showMessageDialog(null, 
       "Please select an Excel file of extension(.xls).",
       "Error",JOptionPane.ERROR_MESSAGE);
    }
    else
    {
     fillData(file);
     model = new DefaultTableModel(data, 
       headers);
     tableWidth = model.getColumnCount() 
       * 150;
     tableHeight = model.getRowCount() 
       * 25;
     table.setPreferredSize(new Dimension(
       tableWidth, tableHeight));
 
     table.setModel(model);
    }
   }
  });
  
  jbexport.addActionListener(new ActionListener()
     {
         @Override
   public void actionPerformed(ActionEvent arg0)
   {
       insertDataFromTableIntoDatabase();
   }
     });
  
    jbInfo.addActionListener(new ActionListener()
     {
         @Override
   public void actionPerformed(ActionEvent arg0)
   {
       DialogExcelSetup bookDialogEx = new DialogExcelSetup(null, true);
       bookDialogEx.setVisible(true);
   }
     });
  
  table = new JTable();
  table.setAutoCreateRowSorter(true);
  model = new DefaultTableModel(data, headers);

  table.setModel(model);
  table.setBackground(Color.lightGray);

  table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  table.setEnabled(false);
  table.setRowHeight(25);
  table.setRowMargin(4);

  tableWidth = model.getColumnCount() * 150;
  tableHeight = model.getRowCount() * 25;
  table.setPreferredSize(new Dimension(
    tableWidth, tableHeight));

  scroll = new JScrollPane(table);
  scroll.setBackground(Color.pink);
  scroll.setPreferredSize(new Dimension(300, 300));
  scroll.setHorizontalScrollBarPolicy(
    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  scroll.setVerticalScrollBarPolicy(
    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
  getContentPane().add(buttonPanel, 
    BorderLayout.NORTH);
  getContentPane().add(scroll, 
    BorderLayout.CENTER);
  setSize(600, 600);
  setResizable(true);
  setVisible(true);
  
 }
 
 public void insertDataFromTableIntoDatabase(){
     int rows=table.getRowCount();
     if(rows == 0){
     JOptionPane.showMessageDialog(null, "Table has no data to be saved!");
     }else{
 try{

Class.forName("com.mysql.jdbc.Driver").newInstance();
java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/libdb?useSSL = false", "root", "libsystem@dmin");
conn.setAutoCommit(false);

String queryco = "INSERT INTO books_db(bklib_id, book_isbn, author, title, publisher_name, edition, subject_category, loan_type, shelf) VALUES (?,?,?,?,?,?,?,?,?)";
PreparedStatement pst = conn.prepareStatement(queryco);
for(int row = 0; row<rows; row++)
{
    String bookId = (String)table.getValueAt(row, 0);
    String isbnNumber = (String)table.getValueAt(row, 1);
    String authorName = (String)table.getValueAt(row, 2);
    String bookTitle = (String)table.getValueAt(row, 3);
    String publisherName = (String)table.getValueAt(row, 4);
    String bookEdition = (String)table.getValueAt(row, 5);
    String BookCat = (String)table.getValueAt(row, 6);
    String BookLoan = (String)table.getValueAt(row, 7);
    String bookShelf = (String)table.getValueAt(row, 8);
    
    
    pst.setString(1, bookId);
    pst.setString(2, isbnNumber);
    pst.setString(3, authorName);
    pst.setString(4, bookTitle);
    pst.setString(5, publisherName);
    pst.setString(6, bookEdition);
    pst.setString(7, BookCat);
    pst.setString(8, BookLoan);
    pst.setString(9, bookShelf);

    pst.addBatch();
}
pst.executeBatch();
conn.commit();
JOptionPane.showMessageDialog(null, "Data successfully saved to the database");
}
catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
}}
 }
 /**
  * Fill JTable with Excel file data.
  * 
  * @param file
  * file :contains xls file to display in jTable
  */
 void fillData(File file) {

  Workbook workbook = null;
  try {
   try {
    workbook = Workbook.getWorkbook(file);
   } catch (IOException ex) {
    Logger.getLogger(
      BookExcelImport.class.
      getName()).log(Level.SEVERE, 
        null, ex);
   }
   Sheet sheet = workbook.getSheet(0);
   
   headers.clear();
   for (int i = 0; i < sheet.getColumns(); i++) {
    Cell cell1 = sheet.getCell(i, 0);
    headers.add(cell1.getContents());
   }

   data.clear();
   for (int j = 1; j < sheet.getRows(); j++) {
    Vector d = new Vector();
    for (int i = 0; i < sheet.getColumns(); i++) {

     Cell cell = sheet.getCell(i, j);
     
     d.add(cell.getContents());

    }
    d.add("\n");
    data.add(d);
   }
  } catch (BiffException e) {
  }
 }

 public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

    BookExcelImport frame = new BookExcelImport();
    frame.setTitle("ADD BOOKS FROM EXCEL SHEET");
    frame.setSize(1000, 500);
    frame.setBackground(Color.BLUE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
 }
}
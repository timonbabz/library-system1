/*
 * Designed and created by Timothy Opiyo Ochieng as a library management system.
 * All rights reserved.
 * copyright 2018.
 */
package librarySystemcodes;

import com.sun.glass.events.KeyEvent;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
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
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author timothy opiyo
 */
public final class LibraryHome extends javax.swing.JFrame {

    /**
     * Creates new form LibraryHome
     */
    
    Connection con = null;
    Connection cons = null;
    Statement statement = null;
    ResultSet rs = null;
    PreparedStatement state = null;
    String use1=null;
    static String fileDictName = "";

    //----------------declaration for table Scchedules--------------------------------
    public static String schId1, schTitle1, schInfo1,schDate1,schCreatorId1;
    
    public static String schId = "", schTitle = "", schInfo = "", schDate = "", schCreatorId = "";
    String[] schColumnNames = {"Schedule ID", "Title", "Information", "Date"};
    DefaultTableModel scheduleModel = new DefaultTableModel();
    //----------------declaration for table notes--------------------------------
    public static String notesID1, notesTitle1, notesInfo1,createdBy1,dueDatenptes1,importance1,acknowledge1;
    
    public static String notesID = "", notesTitle = "", notesInfo = "", createdBy = "", dueDatenptes = "", importance = "", acknowledge = "";
    String[] notesColumnNames = {"Notes ID", "Title", "Information", "Created by", "Date due","Importance","Acknowledged"};
    DefaultTableModel notesModel = new DefaultTableModel();
    //----------------declaration of table list for list item--------------------
    String select = null;
    public static String bookID1, bookISBNList1, authorNameList1, titleNameList1, publisherList1,editionList1,categoryList1,loanList1,borrowedList1;
    
    public static String bookID,bookISBNList, authorNameList, titleNameList,publisherList,editionList,categoryList,loanList,borrowedList,conditionList;
    String[] listColumnNames = {"Book ID","ISBN" ,"Author","Title", "Publisher", "Edition", "Category", "Loan Type", "Borrowed","Condition"};
    DefaultTableModel listModel = new DefaultTableModel();
    //----------------declaration of table list for list item--------------------
    public static String stockbookID1, stockbookISBNList1, stockauthorNameList1, stocktitleNameList1, stockpublisherList1,stockeditionList1,stockcategoryList1,stockloanList1;
    
    public static String stockbookID,stockbookISBNList, stockauthorNameList, stocktitleNameList,stockpublisherList,stockeditionList,stockcategoryList,stockloanList;
    String[] stockColumnNames = {"Book ID","ISBN" ,"Author","Title", "Publisher", "Edition", "Category", "Loan Type" };
    DefaultTableModel stockModel = new DefaultTableModel();
    //----------------declaration of issue books to students table---------------
    public static String bookID2, bookISBNList2, authorNameList2, titleNameList2, publisherList2,editionList2,categoryList2,loanList2,borrowedList2;
    
    public static String issuebookID,issuebookISBNList, issueauthorNameList, issuetitleNameList,issuepublisherList,issueeditionList,issuecategoryList,issueloanList,issueborrowedList;
    String[] issueColumnNames = {"Book ID","ISBN" ,"Author","Title", "Publisher", "Edition", "Category"};
    DefaultTableModel issueModel = new DefaultTableModel();
    //----------------declaration of issue books to students table---------------
    public static String bookID4, bookISBNList4, authorNameList4, titleNameList4, publisherList4,editionList4,categoryList4,loanList4,borrowedList4;
    
    public static String shortbookID,shortbookISBNList, shortauthorNameList, shorttitleNameList,shortpublisherList,shorteditionList,shortcategoryList,shortloanList,shortborrowedList;
    String[] shortColumnNames = {"Book ID","ISBN" ,"Author","Title", "Publisher", "Edition", "Category"};
    DefaultTableModel shortModel = new DefaultTableModel();
    //----------------declaration of issue books to staff table---------------
    public static String bookID3, bookISBNList3, authorNameList3, titleNameList3, publisherList3,editionList3,categoryList3,loanList3,borrowedList3;
    
    public static String issueSbookID,issueSbookISBNList, issueSauthorNameList, issueStitleNameList,issueSpublisherList,issueSeditionList,issueScategoryList,issueSloanList,issueSborrowedList;
    String[] issueSColumnNames = {"Book ID","ISBN" ,"Author","Title", "Publisher", "Edition", "Category"};
    DefaultTableModel issueSModel = new DefaultTableModel();
        //----------------declaration of issue books lost table---------------
    public static String lostbookID3, lostbookISBNList3, lostauthorNameList3, losttitleNameList3, lostpublisherList3,losteditionList3,lostcategoryList3,lostloanList3,lostborrowedList3;
    
    public static String lostbookID,lostbookISBNList, lostauthorNameList, losttitleNameList,lostpublisherList,losteditionList,lostcategoryList,lostloanList,lostborrowedList;
    String[] lostColumnNames = {"Book ID","ISBN" ,"Author","Title", "Publisher", "Edition", "Category"};
    DefaultTableModel lostModel = new DefaultTableModel();
    //----------------declaration for table magazine--------------------------------
    public static String magIssueNo1, magName1, magPublisher1,magDate1;
    
    public static String magIssueNo = "", magName = "", magPublisher = "", magDate = "";
    String[] magColumnNames = {"Issue number", "Magazine name", "Publisher", "Magazine date"};
    DefaultTableModel magModel = new DefaultTableModel();
    //----------------declaration for table magazine borrowers--------------------------------
    public static String magboroNo = "", magboroName = "", magboroPublisher = "", magboroDate = "", magboroIssuedtoID="",magboroIssuedto="",magissuedBy="",recievedBy="",studentStaff="";
    String[] magDetailsColumnNames = {"Issue number", "Magazine name", "Publisher", "Magazine date", "Issued to (ID)", "Issued to","Student/Staff", "Issued by"};
    DefaultTableModel magDetailsModel = new DefaultTableModel();
    //----------------declaration for table borrowers----------------------------
    public static String entryNo,borrowerId, bName1, bName2,bTitle,bIsbn,staffStudent;
    String[] borrowersColumnNames = {"Entry Number","Borrower ID" ,"First Name","Last Name","Book Title","ISBN","Student/Staff"};
    DefaultTableModel borrowerModel = new DefaultTableModel();
    //----------------declaration for table for session logs---------------------
    public static String sessId,logger , timeIn, timeOut,username1;
    String[] sessionColumnNames = {"Session ID","System user ID" ,"Username","Time signed in", "Time signed out"};
    DefaultTableModel logModel = new DefaultTableModel();
    //----------------declaration for table users--------------------------------
    public static String userEdit, userNameedit, username2Edit,usernameEdit,permissionEdit,deptEdit, resetEdit;
    
    public static String useridNo = "", fname = "", lname = "", usernName = "", permission = "", designation = "", reset = "";
    String[] columnNames = {"ID number", "First name", "Second name", "Username", "Permission", "Department", "Reset Password"};
    DefaultTableModel userModel = new DefaultTableModel();
    //----------------declaration of books issued table--------------------------
    String boroBookId = "", boroBookIsbn = "", boroBookTitle = "", boroFname = "", boroLname = "", boroDate = "", boroAuthorNameList= "", boroPublisherList= "", boroEditionList= "";
    String[] boroColumnNames = {"Book ID", "Book ISBN", "Author","Book Title", "Publisher", "Edition", "First name", "Last name"};
    DefaultTableModel boroModel = new DefaultTableModel();
    //----------------declaration of staff table--------------------------
    String staffIDno = "", fnameStaff = "", lnameStaff = "", phoneStaffNo = "", staffDepartment = "", staffBookid = "", staffBookTitle= "", staffBorrrowedDate= "", staffIssued= "",staffRecieved="", staffReturned="" ;
    String[] staffColumnNames = {"Staff ID", "Staff Name", "Phone number","Department", "Book ID", "Book Title", "Date borrowed", "Returend", "Issued by"};
    DefaultTableModel staffModel = new DefaultTableModel();
    //----------------declaration of student table--------------------------
    String stdAdm = "", stdFname = "", stdLname = "", stdForm = "", stdBookId = "", stdBookTitle = "", stdReturned= "", stdIssuedby= "", stdRecievedby= "",stdBorrrowedDate="";
    String[] stdColumnNames = {"Student ID", "Student Name", "Form/Class","Book ID", "Book Title","Date Borrowed", "Returned", "Issued By"};
    DefaultTableModel stdModel = new DefaultTableModel();
    
    public LibraryHome() throws IOException {
        initComponents();
        permissionCheck();
        TimeDisplay();
        DisplayBooksList();
        displayBooksIssueStudents();
        displayBooksIssueStaff();
        numberOfBooksBorrowed();
        numberOfBorrowers();
        numberOfBooks();
        displayBorrowersList();
        DisplaySessions();
        DisplayUsers();
        displayBooksBorrowed();
        displayBooksShortLoan();
        DisplayBooksStock();
        
        String imagepath = "/images/iconforlib_32.png";
        InputStream imgstream = LibraryHome.class.getResourceAsStream(imagepath);
        BufferedImage myImg = ImageIO.read(imgstream);
        this.setIconImage(myImg);
        
        lblUserId.setText(LibrarySignIn.usernameLabel);
        lblID.setText(LibrarySignIn.userId);
        labelPermission.setText(LibrarySignIn.permissionLabel);
        maxStaff.setText(LibrarySignIn.labelStdMax);
        maxStd.setText(LibrarySignIn.labelStaffMax);
        
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 7);
        Date futuredate = cal.getTime();
        
        chooserschDate.setMinSelectableDate(date);
        ChooserNotes.setMinSelectableDate(date);
        
        chooserMagzBoro.setDate(date);
        chooserMagzBoro.setMinSelectableDate(date);
        chooserMagzBoro.setMaxSelectableDate(date);
        JTextFieldDateEditor dateChooserMagz = (JTextFieldDateEditor)chooserMagzBoro.getDateEditor();
        dateChooserMagz.setEditable(false);
        
        chooserMagzDue.setMinSelectableDate(date);
        chooserMagzDue.setMaxSelectableDate(futuredate);
        JTextFieldDateEditor dateChooserMagzfield = (JTextFieldDateEditor)chooserMagzDue.getDateEditor();
        dateChooserMagzfield.setEditable(false);
        
        DateBorrowed.setDate(date);
        DateBorrowed.setMinSelectableDate(date);
        DateBorrowed.setMaxSelectableDate(date);
        JTextFieldDateEditor dateChooserfield = (JTextFieldDateEditor)DateBorrowed.getDateEditor();
        dateChooserfield.setEditable(false);
        
        staffDateBorrowed.setDate(date);
        staffDateBorrowed.setMinSelectableDate(date);
        staffDateBorrowed.setMaxSelectableDate(date);
        JTextFieldDateEditor dateChooserStaffField = (JTextFieldDateEditor)staffDateBorrowed.getDateEditor();
        dateChooserStaffField.setEditable(false);
        
        dateStaffDue.setMinSelectableDate(date);
        dateStaffDue.setMaxSelectableDate(futuredate);
        JTextFieldDateEditor dateChooserStaffDuefield = (JTextFieldDateEditor)dateStaffDue.getDateEditor();
        dateChooserStaffDuefield.setEditable(false);
        
        dateReturnedChooser.setDate(date);
        dateReturnedChooser.setMinSelectableDate(date);
        dateReturnedChooser.setMaxSelectableDate(date);
        JTextFieldDateEditor dateReturnedfield = (JTextFieldDateEditor)dateReturnedChooser.getDateEditor();
        dateReturnedfield.setEditable(false);
        
        dateChooserDue.setMinSelectableDate(date);
        dateChooserDue.setMaxSelectableDate(futuredate);
        JTextFieldDateEditor dateChooserDuefield = (JTextFieldDateEditor)dateChooserDue.getDateEditor();
        dateChooserDuefield.setEditable(false);
        
        SpinfieldTimeLoan.setMaximum(8);
        SpinfieldTimeLoan.setMinimum(1);
        SpinfieldTimeLoan.setValue(1);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel28 = new javax.swing.JPanel();
        holderPanel = new javax.swing.JPanel();
        panelHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelUser = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        labelTabOne = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        labelBookNo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        labelTabTwo = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        labelBooksBorrowed = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        labelTabThree = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblNoOfBorrowers = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        btnProfMore = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        btnIssueCut = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        btnMagzShortcut = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        btnSchedulesShortCut = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        calenderHome = new com.toedter.calendar.JCalendar();
        labelPermission = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        maxStaff = new javax.swing.JLabel();
        maxStd = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        lblUserId = new javax.swing.JLabel();
        labelTime = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        panelstock = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableBookStock = new javax.swing.JTable();
        txtSearchText = new javax.swing.JTextField();
        searchStock = new javax.swing.JButton();
        comboFilterStock = new javax.swing.JComboBox<String>();
        btnExportStock = new javax.swing.JButton();
        btnRefreshStockDetails = new javax.swing.JButton();
        panelIssueStudent = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableIssueToStudents = new javax.swing.JTable();
        jPanel34 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtStdntClass = new javax.swing.JTextField();
        txtBookIdIssue = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        btnAddIssueStudent = new javax.swing.JButton();
        txtBookIssueTitle1 = new javax.swing.JTextField();
        txtStdntLname = new javax.swing.JTextField();
        btnCancelIssue = new javax.swing.JButton();
        DateBorrowed = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        txtStdntAmNo = new javax.swing.JTextField();
        txtBookIsbnIssue = new javax.swing.JTextField();
        dateChooserDue = new com.toedter.calendar.JDateChooser();
        txtSdntFname = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnSearchStd = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnIssueToStudents = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        comboSearchIssue = new javax.swing.JComboBox<String>();
        txtSearchIssueStd = new javax.swing.JTextField();
        btnSearchIssueStd = new javax.swing.JButton();
        btnIssueRefresh = new javax.swing.JButton();
        panelIssueStaff = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableBooksForStaff = new javax.swing.JTable();
        jPanel36 = new javax.swing.JPanel();
        txtStaffPhone = new javax.swing.JTextField();
        staffDateBorrowed = new com.toedter.calendar.JDateChooser();
        dateStaffDue = new com.toedter.calendar.JDateChooser();
        txtStaffID = new javax.swing.JTextField();
        txtStaffName2 = new javax.swing.JTextField();
        txtStaffName1 = new javax.swing.JTextField();
        txtStaffBookId = new javax.swing.JTextField();
        btnCancelIssueStaff = new javax.swing.JButton();
        txtStaffDept = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtStaffBookIsbn = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtStaffBkTitle = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        btnIsssueStaff = new javax.swing.JButton();
        btnSearchStaff = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        comboSearchInStaffIssue = new javax.swing.JComboBox<String>();
        btnSearchStaffBk = new javax.swing.JButton();
        btnAddBookStaff = new javax.swing.JButton();
        txtSearchStaffBook = new javax.swing.JTextField();
        panelRecieve = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        btnRecieveBooks = new javax.swing.JButton();
        btnCancelRecieve = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtAdmNo = new javax.swing.JTextField();
        txtBookTitle = new javax.swing.JTextField();
        txtPenalties = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtReceievedFrom = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btnSearchBookDetails = new javax.swing.JButton();
        textFieldBookId = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtDateDue = new javax.swing.JTextField();
        dateReturnedChooser = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtAreaCondition = new javax.swing.JTextArea();
        txtStaffStudent = new javax.swing.JTextField();
        txtBookIsbnRet = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnIndicator = new javax.swing.JButton();
        panelList = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableListBooks = new javax.swing.JTable();
        btnAddBookList = new javax.swing.JButton();
        btnEditBookDetails = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        txtListBooks = new javax.swing.JTextField();
        btnSearchList = new javax.swing.JButton();
        btnExcelList = new javax.swing.JButton();
        comboBoxList = new javax.swing.JComboBox<String>();
        panelBorrowers = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableBorrowers = new javax.swing.JTable();
        txtSearchBorrowers = new javax.swing.JTextField();
        btnSearchBorrowers = new javax.swing.JButton();
        comboFilter = new javax.swing.JComboBox<String>();
        btnPrintBorrowers = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        btnExcelBorrowers = new javax.swing.JButton();
        btnRefreshBoro = new javax.swing.JButton();
        panelBooksIssued = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableBooksIssued = new javax.swing.JTable();
        btnPrintIssued = new javax.swing.JButton();
        txtSearchIssued = new javax.swing.JTextField();
        btnSearchIssued = new javax.swing.JButton();
        panelShortLoanBooks = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableShortLoanBook = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        txtShortBkTitle = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txtShortLname = new javax.swing.JTextField();
        txtStaffstdId = new javax.swing.JTextField();
        txtShortClass = new javax.swing.JTextField();
        SpinfieldTimeLoan = new com.toedter.components.JSpinField();
        jLabel55 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtShortDept = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        txtStaffNo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        txtShortFname = new javax.swing.JTextField();
        btnCancelShort = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtShortBkIsbn = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        btnIssueShort = new javax.swing.JButton();
        btnSearchStdStaff = new javax.swing.JButton();
        txtShortBkId = new javax.swing.JTextField();
        comboStaffStudent = new javax.swing.JComboBox<String>();
        jLabel59 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        comboSearchShort = new javax.swing.JComboBox<String>();
        btnRefreshShortBks = new javax.swing.JButton();
        txtSearchShort = new javax.swing.JTextField();
        btnSearchShortLoanBks = new javax.swing.JButton();
        panelManageUsers = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        panelHolderManageUsers = new javax.swing.JPanel();
        panelUsersView = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        txtSearchUser = new javax.swing.JTextField();
        btnSearchUser = new javax.swing.JButton();
        btnRefreshUserTable = new javax.swing.JButton();
        panelSessionLogs = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSessionLogs = new javax.swing.JTable();
        btnPrintSession = new javax.swing.JButton();
        panelAddUsers = new javax.swing.JPanel();
        txtIdNo = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtDept = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        txtConfPass = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        btnusersInfo = new javax.swing.JButton();
        btnUsersSessions = new javax.swing.JButton();
        btnAddNewUsers = new javax.swing.JButton();
        btnPassReset = new javax.swing.JButton();
        btnPermissions = new javax.swing.JButton();
        panelReportLost = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        panelLostBooks = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tableBookLost = new javax.swing.JTable();
        txtSearchLost = new javax.swing.JTextField();
        searchLost = new javax.swing.JButton();
        comboFilterLost = new javax.swing.JComboBox<String>();
        txtBookIDlost = new javax.swing.JTextField();
        btnAddBkLost = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        txtIDLost = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        txtFnameLost = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtLnameLost = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        txtStaffLost = new javax.swing.JTextField();
        btnLostConf = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        txtBookTitleLost = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        txtIsbnLost = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        panelStudents = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableStudents = new javax.swing.JTable();
        btnWriteStdToExcel = new javax.swing.JButton();
        txtStdIdSearch = new javax.swing.JTextField();
        btnSearchStdID = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        comboFilterStudents = new javax.swing.JComboBox<String>();
        panelTeachers = new javax.swing.JPanel();
        labelStaffList = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tableStaff = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        txtStaffIdList = new javax.swing.JTextField();
        btnSearchStaffId = new javax.swing.JButton();
        jLabel92 = new javax.swing.JLabel();
        comboFiletStaff = new javax.swing.JComboBox<String>();
        panelMags = new javax.swing.JPanel();
        labelMagz = new javax.swing.JLabel();
        panelMagsIn = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableMags = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        txtMagzNameID = new javax.swing.JTextField();
        labelId = new javax.swing.JLabel();
        comboMagz = new javax.swing.JComboBox<String>();
        jLabel80 = new javax.swing.JLabel();
        txtMagzName1 = new javax.swing.JTextField();
        labelId1 = new javax.swing.JLabel();
        labelId2 = new javax.swing.JLabel();
        txtMagzName2 = new javax.swing.JTextField();
        txtMagzClass = new javax.swing.JTextField();
        labelId3 = new javax.swing.JLabel();
        txtMagzPhone = new javax.swing.JTextField();
        labelId4 = new javax.swing.JLabel();
        txtMagzDept = new javax.swing.JTextField();
        labelId5 = new javax.swing.JLabel();
        txtMagzTitle = new javax.swing.JTextField();
        labelId6 = new javax.swing.JLabel();
        btnSearchForMagIssue = new javax.swing.JButton();
        labelId7 = new javax.swing.JLabel();
        txtMagzDate = new javax.swing.JTextField();
        labelId8 = new javax.swing.JLabel();
        labelId9 = new javax.swing.JLabel();
        txtMagzIssueNo = new javax.swing.JTextField();
        labelId10 = new javax.swing.JLabel();
        chooserMagzDue = new com.toedter.calendar.JDateChooser();
        chooserMagzBoro = new com.toedter.calendar.JDateChooser();
        btnMagzIssue = new javax.swing.JButton();
        btnMagzCancel = new javax.swing.JButton();
        btnAddMagToIssue = new javax.swing.JButton();
        btnAddMag = new javax.swing.JButton();
        btnMagzDetails = new javax.swing.JButton();
        chooserMagz = new com.toedter.calendar.JDateChooser();
        btnSearchMagz = new javax.swing.JButton();
        labelSearchInMagzPanel = new javax.swing.JLabel();
        btnRecieveMagz = new javax.swing.JButton();
        btnRefreshMagz = new javax.swing.JButton();
        panelMagzBorrowers = new javax.swing.JPanel();
        labelMagzBorrowed = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tableMagzBoro = new javax.swing.JTable();
        btnRefreshMagzBoro = new javax.swing.JButton();
        txtSearchMagzBorrowed = new javax.swing.JTextField();
        btnSearchBoroMagz = new javax.swing.JButton();
        btnMagzToExcel = new javax.swing.JButton();
        comboMagzFilter = new javax.swing.JComboBox<String>();
        panelSchedules = new javax.swing.JPanel();
        labelMagzBorrowed1 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tableSchedules = new javax.swing.JTable();
        panelSchedulesCreate = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        txtSchInfo = new javax.swing.JTextArea();
        chooserschDate = new com.toedter.calendar.JDateChooser();
        txtschtitle = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        btnCreateSch = new javax.swing.JButton();
        btnCancelSch = new javax.swing.JButton();
        btnViewSch = new javax.swing.JButton();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tableNotes = new javax.swing.JTable();
        panelNotesCreate = new javax.swing.JPanel();
        txtNotesTitle = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        txtNotesInfo = new javax.swing.JTextArea();
        jLabel85 = new javax.swing.JLabel();
        comboNotes = new javax.swing.JComboBox<String>();
        ChooserNotes = new com.toedter.calendar.JDateChooser();
        btnCreateNotes = new javax.swing.JButton();
        btnCancelNotes = new javax.swing.JButton();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        btnInfoDialog = new javax.swing.JButton();
        mainMenuBar = new javax.swing.JMenuBar();
        mainMenuNav = new javax.swing.JMenu();
        itemHome = new javax.swing.JMenuItem();
        itemStock = new javax.swing.JMenuItem();
        itemIssue = new javax.swing.JMenu();
        itemStudent = new javax.swing.JMenuItem();
        itemStaff = new javax.swing.JMenuItem();
        itemShortLoan = new javax.swing.JMenuItem();
        itemRecieve = new javax.swing.JMenuItem();
        menuItemLost = new javax.swing.JMenuItem();
        menuItemMagz = new javax.swing.JMenuItem();
        menuItemProfile = new javax.swing.JMenuItem();
        itemLogout = new javax.swing.JMenuItem();
        menuItemEdit = new javax.swing.JMenu();
        itemList = new javax.swing.JMenuItem();
        menuItemView = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        itemBooksIssued = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuSettings = new javax.swing.JMenu();
        itemsSystems = new javax.swing.JMenuItem();
        itemManageUsers = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuItemGuide = new javax.swing.JMenuItem();
        menuItemAbout = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Library Management System");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        holderPanel.setBackground(new java.awt.Color(51, 153, 255));
        holderPanel.setLayout(new java.awt.CardLayout());

        panelHome.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
        jLabel1.setText("Home");

        labelUser.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelUser.setForeground(new java.awt.Color(255, 255, 255));
        labelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Name_16.png"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(129, 186, 243));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        labelTabOne.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelTabOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/More_16.png"))); // NOI18N
        labelTabOne.setText("More info");
        labelTabOne.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelTabOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTabOneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelTabOneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelTabOneMouseExited(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Book_Shelf_32.png"))); // NOI18N
        jLabel33.setText("Books");

        labelBookNo.setText("number");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(labelBookNo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelTabOne)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBookNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTabOne)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        labelTabTwo.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelTabTwo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/More_16.png"))); // NOI18N
        labelTabTwo.setText("More info");
        labelTabTwo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelTabTwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTabTwoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelTabTwoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelTabTwoMouseExited(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/booksBorrowed_32.png"))); // NOI18N
        jLabel34.setText("Borrowed Books");

        labelBooksBorrowed.setText("number");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBooksBorrowed)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTabTwo)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBooksBorrowed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTabTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        labelTabThree.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelTabThree.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/More_16.png"))); // NOI18N
        labelTabThree.setText("More info");
        labelTabThree.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelTabThree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTabThreeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelTabThreeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelTabThreeMouseExited(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrowers_32.png"))); // NOI18N
        jLabel37.setText("Borrowers");

        lblNoOfBorrowers.setText("number");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelTabThree))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lblNoOfBorrowers)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNoOfBorrowers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTabThree)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(129, 186, 243));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP));

        jPanel31.setBackground(new java.awt.Color(0, 102, 204));

        jLabel73.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("Recieve");

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sell_50px.png"))); // NOI18N

        btnProfMore.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnProfMore.setForeground(new java.awt.Color(255, 255, 255));
        btnProfMore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/More_16.png"))); // NOI18N
        btnProfMore.setText("Recieve");
        btnProfMore.setBorder(null);
        btnProfMore.setContentAreaFilled(false);
        btnProfMore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProfMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProfMoreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProfMoreMouseExited(evt);
            }
        });
        btnProfMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfMoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(btnProfMore, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnProfMore)))
                .addContainerGap())
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jLabel63.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel63.setText("Issue");

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User_64px_1.png"))); // NOI18N

        btnIssueCut.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnIssueCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/More_16.png"))); // NOI18N
        btnIssueCut.setText("Issue book");
        btnIssueCut.setBorder(null);
        btnIssueCut.setContentAreaFilled(false);
        btnIssueCut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIssueCut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIssueCutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIssueCutMouseExited(evt);
            }
        });
        btnIssueCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIssueCutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(btnIssueCut))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnIssueCut)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Magazine_32.png"))); // NOI18N

        jLabel76.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel76.setText("Magazines/Journals");

        btnMagzShortcut.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnMagzShortcut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/More_16.png"))); // NOI18N
        btnMagzShortcut.setText("VIew");
        btnMagzShortcut.setBorder(null);
        btnMagzShortcut.setContentAreaFilled(false);
        btnMagzShortcut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMagzShortcut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMagzShortcutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMagzShortcut, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(btnMagzShortcut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Schedule_32.png"))); // NOI18N

        jLabel78.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel78.setText("My Schedules/Notes");

        btnSchedulesShortCut.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSchedulesShortCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/More_16.png"))); // NOI18N
        btnSchedulesShortCut.setText("View");
        btnSchedulesShortCut.setContentAreaFilled(false);
        btnSchedulesShortCut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSchedulesShortCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSchedulesShortCutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel77)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel78)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSchedulesShortCut, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel77, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(btnSchedulesShortCut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(129, 186, 243));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        calenderHome.setBackground(new java.awt.Color(129, 186, 243));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calenderHome, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calenderHome, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );

        labelPermission.setText("permission");

        jLabel42.setText("Logged in as :");

        jLabel79.setText("System version 1.0.2 created by Optimum Computer Systems © 2018 ");

        jLabel93.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel93.setText("Maximum books allowable:");

        jLabel94.setText("Students :");

        maxStaff.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        maxStaff.setText("number");

        maxStd.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        maxStd.setText("number");

        jLabel95.setText("Staff :");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel96.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel96.setText("Maximum days allowable:");

        jLabel97.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel97.setText("number");

        jLabel98.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel98.setText("number");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelPermission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel79, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel93)
                                .addGap(95, 95, 95)
                                .addComponent(jLabel96))
                            .addComponent(jSeparator1)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel95)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(maxStaff))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel94)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(maxStd)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel98)
                                    .addComponent(jLabel97))
                                .addGap(90, 90, 90)))))
                .addGap(16, 16, 16))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel93)
                            .addComponent(jLabel96))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel95)
                            .addComponent(maxStaff)
                            .addComponent(jLabel97))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel94)
                            .addComponent(maxStd)
                            .addComponent(jLabel98))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPermission)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel79)
                        .addGap(3, 3, 3))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        lblUserId.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblUserId.setForeground(new java.awt.Color(255, 255, 255));
        lblUserId.setText("username");

        labelTime.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelTime.setForeground(new java.awt.Color(255, 255, 255));
        labelTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Time_16.png"))); // NOI18N
        labelTime.setText("time here");

        lblID.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("user id");

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblID))
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addComponent(labelUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUser)
                    .addComponent(lblUserId)
                    .addComponent(labelTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        holderPanel.add(panelHome, "card2");

        panelstock.setBackground(new java.awt.Color(51, 102, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
        jLabel2.setText("Book Stock");

        jPanel11.setBackground(new java.awt.Color(129, 186, 243));

        tableBookStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jScrollPane5.setViewportView(tableBookStock);

    txtSearchText.setToolTipText("enter book title to search");

    searchStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
    searchStock.setToolTipText("search books in stock");
    searchStock.setContentAreaFilled(false);
    searchStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    searchStock.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchwhite_16.png"))); // NOI18N
    searchStock.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchStockActionPerformed(evt);
        }
    });

    comboFilterStock.setBackground(new java.awt.Color(129, 186, 243));
    comboFilterStock.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Filter by :", "Arts & Recreation", "Computers, IT & General Works", "History & Geography", "Literature", "Languages", "Philosophy & Psychology", "Religion", "Science", "Social Sciences", "Technology & Applied Science" }));
    comboFilterStock.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            comboFilterStockItemStateChanged(evt);
        }
    });

    btnExportStock.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnExportStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Microsoft_Excel_16.png"))); // NOI18N
    btnExportStock.setText("Export to excel");
    btnExportStock.setToolTipText("view in excel");
    btnExportStock.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnExportStock.setContentAreaFilled(false);
    btnExportStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnExportStock.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Microsoftwhitel_16.png"))); // NOI18N
    btnExportStock.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnExportStockMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnExportStockMouseExited(evt);
        }
    });
    btnExportStock.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnExportStockActionPerformed(evt);
        }
    });

    btnRefreshStockDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh_16.png"))); // NOI18N
    btnRefreshStockDetails.setToolTipText("refresh");
    btnRefreshStockDetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnRefreshStockDetails.setContentAreaFilled(false);
    btnRefreshStockDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnRefreshStockDetails.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refreshwhite_16.png"))); // NOI18N
    btnRefreshStockDetails.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRefreshStockDetailsActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
    jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addComponent(jScrollPane5)
                    .addContainerGap())
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addComponent(btnExportStock, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnRefreshStockDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                    .addComponent(comboFilterStock, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(searchStock, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14))))
    );
    jPanel11Layout.setVerticalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboFilterStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(searchStock, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(btnRefreshStockDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(btnExportStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
            .addContainerGap())
    );

    javax.swing.GroupLayout panelstockLayout = new javax.swing.GroupLayout(panelstock);
    panelstock.setLayout(panelstockLayout);
    panelstockLayout.setHorizontalGroup(
        panelstockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelstockLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelstockLayout.setVerticalGroup(
        panelstockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelstockLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelstock, "card2");

    panelIssueStudent.setBackground(new java.awt.Color(51, 102, 255));

    jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    jLabel3.setText("Issue to students");

    jPanel4.setBackground(new java.awt.Color(129, 186, 243));

    tableIssueToStudents.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    )
    {public boolean isCellEditable(int row, int column){return false;}}
    );
    tableIssueToStudents.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableIssueToStudentsMouseClicked(evt);
        }
    });
    jScrollPane3.setViewportView(tableIssueToStudents);

    jPanel34.setBackground(new java.awt.Color(129, 186, 243));
    jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP));

    jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel27.setText("Book ID :");

    txtBookIdIssue.setEditable(false);

    jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel22.setText("First name :");

    jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel30.setText("Book Title :");

    btnAddIssueStudent.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnAddIssueStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrow_16.png"))); // NOI18N
    btnAddIssueStudent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnAddIssueStudent.setContentAreaFilled(false);
    btnAddIssueStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnAddIssueStudent.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrowwhite_16.png"))); // NOI18N
    btnAddIssueStudent.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddIssueStudentActionPerformed(evt);
        }
    });

    txtBookIssueTitle1.setEditable(false);

    txtStdntLname.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtStdntLnameActionPerformed(evt);
        }
    });

    btnCancelIssue.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnCancelIssue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelblack_16.png"))); // NOI18N
    btnCancelIssue.setText("Cancel");
    btnCancelIssue.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnCancelIssue.setContentAreaFilled(false);
    btnCancelIssue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnCancelIssue.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelred_16.png"))); // NOI18N
    btnCancelIssue.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnCancelIssueMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnCancelIssueMouseExited(evt);
        }
    });
    btnCancelIssue.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelIssueActionPerformed(evt);
        }
    });

    DateBorrowed.setBackground(new java.awt.Color(129, 186, 243));

    jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel26.setText("Date due :");

    txtStdntAmNo.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtStdntAmNoKeyPressed(evt);
        }
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtStdntAmNoKeyTyped(evt);
        }
    });

    txtBookIsbnIssue.setEditable(false);

    dateChooserDue.setBackground(new java.awt.Color(129, 186, 243));
    dateChooserDue.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            dateChooserDueKeyTyped(evt);
        }
    });

    jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel24.setText("Date borrowed :");

    jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel21.setText("Adm NO :");

    jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel25.setText("Class/Form :");

    btnSearchStd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
    btnSearchStd.setContentAreaFilled(false);
    btnSearchStd.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchwhite_16.png"))); // NOI18N
    btnSearchStd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchStdActionPerformed(evt);
        }
    });

    jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel28.setText("Book ISBN No :");

    jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel23.setText("Last name :");

    btnIssueToStudents.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnIssueToStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/issueBookblack_16.png"))); // NOI18N
    btnIssueToStudents.setText("Issue");
    btnIssueToStudents.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnIssueToStudents.setContentAreaFilled(false);
    btnIssueToStudents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnIssueToStudents.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/issuebookgreen_16.png"))); // NOI18N
    btnIssueToStudents.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnIssueToStudentsMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnIssueToStudentsMouseExited(evt);
        }
    });
    btnIssueToStudents.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnIssueToStudentsActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
    jPanel34.setLayout(jPanel34Layout);
    jPanel34Layout.setHorizontalGroup(
        jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel34Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel34Layout.createSequentialGroup()
                            .addComponent(txtStdntAmNo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSearchStd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(txtSdntFname, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtStdntLname, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtStdntClass, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(DateBorrowed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateChooserDue, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBookIsbnIssue)
                        .addComponent(txtBookIssueTitle1)
                        .addGroup(jPanel34Layout.createSequentialGroup()
                            .addComponent(btnIssueToStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel34Layout.createSequentialGroup()
                            .addComponent(txtBookIdIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAddIssueStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))))
            .addContainerGap())
    );
    jPanel34Layout.setVerticalGroup(
        jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
            .addGap(29, 29, 29)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtStdntAmNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(btnSearchStd))
            .addGap(19, 19, 19)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel22)
                .addComponent(txtSdntFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel23)
                .addComponent(txtStdntLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel25)
                .addComponent(txtStdntClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jLabel24))
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(DateBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel26)
                .addComponent(dateChooserDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel27)
                .addComponent(txtBookIdIssue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddIssueStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel30)
                .addComponent(txtBookIssueTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel28)
                .addComponent(txtBookIsbnIssue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnIssueToStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnCancelIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20, 20, 20))
    );

    jPanel35.setBackground(new java.awt.Color(129, 186, 243));
    jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    comboSearchIssue.setBackground(new java.awt.Color(129, 186, 243));
    comboSearchIssue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select category to display", "Arts & Recreation", "Computers, IT & General Works", "History & Geography", "Literature", "Languages", "Philosophy & Psychology", "Religion", "Science", "Social Sciences", "Technology & Applied Science" }));
    comboSearchIssue.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            comboSearchIssueItemStateChanged(evt);
        }
    });

    txtSearchIssueStd.setToolTipText("search book title here");

    btnSearchIssueStd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
    btnSearchIssueStd.setToolTipText("Search book title");
    btnSearchIssueStd.setContentAreaFilled(false);
    btnSearchIssueStd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSearchIssueStd.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchred_16.png"))); // NOI18N
    btnSearchIssueStd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchIssueStdActionPerformed(evt);
        }
    });

    btnIssueRefresh.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnIssueRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh_16.png"))); // NOI18N
    btnIssueRefresh.setText("Refresh");
    btnIssueRefresh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnIssueRefresh.setContentAreaFilled(false);
    btnIssueRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnIssueRefresh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh2_16.png"))); // NOI18N
    btnIssueRefresh.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnIssueRefreshActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
    jPanel35.setLayout(jPanel35Layout);
    jPanel35Layout.setHorizontalGroup(
        jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel35Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btnIssueRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtSearchIssueStd, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSearchIssueStd, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, Short.MAX_VALUE)
            .addComponent(comboSearchIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    jPanel35Layout.setVerticalGroup(
        jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel35Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchIssueStd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIssueRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(comboSearchIssue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSearchIssueStd))
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE))
                .addComponent(jPanel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(9, 9, 9))
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jScrollPane3)
                    .addContainerGap())))
    );

    javax.swing.GroupLayout panelIssueStudentLayout = new javax.swing.GroupLayout(panelIssueStudent);
    panelIssueStudent.setLayout(panelIssueStudentLayout);
    panelIssueStudentLayout.setHorizontalGroup(
        panelIssueStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelIssueStudentLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel3)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelIssueStudentLayout.setVerticalGroup(
        panelIssueStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelIssueStudentLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelIssueStudent, "card2");

    panelIssueStaff.setBackground(new java.awt.Color(51, 102, 255));

    jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    jLabel4.setText("Issue to staff");

    jPanel12.setBackground(new java.awt.Color(129, 186, 243));

    tableBooksForStaff.setModel(new javax.swing.table.DefaultTableModel(
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
    tableBooksForStaff.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableBooksForStaffMouseClicked(evt);
        }
    });
    jScrollPane6.setViewportView(tableBooksForStaff);

    jPanel36.setBackground(new java.awt.Color(129, 186, 243));
    jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP));

    txtStaffPhone.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtStaffPhoneKeyTyped(evt);
        }
    });

    staffDateBorrowed.setBackground(new java.awt.Color(129, 186, 243));

    dateStaffDue.setBackground(new java.awt.Color(129, 186, 243));

    txtStaffID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtStaffIDKeyPressed(evt);
        }
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtStaffIDKeyTyped(evt);
        }
    });

    txtStaffBookId.setEditable(false);

    btnCancelIssueStaff.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnCancelIssueStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelblack_16.png"))); // NOI18N
    btnCancelIssueStaff.setText("Cancel");
    btnCancelIssueStaff.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnCancelIssueStaff.setContentAreaFilled(false);
    btnCancelIssueStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnCancelIssueStaff.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelred_16.png"))); // NOI18N
    btnCancelIssueStaff.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelIssueStaffActionPerformed(evt);
        }
    });

    jLabel44.setText("Book ISBN number :");

    txtStaffBookIsbn.setEditable(false);

    jLabel48.setText("Date borrowed :");

    jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel20.setText("Book ID :");

    txtStaffBkTitle.setEditable(false);

    jLabel39.setText("First name :");

    btnIsssueStaff.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnIsssueStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/issueBookblack_16.png"))); // NOI18N
    btnIsssueStaff.setText("Issue");
    btnIsssueStaff.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnIsssueStaff.setContentAreaFilled(false);
    btnIsssueStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnIsssueStaff.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/issuebookgreen_16.png"))); // NOI18N
    btnIsssueStaff.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnIsssueStaffActionPerformed(evt);
        }
    });

    btnSearchStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
    btnSearchStaff.setToolTipText("Search");
    btnSearchStaff.setContentAreaFilled(false);
    btnSearchStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSearchStaff.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchwhite_16.png"))); // NOI18N
    btnSearchStaff.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchStaffActionPerformed(evt);
        }
    });

    jLabel47.setText("Phone number :");

    jLabel43.setText("Date due :");

    jLabel32.setText("ID number :");

    jLabel40.setText("Last name :");

    jLabel41.setText("Department :");

    jLabel46.setText("Book title :");

    javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
    jPanel36.setLayout(jPanel36Layout);
    jPanel36Layout.setHorizontalGroup(
        jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
            .addContainerGap(20, Short.MAX_VALUE)
            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtStaffBkTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(staffDateBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(txtStaffBookIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStaffBookId))
                    .addComponent(jLabel43)
                    .addComponent(txtStaffDept)
                    .addComponent(txtStaffName2)
                    .addComponent(jLabel41)
                    .addComponent(jLabel40)
                    .addComponent(jLabel39)
                    .addComponent(txtStaffName1)
                    .addComponent(txtStaffPhone)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(txtStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel47)
                    .addComponent(jLabel32)
                    .addComponent(jLabel48)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(btnIsssueStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(btnCancelIssueStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateStaffDue, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel46))
            .addGap(16, 16, 16))
    );
    jPanel36Layout.setVerticalGroup(
        jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel36Layout.createSequentialGroup()
            .addComponent(jLabel32)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(txtStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSearchStaff))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel39)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtStaffName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel40)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtStaffName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel41)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtStaffDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel47)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtStaffPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel48)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(staffDateBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel43)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(dateStaffDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel44)
                .addComponent(jLabel20))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtStaffBookIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtStaffBookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel46)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtStaffBkTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnIsssueStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnCancelIssueStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, Short.MAX_VALUE))
    );

    jPanel37.setBackground(new java.awt.Color(129, 186, 243));
    jPanel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    comboSearchInStaffIssue.setBackground(new java.awt.Color(129, 186, 243));
    comboSearchInStaffIssue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select category to display", "Arts & Recreation", "Computers, IT & General Works", "History & Geography", "Literature", "Languages", "Philosophy & Psychology", "Religion", "Science", "Social Sciences", "Technology & Applied Science" }));
    comboSearchInStaffIssue.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            comboSearchInStaffIssueItemStateChanged(evt);
        }
    });

    btnSearchStaffBk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
    btnSearchStaffBk.setToolTipText("click to search");
    btnSearchStaffBk.setContentAreaFilled(false);
    btnSearchStaffBk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSearchStaffBk.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchred_16.png"))); // NOI18N
    btnSearchStaffBk.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchStaffBkActionPerformed(evt);
        }
    });

    btnAddBookStaff.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnAddBookStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrow_16.png"))); // NOI18N
    btnAddBookStaff.setText("Add");
    btnAddBookStaff.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    btnAddBookStaff.setContentAreaFilled(false);
    btnAddBookStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnAddBookStaff.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrowwhite_16.png"))); // NOI18N
    btnAddBookStaff.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddBookStaffActionPerformed(evt);
        }
    });

    txtSearchStaffBook.setToolTipText("enter book title to search");

    javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
    jPanel37.setLayout(jPanel37Layout);
    jPanel37Layout.setHorizontalGroup(
        jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel37Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btnAddBookStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtSearchStaffBook, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSearchStaffBk, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
            .addComponent(comboSearchInStaffIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    jPanel37Layout.setVerticalGroup(
        jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel37Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchStaffBk, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearchStaffBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddBookStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(comboSearchInStaffIssue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
    jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel12Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    jPanel12Layout.setVerticalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel12Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(1, 1, 1)))
            .addContainerGap())
    );

    javax.swing.GroupLayout panelIssueStaffLayout = new javax.swing.GroupLayout(panelIssueStaff);
    panelIssueStaff.setLayout(panelIssueStaffLayout);
    panelIssueStaffLayout.setHorizontalGroup(
        panelIssueStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelIssueStaffLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel4)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelIssueStaffLayout.setVerticalGroup(
        panelIssueStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelIssueStaffLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelIssueStaff, "card2");

    panelRecieve.setBackground(new java.awt.Color(51, 102, 255));

    jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 255, 255));
    jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    jLabel5.setText("Recieve books");

    jPanel13.setBackground(new java.awt.Color(129, 186, 243));

    jPanel14.setBackground(new java.awt.Color(129, 186, 243));
    jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

    btnRecieveBooks.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnRecieveBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/acceptbookblack_16.png"))); // NOI18N
    btnRecieveBooks.setText("Accept");
    btnRecieveBooks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    btnRecieveBooks.setContentAreaFilled(false);
    btnRecieveBooks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnRecieveBooks.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/acceptbookwhite_16.png"))); // NOI18N
    btnRecieveBooks.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnRecieveBooksMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnRecieveBooksMouseExited(evt);
        }
    });
    btnRecieveBooks.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRecieveBooksActionPerformed(evt);
        }
    });

    btnCancelRecieve.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnCancelRecieve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelblack_16.png"))); // NOI18N
    btnCancelRecieve.setText("Cancel");
    btnCancelRecieve.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    btnCancelRecieve.setContentAreaFilled(false);
    btnCancelRecieve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnCancelRecieve.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelred_16.png"))); // NOI18N
    btnCancelRecieve.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnCancelRecieveMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnCancelRecieveMouseExited(evt);
        }
    });
    btnCancelRecieve.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelRecieveActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
    jPanel14.setLayout(jPanel14Layout);
    jPanel14Layout.setHorizontalGroup(
        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel14Layout.createSequentialGroup()
            .addGap(52, 52, 52)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(btnRecieveBooks, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addComponent(btnCancelRecieve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(49, Short.MAX_VALUE))
    );
    jPanel14Layout.setVerticalGroup(
        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel14Layout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(btnRecieveBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnCancelRecieve, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(27, Short.MAX_VALUE))
    );

    jPanel16.setBackground(new java.awt.Color(129, 186, 243));
    jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    jLabel52.setText("Returned on :");

    jLabel31.setText("Book title :");

    txtAdmNo.setEditable(false);

    txtBookTitle.setEditable(false);

    jLabel49.setText("Date due :");

    txtReceievedFrom.setEditable(false);

    jLabel53.setText("Penalties :");

    jLabel51.setText("ID no/Adm no :");

    jPanel15.setBackground(new java.awt.Color(129, 186, 243));
    jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Enter book ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

    btnSearchBookDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
    btnSearchBookDetails.setBorder(null);
    btnSearchBookDetails.setContentAreaFilled(false);
    btnSearchBookDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSearchBookDetails.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchred_16.png"))); // NOI18N
    btnSearchBookDetails.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchBookDetailsActionPerformed(evt);
        }
    });

    textFieldBookId.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            textFieldBookIdKeyTyped(evt);
        }
    });

    javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
    jPanel15.setLayout(jPanel15Layout);
    jPanel15Layout.setHorizontalGroup(
        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel15Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(textFieldBookId, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSearchBookDetails)
            .addGap(43, 43, 43))
    );
    jPanel15Layout.setVerticalGroup(
        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel15Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(textFieldBookId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSearchBookDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jLabel50.setText("Recieved from :");

    txtDateDue.setEditable(false);

    dateReturnedChooser.setBackground(new java.awt.Color(129, 186, 243));

    jPanel1.setBackground(new java.awt.Color(129, 186, 243));
    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Condition", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

    txtAreaCondition.setColumns(20);
    txtAreaCondition.setRows(5);
    jScrollPane7.setViewportView(txtAreaCondition);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    txtStaffStudent.setEditable(false);
    txtStaffStudent.setBackground(new java.awt.Color(204, 204, 255));
    txtStaffStudent.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    txtStaffStudent.setForeground(new java.awt.Color(0, 51, 51));

    txtBookIsbnRet.setEditable(false);

    jLabel19.setText("Book ISBN :");

    javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
    jPanel16.setLayout(jPanel16Layout);
    jPanel16Layout.setHorizontalGroup(
        jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel16Layout.createSequentialGroup()
            .addContainerGap(129, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel31)
                        .addComponent(jLabel49)
                        .addComponent(jLabel50)
                        .addComponent(jLabel51)
                        .addComponent(jLabel52)
                        .addComponent(jLabel53)
                        .addComponent(jLabel19))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPenalties, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dateReturnedChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAdmNo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtReceievedFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDateDue, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtStaffStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtBookIsbnRet, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBookTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(130, Short.MAX_VALUE))
    );
    jPanel16Layout.setVerticalGroup(
        jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel16Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtBookIsbnRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel19))
            .addGap(18, 18, 18)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel31))
            .addGap(18, 18, 18)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtDateDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel49))
            .addGap(18, 18, 18)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtReceievedFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel50))
            .addGap(18, 18, 18)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtAdmNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel51)
                .addComponent(txtStaffStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(dateReturnedChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20, 20, 20)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtPenalties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel53))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(36, Short.MAX_VALUE))
    );

    btnIndicator.setBackground(new java.awt.Color(129, 186, 243));

    javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
    jPanel13.setLayout(jPanel13Layout);
    jPanel13Layout.setHorizontalGroup(
        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(51, 51, 51))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())))
    );
    jPanel13Layout.setVerticalGroup(
        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel13Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addComponent(btnIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21))
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );

    javax.swing.GroupLayout panelRecieveLayout = new javax.swing.GroupLayout(panelRecieve);
    panelRecieve.setLayout(panelRecieveLayout);
    panelRecieveLayout.setHorizontalGroup(
        panelRecieveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelRecieveLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(jLabel5)
            .addContainerGap(887, Short.MAX_VALUE))
        .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelRecieveLayout.setVerticalGroup(
        panelRecieveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelRecieveLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelRecieve, "card2");

    panelList.setBackground(new java.awt.Color(51, 102, 255));

    jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    jLabel6.setText("List of Books");

    jPanel18.setBackground(new java.awt.Color(129, 186, 243));

    tableListBooks.setModel(new javax.swing.table.DefaultTableModel(
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
    tableListBooks.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableListBooksMouseClicked(evt);
        }
    });
    jScrollPane9.setViewportView(tableListBooks);

    javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
    jPanel18.setLayout(jPanel18Layout);
    jPanel18Layout.setHorizontalGroup(
        jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane9)
    );
    jPanel18Layout.setVerticalGroup(
        jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
    );

    btnAddBookList.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnAddBookList.setForeground(new java.awt.Color(255, 255, 255));
    btnAddBookList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add_16.png"))); // NOI18N
    btnAddBookList.setText("Add a book");
    btnAddBookList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnAddBookList.setContentAreaFilled(false);
    btnAddBookList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnAddBookList.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Addred_16.png"))); // NOI18N
    btnAddBookList.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnAddBookListMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnAddBookListMouseExited(evt);
        }
    });
    btnAddBookList.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddBookListActionPerformed(evt);
        }
    });

    btnEditBookDetails.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnEditBookDetails.setForeground(new java.awt.Color(255, 255, 255));
    btnEditBookDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Editwhite_16.png"))); // NOI18N
    btnEditBookDetails.setText("Edit details");
    btnEditBookDetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnEditBookDetails.setContentAreaFilled(false);
    btnEditBookDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnEditBookDetails.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Editred_16.png"))); // NOI18N
    btnEditBookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnEditBookDetailsMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnEditBookDetailsMouseExited(evt);
        }
    });
    btnEditBookDetails.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEditBookDetailsActionPerformed(evt);
        }
    });

    btnRefresh.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
    btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refreshwhite_16.png"))); // NOI18N
    btnRefresh.setToolTipText("refresh");
    btnRefresh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnRefresh.setContentAreaFilled(false);
    btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnRefresh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh2_16.png"))); // NOI18N
    btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnRefreshMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnRefreshMouseExited(evt);
        }
    });
    btnRefresh.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRefreshActionPerformed(evt);
        }
    });

    btnSearchList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchwhite_16.png"))); // NOI18N
    btnSearchList.setContentAreaFilled(false);
    btnSearchList.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchred_16.png"))); // NOI18N
    btnSearchList.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchListActionPerformed(evt);
        }
    });

    btnExcelList.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnExcelList.setForeground(new java.awt.Color(255, 255, 255));
    btnExcelList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Microsoftwhitel_16.png"))); // NOI18N
    btnExcelList.setText("Export to excel");
    btnExcelList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnExcelList.setContentAreaFilled(false);
    btnExcelList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnExcelList.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MicrosoftExcelred_16.png"))); // NOI18N
    btnExcelList.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnExcelListMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnExcelListMouseExited(evt);
        }
    });
    btnExcelList.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnExcelListActionPerformed(evt);
        }
    });

    comboBoxList.setBackground(new java.awt.Color(255, 255, 255));
    comboBoxList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Filter by borrowed", "YES", "NO", "LOST" }));
    comboBoxList.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            comboBoxListItemStateChanged(evt);
        }
    });

    javax.swing.GroupLayout panelListLayout = new javax.swing.GroupLayout(panelList);
    panelList.setLayout(panelListLayout);
    panelListLayout.setHorizontalGroup(
        panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelListLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel6)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txtListBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSearchList, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(comboBoxList, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
            .addComponent(btnExcelList, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnAddBookList, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnEditBookDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(14, 14, 14))
        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelListLayout.setVerticalGroup(
        panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelListLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnExcelList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(comboBoxList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtListBooks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchList))
                .addGroup(panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditBookDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddBookList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelList, "card2");

    panelBorrowers.setBackground(new java.awt.Color(51, 102, 255));

    jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    jLabel7.setText("Borrowers");

    jPanel17.setBackground(new java.awt.Color(129, 186, 243));

    tableBorrowers.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane8.setViewportView(tableBorrowers);

    btnSearchBorrowers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
    btnSearchBorrowers.setBorder(null);
    btnSearchBorrowers.setContentAreaFilled(false);
    btnSearchBorrowers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSearchBorrowers.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchred_16.png"))); // NOI18N
    btnSearchBorrowers.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchBorrowersActionPerformed(evt);
        }
    });

    comboFilter.setBackground(new java.awt.Color(129, 186, 243));
    comboFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Filter by :", "STAFF", "STUDENT" }));
    comboFilter.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            comboFilterItemStateChanged(evt);
        }
    });

    btnPrintBorrowers.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnPrintBorrowers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print_16.png"))); // NOI18N
    btnPrintBorrowers.setText("Print");
    btnPrintBorrowers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnPrintBorrowers.setContentAreaFilled(false);
    btnPrintBorrowers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnPrintBorrowers.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Printwhite_16.png"))); // NOI18N
    btnPrintBorrowers.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnPrintBorrowersActionPerformed(evt);
        }
    });

    jLabel62.setText("Enter second name :");

    btnExcelBorrowers.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnExcelBorrowers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Microsoft_Excel_16.png"))); // NOI18N
    btnExcelBorrowers.setText("Export to excel");
    btnExcelBorrowers.setToolTipText("view excel of chosen data");
    btnExcelBorrowers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnExcelBorrowers.setContentAreaFilled(false);
    btnExcelBorrowers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnExcelBorrowers.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Microsoftwhitel_16.png"))); // NOI18N
    btnExcelBorrowers.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnExcelBorrowersActionPerformed(evt);
        }
    });

    btnRefreshBoro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh_16.png"))); // NOI18N
    btnRefreshBoro.setToolTipText("refresh table");
    btnRefreshBoro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnRefreshBoro.setContentAreaFilled(false);
    btnRefreshBoro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnRefreshBoro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refreshwhite_16.png"))); // NOI18N
    btnRefreshBoro.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRefreshBoroActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
    jPanel17.setLayout(jPanel17Layout);
    jPanel17Layout.setHorizontalGroup(
        jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(comboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnPrintBorrowers, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnExcelBorrowers, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRefreshBoro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel62)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtSearchBorrowers, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(5, 5, 5)
            .addComponent(btnSearchBorrowers)
            .addContainerGap())
    );
    jPanel17Layout.setVerticalGroup(
        jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel17Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPrintBorrowers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshBoro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearchBorrowers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel62))
                    .addComponent(btnExcelBorrowers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(btnSearchBorrowers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(3, 3, 3)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout panelBorrowersLayout = new javax.swing.GroupLayout(panelBorrowers);
    panelBorrowers.setLayout(panelBorrowersLayout);
    panelBorrowersLayout.setHorizontalGroup(
        panelBorrowersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBorrowersLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel7)
            .addContainerGap(913, Short.MAX_VALUE))
        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelBorrowersLayout.setVerticalGroup(
        panelBorrowersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBorrowersLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelBorrowers, "card2");

    panelBooksIssued.setBackground(new java.awt.Color(51, 102, 255));

    jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    jLabel8.setText("Books issued");

    jPanel19.setBackground(new java.awt.Color(129, 186, 243));

    tableBooksIssued.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane10.setViewportView(tableBooksIssued);

    javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
    jPanel19.setLayout(jPanel19Layout);
    jPanel19Layout.setHorizontalGroup(
        jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
    );
    jPanel19Layout.setVerticalGroup(
        jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
    );

    btnPrintIssued.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnPrintIssued.setForeground(new java.awt.Color(255, 255, 255));
    btnPrintIssued.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Printwhite_16.png"))); // NOI18N
    btnPrintIssued.setText("Print");
    btnPrintIssued.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnPrintIssued.setContentAreaFilled(false);
    btnPrintIssued.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnPrintIssued.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnPrintIssuedMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnPrintIssuedMouseExited(evt);
        }
    });
    btnPrintIssued.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnPrintIssuedActionPerformed(evt);
        }
    });

    btnSearchIssued.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchwhite_16.png"))); // NOI18N
    btnSearchIssued.setContentAreaFilled(false);
    btnSearchIssued.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchred_16.png"))); // NOI18N
    btnSearchIssued.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchIssuedActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout panelBooksIssuedLayout = new javax.swing.GroupLayout(panelBooksIssued);
    panelBooksIssued.setLayout(panelBooksIssuedLayout);
    panelBooksIssuedLayout.setHorizontalGroup(
        panelBooksIssuedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBooksIssuedLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel8)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtSearchIssued, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSearchIssued, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPrintIssued, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelBooksIssuedLayout.setVerticalGroup(
        panelBooksIssuedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBooksIssuedLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelBooksIssuedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBooksIssuedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrintIssued, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBooksIssuedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearchIssued, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(btnSearchIssued, javax.swing.GroupLayout.Alignment.TRAILING))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelBooksIssued, "card2");

    panelShortLoanBooks.setBackground(new java.awt.Color(51, 102, 255));

    jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    jLabel9.setText("Short loan books");

    jPanel20.setBackground(new java.awt.Color(129, 186, 243));

    tableShortLoanBook.setModel(new javax.swing.table.DefaultTableModel(
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
    tableShortLoanBook.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableShortLoanBookMouseClicked(evt);
        }
    });
    jScrollPane11.setViewportView(tableShortLoanBook);

    jPanel33.setBackground(new java.awt.Color(129, 186, 243));
    jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP));

    txtShortBkTitle.setEditable(false);
    txtShortBkTitle.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtShortBkTitleActionPerformed(evt);
        }
    });

    jLabel58.setText("Book title ;");

    txtStaffstdId.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtStaffstdIdKeyTyped(evt);
        }
    });

    txtShortClass.setEditable(false);
    txtShortClass.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtShortClassKeyTyped(evt);
        }
    });

    SpinfieldTimeLoan.setBackground(new java.awt.Color(129, 186, 243));
    SpinfieldTimeLoan.setToolTipText("select borrowing duration");

    jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel55.setText("Duration :");

    jLabel61.setText("Class/Form :");

    jLabel35.setText("First name :");

    txtShortDept.setEditable(false);

    jLabel56.setText("Issue to :");

    jLabel11.setText("ID/Adm No :");

    jLabel72.setText("Department :");

    txtStaffNo.setEditable(false);
    txtStaffNo.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtStaffNoKeyTyped(evt);
        }
    });

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrow_16.png"))); // NOI18N
    jButton1.setToolTipText("add book");
    jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    jButton1.setContentAreaFilled(false);
    jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrowwhite_16.png"))); // NOI18N
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jLabel57.setText("Book ISBN :");

    btnCancelShort.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnCancelShort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelblack_16.png"))); // NOI18N
    btnCancelShort.setText("Cancel");
    btnCancelShort.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnCancelShort.setContentAreaFilled(false);
    btnCancelShort.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelred_16.png"))); // NOI18N
    btnCancelShort.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelShortActionPerformed(evt);
        }
    });

    jLabel36.setText("Last name :");

    jLabel54.setText("Phone No :");

    txtShortBkIsbn.setEditable(false);

    jLabel38.setText("Book ID :");

    btnIssueShort.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnIssueShort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/issueBookblack_16.png"))); // NOI18N
    btnIssueShort.setText("Issue");
    btnIssueShort.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnIssueShort.setContentAreaFilled(false);
    btnIssueShort.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/issuebookgreen_16.png"))); // NOI18N
    btnIssueShort.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnIssueShortActionPerformed(evt);
        }
    });

    btnSearchStdStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
    btnSearchStdStaff.setBorder(null);
    btnSearchStdStaff.setContentAreaFilled(false);
    btnSearchStdStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSearchStdStaff.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchwhite_16.png"))); // NOI18N
    btnSearchStdStaff.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchStdStaffActionPerformed(evt);
        }
    });

    txtShortBkId.setEditable(false);

    comboStaffStudent.setBackground(new java.awt.Color(129, 186, 243));
    comboStaffStudent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "STUDENT", "STAFF" }));
    comboStaffStudent.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            comboStaffStudentItemStateChanged(evt);
        }
    });

    jLabel59.setText("HRS");

    javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
    jPanel33.setLayout(jPanel33Layout);
    jPanel33Layout.setHorizontalGroup(
        jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel33Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                    .addComponent(jLabel11)
                    .addGap(204, 204, 204)
                    .addComponent(btnSearchStdStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel54)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStaffNo)
                            .addComponent(txtShortClass, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                            .addComponent(jLabel57)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtShortBkIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                            .addComponent(jLabel38)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtShortBkId, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                            .addComponent(jLabel72)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtShortDept, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtShortBkTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel33Layout.createSequentialGroup()
                                        .addComponent(btnIssueShort, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(btnCancelShort, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel33Layout.createSequentialGroup()
                                        .addComponent(SpinfieldTimeLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel59)))))))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel35))
                        .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtStaffstdId, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtShortLname)
                            .addComponent(txtShortFname, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(comboStaffStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap())
    );
    jPanel33Layout.setVerticalGroup(
        jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(comboStaffStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel56))
            .addGap(19, 19, 19)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtStaffstdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(btnSearchStdStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel35)
                .addComponent(txtShortFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel36)
                .addComponent(txtShortLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtShortClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel61))
            .addGap(18, 18, 18)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtStaffNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel54))
            .addGap(18, 18, 18)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtShortDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel72))
            .addGap(15, 15, 15)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtShortBkId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel57)
                .addComponent(txtShortBkIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(15, 15, 15)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel58)
                .addComponent(txtShortBkTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SpinfieldTimeLoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(28, 28, 28)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnIssueShort, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnCancelShort, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(27, 27, 27))
    );

    jPanel38.setBackground(new java.awt.Color(129, 186, 243));
    jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    comboSearchShort.setBackground(new java.awt.Color(129, 186, 243));
    comboSearchShort.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select category to display", "Arts & Recreation", "Computers, IT & General Works", "History & Geography", "Literature", "Languages", "Philosophy & Psychology", "Religion", "Science", "Social Sciences", "Technology & Applied Science" }));
    comboSearchShort.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            comboSearchShortItemStateChanged(evt);
        }
    });

    btnRefreshShortBks.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnRefreshShortBks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh_16.png"))); // NOI18N
    btnRefreshShortBks.setText("Refresh");
    btnRefreshShortBks.setToolTipText("refresh table");
    btnRefreshShortBks.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnRefreshShortBks.setContentAreaFilled(false);
    btnRefreshShortBks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnRefreshShortBks.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refreshwhite_16.png"))); // NOI18N
    btnRefreshShortBks.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnRefreshShortBksMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnRefreshShortBksMouseExited(evt);
        }
    });
    btnRefreshShortBks.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRefreshShortBksActionPerformed(evt);
        }
    });

    txtSearchShort.setToolTipText("type book ID");
    txtSearchShort.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtSearchShortKeyTyped(evt);
        }
    });

    btnSearchShortLoanBks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
    btnSearchShortLoanBks.setContentAreaFilled(false);
    btnSearchShortLoanBks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSearchShortLoanBks.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchred_16.png"))); // NOI18N
    btnSearchShortLoanBks.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchShortLoanBksActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
    jPanel38.setLayout(jPanel38Layout);
    jPanel38Layout.setHorizontalGroup(
        jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel38Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btnRefreshShortBks, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtSearchShort, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSearchShortLoanBks, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(comboSearchShort, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    jPanel38Layout.setVerticalGroup(
        jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel38Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearchShort)
                    .addComponent(btnSearchShortLoanBks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefreshShortBks, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(comboSearchShort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
    jPanel20.setLayout(jPanel20Layout);
    jPanel20Layout.setHorizontalGroup(
        jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel20Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())))
    );
    jPanel20Layout.setVerticalGroup(
        jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel20Layout.createSequentialGroup()
            .addGap(9, 9, 9)
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))))
    );

    javax.swing.GroupLayout panelShortLoanBooksLayout = new javax.swing.GroupLayout(panelShortLoanBooks);
    panelShortLoanBooks.setLayout(panelShortLoanBooksLayout);
    panelShortLoanBooksLayout.setHorizontalGroup(
        panelShortLoanBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelShortLoanBooksLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel9)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelShortLoanBooksLayout.setVerticalGroup(
        panelShortLoanBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelShortLoanBooksLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelShortLoanBooks, "card2");

    panelManageUsers.setBackground(new java.awt.Color(51, 102, 255));

    jLabel12.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(255, 255, 255));
    jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    jLabel12.setText("Manage users");

    jPanel21.setBackground(new java.awt.Color(129, 186, 243));

    panelHolderManageUsers.setLayout(new java.awt.CardLayout());

    panelUsersView.setBackground(new java.awt.Color(129, 186, 243));
    panelUsersView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

    tableUsers.setModel(new javax.swing.table.DefaultTableModel(
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
    tableUsers.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableUsersMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tableUsers);

    txtSearchUser.setToolTipText("enter user id");
    txtSearchUser.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtSearchUserKeyTyped(evt);
        }
    });

    btnSearchUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
    btnSearchUser.setContentAreaFilled(false);
    btnSearchUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSearchUser.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchred_16.png"))); // NOI18N
    btnSearchUser.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchUserActionPerformed(evt);
        }
    });

    btnRefreshUserTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh_16.png"))); // NOI18N
    btnRefreshUserTable.setToolTipText("refresh table");
    btnRefreshUserTable.setContentAreaFilled(false);
    btnRefreshUserTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnRefreshUserTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh2_16.png"))); // NOI18N
    btnRefreshUserTable.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRefreshUserTableActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout panelUsersViewLayout = new javax.swing.GroupLayout(panelUsersView);
    panelUsersView.setLayout(panelUsersViewLayout);
    panelUsersViewLayout.setHorizontalGroup(
        panelUsersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsersViewLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRefreshUserTable)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(39, 39, 39))
    );
    panelUsersViewLayout.setVerticalGroup(
        panelUsersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsersViewLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelUsersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSearchUser)
                .addComponent(btnRefreshUserTable))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
    );

    panelHolderManageUsers.add(panelUsersView, "card2");

    panelSessionLogs.setBackground(new java.awt.Color(153, 153, 255));
    panelSessionLogs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    tableSessionLogs.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane2.setViewportView(tableSessionLogs);

    btnPrintSession.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnPrintSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print_16.png"))); // NOI18N
    btnPrintSession.setText("Print");
    btnPrintSession.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnPrintSession.setContentAreaFilled(false);
    btnPrintSession.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnPrintSession.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Printred_16.png"))); // NOI18N
    btnPrintSession.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnPrintSessionMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnPrintSessionMouseExited(evt);
        }
    });
    btnPrintSession.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnPrintSessionActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout panelSessionLogsLayout = new javax.swing.GroupLayout(panelSessionLogs);
    panelSessionLogs.setLayout(panelSessionLogsLayout);
    panelSessionLogsLayout.setHorizontalGroup(
        panelSessionLogsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSessionLogsLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPrintSession, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    panelSessionLogsLayout.setVerticalGroup(
        panelSessionLogsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelSessionLogsLayout.createSequentialGroup()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnPrintSession, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    panelHolderManageUsers.add(panelSessionLogs, "card2");

    panelAddUsers.setBackground(new java.awt.Color(153, 153, 255));
    panelAddUsers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    txtIdNo.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtIdNoKeyTyped(evt);
        }
    });

    jLabel10.setText("ID number ;");

    jLabel13.setText("First name :");

    jLabel14.setText("Last name :");

    jLabel15.setText("Department :");

    jLabel16.setText("Username :");

    jLabel17.setText("Password :");

    jLabel18.setText("Retype password :");

    jButton12.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Addblack_16.png"))); // NOI18N
    jButton12.setText("Add");
    jButton12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    jButton12.setContentAreaFilled(false);
    jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add_16.png"))); // NOI18N
    jButton12.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton12ActionPerformed(evt);
        }
    });

    jButton13.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelblack_16.png"))); // NOI18N
    jButton13.setText("Cancel");
    jButton13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    jButton13.setContentAreaFilled(false);
    jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelred_16.png"))); // NOI18N

    javax.swing.GroupLayout panelAddUsersLayout = new javax.swing.GroupLayout(panelAddUsers);
    panelAddUsers.setLayout(panelAddUsersLayout);
    panelAddUsersLayout.setHorizontalGroup(
        panelAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelAddUsersLayout.createSequentialGroup()
            .addContainerGap(229, Short.MAX_VALUE)
            .addGroup(panelAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel10)
                .addComponent(jLabel13)
                .addComponent(jLabel14)
                .addComponent(jLabel15)
                .addComponent(jLabel16)
                .addComponent(jLabel17)
                .addComponent(jLabel18))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(panelAddUsersLayout.createSequentialGroup()
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addComponent(txtDept, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addComponent(txtLname, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addComponent(txtFname, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addComponent(txtIdNo)
                .addComponent(txtPass)
                .addComponent(txtConfPass))
            .addContainerGap(248, Short.MAX_VALUE))
    );
    panelAddUsersLayout.setVerticalGroup(
        panelAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelAddUsersLayout.createSequentialGroup()
            .addContainerGap(99, Short.MAX_VALUE)
            .addGroup(panelAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtIdNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel10))
            .addGap(18, 18, 18)
            .addGroup(panelAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel13))
            .addGap(18, 18, 18)
            .addGroup(panelAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel14))
            .addGap(18, 18, 18)
            .addGroup(panelAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel15))
            .addGap(18, 18, 18)
            .addGroup(panelAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel16))
            .addGap(18, 18, 18)
            .addGroup(panelAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel17))
            .addGap(18, 18, 18)
            .addGroup(panelAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtConfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel18))
            .addGap(68, 68, 68)
            .addGroup(panelAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(79, Short.MAX_VALUE))
    );

    panelHolderManageUsers.add(panelAddUsers, "card2");

    btnusersInfo.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnusersInfo.setText("View Users");
    btnusersInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnusersInfo.setContentAreaFilled(false);
    btnusersInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnusersInfo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnusersInfoActionPerformed(evt);
        }
    });

    btnUsersSessions.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnUsersSessions.setText("Session Logs");
    btnUsersSessions.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnUsersSessions.setContentAreaFilled(false);
    btnUsersSessions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnUsersSessions.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnUsersSessionsActionPerformed(evt);
        }
    });

    btnAddNewUsers.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnAddNewUsers.setText("Add Users");
    btnAddNewUsers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnAddNewUsers.setContentAreaFilled(false);
    btnAddNewUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnAddNewUsers.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddNewUsersActionPerformed(evt);
        }
    });

    btnPassReset.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnPassReset.setText("Password reset");
    btnPassReset.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnPassReset.setContentAreaFilled(false);
    btnPassReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnPassReset.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnPassResetActionPerformed(evt);
        }
    });

    btnPermissions.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnPermissions.setText("Permissions");
    btnPermissions.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnPermissions.setContentAreaFilled(false);
    btnPermissions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnPermissions.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnPermissionsActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
    jPanel21.setLayout(jPanel21Layout);
    jPanel21Layout.setHorizontalGroup(
        jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(btnUsersSessions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addComponent(btnusersInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddNewUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPassReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPermissions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(panelHolderManageUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel21Layout.setVerticalGroup(
        jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panelHolderManageUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel21Layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(btnusersInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btnUsersSessions, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btnAddNewUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btnPermissions, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btnPassReset, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout panelManageUsersLayout = new javax.swing.GroupLayout(panelManageUsers);
    panelManageUsers.setLayout(panelManageUsersLayout);
    panelManageUsersLayout.setHorizontalGroup(
        panelManageUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelManageUsersLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel12)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelManageUsersLayout.setVerticalGroup(
        panelManageUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelManageUsersLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(12, 12, 12)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelManageUsers, "card2");

    panelReportLost.setBackground(new java.awt.Color(51, 102, 255));

    jLabel45.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel45.setForeground(new java.awt.Color(255, 255, 255));
    jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    jLabel45.setText("Report Book as Lost");

    panelLostBooks.setBackground(new java.awt.Color(129, 186, 243));

    tableBookLost.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    )
    {public boolean isCellEditable(int row, int column){return false;}}
    );
    tableBookLost.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableBookLostMouseClicked(evt);
        }
    });
    jScrollPane12.setViewportView(tableBookLost);

    txtSearchLost.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtSearchLostKeyTyped(evt);
        }
    });

    searchLost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
    searchLost.setToolTipText("search books in stock");
    searchLost.setContentAreaFilled(false);
    searchLost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    searchLost.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchwhite_16.png"))); // NOI18N
    searchLost.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchLostActionPerformed(evt);
        }
    });

    comboFilterLost.setBackground(new java.awt.Color(129, 186, 243));
    comboFilterLost.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Filter by :", "Arts & Recreation", "Computers, IT & General Works", "History & Geography", "Literature", "Languages", "Philosophy & Psychology", "Religion", "Science", "Social Sciences", "Technology & Applied Science" }));
    comboFilterLost.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            comboFilterLostItemStateChanged(evt);
        }
    });

    txtBookIDlost.setEditable(false);
    txtBookIDlost.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtBookIDlostKeyTyped(evt);
        }
    });

    btnAddBkLost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrow_16.png"))); // NOI18N
    btnAddBkLost.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnAddBkLost.setContentAreaFilled(false);
    btnAddBkLost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnAddBkLost.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrowwhite_16.png"))); // NOI18N
    btnAddBkLost.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddBkLostActionPerformed(evt);
        }
    });

    jLabel65.setText("Book ID :");

    jPanel22.setBackground(new java.awt.Color(129, 186, 243));
    jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Issued to", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

    txtIDLost.setEditable(false);

    jLabel66.setText("Adm no/ID number :");

    jLabel67.setText("First name :");

    txtFnameLost.setEditable(false);

    jLabel68.setText("Last name :");

    txtLnameLost.setEditable(false);

    jLabel69.setText("Staff/Student :");

    txtStaffLost.setEditable(false);

    javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
    jPanel22.setLayout(jPanel22Layout);
    jPanel22Layout.setHorizontalGroup(
        jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel22Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtFnameLost)
                .addComponent(txtLnameLost)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel66)
                        .addComponent(jLabel67)
                        .addComponent(jLabel68)
                        .addComponent(jLabel69)
                        .addComponent(txtIDLost, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtStaffLost, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    jPanel22Layout.setVerticalGroup(
        jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel22Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel66)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtIDLost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel67)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtFnameLost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel68)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtLnameLost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel69)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtStaffLost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(17, Short.MAX_VALUE))
    );

    btnLostConf.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnLostConf.setText("Confirm");
    btnLostConf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnLostConf.setContentAreaFilled(false);
    btnLostConf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnLostConf.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLostConfActionPerformed(evt);
        }
    });

    jLabel70.setText("Book Title :");

    txtBookTitleLost.setEditable(false);

    jLabel71.setText("Book ISBN :");

    txtIsbnLost.setEditable(false);

    btnCancel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnCancel.setText("Cancel");
    btnCancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnCancel.setContentAreaFilled(false);
    btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout panelLostBooksLayout = new javax.swing.GroupLayout(panelLostBooks);
    panelLostBooks.setLayout(panelLostBooksLayout);
    panelLostBooksLayout.setHorizontalGroup(
        panelLostBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelLostBooksLayout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addGroup(panelLostBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(panelLostBooksLayout.createSequentialGroup()
                    .addComponent(jLabel65)
                    .addGap(226, 226, 226))
                .addGroup(panelLostBooksLayout.createSequentialGroup()
                    .addGroup(panelLostBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLostBooksLayout.createSequentialGroup()
                            .addComponent(txtBookIDlost)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAddBkLost, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtBookTitleLost)
                        .addComponent(txtIsbnLost)
                        .addGroup(panelLostBooksLayout.createSequentialGroup()
                            .addGroup(panelLostBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel70)
                                .addComponent(jLabel71))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(panelLostBooksLayout.createSequentialGroup()
                            .addComponent(btnLostConf, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
            .addGroup(panelLostBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLostBooksLayout.createSequentialGroup()
                    .addComponent(comboFilterLost, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchLost, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(searchLost, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14))
                .addGroup(panelLostBooksLayout.createSequentialGroup()
                    .addComponent(jScrollPane12)
                    .addContainerGap())))
    );
    panelLostBooksLayout.setVerticalGroup(
        panelLostBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelLostBooksLayout.createSequentialGroup()
            .addGroup(panelLostBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLostBooksLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(panelLostBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearchLost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboFilterLost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLostBooksLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(searchLost, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(8, 8, 8)
            .addGroup(panelLostBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLostBooksLayout.createSequentialGroup()
                    .addComponent(jScrollPane12)
                    .addContainerGap())
                .addGroup(panelLostBooksLayout.createSequentialGroup()
                    .addComponent(jLabel65)
                    .addGap(5, 5, 5)
                    .addGroup(panelLostBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBookIDlost)
                        .addComponent(btnAddBkLost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel70)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtBookTitleLost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel71)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtIsbnLost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(panelLostBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLostConf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26))))
    );

    javax.swing.GroupLayout panelReportLostLayout = new javax.swing.GroupLayout(panelReportLost);
    panelReportLost.setLayout(panelReportLostLayout);
    panelReportLostLayout.setHorizontalGroup(
        panelReportLostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelReportLostLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(859, Short.MAX_VALUE))
        .addComponent(panelLostBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelReportLostLayout.setVerticalGroup(
        panelReportLostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelReportLostLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(panelLostBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelReportLost, "card2");

    panelStudents.setBackground(new java.awt.Color(51, 102, 255));

    jLabel75.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel75.setForeground(new java.awt.Color(255, 255, 255));
    jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    jLabel75.setText("List of Student borrowers");

    jPanel23.setBackground(new java.awt.Color(129, 186, 243));

    tableStudents.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane13.setViewportView(tableStudents);

    btnWriteStdToExcel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnWriteStdToExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Microsoft_Excel_16.png"))); // NOI18N
    btnWriteStdToExcel.setText("Export to excel");
    btnWriteStdToExcel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnWriteStdToExcel.setContentAreaFilled(false);
    btnWriteStdToExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnWriteStdToExcel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MicrosoftExcelred_16.png"))); // NOI18N
    btnWriteStdToExcel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnWriteStdToExcelActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
    jPanel23.setLayout(jPanel23Layout);
    jPanel23Layout.setHorizontalGroup(
        jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnWriteStdToExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    jPanel23Layout.setVerticalGroup(
        jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel23Layout.createSequentialGroup()
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnWriteStdToExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    txtStdIdSearch.setToolTipText("");
    txtStdIdSearch.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtStdIdSearchKeyTyped(evt);
        }
    });

    btnSearchStdID.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnSearchStdID.setForeground(new java.awt.Color(255, 255, 255));
    btnSearchStdID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchwhite_16.png"))); // NOI18N
    btnSearchStdID.setContentAreaFilled(false);
    btnSearchStdID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSearchStdID.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchred_16.png"))); // NOI18N
    btnSearchStdID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchStdIDActionPerformed(evt);
        }
    });

    jLabel60.setForeground(new java.awt.Color(255, 255, 255));
    jLabel60.setText("Enter student ID :");

    comboFilterStudents.setBackground(new java.awt.Color(255, 255, 255));
    comboFilterStudents.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Filter by returned :", "YES", "NO" }));
    comboFilterStudents.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            comboFilterStudentsItemStateChanged(evt);
        }
    });

    javax.swing.GroupLayout panelStudentsLayout = new javax.swing.GroupLayout(panelStudents);
    panelStudents.setLayout(panelStudentsLayout);
    panelStudentsLayout.setHorizontalGroup(
        panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelStudentsLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel75)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(comboFilterStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel60)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtStdIdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSearchStdID, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelStudentsLayout.setVerticalGroup(
        panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelStudentsLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtStdIdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSearchStdID)
                .addComponent(jLabel60)
                .addComponent(comboFilterStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(4, 4, 4)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelStudents, "card2");

    panelTeachers.setBackground(new java.awt.Color(51, 102, 255));

    labelStaffList.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    labelStaffList.setForeground(new java.awt.Color(255, 255, 255));
    labelStaffList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    labelStaffList.setText("List ofStaff borrowers");

    jPanel24.setBackground(new java.awt.Color(129, 186, 243));

    tableStaff.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane14.setViewportView(tableStaff);

    jButton2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Microsoft_Excel_16.png"))); // NOI18N
    jButton2.setText("Export to excel");
    jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    jButton2.setContentAreaFilled(false);
    jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MicrosoftExcelred_16.png"))); // NOI18N
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
    jPanel24.setLayout(jPanel24Layout);
    jPanel24Layout.setHorizontalGroup(
        jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    jPanel24Layout.setVerticalGroup(
        jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel24Layout.createSequentialGroup()
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    txtStaffIdList.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtStaffIdListKeyTyped(evt);
        }
    });

    btnSearchStaffId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchwhite_16.png"))); // NOI18N
    btnSearchStaffId.setContentAreaFilled(false);
    btnSearchStaffId.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSearchStaffId.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchred_16.png"))); // NOI18N
    btnSearchStaffId.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchStaffIdActionPerformed(evt);
        }
    });

    jLabel92.setForeground(new java.awt.Color(255, 255, 255));
    jLabel92.setText("Enter staff ID :");

    comboFiletStaff.setBackground(new java.awt.Color(255, 255, 255));
    comboFiletStaff.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Filter by returned :", "YES", "NO" }));
    comboFiletStaff.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            comboFiletStaffItemStateChanged(evt);
        }
    });

    javax.swing.GroupLayout panelTeachersLayout = new javax.swing.GroupLayout(panelTeachers);
    panelTeachers.setLayout(panelTeachersLayout);
    panelTeachersLayout.setHorizontalGroup(
        panelTeachersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelTeachersLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(labelStaffList)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(comboFiletStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel92)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtStaffIdList, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSearchStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelTeachersLayout.setVerticalGroup(
        panelTeachersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelTeachersLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelTeachersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(panelTeachersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStaffIdList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchStaffId)
                    .addComponent(jLabel92)
                    .addComponent(comboFiletStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(labelStaffList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(8, 8, 8)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelTeachers, "card2");

    panelMags.setBackground(new java.awt.Color(51, 102, 255));

    labelMagz.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    labelMagz.setForeground(new java.awt.Color(255, 255, 255));
    labelMagz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    labelMagz.setText("Magazines and Journals");

    panelMagsIn.setBackground(new java.awt.Color(129, 186, 243));

    tableMags.setModel(new javax.swing.table.DefaultTableModel(
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
    tableMags.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableMagsMouseClicked(evt);
        }
    });
    jScrollPane4.setViewportView(tableMags);

    jPanel25.setBackground(new java.awt.Color(129, 186, 243));
    jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Enter details of borrower", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("sansserif", 0, 12))); // NOI18N

    txtMagzNameID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtMagzNameIDKeyTyped(evt);
        }
    });

    labelId.setText("Adm No/ID :");

    comboMagz.setBackground(new java.awt.Color(129, 186, 243));
    comboMagz.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select", "STUDENT", "STAFF" }));
    comboMagz.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            comboMagzItemStateChanged(evt);
        }
    });

    jLabel80.setText("Student/staff :");

    labelId1.setText("First name :");

    labelId2.setText("Last name :");

    txtMagzClass.setEditable(false);

    labelId3.setText("Class/Form :");

    txtMagzPhone.setEditable(false);
    txtMagzPhone.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtMagzPhoneKeyTyped(evt);
        }
    });

    labelId4.setText("Phone No :");

    txtMagzDept.setEditable(false);

    labelId5.setText("Department :");

    txtMagzTitle.setEditable(false);

    labelId6.setText("Magazine Title :");

    btnSearchForMagIssue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search_16.png"))); // NOI18N
    btnSearchForMagIssue.setBorder(null);
    btnSearchForMagIssue.setContentAreaFilled(false);
    btnSearchForMagIssue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSearchForMagIssue.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchwhite_16.png"))); // NOI18N
    btnSearchForMagIssue.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchForMagIssueActionPerformed(evt);
        }
    });

    labelId7.setText("Magazine date :");

    txtMagzDate.setEditable(false);

    labelId8.setText("Date borrowed :");

    labelId9.setText("Date due :");

    txtMagzIssueNo.setEditable(false);

    labelId10.setText("Issue No :");

    chooserMagzDue.setBackground(new java.awt.Color(129, 186, 243));

    chooserMagzBoro.setBackground(new java.awt.Color(129, 186, 243));

    btnMagzIssue.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnMagzIssue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/issueBookblack_16.png"))); // NOI18N
    btnMagzIssue.setText("Issue");
    btnMagzIssue.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnMagzIssue.setContentAreaFilled(false);
    btnMagzIssue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnMagzIssue.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/issuebookgreen_16.png"))); // NOI18N
    btnMagzIssue.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMagzIssueActionPerformed(evt);
        }
    });

    btnMagzCancel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnMagzCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelblack_16.png"))); // NOI18N
    btnMagzCancel.setText("Cancel");
    btnMagzCancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnMagzCancel.setContentAreaFilled(false);
    btnMagzCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnMagzCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelred_16.png"))); // NOI18N
    btnMagzCancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMagzCancelActionPerformed(evt);
        }
    });

    btnAddMagToIssue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrow_16.png"))); // NOI18N
    btnAddMagToIssue.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnAddMagToIssue.setContentAreaFilled(false);
    btnAddMagToIssue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnAddMagToIssue.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrowwhite_16.png"))); // NOI18N
    btnAddMagToIssue.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddMagToIssueActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
    jPanel25.setLayout(jPanel25Layout);
    jPanel25Layout.setHorizontalGroup(
        jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel25Layout.createSequentialGroup()
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jLabel80)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboMagz, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addComponent(labelId2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMagzName2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(labelId1)
                                            .addComponent(labelId))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel25Layout.createSequentialGroup()
                                                .addComponent(txtMagzNameID)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSearchForMagIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtMagzName1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addComponent(labelId3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMagzClass, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addComponent(labelId4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMagzPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addComponent(labelId5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMagzDept, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addComponent(labelId10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMagzIssueNo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddMagToIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel25Layout.createSequentialGroup()
                            .addComponent(labelId7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMagzDate, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel25Layout.createSequentialGroup()
                            .addComponent(labelId6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMagzTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel25Layout.createSequentialGroup()
                            .addComponent(labelId9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(chooserMagzDue, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel25Layout.createSequentialGroup()
                            .addComponent(btnMagzIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(93, 93, 93)
                            .addComponent(btnMagzCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(labelId8)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(chooserMagzBoro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGap(23, 23, 23))
    );
    jPanel25Layout.setVerticalGroup(
        jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel25Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(comboMagz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel80))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnSearchForMagIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(txtMagzNameID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelId1)
                .addComponent(txtMagzName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelId2)
                .addComponent(txtMagzName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelId3)
                .addComponent(txtMagzClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelId4)
                .addComponent(txtMagzPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelId5)
                .addComponent(txtMagzDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnAddMagToIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId10)
                    .addComponent(txtMagzIssueNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelId6)
                .addComponent(txtMagzTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelId7)
                .addComponent(txtMagzDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(labelId8)
                    .addGap(24, 24, 24)
                    .addComponent(labelId9))
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(chooserMagzBoro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)
                    .addComponent(chooserMagzDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnMagzIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnMagzCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(23, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout panelMagsInLayout = new javax.swing.GroupLayout(panelMagsIn);
    panelMagsIn.setLayout(panelMagsInLayout);
    panelMagsInLayout.setHorizontalGroup(
        panelMagsInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMagsInLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
            .addContainerGap())
    );
    panelMagsInLayout.setVerticalGroup(
        panelMagsInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelMagsInLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelMagsInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4)
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );

    btnAddMag.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnAddMag.setForeground(new java.awt.Color(255, 255, 255));
    btnAddMag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add_16.png"))); // NOI18N
    btnAddMag.setText("Add");
    btnAddMag.setToolTipText("add a mgazine/journal");
    btnAddMag.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnAddMag.setContentAreaFilled(false);
    btnAddMag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnAddMag.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Addred_16.png"))); // NOI18N
    btnAddMag.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddMagActionPerformed(evt);
        }
    });

    btnMagzDetails.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnMagzDetails.setForeground(new java.awt.Color(255, 255, 255));
    btnMagzDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/More_Details_16.png"))); // NOI18N
    btnMagzDetails.setText("Details");
    btnMagzDetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnMagzDetails.setContentAreaFilled(false);
    btnMagzDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnMagzDetails.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/More_Detailsred_16.png"))); // NOI18N
    btnMagzDetails.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMagzDetailsActionPerformed(evt);
        }
    });

    chooserMagz.setBackground(new java.awt.Color(51, 102, 255));

    btnSearchMagz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchwhite_16.png"))); // NOI18N
    btnSearchMagz.setToolTipText("search magazines");
    btnSearchMagz.setBorder(null);
    btnSearchMagz.setContentAreaFilled(false);
    btnSearchMagz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSearchMagz.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchred_16.png"))); // NOI18N
    btnSearchMagz.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchMagzActionPerformed(evt);
        }
    });

    labelSearchInMagzPanel.setForeground(new java.awt.Color(255, 255, 255));
    labelSearchInMagzPanel.setText("Search by date :");

    btnRecieveMagz.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnRecieveMagz.setForeground(new java.awt.Color(255, 255, 255));
    btnRecieveMagz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/acceptbookwhite_16.png"))); // NOI18N
    btnRecieveMagz.setText("Recieve");
    btnRecieveMagz.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnRecieveMagz.setContentAreaFilled(false);
    btnRecieveMagz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnRecieveMagz.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRecieveMagzActionPerformed(evt);
        }
    });

    btnRefreshMagz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refreshwhite_16.png"))); // NOI18N
    btnRefreshMagz.setToolTipText("Refresh table");
    btnRefreshMagz.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnRefreshMagz.setContentAreaFilled(false);
    btnRefreshMagz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnRefreshMagz.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh2_16.png"))); // NOI18N
    btnRefreshMagz.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRefreshMagzActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout panelMagsLayout = new javax.swing.GroupLayout(panelMags);
    panelMags.setLayout(panelMagsLayout);
    panelMagsLayout.setHorizontalGroup(
        panelMagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelMagsLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(labelMagz)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRefreshMagz, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(labelSearchInMagzPanel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(chooserMagz, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSearchMagz, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btnMagzDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnAddMag, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnRecieveMagz, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        .addComponent(panelMagsIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelMagsLayout.setVerticalGroup(
        panelMagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelMagsLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelMagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(panelMagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMagzDetails, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddMag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRecieveMagz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnRefreshMagz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelMagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMagz, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSearchInMagzPanel))))
                .addComponent(chooserMagz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearchMagz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(8, 8, 8)
            .addComponent(panelMagsIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelMags, "card2");

    panelMagzBorrowers.setBackground(new java.awt.Color(51, 102, 255));

    labelMagzBorrowed.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    labelMagzBorrowed.setForeground(new java.awt.Color(255, 255, 255));
    labelMagzBorrowed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    labelMagzBorrowed.setText("Magazines borrowed");

    jPanel26.setBackground(new java.awt.Color(129, 186, 243));

    tableMagzBoro.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane15.setViewportView(tableMagzBoro);

    javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
    jPanel26.setLayout(jPanel26Layout);
    jPanel26Layout.setHorizontalGroup(
        jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane15)
    );
    jPanel26Layout.setVerticalGroup(
        jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
    );

    btnRefreshMagzBoro.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnRefreshMagzBoro.setForeground(new java.awt.Color(255, 255, 255));
    btnRefreshMagzBoro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refreshwhite_16.png"))); // NOI18N
    btnRefreshMagzBoro.setToolTipText("refresh");
    btnRefreshMagzBoro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnRefreshMagzBoro.setContentAreaFilled(false);
    btnRefreshMagzBoro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnRefreshMagzBoro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh2_16.png"))); // NOI18N
    btnRefreshMagzBoro.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRefreshMagzBoroActionPerformed(evt);
        }
    });

    txtSearchMagzBorrowed.setToolTipText("enter  borrower id");

    btnSearchBoroMagz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchwhite_16.png"))); // NOI18N
    btnSearchBoroMagz.setContentAreaFilled(false);
    btnSearchBoroMagz.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Searchred_16.png"))); // NOI18N
    btnSearchBoroMagz.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchBoroMagzActionPerformed(evt);
        }
    });

    btnMagzToExcel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnMagzToExcel.setForeground(new java.awt.Color(255, 255, 255));
    btnMagzToExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Microsoftwhitel_16.png"))); // NOI18N
    btnMagzToExcel.setText("Export to excel");
    btnMagzToExcel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnMagzToExcel.setContentAreaFilled(false);
    btnMagzToExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnMagzToExcel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MicrosoftExcelred_16.png"))); // NOI18N
    btnMagzToExcel.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnMagzToExcelMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnMagzToExcelMouseExited(evt);
        }
    });
    btnMagzToExcel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnMagzToExcelActionPerformed(evt);
        }
    });

    comboMagzFilter.setBackground(new java.awt.Color(51, 102, 255));
    comboMagzFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Filter by :", "STUDENT", "STAFF" }));
    comboMagzFilter.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            comboMagzFilterItemStateChanged(evt);
        }
    });

    javax.swing.GroupLayout panelMagzBorrowersLayout = new javax.swing.GroupLayout(panelMagzBorrowers);
    panelMagzBorrowers.setLayout(panelMagzBorrowersLayout);
    panelMagzBorrowersLayout.setHorizontalGroup(
        panelMagzBorrowersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelMagzBorrowersLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(labelMagzBorrowed)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txtSearchMagzBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSearchBoroMagz, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
            .addComponent(comboMagzFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnRefreshMagzBoro, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnMagzToExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelMagzBorrowersLayout.setVerticalGroup(
        panelMagzBorrowersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelMagzBorrowersLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelMagzBorrowersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(labelMagzBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnMagzToExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(comboMagzFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelMagzBorrowersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchBoroMagz, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearchMagzBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(btnRefreshMagzBoro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelMagzBorrowers, "card2");

    panelSchedules.setBackground(new java.awt.Color(51, 102, 255));

    labelMagzBorrowed1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    labelMagzBorrowed1.setForeground(new java.awt.Color(255, 255, 255));
    labelMagzBorrowed1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bookscolor.png"))); // NOI18N
    labelMagzBorrowed1.setText("Schedules and Notes");

    jPanel27.setBackground(new java.awt.Color(129, 186, 243));

    jPanel29.setBackground(new java.awt.Color(129, 186, 243));
    jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Schedules", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

    tableSchedules.setModel(new javax.swing.table.DefaultTableModel(
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
    tableSchedules.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableSchedulesMouseClicked(evt);
        }
    });
    jScrollPane17.setViewportView(tableSchedules);

    panelSchedulesCreate.setBackground(new java.awt.Color(129, 186, 243));
    panelSchedulesCreate.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Create schedule", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

    txtSchInfo.setColumns(20);
    txtSchInfo.setRows(5);
    jScrollPane16.setViewportView(txtSchInfo);

    chooserschDate.setBackground(new java.awt.Color(129, 186, 243));

    jLabel81.setText("Schedule Title :");

    jLabel82.setText("Schedule information :");

    jLabel83.setText("Schedule date :");

    btnCreateSch.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnCreateSch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/createBlack_16.png"))); // NOI18N
    btnCreateSch.setText("Create");
    btnCreateSch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnCreateSch.setContentAreaFilled(false);
    btnCreateSch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnCreateSch.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Createwhite_16.png"))); // NOI18N
    btnCreateSch.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCreateSchActionPerformed(evt);
        }
    });

    btnCancelSch.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnCancelSch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelblack_16.png"))); // NOI18N
    btnCancelSch.setText("Cancel");
    btnCancelSch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnCancelSch.setContentAreaFilled(false);
    btnCancelSch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnCancelSch.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelred_16.png"))); // NOI18N

    javax.swing.GroupLayout panelSchedulesCreateLayout = new javax.swing.GroupLayout(panelSchedulesCreate);
    panelSchedulesCreate.setLayout(panelSchedulesCreateLayout);
    panelSchedulesCreateLayout.setHorizontalGroup(
        panelSchedulesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSchedulesCreateLayout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addGroup(panelSchedulesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel83, javax.swing.GroupLayout.Alignment.TRAILING))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelSchedulesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane16)
                .addComponent(txtschtitle)
                .addGroup(panelSchedulesCreateLayout.createSequentialGroup()
                    .addGroup(panelSchedulesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelSchedulesCreateLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                            .addComponent(btnCreateSch, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(chooserschDate, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnCancelSch, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    panelSchedulesCreateLayout.setVerticalGroup(
        panelSchedulesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelSchedulesCreateLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelSchedulesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtschtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel81))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelSchedulesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane16)
                .addComponent(jLabel82))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelSchedulesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(chooserschDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelSchedulesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnCancelSch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnCreateSch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    btnViewSch.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnViewSch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewWhite_16.png"))); // NOI18N
    btnViewSch.setText("View");
    btnViewSch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnViewSch.setContentAreaFilled(false);
    btnViewSch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnViewSch.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewBlack_16.png"))); // NOI18N
    btnViewSch.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnViewSchActionPerformed(evt);
        }
    });

    jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view_16.png"))); // NOI18N

    jLabel90.setText("(Only seen by you)");

    javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
    jPanel29.setLayout(jPanel29Layout);
    jPanel29Layout.setHorizontalGroup(
        jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel29Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane17)
                .addComponent(panelSchedulesCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jLabel90)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel89)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnViewSch, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    jPanel29Layout.setVerticalGroup(
        jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel29Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnViewSch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel90))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(panelSchedulesCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    jPanel30.setBackground(new java.awt.Color(129, 186, 243));
    jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Notes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

    tableNotes.setModel(new javax.swing.table.DefaultTableModel(
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
    tableNotes.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableNotesMouseClicked(evt);
        }
    });
    jScrollPane18.setViewportView(tableNotes);

    panelNotesCreate.setBackground(new java.awt.Color(129, 186, 243));
    panelNotesCreate.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Create note", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

    jLabel84.setText("Note Title :");

    txtNotesInfo.setColumns(20);
    txtNotesInfo.setRows(5);
    jScrollPane19.setViewportView(txtNotesInfo);

    jLabel85.setText("Note information :");

    comboNotes.setBackground(new java.awt.Color(129, 186, 243));
    comboNotes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select importance", "Not important", "Mild importance", "important", "Very important", "Urgent" }));

    ChooserNotes.setBackground(new java.awt.Color(129, 186, 243));

    btnCreateNotes.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnCreateNotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/createBlack_16.png"))); // NOI18N
    btnCreateNotes.setText("Create");
    btnCreateNotes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnCreateNotes.setContentAreaFilled(false);
    btnCreateNotes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnCreateNotes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Createwhite_16.png"))); // NOI18N
    btnCreateNotes.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCreateNotesActionPerformed(evt);
        }
    });

    btnCancelNotes.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnCancelNotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelblack_16.png"))); // NOI18N
    btnCancelNotes.setText("Cancel");
    btnCancelNotes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    btnCancelNotes.setContentAreaFilled(false);
    btnCancelNotes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnCancelNotes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelred_16.png"))); // NOI18N

    jLabel86.setText("Importance :");

    jLabel87.setText("Date due :");

    javax.swing.GroupLayout panelNotesCreateLayout = new javax.swing.GroupLayout(panelNotesCreate);
    panelNotesCreate.setLayout(panelNotesCreateLayout);
    panelNotesCreateLayout.setHorizontalGroup(
        panelNotesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelNotesCreateLayout.createSequentialGroup()
            .addGroup(panelNotesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelNotesCreateLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addGroup(panelNotesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel84, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel85, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelNotesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(txtNotesTitle)
                        .addGroup(panelNotesCreateLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btnCreateNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(panelNotesCreateLayout.createSequentialGroup()
                    .addGroup(panelNotesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelNotesCreateLayout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(jLabel87)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ChooserNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelNotesCreateLayout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addComponent(jLabel86)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    panelNotesCreateLayout.setVerticalGroup(
        panelNotesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelNotesCreateLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelNotesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtNotesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel84))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelNotesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel85))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelNotesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(comboNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel86))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelNotesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(ChooserNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelNotesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnCancelNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnCreateNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    jButton7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewWhite_16.png"))); // NOI18N
    jButton7.setText("View");
    jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    jButton7.setContentAreaFilled(false);
    jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewBlack_16.png"))); // NOI18N
    jButton7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton7ActionPerformed(evt);
        }
    });

    jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view_16.png"))); // NOI18N

    jLabel91.setText("(Notes are seen by all users)");

    javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
    jPanel30.setLayout(jPanel30Layout);
    jPanel30Layout.setHorizontalGroup(
        jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel30Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(panelNotesCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jLabel91)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel88)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    jPanel30Layout.setVerticalGroup(
        jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel30Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel91))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(panelNotesCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
    jPanel27.setLayout(jPanel27Layout);
    jPanel27Layout.setHorizontalGroup(
        jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanel27Layout.setVerticalGroup(
        jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel27Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );

    btnInfoDialog.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    btnInfoDialog.setForeground(new java.awt.Color(255, 255, 255));
    btnInfoDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info_16.png"))); // NOI18N
    btnInfoDialog.setText("Info");
    btnInfoDialog.setContentAreaFilled(false);
    btnInfoDialog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnInfoDialog.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnInfoDialogActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout panelSchedulesLayout = new javax.swing.GroupLayout(panelSchedules);
    panelSchedules.setLayout(panelSchedulesLayout);
    panelSchedulesLayout.setHorizontalGroup(
        panelSchedulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelSchedulesLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(labelMagzBorrowed1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInfoDialog)
            .addContainerGap())
        .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    panelSchedulesLayout.setVerticalGroup(
        panelSchedulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelSchedulesLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelSchedulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelMagzBorrowed1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnInfoDialog))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    holderPanel.add(panelSchedules, "card2");

    mainMenuBar.setBackground(new java.awt.Color(0, 204, 204));

    mainMenuNav.setBackground(new java.awt.Color(51, 153, 255));
    mainMenuNav.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/File_16.png"))); // NOI18N
    mainMenuNav.setText("Navigate");

    itemHome.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
    itemHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home_16.png"))); // NOI18N
    itemHome.setText("Home");
    itemHome.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Homeover_16.png"))); // NOI18N
    itemHome.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itemHomeActionPerformed(evt);
        }
    });
    mainMenuNav.add(itemHome);

    itemStock.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
    itemStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock_16.png"))); // NOI18N
    itemStock.setText("Books stock");
    itemStock.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itemStockActionPerformed(evt);
        }
    });
    mainMenuNav.add(itemStock);

    itemIssue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/issue_16.png"))); // NOI18N
    itemIssue.setText("Issue Book(s)");

    itemStudent.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
    itemStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student_16.png"))); // NOI18N
    itemStudent.setText("Student");
    itemStudent.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itemStudentActionPerformed(evt);
        }
    });
    itemIssue.add(itemStudent);

    itemStaff.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
    itemStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staff_16.png"))); // NOI18N
    itemStaff.setText("Staff");
    itemStaff.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itemStaffActionPerformed(evt);
        }
    });
    itemIssue.add(itemStaff);

    itemShortLoan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    itemShortLoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shortloan_16.png"))); // NOI18N
    itemShortLoan.setText("Short Loan Book");
    itemShortLoan.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itemShortLoanActionPerformed(evt);
        }
    });
    itemIssue.add(itemShortLoan);

    mainMenuNav.add(itemIssue);

    itemRecieve.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
    itemRecieve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/recieve_16.png"))); // NOI18N
    itemRecieve.setText("Recieve Book(s)");
    itemRecieve.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itemRecieveActionPerformed(evt);
        }
    });
    mainMenuNav.add(itemRecieve);

    menuItemLost.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
    menuItemLost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lost_and_Found_16.png"))); // NOI18N
    menuItemLost.setText("Report as Lost");
    menuItemLost.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lost_and_Foundwhite_16.png"))); // NOI18N
    menuItemLost.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuItemLostActionPerformed(evt);
        }
    });
    mainMenuNav.add(menuItemLost);

    menuItemMagz.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
    menuItemMagz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/News_16.png"))); // NOI18N
    menuItemMagz.setText("Magazine/Journals");
    menuItemMagz.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuItemMagzActionPerformed(evt);
        }
    });
    mainMenuNav.add(menuItemMagz);

    menuItemProfile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
    menuItemProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile_16.png"))); // NOI18N
    menuItemProfile.setText("Profile");
    menuItemProfile.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuItemProfileActionPerformed(evt);
        }
    });
    mainMenuNav.add(menuItemProfile);

    itemLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
    itemLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout_16.png"))); // NOI18N
    itemLogout.setText("Log Out");
    itemLogout.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itemLogoutActionPerformed(evt);
        }
    });
    mainMenuNav.add(itemLogout);

    mainMenuBar.add(mainMenuNav);

    menuItemEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Edit_File_16.png"))); // NOI18N
    menuItemEdit.setText("Edit");

    itemList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/List_16.png"))); // NOI18N
    itemList.setText("Lists");
    itemList.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itemListActionPerformed(evt);
        }
    });
    menuItemEdit.add(itemList);

    mainMenuBar.add(menuItemEdit);

    menuItemView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/View_File_16.png"))); // NOI18N
    menuItemView.setText("View");

    jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/issueBookblack_16.png"))); // NOI18N
    jMenu1.setText("Borrowers");

    jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/acceptbookblack_16.png"))); // NOI18N
    jMenuItem1.setText("Books");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem1ActionPerformed(evt);
        }
    });
    jMenu1.add(jMenuItem1);

    jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/News_16.png"))); // NOI18N
    jMenuItem2.setText("Magazines");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem2ActionPerformed(evt);
        }
    });
    jMenu1.add(jMenuItem2);

    menuItemView.add(jMenu1);

    itemBooksIssued.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Books_16.png"))); // NOI18N
    itemBooksIssued.setText("Books Issued");
    itemBooksIssued.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itemBooksIssuedActionPerformed(evt);
        }
    });
    menuItemView.add(itemBooksIssued);

    jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Students_16.png"))); // NOI18N
    jMenuItem3.setText("Students");
    jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem3ActionPerformed(evt);
        }
    });
    menuItemView.add(jMenuItem3);

    jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Teacher_Hiring_16.png"))); // NOI18N
    jMenuItem4.setText("Staff");
    jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem4ActionPerformed(evt);
        }
    });
    menuItemView.add(jMenuItem4);

    mainMenuBar.add(menuItemView);

    menuSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Settings_16.png"))); // NOI18N
    menuSettings.setText("Settings");

    itemsSystems.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
    itemsSystems.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system_16.png"))); // NOI18N
    itemsSystems.setText("System");
    itemsSystems.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itemsSystemsActionPerformed(evt);
        }
    });
    menuSettings.add(itemsSystems);

    itemManageUsers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
    itemManageUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usersmanage_16.png"))); // NOI18N
    itemManageUsers.setText("Manage Users");
    itemManageUsers.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itemManageUsersActionPerformed(evt);
        }
    });
    menuSettings.add(itemManageUsers);

    mainMenuBar.add(menuSettings);

    menuHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help_16.png"))); // NOI18N
    menuHelp.setText("Help");

    menuItemGuide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User_Manual_16.png"))); // NOI18N
    menuItemGuide.setText("Guidance");
    menuItemGuide.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuItemGuideActionPerformed(evt);
        }
    });
    menuHelp.add(menuItemGuide);

    menuItemAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/About_16.png"))); // NOI18N
    menuItemAbout.setText("About");
    menuItemAbout.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuItemAboutActionPerformed(evt);
        }
    });
    menuHelp.add(menuItemAbout);

    mainMenuBar.add(menuHelp);

    setJMenuBar(mainMenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(holderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(holderPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setExtendedState(LibraryHome.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void itemHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHomeActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelHome);
        holderPanel.repaint();
        holderPanel.revalidate();
        
        numberOfBooksBorrowed();
        numberOfBorrowers();
        numberOfBooks();
    }//GEN-LAST:event_itemHomeActionPerformed

    private void itemStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemStockActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelstock);
        holderPanel.repaint();
        holderPanel.revalidate();
       refreshBooksStock();
    }//GEN-LAST:event_itemStockActionPerformed

    private void itemStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemStudentActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelIssueStudent);
        holderPanel.repaint();
        holderPanel.revalidate();
        showMaxOnLabelStd();
        showMaxOnLabelStaff();
    }//GEN-LAST:event_itemStudentActionPerformed

    private void itemStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemStaffActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelIssueStaff);
        holderPanel.repaint();
        holderPanel.revalidate();
        showMaxOnLabelStd();
        showMaxOnLabelStaff();
    }//GEN-LAST:event_itemStaffActionPerformed

    private void itemRecieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRecieveActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelRecieve);
        holderPanel.repaint();
        holderPanel.revalidate();
    }//GEN-LAST:event_itemRecieveActionPerformed

    private void itemListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemListActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelList);
        holderPanel.repaint();
        holderPanel.revalidate();
        refreshList();
    }//GEN-LAST:event_itemListActionPerformed

    private void itemBooksIssuedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBooksIssuedActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelBooksIssued);
        holderPanel.repaint();
        holderPanel.revalidate();
        refreshBooksBorrwed();
    }//GEN-LAST:event_itemBooksIssuedActionPerformed

    private void itemsSystemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsSystemsActionPerformed
        SettingsDialog settingsDialog = new SettingsDialog(this, true);
        settingsDialog.setVisible(true);
    }//GEN-LAST:event_itemsSystemsActionPerformed

    private void itemManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemManageUsersActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelManageUsers);
        holderPanel.repaint();
        holderPanel.revalidate();
    }//GEN-LAST:event_itemManageUsersActionPerformed

    private void menuItemProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProfileActionPerformed
        ProfieDialog profileDialog = new ProfieDialog(this, true);
        profileDialog.setVisible(true);
    }//GEN-LAST:event_menuItemProfileActionPerformed

    private void txtStdntLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStdntLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStdntLnameActionPerformed

    private void labelTabOneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTabOneMouseEntered
        labelTabOne.setForeground(Color.red);
    }//GEN-LAST:event_labelTabOneMouseEntered

    private void labelTabOneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTabOneMouseExited
        labelTabOne.setForeground(Color.BLACK);
    }//GEN-LAST:event_labelTabOneMouseExited

    private void labelTabTwoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTabTwoMouseEntered
        labelTabTwo.setForeground(Color.red);
    }//GEN-LAST:event_labelTabTwoMouseEntered

    private void labelTabTwoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTabTwoMouseExited
        labelTabTwo.setForeground(Color.BLACK);
    }//GEN-LAST:event_labelTabTwoMouseExited

    private void labelTabThreeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTabThreeMouseEntered
        labelTabThree.setForeground(Color.red);
    }//GEN-LAST:event_labelTabThreeMouseEntered

    private void labelTabThreeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTabThreeMouseExited
        labelTabThree.setForeground(Color.black);
    }//GEN-LAST:event_labelTabThreeMouseExited

    private void labelTabOneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTabOneMouseClicked
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelstock);
        holderPanel.repaint();
        holderPanel.revalidate();
    }//GEN-LAST:event_labelTabOneMouseClicked

    private void labelTabTwoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTabTwoMouseClicked
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelBooksIssued);
        holderPanel.repaint();
        holderPanel.revalidate();
    }//GEN-LAST:event_labelTabTwoMouseClicked

    private void labelTabThreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTabThreeMouseClicked
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelBorrowers);
        holderPanel.repaint();
        holderPanel.revalidate();
    }//GEN-LAST:event_labelTabThreeMouseClicked

    private void btnAddBookListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookListActionPerformed
        AddBookDialog bookDialog = new AddBookDialog(this, true);
        bookDialog.setVisible(true);
    }//GEN-LAST:event_btnAddBookListActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        while (listModel.getRowCount() != 0) {
            listModel.removeRow(0);
        }
        DisplayBooksList();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnEditBookDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBookDetailsActionPerformed
        select = bookID1;
        if (select == null) 
        {
            JOptionPane.showMessageDialog(null, "Select a book from the list to edit");
        } else if((borrowedList1.equals("YES") || borrowedList1.equals("NO") && select != null)){
            EditBookListDialog editList = new EditBookListDialog(this, true);
            editList.setVisible(true);
        }else if(borrowedList1.equals("LOST"))
        {
        int response = JOptionPane.showConfirmDialog(null, "This book has been reported as LOST." + System.lineSeparator()
                + "            Report it as recovered?",
                "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (response) {
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.CLOSED_OPTION:
                break;
            case JOptionPane.YES_OPTION:
                DialogReportFound bookFound = new DialogReportFound(this, true);
                bookFound.setVisible(true);}
        }
    }//GEN-LAST:event_btnEditBookDetailsActionPerformed

    private void tableListBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListBooksMouseClicked
        int row = tableListBooks.getSelectedRow();
        bookID1 = (String) tableListBooks.getModel().getValueAt(row, 0);
        bookISBNList1 = (String) tableListBooks.getModel().getValueAt(row, 1);
        authorNameList1 = (String) tableListBooks.getModel().getValueAt(row, 2);
        titleNameList1 = (String) tableListBooks.getModel().getValueAt(row, 3);
        publisherList1 = (String) tableListBooks.getModel().getValueAt(row, 4);
        editionList1 = (String) tableListBooks.getModel().getValueAt(row, 5);
        categoryList1 = (String) tableListBooks.getModel().getValueAt(row, 6);
        loanList1 = (String) tableListBooks.getModel().getValueAt(row, 7);
        borrowedList1 = (String) tableListBooks.getModel().getValueAt(row, 8);
    }//GEN-LAST:event_tableListBooksMouseClicked

    private void btnIssueToStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssueToStudentsActionPerformed
        limitBorrowersStudents();
        displayBooksBorrowed();
        refreshAfterIssue();
        refreshAfterIssueStaff();
    }//GEN-LAST:event_btnIssueToStudentsActionPerformed

    private void tableIssueToStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableIssueToStudentsMouseClicked
        int row = tableIssueToStudents.getSelectedRow();
        bookID2 = (String) tableIssueToStudents.getModel().getValueAt(row, 0);
        bookISBNList2 = (String) tableIssueToStudents.getModel().getValueAt(row, 1);
        authorNameList2 = (String) tableIssueToStudents.getModel().getValueAt(row, 2);
        titleNameList2 = (String) tableIssueToStudents.getModel().getValueAt(row, 3);
        publisherList2 = (String) tableIssueToStudents.getModel().getValueAt(row, 4);
        editionList2 = (String) tableIssueToStudents.getModel().getValueAt(row, 5);
        categoryList2 = (String) tableIssueToStudents.getModel().getValueAt(row, 6);
    }//GEN-LAST:event_tableIssueToStudentsMouseClicked

    private void btnAddIssueStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddIssueStudentActionPerformed
        select = bookID2;
        if (select == null) {
            JOptionPane.showMessageDialog(null, "Select a book from the list to issue");
        } else {
                txtBookIdIssue.setText(bookID2);
                txtBookIssueTitle1.setText(titleNameList2);
                txtBookIsbnIssue.setText(bookISBNList2);
        }
    }//GEN-LAST:event_btnAddIssueStudentActionPerformed

    private void dateChooserDueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateChooserDueKeyTyped
        JOptionPane.showMessageDialog(null, "Select a date from the button");
        Date date = new Date();
        dateChooserDue.setDate(date);
    }//GEN-LAST:event_dateChooserDueKeyTyped

    private void btnIssueRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssueRefreshActionPerformed
        while (issueModel.getRowCount() != 0) {
         issueModel.removeRow(0);
          }
        displayBooksIssueStudents();
    }//GEN-LAST:event_btnIssueRefreshActionPerformed

    private void itemShortLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemShortLoanActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelShortLoanBooks);
        holderPanel.repaint();
        holderPanel.revalidate();
    }//GEN-LAST:event_itemShortLoanActionPerformed

    private void itemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLogoutActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Make sure you save all your changes before you sign out." + System.lineSeparator()
                + "                            Sign out anyway?",
                "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (response) {
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.CLOSED_OPTION:
                break;
            case JOptionPane.YES_OPTION:
        LibrarySignIn.main(null);
        SessionEnd();
        dispose();}
    }//GEN-LAST:event_itemLogoutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int response = JOptionPane.showConfirmDialog(null, "Make sure you save all your changes before you sign out." + System.lineSeparator()
                + "                            Sign out anyway?",
                "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (response) {
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.CLOSED_OPTION:
                break;
            case JOptionPane.YES_OPTION:
        LibrarySignIn.main(null);
        SessionEnd();
        dispose();}
    }//GEN-LAST:event_formWindowClosing

    private void btnusersInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusersInfoActionPerformed
        panelHolderManageUsers.removeAll();
        panelHolderManageUsers.repaint();
        panelHolderManageUsers.revalidate();

        panelHolderManageUsers.add(panelUsersView);
        panelHolderManageUsers.repaint();
        panelHolderManageUsers.revalidate();
    }//GEN-LAST:event_btnusersInfoActionPerformed

    private void btnUsersSessionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersSessionsActionPerformed
        panelHolderManageUsers.removeAll();
        panelHolderManageUsers.repaint();
        panelHolderManageUsers.revalidate();

        panelHolderManageUsers.add(panelSessionLogs);
        panelHolderManageUsers.repaint();
        panelHolderManageUsers.revalidate();
    }//GEN-LAST:event_btnUsersSessionsActionPerformed

    private void btnAddNewUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewUsersActionPerformed
        panelHolderManageUsers.removeAll();
        panelHolderManageUsers.repaint();
        panelHolderManageUsers.revalidate();

        panelHolderManageUsers.add(panelAddUsers);
        panelHolderManageUsers.repaint();
        panelHolderManageUsers.revalidate();
    }//GEN-LAST:event_btnAddNewUsersActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        addUserMethod();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void textFieldBookIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldBookIdKeyTyped
        textFieldBookId.setBackground(Color.white);
        btnIndicator.setBackground(Color.ORANGE);
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
            btnIndicator.setBackground(Color.red);
        }
    }//GEN-LAST:event_textFieldBookIdKeyTyped

    private void btnSearchBookDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBookDetailsActionPerformed
        if(textFieldBookId.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Please enter book ID");
        textFieldBookId.setBackground(Color.CYAN);
        textFieldBookId.requestFocus();
        btnIndicator.setBackground(Color.red);}
        else{retrieveBookDetails();}
    }//GEN-LAST:event_btnSearchBookDetailsActionPerformed

    private void btnCancelRecieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelRecieveActionPerformed
        textFieldBookId.setText("");
        txtBookIsbnRet.setText("");
        txtBookTitle.setText("");
        txtDateDue.setText("");
        txtReceievedFrom.setText("");
        txtAdmNo.setText("");
        txtStaffStudent.setText("");
        txtPenalties.setText("");
        txtAreaCondition.setText("");
    }//GEN-LAST:event_btnCancelRecieveActionPerformed

    private void btnRecieveBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecieveBooksActionPerformed
        String studentORstaff = txtStaffStudent.getText();
        String penns = txtPenalties.getText();
        String condy = txtAreaCondition.getText();
        if (penns.isEmpty())
        {JOptionPane.showMessageDialog(null, "Update penalties, if none indicate NONE");}
        
        else if (condy.isEmpty())
        {JOptionPane.showMessageDialog(null, "Indicate book condition when returned");}
        
        else if(studentORstaff.equals("STUDENT")){
        recieveFromStudents();
        refreshAfterIssue();
        refreshAfterIssueStaff();}
        
        else if(studentORstaff.equals("STAFF")){
        recieveFromStaff();
        refreshAfterIssueStaff();
        refreshAfterIssue();}
    }//GEN-LAST:event_btnRecieveBooksActionPerformed

    private void btnIsssueStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIsssueStaffActionPerformed
        
        limitBorrowersStaff();
        displayBooksBorrowed();
        refreshAfterIssue();
        refreshAfterIssueStaff();
    }//GEN-LAST:event_btnIsssueStaffActionPerformed

    private void tableBooksForStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBooksForStaffMouseClicked
        int row = tableBooksForStaff.getSelectedRow();
        bookID3 = (String) tableBooksForStaff.getModel().getValueAt(row, 0);
        bookISBNList3 = (String) tableBooksForStaff.getModel().getValueAt(row, 1);
        authorNameList3 = (String) tableBooksForStaff.getModel().getValueAt(row, 2);
        titleNameList3 = (String) tableBooksForStaff.getModel().getValueAt(row, 3);
        publisherList3 = (String) tableBooksForStaff.getModel().getValueAt(row, 4);
        editionList3 = (String) tableBooksForStaff.getModel().getValueAt(row, 5);
        categoryList3 = (String) tableBooksForStaff.getModel().getValueAt(row, 6);
    }//GEN-LAST:event_tableBooksForStaffMouseClicked

    private void btnCancelIssueStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelIssueStaffActionPerformed
        txtStaffID.setText("");
        txtStaffName1.setText("");
        txtStaffName2.setText("");
        txtStaffDept.setText("");
        txtStaffPhone.setText("");
        txtStaffBkTitle.setText("");
        txtStaffBookId.setText("");
        txtStaffBookIsbn.setText("");
    }//GEN-LAST:event_btnCancelIssueStaffActionPerformed

    private void btnAddBookStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookStaffActionPerformed
        select = bookID3;
        if (select == null) {
            JOptionPane.showMessageDialog(null, "Select a book from the list to issue");
        } else {
                txtStaffBookId.setText(bookID3);
                txtStaffBkTitle.setText(titleNameList3);
                txtStaffBookIsbn.setText(bookISBNList3);
        }
    }//GEN-LAST:event_btnAddBookStaffActionPerformed

    private void btnPermissionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermissionsActionPerformed
        panelHolderManageUsers.removeAll();
        panelHolderManageUsers.repaint();
        panelHolderManageUsers.revalidate();

        panelHolderManageUsers.add(panelUsersView);
        panelHolderManageUsers.repaint();
        panelHolderManageUsers.revalidate();
        
        select = userEdit;
        if (select == null) {
            JOptionPane.showMessageDialog(null, "Select a user ID from the table first");
        } else {
            DialogEditUser editUser = new DialogEditUser(this, true);
            editUser.setVisible(true);
        }
    }//GEN-LAST:event_btnPermissionsActionPerformed

    private void tableUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUsersMouseClicked
        int row = tableUsers.getSelectedRow();
        userEdit = (String) tableUsers.getModel().getValueAt(row, 0);
        userNameedit = (String) tableUsers.getModel().getValueAt(row, 1);
        username2Edit = (String) tableUsers.getModel().getValueAt(row, 2);
        usernameEdit = (String) tableUsers.getModel().getValueAt(row, 3);
        permissionEdit = (String) tableUsers.getModel().getValueAt(row, 4);
        deptEdit = (String) tableUsers.getModel().getValueAt(row, 5);
        resetEdit = (String) tableUsers.getModel().getValueAt(row, 6);
    }//GEN-LAST:event_tableUsersMouseClicked

    private void tableShortLoanBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableShortLoanBookMouseClicked
        int row = tableShortLoanBook.getSelectedRow();
        bookID4 = (String) tableShortLoanBook.getModel().getValueAt(row, 0);
        bookISBNList4 = (String) tableShortLoanBook.getModel().getValueAt(row, 1);
        authorNameList4 = (String) tableShortLoanBook.getModel().getValueAt(row, 2);
        titleNameList4 = (String) tableShortLoanBook.getModel().getValueAt(row, 3);
        publisherList4 = (String) tableShortLoanBook.getModel().getValueAt(row, 4);
        editionList4 = (String) tableShortLoanBook.getModel().getValueAt(row, 5);
        categoryList4 = (String) tableShortLoanBook.getModel().getValueAt(row, 6);
    }//GEN-LAST:event_tableShortLoanBookMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        select = bookID4;
        if (select == null) {
            JOptionPane.showMessageDialog(null, "Select a book from the table to issue");
        } else {
                txtShortBkId.setText(bookID4);
                txtShortBkIsbn.setText(titleNameList4);
                txtShortBkTitle.setText(bookISBNList4);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRefreshShortBksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshShortBksActionPerformed
        while (shortModel.getRowCount() != 0) {
         shortModel.removeRow(0);
          }
        displayBooksShortLoan();
    }//GEN-LAST:event_btnRefreshShortBksActionPerformed

    private void btnIssueShortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssueShortActionPerformed
        String stdntID = txtStaffstdId.getText().toUpperCase().trim();
        String stdntFname = txtShortFname.getText().toUpperCase().trim();
        String stdntLname = txtShortLname.getText().toUpperCase().trim();
        String StdntClass = txtShortClass.getText().toUpperCase().trim();
        String deptStaff = txtShortDept.getText().toUpperCase().trim();
        String phoneStaff = txtStaffNo.getText().trim();

        
        if(stdntID.isEmpty()){
            JOptionPane.showMessageDialog(null, "Admission/ID required");
            txtStaffstdId.requestFocus();
        }else if(stdntFname.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter first name");
            txtShortFname.requestFocus();
        }else if(stdntLname.isEmpty()){
            JOptionPane.showMessageDialog(null, "Last name");
            txtShortLname.requestFocus();
        }else if(comboStaffStudent.getSelectedIndex() == 0){
        JOptionPane.showMessageDialog(null, "Select whether student or staff");
        }else if(comboStaffStudent.getSelectedIndex() == 1){
            if(StdntClass.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter student's class/form");
            txtShortClass.requestFocus();
            }else{
            issueShortToStudents();
            refreshAfterIssueShort();}
        }
        else if(comboStaffStudent.getSelectedIndex() == 2){
            if(deptStaff.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter staff department");
            txtShortDept.requestFocus();
            }else if(phoneStaff.isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter staff phone number");
                txtStaffNo.requestFocus();
            }else{
            issueShortToStaff();
            refreshAfterIssueShort();
            }
        }
    }//GEN-LAST:event_btnIssueShortActionPerformed

    private void btnPassResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPassResetActionPerformed
        panelHolderManageUsers.removeAll();
        panelHolderManageUsers.repaint();
        panelHolderManageUsers.revalidate();

        panelHolderManageUsers.add(panelUsersView);
        panelHolderManageUsers.repaint();
        panelHolderManageUsers.revalidate();
        
        select = userEdit;
        if (select == null) {
            JOptionPane.showMessageDialog(null, "Select a user ID from the users table first");
        } else if(resetEdit.equals("YES") && select != null){
            AdminReset editUserPass = new AdminReset(this, true);
            editUserPass.setVisible(true);
        }else if(resetEdit.equals("NO") && select != null){
          JOptionPane.showMessageDialog(null, "Selected user has not requested for a password reset");
        }
    }//GEN-LAST:event_btnPassResetActionPerformed

    private void btnRefreshUserTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshUserTableActionPerformed
        while (userModel.getRowCount() != 0) {
         userModel.removeRow(0);
          }
        DisplayUsers();
    }//GEN-LAST:event_btnRefreshUserTableActionPerformed

    private void txtSearchUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchUserKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSearchUserKeyTyped

    private void btnSearchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchUserActionPerformed
        while (userModel.getRowCount() != 0) {
         userModel.removeRow(0);
          }
        searchUser();
    }//GEN-LAST:event_btnSearchUserActionPerformed

    private void btnSearchIssueStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIssueStdActionPerformed
        refreshOnIdIssueStd();
    }//GEN-LAST:event_btnSearchIssueStdActionPerformed

    private void btnSearchStaffBkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchStaffBkActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(issueSModel); 
        tableBooksForStaff.setRowSorter(sorter);
    
        String text = txtSearchStaffBook.getText().toUpperCase();
        if (text.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          refreshOnTitleIssueStaff();
        }
    }//GEN-LAST:event_btnSearchStaffBkActionPerformed

    private void btnSearchShortLoanBksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchShortLoanBksActionPerformed
        refreshsearchShort();
    }//GEN-LAST:event_btnSearchShortLoanBksActionPerformed

    private void btnSearchListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchListActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(listModel); 
        tableListBooks.setRowSorter(sorter);
    
        String text = txtListBooks.getText().toUpperCase();
        if (text.length() == 0) {
          sorter.setRowFilter(null);
        } else {
            refreshListOnTitle();
        }
    }//GEN-LAST:event_btnSearchListActionPerformed

    private void btnRefreshShortBksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshShortBksMouseEntered
        btnRefreshShortBks.setForeground(Color.white);
    }//GEN-LAST:event_btnRefreshShortBksMouseEntered

    private void btnRefreshShortBksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshShortBksMouseExited
        btnRefreshShortBks.setForeground(Color.black);
    }//GEN-LAST:event_btnRefreshShortBksMouseExited

    private void btnRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseEntered
        btnRefresh.setForeground(Color.red);
    }//GEN-LAST:event_btnRefreshMouseEntered

    private void btnRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseExited
        btnRefresh.setForeground(Color.white);
    }//GEN-LAST:event_btnRefreshMouseExited

    private void btnAddBookListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddBookListMouseEntered
        btnAddBookList.setForeground(Color.red);
    }//GEN-LAST:event_btnAddBookListMouseEntered

    private void btnAddBookListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddBookListMouseExited
        btnAddBookList.setForeground(Color.white);
    }//GEN-LAST:event_btnAddBookListMouseExited

    private void btnEditBookDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditBookDetailsMouseEntered
        btnEditBookDetails.setForeground(Color.red);
    }//GEN-LAST:event_btnEditBookDetailsMouseEntered

    private void btnEditBookDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditBookDetailsMouseExited
        btnEditBookDetails.setForeground(Color.white);
    }//GEN-LAST:event_btnEditBookDetailsMouseExited

    private void btnRecieveBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecieveBooksMouseEntered
        btnRecieveBooks.setForeground(Color.white);
    }//GEN-LAST:event_btnRecieveBooksMouseEntered

    private void btnRecieveBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecieveBooksMouseExited
        btnRecieveBooks.setForeground(Color.black);
    }//GEN-LAST:event_btnRecieveBooksMouseExited

    private void btnPrintSessionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintSessionMouseEntered
        btnPrintSession.setForeground(Color.red);
    }//GEN-LAST:event_btnPrintSessionMouseEntered

    private void btnPrintSessionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintSessionMouseExited
        btnPrintSession.setForeground(Color.black);
    }//GEN-LAST:event_btnPrintSessionMouseExited

    private void btnPrintSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintSessionActionPerformed
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        MessageFormat footer = new MessageFormat(reportDate);
        
        MessageFormat header = new MessageFormat("School Library System Session Logs");
        try {
            boolean complete = tableSessionLogs.print(JTable.PrintMode.NORMAL, header, footer);
        if (complete) {
        JOptionPane.showMessageDialog(null, "Session logs printed successfully");
        } else {
        JOptionPane.showMessageDialog(null, "Printing cancelled");
        }
    } catch (PrinterException pe) {
    JOptionPane.showMessageDialog(null,  pe.getMessage());
}
    }//GEN-LAST:event_btnPrintSessionActionPerformed

    private void btnPrintIssuedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintIssuedActionPerformed
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        MessageFormat footer = new MessageFormat(reportDate);
        
        MessageFormat header = new MessageFormat("School Library System: Books Issued List");
        try {
            boolean complete = tableBooksIssued.print(JTable.PrintMode.NORMAL, header, footer);
        if (complete) {
        JOptionPane.showMessageDialog(null, "Session logs printed successfully");
        } else {
        JOptionPane.showMessageDialog(null, "Printing cancelled");
        }
    } catch (PrinterException pe) {
    JOptionPane.showMessageDialog(null,  pe.getMessage());
}
    }//GEN-LAST:event_btnPrintIssuedActionPerformed

    private void btnPrintIssuedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintIssuedMouseEntered
        btnPrintIssued.setForeground(Color.red);
    }//GEN-LAST:event_btnPrintIssuedMouseEntered

    private void btnPrintIssuedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintIssuedMouseExited
         btnPrintIssued.setForeground(Color.white);
    }//GEN-LAST:event_btnPrintIssuedMouseExited

    private void btnSearchIssuedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIssuedActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(boroModel); 
        tableBooksIssued.setRowSorter(sorter);
        int col = 3;
    
        String text = txtSearchIssued.getText().toUpperCase();
        if (text.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter(text,col));
        }
    }//GEN-LAST:event_btnSearchIssuedActionPerformed

    private void btnCancelRecieveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelRecieveMouseEntered
        btnCancelRecieve.setForeground(Color.red);
    }//GEN-LAST:event_btnCancelRecieveMouseEntered
            
    private void btnCancelRecieveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelRecieveMouseExited
        btnCancelRecieve.setForeground(Color.black);
    }//GEN-LAST:event_btnCancelRecieveMouseExited

    private void btnCancelShortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelShortActionPerformed
        txtStaffstdId.setText("");
        txtShortFname.setText("");
        txtShortLname.setText("");
        txtShortClass.setText("");
        txtStaffNo.setText("");
        comboStaffStudent.setSelectedIndex(0);
        txtShortBkId.setText("");
        txtShortBkIsbn.setText("");
        txtShortBkTitle.setText("");
        SpinfieldTimeLoan.setValue(1);
    }//GEN-LAST:event_btnCancelShortActionPerformed

    private void comboSearchShortItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSearchShortItemStateChanged
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(shortModel); 
        tableShortLoanBook.setRowSorter(sorter);
    
        String text = (String) comboSearchShort.getSelectedItem();
        if (text.equalsIgnoreCase("select category to display")) {
          sorter.setRowFilter(null);
        } else {
          refreshShortTable();
        }
    }//GEN-LAST:event_comboSearchShortItemStateChanged

    private void comboSearchIssueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSearchIssueItemStateChanged
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(issueModel); 
        tableIssueToStudents.setRowSorter(sorter);
    
        String text = (String) comboSearchIssue.getSelectedItem();
        if (text.equals("select category to display")) {
          sorter.setRowFilter(null);
        } else {
          refreshOnItemIssueStd();
        }
    }//GEN-LAST:event_comboSearchIssueItemStateChanged

    private void btnIssueToStudentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIssueToStudentsMouseEntered
        btnIssueToStudents.setForeground(Color.white);
    }//GEN-LAST:event_btnIssueToStudentsMouseEntered

    private void btnIssueToStudentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIssueToStudentsMouseExited
        btnIssueToStudents.setForeground(Color.black);
    }//GEN-LAST:event_btnIssueToStudentsMouseExited

    private void btnCancelIssueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelIssueMouseEntered
        btnCancelIssue.setForeground(Color.red);
    }//GEN-LAST:event_btnCancelIssueMouseEntered

    private void btnCancelIssueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelIssueMouseExited
        btnCancelIssue.setForeground(Color.black);
    }//GEN-LAST:event_btnCancelIssueMouseExited

    private void comboStaffStudentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboStaffStudentItemStateChanged
        switch (comboStaffStudent.getSelectedIndex()) {
            case 1:
                txtShortDept.setEditable(false);
                txtShortDept.setBackground(Color.white);
                txtStaffNo.setBackground(Color.white);
                txtStaffNo.setEditable(false);
                txtShortClass.setEditable(true);
                txtShortClass.setBackground(Color.CYAN);
                txtShortDept.setText("");
                txtStaffNo.setText("");
                break;
            case 2:
                txtShortClass.setEditable(false);
                txtShortClass.setText("");
                txtShortClass.setBackground(Color.white);
                txtStaffNo.setEditable(true);
                txtStaffNo.setBackground(Color.CYAN);
                txtShortDept.setEditable(true);
                txtShortDept.setBackground(Color.CYAN);
                break;
            case 0:
                txtShortClass.setEditable(false);
                txtShortClass.setBackground(Color.white);
                txtStaffNo.setEditable(false);
                txtStaffNo.setBackground(Color.white);
                txtShortDept.setEditable(false);
                txtShortDept.setBackground(Color.white);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_comboStaffStudentItemStateChanged

    private void comboFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFilterItemStateChanged
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(borrowerModel); 
        tableBorrowers.setRowSorter(sorter);
        int col = 6;
    
        String text = (String) comboFilter.getSelectedItem();
        if (text.equals("Filter by :")) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter(text,col));
        }
    }//GEN-LAST:event_comboFilterItemStateChanged

    private void btnSearchBorrowersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBorrowersActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(borrowerModel); 
        tableBorrowers.setRowSorter(sorter);
        int col = 3;
    
        String text = txtSearchBorrowers.getText().toUpperCase();
        if (text.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter(text,col));
        }
    }//GEN-LAST:event_btnSearchBorrowersActionPerformed

    private void btnPrintBorrowersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBorrowersActionPerformed
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        MessageFormat footer = new MessageFormat(reportDate);
        
        MessageFormat header = new MessageFormat("School Library System: Borrowers' List");
        try {
            boolean complete = tableBorrowers.print(JTable.PrintMode.NORMAL, header, footer);
        if (complete) {
        JOptionPane.showMessageDialog(null, "Borrowers table printed successfuly");
        } else {
        JOptionPane.showMessageDialog(null, "Printing cancelled");
        }
    } catch (PrinterException pe) {
    JOptionPane.showMessageDialog(null,  pe.getMessage());
    }
    }//GEN-LAST:event_btnPrintBorrowersActionPerformed

    private void btnProfMoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfMoreMouseEntered
        btnProfMore.setForeground(Color.red);
    }//GEN-LAST:event_btnProfMoreMouseEntered

    private void btnProfMoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfMoreMouseExited
        btnProfMore.setForeground(Color.white);
    }//GEN-LAST:event_btnProfMoreMouseExited

    private void btnIssueCutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIssueCutMouseEntered
        btnIssueCut.setForeground(Color.red);
    }//GEN-LAST:event_btnIssueCutMouseEntered

    private void btnIssueCutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIssueCutMouseExited
        btnIssueCut.setForeground(Color.black);
    }//GEN-LAST:event_btnIssueCutMouseExited

    private void btnProfMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfMoreActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelRecieve);
        holderPanel.repaint();
        holderPanel.revalidate();
    }//GEN-LAST:event_btnProfMoreActionPerformed

    private void btnIssueCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssueCutActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelIssueStudent);
        holderPanel.repaint();
        holderPanel.revalidate();
    }//GEN-LAST:event_btnIssueCutActionPerformed

    private void btnSearchStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchStdActionPerformed
        retrieveStudentDetails();
    }//GEN-LAST:event_btnSearchStdActionPerformed

    private void txtStdntAmNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStdntAmNoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        retrieveStudentDetails();}
    }//GEN-LAST:event_txtStdntAmNoKeyPressed

    private void txtStaffIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStaffIDKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        retrieveStaffDetails();}
    }//GEN-LAST:event_txtStaffIDKeyPressed

    private void btnSearchStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchStaffActionPerformed
        retrieveStaffDetails();
    }//GEN-LAST:event_btnSearchStaffActionPerformed

    private void btnExcelListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelListActionPerformed
        writeToExcel();
    }//GEN-LAST:event_btnExcelListActionPerformed

    private void btnExcelListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcelListMouseEntered
        btnExcelList.setForeground(Color.red);
    }//GEN-LAST:event_btnExcelListMouseEntered

    private void btnExcelListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcelListMouseExited
        btnExcelList.setForeground(Color.white);
    }//GEN-LAST:event_btnExcelListMouseExited

    private void btnExcelBorrowersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelBorrowersActionPerformed
        writeBorrowersToExcel();
    }//GEN-LAST:event_btnExcelBorrowersActionPerformed

    private void comboFilterStockItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFilterStockItemStateChanged
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(stockModel); 
        tableBookStock.setRowSorter(sorter);
    
        String text = (String) comboFilterStock.getSelectedItem();
        if (text.equals("Filter by :")) {
          sorter.setRowFilter(null);
        } else {
            refreshStockModel();
        }
    }//GEN-LAST:event_comboFilterStockItemStateChanged

    private void searchStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchStockActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(stockModel); 
        tableBookStock.setRowSorter(sorter);
        
        String text = txtSearchText.getText().toUpperCase();
        if (text.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          refreshStockModeltitle();
        }
    }//GEN-LAST:event_searchStockActionPerformed

    private void btnExportStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportStockActionPerformed
        writeStockToExcel();
    }//GEN-LAST:event_btnExportStockActionPerformed

    private void btnExportStockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportStockMouseEntered
        btnExportStock.setForeground(Color.white);
    }//GEN-LAST:event_btnExportStockMouseEntered

    private void btnExportStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportStockMouseExited
        btnExportStock.setForeground(Color.black);
    }//GEN-LAST:event_btnExportStockMouseExited

    private void txtSearchLostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchLostKeyTyped
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(lostModel); 
            tableBookLost.setRowSorter(sorter);
            int col = 6;

            String text = txtSearchLost.getText().toUpperCase();
            if (text.length() == 0) {
              sorter.setRowFilter(null);
            } else {
              sorter.setRowFilter(RowFilter.regexFilter(text,col));
            }
        }
    }//GEN-LAST:event_txtSearchLostKeyTyped

    private void searchLostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchLostActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(lostModel); 
        tableBookLost.setRowSorter(sorter);
        int col = 6;
    
        String text = txtSearchLost.getText().toUpperCase();
        if (text.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter(text,col));
        }
    }//GEN-LAST:event_searchLostActionPerformed

    private void comboFilterLostItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFilterLostItemStateChanged
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(lostModel); 
        tableBookLost.setRowSorter(sorter);
        int col = 6;
    
        String text = (String) comboFilterLost.getSelectedItem();
        if (text.equals("Filter by :")) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter(text,col));
        }
    }//GEN-LAST:event_comboFilterLostItemStateChanged

    private void menuItemLostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLostActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelReportLost);
        holderPanel.repaint();
        holderPanel.revalidate();
        refreshBooksLost();
    }//GEN-LAST:event_menuItemLostActionPerformed

    private void btnLostConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLostConfActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Report this book as lost?",
                "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (response) {
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.CLOSED_OPTION:
                break;
            case JOptionPane.YES_OPTION:
                if(txtStaffLost.getText().equals("STUDENT"))
                    {lostByStudents();
                    refreshBooksLost();}
                else if(txtStaffLost.getText().equals("STAFF")){
                    lostByStaff();
                    refreshBooksLost();}
        }
    }//GEN-LAST:event_btnLostConfActionPerformed

    private void tableBookLostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBookLostMouseClicked
        int row = tableBookLost.getSelectedRow();
        lostbookID3 = (String) tableBookLost.getModel().getValueAt(row, 0);
    }//GEN-LAST:event_tableBookLostMouseClicked

    private void btnAddBkLostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBkLostActionPerformed
        retrieveBookDetailsLost() ;
    }//GEN-LAST:event_btnAddBkLostActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        txtBookIDlost.setText("");
        txtIsbnLost.setText("");
        txtBookTitleLost.setText("");
        txtIDLost.setText("");
        txtFnameLost.setText("");
        txtLnameLost.setText("");
        txtStaffLost.setText("");
        txtDateDue.setText("");
    }//GEN-LAST:event_btnCancelActionPerformed

    private void comboBoxListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxListItemStateChanged
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(listModel); 
        tableListBooks.setRowSorter(sorter);
        
        String text = (String) comboBoxList.getSelectedItem();
        if (text.equals("Filter by borrowed")) {
          sorter.setRowFilter(null);
        } else{
            refreshListOnBorod();
        }
    }//GEN-LAST:event_comboBoxListItemStateChanged

    private void txtSearchShortKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchShortKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSearchShortKeyTyped

    private void txtStaffNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStaffNoKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtStaffNoKeyTyped

    private void txtStaffstdIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStaffstdIdKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtStaffstdIdKeyTyped

    private void txtShortClassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtShortClassKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtShortClassKeyTyped

    private void txtShortBkTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtShortBkTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtShortBkTitleActionPerformed

    private void btnSearchStdStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchStdStaffActionPerformed
        String stdStaff = (String) comboStaffStudent.getSelectedItem();
        if(stdStaff.equals("Select"))
        {JOptionPane.showMessageDialog(null, "Please select STUDENT or STAFF from dropdown list above");
        }else if(stdStaff.equals("STUDENT"))
        {
            retrieveStudentDetailsShort();
        }
        else if(stdStaff.equals("STAFF"))
        {
            retrieveStaffDetailsShort();
        }
    }//GEN-LAST:event_btnSearchStdStaffActionPerformed

    private void txtStaffIdListKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStaffIdListKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtStaffIdListKeyTyped

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelStudents);
        holderPanel.repaint();
        holderPanel.revalidate();
        refreshStdTable();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelTeachers);
        holderPanel.repaint();
        holderPanel.revalidate();
        refreshStaffTable();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void btnCancelIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelIssueActionPerformed
        txtStdntAmNo.setText("");
        txtSdntFname.setText("");
        txtStdntLname.setText("");
        txtStdntClass.setText("");
        txtBookIssueTitle1.setText("");
        txtBookIdIssue.setText("");
        txtBookIsbnIssue.setText("");
    }//GEN-LAST:event_btnCancelIssueActionPerformed

    private void comboSearchInStaffIssueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSearchInStaffIssueItemStateChanged
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(issueSModel); 
        tableBooksForStaff.setRowSorter(sorter);
    
        String text = (String) comboSearchInStaffIssue.getSelectedItem();
        if (text.equals("select category to display")) {
          sorter.setRowFilter(null);
        } else{
        refreshOnItemIssueStaff();}
    }//GEN-LAST:event_comboSearchInStaffIssueItemStateChanged

    private void txtStdntAmNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStdntAmNoKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtStdntAmNoKeyTyped

    private void txtStaffIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStaffIDKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtStaffIDKeyTyped

    private void txtStaffPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStaffPhoneKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtStaffPhoneKeyTyped

    private void btnRefreshStockDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshStockDetailsActionPerformed
        refreshBooksStock();
    }//GEN-LAST:event_btnRefreshStockDetailsActionPerformed

    private void menuItemMagzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMagzActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelMags);
        holderPanel.repaint();
        holderPanel.revalidate();
        refreshMagz();
    }//GEN-LAST:event_menuItemMagzActionPerformed

    private void btnMagzShortcutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMagzShortcutActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelMags);
        holderPanel.repaint();
        holderPanel.revalidate();
        refreshMagz();
    }//GEN-LAST:event_btnMagzShortcutActionPerformed

    private void btnMagzIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMagzIssueActionPerformed
        String stdntID = txtMagzNameID.getText().toUpperCase().trim();
        String stdntFname = txtMagzName1.getText().toUpperCase().trim();
        String stdntLname = txtMagzName2.getText().toUpperCase().trim();
        String StdntClass = txtMagzClass.getText().toUpperCase().trim();
        String deptStaff = txtMagzDept.getText().toUpperCase().trim();
        String phoneStaff = txtMagzPhone.getText().trim();

        
        if(stdntID.isEmpty()){
            JOptionPane.showMessageDialog(null, "Admission/ID required");
            txtMagzNameID.requestFocus();
        }else if(stdntFname.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter first name");
            txtMagzName1.requestFocus();
        }else if(stdntLname.isEmpty()){
            JOptionPane.showMessageDialog(null, "Last name");
            txtMagzName2.requestFocus();
        }else if(comboMagz.getSelectedIndex() == 0){
        JOptionPane.showMessageDialog(null, "Select whether STUDENT or STAFF");
        }else if(comboMagz.getSelectedIndex() == 1){
            if(StdntClass.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter student's class/form");
            txtMagzClass.requestFocus();
            }else{
            issueMagzToStudents();
            refreshMagz();
            }
        }
        else if(comboMagz.getSelectedIndex() == 2){
            if(deptStaff.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter staff department");
            txtMagzDept.requestFocus();
            }else if(phoneStaff.isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter staff phone number");
                txtMagzPhone.requestFocus();
            }else{
            issueMagzToStaff();
            refreshMagz();
            }
        }
    }//GEN-LAST:event_btnMagzIssueActionPerformed

    private void comboMagzItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMagzItemStateChanged
        switch (comboMagz.getSelectedIndex()) {
            case 1:
                txtMagzDept.setEditable(false);
                txtMagzDept.setBackground(Color.white);
                txtMagzPhone.setBackground(Color.white);
                txtMagzPhone.setEditable(false);
                txtMagzClass.setEditable(true);
                txtMagzClass.setBackground(Color.CYAN);
                txtMagzDept.setText("");
                txtMagzPhone.setText("");
                break;
            case 2:
                txtMagzClass.setEditable(false);
                txtMagzClass.setText("");
                txtMagzClass.setBackground(Color.white);
                txtMagzPhone.setEditable(true);
                txtMagzPhone.setBackground(Color.CYAN);
                txtMagzDept.setEditable(true);
                txtMagzDept.setBackground(Color.CYAN);
                break;
            case 0:
                txtMagzClass.setEditable(false);
                txtMagzClass.setBackground(Color.white);
                txtMagzPhone.setEditable(false);
                txtMagzPhone.setBackground(Color.white);
                txtMagzDept.setEditable(false);
                txtMagzDept.setBackground(Color.white);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_comboMagzItemStateChanged

    private void btnAddMagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMagActionPerformed
        DialogAddMagz addMAg = new DialogAddMagz(this, true);
        addMAg.setVisible(true);
    }//GEN-LAST:event_btnAddMagActionPerformed

    private void btnRefreshMagzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshMagzActionPerformed
        refreshMagz();
    }//GEN-LAST:event_btnRefreshMagzActionPerformed

    private void tableMagsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMagsMouseClicked
        int row = tableMags.getSelectedRow();
        magIssueNo1 = (String) tableMags.getModel().getValueAt(row, 0);
        magName1 = (String) tableMags.getModel().getValueAt(row, 1);
        magPublisher1 = (String) tableMags.getModel().getValueAt(row, 2);
        magDate1 = (String) tableMags.getModel().getValueAt(row, 3);
    }//GEN-LAST:event_tableMagsMouseClicked

    private void btnAddMagToIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMagToIssueActionPerformed
        select = magIssueNo1;
        if (select == null) {
            JOptionPane.showMessageDialog(null, "Select a magazine from the table to issue");
        } else {
                txtMagzIssueNo.setText(magIssueNo1);
                txtMagzTitle.setText(magName1);
                txtMagzDate.setText(magDate1);
        }
    }//GEN-LAST:event_btnAddMagToIssueActionPerformed

    private void btnSearchForMagIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchForMagIssueActionPerformed
        String stdStaff = (String) comboMagz.getSelectedItem();
        switch (stdStaff) {
            case "select":
                JOptionPane.showMessageDialog(null, "Please select STUDENT or STAFF from dropdown list above");
                break;
            case "STUDENT":
                retrieveStudentDetailsMagz();
                break;
            case "STAFF":
                retrieveStaffDetailsMagz();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnSearchForMagIssueActionPerformed

    private void btnSearchMagzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchMagzActionPerformed
        refreshMagSearch();
    }//GEN-LAST:event_btnSearchMagzActionPerformed

    private void btnMagzCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMagzCancelActionPerformed
        txtMagzNameID.setText("");
        txtMagzName1.setText("");
        txtMagzName2.setText("");
        txtMagzClass.setText("");
        comboMagz.setSelectedIndex(0);
        txtMagzPhone.setText("");
        txtMagzDept.setText("");
        txtMagzIssueNo.setText("");
        txtMagzTitle.setText("");
        txtMagzDate.setText("");
    }//GEN-LAST:event_btnMagzCancelActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelBorrowers);
        holderPanel.repaint();
        holderPanel.revalidate();
        refreshBorrowers();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnRefreshMagzBoroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshMagzBoroActionPerformed
        refreshMagzBorowedList();
    }//GEN-LAST:event_btnRefreshMagzBoroActionPerformed

    private void btnSearchBoroMagzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBoroMagzActionPerformed
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(magDetailsModel); 
            tableMagzBoro.setRowSorter(sorter);
            int col = 4;

            String text = txtSearchLost.getText().trim();
            if (text.length() == 0) {
              sorter.setRowFilter(null);
            } else {
              sorter.setRowFilter(RowFilter.regexFilter(text,col));
            }
    }//GEN-LAST:event_btnSearchBoroMagzActionPerformed

    private void btnMagzToExcelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMagzToExcelMouseEntered
        btnMagzToExcel.setForeground(Color.red);
    }//GEN-LAST:event_btnMagzToExcelMouseEntered

    private void btnMagzToExcelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMagzToExcelMouseExited
        btnMagzToExcel.setForeground(Color.black);
    }//GEN-LAST:event_btnMagzToExcelMouseExited

    private void btnMagzToExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMagzToExcelActionPerformed
        writeMagzToExcel();
    }//GEN-LAST:event_btnMagzToExcelActionPerformed

    private void comboMagzFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMagzFilterItemStateChanged
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(magDetailsModel); 
            tableMagzBoro.setRowSorter(sorter);
            int col = 6;

            String text = (String) comboMagzFilter.getSelectedItem();
            if (text.equals("Filter by :")) {
              sorter.setRowFilter(null);
            } else {
              sorter.setRowFilter(RowFilter.regexFilter(text,col));
            }
    }//GEN-LAST:event_comboMagzFilterItemStateChanged

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelMagzBorrowers);
        holderPanel.repaint();
        holderPanel.revalidate();
        refreshMagzBorowedList();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnSchedulesShortCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSchedulesShortCutActionPerformed
        holderPanel.removeAll();
        holderPanel.repaint();
        holderPanel.revalidate();

        holderPanel.add(panelSchedules);
        holderPanel.repaint();
        holderPanel.revalidate();
        refreshSchedules();
        refreshNotes();
    }//GEN-LAST:event_btnSchedulesShortCutActionPerformed

    private void btnCreateSchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateSchActionPerformed
        if(txtschtitle.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Please enter the schedule title");}
        else if(txtSchInfo.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Please enter the schedule information");}
        else if(chooserschDate.getDate() == null){
        JOptionPane.showMessageDialog(null, "Date required");}
        else{
        addSchedule();
        refreshSchedules();}
    }//GEN-LAST:event_btnCreateSchActionPerformed

    private void btnCreateNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNotesActionPerformed
        if(txtNotesTitle.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Please enter the Note title");}
        else if(txtNotesInfo.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Please enter the Note information");}
        else if(comboNotes.getSelectedIndex() == 0){
        JOptionPane.showMessageDialog(null, "Please select the importance fromthe dropdown list");}
        else if(ChooserNotes.getDate() == null){
        JOptionPane.showMessageDialog(null, "Date required");}
        else{
        addNotes();
        refreshNotes();}
    }//GEN-LAST:event_btnCreateNotesActionPerformed

    private void tableSchedulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSchedulesMouseClicked
        int row = tableSchedules.getSelectedRow();
        schId1 = (String) tableSchedules.getModel().getValueAt(row, 0);
        schTitle1 = (String) tableSchedules.getModel().getValueAt(row, 1);
        schInfo1 = (String) tableSchedules.getModel().getValueAt(row, 2);
        schDate1 = (String) tableSchedules.getModel().getValueAt(row, 3);
    }//GEN-LAST:event_tableSchedulesMouseClicked

    private void tableNotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNotesMouseClicked
       int row = tableNotes.getSelectedRow();
        notesID1 = (String) tableNotes.getModel().getValueAt(row, 0);
        notesTitle1 = (String) tableNotes.getModel().getValueAt(row, 1);
        notesInfo1 = (String) tableNotes.getModel().getValueAt(row, 2);
        createdBy1 = (String) tableNotes.getModel().getValueAt(row, 3);
        dueDatenptes1 = (String) tableNotes.getModel().getValueAt(row, 4);
        importance1 = (String) tableNotes.getModel().getValueAt(row, 5);
        acknowledge1 = (String) tableNotes.getModel().getValueAt(row, 6);
    }//GEN-LAST:event_tableNotesMouseClicked

    private void btnViewSchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSchActionPerformed
        select = schId1;
        if (select == null) 
        {
            JOptionPane.showMessageDialog(null, "Select a schedule from the table above to view");
        } else{
            SchedulesEddit editSch = new SchedulesEddit(this, true);
            editSch.setVisible(true);
        }
    }//GEN-LAST:event_btnViewSchActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        select = notesID1;
        if (select == null) 
        {
            JOptionPane.showMessageDialog(null, "Select a note from the table above to view");
        } else{
            NtesEdit editNOtes = new NtesEdit(this, true);
            editNOtes.setVisible(true);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnInfoDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoDialogActionPerformed
        InfoDialog infoDialog = new InfoDialog(this, true);
        infoDialog.setVisible(true);
    }//GEN-LAST:event_btnInfoDialogActionPerformed

    private void btnRefreshBoroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshBoroActionPerformed
        refreshBorrowers();
    }//GEN-LAST:event_btnRefreshBoroActionPerformed

    private void btnRecieveMagzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecieveMagzActionPerformed
        DialogRecieveMag dialogRecieve = new DialogRecieveMag(this, true);
        dialogRecieve.setVisible(true);
    }//GEN-LAST:event_btnRecieveMagzActionPerformed

    private void btnMagzDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMagzDetailsActionPerformed
        select = magIssueNo1;
        if (select == null){
        JOptionPane.showMessageDialog(null, "Please select a magazine from the table below");}
        else{
        DialogEditMag dialogeditMag = new DialogEditMag(this, true);
        dialogeditMag.setVisible(true);}
    }//GEN-LAST:event_btnMagzDetailsActionPerformed

    private void btnSearchStdIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchStdIDActionPerformed
        if(txtStdIdSearch.getText().equals("")){
        JOptionPane.showMessageDialog(null, "please enter the student admission number");
        }else{refreshStdOnId();}
    }//GEN-LAST:event_btnSearchStdIDActionPerformed

    private void comboFilterStudentsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFilterStudentsItemStateChanged
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(stdModel); 
            tableStudents.setRowSorter(sorter);

            String text = (String) comboFilterStudents.getSelectedItem();
            if (text.equals("Filter by returned :")) {
              sorter.setRowFilter(null);
            } else {
              refreshStdOnFilter();
            }
    }//GEN-LAST:event_comboFilterStudentsItemStateChanged

    private void btnWriteStdToExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteStdToExcelActionPerformed
        writeStdToExcel();
    }//GEN-LAST:event_btnWriteStdToExcelActionPerformed

    private void comboFiletStaffItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFiletStaffItemStateChanged
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(staffModel); 
            tableStaff.setRowSorter(sorter);

            String text = (String) comboFiletStaff.getSelectedItem();
            if (text.equals("Filter by returned :")) {
              sorter.setRowFilter(null);
            } else {
              refreshStaffOnFilter();
            }
    }//GEN-LAST:event_comboFiletStaffItemStateChanged

    private void btnSearchStaffIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchStaffIdActionPerformed
        if(txtStaffIdList.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the staff id");}
        else{refreshStaffOnId();}
    }//GEN-LAST:event_btnSearchStaffIdActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        writeStaffTbToExcel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void menuItemGuideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGuideActionPerformed
        HelpDialog dialogHelp = new HelpDialog(this, true);
        dialogHelp.setVisible(true);
    }//GEN-LAST:event_menuItemGuideActionPerformed

    private void menuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAboutActionPerformed
        AboutLib dialogabout = new AboutLib(this, true);
        dialogabout.setVisible(true);
    }//GEN-LAST:event_menuItemAboutActionPerformed

    private void txtIdNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdNoKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtIdNoKeyTyped

    private void txtMagzNameIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMagzNameIDKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMagzNameIDKeyTyped

    private void txtMagzPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMagzPhoneKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMagzPhoneKeyTyped

    private void txtStdIdSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStdIdSearchKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtStdIdSearchKeyTyped

    private void txtBookIDlostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBookIDlostKeyTyped
        char c = evt.getKeyChar();
        if ((c == java.awt.event.KeyEvent.VK_SPACE) || (c == 9 || c >= 58 && c <= 126 || c >= 33 && c <= 42 || c >= 44 && c <= 47)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtBookIDlostKeyTyped

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
            java.util.logging.Logger.getLogger(LibraryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new LibraryHome().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(LibraryHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
//----------------[methods for the system]--------------------------------
public void refreshAfterIssue(){
    while (issueModel.getRowCount() != 0) {
         issueModel.removeRow(0);
          }
        displayBooksIssueStudents();
}

public void refreshAfterIssueStaff(){
    while (issueSModel.getRowCount() != 0) {
         issueSModel.removeRow(0);
          }
        displayBooksIssueStaff();
}

public void refreshAfterIssueShort(){
    while (shortModel.getRowCount() != 0) {
         shortModel.removeRow(0);
          }
        displayBooksShortLoan();
}

public void refreshsearchShort(){
    while (shortModel.getRowCount() != 0) {
         shortModel.removeRow(0);
          }
        searchBooksShortLoan();
}

public void refreshBorrowers(){
    while (borrowerModel.getRowCount() != 0) {
         borrowerModel.removeRow(0);
          }
        displayBorrowersList();
}

public void refreshBooksBorrwed(){
    while (boroModel.getRowCount() != 0) {
         boroModel.removeRow(0);
          }
        displayBooksBorrowed();
}

public void refreshBooksStock(){
    while (stockModel.getRowCount() != 0) {
         stockModel.removeRow(0);
          }
        DisplayBooksStock();
}

public void refreshBooksLost(){
    while (lostModel.getRowCount() != 0) {
         lostModel.removeRow(0);
          }
        displayLostTable();
}

public void refreshList(){
    while (listModel.getRowCount() != 0) {
        listModel.removeRow(0);
    }
    DisplayBooksList();
}

public void refreshStdTable(){
    while (stdModel.getRowCount() != 0) {
        stdModel.removeRow(0);
    }
    studentTable();
}  

public void refreshStaffTable(){
while(staffModel.getRowCount() != 0){
        staffModel.removeRow(0);}
    staffTable();
}

public void refreshShortTable(){
while(shortModel.getRowCount() != 0){
        shortModel.removeRow(0);}
    searchBooksShortLoanItem();
}

public void refreshOnItemIssueStd(){
while(issueModel.getRowCount() != 0){
        issueModel.removeRow(0);}
    searchBooksIssueStudentsItem();
}

public void refreshOnIdIssueStd(){
while(issueModel.getRowCount() != 0){
        issueModel.removeRow(0);}
    searchBooksLongLoanStd();
}

public void refreshOnItemIssueStaff(){
while(issueSModel.getRowCount() != 0){
        issueSModel.removeRow(0);}
    searchBooksIssueStaffCategory();
}

public void refreshOnTitleIssueStaff(){
while(issueSModel.getRowCount() != 0){
        issueSModel.removeRow(0);}
    searchBooksIssueStaffTitle();
}

public void refreshStockModel(){
while(stockModel.getRowCount() != 0){
        stockModel.removeRow(0);}
    filterBooksStockCat();
}

public void refreshStockModeltitle(){
while(stockModel.getRowCount() != 0){
        stockModel.removeRow(0);}
    filterBooksStocktitle();
}

public void refreshListOnBorod(){
    while(listModel.getRowCount() != 0){
        listModel.removeRow(0);}
    displayBooksListFilter();
}

public void refreshListOnTitle(){
    while(listModel.getRowCount() != 0){
        listModel.removeRow(0);}
    displayBooksListFilterTitle();
}

public void refreshMagz(){
    while(magModel.getRowCount() != 0){
        magModel.removeRow(0);}
    displayMagz();
}

public void refreshMagSearch(){
    while(magModel.getRowCount() != 0){
        magModel.removeRow(0);}
    displayMagzSearch();
}

public void refreshMagzBorowedList(){
    while(magDetailsModel.getRowCount() != 0){
        magDetailsModel.removeRow(0);}
    displayMagzdetails();}

public void refreshSchedules(){
    while(scheduleModel.getRowCount() != 0){
        scheduleModel.removeRow(0);}
    displaySchedules();}

public void refreshNotes(){
    while(notesModel.getRowCount() != 0){
        notesModel.removeRow(0);}
    displayNotes();}

public void refreshStdOnFilter(){
    while(stdModel.getRowCount() != 0){
        stdModel.removeRow(0);}
    filterStudentTable();}

public void refreshStdOnId(){
    while(stdModel.getRowCount() != 0){
        stdModel.removeRow(0);}
    filterStudentTableID();}

public void refreshStaffOnFilter(){
    while(staffModel.getRowCount() != 0){
        staffModel.removeRow(0);}
    filterStaffTable();}

public void refreshStaffOnId(){
    while(staffModel.getRowCount() != 0){
        staffModel.removeRow(0);}
    filterStaffTableID();}

public void permissionCheck(){

    if( null != LibrarySignIn.permissionLabel)switch (LibrarySignIn.permissionLabel) {
            case "General user":
                menuItemView.setEnabled(false);
                itemRecieve.setEnabled(false);
                menuItemEdit.setEnabled(false);
                itemsSystems.setEnabled(false);
                btnIssueCut.setEnabled(false);
                btnProfMore.setEnabled(false);
                itemManageUsers.setEnabled(false);
                itemStaff.setEnabled(false);
                itemShortLoan.setEnabled(false);
                labelTabTwo.setEnabled(false);
                labelTabThree.setEnabled(false);
                menuItemLost.setEnabled(false);
                btnMagzShortcut.setEnabled(false);
                btnSchedulesShortCut.setEnabled(false);
                break;
            case "User":
                itemList.setEnabled(false);
                itemsSystems.setEnabled(false);
                itemManageUsers.setEnabled(false);
                break;
            case "Administrator":
                btnPassReset.setEnabled(false);
                break;
            case "Block user":
                menuItemMagz.setEnabled(false);
                btnMagzShortcut.setEnabled(false);
                btnSchedulesShortCut.setEnabled(false);
                menuItemView.setEnabled(false);
                itemStock.setEnabled(false);
                menuItemEdit.setEnabled(false);
                itemsSystems.setEnabled(false);
                btnIssueCut.setEnabled(false);
                btnProfMore.setEnabled(false);
                itemManageUsers.setEnabled(false);
                itemRecieve.setEnabled(false);
                itemIssue.setEnabled(false);
                labelTabTwo.setVisible(false);
                labelTabOne.setVisible(false);
                labelTabThree.setVisible(false);
                menuItemLost.setEnabled(false);
                menuItemProfile.setEnabled(false);
                JOptionPane.showMessageDialog(null, "You are a blocked user, please see the admin");
                break;
            default:
                break;
        }
}       
    
public final void TimeDisplay(){
  
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
        ActionListener timerListener = (ActionEvent e) -> {
            Date date = new Date();
            String time = timeFormat.format(date);
            String todayDate  = dateFormat.format(date);
            labelTime.setText(todayDate+"   "+time);
        };
        Timer timer = new Timer(1000, timerListener);
        //tomake it start at the launch of the application
        timer.setInitialDelay(0);
        timer.start();
    }
public void addNotes(){
    
        String titleForNotes = txtNotesTitle.getText().toUpperCase().trim();
        String inforNotes = txtNotesInfo.getText().toUpperCase().trim();
        String importanceNotes = (String) comboNotes.getSelectedItem();
        Date dateForNotes = ChooserNotes.getDate();
        String idLabel = lblID.getText();
        int userIdLabel = Integer.parseInt(idLabel);
        String userIDName = lblUserId.getText().toUpperCase().trim();
        
                try {
                    Class.forName("com.mysql.jdbc.Driver");

                    con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
                    statement = con.createStatement();

                    // SQL Insert
                    String sql = "INSERT INTO notes " + "(title, information, importance, creator_id, creator_name, date_due)"
                            + "VALUES ('" + titleForNotes + "','"
                            + inforNotes + "','"
                            + importanceNotes + "','"
                            + userIdLabel + "','"
                            + userIDName + "','"
                            + dateForNotes + "') ";
                    
                    statement.execute(sql);

                    JOptionPane.showMessageDialog(null, "New note created");

                    // Reset Text Fields
                    txtNotesTitle.setText("");
                    txtNotesInfo.setText("");
                    comboNotes.setSelectedIndex(0);
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
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, es.getMessage());
                }
        //end of if statement that validate the form
}


public void displayNotes() {
    
        notesModel.setColumnIdentifiers(notesColumnNames);

        tableNotes.setModel(notesModel);

        tableNotes.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  note_id,title,information,importance,creator_name,date_due,acknowledge FROM notes");
            ResultSet staffRs = st.executeQuery();
            
            int i = 0;
            while (staffRs.next()) {
                notesID = staffRs.getString("note_id");
                notesTitle = staffRs.getString("title");
                notesInfo = staffRs.getString("information");
                createdBy = staffRs.getString("creator_name");
                dueDatenptes = staffRs.getString("date_due");
                importance = staffRs.getString("importance");
                acknowledge = staffRs.getString("acknowledge");

                notesModel.addRow(new Object[]{notesID, notesTitle, notesInfo, createdBy,dueDatenptes,importance,acknowledge});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Notes to display", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void displaySchedules() {
    
        scheduleModel.setColumnIdentifiers(schColumnNames);

        tableSchedules.setModel(scheduleModel);

        tableSchedules.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  sch_id,title,info,date FROM schedules WHERE creator_id='"+ lblID.getText() +"'");
            ResultSet staffRs = st.executeQuery();
            
            int i = 0;
            while (staffRs.next()) {
                schId = staffRs.getString("sch_id");
                schTitle = staffRs.getString("title");
                schInfo = staffRs.getString("info");
                schDate = staffRs.getString("date");

                scheduleModel.addRow(new Object[]{schId, schTitle, schInfo, schDate});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No schedules to display", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void addSchedule(){
    
        String titleForSch = txtschtitle.getText().toUpperCase().trim();
        String inforRoSch = txtSchInfo.getText().toUpperCase().trim();
        Date dateForSch = chooserschDate.getDate();
        String idLabel = lblID.getText();
        int userIdLabel = Integer.parseInt(idLabel);
        
                try {
                    Class.forName("com.mysql.jdbc.Driver");

                    con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
                    statement = con.createStatement();

                    // SQL Insert
                    String sql = "INSERT INTO schedules " + "(title, info, date, creator_id)"
                            + "VALUES ('" + titleForSch + "','"
                            + inforRoSch + "','"
                            + dateForSch + "','"
                            + userIdLabel + "') ";
                    
                    statement.execute(sql);

                    JOptionPane.showMessageDialog(null, "New Schedule created");

                    // Reset Text Fields
                    txtschtitle.setText("");
                    txtSchInfo.setText("");
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
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, es.getMessage());
                }
        //end of if statement that validate the form
}
            
public void DisplayBooksList() {

        listModel.setColumnIdentifiers(listColumnNames);

        tableListBooks.setModel(listModel);

        tableListBooks.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("select  book_id,book_isbn,author,title,publisher_name,edition,subject_category,loan_type,borrowed,book_condition from books_db");
            ResultSet rsIssue = st.executeQuery();

            int i = 0;
            while (rsIssue.next()) {
                bookID = rsIssue.getString("book_id");
                bookISBNList = rsIssue.getString("book_isbn");
                authorNameList = rsIssue.getString("author");
                titleNameList = rsIssue.getString("title");
                publisherList = rsIssue.getString("publisher_name");
                editionList = rsIssue.getString("edition");
                categoryList = rsIssue.getString("subject_category");
                loanList = rsIssue.getString("loan_type");
                borrowedList = rsIssue.getString("borrowed");
                conditionList = rsIssue.getString("book_condition");

                listModel.addRow(new Object[]{bookID, bookISBNList, authorNameList, titleNameList, publisherList,editionList,categoryList,loanList,borrowedList,conditionList});
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

public void displayBooksListFilter() {

        listModel.setColumnIdentifiers(listColumnNames);

        tableListBooks.setModel(listModel);

        tableListBooks.setFillsViewportHeight(true);
        
        String itemSelect = (String) comboBoxList.getSelectedItem();

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  book_id,book_isbn,author,title,publisher_name,edition,subject_category,loan_type,borrowed,book_condition FROM books_db WHERE borrowed='"+ itemSelect +"'");
            ResultSet rsIssue = st.executeQuery();

            int i = 0;
            while (rsIssue.next()) {
                bookID = rsIssue.getString("book_id");
                bookISBNList = rsIssue.getString("book_isbn");
                authorNameList = rsIssue.getString("author");
                titleNameList = rsIssue.getString("title");
                publisherList = rsIssue.getString("publisher_name");
                editionList = rsIssue.getString("edition");
                categoryList = rsIssue.getString("subject_category");
                loanList = rsIssue.getString("loan_type");
                borrowedList = rsIssue.getString("borrowed");
                conditionList = rsIssue.getString("book_condition");

                listModel.addRow(new Object[]{bookID, bookISBNList, authorNameList, titleNameList, publisherList,editionList,categoryList,loanList,borrowedList,conditionList});
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

public void displayBooksListFilterTitle() {

        listModel.setColumnIdentifiers(listColumnNames);

        tableListBooks.setModel(listModel);

        tableListBooks.setFillsViewportHeight(true);
        
        String itemSelect = txtListBooks.getText().toUpperCase().trim();

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  book_id,book_isbn,author,title,publisher_name,edition,subject_category,loan_type,borrowed,book_condition FROM books_db WHERE title='"+ itemSelect +"'");
            ResultSet rsIssue = st.executeQuery();

            int i = 0;
            while (rsIssue.next()) {
                bookID = rsIssue.getString("book_id");
                bookISBNList = rsIssue.getString("book_isbn");
                authorNameList = rsIssue.getString("author");
                titleNameList = rsIssue.getString("title");
                publisherList = rsIssue.getString("publisher_name");
                editionList = rsIssue.getString("edition");
                categoryList = rsIssue.getString("subject_category");
                loanList = rsIssue.getString("loan_type");
                borrowedList = rsIssue.getString("borrowed");
                conditionList = rsIssue.getString("book_condition");

                listModel.addRow(new Object[]{bookID, bookISBNList, authorNameList, titleNameList, publisherList,editionList,categoryList,loanList,borrowedList,conditionList});
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

public void DisplayBooksStock() {

        stockModel.setColumnIdentifiers(stockColumnNames);

        tableBookStock.setModel(stockModel);

        tableBookStock.setFillsViewportHeight(true);
        
        String borrowedNo = "NO";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  book_id,book_isbn,author,title,publisher_name,edition,subject_category,loan_type FROM books_db WHERE borrowed='"+ borrowedNo +"'");
            ResultSet rsIssue = st.executeQuery();

            int i = 0;
            while (rsIssue.next()) {
                stockbookID = rsIssue.getString("book_id");
                stockbookISBNList = rsIssue.getString("book_isbn");
                stockauthorNameList = rsIssue.getString("author");
                stocktitleNameList = rsIssue.getString("title");
                stockpublisherList = rsIssue.getString("publisher_name");
                stockeditionList = rsIssue.getString("edition");
                stockcategoryList = rsIssue.getString("subject_category");
                stockloanList = rsIssue.getString("loan_type");

                stockModel.addRow(new Object[]{stockbookID, stockbookISBNList, stockauthorNameList, stocktitleNameList, stockpublisherList,stockeditionList,stockcategoryList,stockloanList});
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

public void filterBooksStockCat() {

        stockModel.setColumnIdentifiers(stockColumnNames);

        tableBookStock.setModel(stockModel);

        tableBookStock.setFillsViewportHeight(true);
        
        String itemCat = (String) comboFilterStock.getSelectedItem();
        
        String borrowedNo = "NO";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  book_id,book_isbn,author,title,publisher_name,edition,subject_category,loan_type FROM books_db WHERE borrowed='"+ borrowedNo +"' AND subject_category='"+ itemCat +"'");
            ResultSet rsIssue = st.executeQuery();

            int i = 0;
            while (rsIssue.next()) {
                stockbookID = rsIssue.getString("book_id");
                stockbookISBNList = rsIssue.getString("book_isbn");
                stockauthorNameList = rsIssue.getString("author");
                stocktitleNameList = rsIssue.getString("title");
                stockpublisherList = rsIssue.getString("publisher_name");
                stockeditionList = rsIssue.getString("edition");
                stockcategoryList = rsIssue.getString("subject_category");
                stockloanList = rsIssue.getString("loan_type");

                stockModel.addRow(new Object[]{stockbookID, stockbookISBNList, stockauthorNameList, stocktitleNameList, stockpublisherList,stockeditionList,stockcategoryList,stockloanList});
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

public void filterBooksStocktitle() {

        stockModel.setColumnIdentifiers(stockColumnNames);

        tableBookStock.setModel(stockModel);

        tableBookStock.setFillsViewportHeight(true);
        
        String itemCat = txtSearchText.getText().toUpperCase().trim();
        
        String borrowedNo = "NO";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  book_id,book_isbn,author,title,publisher_name,edition,subject_category,loan_type FROM books_db WHERE borrowed='"+ borrowedNo +"' AND title='"+ itemCat +"'");
            ResultSet rsIssue = st.executeQuery();

            int i = 0;
            while (rsIssue.next()) {
                stockbookID = rsIssue.getString("book_id");
                stockbookISBNList = rsIssue.getString("book_isbn");
                stockauthorNameList = rsIssue.getString("author");
                stocktitleNameList = rsIssue.getString("title");
                stockpublisherList = rsIssue.getString("publisher_name");
                stockeditionList = rsIssue.getString("edition");
                stockcategoryList = rsIssue.getString("subject_category");
                stockloanList = rsIssue.getString("loan_type");

                stockModel.addRow(new Object[]{stockbookID, stockbookISBNList, stockauthorNameList, stocktitleNameList, stockpublisherList,stockeditionList,stockcategoryList,stockloanList});
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

public void displayBorrowersList() {
    
        borrowerModel.setColumnIdentifiers(borrowersColumnNames);

        tableBorrowers.setModel(borrowerModel);

        tableBorrowers.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("select  borrower_entry_no,borrower_id,borrower_name1,borrower_name2,book_title,book_isbn,student_staff from borrowers_db");
            ResultSet listRs = st.executeQuery();

            int i = 0;
            while (listRs.next()) {
                entryNo = listRs.getString("borrower_entry_no");
                borrowerId = listRs.getString("borrower_id");
                bName1 = listRs.getString("borrower_name1");
                bName2 = listRs.getString("borrower_name2");
                bTitle = listRs.getString("book_title");
                bIsbn = listRs.getString("book_isbn");
                staffStudent = listRs.getString("student_staff");

                borrowerModel.addRow(new Object[]{entryNo, borrowerId, bName1, bName2, bTitle,bIsbn,staffStudent});
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

public void numberOfBooks(){
    
    String boorrowedCondtion = "NO";
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
        PreparedStatement os = con.prepareStatement("select count(book_id) as bookcount_no from books_db where borrowed='"+ boorrowedCondtion +"'");
        ResultSet rsCs = os.executeQuery();
        
        int i = 0;
            if(rsCs.next()){    
                String repoCount = rsCs.getString("bookcount_no");
                labelBookNo.setText(repoCount);}
            
            else{}
                
    }catch(ClassNotFoundException | SQLException | HeadlessException es){
    JOptionPane.showMessageDialog(null, es.getMessage());}
    }

public void numberOfBooksBorrowed(){
    
    String boorrowedCondtionyes = "YES";
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
        PreparedStatement os = con.prepareStatement("select count(book_id) as bookcount_no from books_db where borrowed='"+ boorrowedCondtionyes +"'");
        ResultSet rsCs = os.executeQuery();
        
        int i = 0;
            if(rsCs.next()){    
                String repoCount = rsCs.getString("bookcount_no");
                labelBooksBorrowed.setText(repoCount);}
            
            else{}
                
    }catch(ClassNotFoundException | SQLException | HeadlessException es){
    JOptionPane.showMessageDialog(null, es.getMessage());}
    }

public void numberOfBorrowers(){
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
        PreparedStatement os = con.prepareStatement("select count(borrower_entry_no) as borrowercount_no from borrowers_db");
        ResultSet rsCs = os.executeQuery();
        
        int i = 0;
            if(rsCs.next()){    
                String repoCount = rsCs.getString("borrowercount_no");
                lblNoOfBorrowers.setText(repoCount);}
            
            else{}
                
    }catch(ClassNotFoundException | SQLException | HeadlessException es){
    JOptionPane.showMessageDialog(null, es.getMessage());}
    }

public void limitBorrowersStudents(){
    
    String limitNo = txtStdntAmNo.getText().trim();
    String numberlimit = maxStd.getText();
    int noLimit = Integer.parseInt(numberlimit);
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
        PreparedStatement os = con.prepareStatement("SELECT COUNT(borrower_id) AS borrowertimes_no FROM borrowers_db WHERE borrower_id='"+ limitNo +"' AND student_staff=\"STUDENT\"");
        ResultSet rsCs = os.executeQuery();
        
        int i = 0;
            if(rsCs.next())
            {    
                String limitCount = rsCs.getString("borrowertimes_no");
                int boroLimit = Integer.parseInt(limitCount);
                if(boroLimit < noLimit)
                {
                    issueToStudents();
                } else {
                    JOptionPane.showMessageDialog(null, "Limit of books borrowed reached");
                       }
            }
            
    }catch(ClassNotFoundException | SQLException | HeadlessException es){
    JOptionPane.showMessageDialog(null, es.getMessage());}
 }

public void limitBorrowersStaff(){
    
    String limitNo = txtStaffID.getText().trim();
    String numberlimit = maxStaff.getText();
    int noLimit = Integer.parseInt(numberlimit);
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
        PreparedStatement os = con.prepareStatement("SELECT COUNT(borrower_id) AS borrowertimes_no FROM borrowers_db WHERE borrower_id='"+ limitNo +"' AND student_staff=\"STUDENT\"");
        ResultSet rsCs = os.executeQuery();
        
        int i = 0;
            if(rsCs.next())
            {    
                String limitCount = rsCs.getString("borrowertimes_no");
                int boroLimit = Integer.parseInt(limitCount);
                if(boroLimit < noLimit)
                {
                    issueToStaff();
                } else {
                    JOptionPane.showMessageDialog(null, "Limit of books borrowed reached");
                       }
            }
            
            else{}
                
    }catch(ClassNotFoundException | SQLException | HeadlessException es){
    JOptionPane.showMessageDialog(null, es.getMessage());}
 }

public void displayBooksShortLoan() {
    
        String loanType = "SHORT";
        String boorrowedCondtion = "NO";

        shortModel.setColumnIdentifiers(shortColumnNames);

        tableShortLoanBook.setModel(shortModel);

        tableShortLoanBook.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("select  book_id,book_isbn,author,title,publisher_name,edition,subject_category from books_db where (loan_type='"+ loanType +"' and borrowed='"+ boorrowedCondtion +"')");
            ResultSet loanRs = st.executeQuery();
            
            int i = 0;
            while (loanRs.next()) {
                shortbookID = loanRs.getString("book_id");
                shortbookISBNList = loanRs.getString("book_isbn");
                shortauthorNameList = loanRs.getString("author");
                shorttitleNameList = loanRs.getString("title");
                shortpublisherList = loanRs.getString("publisher_name");
                shorteditionList = loanRs.getString("edition");
                shortcategoryList = loanRs.getString("subject_category");

                shortModel.addRow(new Object[]{shortbookID, shortbookISBNList, shortauthorNameList, shorttitleNameList, shortpublisherList,shorteditionList,shortcategoryList});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "all books for short loan have been issued", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void searchBooksShortLoanItem() {
    
        String itemSelected = (String) comboSearchShort.getSelectedItem();
        String loanType = "SHORT";
        String boorrowedCondtion = "NO";

        shortModel.setColumnIdentifiers(shortColumnNames);

        tableShortLoanBook.setModel(shortModel);

        tableShortLoanBook.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  book_id,book_isbn,author,title,publisher_name,edition,subject_category from books_db WHERE (loan_type='"+ loanType +"' AND borrowed='"+ boorrowedCondtion +"' AND subject_category='"+ itemSelected +"' )");
            ResultSet loanRs = st.executeQuery();
            
            int i = 0;
            while (loanRs.next()) {
                shortbookID = loanRs.getString("book_id");
                shortbookISBNList = loanRs.getString("book_isbn");
                shortauthorNameList = loanRs.getString("author");
                shorttitleNameList = loanRs.getString("title");
                shortpublisherList = loanRs.getString("publisher_name");
                shorteditionList = loanRs.getString("edition");
                shortcategoryList = loanRs.getString("subject_category");

                shortModel.addRow(new Object[]{shortbookID, shortbookISBNList, shortauthorNameList, shorttitleNameList, shortpublisherList,shorteditionList,shortcategoryList});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "Books in selected category not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            //JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void searchBooksShortLoan() {
    

        shortModel.setColumnIdentifiers(shortColumnNames);

        tableShortLoanBook.setModel(shortModel);

        tableShortLoanBook.setFillsViewportHeight(true);
       
        String shortBkID = txtSearchShort.getText().toUpperCase().trim();
        if(shortBkID.equals("")){
        JOptionPane.showMessageDialog(null, "Enter the book title to search");}
        else
        {
            try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT book_id,book_isbn,author,title,publisher_name,edition,subject_category FROM books_db WHERE loan_type=\"SHORT\" AND borrowed=\"NO\" AND title='"+ shortBkID +"'");
            ResultSet loanRs = st.executeQuery();
            
            int i = 0;
            while (loanRs.next()) {
                shortbookID = loanRs.getString("book_id");
                shortbookISBNList = loanRs.getString("book_isbn");
                shortauthorNameList = loanRs.getString("author");
                shorttitleNameList = loanRs.getString("title");
                shortpublisherList = loanRs.getString("publisher_name");
                shorteditionList = loanRs.getString("edition");
                shortcategoryList = loanRs.getString("subject_category");

                shortModel.addRow(new Object[]{shortbookID, shortbookISBNList, shortauthorNameList, shorttitleNameList, shortpublisherList,shorteditionList,shortcategoryList});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "please check your spelling otherwise the book may be issued", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            //JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

}

public void displayBooksIssueStudents() {
    
        String loanType = "LONG";
        String boorrowedCondtion = "NO";

        issueModel.setColumnIdentifiers(issueColumnNames);

        tableIssueToStudents.setModel(issueModel);

        tableIssueToStudents.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("select  book_id,book_isbn,author,title,publisher_name,edition,subject_category from books_db where (loan_type='"+ loanType +"' and borrowed='"+ boorrowedCondtion +"')");
            ResultSet studentRs = st.executeQuery();
            
            int i = 0;
            while (studentRs.next()) {
                issuebookID = studentRs.getString("book_id");
                issuebookISBNList = studentRs.getString("book_isbn");
                issueauthorNameList = studentRs.getString("author");
                issuetitleNameList = studentRs.getString("title");
                issuepublisherList = studentRs.getString("publisher_name");
                issueeditionList = studentRs.getString("edition");
                issuecategoryList = studentRs.getString("subject_category");

                issueModel.addRow(new Object[]{issuebookID, issuebookISBNList, issueauthorNameList, issuetitleNameList, issuepublisherList,issueeditionList,issuecategoryList});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "all books for long loan have been issued", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void displayMagz() {
    
        String boorrowedCondtion = "YES";

        magModel.setColumnIdentifiers(magColumnNames);

        tableMags.setModel(magModel);

        tableMags.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  issue_number,mag_name,publisher,mag_date FROM magazine WHERE returned='"+ boorrowedCondtion +"'");
            ResultSet studentRs = st.executeQuery();
            //magIssueNo = "", magName = "", magPublisher = "", magDate = "";
            int i = 0;
            while (studentRs.next()) {
                magIssueNo = studentRs.getString("issue_number");
                magName = studentRs.getString("mag_name");
                magPublisher = studentRs.getString("publisher");
                magDate = studentRs.getString("mag_date");

                magModel.addRow(new Object[]{magIssueNo, magName, magPublisher, magDate});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "no magazines to issue", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            //JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void displayMagzdetails() {
    
        String boorrowedCondtion = "NO";

        magDetailsModel.setColumnIdentifiers(magDetailsColumnNames);

        tableMagzBoro.setModel(magDetailsModel);

        tableMagzBoro.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  issue_number,mag_name,publisher,mag_date,issued_to_id,issued_to_name,issued_by,recieved_by,staff_std FROM magazine WHERE returned='"+ boorrowedCondtion +"'");
            ResultSet studentRs = st.executeQuery();
            //magboroNo = "", magboroName = "", magboroPublisher = "", magboroDate = "", magboroIssuedtoID="",magboroIssuedto="",magissuedBy="",recievedBy="",studentStaff="";
            int i = 0;
            while (studentRs.next()) {
                magboroNo = studentRs.getString("issue_number");
                magboroName = studentRs.getString("mag_name");
                magboroPublisher = studentRs.getString("publisher");
                magboroDate = studentRs.getString("mag_date");
                magboroIssuedtoID = studentRs.getString("issued_to_id");
                magboroIssuedto = studentRs.getString("issued_to_name");
                studentStaff = studentRs.getString("staff_std");
                magissuedBy = studentRs.getString("issued_by");
                recievedBy = studentRs.getString("recieved_by");
                                

                magDetailsModel.addRow(new Object[]{magboroNo, magboroName, magboroPublisher, magboroDate,magboroIssuedtoID,magboroIssuedto,studentStaff,magissuedBy,recievedBy});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No magazines have been issued", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            //JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void displayMagzSearch() {
    
        String boorrowedCondtion = "YES";
        Date searchDate = chooserMagz.getDate();

        magModel.setColumnIdentifiers(magColumnNames);

        tableMags.setModel(magModel);

        tableMags.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  issue_number,mag_name,publisher,mag_date FROM magazine WHERE returned='"+ boorrowedCondtion +"' AND mag_date='"+ searchDate +"'");
            ResultSet studentRs = st.executeQuery();
            //magIssueNo = "", magName = "", magPublisher = "", magDate = "";
            int i = 0;
            while (studentRs.next()) {
                magIssueNo = studentRs.getString("issue_number");
                magName = studentRs.getString("mag_name");
                magPublisher = studentRs.getString("publisher");
                magDate = studentRs.getString("mag_date");

                magModel.addRow(new Object[]{magIssueNo, magName, magPublisher, magDate});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No magazines for that date available", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            //JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void searchBooksIssueStudentsItem() {
        
        String itemSelected = (String) comboSearchIssue.getSelectedItem();
        String loanType = "LONG";
        String boorrowedCondtion = "NO";

        issueModel.setColumnIdentifiers(issueColumnNames);

        tableIssueToStudents.setModel(issueModel);

        tableIssueToStudents.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  book_id,book_isbn,author,title,publisher_name,edition,subject_category from books_db WHERE (loan_type='"+ loanType +"' AND borrowed='"+ boorrowedCondtion +"' AND subject_category='"+ itemSelected +"' )");
            ResultSet studentRs = st.executeQuery();
            
            int i = 0;
            while (studentRs.next()) {
                issuebookID = studentRs.getString("book_id");
                issuebookISBNList = studentRs.getString("book_isbn");
                issueauthorNameList = studentRs.getString("author");
                issuetitleNameList = studentRs.getString("title");
                issuepublisherList = studentRs.getString("publisher_name");
                issueeditionList = studentRs.getString("edition");
                issuecategoryList = studentRs.getString("subject_category");

                issueModel.addRow(new Object[]{issuebookID, issuebookISBNList, issueauthorNameList, issuetitleNameList, issuepublisherList,issueeditionList,issuecategoryList});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "all books for long loan have been issued", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void searchBooksLongLoanStd() {
    

        issueModel.setColumnIdentifiers(issueColumnNames);

        tableIssueToStudents.setModel(issueModel);

        tableIssueToStudents.setFillsViewportHeight(true);
       
        String longBkTitle = txtSearchIssueStd.getText().toUpperCase().trim();
        if(longBkTitle.equals("")){
        JOptionPane.showMessageDialog(null, "Enter the book ID to search");}
        else
        {
            try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT book_id,book_isbn,author,title,publisher_name,edition,subject_category FROM books_db WHERE loan_type=\"LONG\" AND borrowed=\"NO\" AND title='"+ longBkTitle +"'");
            ResultSet loanRs = st.executeQuery();
            
            int i = 0;
            while (loanRs.next()) {
                issuebookID = loanRs.getString("book_id");
                issuebookISBNList = loanRs.getString("book_isbn");
                issueauthorNameList = loanRs.getString("author");
                issuetitleNameList = loanRs.getString("title");
                issuepublisherList = loanRs.getString("publisher_name");
                issueeditionList = loanRs.getString("edition");
                issuecategoryList = loanRs.getString("subject_category");

                issueModel.addRow(new Object[]{issuebookID, issuebookISBNList, issueauthorNameList, issuetitleNameList, issuepublisherList,issueeditionList,issuecategoryList});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "This book is either issued, lost or not in the library database", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            //JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

}

public void searchBooksIssueStaffCategory() {
    
        String loanType = "LONG";
        String boorrowedCondtion = "NO";
        String itemSelect = (String) comboSearchInStaffIssue.getSelectedItem();

        issueSModel.setColumnIdentifiers(issueSColumnNames);

        tableBooksForStaff.setModel(issueSModel);

        tableBooksForStaff.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  book_id,book_isbn,author,title,publisher_name,edition,subject_category FROM books_db WHERE (loan_type='"+ loanType +"' AND borrowed='"+ boorrowedCondtion +"' AND subject_category='"+ itemSelect +"')");
            ResultSet staffRs = st.executeQuery();
            
            int i = 0;
            while (staffRs.next()) {
                issueSbookID = staffRs.getString("book_id");
                issueSbookISBNList = staffRs.getString("book_isbn");
                issueSauthorNameList = staffRs.getString("author");
                issueStitleNameList = staffRs.getString("title");
                issueSpublisherList = staffRs.getString("publisher_name");
                issueSeditionList = staffRs.getString("edition");
                issueScategoryList = staffRs.getString("subject_category");

                issueSModel.addRow(new Object[]{issueSbookID, issueSbookISBNList, issueSauthorNameList, issueStitleNameList, issueSpublisherList,issueSeditionList,issueScategoryList});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "all books for long loan have been issued", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void searchBooksIssueStaffTitle() {
    
        String loanType = "LONG";
        String boorrowedCondtion = "NO";
        String itemSelect = txtSearchStaffBook.getText().toUpperCase().trim();

        issueSModel.setColumnIdentifiers(issueSColumnNames);

        tableBooksForStaff.setModel(issueSModel);

        tableBooksForStaff.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  book_id,book_isbn,author,title,publisher_name,edition,subject_category FROM books_db WHERE (loan_type='"+ loanType +"' AND borrowed='"+ boorrowedCondtion +"' AND title='"+ itemSelect +"')");
            ResultSet staffRs = st.executeQuery();
            
            int i = 0;
            while (staffRs.next()) {
                issueSbookID = staffRs.getString("book_id");
                issueSbookISBNList = staffRs.getString("book_isbn");
                issueSauthorNameList = staffRs.getString("author");
                issueStitleNameList = staffRs.getString("title");
                issueSpublisherList = staffRs.getString("publisher_name");
                issueSeditionList = staffRs.getString("edition");
                issueScategoryList = staffRs.getString("subject_category");

                issueSModel.addRow(new Object[]{issueSbookID, issueSbookISBNList, issueSauthorNameList, issueStitleNameList, issueSpublisherList,issueSeditionList,issueScategoryList});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "all books for long loan have been issued", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void displayBooksIssueStaff() {
    
        String loanType = "LONG";
        String boorrowedCondtion = "NO";

        issueSModel.setColumnIdentifiers(issueSColumnNames);

        tableBooksForStaff.setModel(issueSModel);

        tableBooksForStaff.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("select  book_id,book_isbn,author,title,publisher_name,edition,subject_category from books_db where (loan_type='"+ loanType +"' and borrowed='"+ boorrowedCondtion +"')");
            ResultSet staffRs = st.executeQuery();
            
            int i = 0;
            while (staffRs.next()) {
                issueSbookID = staffRs.getString("book_id");
                issueSbookISBNList = staffRs.getString("book_isbn");
                issueSauthorNameList = staffRs.getString("author");
                issueStitleNameList = staffRs.getString("title");
                issueSpublisherList = staffRs.getString("publisher_name");
                issueSeditionList = staffRs.getString("edition");
                issueScategoryList = staffRs.getString("subject_category");

                issueSModel.addRow(new Object[]{issueSbookID, issueSbookISBNList, issueSauthorNameList, issueStitleNameList, issueSpublisherList,issueSeditionList,issueScategoryList});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "all books for long loan have been issued", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void displayBooksBorrowed(){

        boroModel.setColumnIdentifiers(boroColumnNames);

        tableBooksIssued.setModel(boroModel);
        
        tableBooksIssued.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT book_id, book_isbn, author, title, publisher_name, "
                    + "edition, name1_of_borrower,name2_of_borrower, borrowed_by_id FROM books_db WHERE borrowed=\"YES\"");
            ResultSet rsIssue = st.executeQuery();
            
            int i = 0;
            while (rsIssue.next()) {
                boroBookId = rsIssue.getString("book_id");
                boroBookIsbn = rsIssue.getString("book_isbn");
                boroAuthorNameList = rsIssue.getString("author");
                boroBookTitle = rsIssue.getString("title");
                boroPublisherList = rsIssue.getString("publisher_name");
                boroEditionList = rsIssue.getString("edition");
                boroFname = rsIssue.getString("name1_of_borrower");
                boroLname = rsIssue.getString("name2_of_borrower");

                boroModel.addRow(new Object[]{boroBookId, boroBookIsbn, boroAuthorNameList, boroBookTitle, boroPublisherList,boroEditionList,boroFname,boroLname});
                i++;
            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "All books have been returned", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void issueToStudents() {                                        
        
        String stdntID = txtStdntAmNo.getText().toUpperCase().trim();
        String stdntFname = txtSdntFname.getText().toUpperCase().trim();
        String stdntLname = txtStdntLname.getText().toUpperCase().trim();
        String StdntClass = txtStdntClass.getText().toUpperCase().trim();
        Date dateBorrowed = DateBorrowed.getDate();
        Date dateDue = dateChooserDue.getDate();
        String bookdIssue = txtBookIdIssue.getText();
        String titleIssue = txtBookIssueTitle1.getText();
        String bookIsbnIssue = txtBookIsbnIssue.getText();
        String student = "STUDENT";
        String borrowedStatus = "YES";
        
        String librarianName = lblUserId.getText().toUpperCase().trim();
        String librarianID = lblID.getText();
        
        if(stdntID.isEmpty()){
            JOptionPane.showMessageDialog(null, "Student Admission/ID required");
            txtStdntAmNo.requestFocus();
        }else if(stdntFname.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter student's first name");
            txtSdntFname.requestFocus();
        }else if(stdntLname.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter student's last name");
            txtStdntLname.requestFocus();
        }else if(StdntClass.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter student's class/form");
            txtStdntClass.requestFocus();
        }else if(dateDue == null){
            JOptionPane.showMessageDialog(null, "Select date due for the book");
        }else if(bookdIssue.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please select a book from the table");
        }
        else{
            try {
                String url = "jdbc:mysql://localhost/libsystem?useSSL = false";
                Connection conn;
                conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
               
                //--------update books db-----------
                String sql = "UPDATE books_db SET borrowed='" + borrowedStatus + "',borrowed_by_id='" + stdntID + "'"
                        + ",name1_of_borrower='" + stdntFname + "',name2_of_borrower='" + stdntLname + "'"
                        + ",staff_std='" + student + "',date_due='" + dateDue + "',received_on=NULL ,date_borrowed='" + dateBorrowed + "'WHERE book_id=" + bookdIssue;
                
                PreparedStatement pst;
                pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                statement = con.createStatement();

                //---------SQL Insert into student db------------
                String sql2 = "INSERT INTO student_db " + "(adm_no, std_fname, std_lname, form, "
                        + "date_borrowed, date_due,book_id,book_isbn,book_title,issued_by_id,issued_by_name)"
                            + "VALUES ('" + stdntID + "','"
                            + stdntFname + "','"
                            + stdntLname + "','"
                            + StdntClass + "','"
                            + dateBorrowed + "','"
                            + dateDue + "','"
                            + bookdIssue + "','"
                            + bookIsbnIssue + "','"
                            + titleIssue + "','"
                            + librarianID + "','"
                            + librarianName + "') ";
                    
                statement.execute(sql2);
                
                //-----------insert into borrowers db-----------
                String sql3 = "INSERT INTO borrowers_db " + "(book_id,book_isbn,book_title,borrower_id, borrower_name1, borrower_name2,student_staff)"
                            + "VALUES ('" + bookdIssue + "','"
                            + bookIsbnIssue + "','"
                            + titleIssue + "','"
                            + stdntID + "','"
                            + stdntFname + "','"
                            + stdntLname + "','"
                            + student + "') ";
                    
                statement.execute(sql3);

                //-----clear text fields after above------------
                
                JOptionPane.showMessageDialog(null, "Book successfully issued to "+ stdntFname +" "+ stdntLname);
                
                txtStdntAmNo.setText("");
                txtSdntFname.setText("");
                txtStdntLname.setText("");
                txtStdntClass.setText("");
                txtBookIssueTitle1.setText("");
                txtBookIdIssue.setText("");
                txtBookIsbnIssue.setText("");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }
}

public void issueShortToStudents() {                                        
        
        String stdntID = txtStaffstdId.getText().trim();
        String stdntFname = txtShortFname.getText().toUpperCase().trim();
        String stdntLname = txtShortLname.getText().toUpperCase().trim();
        String StdntClass = txtShortClass.getText();
        Date dateBorrowed = DateBorrowed.getDate();
        Date dateDue = DateBorrowed.getDate();
        String bookdIssue = txtShortBkId.getText();
        String titleIssue = txtShortBkTitle.getText();
        String bookIsbnIssue = txtShortBkIsbn.getText();
        int timelapse = SpinfieldTimeLoan.getValue();
        String student = "STUDENT";
        String borrowedStatus = "YES";
        
        String librarianName = lblUserId.getText().toUpperCase().trim();
        String librarianID = lblID.getText();

            try {
                String url = "jdbc:mysql://localhost/libsystem?useSSL = false";
                Connection conn;
                conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
               
                //--------update books db-----------
                String sql = "UPDATE books_db SET borrowed='" + borrowedStatus + "',borrowed_by_id='" + stdntID + "'"
                        + ",name1_of_borrower='" + stdntFname + "',name2_of_borrower='" + stdntLname + "'"
                        + ",staff_std='" + student + "',date_due='" + dateDue + "',received_on=NULL ,date_borrowed='" + dateBorrowed + "'WHERE book_id=" + bookdIssue;
                
                PreparedStatement pst;
                pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                statement = con.createStatement();

                //---------SQL Insert into student db------------
                String sql2 = "INSERT INTO student_db " + "(adm_no, std_fname, std_lname, form, "
                        + "date_borrowed, date_due,book_id,book_isbn,book_title,issued_by_id,issued_by_name)"
                            + "VALUES ('" + stdntID + "','"
                            + stdntFname + "','"
                            + stdntLname + "','"
                            + StdntClass + "','"
                            + dateBorrowed + "','"
                            + dateDue + "','"
                            + bookdIssue + "','"
                            + bookIsbnIssue + "','"
                            + titleIssue + "','"
                            + librarianID + "','"
                            + librarianName + "') ";
                    
                statement.execute(sql2);
                
                //-----------insert into borrowers db-----------
                String sql3 = "INSERT INTO borrowers_db " + "(book_id,book_isbn,book_title,borrower_id, borrower_name1, borrower_name2,student_staff)"
                            + "VALUES ('" + bookdIssue + "','"
                            + bookIsbnIssue + "','"
                            + titleIssue + "','"
                            + stdntID + "','"
                            + stdntFname + "','"
                            + stdntLname + "','"
                            + student + "') ";
                    
                statement.execute(sql3);

                //-----clear text fields after above------------
                
                JOptionPane.showMessageDialog(null, "Book issued to "+ stdntFname +" "+ stdntLname+ " must be returned in "+ timelapse +"Hrs");
                
                txtStaffstdId.setText("");
                txtShortFname.setText("");
                txtShortLname.setText("");
                txtShortClass.setText("");
                comboStaffStudent.setSelectedIndex(0);
                txtShortBkTitle.setText("");
                txtShortBkId.setText("");
                txtShortBkIsbn.setText("");
                SpinfieldTimeLoan.setValue(1);
                txtShortDept.setText("");
                txtStaffNo.setText("");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
    
}

public void issueMagzToStudents() {                                        
        
        String stdntID = txtMagzNameID.getText();
        String stdntFname = txtMagzName1.getText().toUpperCase().trim();
        String stdntLname = txtMagzName2.getText().toUpperCase().trim();
        String name = stdntFname+" "+stdntLname;
        String StdntClass = txtMagzClass.getText();
        Date dateBorrowed = chooserMagzBoro.getDate();
        Date dateDue = chooserMagzDue.getDate();
        String bookdIssue = txtMagzIssueNo.getText();
        String titleIssue = txtMagzTitle.getText();
        String magzDate = txtMagzDate.getText();
        String student = (String) comboMagz.getSelectedItem();
        String borrowedStatus = "NO";
        
        String librarianName = lblUserId.getText().toUpperCase().trim();
        String librarianID = lblID.getText();

            try {
                String url = "jdbc:mysql://localhost/libsystem?useSSL = false";
                Connection conn;
                conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
               
                //--------update books db-----------
                String sql = "UPDATE magazine SET returned='" + borrowedStatus + "',issued_to_id='" + stdntID + "'"
                        + ",issued_to_name='" + name + "',staff_std='" + student + "',issued_by='" + librarianName + "' WHERE issue_number=" + bookdIssue;
                
                PreparedStatement pst;
                pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                statement = con.createStatement();

                //-----clear text fields after above------------
                
                JOptionPane.showMessageDialog(null, "Magazine issued to "+ stdntFname +" "+ stdntLname+ " must be returned on "+ dateDue);
                
                txtMagzNameID.setText("");
                txtMagzName1.setText("");
                txtMagzName2.setText("");
                txtMagzClass.setText("");
                comboMagz.setSelectedIndex(0);
                txtMagzPhone.setText("");
                txtMagzDept.setText("");
                txtMagzIssueNo.setText("");
                txtMagzTitle.setText("");
                txtMagzDate.setText("");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
    
}

public void issueToStaff() {                                        
        
        String staffID = txtStaffID.getText().toUpperCase().trim();
        String staffFname = txtStaffName1.getText().toUpperCase().trim();
        String staffLname = txtStaffName2.getText().toUpperCase().trim();
        String StaffDept = txtStaffDept.getText().toUpperCase().trim();
        String phoneNo = txtStaffPhone.getText().trim();
        Date dateBorrowedStaff = staffDateBorrowed.getDate();
        Date dateDueStaff = dateStaffDue.getDate();
        String bookdIssueStaff = txtStaffBookId.getText();
        String titleIssueStaff = txtStaffBkTitle.getText();
        String bookIsbnIssueStaff = txtStaffBookIsbn.getText();
        String staff = "STAFF";
        String borrowedStatusStaff = "YES";
        
        String librarianName = lblUserId.getText().toUpperCase().trim();
        String librarianID = lblID.getText();
        
        if(staffID.isEmpty()){
            JOptionPane.showMessageDialog(null, "Staff ID required");
            txtStaffID.requestFocus();
        }else if(staffFname.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter staff's first name");
            txtStaffName1.requestFocus();
        }else if(staffLname.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter staff's last name");
            txtStdntLname.requestFocus();
        }else if(StaffDept.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter staff's deoartment");
            txtStdntClass.requestFocus();
        }else if(phoneNo.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter staff's phone number");
            txtStdntClass.requestFocus();
        }else if(dateDueStaff == null){
            JOptionPane.showMessageDialog(null, "Select date due for the book");
        }else if(bookdIssueStaff.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please select a book from the table");
        }
        else{
            try {
                String url = "jdbc:mysql://localhost/libsystem?useSSL = false";
                Connection conn;
                conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
               
                //--------update books db-----------
                String sql = "UPDATE books_db SET borrowed='" + borrowedStatusStaff + "',borrowed_by_id='" + staffID + "'"
                        + ",name1_of_borrower='" + staffFname + "',name2_of_borrower='" + staffLname + "'"
                        + ",staff_std='" + staff + "',date_due='" + dateDueStaff + "',received_on= NULL ,date_borrowed='" + dateBorrowedStaff + "'WHERE book_id=" + bookdIssueStaff;
                
                PreparedStatement pst;
                pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                statement = con.createStatement();

                //---------SQL Insert into student db------------
                String sql2 = "INSERT INTO staff_db " + "(id_number, staff_fname, staff_lname, dept, "
                        + "date_borrowed, date_due,book_id,book_isbn,book_title,phone_no,issued_by,issued_by_id)"
                            + "VALUES ('" + staffID + "','"
                            + staffFname + "','"
                            + staffLname + "','"
                            + StaffDept + "','"
                            + dateBorrowedStaff + "','"
                            + dateDueStaff + "','"
                            + bookdIssueStaff + "','"
                            + bookIsbnIssueStaff + "','"
                            + titleIssueStaff + "','"
                            + phoneNo + "','"
                            + librarianName + "','"
                            + librarianID + "') ";
                    
                statement.execute(sql2);
                
                //-----------insert into borrowers db-----------
                String sql3 = "INSERT INTO borrowers_db " + "(book_id,book_isbn,book_title,borrower_id, borrower_name1, borrower_name2,student_staff)"
                            + "VALUES ('" + bookdIssueStaff + "','"
                            + bookIsbnIssueStaff + "','"
                            + titleIssueStaff + "','"
                            + staffID + "','"
                            + staffFname + "','"
                            + staffLname + "','"
                            + staff + "') ";
                    
                statement.execute(sql3);

                //-----clear text fields after above------------
                
                JOptionPane.showMessageDialog(null, "Book successfully isued to "+ staffFname +" "+ staffLname);
                
                txtStaffID.setText("");
                txtStaffName1.setText("");
                txtStaffName2.setText("");
                txtStaffDept.setText("");
                txtStaffPhone.setText("");
                txtStaffBkTitle.setText("");
                txtStaffBookId.setText("");
                txtStaffBookIsbn.setText("");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }
}

public void issueMagzToStaff(){                                        
        
        String stdntID = txtMagzNameID.getText();
        String stdntFname = txtMagzName1.getText().toUpperCase().trim();
        String stdntLname = txtMagzName2.getText().toUpperCase().trim();
        String name = stdntFname+" "+stdntLname;
        String deptShortStaff = txtMagzDept.getText();
        Date dateBorrowed = chooserMagzBoro.getDate();
        Date dateDue = chooserMagzDue.getDate();
        String bookdIssue = txtMagzIssueNo.getText();
        String titleIssue = txtMagzTitle.getText();
        String magzDate = txtMagzDate.getText();
        String phoneToShort = txtMagzPhone.getText();
        String student = (String) comboMagz.getSelectedItem();
        String borrowedStatus = "NO";
        
        String librarianName = lblUserId.getText().toUpperCase().trim();
        String librarianID = lblID.getText();

            try {
                String url = "jdbc:mysql://localhost/libsystem?useSSL = false";
                Connection conn;
                conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
               
                //--------update books db-----------
              String sql = "UPDATE magazine SET returned='" + borrowedStatus + "',issued_to_id='" + stdntID + "'"
                        + ",issued_to_name='" + name + "',staff_std='" + student + "',issued_by='" + librarianName + "' WHERE issue_number=" + bookdIssue;
                
                PreparedStatement pst;
                pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                statement = con.createStatement();

                //-----clear text fields after above------------
                
                JOptionPane.showMessageDialog(null, "Magazine issued to "+ stdntFname +" "+ stdntLname+ " must be returned on "+ dateDue);
                
                txtStaffstdId.setText("");
                txtShortFname.setText("");
                txtShortLname.setText("");
                txtShortClass.setText("");
                comboStaffStudent.setSelectedIndex(0);
                txtShortBkTitle.setText("");
                txtShortBkId.setText("");
                txtShortBkIsbn.setText("");
                SpinfieldTimeLoan.setValue(1);
                txtShortDept.setText("");
                txtStaffNo.setText("");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
    
}

public void issueShortToStaff() {                                        
        
        String stdntID = txtStaffstdId.getText().trim();
        String stdntFname = txtShortFname.getText().toUpperCase().trim();
        String stdntLname = txtShortLname.getText().toUpperCase().trim();
        Date dateBorrowed = DateBorrowed.getDate();
        String phoneToShort = txtStaffNo.getText().trim();
        String deptShortStaff = txtShortDept.getText().toUpperCase().trim();
        Date dateDue = DateBorrowed.getDate();
        String bookdIssue = txtShortBkId.getText();
        String titleIssue = txtShortBkTitle.getText();
        String bookIsbnIssue = txtShortBkIsbn.getText();
        int timelapse = SpinfieldTimeLoan.getValue();
        String student = "STAFF";
        String borrowedStatus = "YES";
        
        String librarianName = lblUserId.getText().toUpperCase().trim();
        String librarianID = lblID.getText();

            try {
                String url = "jdbc:mysql://localhost/libsystem?useSSL = false";
                Connection conn;
                conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
               
                //--------update books db-----------
                String sql = "UPDATE books_db SET borrowed='" + borrowedStatus + "',borrowed_by_id='" + stdntID + "'"
                        + ",name1_of_borrower='" + stdntFname + "',name2_of_borrower='" + stdntLname + "'"
                        + ",staff_std='" + student + "',date_due='" + dateDue + "',received_on=NULL ,date_borrowed='" + dateBorrowed + "'WHERE book_id=" + bookdIssue;
                
                PreparedStatement pst;
                pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                statement = con.createStatement();

                //---------SQL Insert into student db------------
                String sql2 = "INSERT INTO staff_db " + "(id_number, staff_fname, staff_lname, dept, "
                        + "date_borrowed, date_due,book_id,book_isbn,book_title,phone_no,issued_by,issued_by_id)"
                            + "VALUES ('" + stdntID + "','"
                            + stdntFname + "','"
                            + stdntLname + "','"
                            + deptShortStaff + "','"
                            + dateBorrowed + "','"
                            + dateDue + "','"
                            + bookdIssue + "','"
                            + bookIsbnIssue + "','"
                            + titleIssue + "','"
                            + phoneToShort + "','"
                            + librarianName + "','"
                            + librarianID + "') ";
                    
                statement.execute(sql2);
                    
                statement.execute(sql2);
                
                //-----------insert into borrowers db-----------
                String sql3 = "INSERT INTO borrowers_db " + "(book_id,book_isbn,book_title,borrower_id, borrower_name1, borrower_name2,student_staff)"
                            + "VALUES ('" + bookdIssue + "','"
                            + bookIsbnIssue + "','"
                            + titleIssue + "','"
                            + stdntID + "','"
                            + stdntFname + "','"
                            + stdntLname + "','"
                            + student + "') ";
                    
                statement.execute(sql3);

                //-----clear text fields after above------------
                
                JOptionPane.showMessageDialog(null, "Book issued to "+ stdntFname +" "+ stdntLname+ " must be returned in "+ timelapse +"Hrs");
                
                txtStaffstdId.setText("");
                txtShortFname.setText("");
                txtShortLname.setText("");
                txtShortClass.setText("");
                comboStaffStudent.setSelectedIndex(0);
                txtShortBkTitle.setText("");
                txtShortBkId.setText("");
                txtShortBkIsbn.setText("");
                SpinfieldTimeLoan.setValue(1);
                txtShortDept.setText("");
                txtStaffNo.setText("");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
    
}

public void retrieveBookDetails() {
    
            String condition_borrowed = "YES";
            try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT book_id,book_isbn,title,borrowed_by_id,name1_of_borrower,name2_of_borrower,staff_std,date_due FROM books_db WHERE (book_id='"+ textFieldBookId.getText() +"' AND borrowed='"+ condition_borrowed +"')");
            ResultSet rs = st.executeQuery();
            boolean emptyRs = true;
            if (rs.next()) {
                emptyRs = false;
                String bookretid = rs.getString("book_id");
                textFieldBookId.setText(bookretid);
                
                String bookreIsbn = rs.getString("book_isbn");
                txtBookIsbnRet.setText(bookreIsbn);
                
                String bkTitle = rs.getString("title");
                txtBookTitle.setText(bkTitle);
                
                String boroID = rs.getString("borrowed_by_id");
                txtAdmNo.setText(boroID);
                
                String name1 = rs.getString("name1_of_borrower");
                String name2 = rs.getString("name2_of_borrower");
                txtReceievedFrom.setText(name1+" "+name2);
                
                String stafstd = rs.getString("staff_std");
                txtStaffStudent.setText(stafstd);
                
                String date_due = rs.getString("date_due");
                txtDateDue.setText(date_due);
                
            }
            if (emptyRs) {
                JOptionPane.showMessageDialog(null, "No Record of entered book ID Found in borrowers' list");
                textFieldBookId.setText("");
                btnIndicator.setBackground(Color.red);
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            //JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        
    }

public void recieveFromStudents() {                                        
        
        String bookdRecieve = textFieldBookId.getText();
        Date dateRecieOn = dateReturnedChooser.getDate();
        String penalties = txtPenalties.getText();
        String bookCon = txtAreaCondition.getText();
        String dateDue = txtDateDue.getText();
        String returnString = "YES";
        String borrowedStatusR = "NO";
        String setNull = "NULL";
        
        String librarianName = lblUserId.getText().toUpperCase().trim();
        String librarianID = lblID.getText();
        
            try {
                String url = "jdbc:mysql://localhost/libsystem?useSSL = false";
                Connection conn;
                conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
               
                //--------update books db-----------
                String sql = "UPDATE books_db SET borrowed='" + borrowedStatusR + "',borrowed_by_id=NULL ,name1_of_borrower='" + setNull + "',name2_of_borrower='" + setNull + "'"
                        + ",staff_std='" + setNull + "',date_due=NULL ,received_on='" + dateRecieOn + "',penalties='" + penalties + "',book_condition='" + bookCon + "',date_borrowed='" + setNull + "' WHERE book_id=" + bookdRecieve;
                
                PreparedStatement pst;
                pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                statement = con.createStatement();

                //---------SQL Insert into student db------------                                                                                            
                String sql2 = "UPDATE student_db SET returned='" + returnString + "',received_by_id='" + librarianID + "',received_by='" + librarianName + "' WHERE (book_id='" + bookdRecieve +"' AND date_due='"+ dateDue +"')";
                    
                statement.execute(sql2);
                
                //-----------insert into borrowers db-----------
                String sql3 = "DELETE FROM borrowers_db WHERE book_id=" + bookdRecieve;
                    
                statement.execute(sql3);

                //-----clear text fields after above------------
                
                JOptionPane.showMessageDialog(null, "Book recieved");
                textFieldBookId.setText("");
                txtBookIsbnRet.setText("");
                txtBookTitle.setText("");
                txtDateDue.setText("");
                txtReceievedFrom.setText("");
                txtAdmNo.setText("");
                txtStaffStudent.setText("");
                txtPenalties.setText("");
                txtAreaCondition.setText("");
                btnIndicator.setBackground(Color.green);

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
                btnIndicator.setBackground(Color.red);
            }
        
    }

public void recieveFromStaff() {                                        
        
        String bookdRecieve = textFieldBookId.getText();
        Date dateRecieOn = dateReturnedChooser.getDate();
        String penalties = txtPenalties.getText();
        String bookCon = txtAreaCondition.getText();
        String returnString = "YES";
        String borrowedStatusR = "NO";
        String dateDue = txtDateDue.getText();
        
        String librarianName = lblUserId.getText().toUpperCase().trim();
        String librarianID = lblID.getText();
        
            try {
                String url = "jdbc:mysql://localhost/libsystem?useSSL = false";
                Connection conn;
                conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
               
                //--------update books db-----------
                String sql = "UPDATE books_db SET borrowed='" + borrowedStatusR + "',borrowed_by_id=NULL ,name1_of_borrower=NULL,name2_of_borrower=NULL"
                        + ",staff_std=NULL,date_due=NULL ,received_on='" + dateRecieOn + "',penalties='" + penalties + "',book_condition='" + bookCon + "',date_borrowed=NULL WHERE book_id=" + bookdRecieve;
                
                PreparedStatement pst;
                pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                statement = con.createStatement();

                //---------SQL Insert into student db------------
                String sql2 = "UPDATE staff_db SET returned='" + returnString + "',received_by_id='" + librarianID + "',received_by='" + librarianName + "'WHERE (book_id='" + bookdRecieve +"' AND date_due='"+ dateDue +"')";
                    
                statement.execute(sql2);
                
                //-----------insert into borrowers db-----------
                String sql3 = "DELETE FROM borrowers_db WHERE book_id=" + bookdRecieve;
                    
                statement.execute(sql3);

                //-----clear text fields after above------------
                
                JOptionPane.showMessageDialog(null, "Book received");
                textFieldBookId.setText("");
                txtBookIsbnRet.setText("");
                txtBookTitle.setText("");
                txtDateDue.setText("");
                txtReceievedFrom.setText("");
                txtAdmNo.setText("");
                txtStaffStudent.setText("");
                txtPenalties.setText("");
                txtAreaCondition.setText("");
                btnIndicator.setBackground(Color.green);

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
                btnIndicator.setBackground(Color.red);
            }
        
    }

public void retrieveStudentDetails() {
    
            try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT std_fname, std_lname, form FROM student_db WHERE adm_no='"+ txtStdntAmNo.getText()+"' LIMIT 1");
            ResultSet rsRetStd = st.executeQuery();
            boolean emptyRs = true;
            if (rsRetStd.next()) {
                emptyRs = false;
                String fname_std = rsRetStd.getString("std_fname");
                txtSdntFname.setText(fname_std);
                
                String lname_std = rsRetStd.getString("std_lname");
                txtStdntLname.setText(lname_std);
                
                String class_std = rsRetStd.getString("form");
                txtStdntClass.setText(class_std);

                
            }
            if (emptyRs) {
                JOptionPane.showMessageDialog(null, "Student not found in the library records");
                txtStdntAmNo.setText("");
                txtSdntFname.setText("");
                txtStdntLname.setText("");
                txtStdntClass.setText("");
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            System.out.println(rt);
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        
    }

public void retrieveStudentDetailsShort() {
    
            try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT std_fname, std_lname, form FROM student_db WHERE adm_no='"+ txtStaffstdId.getText()+"' LIMIT 1");
            ResultSet rsRetStd = st.executeQuery();
            boolean emptyRs = true;
            if (rsRetStd.next()) {
                emptyRs = false;
                String fname_std = rsRetStd.getString("std_fname");
                txtShortFname.setText(fname_std);
                
                String lname_std = rsRetStd.getString("std_lname");
                txtShortLname.setText(lname_std);
                
                String class_std = rsRetStd.getString("form");
                txtShortClass.setText(class_std);

                
            }
            if (emptyRs) {
                JOptionPane.showMessageDialog(null, "Student not found in the library records");
                comboStaffStudent.setSelectedIndex(0);
                txtShortFname.setText("");
                txtShortLname.setText("");
                txtShortClass.setText("");
                txtStaffstdId.setText("");
                txtStaffNo.setText("");
                txtShortDept.setText("");
                txtShortBkId.setText("");
                txtShortBkIsbn.setText("");
                txtShortBkTitle.setText("");
                SpinfieldTimeLoan.setValue(1);
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            System.out.println(rt);
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        
    }

public void retrieveStudentDetailsMagz() {
    
            try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT std_fname, std_lname, form FROM student_db WHERE adm_no='"+ txtMagzNameID.getText()+"' LIMIT 1");
            ResultSet rsRetStd = st.executeQuery();
            boolean emptyRs = true;
            if (rsRetStd.next()) {
                emptyRs = false;
                String fname_std = rsRetStd.getString("std_fname");
                txtMagzName1.setText(fname_std);
                
                String lname_std = rsRetStd.getString("std_lname");
                txtMagzName2.setText(lname_std);
                
                String class_std = rsRetStd.getString("form");
                txtMagzClass.setText(class_std);

                
            }
            if (emptyRs) {
                JOptionPane.showMessageDialog(null, "Student not found in the library records");
                comboMagz.setSelectedIndex(0);
                txtMagzNameID.setText("");
                txtMagzName1.setText("");
                txtMagzName2.setText("");
                txtMagzClass.setText("");
                txtMagzPhone.setText("");
                txtMagzDept.setText("");
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            System.out.println(rt);
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        
    }

public void retrieveStaffDetails() {
    
            try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT staff_fname, staff_lname, dept, phone_no FROM staff_db WHERE id_number='"+ txtStaffID.getText()+"' LIMIT 1");
            ResultSet rsRetStd = st.executeQuery();
            boolean emptyRs = true;
            if (rsRetStd.next()) {
                emptyRs = false;
                String fname_stf = rsRetStd.getString("staff_fname");
                txtStaffName1.setText(fname_stf);
                
                String lname_stf = rsRetStd.getString("staff_lname");
                txtStaffName2.setText(lname_stf);
                
                String deptName = rsRetStd.getString("dept");
                txtStaffDept.setText(deptName);
                
                String phoneNo = rsRetStd.getString("phone_no");
                txtStaffPhone.setText(phoneNo);

                
            }
            if (emptyRs) {
                JOptionPane.showMessageDialog(null, "Staff not found in the library records");
                txtStaffID.setText("");
                txtStaffName1.setText("");
                txtStaffName2.setText("");
                txtStaffDept.setText("");
                txtStaffPhone.setText("");
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            System.out.println(rt);
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        
    }

public void retrieveStaffDetailsMagz() {
    
            try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT staff_fname, staff_lname, dept, phone_no FROM staff_db WHERE id_number='"+ txtMagzNameID.getText()+"' LIMIT 1");
            ResultSet rsRetStd = st.executeQuery();
            boolean emptyRs = true;
            if (rsRetStd.next()) {
                emptyRs = false;
                String fname_stf = rsRetStd.getString("staff_fname");
                txtMagzName1.setText(fname_stf);
                
                String lname_stf = rsRetStd.getString("staff_lname");
                txtMagzName2.setText(lname_stf);
                
                String deptName = rsRetStd.getString("dept");
                txtMagzDept.setText(deptName);
                
                String phoneNo = rsRetStd.getString("phone_no");
                txtMagzPhone.setText(phoneNo);

                
            }
            if (emptyRs) {
                JOptionPane.showMessageDialog(null, "Staff not found in the library records");
                comboMagz.setSelectedIndex(0);
                txtMagzNameID.setText("");
                txtMagzName1.setText("");
                txtMagzName2.setText("");
                txtMagzClass.setText("");
                txtMagzPhone.setText("");
                txtMagzDept.setText("");
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            System.out.println(rt);
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        
    }

public void retrieveStaffDetailsShort() {
    
            try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT staff_fname, staff_lname, dept, phone_no FROM staff_db WHERE id_number='"+ txtStaffstdId.getText()+"' LIMIT 1");
            ResultSet rsRetStd = st.executeQuery();
            boolean emptyRs = true;
            if (rsRetStd.next()) {
                emptyRs = false;
                String fname_stf = rsRetStd.getString("staff_fname");
                txtShortFname.setText(fname_stf);
                
                String lname_stf = rsRetStd.getString("staff_lname");
                txtShortLname.setText(lname_stf);
                
                String deptName = rsRetStd.getString("dept");
                txtShortDept.setText(deptName);
                
                String phoneNo = rsRetStd.getString("phone_no");
                txtStaffNo.setText(phoneNo);

                
            }
            if (emptyRs) {
                JOptionPane.showMessageDialog(null, "Staff not found in the library records");
                comboStaffStudent.setSelectedIndex(0);
                txtShortFname.setText("");
                txtShortLname.setText("");
                txtShortClass.setText("");
                txtStaffstdId.setText("");
                txtStaffNo.setText("");
                txtShortDept.setText("");
                txtShortBkId.setText("");
                txtShortBkIsbn.setText("");
                txtShortBkTitle.setText("");
                SpinfieldTimeLoan.setValue(1);
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            System.out.println(rt);
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        
    }

public boolean CheckUsernameExists(){
     
    boolean usernameExists = false;
    String username = txtUser.getText().trim();
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/libsystem?useSSL = false";
        Connection conn;
        conn = DriverManager.getConnection(url, "root", "libsystem@dmin");

        PreparedStatement st = conn.prepareStatement("select * from users_db order by username desc");
        ResultSet r1=st.executeQuery();
        String usernameCounter;
         if(r1.next()) 
         {
           usernameCounter =  r1.getString("username");
           if(usernameCounter.equalsIgnoreCase(username)) //this part does not happen even if it should
           {
              getToolkit().beep();
              JOptionPane.showMessageDialog(null, "Username already exists");
              txtUser.requestFocus();
              System.out.println("Username already exists");
              usernameExists = true;
           }
         }
     }

     catch (SQLException e) 
     {
        System.out.println("SQL Exception: "+ e.toString());
     } 
     catch (ClassNotFoundException cE) 
     {
        System.out.println("Class Not Found Exception: "+ cE.toString());
     }
 return usernameExists;
}

public Boolean checkInfoInput(){
    
            String useridentity = txtIdNo.getText();
            String userFname = txtFname.getText().toUpperCase().trim();
            String userLname = txtLname.getText().toUpperCase().trim();
            String username = txtUser.getText().trim();
            String deptName = txtDept.getText().toUpperCase().trim();
            String password = new String(txtPass.getPassword());
            String confPassword = new String(txtConfPass.getPassword());
            
            if(useridentity.isEmpty()){
            JOptionPane.showMessageDialog(null, "enter your national id number");
            txtIdNo.requestFocus();
            return false;}
            
            else if(userFname.isEmpty()){
            JOptionPane.showMessageDialog(null, "enter your first name");
            txtFname.requestFocus();
            return false;}
            
            else if(userLname.isEmpty()){
            JOptionPane.showMessageDialog(null, "enter your last name");
            txtLname.requestFocus();
            return false;}
            
            else if(deptName.isEmpty()){
            JOptionPane.showMessageDialog(null, "enter your department name");
            txtDept.requestFocus();
            return false;}
            
            else if(username.isEmpty()){
            JOptionPane.showMessageDialog(null, "enter your username");
            txtUser.requestFocus();
            return false;}
            
            else if(password.isEmpty()){
            JOptionPane.showMessageDialog(null, "enter your password");
            txtPass.requestFocus();
            return false;}

            else if(password.length()< 6){
            JOptionPane.showMessageDialog(null, "Password must be more than six(6) characters");
            txtPass.requestFocus();
            return false;}
            
            else if(!password.equals(confPassword)){
            JOptionPane.showMessageDialog(null, "Your password doesn't match");
            return false;}
            
        return true;
}

public void addUserMethod(){
    
    if (checkInfoInput() == true && CheckUsernameExists() == false){
        
            String useridentity = txtIdNo.getText();
            String userFname = txtFname.getText().toUpperCase().trim();
            String userLname = txtLname.getText().toUpperCase().trim();
            String username = txtUser.getText().trim();
            String deptName = txtDept.getText().toUpperCase().trim();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            state = con.prepareStatement("INSERT INTO users_db (user_fname,user_lname,id_no,department,password,username) VALUES (?,?,?,?,?,?)");

            state.setString(1, userFname);
            state.setString(2, userLname);
            state.setString(3, useridentity);
            state.setString(4, deptName);
            
            if(md5(txtConfPass.getPassword()).isEmpty()){
            JOptionPane.showMessageDialog(null, "Password must be confirmed");
            txtConfPass.requestFocus();
            }
            state.setString(5, md5(txtConfPass.getPassword()));
            state.setString(6, username);

            int count = state.executeUpdate();
            if(count > 0){
                JOptionPane.showMessageDialog(null, userFname+" "+userLname+" added as a user with username '"+username+"'");
                
                txtIdNo.setText("");
                txtFname.setText("");
                txtLname.setText("");
                txtUser.setText("");
                txtDept.setText("");
                txtPass.setText("");
                txtConfPass.setText("");
                }
            
                    }catch(ClassNotFoundException | SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                }
       
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

public void SessionEnd() {
        
        String use=null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            statement = con.createStatement();
            String sgl=" select  max(time_in) as try from session_logs";
            
            rs=statement.executeQuery(sgl);
                    if(rs.next()){
                       use= rs.getString("try");
                    }
                String sql1="SELECT session_id from session_logs where time_in='"+use+"'";
                 ResultSet rs1=statement.executeQuery(sql1);
                 if(rs1.next()){
                    use1=rs1.getString("session_id");
                    String sql = "UPDATE session_logs SET time_out = NOW() where session_id='"+use1+"'";
            
            statement.execute(sql);
                 }
                 else JOptionPane.showMessageDialog(null, "unable to insert");
            // SQL Insert
            
            //status  = true;
        } catch (ClassNotFoundException | SQLException | HeadlessException es) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Log out of reach");
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }

public final void DisplaySessions() {

        logModel.setColumnIdentifiers(sessionColumnNames);

        tableSessionLogs.setModel(logModel);

        tableSessionLogs.setFillsViewportHeight(true);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("select  session_id,user_id,username,time_in,time_out from  session_logs");
            rs = st.executeQuery();

            int i = 0;
            while (rs.next()) {
                sessId = rs.getString("session_id");
                logger = rs.getString("user_id");
                username1 = rs.getString("username");
                timeIn = rs.getString("time_in");
                timeOut = rs.getString("time_out");

                logModel.addRow(new Object[]{sessId,logger ,username1,timeIn, timeOut});
                i++;

            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

public final void DisplayUsers() {
            
        userModel.setColumnIdentifiers(columnNames);
        
        tableUsers.setModel(userModel);
        
        tableUsers.setFillsViewportHeight(true);
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement stateTable = con.prepareStatement("select id_no,user_fname,user_lname,username,permission,department,reset from  users_db");
            ResultSet userTrs = stateTable.executeQuery();
            
            int i = 0;
            while (userTrs.next()) {
                useridNo = userTrs.getString("id_no");
                fname = userTrs.getString("user_fname");
                lname = userTrs.getString("user_lname");
                usernName= userTrs.getString("username");
                permission= userTrs.getString("permission");
                designation= userTrs.getString("department");
                reset= userTrs.getString("reset");
                
                userModel.addRow(new Object[]{useridNo, fname, lname,usernName,permission,designation,reset});
                i++;
                
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

public void searchUser() {
        userModel.setColumnIdentifiers(columnNames);

        tableUsers.setModel(userModel);

        tableUsers.setFillsViewportHeight(true);
        String x = txtSearchUser.getText();
        if (x.equals("")) {
            JOptionPane.showMessageDialog(null, "Nothing to search, enter an ID to search");
        } else {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conUser = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
                PreparedStatement st = conUser.prepareStatement("SELECT id_no,user_fname,user_lname,username,permission,department,reset FROM  users_db WHERE id_no=" + x);
                //st.setString(1, tb);
                ResultSet userTrs = st.executeQuery();
                int i = 0;
            while (userTrs.next()) {
                useridNo = userTrs.getString("id_no");
                fname = userTrs.getString("user_fname");
                lname = userTrs.getString("user_lname");
                usernName= userTrs.getString("username");
                permission= userTrs.getString("permission");
                designation= userTrs.getString("department");
                reset= userTrs.getString("reset");
                
                userModel.addRow(new Object[]{useridNo, fname, lname,usernName,permission,designation,reset});
                i++;

                }

                if (i < 1) {
                    JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                }else if(x.equals("")){JOptionPane.showMessageDialog(null, "Enter Employees ID to search");}
             
            } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
                // System.out.println(rt);
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

private String getCellValueMagz(int x, int y)
{
    return magDetailsModel.getValueAt(x, y).toString();
}

private void writeMagzToExcel()
{
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Files", ".xlsx");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogTitle("Select file location"); 
        fileChooser.setSelectedFile(new File(fileDictName));
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileDictName = fileChooser.getSelectedFile()+".xlsx";
        }

    File file = new File(fileDictName);
    if(file.exists() == false){
    
        XSSFWorkbook xWb = new XSSFWorkbook();
        XSSFSheet xSt = xWb.createSheet();
        TreeMap<String, Object[]> data = new TreeMap<>();
        data.put("-1", new Object[]{magDetailsModel.getColumnName(0),magDetailsModel.getColumnName(1),
            magDetailsModel.getColumnName(2),magDetailsModel.getColumnName(3),magDetailsModel.getColumnName(4),
            magDetailsModel.getColumnName(5),magDetailsModel.getColumnName(6),magDetailsModel.getColumnName(7)});
        for (int i = 0; i < magDetailsModel.getRowCount(); i++) 
        {
            data.put(Integer.toString(i), new Object[]{getCellValueMagz(i, 0),getCellValueMagz(i, 1),
                getCellValueMagz(i, 2),getCellValueMagz(i, 3),getCellValueMagz(i, 4),getCellValueMagz(i, 5),
                getCellValueMagz(i, 6),getCellValueMagz(i, 7)});
        }
        Set<String> ids = data.keySet();
        XSSFRow row;
        int rowId = 0;
        for(String key: ids)
        {
            row = xSt.createRow(rowId++);
            Object[] values = data.get(key);
            int cellId = 0;
            for(Object o: values)
            {
                Cell cell = row.createCell(cellId++);
                cell.setCellValue(o.toString());
            }
        }

        try (
            FileOutputStream fos = new FileOutputStream(file)) 
            {
            xWb.write(fos);
            JOptionPane.showMessageDialog(null, "Excel file saved");
        } catch (IOException ex) {
            Logger.getLogger(LibraryHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

private String getCellValue(int x, int y)
{
    return listModel.getValueAt(x, y).toString();
}

private void writeToExcel()
{
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Files", ".xlsx");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogTitle("Select file location"); 
        fileChooser.setSelectedFile(new File(fileDictName));
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileDictName = fileChooser.getSelectedFile()+".xlsx";
        }

    File file = new File(fileDictName);
    if(file.exists() == false){
    
        XSSFWorkbook xWb = new XSSFWorkbook();
        XSSFSheet xSt = xWb.createSheet();
        TreeMap<String, Object[]> data = new TreeMap<>();
        data.put("-1", new Object[]{listModel.getColumnName(0),listModel.getColumnName(1),
            listModel.getColumnName(2),listModel.getColumnName(3),listModel.getColumnName(4),
            listModel.getColumnName(5),listModel.getColumnName(6),listModel.getColumnName(7),
            listModel.getColumnName(8)});
        for (int i = 0; i < listModel.getRowCount(); i++) 
        {
            data.put(Integer.toString(i), new Object[]{getCellValue(i, 0),getCellValue(i, 1),
                getCellValue(i, 2),getCellValue(i, 3),getCellValue(i, 4),getCellValue(i, 5),
                getCellValue(i, 6),getCellValue(i, 7),getCellValue(i, 8)});
        }
        Set<String> ids = data.keySet();
        XSSFRow row;
        int rowId = 0;
        for(String key: ids)
        {
            row = xSt.createRow(rowId++);
            Object[] values = data.get(key);
            int cellId = 0;
            for(Object o: values)
            {
                Cell cell = row.createCell(cellId++);
                cell.setCellValue(o.toString());
            }
        }

        try (
            FileOutputStream fos = new FileOutputStream(file)) 
            {
            xWb.write(fos);
            JOptionPane.showMessageDialog(null, "Excel file saved");
        } catch (IOException ex) {
            Logger.getLogger(LibraryHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

private String getCellValueBorrowers(int x, int y)
{
    return borrowerModel.getValueAt(x, y).toString();
}

private void writeBorrowersToExcel()
{
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Files", ".xlsx");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogTitle("Select file location"); 
        fileChooser.setSelectedFile(new File(fileDictName));
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileDictName = fileChooser.getSelectedFile()+".xlsx";
        }

    File file = new File(fileDictName);
    if(file.exists() == false){
    
        XSSFWorkbook xWb = new XSSFWorkbook();
        XSSFSheet xSt = xWb.createSheet();
        TreeMap<String, Object[]> data = new TreeMap<>();
        data.put("-1", new Object[]{borrowerModel.getColumnName(0),borrowerModel.getColumnName(1),
            borrowerModel.getColumnName(2),borrowerModel.getColumnName(3),borrowerModel.getColumnName(4),
            borrowerModel.getColumnName(5),borrowerModel.getColumnName(6)});
        for (int i = 0; i < borrowerModel.getRowCount(); i++) 
        {
                data.put(Integer.toString(i), new Object[]{getCellValueBorrowers(i, 0),getCellValueBorrowers(i, 1),
                getCellValueBorrowers(i, 2),getCellValueBorrowers(i, 3),getCellValueBorrowers(i, 4),getCellValueBorrowers(i, 5),
                getCellValueBorrowers(i, 6)});
        }
        Set<String> ids = data.keySet();
        XSSFRow row;
        int rowId = 0;
        for(String key: ids)
        {
            row = xSt.createRow(rowId++);
            Object[] values = data.get(key);
            int cellId = 0;
            for(Object o: values)
            {
                Cell cell = row.createCell(cellId++);
                cell.setCellValue(o.toString());
            }
        }

        try (
            FileOutputStream fos = new FileOutputStream(file)) 
            {
            xWb.write(fos);
            JOptionPane.showMessageDialog(null, "Excel file saved");
        } catch (IOException ex) {
            Logger.getLogger(LibraryHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

private String getCellValueStock(int x, int y)
{
    return stockModel.getValueAt(x, y).toString();
}

private void writeStockToExcel()
{
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Files", ".xlsx");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogTitle("Select file location"); 
        fileChooser.setSelectedFile(new File(fileDictName));
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileDictName = fileChooser.getSelectedFile()+".xlsx";
        }

    File file = new File(fileDictName);
    if(file.exists() == false){
    
        XSSFWorkbook xWb = new XSSFWorkbook();
        XSSFSheet xSt = xWb.createSheet();
        TreeMap<String, Object[]> data = new TreeMap<>();
        data.put("-1", new Object[]{stockModel.getColumnName(0),stockModel.getColumnName(1),
            stockModel.getColumnName(2),stockModel.getColumnName(3),stockModel.getColumnName(4),
            stockModel.getColumnName(5),stockModel.getColumnName(6),stockModel.getColumnName(7)});
        for (int i = 0; i < stockModel.getRowCount(); i++) 
        {
                data.put(Integer.toString(i), new Object[]{getCellValueStock(i, 0),getCellValueStock(i, 1),
                getCellValueStock(i, 2),getCellValueStock(i, 3),getCellValueStock(i, 4),getCellValueStock(i, 5),
                getCellValueStock(i, 6),getCellValueStock(i, 7)});
        }
        Set<String> ids = data.keySet();
        XSSFRow row;
        int rowId = 0;
        for(String key: ids)
        {
            row = xSt.createRow(rowId++);
            Object[] values = data.get(key);
            int cellId = 0;
            for(Object o: values)
            {
                Cell cell = row.createCell(cellId++);
                cell.setCellValue(o.toString());
            }
        }

        try (
            FileOutputStream fos = new FileOutputStream(file)) 
            {
            xWb.write(fos);
            JOptionPane.showMessageDialog(null, "Excel file saved");
        } catch (IOException ex) {
            Logger.getLogger(LibraryHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

private String getCellValueStdTable(int x, int y)
{
    return stdModel.getValueAt(x, y).toString();
}

private void writeStdToExcel()
{
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Files", ".xlsx");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogTitle("Select file location"); 
        fileChooser.setSelectedFile(new File(fileDictName));
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileDictName = fileChooser.getSelectedFile()+".xlsx";
        }

    File file = new File(fileDictName);
    if(file.exists() == false){
    
        XSSFWorkbook xWb = new XSSFWorkbook();
        XSSFSheet xSt = xWb.createSheet();
        TreeMap<String, Object[]> data = new TreeMap<>();
        data.put("-1", new Object[]{stdModel.getColumnName(0),stdModel.getColumnName(1),
            stdModel.getColumnName(2),stdModel.getColumnName(3),stdModel.getColumnName(4),
            stdModel.getColumnName(5),stdModel.getColumnName(6),stdModel.getColumnName(7)});
        for (int i = 0; i < stdModel.getRowCount(); i++) 
        {
                data.put(Integer.toString(i), new Object[]{getCellValueStdTable(i, 0),getCellValueStdTable(i, 1),
                getCellValueStdTable(i, 2),getCellValueStdTable(i, 3),getCellValueStdTable(i, 4),getCellValueStdTable(i, 5),
                getCellValueStdTable(i, 6),getCellValueStdTable(i, 7)});
        }
        Set<String> ids = data.keySet();
        XSSFRow row;
        int rowId = 0;
        for(String key: ids)
        {
            row = xSt.createRow(rowId++);
            Object[] values = data.get(key);
            int cellId = 0;
            for(Object o: values)
            {
                Cell cell = row.createCell(cellId++);
                cell.setCellValue(o.toString());
            }
        }

        try (
            FileOutputStream fos = new FileOutputStream(file)) 
            {
            xWb.write(fos);
            JOptionPane.showMessageDialog(null, "Excel file for students' list saved");
        } catch (IOException ex) {
            Logger.getLogger(LibraryHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

private String getCellValueStaffTb(int x, int y)
{
    return staffModel.getValueAt(x, y).toString();
}

private void writeStaffTbToExcel()
{
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Files", ".xlsx");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogTitle("Select file location"); 
        fileChooser.setSelectedFile(new File(fileDictName));
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileDictName = fileChooser.getSelectedFile()+".xlsx";
        }

    File file = new File(fileDictName);
    if(file.exists() == false){
    
        XSSFWorkbook xWb = new XSSFWorkbook();
        XSSFSheet xSt = xWb.createSheet();
        TreeMap<String, Object[]> data = new TreeMap<>();
        data.put("-1", new Object[]{staffModel.getColumnName(0),staffModel.getColumnName(1),
            staffModel.getColumnName(2),staffModel.getColumnName(3),staffModel.getColumnName(4),
            staffModel.getColumnName(5),staffModel.getColumnName(6),staffModel.getColumnName(7),staffModel.getColumnName(8)});
        for (int i = 0; i < staffModel.getRowCount(); i++) 
        {
            data.put(Integer.toString(i), new Object[]{getCellValueStaffTb(i, 0),getCellValueStaffTb(i, 1),
                getCellValueStaffTb(i, 2),getCellValueStaffTb(i, 3),getCellValueStaffTb(i, 4),getCellValueStaffTb(i, 5),
                getCellValueStaffTb(i, 6),getCellValueStaffTb(i, 7),getCellValueStaffTb(i, 8)});
        }
        Set<String> ids = data.keySet();
        XSSFRow row;
        int rowId = 0;
        for(String key: ids)
        {
            row = xSt.createRow(rowId++);
            Object[] values = data.get(key);
            int cellId = 0;
            for(Object o: values)
            {
                Cell cell = row.createCell(cellId++);
                cell.setCellValue(o.toString());
            }
        }

        try (
            FileOutputStream fos = new FileOutputStream(file)) 
            {
            xWb.write(fos);
            JOptionPane.showMessageDialog(null, "Excel file for staff saved");
        } catch (IOException ex) {
            Logger.getLogger(LibraryHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

public void displayLostTable() {
    
        String loanType = "LONG";
        String boorrowedCondtion = "YES";

        lostModel.setColumnIdentifiers(lostColumnNames);

        tableBookLost.setModel(lostModel);

        tableBookLost.setFillsViewportHeight(true);
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  book_id,book_isbn,author,title,publisher_name,edition,subject_category FROM books_db WHERE borrowed='"+ boorrowedCondtion +"'");
            ResultSet staffRs = st.executeQuery();
            
            int i = 0;
            while (staffRs.next()) {
                lostbookID = staffRs.getString("book_id");
                lostbookISBNList = staffRs.getString("book_isbn");
                lostauthorNameList = staffRs.getString("author");
                losttitleNameList = staffRs.getString("title");
                lostpublisherList = staffRs.getString("publisher_name");
                losteditionList = staffRs.getString("edition");
                lostcategoryList = staffRs.getString("subject_category");

                lostModel.addRow(new Object[]{lostbookID, lostbookISBNList, lostauthorNameList, losttitleNameList, lostpublisherList,losteditionList,lostcategoryList});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "All books have been issued", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void retrieveBookDetailsLost() {
    
            String condition_borrowed = "YES";
            try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT book_id,book_isbn,title,borrowed_by_id,name1_of_borrower,name2_of_borrower,staff_std,date_due FROM books_db WHERE (book_id='"+ lostbookID3 +"' and borrowed='"+ condition_borrowed +"')");
            ResultSet rsLost = st.executeQuery();
            boolean emptyRs = true;
            if (rsLost.next()) {
                emptyRs = false;
                String bookretid = rsLost.getString("book_id");
                txtBookIDlost.setText(bookretid);
                
                String bookreIsbn = rsLost.getString("book_isbn");
                txtIsbnLost.setText(bookreIsbn);
                
                String bkTitle = rsLost.getString("title");
                txtBookTitleLost.setText(bkTitle);
                
                String boroID = rsLost.getString("borrowed_by_id");
                txtIDLost.setText(boroID);
                
                String name1 = rsLost.getString("name1_of_borrower");
                txtFnameLost.setText(name1);
                
                String name2 = rsLost.getString("name2_of_borrower");
                txtLnameLost.setText(name2);
                
                String stafstd = rsLost.getString("staff_std");
                txtStaffLost.setText(stafstd);
                
                String date_due = rsLost.getString("date_due");
                txtDateDue.setText(date_due);
                
            }
            if (emptyRs) {
                JOptionPane.showMessageDialog(null, "No Record of entered book ID Found in borrowers' list");
                textFieldBookId.setText("");
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            //JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        
    }

public void lostByStudents() {                                        
        
        String bookdRecieve = txtBookIDlost.getText();
        String returnString = "NO";
        String borrowedStatusR = "LOST";
        
        String librarianName = lblUserId.getText().toUpperCase().trim();
        String librarianID = lblID.getText();
        
            try {
                String url = "jdbc:mysql://localhost/libsystem?useSSL = false";
                Connection conn;
                conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
               
                //--------update books db-----------
                String sql = "UPDATE books_db SET borrowed='" + borrowedStatusR + "'WHERE book_id=" + bookdRecieve;
                
                PreparedStatement pst;
                pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                statement = con.createStatement();

                //---------SQL Insert into student db------------
                String sql2 = "UPDATE student_db SET returned='" + returnString + "',received_by_id='" + librarianID + "',received_by='" + librarianName + "'WHERE book_id=" + bookdRecieve;
                    
                statement.execute(sql2);
                
                //-----------insert into borrowers db-----------
                String sql3 = "DELETE FROM borrowers_db WHERE book_id=" + bookdRecieve;
                    
                statement.execute(sql3);

                //-----clear text fields after above------------
                
                JOptionPane.showMessageDialog(null, "Book reported as lost");
                    txtBookIDlost.setText("");
                    txtIsbnLost.setText("");
                    txtBookTitleLost.setText("");
                    txtIDLost.setText("");
                    txtFnameLost.setText("");
                    txtLnameLost.setText("");
                    txtStaffLost.setText("");
                    txtDateDue.setText("");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        
    }

public void lostByStaff() {                                        
        
        String bookdRecieve = txtBookIDlost.getText();
        
        String returnString = "NO";
        String borrowedStatus = "LOST";
        
        String librarianName = lblUserId.getText().toUpperCase().trim();
        String librarianID = lblID.getText();
        
            try {
                String url = "jdbc:mysql://localhost/libsystem?useSSL = false";
                Connection conn;
                conn = DriverManager.getConnection(url, "root", "libsystem@dmin");
               
                //--------update books db-----------
                String sql = "UPDATE books_db SET borrowed='" + borrowedStatus + "' WHERE book_id=" + bookdRecieve;
                
                PreparedStatement pst;
                pst = null;
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                statement = con.createStatement();

                //---------SQL Insert into student db------------
                String sql2 = "UPDATE staff_db SET returned='" + returnString + "',received_by_id='" + librarianID + "',received_by='" + librarianName + "'WHERE book_id=" + bookdRecieve;
                    
                statement.execute(sql2);
                
                //-----------insert into borrowers db-----------
                String sql3 = "DELETE FROM borrowers_db WHERE book_id=" + bookdRecieve;
                    
                statement.execute(sql3);

                //-----clear text fields after above------------
                
                JOptionPane.showMessageDialog(null, "Book reported as lost");
                    txtBookIDlost.setText("");
                    txtIsbnLost.setText("");
                    txtBookTitleLost.setText("");
                    txtIDLost.setText("");
                    txtFnameLost.setText("");
                    txtLnameLost.setText("");
                    txtStaffLost.setText("");
                    txtDateDue.setText("");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        
    }

public void studentTable() {

        stdModel.setColumnIdentifiers(stdColumnNames);

        tableStudents.setModel(stdModel);

        tableStudents.setFillsViewportHeight(true);
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  adm_no,std_fname,std_lname,form,date_borrowed,book_id,book_title,returned,issued_by_name,received_by FROM student_db");
            ResultSet staffRs = st.executeQuery();
            
            int i = 0;
            while (staffRs.next()) {
                stdAdm = staffRs.getString("adm_no");
                stdFname = staffRs.getString("std_fname");
                stdLname = staffRs.getString("std_lname");
                String namelist = stdFname+" "+stdLname;
                stdForm = staffRs.getString("form");
                stdBookId = staffRs.getString("book_id");
                stdBookTitle = staffRs.getString("book_title");
                stdBorrrowedDate = staffRs.getString("date_borrowed");
                stdReturned = staffRs.getString("returned");
                stdIssuedby = staffRs.getString("issued_by_name");
                stdRecievedby = staffRs.getString("received_by");

                stdModel.addRow(new Object[]{stdAdm, namelist, stdForm, stdBookId, stdBookTitle,stdBorrrowedDate,stdReturned,stdIssuedby,stdRecievedby});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No student records yet", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void filterStudentTable() {

        stdModel.setColumnIdentifiers(stdColumnNames);

        tableStudents.setModel(stdModel);

        tableStudents.setFillsViewportHeight(true);
        
        String itemSelect = (String) comboFilterStudents.getSelectedItem();
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  adm_no,std_fname,std_lname,form,date_borrowed,book_id,book_title,returned,issued_by_name,received_by FROM student_db WHERE returned='"+ itemSelect +"'");
            ResultSet staffRs = st.executeQuery();
            
            int i = 0;
            while (staffRs.next()) {
                stdAdm = staffRs.getString("adm_no");
                stdFname = staffRs.getString("std_fname");
                stdLname = staffRs.getString("std_lname");
                String namelist = stdFname+" "+stdLname;
                stdForm = staffRs.getString("form");
                stdBookId = staffRs.getString("book_id");
                stdBookTitle = staffRs.getString("book_title");
                stdBorrrowedDate = staffRs.getString("date_borrowed");
                stdReturned = staffRs.getString("returned");
                stdIssuedby = staffRs.getString("issued_by_name");
                stdRecievedby = staffRs.getString("received_by");

                stdModel.addRow(new Object[]{stdAdm, namelist, stdForm, stdBookId, stdBookTitle,stdBorrrowedDate,stdReturned,stdIssuedby,stdRecievedby});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "Books with returned condition as "+itemSelect+" not in student records", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void filterStudentTableID() {

        stdModel.setColumnIdentifiers(stdColumnNames);

        tableStudents.setModel(stdModel);

        tableStudents.setFillsViewportHeight(true);
        
        String itemSelect = txtStdIdSearch.getText();
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  adm_no,std_fname,std_lname,form,date_borrowed,book_id,book_title,returned,issued_by_name,received_by FROM student_db WHERE adm_no='"+ itemSelect +"'");
            ResultSet staffRs = st.executeQuery();
            
            int i = 0;
            while (staffRs.next()) {
                stdAdm = staffRs.getString("adm_no");
                stdFname = staffRs.getString("std_fname");
                stdLname = staffRs.getString("std_lname");
                String namelist = stdFname+" "+stdLname;
                stdForm = staffRs.getString("form");
                stdBookId = staffRs.getString("book_id");
                stdBookTitle = staffRs.getString("book_title");
                stdBorrrowedDate = staffRs.getString("date_borrowed");
                stdReturned = staffRs.getString("returned");
                stdIssuedby = staffRs.getString("issued_by_name");
                stdRecievedby = staffRs.getString("received_by");

                stdModel.addRow(new Object[]{stdAdm, namelist, stdForm, stdBookId, stdBookTitle,stdBorrrowedDate,stdReturned,stdIssuedby,stdRecievedby});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "Student record not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void staffTable(){

        staffModel.setColumnIdentifiers(staffColumnNames);

        tableStaff.setModel(staffModel);

        tableStaff.setFillsViewportHeight(true);
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  id_number,staff_fname,staff_lname,phone_no,dept,book_id,book_title,date_borrowed,returned,issued_by,received_by FROM staff_db");
            ResultSet staffRs = st.executeQuery();
            
            int i = 0;
            while (staffRs.next()) {
                staffIDno = staffRs.getString("id_number");
                stdFname = staffRs.getString("staff_fname");
                stdLname = staffRs.getString("staff_lname");
                String namelistStaff = stdFname+" "+stdLname;
                phoneStaffNo = staffRs.getString("phone_no");
                staffDepartment = staffRs.getString("dept");
                staffBookid = staffRs.getString("book_id");
                staffBookTitle = staffRs.getString("book_title");
                staffReturned = staffRs.getString("returned");
                staffBorrrowedDate = staffRs.getString("date_borrowed");
                staffIssued = staffRs.getString("issued_by");
                staffRecieved = staffRs.getString("received_by");

                staffModel.addRow(new Object[]{staffIDno, namelistStaff,phoneStaffNo ,staffDepartment, staffBookid, staffBookTitle,staffBorrrowedDate,staffReturned,staffIssued});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "All books have been issued", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void filterStaffTable(){

        staffModel.setColumnIdentifiers(staffColumnNames);

        tableStaff.setModel(staffModel);

        tableStaff.setFillsViewportHeight(true);
        
        String slectedItem = (String) comboFiletStaff.getSelectedItem();
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  id_number,staff_fname,staff_lname,phone_no,dept,book_id,book_title,date_borrowed,returned,issued_by,received_by FROM staff_db WHERE returned='"+ slectedItem +"'");
            ResultSet staffRs = st.executeQuery();
            
            int i = 0;
            while (staffRs.next()) {
                staffIDno = staffRs.getString("id_number");
                stdFname = staffRs.getString("staff_fname");
                stdLname = staffRs.getString("staff_lname");
                String namelistStaff = stdFname+" "+stdLname;
                phoneStaffNo = staffRs.getString("phone_no");
                staffDepartment = staffRs.getString("dept");
                staffBookid = staffRs.getString("book_id");
                staffBookTitle = staffRs.getString("book_title");
                staffReturned = staffRs.getString("returned");
                staffBorrrowedDate = staffRs.getString("date_borrowed");
                staffIssued = staffRs.getString("issued_by");
                staffRecieved = staffRs.getString("received_by");

                staffModel.addRow(new Object[]{staffIDno, namelistStaff,phoneStaffNo ,staffDepartment, staffBookid, staffBookTitle,staffBorrrowedDate,staffReturned,staffIssued});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "All books have been issued", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

public void filterStaffTableID(){

        staffModel.setColumnIdentifiers(staffColumnNames);

        tableStaff.setModel(staffModel);

        tableStaff.setFillsViewportHeight(true);
        
        String slectedItem = txtStaffIdList.getText();
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libsystem", "root", "libsystem@dmin");
            PreparedStatement st = con.prepareStatement("SELECT  id_number,staff_fname,staff_lname,phone_no,dept,book_id,book_title,date_borrowed,returned,issued_by,received_by FROM staff_db WHERE id_number='"+ slectedItem +"'");
            ResultSet staffRs = st.executeQuery();
            
            int i = 0;
            while (staffRs.next()) {
                staffIDno = staffRs.getString("id_number");
                stdFname = staffRs.getString("staff_fname");
                stdLname = staffRs.getString("staff_lname");
                String namelistStaff = stdFname+" "+stdLname;
                phoneStaffNo = staffRs.getString("phone_no");
                staffDepartment = staffRs.getString("dept");
                staffBookid = staffRs.getString("book_id");
                staffBookTitle = staffRs.getString("book_title");
                staffReturned = staffRs.getString("returned");
                staffBorrrowedDate = staffRs.getString("date_borrowed");
                staffIssued = staffRs.getString("issued_by");
                staffRecieved = staffRs.getString("received_by");

                staffModel.addRow(new Object[]{staffIDno, namelistStaff,phoneStaffNo ,staffDepartment, staffBookid, staffBookTitle,staffBorrrowedDate,staffReturned,staffIssued});
                i++;

            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "All books have been issued", "Error", JOptionPane.ERROR_MESSAGE);
            }
         
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, rt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

}

 public void showMaxOnLabelStd() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conMaxStd = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement stino = conMaxStd.prepareStatement("SELECT number_set FROM maxstudent");
            ResultSet rsName = stino.executeQuery();
            if (rsName.next()) {
                String maxno = rsName.getString("number_set");
                maxStd.setText(maxno);
                
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
 public void showMaxOnLabelStaff() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conMaxStaff;
            conMaxStaff = DriverManager.getConnection("jdbc:mysql://localhost/libsystem?useSSL = false", "root", "libsystem@dmin");
            PreparedStatement stino2 = conMaxStaff.prepareStatement("SELECT number_set FROM maxstaff");
            ResultSet rsName = stino2.executeQuery();
            if (rsName.next()) {
                String maxno = rsName.getString("number_set");
                maxStaff.setText(maxno);
                
            }
            
        } catch (ClassNotFoundException | SQLException | HeadlessException rt) {
            // System.out.println(rt);
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser ChooserNotes;
    private com.toedter.calendar.JDateChooser DateBorrowed;
    private com.toedter.components.JSpinField SpinfieldTimeLoan;
    private javax.swing.JButton btnAddBkLost;
    private javax.swing.JButton btnAddBookList;
    private javax.swing.JButton btnAddBookStaff;
    private javax.swing.JButton btnAddIssueStudent;
    private javax.swing.JButton btnAddMag;
    private javax.swing.JButton btnAddMagToIssue;
    private javax.swing.JButton btnAddNewUsers;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelIssue;
    private javax.swing.JButton btnCancelIssueStaff;
    private javax.swing.JButton btnCancelNotes;
    private javax.swing.JButton btnCancelRecieve;
    private javax.swing.JButton btnCancelSch;
    private javax.swing.JButton btnCancelShort;
    private javax.swing.JButton btnCreateNotes;
    private javax.swing.JButton btnCreateSch;
    private javax.swing.JButton btnEditBookDetails;
    private javax.swing.JButton btnExcelBorrowers;
    private javax.swing.JButton btnExcelList;
    private javax.swing.JButton btnExportStock;
    private javax.swing.JButton btnIndicator;
    private javax.swing.JButton btnInfoDialog;
    private javax.swing.JButton btnIsssueStaff;
    private javax.swing.JButton btnIssueCut;
    private javax.swing.JButton btnIssueRefresh;
    private javax.swing.JButton btnIssueShort;
    private javax.swing.JButton btnIssueToStudents;
    private javax.swing.JButton btnLostConf;
    private javax.swing.JButton btnMagzCancel;
    private javax.swing.JButton btnMagzDetails;
    private javax.swing.JButton btnMagzIssue;
    private javax.swing.JButton btnMagzShortcut;
    private javax.swing.JButton btnMagzToExcel;
    private javax.swing.JButton btnPassReset;
    private javax.swing.JButton btnPermissions;
    private javax.swing.JButton btnPrintBorrowers;
    private javax.swing.JButton btnPrintIssued;
    private javax.swing.JButton btnPrintSession;
    private javax.swing.JButton btnProfMore;
    private javax.swing.JButton btnRecieveBooks;
    private javax.swing.JButton btnRecieveMagz;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRefreshBoro;
    private javax.swing.JButton btnRefreshMagz;
    private javax.swing.JButton btnRefreshMagzBoro;
    private javax.swing.JButton btnRefreshShortBks;
    private javax.swing.JButton btnRefreshStockDetails;
    private javax.swing.JButton btnRefreshUserTable;
    private javax.swing.JButton btnSchedulesShortCut;
    private javax.swing.JButton btnSearchBookDetails;
    private javax.swing.JButton btnSearchBoroMagz;
    private javax.swing.JButton btnSearchBorrowers;
    private javax.swing.JButton btnSearchForMagIssue;
    private javax.swing.JButton btnSearchIssueStd;
    private javax.swing.JButton btnSearchIssued;
    private javax.swing.JButton btnSearchList;
    private javax.swing.JButton btnSearchMagz;
    private javax.swing.JButton btnSearchShortLoanBks;
    private javax.swing.JButton btnSearchStaff;
    private javax.swing.JButton btnSearchStaffBk;
    private javax.swing.JButton btnSearchStaffId;
    private javax.swing.JButton btnSearchStd;
    private javax.swing.JButton btnSearchStdID;
    private javax.swing.JButton btnSearchStdStaff;
    private javax.swing.JButton btnSearchUser;
    private javax.swing.JButton btnUsersSessions;
    private javax.swing.JButton btnViewSch;
    private javax.swing.JButton btnWriteStdToExcel;
    private javax.swing.JButton btnusersInfo;
    private com.toedter.calendar.JCalendar calenderHome;
    private com.toedter.calendar.JDateChooser chooserMagz;
    private com.toedter.calendar.JDateChooser chooserMagzBoro;
    private com.toedter.calendar.JDateChooser chooserMagzDue;
    private com.toedter.calendar.JDateChooser chooserschDate;
    private javax.swing.JComboBox<String> comboBoxList;
    private javax.swing.JComboBox<String> comboFiletStaff;
    private javax.swing.JComboBox<String> comboFilter;
    private javax.swing.JComboBox<String> comboFilterLost;
    private javax.swing.JComboBox<String> comboFilterStock;
    private javax.swing.JComboBox<String> comboFilterStudents;
    private javax.swing.JComboBox<String> comboMagz;
    private javax.swing.JComboBox<String> comboMagzFilter;
    private javax.swing.JComboBox<String> comboNotes;
    private javax.swing.JComboBox<String> comboSearchInStaffIssue;
    private javax.swing.JComboBox<String> comboSearchIssue;
    private javax.swing.JComboBox<String> comboSearchShort;
    private javax.swing.JComboBox<String> comboStaffStudent;
    private com.toedter.calendar.JDateChooser dateChooserDue;
    private com.toedter.calendar.JDateChooser dateReturnedChooser;
    private com.toedter.calendar.JDateChooser dateStaffDue;
    private javax.swing.JPanel holderPanel;
    private javax.swing.JMenuItem itemBooksIssued;
    private javax.swing.JMenuItem itemHome;
    private javax.swing.JMenu itemIssue;
    private javax.swing.JMenuItem itemList;
    private javax.swing.JMenuItem itemLogout;
    private javax.swing.JMenuItem itemManageUsers;
    private javax.swing.JMenuItem itemRecieve;
    private javax.swing.JMenuItem itemShortLoan;
    private javax.swing.JMenuItem itemStaff;
    private javax.swing.JMenuItem itemStock;
    private javax.swing.JMenuItem itemStudent;
    private javax.swing.JMenuItem itemsSystems;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelBookNo;
    private javax.swing.JLabel labelBooksBorrowed;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelId1;
    private javax.swing.JLabel labelId10;
    private javax.swing.JLabel labelId2;
    private javax.swing.JLabel labelId3;
    private javax.swing.JLabel labelId4;
    private javax.swing.JLabel labelId5;
    private javax.swing.JLabel labelId6;
    private javax.swing.JLabel labelId7;
    private javax.swing.JLabel labelId8;
    private javax.swing.JLabel labelId9;
    private javax.swing.JLabel labelMagz;
    private javax.swing.JLabel labelMagzBorrowed;
    private javax.swing.JLabel labelMagzBorrowed1;
    private javax.swing.JLabel labelPermission;
    private javax.swing.JLabel labelSearchInMagzPanel;
    private javax.swing.JLabel labelStaffList;
    private javax.swing.JLabel labelTabOne;
    private javax.swing.JLabel labelTabThree;
    private javax.swing.JLabel labelTabTwo;
    private javax.swing.JLabel labelTime;
    private javax.swing.JLabel labelUser;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNoOfBorrowers;
    private javax.swing.JLabel lblUserId;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenu mainMenuNav;
    private javax.swing.JLabel maxStaff;
    private javax.swing.JLabel maxStd;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuItemAbout;
    private javax.swing.JMenu menuItemEdit;
    private javax.swing.JMenuItem menuItemGuide;
    private javax.swing.JMenuItem menuItemLost;
    private javax.swing.JMenuItem menuItemMagz;
    private javax.swing.JMenuItem menuItemProfile;
    private javax.swing.JMenu menuItemView;
    private javax.swing.JMenu menuSettings;
    private javax.swing.JPanel panelAddUsers;
    private javax.swing.JPanel panelBooksIssued;
    private javax.swing.JPanel panelBorrowers;
    private javax.swing.JPanel panelHolderManageUsers;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelIssueStaff;
    private javax.swing.JPanel panelIssueStudent;
    private javax.swing.JPanel panelList;
    private javax.swing.JPanel panelLostBooks;
    private javax.swing.JPanel panelMags;
    private javax.swing.JPanel panelMagsIn;
    private javax.swing.JPanel panelMagzBorrowers;
    private javax.swing.JPanel panelManageUsers;
    private javax.swing.JPanel panelNotesCreate;
    private javax.swing.JPanel panelRecieve;
    private javax.swing.JPanel panelReportLost;
    private javax.swing.JPanel panelSchedules;
    private javax.swing.JPanel panelSchedulesCreate;
    private javax.swing.JPanel panelSessionLogs;
    private javax.swing.JPanel panelShortLoanBooks;
    private javax.swing.JPanel panelStudents;
    private javax.swing.JPanel panelTeachers;
    private javax.swing.JPanel panelUsersView;
    private javax.swing.JPanel panelstock;
    private javax.swing.JButton searchLost;
    private javax.swing.JButton searchStock;
    private com.toedter.calendar.JDateChooser staffDateBorrowed;
    private javax.swing.JTable tableBookLost;
    private javax.swing.JTable tableBookStock;
    private javax.swing.JTable tableBooksForStaff;
    private javax.swing.JTable tableBooksIssued;
    private javax.swing.JTable tableBorrowers;
    private javax.swing.JTable tableIssueToStudents;
    private javax.swing.JTable tableListBooks;
    private javax.swing.JTable tableMags;
    private javax.swing.JTable tableMagzBoro;
    private javax.swing.JTable tableNotes;
    private javax.swing.JTable tableSchedules;
    private javax.swing.JTable tableSessionLogs;
    private javax.swing.JTable tableShortLoanBook;
    private javax.swing.JTable tableStaff;
    private javax.swing.JTable tableStudents;
    private javax.swing.JTable tableUsers;
    private javax.swing.JTextField textFieldBookId;
    private javax.swing.JTextField txtAdmNo;
    private javax.swing.JTextArea txtAreaCondition;
    private javax.swing.JTextField txtBookIDlost;
    private javax.swing.JTextField txtBookIdIssue;
    private javax.swing.JTextField txtBookIsbnIssue;
    private javax.swing.JTextField txtBookIsbnRet;
    private javax.swing.JTextField txtBookIssueTitle1;
    private javax.swing.JTextField txtBookTitle;
    private javax.swing.JTextField txtBookTitleLost;
    private javax.swing.JPasswordField txtConfPass;
    private javax.swing.JTextField txtDateDue;
    private javax.swing.JTextField txtDept;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtFnameLost;
    private javax.swing.JTextField txtIDLost;
    private javax.swing.JTextField txtIdNo;
    private javax.swing.JTextField txtIsbnLost;
    private javax.swing.JTextField txtListBooks;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtLnameLost;
    private javax.swing.JTextField txtMagzClass;
    private javax.swing.JTextField txtMagzDate;
    private javax.swing.JTextField txtMagzDept;
    private javax.swing.JTextField txtMagzIssueNo;
    private javax.swing.JTextField txtMagzName1;
    private javax.swing.JTextField txtMagzName2;
    private javax.swing.JTextField txtMagzNameID;
    private javax.swing.JTextField txtMagzPhone;
    private javax.swing.JTextField txtMagzTitle;
    private javax.swing.JTextArea txtNotesInfo;
    private javax.swing.JTextField txtNotesTitle;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPenalties;
    private javax.swing.JTextField txtReceievedFrom;
    private javax.swing.JTextArea txtSchInfo;
    private javax.swing.JTextField txtSdntFname;
    private javax.swing.JTextField txtSearchBorrowers;
    private javax.swing.JTextField txtSearchIssueStd;
    private javax.swing.JTextField txtSearchIssued;
    private javax.swing.JTextField txtSearchLost;
    private javax.swing.JTextField txtSearchMagzBorrowed;
    private javax.swing.JTextField txtSearchShort;
    private javax.swing.JTextField txtSearchStaffBook;
    private javax.swing.JTextField txtSearchText;
    private javax.swing.JTextField txtSearchUser;
    private javax.swing.JTextField txtShortBkId;
    private javax.swing.JTextField txtShortBkIsbn;
    private javax.swing.JTextField txtShortBkTitle;
    private javax.swing.JTextField txtShortClass;
    private javax.swing.JTextField txtShortDept;
    private javax.swing.JTextField txtShortFname;
    private javax.swing.JTextField txtShortLname;
    private javax.swing.JTextField txtStaffBkTitle;
    private javax.swing.JTextField txtStaffBookId;
    private javax.swing.JTextField txtStaffBookIsbn;
    private javax.swing.JTextField txtStaffDept;
    private javax.swing.JTextField txtStaffID;
    private javax.swing.JTextField txtStaffIdList;
    private javax.swing.JTextField txtStaffLost;
    private javax.swing.JTextField txtStaffName1;
    private javax.swing.JTextField txtStaffName2;
    private javax.swing.JTextField txtStaffNo;
    private javax.swing.JTextField txtStaffPhone;
    private javax.swing.JTextField txtStaffStudent;
    private javax.swing.JTextField txtStaffstdId;
    private javax.swing.JTextField txtStdIdSearch;
    private javax.swing.JTextField txtStdntAmNo;
    private javax.swing.JTextField txtStdntClass;
    private javax.swing.JTextField txtStdntLname;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtschtitle;
    // End of variables declaration//GEN-END:variables
}
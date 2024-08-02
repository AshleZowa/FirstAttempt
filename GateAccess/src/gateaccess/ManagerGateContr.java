/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gateaccess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ManagerGateContr extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManagerGateContr
     */
    public ManagerGateContr() {
        initComponents();
         mLoadComboBox();
         mGUIControls();
        
    }
    
    String strDate;                  String strReg;
    String strTime;                  int intTel;
    String strName;               String strReason;
    String strCompany;            String strPerson;
    
   private void mGUIControls()
   {
      cboResults.setEnabled(true);
      btnResults.setEnabled(true);
      btnSave.setEnabled(false);
      btnDelete.setEnabled(true);
     
   }
   
   private void mControls()
   {
      cboResults.setEnabled(true);
      btnSave.setEnabled(true);
      btnDelete.setEnabled(true);
     
   }
     
     private void mRead()
     {
    String strDBConnectionString = "jdbc:mysql://localhost:3306/gate_access_control";
    String strDBUser = "root";
    String strDBPassword = "Password";
    java.sql.Connection conMySQLConnectionString;
    Statement stStatement = null ;
    ResultSet rs = null;
    
    try
    {
   
    conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
    stStatement = (Statement) conMySQLConnectionString.createStatement();
    String strQuery = " Select Date, Time_In, Name, From_Company, Vehicle_Reg, Tel, Reason_for_Visit, Person_to_See from visitor_records where "
            + "Name='"+ cboResults.getSelectedItem().toString()+"'";
    stStatement.execute(strQuery);
     rs = stStatement.getResultSet(); 
    while(rs.next())
    {
         strDate = rs.getString(1);
         strTime = rs.getString(2);
         strName = rs.getString(3);
         strCompany = rs.getString(4);
         strReg = rs.getString(5);
         intTel = rs.getInt(6);
         strReason = rs.getString(7);
         strPerson = rs.getString(8);
           
    }
    }
    catch(SQLException e)
    {
       JOptionPane.showMessageDialog(null, e);  
    }
     finally
    {
        try{
            stStatement.close();
        }
     catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Connection string not closed" + " " + e) ;  
     } 
    }   
    }
      private void mLoadComboBox()
     {
    String strDBConnectionString = "jdbc:mysql://localhost:3306/gate_access_control";
    String strDBUser = "root";
    String strDBPassword = "Password";
    java.sql.Connection conMySQLConnectionString;
    Statement stStatement = null ;
    ResultSet rs = null;
    
    try
    {
   
    conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
    stStatement = (Statement) conMySQLConnectionString.createStatement();
    String strQuery = " Select Name from visitor_records ";
    stStatement.execute(strQuery);
    rs = stStatement.getResultSet(); 
    while(rs.next())
    {
      cboResults.addItem(rs.getString(1)); 
    }
    }
    catch(SQLException e)
    {
      JOptionPane.showMessageDialog(null, e);  
    }
     finally
    {
        try{
            stStatement.close();
        }
     catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Connection string not closed" + " " + e) ;  
     }
    }
    }
    
     private void mLoadTable()
    {
     String strDBConnectionString = "jdbc:mysql://localhost:3306/gate_access_control";
    String strDBUser = "root";
    String strDBPassword = "Password";
    java.sql.Connection conMySQLConnectionString;
    Statement stStatement = null ;
    ResultSet rs = null;
    
    try
    {
   
    conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
    stStatement = (Statement) conMySQLConnectionString.createStatement();
    String strQuery = " Select * from visitor_records ";
    stStatement.execute(strQuery);
    rs = stStatement.getResultSet(); 
    while(rs.next())
    {
           String Date = rs.getString("Date");
           String Time_In = rs.getString("Time_In");
           String Name = rs.getString("Name");
           String From_Company = rs.getString("From_Company");
           String Vehicle_Reg = rs.getString("Vehicle_Reg");
           String Tel = String.valueOf(rs.getInt("Tel"));
           String Reason_for_Visit = rs.getString("Reason_for_Visit");
           String Person_to_See = rs.getString("Person_to_See");
           
           String tbData[] = {Date, Time_In, Name, From_Company, Vehicle_Reg, Tel, Reason_for_Visit, Person_to_See};
           DefaultTableModel tblModel = (DefaultTableModel)tblView.getModel();
           
           tblModel.addRow(tbData);
          }
        conMySQLConnectionString.close();
     } 
     catch (SQLException ex) 
     {
      JOptionPane.showMessageDialog(null, ex);
     }
     finally
     {
         try{
             stStatement.close();
         }
         catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Connection String not closed" + "" + e); 
         }   
    }
    }
     
      private void mClearComboBox()
     {
        String [] arrArray = new String[0];
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray);
        cboResults.setModel(model);
     }
      
        private void mDelete()
     {
    String strDBConnectionString = "jdbc:mysql://localhost:3306/gate_access_control";
    String strDBUser = "root";
    String strDBPassword = "Password";
    java.sql.Connection conMySQLConnectionString;
    Statement stStatement = null ;
    ResultSet rs = null;
    
    try
    {
   
    conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
    String strQuery = " Delete  from  visitor_records where Date= '"+ strDate+"' and Time_In='"+strTime+"' and Name='"+strName+"'and "
            + "From_Company='"+strCompany+"' and Vehicle_Reg='"+strReg+"' and Tel='"+intTel+"' and Reason_for_Visit='"+strReason+"' and"
            + " Person_to_See='"+strPerson+"'" ;
    stStatement = (Statement) conMySQLConnectionString.prepareStatement(strQuery);
    stStatement.execute(strQuery);
    }
    catch(SQLException e)
    {
       JOptionPane.showMessageDialog(null, e);  
    }
     finally
    {
        try{
            stStatement.close();
        }
     catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Connection string not closed" + " " + e) ;  
     } 
    } 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblView = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnResults = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        cboResults = new javax.swing.JComboBox<>();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblView1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnResults1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();
        cboResults1 = new javax.swing.JComboBox<>();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblView2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnResults2 = new javax.swing.JButton();
        btnDelete2 = new javax.swing.JButton();
        btnSave2 = new javax.swing.JButton();
        cboResults2 = new javax.swing.JComboBox<>();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblView3 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnResults3 = new javax.swing.JButton();
        btnDelete3 = new javax.swing.JButton();
        btnSave3 = new javax.swing.JButton();
        cboResults3 = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(827, 638));

        tblView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time In", "Name", "From Company", "Vehicle Reg.No", "Tel.No", "Reason for visit", "Person to see"
            }
        ));
        jScrollPane1.setViewportView(tblView);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Gate Access ");

        btnResults.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnResults.setText("View");
        btnResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultsActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cboResults.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        tblView1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time In", "Name", "From Company", "Vehicle Reg.No", "Tel.No", "Reason for visit", "Person to see"
            }
        ));
        jScrollPane2.setViewportView(tblView1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Gate Access ");

        btnResults1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnResults1.setText("View");
        btnResults1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResults1ActionPerformed(evt);
            }
        });

        btnDelete1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete1.setText("Delete");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        btnSave1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave1.setText("Save");

        cboResults1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboResults1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(btnDelete1)
                .addGap(229, 229, 229))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(btnResults1)
                .addGap(178, 178, 178)
                .addComponent(btnSave1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResults1)
                    .addComponent(btnSave1))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboResults1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete1))
                .addGap(32, 32, 32))
        );

        tblView2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time In", "Name", "From Company", "Vehicle Reg.No", "Tel.No", "Reason for visit", "Person to see"
            }
        ));
        jScrollPane3.setViewportView(tblView2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Gate Access ");

        btnResults2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnResults2.setText("View");
        btnResults2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResults2ActionPerformed(evt);
            }
        });

        btnDelete2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete2.setText("Delete");
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });

        btnSave2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave2.setText("Save");

        cboResults2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        tblView3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time In", "Name", "From Company", "Vehicle Reg.No", "Tel.No", "Reason for visit", "Person to see"
            }
        ));
        jScrollPane4.setViewportView(tblView3);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Gate Access ");

        btnResults3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnResults3.setText("View");
        btnResults3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResults3ActionPerformed(evt);
            }
        });

        btnDelete3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete3.setText("Delete");
        btnDelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete3ActionPerformed(evt);
            }
        });

        btnSave3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave3.setText("Save");

        cboResults3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboResults3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(btnDelete3)
                .addGap(229, 229, 229))
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(btnResults3)
                .addGap(178, 178, 178)
                .addComponent(btnSave3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResults3)
                    .addComponent(btnSave3))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboResults3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete3))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboResults2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(btnDelete2)
                .addGap(229, 229, 229))
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(btnResults2)
                .addGap(178, 178, 178)
                .addComponent(btnSave2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                    .addGap(0, 337, Short.MAX_VALUE)
                    .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 338, Short.MAX_VALUE)))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResults2)
                    .addComponent(btnSave2))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboResults2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete2))
                .addGap(32, 32, 32))
            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                    .addGap(0, 179, Short.MAX_VALUE)
                    .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 179, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(350, 350, 350)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(cboResults, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addComponent(btnDelete)
                        .addGap(0, 227, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(btnResults)
                .addGap(205, 205, 205)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(510, Short.MAX_VALUE)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(308, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResults)
                    .addComponent(btnSave))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboResults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addGap(79, 79, 79))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 265, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 265, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(145, Short.MAX_VALUE)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(385, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
            mRead();
            mDelete();
            mClearComboBox();
            mLoadComboBox();
           
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultsActionPerformed
         mRead();
         mLoadTable();
         mControls();
    }//GEN-LAST:event_btnResultsActionPerformed

    private void btnResults1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResults1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResults1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnResults2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResults2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResults2ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void btnResults3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResults3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResults3ActionPerformed

    private void btnDelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete3ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
      String filePath = "C:\\Users\\HP\\Documents\\NetBeansProjects\\TextFile\\gate_access.txt";
      File file = new File(filePath);
        try {
          try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
              
              for(int i = 0; i < tblView.getRowCount(); i++)
              {
                  for(int j = 0; j < tblView.getColumnCount(); j++)
                  {
                      bw.write(tblView.getValueAt(i, j).toString()+" ; ");
                  }
                  bw.newLine();
              }
          }
           JOptionPane.showMessageDialog(null, "Complete");
        } catch (IOException ex) {
            Logger.getLogger(ManagerGateContr.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnDelete3;
    private javax.swing.JButton btnResults;
    private javax.swing.JButton btnResults1;
    private javax.swing.JButton btnResults2;
    private javax.swing.JButton btnResults3;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton btnSave2;
    private javax.swing.JButton btnSave3;
    private javax.swing.JComboBox<String> cboResults;
    private javax.swing.JComboBox<String> cboResults1;
    private javax.swing.JComboBox<String> cboResults2;
    private javax.swing.JComboBox<String> cboResults3;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblView;
    private javax.swing.JTable tblView1;
    private javax.swing.JTable tblView2;
    private javax.swing.JTable tblView3;
    // End of variables declaration//GEN-END:variables
}

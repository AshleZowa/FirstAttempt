/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gateaccess;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class SecurityGateContr extends javax.swing.JInternalFrame {

    /**
     * Creates new form SecurityGateContr
     */
    public SecurityGateContr() {
        initComponents();
        mLoadComboBox();
        mLoadGUIControls();
    }
    Boolean boolRecordExists = false;
    Boolean boolEdit = false;
    Boolean boolCreate = false;
    String strDate;                  String strReg;
    String strTime;                  int intTel;
    String strName;               String strReason;
    String strCompany;            String strPerson;
    
    private void mClearVariables()
    {
       strDate = "";
        strTime = "";
        strName = "";
        strCompany = "";
        strReg ="";
        intTel = 0;
        strReason = "";
        strPerson = "";
    }
     private void mGetValues()
     {
         strDate = txtDate.getText();
         strTime = txtTime.getText();
         strName = txtName.getText();
         strCompany = txtCompany.getText();
         strReg = txtReg.getText();
         intTel = Integer.parseInt(txtTel.getText());
         strReason = txtReason.getText();
         strPerson = txtPerson.getText(); 
     }
     private void mSetValues()
     {
          txtDate.setText(strDate);
          txtTime.setText(strTime);
          txtName.setText(strName);
          txtCompany.setText(strCompany);
          txtReg.setText(strReg);
          txtTel.setText(String.valueOf(intTel));
          txtReason.setText(strReason);
          txtPerson.setText(strPerson); 
     }
     private void mSetValuesToUpperCase()
    {
         strDate = strDate.toUpperCase();
         strTime = strTime.toUpperCase();
         strName = strName.toUpperCase();
         strCompany = strCompany.toUpperCase();
         strReg = strReg.toUpperCase();
         strReason = strReason.toUpperCase();
         strPerson = strPerson.toUpperCase();
    }
     private void mClearText()
     {
         txtDate.setText(" ");
          txtTime.setText(" ");
          txtName.setText(" ");
          txtCompany.setText(" ");
          txtReg.setText(" ");
          txtTel.setText(String.valueOf(" "));
          txtReason.setText(" ");
          txtPerson.setText(" "); 
     }
     private void mCheckItems()
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
    String strQuery = " Select * from  visitor_records where Date= '"+ strDate+"' and Time_In='"+strTime+"' and Name='"+strName+"'and "
            + "From_Company='"+strCompany+"' and Vehicle_Reg='"+strReg+"' and Tel='"+intTel+"' and Reason_for_Visit='"+strReason+"' and"
            + " Person_to_See='"+strPerson+"'";
    stStatement.execute(strQuery);
    rs = stStatement.getResultSet();
    boolRecordExists = rs.next();
    }
    catch(SQLException e)
    {
     JOptionPane.showMessageDialog(null, e) ;  
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
     private void mCreate()
     {
      java.sql.Connection conMySQLConnectionString = null;
      String URL = "jdbc:mysql://localhost:3306/gate_access_control";
      String User = "root";
      String Password = "Password";
     try
     {
      conMySQLConnectionString = DriverManager.getConnection(URL, User, Password);
      Statement myStatement = (Statement)  conMySQLConnectionString.createStatement(); 
      String sqlinsert = " insert into visitor_records "+"(Date, Time_In, Name, From_Company, Vehicle_Reg, Tel, Reason_for_Visit, Person_to_See) "+
                     "values('"+ strDate +"','"+ strTime +"','"+ strName+"','"+ strCompany +"','"+ strReg+"','"+ intTel +"','"+ strReason+"','"+ strPerson+"')";
      myStatement.executeUpdate(sqlinsert);
      myStatement.close();
      JOptionPane.showMessageDialog(null, "Complete");
    }
    catch( SQLException e)
    {
     JOptionPane.showMessageDialog(null, e);
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
           DefaultTableModel tblModel = (DefaultTableModel)tblResults.getModel();
           
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
      cboName.addItem(rs.getString(1)); 
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
     private void mUpdate()
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
    String strQuery = " UPDATE visitor_records SET Date= '"+strDate+"',Time_In= '"+strTime+"',Name= '"+ strName+"', From_Company='"+strCompany+"', "
            + "Vehicle_Reg='"+strReg+"',Tel='"+intTel+"',Reason_for_Visit='"+strReason+"',Person_to_See='"+strPerson+"'" ;
    stStatement.executeUpdate(strQuery);
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
     private void mClearComboBox()
     {
        String [] arrArray = new String[0];
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray);
        cboName.setModel(model);
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
    String strQuery = " Select Date, Time_In, Name, From_Company, Vehicle_Reg, Tel, Reason_for_Visit, Person_to_See from visitor_records where Name='"+ cboName.getSelectedItem().toString() +"'";
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
     private void mLoadGUIControls()
     {
          txtDate.setEnabled(false);
          txtTime.setEnabled(false);
          txtName.setEnabled(false);
          txtCompany.setEnabled(false);
          txtReg.setEnabled(false);
          txtTel.setEnabled(false);
          txtReason.setEnabled(false);
          txtPerson.setEnabled(false); 
         cboName.setEnabled(true);
         btnInsert.setEnabled(true);
         btnView.setEnabled(true);
         btnUpdate.setEnabled(true);
         btnSave.setEnabled(false);
     }
     private void mEditGUIControls()
     {
        txtDate.setEnabled(true);
          txtTime.setEnabled(true);
          txtName.setEnabled(true);
          txtCompany.setEnabled(true);
          txtReg.setEnabled(true);
          txtTel.setEnabled(true);
          txtReason.setEnabled(true);
          txtPerson.setEnabled(true); 
         cboName.setEnabled(false);
         btnInsert.setEnabled(false);
         btnView.setEnabled(false);
         btnUpdate.setEnabled(false); 
         btnSave.setEnabled(true);
     }
     private void mSaveGUIControls()
     {
         txtDate.setEnabled(false);
          txtTime.setEnabled(false);
          txtName.setEnabled(false);
          txtCompany.setEnabled(false);
          txtReg.setEnabled(false);
          txtTel.setEnabled(false);
          txtReason.setEnabled(false);
          txtPerson.setEnabled(false); 
         cboName.setEnabled(true);
         btnInsert.setEnabled(true);
         btnView.setEnabled(true);
         btnUpdate.setEnabled(true); 
         btnSave.setEnabled(false); 
     }
    private void mCreateGUIControls()
    {
         txtDate.setEnabled(true);
          txtTime.setEnabled(true);
          txtName.setEnabled(true);
          txtCompany.setEnabled(true);
          txtReg.setEnabled(true);
          txtTel.setEnabled(true);
          txtReason.setEnabled(true);
          txtPerson.setEnabled(true); 
         cboName.setEnabled(false);
         btnInsert.setEnabled(false);
         btnView.setEnabled(false);
         btnUpdate.setEnabled(false); 
         btnSave.setEnabled(true); 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResults = new javax.swing.JTable();
        cboName = new javax.swing.JComboBox<>();
        txtDate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCompany = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        txtReg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtReason = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPerson = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Person to See");

        tblResults.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tblResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time In", "Name", "From Company", "Vehicle Reg.No", "Tel.No", "Reason for visit", "Person to see"
            }
        ));
        jScrollPane1.setViewportView(tblResults);

        cboName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Gate Access");

        txtTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Date");

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Time In");

        txtCompany.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompanyActionPerformed(evt);
            }
        });

        btnInsert.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInsert.setText("Capture");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Name");

        btnView.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        txtReg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("From Company");

        txtTel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Vehicle Reg.No");

        txtReason.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Tel.No");

        txtPerson.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Reason to Visit");

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(cboName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(btnUpdate)
                        .addGap(85, 85, 85)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(txtTime)
                            .addComponent(txtName)
                            .addComponent(txtCompany))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(40, 40, 40)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtReg, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPerson, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtReason, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(btnInsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(117, 117, 117)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGap(37, 37, 37))))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnView))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate)
                    .addComponent(btnSave))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        mRead();
        mSetValues();
        mLoadGUIControls();
        mLoadTable();
       
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        mCreateGUIControls();
        txtDate.requestFocusInWindow();
        boolCreate= true;
    }//GEN-LAST:event_btnInsertActionPerformed

    private void txtCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        mRead();
        mSetValues();
        mEditGUIControls();
         txtDate.requestFocusInWindow();
         boolEdit= true;
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
         if(boolCreate == true)
      {
          if(txtDate.getText().equals(""))
          {
              JOptionPane.showMessageDialog(null , "This field cannot be empty");
              txtDate.requestFocusInWindow();
          }
          else if(txtTime.getText().equals(""))
          {
             JOptionPane.showMessageDialog(null , "This field cannot be empty");
              txtTime.requestFocusInWindow();  
          }
          else if(txtName.getText().equals(""))
          {
             JOptionPane.showMessageDialog(null , "This field cannot be empty");
              txtName.requestFocusInWindow();   
          }
          else if(txtCompany.getText().equals(""))
          {
             JOptionPane.showMessageDialog(null , "This field cannot be empty");
              txtCompany.requestFocusInWindow();   
          }
          else if(txtReg.getText().equals(""))
          {
             JOptionPane.showMessageDialog(null , "This field cannot be empty");
              txtReg.requestFocusInWindow();   
          }
          else if(txtTel.getText().equals(""))
          {
             JOptionPane.showMessageDialog(null , "This field cannot be empty");
              txtTel.requestFocusInWindow();   
          }
          else if(txtReason.getText().equals(""))
          {
             JOptionPane.showMessageDialog(null , "This field cannot be empty");
              txtReason.requestFocusInWindow();   
          }
          else if(txtPerson.getText().equals(""))
          {
             JOptionPane.showMessageDialog(null , "This field cannot be empty");
              txtPerson.requestFocusInWindow();   
          }
          else
          {
              mGetValues();
              mSetValuesToUpperCase();
              mCheckItems();
              
            if(boolRecordExists == true){
                boolRecordExists =false;
                JOptionPane.showMessageDialog(null, "Visitor already Exists");
            }
            else if (boolRecordExists == false){
               boolCreate =false;
                mCreate();
                mClearText();
                mClearComboBox();
                mClearVariables();
                mLoadComboBox();
                mLoadGUIControls();
            }
          }
      }
      else if (boolEdit==true){
          boolEdit = false;
          mGetValues();
          mSetValues();
          mSetValuesToUpperCase();
          mUpdate();
          mClearText();
          mClearVariables();
          mClearComboBox();
          mLoadTable();
          mLoadComboBox();
          mLoadGUIControls();
      }
         
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cboName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResults;
    private javax.swing.JTextField txtCompany;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPerson;
    private javax.swing.JTextField txtReason;
    private javax.swing.JTextField txtReg;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}

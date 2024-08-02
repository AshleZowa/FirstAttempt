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

/**
 *
 * @author HP
 */
public class Credentials extends javax.swing.JInternalFrame {

    /**
     * Creates new form Credentials
     */
    public Credentials() {
        initComponents();
        mLoad();
        mLoadGUIControls();
    }

    CaesarsChiper clsCC = new CaesarsChiper();
    
    Boolean boolRecordExists = false;
    Boolean boolEdit = false;
    Boolean boolCreate = false;
    String strUserName;
    String strPassword;
    String  strRole;
    
    private void mClearVariables()
    {
        strUserName = "";
        strPassword = "";
        strRole = "";
    }
    
    private void mGetValues()
    {
        strUserName = txtUserName.getText();
        strPassword = txtPassword.getText();
        strRole = txtRole.getText();
    }
    private void mSetValues()
    {
        strUserName = strUserName.toUpperCase();
        strPassword = strPassword.toUpperCase();
        strRole = strRole.toUpperCase();
    }
    
    private void mClearText()
    {
        txtUserName.setText("");
        txtPassword.setText("");
        txtRole.setText("");
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
    String strQuery = " Select * from  credentials where UserName= '"+ strUserName+"' and Password='"+strPassword+"'";
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
      String sqlinsert = " insert into credentials "+"(UserName, Password, Role) "+
                     "values('"+ strUserName +"','"+ strPassword +"','"+ strRole +"')";
      myStatement.executeUpdate(sqlinsert);
      myStatement.close();
      JOptionPane.showMessageDialog(null, "Complete");
    }
    catch( SQLException e)
    {
     JOptionPane.showMessageDialog(null, e);
    }
    }
    
    private void mLoad()
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
    String strQuery = " Select UserName from credentials ";
    stStatement.execute(strQuery);
    rs = stStatement.getResultSet(); 
    while(rs.next())
    {
      cboUserName.addItem(rs.getString(1)); 
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
    String strQuery = " UPDATE credentials SET UserName= '"+ strUserName+"', Password='"+strPassword+"', Role="+strRole+"'";
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
        cboUserName.setModel(model);
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
    String strQuery = " Delete from credentials where UserName= '"+ strUserName+"'and Password='"+strPassword+"'and Role='"+strRole+"'";
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
    String strQuery = " Select UserName, Password, Role from credentials where UserName='"+ cboUserName.getSelectedItem().toString()+"'";
    stStatement.execute(strQuery);
     rs = stStatement.getResultSet(); 
    while(rs.next())
    {
        strUserName = rs.getString(1);
        strPassword = rs.getString(2);
        strRole = rs.getString(3);
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
         txtUserName.setEnabled(false);
         txtPassword.setEnabled(false);
         txtRole.setEnabled(false);
         cboUserName.setEnabled(true);
         btnCreate.setEnabled(true);
         btnView.setEnabled(true);
         btnEdit.setEnabled(true);
         btnSave.setEnabled(false);
         btnDelete.setEnabled(true);
     }
     
     private void mEditGUIControls()
     {
        txtUserName.setEnabled(true);
         txtPassword.setEnabled(true);
         txtRole.setEnabled(true);
         cboUserName.setEnabled(false);
         btnCreate.setEnabled(false);
         btnView.setEnabled(false);
         btnEdit.setEnabled(false);
         btnSave.setEnabled(true);
         btnDelete.setEnabled(true);  
     }
     
     private void mSaveGUIControls()
     {
        txtUserName.setEnabled(false);
         txtPassword.setEnabled(false);
         txtRole.setEnabled(false);
         cboUserName.setEnabled(true);
         btnCreate.setEnabled(true);
         btnView.setEnabled(true);
         btnEdit.setEnabled(true);
         btnSave.setEnabled(false);
         btnDelete.setEnabled(false);
     }
     
     private void mDeleteGUIControls()
     {
         txtUserName.setEnabled(false);
         txtPassword.setEnabled(false);
         txtRole.setEnabled(false);
         cboUserName.setEnabled(true);
         btnCreate.setEnabled(true);
         btnView.setEnabled(true);
         btnEdit.setEnabled(true);
         btnSave.setEnabled(false);
         btnDelete.setEnabled(false);  
     }
     
     private void mEncryptPassword()
     {
         strPassword = clsCC.mEncrypt(strPassword, 8);
     }
     
     private void mDecryptPassword()
     {
         strPassword = clsCC.mDecrypt(strPassword, 8);
     }
     
     private void mCreateGUIControls()
     {
        txtUserName.setEnabled(true);
         txtPassword.setEnabled(true);
         txtRole.setEnabled(true);
         cboUserName.setEnabled(false);
         btnCreate.setEnabled(false);
         btnView.setEnabled(false);
         btnEdit.setEnabled(false);
         btnSave.setEnabled(true);
         btnDelete.setEnabled(true);   
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtRole = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cboUserName = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("UserName");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Role");

        txtUserName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtRole.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnCreate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnView.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        cboUserName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserName)
                            .addComponent(txtPassword)
                            .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCreate)
                            .addComponent(btnDelete))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnView)
                            .addComponent(btnSave))))
                .addGap(0, 106, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(btnEdit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(cboUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnView))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnDelete))
                .addGap(86, 86, 86)
                .addComponent(cboUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnEdit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        mCreateGUIControls();
        txtUserName.requestFocusInWindow();
        btnDelete.setText("Cancel");
        boolCreate = true;
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
       mRead();
       mDecryptPassword();
       mSetValues();
       mLoadGUIControls();
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       mRead();
       mDecryptPassword();
       mSetValues();
       mEditGUIControls();
       txtUserName.requestFocusInWindow();
       btnDelete.setText("Cancel");
       boolEdit = true;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
      if(boolCreate == true)
      {
          if(txtUserName.getText().equals(""))
          {
              JOptionPane.showMessageDialog(null , "This field cannot be empty");
              txtUserName.requestFocusInWindow();
          }
          else if(txtPassword.getText().equals(""))
          {
             JOptionPane.showMessageDialog(null , "This field cannot be empty");
              txtPassword.requestFocusInWindow();  
          }
          else if(txtRole.getText().equals(""))
          {
             JOptionPane.showMessageDialog(null , "This field cannot be empty");
              txtRole.requestFocusInWindow();   
          }
          else
          {
              mGetValues();
              mSetValues();
              mEncryptPassword();
              mCheckItems();
            if(boolRecordExists == true){
                boolRecordExists =false;
                JOptionPane.showMessageDialog(null, "User already Exists");
            }
            else if (boolRecordExists == false){
                boolCreate = false;
                mCreate();
                mClearText();
                mClearComboBox();
                mLoad();
                mLoadGUIControls();
            }
          }
      }
      else if (boolEdit==true){
          boolEdit = false;
          mGetValues();
          mSetValues();
          mEncryptPassword();
          mUpdate();
          mClearText();
          mClearVariables();
          mClearComboBox();
          mLoad();
          mLoadGUIControls();
      }
      btnDelete.setText("Delete");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if ("Delete".equals(btnDelete.getText())){
            mRead();
            mDelete();
            mDeleteGUIControls();
            mClearComboBox();
            mClearVariables();
            mLoad();
        }
        else if("Cancel".equals(btnDelete.getText())){
            mClearText();
            mClearVariables();
            mLoad();
            //mClearComboBox();
            mLoadGUIControls();
            btnDelete.setText("Delete");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cboUserName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}

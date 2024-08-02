/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gateaccess;

/**
 *
 * @author HP
 */
public class Main extends javax.swing.JFrame {

   
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }
    public String strRole;
    
    public void mSetRoleRights()
    {
        if(null != strRole)
        switch(strRole)
        {
          case"ADMIN" -> {
              mnuLogoff.setEnabled(true);
              mnuExit.setEnabled(true);
              mnuSecurity.setEnabled(true);
              mnuManager.setEnabled(true);
              mnuCredentials.setEnabled(true);
            }
          case"MANAGER" -> {
              mnuLogoff.setEnabled(true);
              mnuExit.setEnabled(true);
              mnuSecurity.setEnabled(false);
              mnuManager.setEnabled(true);
              mnuCredentials.setEnabled(false);
            }
          case"SECURITY" -> {
              mnuLogoff.setEnabled(true);
              mnuExit.setEnabled(true);
              mnuSecurity.setEnabled(true);
              mnuManager.setEnabled(false);
              mnuCredentials.setEnabled(false);
            }
          default -> {
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

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        dpMain = new javax.swing.JDesktopPane();
        mnuMain = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuLogoff = new javax.swing.JMenuItem();
        mnuExit = new javax.swing.JMenuItem();
        mnuForms = new javax.swing.JMenu();
        mnuSecurity = new javax.swing.JMenuItem();
        mnuManager = new javax.swing.JMenuItem();
        mnuCredentials = new javax.swing.JMenuItem();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dpMain.setPreferredSize(new java.awt.Dimension(830, 630));

        javax.swing.GroupLayout dpMainLayout = new javax.swing.GroupLayout(dpMain);
        dpMain.setLayout(dpMainLayout);
        dpMainLayout.setHorizontalGroup(
            dpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        dpMainLayout.setVerticalGroup(
            dpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        mnuFile.setText("File");

        mnuLogoff.setText("LogOut");
        mnuLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLogoffActionPerformed(evt);
            }
        });
        mnuFile.add(mnuLogoff);

        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuExit);

        mnuMain.add(mnuFile);

        mnuForms.setText("Forms");

        mnuSecurity.setText("Security Gate Control");
        mnuSecurity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSecurityActionPerformed(evt);
            }
        });
        mnuForms.add(mnuSecurity);

        mnuManager.setText("Manager Gate Control");
        mnuManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuManagerActionPerformed(evt);
            }
        });
        mnuForms.add(mnuManager);

        mnuCredentials.setText("Credentials");
        mnuCredentials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCredentialsActionPerformed(evt);
            }
        });
        mnuForms.add(mnuCredentials);

        mnuMain.add(mnuForms);

        setJMenuBar(mnuMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dpMain.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLogoffActionPerformed
        SystemLogIn frmS = new SystemLogIn();
        frmS.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mnuLogoffActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuSecurityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSecurityActionPerformed
        SecurityGateContr sgc = new SecurityGateContr();
        dpMain.add(sgc);
        sgc.setVisible(true);
                
    }//GEN-LAST:event_mnuSecurityActionPerformed

    private void mnuManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuManagerActionPerformed
       ManagerGateContr mgc = new ManagerGateContr();
       dpMain.add(mgc);
       mgc.setVisible(true);
    }//GEN-LAST:event_mnuManagerActionPerformed

    private void mnuCredentialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCredentialsActionPerformed
       Credentials crd = new Credentials();
       dpMain.add(crd);
       crd.setVisible(true);
    }//GEN-LAST:event_mnuCredentialsActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpMain;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private javax.swing.JMenuItem mnuCredentials;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuForms;
    private javax.swing.JMenuItem mnuLogoff;
    private javax.swing.JMenuBar mnuMain;
    private javax.swing.JMenuItem mnuManager;
    private javax.swing.JMenuItem mnuSecurity;
    // End of variables declaration//GEN-END:variables
}
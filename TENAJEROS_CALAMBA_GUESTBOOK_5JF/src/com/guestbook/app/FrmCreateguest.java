/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmCreateguest.java
 *
 * Created on Jul 31, 2017, 3:28:30 PM
 */
package com.guestbook.app;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author 3rd Year Account
 */
public class FrmCreateguest extends javax.swing.JFrame {
    static java.sql.Connection conn = null;
    static java.sql.Statement stmt = null;
    static String url = "jdbc:sqlite:C:\\Users\\Andrew\\Documents\\sqlite.sqlite";
    
    private ResultSet rs;
   // String input1 = "0";
    
    /** Creates new form FrmCreateguest */
    public FrmCreateguest() {
        initComponents();
      
         if(SQLite.openDB()){
            int count = SQLite.autoincrement("task")+1;
            cid.setText(Integer.toString(count));
            SQLite.closeDB();
        }
        
    }
    static String error = "";
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ccont = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cemail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cgender = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CREATEBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Guest");
        setResizable(false);

        jLabel1.setText("NAME");

        cid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        jLabel3.setText("CONTACT NO");

        jLabel4.setText("EMAIL");

        jLabel5.setText("GENDER");

        jLabel6.setText("CREATE GUEST");

        CREATEBTN.setText("CREATE");
        CREATEBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CREATEBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(ccont, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(cemail, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(cid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CREATEBTN)
                            .addComponent(cgender, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ccont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(CREATEBTN)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(427, 378));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

private void CREATEBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CREATEBTNActionPerformed
        

        
       String  input1 = cid.getText();   
        String input2 = cname.getText();
        String input3 = ccont.getText();
        String input4 = cemail.getText();
        String input5 = cgender.getText();
        
        //INSERT INTO task VALUES(1,'asdas','asdas')
        String values = input1 + "," + "'" +input2 + "'"  + " , " +input3 + " , " + "'" + input4 +  "'" + "," + "'" + input5 + "'";
        
            if(SQLite.openDB()){
                SQLite.create("task",values);
            }   SQLite.closeDB();
        JOptionPane.showMessageDialog(null, "successfully created guest", "successfully created guest", JOptionPane.INFORMATION_MESSAGE);

        
        
}//GEN-LAST:event_CREATEBTNActionPerformed

    private void cidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cidActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCreateguest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCreateguest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCreateguest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCreateguest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmCreateguest().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CREATEBTN;
    private javax.swing.JTextField ccont;
    private javax.swing.JTextField cemail;
    private javax.swing.JTextField cgender;
    private javax.swing.JTextField cid;
    private javax.swing.JTextField cname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}

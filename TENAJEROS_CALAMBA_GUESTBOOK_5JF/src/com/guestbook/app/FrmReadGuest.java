/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmReadGuest.java
 *
 * Created on Jul 31, 2017, 3:29:27 PM
 */
package com.guestbook.app;
import static com.guestbook.app.SQLite.stmt;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3rd Year Account
 */
public class FrmReadGuest extends javax.swing.JFrame {
static java.sql.Connection conn = null;
    static java.sql.Statement stmt = null;
    static String url = "jdbc:sqlite:C:\\Users\\Andrew\\Documents\\sqlite.sqlite";
    
    private ResultSet rs;
    
    /** Creates new form FrmReadGuest */
    public FrmReadGuest() {
        initComponents();
        
        if(SQLite.openDB()){
            String[][] data = SQLite.read("task");
            
            String[] column = {"ID", "NAME","CONTACT NO","EMAIL ADD","GENDER"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblGuestbook.setModel(model);
            SQLite.closeDB();
        } 
    }
    int a=0;
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGuestbook = new javax.swing.JTable();
        searchbtn = new javax.swing.JButton();
        searchbox = new javax.swing.JTextField();
        searchcat = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Read Guest");
        setResizable(false);

        jLabel1.setText("READ TABLE");

        tblGuestbook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "CONTACT NO", "EMAIL ADD", "GENDER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGuestbook.setEnabled(false);
        jScrollPane1.setViewportView(tblGuestbook);

        searchbtn.setText("SEARCH");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });

        searchcat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "NAME", "CONTACT NO", "EMAIL ADD", "GENDER" }));
        searchcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchcatActionPerformed(evt);
            }
        });

        jButton1.setText("x");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(jLabel1)
                                .addGap(0, 200, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchcat, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchbtn)
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchbtn)
                    .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(480, 451));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        
public String[][] search(String table,String scombo) throws SQLException{
       String[][] records = null;
        try{
               
    {SQLite.stmt = conn.createStatement();
            
   
            //Count total rows
            System.out.println(scombo);
            String db_name = "name like '%"+ searchbox.getSelectedText() +"%' order by desc";
            String db_id = " id ="+ searchbox.getSelectedText() +" order by desc";
            String db_contactno ="contactno like '%"+ searchbox.getSelectedText() +"%' order by desc";
            String db_emailadd = "email like'%"+ searchbox.getSelectedText() +"%' order by desc";
            String db_gender ="like '"+ searchbox.getSelectedText() +"' order by desc";
            int totalRows = 0;
            if (scombo == "NAME"){
                 rs = stmt.executeQuery("SELECT count(*) FROM task WHERE "+db_name);
                totalRows = rs.getInt(1);
            }
            else if (scombo == "ID"){
                 rs = stmt.executeQuery("SELECT count(*) FROM task WHERE" +db_id);
                 totalRows = rs.getInt(1);
            }
            else if (scombo == "CONTACT NO"){
                 rs = stmt.executeQuery("SELECT count(*) FROM task WHERE " + db_contactno);
                 totalRows = rs.getInt(1);
            }
            else if (scombo == "EMAIL ADD"){
                 rs = stmt.executeQuery("SELECT count(*) FROM task WHERE "+db_emailadd);
                 totalRows = rs.getInt(1);
            }
            else if (scombo == "GENDER"){
                 rs = stmt.executeQuery("SELECT count(*) FROM task WHERE "+db_gender);
                 totalRows = rs.getInt(1);
            }
            
            
            //ID, NAME, CONTACT NO, EMAIL ADD, GENDER

            //Count total columns
            int totalColumns = 0;
                        if (scombo == "NAME"){
                 rs = stmt.executeQuery("SELECT * FROM task WHERE "+db_name);
                ResultSetMetaData rsmd = rs.getMetaData();
                totalColumns = rsmd.getColumnCount();
            }
            else if (scombo == "ID"){
                 rs = stmt.executeQuery("SELECT * FROM task WHERE" +db_id);
                 ResultSetMetaData rsmd = rs.getMetaData();
                totalColumns = rsmd.getColumnCount();
            }
            else if (scombo == "CONTACT NO"){
                 rs = stmt.executeQuery("SELECT * FROM task WHERE " + db_contactno);
                 ResultSetMetaData rsmd = rs.getMetaData();
               totalColumns = rsmd.getColumnCount();
            }
            else if (scombo == "EMAIL ADD"){
                 rs = stmt.executeQuery("SELECT * FROM task WHERE "+db_emailadd);
                 ResultSetMetaData rsmd = rs.getMetaData();
                totalColumns = rsmd.getColumnCount();
            }
            else if (scombo == "GENDER"){
                 rs = stmt.executeQuery("SELECT * FROM task WHERE "+db_gender);
                 ResultSetMetaData rsmd = rs.getMetaData();
                 totalColumns = rsmd.getColumnCount();

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }  

        }}       
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }
    
private void searchcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchcatActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_searchcatActionPerformed

private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
// TODO add your handling code here:
    
    
}//GEN-LAST:event_searchboxActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        // TODO add your handling code here:
           String scombo = searchcat.getSelectedItem().toString();
           System.out.println(scombo);
            String[][] data = null;
        if(SQLite.openDB()){
            if(scombo == "ID"){
                data = SQLite.readID("task", Integer.parseInt(searchbox.getText()));
            }
            else if(scombo == "NAME"){
                data = SQLite.readName("task", (searchbox.getText()));
            }
            else if(scombo == "CONTACT NO"){
                data = SQLite.readContactNO("task", searchbox.getText());
            }
            else if(scombo == "EMAIL ADD"){
                data = SQLite.readEmail("task", searchbox.getText());
            }
            else if(scombo == "GENDER"){
                data = SQLite.readGender("task", searchbox.getText());
            }
            else{
                data = SQLite.read("task");
            }
            String[] column = {"ID", "NAME","CONTACT NO","EMAIL ADD","GENDER"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblGuestbook.setModel(model);
            SQLite.closeDB();
        }
    }//GEN-LAST:event_searchbtnActionPerformed

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
  
        
    }//GEN-LAST:event_searchboxKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(SQLite.openDB()){
            String[][] data = SQLite.read("task");
            
            String[] column = {"ID", "NAME","CONTACT NO","EMAIL ADD","GENDER"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblGuestbook.setModel(model);
            SQLite.closeDB();
        } 
        searchbox.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed
public static String[][] read(String table){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();

            //Count total rows
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table);
            int totalRows = rs.getInt(1);

            //Count total columns
            rs = stmt.executeQuery("SELECT * FROM " + table);
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }


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
            java.util.logging.Logger.getLogger(FrmReadGuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReadGuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReadGuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReadGuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmReadGuest().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchbox;
    private javax.swing.JButton searchbtn;
    private javax.swing.JComboBox searchcat;
    private javax.swing.JTable tblGuestbook;
    // End of variables declaration//GEN-END:variables
}

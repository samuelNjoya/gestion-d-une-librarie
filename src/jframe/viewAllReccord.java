/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samuel Njoya
 */
public class viewAllReccord extends javax.swing.JFrame {

    DefaultTableModel model;
    
    public viewAllReccord() {
        initComponents();
        setViewAllReccordTable();
    }
    
    
  public void setViewAllReccordTable(){
       try {
            Connection con = DBconnexion.getConnection();
            String sql = "select * from issue_book";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
               
                String Id = rs.getString("id");
                String BookName = rs.getString("name_book");
                String StudentName = rs.getString("name_student");
                Date issueDate = rs.getDate("issue_date");
                Date dueDate = rs.getDate("due_date");
                String statut = rs.getString("statut");
                
                Object[] obj = {Id,BookName,StudentName,issueDate,dueDate,statut};
                model = (DefaultTableModel) tbl_ViewAllReccord.getModel();
                model.addRow(obj);
               
           }
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
   }
  //Pour eviter les redondances d'informations
     public void clearTable(){
       DefaultTableModel model = (DefaultTableModel) tbl_ViewAllReccord.getModel();
       model.setRowCount(0);
       
   }
     
      public boolean search(){
          
          boolean isIssueBook = false;
          
          
          java.util.Date uFromDate = date_from_date.getDate();
          java.util.Date uToDate = date_to_date.getDate();
          
          Long l1 = uFromDate.getTime();
          Long l2 = uToDate.getTime();
          
          java.sql.Date fromDate = new  java.sql.Date(l1);
          java.sql.Date toDate = new  java.sql.Date(l2);
          
      
        
        try 
        {
            Connection con = DBconnexion.getConnection();
            String sql = "select * from issue_book where issue_date between ? and ?"; // ceci aussi marche
            //String sql = "select * from issue_book where issue_date >= ? and due_date <= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            
            ps.setDate(1, fromDate);
            ps.setDate(2, toDate);
           
         ResultSet rs =   ps.executeQuery();
          
            if(rs.next() == false){
                JOptionPane.showMessageDialog(this, "Request not found");
            }else{
                while(rs.next()) {
                String Id = rs.getString("id");
                String BookName = rs.getString("name_book");
                String StudentName = rs.getString("name_student");
                Date issueDate = rs.getDate("issue_date");
                Date dueDate = rs.getDate("due_date");
                String statut = rs.getString("statut");
                
                Object[] obj = {Id,BookName,StudentName,issueDate,dueDate,statut};
                model = (DefaultTableModel) tbl_ViewAllReccord.getModel();
                model.addRow(obj);
            }
            }
            
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
          
        return isIssueBook;
      }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ViewAllReccord = new rojerusan.RSTableMetro();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        date_from_date = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        date_to_date = new com.toedter.calendar.JDateChooser();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_ViewAllReccord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "NameBook", "NameStudent", "IssueDate", "DueDate", "Statut"
            }
        ));
        tbl_ViewAllReccord.setColorBackgoundHead(new java.awt.Color(50, 100, 255));
        tbl_ViewAllReccord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ViewAllReccordMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_ViewAllReccord);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 890, 340));

        jPanel1.setBackground(new java.awt.Color(50, 100, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 450, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel16.setText("View All Reccord");
        jLabel16.setName(""); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 320, 70));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("BACK");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 30));

        jPanel5.setBackground(new java.awt.Color(255, 102, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("x");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("Issue_Date");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        date_from_date.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.add(date_from_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 150, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setText("Due_Date");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        date_to_date.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.add(date_to_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 150, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 102, 0));
        rSMaterialButtonCircle1.setText("Search");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 180, 50));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 102, 0));
        rSMaterialButtonCircle2.setText("All");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, 150, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 230));

        setSize(new java.awt.Dimension(1100, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_ViewAllReccordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ViewAllReccordMouseClicked

     /*   int rowNo = tbl_bookDetail.getSelectedRow();
        TableModel model = tbl_bookDetail.getModel();

        txt_book_id.setText(model.getValueAt(rowNo, 0).toString());
        txt_book_name.setText(model.getValueAt(rowNo, 1).toString());
        txt_book_author.setText(model.getValueAt(rowNo, 2).toString());
        txt_book_quantirty.setText(model.getValueAt(rowNo, 3).toString());

        btn_add.setEnabled(false);
        btn_delete.setEnabled(true);
        btn_updape.setEnabled(true);*/
    }//GEN-LAST:event_tbl_ViewAllReccordMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Home hm = new Home();
        hm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed

       if(date_from_date.getDate() != null && date_to_date.getDate() != null){
            clearTable();
              search();
       }else{
           JOptionPane.showMessageDialog(this, "Please enter the date");
       }
      

    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
       clearTable();
       setViewAllReccordTable();
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(viewAllReccord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewAllReccord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewAllReccord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewAllReccord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewAllReccord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser date_from_date;
    private com.toedter.calendar.JDateChooser date_to_date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSTableMetro tbl_ViewAllReccord;
    // End of variables declaration//GEN-END:variables
}

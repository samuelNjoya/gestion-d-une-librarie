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

/**
 *
 * @author samuel Njoya
 */
public class retourBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public retourBook() {
        initComponents();
    }

  
      
      //Updating CountBook
      public void updatingCountBook(){
          String id_Book = txt_Book_id.getText();
          
          try {
              
            Connection con = DBconnexion.getConnection();
            String sql = "update manage_book set quantity = quantity + 1 where id_book = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, id_Book);
          
            
          int RowCount =   ps.executeUpdate();
          
          if(RowCount>0){
             JOptionPane.showMessageDialog(this, "Book count updating");
           
          }else{
              JOptionPane.showMessageDialog(this, "Book count not updating");
          }
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(this, e);
          }
      }
      
       public void getIssueDetail(){
       String studentId = txt_student_id.getText();
       String bookId = txt_Book_id.getText();
       
       try {
            Connection con = DBconnexion.getConnection();
            String sql = "select * from issue_book where id_book = ? and id_student= ? and statut=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, bookId);
            ps.setString(2, studentId);
            ps.setString(3, "pending");
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                lbl_id_Issuebook.setText(rs.getString("id"));
                lbl_name_student.setText(rs.getString("name_student"));
                lbl_name_book.setText(rs.getString("name_book"));
                lbl_Issue_date.setText(rs.getString("issue_date"));
                lbl_due_date.setText(rs.getString("due_date"));
            }else{
                JOptionPane.showMessageDialog(this, "No reccord fund");
                 lbl_id_Issuebook.setText("");
                lbl_name_student.setText("");
                lbl_name_book.setText("");
                lbl_Issue_date.setText("");
                lbl_due_date.setText("");
                lbl_error.setText("Reccord not found");
            }
            
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
   }
    
       
        public boolean returnBook(){
          boolean isReturned = false;
       String studentId = txt_student_id.getText();
       String bookId = txt_Book_id.getText();
       
       try {
            Connection con = DBconnexion.getConnection();
            String sql = "update issue_book set statut=? where id_student= ? and  id_book = ? and statut=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, "returned");
            ps.setString(2, studentId);
            ps.setString(3, bookId);
            ps.setString(4, "pending");
            
            int row = ps.executeUpdate();
            
            if(row > 0){
                isReturned = true;
            }else{
               isReturned = false;
            }
            
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
       
       return isReturned;
   }
      
      
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        main_panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_name_student = new javax.swing.JLabel();
        lbl_id_Issuebook = new javax.swing.JLabel();
        lbl_name_book = new javax.swing.JLabel();
        lbl_Issue_date = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbl_error = new javax.swing.JLabel();
        lbl_due_date = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        txt_Book_id = new javax.swing.JTextField();
        txt_student_id = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel17.setText("BACK");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 102, 0));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("x");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name Student");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name Book");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Issue_Date");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        lbl_name_student.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_name_student.setForeground(new java.awt.Color(255, 255, 255));
        lbl_name_student.setText("Name Student");
        jPanel1.add(lbl_name_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));

        lbl_id_Issuebook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_id_Issuebook.setForeground(new java.awt.Color(255, 255, 255));
        lbl_id_Issuebook.setText("Id Issue");
        jPanel1.add(lbl_id_Issuebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        lbl_name_book.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_name_book.setForeground(new java.awt.Color(255, 255, 255));
        lbl_name_book.setText("Name Book");
        jPanel1.add(lbl_name_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, 50));

        lbl_Issue_date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Issue_date.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Issue_date.setText("Issue_Date");
        jPanel1.add(lbl_Issue_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel16.setText("Book Detail");
        jLabel16.setName(""); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 250, 70));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Id Issue");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        lbl_error.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_error.setForeground(new java.awt.Color(255, 255, 255));
        lbl_error.setText("Due_Date");
        jPanel1.add(lbl_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, -1, -1));

        lbl_due_date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_due_date.setForeground(new java.awt.Color(255, 255, 255));
        lbl_due_date.setText("Due_Date");
        jPanel1.add(lbl_due_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Due_Date");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        main_panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 390, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Student_id");
        main_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setText("Book_Id");
        main_panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 180, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(50, 100, 255));
        rSMaterialButtonCircle1.setText("Find");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        main_panel.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 410, 220, 60));

        txt_Book_id.setBackground(new java.awt.Color(255, 102, 0));
        txt_Book_id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Book_id.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        txt_Book_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_Book_idFocusLost(evt);
            }
        });
        main_panel.add(txt_Book_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 180, 160, 30));

        txt_student_id.setBackground(new java.awt.Color(255, 102, 0));
        txt_student_id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_student_id.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        txt_student_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_student_idFocusLost(evt);
            }
        });
        main_panel.add(txt_student_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 240, 160, 30));

        jLabel12.setBackground(new java.awt.Color(255, 102, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 102, 0));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Book_50px_1.png"))); // NOI18N
        jLabel12.setText("Return Book ");
        jLabel12.setName(""); // NOI18N
        main_panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 50, 250, 70));

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        main_panel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 130, 310, 10));

        jPanel11.setBackground(new java.awt.Color(255, 102, 0));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("x");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        main_panel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 50, 40));

        jPanel9.setBackground(new java.awt.Color(50, 100, 255));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel19.setText("BACK");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        main_panel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-2.png"))); // NOI18N
        main_panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 30, 460, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 102, 0));
        rSMaterialButtonCircle2.setText("Return Book");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        main_panel.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, 220, 60));

        getContentPane().add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Book_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Book_idFocusLost
        //focus lost
    
    }//GEN-LAST:event_txt_Book_idFocusLost

    private void txt_student_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_idFocusLost
     
    }//GEN-LAST:event_txt_student_idFocusLost

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        getIssueDetail();
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        Home hm = new Home();
        hm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        Home hm = new Home();
        hm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
       if(returnBook() == true){
           JOptionPane.showMessageDialog(this, "book returnet");
           updatingCountBook();
       }else{
           JOptionPane.showMessageDialog(this, "Book not returned");
       }
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
            java.util.logging.Logger.getLogger(retourBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(retourBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(retourBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(retourBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new retourBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_Issue_date;
    private javax.swing.JLabel lbl_due_date;
    private javax.swing.JLabel lbl_error;
    private javax.swing.JLabel lbl_id_Issuebook;
    private javax.swing.JLabel lbl_name_book;
    private javax.swing.JLabel lbl_name_student;
    private javax.swing.JPanel main_panel;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private javax.swing.JTextField txt_Book_id;
    private javax.swing.JTextField txt_student_id;
    // End of variables declaration//GEN-END:variables
}

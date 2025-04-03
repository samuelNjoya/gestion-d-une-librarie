
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author samuel Njoya
 */
public class ManageStudent extends javax.swing.JFrame {

    DefaultTableModel model;
 
    public ManageStudent() {
        initComponents();
        setDetailStudentTable();
        
       //Enable and disable button 
       btn_add.setEnabled(true);
       btn_delete.setEnabled(false);
       btn_updape.setEnabled(false);
       
       txt_Student_id.setEditable(false);
    }

   public void setDetailStudentTable(){
       try {
            Connection con = DBconnexion.getConnection();
            String sql = "select * from manage_student";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
               
                String studentId = rs.getString("id_student");
                String studentName = rs.getString("name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");
                
                Object[] obj = {studentId,studentName,course,branch};
                model = (DefaultTableModel) tbl_StudentDetail.getModel();
                model.addRow(obj);
               
           }
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
   }
   
   public  void addStudent(){
       
       // String id = txt_student_id.getText();
        String name = txt_Student_name.getText();
        String course = cmb_Student_course.getSelectedItem().toString();
        String branch = cmb_Student_branch.getSelectedItem().toString();
        
        try 
        {
            Connection con = DBconnexion.getConnection();
            String sql = "insert into manage_student(name,course,branch) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, course);
            ps.setString(3, branch);
          //  ps.setString(4, contact);
            
          int UpdatedRowCount =   ps.executeUpdate();
          
          if(UpdatedRowCount>0){
              JOptionPane.showMessageDialog(this, "ajouter avec success");
          }else{
              JOptionPane.showMessageDialog(this, "erreur lors de l'ajout");
          }
            txt_Student_name.setText(""); //cmb_Student_course.getSelectedItem(); cmb_Student_branch.setText(""); 
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
   }
   
   
   //Clear table pour eviter la redondendanc des données dans le tableau
   public void clearTable(){
       DefaultTableModel model = (DefaultTableModel) tbl_StudentDetail.getModel();
       model.setRowCount(0);
       
   }
   
   public boolean vallidationAddStudent(){
        
         String name = txt_Student_name.getText();
        String course = cmb_Student_course.getSelectedItem().toString();
        String branch = cmb_Student_branch.getSelectedItem().toString();
       
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(this, "please enter the Name");
            return  false;
        }
        
         if(course.equals("")){
            JOptionPane.showMessageDialog(this, "please enter the author");
            return  false;
        }
         
         if(branch.equals("")){
            JOptionPane.showMessageDialog(this, "please enter the quantity");
            return  false;
        }
        
        
        return true;
    }
   
   
   public  void updateStudent(){
         // Update
        String id = txt_Student_id.getText();
        String name = txt_Student_name.getText();
        String course = cmb_Student_course.getSelectedItem().toString();
        String branch = cmb_Student_branch.getSelectedItem().toString();
        
         try 
        {
        
        Connection con = DBconnexion.getConnection();
            String sql = "update manage_student set name=?,course=?,branch=? where id_student=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, course);
            ps.setString(3, branch);
         
        
      
           ps.setString(4, id);
           ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "update successfuly");
      }
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(this, e);
      }
   }
   
    public  void deleteStudent(){
         // Update
        String id = txt_Student_id.getText();
        
         try 
        {
        
        Connection con = DBconnexion.getConnection();
            String sql = "delete from manage_student where id_student=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
           ps.setString(1, id);
           ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "delete successfuly");
      }
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(this, e);
      }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_Student_id = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_updape = new rojerusan.RSMaterialButtonCircle();
        btn_delete = new rojerusan.RSMaterialButtonCircle();
        btn_add = new rojerusan.RSMaterialButtonCircle();
        txt_Student_name = new javax.swing.JTextField();
        cmb_Student_branch = new javax.swing.JComboBox<>();
        cmb_Student_course = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_StudentDetail = new rojerusan.RSTableMetro();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(50, 100, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        txt_Student_id.setBackground(new java.awt.Color(50, 100, 255));
        txt_Student_id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Student_id.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        txt_Student_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_Student_idFocusLost(evt);
            }
        });
        jPanel1.add(txt_Student_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 240, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Id Student");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 50, 40));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 50, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name Student");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 40, 40));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 50, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Branch");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Course");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        btn_updape.setBackground(new java.awt.Color(255, 102, 0));
        btn_updape.setText("update");
        btn_updape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updapeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_updape, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 120, 50));

        btn_delete.setBackground(new java.awt.Color(255, 102, 0));
        btn_delete.setText("delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 120, 50));

        btn_add.setBackground(new java.awt.Color(255, 102, 0));
        btn_add.setText("add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 120, 50));

        txt_Student_name.setBackground(new java.awt.Color(50, 100, 255));
        txt_Student_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Student_name.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        txt_Student_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_Student_nameFocusLost(evt);
            }
        });
        jPanel1.add(txt_Student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 240, 30));

        cmb_Student_branch.setEditable(true);
        cmb_Student_branch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmb_Student_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmb_Student_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 240, -1));

        cmb_Student_course.setEditable(true);
        cmb_Student_course.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmb_Student_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmb_Student_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 240, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_StudentDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Course", "Branch"
            }
        ));
        tbl_StudentDetail.setColorBackgoundHead(new java.awt.Color(50, 100, 255));
        tbl_StudentDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_StudentDetailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_StudentDetail);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 172, -1, 340));

        jLabel9.setBackground(new java.awt.Color(255, 102, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel9.setText("Student Manager");
        jLabel9.setName(""); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 320, 80));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

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

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 310, 10));

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

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Home hm = new Home();
        hm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_Student_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Student_idFocusLost
        //focus lost
      /*  if(checkDuplicateUser() == true){
            JOptionPane.showMessageDialog(this, "ce nom existe deja");
        }*/

    }//GEN-LAST:event_txt_Student_idFocusLost

    private void btn_updapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updapeActionPerformed
   //  if(vallidationAddBook()){
          updateStudent();
          
           // after update the  book clear the table then actualizate the table
             clearTable();
             setDetailStudentTable();
   //  }
    }//GEN-LAST:event_btn_updapeActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
       deleteStudent();
       
        // after delete the book clear the table then actualizate the table
             clearTable();
             setDetailStudentTable();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
       
       // if(vallidationAddStudent()){
             addStudent();
             
             // after add the new book clear the table then actualizate the table
             clearTable();
             setDetailStudentTable();
      //  }
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_Student_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Student_nameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Student_nameFocusLost

    private void tbl_StudentDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_StudentDetailMouseClicked
        
       int rowNo = tbl_StudentDetail.getSelectedRow();
       TableModel model = tbl_StudentDetail.getModel();
       
       txt_Student_id.setText(model.getValueAt(rowNo, 0).toString());
       txt_Student_name.setText(model.getValueAt(rowNo, 1).toString());
       cmb_Student_course.setSelectedItem(model.getValueAt(rowNo, 2).toString());
       cmb_Student_branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
        
       btn_add.setEnabled(false);
       btn_delete.setEnabled(true);
       btn_updape.setEnabled(true);
    }//GEN-LAST:event_tbl_StudentDetailMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btn_add;
    private rojerusan.RSMaterialButtonCircle btn_delete;
    private rojerusan.RSMaterialButtonCircle btn_updape;
    private javax.swing.JComboBox<String> cmb_Student_branch;
    private javax.swing.JComboBox<String> cmb_Student_course;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSTableMetro tbl_StudentDetail;
    private javax.swing.JTextField txt_Student_id;
    private javax.swing.JTextField txt_Student_name;
    // End of variables declaration//GEN-END:variables
}

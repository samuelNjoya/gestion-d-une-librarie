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
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }

   public void getBookDetail(){
       String bookId = txt_Book_id.getText();
       
       try {
            Connection con = DBconnexion.getConnection();
            String sql = "select * from manage_book where id_book= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, bookId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                lbl_id_book.setText(rs.getString("id_book"));
                lbl_name_book.setText(rs.getString("name"));
                lbl_Author_book.setText(rs.getString("author"));
                lbl_quantity_book.setText(rs.getString("quantity"));
            }else{
                JOptionPane.showMessageDialog(this, "This Book id is invalide");
            }
            
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
   }
   
      public void getStudentDetail(){
       String studentId = txt_student_id.getText();
       
       try {
            Connection con = DBconnexion.getConnection();
            String sql = "select * from manage_student where id_student= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, studentId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                lbl_id_student.setText(rs.getString("id_student"));
                lbl_name_student.setText(rs.getString("name"));
                lbl_course_student.setText(rs.getString("course"));
                lbl_branch_student.setText(rs.getString("branch"));
            }else{
                JOptionPane.showMessageDialog(this, "This Student id is invalide");
            }
            
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
   }
      
      //Updating CountBook
      public void updatingCountBook(){
          String id_Book = txt_Book_id.getText();
          
          try {
              
            Connection con = DBconnexion.getConnection();
            String sql = "update manage_book set quantity = quantity - 1 where id_book = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, id_Book);
          
            
          int RowCount =   ps.executeUpdate();
          
          if(RowCount>0){
             JOptionPane.showMessageDialog(this, "Book count updating");
             int initialCount = Integer.parseInt(lbl_quantity_book.getText());
             lbl_quantity_book.setText(Integer.toString(initialCount - 1));
          }else{
              JOptionPane.showMessageDialog(this, "Book count not updating");
          }
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(this, e);
          }
      }
      
      
       //Updating CountBook
      public Boolean AlreadyExistBookStudent(){
          
          boolean alreadyIssued = false;
          
        String id_B = lbl_id_book.getText();
        String id_S = lbl_id_student.getText();
          
          try {
              
            Connection con = DBconnexion.getConnection();
            String sql = "select * from issue_book where id_book = ? and id_student = ? and statut = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, id_B);
            ps.setString(2, id_S);
            ps.setString(3, "pending");
          
            
          ResultSet rs =   ps.executeQuery();
          
          if(rs.next()){
             alreadyIssued = true;
          }else{
              alreadyIssued = false;
          }
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(this, e);
          }
          
          return  alreadyIssued;
      }
      
      public boolean insertIssueBook(){
          
          boolean isIssueBook = false;
          
          
          java.util.Date ussiDate = issue_date.getDate();
          java.util.Date dueDate = due_date.getDate();
          
          Long l1 = ussiDate.getTime();
          Long l2 = dueDate.getTime();
          
          java.sql.Date sisussiDate = new  java.sql.Date(l1);
          java.sql.Date sisdueDate = new  java.sql.Date(l2);
          
        String id_B = lbl_id_book.getText();
        String name_B = lbl_name_book.getText();
        String id_S = lbl_id_student.getText();
        String name_S = lbl_name_student.getText();
        
        try 
        {
            Connection con = DBconnexion.getConnection();
            String sql = "insert into issue_book(id_book,name_book,id_student,name_student,issue_date,due_date,statut) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, id_B);
            ps.setString(2, name_B);
            ps.setString(3, id_S);
            ps.setString(4, name_S);
            ps.setDate(5, sisussiDate);
            ps.setDate(6, sisdueDate);
            ps.setString(7, "Pending");
            
          int RowCount =   ps.executeUpdate();
          
          if(RowCount>0){
              isIssueBook = true;
          }else{
              isIssueBook = false;
          }
          //  txt_book_name.setText(""); txt_book_author.setText(""); txt_book_quantirty.setText(""); 
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
          
        return isIssueBook;
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
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_Author_book = new javax.swing.JLabel();
        lbl_id_book = new javax.swing.JLabel();
        lbl_name_book = new javax.swing.JLabel();
        lbl_quantity_book = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_id_student = new javax.swing.JLabel();
        lbl_name_student = new javax.swing.JLabel();
        lbl_course_student = new javax.swing.JLabel();
        lbl_branch_student = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        due_date = new com.toedter.calendar.JDateChooser();
        issue_date = new com.toedter.calendar.JDateChooser();
        txt_Book_id = new javax.swing.JTextField();
        txt_student_id = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();

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
        jLabel3.setText("Author");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Id Book");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name Book");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantity");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        lbl_Author_book.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Author_book.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Author_book.setText("Author");
        jPanel1.add(lbl_Author_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));

        lbl_id_book.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_id_book.setForeground(new java.awt.Color(255, 255, 255));
        lbl_id_book.setText("Id Book");
        jPanel1.add(lbl_id_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        lbl_name_book.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_name_book.setForeground(new java.awt.Color(255, 255, 255));
        lbl_name_book.setText("Name Book");
        jPanel1.add(lbl_name_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, 50));

        lbl_quantity_book.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_quantity_book.setForeground(new java.awt.Color(255, 255, 255));
        lbl_quantity_book.setText("Quantity");
        jPanel1.add(lbl_quantity_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

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

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        main_panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 600));

        jPanel2.setBackground(new java.awt.Color(50, 100, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Id Student");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Name Student");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Course");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Branch");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        lbl_id_student.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_id_student.setForeground(new java.awt.Color(255, 255, 255));
        lbl_id_student.setText("Id Student");
        jPanel2.add(lbl_id_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        lbl_name_student.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_name_student.setForeground(new java.awt.Color(255, 255, 255));
        lbl_name_student.setText("Name Student");
        jPanel2.add(lbl_name_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, 50));

        lbl_course_student.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_course_student.setForeground(new java.awt.Color(255, 255, 255));
        lbl_course_student.setText("Course");
        jPanel2.add(lbl_course_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        lbl_branch_student.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_branch_student.setForeground(new java.awt.Color(255, 255, 255));
        lbl_branch_student.setText("Branch");
        jPanel2.add(lbl_branch_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, -1, -1));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 130, 310, 10));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 102, 0));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel14.setText("Issue Book ");
        jLabel14.setName(""); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 250, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel15.setText("Student Detail");
        jLabel15.setName(""); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 280, 70));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jPanel10.setBackground(new java.awt.Color(255, 102, 0));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("x");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 40, -1));

        main_panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 390, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Student_id");
        main_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("Issue_Date");
        main_panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("Due_Date");
        main_panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 400, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setText("Book_Id");
        main_panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 180, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 102, 0));
        rSMaterialButtonCircle1.setText("Issue Book");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        main_panel.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, 220, 60));

        due_date.setBackground(new java.awt.Color(255, 102, 0));
        main_panel.add(due_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 400, 150, -1));

        issue_date.setBackground(new java.awt.Color(255, 102, 0));
        main_panel.add(issue_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 320, 150, -1));

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
        jLabel12.setText("Issue Book ");
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

        getContentPane().add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Book_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Book_idFocusLost
        //focus lost
        if(!txt_Book_id.getText().equals("")){
            getBookDetail();
        }
    }//GEN-LAST:event_txt_Book_idFocusLost

    private void txt_student_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_idFocusLost
       if(!txt_student_id.getText().equals("")){
           getStudentDetail();
       }
    }//GEN-LAST:event_txt_student_idFocusLost

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed

        if(lbl_quantity_book.getText().equals("0")){
            JOptionPane.showMessageDialog(this, "This book is not available");
        }else{
            if(AlreadyExistBookStudent() == false){
            
           if( insertIssueBook() == true){
                JOptionPane.showMessageDialog(this, "Insert succesfull");
               updatingCountBook();
           }else{
              JOptionPane.showMessageDialog(this, "can't Insert succesfull");
          }
        }else{
           JOptionPane.showMessageDialog(this, "student is already have this book");
        }
        }
        
      
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

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel21MouseClicked

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser due_date;
    private com.toedter.calendar.JDateChooser issue_date;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_Author_book;
    private javax.swing.JLabel lbl_branch_student;
    private javax.swing.JLabel lbl_course_student;
    private javax.swing.JLabel lbl_id_book;
    private javax.swing.JLabel lbl_id_student;
    private javax.swing.JLabel lbl_name_book;
    private javax.swing.JLabel lbl_name_student;
    private javax.swing.JLabel lbl_quantity_book;
    private javax.swing.JPanel main_panel;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private javax.swing.JTextField txt_Book_id;
    private javax.swing.JTextField txt_student_id;
    // End of variables declaration//GEN-END:variables
}

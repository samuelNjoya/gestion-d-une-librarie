/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author samuel Njoya
 */
public class Home extends javax.swing.JFrame {

    
    Color mouseEnterColor = new  Color(0,0,255);
    Color mouseExitColor = new  Color(0,0,0);
    DefaultTableModel model;

  
    public Home() {
        initComponents();
        showPieChart();
        setDetailBookTable();
        setDetailStudentTable();
        
        setDataToCard();
      
    }
    
    //Detail Book
    public void setDetailBookTable(){
       try {
            Connection con = DBconnexion.getConnection();
            String sql = "select * from manage_book";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
               
                String BookId = rs.getString("id_book");
                String BookName = rs.getString("name");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                
                Object[] obj = {BookId,BookName,author,quantity};
                model = (DefaultTableModel) tbl_bookDetail.getModel();
                model.addRow(obj);
               
           }
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
   }
    
    //Manage Student
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

     //Methode Count 
      public void setDataToCard(){
          
         long l = System.currentTimeMillis();
         Date todaysDate = new Date(l);
          
         PreparedStatement ps = null;
         ResultSet rs = null;
          
       try {
           
            Connection con = DBconnexion.getConnection();
            
          
            ps = con.prepareStatement("select count(*) from manage_book");
            rs = ps.executeQuery();
            rs.next();
            int nbBook = rs.getInt(1);
            lbl_nbr_book.setText(Integer.toString(nbBook));
            
           
            ps = con.prepareStatement("select count(*) from manage_student");
            rs = ps.executeQuery();
            rs.next();
            int nbStudent = rs.getInt(1);
            lbl_nbr_student.setText(Integer.toString(nbStudent));
            
            ps = con.prepareStatement("select count(*) from issue_book");
            rs = ps.executeQuery();
            rs.next();
            int nbIssueB = rs.getInt(1);
            lbl_issue_book.setText(Integer.toString(nbIssueB));
            
            ps = con.prepareStatement("select count(*) from issue_book where due_date < '"+todaysDate+"' and statut = '"+"pending"+"'");
            rs = ps.executeQuery();
            rs.next();
            int nbDefaulL = rs.getInt(1);
            lbl_default_list.setText(Integer.toString(nbDefaulL));
         
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
   }
      
    
      
   public void showPieChart(){
       // created dataset
       DefaultPieDataset barDataSet = new DefaultPieDataset();
      /* barDataSet.setValue("Iphone 5s", new Double(20));
       barDataSet.setValue("Ip 5s", new Double(20));
       barDataSet.setValue("Moto 5s", new Double(40));
       barDataSet.setValue("Iphon 5s", new Double(10));*/
      //Manage Student
    
       try {
            Connection con = DBconnexion.getConnection();
            String sql = "select name_book, count(*) as issue_count from issue_book group by id_book";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
               barDataSet.setValue(rs.getString("name_book"), new Double(rs.getDouble("issue_count")));
           }
            
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e);
       }
   
       
       //create chart
       JFreeChart piechart = ChartFactory.createPieChart("issue_book",barDataSet, true,true,false);
       
       PiePlot piePlot = (PiePlot) piechart.getPlot();
       
       // charging piechart.block.colors
       piePlot.setSectionPaint("Iphone 5s", new Color(255,255,102));
       piePlot.setSectionPaint("Ip 5s", new Color(25,55,102));
       piePlot.setSectionPaint("Moto 5s", new Color(255,23,102));
       piePlot.setSectionPaint("Iphon 5s", new Color(102,255,102));
       
       piePlot.setBackgroundPaint(Color.white);
       
       //create chartpanel to display ChartGraph
       ChartPanel barChartPanel = new ChartPanel(piechart);
       panelBarChart.removeAll();
       panelBarChart.add(barChartPanel, BorderLayout.CENTER);
       panelBarChart.validate();
   }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel69 = new javax.swing.JPanel();
        lbl_default_list = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        lbl_nbr_student = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        lbl_nbr_book = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        lbl_issue_book = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        panelBarChart = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_bookDetail = new rojerusan.RSTableMetro();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_StudentDetail = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1400, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(50, 100, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1400, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 10, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel3.setText("welcome");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, -1, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SMART LIBRARY");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, 50));

        jPanel73.setBackground(new java.awt.Color(255, 102, 0));

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("x");
        jLabel78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel78MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel73Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 10, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 60));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(50, 100, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px.png"))); // NOI18N
        jLabel1.setText("    Logout");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel10.setBackground(new java.awt.Color(255, 0, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel10.setText("    Home Page");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel11.setBackground(new java.awt.Color(255, 0, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel11.setText("    Home Page");
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel12.setBackground(new java.awt.Color(255, 0, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel12.setText("    Home Page");
        jPanel12.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel4.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel17.setBackground(new java.awt.Color(255, 0, 51));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel17.setText("    Home Page");
        jPanel17.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel18.setBackground(new java.awt.Color(255, 0, 51));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel18.setText("    Home Page");
        jPanel18.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel19.setBackground(new java.awt.Color(255, 0, 51));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel19.setText("    Home Page");
        jPanel19.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel20.setBackground(new java.awt.Color(255, 0, 51));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel20.setText("    Home Page");
        jPanel20.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel17.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel4.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 280, 41));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 280, 41));

        jPanel6.setBackground(new java.awt.Color(255, 102, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel6.setText("    Home Page");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 280, 41));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel7.setText("    Dashboard");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 280, 41));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel8.setText("    Manage Books");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 40));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 280, 41));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel9.setText("    Manage Students");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 280, 41));

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel13.setText("   Issue Books");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jPanel13.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 180, 30));

        jPanel14.setBackground(new java.awt.Color(255, 0, 51));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel14.setText("    Home Page");
        jPanel14.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel15.setBackground(new java.awt.Color(255, 0, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel15.setText("    Home Page");
        jPanel15.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel16.setBackground(new java.awt.Color(255, 0, 51));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel16.setText("    Home Page");
        jPanel16.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel21.setBackground(new java.awt.Color(0, 0, 0));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel21.setText("   Return Books\n");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });
        jPanel21.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 40));

        jPanel22.setBackground(new java.awt.Color(255, 0, 51));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel22.setText("    Home Page");
        jPanel22.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel21.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel23.setBackground(new java.awt.Color(255, 0, 51));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel23.setText("    Home Page");
        jPanel23.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel24.setBackground(new java.awt.Color(255, 0, 51));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel24.setText("    Home Page");
        jPanel24.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel21.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel25.setBackground(new java.awt.Color(255, 0, 51));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel25.setText("    Home Page");
        jPanel25.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel26.setBackground(new java.awt.Color(255, 0, 51));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel26.setText("    Home Page");
        jPanel26.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel25.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel27.setBackground(new java.awt.Color(255, 0, 51));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel27.setText("    Home Page");
        jPanel27.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel28.setBackground(new java.awt.Color(255, 0, 51));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel28.setText("    Home Page");
        jPanel28.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel27.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel25.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel21.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 280, 41));

        jPanel3.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 280, 41));

        jPanel29.setBackground(new java.awt.Color(0, 0, 0));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel29.setText("    View Reccords");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
        });
        jPanel29.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        jPanel30.setBackground(new java.awt.Color(255, 0, 51));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel30.setText("    Home Page");
        jPanel30.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel29.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel31.setBackground(new java.awt.Color(255, 0, 51));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel31.setText("    Home Page");
        jPanel31.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel32.setBackground(new java.awt.Color(255, 0, 51));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel32.setText("    Home Page");
        jPanel32.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel31.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel29.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel33.setBackground(new java.awt.Color(255, 0, 51));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel33.setText("    Home Page");
        jPanel33.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel34.setBackground(new java.awt.Color(255, 0, 51));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel34.setText("    Home Page");
        jPanel34.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel33.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel35.setBackground(new java.awt.Color(255, 0, 51));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel35.setText("    Home Page");
        jPanel35.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel36.setBackground(new java.awt.Color(255, 0, 51));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel36.setText("    Home Page");
        jPanel36.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel35.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel33.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel29.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 280, 41));

        jPanel3.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 280, 41));

        jPanel37.setBackground(new java.awt.Color(0, 0, 0));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel37.setText("    View issued books");
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel37MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel37MouseExited(evt);
            }
        });
        jPanel37.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 230, 20));

        jPanel38.setBackground(new java.awt.Color(255, 0, 51));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel38.setText("    Home Page");
        jPanel38.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel37.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel39.setBackground(new java.awt.Color(255, 0, 51));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel39.setText("    Home Page");
        jPanel39.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel40.setBackground(new java.awt.Color(255, 0, 51));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel40.setText("    Home Page");
        jPanel40.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel39.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel37.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel41.setBackground(new java.awt.Color(255, 0, 51));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel41.setText("    Home Page");
        jPanel41.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel42.setBackground(new java.awt.Color(255, 0, 51));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel42.setText("    Home Page");
        jPanel42.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel41.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel43.setBackground(new java.awt.Color(255, 0, 51));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel43.setText("    Home Page");
        jPanel43.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel44.setBackground(new java.awt.Color(255, 0, 51));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel44.setText("    Home Page");
        jPanel44.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel43.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel41.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel37.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 280, 41));

        jPanel3.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 280, 41));

        jPanel45.setBackground(new java.awt.Color(0, 0, 0));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel45.setText("    Default List");
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel45MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel45MouseExited(evt);
            }
        });
        jPanel45.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 170, 40));

        jPanel46.setBackground(new java.awt.Color(255, 0, 51));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel46.setText("    Home Page");
        jPanel46.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel45.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel47.setBackground(new java.awt.Color(255, 0, 51));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel47.setText("    Home Page");
        jPanel47.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel48.setBackground(new java.awt.Color(255, 0, 51));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel48.setText("    Home Page");
        jPanel48.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel47.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel45.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel49.setBackground(new java.awt.Color(255, 0, 51));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel49.setText("    Home Page");
        jPanel49.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel50.setBackground(new java.awt.Color(255, 0, 51));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel50.setText("    Home Page");
        jPanel50.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel49.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel51.setBackground(new java.awt.Color(255, 0, 51));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel51.setText("    Home Page");
        jPanel51.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel52.setBackground(new java.awt.Color(255, 0, 51));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel52.setText("    Home Page");
        jPanel52.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel51.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel49.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 41));

        jPanel45.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 280, 41));

        jPanel3.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 280, 41));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 280, 760));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel69.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(50, 100, 255)));

        lbl_default_list.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbl_default_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        lbl_default_list.setText("10");

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lbl_default_list)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbl_default_list, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, 140, 110));

        jPanel70.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(50, 100, 255)));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel69.setText("10");

        lbl_nbr_student.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbl_nbr_student.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        lbl_nbr_student.setText("10");

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lbl_nbr_student)
                .addGap(372, 372, 372)
                .addComponent(jLabel69)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl_nbr_student, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 140, 110));

        jPanel71.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 102, 0)));

        lbl_nbr_book.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbl_nbr_book.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        lbl_nbr_book.setText("10");

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lbl_nbr_book)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel71Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(lbl_nbr_book, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel5.add(jPanel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 150, 110));

        jPanel72.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 102, 0)));

        lbl_issue_book.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbl_issue_book.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        lbl_issue_book.setText("10");

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbl_issue_book)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl_issue_book, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 140, 110));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel70.setText("default list");
        jPanel5.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, -1, 34));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel73.setText("no of book");
        jPanel5.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, 34));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel74.setText("Student detail");
        jPanel5.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, 34));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel75.setText("book Detail");
        jPanel5.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, -1, 34));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel76.setText("no of student");
        jPanel5.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, 34));

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel77.setText("issue book");
        jPanel5.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, 34));

        panelBarChart.setLayout(new java.awt.BorderLayout());
        jPanel5.add(panelBarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, 330, 350));

        tbl_bookDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetail.setColorBackgoundHead(new java.awt.Color(50, 100, 255));
        tbl_bookDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_bookDetail);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, 580, 180));

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
        jScrollPane4.setViewportView(tbl_StudentDetail);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 580, 180));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 1120, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
       ManageBook mB = new  ManageBook();
       mB.setVisible(true);
       dispose();
               
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel78MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel78MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel78MouseClicked

    private void tbl_bookDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailMouseClicked

    /*    int rowNo = tbl_bookDetail.getSelectedRow();
        TableModel model = tbl_bookDetail.getModel();

        txt_book_id.setText(model.getValueAt(rowNo, 0).toString());
        txt_book_name.setText(model.getValueAt(rowNo, 1).toString());
        txt_book_author.setText(model.getValueAt(rowNo, 2).toString());
        txt_book_quantirty.setText(model.getValueAt(rowNo, 3).toString());

        btn_add.setEnabled(false);
        btn_delete.setEnabled(true);
        btn_updape.setEnabled(true);*/
    }//GEN-LAST:event_tbl_bookDetailMouseClicked

    private void tbl_StudentDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_StudentDetailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_StudentDetailMouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
       jPanel8.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
       jPanel8.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        ManageStudent ms = new  ManageStudent();
        ms.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        jPanel9.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        jPanel9.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
       IssueBook ib = new IssueBook();
       ib.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
       jPanel13.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        jPanel13.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        retourBook ib = new retourBook();
        ib.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        jPanel21.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
       jPanel21.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        viewAllReccord vReccord = new viewAllReccord();
        vReccord.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered
        jPanel29.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
        jPanel29.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel29MouseExited

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        IssueBookDetail ibd = new IssueBookDetail();
        ibd.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseEntered
       jPanel37.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel37MouseEntered

    private void jLabel37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseExited
        jPanel37.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel37MouseExited

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        DefaultList dl = new DefaultList();
        dl.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel45MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseEntered
       jPanel45.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel45MouseEntered

    private void jLabel45MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseExited
       jPanel45.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel45MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        login_page lp = new login_page();
        lp.setVisible(true);
        dispose();
                
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_default_list;
    private javax.swing.JLabel lbl_issue_book;
    private javax.swing.JLabel lbl_nbr_book;
    private javax.swing.JLabel lbl_nbr_student;
    private javax.swing.JPanel panelBarChart;
    private rojerusan.RSTableMetro tbl_StudentDetail;
    private rojerusan.RSTableMetro tbl_bookDetail;
    // End of variables declaration//GEN-END:variables
}

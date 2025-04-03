
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
public class ManageBook extends javax.swing.JFrame {

    DefaultTableModel model;
 
    public ManageBook() {
        initComponents();
        setDetailBookTable();
        
       //Enable and disable button 
       btn_add.setEnabled(true);
       btn_delete.setEnabled(false);
       btn_updape.setEnabled(false);
       
       txt_book_id.setEditable(false);
    }

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
   
   public  void addBook(){
       
       // String id = txt_book_id.getText();
        String name = txt_book_name.getText();
        String author = txt_book_author.getText();
        String quantity = txt_book_quantirty.getText();
        
        try 
        {
            Connection con = DBconnexion.getConnection();
            String sql = "insert into manage_book(name,author,quantity) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, author);
            ps.setString(3, quantity);
          //  ps.setString(4, contact);
            
          int UpdatedRowCount =   ps.executeUpdate();
          
          if(UpdatedRowCount>0){
              JOptionPane.showMessageDialog(this, "ajouter avec success");
          }else{
              JOptionPane.showMessageDialog(this, "erreur lors de l'ajout");
          }
            txt_book_name.setText(""); txt_book_author.setText(""); txt_book_quantirty.setText(""); 
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
   }
   
   
   //Clear table
   public void clearTable(){
       DefaultTableModel model = (DefaultTableModel) tbl_bookDetail.getModel();
       model.setRowCount(0);
       
   }
   
   public boolean vallidationAddBook(){
        
         String name = txt_book_name.getText();
        String author = txt_book_author.getText();
        String quantity = txt_book_quantirty.getText();
       
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(this, "please enter the Name");
            return  false;
        }
        
         if(author.equals("")){
            JOptionPane.showMessageDialog(this, "please enter the author");
            return  false;
        }
         
         if(quantity.equals("")){
            JOptionPane.showMessageDialog(this, "please enter the quantity");
            return  false;
        }
        
        
        return true;
    }
   
   
   public  void updateBook(){
         // Update
        String id = txt_book_id.getText();
        String name = txt_book_name.getText();
        String author = txt_book_author.getText();
        String quantity = txt_book_quantirty.getText();
         try 
        {
        
        Connection con = DBconnexion.getConnection();
            String sql = "update manage_book set name=?,author=?,quantity=? where id_book=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, author);
            ps.setString(3, quantity);
         
        
      
           ps.setString(4, id);
           ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "update successfuly");
      }
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(this, e);
      }
   }
   
    public  void deleteBook(){
         // Update
        String id = txt_book_id.getText();
        
         try 
        {
        
        Connection con = DBconnexion.getConnection();
            String sql = "delete from manage_book where id_book=?";
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
        txt_book_id = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_book_quantirty = new javax.swing.JTextField();
        txt_book_author = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_updape = new rojerusan.RSMaterialButtonCircle();
        btn_delete = new rojerusan.RSMaterialButtonCircle();
        btn_add = new rojerusan.RSMaterialButtonCircle();
        txt_book_name = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bookDetail = new rojerusan.RSTableMetro();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 600));

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

        txt_book_id.setBackground(new java.awt.Color(50, 100, 255));
        txt_book_id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_book_id.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        txt_book_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_book_idFocusLost(evt);
            }
        });
        jPanel1.add(txt_book_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 240, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Id Book");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 50, 40));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 50, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name Book");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 40, 40));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 50, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Author");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        txt_book_quantirty.setBackground(new java.awt.Color(50, 100, 255));
        txt_book_quantirty.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_book_quantirty.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_book_quantirty, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 240, 30));

        txt_book_author.setBackground(new java.awt.Color(50, 100, 255));
        txt_book_author.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_book_author.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txt_book_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 240, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantity");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

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

        txt_book_name.setBackground(new java.awt.Color(50, 100, 255));
        txt_book_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_book_name.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        txt_book_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_book_nameFocusLost(evt);
            }
        });
        jPanel1.add(txt_book_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 240, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane1.setViewportView(tbl_bookDetail);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 172, -1, 340));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel9.setText("Book Manager");
        jLabel9.setName(""); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 250, -1));

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

    private void txt_book_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_book_idFocusLost
        //focus lost
      /*  if(checkDuplicateUser() == true){
            JOptionPane.showMessageDialog(this, "ce nom existe deja");
        }*/

    }//GEN-LAST:event_txt_book_idFocusLost

    private void btn_updapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updapeActionPerformed
     if(vallidationAddBook()){
          updateBook();
          
           // after update the  book clear the table then actualizate the table
             clearTable();
             setDetailBookTable();
     }
    }//GEN-LAST:event_btn_updapeActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
       deleteBook();
       
        // after delete the book clear the table then actualizate the table
             clearTable();
             setDetailBookTable();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
       
        if(vallidationAddBook()){
             addBook();
             
             // after add the new book clear the table then actualizate the table
             clearTable();
             setDetailBookTable();
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_book_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_book_nameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_book_nameFocusLost

    private void tbl_bookDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailMouseClicked
        
       int rowNo = tbl_bookDetail.getSelectedRow();
       TableModel model = tbl_bookDetail.getModel();
       
       txt_book_id.setText(model.getValueAt(rowNo, 0).toString());
       txt_book_name.setText(model.getValueAt(rowNo, 1).toString());
       txt_book_author.setText(model.getValueAt(rowNo, 2).toString());
       txt_book_quantirty.setText(model.getValueAt(rowNo, 3).toString());
        
       btn_add.setEnabled(false);
       btn_delete.setEnabled(true);
       btn_updape.setEnabled(true);
    }//GEN-LAST:event_tbl_bookDetailMouseClicked

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
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btn_add;
    private rojerusan.RSMaterialButtonCircle btn_delete;
    private rojerusan.RSMaterialButtonCircle btn_updape;
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
    private rojerusan.RSTableMetro tbl_bookDetail;
    private javax.swing.JTextField txt_book_author;
    private javax.swing.JTextField txt_book_id;
    private javax.swing.JTextField txt_book_name;
    private javax.swing.JTextField txt_book_quantirty;
    // End of variables declaration//GEN-END:variables
}

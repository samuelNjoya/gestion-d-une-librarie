
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class sigup_page extends javax.swing.JFrame {

  
    public sigup_page() {
        initComponents();
    }

    public void insertSinglePage(){
        String username = txt_username.getText();
        String password = txt_password.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        
        try 
        {
            Connection con = DBconnexion.getConnection();
            String sql = "insert into user(name,password,email,contact) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, contact);
            
          int UpdatedRowCount =   ps.executeUpdate();
          
          if(UpdatedRowCount>0){
              JOptionPane.showMessageDialog(this, "ajouter avec success");
          }else{
              JOptionPane.showMessageDialog(this, "erreur lors de l'ajout");
          }
            txt_username.setText(""); txt_password.setText(""); txt_email.setText(""); txt_contact.setText("");
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public boolean vallidationSingin(){
        
        String username = txt_username.getText();
        String password = txt_password.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        
        if(username.equals("")){
            JOptionPane.showMessageDialog(this, "please insert your Name");
            return  false;
        }
        
         if(password.equals("")){
            JOptionPane.showMessageDialog(this, "please insert your password");
            return  false;
        }
        
          if(email.equals("") || !email.matches("^.+@.+\\..+$")){
            JOptionPane.showMessageDialog(this, "please insert valid email");
            return  false;
        }
           if(contact.equals("")){
            JOptionPane.showMessageDialog(this, "please insert your Contact");
            return  false;
        }
        
        return true;
    }
    
    public boolean checkDuplicateUser(){
        String username = txt_username.getText();
        boolean isExist = false;
        
        try {
            Connection con = DBconnexion.getConnection();
            String sql = "select * from user where name = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, username);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                isExist = true;
            }else{
                isExist = false;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        return isExist;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_contact = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        txt_username = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_submit = new rojerusan.RSMaterialButtonCircle();
        btn_login = new rojerusan.RSMaterialButtonCircle();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(50, 100, 255));
        jLabel6.setText("SMART LIBRARY");
        jLabel6.setName(""); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 170, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/signup-library-icon.png"))); // NOI18N
        jLabel7.setAutoscrolls(true);
        jLabel7.setName(""); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 500, 480));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 0));
        jLabel9.setText("WELCOME TO");
        jLabel9.setName(""); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 600));

        panel1.setBackground(new java.awt.Color(50, 100, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("x");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 20, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 40, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Password");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contact");
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        txt_contact.setBackground(new java.awt.Color(50, 100, 255));
        txt_contact.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        panel1.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 240, 30));

        txt_email.setBackground(new java.awt.Color(50, 100, 255));
        txt_email.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        panel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 240, 30));

        txt_password.setBackground(new java.awt.Color(50, 100, 255));
        txt_password.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        panel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 240, 30));

        txt_username.setBackground(new java.awt.Color(50, 100, 255));
        txt_username.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        panel1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 240, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Create New Account Here");
        jLabel8.setName(""); // NOI18N
        panel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sigup Page");
        jLabel10.setName(""); // NOI18N
        panel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Name");
        panel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        panel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 50, 40));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Forgot_Password_50px_4.png"))); // NOI18N
        panel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 50, 40));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        panel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 50, 40));

        btn_submit.setBackground(new java.awt.Color(255, 102, 0));
        btn_submit.setLabel("Register");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });
        panel1.add(btn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 310, 50));

        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        panel1.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 310, 50));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 480, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
         System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        //focus lost
        if(checkDuplicateUser() == true){
            JOptionPane.showMessageDialog(this, "ce nom existe deja");
        }
        
    }//GEN-LAST:event_txt_usernameFocusLost

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
          if(vallidationSingin() == true){
      if(checkDuplicateUser() == false){
          insertSinglePage();
      }else{
          JOptionPane.showMessageDialog(this, "ce nom existe deja");
      }
        
  }    
    }//GEN-LAST:event_btn_submitActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        login_page loginp = new login_page();
        loginp.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_loginActionPerformed

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
            java.util.logging.Logger.getLogger(sigup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sigup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sigup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sigup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sigup_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btn_login;
    private rojerusan.RSMaterialButtonCircle btn_submit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private java.awt.Panel panel1;
    private javax.swing.JTextField txt_contact;
    private javax.swing.JTextField txt_email;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}

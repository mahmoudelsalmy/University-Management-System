

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class Student_JfFrame extends javax.swing.JFrame {
static final String dbURL = "jdbc:mysql://localhost:3306/universitydatabase";
    static final String dbUser = "root";  // your DB user
    static final String dbPass = "";  // your DB password  
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    private Object role;

    
    public Student_JfFrame() {
        initComponents();
         try {
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database connection failed: " + ex.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    Student_JfFrame(String id) {
         this(); 
    
    try {
        String sql = "SELECT u.*, s.*, d.* FROM users u " +
                    "LEFT JOIN students s ON u.user_id = s.student_id " +
                    "LEFT JOIN departments d ON s.department_id = d.department_id " +
                    "WHERE u.user_id = ?";
        
        pst = conn.prepareStatement(sql);
        pst.setString(1, id);
        rs = pst.executeQuery();
        
        if (rs.next()) {
            String name = rs.getString("username");
            String email = rs.getString("email");
            String role = rs.getString("role");        
            tID.setText("User ID: " + id);
            Lname.setText("Name : "+name);
            Lrole.setText("Role : "+role);
            Lemail.setText("email: "+email);
            
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Lname = new javax.swing.JLabel();
        Lrole = new javax.swing.JLabel();
        Lemail = new javax.swing.JLabel();
        tID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Welcome To The University");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("My Courses and Grade");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Sign Out");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        Lname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Lname.setForeground(new java.awt.Color(255, 255, 255));
        Lname.setText("jLabel1");

        Lrole.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Lrole.setForeground(new java.awt.Color(255, 255, 255));
        Lrole.setText("jLabel1");

        Lemail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Lemail.setForeground(new java.awt.Color(255, 255, 255));
        Lemail.setText("jLabel1");

        tID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tID.setForeground(new java.awt.Color(255, 255, 255));
        tID.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Lname)
                        .addGap(1178, 1178, 1178))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lemail)
                            .addComponent(tID)
                            .addComponent(Lrole))
                        .addGap(113, 113, 113)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(258, 258, 258)
                        .addComponent(jButton6)
                        .addGap(180, 180, 180))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Lname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tID)
                        .addGap(12, 12, 12)
                        .addComponent(Lrole)
                        .addGap(13, 13, 13)
                        .addComponent(Lemail)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(808, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1616, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        jButton6.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        jButton6.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to sign out?", "Sign Out", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            SignIn signIn = new SignIn();
            signIn.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
          String userText = tID.getText(); // e.g., "User ID: 123"
          String userId = userText.replaceAll("[^0-9]", ""); // Extract digits only

          String getStudentIdSQL = "SELECT student_id FROM students WHERE user_id = ?";
          pst = conn.prepareStatement(getStudentIdSQL);
          pst.setString(1, userId);
          rs = pst.executeQuery();

          String studentId = null;
          if (rs.next()) {
              studentId = rs.getString("student_id");
          } else {
              JOptionPane.showMessageDialog(this, "No student record found for user.");
              return;
          }

          String sql = "SELECT course_code, grade FROM enrollments WHERE student_id = ?";
          pst = conn.prepareStatement(sql);
          pst.setString(1, studentId);
          rs = pst.executeQuery();

          if (!rs.isBeforeFirst()) {
              JOptionPane.showMessageDialog(this, "No courses found for this student.");
              return;
          }

          String[] columnNames = {"Course Code", "Grade"};
          DefaultTableModel model = new DefaultTableModel(columnNames, 0);

          double totalGpaPoints = 0;
          int courseCount = 0;

          while (rs.next()) {
              String course = rs.getString("course_code");
              String gradeStr = rs.getString("grade");
              model.addRow(new Object[]{course, gradeStr});

              try {
                  int grade = Integer.parseInt(gradeStr);
                  double gpaPoint = 0;
                  if (grade >= 90) gpaPoint = 4.0;
                  else if (grade >= 80) gpaPoint = 3.0;
                  else if (grade >= 70) gpaPoint = 2.0;
                  else if (grade >= 60) gpaPoint = 1.0;
                  else gpaPoint = 0.0;

                  totalGpaPoints += gpaPoint;
                  courseCount++;
              } catch (NumberFormatException e) {
                  // Handle non-numeric grade (optional)
                  System.err.println("Invalid grade format: " + gradeStr);
              }
          }

          JTable table = new JTable(model);
          JScrollPane scrollPane = new JScrollPane(table);
          scrollPane.setPreferredSize(new Dimension(400, 200));

          String gpaMessage = (courseCount > 0)
                  ? String.format("GPA: %.2f", totalGpaPoints / courseCount)
                  : "GPA: N/A (No valid grades)";

          JPanel panel = new JPanel(new BorderLayout());
          panel.add(scrollPane, BorderLayout.CENTER);
          panel.add(new JLabel(gpaMessage, SwingConstants.CENTER), BorderLayout.SOUTH);

          JOptionPane.showMessageDialog(this, panel, "Your Courses, Grades & GPA", JOptionPane.INFORMATION_MESSAGE);

      } catch (SQLException ex) {
          Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jButton4ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_JfFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lemail;
    private javax.swing.JLabel Lname;
    private javax.swing.JLabel Lrole;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel tID;
    // End of variables declaration//GEN-END:variables
}

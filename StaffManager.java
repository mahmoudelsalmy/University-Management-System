package university;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StaffManager extends UserManager {

    public StaffManager(Connection conn) {
        super(conn);
    }

    // Add a staff member (must first be a user)
    public void addAcademicStaff(int userId, int departmentId) throws SQLException {
    String sql = "INSERT INTO academic_staff (user_id, department_id) VALUES (?, ?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, userId);
        pstmt.setInt(2, departmentId);
        pstmt.executeUpdate();
        System.out.println("Academic staff added.");
    }
}

    // Assign a course to a staff member
    public void assignCourse(int staffId, int courseId) throws SQLException {
        String sql = "INSERT INTO courses_staff (staff_id, course_id) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, staffId);
            pstmt.setInt(2, courseId);
            pstmt.executeUpdate();
            System.out.println("Course assigned to staff.");
        }
    }

    // View all staff
    public void viewAllStaff(Connection conn) throws SQLException {
        String sql = "SELECT a.staff_id, u.username, u.email, d.name AS department_name " +
                 "FROM academic_staff a " +
                 "JOIN users u ON a.user_id = u.user_id " +
                 "JOIN departments d ON a.department_id = d.department_id";
    
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; 
                }
            };

            
            model.addColumn("Staff ID");
            model.addColumn("Username");
            model.addColumn("Email");
            model.addColumn("Department");

            
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("staff_id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("department_name")
                });
            }

           
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, 
                    "No staff records found", 
                    "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            
            JTable table = new JTable(model);
            table.setFillsViewportHeight(true);

           
            table.getColumnModel().getColumn(0).setPreferredWidth(80);  // Staff ID
            table.getColumnModel().getColumn(1).setPreferredWidth(120); // Username
            table.getColumnModel().getColumn(2).setPreferredWidth(200); // Email
            table.getColumnModel().getColumn(3).setPreferredWidth(150); // Department

           
            JScrollPane scrollPane = new JScrollPane(table);
            JFrame frame = new JFrame("All Academic Staff");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(scrollPane);
            frame.pack();
            frame.setSize(800, 400);
            frame.setLocationRelativeTo(null); 
            frame.setVisible(true);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error loading staff data: " + e.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }

   
    public boolean OfficeHours(Connection conn, int staffId, String officeHours) throws SQLException {
    // Validate input
        String sql = "UPDATE staff SET OA = ? WHERE staff_id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, officeHours);
            pstmt.setInt(2, staffId);
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, 
                    "Office hours updated successfully", 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Staff member not found", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error updating office hours: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
    


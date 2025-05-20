package university;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentManager extends UserManager {

    public StudentManager(Connection conn) {
        super(conn);
    }

   public void addStudent(int userId, int departmentId) throws SQLException {
    String sql = "INSERT INTO students (user_id, department_id) VALUES (?, ?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, userId);
        pstmt.setInt(2, departmentId);
        pstmt.executeUpdate();
        System.out.println("Student added.");
    }
}

    public void deleteStudent(int studentId) throws SQLException {
        String sql = "DELETE FROM students WHERE student_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            pstmt.executeUpdate();
            System.out.println("Student deleted.");
        }
    }
    public void viewAllStudents(Connection conn) throws SQLException {
        String sql = "SELECT s.student_id, u.username, u.email, d.name AS department_name " +
                 "FROM students s " +
                 "JOIN users u ON s.user_id = u.user_id " +
                 "JOIN departments d ON s.department_id = d.department_id";
    
    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Student ID");
        model.addColumn("Username");
        model.addColumn("Email");
        model.addColumn("Department");
        
        
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("student_id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("department_name")
            });
        }
        
        
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        
        
        table.getColumnModel().getColumn(0).setPreferredWidth(80);  // Student ID
        table.getColumnModel().getColumn(1).setPreferredWidth(120); // Username
        table.getColumnModel().getColumn(2).setPreferredWidth(200); // Email
        table.getColumnModel().getColumn(3).setPreferredWidth(150); // Department
        
        
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("All Students");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(scrollPane);
        frame.pack();
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,
            "Error loading student data: " + e.getMessage(),
            "Database Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }
}

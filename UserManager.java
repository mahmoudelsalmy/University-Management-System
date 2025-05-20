package university;

import java.sql.*;

public class UserManager extends DatabaseHandler {

    public UserManager(Connection conn) {
        super(conn);
    }
public int addUser(String username, String email, String passwordHash, String role, int departmentId) throws SQLException {
    String sql = "INSERT INTO users (username, email, password_hash, role) VALUES (?, ?, ?, ?)";
    int userId = -1;

    try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        pstmt.setString(1, username);
        pstmt.setString(2, email);
        pstmt.setString(3, passwordHash);
        pstmt.setString(4, role);
        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            userId = rs.getInt(1);
        }

        System.out.println("User added with ID: " + userId);
    }

    if ("student".equals(role)) {
        addStudent(userId, departmentId);
    } else if ("staff".equals(role)) {
        addAcademicStaff(userId, departmentId);
    }

    return userId;
}
   

    public void updateUserEmail(int userId, String newEmail) throws SQLException {
        String sql = "UPDATE users SET email = ? WHERE user_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();
            System.out.println("Email updated.");
        }
    }

   private void addStudent(int userId, int departmentId) throws SQLException {
    String sql = "INSERT INTO students (user_id, department_id) VALUES (?, ?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, userId);
        pstmt.setInt(2, departmentId);
        pstmt.executeUpdate();
        System.out.println("Student added.");
    }
}
   private void addAcademicStaff(int userId, int departmentId) throws SQLException {
    String sql = "INSERT INTO academic_staff (user_id, department_id) VALUES (?, ?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, userId);
        pstmt.setInt(2, departmentId);
        pstmt.executeUpdate();
        System.out.println("Academic staff added.");
    }
}

}
/*case "admin":
        new AdminDashboard().setVisible(true);
        this.setVisible(false); // Hide the sign up form
        break;
    case "student":
        new StudentDashboard().setVisible(true);
        this.setVisible(false);
        break;
    case "staff":
        new StaffDashboard().setVisible(true);
        this.setVisible(false);
        break;*/
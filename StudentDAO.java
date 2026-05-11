import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // Add Student  
    public void addStudent(Student student) {

        String query = "INSERT INTO student (name, roll_no, semester) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getRollNo());
            stmt.setInt(3, student.getSemester());

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Added Successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Students
    public void viewStudents() {

        String query = "SELECT * FROM student";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n---- Student List ----");

            while (rs.next()) {

                int id = rs.getInt("student_id");
                String name = rs.getString("name");
                String roll = rs.getString("roll_no");
                int sem = rs.getInt("semester");

                System.out.println(id + " | " + name + " | " + roll + " | Semester: " + sem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Delete Student
   public void deleteStudent(int studentId) {

    String deleteMarksQuery = "DELETE FROM marks WHERE student_id = ?";
    String deleteStudentQuery = "DELETE FROM student WHERE student_id = ?";

    try (Connection con = DBConnection.getConnection()) {

        // Step 1: Delete marks first
        PreparedStatement pst1 = con.prepareStatement(deleteMarksQuery);
        pst1.setInt(1, studentId);
        int marksDeleted = pst1.executeUpdate();

        // Step 2: Delete student
        PreparedStatement pst2 = con.prepareStatement(deleteStudentQuery);
        pst2.setInt(1, studentId);
        int studentDeleted = pst2.executeUpdate();

        if (studentDeleted > 0) {
            System.out.println(" Student deleted successfully!");
            System.out.println(" Related marks deleted: " + marksDeleted);
        } else {
            System.out.println("!! Student not found!");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // Add Student (No student_id because AUTO_INCREMENT)
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

        String query = "DELETE FROM student WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, studentId);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent(String name, String rollNo, int semester) {

    String query = "INSERT INTO student (name, roll_no, semester) VALUES (?, ?, ?)";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setString(1, name);
        pst.setString(2, rollNo);
        pst.setInt(3, semester);

        pst.executeUpdate();
        System.out.println("Student added successfully!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

}

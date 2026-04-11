import java.sql.*;

public class MarksDAO {

    // 1️⃣ Add Marks
    public void addMarks(int studentId, String subject, int marks) {
        String query = "INSERT INTO marks (student_id, subject, marks) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, studentId);
            pst.setString(2, subject);
            pst.setInt(3, marks);

            pst.executeUpdate();
            System.out.println("Marks Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2️⃣ View Marks
    public void viewMarks(int studentId) {
        String query = "SELECT subject, marks FROM marks WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();

            System.out.println("Subjects and Marks:");
            while (rs.next()) {
                System.out.println(
                        rs.getString("subject") + " : " +
                        rs.getInt("marks")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3️⃣ Calculate Average
    public void calculateAverage(int studentId) {
        String query = "SELECT AVG(marks) AS average FROM marks WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                double avg = rs.getDouble("average");
                System.out.println("Average Marks: " + avg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 4️⃣ Generate Full Report
public void generateReport(int studentId) {

    String studentQuery = "SELECT name, roll_no, semester FROM student WHERE student_id = ?";
    String marksQuery = "SELECT subject, marks FROM marks WHERE student_id = ?";

    try (Connection con = DBConnection.getConnection()) {

        // Fetch Student Details
        PreparedStatement pst1 = con.prepareStatement(studentQuery);
        pst1.setInt(1, studentId);
        ResultSet studentRs = pst1.executeQuery();

        if (studentRs.next()) {
            System.out.println("\n===== STUDENT REPORT =====");
            System.out.println("Name: " + studentRs.getString("name"));
            System.out.println("Roll No: " + studentRs.getString("roll_no"));
            System.out.println("Semester: " + studentRs.getInt("semester"));
        } else {
            System.out.println("Student Not Found!");
            return;
        }

        // Fetch Marks
        PreparedStatement pst2 = con.prepareStatement(marksQuery);
        pst2.setInt(1, studentId);
        ResultSet marksRs = pst2.executeQuery();

        System.out.println("\nSubjects & Marks:");
        int total = 0;
        int count = 0;

        while (marksRs.next()) {
            int marks = marksRs.getInt("marks");
            total += marks;
            count++;

            System.out.println(
                    marksRs.getString("subject") + " : " + marks
            );
        }

        if (count > 0) {
            double average = (double) total / count;
            System.out.println("\nTotal Marks: " + total);
            System.out.println("Average Marks: " + average);

            // Auto Grade 
            String grade;

            if (average >= 90) {
                grade = "A";
            } else if (average >= 75) {
                grade = "B";
            } else if (average >= 60) {
                grade = "C";
            } else {
                grade = "F";
            }

            System.out.println("Grade: " + grade);

        } else {
            System.out.println("No marks found for this student.");
        }

        System.out.println("==========================\n");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
// Update Marks
public void updateMarks(int studentId, String subject, int newMarks) {

    String query = "UPDATE marks SET marks = ? WHERE student_id = ? AND subject = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setInt(1, newMarks);
        pst.setInt(2, studentId);
        pst.setString(3, subject);

        int rows = pst.executeUpdate();

        if (rows > 0) {
            System.out.println("Marks updated successfully!");
        } else {
            System.out.println("Record not found!");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

// 🏆 Find Topper
public void findTopper() {

    String query = """
        SELECT s.student_id, s.name, AVG(m.marks) AS average
        FROM student s
        JOIN marks m ON s.student_id = m.student_id
        GROUP BY s.student_id
        ORDER BY average DESC
        LIMIT 1
        """;

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {

        if (rs.next()) {
            System.out.println("\n🏆 TOPPER DETAILS 🏆");
            System.out.println("Student ID: " + rs.getInt("student_id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Average Marks: " + rs.getDouble("average"));
        } else {
            System.out.println("No data available.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}





}

import javax.swing.*;
import java.awt.*;

public class StudentGUI extends JFrame {

    private JTextField nameField, rollField, semesterField;
    private JTextField studentIdField, subjectField, marksField;

    private StudentDAO studentDAO = new StudentDAO();
    private MarksDAO marksDAO = new MarksDAO();

    public StudentGUI() {

        setTitle("Student Performance and Progress Tracker");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(0, 2, 8, 8));

        // ===== HEADING =====
        JLabel heading = new JLabel("Student Performance Tracker", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading);
        add(new JLabel(""));

        // ===== STUDENT SECTION =====
        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Roll No:"));
        rollField = new JTextField();
        add(rollField);

        add(new JLabel("Semester:"));
        semesterField = new JTextField();
        add(semesterField);

        JButton addStudentBtn = new JButton("Add Student");
        JButton viewStudentsBtn = new JButton("View Students");

        add(addStudentBtn);
        add(viewStudentsBtn);

        // ===== MARKS SECTION =====
        add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        add(studentIdField);

        add(new JLabel("Subject:"));
        subjectField = new JTextField();
        add(subjectField);

        add(new JLabel("Marks:"));
        marksField = new JTextField();
        add(marksField);

        JButton addMarksBtn = new JButton("Add Marks");
        JButton viewMarksBtn = new JButton("View Marks");

        add(addMarksBtn);
        add(viewMarksBtn);

        JButton avgBtn = new JButton("Calculate Average");
        JButton reportBtn = new JButton("Generate Report");

        add(avgBtn);
        add(reportBtn);

        JButton updateBtn = new JButton("Update Marks");
        JButton deleteBtn = new JButton("Delete Student");

        add(updateBtn);
        add(deleteBtn);

        JButton topperBtn = new JButton("Find Topper");
        JButton exportBtn = new JButton("Export CSV");

        add(topperBtn);
        add(exportBtn);

        // =========================
        // BUTTON                            
        // =========================

        // Add Student
        addStudentBtn.addActionListener(e -> {
            try {
                   String name = nameField.getText().trim();
                    String roll = rollField.getText().trim();
                    int semester = Integer.parseInt(semesterField.getText().trim());

                    Student student = new Student(name, roll, semester);

                    studentDAO.addStudent(student);

                JOptionPane.showMessageDialog(this,
                        "Student Added Successfully!");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Semester must be a number!");
            }
        });

        // View Students
        viewStudentsBtn.addActionListener(e -> {
            studentDAO.viewStudents();
            JOptionPane.showMessageDialog(this,
                    "Check console for student list.");
        });

        // Add Marks
        addMarksBtn.addActionListener(e -> {
            try {
                int studentId =
                        Integer.parseInt(studentIdField.getText().trim());

                String subject = subjectField.getText().trim();

                int marks =
                        Integer.parseInt(marksField.getText().trim());

                marksDAO.addMarks(studentId, subject, marks);

                JOptionPane.showMessageDialog(this,
                        "Marks Added Successfully!");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Student ID and Marks must be numbers!");
            }
        });

        // View Marks
        viewMarksBtn.addActionListener(e -> {
            try {
                int studentId =
                        Integer.parseInt(studentIdField.getText().trim());

                marksDAO.viewMarks(studentId);

                JOptionPane.showMessageDialog(this,
                        "Check console for marks.");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Enter valid Student ID!");
            }
        });

        // Calculate Average
        avgBtn.addActionListener(e -> {
            try {
                int studentId =
                        Integer.parseInt(studentIdField.getText().trim());

                marksDAO.calculateAverage(studentId);

                JOptionPane.showMessageDialog(this,
                        "Check console for average.");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Enter valid Student ID!");
            }
        });

        // Generate Report
        reportBtn.addActionListener(e -> {
            try {
                int studentId =
                        Integer.parseInt(studentIdField.getText().trim());

                marksDAO.generateReport(studentId);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Enter valid Student ID!");
            }
        });

        // Update Marks
        updateBtn.addActionListener(e -> {
            try {
                int studentId =
                        Integer.parseInt(studentIdField.getText().trim());

                String subject = subjectField.getText().trim();

                int marks =
                        Integer.parseInt(marksField.getText().trim());

                marksDAO.updateMarks(studentId, subject, marks);

                JOptionPane.showMessageDialog(this,
                        "Marks Updated Successfully!");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Student ID and Marks must be numbers!");
            }
        });

        // Delete Student
        deleteBtn.addActionListener(e -> {
            try {
                int studentId =
                        Integer.parseInt(studentIdField.getText().trim());

                studentDAO.deleteStudent(studentId);

                JOptionPane.showMessageDialog(this,
                        "Student Deleted Successfully!");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Enter valid Student ID!");
            }
        });

        // Find Topper
        topperBtn.addActionListener(e -> {
            marksDAO.findTopper();
            JOptionPane.showMessageDialog(this,
                    "Check console for topper.");
        });

        // Export CSV
        exportBtn.addActionListener(e -> {
            try {
                int studentId =
                        Integer.parseInt(studentIdField.getText().trim());

                marksDAO.exportReportToCSV(studentId);

                JOptionPane.showMessageDialog(this,
                        "CSV exported successfully!");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Enter valid Student ID!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentGUI().setVisible(true);
        });
    }
}
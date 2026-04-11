    import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        MarksDAO marksDao = new MarksDAO();


        while (true) {

            System.out.println("\n===== Student Performance System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Marks");
            System.out.println("4. View Marks");
            System.out.println("5. Calculate Average");
            System.out.println("6. Generate Performance Report");
            System.out.println("7. Update Marks");
            System.out.println("8. Delete Student");
            System.out.println("9.Find Topper");
            System.out.println("10. Exit");
            System.out.print("Choose option: ");


            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

                switch (choice) {

            case 1:
                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Roll No: ");
                String roll = sc.nextLine();

                System.out.print("Enter Semester: ");
                int sem = sc.nextInt();
                sc.nextLine();

                Student student = new Student(name, roll, sem);
                dao.addStudent(student);
                break;

            case 2:
                dao.viewStudents();
                break;

            case 3:
                System.out.print("Enter Student ID: ");
                int sid = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Subject Name: ");
                String subject = sc.nextLine();

                System.out.print("Enter Marks: ");
                int marks = sc.nextInt();
                sc.nextLine();

                marksDao.addMarks(sid, subject, marks);
                break;

            case 4:
                System.out.print("Enter Student ID: ");
                int viewId = sc.nextInt();
                sc.nextLine();

                marksDao.viewMarks(viewId);
                break;

            case 5:
                System.out.print("Enter Student ID: ");
                int avgId = sc.nextInt();
                sc.nextLine();

                marksDao.calculateAverage(avgId);
                break;

            case 6:
                System.out.print("Enter Student ID: ");
                int reportId = sc.nextInt();
                sc.nextLine();

                marksDao.generateReport(reportId);
                break;

            case 7:
                System.out.print("Enter Student ID: ");
                sid = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Subject: ");
                String sub = sc.nextLine();

                System.out.print("Enter New Marks: ");
                int newMarks = sc.nextInt();

                marksDao.updateMarks(sid, sub, newMarks);
                break;

            case 8:
                System.out.print("Enter Student ID to delete: ");
                int deleteId = sc.nextInt();
                dao.deleteStudent(deleteId);
                break;
            case 9:
                marksDao.findTopper();
                break;

            case 10:
                System.out.println("Exiting...");
                System.exit(0);

            default:
                System.out.println("Invalid choice!");
                sc.close();
        }


        }
    }
}

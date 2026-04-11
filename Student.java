public class Student {

    private String name;
    private String rollNo;
    private int semester;

    public Student(String name, String rollNo, int semester) {
        this.name = name;
        this.rollNo = rollNo;
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public int getSemester() {
        return semester;
    }
}

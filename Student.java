public class Student {

    private int rollNumber;
    private String studentName;
    private int[] marks = new int[5];
    private int totalMarks;
    private double averageMarks;
    private String grade;

    // Default Constructor
    public Student() {
    }

    // Parameterized Constructor
    public Student(int rollNumber, String studentName, int[] marks) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.marks = marks;
        calculateResult();
    }

    // Getter methods
    public int getRollNumber() {
        return rollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public int[] getMarks() {
        return marks;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public double getAverageMarks() {
        return averageMarks;
    }

    public String getGrade() {
        return grade;
    }

    // Result calculation
    private void calculateResult() {
        totalMarks = 0;
        for (int m : marks) {
            totalMarks += m;
        }

        averageMarks = totalMarks / 5.0;

        if (averageMarks >= 90)
            grade = "A+";
        else if (averageMarks >= 75)
            grade = "A";
        else if (averageMarks >= 60)
            grade = "B";
        else if (averageMarks >= 50)
            grade = "C";
        else
            grade = "Fail";
    }

    // Method Overloading
    public void display() {
        System.out.println(rollNumber + " | " + studentName + " | " + averageMarks + " | " + grade);
    }

    public void display(boolean showMarks) {
        if (showMarks) {
            System.out.println("\n------ STUDENT RESULT ------");
            System.out.println("Roll No : " + rollNumber);
            System.out.println("Name    : " + studentName);
            System.out.print("Marks   : ");
            for (int m : marks) {
                System.out.print(m + " ");
            }
            System.out.println("\nTotal   : " + totalMarks);
            System.out.println("Average : " + averageMarks);
            System.out.println("Grade   : " + grade);
            System.out.println("----------------------------");
        }
    }
}
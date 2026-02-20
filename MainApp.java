import java.util.*;

public class MainApp {

    private static Scanner sc = new Scanner(System.in);
    private static ResultManager manager = new ResultManager();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== SMART RESULT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Failed Students");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudentProcess();
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    manager.viewFailedStudents();
                    break;
                case 4:
                    System.out.println("Exiting System...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);
    }

    private static void addStudentProcess() {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        int[] marks = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Marks for Subject " + (i + 1) + ": ");
            int mark = sc.nextInt();

            if (mark < 0 || mark > 100) {
                System.out.println("Invalid Marks! Enter between 0-100.");
                i--;
            } else {
                marks[i] = mark;
            }
        }

        Student student = new Student(roll, name, marks);
        manager.addStudent(student);
    }
}
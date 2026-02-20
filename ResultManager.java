import java.io.*;

public class ResultManager {

    private static final String FILE_NAME = "student_records.dat";

    // Add Student
    public void addStudent(Student student) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            StringBuilder sb = new StringBuilder();
            sb.append(student.getRollNumber()).append("|");
            sb.append(student.getStudentName()).append("|");

            for (int m : student.getMarks()) {
                sb.append(m).append(",");
            }

            bw.write(sb.toString());
            bw.newLine();

            System.out.println("Student Record Saved Successfully.");

        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    // Display All Students
    public void viewAllStudents() {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String record;

            while ((record = br.readLine()) != null) {

                String[] parts = record.split("\\|");
                int roll = Integer.parseInt(parts[0]);
                String name = parts[1];

                String[] markArray = parts[2].split(",");
                int[] marks = new int[5];

                for (int i = 0; i < 5; i++) {
                    marks[i] = Integer.parseInt(markArray[i]);
                }

                Student s = new Student(roll, name, marks);
                s.display(true);
            }

        } catch (IOException e) {
            System.out.println("No records found.");
        }
    }

    // Display Failed Students
    public void viewFailedStudents() {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String record;

            while ((record = br.readLine()) != null) {

                String[] parts = record.split("\\|");
                int roll = Integer.parseInt(parts[0]);
                String name = parts[1];

                String[] markArray = parts[2].split(",");
                int[] marks = new int[5];

                for (int i = 0; i < 5; i++) {
                    marks[i] = Integer.parseInt(markArray[i]);
                }

                Student s = new Student(roll, name, marks);

                if (s.getGrade().equals("Fail")) {
                    s.display(true);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
import java.io.*;
import java.util.*;

public class StudentManager {
    private List<Student> students;
    private final String fileName = "students.txt";

    public StudentManager() {
        students = new ArrayList<>();
        loadFromFile();
    }

    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
    }

    public void deleteStudent(String id) {
        students.removeIf(s -> s.getId().equals(id));
        saveToFile();
    }

    public Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) return s;
        }
        return null;
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void assignCourse(String id, String course) {
        Student s = findStudentById(id);
        if (s != null) {
            s.addCourse(course);
            saveToFile();
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromFileString(line));
            }
        } catch (IOException e) {
            // File might not exist initially
        }
    }

    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (Student s : students) {
                pw.println(s.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}


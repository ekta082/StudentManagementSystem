import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Assign Course to Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    manager.addStudent(new Student(id, name, email));
                    System.out.println("Student added.");
                    break;

                case 2:
                    manager.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String sid = sc.nextLine();
                    System.out.print("Enter Course Name: ");
                    String course = sc.nextLine();
                    manager.assignCourse(sid, course);
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    String delId = sc.nextLine();
                    manager.deleteStudent(delId);
                    System.out.println("Student deleted if ID existed.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}

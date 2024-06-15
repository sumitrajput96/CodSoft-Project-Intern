import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<String> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(String studentName) {
        students.add(studentName);
        System.out.println("Student " + studentName + " added successfully.");
    }

    public void removeStudent(String studentName) {
        if (students.remove(studentName)) {
            System.out.println("Student " + studentName + " removed successfully.");
        } else {
            System.out.println("Student " + studentName + " not found.");
        }
    }

    public void displayStudents() {
        System.out.println("List of students:");
        for (String student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        boolean running = true;
        while (running) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character after nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to add: ");
                    String addName = scanner.nextLine();
                    sms.addStudent(addName);
                    break;
                case 2:
                    System.out.print("Enter student name to remove: ");
                    String removeName = scanner.nextLine();
                    sms.removeStudent(removeName);
                    break;
                case 3:
                    sms.displayStudents();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EnrollmentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course>  courses  = new ArrayList<>();
        HashMap<String, ArrayList<String>> enrollments =
                new HashMap<>();
        String[] validPrograms = {"BSIT", "BSCS"};

        int choice = -1;
        while (choice != 0) {
            printMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:  // Register Student
                    System.out.print("Student ID   : ");
                    String id = sc.nextLine();
                    System.out.print("Student Name   : ");
                    String fullName = sc.nextLine();
                    System.out.print("Our Valid Programs   :(BSIT/BSCS ");
                    String program = sc.nextLine();
                    System.out.print("Year Level   : ");
                    String yearLevel = sc.nextLine();
                    // TODO: read name, program, year level
                    // TODO: validate program vs validPrograms
                    // TODO: validate yearLevel is 1..4
                    students.add(new Student(id, "", "", 1));
                    System.out.println("[OK] Registered!");
                    break;
                case 2:  // TODO: Add Course Offering
                    System.out.print("Courses We Offer:");
                    System.out.println("BSIT");
                    System.out.println("BSCS");
                    break;
                case 3:  // TODO: Enroll Student to Course

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                // TODO: cases 4, 5, 6
                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void printMenu() {
        System.out.println("[1] Register Student");
        // ... print the rest of the menu
        System.out.println("[2] Add Course Offering");
        System.out.println("[3] Enroll Student to Course");
        System.out.println("[4] View All Students");
        System.out.println("[5] View All Courses");
        System.out.println("[6] View Student Load");
        System.out.println("[0]  Exit");
        System.out.print("Enter choice: ");
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    static int[] cutoffs = {90, 80, 70, 60};
    static char[] letters = {'A', 'B', 'C', 'D'};

    public static char letterFor(int score) {
        for (int i = 0; i < cutoffs.length; i++) {
            if (score >= cutoffs[i]) {
                return letters[i];
            }
        }
        return 'F';
    }

    public static void main(String[] args) {

        ArrayList<Student> roster = new ArrayList<Student>();

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {

            System.out.println("");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Class average");
            System.out.println("4. Exit");
            System.out.print("Pick an option: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Grade: ");
                double grade = sc.nextDouble();
                sc.nextLine();

                Student s = new Student(name, grade);
                roster.add(s);

                System.out.println("added " + name);
            }
            else if (choice == 2) {
                if (roster.isEmpty()) {
                    System.out.println("nobody in the list yet");
                } else {
                    for (Student s : roster) {
                        System.out.println(s.name + ": " + s.grade + " (" + letterFor((int) s.grade) + ")");
                    }
                }
            }
            else if (choice == 3) {
                if (roster.isEmpty()) {
                    System.out.println("no students yet, can't do average");
                } else {
                    double total = 0;
                    for (int i = 0; i < roster.size(); i++) {
                        total = total + roster.get(i).grade;
                    }
                    double avg = total / roster.size();
                    System.out.printf("class average: %.2f%n", avg);
                }
            }
            else if (choice == 4) {
                System.out.println("bye!");
            }
            else {
                System.out.println("that's not a valid option");
            }
        }

        sc.close();
    }
}


class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}
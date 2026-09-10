import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final int LIMIT = 10;

        int[] studentId = new int[LIMIT];
        String[] studentName = new String[LIMIT];
        int[] studentAge = new int[LIMIT];
        String[] studentCourse = new String[LIMIT];
        double[] studentGrade = new double[LIMIT];
        boolean[] isEnrolled = new boolean[LIMIT];

        int total = 0; // number of students currently stored
        int choice = 0;

        while (choice != 5) {

            System.out.println("\n---- STUDENT INFORMATION SYSTEM ----");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. View Statistics");
            System.out.println("5. Exit");

            choice = -1;
            while (choice < 1 || choice > 5) {
                System.out.print("Choice: ");
                String line = input.nextLine();
                try {
                    choice = Integer.parseInt(line);
                    if (choice < 1 || choice > 5) {
                        System.out.println("Input is invalid. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input is invalid. Try again.");
                }
            }

            switch (choice) {

                case 1:
                    if (total >= LIMIT) {
                        System.out.println("Student list is full. Cannot add more.");
                        break;
                    }

                    // ID
                    int id = 0;
                    boolean validId = false;
                    while (!validId) {
                        System.out.print("ID: ");
                        try {
                            id = Integer.parseInt(input.nextLine());
                            validId = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Input is invalid. Try again.");
                        }
                    }

                    // Name
                    System.out.print("Name: ");
                    String name = input.nextLine();

                    // Age
                    int age = 0;
                    boolean validAge = false;
                    while (!validAge) {
                        System.out.print("Age: ");
                        try {
                            age = Integer.parseInt(input.nextLine());
                            if (age > 0) {
                                validAge = true;
                            } else {
                                System.out.println("Input is invalid. Try again.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Input is invalid. Try again.");
                        }
                    }

                    // Course
                    System.out.print("Course: ");
                    String course = input.nextLine();

                    // Grade
                    double grade = 0;
                    boolean validGrade = false;
                    while (!validGrade) {
                        System.out.print("Grade: ");
                        try {
                            grade = Double.parseDouble(input.nextLine());
                            if (grade >= 0 && grade <= 100) {
                                validGrade = true;
                            } else {
                                System.out.println("Input is invalid. Try again.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Input is invalid. Try again.");
                        }
                    }

                    // Enrolled
                    boolean enrolled = false;
                    boolean validEnrolled = false;
                    while (!validEnrolled) {
                        System.out.print("Enrolled? (true/false): ");
                        String line = input.nextLine().trim();
                        if (line.equalsIgnoreCase("true") || line.equalsIgnoreCase("false")) {
                            enrolled = Boolean.parseBoolean(line);
                            validEnrolled = true;
                        } else {
                            System.out.println("Input is invalid. Try again.");
                        }
                    }

                    studentId[total] = id;
                    studentName[total] = name;
                    studentAge[total] = age;
                    studentCourse[total] = course;
                    studentGrade[total] = grade;
                    isEnrolled[total] = enrolled;
                    total++;

                    System.out.println("Student added.");
                    break;

                case 2:
                    if (total == 0) {
                        System.out.println("No students yet.");
                        break;
                    }

                    for (int i = 0; i < total; i++) {
                        String standing;

                        if (studentGrade[i] >= 90) {
                            standing = "Dean's Lister";
                        } else if (studentGrade[i] >= 75) {
                            standing = "Passed";
                        } else {
                            standing = "Failed";
                        }

                        System.out.println("\nID: " + studentId[i]);
                        System.out.println("Name: " + studentName[i]);
                        System.out.println("Age: " + studentAge[i]);
                        System.out.println("Course: " + studentCourse[i]);
                        System.out.println("Grade: " + studentGrade[i]);
                        System.out.println("Enrolled: " + isEnrolled[i]);
                        System.out.println("Standing: " + standing);
                    }
                    break;

                case 3:
                    int searchId = 0;
                    boolean validSearchId = false;
                    while (!validSearchId) {
                        System.out.print("Enter ID to search: ");
                        try {
                            searchId = Integer.parseInt(input.nextLine());
                            validSearchId = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Input is invalid. Try again.");
                        }
                    }

                    boolean found = false;
                    for (int i = 0; i < total; i++) {
                        if (studentId[i] == searchId) {
                            found = true;
                            System.out.println("\nName: " + studentName[i]);
                            System.out.println("Age: " + studentAge[i]);
                            System.out.println("Course: " + studentCourse[i]);
                            System.out.println("Grade: " + studentGrade[i]);
                            System.out.println("Enrolled: " + isEnrolled[i]);
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    if (total == 0) {
                        System.out.println("No students yet.");
                        break;
                    }

                    double sum = 0;
                    int topIndex = 0;

                    for (int i = 0; i < total; i++) {
                        sum = sum + studentGrade[i];

                        if (studentGrade[i] > studentGrade[topIndex]) {
                            topIndex = i;
                        }
                    }

                    double average = sum / total;

                    System.out.println("Total students: " + total);
                    System.out.println("Average grade: " + average);
                    System.out.println("Top student: " + studentName[topIndex] + " with " + studentGrade[topIndex]);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;
            }
        }

        input.close();
    }
}
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("===== JAVA TOOLBOX =====");
            System.out.println("1 - Greet me");
            System.out.println("2 - Area (square or rectangle)");
            System.out.println("3 - Sum of numbers");
            System.out.println("4 - Swap demo (pass-by-value)");
            System.out.println("5 - Box demo (object mutation)");
            System.out.println("0 - Exit");
            System.out.print("Choose an option: ");

            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Please enter a number. Choose an option: ");
            }
            option = sc.nextInt();
            System.out.println();

            if (option == 1) {
                System.out.print("Enter your name: ");
                String userName = sc.next();
                System.out.println(greet(userName));

            } else if (option == 2) {
                System.out.print("Sides (1 = square, 2 = rectangle): ");
                int shape = sc.nextInt();

                if (shape == 1) {
                    System.out.print("Enter side length: ");
                    double side = sc.nextDouble();
                    System.out.println("Area of square = " + area(side));
                } else {
                    System.out.print("Enter length: ");
                    double len = sc.nextDouble();
                    System.out.print("Enter width: ");
                    double wid = sc.nextDouble();
                    System.out.println("Area of rectangle = " + area(len, wid));
                }

            } else if (option == 3) {
                System.out.println("Sum of 4, 8, 15 = " + sum(4, 8, 15));
                System.out.println("Sum of 2, 4, 6, 8, 10 = " + sum(2, 4, 6, 8, 10));

            } else if (option == 4) {
                int x = 5, y = 9;
                System.out.println("Before swap: x = " + x + ", y = " + y);
                swap(x, y);
                System.out.println("After swap:  x = " + x + ", y = " + y
                        + "  (unchanged - Java is pass-by-value)");

            } else if (option == 5) {
                Box b = new Box();
                b.value = 10;
                System.out.println("Before: box.value = " + b.value);
                addToBox(b, 25);
                System.out.println("After:  box.value = " + b.value
                        + "  (changed - the object is shared)");

            } else if (option == 0) {
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid option, try again.");
            }

            System.out.println();

        } while (option != 0);

        sc.close();
    }

    static String greet(String userName) {
        return "Hello, " + userName + "! Welcome to my Java Toolbox.";
    }

    static double area(double side) {
        return Math.pow(side, 2);
    }

    static double area(double length, double width) {
        return length * width;
    }

    static int sum(int... values) {
        int result = 0;
        for (int v : values) {
            result += v;
        }
        return result;
    }

    static void swap(int a, int b) {
        int hold = a;
        a = b;
        b = hold;
        System.out.println("   (inside swap)  a = " + a + ", b = " + b);
    }

    static void addToBox(Box b, int amount) {
        b.value += amount;
    }
}

class Box {
    int value;
}

import java.util.Scanner;

public class Calculator {

    // Basic operations
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("=== Java Console Calculator ===");

        while (keepRunning) {
            System.out.println("\nSelect operation:");
            System.out.println("1) Add");
            System.out.println("2) Subtract");
            System.out.println("3) Multiply");
            System.out.println("4) Divide");
            System.out.println("5) Exit");
            System.out.print("Enter choice (1-5): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number 1-5.");
                sc.nextLine(); // clear buffer
                continue;
            }

            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            System.out.print("Enter first number: ");
            while (!sc.hasNextDouble()) {
                System.out.print("That's not a number. Enter first number: ");
                sc.next();
            }
            double num1 = sc.nextDouble();

            System.out.print("Enter second number: ");
            while (!sc.hasNextDouble()) {
                System.out.print("That's not a number. Enter second number: ");
                sc.next();
            }
            double num2 = sc.nextDouble();

            sc.nextLine(); // ✅ clear any leftover inputs (like a 3rd number)

            try {
                double result;
                switch (choice) {
                    case 1:
                        result = add(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 2:
                        result = subtract(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 3:
                        result = multiply(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 4:
                        result = divide(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    default:
                        System.out.println("Invalid choice. Pick 1-5.");
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("Do another calculation? (y/n): ");
            String again = sc.nextLine();
            if (!again.equalsIgnoreCase("y") && !again.equalsIgnoreCase("yes")) {
                keepRunning = false;
                System.out.println("Bye!");
            }
        }

        sc.close();
    }
}
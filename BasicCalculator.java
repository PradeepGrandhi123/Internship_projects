import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter two numbers
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        // Prompt the user to choose an operation
        System.out.println("Choose an operation: ");
        System.out.println("1 - Addition (+)");
        System.out.println("2 - Subtraction (-)");
        System.out.println("3 - Multiplication (*)");
        System.out.println("4 - Division (/)");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        double result = 0;

        // Perform the chosen operation
        switch (choice) {
            case 1:
                result = num1 + num2;
                System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
                break;
            case 2:
                result = num1 - num2;
                System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
                break;
            case 3:
                result = num1 * num2;
                System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
                break;
            case 4:
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid choice! Please choose a valid operation.");
                break;
        }

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}


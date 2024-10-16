import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Random Password Generator!");

        // User inputs for length and character options
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().toLowerCase().charAt(0) == 'y';

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.next().toLowerCase().charAt(0) == 'y';

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.next().toLowerCase().charAt(0) == 'y';

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialChars = scanner.next().toLowerCase().charAt(0) == 'y';

        // Validate if at least one type of character is selected
        if (!includeUppercase && !includeLowercase && !includeNumbers && !includeSpecialChars) {
            System.out.println("Error: You must select at least one type of character.");
            return;
        }

        String password = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars, random);
        System.out.println("Generated password: " + password);

        scanner.close();
    }

    // Method to generate password
    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
                                          boolean includeNumbers, boolean includeSpecialChars, Random random) {

        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

        String allowedChars = "";
        if (includeUppercase) allowedChars += upperCaseLetters;
        if (includeLowercase) allowedChars += lowerCaseLetters;
        if (includeNumbers) allowedChars += numbers;
        if (includeSpecialChars) allowedChars += specialCharacters;

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(randomIndex));
        }

        return password.toString();
    }
}

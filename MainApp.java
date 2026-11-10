import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=========================================");
            System.out.println("   PASSWORD STRENGTH ANALYSIS ENGINE     ");
            System.out.println("=========================================");

            System.out.print("Enter a password to test: ");
            String input = scanner.nextLine();

            PasswordValidator.StrengthResult result = PasswordValidator.analyzePassword(input);

            System.out.println("\n--- Analysis Report ---");
            System.out.printf("Overall Status:    [%s]\n", result.getLabel());
            System.out.printf("Structural Score:  %d / 6\n", result.getScore());
            System.out.printf("Shannon Entropy:   %.2f bits\n", result.getEntropy());
            System.out.println("\n--- Metrics Breakdown ---");
            System.out.println("✔ Contains Uppercase: " + (result.hasUpper() ? "Yes" : "No"));
            System.out.println("✔ Contains Lowercase: " + (result.hasLower() ? "Yes" : "No"));
            System.out.println("✔ Contains Digits:    " + (result.hasDigit() ? "Yes" : "No"));
            System.out.println("✔ Contains Symbols:   " + (result.hasSpecial() ? "Yes" : "No"));
            System.out.println("=========================================");
        }
    }
}

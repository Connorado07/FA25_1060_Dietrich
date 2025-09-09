import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your grade: ");
        double grade = scanner.nextDouble();
        if (grade < 0) {
            System.out.println("Error: Grade cannot be negative.");
        }
        else if (grade >= 92) {
            System.out.println("Your grade is A.");
        }
        else if (grade >= 89) {
            System.out.println("Your grade is A-.");
        }
        else if (grade >= 87) {
            System.out.println("Your grade is B+.");
        }
        else if (grade >= 82) {
            System.out.println("Your grade is B.");
        }
        else if (grade >= 79) {
            System.out.println("Your grade is B-.");
        }
        else if (grade >= 77) {
            System.out.println("Your grade is C+.");
        }
        else if (grade >= 72) {
            System.out.println("Your grade is C.");
        }
        else if (grade >= 69) {
            System.out.println("Your grade is C-.");
        }
        else if (grade >= 67) {
            System.out.println("Your grade is D+.");
        }
        else if (grade >= 60) {
            System.out.println("Your grade is D.");
        }
        else {
            System.out.println("Your grade is F.");
        }
        
        scanner.close();
    }
}
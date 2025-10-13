import java.util.Scanner;

public class ArrayReversal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array to hold up to 100 positive integers
        int[] numbers = new int[100];

        // Counter to keep track of the actual number of elements read
        int count = 0;
        int input;

        System.out.println("Enter values (-1 to stop)");

        // Loop to read integers until -1 is entered or the array is full
        while (count < numbers.length) {
            System.out.print(": ");
            
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();

                // Check for the end value
                if (input == -1) {
                    break; 
                }

                // Only store if the input is positive
                numbers[count] = input;
                count++;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); 
            }
        }

        scanner.close();

        System.out.println("Your values, reversed:");

        // Loop backwards through the array starting from the last valid element stored
        for (int i = count - 1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }
    }
}

import java.util.Scanner;
import java.util.Arrays;

public class StringSorting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many strings will you enter? ");
        
        int numStrings = 0;
        try {
            numStrings = scanner.nextInt();
            scanner.nextLine(); 
            
            if (numStrings <= 0) {
                System.out.println("Please enter a positive number of strings. Exiting.");
                return;
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a whole number. Exiting.");
            return;
        }

        String[] stringsArray = new String[numStrings];

        System.out.println("\nPlease enter the " + numStrings + " strings (no spaces allowed):");
        for (int i = 0; i < numStrings; i++) {
            System.out.print("String " + (i + 1) + ": ");
            stringsArray[i] = scanner.nextLine();
        }

        System.out.println("Initial Array: " + Arrays.toString(stringsArray));
        
        String[] originalArrayCopy = Arrays.copyOf(stringsArray, numStrings);

        sortStringsBubble(stringsArray, "A-Z");
        System.out.println("Result 1 (Alphabetical A-Z):");
        System.out.println(Arrays.toString(stringsArray));


        sortStringsBubble(originalArrayCopy, "Z-A");
        System.out.println("Result 2 (Reverse Alphabetical Z-A):");
        System.out.println(Arrays.toString(originalArrayCopy));
    }

   public static void sortStringsBubble(String[] arr, String order) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                int comparisonResult = arr[j].compareTo(arr[j+1]);
                
                boolean shouldSwap = false;
                
                if (order.equalsIgnoreCase("A-Z")) {
                    if (comparisonResult > 0) {
                        shouldSwap = true;
                    }
                } else if (order.equalsIgnoreCase("Z-A")) {
                    if (comparisonResult < 0) {
                        shouldSwap = true;
                    }
                }

                if (shouldSwap) {
                    // Standard Bubble Sort swap logic
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
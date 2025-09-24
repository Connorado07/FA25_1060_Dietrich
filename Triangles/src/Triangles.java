import java.util.Scanner;

public class Triangles {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueChoice;
        
        do {
            //get valid size input
            int size = getValidSize(scanner);

            //get fill character
            System.out.print("Enter fill: ");
            String fill = scanner.next();
            
            printTriangle(size, fill);

            //prompt user to continue (y/n)
            System.out.print("Would you like another triangle (Y/N)?\n: ");
            continueChoice = scanner.next().toUpperCase();
            
        } while (continueChoice.equals("Y"));
    }

    /*
     * gets a valid size input from the user between 1 and 50
     * prompts repeatedly until a valid input is received
     */
    
    private static int getValidSize(Scanner scanner) {
        int size;
        
        while (true) {
            System.out.print("Enter size: ");
            size = scanner.nextInt();
            
            if (size >= 1 && size <= 50) {
                return size;
            } else {
                System.out.println("Size must be between 1-50!");
            }
        }
    }


    /*
     * prints a triangle pattern with the specified size and fill character
     */
    private static void printTriangle(int size, String fill) {
        for (int row = 1; row <= size; row++) {
            // print leading spaces
            for (int spaces = 0; spaces < size - row; spaces++) {
                System.out.print(" ");
            }
            
             for (int col = 0; col < row; col++) {
                System.out.print(fill);
                if (col < row - 1) { //makes it so it doesnt print a space after the last character
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }
}
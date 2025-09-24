import java.util.Scanner;

public class Triangles {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueChoice;
        
        do {
            int size = getValidSize(scanner);
            System.out.print("Enter fill: ");
            String fill = scanner.next();
            
            printTriangle(size, fill);
            
            System.out.print("Would you like another triangle (Y/N)?\n: ");
            continueChoice = scanner.next().toUpperCase();
            
        } while (continueChoice.equals("Y"));
    }
    
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
    
    private static void printTriangle(int size, String fill) {
        for (int row = 1; row <= size; row++) {
            for (int spaces = 0; spaces < size - row; spaces++) {
                System.out.print(" ");
            }
            
             for (int col = 0; col < row; col++) {
                System.out.print(fill);
                if (col < row - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }
}
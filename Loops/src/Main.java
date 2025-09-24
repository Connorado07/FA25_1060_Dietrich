import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();
        
        int forTotal = 0;
        for (int i = 1; i <= n; i++) {
            forTotal += i;
        }

        int whileTotal = 0;
        while(true) {
            int i = 1;
            while (i <= n) {
                whileTotal += i;
                i++;
            }
            break;
        }

        System.out.println("Sum using for loop: " + forTotal);
        System.out.println("Sum using while loop: " + whileTotal);




        
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        double subtotal = 0.0;
        double taxRate = 0.053;
        DecimalFormat df = new DecimalFormat("0.00");

        try {

            BufferedReader br = new BufferedReader(new FileReader("TotalCalculation/src/items.txt"));
            Scanner scanner = new Scanner(br);

            // Read values in a loop
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    subtotal += scanner.nextDouble();
                } else {
                    scanner.next();
                }
            }
            scanner.close();

            double tax = subtotal * taxRate;
            double finalTotal = subtotal + tax;

            FileWriter writer = new FileWriter("TotalCalculation/src/total.txt");
            writer.write("The sub-total is $" + df.format(subtotal) + "\n");
            writer.write("The tax is $" + df.format(tax) + "\n");
            writer.write("The total is $" + df.format(finalTotal) + "\n");
            writer.close();

            System.out.println("Calculation complete. Results written to total.txt");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double inRadius = input.nextDouble();

        System.out.printf("Area: %.2f%nDiameter: %.2f%nCircumference: %.2f%n ", areaOfCircle(inRadius), diameterOfCircle(inRadius), circumferenceOfCircle(inRadius));

        input.close();
        }

    public static double areaOfCircle(double radius) {
        return Math.PI * radius * radius;
    }

    public static double diameterOfCircle(double radius) {
        return 2 * radius;
    }

    public static double circumferenceOfCircle(double radius) {
        return 2 * Math.PI * radius;
    }
}
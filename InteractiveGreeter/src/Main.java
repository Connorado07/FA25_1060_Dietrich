import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = scanner.nextLine();
        System.out.print("Where are you from? ");
        String location = scanner.nextLine();
        System.out.print("How old are you (years)? ");
        String age = scanner.nextLine();
        System.out.println("Hello " + name + " from " + location + ". You are " + age + " years old.");
        System.out.print("What's something you like to do? ");
        String activity = scanner.nextLine();
        System.out.println("Have fun next time you " + activity + "!");
        System.out.print("How much would you like to donate today? ");
        String donation = scanner.nextLine();
        System.out.println("You will donate $" + donation + " today. Yay!");
        scanner.close();
    }
}
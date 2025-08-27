import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Where are you from? ");
        String location = input.nextLine();
        System.out.print("How old are you (in years)? ");
        int age = input.nextInt();
        System.out.print("Hi there "+name+" from "+location+". You are "+age+" years old.\n");
        System.out.println("What's something you like to do? ");
        String test = input.nextLine();
        System.out.println("Have fun next time you " + test + "!");
        /*System.out.println("How much would you like to donate today? ");
        double donation =  input.nextDouble();
        System.out.println("You will donate $"+donation+" today. Thank you!!");*/
    }
}
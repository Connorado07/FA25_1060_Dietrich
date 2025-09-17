import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of bottles to start with: ");
        int bottles = input.nextInt();

        int i;
        for(i = bottles; i > 0; i--) {
            System.out.printf("%d bottles of beer on the wall, %d bottles of beer.%n", i, i);
            System.out.printf("Take one down and pass it around, %d bottles of beer on the wall.%n%n", i - 1);
        } if(i==0){
            System.out.println("0 bottles of beer on the wall, 0 bottles of beer.");
            System.out.println("Go to the store and buy some more, " + bottles + " bottles of beer on the wall.");
        }
        input.close();
    }
}
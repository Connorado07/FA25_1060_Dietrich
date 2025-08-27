import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter the temperature in Fahrenheit: ");

        double tempF = userInput.nextDouble();

        double celConversion =  (double) 5 /9;

        double tempC = (tempF-32) * celConversion;
        BigDecimal value = new BigDecimal(tempC);
        BigDecimal trunTempC = value.setScale(2, RoundingMode.DOWN);

        double tempK = tempF + 273.15;

        System.out.println("The temperature " + tempF + "°F is equivalent to " + trunTempC +
                                "°C, and is equivalent to " + tempK + "°K");
    }
}
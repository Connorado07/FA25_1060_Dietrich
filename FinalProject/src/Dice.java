import java.util.Random;

public class Dice {
    private int numSides;
    private int numRolls;
    private Random random;
    
    public Dice(int numSides, int numRolls) {
        this.numSides = numSides;
        this.numRolls = numRolls;
        this.random = new Random();
    }
    
    public int roll() {
        int total = 0;
        for (int i = 0; i < numRolls; i++) {
            total += random.nextInt(numSides) + 1;
        }
        return total;
    }
    
    public int rollWithAdvantage() {
        // Roll twice, take the higher
        int roll1 = roll();
        int roll2 = roll();
        return Math.max(roll1, roll2);
    }
    
    public int rollWithDisadvantage() {
        // Roll twice, take the lower
        int roll1 = roll();
        int roll2 = roll();
        return Math.min(roll1, roll2);
    }
    
    public int getNumSides() {
        return numSides;
    }
    
    public int getNumRolls() {
        return numRolls;
    }
    
    @Override
    public String toString() {
        return numRolls + "d" + numSides;
    }
}
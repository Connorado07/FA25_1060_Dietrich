import java.util.Random;

public class Die {
    private int numSides;
    private int value;

    public Die(){
        this.numSides = 6;
        this.value = -1; 
    }

    public Die(int numSides){
        this.numSides = numSides;
        this.value = -1; 
    }

    public int getNumSides(){
        return this.numSides;
    }

    public void getNumSides(int numSides){
        this.numSides = numSides;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void roll(){
        Random rand = new Random();
        this.value = rand.nextInt(this.numSides) + 1;
    }
}

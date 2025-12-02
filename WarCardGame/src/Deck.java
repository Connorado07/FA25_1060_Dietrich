import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final int MIN_RANK = 2;
    private static final int MAX_RANK = 14; // Ace is high

    public Deck() {
        cards = new ArrayList<>(52);
        for (String suit : SUITS) {
            for (int rank = MIN_RANK; rank <= MAX_RANK; rank++) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    
    public List<Card> subDeck(int start, int end) {
        // The List.subList(fromIndex, toIndex) method is exclusive for the end index,
        // use end + 1 to match the inclusive range (0-25 and 26-51) in the driver
        if (start < 0 || end >= cards.size() || start > end) {
            throw new IndexOutOfBoundsException("Invalid subDeck range.");
        }
        return cards.subList(start, end + 1);
    }
    
    public List<Card> getCards() {
        return cards;
    }
}
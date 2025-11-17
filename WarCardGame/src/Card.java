public class Card {
    private final int rank;
    private final String suit;

    private static final String[] RANK_SYMBOLS = {
        "", "", // Ranks 0 and 1 unused
        "2", "3", "4", "5", "6", "7", "8", "9", "10", 
        "Jack", "Queen", "King", "Ace" // Ranks 11, 12, 13, 14
    };
    
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        String rankName;
        
        // Use the static array to get the rank name based on the rank value.
        if (rank >= 2 && rank <= 14) {
            rankName = RANK_SYMBOLS[rank];
        } else {
            rankName = "Unknown Rank";
        }
        
        return rankName + " of " + suit;
    }

    public int compareTo(Card other) {
        // Compares based on rank. A positive result means 'this' card is higher.
        return this.rank - other.rank;
    }
}
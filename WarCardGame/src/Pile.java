import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class Pile {
    private List<Card> cards;

    public Pile() {
        this.cards = new ArrayList<>();
    }

    
    //checks if the pile is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }


    //Draws the top card from the pile.
    //Removes the element at index 0 (the top).
    public Card pop() {
        if (cards.isEmpty()) {
            throw new java.util.NoSuchElementException("Cannot pop from an empty pile.");
        }
        // Remove from the top of the pile
        return cards.remove(0); 
    }

    
    //Adds a single card to the bottom of the pile (winner's action).
    public void add(Card card) {
        cards.add(card); // Adds to the end of the List, acting as the bottom of the pile
    }
    
    //Adds a collection of cards (like a sub-deck or war pile) to the bottom of this pile.
    public void addDeck(Collection<Card> cards) {
        this.cards.addAll(cards);
    }
    
    
    //Gets the current size of the pile.
    public int size() {
        return cards.size();
    }
}
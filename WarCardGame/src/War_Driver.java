public class War_Driver {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.shuffle();
        deck.shuffle();
        Pile p1 = new Pile();
        p1.addDeck(deck.subDeck(0, 25));

        Pile p2 = new Pile();
        p2.addDeck(deck.subDeck(26, 51));

        Pile center = new Pile();
        int diff = -1;
        while(!p1.isEmpty() && !p2.isEmpty()) 
        {
            if(diff != 0) 
            {
                center = new Pile();
            }

            Card c1 = p1.pop();
            Card c2 = p2.pop();            
            System.out.println(c1 + " , " + c2);

            diff = c1.getRank() - c2.getRank();
            if(diff > 0) 
            {
                while(!center.isEmpty()) {
                    Card card = center.pop();
                    p1.add(card);
                }
            } 
            else if (diff < 0) 
            {
                while(!center.isEmpty()) 
                {
                    Card card = center.pop();
                    p2.add(card);
                }

            } 
            else 
            {
                System.out.println("WAR!!!");
                for (int i = 0; i < 3; i++) {
                    if(!p1.isEmpty() && !p2.isEmpty()) 
                    {
                        center.add(p1.pop());
                        center.add(p2.pop());
                    }
                }
            }
        }
        System.out.println();
        if(p1.isEmpty()) 
        {
            System.out.println("Player 2 Wins!");
        } 
        else 
        {
            System.out.println("Player 1 Wins!");
        }
    }

    private static int binSearch(Card[] cards, Card target){
        int low =0;
        int high = cards.length -1;
        while(low <= high){
            System.out.println(low + ", " + high);
            int mid = (low + high) /2;
            int comp = cards[mid].compareTo(target);
            if(comp==0){
                return mid;
            } else if (comp<0){
                low=mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    private static int search(Card[] cards, Card target){
        for(int i=0; i<cards.length; i++){
            if(cards[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    private static void printDeck(Card[] cards){
        for(int i=0; i<cards.length; i++){
            System.out.println(cards[i]);
            if(i%13 == 0 && i !=0){
                System.out.println();
            }
        }
    }
}
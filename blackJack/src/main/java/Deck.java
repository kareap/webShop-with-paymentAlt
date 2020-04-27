import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private String[] types = {"hearts", "spades", "diamonds", "clubs"};
    private List<PlayingCard> deckOfCards = new ArrayList<>();
    //List<PlayingCard> shuffledCards = new ArrayList<>();

    void createDeck() {
        for (String t : types) {
            for (int i = 1; i < 14; i++) {
                if (i == 1) {
                    deckOfCards.add((new PlayingCard(i, 11, t, true)));
                }
                deckOfCards.add(new PlayingCard(i, i, t, true));
            }
        }
    }

   List<PlayingCard> shuffleDeck(Deck deck) {
        Collections.shuffle(deck.deckOfCards);
        return deckOfCards;
        //vil egentlig lagre dette i ny liste og returnere den nye
    }

    PlayingCard pickCard() {
        if (deckOfCards.size() != 0) {
            PlayingCard pickedCard = deckOfCards.get(0);
            deckOfCards.remove(0);
            return pickedCard;
        }
        else {
            //System.out.println("There are no more cards in the deck!");
            //kaste exception??
            return null;
        }
    }
}

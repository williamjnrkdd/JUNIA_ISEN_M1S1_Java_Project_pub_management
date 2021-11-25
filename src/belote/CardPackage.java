package belote;


import java.util.ArrayList;
import java.util.List;

public class CardPackage {
    private List<Card> newCards = new ArrayList<Card>();
    private List<Card> cards = new ArrayList<Card>(32);
    private static final Color HEART = new Color("HEART");
    private static final Color SPADE = new Color("SPADE");
    private static final Color CLUBS = new Color("CLUBS");
    private static final Color DIAMOND = new Color("DIAMOND");
    private static final Figure ACE = new Figure("ACE", 11, 11);
    private static final Figure KING = new Figure("KING", 4, 4);
    private static final Figure QUEEN = new Figure("QUEEN", 3, 3);
    private static final Figure JACK = new Figure("JACK", 2, 20);
    private static final Figure TEN = new Figure("TEN", 10, 10);
    private static final Figure NINE = new Figure("NINE", 0, 14);
    private static final Figure EIGHT = new Figure("EIGHT", 0, 0);
    private static final Figure SEVEN = new Figure("SEVEN", 0, 0);

    public CardPackage() {
        newCards.add(new Card(HEART, ACE));
        newCards.add(new Card(HEART, KING));
        newCards.add(new Card(HEART, QUEEN));
        newCards.add(new Card(HEART, JACK));
        newCards.add(new Card(HEART, TEN));
        newCards.add(new Card(HEART, NINE));
        newCards.add(new Card(HEART, EIGHT));
        newCards.add(new Card(HEART, SEVEN));
        newCards.add(new Card(SPADE, ACE));
        newCards.add(new Card(SPADE, KING));
        newCards.add(new Card(SPADE, QUEEN));
        newCards.add(new Card(SPADE, JACK));
        newCards.add(new Card(SPADE, TEN));
        newCards.add(new Card(SPADE, NINE));
        newCards.add(new Card(SPADE, EIGHT));
        newCards.add(new Card(SPADE, SEVEN));
        newCards.add(new Card(CLUBS, ACE));
        newCards.add(new Card(CLUBS, KING));
        newCards.add(new Card(CLUBS, QUEEN));
        newCards.add(new Card(CLUBS, JACK));
        newCards.add(new Card(CLUBS, TEN));
        newCards.add(new Card(CLUBS, NINE));
        newCards.add(new Card(CLUBS, EIGHT));
        newCards.add(new Card(CLUBS, SEVEN));
        newCards.add(new Card(DIAMOND, ACE));
        newCards.add(new Card(DIAMOND, KING));
        newCards.add(new Card(DIAMOND, QUEEN));
        newCards.add(new Card(DIAMOND, JACK));
        newCards.add(new Card(DIAMOND, TEN));
        newCards.add(new Card(DIAMOND, NINE));
        newCards.add(new Card(DIAMOND, EIGHT));
        newCards.add(new Card(DIAMOND, SEVEN));
    }

    public void mixing() {
        int number;
        for (int i = 32; i > 0; i--) {
            number = (int) (Math.random() * i);
            cards.add(newCards.get(number));
            newCards.remove(number);
        }
    }

    public void cut() {
        int random = (int) (Math.random() * 31);
        cards.addAll(cards.subList(random, 32));
        cards.addAll(cards.subList(0, random));
        for (int i = 0; i < 31; i++) {
            cards.remove(0);
        }
    }

    public void distribute(Player player, int cardsNumber) {
        for (int i = 0; i < cardsNumber; i++) {
            player.getCards().add(cards.get(0));
            cards.remove(0);
        }
    }

    public Card display() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }


    public List<Card> getCards() {
        return cards;
    }

}

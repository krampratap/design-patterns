package a_ObjectOriented.b_BlackJack;

import java.util.ArrayList;
import java.util.List;

class Hand {
    private final List<Card> cards;
    private int score;

    public Hand() {
        this.score = 0;
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
        if (card.getValue() == 1) {
            score += (score + 11 <= 21) ? 11 : 1;
        } else {
            score += card.getValue();
        }
    }

    public int getScore() {
        return score;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void print() {
        for (Card card : cards) {
            System.out.println(card.getSuit() + ", " + card.getValue());
        }
    }
}

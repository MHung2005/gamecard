package module;

import java.util.ArrayList;
import java.util.List;

public class Playerofblackjack {
	private int score;
	private List<Card> hand;

	public Playerofblackjack() {
		hand = new ArrayList<>();
		score = 0;
	}

	public Playerofblackjack(String name) {
		this.hand = new ArrayList<>();
	}

	public void drawCard(Deck deck) {
		hand.add(deck.drawCard());
	}

	public int calculateHandValue() {
		int total = 0;
		int aceCount = 0;

		for (Card card : hand) {
			total += card.getCardValue();
			if (card.getValue().equals("A")) {
				aceCount++;
			}
		}

		while (total > 21 && aceCount > 0) {
			total -= 10;
			aceCount--;
		}

		return total;
	}

	public void addCard(Card card) {
		hand.add(card);
		score += card.getCardValue();
	}

	public int getScore() {
		return score;
	}

	public void reset() {
		hand.clear();
		score = 0;
	}

	public List<Card> getHand() {
		return hand;
	}

	public boolean isBust() {
		return calculateHandValue() > 21;
	}
}

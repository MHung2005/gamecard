package module;

public class Cardofblackjack implements Card {
	private String value;
	private String suit;

	public Cardofblackjack(String value, String suit) {
		this.value = value;
		this.suit = suit;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getSuit() {
		return suit;
	}

	@Override
	public int getCardValue() {
		switch (value) {
		case "J":
		case "Q":
		case "K":
			return 10;
		case "A":
			return 11; // Trong game Blackjack, Át có thể là 1 hoặc 11
		default:
			return Integer.parseInt(value);
		}
	}

	@Override
	public int getTypeValue() {
		switch (suit) {
		case "♠":
			return 1;
		case "♣":
			return 2;
		case "♦":
			return 3;
		case "♥":
			return 4;
		default:
			return 0;
		}
	}

	@Override
	public String toString() {
		return value + " of " + suit;
	}

	public boolean compareCard(Card t) {
		return true;
	}
}

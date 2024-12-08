package module;

public class CardofTienLen implements Card {
	private String value;
	private String suit;

	public CardofTienLen() {
	}

	public CardofTienLen(String value, String suit) {
		this.value = value;
		this.suit = suit;
	}

	public int getCardValue() {
		switch (value) {
		case "J":
			return 11;
		case "Q":
			return 12;
		case "K":
			return 13;
		case "A":
			return 14;
		default:
			return Integer.parseInt(value);
		}
	}

	public int getTypeValue() {
		switch (suit) {
		case "♠":
			return 1;
		case "♦":
			return 2;
		case "♣":
			return 3;
		case "♥":
			return 4;
		default:
			return 0;
		}
	}

	// Hàm trả về thông tin lá bài với định dạng đẹp
	@Override
	public String toString() {
		return value + "_of_" + suit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setType(String suit) {
		this.suit = suit;
	}

	@Override
	public String getSuit() {
		return suit;
	}

	@Override
	public boolean compareCard(Card otherCard) {
		if (this.getCardValue() != otherCard.getCardValue()) {
			return this.getCardValue() > otherCard.getCardValue();
		}
		return this.getTypeValue() > otherCard.getTypeValue();
	}

}
package module;

public interface Card {
	String getValue(); // Giá trị bài, ví dụ: "A", "2", "10"

	String getSuit(); // Chất bài, ví dụ: "♥", "♦"

	int getCardValue(); // Điểm bài tùy thuộc vào logic game

	int getTypeValue();

	String toString();

	boolean compareCard(Card t);
}
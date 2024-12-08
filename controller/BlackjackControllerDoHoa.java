package controller;

import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import module.Card;
import module.Cardofblackjack;
import module.Deck;
import module.Playerofblackjack;

public class BlackjackControllerDoHoa {

	private Deck deck;
	private HashMap<String, Playerofblackjack> players;

	@FXML
	private HBox playerHand;
	@FXML
	private HBox dealerHand;
	@FXML
	private Button hitButton;
	@FXML
	private Button standButton;
	@FXML
	private Button dealButton;
	@FXML
	private Label gameStatus;

	@FXML
	private void initialize() {
		deck = new Deck();
		players = new HashMap<>();

		// Khởi tạo người chơi và nhà cái
		players.put("player", new Playerofblackjack());
		players.put("dealer", new Playerofblackjack());

		// Tạo bộ bài mới và trộn bài
		createAndShuffleDeck();

		setupButtons();
	}

	private void createAndShuffleDeck() {
		deck = new Deck();

		// Tạo 52 lá bài
		String[] suits = { "♠", "♥", "♦", "♣" };
		String[] values = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

		for (String suit : suits) {
			for (String value : values) {
				deck.addCard(new Cardofblackjack(value, suit));
			}
		}

		deck.shuffleDeck(); // Trộn bài
	}

	private void setupButtons() {
		hitButton.setDisable(true);
		standButton.setDisable(true);
		dealButton.setDisable(false);
		gameStatus.setText("Welcome to Blackjack!");
	}

	@FXML
	private void dealCards() {
		// Reset lại trạng thái trò chơi
		resetGame();

		// Rút 2 lá bài cho người chơi và nhà cái
		for (int i = 0; i < 2; i++) {
			players.get("player").addCard(deck.drawCard());
			players.get("dealer").addCard(deck.drawCard());
		}

		// Hiển thị bài trên giao diện
		displayCards();

		// Cập nhật trạng thái và kích hoạt nút
		hitButton.setDisable(false);
		standButton.setDisable(false);
		dealButton.setDisable(true);

		updateGameStatus();
	}

	@FXML
	private void hit() {
		// Người chơi rút thêm bài
		players.get("player").addCard(deck.drawCard());
		displayCards();

		// Kiểm tra nếu người chơi vượt quá 21 điểm
		if (players.get("player").getScore() > 21) {
			endGame("You busted! Dealer wins!");
		}
	}

	@FXML
	private void stand() {
		// Nhà cái chơi
		while (players.get("dealer").getScore() < 17) {
			players.get("dealer").addCard(deck.drawCard());
		}

		// Hiển thị bài và xác định người chiến thắng
		displayCards();
		determineWinner();
	}

	private void resetGame() {
		players.get("player").reset();
		players.get("dealer").reset();
		playerHand.getChildren().clear();
		dealerHand.getChildren().clear();
		createAndShuffleDeck();
	}

	private void displayCards() {
		playerHand.getChildren().clear();
		dealerHand.getChildren().clear();

		// Hiển thị bài người chơi
		for (Card card : players.get("player").getHand()) {
			playerHand.getChildren().add(createCardImageView(card));
		}

		// Hiển thị bài nhà cái
		for (Card card : players.get("dealer").getHand()) {
			dealerHand.getChildren().add(createCardImageView(card));
		}
	}

	private ImageView createCardImageView(Card card) {
		ImageView imageView = new ImageView(new Image(
				getClass().getResourceAsStream("/resources/card/" + card.getValue() + card.getSuit() + ".png")));
		imageView.setFitWidth(80);
		imageView.setFitHeight(120);
		imageView.setPreserveRatio(true);
		return imageView;
	}

	private void updateGameStatus() {
		int playerScore = players.get("player").getScore();
		gameStatus.setText("Your score: " + playerScore);
	}

	private void determineWinner() {
		int playerScore = players.get("player").getScore();
		int dealerScore = players.get("dealer").getScore();

		if (playerScore > 21) {
			endGame("You busted! Dealer wins!");
		} else if (dealerScore > 21) {
			endGame("Dealer busted! You win!");
		} else if (playerScore > dealerScore) {
			endGame("You win!");
		} else if (playerScore < dealerScore) {
			endGame("Dealer wins!");
		} else {
			endGame("It's a tie!");
		}
	}

	private void endGame(String message) {
		gameStatus.setText(message);
		hitButton.setDisable(true);
		standButton.setDisable(true);
		dealButton.setDisable(false);
	}
}

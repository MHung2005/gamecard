package module;

/*
 * Lớp Player đại diện cho người chơi
 * Mỗi người chơi sẽ sở hữu các lá bài tức sở hữu một Deck
 * Do đó ta sẽ cho lớp Player kế thừa lớp Deck
 * Cùng với đó mỗi Player sẽ có thêm các thuộc tính như tên, trạng thái trong vòng ....
 */

public class Player extends Deck {
	/*
	 * Trạng thái trong vòng chơi của người chơi sẽ có 3 trạng thái Bỏ lượt là người
	 * chơi đã bỏ qua vòng chơi và không còn quyền tham gia Trong vòng là người chơi
	 * đang trong vòng Và hết bài là người chơi đã đánh hết bài trong tay và về
	 */
	public enum PlayerState {
		BO_LUOT, TRONG_VONG, HET_BAI
	}

	// Các thuộc tính của người chơi như Trạng thái, tên, STT, và số dư
	private PlayerState playerState;
	private String playerName;
	private int playerNum;
	private int playerRank;

	// constructer
	public Player() {
	}

	// tiếp tục là constructer
	public Player(String playerName, double playerBallance, int playerNum) {
		this.playerState = PlayerState.TRONG_VONG;
		this.playerName = playerName;
		this.playerNum = playerNum;
		this.playerRank = 0;
	}

	// Check trạng thái của người chơi, nếu đang trong vòng chơi sẽ trả về true
	public Boolean checkState() {
		switch (playerState) {
		case TRONG_VONG:
			return true;
		default:
			return false;
		}
	}

	// Phương thức trả về trạng thái người chơi
	public PlayerState getPlayerState() {
		return playerState;
	}

	// Phương thức trả về tên người chơi
	public String getPlayerName() {
		return playerName;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	// Phương thức đặt lại trạng thái
	public void setPlayerState(PlayerState playerState) {
		this.playerState = playerState;
	}

	public int getPlayerRank() {
		return playerRank;
	}

	public void setPlayerName(String text) {
		this.playerName = text;
	}
}

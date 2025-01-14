package imageAction;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class BackgroundImageView {
	public static Background set() {
		try {
			Image background = new Image(
					BackgroundImageView.class.getResource("/resources/card/background.png").toExternalForm());
			BackgroundImage bgImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
					new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
			return new Background(bgImage);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

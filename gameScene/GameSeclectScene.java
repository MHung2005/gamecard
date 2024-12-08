package gameScene;

import java.io.IOException;

import application.Main;
import imageAction.BackgroundImageView;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameSeclectScene {
	public static Scene create(Stage primaryStage) {
		VBox selectPane = new VBox(20);
		selectPane.setAlignment(Pos.CENTER);

		Label label = new Label("Chọn Game và chế độ chơi");
		label.setStyle("-fx-font-size: 18px; -fx-text-fill: white;");

		Button button1 = new Button("Tiến lên miền nam giao diện đẹp");
		button1.setOnAction(e -> {
			primaryStage.setScene(InputScene.create(primaryStage, 0));
		});

		Button button2 = new Button("Tiến lên miền nam giao diện Basic");
		button2.setOnAction(e -> {
			primaryStage.setScene(InputScene.create(primaryStage, 1));
		});

		Button button3 = new Button("BlackJack giao diện đẹp");
		button3.setOnAction(e -> {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/gameScene/BlackjackDohoa.fxml"));
			Scene scene = null;
			try {
				scene = new Scene(loader.load());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			primaryStage.setScene(scene);
		});

		Button button4 = new Button("BlackJack giao diện Basic");
		button4.setOnAction(e -> {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/gameScene/Blackjackbasic.fxml"));
			Scene scene = null;
			try {
				scene = new Scene(loader.load());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			primaryStage.setScene(scene);

		});

		selectPane.getChildren().addAll(label, button1, button2, button3, button4);

		StackPane inputRoot = new StackPane();
		inputRoot.setPrefSize(1200, 700);
		inputRoot.setBackground(BackgroundImageView.set());
		inputRoot.getChildren().add(selectPane);

		return new Scene(inputRoot, 1200, 700);
	}
}
package com.vinstorm.javafx_experiments.dev.vinayak.aaaab;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class ABC extends Application{

	Group root = new Group();
	Scene scene = new Scene(root, 1280, 720);
	static File file = new File(("D:\\Eclipse-Workspace\\JavaFX_Experiments\\src\\com\\vinstorm\\javafx_experiments\\dev\\vinayak\\aaaab\\robberySceneV2.mp4"));
	static Media media = new Media(file.toURI().toString());
	static MediaPlayer HEADPHONE_PLAYER = new MediaPlayer(media);
	static MediaView HEADPHONE_VIEW = new MediaView(HEADPHONE_PLAYER);
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {
		root.getChildren().add(HEADPHONE_VIEW);
		HEADPHONE_PLAYER.play();
		HEADPHONE_PLAYER.setOnError(() -> System.out.println("error?"));
		window.show();
		window.setScene(scene);
	}
}

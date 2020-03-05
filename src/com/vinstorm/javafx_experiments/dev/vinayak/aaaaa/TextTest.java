package com.vinstorm.javafx_experiments.dev.vinayak.aaaaa;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TextTest extends Application {

	private Group root;
	private Scene scene;
	private Text text;
	private Glow glow;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new Group();
		scene = new Scene(root, 1280, 720);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TEXT!!!!!!");
		
		for(int i = 0; i < 5; i++) {
			new Stage().setScene(new Scene(new Group(), 1280, 720));
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package com.vinstorm.javafx_experiments.dev.vinayak.aaaao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * 
 * @author vinay
 *
 */
public class FxmlTest extends Application {
	
	static Stage window;
	static Scene scene;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = FXMLLoader.load(getClass().getResource("layoutTestV3.fxml"));
		scene = new Scene(root, 1575, 720);
		
		window = primaryStage;
		window.setTitle("solarsystem test");
		window.setScene(scene);
		window.setMinWidth(1575);
		window.setMinHeight(720);
		window.show();
	}
}

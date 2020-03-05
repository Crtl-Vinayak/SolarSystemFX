package com.vinstorm.javafx_experiments.dev.vinayak.aaaam;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxmlTest {

	static GridPane root;
	
	public void loadFxml() throws IOException {
		root = FXMLLoader.load(getClass().getResource("layoutTest.fxml"));
	}
	
	public static void openFxmlWindow() throws IOException {
		Stage window = new Stage();
		
		window.setScene(new Scene(root, 1280, 720));
		window.show();
	}
	
	
	
	
}
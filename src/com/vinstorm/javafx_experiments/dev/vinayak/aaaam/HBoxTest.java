package com.vinstorm.javafx_experiments.dev.vinayak.aaaam;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxTest {

	static HBox hbox;
	static Scene scene;
	static Stage window;
	
	public static void _HBoxTest_Setup() {
		hbox = new HBox();
		scene = new Scene(hbox, 640, 360);
		window = new Stage();
		window.setScene(scene);
		window.setTitle("HBox Test");
		
		
		
		hbox.setSpacing(10);
		
	}
	
	public static void hboxShow() {
		window.show();
	}
}

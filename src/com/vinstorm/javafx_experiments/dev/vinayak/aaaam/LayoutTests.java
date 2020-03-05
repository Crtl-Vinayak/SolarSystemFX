package com.vinstorm.javafx_experiments.dev.vinayak.aaaam;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class LayoutTests extends Application{

	public static Group root;
	public static Scene scene;
	public static Stage window;
	
	static Button[] stageButtons = new Button[11];
	
	static int stageSelected;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// make a program, it haves UI. and if you chooses what stage you will open, it will open the right "layout" stage.
		
		Stop[] stops = new Stop[] {new Stop(0, Color.DARKGRAY), new Stop(1, Color.DIMGRAY), new Stop(2, Color.DARKSLATEGREY)};
		LinearGradient lg = new LinearGradient(0, 0, 480, 320, false, CycleMethod.NO_CYCLE, stops);
		
		root = new Group();
		scene = new Scene(root, 480, 320, true, SceneAntialiasing.BALANCED);
		scene.setFill(lg);
		window = primaryStage;
		window.setScene(scene);
		window.setTitle("layout manager");
		window.show();
		
		TextField tf = new TextField();
		tf.setLayoutX(10);
		tf.setLayoutY(10);
		tf.setPrefWidth(320);
		tf.setPrefHeight(20);
		
		Button but = new Button("Submit");
		but.setLayoutX(10 + 320 + 10);
		but.setLayoutY(10);
		but.setPrefWidth(80);
		but.setPrefHeight(20);
		
		but.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for (int i = 1; i < 10; i++) {
					if (tf.getText().equals(String.valueOf(i))) {
						stageSelected = i;
						try {
							LayoutStage.openSpecificStage(stageSelected);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						tf.setText("");
					}	
				}
			}
		});
		
		root.getChildren().addAll(tf, but);
		
//		Button[] stageButtons = new Button[10];
		for (int i = 0; i < stageButtons.length; i++) {
			stageButtons[i] = new Button();
			stageButtons[i].setLayoutX(i * 40 + 20);
			stageButtons[i].setLayoutY(40 + 10);
			stageButtons[i].setPrefWidth(30);
			stageButtons[i].setPrefHeight(30);
			stageButtons[i].setId("StageButton" + String.valueOf(i));
			stageButtons[i].setText(String.valueOf(i + 1));
			root.getChildren().add(stageButtons[i]);
		}
		
		String[] typeLayouts = new String[] {
			"Hbox", "VBox", "Border Pane", "Stack Pane", "Text Flow", "Anchor Pane",
			"Title Pane", "Grid Pane", "Flow Panel", "Pane", "Fxml Test Layout"
		};
		Label[] labels = new Label[11];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new Label();
			labels[i].setLayoutX(20);
			labels[i].setLayoutY(i * 20 + 90);
			labels[i].setText(typeLayouts[i] + " = " + i);
			root.getChildren().add(labels[i]);
		}
		
		stageFuncButton();
		
		HBoxTest._HBoxTest_Setup();
		VBoxTest._VBoxTest_Setup();
		BorderPaneTest._BorderPaneTest_Setup();
		StackPaneTest._StackPaneTest_Setup();
		TextFlowTest._TextFlowTest_Setup();
		AnchorPaneTest._AnchorPaneTest_Setup();
		TitlePaneTest._TitlePaneTest_Setup();
		GridPaneTest._GridPaneTest_Setup();
		FlowPanelTest._FlowPanelTest_Setup();
	}
	
	@SuppressWarnings("unchecked")
	private static void stageFuncButton() {
		@SuppressWarnings("rawtypes")
		class MyHandler implements EventHandler {

			int i;
			MyHandler(int i){
				this.i = i;
			}
			
			@Override
			public void handle(Event event) {
				stageSelected = i + 1;
				try {
					LayoutStage.openSpecificStage(stageSelected);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		for (int i = 0; i < stageButtons.length; i++) {
			stageButtons[i].setOnAction(new MyHandler(i));
		}
	}
}

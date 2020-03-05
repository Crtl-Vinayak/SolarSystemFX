package com.vinstorm.javafx_experiments.dev.vinayak.aaaac;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * <h1>Collision Testing!</h1>
 * This is the core of the map development.
 * 
 * @author vinayak
 * @version 1.0
 * @since 2019-1-8
 * @category JavaFX_Experiments || TTiming
 */
public class TTiming extends Application {
	
	public final static String GAMETITLE = "OBAMA BATTLEZ || JavaFX Experiments \\/\\/ TTiming || v1.0";
	public static Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();
	public static double monitorWidth = (primaryScreenBounds.getWidth());
	public static double monitorHeight = (primaryScreenBounds.getHeight());
	public static double sceneWidth = (monitorWidth / 1.5);
	public static double sceneHeight = (monitorHeight / 1.5);
	public static double set_fps_to;
	public static boolean isFullScreen;
	public static boolean isConsoleSpamOn;
	
	public static Group root;
	public static Scene scene;
	public static Stage window;
	
	public static Camera camera = new PerspectiveCamera();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new Group();
		scene = new Scene(root, sceneWidth, sceneHeight, Color.MIDNIGHTBLUE);
		window = primaryStage;
		window.setScene(scene);
		window.setTitle(GAMETITLE);
		window.show();
		set_fps_to = 60;
		isFullScreen = false;
		isConsoleSpamOn = false;
		
		LilMap.addMap();
		Sprite.addSprite();
		TTiming.cameraSettings();
		GameLoop.keyMechanism();
		GameLoop.startLoop();
	}
	
	public static void cameraSettings() {
		scene.setCamera(camera);
		TTiming.camera.setTranslateX(Sprite.spriteBoi.getX() - (TTiming.sceneWidth / 2 - 50));
		TTiming.camera.setTranslateY(Sprite.spriteBoi.getY() - (TTiming.sceneHeight / 2 - 50));
	}
}

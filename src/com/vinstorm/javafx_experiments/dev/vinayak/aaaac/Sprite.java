package com.vinstorm.javafx_experiments.dev.vinayak.aaaac;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sprite {
	public static String back1 = Sprite.class.getResource("resources/sprites/back1.png").toExternalForm();
	public static String back2 = Sprite.class.getResource("resources/sprites/back2.png").toExternalForm();
	public static String back3 = Sprite.class.getResource("resources/sprites/back3.png").toExternalForm();
	public static String front1 = Sprite.class.getResource("resources/sprites/front1.png").toExternalForm();
	public static String front2 = Sprite.class.getResource("resources/sprites/front2.png").toExternalForm();
	public static String front3 = Sprite.class.getResource("resources/sprites/front3.png").toExternalForm();
	public static String left1 = Sprite.class.getResource("resources/sprites/left1.png").toExternalForm();
	public static String left2 = Sprite.class.getResource("resources/sprites/left2.png").toExternalForm();
	public static String left3 = Sprite.class.getResource("resources/sprites/left3.png").toExternalForm();
	public static String right1 = Sprite.class.getResource("resources/sprites/right1.png").toExternalForm();
	public static String right2 = Sprite.class.getResource("resources/sprites/right2.png").toExternalForm();
	public static String right3 = Sprite.class.getResource("resources/sprites/right3.png").toExternalForm();

	public static Image back1_img = new Image(back1);
	public static Image back2_img = new Image(back2);
	public static Image back3_img = new Image(back3);
	public static Image front1_img = new Image(front1);
	public static Image front2_img = new Image(front2);
	public static Image front3_img = new Image(front3);
	public static Image left1_img = new Image(left1);
	public static Image left2_img = new Image(left2);
	public static Image left3_img = new Image(left3);
	public static Image right1_img = new Image(right1);
	public static Image right2_img = new Image(right2);
	public static Image right3_img = new Image(right3);

	public static ImageView spriteBoi = new ImageView(front1_img);

	public static boolean back = false;
	public static boolean left = false;
	public static boolean front = true;
	public static boolean right = false;

	public static boolean isPressed = false;
	public static boolean isPressedW = false;
	public static boolean isPressedA = false;
	public static boolean isPressedS = false;
	public static boolean isPressedD = false;
	
	public static void addSprite() {
		spriteBoi.setImage(front1_img);
		spriteBoi.setX(1000);
		spriteBoi.setY(75);
		spriteBoi.setFitWidth(100);
		spriteBoi.setFitHeight(100);
		TTiming.root.getChildren().add(spriteBoi);
	}
}

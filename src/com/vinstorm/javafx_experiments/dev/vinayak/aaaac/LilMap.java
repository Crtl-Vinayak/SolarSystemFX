package com.vinstorm.javafx_experiments.dev.vinayak.aaaac;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LilMap {

	private static Rectangle rect[] = new Rectangle[4];
	
	public static void addMap() {
		for (int i = 0; i < rect.length; i++) {
			rect[i] = new Rectangle();
			rect[i].setX(1000 + (100 * i));
			rect[i].setY(100 + (100 * i));
			rect[i].setWidth(100);
			rect[i].setHeight(100);
			rect[i].setFill(Color.DARKRED);
			TTiming.root.getChildren().add(rect[i]);
		}
	}
}

package com.vinstorm.javafx_experiments.dev.vinayak.aaaac;

import java.time.Duration;

import org.reactfx.util.FxTimer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class Animationz {
	
	private static int repeat = 0;
	
	public static void doAnimate_W() throws Exception {
		//its playing and about 5 seconds later it will
		//say nibba. (:
		//new Timeline(new KeyFrame(Duration.millis(5000), 
		//		ae -> System.out.println("nibba"))).play();
		
		FxTimer.runLater(
	        Duration.ofMillis(20),
	        () -> {
	        for (int i = 0; i < 50; i++) {
	        	FxTimer.runLater(
    		        Duration.ofMillis(5 * i),
    		        () -> {
        		        Sprite.spriteBoi.setY(Sprite.spriteBoi.getY() - 2);
    	        });
	        }
        });
	}
	
	public static void doAnimate_A() throws Exception {
		FxTimer.runLater(
	        Duration.ofMillis(20),
	        () -> {
	        for (int i = 0; i < 50; i++) {
	        	FxTimer.runLater(
    		        Duration.ofMillis(5 * i),
    		        () -> {
        		        Sprite.spriteBoi.setX(Sprite.spriteBoi.getX() - 2);
    	        });
	        }
        });
	}
	
	public static void doAnimate_S() throws Exception {
		FxTimer.runLater(
	        Duration.ofMillis(20),
	        () -> {
	        for (int i = 0; i < 50; i++) {
	        	FxTimer.runLater(
    		        Duration.ofMillis(5 * i),
    		        () -> {
        		        Sprite.spriteBoi.setY(Sprite.spriteBoi.getY() + 2);
    	        });
	        }
        });
	}
	
	public static void doAnimate_D() throws Exception {
		FxTimer.runLater(
	        Duration.ofMillis(20),
	        () -> {
	        for (int i = 0; i < 50; i++) {
	        	FxTimer.runLater(
    		        Duration.ofMillis(5 * i),
    		        () -> {
        		        Sprite.spriteBoi.setX(Sprite.spriteBoi.getX() + 2);
    	        });
	        }
        });
	}
}

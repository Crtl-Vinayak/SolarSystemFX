package com.vinstorm.javafx_experiments.dev.vinayak.aaaac;

import java.time.Duration;

import org.reactfx.util.FxTimer;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameLoop {

	public static int TimeW = 0;
	public static int TimeA = 0;
	public static int TimeS = 0;
	public static int TimeD = 0;
	
	public static boolean WPressed = false;
	public static boolean APressed = false;
	public static boolean SPressed = false;
	public static boolean DPressed = false;
	
	public static void startLoop() {
		FxTimer.runPeriodically(Duration.ofMillis(1000 / 60), () -> {
			if (WPressed == true) {
				
			} else {
				
			}
		});
	}

	public static void keyMechanism() {
		
		TTiming.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				try {
					if (event.getCode() == KeyCode.W) {
						WPressed = true;
						Animationz.doAnimate_W();
					}
					if (event.getCode() == KeyCode.A) {
						APressed = true;
						Animationz.doAnimate_A();
					}
					if (event.getCode() == KeyCode.S) {
						SPressed = true;
						Animationz.doAnimate_S();
					}
					if (event.getCode() == KeyCode.D) {
						DPressed = true;
						Animationz.doAnimate_D();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		TTiming.scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				try {
					if (event.getCode() == KeyCode.W) {
						WPressed = false;
					}
					if (event.getCode() == KeyCode.A) {
						APressed = false;
					}
					if (event.getCode() == KeyCode.S) {
						SPressed = false;
					}
					if (event.getCode() == KeyCode.D) {
						DPressed = false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

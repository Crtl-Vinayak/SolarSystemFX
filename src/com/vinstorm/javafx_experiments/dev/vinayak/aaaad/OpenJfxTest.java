package com.vinstorm.javafx_experiments.dev.vinayak.aaaad;

import java.nio.ByteBuffer;

import javax.swing.JFrame;

//import com.jogamp.opengl.GLCapabilities;
//import com.jogamp.opengl.GLProfile;
//import com.jogamp.opengl.awt.GLCanvas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class OpenJfxTest extends Application {

	private static int width = 1280;
	private static int height = 720;
	private static ByteBuffer byteBuffer;
	
	private static final WritableImage WRITABLE_IMAGE = new WritableImage(640, 480);
	private static final PixelFormat<ByteBuffer> PF = PixelFormat.getByteRgbInstance();
	private static final JFrame JWINDOW = new JFrame("Swing");
	
//	private static GLProfile glProfile = GLProfile.getDefault();
//	private static GLCapabilities glCapabalities = new GLCapabilities(glProfile);
//	private static final GLCanvas GL_CANVAS = new GLCanvas(glCapabalities);
	
	private static Group root = new Group();
	private static Scene scene = new Scene(root, width, height, Color.YELLOW);
	private static Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		OpenJfxTest.doOpenGLStuff();
		OpenJfxTest.openJfxWindow();
	}
	
	private static void doOpenGLStuff() {
		
	}
	
	private static void openJfxWindow() {
		window.setScene(scene);
		window.show();
	}
}

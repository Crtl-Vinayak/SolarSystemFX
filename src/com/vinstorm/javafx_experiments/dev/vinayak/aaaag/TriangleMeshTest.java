package com.vinstorm.javafx_experiments.dev.vinayak.aaaag;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;

public class TriangleMeshTest extends Application{

	Group root;
	Scene scene;
	Stage window;
	
	TriangleMesh pyramidMesh = new TriangleMesh();
	float h = 150;
	float s = 300;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new Group();
		scene = new Scene(root, 1280, 720, Color.AQUAMARINE);
		window = primaryStage;
		window.setScene(scene);
		window.setTitle("TriangleMeshTest Program");
		window.show();
		
		
		
		pyramidMesh.getTexCoords().addAll(0,0);
		
		float h = 150;                    // Height
		float s = 300;                    // Side
		
		pyramidMesh.getPoints().addAll(
		        0,    0,    0,            // Point 0 - Top
		        0,    h,    -s/2,         // Point 1 - Front
		        -s/2, h,    0,            // Point 2 - Left
		        s/2,  h,    0,            // Point 3 - Back
		        0,    h,    s/2           // Point 4 - Right
	    );
		
		pyramidMesh.getFaces().addAll(
		        0,0,  2,0,  1,0,          // Front left face
		        0,0,  1,0,  3,0,          // Front right face
		        0,0,  3,0,  4,0,          // Back right face
		        0,0,  4,0,  2,0,          // Back left face
		        4,0,  1,0,  2,0,          // Bottom rear face
		        4,0,  3,0,  1,0           // Bottom front face
	    );
		
		final PhongMaterial greenMaterial = new PhongMaterial();
	    greenMaterial.setDiffuseColor(Color.DARKGREEN);
	    greenMaterial.setSpecularColor(Color.GREEN);
		
		MeshView pyramid = new MeshView(pyramidMesh);
		pyramid.setDrawMode(DrawMode.FILL);
		pyramid.setMaterial(greenMaterial);
		pyramid.setTranslateX(200);
		pyramid.setTranslateY(100);
		pyramid.setTranslateZ(200);
		pyramid.setRotationAxis(new Point3D(0.0, 1.0, 0.0));
		pyramid.setRotate(45);
		root.getChildren().add(pyramid);
		
	}
}

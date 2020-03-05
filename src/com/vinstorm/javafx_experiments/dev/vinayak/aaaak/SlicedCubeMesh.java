package com.vinstorm.javafx_experiments.dev.vinayak.aaaak;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class SlicedCubeMesh extends Application {
	
    PerspectiveCamera pCamera;
    Group cast;
    MeshView slicedCube;

    int windowW = 380, windowH = 440;
    int sceneW = windowW - 20, sceneH = windowH - 80;
    
    @Override
    public void start(Stage primaryStage) {
        // Give the stage a title
        primaryStage.setTitle("Using MeshView to create a Obama Cube");

        // Use a floawpane for the root node. In this case,
        // vertical and horizontal gaps of 10 are used
        FlowPane rootNode = new FlowPane(10, 10);

        // Center nodes in the scene
        rootNode.setAlignment(Pos.CENTER);

        // Create the scene
        Scene myScene = new Scene(rootNode, windowW, windowH);

        // Set the scene on the stage
        primaryStage.setScene(myScene);

        // Create the camera
        pCamera = new PerspectiveCamera(true);

        // Set the camera's rotation axis to Y axis
        // pCamera.setRotationAxis(Rotate.Y_AXIS);
        // Add transform to the camera
        pCamera.getTransforms().addAll(new Translate(0, 0, -500));

        // Set the cameras field of view and farclip
        pCamera.setFieldOfView(45);
        pCamera.setFarClip(1000);

        // Create sub scene to manage the group. Notice that a 
        // depth buffer is enabled
        Group groupAll = new Group();
        // Build the cast (shapes) and XYZ axis
        cast = buildCast();
        groupAll.getChildren().add(cast);
        // Create the scene and set its camera
        SubScene shapesSub = new SubScene(groupAll, sceneW, sceneH, true,
                SceneAntialiasing.DISABLED);
        shapesSub.setFill(Color.AZURE);
        shapesSub.setCamera(pCamera);

        rootNode.getChildren().add(shapesSub);

        primaryStage.show();
    }

    public Group buildCast() {
        TriangleMesh mesh = new TriangleMesh();

        // Vertex coordinates
        float h = 100;    // Height (Y)
        float w = 200;    // Width (X)
        float d = 100;    // Depth (Z)

         mesh.getPoints().addAll(
    		 -w / 2,	-h / 2,		-d / 2,		// 0
    		 -w / 2, 	h / 2,		-d / 2,		// 1
    		 w / 2, 	-h / 2,		-d / 2,		// 2
    		 w / 2, 	h / 2,		-d / 2,		// 3
    		 -w / 2, 	h / 2,		d / 2,		// 4
    		 w / 2,		h / 2,		d / 2		// 5
        );
        // Add texture coordinates
        mesh.getTexCoords().addAll(
        		(0 / 5f), 0.0f,		// 0
        		(0 / 5f), 1.0f,		// 1
                (1 / 5f), 0.0f,		// 2
                (1 / 5f), 1.0f,		// 3
                (2 / 5f), 0.0f,		// 4
                (2 / 5f), 1.0f,		// 5
                (3 / 5f), 0.0f,		// 6
                (3 / 5f), 1.0f,		// 7
                (4 / 5f), 0.0f,		// 8
                (4 / 5f), 1.0f,		// 9
                (5 / 5f), 0.0f,		// 10
                (5 / 5f), 1.0f		// 11
        );

        mesh.getFaces().addAll(
        	3, 3, 0, 0, 1, 1,	// Front 1 face
        	3, 3, 2, 2, 0, 0,	// Front 2 face
        	5, 5, 2, 2, 3, 3,	// Right Whole face
        	4, 7, 2, 2, 5, 5,	// Back 1 face
        	4, 7, 0, 6, 2, 2,	// Back 2 face
        	1, 9, 0, 6, 4, 7,	// Left Whole face
        	3, 11, 1, 9, 4, 8,// Bottom 1 face
        	3, 11, 4, 8, 5, 10 // Bottom 2 face
        );

        PhongMaterial material = new PhongMaterial();
        String filepath = SlicedCubeMesh.class.getResource("images/texture.png").toExternalForm();
        material.setDiffuseMap(new Image(filepath));
        //material = new PhongMaterial(Color.YELLOWGREEN);

        slicedCube = new MeshView(mesh);
        slicedCube.setDrawMode(DrawMode.FILL);
        
        slicedCube.setMaterial(material);
        //pyramid.setCullFace(CullFace.BACK);
        slicedCube.setTranslateZ(200);
        slicedCube.setRotationAxis(new Point3D(1.0, 1.0, 1.0));
        slicedCube.setRotate(0);
        
        slicedCube.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				slicedCube.setRotate(slicedCube.getRotate() + 45);
			}
        	
        });

        AmbientLight al = new AmbientLight();
        al.setColor(Color.LIGHTGRAY);

        // Create a group that will hold the box and cylinder        
        Group group = new Group();
        group.getChildren().addAll(slicedCube, al);

        return group;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
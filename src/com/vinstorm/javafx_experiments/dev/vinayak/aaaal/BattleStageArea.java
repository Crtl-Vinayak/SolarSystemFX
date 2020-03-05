package com.vinstorm.javafx_experiments.dev.vinayak.aaaal;

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

public class BattleStageArea extends Application {
	
    PerspectiveCamera pCamera;
    Group cast;
    MeshView cube;

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
        pCamera.getTransforms().addAll(new Translate(0, 0, -600));

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
        float w = 100;    // Width (X)
        float d = 100;    // Depth (Z)

         mesh.getPoints().addAll(
    		 -w / 2,	-h / 2,		-d / 2,		// 0
    		 -w / 2, 	h / 2,		-d / 2,		// 1
    		 w / 2, 	-h / 2,		-d / 2,		// 2
    		 w / 2, 	h / 2,		-d / 2,		// 3
    		 -w / 2, 	-h / 2,		d / 2,		// 4
    		 -w / 2,	h / 2,		d / 2,		// 5
    		 w / 2,		h / 2,		d / 2,		// 6
    		 w / 2,		-h / 2,		d / 2		// 7
        );
        // Add texture coordinates
        mesh.getTexCoords().addAll(
        		(0 / 6f), 0.0f,		// 0
        		(0 / 6f), 1.0f,		// 1
                (1 / 6f), 0.0f,		// 2
                (1 / 6f), 1.0f,		// 3
                (2 / 6f), 0.0f,		// 4
                (2 / 6f), 1.0f,		// 5
                (3 / 6f), 0.0f,		// 6
                (3 / 6f), 1.0f,		// 7
                (4 / 6f), 0.0f,		// 8
                (4 / 6f), 1.0f,		// 9
                (5 / 6f), 0.0f,		// 10
                (5 / 6f), 1.0f,		// 11
                (6 / 6f), 0.0f,		// 12
                (6 / 6f), 1.0f		// 13
        );

        mesh.getFaces().addAll(
        	3, 3, 1, 1, 0, 0,	// Front 1 face		// 0, 0, 1, 1,
        	3, 3, 0, 0, 2, 2,	// Front 2 face		// 2, 2, 0, 0,
        	6, 5, 3, 3, 2, 2,	// Right 1 face		// 2, 2, 3, 3,
        	6, 5, 2, 2, 7, 4,	// Right 2 face		// 7, 4, 2, 2,
        	5, 7, 6, 5, 7, 4,	// Back 1 face		// 7, 4, 6, 5,
        	5, 7, 7, 4, 4, 6,	// Back 2 face		// 4, 6, 7, 4,
        	1, 9, 5, 7, 4, 6,	// Left 1 face		// 4, 6, 5, 7,
        	1, 9, 4, 6, 0, 8,	// Left 2 face		// 0, 8, 4, 6,
        	
        	2, 11, 0, 9, 4, 8,	// Top 1 face		// 4, 8, 0, 9,
        	2, 11, 4, 8, 7, 10,	// Top 2 face		// 7, 10, 4, 8,
        	6, 13, 1, 10, 3, 11,// Bottom 1 face	// 3, 11, 1, 10,
        	6, 13, 5, 12, 1, 10 // Bottom 2 face	// 1, 10, 5, 12
        );

        PhongMaterial material = new PhongMaterial();
        String filepath = BattleStageArea.class.getResource("images/battleStageV2.gif").toExternalForm();
        material.setDiffuseMap(new Image(filepath));
        //material = new PhongMaterial(Color.YELLOWGREEN);

        cube = new MeshView(mesh);
        cube.setDrawMode(DrawMode.FILL);
        
        cube.setMaterial(material);
        //pyramid.setCullFace(CullFace.BACK);
        cube.setRotationAxis(new Point3D(1.0, 1.0, 0.0));
        cube.setRotate(0);
        
        cube.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				cube.setRotate(cube.getRotate() + 45);
			}
        	
        });

        AmbientLight al = new AmbientLight();
        al.setColor(Color.LIGHTGRAY);

        // Create a group that will hold the box and cylinder        
        Group group = new Group();
        group.getChildren().addAll(cube, al);

        return group;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
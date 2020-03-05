/*
 * Copyright (c) 2017 Peter Lager
 * <quark(a)lagers.org.uk> http:www.lagers.org.uk
 * 
 * This software is provided 'as-is', without any express or implied warranty.
 * In no event will the authors be held liable for any damages arising from
 * the use of this software.
 * 
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it freely,
 * subject to the following restrictions:
 * 
 * 1. The origin of this software must not be misrepresented;
 * you must not claim that you wrote the original software.
 * If you use this software in a product, an acknowledgment in the product
 * documentation would be appreciated but is not required.
 * 
 * 2. Altered source versions must be plainly marked as such,
 * and must not be misrepresented as being the original software.
 * 
 * 3. This notice may not be removed or altered from any source distribution.
 */

package com.vinstorm.javafx_experiments.dev.vinayak.aaaai;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Demonstrates how to use MeshView class to create and texture a 3D shape.
 * 
 * @author Peter Lager
 */
public class NiceCubeCore extends Application {
	
    // On stage
    PerspectiveCamera pCamera;
    Group cast;
    // Our pyramid shape
    MeshView pyramid;

    int windowW = 380, windowH = 440;
    int sceneW = windowW - 20, sceneH = windowH - 80;
    
    @Override
    public void start(Stage primaryStage) {
        // Give the stage a title
        primaryStage.setTitle("Using MeshView to create a pyramid");

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
        float h = 210;    // Height (Y)
        float w = 245;    // Width (X)
        float d = 125;    // Depth (Z)

         mesh.getPoints().addAll(
            0,      -h / 2,   0,        // 0
            w / 2,  h / 2,    d / 2,    // 1
            w / 2,  h / 2,    -d / 2,   // 2
            -w / 2, h / 2,    -d / 2,   // 3
            -w / 2, h / 2,    d / 2     // 4
        );
        // Add texture coordinates
        mesh.getTexCoords().addAll(
                0.504f, 0.524f,     // 0
                0.701f, 0,          // 1
                0.126f, 0,          // 2
                0,      0.364f,     // 3
                0,      0.608f,     // 4
                0.165f, 1,          // 5
                0.606f, 1,          // 6
                0.575f, 0.420f,     // 7
                0.575f, 0.643f,     // 8
                0.740f, 0.643f,     // 9
                0.740f, 0.420f      // 10      
        );

        mesh.getFaces().addAll(
                0, 0, 3, 5, 2, 6, // Front face
                0, 0, 2, 2, 1, 3, // Right face
                0, 0, 1, 1, 4, 2, // Back face
                0, 0, 4, 4, 3, 5, // Left right face
                2, 9, 3, 8, 4, 7, // Bottom face
                2, 9, 4, 7, 1, 10 // Bottom face
        );

        PhongMaterial material = new PhongMaterial();
        String filepath = NiceCubeCore.class.getResource("images/buildings1.png").toExternalForm();
        material.setDiffuseMap(new Image(filepath));
        //material = new PhongMaterial(Color.YELLOWGREEN);

        pyramid = new MeshView(mesh);
        pyramid.setDrawMode(DrawMode.FILL);
        
        pyramid.setMaterial(material);
        //pyramid.setCullFace(CullFace.BACK);

        AmbientLight al = new AmbientLight();
        al.setColor(Color.LIGHTGRAY);

        // Create a group that will hold the box and cylinder        
        Group group = new Group();
        group.getChildren().addAll(pyramid, al);

        return group;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

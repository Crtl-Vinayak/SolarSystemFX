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

package com.vinstorm.javafx_experiments.dev.vinayak.aaaah;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Demonstrates how to use MeshView class to create and texture a 3D shape.
 * 
 * @author Peter Lager
 */
public class Pyramid01 extends Application {
    
    // GUI controls
    Button btnX, btnY, btnZ;
    ToggleButton btnHideShape, btnHideAxis;
    RadioButton optCamera, optShape;
    ToggleGroup tgpSwitch;
    CheckBox cbxWireframe;
    // On stage
    PerspectiveCamera pCamera;
    Group cast, xyzAxis;
    // Our pyramid shape
    MeshView pyramid;
    // Actions
    RotateAction rotShapeX, rotShapeY, rotShapeZ;
    RotateAction rotCamX, rotCamY, rotCamZ;

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
        xyzAxis = (buildAxis(1, 200));
        groupAll.getChildren().addAll(cast, xyzAxis);
        // Create the scene and set its camera
        SubScene shapesSub = new SubScene(groupAll, sceneW, sceneH, true,
                SceneAntialiasing.DISABLED);
        shapesSub.setFill(Color.AZURE);
        shapesSub.setCamera(pCamera);
        // Set up rotation axis
        rotShapeX = new RotateAction(Rotate.X_AXIS, cast);
        rotShapeY = new RotateAction(Rotate.Y_AXIS, cast);
        rotShapeZ = new RotateAction(Rotate.Z_AXIS, cast);
        rotCamX = new RotateAction(Rotate.X_AXIS, pCamera);
        rotCamY = new RotateAction(Rotate.Y_AXIS, pCamera);
        rotCamZ = new RotateAction(Rotate.Z_AXIS, pCamera);

        // Create the GUI
        Pane gui = buildGUI(cast);

        rootNode.getChildren().addAll(shapesSub, gui);

        primaryStage.show();
    }

    public Group buildAxis(float rad, float size) {
        Cylinder xAxis = new Cylinder(rad, size);
        xAxis.setMaterial(new PhongMaterial(Color.RED));
        xAxis.setRotationAxis(Rotate.Z_AXIS);
        xAxis.setRotate(90);
        xAxis.setTranslateX(size / 2);

        Cylinder yAxis = new Cylinder(rad, size);
        yAxis.setMaterial(new PhongMaterial(Color.GREEN));
        yAxis.setTranslateY(size / 2);

        Cylinder zAxis = new Cylinder(rad, size);
        zAxis.setMaterial(new PhongMaterial(Color.BLUE));
        zAxis.setRotationAxis(Rotate.X_AXIS);
        zAxis.setRotate(90);
        zAxis.setTranslateZ(-rad + size / 2);

        xyzAxis = new Group();
        xyzAxis.getChildren().addAll(xAxis, yAxis, zAxis);

        return xyzAxis;
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
        String filepath = Pyramid01.class.getResource("images/buildings1.png").toExternalForm();
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

    public Pane buildGUI(Group shapeGroup) {
        FlowPane guiPane = new FlowPane(10, 10);
        guiPane.setAlignment(Pos.CENTER);
        btnX = new Button("<X>");
        btnY = new Button("<Y>");
        btnZ = new Button("<Z>");
        btnHideShape = new ToggleButton("Hide Shape");
        btnHideAxis = new ToggleButton("Hide Axis");
        tgpSwitch = new ToggleGroup();
        optCamera = new RadioButton("Camera");
        optCamera.setToggleGroup(tgpSwitch);
        optShape = new RadioButton("Shape");
        optShape.setToggleGroup(tgpSwitch);
        optShape.setSelected(true);
        cbxWireframe = new CheckBox("Wireframe");
        cbxWireframe.setSelected(false);

        guiPane.getChildren().addAll(btnX, btnY, btnZ,
                btnHideShape, btnHideAxis,
                optCamera, optShape, cbxWireframe);
        
        // Add event handlers
        btnX.setOnAction(rotShapeX);
        btnY.setOnAction(rotShapeY);
        btnZ.setOnAction(rotShapeZ);

        optShape.setOnAction((ActionEvent event) -> {
            btnX.setOnAction(rotShapeX);
            btnY.setOnAction(rotShapeY);
            btnZ.setOnAction(rotShapeZ);
        });
        optCamera.setOnAction((ActionEvent event) -> {
            btnX.setOnAction(rotCamX);
            btnY.setOnAction(rotCamY);
            btnZ.setOnAction(rotCamZ);
        });
        btnHideShape.setOnAction((ActionEvent event) -> {
            cast.setVisible(!btnHideShape.isSelected());
        });

        btnHideAxis.setOnAction((ActionEvent event) -> {
            xyzAxis.setVisible(!btnHideAxis.isSelected());
        });

        cbxWireframe.setOnAction((ActionEvent event) -> {
            if (cbxWireframe.isSelected()) {
                pyramid.setDrawMode(DrawMode.LINE);
            } else {
                pyramid.setDrawMode(DrawMode.FILL);
            }
        });

        return guiPane;
    }

    public class RotateAction implements EventHandler<ActionEvent> {

        RotateTransition trans;

        RotateAction(Point3D a, Node group) {
            trans = new RotateTransition(new Duration(5000), group);
            trans.setAxis(a);
            trans.setCycleCount(2);
            trans.setAutoReverse(true);
            trans.setByAngle(360);
        }

        @Override
        public void handle(ActionEvent event) {
            trans.play();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

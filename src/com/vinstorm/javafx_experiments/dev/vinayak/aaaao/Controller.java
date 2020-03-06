package com.vinstorm.javafx_experiments.dev.vinayak.aaaao;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.ParallelCamera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

/**
 * 
 * @author vinay
 *
 */
public class Controller {
	
	@FXML private AnchorPane anchRoot;
	
	@FXML private Button sunButton;
	@FXML private Button mercuryButton;
	@FXML private Button venusButton;
	@FXML private Button earthButton;
	@FXML private Button marsButton;
	@FXML private Button jupiterButton;
	@FXML private Button saturnButton;
	@FXML private Button uranusButton;
	@FXML private Button neptuneButton;
	@FXML private Button solarSystemButton;
	
	@FXML private Sphere sun;
	@FXML private Sphere mercury;
	@FXML private Sphere venus;
	@FXML private Sphere earth;
	@FXML private Sphere mars;
	@FXML private Sphere jupiter;
	@FXML private Sphere saturn;
	@FXML private Sphere uranus;
	@FXML private Sphere neptune;
	
	@FXML private PerspectiveCamera camera;
	@FXML private ParallelCamera camera2;

	/**
	 * initialize method is called when the program startsup.
	 * more specificly when the fxml file is being loaded.
	 */
	@FXML
	private void initialize() {
		sun();
		mercury();
		venus();
		earth();
		mars();
		jupiter();
		saturn();
		uranus();
		neptune();
		
		movePlanets();
	}
	
	@FXML
	private void sunButtonAction(ActionEvent event) {
		System.out.println("sun");
		camera.setRotationAxis(new Point3D(1, 0, 1));
		camera.setRotate(45);
		camera.setTranslateX(camera.getTranslateX() + 100);
		camera.setTranslateY(camera.getTranslateY() + 100);
		camera.setTranslateZ(camera.getTranslateZ() + 100);
		
		camera2.setRotationAxis(new Point3D(1, 0, 1));
		camera2.setRotate(45);
		camera2.setTranslateX(camera2.getTranslateX() + 100);
		camera2.setTranslateY(camera2.getTranslateY() + 100);
		camera2.setTranslateZ(camera2.getTranslateZ() + 100);
	}
	
	@FXML
	private void mercuryButtonAction(ActionEvent event) {
		System.out.println("mercury");
	}
	
	@FXML
	private void venusButtonAction(ActionEvent event) {
		System.out.println("venus");
	}
	
	@FXML
	private void earthButtonAction(ActionEvent event) {
		System.out.println("earth");
	}
	
	@FXML
	private void marsButtonAction(ActionEvent event) {
		System.out.println("mars");
	}
	
	@FXML
	private void jupiterButtonAction(ActionEvent event) {
		System.out.println("jupiter");
	}
	
	@FXML
	private void saturnButtonAction(ActionEvent event) {
		System.out.println("saturn");
	}
	
	@FXML
	private void uranusButtonAction(ActionEvent event) {
		System.out.println("uranus");
	}
	
	@FXML
	private void neptuneButtonAction(ActionEvent event) {
		System.out.println("neptune");
	}
	
	@FXML
	private void solarSystemButtonAction(ActionEvent event) {
		System.out.println("solarSystem");
	}
	
	protected void sun() {
		PhongMaterial sunMat = new PhongMaterial();
		sunMat.setDiffuseMap(new Image(getClass().getResourceAsStream("res/8k_sun.jpg")));
		sun.setMaterial(sunMat);
	}
	
	protected void mercury() {
		PhongMaterial mercuryMat = new PhongMaterial();
		mercuryMat.setDiffuseMap(new Image(getClass().getResourceAsStream("res/images.png")));
		mercury.setMaterial(mercuryMat);
	}
	
	protected void venus() {
		PhongMaterial venusMat = new PhongMaterial();
		venusMat.setDiffuseMap(new Image(getClass().getResourceAsStream("res/ven0aaa2-copy-428-321.jpg")));
		venus.setMaterial(venusMat);
	}
	
	protected void earth() {
		PhongMaterial earthMat = new PhongMaterial();
		earthMat.setDiffuseMap(new Image(getClass().getResourceAsStream("res/download.png")));
		earth.setMaterial(earthMat);
	}
	
	protected void mars() {
		PhongMaterial marsMat = new PhongMaterial();
		marsMat.setDiffuseMap(new Image(getClass().getResourceAsStream("res/L_K7qY___400x400.jpg")));
		mars.setMaterial(marsMat);
	}
	
	protected void jupiter() {
		PhongMaterial jupiterMat = new PhongMaterial();
		jupiterMat.setDiffuseMap(new Image(getClass().getResourceAsStream("res/PIA07782_hires.jpg")));
		jupiter.setMaterial(jupiterMat);
	}
	
	protected void saturn() {
		PhongMaterial saturnMat = new PhongMaterial();
		saturnMat.setDiffuseMap(new Image(getClass().getResourceAsStream("res/87614c592cfb5e9d369fdde536263e2b.jpg")));
		saturn.setMaterial(saturnMat);
	}
	
	protected void uranus() {
		PhongMaterial uranusMat = new PhongMaterial();
		uranusMat.setDiffuseMap(new Image(getClass().getResourceAsStream("res/dbzj71k-8fe30215-2794-4bca-bcee-0bd1fa3d1850.png")));
		uranus.setMaterial(uranusMat);
	}
	
	protected void neptune() {
		PhongMaterial neptuneMat = new PhongMaterial();
		neptuneMat.setDiffuseMap(new Image(getClass().getResourceAsStream("res/2k_neptune.jpg")));
		neptune.setMaterial(neptuneMat);
	}
	
	protected void movePlanets() {
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(1000 / 60), e -> {
			sun.setRotationAxis(new Point3D(0, 1, 0));
			sun.setRotate(sun.getRotate() + 0.1);
			mercury.setRotationAxis(new Point3D(0, 1, 0));
			mercury.setRotate(mercury.getRotate() + 3.1);
			venus.setRotationAxis(new Point3D(0, 1, 0));
			venus.setRotate(venus.getRotate() + 1.2);
			earth.setRotationAxis(new Point3D(0, 1, 0));
			earth.setRotate(earth.getRotate() + 3.5);
			mars.setRotationAxis(new Point3D(0, 1, 0));
			mars.setRotate(mars.getRotate() + 2.3);
			jupiter.setRotationAxis(new Point3D(0, 1, 0));
			jupiter.setRotate(jupiter.getRotate() + 0.3);
			saturn.setRotationAxis(new Point3D(0, 1, 0));
			saturn.setRotate(saturn.getRotate() + 0.4);
			uranus.setRotationAxis(new Point3D(0, 1, 0));
			uranus.setRotate(uranus.getRotate() + 0.8);
			neptune.setRotationAxis(new Point3D(0, 1, 0));
			neptune.setRotate(neptune.getRotate() + 0.9);
		}));
		tl.setCycleCount(Animation.INDEFINITE);
		tl.play();
	}
}
